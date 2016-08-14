package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class TicTacToe {

    private PrintStream printStream;
    private GameBoard gameBoard;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public TicTacToe(PrintStream printStream, GameBoard gameBoard, Player player1, Player player2) {
        this.printStream = printStream;
        this.gameBoard = gameBoard;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void startGame() {
        while (!gameBoard.isFull()) {
            gameBoard.display();
            currentPlayer.executeMove();
            if (currentPlayer.hasWon()) {
                break;
            } else {
                switchCurrentPlayer();
            }
        }
        displayResult();
    }

    private void switchCurrentPlayer() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private void displayResult() {
        String result;
        if (currentPlayer.hasWon()) {
            result = "Player " + currentPlayer.getPlayerNumber() + " wins!";
        } else {
            result = "Game is a draw.";
        }
        printStream.println(result);
    }

}
