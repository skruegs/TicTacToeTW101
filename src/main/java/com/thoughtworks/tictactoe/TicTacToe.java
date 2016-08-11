package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToe {

    private GameBoard gameBoard;
    private PrintStream printStream;
    private BufferedReader reader;
    private String currentPlayer;

    public TicTacToe(GameBoard gameBoard, PrintStream printStream, BufferedReader reader) {
        this.gameBoard = gameBoard;
        this.printStream = printStream;
        this.reader = reader;
        this.currentPlayer = "X";
    }

    public void startGame() {
        gameBoard.display();

        executePlayerMove();
        switchCurrentPlayer();
        executePlayerMove();
    }

    private void executePlayerMove() {
        promptPlayer();
        int move = readNumber();
        while (gameBoard.isPositionTaken(move)) {
            printStream.println("Location already taken.");
            promptPlayer();
            move = readNumber();
        }
        gameBoard.makeMove(move, currentPlayer);
        gameBoard.display();
    }

    private void promptPlayer() {
        printStream.println("Player " + currentPlayer + ": Enter a number to place your mark.");
    }

    private int readNumber() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            printStream.println("I/O Error. Could not read input.");
        } catch (NumberFormatException e) {
            printStream.println("Input was not an integer.");
        }
        return -1;
    }

    private void switchCurrentPlayer() {
        if (currentPlayer.equals("X")) {
            currentPlayer = "O";
        }
        else {
            currentPlayer = "X";
        }
    }


}
