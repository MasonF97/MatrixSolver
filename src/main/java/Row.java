package src.main.java;

import java.util.ArrayList;

public class Row {
    private ArrayList<Integer> row;
    
    public Row(ArrayList<Integer> row){
        this.row = row;
    }

    public void addRow(Row other, int scalar){
        for(int i = 0;i<row.size();i++){
            row.set(i, row.get(i)+(scalar*other.getAtIndex(i)));
        }
    }


    public void multiplyRow(int scalar){
        for(int i = 0;i<row.size();i++){
            row.set(i, row.get(i)*scalar);
        }
    }

    public int getAtIndex(int i){ return row.get(i);}
    public ArrayList<Integer> getRow(){return this.row;}
}
