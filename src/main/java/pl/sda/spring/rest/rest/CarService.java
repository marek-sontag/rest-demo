package pl.sda.spring.rest.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarService.class);

    @Autowired
    private CarRepository repository;

    public Collection<Car> getCars() {
        LOGGER.info("Getting cars");
        return repository.getCars();
    }

    public Car findCar(int i) {
        LOGGER.info("Getting car: {}", i);
        return repository.findCar(i).orElseThrow(() ->  {
            String msg = String.format("Car with id: %s not found", i);
            LOGGER.error(msg);
            return new IllegalArgumentException(msg);
        });
    }

    public void storeCar(Car car) {
        LOGGER.info("Storing car {}", car.toString());
        repository.storeCar(car);
    }

    public void deleteCar(int index) {
        LOGGER.warn("Deleting car {}", index);
        if (repository.deleteCar(index) == null) {
            String msg = String.format("Car with id: %s not found", index);
            LOGGER.error(msg);
            throw new IllegalArgumentException(msg);
        }
    }
}
