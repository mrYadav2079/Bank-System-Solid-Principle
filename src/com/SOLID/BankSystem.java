package com.SOLID;





    //--------------------------SINGLE RESPONSIBILITY------------------------------------------
    interface BankServices {
        public long deposit(long amount, String accountNo);

        public long withDraw(long amount, String accountNo);

    }
    //here Bank Services has given only one responsibility so that it has
    //only reason to change
    // we have not added loan services or notification services  to it.
    //we must create other interfaces to do so
    interface LoanServices{
        public void getLoanServiceInfo(String loanType);
    }
    interface NotificationServices{
        public void sendOtp(String Medium);
        public void sendTransactionReport(String medium);
    }
//--------------------------------------------------------------------------------------------------

//------------------------------------OPEN / CLOSED-----------------------------------------------------------------
//suppose we have to add feature of sending notification using mobile,email and whatsapp
//instead of modifying in the notification interface we will implement it
//which follows the principle of open for extension closed for modification

    class MobileNotificationService implements NotificationServices {
        @Override
        public void sendOtp(String medium) {
            System.out.println("OTP sent to your mobile");
        }

        @Override
        public void sendTransactionReport(String medium) {
            System.out.println("Transaction report sent to your mobile");
        }
    }


    class WhatsappNotificationService implements NotificationServices {
        @Override
        public void sendOtp(String medium) {
            System.out.println("OTP sent to your whatsapp");
        }

        @Override
        public void sendTransactionReport(String medium) {
            System.out.println("Transaction report sent to your whatsapp");
        }
    }
//---------------------------------------------------------------------------------------------------------

    //-----------------------------LISKOV SUBSTITUTION---------------------------------------------------------
    interface Bank {

        public void PassBook();

        public void debitCard();

        //credit card
        //checkbook
    }
    interface CheckBook {

        public void checkBook();

    }
    interface CreditCard {

        public void creditCard();

    }
    class StateBankOfIndia implements Bank,CreditCard {

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
    class PunjabNationalBank implements Bank,CheckBook{
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
//----------------------------------------------------------------------------------------------

    //-----------------------INTERFACE SEGREGATION--------------------------------------------------
    interface UPIPayment {
        public void payMoney();
        public void getScratchMethod();
    }
    interface CashBackManager {

        public void GetCashBackAsCreditBalance();

    }
    class Gpay implements UPIPayment, CashBackManager{
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
    class Phonepe implements UPIPayment {
        @Override
        public void payMoney() {
            System.out.println("Paid money to Vishal");
        }

        @Override
        public void getScratchMethod() {
            System.out.println("You got a scratch card worth of 50 rs");
        }
    }
    //----------------------------------------------------------------------------------------------

    //------------------------Dependency Inversion --------------------------------------------
    interface BankCard {

        public void doTransaction(long amount);

    }
    class Credit_Card implements BankCard{
        @Override
        public void doTransaction(long amount) {
            System.out.println("You have done a transaction of :" +amount+"using Credit Card");
        }
    }
    class Debit_Card implements BankCard{
        @Override
        public void doTransaction(long amount) {
            System.out.println("You have done a transaction of :" +amount+"using Debit Card  ");
        }
    }

    class ShoppingMall {

        private  BankCard bankCard;

         public  ShoppingMall(BankCard bankCard) {
            this.bankCard = bankCard;
        }
        //instead of tightly coupling credit card or debit card we use bank card which is implemented by
//both credit and debit card.
         void doPurchase(long amount) {
            bankCard.doTransaction(amount);
        }
    }
public class BankSystem  {
   public static void  main(String[] args) {
    BankCard bankcard = new Debit_Card();
    ShoppingMall shoppingMall = new ShoppingMall(bankcard);
    shoppingMall.doPurchase(5000);
    StateBankOfIndia sbi = new StateBankOfIndia();
    sbi.debitCard();
    sbi.creditCard();
    }
}



