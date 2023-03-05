package JavaHungryJavaProjects;
import java.util.Scanner;


public class SimpleBankingApp {
    public static void main(String[] args) {
    BankAccount myBankAccount = new BankAccount("Amazing One", "BA100000001");
        myBankAccount.showMenu();


//    BankAccount leesBankAccount = new BankAccount("Lee", "BA100000002");
////        leesBankAccount.showMenu();
    }
}

class BankAccount {
    double balance;
    double previousTransaction;
    String customerName;
    String customerId;



   BankAccount(String cName, String cId){
       customerName = cName;
       customerId = cId;
   }


    void deposit(double amount) {
        if(amount != 0){
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(double amount){
       if(amount != 0){
           balance -= amount;
           previousTransaction = -amount;
       }
    }

    void getPreviousTransaction() {

        if(previousTransaction > 0){
            System.out.println("Deposited: "+ previousTransaction);
        } else {
            System.out.println("No deposit made");
        }
        if( previousTransaction < 0 ){
            System.out.println("Withdrew: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No withdrawal made");
        }
    }

   public void showMenu(){
       char option = 0;
       Scanner scan = new Scanner(System.in);

       System.out.println("Welcome to the Bank, " + customerName + "!" + "\n" + " Customer ID: "+ customerId);
       System.out.println("\n");
       System.out.println("Choose from the options Below:");
       System.out.println("==============================");
       System.out.println("A. Check Balance");
       System.out.println("B. Deposit");
       System.out.println("C. Withdraw");
       System.out.println("D. Previous Transaction");
       System.out.println("E. Exit");
       System.out.println("==============================");

       do {
           System.out.println("Enter your option below: ");
           System.out.println("==============================");
           option = scan.next().toLowerCase().charAt(0);

           switch(option){

               case 'a':
                   System.out.println("++++++++++++++++++++++++++++");
                   System.out.println("Your Balance is: " + balance);
                   System.out.println("++++++++++++++++++++++++++++");
                   System.out.println("\n");
                   break;

               case 'b':
                   System.out.println("++++++++++++++++++++++++++++");
                   System.out.println("Enter deposit amount: ");
                   System.out.println("++++++++++++++++++++++++++++");
                   int depositAmount = scan.nextInt();
                    deposit(depositAmount);
                   System.out.println("\n");
                   break;

               case 'c':
                   System.out.println("++++++++++++++++++++++++++++");
                   System.out.println("Enter withdrawal amount: ");
                   System.out.println("++++++++++++++++++++++++++++");
                   int withdrawAmount = scan.nextInt();
                   withdraw(withdrawAmount);
                   System.out.println("\n");
                   break;

               case 'd':
                   System.out.println("++++++++++++++++++++++++++++");
                   System.out.println("Your previous transaction is: ");
                   getPreviousTransaction();
                   System.out.println("++++++++++++++++++++++++++++");
                   System.out.println("\n");
                   break;

               case 'e':
                   System.out.println("++++++++++++++++++++++++++++");
                   System.out.println("Exiting Now");
                   System.out.println("++++++++++++++++++++++++++++");
                   System.out.println("\n");
                   break;

               default:
                   System.out.println("++++++++++++++++++++++++++++++++++");
                   System.err.println("INVALID Option. Please Try Again.");
                   System.out.println("++++++++++++++++++++++++++++++++++");
                   System.out.println("\n");
                   break;
           }
       } while(option !='e');
       System.out.println("Thank you for your patronage! Please come again soon!");
       scan.close();
   }
}
