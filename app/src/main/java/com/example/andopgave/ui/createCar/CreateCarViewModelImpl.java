package com.example.andopgave.ui.createCar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.andopgave.model.Data.WebService.PostCarRepository;
import com.example.andopgave.model.Data.CarData;

public class CreateCarViewModelImpl extends ViewModel implements CreateCarViewModel {
    PostCarRepository postCarRepository;
    public CreateCarViewModelImpl() {
        postCarRepository = PostCarRepository.getInstance();
    }


    @Override
    public LiveData<CarData> getCarDataFromPlate() {
        return postCarRepository.getSearchedInPlateWeb();
    }

    @Override
    public void SearchForCarWithPlate(String Plate) {
        postCarRepository.searchForCarWithPlateInWeb(Plate);
    }

}