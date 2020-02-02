package edu.touro.mco364;

import static org.junit.jupiter.api.Assertions.*;


class OthelloModelTest {

    OthelloModel test = new OthelloModel();

    @org.junit.jupiter.api.Test
    void setupBoard()
    {
        test.setupBoard();
        assertEquals(CellState.W, test.grid[3][3]);
        assertEquals(CellState.W, test.grid[4][4]);
        assertEquals(CellState.B, test.grid[3][4]);
        assertEquals(CellState.B, test.grid[4][3]);
        assertEquals(CellState.NONE, test.grid[5][2]);
        assertEquals(CellState.NONE, test.grid[3][7]);
        assertEquals(CellState.NONE, test.grid[6][3]);
        assertEquals(CellState.NONE, test.grid[1][1]);
        assertEquals(CellState.NONE, test.grid[7][4]);

    }

    @org.junit.jupiter.api.Test
    void makeMove()
    {
        test.setupBoard();
        test.makeMove(4,3 ,CellState.B);
        assertEquals(CellState.B, test.grid[3][2]); //We have to subtract 1 in our assert since we subtracted 1 in our makeMove method to match the board
        test.makeMove(3,5,CellState.W);
        assertEquals(CellState.W, test.grid[2][4]);
    }

    @org.junit.jupiter.api.Test
    void isValid()
    {
        test.setupBoard();
        //assertTrue(test.isValid(3,2,CellState.B));
        test.makeMove(4,3,CellState.B);
        assertTrue(test.isValid(2,2,CellState.W));
    }

    @org.junit.jupiter.api.Test
    void isLegalIndex()
    {
        test.setupBoard();
        assertTrue(test.isLegalIndex(6,4));
        assertTrue(test.isLegalIndex(0,0));
        assertTrue(test.isLegalIndex(7,7));
        assertTrue(test.isLegalIndex(5,2));
        assertFalse(test.isLegalIndex(6,13));
        assertFalse(test.isLegalIndex(-1,5));
        assertFalse(test.isLegalIndex(4,8));
    }

    @org.junit.jupiter.api.Test
    void reverseState()
    {
        CellState actual = test.reverseState(CellState.W);
        assertEquals(CellState.B, actual);
        actual = test.reverseState(CellState.B);
        assertEquals(CellState.W, actual);
    }

    @org.junit.jupiter.api.Test
    void flipCells()
    {
        test.setupBoard();
        test.makeMove(4,3,CellState.B);
        assertEquals(CellState.B, test.grid[3][3]);
        test.makeMove(3,5,CellState.W);
        assertEquals(CellState.W, test.grid[3][4]);
    }
}