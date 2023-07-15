import javax.sound.midi.Soundbank;
import java.util.*;

public class Main {

    public static List<User> userList = new ArrayList<>();
    public static Map<String, String> Users = new HashMap<>();

    private static void Interface(){
        System.out.println();
        System.out.println();
        System.out.println("------------------------------------------------");
        System.out.println("|                 ATM INTERFACE                |");
        System.out.println("------------------------------------------------");
        System.out.println("| 1. ACCOUNT DETAILS                           |");
        System.out.println("| 2. WITHDRAW                                  |");
        System.out.println("| 3. DEPOSIT                                   |");
        System.out.println("| 4. TRANSFER                                  |");
        System.out.println("| 5. TRANSACTION HISTORY                       |");
        System.out.println("| 6. EXIT                                      |");
        System.out.println("| 7. LOGOUT                                    |");
        System.out.println("------------------------------------------------");
        System.out.println("Please select any function of ATM: ");
    }
    private static void modeInterface(){
        System.out.println("------------------------------------------------");
        System.out.println("|               SELECT USER MODE               |");
        System.out.println("------------------------------------------------");
        System.out.println("|                                              |");
        System.out.println("|         1. New User (Sign Up)                |");
        System.out.println("|         2. Login                             |");
        System.out.println("|                                              |");
        System.out.println("------------------------------------------------");
        System.out.println("Select User Mode: ");
    }
    private static void logout(){
        System.out.println("Successfully Logged Out!!");
        main(null);
    }
    private static void showAccountDetails(User user){
        System.out.println("ACCOUNT DETAILS");
        System.out.println("Username: "+user.getUsername());
        System.out.println("Balance: ₹"+user.getBalance());
    }
    private static void interfaceHandler(User user){
        Scanner sc = new Scanner(System.in);
        int function = sc.nextInt();
        sc.nextLine();

        switch (function){
            case 1:
                showAccountDetails(user);
                break;
            case 2:
                System.out.println("Withdraw Amount: ₹");
                double withdrawAmount = sc.nextDouble();
                user.withdraw(withdrawAmount);
                break;
            case 3:
                System.out.println("Deposit Amount: ₹");
                double depositAmount = sc.nextDouble();
                user.deposit(depositAmount);
                break;
            case 4:
                System.out.println("Eneter Transfering Details");
                System.out.println("To: ");
                String to = sc.nextLine();
                User toUser = findUserByUsername(userList, to);
                if(toUser != null){
                    System.out.println("Enter Transfer Amount: ₹");
                    double transferAmount = sc.nextDouble();
                    user.transfer(toUser, transferAmount);
                }
                else
                    System.out.println("User not found!!");
                break;
            case 5:
                user.showTransactionHistory(user);
                break;
            case 6:
                System.out.println("Thankyou for using the ATM services");
                return;
            case 7:
                logout();
                return;
        }
        Interface();
        interfaceHandler(user);
    }
    private static User findUserByUsername(List<User> users, String username){
        for(User user: users){
            if(user.getUsername().equals(username))
                return user;
        }
        return null;
    }
    private static User findUser(List<User> users, String username, String pass){
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(pass))
                return user;
        }
        return null;
    }
    private static User authenticateUser(){

        Scanner sc = new Scanner(System.in);
        User user = null;
        do {
            System.out.println("Enter Username: ");
            String username = sc.nextLine();
            System.out.println("Enter Password");
            String pass = sc.nextLine();
            user = findUser(userList, username, pass);

            if (user == null){
                System.out.println("Invalid password or username!!");
                System.out.println("Please Try Again");
            }
        }while (user == null);

        return user;
    }
    private static void signUp(String user,String pass){
        userList.add(new User(user, pass, 5000));
    }
    private static void modeHandle(){
        String user, pass;
        Scanner sc = new Scanner(System.in);
        modeInterface();
        int userMode = sc.nextInt();
        sc.nextLine();

        switch (userMode){
            case 1:
                System.out.println("Enter Username: ");
                user = sc.nextLine();
                System.out.println("Enter Password: ");
                pass = sc.nextLine();
                signUp(user, pass);
                System.out.println("NEW ACCOUNT CREATED!!");
                return;
            case 2:
                System.out.println();
                System.out.println();
                System.out.println("------------------------------------------------");
                System.out.println("|                                              |");
                System.out.println("|                                              |");
                System.out.println("|           USERNAME:____________              |");
                System.out.println("|           PASSWORD:____________              |");
                System.out.println("|                                              |");
                System.out.println("|                                              |");
                System.out.println("------------------------------------------------");
                break;
            default:
                System.out.println("Invalid Input");
                System.out.println("Enter 1 for Sign up & 2 for Login");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        modeHandle();
        sc.nextLine();
        User user = authenticateUser();
        if (( user!=null )){
            System.out.println("You are now Logged in!!");
            Interface();
            interfaceHandler(user);
        }
    }

}