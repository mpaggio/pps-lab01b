package it.unibo.pps.e2;

import java.util.Random;

public class BoardLogicImpl implements BoardLogic {
    private final int boardSize;
    private Pair<Integer, Integer> pawnPosition;
    private Pair<Integer, Integer> knightPosition;
    private final Random random = new Random();
    private static final int MIN_AXIS_POSITION = 0;

    private final Pair<Integer,Integer> randomEmptyPosition(){
        Pair<Integer,Integer> pos = new Pair<>(
                this.random.nextInt(this.boardSize),
                this.random.nextInt(this.boardSize)
        );
        // the recursive call below prevents clash with an existing pawn
        return this.pawnPosition!=null && this.pawnPosition.equals(pos) ? randomEmptyPosition() : pos;
    }

    public BoardLogicImpl(int boardSize) {
        this.boardSize = boardSize;
        this.pawnPosition = this.randomEmptyPosition();
        this.knightPosition = this.randomEmptyPosition();
    }

    public BoardLogicImpl(int boardSize, Pair<Integer, Integer> pawnPosition, Pair<Integer, Integer> knightPosition) {
        this.boardSize = boardSize;
        this.pawnPosition = pawnPosition;
        this.knightPosition = knightPosition;
    }

    @Override
    public int getSize() {
        return boardSize;
    }

    @Override
    public Pair<Integer, Integer> getKnightPosition() {
        return new Pair<>(this.knightPosition.getX(), this.knightPosition.getY());
    }

    @Override
    public Pair<Integer, Integer> getPawnPosition() {
        return new Pair<>(this.pawnPosition.getX(), this.pawnPosition.getY());
    }

    @Override
    public boolean isPositionAllowed(final int row, final int col) {
        return row >= MIN_AXIS_POSITION &&
            col >= MIN_AXIS_POSITION &&
            row < this.boardSize &&
            col < this.boardSize;
    }

    @Override
    public void moveKnight(int x, int y) {
        this.knightPosition = new Pair<>(x,y);
    }
}
