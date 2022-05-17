package com.example.andopgave.ui.logout;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;

public class LogoutViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    FirebaseAuth mAuth;


    public void logout() {
        mAuth.signOut();
    }

}