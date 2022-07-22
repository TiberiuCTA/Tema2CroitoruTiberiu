import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Intersection intersection = new Intersection();
        ArrayList<Car> cars = new ArrayList<>();
        Car car0 = new Car("PH95CRO", "WE");
        Car car1 = new Car("PH95CRG","WE");
        Car car2 = new Car("PH02CTA","WE");
        Car car3 = new Car("PH22SLA","NS");
        Car car4 = new Car("PH29PKS","NS");
        Car car5 = new Car("PH09BOO","NS");
        Car car6 = new Car("PH20ANP","NS");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);
        cars.add(car6);


        for (Car car : cars) {
            car.setIntersection(intersection);
        }

        try {
            car1.start();
            car1.join(500);
            car2.start();
            car2.join(500);
            car3.start();
            car3.join(700);
            car4.start();
            car4.join(1000);
            car5.start();
            car5.join(1200);
            car6.start();
            car6.join(1001);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
