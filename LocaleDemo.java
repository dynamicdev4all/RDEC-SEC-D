import java.util.*;
import java.text.*;

public class LocaleDemo {

    static void printTotal(Locale locale) {
        // NumberFormat nf = new NumberFormat();
        NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
        System.out.println(nf.format(12500));
    }

    static void printDate(Locale locale) {
        Date date = new Date();
        DateFormat dtf = DateFormat.getDateInstance(DateFormat.LONG, locale);
        System.out.println(dtf.format(date));
    }

    public static void main(String[] args) {
        Locale locale = new Locale("JP", "JP");
        // Locale locale = Locale.of("JP", "JP");
        // Locale locale2 = Locale.CANADA_FRENCH;
        // 2,00,000.00
        // 200,000.00
        printTotal(locale);
        printDate(locale);
    }
}
