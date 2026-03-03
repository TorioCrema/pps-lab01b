package it.unibo.pps.e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {

    private Knight knight;
    private Pair<Integer, Integer> initialPosition;
    private Pair<Integer, Integer> validMove;
    private Pair<Integer, Integer> invalidMove;

    @BeforeEach
    public void init() {
        this.initialPosition = new Pair<>(2, 3);
        this.knight = new KnightImpl(this.initialPosition);
        this.validMove = new Pair<>(4, 4);
        this.invalidMove = new Pair<>(2, 2);
    }

    @Test
    public void testInitialPosition() {
        assertEquals(this.initialPosition, knight.getPosition());
    }

    @Test
    public void testIsValidIsTrueOnValidMove() {
        assertTrue(this.knight.isValid(validMove));
    }

    @Test
    public void testIsValidIsFalseOnInvalidMove() {
        assertFalse(this.knight.isValid(invalidMove));
    }

    @Test
    public void testMovesOnValidMove() {
        this.knight.move(this.validMove);
        assertEquals(validMove, this.knight.getPosition());
    }

    @Test
    public void testMoveThrowsOnInvalidMove() {
        assertThrows(IllegalArgumentException.class, () -> this.knight.move(invalidMove));
    }
}
