package src.main.java.API;

import java.util.Scanner;

public class App {
    private static Scanner scan = new Scanner(System.in);
    public Matrix inputMatrix() throws Exception{
        
        int rows = 0;
        int cols = 0;
        while(true){
            try{
                System.out.println("Enter the number of rows");
                rows = Integer.parseInt(scan.nextLine());
                System.out.println("Enter the number of columns");
                cols = Integer.parseInt(scan.nextLine());
                break;
            } catch(Exception e){
                System.out.println("Invalid input");
            }
        }
        float[][] floats = new float[rows][cols];
        float[] rhs = new float[rows];
        for(int i = 0; i < rows; i++){
            System.out.println("Enter the values for row " + (i+1)+ " separated by spaces");
            String[] values = scan.nextLine().split(" ");
            for(int j = 0; j < cols; j++){
                floats[i][j] = Float.parseFloat(values[j]);
            }
            System.out.println("Enter the value for the right hand side of the matrix");
            rhs[i] = Float.parseFloat(scan.nextLine());
        }
        Matrix m = new Matrix(floats, rhs);
        // scan.close();
        return m;
        
    }
    
    public void reduceMatrix() throws Exception{
        Matrix m = inputMatrix();
        
        System.out.println("Do you want to see the steps? (y/n)");
        String out  = scan.nextLine();
        if(out.equals("n")){
            m.setSteps(false);
        }
        System.out.println("Do you want to reduce the matrix to echelon form or reduced row echelon form? (e/r)");
        if(scan.nextLine().equals("e")){
            m.reduceMatrixToEchelon();
            System.out.println("Reduced matrix:");
            System.out.println(m.toString());
        }else{
            m.toRREF();
            System.out.println("Reduced matrix:");
            System.out.println(m.toString());
        }
        // scan.close();

    }
    public static void main(String[] args) throws Exception{
        App app = new App();
        boolean run = true;
        while(run){
            System.out.println("Enter 1 to solve a system of equations, 2 to reduce a matrix, or 3 to quit");
            switch(scan.nextLine()){
                case "1": 
                    break;
                case "2":
                    app.reduceMatrix();
                    break;
                case "3":
                    run = false;
                    break;
                default: 
                    System.out.println("Invalid input");
                    continue;
            }
        }
        scan.close();
    }

}
