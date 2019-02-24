package pl.sda.spring.rest.rest;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CarRepository {

    private Map<Integer, Car> cars;

    public CarRepository() {
        Car car1 = new Car();
        car1.setBrand("Fiat");
        car1.setModel("Panda");
        car1.setEngineCapacity(1000);
        car1.setPower(70);

        Car car2 = new Car();
        car2.setBrand("Hummer");
        car2.setModel("H3");
        car2.setEngineCapacity(6500);
        car2.setPower(200);

        Car car3 = new Car();
        car3.setBrand("Ford");
        car3.setModel("T");
        car3.setEngineCapacity(2500);
        car3.setPower(30);

        cars = new HashMap<>();
        cars.put(1, car1);
        cars.put(2, car2);
        cars.put(3, car3);
    }

    public Collection<Car> getCars() {
        return cars.values();
    }

    public Car findCar(int i) {
        return cars.get(i);
    }

    public void storeCar(Car car) {
        cars.put(cars.keySet().size() + 1, car);
    }

    public void deleteCar(int index) {
        cars.remove(index);
    }
}
