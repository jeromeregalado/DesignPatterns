package org.example.chainOfResponsibility;

public class PHP20DispenseChain extends IATMDispenseChain{
    @Override
    public void dispense(int amount) {
        if (amount >= 20) {
            int notes = amount / 20;
            int remainingAmount = amount % 20;
            System.out.println("Number of PHP 20 notes are " + String.valueOf(notes));
            this.nextChain.dispense(remainingAmount);
        } else if (amount > 0) {
            this.nextChain.dispense(amount);
        }
    }
}
