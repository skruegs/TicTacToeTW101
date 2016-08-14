package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
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
    public void shouldHaveXInSpotOneWhenFirstMoveIsOne() throws Exception {
        gameBoard.mark(1, "X");
        assertThat(board.get(0), is("X"));
    }

    @Test
    public void shouldHaveXInSpotTwoWhenFirstMoveIsTwo() throws Exception {
        gameBoard.mark(2, "X");
        assertThat(board.get(1), is("X"));
    }

    @Test
    public void isPositionTakenMethodShouldReturnFalseWhenMoveIsValid() {
        assertFalse(gameBoard.isPositionTaken(1));
    }

    @Test
    public void isPositionTakenMethodShouldReturnTrueWhenMoveIsNotValid() {
        board.set(0, "X");
        assertTrue(gameBoard.isPositionTaken(1));
    }

    @Test
    public void shouldReturnFalseWhenBoardIsNotFull() {
        assertFalse(gameBoard.isFull());
    }

    @Test
    public void shouldReturnTrueWhenBoardIsFull() {
        board = Arrays.asList("X", "X", "X", "X", "X", "O", "O", "O", "O");
        gameBoard = new GameBoard(printStream, board);
        assertTrue(gameBoard.isFull());
    }

    @Test
    public void shouldReturnTrueWhenRowIsFullWithSameSymbol() {
        board = Arrays.asList("X", "X", "X", "4", "5", "6", "7", "8", "9");
        gameBoard = new GameBoard(printStream, board);
        assertTrue(gameBoard.hasFullRow());
    }

    @Test
    public void shouldReturnFalseWhenRowIsFullWithDifferentSymbols() {
        board = Arrays.asList("X", "O", "X", "4", "5", "6", "7", "8", "9");
        gameBoard = new GameBoard(printStream, board);
        assertFalse(gameBoard.hasFullRow());
    }

    @Test
    public void shouldReturnFalseWhenRowIsNotFull() {
        assertFalse(gameBoard.hasFullRow());
    }

    @Test
    public void shouldReturnTrueWhenColumnIsFullWithSameSymbol() {
        board = Arrays.asList("X", "2", "3", "X", "5", "6", "X", "8", "9");
        gameBoard = new GameBoard(printStream, board);
        assertTrue(gameBoard.hasFullColumn());
    }

    @Test
    public void shouldReturnFalseWhenColumnIsFullWithDifferentSymbols() {
        board = Arrays.asList("X", "2", "3", "O", "5", "6", "X", "8", "9");
        gameBoard = new GameBoard(printStream, board);
        assertFalse(gameBoard.hasFullColumn());
    }

    @Test
    public void shouldReturnFalseWhenColumnIsNotFull() {
        assertFalse(gameBoard.hasFullColumn());
    }

    @Test
    public void shouldReturnTrueWhenDiagonalIsFullWithSameSymbol() {
        board = Arrays.asList("X", "2", "3", "4", "X", "6", "7", "8", "X");
        gameBoard = new GameBoard(printStream, board);
        assertTrue(gameBoard.hasFullDiagonal());
    }

    @Test
    public void shouldReturnFalseWhenDiagonalIsFullWithDifferentSymbols() {
        board = Arrays.asList("1", "2", "X", "4", "O", "6", "X", "8", "9");
        gameBoard = new GameBoard(printStream, board);
        assertFalse(gameBoard.hasFullDiagonal());
    }

    @Test
    public void shouldReturnFalseWhenDiagonalIsNotFull() {
        assertFalse(gameBoard.hasFullDiagonal());
    }


}