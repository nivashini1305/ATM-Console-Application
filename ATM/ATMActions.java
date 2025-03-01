package ATM;
import ATM.ListOfNotes.TwoHundred;
import ATM.ListOfNotes.FiveHundred;
import ATM.ListOfNotes.TwoThousand;
import ATM.ListOfNotes.OneHundred;
import ATM.Notes.Notes;
import ATM.Notes.Note;

import java.util.Scanner;
public class ATMActions {
    public static void start() throws CloneNotSupportedException {
       Notes twoThousand= new TwoThousand("2000",0);
       Notes fiveHundred=new FiveHundred("500",0);
       Notes twohundred= new TwoHundred("200",0);
       Notes hundred=  new OneHundred("100",0);
       Note note = new Note();
       note.add(twohundred);
       note.add(twoThousand);
       note.add(hundred);
       note.add(fiveHundred);
        Scanner s = new Scanner(System.in);
        Admin admin=new Admin("admin","123");//sets the admin name and pin
        AdminAction adminAction = new AdminAction();
        UserActions userActions = new UserActions();
        ATM.getAccounts().add(admin);//the admin id and admin pin has been set to the admin's array list
        while (true){//while loop which is executed until the user exits
            System.out.println("Do you want Login as \n1.Admin\n2.User\n3.Exit");
            int loginOption = Integer.parseInt(s.nextLine());
            switch (loginOption){
                case 1:
                    Accounts currentAdmin=adminAction.adminLogin(s);//if the option is 1,the admin login method calls and stores the return object into a variable
                    if(currentAdmin == null){//if the currentAdmin object returns null body of the loop executes
                        System.out.println("Invalid credentials...Enter correctly");
                        break;
                    } else if (currentAdmin.getPin()==null) {//if the currentAdmin object's pin  returns null body of the loop executes
                        System.out.println("Enter the pin correctly");
                        break;

                    } else{//if it returns admin object body of the loop executes
                        System.out.println("Login successfull");
                        ATMActions.adminOperations(s,currentAdmin,note);//the adminOperation method will be called
                        break;
                    }
                case 2:
                    Accounts currentUser=userActions.userLogin(s);//if the user chooses option 2,the user login method calls and stores it to a variable currentUser
                    if(currentUser==null){
                        System.out.println("The given credentials are wrong...Enter correctly");
                        break;
                    } else if (currentUser.getPin()==null) {
                        break;
                    }
                    else {
                        System.out.println("Login Successfull");
                        ATMActions.userOperations(s,(User) currentUser,note);//the userOperation method will be called
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
        public static void adminOperations(Scanner s,Accounts currentAdmin,Note note){
        AdminAction adminAction= new AdminAction();
        while(true){
            System.out.println("Choose the Operations to do...\n1.Add User\n2.Delete User\n3.Deposit Amount\n4.View Transactions\n5.Log out");
            int adminOperations=Integer.parseInt(s.nextLine());//Enters the admin options to do
            switch (adminOperations){
                case 1:
                    adminAction.addUser(s);//calls the method to add a new user
                    break;
                case 2:
                    adminAction.deleteUser(s);//calls the method to delete a user
                    break;
                case 3:
                    adminAction.depositMoney(s,currentAdmin,note);//calls the method to deposit money
                    break;
                case 4:
                    adminAction.viewTransaction(s,(Admin) currentAdmin);//calls the method to view transaction
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
        public static void userOperations(Scanner s,Accounts currentUser,Note note) throws CloneNotSupportedException {// the userOperation method has two object that has been passed
        UserActions userActions=new UserActions();
        while (true){
            System.out.println("Choose the operations to do...\n1.Deposit amount\n2.Withdraw amount\n3.View balance\n4.Change pin\n5.View Transactions\n6.Log out");
            int userOperations=Integer.parseInt(s.nextLine());//enters the user operation to do
            switch (userOperations){
                case 1:
                    userActions.depositAmount(s,currentUser,note);//calls the method to deposit amount
                    break;
                case 2:
                    userActions.withDrawAmount(s,(User) currentUser,note);//calls the method to withdraw amount
                    break;
                case 3:
                    userActions.viewBalance((User) currentUser);//calls the method to view balance
                    break;
                case 4:
                    userActions.changePin(s,(User) currentUser);//calls the method to change pin
                    break;
                case 5:
                    userActions.viewTransaction(s,(User) currentUser);//calls the method to view transactions
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
