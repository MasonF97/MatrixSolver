package src.main.java.API;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);
        boolean run = true;
        while(run){
            System.out.println("Enter 1 to solve a system of equations, 2 to reduce a matrix, 3 to perform matrix multiplication, or 4 to quit");
            switch(scan.nextLine()){
                case "1": 
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
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
