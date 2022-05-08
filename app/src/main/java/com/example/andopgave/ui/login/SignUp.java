package com.example.andopgave.ui.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andopgave.R;
import com.example.andopgave.model.User;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Buttons and input fields
        Button login = findViewById(R.id.SignupButtonOnSignup);
        EditText name = findViewById(R.id.NameFromSignup);
        EditText email = findViewById(R.id.EmailFromSignup);
        EditText password = findViewById(R.id.PasswordFromSignup);

        //Firebase database reference

        mDatabase = FirebaseDatabase.getInstance().getReference();

        //Signup button event listener
        login.setOnClickListener(view -> {
            //Creating User Object
            User u = new User();
            u.username = name.getText().toString();
            u.email = email.getText().toString();
            u.password = password.getText().toString();

            //Pushing to firebase (This might need to be reworked - Not optimal)
            mDatabase.child("users").child(u.username).setValue(u);
        });


            //CLEAN UP FOR LATER:: Delete everything under this?
        // Get email & name from google - Not need ATM but might be usefull later
        /*

        GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;
    TextView name,email;email = findViewById(R.id.email);
        name = findViewById(R.id.name);


        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);

        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        if (account !=null){
            String personName = account.getDisplayName();
            String personEmail = account.getEmail();
            name.setText(personName);
            email.setText(personEmail);
        }*/
    }
}
