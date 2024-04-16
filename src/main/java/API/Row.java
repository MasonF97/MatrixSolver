package src.main.java.API;

import java.util.ArrayList;

public class Row {
    private ArrayList<Integer> row;
    
    public Row(ArrayList<Integer> row){
        this.row = row;
    }

    public Row(int[] row){
        this.row = new ArrayList<>();
        for(int i: row){
            this.row.add(i);
        }
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

    public boolean isZeroRow(){
        for(int x : row){
            if(x != 0){
                return false;
            }
        }
        return true;
    }

    public int getPivotPosition(){
        for(int i = 0;i<row.size();i++){
            if(row.get(i) != 0){
                return i;
            }
        }
        return -1;
    }

    public int getPivot(){
        return row.get(this.getPivotPosition());
    }

    public int getAtIndex(int i){ return row.get(i);}
    public ArrayList<Integer> getRow(){return this.row;}
    public int getSize(){return this.row.size();}
    @Override
    public String toString(){
        String s = "[";
        for(int i :this.row){
            s+= " "+i+" ";
        }
        return s + "]";
    }
    @Override 
    public boolean 
}
