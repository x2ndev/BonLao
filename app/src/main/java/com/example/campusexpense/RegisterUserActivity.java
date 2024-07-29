package com.example.campusexpense;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.campusexpense.sqlite.AccountDB;

public class RegisterUserActivity extends AppCompatActivity {
    private EditText name, email, password, password2;
    private Button register;

    private AccountDB accountDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        password2 = findViewById(R.id.password2);
        register = findViewById(R.id.register);

        register.setOnClickListener(v -> {
            RegisterAccount();
        });
    }

    public void RegisterAccount(){
        String name = this.name.getText().toString().trim();
        String email = this.email.getText().toString().trim();
        String password = this.password.getText().toString().trim();
        String password2 = this.password2.getText().toString().trim();

        if(name.isEmpty() || email.isEmpty() || password.isEmpty() || password2.isEmpty()){
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!password.equals(password2)){
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        accountDB = new AccountDB(this);
        long id = accountDB.newAccount(name, email, password);

        //check account exists




        if(id == -1){
            Toast.makeText(this, "Account creation failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Account created successfully", Toast.LENGTH_SHORT).show();
        }
    }



}
