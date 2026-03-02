package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    private Logics logic;

    @BeforeEach
    public void setUp() {
        this.logic = new LogicsImpl(5);
    }

    @Test
    public void testInitialSize() {
        assertEquals(5, this.logic.getSize());
    }

    @Test
    public void testPawnIsSingle() {
        int pawnCounter = 0;
        for (int i = 0; i < this.logic.getSize(); i++) {
            for (int j = 0; j < this.logic.getSize(); j++) {
                if (this.logic.hasPawn(i,j)) {
                    pawnCounter++;
                }
            }
        }
        assertEquals(1, pawnCounter);
    }

    @Test
    public void testKnightIsSingle() {
        int knightCounter = 0;
        for (int i = 0; i < this.logic.getSize(); i++) {
            for (int j = 0; j < this.logic.getSize(); j++) {
                if (this.logic.hasKnight(i,j)) {
                    knightCounter++;
                }
            }
        }
        assertEquals(1, knightCounter);
    }
}
