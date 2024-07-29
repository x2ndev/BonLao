package com.example.campusexpense;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginUserActivity  extends AppCompatActivity {
  //  Button register;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_user);
        Button registeracc = findViewById(R.id.registeracc);
        registeracc.findViewById(R.id.register);

        registeracc.setOnClickListener(v -> {
            Intent intent = new Intent(LoginUserActivity.this, RegisterUserActivity.class);
            startActivity(intent);
        });
    }
}
