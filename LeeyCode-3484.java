class Spreadsheet {
    private int arr[][];
    public Spreadsheet(int rows) {
        arr=new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        char colchar=cell.charAt(0);
        int col=colchar- 'A';

        int row=Integer.parseInt(cell.substring(1))-1;
        arr[row][col]=value;
    }
    
    public void resetCell(String cell) {
        setCell(cell,0);
    }

    public int getCell(String cell){
        char colchar=cell.charAt(0);
        int col=colchar- 'A';

        int row=Integer.parseInt(cell.substring(1))-1;
        return arr[row][col];
    }
    
    public int getValue(String formula) {
        String form=formula.substring(1);
        String[] st=form.split("\\+");

        int sum=0;
        for(String sst:st){
            if(sst.matches("\\d+")){
                sum+=Integer.parseInt(sst);
            }
            else{
                sum+=getCell(sst);
            }
        }
        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */