package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class TransactionTest {

    @Test
    public void transaction() {
        //Return true or false when transactions are successful or not, then can check against this
        Transaction t = new Transaction(5);
        assertTrue(t instanceof Transaction);

    }
}
