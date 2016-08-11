package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.List;

public class GameBoard {

    private PrintStream printStream;
    private List<String> board;

    public GameBoard(PrintStream printStream, List<String> board) {
        this.printStream = printStream;
        this.board = board;
    }

    public void display() {
        printStream.println(String.format("%s|%s|%s" +
                                          "\n-----\n" +
                                          "%s|%s|%s" +
                                          "\n-----\n" +
                                          "%s|%s|%s", board.toArray()));
    }

    public void makeMove(String boardPosition, String playerSymbol) {
        int index = Integer.parseInt(boardPosition) - 1;
        board.set(index, playerSymbol);
    }
}
