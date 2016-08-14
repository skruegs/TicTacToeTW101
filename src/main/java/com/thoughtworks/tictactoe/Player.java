package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public abstract class Player {

    protected PrintStream printStream;
    protected BufferedReader reader;
    protected GameBoard gameBoard;
    protected String playerNumber;
    protected String symbol;

    public Player(PrintStream printStream, BufferedReader reader, GameBoard gameBoard, String playerNumber, String symbol) {
        this.printStream = printStream;
        this.reader = reader;
        this.gameBoard = gameBoard;
        this.playerNumber = playerNumber;
        this.symbol = symbol;
    }

    public boolean hasWon() {
        return gameBoard.hasFullRow() ||
               gameBoard.hasFullColumn() ||
               gameBoard.hasFullDiagonal();
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    protected void promptPlayer() {
        printStream.println("Player " + playerNumber + ": Enter a number to place your mark.");
    }

    protected int readNumber() {
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            printStream.println("I/O Error. Could not read input.");
        } catch (NumberFormatException e) {
            printStream.println("Input was not an integer.");
        }
        return -1;
    }

    abstract void executeMove();

}
