package pl.sda.spring.rest.rest;

import lombok.Data;

@Data
public class Car {

    private String brand;
    private String model;
    private int power;
    private int engineCapacity;
}
