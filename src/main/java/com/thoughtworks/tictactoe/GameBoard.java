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

    public boolean hasFullRow() {
        return cellsHaveMatchingSymbol(0, 1, 2) ||
               cellsHaveMatchingSymbol(3, 4, 5) ||
               cellsHaveMatchingSymbol(6, 7, 8);
    }

    public boolean hasFullColumn() {
        return cellsHaveMatchingSymbol(0, 3, 6) ||
               cellsHaveMatchingSymbol(1, 4, 7) ||
               cellsHaveMatchingSymbol(2, 5, 8);
    }

    public boolean hasFullDiagonal() {
        return cellsHaveMatchingSymbol(0, 4, 8) ||
               cellsHaveMatchingSymbol(2, 4, 6);
    }

    private int getIndexFromBoardPosition(int move) {
        return move - 1;
    }

    private boolean cellsHaveMatchingSymbol(int c1, int c2, int c3) {
        return board.get(c1).equals(board.get(c2)) && board.get(c2).equals(board.get(c3));
    }

}
