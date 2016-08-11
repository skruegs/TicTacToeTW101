package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TicTacToe ticTacToe = initializeTicTacToe();
        ticTacToe.startGame();
    }

    private static TicTacToe initializeTicTacToe() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintStream printStream = System.out;
        GameBoard gameBoard = initializeGameBoard(printStream);
        return new TicTacToe(gameBoard, printStream, reader);
    }

    private static GameBoard initializeGameBoard(PrintStream printStream) {
        List<String> board = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        return new GameBoard(printStream, board);
    }


}
