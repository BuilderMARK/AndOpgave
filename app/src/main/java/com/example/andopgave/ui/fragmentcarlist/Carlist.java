package com.example.andopgave.ui.fragmentcarlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.andopgave.R;
import com.example.andopgave.ui.fragmentcarlist.fragmentCarlist;

public class Carlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carlist_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragmentCarlist.newInstance())
                    .commitNow();
        }
    }
}