package com.quintrix.quintrixspringdemo.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.quintrixspringdemo.Models.Car;

@RestController
public class CarController {

  List<Car> carsList = new ArrayList<>(Arrays.asList(new Car(1L, "Ford", "SUV", 2011),
      new Car(2L, "Honda", "SUV", 2005), new Car(3L, "Volvo", "Truck", 2015)));



  @RequestMapping(method = RequestMethod.GET, value = "/cars")
  List<Car> getCars(@RequestParam(name = "make", required = false) String make) {
    return carsList;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/cars{id}")
  Car something(@QueryParam("id") Long id) {

    Optional<Car> car =
        carsList.stream().filter(c -> c.getId().longValue() == id.longValue()).findAny();

    if (car.isPresent()) {
      return car.get();
    } else {
      return null;
    }
  }

  @RequestMapping(method = RequestMethod.POST, value = "/cars{id}")
  Car getCarDetails(@PathVariable("id") Long id) {

    Optional<Car> car =
        carsList.stream().filter(c -> c.getId().longValue() == id.longValue()).findAny();

    if (car.isPresent()) {
      return car.get();
    } else {
      return null;
    }
  }

  @RequestMapping(method = RequestMethod.POST, value = "/cars")
  Car addCar(@RequestBody Car car) {

    carsList.add(car);

    return car;

  }



}
