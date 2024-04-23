package src.main.java.API;

import java.util.ArrayList;

public class Row {
    private ArrayList<Float> row;
    private float rhs;
    // private float rhs;
    
    public Row(ArrayList<Float> row){
        this(row, 0);
    }
    public Row(ArrayList<Float> row, float rhs){
        this.row = row;
    }

    public Row(float[] row, float rhs){
        this.row = new ArrayList<>();
        for(float i: row){
            this.row.add(i);
        }
        this.rhs = rhs;
    }
    public Row(float[] row){
        this(row, 0);
    }

    public Row addRow(Row other, float scalar){
        for(int i = 0;i<row.size();i++){
            row.set(i, row.get(i)+(scalar*other.getAtIndex(i)));
        }
        rhs += scalar*other.getRHS();
        return this;
    }


    public Row multiplyRow(float scalar){
        for(int i = 0;i<row.size();i++){
            row.set(i, row.get(i)*scalar);
        }
        rhs = scalar*rhs;
        return this;
    }

    public boolean isZeroRow(){
        for(float x : row){
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
        return row.size();
    }

    public float getPivot(){
        return row.get(this.getPivotPosition());
    }
    // public float getRHS(){return this.rhs;}
    public float getAtIndex(int i){ return row.get(i);}
    public ArrayList<Float> getRow(){return this.row;}
    public int getSize(){return this.row.size();}
    public float getRHS(){return rhs;}
    public boolean isRHSZero(){return rhs == 0;}
    @Override
    public String toString(){
        String s = "[";
        for(float i :this.row){
            s+= " "+Math.round(i * Math.pow(10, 2)) / Math.pow(10, 2)+" ";
        }
        return s +"| "+rhs +" ]";
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
