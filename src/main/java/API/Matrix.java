package src.main.java.API;
import java.util.ArrayList;

public class Matrix {
    private ArrayList<Row> rows;
    private boolean steps = true;

    public void setSteps(boolean steps){
        this.steps = steps;
    }
    public Matrix(ArrayList<Row> rows){
        this.rows = rows;
    }
    public Matrix(float[][] arrays, float[] rhsVector) throws Exception{
        if(rhsVector.length != arrays.length){
            throw new Exception("invalid rhs");
        }
        ArrayList<Row> rows = new ArrayList<>();
        int i = 0;
        int len = arrays[0].length;
        for(float[] r : arrays){
            if(r.length != len){
                throw new Exception("rows not same size");
            }
            rows.add(new Row(r, rhsVector[i]));
            i++;
        }
        this.rows = rows;
    }

    public Matrix(float[][] arrays) throws Exception{
        this(arrays, new float[arrays[0].length]);
    }

    public Matrix reduceMatrixToEchelon(){
        if(this.isEchelonForm()){
            return this;
        }else{
            if(this.fixOrder()){
                return reduceMatrixToEchelon();
            }else{
                int rn = findWrongRow();
                rows.get(rn).addRow(rows.get(rn-1), findScalar(rows.get(rn-1),rows.get(rn)));
                if(steps){
                    System.out.println(this.toString());
                }
                return reduceMatrixToEchelon();
            }
        }
    }

    public Matrix toRREF(){
        if(!isEchelonForm()){
            this.reduceMatrixToEchelon();
        }
        for(Row row: rows){
            if(row.getPivot() != 1 && row.getPivot() != 0){
                row.multiplyRow(1/row.getPivot());
                if(steps){
                    System.out.println(this.toString());
                }
            }
        }
        for(Row row: rows){
            while(row.findRREFInt() != -1){
                row.addRow(rows.get(row.findRREFInt()), -row.getRow().get(row.findRREFInt()));
                if(steps){
                    System.out.println(this.toString());
                }
            }
            
        }
        return this;
    }

    public float findScalar(Row rUp, Row rDown){
        float rUpNum = rUp.getAtIndex(rDown.getPivotPosition());
        float rDownNum = rDown.getPivot();
        return -rDownNum/rUpNum;
    }

    public int findWrongRow(){
        for(int i = 0;i<rows.size();i++){
            if(rows.get(i).getPivotPosition() == rows.get(i+1).getPivotPosition()){
                return i+1;
            }
        }
        return -1;
    }   

    public boolean fixOrder(){         
        for(int x = 0; x<rows.size()-1;x++){
            if(rows.get(x).getPivotPosition() > rows.get(x+1).getPivotPosition()){
                this.swap(x, x+1);
                if(steps){
                    System.out.println(this.toString());
                }
                return true;
            }
        }
        return false;
    }
    
    public void swap(int x, int y){
        Row r1 = this.rows.get(x);
        this.rows.set(x,this.rows.get(y));
        this.rows.set(y, r1);
        System.out.println("Swap: R"+x+" R"+y);
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
    public ArrayList<Float> getRHSVector(){
        ArrayList<Float> vec = new ArrayList<>();
        for(Row row: rows){
            vec.add(row.getRHS());
        }
        return vec;
    }
}
