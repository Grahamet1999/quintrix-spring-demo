package com.quintrix.quintrixspringdemo.Models;

public class Phone {

  public Phone(int id, String brand, String model) {
    super();
    this.id = id;
    this.brand = brand;
    this.model = model;
  }

  public Phone() {}

  int id;

  String brand;

  String model;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }



}
