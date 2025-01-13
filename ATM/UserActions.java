package ATM;
import ATM.Notes.Notes;

import java.util.Scanner;
public class UserActions {
public static User userLogin(Scanner s){
        System.out.print("Enter the user Id:");
        String userName = s.nextLine();
        System.out.print("Enter the User Pin:");
        String adminPin=s.nextLine();
        for(User user:ATM.getUsers()){
            if(user.getUserId().equals(userName)&&user.getUserPin().equals(adminPin)){
                return user;
            } else if (user.getUserId().equals(userName)&& !user.getUserPin().equals(adminPin)) {
                User user1=new User(null,null);
                return user1;
            }
        }
        return null;
    }
    public static void changepin(Scanner s,User currentUser){
            System.out.print("Enter the pin to be changed:");
            String changePin = s.nextLine();
            currentUser.setUserPin(changePin);
            System.out.println("The Pin has been changed successfully");
    }
    public static void depositMoney(Scanner s,User currentUser){
        System.out.println("Enter the amount to be deposited:");
        long depositMoney = Long.parseLong(s.nextLine());
        System.out.println("Enter the number of two Thousand notes:");
        long Notes2000 = Long.parseLong(s.nextLine());
        System.out.println("Enter the number of two Five Hundred notes:");
        long Notes500 = Long.parseLong(s.nextLine());
        System.out.println("Enter the number of Two Hundred notes:");
        long Notes200 = Long.parseLong(s.nextLine());
        System.out.println("Enter the number of One hundred notes:");
        long Notes100 = Long.parseLong(s.nextLine());
        long totalAmount = Notes2000 * 2000 + Notes500 * 500 + Notes200 * 200 + Notes100 * 100;
        if (depositMoney == totalAmount) {
            for (Notes notes : ATM.getNotes()) {
                String amount = notes.getNote();
                switch (amount) {
                    case "2000":
                        notes.setCount(notes.getCount() + Notes2000);
                        break;
                    case "500":
                        notes.setCount(notes.getCount() + Notes500);
                        break;
                    case "200":
                        notes.setCount(notes.getCount() + Notes200);
                        break;
                    case "100":
                        notes.setCount(notes.getCount() + Notes100);
                        break;
                }
            }
                currentUser.setBalance(currentUser.getBalance() + depositMoney);
                ATM.setBalance(ATM.getBalance() + depositMoney);
                System.out.println("The amount of ruppees " + depositMoney + " has been successfully credited");
                System.out.println("Your balance:" + currentUser.getBalance());
                System.out.println("Your current ATM balance:" + ATM.getBalance());
                currentUser.getTransactions().add(new Transactions("Admin", "Deposited", depositMoney));
        }
        else{
            System.out.println("Wrong denomination");
        }
    }
    public static void viewBalance(User currentUser){
        System.out.println("The current Balance of"+currentUser.getUserId()+"is"+currentUser.getBalance());
    }
    public static void withDrawMoney(Scanner s,User currentUser) {
        System.out.println("Enter the amount to be WithDraw:");
        long withDrawMoney=Long.parseLong(s.nextLine());
        if(withDrawMoney<=ATM.getBalance() && withDrawMoney<=currentUser.getBalance()){
            currentUser.setBalance(currentUser.getBalance()-withDrawMoney);
            ATM.setBalance(ATM.getBalance()-withDrawMoney);
            System.out.println("The current balance of "+currentUser.getUserId() +" is "+currentUser.getBalance());
            System.out.println("The current balance of ATM: "+ATM.getBalance());
            System.out.println("The amount of "+withDrawMoney+" has been withdrawn");
            currentUser.getTransactions().add(new Transactions(currentUser.getUserId(), "withdrawn",withDrawMoney));
            return;
        }
            System.out.println("The ATM balance is insufficient");
    }
    public static void viewUserTransaction(User currentUser){
    for(Transactions transactions:currentUser.getTransactions()){
        System.out.println(transactions.getName()+" has "+transactions.getTransaction()+" amount of "+transactions.getBalance());
        return;
    }
        System.out.println("No Transactions done");
    }
}
