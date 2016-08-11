package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToe {

    private GameBoard gameBoard;
    private PrintStream printStream;
    private BufferedReader reader;

    public TicTacToe(GameBoard gameBoard, PrintStream printStream, BufferedReader reader) {
        this.gameBoard = gameBoard;
        this.printStream = printStream;
        this.reader = reader;
    }

    public void startGame() {
        gameBoard.display();
        executePlayerMove();
    }

    private void executePlayerMove() {
        promptPlayer();
        String move = readLine();
        gameBoard.makeMove(move, "X");
    }

    private void promptPlayer() {
        printStream.println("Enter a number to place your mark:");
    }

    private String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            printStream.println("I/O Error. Could not read input.");
        }
        return null;
    }


}
