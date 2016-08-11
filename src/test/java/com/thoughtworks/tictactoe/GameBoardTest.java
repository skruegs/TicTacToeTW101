package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameBoardTest {

    private GameBoard gameBoard;
    private PrintStream printStream;
    private List<String> board;

    @Before
    public void setUp() {
        printStream = mock(PrintStream.class);
        board = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        gameBoard = new GameBoard(printStream, board);
    }

    @Test
    public void shouldDisplayEmptyBoardWhenNoMovesPlayed() throws Exception {
        gameBoard.display();
        verify(printStream).println("1|2|3\n" +
                                    "-----\n" +
                                    "4|5|6\n" +
                                    "-----\n" +
                                    "7|8|9");
    }

    @Test
    public void shouldDisplayBoardWithXInOneSpotWhenFirstMoveIsOne() throws Exception {
        gameBoard.makeMove("1", "X");
        verify(printStream).println("X|2|3\n" +
                                    "-----\n" +
                                    "4|5|6\n" +
                                    "-----\n" +
                                    "7|8|9");
    }

    @Test
    public void shouldDisplayBoardWithXInTwoSpotWhenFirstMoveIsTwo() throws Exception {
        gameBoard.makeMove("2", "X");
        verify(printStream).println("1|X|3\n" +
                                    "-----\n" +
                                    "4|5|6\n" +
                                    "-----\n" +
                                    "7|8|9");
        //assertThat(board.get(4), is("X"));
    }


}