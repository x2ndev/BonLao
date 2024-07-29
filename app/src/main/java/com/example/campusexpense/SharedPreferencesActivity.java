package com.example.campusexpense;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SharedPreferencesActivity extends AppCompatActivity {
    private EditText num1, num2, result;
    private Button sum, clear;
    private TextView history;

    private String historyString = "";




    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreferences);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        sum = findViewById(R.id.sum);
        clear = findViewById(R.id.clear);
        history = findViewById(R.id.history);

        result.setEnabled(false);

        historyString = getSharedPreferences("savehistory", MODE_PRIVATE).getString("history", "");
        history.setText(historyString);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1Value = Integer.parseInt(num1.getText().toString());
                int num2Value = Integer.parseInt(num2.getText().toString());
                int resultSum = num1Value + num2Value;
                result.setText(String.format("%d", resultSum));
                String newHistoryEntry = String.format("%s\n%d + %d = %d", history.getText().toString(), num1Value, num2Value, resultSum);
                history.setText(newHistoryEntry);
                historyString = newHistoryEntry; // Update historyString with the new entry
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText("");
                num2.setText("");
                result.setText("");
                history.setText("");
                historyString = ""; // Clear historyString as well
            }
        });
    }
        @Override
        protected void onPause () {
            super.onPause();
            SharedPreferences sharedPreferences = getSharedPreferences("savehistory", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("history", historyString); // Ensure this uses the updated historyString
            editor.apply();
        }


}
