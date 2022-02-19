package com.java.solid.open_closed;

public class EmailNotificationService implements Notificationservice{
    @Override
    public void sendOtp(String medium) {

        //logic for sending otp through mail
    }

    @Override
    public void sendTransactionReport(String medium) {

        //logic fo sending transaction report via mail
    }
}
