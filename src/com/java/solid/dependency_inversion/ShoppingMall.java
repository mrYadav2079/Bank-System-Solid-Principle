package com.java.solid.dependency_inversion;

public class ShoppingMall {
    private BankCard bankCard;
    public ShoppingMall(BankCard bankCard){
        this.bankCard =bankCard;
    }
    public void doPurchase(long amount){
        bankCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        //CreditCard creditCard = new creditCard();
        //DebitCard debitCard = new debitCard();
        //instead of making tightly coupled debit card or credit card
        //we will use bank card which is implemented by both debit and credit card
        //so that we can use which ever we want
        BankCard bankCard = new DebitCard() ;
        ShoppingMall shoppingMall = new ShoppingMall(bankCard);
        shoppingMall.doPurchase(5000);


    }
}
