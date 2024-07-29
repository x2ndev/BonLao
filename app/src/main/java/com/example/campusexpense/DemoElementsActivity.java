package com.example.campusexpense;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DemoElementsActivity extends AppCompatActivity {
    private final String FlagTag = "LogElements";
    private CheckBox YesTick;
    private CheckBox NoTick;
    private RadioButton Male;
    private RadioButton Fmale;
    private Button BTN_TEST;
    private Button BTN_TEST1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_elements);
        findViewById(R.id.btn_test).setEnabled(false);
        findViewById(R.id.btn_test1).setEnabled(false);


        YesTick = findViewById(R.id.cb_yes);
        NoTick = findViewById(R.id.cb_no);
        BTN_TEST = findViewById(R.id.btn_test);
        BTN_TEST1 = findViewById(R.id.btn_test1);


        YesTick.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Log.i(FlagTag,"YES CHECKED");
                    BTN_TEST.setEnabled(true);
                }else{
                    Log.i(FlagTag,"YES UNCHECKED");
                    BTN_TEST.setEnabled(false);
                }
            }
        });

        BTN_TEST.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBTN_TEST(v);
            }
        });



        Fmale = findViewById(R.id.rd_female);
Fmale.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        BTN_TEST1.setEnabled(true);

        Log.i(FlagTag, "Radio checked");

    }
});


    }


    public void handleBTN_TEST(View view){
        NoTick = findViewById(R.id.cb_no);
        if(NoTick.isChecked()){
            Toast.makeText(this, "NO CHECKED", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "NO UNCHECKED", Toast.LENGTH_SHORT).show();
        }
    }


}
