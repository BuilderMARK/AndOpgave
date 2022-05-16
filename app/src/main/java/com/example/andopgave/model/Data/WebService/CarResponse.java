package com.example.andopgave.model.Data.WebService;

import com.example.andopgave.model.Data.CarData;

public class CarResponse {
    private String registration_number, make,model,url;
    private int model_year,price;

  public CarData getCars(){
      return new CarData(registration_number,make,model,url,model_year,price);
  }
}
