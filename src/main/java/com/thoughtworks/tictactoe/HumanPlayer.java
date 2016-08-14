package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.PrintStream;

public class HumanPlayer extends Player {

    public HumanPlayer(PrintStream printStream, BufferedReader reader, GameBoard gameBoard, String playerNumber, String symbol) {
        super(printStream, reader, gameBoard, playerNumber, symbol);
    }

    @Override
    public void executeMove() {
        promptPlayer();
        int move = getValidMove();
        gameBoard.mark(move, symbol);
    }

    private int getValidMove() {
        int mark = readNumber();
        while (gameBoard.isPositionTaken(mark)) {
            printStream.println("Location already taken. Try again.");
            mark = readNumber();
        }
        return mark;
    }

}
