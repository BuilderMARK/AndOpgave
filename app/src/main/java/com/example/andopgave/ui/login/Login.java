
package com.example.andopgave.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.andopgave.MainActivity;
import com.example.andopgave.R;
import com.example.andopgave.ui.home.HomeFragment;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class Login extends AppCompatActivity implements View.OnClickListener {
    GoogleSignInOptions googleSignInOptions;
    GoogleSignInClient googleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleSignInClient = GoogleSignIn.getClient(this,googleSignInOptions);
        Button googleLogin = findViewById(R.id.GoogleLogin);
        Button login = findViewById(R.id.Login);
        Button signUp = findViewById(R.id.SignUP);
        login.setOnClickListener(this);
        signUp.setOnClickListener(this);
        googleLogin.setOnClickListener(this);
    }


    //On click skifter view her, og det gør den ved en switch, Kig startActivity
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Login:
                startActivity(new Intent(this, MainActivity.class));
                Toast.makeText(this, "Login",Toast.LENGTH_SHORT).show();
                break;
            case R.id.SignUP:
                startActivity(new Intent(this,SignUp.class));
                Toast.makeText(this, "Signup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.GoogleLogin:
                finish();
                signIn();
                break;


        }
    }

    private void signIn() {
        Intent googleSignIn = googleSignInClient.getSignInIntent();
        startActivityForResult(googleSignIn,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            navigateTosecondActivity();
            try {
                task.getResult(ApiException.class);
            } catch (ApiException e) {
                Toast.makeText(getApplicationContext(), "Noget gik galt prøv igen",Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }
    void navigateTosecondActivity(){
        finish();
        Intent intent = new Intent(Login.this,Login.class);
        startActivity(intent);

    }
}

