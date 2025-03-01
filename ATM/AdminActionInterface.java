package ATM;

import ATM.Notes.Note;

import java.util.Scanner;

public interface AdminActionInterface extends Actions{

     void addUser(Scanner s);
    void deleteUser(Scanner s);
     void viewTransaction(Scanner s, Admin currentAdmin);

}
