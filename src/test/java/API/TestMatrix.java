package src.test.java.API;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.java.API.Matrix;

public class TestMatrix {
    @Test
    public void testToString(){
        int[][] ints = {{1,2,3,4}, {0,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(ints);
        assertEquals("[ 1  2  3  4 ]\n[ 0  1  2  3 ]\n[ 0  0  1  2 ]\n[ 0  0  0  1 ]\n", m.toString());
    }
    @Test
    public void testIsEchelonForm(){
        int[][] ints = {{1,2,3,4}, {0,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(ints);
        assertEquals(true, m.isEchelonForm());
    }
    @Test
    public void testIsNotEchelonForm(){
        int[][] ints = {{1,2,3,4}, {0,1,2,3}, {0,3,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(ints);
        assertEquals(false, m.isEchelonForm());
    }

}
