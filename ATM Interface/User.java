import java.util.ArrayList;
import java.util.List;

public class User {
    public List<User> userList = new ArrayList<>();
    public String username;
    public String password;
    private double Balance;
    private List<String> transcationHistory;
    public User(String user, String pass, double balance){
        this.username=user;
        this.password=pass;
        this.Balance=balance;
        this.transcationHistory = new ArrayList<>();
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public double getBalance(){
        return Balance;
    }
    public void withdraw(double amount){
        Balance-=amount;
        String transcation = "Withdraw: ₹" + amount;
        transcationHistory.add(transcation);
    }
    public void deposit(double amount){
        Balance+=amount;
        String transaction = "Deposit: ₹" + amount;
        transcationHistory.add(transaction);
    }
    public void transfer(User to, double amount){
        Balance-=amount;
        to.Balance+=amount;
        String transaction = "Transfer to " + to.getUsername() + ": ₹" + amount;
        transcationHistory.add(transaction);
        transaction = "Transaction from " + username + ": ₹" +amount;
        to.transcationHistory.add(transaction);
    }
    public void showTransactionHistory(User user){
        System.out.println("Transaction History,");
        for(String transaction : transcationHistory)
            System.out.println(transaction);
    }
}
