package ATM;
import ATM.Interfaces.UserActionInterface;
import ATM.Notes.Note;
import ATM.Notes.Notes;
import java.util.ArrayList;
import java.util.Scanner;

public  class UserActions implements UserActionInterface {
    public  Accounts login(){//method to login for user
        Scanner s= new Scanner(System.in);
        System.out.print("Enter the user id:");
        String userId=s.nextLine();
        System.out.print("Enter the user pin:");
        String userPin=s.nextLine();
        for(Accounts user:ATM.getAccounts()) {//Enhanced for loop takes each object in user arraylist
            if (user instanceof User) {
                if (user.getUserId().equals(userId) && user.getPin().equals(userPin)) {//checks user id and user pin with the object
                    return user;
                } else if (user.getUserId().equals(userId) && !user.getPin().equals(userPin)) {//If the user pin is wrong returns null in this else if block
                    System.out.println("Wrong pin");
                    User user1 = new User(null, null,0);
                    return user1;
                }
            }
        }
        return null;
    }
    public  void depositMoney(Accounts currentAccount){//method to deposit money by user
        Scanner s= new Scanner(System.in);
        User currentUser=null;
        if(currentAccount instanceof User){
            currentUser=(User) currentAccount;
        }

        System.out.println("Enter the amount to be deposited:");
        long depositAmount=Long.parseLong(s.nextLine());//enters money to deposit
        System.out.print("Enter the count of 2000 notes:");
        long note2k=Long.parseLong(s.nextLine());// number of 2000 rupee note
        System.out.print("Enter the count of 500 notes:");
        long note5h=Long.parseLong(s.nextLine());// number of 500 rupee note
        System.out.print("Enter the count of 200 notes:");
        long note2h=Long.parseLong(s.nextLine());// number of 200 rupee note
        System.out.print("Enter the count of 100 notes:");
        long note1h=Long.parseLong(s.nextLine());// number of 100 rupee note
        long denominationamount=2000*note2k+500*note5h+200*note2h+100*note1h;//calculates  all the amount of each rupee note
        if(depositAmount==denominationamount){//checks calculated amount and deposited amount
            System.out.println("Denomination successfully done!!");
            Note<Notes> newNote=ATM.getNotesArray();
            for(Notes notes:newNote.getArr()) {//enhanced for loop to check each notes in ATM
                String note = notes.getNote();//stores  each note in the note variable
                switch (note) {//switch case to set the note count for each note
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
                currentUser.setBalance(currentUser.getBalance()+depositAmount);//sets the user balance
                ATM.setBalance(ATM.getBalance()+depositAmount);//sets the ATM balance
                System.out.println("The current balance of your account:"+currentUser.getBalance());//prints the user balance
                System.out.println("The current balance of ATM:"+ATM.getBalance());//prints the ATM balance
                currentUser.getTransactions().add(new Transactions( "deposited", depositAmount, currentUser.getUserId()));//adds the object of Transaction
        }
        else {
            System.out.println("Wrong denomination");
        }
    }
    public  void withDrawAmount(User currentUser) throws CloneNotSupportedException {
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the amount to be withdraw:");
        long withDrawAmount = Long.parseLong(s.nextLine());//enters the amount to be withdrawn
        Note<Notes> duplicate = new Note<>();//creates a Note object to clone and store the updated notes instead of changing the original array list
        ArrayList<String> showNoteCount = new ArrayList<>();//arraylist for string to store the notes which will be given to the number of notes to be withdrawn
        if (withDrawAmount <= ATM.getBalance()) {//checks the withdrawal amount that should be less than ATM balance
            if (withDrawAmount <= currentUser.getBalance()) {//checks the withdrawal amount that should be less than current balance of user
                long amount = withDrawAmount;//stores the withdrawal to the variable
                for (Notes notes : ATM.getNotesArray().getArr()) {//loops the notes arraylist
                    duplicate.add((Notes)notes.clone());//clones the notes object and adds to the duplicate arraylist
                    }
                if (withDrawAmount!=0) {
                    for (Notes notes : duplicate.getArr()) {//loop for duplicate arraylist
                        String amountOfNote = notes.getNote();//stores each note in the amountOfNote
                        switch (amountOfNote) {
                            case "2000", "500", "200", "100":
                                withDrawAmount = performWithdraw(withDrawAmount, notes, showNoteCount);//calls the perform withdraw method for each object...for the first loop,the 2000 note goes and perform the perform withdraw method
                                break;
                        }
                    }
                    if (withDrawAmount == 0) {
                        ATM.setNotesArray(duplicate);//sets the duplicate arraylist to the original arraylist
                        currentUser.setBalance(currentUser.getBalance() - amount);//sets the user balance after withdrawal
                        ATM.setBalance(ATM.getBalance() - amount);//sets the ATM balance
                        for( String a:showNoteCount){
                            System.out.println(a);
                        }

                        System.out.println("Your current balance is:"+currentUser.getBalance());
                        System.out.println("Your current ATM balance is:"+ATM.getBalance());
                        currentUser.getTransactions().add(new Transactions("WithDraw", amount, currentUser.getUserId()));//adds the transaction as objects
                        return;
                    }
                    else {
                        System.out.println("No denomination...enter another amount");
                        return;
                    }
                }
                }
            System.out.println("Insufficient balance in your account");
            return;
            }
            System.out.println("Insufficient balance in ATM");
        }
        public  long performWithdraw(long withDrawAmount,Notes notes,ArrayList<String> showNoteCount){
        long note=Integer.parseInt(notes.getNote());//converts the string notes into long
        long count=withDrawAmount/note;//calculates the no.of note count  if the withdrawal amount is 4500...at the loop of first 2000 note...count = 4500(withdrawal amount)/2000(note)...now the count stores the value 2
                if(withDrawAmount >= note&&notes.getCount()>0){//checks the condition...withdraw amount should be greater than each note and count should be greater than 0
                    if(count<=notes.getCount()){//the calculated count should be less than notes
                      long withDrawAmount1=withDrawAmount-note*count;//the amount should be reduced by multiplying with the note and no.of notes For example...withDrawAmount1 = 4500(withdrawAmount)-2000(note)*2(count)...now the withDrawAmount1 stores 500
                      notes.setCount(notes.getCount()-count);//sets the note count
                      showNoteCount.add("You got "+count+" "+notes.getNote()+" note");//adds the no.of notes given to the arraylist of string object(showNoteCount)
                      return withDrawAmount1;
                  }
                   else{//this is the condition block when it has lesser number of notes than the expected no.of notes(count>=notes.getCount())
                      long withDrawAmount1=withDrawAmount-note*notes.getCount();//calculates the amount...withdrawAmount1=4500(withDrawAmount)-2000(note)*available note count in the arraylist(notes.getCount())
                      showNoteCount.add("You got "+notes.getCount()+" "+notes.getNote()+"notes");
                      notes.setCount(0);//sets the note count to 0...which means all the available notes was supplied
                      return withDrawAmount1;
                  }
            }
                return withDrawAmount;
        }
    public   void viewBalance(User currentUser){
        System.out.println("Your current Balance of your account is: "+currentUser.getBalance());//shows the current balance of the user
    }
    public  void changePin(User currentUser){
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the pin to be changed:");
        String changePin=s.nextLine();//gets the pin to be changed
        currentUser.setPin(changePin);//sets the new pin
        System.out.println("The pin has been changed successfully");
    }
    public  void viewTransaction(User currentUser){
        System.out.println("The transactions are...");
        for (Transactions transactions: currentUser.getTransactions()){//loops the arraylist of user transaction
            System.out.println(transactions.getName()+" has "+transactions.getTypeOfTransaction()+" amount of "+transactions.getBalanceAmount());//prints the transaction of specific user
        }

    }
}
