package Basic;

public class Car {
    private String name;
    private String engine;
    public static int numberOfCars;

    public static void main(String[] args) {
        new Car("Jaguar", "V8");
        new Car("Bugatti", "w16");
        System.out.println();
        System.out.println(numberOfCars);
    }
    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        System.out.println(numberOfCars);
        numberOfCars++;
    }

    public static void setNumberOfCars(String name){
        //this.name=name;
    }
}
