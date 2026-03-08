package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightLogicTest {
    private KnightLogic knightLogic;

    @BeforeEach
    public void setUp() {
        this.knightLogic = new KnightLogicImpl();
    }

    @Test
    public void testMoveIsValid() {
        Pair<Integer, Integer> oldPosition = new Pair<>(0,0);
        Pair<Integer, Integer> newPosition = new Pair<>(2,1);
        assertTrue(this.knightLogic.isMoveValid(oldPosition, newPosition));
    }

    @Test
    public void testMoveIsNotValid() {
        Pair<Integer, Integer> oldPosition = new Pair<>(0,0);
        Pair<Integer, Integer> newPosition = new Pair<>(1,1);
        assertFalse(this.knightLogic.isMoveValid(oldPosition, newPosition));
    }
}
