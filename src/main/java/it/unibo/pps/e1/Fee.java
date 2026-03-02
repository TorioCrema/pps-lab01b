package it.unibo.pps.e1;

@FunctionalInterface
public interface Fee {
    /**
     * Calculates and returns the fee;
     *
     * @return the fee.
     */
    int calculateFee(final int withdrawAmount);
}
