package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {

    private final BoardLogic boardLogic;
    private final KnightLogic knightLogic;
	 
    public LogicsImpl(final BoardLogic boardLogic, final KnightLogic knightLogic){
    	this.boardLogic = boardLogic;
        this.knightLogic = knightLogic;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (!this.boardLogic.isPositionAllowed(row, col)) {
			throw new IndexOutOfBoundsException();
		}
        Pair<Integer, Integer> newPosition = new Pair<>(row, col);
		if (this.knightLogic.isMoveValid(this.boardLogic.getKnightPosition(), newPosition)) {
            this.boardLogic.moveKnight(row,col);
			return this.boardLogic.getPawnPosition().equals(newPosition);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.boardLogic.getKnightPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.boardLogic.getPawnPosition().equals(new Pair<>(row,col));
	}

    @Override
    public int getSize() {
        return this.boardLogic.getSize();
    }

    @Override
    public Pair<Integer, Integer> getKnightPos() {
        return this.boardLogic.getKnightPosition();
    }

    @Override
    public Pair<Integer, Integer> getPawnPos() {
        return this.boardLogic.getPawnPosition();
    }
}
