package com.java.solid.open_closed;

public interface Notificationservice {

    public void sendOtp(String medium);

    public void sendTransactionReport(String medium);
}
