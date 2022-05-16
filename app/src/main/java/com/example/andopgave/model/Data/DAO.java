package com.example.andopgave.model.Data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAO {
    private static DAO single_instance = null;

    private static FirebaseDatabase mDatabase;
    private static FirebaseAuth mAuth;


    public static DAO getInstance()
    {
        if (single_instance == null) {
            single_instance = new DAO();
            mAuth = FirebaseAuth.getInstance();
            mDatabase = FirebaseDatabase.getInstance();
        }
        return single_instance;
    }

    public static FirebaseAuth getmAuth() {
        getInstance();
        return mAuth;
    }

    public static FirebaseDatabase getmDatabase() {
        getInstance();
        return mDatabase;
    }
}
