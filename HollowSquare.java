public class HollowSquare {
    public static void main(String[] args) {
        for (int col = 0; col < 5; col++) {
            for (int row = 0; row < 5; row++) {
                if (row == 0 || row == 4 || col == 0 || col == 4){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
