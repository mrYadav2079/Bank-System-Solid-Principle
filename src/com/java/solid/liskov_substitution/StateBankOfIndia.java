package com.java.solid.liskov_substitution;

public class StateBankOfIndia implements bankServices,CreditCard {

    @Override
    public void PassBook() {
        System.out.println("SBI provides you Passbook");
    }

    @Override
    public void debitCard() {
        System.out.println("SBI provides you Debit card");
    }

    @Override
    public void creditCard() {
        System.out.println("SBI provides you Credit card");
    }
}
