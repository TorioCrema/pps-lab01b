package it.unibo.pps.e2;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogicTest {

    private Pair<Integer, Integer> pawnPosition;
    private Pair<Integer, Integer> knightPosition;
    private Logics logic;

    @BeforeEach
    public void init() {
        this.pawnPosition = new Pair<>(3, 2);
        this.knightPosition = new Pair<>(4, 5);
        this.logic = new LogicsImpl(10, this.pawnPosition, this.knightPosition);
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

}
