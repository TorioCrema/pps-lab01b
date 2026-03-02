package it.unibo.pps.e1;

public class BronzeFee implements Fee {
    @Override
    public int calculateFee(final int withdrawAmount) {
        return withdrawAmount > 100 ? 1 : 0;
    }
}
