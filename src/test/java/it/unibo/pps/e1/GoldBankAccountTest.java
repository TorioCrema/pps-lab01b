package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldBankAccountTest extends BankAccountTest {

    @Override
    @BeforeEach
    void init() {
        super.account = new GoldBankAccount(new CoreBankAccount(), new GoldFee());
    }

    @Override
    protected int getExpectedFee() {
        return 0;
    }
}
