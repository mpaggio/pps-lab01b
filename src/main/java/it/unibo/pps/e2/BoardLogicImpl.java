package it.unibo.pps.e2;

public class BoardLogicImpl implements BoardLogic {
    private int boardSize;

    public BoardLogicImpl(int boardSize) {
        this.boardSize = boardSize;
    }

    @Override
    public int getSize() {
        return boardSize;
    }
}
