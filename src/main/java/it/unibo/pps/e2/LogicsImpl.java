package it.unibo.pps.e2;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private final Pair<Integer,Integer> pawn;
	private final Knight knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = new KnightImpl(this.randomEmptyPosition());
    }

	public LogicsImpl(final int size, final Pair<Integer, Integer> pawnPosition,
					  final Knight knight) {
		this.size = size;
		this.pawn = pawnPosition;
		this.knight = knight;
	}
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		final Pair<Integer, Integer> position = new Pair<>(row, col);
		if (!this.isInsideBoard(position)) {
			throw new IndexOutOfBoundsException();
		}

		this.knight.move(position);
		return this.pawn.equals(this.knight.getPosition());
	}

	@Override
	public boolean hasKnight(int row, int col) {
		return this.knight.getPosition().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		return this.pawn.equals(new Pair<>(row,col));
	}

	private boolean isInsideBoard(final Pair<Integer, Integer> position) {
        return position.getX() >= 0 && position.getY() >= 0
				&& position.getX() < this.size && position.getY() < this.size;
    }
}
