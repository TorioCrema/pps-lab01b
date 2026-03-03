package it.unibo.pps.e2;

public interface Knight {

    /**
     * Returns a safe copy of the knight's current position.
     * @return The knight's position.
     */
    Pair<Integer, Integer> getPosition();

    /**
     * Returns true is the move is valid in reference to the
     * knight's current position, false otherwise.
     * @param move the move that will be tested for validity.
     * @return true if the move is valid, false otherwise
     */
    boolean isValid(Pair<Integer, Integer> move);

    /**
     * Moves the knight to the given position if
     * said position is valid, otherwise throws an
     * exception.
     * @param position the position to move the knight to.
     * @throws IllegalArgumentException if the move isn't valid.
     */
    void move(Pair<Integer, Integer> position);
}
