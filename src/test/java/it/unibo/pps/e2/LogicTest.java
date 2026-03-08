package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    private Logics logic;
    private static final int LOGIC_INITIAL_SIZE = 5;

    @BeforeEach
    public void setUp() {
        this.logic = new LogicsImpl(LOGIC_INITIAL_SIZE);
    }

    @Test
    public void testInitialSize() {
        assertEquals(LOGIC_INITIAL_SIZE, this.logic.getSize());
    }

    @Test
    public void testPawnIsSingle() {
        int pawnCounter = 0;
        int numberOfPawn = 1;
        for (int i = 0; i < this.logic.getSize(); i++) {
            for (int j = 0; j < this.logic.getSize(); j++) {
                if (this.logic.hasPawn(i,j)) {
                    pawnCounter++;
                }
            }
        }
        assertEquals(numberOfPawn, pawnCounter);
    }

    @Test
    public void testKnightIsSingle() {
        int knightCounter = 0;
        int numberOfKnight = 1;
        for (int i = 0; i < this.logic.getSize(); i++) {
            for (int j = 0; j < this.logic.getSize(); j++) {
                if (this.logic.hasKnight(i,j)) {
                    knightCounter++;
                }
            }
        }
        assertEquals(numberOfKnight, knightCounter);
    }

    @Test
    public void testKnightAndPawnNotInTheSamePosition() {
        Pair<Integer, Integer> knightPos = null;
        Pair<Integer, Integer> pawnPos = null;
        for (int i = 0; i < this.logic.getSize(); i++) {
            for (int j = 0; j < this.logic.getSize(); j++) {
                if (this.logic.hasKnight(i,j)) {
                    knightPos = new Pair<>(i,j);
                } else if (this.logic.hasPawn(i,j)) {
                    pawnPos = new Pair<>(i,j);
                }
            }
        }
        assertNotEquals(knightPos, pawnPos);
    }
}
