package it.unibo.pps.e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardLogicTest {
    private static final int BOARD_SIZE = 5;

    @Test
    public void testBoardLogicInitialization() {
        BoardLogic boardLogic = new BoardLogicImpl(BOARD_SIZE);
        assertEquals(BOARD_SIZE, boardLogic.getSize());
    }
}
