package com.jovannirodriguez.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    // Class variables; AKA 'Fields'
    private TextView resultText;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;
    private Button calculateButton;


    //app entry point
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //reload state data (kind of)
        setContentView(R.layout.activity_main); //set default "screen"/.xml file


        // grab all the View objects we need to interact with from the layout file
        findViews();

        // set a listener for the button to actually do something on click
        setupButtonClickListener();

    }


    private void findViews() {
        resultText = findViewById(R.id.text_view_result);

        maleButton = findViewById(R.id.radio_button_male);
        femaleButton = findViewById(R.id.radio_button_female);

        ageEditText = findViewById(R.id.edit_text_age);
        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);

        calculateButton = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bmiResult = calculateBmi();

                String ageText = ageEditText.getText().toString();
                int age = Integer.parseInt(ageText);

                if (age >= 18) {
                    displayResult(bmiResult);
                } else {
                    displayGuidance(bmiResult);
                }


            }
        });
    }



    private double calculateBmi() {
        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        // Converting the number 'Strings' into int variables
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        // Convert height in inches to meters
        int totalInches = (feet * 12) + inches;

        double heightInMeters = totalInches * 0.0254;

        // Calculate the BMI and return
        return weight / (heightInMeters * heightInMeters);
    }

    private void displayResult(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;

        if (bmi < 18.5) {
            // Display underweight
            fullResultString = bmiTextResult + " - You are underweight";
        } else if (bmi > 25) {
            // Display overweight
            fullResultString = bmiTextResult + " - You are overweight";
        } else {
            // Display healthy
            fullResultString = bmiTextResult + " - You are a healthy weight";
        }

        resultText.setText(fullResultString);
    }

    private void displayGuidance(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if (maleButton.isChecked()) {
            // Display boy guidance
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for the healthy range for boys";
        } else if (femaleButton.isChecked()) {
            // Display girl guidance
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for the healthy range for girls";

        } else {
            // Display general guidance
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for the healthy range";
        }

        resultText.setText(fullResultString);
    }


}












