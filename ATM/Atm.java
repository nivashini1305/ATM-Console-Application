package ATM;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Atm {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Are u a user or admin\n1.USER\n2.ADMIN");
            int input = s.nextInt();
            if (input == 2) {
                System.out.println("Enter Admin id:");
                String input_id = s.next();
                if (input_id.equals(Admin.getAdmin_id())) {
                    int i = 0;
                    while (i <= 2) {
                        System.out.println("Enter Admin pin:");
                        String input_pin = s.next();
                        if (input_pin.equals((Admin.getAdmin_pin()))) {

                            Admin admin = new Admin();
//                            admin.print();
                        } else {
                            System.out.println("Wrong pin");
                            i++;
                        }
                    }
                }
                else {
                    System.out.println("Wrong id");
                }
//            else {
//                System.out.println("Invalid input");
            }

        }
    }
}


