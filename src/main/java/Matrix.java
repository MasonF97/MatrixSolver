package src.main.java;
import java.util.ArrayList;

public class Matrix {
    private ArrayList<Row> rows;
    public Matrix(ArrayList<Row> rows){
        this.rows = rows;
    }

    // public Matrix solveMatrix(){

    // }

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
