package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameBoardTest {

    private GameBoard gameBoard;
    private PrintStream printStream;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        gameBoard = new GameBoard(printStream);
    }

    @Test
    public void shouldDisplayEmptyBoardWhenNoMovesPlayed() throws Exception {
        gameBoard.display();
        verify(printStream).println("1|2|3");
        verify(printStream).println("4|5|6");
        verify(printStream).println("7|8|9");
    }

    @Test
    public void shouldDisplayBoardWithXInOneSpotWhenMoveIsOne() throws Exception {
        gameBoard.makeMove("1");
        verify(printStream).println("X|2|3");
        verify(printStream).println("4|5|6");
        verify(printStream).println("7|8|9");
    }
}