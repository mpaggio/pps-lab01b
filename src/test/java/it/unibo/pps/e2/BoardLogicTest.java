package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardLogicTest {
    private BoardLogic boardLogic;
    private static final int BOARD_SIZE = 5;


    @BeforeEach
    public void setUp() {
        Pair<Integer, Integer> pawnPosition = new Pair<>(0,0);
        Pair<Integer, Integer> knightPosition = new Pair<>(2,1);
        this.boardLogic = new BoardLogicImpl(BOARD_SIZE, pawnPosition, knightPosition);
    }

    @Test
    public void testBoardLogicInitialization() {
        assertEquals(BOARD_SIZE, this.boardLogic.getSize());
        assertNotNull(this.boardLogic.getKnightPosition());
        assertNotNull(this.boardLogic.getPawnPosition());
    }

    @Test
    public void testBoardLogicRandomInitialization() {
        BoardLogic localBoardLogic = new BoardLogicImpl(BOARD_SIZE);
        assertEquals(BOARD_SIZE, localBoardLogic.getSize());
        assertNotNull(localBoardLogic.getKnightPosition());
        assertNotNull(localBoardLogic.getPawnPosition());
    }

    @Test
    public void testPositionIsNotWithinBoundaries() {
        assertFalse(this.boardLogic.isPositionAllowed(BOARD_SIZE, BOARD_SIZE));
    }

    @Test
    public void testPositionIsWithinBoundaries() {
        int rowExample = 0;
        int colExample = 4;
        assertTrue(this.boardLogic.isPositionAllowed(rowExample, colExample));
    }

    @Test
    public void testMoveKnight() {
        Pair<Integer, Integer> oldKnightPos = this.boardLogic.getKnightPosition();
        this.boardLogic.moveKnight(this.boardLogic.getPawnPosition().getX(), this.boardLogic.getPawnPosition().getY());
        assertNotEquals(oldKnightPos, this.boardLogic.getKnightPosition());
    }
}
