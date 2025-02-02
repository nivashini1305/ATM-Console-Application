package ATM;
import ATM.Notes.Notes;

import java.util.Scanner;

public class AdminAction{
    public static Admin adminLogin(Scanner s){
        System.out.print("Enter the admin Id:");
        String adminName = s.nextLine();
        System.out.print("Enter the admin pin:");
        String adminPin=s.nextLine();
        for(Admin admin:ATM.getAdmin()){
            if(admin.getAdminName().equals(adminName)&&admin.getAdminPin().equals(adminPin)){
                return admin;
            } else if (admin.getAdminName().equals(adminName)&& !admin.getAdminPin().equals(adminPin)) {
                Admin admin1=new Admin(null,null);
                return admin1;
            }
        }
        return null;
    }
    public static void  addUser(Scanner s){
        System.out.print("Enter the user to be added:");
        String userName = s.nextLine();
        System.out.print("Enter the user pin:");
        String userPin = s.nextLine();
        User user = new User(userName,userPin);
        ATM.getUsers().add(user);
        System.out.println("User successfully added");
    }
    public static void deleteUser(Scanner s){
        System.out.println("The availabe users are:");
        for(User user:ATM.getUsers()){
            System.out.println("->"+user.getUserId());
        }
        System.out.println("Enter the user to be deleted:");
        String deleteUser = s.nextLine();
        for(User users:ATM.getUsers()){
            if(users.getUserId().equals(deleteUser)){
                ATM.getUsers().remove(users);
                System.out.println("Successfully deleted");
                return;
            }
        }
        System.out.println("No users found");
    }
    public static void depositMoney(Scanner s,Admin currentAdmin) {
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
                ATM.setBalance(ATM.getBalance() + depositMoney);
                System.out.println("The amount of ruppees " + depositMoney + " has been successfully credited");
                System.out.println("Your current balance:" + ATM.getBalance());
                currentAdmin.getAdminTransactions().add(new Transactions("Admin", "Deposited", depositMoney));
        }
        else{
            System.out.println("Wrong denominations");
        }
    }
    public static void viewTransaction(Scanner s,Admin currentAdmin){
        System.out.println("View Transaction of\n1.Admin\n2.User\n3.All");
        int transactionOption=Integer.parseInt(s.nextLine());
        switch (transactionOption){
            case 1:
                for(Transactions transactions:currentAdmin.getAdminTransactions()){
                    System.out.println("The admin transactions are...");
                    System.out.println("The "+transactions.getName()+" has "+transactions.getTransaction()+" amount of "+transactions.getBalance());
                }
                System.out.println("No Transactions found");
                break;
            case 2:
                for(User users:ATM.getUsers()) {
                    System.out.println("->" + users.getUserId());
                }
                    for(User user:ATM.getUsers()) {
                        System.out.println("Enter the user name to show the transaction:");
                        String nameOftheUser= s.nextLine();
                        if (nameOftheUser.equals(user.getUserId())) {
                            for (Transactions userTransaction : user.getTransactions()) {
                                System.out.println("The transacations of " + userTransaction.getName() + " has " + userTransaction.getTransaction() + " amount of " + userTransaction.getBalance());
                            }
                            System.out.println("No transaction found");
                            return;
                        }

                    }
                System.out.println("Invalid user name");
            case 3:
                for(Transactions transactions:currentAdmin.getAdminTransactions()){
                    System.out.println("The admin transactions are...");
                    System.out.println("The "+transactions.getName()+" has "+transactions.getTransaction()+" amount of "+transactions.getBalance());
                }
                for(User user:ATM.getUsers()) {
                    for (Transactions userTransaction : user.getTransactions()) {
                        System.out.println("The transacations of the user " +userTransaction.getName()+" has "+userTransaction.getTransaction()+" the amount of " +userTransaction.getBalance());
                    }
                    System.out.println("No transactions done");
                    return;
                }
                System.out.println("No Transactions found");
        }
    }
}
