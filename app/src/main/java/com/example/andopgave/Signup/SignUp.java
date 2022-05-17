
package com.example.andopgave.Signup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.andopgave.R;
import com.example.andopgave.model.Data.DAO;
import com.example.andopgave.ui.login.Login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    private EditText et_Email,et_Name,et_Password;
    private Button btn_signUp, btn_Cancel;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        et_Email = findViewById(R.id.tv_email);
        et_Name = findViewById(R.id.NameFromSignup);
        et_Password = findViewById(R.id.tv_password);
        btn_signUp = findViewById(R.id.btn_login);
        btn_Cancel = findViewById(R.id.btn_SignUp);
        mAuth = DAO.getmAuth();
        btn_signUp.setOnClickListener(view -> {
            createUser();

        });
        btn_Cancel.setOnClickListener(view -> {
            Log.e("SignUp", "onCreate: Virker ikke lige pt ");
            startActivity(new Intent (SignUp.this, Login.class));
        });
    }

    private void createUser() {
        String Email, Name,Password;
        Email = et_Email.getText().toString();
        Name = et_Name.getText().toString();
        Password = et_Password.getText().toString();
        if (TextUtils.isEmpty(Email)){
            et_Email.setError("Email cant be empty");
            et_Email.requestFocus();
        }
        else if (TextUtils.isEmpty(Name))
    {
            et_Name.setError("Name cant be empty");
            et_Name.requestFocus();
        }
        else if (TextUtils.isEmpty(Password))
        {
            et_Password.setError("Password cant be empty");
            et_Password.requestFocus();
        }
        else {
            mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUp.this, "User Signup successfull", Toast.LENGTH_LONG).show();
                        startActivity(new Intent (SignUp.this, Login.class));
                    }else{
                        Toast.makeText(SignUp.this, "User Signup Failed" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }
}

