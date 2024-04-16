package src.test.java.API;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.java.API.Row;

public class TestRow {
    @Test 
    public void testToString(){
        int[] r = {1,2,3,4};
        Row row  = new Row(r);
        assertEquals("[ 1  2  3  4 ]",row.toString());
    }

    @Test 
    public void testIsZeroRow(){
        int[] r = {1,2,3,4};
        Row row  = new Row(r);
        int[] r2 = {0,0,0,0};
        Row row2  = new Row(r2);
        assertEquals(false, row.isZeroRow());
        assertEquals(true, row2.isZeroRow());
    }
    @Test 
    public void testGetPivot(){
        int[] r = {1,2,3,4};
        Row row  = new Row(r);
        int[] r2 = {0,3,0,0};
        Row row2  = new Row(r2);
        assertEquals(1, row.getPivot());
        assertEquals(3, row2.getPivot());
    }
    @Test 
    public void testGetPivotPosition(){
        int[] r = {1,2,3,4};
        Row row  = new Row(r);
        int[] r2 = {0,3,0,0};
        Row row2  = new Row(r2);
        assertEquals(0, row.getPivotPosition());
        assertEquals(1, row2.getPivotPosition());
    }
    @Test 
    public void testAddRow(){
        int[] r = {0,2,3,4};
        Row row  = new Row(r);
        int[] r2 = {0,-4,1,-3};
        Row row2  = new Row(r2);
        int[] r3 = {0,0,7,5};
        Row row3  = new Row(r3);
        assertEquals(row3.toString(), row2.addRow(row, 2).toString());
    }
    @Test 
    public void testMultiplyRow(){
        int[] r = {1,2,3,4};
        Row row  = new Row(r);
        int[] r3 = {3,6,9,12};
        Row row3  = new Row(r3);
        assertEquals(row3.toString(), row.multiplyRow(3).toString());
    }
}
