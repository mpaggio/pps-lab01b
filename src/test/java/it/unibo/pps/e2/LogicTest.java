package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {
    private Logics logic;
    private static final int LOGIC_INITIAL_SIZE = 5;
    private static final int KNIGHT_MAX_MOVEMENT_ON_AXIS = 2;
    private static final int KNIGHT_MIN_MOVEMENT_ON_AXIS = 1;

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
        Pair<Integer, Integer> knightPos = this.logic.getKnightPos();
        Pair<Integer, Integer> pawnPos = this.logic.getPawnPos();
        assertNotEquals(knightPos, pawnPos);
    }

    @Test
    public void testKnightHitNotAllowed() {
        Pair<Integer, Integer> knightPos = this.logic.getKnightPos();
        int newX = (knightPos.getX() < this.logic.getSize() - KNIGHT_MIN_MOVEMENT_ON_AXIS) ?
            knightPos.getX() + KNIGHT_MIN_MOVEMENT_ON_AXIS :
            knightPos.getX();
        int newY = (knightPos.getY() < this.logic.getSize() - KNIGHT_MIN_MOVEMENT_ON_AXIS) ?
            knightPos.getY() + KNIGHT_MIN_MOVEMENT_ON_AXIS :
            knightPos.getY();
        assertFalse(this.logic.hit(newX, newY));
    }

    @Test
    public void testKnightHitOutOfBoundaries() {
        assertThrows(
            IndexOutOfBoundsException.class,
                () -> this.logic.hit(
                this.logic.getKnightPos().getX() + this.logic.getSize(),
                this.logic.getKnightPos().getY() + this.logic.getSize()
            )
        );
    }

    private Pair<Integer, Integer> findNewPos(final Pair<Integer, Integer> currentPos) {
        List<Pair<Integer, Integer>> possibleMovementOffset = List.of(
                new Pair<>(KNIGHT_MAX_MOVEMENT_ON_AXIS, KNIGHT_MIN_MOVEMENT_ON_AXIS),
                new Pair<>(-KNIGHT_MAX_MOVEMENT_ON_AXIS, KNIGHT_MIN_MOVEMENT_ON_AXIS),
                new Pair<>(KNIGHT_MAX_MOVEMENT_ON_AXIS, -KNIGHT_MIN_MOVEMENT_ON_AXIS),
                new Pair<>(-KNIGHT_MAX_MOVEMENT_ON_AXIS, -KNIGHT_MIN_MOVEMENT_ON_AXIS),
                new Pair<>(KNIGHT_MIN_MOVEMENT_ON_AXIS, KNIGHT_MAX_MOVEMENT_ON_AXIS),
                new Pair<>(-KNIGHT_MIN_MOVEMENT_ON_AXIS, KNIGHT_MAX_MOVEMENT_ON_AXIS),
                new Pair<>(KNIGHT_MIN_MOVEMENT_ON_AXIS, -KNIGHT_MAX_MOVEMENT_ON_AXIS),
                new Pair<>(-KNIGHT_MIN_MOVEMENT_ON_AXIS, -KNIGHT_MAX_MOVEMENT_ON_AXIS)
        );
        Pair<Integer, Integer> newPos = null;
        for (Pair<Integer, Integer> offset : possibleMovementOffset) {
            Pair<Integer,Integer> tmpPosition = new Pair<>(currentPos.getX() + offset.getX(), currentPos.getY() + offset.getY());
            if (tmpPosition.getX() >= 0 && tmpPosition.getY() >= 0 &&
                    tmpPosition.getX() < this.logic.getSize() && tmpPosition.getY() < this.logic.getSize()) {
                newPos = tmpPosition;
                break;
            }
        }
        return newPos;
    }

    @Test
    public void testKnightHitAllowed() {
        Pair<Integer, Integer> knightPos = this.logic.getKnightPos();
        Pair<Integer, Integer> newPos = findNewPos(knightPos);
        this.logic.hit(newPos.getX(), newPos.getY());
        assertEquals(newPos, this.logic.getKnightPos());
    }

    @Test
    public void testKnightHitPawnPosition() {
        Logics localLogic = new LogicsImpl(5, new Pair<>(0,0), new Pair<>(2,1));
        assertTrue(localLogic.hit(localLogic.getPawnPos().getX(), localLogic.getPawnPos().getY()));
    }
}
