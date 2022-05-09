package com.example.andopgave.ui.createCar;

import androidx.lifecycle.LiveData;

import com.example.andopgave.model.CarData;

public interface CreateCarViewModel {
    LiveData<CarData> getCarDataFromPlate();
    void SearchForCarWithPlate(String Plate);
}
