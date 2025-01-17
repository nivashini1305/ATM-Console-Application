package ATM;
import java.util.Scanner;
public class ATMActions {
    public static void start() throws CloneNotSupportedException {
        Scanner s = new Scanner(System.in);
        while (true){//while loop which is executed until the user exits
            System.out.println("Do you want Login as \n1.Admin\n2.User\n3.Exit");
            int loginOption = Integer.parseInt(s.nextLine());
            Admin admin=new Admin("admin","123");//sets the admin name and pin
            ATM.getAccounts().add(admin);//the admin id and admin pin has been set to the admin's array list
            switch (loginOption){
                case 1:
                    Accounts currentAdmin=AdminAction.adminLogin(s);//if the option is 1,the admin login method calls and stores the return object into a variable
                    if(currentAdmin == null){//if the currentAdmin object returns null body of the loop executes
                        System.out.println("Invalid credentials...Enter correctly");
                        break;
                    } else if (currentAdmin.getPin()==null) {//if the currentAdmin object's pin  returns null body of the loop executes
                        System.out.println("Enter the pin correctly");
                        break;

                    } else{//if it returns admin object body of the loop executes
                        System.out.println("Login successfull");
                        ATMActions.adminOperations(s,(Admin) currentAdmin);//the adminOperation method wll be called
                        break;
                    }
                case 2:
                    Accounts currentUser=UserActions.userLogin(s);//if the user chooses option 2,the user login method calls and stores it to a variable currentUser
                    if(currentUser==null){
                        System.out.println("The given credentials are wrong...Enter correctly");
                        break;
                    } else if (currentUser.getPin()==null) {
                        break;
                    }
                    else {
                        System.out.println("Login Successfull");
                        ATMActions.userOperations(s,(User) currentUser);//the userOperation method will be called
                        break;
                    }
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        }
        public static void adminOperations(Scanner s,Admin currentAdmin){
        while(true){
            System.out.println("Choose the Operations to do...\n1.Add User\n2.Delete User\n3.Deposit Amount\n4.View Transactions\n5.Log out");
            int adminOperations=Integer.parseInt(s.nextLine());//Enters the admin options to do
            switch (adminOperations){
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
                    System.out.println("Logging out...");//method logs out
                    return;
                default:
                    System.out.println("invalid input");
                    break;
            }
           }
        }
        public static void userOperations(Scanner s,User currentUser) throws CloneNotSupportedException {// the userOperation method has two object that has been passed
        while (true){
            System.out.println("Choose the operations to do...\n1.Deposit amount\n2.Withdraw amount\n3.View balance\n4.Change pin\n5.View Transactions\n6.Log out");
            int userOperations=Integer.parseInt(s.nextLine());//enters the user operation to do
            switch (userOperations){
                case 1:
                    UserActions.depositAmount(s,currentUser);//calls the method to deposit amount
                    break;
                case 2:
                    UserActions.withDrawAmount(s,currentUser);//calls the method to withdraw amount
                    break;
                case 3:
                    UserActions.viewBalance(currentUser);//calls the method to view balance
                    break;
                case 4:
                    UserActions.changePin(s,currentUser);//calls the method to change pin
                    break;
                case 5:
                    UserActions.viewTransaction(s,currentUser);//calls the method to view transactions
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
        }

}
