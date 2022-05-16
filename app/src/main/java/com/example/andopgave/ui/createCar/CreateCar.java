package com.example.andopgave.ui.createCar;

import static android.app.Activity.RESULT_OK;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.example.andopgave.databinding.FragmentCreateCarBinding;
import com.example.andopgave.model.Data.CarData;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.util.UUID;

public class CreateCar extends Fragment  {

    private Button btn_Search, btn_Create, btn_Cancel, btn_Picture;
    private EditText et_seacrhReg, et_price, et_regNumber, et_make, et_model, et_modelYear;
    private FragmentCreateCarBinding binding;
    private CreateCarViewModelImpl mViewModel;
    private ImageView imageView;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private static final int PICK_IMAGE_REQUEST =1;
    private Uri imageUrl;

    FirebaseStorage storage;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(CreateCarViewModelImpl.class);
        binding = FragmentCreateCarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        bindings();
        observer();
        onClickListeners();

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();






        return root;
    }

    private void observer() {
        mViewModel.getCarDataFromPlate().observe(getViewLifecycleOwner(), carData -> {
            et_regNumber.setText(carData.getRegistration_number());
            et_make.setText(carData.getMake());
            et_model.setText(carData.getModel());
            et_modelYear.setText(String.valueOf(carData.getModel_year()));
        });
    }


    private void bindings() {
        //TextView
        et_regNumber = binding.regNumber;
        et_make = binding.make;
        et_model = binding.model;
        et_modelYear = binding.modelYear;
        //ImageView
        imageView = binding.imageView;
        //EditText
        et_seacrhReg = binding.editTextTextRegNub;
        et_price = binding.editPrice;
        //Knapper
        btn_Search = binding.BtnSearchCar;
        btn_Create = binding.BtnCreateCar;
        btn_Picture = binding.btnPicture;
        //btn_Cancel = binding.BtnCancel;
        // TODO: Hjælp mark (:

    }

    private void onClickListeners() {
        btn_Search.setOnClickListener(view -> {
            mViewModel.SearchForCarWithPlate(et_seacrhReg.getText().toString());
            Log.i("OnclickCar", "onClickListeners: " + et_seacrhReg.toString() + mAuth.getCurrentUser().getUid());
            UploadImage();
        });
        btn_Create.setOnClickListener(view -> {
            CarData carData = new CarData();
            carData.registration_number = et_regNumber.getText().toString();
            carData.model = et_model.getText().toString();
            carData.make = et_make.getText().toString();
            carData.model_year = Integer.parseInt(et_modelYear.getText().toString());
            carData.price = Integer.parseInt(et_price.getText().toString());
            //Pushing to firebase
            mDatabase.child(mAuth.getCurrentUser().getUid()).child(carData.getRegistration_number()).setValue(carData);
            Log.e("Database", "Uploaded til database " + carData.getRegistration_number() + " " + carData.make + " " + carData.model);
            mDatabase.child("AllCars").child(carData.getRegistration_number()).setValue(carData);
        });
        btn_Picture.setOnClickListener(view -> {

mGetContent.launch("image/*");

        });
    }

public void UploadImage(){
        if (imageUrl != null ){
            StorageReference storageReference = storage.getReference().child("images/" + UUID.randomUUID().toString());
storageReference.putFile(imageUrl).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
    @Override
    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
        if (task.isSuccessful()){
            //Image upload
            System.out.println("On Complete Working");
        } else {
            System.out.println("Do not work");
        }
    }
});
        }

}

 ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(), new ActivityResultCallback<android.net.Uri>() {
     @Override
     public void onActivityResult(android.net.Uri result) {
         if (result != null){
             imageView.setImageURI(result);
             imageUrl = result;
         }
     }
 });






    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}