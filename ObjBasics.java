public class ObjBasics {
    public static void main(String[] args) {
        // Car scorpio = new Car(4, "Mahindra", "s11", "Diesel");
        // Car scorpio = new Car(4, "Mahindra", "s11", "Diesel");
        Car scorpio = Car.createObject(4, "mahindra", "s11", "Diesel");
        System.out.println(scorpio.modelName);
        System.out.println(scorpio.wheelCount);
        System.out.println(scorpio.fuelType);
        System.out.println(scorpio.brandName);
        System.out.println("****************************");
        Car swift = Car.createObject2(4, "Suzuli", "VXI", "Diesel");
        System.out.println(swift.modelName);
        System.out.println(swift.wheelCount);
        System.out.println(swift.fuelType);
        System.out.println(swift.brandName);

    }
}

class Car {
    static Car obj;
    static Car obj2;
    int wheelCount;
    String brandName;
    String modelName;
    String fuelType;

    private Car(int wheelCount, String brandName, String modelName, String fuelType) {
        this.wheelCount = wheelCount;
        this.brandName = brandName;
        this.modelName = modelName;
        this.fuelType = fuelType;
    }

    static Car createObject(int wheelCount, String brandName, String modelName, String fuelType) {
        if (obj == null) {
            obj = new Car(wheelCount, brandName, modelName, fuelType);
        }
        return obj;
    }
    static Car createObject2(int wheelCount, String brandName, String modelName, String fuelType) {
        if (obj2 == null) {
            obj = new Car(wheelCount, brandName, modelName, fuelType);
        }
        return obj;
    }
}
