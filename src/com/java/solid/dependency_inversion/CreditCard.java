package com.java.solid.dependency_inversion;

public class CreditCard implements BankCard{
    @Override
    public void doTransaction(long amount) {
        System.out.println("You have done a transaction of :" +amount+"using Credit Card");
    }
}
