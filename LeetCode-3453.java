class Solution {
    public double separateSquares(int[][] squares) {
        double low = Double.MAX_VALUE;
        double high = Double.MIN_VALUE;
        double total = 0.0;

        for (int[] s : squares) {
            low = Math.min(low, s[1]);
            high = Math.max(high, s[1] + s[2]);
            total += (double) s[2] * s[2];
        }

        double target = total / 2.0;
        double eps = 1e-6;

        while (high - low > eps) {
            double mid = (low + high) / 2.0;
            if (area(squares, mid) < target) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private double area(int[][] squares, double y) {
        double res = 0.0;
        for (int[] s : squares) {
            double b = s[1];
            double side = s[2];
            if (y <= b) continue;
            if (y >= b + side) res += side * side;
            else res += side * (y - b);
        }
        return res;
    }
}
