package it.unibo.pps.e2;

public interface BoardLogic {

    int getSize();

    Pair<Integer, Integer> getKnightPosition();

    Pair<Integer, Integer> getPawnPosition();

    boolean isPositionAllowed(int row, int col);

    void moveKnight(int x, int y);
}
