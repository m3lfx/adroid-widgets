package com.example.app4;

import static android.graphics.Color.*;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    EditText name;
    Button ok;
    TextView result;
    String userName;
    ImageView image;
    RadioGroup radioGroup;
    RadioButton red;
    RadioButton green;
    RadioButton yellow;
    LinearLayout layout;
    ToggleButton toggleButton;
    Spinner spinner;
    ArrayAdapter adapter;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.editTextName);
        ok = findViewById(R.id.buttonOk);
        result = findViewById(R.id.textViewResult);
        image = findViewById(R.id.img);
        image.setImageResource(R.drawable.s1);
        radioGroup = findViewById((R.id.radiogroup));
        yellow = findViewById(R.id.radioButtonYellow);
        red = findViewById(R.id.radioButtonRed);
        green = findViewById(R.id.radioButtonGreen);
        layout = findViewById(R.id.layoutLinear);
        toggleButton = findViewById(R.id.toggleButton);
        spinner = findViewById(R.id.spinnerCountry);
        adapter = ArrayAdapter.createFromResource(this, R.array.countries, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String country = adapterView.getItemAtPosition(i).toString();
                result.setText(country);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ok.setOnClickListener(v -> {
            userName = name.getText().toString();
            result.setText(userName);
            image.setImageResource(R.drawable.s2);
            Toast.makeText(getBaseContext(), "toast message", Toast.LENGTH_LONG).show();
            showDialogMessage();
            Snackbar.make(layout, "this is a snackbar", Snackbar.LENGTH_INDEFINITE).setAction("close", new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            }).show();

            if (green.isChecked()) {
                layout.setBackgroundColor(GREEN);
            } else if (red.isChecked()) {
                layout.setBackgroundColor(RED);

            } else {
                layout.setBackgroundColor(YELLOW);
            }

        });
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {


                if (isChecked) {
                    image.setVisibility(View.INVISIBLE);
                    result.setText("hide image");
                } else {
                    image.setVisibility(View.VISIBLE);
                    result.setText("show image");


                }

            }
        });
    }

    private void showDialogMessage() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("alert").setMessage("this is an alert").setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                result.setText("clicked yes");
            }
        }).show();
        alertDialog.create();
    }

}