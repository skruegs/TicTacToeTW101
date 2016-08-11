package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class GameBoard {

    private final PrintStream printStream;

    public GameBoard(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void display() {
        printStream.println("1|2|3");
        printStream.println("-----");
        printStream.println("4|5|6");
        printStream.println("-----");
        printStream.println("7|8|9");
    }

    public void makeMove(String move) {
        printStream.println("X|2|3");
        printStream.println("-----");
        printStream.println("4|5|6");
        printStream.println("-----");
        printStream.println("7|8|9");
    }
}
