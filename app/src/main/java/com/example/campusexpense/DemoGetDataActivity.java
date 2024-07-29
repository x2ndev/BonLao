package com.example.campusexpense;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DemoGetDataActivity extends AppCompatActivity {
    private TextView ID, Name;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demogetdata);

        ID = findViewById(R.id.tv_data);
        Name = findViewById(R.id.tv_data2);
        GetDataFromInternaltxtFile();
    }
    private void GetDataFromInternaltxtFile() {
        File file = new File(getFilesDir(), "data.txt");
        if (file.exists()) {
            try {
                // Đọc dữ liệu từ tệp
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                StringBuilder dataBuilder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    dataBuilder.append(line).append("\n");
                }
                reader.close();

                // Tách dữ liệu theo dòng và ký tự phân cách
                String[] lines = dataBuilder.toString().split("\n");
                for (String dataLine : lines) {
                    String[] parts = dataLine.split("\\|");
                    if (parts.length == 2) {
                        String id = parts[0];
                        String name = parts[1];
                        // Hiển thị dữ liệu trên TextView
                        ID.setText(id);
                        Name.setText(name);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ID.setText("File not found");
            Name.setText("File not found");
        }
    }



}
