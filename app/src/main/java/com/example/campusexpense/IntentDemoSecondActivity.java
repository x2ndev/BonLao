package com.example.campusexpense;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IntentDemoSecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo_second);

        Button btn_back = findViewById(R.id.btn_comback);

        Button btn_login = findViewById(R.id.btn_sendData);


btn_back.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(IntentDemoSecondActivity.this, IntentDemoActivity.class);
        startActivity(intent);
    }
});
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras != null){
            String url = extras.getString("URL");
            String phone = extras.getString("PHONE");
            TextView tv_data = findViewById(R.id.tv_data);
            TextView tv_data2 = findViewById(R.id.tv_data2);
            tv_data.setText(url);
            tv_data2.setText(phone);
        }

//        TextView tv_data = findViewById(R.id.tv_data);
//        TextView tv_data2 = findViewById(R.id.tv_data2);
//        tv_data.setText(getIntent().getStringExtra("URL"));
//        tv_data2.setText(getIntent().getStringExtra("PHONE"));


btn_login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        EditText username = findViewById(R.id.et_userName);
        EditText password = findViewById(R.id.et_password);

        if(!CheckLogin(username.getText().toString(), password.getText().toString())){
            username.setError("Invalid username or password");
            password.setError("Invalid username or password");
            return;
        }

        Intent intent = new Intent(IntentDemoSecondActivity.this, IntentDemoActivity.class);
        Bundle extras = new Bundle();
        extras.putString("USERNAME", username.getText().toString());
        extras.putString("PASSWORD", password.getText().toString());
        intent.putExtras(extras);

        startActivity(intent);



    }
});





}

    private boolean CheckLogin(String username, String password){
        if(username.equals("admin") && password.equals("admin")){
            return true;
        }else{
            return false;
        }
    }

}
