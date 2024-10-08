import java.util.*;
import java.text.*;

public class BillPrint {

    void properName(String name) {
        String arr[] = name.split(" ");
        String fname = arr[0].toLowerCase();
        String lname = arr[1].toLowerCase();
    }

    static String printTotal(Locale locale, double tot) {
        // NumberFormat nf = new NumberFormat();
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        return nf.format(tot);
    }

    static String printDate(Locale locale) {
        Date date = new Date();
        DateFormat dtf = DateFormat.getDateInstance(DateFormat.LONG, locale);
        return dtf.format(date);
    }

    public static void main(String[] args) {
        Locale locale = new Locale("hi", "IN");
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your name");
        String userName = sc.nextLine();
        userName.toCharArray();
        (char)22
        System.out.println("Product Name?");
        String prodName = sc.nextLine();
        System.out.println("Purchase Price?");
        double price = sc.nextDouble();
        System.out.println("Tax Paid in %?");
        double tax = sc.nextDouble();

        double taxPaid = price * (tax / 100);
        double netPrice = price - taxPaid;
        //aKshiT DaGAr --> Akshit Dagar (Proper Case)
        System.out.println("Hello, " + userName);
        System.out.println("You have bought :" + prodName + " on " + printDate(locale));
        System.out.println("Total Paid Price :" + printTotal(locale, price));
        System.out.println("Net Paid Price :" + printTotal(locale, netPrice));
        System.out.println("Tax Paid :" + printTotal(locale, taxPaid));
    }
}
