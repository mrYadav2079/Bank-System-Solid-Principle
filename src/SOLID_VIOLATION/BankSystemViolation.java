package SOLID_VIOLATION;

import com.java.solid.dependency_inversion.BankCard;

//--------------------------SINGLE RESPONSIBILITY------------------------------------------
class BankServices {
    public long deposit(long amount, String accountNo) {
        return 0;
    }

    public long withDraw(long amount, String accountNo) {
        return 0;
    }

    public void getLoanServiceInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            //do some job
        }
        if (loanType.equals("personalLoan")) {
            //do some job
        }
        if (loanType.equals("carLoan")) {
            //do some job
        }

    }
    public void sendOtp(String Medium){
        if(Medium.equals("email")){
            //write email related logic
        }
        if(Medium.equals("mobile")){
            //write message related logic
        }
    }
    // this class has more than one reason to change
    //hence it violates the single responsibility function.
}

//--------------------------------------------------------------------------------------------------

//------------------------------------OPEN / CLOSED---------------------------------------------------
     class notificationService {
    public void sendOtp(String Medium){
        if(Medium.equals("email")){
            //write email related logic
        }
        if(Medium.equals("mobile")){
            //write message related logic
        }
    }
}
// if we want to add a new feature in notification services to send otp via whatsapp
//we have to modify in the notification services class
//hence it violates the open /closed principle
//---------------------------------------------------------------------------------------------------------

//-----------------------------LISKOV SUBSTITUTION---------------------------------------------------------
    class Bank{
    public void PassBook(){

    }
    public void debitCard(){

    }
    public void checkbook(){

    }
    public void creditCard(){

    }
}
     class SBI extends Bank{
         public void PassBook(){

         }

         public void debitCard(){

         }
         public void checkbook(){

         }
//         public void creditCard(){
//
//         }
         //although SBI class extends the Bank class but we do not have a feature of Credit Card
         //in SBI so class SBI can not be replaced by class Bank
         //hence it violates the liskov substitution principle
}
//----------------------------------------------------------------------------------------------

//-----------------------INTERFACE SEGREGATION--------------------------------------------------
interface UPIPayment {
    public void payMoney();

    public void getScratchMethod();

    public void getCashBackCreditBalance();

}
 class paytm implements UPIPayment{
     public void payMoney(){

     }

     public void getScratchMethod(){

     }
        // here interface is not segregated which results in paytm implementing method it does not have
     //it violates the interface segregation principle
   public void getCashBackCreditBalance(){

   }
}
//----------------------------------------------------------------------------------------------

//------------------------Dependency Inversion --------------------------------------------
 class ShoppingMall {

    private CreditCard creditCard;
    //Here CreditCard class is tightly coupled with the Shopping Mall class
    //hence it violates the Dependency Inversion principle
    public ShoppingMall(CreditCard creditCard){
        this.creditCard =creditCard;
    }
    public void doPurchase(long amount){
        creditCard.doTransaction(amount);
    }
    class CreditCard{
        public void doTransaction(long amount) {
            System.out.println("You have done a transaction of :" +amount+"using Credit Card");
        }
    }
}

public class BankSystemViolation {
    public static void main(String[] args) {

    }
}
