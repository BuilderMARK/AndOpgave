package com.example.andopgave.WebService;

import com.example.andopgave.model.Data.CarData;

public class CarResponse {
    private String registration_number, make,model;
    private int model_year,price;

  public CarData getCars(){
      return new CarData(registration_number,make,model,model_year,price);
  }
}
