package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.PrintStream;

public class ComputerPlayer extends Player {

    public ComputerPlayer(PrintStream printStream, BufferedReader reader, GameBoard gameBoard, String playerNumber, String symbol) {
        super(printStream, reader, gameBoard, playerNumber, symbol);
    }

    @Override
    public void executeMove() {
        promptPlayer();
        int move = getAnyMove();
        gameBoard.mark(move, symbol);
    }

    private int getAnyMove() {
        for (int i = 1; i <= 9; i++) {
            if (!gameBoard.isPositionTaken(i)) {
                return i;
            }
        }
        return -1;
    }

}
