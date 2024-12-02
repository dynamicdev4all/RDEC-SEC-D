import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        String arr[] = new String[20];
        arr[0] = "A";//0
        arr[1] = "B";//1
        l.add("A");//0
        l.add("B");//1
        System.out.println(arr.length);
        System.out.println(l.size());
        System.out.println(arr[0]);
        System.out.println(l.get(0));
    }
}

