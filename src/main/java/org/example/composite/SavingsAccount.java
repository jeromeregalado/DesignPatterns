package org.example.composite;

public class SavingsAccount extends Account
{
    private String accountNo;
    private float accountBalance;

    public SavingsAccount(String accountNo, float accountBalance) {
        super();
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }

    public float getBalance() {
        return accountBalance;
    }
}

