import java.util.*;
import java.text.*;
public class BillPrint {
    static void Bill(String name,String item_name, double price , int quantity,double tax,Locale lang,ResourceBundle rb){
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT,lang);
        Date date = new Date();
        NumberFormat nf = NumberFormat.getCurrencyInstance(lang);
        double tax_amount = (tax/100) * price * quantity;
        System.out.println("-----------------------");
        System.out.println(rb.getString("getGretting")+", "+ name);
        System.out.println(rb.getString("getPurchased") + "  : " + quantity + " " +  item_name + " on " + df.format(date) );
        System.out.println(rb.getString("getPrice")+ "  : " + nf.format(price * quantity));
        System.out.println(rb.getString("getTaxAmount")+ "  : "+ nf.format(tax_amount));
        System.out.println(rb.getString("getBeforeTax")+ "  : "+ nf.format((price * quantity - tax_amount)));
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Locale lang;
        ResourceBundle rb;
        System.out.println("Enter your choice \n 1 for English \n 2 for Hindi \n 3 for Japanese");
        int choice = scan.nextInt();
        if(choice == 1){
            lang = Locale.of("en","US");
        }
        else if(choice == 2){
            lang = Locale.of("hi","IN");
        }
        else if(choice == 3){
            lang = Locale.of("jp","JP");
        }
        else {
            System.out.println("Invalid Choice. default using English");
            lang = Locale.of("en", "US");
        }
        rb = ResourceBundle.getBundle("ResourceBundle", lang);
        System.out.println(rb.getString("getName"));
        scan.nextLine();
        String name = scan.nextLine();
        System.out.print(rb.getString("getProductName"));
        String item = scan.nextLine();
        System.out.print(rb.getString("getQuantity"));
        int quantity = scan.nextInt();
        System.out.print(rb.getString("getAmount"));
        double price = scan.nextDouble();
        System.out.print(rb.getString("getTax"));
        double tax = scan.nextDouble();

        Bill(name,item,price,quantity,tax,lang,rb);
    }
}
