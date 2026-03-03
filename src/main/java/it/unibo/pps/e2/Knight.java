package it.unibo.pps.e2;

public class Knight {
    private Pair<Integer, Integer> position;

    public Knight(final Pair<Integer, Integer> startPosition) {
        this.position = startPosition;
    }

    public Pair<Integer, Integer> getPosition() {
        return new Pair<>(this.position.getX(), this.position.getY());
    }

    public boolean isValid(final Pair<Integer, Integer> move) {
        int x = move.getX() - this.position.getX();
        int y = move.getY() - this.position.getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }

    public void move(final Pair<Integer, Integer> position) {
        if (!this.isValid(position)) {
            throw new IllegalArgumentException();
        }
        this.position = new Pair<>(position.getX(), position.getY());
    }
}
