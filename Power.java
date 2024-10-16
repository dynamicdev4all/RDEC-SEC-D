import java.util.*;

public class Power {

    static int findPower(int base, int exp) {
        if (exp == 0) {
            return 1;
        }
        return base * findPower(base, exp - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the base");
        int base = sc.nextInt();
        System.out.println("Please enter the exponent");
        int exp = sc.nextInt();
        int power = 1;
        for (int i = 1; i <= exp; i++) {
            power = power * base;
        }
        System.out.println(power);
    }
}
