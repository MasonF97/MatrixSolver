package src.main.java.API;
import java.util.ArrayList;

public class Matrix {
    private ArrayList<Row> rows;
    public Matrix(ArrayList<Row> rows){
        this.rows = rows;
    }
    public Matrix(int[][] arrays){
        ArrayList<Row> rows = new ArrayList<>();
        for(int[] r : arrays){
            rows.add(new Row(r));
        }
        this.rows = rows;
    }

    public Matrix reduceMatrixToEchelon(){
        System.out.println(this.toString());
        if(this.isEchelonForm()){
            return this;
        }else{
            if(this.fixOrder()){
                return reduceMatrixToEchelon();
            }else{
                return null;
            }
        }
    }

    public boolean fixOrder(){         
        for(int x = 0; x<rows.size()-1;x++){
            if(rows.get(x).getPivotPosition() > rows.get(x+1).getPivotPosition()){
                this.swap(x, x+1);
                return true;
            }
        }
        return false;
    }
    
    public void swap(int x, int y){
        Row r1 = this.rows.get(x);
        this.rows.set(x,this.rows.get(y));
        this.rows.set(y, r1);
    }
    public boolean isEchelonForm(){
        int pivotLocation = -1;
        for(Row r : rows){
            if(r.isZeroRow()){
                pivotLocation = this.getColCount();
            }else{
                if(r.getPivotPosition() <= pivotLocation){
                    return false;
                }else{
                    pivotLocation = r.getPivotPosition();
                }
            }
        }
        return true;
    }

    @Override
    public String toString(){
        String s = "";
        for(Row r: rows){
            s+= r.toString()+"\n";
        }
        return s;
    }

    public ArrayList<Row> getRows(){ return rows;}
    public int getRowCount(){ return rows.size();}
    public int getColCount(){return rows.get(0).getSize();}
}
