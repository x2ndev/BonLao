package com.example.campusexpense;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class QuestActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private RadioGroup radioGroupAnswers;
    private RadioButton radioAnswer1, radioAnswer2, radioAnswer3, radioAnswer4;
    private Button btnSubmit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest);

        tvQuestion = findViewById(R.id.tvQuestion);
        radioGroupAnswers = findViewById(R.id.radioGroupAnswers);
        radioAnswer1 = findViewById(R.id.radioAnswer1);
        radioAnswer2 = findViewById(R.id.radioAnswer2);
        radioAnswer3 = findViewById(R.id.radioAnswer3);
        radioAnswer4 = findViewById(R.id.radioAnswer4);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer();
            }
        });
    }

    private void checkAnswer() {
        int selectedId = radioGroupAnswers.getCheckedRadioButtonId();

        if (selectedId == -1) {
            showAlertDialog("No Answer Selected", "Please select an answer.");
            return;
        }

        RadioButton selectedRadioButton = findViewById(selectedId);
        String answerText = selectedRadioButton.getText().toString();

        if (answerText.equals("Paris")) {
            // Correct answer
            showAlertDialog("Correct Answer", "Correct! Paris is the capital of France.");
        } else {
            // Incorrect answer
            showAlertDialog("Incorrect Answer", "Incorrect! Try again.");
        }
    }

    private void showAlertDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}
