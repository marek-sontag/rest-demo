package pl.sda.spring.rest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/cars")
public class CarRestController {

    @Autowired
    private CarService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Car getCar(@PathVariable String id) {
        int index = Integer.parseInt(id);
        return service.findCar(index);
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
        int index = Integer.parseInt    (id);
        service.deleteCar(index);
    }
}
