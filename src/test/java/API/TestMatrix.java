package src.test.java.API;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.java.API.Matrix;

public class TestMatrix {
    @Test
    public void testToString(){
        float[][] floats = {{1,2,3,4}, {0,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        assertEquals("[ 1.0  2.0  3.0  4.0 ]\n[ 0.0  1.0  2.0  3.0 ]\n[ 0.0  0.0  1.0  2.0 ]\n[ 0.0  0.0  0.0  1.0 ]\n", m.toString());
    }
    @Test
    public void testIsEchelonForm(){
        float[][] floats = {{1,2,3,4}, {0,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        assertEquals(true, m.isEchelonForm());
    }
    @Test
    public void testIsNotEchelonForm(){
        float[][] floats = {{1,2,3,4}, {0,1,2,3}, {0,3,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        assertEquals(false, m.isEchelonForm());
    }
    @Test
    public void testIsNotEchelonForm2(){
        float[][] floats = {{0,2,3,4}, {0,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        assertEquals(false, m.isEchelonForm());
    }
    @Test
    public void testIsNotEchelonForm3(){
        float[][] floats = {{0,2,3,4}, {1,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        assertEquals(false, m.isEchelonForm());
    }
    @Test
    public void testAlreadyReduced(){
        float[][] floats = {{1,2,3,4}, {0,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        assertEquals(m.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testFixOrder(){
        float[][] floats = {{0,2,3,4}, {1,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        float[][] floats2 = {{1,1,2,3}, {0,2,3,4}, {0,0,1,2}, {0,0,0,1}};
        Matrix m2 = new Matrix(floats2);
        assertEquals(m2.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testFixOrder2(){
        float[][] floats = {{0,0,3,4}, {0,1,2,3}, {0,0,0,0}, {1,2,3,1}};
        Matrix m = new Matrix(floats);
        float[][] floats2 = {{1,2,3,1}, {0,1,2,3}, {0,0,3,4}, {0,0,0,0}};
        Matrix m2 = new Matrix(floats2);
        assertEquals(m2.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testReduce1(){
        float[][] floats = {{0,0,3,4}, {1,2,2,3}, {0,0,0,0}, {2,3,3,1}};
        Matrix m = new Matrix(floats);
        float[][] floats2 = {{1,2,2,3}, {0,-1,-1,-5}, {0,0,3,4}, {0,0,0,0}};
        Matrix m2 = new Matrix(floats2);
        assertEquals(m2.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testReduce2(){
        float[][] floats = {{11,8,0}, {57,9,3}, {14,0,8}};
        Matrix m = new Matrix(floats);
        float[][] floats2 = {{11,8,0}, {0,(float)(-10.18),8}, {0,0,(float)-22.5}};
        Matrix m2 = new Matrix(floats2);
        assertEquals(m2.toString(), m.reduceMatrixToEchelon().toString());
    }

}
