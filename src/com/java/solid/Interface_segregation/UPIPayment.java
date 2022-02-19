package com.java.solid.Interface_segregation;

public interface UPIPayment {
    public void payMoney();

    public void getScratchMethod();

    //public void getCashBackCreditBalance();


    //since this feature is not supported by phonepe and Paytm
    //we will add this feature in different interface
}
