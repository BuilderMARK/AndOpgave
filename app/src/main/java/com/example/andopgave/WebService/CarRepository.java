package com.example.andopgave.WebService;

import androidx.lifecycle.LiveData;

import com.example.andopgave.model.CarData;

public interface CarRepository {
    LiveData<CarData> getSearchedInPlateWeb();
    void searchForCarWithPlateInWeb(String Plate);
}
