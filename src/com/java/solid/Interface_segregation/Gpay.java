package com.java.solid.Interface_segregation;

public class Gpay implements UPIPayment,CashBackManager{
    @Override
    public void GetCashBackAsCreditBalance() {
        System.out.println("cash back received to your bank account");
    }

    @Override
    public void payMoney() {
        System.out.println("Paid money to Vishal");
    }

    @Override
    public void getScratchMethod() {
        System.out.println("You got a scratch card worth of 50 rs");
    }
}
