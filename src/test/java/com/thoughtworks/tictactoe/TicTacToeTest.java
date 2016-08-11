package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TicTacToeTest {

    private GameBoard gameBoard;
    private PrintStream printStream;
    private BufferedReader reader;
    private TicTacToe ticTacToe;

    @Before
    public void setUp() {
        gameBoard = mock(GameBoard.class);
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        ticTacToe = new TicTacToe(gameBoard, printStream, reader);
    }

    @Test
    public void shouldDisplayBoardWhenGameStarts() {
        ticTacToe.startGame();
        verify(gameBoard, times(3)).display();
    }

    @Test
    public void shouldPromptFirstPlayerToEnterANumberAfterBoardDisplays() {
        ticTacToe.startGame();
        verify(printStream).println("Player X: Enter a number to place your mark.");
    }

    @Test
    public void shouldMakeMoveWithXWhenFirstPlayerEntersOne() throws Exception {
        when(reader.readLine()).thenReturn("1");
        ticTacToe.startGame();
        verify(gameBoard).makeMove("1", "X");
    }

    @Test
    public void shouldPromptSecondPlayerToEnterANumberAfterFirstPlayerMoves() {
        ticTacToe.startGame();
        verify(printStream).println("Player O: Enter a number to place your mark.");
    }

    @Test
    public void shouldMakeMoveWithOWhenSecondPlayerEntersTwo() throws Exception {
        when(reader.readLine()).thenReturn("1", "2");
        ticTacToe.startGame();
        verify(gameBoard).makeMove("2", "O");
    }
}