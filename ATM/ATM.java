package ATM;

import ATM.ListOfNotes.FiveHundred;
import ATM.ListOfNotes.OneHundred;
import ATM.ListOfNotes.TwoHundred;
import ATM.ListOfNotes.TwoThousand;
import ATM.Notes.Note;
import ATM.Notes.Notes;

import java.util.ArrayList;
import java.util.Arrays;

public class ATM {
    private static ArrayList<Accounts> accounts= new ArrayList<>();//creates arraylist for accounts

    private static long balance;//declares the balance variable
    private static Note<Notes> notesArray= new Note<>();
    //getter and setter methods
    public static Note<Notes> getNotesArray() {
        return notesArray;
    }
    public static void setNotesArray(Note<Notes> notesArray) {
        ATM.notesArray = notesArray;
    }
    public static ArrayList<Accounts> getAccounts() {
        return accounts;
    }

    public static void setBalance(long balance){
        ATM.balance=balance;
    }
    public static long getBalance(){
        return balance;
    }
}
