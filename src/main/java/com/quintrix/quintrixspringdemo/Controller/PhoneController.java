package com.quintrix.quintrixspringdemo.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.quintrix.quintrixspringdemo.Models.Phone;

@RestController
public class PhoneController {


  List<Phone> phoneList = new ArrayList<>(Arrays.asList(new Phone(1, "Google", "Pixel"),
      new Phone(2, "Apple", "Iphone"), new Phone(3, "Samsung", "Galaxy")));

  @RequestMapping(method = RequestMethod.GET, value = "/phones")
  List<Phone> getPhonesByModel(@RequestParam(name = "model", required = false) String model,
      @RequestParam(name = "brand", required = false) String brand) {

    if (model != null) {
      return phoneList.stream().filter(c -> c.getModel().contains(model))
          .collect(Collectors.toList());
    } else if (brand != null) {
      return phoneList.stream().filter(c -> c.getBrand().contains(brand))
          .collect(Collectors.toList());
    } else {
      return phoneList;
    }
  }

  @RequestMapping(method = RequestMethod.POST, value = "/phones{id}")
  Phone getPhoneDetails(@PathVariable("id") Long id) {

    Optional<Phone> phone = phoneList.stream().filter(c -> c.getId() == id.longValue()).findAny();

    if (phone.isPresent()) {
      return phone.get();
    } else {
      return null;
    }

  }


  @RequestMapping(method = RequestMethod.POST, value = "/phones")
  Phone addPhone(@RequestBody Phone phone) {

    phoneList.add(phone);

    return phone;

  }


}
