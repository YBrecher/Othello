package edu.touro.mco364;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OthelloConsoleGameTest {

    OthelloConsoleGame test = new OthelloConsoleGame();

    @Test
    void startGame() { // It is hard to make asserts for the console game methods since it is displaying dynamic output, but we can still test it visually.
        test.startGame();
    }

    @Test
    void displayGrid() {
        test.model.setupBoard();
        test.displayGrid();
    }

    @Test
    void determineWinner() {
        test.model.setupBoard();
        test.model.makeMove(4,3,CellState.B);
        test.determineWinner();
    }
}