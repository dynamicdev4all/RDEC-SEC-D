import java.util.Scanner;

public class CountWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner("This is RDEC and this is the CSE dept");
        int count = 0;
        while (sc.hasNext()) {
            sc.next();
            count++;
        }
        System.out.println(count);
    }
}
