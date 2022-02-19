package com.java.solid.liskov_substitution;

public class PunjabNationalBank implements bankServices,CheckBook{
    @Override
    public void PassBook() {
        System.out.println("PNB provides you Passbook");
    }

    @Override
    public void debitCard() {
        System.out.println("PNB provides you Debit card");
    }

    @Override
    public void checkBook() {
        System.out.println("PNB provides you Check Book");
    }
}
