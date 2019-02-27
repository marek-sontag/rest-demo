package pl.sda.spring.rest.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

@Controller
@RequestMapping("/cars")
public class CarRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(CarRestController.class);

    @Autowired
    private CarService service;

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable String id) {
        int index = Integer.parseInt(id);
        if (index == 418) {
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
        }
        return ResponseEntity.ok(service.findCar(index));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void storeCar(@RequestBody Car car) {
        service.storeCar(car);
    }

    @GetMapping
    public @ResponseBody Collection<Car> getCars() {
        return service.getCars();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCar(@PathVariable String id) {
        int index = Integer.parseInt(id);
        if (index == 418) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        }
        service.deleteCar(index);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleIllegalArgument() {
        LOGGER.error("Handling Illegal Argument Exception - returning 404");
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handleNumberFormatException() {
        LOGGER.error("Handling Number Format Exception - returning 400"); // just for the exercise
    }
}
