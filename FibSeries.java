public class FibSeries {
    public static void main(String[] args) {
        int count = 10;
        int a = 0;
        int b = 1;
        if (count <= 0) {
            System.out.println("Not a valid range");
        }
        if (count == 1) {
            System.out.println(a);
        } else {
            System.out.println(a);
            System.out.println(b);

            for (int i = 0; i < count - 2; i++) {
                int c = a + b;
                System.out.println(c);
                a = b;
                b = c;
            }
        }
    }
}
