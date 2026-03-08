package it.unibo.pps.e2;

public class KnightLogicImpl implements KnightLogic {
    private static final int TOTAL_STEPS_FOR_VALID_MOVEMENT = 3;

    @Override
    public boolean isMoveValid(Pair<Integer, Integer> oldPosition, Pair<Integer, Integer> newPosition) {
        int offsetX = newPosition.getX() - oldPosition.getX();
        int offsetY = newPosition.getY() - oldPosition.getY();
        return offsetX != 0 && offsetY != 0 && Math.abs(offsetX) + Math.abs(offsetY) == TOTAL_STEPS_FOR_VALID_MOVEMENT;
    }
}
