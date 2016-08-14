package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class TicTacToe {

    private GameBoard gameBoard;
    private PrintStream printStream;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;

    public TicTacToe(GameBoard gameBoard, PrintStream printStream, Player player1, Player player2) {
        this.gameBoard = gameBoard;
        this.printStream = printStream;
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
    }

    public void startGame() {
        gameBoard.display();

        while(!gameBoard.isFull()) {
            currentPlayer.executeMove();
            gameBoard.display();
            switchCurrentPlayer();
        }

        printStream.print("Game is a draw.");
    }

    private void switchCurrentPlayer() {
        if (currentPlayer.equals(player1)) {
            currentPlayer = player2;
        }
        else {
            currentPlayer = player1;
        }
    }


}
