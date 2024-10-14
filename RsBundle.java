import java.util.*;

public class RsBundle {
    public static void main(String[] args) {
        Locale locale;
        ResourceBundle rb;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose your language");
        System.out.println("Press 1 for English");
        System.out.println("Press 3 for Hindi");
        System.out.println("Press 3 for Japanese");
        int langChoice = sc.nextInt();
        if (langChoice == 1) {
            locale = new Locale("en", "US");
        } else if (langChoice == 2) {
            locale = new Locale("hi", "IN");
        } else if (langChoice == 3) {
            locale = new Locale("jp", "JP");
        } else {
            System.out.println("Invalid Choice. default using English");
            locale = new Locale("en", "US");
        }
        rb = ResourceBundle.getBundle("ResourceBundle", locale);

        System.out.println(rb.getString("getName"));;
    }

}
