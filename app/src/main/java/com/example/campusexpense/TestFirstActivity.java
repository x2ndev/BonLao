package com.example.campusexpense;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TestFirstActivity extends AppCompatActivity {

    private final String Tag = "TestFirstActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_first);


        findViewById(R.id.btn_start_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), TestSecondActivity.class));//khoi dong actvt moi
            }
        });
        Log.i(Tag, "onCreate Run");
    }
   // Log.i(Tag, "onCreate Run");

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag, "onStart Run");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag, "onResume Run");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag, "onPause Run");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Tag, "onStop Run");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(Tag, "onRestart Run");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag, "onDestroy Run");
    }
}
