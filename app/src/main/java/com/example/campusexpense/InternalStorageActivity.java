package com.example.campusexpense;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class InternalStorageActivity extends AppCompatActivity {
    private EditText InputId, InputName;
    private TextView datafilepath;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internalstorage);
        InputId = findViewById(R.id.et_id);
        InputName = findViewById(R.id.et_name);
        datafilepath = findViewById(R.id.tv_data);
    }

    @SuppressLint("SetTextI18n")
    public void saveData(View view){
        File file = null;
        String idStudent = InputId.getText().toString().trim();
        String fullName = InputName.getText().toString().trim();
        FileOutputStream fileOutputStream = null;
        try{
            file = getFilesDir();
            idStudent = idStudent + "|";
            fileOutputStream = openFileOutput("data.txt", MODE_PRIVATE);
            fileOutputStream.write(idStudent.getBytes());
            fileOutputStream.write(fullName.getBytes());

            InputId.setText("");
            InputName.setText("");
            datafilepath.setText("File Path:"+file.getAbsolutePath()+"/data.txt");
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();

        }finally {
            try{
                fileOutputStream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }



    public void nextActivity(View view) {
        //go to next activity
        Intent intent = new Intent(this, DemoGetDataActivity.class);
        startActivity(intent);
    }
}