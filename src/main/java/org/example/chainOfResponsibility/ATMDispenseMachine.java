package org.example.chainOfResponsibility;

public class ATMDispenseMachine {
    private IATMDispenseChain dispenseChain;

    public ATMDispenseMachine() {
        this.dispenseChain = new PHP50DispenseChain();
        IATMDispenseChain PHP20DispenseChain = new PHP20DispenseChain();
        IATMDispenseChain PHP10DispenseChain = new PHP10DispenseChain();
        PHP20DispenseChain.setNextChain(PHP10DispenseChain);
        this.dispenseChain.setNextChain(PHP20DispenseChain);
    }

    public void dispense(int amount) {
        this.dispenseChain.dispense(amount);
    }
}
