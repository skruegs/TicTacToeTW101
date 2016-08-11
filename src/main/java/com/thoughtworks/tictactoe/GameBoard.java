package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class GameBoard {

    private PrintStream printStream;
    private String[] board;

    public GameBoard(PrintStream printStream) {
        this.printStream = printStream;
        initializeEmptyBoard();
    }

    private void initializeEmptyBoard() {
        board = new String[9];
        for (int i = 0; i <= 8; i++) {
            board[i] = Integer.toString(i + 1);
        }
    }

    public void display() {
        printStream.println(board[0] + "|" + board[1] + "|" + board[2]);
        printStream.println("-----");
        printStream.println(board[3] + "|" + board[4] + "|" + board[5]);
        printStream.println("-----");
        printStream.println(board[6] + "|" + board[7] + "|" + board[8]);
    }

    public void makeMove(String boardPosition, String playerSymbol) {
        int index = Integer.parseInt(boardPosition) - 1;
        board[index] = playerSymbol;
        display();
    }
}
