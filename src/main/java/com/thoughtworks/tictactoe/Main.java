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
        PrintStream printStream = System.out;
        GameBoard gameBoard = initializeGameBoard(printStream);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Player player1 = new Player(printStream, reader,  gameBoard, "1", "X");
        Player player2 = new Player(printStream, reader, gameBoard, "2", "O");
        return new TicTacToe(gameBoard, printStream, player1, player2);
    }

    private static GameBoard initializeGameBoard(PrintStream printStream) {
        List<String> board = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        return new GameBoard(printStream, board);
    }

}
