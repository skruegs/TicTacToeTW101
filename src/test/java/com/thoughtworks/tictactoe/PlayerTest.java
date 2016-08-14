package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private GameBoard gameBoard;
    private PrintStream printStream;
    private BufferedReader reader;
    private Player player;

    @Before
    public void setUp() {
        gameBoard = mock(GameBoard.class);
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        player = new Player(printStream, reader, gameBoard, "1", "X");
    }

    @Test
    public void shouldPromptPlayerToEnterANumberWhenExecutingMove() throws IOException {
        player.executeMove();
        verify(printStream).println("Player 1: Enter a number to place your mark.");
    }

    @Test
    public void shouldMakeMarkWithXWhenPlayerEntersOne() throws Exception {
        when(reader.readLine()).thenReturn("1");
        player.executeMove();
        verify(gameBoard).mark(1, "X");
    }

    @Test
    public void shouldMakeMoveWhenLocationIsOpen() throws IOException {
        when(reader.readLine()).thenReturn("1");
        when(gameBoard.isPositionTaken(anyInt())).thenReturn(false);
        player.executeMove();
        verify(gameBoard).mark(1, "X");
    }

    @Test
    public void shouldAskForAnotherMoveWhenLocationIsTaken() throws IOException {
        when(reader.readLine()).thenReturn("1", "2");
        when(gameBoard.isPositionTaken(anyInt())).thenReturn(true, false);
        player.executeMove();
        verify(gameBoard).mark(2, "X");
    }

    @Test
    public void shouldReturnTrueWhenPlayerHasWon() {
        when(gameBoard.hasFullRow()).thenReturn(true);
        assertTrue(player.hasWon());
    }

    @Test
    public void shouldReturnFalseWhenPlayerHasNotWon() {
        when(gameBoard.hasFullRow()).thenReturn(false);
        assertFalse(player.hasWon());
    }
}