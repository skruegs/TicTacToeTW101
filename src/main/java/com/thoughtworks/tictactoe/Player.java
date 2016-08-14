package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Player {

    private PrintStream printStream;
    private BufferedReader reader;
    private GameBoard gameBoard;
    public final String playerNumber;
    public final String symbol;

    public Player(PrintStream printStream, BufferedReader reader, GameBoard gameBoard, String playerNumber, String symbol) {
        this.printStream = printStream;
        this.reader = reader;
        this.gameBoard = gameBoard;
        this.playerNumber = playerNumber;
        this.symbol = symbol;
    }

    public void executeMove() {
        promptPlayer();
        int mark = getValidMove();
        gameBoard.mark(mark, symbol);
    }

    public boolean hasWon() {
        return gameBoard.hasFullRow() ||
               gameBoard.hasFullColumn() ||
               gameBoard.hasFullDiagonal();
    }

    private void promptPlayer() {
        printStream.println("Player " + playerNumber + ": Enter a number to place your mark.");
    }

    private int getValidMove() {
        int mark = readNumber();
        while (gameBoard.isPositionTaken(mark)) {
            printStream.println("Location already taken. Try again.");
            mark = readNumber();
        }
        return mark;
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

}
