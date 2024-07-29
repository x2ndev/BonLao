package com.example.campusexpense;

import static android.Manifest.permission.CALL_PHONE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class IntentDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo);
        EditText url_field = findViewById(R.id.urlWeb);
        Button show_URL = findViewById(R.id.btn_URL);

        EditText phone_field = findViewById(R.id.phoneNum);
        Button show_phone = findViewById(R.id.btn_Call);

        Button btn_Go = findViewById(R.id.btn_Go);
        Button btn_sendData = findViewById(R.id.btn_sendData);

        show_URL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = url_field.getText().toString().trim();

                if(TextUtils.isEmpty(url)){
                    url_field.setError("Please enter a URL");
                    return;
                }else{
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }

            }
        });


        show_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phone_field.getText().toString().trim();

                if(TextUtils.isEmpty(phone)){
                    phone_field.setError("Please enter a phone number");
                    return;
                }else{
//                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
//                    startActivity(intent);
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+phone));
                   // PackageManager PackageManager = null;
                    if(ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                        startActivity(intent);
                    }else{
                        requestPermissions(new String[]{CALL_PHONE}, 1);
                    }
                    

                }
            }
        });


        btn_Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentDemoActivity.this, IntentDemoSecondActivity.class);

                startActivity(intent);

            }
        });

        btn_sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = url_field.getText().toString().trim();
                String phone = phone_field.getText().toString().trim();

                Intent intent = new Intent(IntentDemoActivity.this, IntentDemoSecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("URL", url);
                bundle.putString("PHONE", phone);
                intent.putExtras(bundle);
//                intent.putExtra("URL", url);
//                intent.putExtra("PHONE", phone);
                startActivity(intent);
            }
        });


        Intent intent_login = getIntent();
        Bundle extras = intent_login.getExtras();
        if(extras != null){
            String username = extras.getString("USERNAME");
            String password = extras.getString("PASSWORD");
            TextView tv_data_username = findViewById(R.id.tv_data_username);
            TextView tv_data_password = findViewById(R.id.tv_data_password);
            tv_data_username.setText(username);
            tv_data_password.setText(password);
        }




    }

}
