package com.java.solid.Interface_segregation;

public class PhonePe implements UPIPayment{
    @Override
    public void payMoney() {
        System.out.println("Paid money to Vishal");
    }

    @Override
    public void getScratchMethod() {
        System.out.println("You got a scratch card worth of 50 rs");
    }
}
