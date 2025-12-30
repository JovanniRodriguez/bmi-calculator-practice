package com.jovannirodriguez.bmicalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //app entry point
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //reload state data
        setContentView(R.layout.activity_main); //set default "screen"/.xml file


        // grab all the View objects we need to interact with from the layout file
        TextView resultText = findViewById(R.id.text_view_result);

        RadioButton maleButton = findViewById(R.id.radio_button_male);
        RadioButton femaleButton = findViewById(R.id.radio_button_female);

        EditText ageEditText = findViewById(R.id.edit_text_age);
        EditText feetEditText = findViewById(R.id.edit_text_feet);
        EditText inchesEditText = findViewById(R.id.edit_text_inches);
        EditText weightEditText = findViewById(R.id.edit_text_weight);

        Button calculateButton = findViewById(R.id.button_calculate);


    }
}