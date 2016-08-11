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

    public void makeMove(int boardPosition, String playerSymbol) {
        board.set(getIndexFromBoardPosition(boardPosition), playerSymbol);
    }

    public boolean isPositionTaken(int boardPosition) {
        int index = getIndexFromBoardPosition(boardPosition);
        if (board.get(index).equals("X") || board.get(index).equals("O")) {
            return true;
        }
        return false;
    }

    private int getIndexFromBoardPosition(int move) {
        return move - 1;
    }
}
