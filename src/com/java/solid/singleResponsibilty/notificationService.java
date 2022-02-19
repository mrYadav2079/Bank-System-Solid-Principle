package com.java.solid.singleResponsibilty;

public class notificationService {
    public void sendOtp(String Medium){
       if(Medium.equals("email")){
           //write email related logic
       }
       if(Medium.equals("mobile")){
           //write message related logic
       }
    }
}
