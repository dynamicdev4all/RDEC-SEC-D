import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your roll no");
        int roll = sc.nextInt();
        System.out.println("This is the entered roll :" + roll);
        sc.nextLine();
        System.out.println("Please enter your name");
        String name = sc.nextLine();
        System.out.println("This is the entered name :" + name);
    }
}
