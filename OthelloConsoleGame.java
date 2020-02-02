package edu.touro.mco364;

import java.util.Scanner;

public class OthelloConsoleGame {

    OthelloModel model = new OthelloModel();

    public void displayGrid()
    {
        System.out.println("   1   2   3   4   5   6   7   8"); // to display column numbers
        for (int i = 0; i < 8; i++)
        {
            System.out.print(i + 1 + " "); // to display row numbers
            for (int j = 0; j < 8; j++)
            {
                if (model.grid[i][j] == CellState.NONE) {
                    System.out.print("|_| "); // to make it look more like a board
                } else {
                    System.out.print("|" + model.grid[i][j] + "| ");
                }
            }
            System.out.println();
        }
    }

    public void startGame()
    {
        model.setupBoard();

        Scanner name = new Scanner(System.in);
        System.out.println("Enter Player 1's Name : ");
        String Player1 = name.nextLine();
        System.out.println("Enter Player 2's Name : ");
        String Player2 = name.nextLine();

        for (int i = 0; i < 30; i++) { //in each othello game there are 30 rounds //TODO split into separate turns to avoid passing issue, or make it a while loop and stop when all pieces are placed

            boolean turnComplete = false;
            int pass = 0;

            while (turnComplete != true && pass == 0) { //while loop ensures that round only progresses after a valid move is made or player passes
                displayGrid();
                System.out.println(Player1 + "'s turn: (Black)"); //first player is always black
                Scanner playerInput = new Scanner(System.in);
                System.out.println("In which row do you want to go?");
                int row = playerInput.nextInt();
                System.out.println("In which column do you want to go?");
                int col = playerInput.nextInt();
                if (model.isValid(row-1 , col-1 , CellState.B)) {
                    model.makeMove(row , col , CellState.B);
                    turnComplete = true;
                } else {
                    System.out.println("Invalid move. Type 0 to try again or any other key to pass.");
                    pass = playerInput.nextInt();
                }
            }

            turnComplete = false;
            pass = 0;

            while (turnComplete != true && pass == 0) {
                displayGrid();
                System.out.println(Player2 + "'s turn: (White)"); //second player is always white
                Scanner playerInput = new Scanner(System.in);
                System.out.println("In which row do you want to go?");
                int row = playerInput.nextInt();
                System.out.println("In which column do you want to go?");
                int col = playerInput.nextInt();
                if (model.isValid(row -1, col-1, CellState.W)) {
                    model.makeMove(row , col , CellState.W);
                    turnComplete = true;
                }else {
                    System.out.println("Invalid move. Type 0 to try again or any other key to pass.");
                    pass = playerInput.nextInt();
                }
            }
        }
        displayGrid();
        determineWinner();
    }
    public void determineWinner()
    {
        int counter = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++)
            {
                if (model.grid[i][j] == CellState.W)
                    counter++;
            }
        }
        if (counter > 32){
            System.out.println("White wins!");
        }else if (counter < 32){
            System.out.println("Black wins!");
        } else{
            System.out.println("It's a tie");
        }
    }
}
