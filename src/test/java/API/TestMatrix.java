package src.test.java.API;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;


import src.main.java.API.Matrix;

public class TestMatrix {
    @Test
    public void testToString() throws Exception{
        float[][] floats = {{1,2,3,4}, {0,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        assertEquals("[ 1.0  2.0  3.0  4.0 | 0.0 ]\n[ 0.0  1.0  2.0  3.0 | 0.0 ]\n[ 0.0  0.0  1.0  2.0 | 0.0 ]\n[ 0.0  0.0  0.0  1.0 | 0.0 ]\n", m.toString());
    }
    @Test
    public void testIsEchelonForm() throws Exception{
        float[][] floats = {{1,2,3,4}, {0,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        assertEquals(true, m.isEchelonForm());
    }
    @Test
    public void testIsNotEchelonForm() throws Exception{
        float[][] floats = {{1,2,3,4}, {0,1,2,3}, {0,3,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        assertEquals(false, m.isEchelonForm());
    }
    @Test
    public void testIsNotEchelonForm2() throws Exception{
        float[][] floats = {{0,2,3,4}, {0,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        assertEquals(false, m.isEchelonForm());
    }
    @Test
    public void testIsNotEchelonForm3() throws Exception{
        float[][] floats = {{0,2,3,4}, {1,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        assertEquals(false, m.isEchelonForm());
    }
    @Test
    public void testAlreadyReduced() throws Exception{
        float[][] floats = {{1,2,3,4}, {0,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        assertEquals(m.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testFixOrder() throws Exception{
        float[][] floats = {{0,2,3,4}, {1,1,2,3}, {0,0,1,2}, {0,0,0,1}};
        Matrix m = new Matrix(floats);
        float[][] floats2 = {{1,1,2,3}, {0,2,3,4}, {0,0,1,2}, {0,0,0,1}};
        Matrix m2 = new Matrix(floats2);
        assertEquals(m2.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testFixOrder2() throws Exception{
        float[][] floats = {{0,0,3,4}, {0,1,2,3}, {0,0,0,0}, {1,2,3,1}};
        Matrix m = new Matrix(floats);
        float[][] floats2 = {{1,2,3,1}, {0,1,2,3}, {0,0,3,4}, {0,0,0,0}};
        Matrix m2 = new Matrix(floats2);
        assertEquals(m2.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testReduce1() throws Exception{
        float[][] floats = {{0,0,3,4}, {1,2,2,3}, {0,0,0,0}, {2,3,3,1}};
        Matrix m = new Matrix(floats);
        float[][] floats2 = {{1,2,2,3}, {0,-1,-1,-5}, {0,0,3,4}, {0,0,0,0}};
        Matrix m2 = new Matrix(floats2);
        assertEquals(m2.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testReduce2() throws Exception{
        float[][] floats = {{11,8,0}, {57,9,3}, {14,0,8}};
        Matrix m = new Matrix(floats);
        float[][] floats2 = {{11,8,0}, {0,(float)(-10.18),8}, {0,0,(float)-22.5}};
        Matrix m2 = new Matrix(floats2);
        assertEquals(m2.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testReduce1WithRHS() throws Exception{
        float[] fs = {5,2,7,3};
        float[][] floats = {{0,0,3,4}, {1,2,2,3}, {0,0,0,0}, {2,3,3,1}};
        Matrix m = new Matrix(floats, fs);
        float[][] floats2 = {{1,2,2,3}, {0,-1,-1,-5}, {0,0,3,4}, {0,0,0,0}};
        float[] fs2 = {2,-1,5,7};
        Matrix m2 = new Matrix(floats2, fs2);
        assertEquals(m2.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testReduce2WithRHS() throws Exception{
        float[] fs = {9,3,6};
        float[][] floats = {{11,8,0}, {57,9,3}, {14,0,8}};
        Matrix m = new Matrix(floats, fs);
        float[][] floats2 = {{11,8,0}, {0,(float)(-10.18),8}, {0,0,(float)-22.5}};
        float[] fs2 = {9,(float)-5.454545,(float)-26.249998};
        Matrix m2 = new Matrix(floats2, fs2);
        assertEquals(m2.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testNonSquareHoriz() throws Exception{
        float[] fs = {9,3,6};
        float[][] floats = {{1, 2, 3, 4, 5}, {2,3,4,5,6}, {8,4,2,6,7}};
        Matrix m = new Matrix(floats, fs);
        float[] fs2 = {9,-66,(float)-9.5};
        float[][] floats2 = {{1, 2, 3, 4, 5}, {0,-12,-22,-26,-33}, {0,0,(float)-0.17,(float)-0.83,(float)-1.25}};
        Matrix m2 = new Matrix(floats2, fs2);
        assertEquals(m2.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testNonSquareVert() throws Exception{
        float[] fs = {9,3,6, 7, 10};
        float[][] floats = {{1, 2, 3}, {2,3,4}, {9,4,1}, {3,8,6}, {9,6,7}};
        Matrix m = new Matrix(floats, fs);
        float[] fs2 = {9,(float)-71, (float)-9.083333, (float)140.75005,(float)80.500046};
        float[][] floats2 = {{1, 2, 3}, {0,-12,-20}, {0,0,(float)-0.33}, {0,0,0}, {0,0,0}};
        Matrix m2 = new Matrix(floats2, fs2);
        assertEquals(m2.toString(), m.reduceMatrixToEchelon().toString());
    }
    @Test
    public void testRHSException() throws Exception{
        float[] fs = {9,3,6, 7, 10,11};
        float[][] floats = {{1, 2, 3}, {2,3,4}, {3,4,5}, {4,5,6}, {5,6,7}};
        Throwable exception = assertThrows(Exception.class, () -> new Matrix(floats, fs));
        assertEquals("invalid rhs", exception.getMessage());
    }
    @Test
    public void testRowLengthException() throws Exception{
        float[] fs = {9,3,6, 7, 10};
        float[][] floats = {{1, 2, 3}, {2,3,4}, {3,4,5,4}, {4,5,6}, {5,6,7}};
        Throwable exception = assertThrows(Exception.class, () -> new Matrix(floats, fs));
        assertEquals("rows not same size", exception.getMessage());
    }
    


}
