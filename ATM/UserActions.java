package ATM;
import ATM.Notes.Notes;

import java.util.ArrayList;
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
                currentUser.getTransactions().add(new Transactions(currentUser.getUserId(), "Deposited", depositMoney));
        }
        else{
            System.out.println("Wrong denomination");
        }
    }
    public static void viewBalance(User currentUser){
        System.out.println("The current Balance of"+currentUser.getUserId()+"is"+currentUser.getBalance());
    }
    public static long performWithdraw(long withdrawAmount,Notes notes,ArrayList<String> denomination ){
            long Note = Long.parseLong(notes.getNote());
            long noteCount = withdrawAmount/Note;

            if(withdrawAmount>=Note && 0 < notes.getCount()){
                if(noteCount<=notes.getCount()){
                    long  AmountToWithdraw = withdrawAmount-noteCount*Note;
                    notes.setCount(notes.getCount()-noteCount);
                    denomination.add("You got "+noteCount+" "+notes.getNote()+" Notes");
                    return AmountToWithdraw;
                }
                else {
                    long AmountToWithDraw=withdrawAmount-Note*notes.getCount();
                    denomination.add("You got "+notes.getCount()+" "+notes.getNote()+" Notes");
                    notes.setCount(0);
                    return AmountToWithDraw;
                }
            }
            return withdrawAmount;
    }
    public static void withDrawMoney(Scanner s,User currentUser) throws CloneNotSupportedException {
         ArrayList<Notes> duplicate = new ArrayList<>();
         ArrayList<String> denomination = new ArrayList<>();
         System.out.println("Enter the amount to be withdraw: ");
         long withdrawAmount = Long.parseLong(s.nextLine());
         if(withdrawAmount<=ATM.getBalance()){
            if(withdrawAmount<= currentUser.getBalance()) {
                long duplicateWithDrawAmount = withdrawAmount;
                for (Notes notes : ATM.getNotes()) {
                    duplicate.add((Notes) notes.clone());
                }
                while (withdrawAmount != 0) {
                    for (Notes notesAmount : duplicate) {
                        String notes = notesAmount.getNote();
                        switch (notes) {
                            case "2000", "500", "200", "100":
                               withdrawAmount = UserActions.performWithdraw(withdrawAmount, notesAmount, denomination);
                                break;
                        }
                    }
                    if (withdrawAmount == 0) {
                        ATM.setNotes(duplicate);
                        currentUser.setBalance(currentUser.getBalance() - duplicateWithDrawAmount);
                        ATM.setBalance(ATM.getBalance()-duplicateWithDrawAmount);
                        for(String showAmount:denomination){
                            System.out.println(showAmount);
                        }
                        System.out.println("Your current balance: "+currentUser.getBalance());
                        currentUser.getTransactions().add(new Transactions(currentUser.getUserId(), "Withdrawn",withdrawAmount));
                        return;
                    } else {
                        System.out.println("Wrong denomination...Enter another Amount");
                        break;
                    }
                }
            }
            System.out.println("Insufficient user balance");
            return;
        }
        System.out.println("Insufficient ATM balance");
    }
    public static void viewUserTransaction(User currentUser){
    for(Transactions transactions:currentUser.getTransactions()){
        System.out.println(transactions.getName()+" has "+transactions.getTransaction()+" amount of "+transactions.getBalance());
        return;
    }
        System.out.println("No Transactions done");
    }
}
