package org.example.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeAccount extends Account
{
    private float totalBalance;
    private List<Account> accountList = new ArrayList<Account>();

    public float getBalance()
    {
        totalBalance = 0;
        for (Account f : accountList)
        {
            totalBalance = totalBalance + f.getBalance();
        }
        return totalBalance;
    }

    public void addAccount(Account acc)
    {
        accountList.add(acc);
    }

    public void removeAccount(Account acc)
    {
        accountList.add(acc);
    }
}
