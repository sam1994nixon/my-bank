package com.abc;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private AccountType accountType;
    public List<Transaction> transactions = new ArrayList<Transaction>();

    public Account(AccountType accountType) {
        this.accountType = accountType;
    }


    public boolean depositOrWithdraw(double amount, boolean deposit) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be greater than zero");
        } else {
            if(deposit) {
                transactions.add(new Transaction(amount));
                return true;
            } else {
                transactions.add(new Transaction(-amount));
                return true;
            }
        }
    }

    //Calculates interest over time.
    public double interestEarned() {
        double amount = sumTransactions();
        int oneThousand = 1000;
        int twoThousand = 2000;
        double standardRate = 0.001;
        double doubleRate = 0.002;
        double maxiStandardRate = 0.02;
        double maxiRateOver1000 = 0.05;
        double maxiRateOver2000 = 0.1;


        switch (accountType) {
            case CHECKING:
                if (amount <= oneThousand)
                    return amount * standardRate;
            case SAVINGS:
                if (amount <= oneThousand)
                    return amount * standardRate;
                else
                    return 1 + (amount - oneThousand) * doubleRate;
//            case SUPER_SAVINGS:
//                if (amount <= 4000)
//                    return 20;
            case MAXI_SAVINGS:
                if (amount <= oneThousand)
                    return amount * maxiStandardRate;
                if (amount <= twoThousand)
                    return 20 + (amount - oneThousand) * maxiRateOver1000;
                return 70 + (amount - twoThousand) * maxiRateOver2000;
            default:
                return amount * standardRate;
        }
    }

    public double sumTransactions() {
        double amount;
        amount = 0.0;
        for (Transaction t : transactions) {
            amount += t.amount;
        }
        return amount;
    }

    public AccountType getAccountType() {
        return accountType;
    }

}
