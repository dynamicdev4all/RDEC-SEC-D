public class ObjBasics2 {
    public static void main(String[] args) {
        Car car1 = new Car(4, 3, 5, "Black", "Thar");
        // Car car2 = new Car();
        // Car car3 = new Car();
        System.out.println(car1.name);
        System.out.println(car1.color);
        System.out.println(car1.noOfDoors);
        System.out.println(car1.noOfSeats);
        System.out.println("*********************");
        Car car2 = new Car(4, 4, 5, "Red", "Swift");
        // Car car2 = new Car();
        // Car car3 = new Car();
        System.out.println(car2.name);
        System.out.println(car2.color);
        System.out.println(car2.noOfDoors);
        System.out.println(car2.noOfSeats);
    }
}

class Car {
    int wheelCount;
    int noOfSeats;
    int noOfDoors;
    String color;
    String name;

    Car(int wheelCount, int noOfDoors, int noOfSeats, String color, String name) {
        this.noOfDoors = noOfDoors;
        this.wheelCount = wheelCount;
        this.noOfSeats = noOfSeats;
        this.color = color;
        this.name = name;
    }
}
