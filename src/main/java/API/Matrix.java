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

    // public Matrix solveMatrix(){

    // }
    
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


    public int getRowCount(){ return rows.size();}
    public int getColCount(){return rows.get(0).getSize();}
}
