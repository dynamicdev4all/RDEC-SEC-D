import javax.swing.text.html.StyleSheet;

public class String2 {
    public static void main(String[] args) {
        // String name = "Deepak";
        // name = name + "Sharma";

        // StringBuffer sb = new StringBuffer();
        // sb.append("Deepak aaqwqwqwqwqwqwqwqwrt");
        // System.out.println(sb.capacity());
        // System.out.println(sb.length());

        long start, end;
        start = System.nanoTime();

        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 1000; i++) {
            sb.append(" ");
        }
        end = System.nanoTime();

        System.out.println(end-start);
    }
}
