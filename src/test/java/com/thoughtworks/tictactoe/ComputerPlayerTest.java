package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ComputerPlayerTest {

    private GameBoard gameBoard;
    private PrintStream printStream;
    private BufferedReader reader;
    private ComputerPlayer player;

    @Before
    public void setUp() {
        gameBoard = mock(GameBoard.class);
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        player = new ComputerPlayer(printStream, reader, gameBoard, "1", "X");
    }

    @Test
    public void shouldPlaceMarkInPosition1WhenBoardIsEmpty() {
        player.executeMove();
        verify(gameBoard).mark(1, "X");
    }

    @Test
    public void shouldPlaceMarkInEmptyLocationWhenBoardHasMarksAlready() {

    }

}