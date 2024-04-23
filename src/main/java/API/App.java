package src.main.java.API;
public class App {
    public static void main(String[] args){
        float[][] floats = {{1,2,3,4}, {0,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix matrix = new Matrix(floats);
        System.out.println(matrix.reduceMatrixToEchelon());
    }
}
