package ATM;
import java.util.Scanner;
public class Admin {
    Scanner s = new Scanner(System.in);
    private static final String Admin_id= "10987";
    private static final String Admin_pin = "1234";
    public static String getAdmin_id(){
        return Admin_id;
    }
    public static String getAdmin_pin(){
        return Admin_pin;
    }
}
