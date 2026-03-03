package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {

    private Knight knight;
    private Pair<Integer, Integer> initialPosition;

    @BeforeEach
    public void init() {
        this.initialPosition = new Pair<>(2, 3);
        this.knight = new KnightImpl(this.initialPosition);
    }

    @Test
    public void testInitialPosition() {
        assertEquals(this.initialPosition, knight.getPosition());
    }

    @Test
    public void testIsValidOnValidMove() {
        final Pair<Integer, Integer> validMove = new Pair<>(4, 4);
        assertTrue(this.knight.isValid(validMove));
    }

    @Test
    public void testIsValidOnInvalidMove() {
        final Pair<Integer, Integer> invalidMove = new Pair<>(2, 2);
        assertFalse(this.knight.isValid(invalidMove));
    }

    @Test
    public void testMovesOnValidMove() {
        final Pair<Integer, Integer> validMove = new Pair<>(4, 4);
        this.knight.move(validMove);
        assertEquals(validMove, this.knight.getPosition());
    }

    @Test
    public void testMoveThrowsOnInvalidMove() {
        final Pair<Integer, Integer> invalidMove = new Pair<>(2, 2);
        assertThrows(IllegalArgumentException.class, () -> this.knight.move(invalidMove));
    }
}
