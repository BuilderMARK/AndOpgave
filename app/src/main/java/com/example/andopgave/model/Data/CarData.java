package com.example.andopgave.model.Data;

public class CarData {
    public String registration_number, make,model,url;
    public int model_year,price;

    public CarData() {
    }

    public CarData(String registration_number, String make, String model,String url, int model_year,int price)
    {
        this.registration_number = registration_number;
        this.make = make;
        this.model = model;
        this.model_year = model_year;
        this.price = price;
        this.url = url;
    }

    public String getRegistration_number() {
        return registration_number;
    }

    public void setRegistration_number(String registration_number) {
        this.registration_number = registration_number;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getModel_year() {
        return model_year;
    }

    public void setModel_year(int model_year) {
        this.model_year = model_year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
