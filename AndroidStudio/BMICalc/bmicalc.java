package com.example.upmasharma.bmicalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
//import the fucking button
import android.widget.Button;

public class MainActivity extends Activity {
    private EditText height;
    private EditText weight;
    private TextView bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        height = findViewById(R.id.eTHeight);
        weight = findViewById(R.id.etWeight);
        bmi = findViewById(R.id.tvBMI);

        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcBMI();

            }
        }));
    }

public void calcBMI()
    {

            String strWeight = weight.getText().toString();
            String strHeight = height.getText().toString();

            float weights = Float.parseFloat(strWeight);
            float heights = Float.parseFloat(strHeight);

            float bmiCalc = (weights/(heights*heights));

            bmi.setText(String.format("%.1f", bmiCalc));
    }

}
