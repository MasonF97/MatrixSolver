package src.test.java.API;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.java.API.Row;

public class TestRow {
    @Test 
    public void testToString(){
        float[] r = {1,2,3,4};
        Row row  = new Row(r);
        assertEquals("[ 1.0  2.0  3.0  4.0 ]",row.toString());
    }

    @Test 
    public void testIsZeroRow(){
        float[] r = {1,2,3,4};
        Row row  = new Row(r);
        float[] r2 = {0,0,0,0};
        Row row2  = new Row(r2);
        assertEquals(false, row.isZeroRow());
        assertEquals(true, row2.isZeroRow());
    }
    @Test 
    public void testGetPivot(){
        float[] r = {1,2,3,4};
        Row row  = new Row(r);
        float[] r2 = {0,3,0,0};
        Row row2  = new Row(r2);
        assertEquals(1, row.getPivot(), 0.001); 
        assertEquals(3, row2.getPivot(), 0.001);
    }
    @Test 
    public void testGetPivotPosition(){
        float[] r = {1,2,3,4};
        Row row  = new Row(r);
        float[] r2 = {0,3,0,0};
        Row row2  = new Row(r2);
        assertEquals(0, row.getPivotPosition());
        assertEquals(1, row2.getPivotPosition());
    }
    @Test 
    public void testAddRow(){
        float[] r = {0,2,3,4};
        Row row  = new Row(r);
        float[] r2 = {0,-4,1,-3};
        Row row2  = new Row(r2);
        float[] r3 = {0,0,7,5};
        Row row3  = new Row(r3);
        assertEquals(row3.toString(), row2.addRow(row, 2).toString());
    }
    @Test 
    public void testMultiplyRow(){
        float[] r = {1,2,3,4};
        Row row  = new Row(r);
        float[] r3 = {3,6,9,12};
        Row row3  = new Row(r3);
        assertEquals(row3.toString(), row.multiplyRow(3).toString());
    }
}
