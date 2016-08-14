package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TicTacToeTest {

    private GameBoard gameBoard;
    private PrintStream printStream;
    private BufferedReader reader;
    private TicTacToe ticTacToe;
    private Player player1;
    private Player player2;

    @Before
    public void setUp() {
        gameBoard = mock(GameBoard.class);
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        player1 = mock(Player.class);
        player2 = mock(Player.class);
        ticTacToe = new TicTacToe(gameBoard, printStream, player1, player2);
    }

    @Test
    public void shouldDisplayBoardWhenGameStarts() {
        when(gameBoard.isFull()).thenReturn(true);
        ticTacToe.startGame();
        verify(gameBoard).display();
    }

    @Test
    public void shouldDisplayBoardTwiceWhenGameStartsAndPlayerOneMakesMove() {
        when(gameBoard.isFull()).thenReturn(false, true);
        ticTacToe.startGame();
        verify(gameBoard, times(2)).display();
    }

    @Test
    public void shouldHaveSecondPlayerMoveAfterFirstPlayerMoves() throws IOException {
        when(gameBoard.isFull()).thenReturn(false, false, true);
        ticTacToe.startGame();
        verify(player2).executeMove();
    }

}