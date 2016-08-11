package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        TicTacToe ticTacToe = initializeTicTacToe();
        ticTacToe.startGame();
    }

    private static TicTacToe initializeTicTacToe() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream printStream = System.out;
        GameBoard gameBoard = new GameBoard(printStream);
        return new TicTacToe(gameBoard, printStream, reader);
    }


}
