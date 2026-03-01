package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText studentName, mathScore, sciScore, engScore;
    Button btnCalculate;
    TextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        studentName = findViewById(R.id.studentName);
        mathScore = findViewById(R.id.mathScore);
        sciScore = findViewById(R.id.sciScore);
        engScore = findViewById(R.id.engScore);
        btnCalculate = findViewById(R.id.btnCalculate);
        results = findViewById(R.id.results);


        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getBtnCalculate();
            }
        });
    }
    public void getBtnCalculate(){
        String name = studentName.getText().toString();
        int math = Integer.parseInt(mathScore.getText().toString());
        int sci = Integer.parseInt(sciScore.getText().toString());
        int eng = Integer.parseInt(engScore.getText().toString());

        int[] num = {math, sci, eng};
        int len = num.length;
        int avg = 0;
        for (int i=0; i < len; i++)
        {
            avg = avg + num[i];
        }
        avg = avg/len;

        char grade;
        if (avg >= 90) {
            grade = 'A';
        }
        else if (avg >= 80) {
            grade = 'B';
        }
        else if (avg >= 70) {
            grade = 'C';
        }
        else if (avg >= 60) {
            grade = 'D';
        }
        else {
            grade = 'F';
        }

        results.setText("Student " + name);
        results.setText("Average Score: " + avg);
        results.setText("Grade: " + grade);
    }

}