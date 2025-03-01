package ATM;

import ATM.Interfaces.AdminActionInterface;
import ATM.Notes.Note;
import ATM.Notes.Notes;

import java.util.Scanner;

public  class AdminAction implements AdminActionInterface {
    public  Accounts login() {
        Scanner s= new Scanner(System.in);
        System.out.print("Enter the Admin id:");
        String adminId = s.nextLine();
        System.out.print("Enter the Admin Pin:");
        String adminPin = s.nextLine();
        for (Accounts admin : ATM.getAccounts()) {//loops the admin array list
            if (admin instanceof Admin) {
                if (admin.getUserId().equals(adminId) && admin.getPin().equals(adminPin)) {//checks the entered admin id and pin
                    return admin;// returns the admin object if the condition is true
                } else if (admin.getUserId().equals(adminId) && !admin.getPin().equals(adminPin)) {//this is condition block if the entered pin is wrong
                    System.out.println("Wrong pin");
                    Admin admin1 = new Admin(null, null);//sets the admin id and pin object as null
                    return admin1;
                }
            }
        }
        return null;
    }

    public  void addUser() {
        Scanner s= new Scanner(System.in);
        System.out.print("Enter the user to be added:");
        String userIdToAdd = s.nextLine();//enters the user id to add
        System.out.print("Enter the user pin:");
        String userPinToAdd = s.nextLine();//enters the user pin to add
        User user1 = new User(userIdToAdd, userPinToAdd, 0);//creates an object for user and the id and pin is passed as parameter
        ATM.getAccounts().add(user1);//add the user object to the arraylist
        System.out.println("User added successfully");
    }

    public  void deleteUser() {
        Scanner s= new Scanner(System.in);
        for (Accounts user : ATM.getAccounts()) {
            if (user instanceof User) {//checks user is the object of the class User
                System.out.println("->" + user.getUserId());
            }
        }
        System.out.print("Enter the user to be deleted:");
        String userToDelete = s.nextLine();
        for (Accounts users : ATM.getAccounts()) {//loops the user arraylist
            if (users instanceof User) {
                if (users.getUserId().equals(userToDelete)) {//checks the given username is available in arraylist
                    ATM.getAccounts().remove(users);//removes the user
                    System.out.println("Successfully deleted");
                    return;
                }
            }
        }
        System.out.println("User not found!!");
    }

    public  void depositMoney( Accounts currentAccount) {
        Scanner s = new Scanner(System.in);
        Admin currentAdmin = null;
        if(currentAccount instanceof Admin){
            currentAdmin = (Admin) currentAccount;
        }
        System.out.println("Enter the amount to be deposited:");
        long depositAmount = Long.parseLong(s.nextLine());//enters money to deposit
        System.out.print("Enter the count of 2000 notes:");
        long note2k = Long.parseLong(s.nextLine());// number of 2000 rupee note
        System.out.print("Enter the count of 500 notes:");
        long note5h = Long.parseLong(s.nextLine());// number of 500 rupee note
        System.out.print("Enter the count of 200 notes:");
        long note2h = Long.parseLong(s.nextLine());// number of 200 rupee note
        System.out.print("Enter the count of 100 notes:");
        long note1h = Long.parseLong(s.nextLine());// number of 100 rupee note
        long denominationAmount = 2000 * note2k + 500 * note5h + 200 * note2h + 100 * note1h;//calculates  all the amount of each rupee note
        if (depositAmount == denominationAmount) {//checks calculated amount and deposited amount
            System.out.println("Denomination successfully done!!");
            for (Notes notes : ATM.getNotesArray().getArr()) {//enhanced for loop to check each notes in ATM
                String noteObj = notes.getNote();//stores  each note in the note variable
                switch (noteObj) {//switch case to set the note count for each note
                    case "2000":
                        notes.setCount(notes.getCount() + note2k);
                    case "500":
                        notes.setCount(notes.getCount() + note5h);
                    case "200":
                        notes.setCount(notes.getCount() + note2h);
                    case "100":
                        notes.setCount(notes.getCount() + note1h);
                }
            }
            ATM.setBalance(ATM.getBalance() + depositAmount);//sets the ATM balance
            System.out.println("The current balance of ATM:" + ATM.getBalance());//prints the ATM balance
            currentAdmin.getTransactions().add(new Transactions("deposited", depositAmount, currentAdmin.getUserId()));//adds the object of Transaction
        } else {
            System.out.println("Wrong denomination");
        }
    }

    public  void viewTransaction(Admin currentAdmin) {
        Scanner s= new Scanner(System.in);
        System.out.println("View Transactions of\n1.Admin\n2.User\n3.All");
        int transactionOption = Integer.parseInt(s.nextLine());//enters the option to view the transaction
        switch (transactionOption) {
            case 1:
                if (!currentAdmin.getTransactions().isEmpty()) {
                    System.out.println("The transactions are:");
                    for (Transactions transactions : currentAdmin.getTransactions()) {//loops the admin transaction
                        System.out.println(transactions.getName() + " has " + transactions.getTypeOfTransaction() + " the amount of " + transactions.getBalanceAmount());//prints the admin transaction
                    }
                    return;
                }
                System.out.println("No Admin Transaction");
                break;
            case 2://transaction for the specific user
                for (Accounts user : ATM.getAccounts()) {// Print all user IDs
                    if (user instanceof User) {
                        System.out.println("->" + user.getUserId());
                    }
                }
                System.out.println("Enter the user name to see transactions:");
                String userName = s.nextLine();
                boolean transactionFound = false;

                for (Accounts user : ATM.getAccounts()) {//loops through all users to find a match
                    if (user instanceof User) {
                        // Check if the user ID matches the input
                        if (user.getUserId().equals(userName)) {
                            boolean hasTransactions = false;
                            // Iterate through transactions for the matched user
                            for (Transactions transaction : user.getTransactions()) {
                                System.out.println("The transaction of " + user.getUserId() + " has "
                                        + transaction.getTypeOfTransaction() + " the amount of "
                                        + transaction.getBalanceAmount());
                                hasTransactions = true;
                            }
                            if (!hasTransactions) {
                                System.out.println("No transactions found for user: " + user.getUserId());
                            }
                            transactionFound = true;
                        }
                    }
                }

// If no transaction found, inform the user
                if (!transactionFound) {
                    System.out.println("No user found with the name: " + userName);
                }
                if(!transactionFound){
                    System.out.println("No user found!!");
                    return;
                }
                break;
            case 3:
                for (Accounts admin : ATM.getAccounts()) {
                    if (admin instanceof Admin) {
                        for (Transactions transactions : currentAdmin.getTransactions()) {//loops for admin transaction
                            System.out.println(currentAdmin.getUserId() + " has " + transactions.getTypeOfTransaction() + " the amount of " + transactions.getBalanceAmount());
                        }
                    }
                }
                for (Accounts user : ATM.getAccounts()) {//loops all the user transaction and prints
                    if (user instanceof User) {
                        for (Transactions transactions : user.getTransactions()) {
                            System.out.println("The transaction of " + user.getUserId() + " has " + transactions.getTypeOfTransaction() + " the amount of " + transactions.getBalanceAmount());
                        }
                    }
                }
        }
    }
}
