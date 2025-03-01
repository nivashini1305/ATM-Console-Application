package ATM;

import ATM.Notes.Note;

import java.util.Scanner;

public interface UserActionInterface extends Actions{
    void depositAmount(Scanner s, Accounts user, Note newNote);
    void withDrawAmount(Scanner s, User currentUser,Note note) throws CloneNotSupportedException;
    void viewBalance(User currentUser);
    void changePin(Scanner s,User currentUser);
    void viewTransaction(Scanner s,User currentUser);
}
