import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

class Bank{
    private double currentbalance;
    private String name;
    private int accountNumber;

    public Bank(double currentbalance, String name, int accountNumber){
        this.currentbalance = currentbalance;
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public void customerinfo(ResourceBundle rb, NumberFormat nf){
        System.out.println("-------------------------------------");
        System.out.println("\n" + rb.getString("customerName") + " "+ this.name );
        System.out.println("\n" + rb.getString("customerAccountNumber") + " " +  this.accountNumber);
        System.out.println("\n" + rb.getString("currentBalance") + " " + nf.format(this.currentbalance));
    }

    public void depositMoney(double amount, ResourceBundle rb) {
        currentbalance += amount;
        System.out.println("\n" + rb.getString("depositSuccess"));
    }

    public void withdrawMoney(double amount, ResourceBundle rb) {
        if (amount > currentbalance) {
            System.out.println("\n" + rb.getString("insufficientFunds"));
            return;
        }
        currentbalance -= amount;
        System.out.println(rb.getString("withdrawSuccess"));
    }
    public void changeName(String newName){
        this.name = newName;
    }
}

public class BankProgram {
    public static void main(String[] args) {
        Locale language;
        ResourceBundle rb;
        Scanner sc = new Scanner(System.in);
        int choice;
        System.out.println("Enter your language preference : \nअपनी भाषा प्राथमिकता दर्ज करें : \n 1 for English \n 2 for Hindi ");
        choice = sc.nextInt();
        if (choice == 1) {
            language = Locale.of("en", "US");
        } else if (choice == 2) {
            language = Locale.of("hi", "IN");
        } else {
            System.out.println("Invalid Choice!");
            System.out.println("Default language English is selected");
            language = Locale.of("en", "US");
        }
        rb = ResourceBundle.getBundle("ResourceBundle", language);
        NumberFormat nf = NumberFormat.getCurrencyInstance(language);
        System.out.println("\n----------------------------\n");
        sc.nextLine();
        System.out.println(rb.getString("enterName"));
        String name = sc.nextLine();
        System.out.println(rb.getString("enterAccountNumber"));
        int accountnumber = sc.nextInt();
        Bank customer = new Bank(2000,name,accountnumber);
        int num;
        do {
            System.out.println("\n----------------------------\n");
            System.out.println(rb.getString("menuCheckInfo"));
            System.out.println(rb.getString("menuDepositMoney"));
            System.out.println(rb.getString("menuWithdrawMoney"));
            System.out.println(rb.getString("changeName"));
            System.out.println(rb.getString("menuExit"));
            num = sc.nextInt();
            switch (num) {
                case 1 -> customer.customerinfo(rb, nf);
                case 2 -> {
                    System.out.print(rb.getString("promptDepositAmount"));
                    double deposit = sc.nextDouble();
                    if (deposit <= 0) {
                        System.out.println(rb.getString("invalidAmount"));
                    } else {
                        customer.depositMoney(deposit, rb);
                    }
                }
                case 3 -> {
                    System.out.print(rb.getString("promptWithdrawAmount"));
                    double withdraw = sc.nextDouble();
                    if (withdraw <= 0) {
                        System.out.println(rb.getString("invalidAmount"));
                    }
                    customer.withdrawMoney(withdraw, rb);
                }
                case 4 ->{
                    System.out.println(rb.getString("newName"));
                    sc.nextLine();
                    String newname = sc.nextLine();
                    customer.changeName(newname);
                }
                case 0 -> System.out.println(rb.getString("exitMessage"));
                default -> System.out.println(rb.getString("invalidChoice"));
            }
        } while (num != 0);
    }
}

