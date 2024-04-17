package src.main.java.API;

import java.util.ArrayList;

public class Row {
    private ArrayList<Integer> row;
    // private int rhs;
    
    public Row(ArrayList<Integer> row){
        this.row = row;
    }

    public Row(int[] row){
        this.row = new ArrayList<>();
        for(int i: row){
            this.row.add(i);
        }
    }

    public Row addRow(Row other, int scalar){
        for(int i = 0;i<row.size();i++){
            row.set(i, row.get(i)+(scalar*other.getAtIndex(i)));
        }
        // rhs += scalar*other.getRHS();
        return this;
    }


    public Row multiplyRow(int scalar){
        for(int i = 0;i<row.size();i++){
            row.set(i, row.get(i)*scalar);
        }
        // rhs = scalar*rhs;
        return this;
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
    // public int getRHS(){return this.rhs;}
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
    public boolean equals(Object obj){
        if (obj == null) {
            return false;
        }else if (obj.getClass() != this.getClass()) {
            return false;
        }else if(obj.toString() != this.toString()){
            return false;
        }else{
            return true;
        }
        
    }
}
