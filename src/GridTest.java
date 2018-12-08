package edu.cmu.cs.cs214.hw3;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GridTest {

    private List<Grid> grids = new ArrayList<>();


    @Before
    public void setUp() {
        //Invalid input including wrong rows, empty file, wrong number format, wrong
        //numbers in row, file not exist
        grids.add(new Grid("src/main/resources/wrong-rows.txt"));
        grids.add(new Grid("src/main/resources/wrong-numbers-inrow.txt"));
        grids.add(new Grid("src/main/resources/invalidNumber.txt"));
        grids.add(new Grid("src/main/resources/empty.txt"));
        grids.add(new Grid("src/main/resources/sudoku-problem-1.txt"));
        grids.add(new Grid("src/main/resources/file-not-exist.txt"));
    }

    @Test
    public void getValid() {
        assertFalse(grids.get(0).getValid());
        assertFalse(grids.get(1).getValid());
        assertFalse(grids.get(2).getValid());
        assertFalse(grids.get(3).getValid());
        assertTrue(grids.get(4).getValid());
        assertFalse(grids.get(5).getValid());
    }

    @Test
    public void getMatrix() {
        int[][] matrixTest = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 9, 1, 0, 7, 6, 0, 3},
                {0, 6, 0, 0, 3, 4, 0, 0, 7},
                {0, 0, 0, 0, 0, 1, 4, 0, 2},
                {0, 3, 4, 8, 0, 6, 5, 7, 0},
                {2, 0, 7, 3, 0, 0, 0, 0, 0},
                {5, 0, 0, 7, 1, 0, 0, 8, 0},
                {7, 0, 1, 5, 0, 9, 3, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                assertEquals(matrixTest[i][j], grids.get(4).getMatrix()[i][j]);
            }
        }
    }

    @Test
    public void getLength() {
        assertEquals(9, grids.get(4).getLength());
    }

    @Test
    public void toStringTest() {
        String string = "0 0 0 0 0 0 0 0 0\n" +
                "0 0 9 1 0 7 6 0 3\n" +
                "0 6 0 0 3 4 0 0 7\n" +
                "0 0 0 0 0 1 4 0 2\n" +
                "0 3 4 8 0 6 5 7 0\n" +
                "2 0 7 3 0 0 0 0 0\n" +
                "5 0 0 7 1 0 0 8 0\n" +
                "7 0 1 5 0 9 3 0 0\n" +
                "0 0 0 0 0 0 0 0 0\n";
        assertEquals(string, grids.get(4).toString());
    }
}