package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private Pair<Integer, Integer> pawnPosition;
    private Pair<Integer, Integer> knightPosition;
    private Logics logic;

    @BeforeEach
    public void init() {
        this.pawnPosition = new Pair<>(3, 2);
        this.knightPosition = new Pair<>(4, 4);
        this.logic = new LogicsImpl(10, this.pawnPosition, new KnightImpl(this.knightPosition));
    }

    @Test
    public void testInitialPositions() {
        assertTrue(logic.hasPawn(pawnPosition.getX(), pawnPosition.getY()));
        assertTrue(logic.hasKnight(knightPosition.getX(), knightPosition.getY()));
    }

    @Test
    public void testHitThrowsWhenOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(11, 9));
        assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(5, -5));
    }

    @Test
    public void testKnightTakes() {
        assertTrue(this.logic.hit(this.pawnPosition.getX(), this.pawnPosition.getY()));
        assertTrue(this.logic.hasPawn(this.pawnPosition.getX(), this.pawnPosition.getY()));
        assertTrue(this.logic.hasKnight(this.pawnPosition.getX(), this.pawnPosition.getY()));
    }

    @Test
    public void testKnightMovesWithoutTaking() {
        final Pair<Integer, Integer> validMove = new Pair<>(2, 5);
        assertFalse(this.logic.hit(validMove.getX(), validMove.getY()));
        assertTrue(this.logic.hasKnight(validMove.getX(), validMove.getY()));
    }

    @Test
    public void testKnightStaysWhenMoveIsInvalid() {
        final Pair<Integer, Integer> invalidMove = new Pair<>(3, 5);
        assertFalse(this.logic.hit(invalidMove.getX(), invalidMove.getY()));
        assertTrue(this.logic.hasKnight(this.knightPosition.getX(), this.knightPosition.getY()));
    }
}
