package com.example.campusexpense;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText m_Username;
    private EditText m_Password;
    private Button login_btn;
    private ProgressBar loadingLogin;
    boolean isProgressShow = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login();
    }
    private void login(){
        m_Username = findViewById(R.id.username); //find id EditText
        m_Password = findViewById(R.id.password);
        login_btn = findViewById(R.id.btn_login);

        loadingLogin = findViewById(R.id.idPBLoading);
        //nguoi dung nhan login
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = m_Username.getText().toString().trim();
                String password = m_Password.getText().toString().trim();
                //check login
                if (TextUtils.isEmpty(username)){
                    m_Username.setError("Username can't be empty");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    m_Password.setError("Password can't be empty");
                    return;
                }
//                if (isProgressShow){
//
//                    loadingLogin.setVisibility(View.GONE);
//                    isProgressShow = false;
//                }else {
//
//                }
                if (username.equals("x2nios") && password.equals("1234")){


                    login_btn.setText("Processing...");
                    loadingLogin.setVisibility(View.VISIBLE);
                    isProgressShow = true;

                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }else{

                    loadingLogin.setVisibility(View.GONE);
                    isProgressShow = false;
                    m_Username.setError("Invalid");
                    m_Password.setError("Invalid");

                }
            }


        });


    }
}
