public class Demo2 {
    public static void main(String[] args) {
        // System.out.println(args[0]);
        // System.out.println(args[1]);
        // System.out.println(args[2]);
        // "5"

        // int num1 =int( args[0]);
        // int num1 = Integer.parseInt(args[0]);
        // int num2 = Integer.parseInt(args[1]);
        // int sum = num1 + num2;
        // System.out.println(sum);


        int sum = 0;
        for(int i = 0; i < args.length; i++){
            sum = sum +  Integer.parseInt(args[i]);
        }
        System.out.println(sum);
    }
}
