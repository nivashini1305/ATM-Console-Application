package ATM;

import java.util.Scanner;

public class ATMActions {

    public static void start() throws CloneNotSupportedException {
        Scanner s = new Scanner(System.in);
        Admin admin = new Admin("admin", "123");//sets the admin name and pin
        ATM.getAdmin().add(admin);//the admin id and admin pin has been set to the admin's array list
        while (true) {//loop runs until the user chooses the exit option
            System.out.println("Choose the option \n1.Admin \n2.User\n3.Exit");
            int choice = Integer.parseInt(s.nextLine());//user should choose the option
            switch (choice) {
                case 1:
                    Admin currentAdmin = AdminAction.adminLogin(s);//if the user chooses the option 1,the admin login method calls and stores into a variable
                    if (currentAdmin == null) {//if the currentAdmin object returns null body of the loop executes
                        System.out.println("No admins found");
                        break;
                    } else if (currentAdmin.getAdminPin() == null) {//if the currentAdmin object's pin  returns null body of the loop executes
                        System.out.println("The entered credentials are wrong");
                        break;
                    } else { //if it returns admin object body of the loop executes
                        System.out.println("Login Successfully done...");
                        ATMActions.adminOperations(s,currentAdmin);//the adminOperation method wll be called
                        break;
                    }
                case 2:
                    User currentUser = UserActions.userLogin(s);//if the user chooses option 2,the user login method calls and stores it to a variable currentUser
                    if(currentUser==null){
                        System.out.println("No User found");
                        break;
                    }
                    else if (currentUser.getUserPin() == null) {
                        System.out.println("The entered credentials are wrong");
                        break;
                    } else {
                        System.out.println("Login successfully done");
                        ATMActions.userOperations(s,currentUser);//the userOperation method will be called
                        break;
                    }
                case 3:
                    System.out.println("Exitting");
                    System.exit(0);//if the user's option is 3,the start method will be exitted
                default:
                    System.out.println("Enter a valid input");
                    break;
            }
        }
    }
    public static void adminOperations(Scanner s,Admin currentAdmin) {// the adminOperation method has two object that has been passed
        while (true) {
            System.out.println("Enter the operations to do\n1.Add user\n2.Delete User\n3.Deposit Money\n4.View Transaction\n5.Log out");
            int operations = Integer.parseInt(s.nextLine());//Enters the admin options to do
            switch (operations) {
                case 1:
                    AdminAction.addUser(s);//calls the method to add a new user
                    break;
                case 2:
                    AdminAction.deleteUser(s);//calls the method to delete a user
                    break;
                case 3:
                    AdminAction.depositMoney(s,currentAdmin);//calls the method to deposit money
                    break;
                case 4:
                    AdminAction.viewTransaction(s,currentAdmin);//calls the method to view transaction
                    break;
                case 5:
                    System.out.println("Logging out");//method logs out
                    return;
                default:
                    System.out.println("Enter the valid options");
            }
        }
    }
    public static void userOperations(Scanner s,User currentUser) throws CloneNotSupportedException {// the userOperation method has two object that has been passed
        while (true){
            System.out.println("Enter the operations to do\n1.Withdraw Amount\n2.Deposit Amount\n3.Change Pin\n4.View Balance\n5.View User Transaction\n6.Logout");
            int operations =Integer.parseInt(s.nextLine());//enters the user operation to do
            switch (operations){
                case 1:
                    UserActions.withDrawMoney(s,currentUser);//calls the method to withdraw amount
                    break;
                case 2:
                    UserActions.depositMoney(s,currentUser);//calls the method to deposit amount
                    break;
                case 3:
                    UserActions.changepin(s,currentUser);//calls the method to change pin
                    break;
                case 4:
                    UserActions.viewBalance(currentUser);//calls the method to view balance
                    break;
                case 5:
                    UserActions.viewUserTransaction(currentUser);//calls the method to view transactions
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
            }
        }
    }
}