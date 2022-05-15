package com.example.andopgave.ui.dashBoard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.andopgave.R;
import com.example.andopgave.ui.fragmentcarlist.fragmentCarlist;

public class allcarlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allcarlist);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragmentCarlist.newInstance())
                    .commitNow();
        }
    }
}