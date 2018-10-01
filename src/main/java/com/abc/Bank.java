package com.abc;

import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers = new ArrayList<Customer>();

    //Add a customer to the banks list of customers.
    //Maybe just call customers.add rather than this method
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    //String summary providing name and number of accounts of each customer in bank.
    public String customerSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Customer Summary");
        String newLine = "\n";
        for (Customer c : customers) {
            summary.append(String.format("%s - %s (%s)", newLine, c.getName(), format(c.getNumberOfAccounts())));
        }

        return summary.toString();
    }

    //Make sure correct plural of word is created based on the number passed in:
    //If number passed in is 1 just return the word otherwise add an 's' at the end
    private String format(int number) {
        String account = " account";
        String accounts = " accounts";
        if(number == 1) {
            return number + account;
        } else {
            return number + accounts;
        }
    }

    public double totalInterestPaid() {
        double total = 0;
        for(Customer c: customers)
            total += c.totalInterestEarned();
        return total;
    }

    //First customer in array list.
    @NotNull
    public String getFirstCustomer() {
        try {
            customers = null;
            return customers.get(0).getName();
        } catch (Exception e){
            e.printStackTrace();
            return "Error";
        }
    }
}
