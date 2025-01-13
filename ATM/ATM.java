package ATM;
import ATM.Notes.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ATM {
        static ArrayList<User>  user = new ArrayList<>();
        static ArrayList<Admin> admin = new ArrayList<>();
        static ArrayList<Notes> notes = new ArrayList<>(Arrays.asList(new TwoThousand("2000",0),new FiveHundred("500",0),new TwoHundred("200",0),new OneHundred("100",0)));

        private static long balance;
        public static ArrayList<Admin> getAdmin() {
            return admin;
        }
        public static ArrayList<User> getUsers() {
            return user;
        }
        public static void setBalance(long balance){
            ATM.balance=balance;
        }
        public static long getBalance(){
            return balance;
        }
        public static ArrayList<Notes> getNotes(){
            return notes;
        }
    }



