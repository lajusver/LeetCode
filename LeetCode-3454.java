import java.util.*;

class Solution {
    static class SegTree {
        int[] cover;
        double[] len;
        double[] xs;

        SegTree(double[] xs) {
            this.xs = xs;
            int n = xs.length;
            cover = new int[n * 4];
            len = new double[n * 4];
        }

        void update(int idx, int l, int r, int ql, int qr, int v) {
            if (ql > r || qr < l) return;
            if (ql <= l && r <= qr) {
                cover[idx] += v;
            } else {
                int m = (l + r) >> 1;
                update(idx << 1, l, m, ql, qr, v);
                update(idx << 1 | 1, m + 1, r, ql, qr, v);
            }
            if (cover[idx] > 0) {
                len[idx] = xs[r + 1] - xs[l];
            } else if (l == r) {
                len[idx] = 0;
            } else {
                len[idx] = len[idx << 1] + len[idx << 1 | 1];
            }
        }

        double query() {
            return len[1];
        }
    }

    public double separateSquares(int[][] squares) {
        int n = squares.length;

        double[] xs = new double[n * 2];
        for (int i = 0; i < n; i++) {
            xs[2 * i] = squares[i][0];
            xs[2 * i + 1] = squares[i][0] + squares[i][2];
        }
        Arrays.sort(xs);
        xs = Arrays.stream(xs).distinct().toArray();

        double[][] events = new double[n * 2][4];
        int idx = 0;
        for (int[] s : squares) {
            double x1 = s[0], x2 = s[0] + s[2];
            double y1 = s[1], y2 = s[1] + s[2];
            events[idx++] = new double[]{y1, 1, x1, x2};
            events[idx++] = new double[]{y2, -1, x1, x2};
        }
        Arrays.sort(events, Comparator.comparingDouble(a -> a[0]));

        SegTree seg = new SegTree(xs);
        double total = 0;
        double prevY = events[0][0];

        for (double[] e : events) {
            double y = e[0];
            total += seg.query() * (y - prevY);
            int l = Arrays.binarySearch(xs, e[2]);
            int r = Arrays.binarySearch(xs, e[3]) - 1;
            if (l <= r) seg.update(1, 0, xs.length - 2, l, r, (int) e[1]);
            prevY = y;
        }

        double half = total / 2.0;

        seg = new SegTree(xs);
        double area = 0;
        prevY = events[0][0];

        for (double[] e : events) {
            double y = e[0];
            double width = seg.query();
            double delta = width * (y - prevY);

            if (width > 0 && area + delta >= half) {
                return prevY + (half - area) / width;
            }

            area += delta;
            int l = Arrays.binarySearch(xs, e[2]);
            int r = Arrays.binarySearch(xs, e[3]) - 1;
            if (l <= r) seg.update(1, 0, xs.length - 2, l, r, (int) e[1]);
            prevY = y;
        }

        return prevY;
    }
}
