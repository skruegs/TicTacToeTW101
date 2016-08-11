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

    @Before
    public void setUp() {
        gameBoard = mock(GameBoard.class);
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        ticTacToe = new TicTacToe(gameBoard, printStream, reader);
    }

    @Test
    public void shouldDisplayBoardWhenGameStarts() {
        when(gameBoard.isFull()).thenReturn(true);
        ticTacToe.startGame();
        verify(gameBoard).display();
    }

    @Test
    public void shouldPromptFirstPlayerToEnterANumberAfterBoardDisplays() throws IOException {
        when(reader.readLine()).thenReturn("1");
        when(gameBoard.isFull()).thenReturn(false, true);
        ticTacToe.startGame();
        verify(printStream).println("Player X: Enter a number to place your mark.");
    }

    @Test
    public void shouldMakeMoveWithXWhenFirstPlayerEntersOne() throws Exception {
        when(reader.readLine()).thenReturn("1");
        when(gameBoard.isFull()).thenReturn(false, true);
        ticTacToe.startGame();
        verify(gameBoard).makeMove(1, "X");
    }

    @Test
    public void shouldPromptSecondPlayerToEnterANumberAfterFirstPlayerMoves() throws IOException {
        when(reader.readLine()).thenReturn("1", "2");
        when(gameBoard.isFull()).thenReturn(false, false, true);
        ticTacToe.startGame();
        verify(printStream).println("Player O: Enter a number to place your mark.");
    }

    @Test
    public void shouldMakeMoveWithOWhenSecondPlayerEntersTwo() throws Exception {
        when(reader.readLine()).thenReturn("1", "2");
        when(gameBoard.isFull()).thenReturn(false, false, true);
        ticTacToe.startGame();
        verify(gameBoard).makeMove(2, "O");
    }

    @Test
    public void shouldMakeMoveWhenLocationIsOpen() throws IOException {
        when(reader.readLine()).thenReturn("1");
        when(gameBoard.isPositionTaken(anyInt())).thenReturn(false);
        when(gameBoard.isFull()).thenReturn(false, true);
        ticTacToe.startGame();
        verify(gameBoard).makeMove(1, "X");
    }

    @Test
    public void shouldAskForAnotherMoveWhenLocationIsTaken() throws IOException {
        when(reader.readLine()).thenReturn("1", "1", "2");
        when(gameBoard.isPositionTaken(anyInt())).thenReturn(false, true, false);
        when(gameBoard.isFull()).thenReturn(false, false, false, true);
        ticTacToe.startGame();
        verify(gameBoard).makeMove(1, "X");
        verify(gameBoard).makeMove(2, "O");
    }

    @Test
    public void shouldLoopUntilBoardIsFull() throws Exception {
        // all the other tests already have to test this... definitely doing something wrong.
        // need to figure out how to separate logic in this class into another one
        // so that I don't have all my tests just running ticTacToe.startGame();
    }
}