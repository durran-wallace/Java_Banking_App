package bankingApp;

public interface AccountInterface {
    void withdrawal(double amount);
    void deposit(double amount);
    double balance();
}