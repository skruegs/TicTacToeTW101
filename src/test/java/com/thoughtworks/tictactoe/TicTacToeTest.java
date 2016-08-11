package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
        verify(gameBoard).display();
    }

    @Test
    public void shouldPromptPlayerToEnterANumberAfterBoardDisplays() {
        ticTacToe.startGame();
        verify(printStream).println("Enter a number to place your mark:");
    }

    @Test
    public void shouldMakeMoveWithXWhenFirstPlayerEntersOne() throws Exception {
        when(reader.readLine()).thenReturn("1");
        ticTacToe.startGame();
        verify(gameBoard).makeMove("1", "X");
    }

}