package com.example.andopgave.createCar;

import androidx.lifecycle.LiveData;

import com.example.andopgave.model.CarData;

public interface CreateCarViewModel {
    LiveData<CarData> getCarDataFromPlate();
    void SearchForCarWithPlate(String Plate);
}
