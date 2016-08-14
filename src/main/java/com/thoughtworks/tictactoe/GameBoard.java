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
        String formatted = String.format(
                "%s|%s|%s" +
                "\n-----\n" +
                "%s|%s|%s" +
                "\n-----\n" +
                "%s|%s|%s",
                board.toArray()
        );
        printStream.println(formatted);
    }

    public void mark(int boardPosition, String playerSymbol) {
        board.set(getIndexFromBoardPosition(boardPosition), playerSymbol);
    }

    public boolean isPositionTaken(int boardPosition) {
        int index = getIndexFromBoardPosition(boardPosition);
        if (board.get(index).equals("X") || board.get(index).equals("O")) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (String value : board) {
            if (!(value.equals("X") || value.equals("O"))) {
                return false;
            }
        }
        return true;
    }

    private int getIndexFromBoardPosition(int move) {
        return move - 1;
    }
}
