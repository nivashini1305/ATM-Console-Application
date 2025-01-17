package ATM;

import ATM.ListOfNotes.FiveHundred;
import ATM.ListOfNotes.OneHundred;
import ATM.ListOfNotes.TwoHundred;
import ATM.ListOfNotes.TwoThousand;
import ATM.Notes.Notes;

import java.util.ArrayList;
import java.util.Arrays;

public class ATM {
    private static ArrayList<Accounts> accounts= new ArrayList<>();
    private static ArrayList<Notes> notes= new ArrayList<>(Arrays.asList(new TwoThousand("2000",0),new FiveHundred("500",0),new TwoHundred("200",0),new OneHundred("100",0)));//Arraylist for Notes and initialises the value by creating object
    private static long balance;//declares the balance variable
    //getter and setter methods

    public static ArrayList<Accounts> getAccounts() {
        return accounts;
    }
    public static void setNotes(ArrayList<Notes> notes){
        ATM.notes=notes;
    }
    public static ArrayList<Notes> getNotes(){
        return notes;
    }
    public static void setBalance(long balance){
        ATM.balance=balance;
    }
    public static long getBalance(){
        return balance;
    }
}
