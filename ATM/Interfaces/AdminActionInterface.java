package ATM.Interfaces;
import ATM.Admin;
public interface AdminActionInterface extends Actions {
    public void addUser();
    public void deleteUser();
    public void viewTransaction(Admin currentAdmin);

}
