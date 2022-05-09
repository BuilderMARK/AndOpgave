package com.example.andopgave.ui.createCar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.andopgave.databinding.FragmentCreateCarBinding;

public class CreateCar extends Fragment {

    private Button btn_Search, btn_Create;
    private TextView tv_regNumber, tv_make, tv_model, tv_modelYear;
    private EditText et_SeacrhReg;
    private FragmentCreateCarBinding binding;
    private CreateCarViewModelImpl mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(CreateCarViewModelImpl.class);
        binding = FragmentCreateCarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        bindings();
        observer();
        onClickListeners();


        return root;
    }

    private void observer() {
        mViewModel.getCarDataFromPlate().observe(getViewLifecycleOwner(), carData -> {
            tv_regNumber.setText(carData.getRegistration_number());
            tv_make.setText(carData.getMake());
            tv_model.setText(carData.getModel());
            tv_modelYear.setText(String.valueOf(carData.getModel_year()));
        });
    }


    private void bindings() {
        //TextView
        tv_regNumber = binding.regNumber;
        tv_make = binding.make;
        tv_model = binding.model;
        tv_modelYear = binding.modelYear;
        //EditText
        et_SeacrhReg = binding.editTextTextRegNub;
        //Knapper
        btn_Search = binding.BtnSearchCar;
        btn_Create = binding.BtnCreateCar;

    }

    private void onClickListeners() {
        btn_Search.setOnClickListener(view -> {
            mViewModel.SearchForCarWithPlate(et_SeacrhReg.getText().toString());
            Log.i("OnclickCar", "onClickListeners: " + et_SeacrhReg.toString());
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}