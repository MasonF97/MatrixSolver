package src.main.java.API;
public class App {
    public static void main(String[] args){
        float[][] floats = {{1,2,3,4}, {0,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        float[] rhs = {1,2,3,4};
        Matrix matrix = new Matrix(floats, rhs );
        System.out.println(matrix.reduceMatrixToEchelon());
    }
}
