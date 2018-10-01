package com.abc;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Customer {
    private String name;
    private List<Account> accounts = new ArrayList<Account>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public double totalInterestEarned() {
        double total = 0;
        for (Account a : accounts)
            total += a.interestEarned();
        return total;
    }

    public String getStatement() {

        StringBuilder statement = new StringBuilder();
        String newLine = "\n";
        double total = 0.0;

        statement.append("Statement for ").append(name).append(newLine);

        for (Account a : accounts) {
            statement.append(newLine).append(statementForAccount(a)).append(newLine);
            total += a.sumTransactions();
        }
        statement.append(newLine).append("Total In All Accounts ").append(toDollars(total));
        return statement.toString();
    }

    private String statementForAccount(Account a) {
        //Refacto all of these shitty one letter vars
        StringBuilder statement = new StringBuilder();
        //Something like this?
//        s += a.getAccountType().toString();
        //Translate to pretty account type
        //Then u can get rid of this whole block
        switch (a.getAccountType()) {
            case CHECKING:
                statement.append("Checking Account\n");
                break;
            case SAVINGS:
                statement.append("Savings Account\n");
                break;
            case MAXI_SAVINGS:
                statement.append("Maxi Savings Account\n");
                break;
        }

        //Now total up all the transactions
        double total = 0.0;
        for (Transaction t : a.transactions) {

            statement.append("  ").append(t.amount < 0 ? "withdrawal" : "deposit").append(" ").append(toDollars(t.amount)).append("\n");
            total += t.amount;
        }
        // Can we call toDollars once?
        statement.append("Total ").append(toDollars(total));
        return statement.toString();
    }

    private String toDollars(double d) {
        return String.format("$%,.2f", abs(d));
    }

    public void transferBetweenAccounts(int account1, int account2, double amount) {
        accounts.get(account1).depositOrWithdraw(amount, false);
        accounts.get(account2).depositOrWithdraw(amount, true);
    }

}
