package com.example.fadni.simpleconverter;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private Button clearButton;
    private EditText inputText;
    private TextView result;
    private TextView category;
    private Button selectButton;
    String selected1 = "";
    String selected2 = "";
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        category = (TextView) findViewById(R.id.category);
        result = (TextView) findViewById(R.id.result);
        inputText = (EditText) findViewById(R.id.userInput);
        clearButton = (Button) findViewById(R.id.clearButton);
        preferences = getSharedPreferences("category",MODE_PRIVATE);

        final Spinner input = (Spinner) findViewById(R.id.input);
        final Spinner output = (Spinner) findViewById(R.id.output);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.length_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        input.setAdapter(adapter);
        output.setAdapter(adapter);



        input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected1 = parent.getSelectedItem().toString();

                output.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        selected2 = parent.getSelectedItem().toString();
                        convertUnit();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        selected2 = parent.getSelectedItem().toString();
                        convertUnit();
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        inputText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                convertUnit();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                convertUnit();
            }

            @Override
            public void afterTextChanged(Editable s) {


            }
        });




    }


    private void convertUnit() {
        inputText = (EditText) findViewById(R.id.userInput);
        double answer;
        String s = inputText.getText().toString();
        if (s.length() > 0) {
            double value = Double.parseDouble(s);
            if (selected1.equals("Inches")) {
                if (selected2.equals("Inches")){
                    answer = value;
                    result.setText(String.valueOf(answer));
                }
                if (selected2.equals("Centimeters")){
                    answer = value * 2.54;
                    result.setText(String.valueOf(answer));
                }
                if (selected2.equals("Feet")){
                    answer = value * 0.083;
                    result.setText(String.valueOf(answer));
                }
                if (selected2.equals("Meters")) {
                    answer = value * 0.0254;
                    result.setText(String.valueOf(answer));
                }

                if (selected2.equals("Miles")){
                    answer = value * 1.5783 / 100000;
                    result.setText(String.valueOf(answer));
                }
                if (selected2.equals("Kilometres")){
                    answer = value * 2.54 / 100000;
                    result.setText(String.valueOf(answer));
                }

            }

            if (selected1.equals("Centimeters")) {
                if (selected2.equals("Inches")){
                    answer = value * 0.393701;
                    result.setText(String.valueOf(answer));
                }
                if (selected2.equals("Centimeters")){
                    answer = value;
                    result.setText(String.valueOf(answer));
                }
                if (selected2.equals("Feet")){
                    answer = value * 0.0328;
                    result.setText(String.valueOf(answer));
                }
                if (selected2.equals("Meters")) {
                    answer = value / 100;
                    result.setText(String.valueOf(answer));
                }

                if (selected2.equals("Miles")){
                    answer = value * 6.2137 / 1000000;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Kilometres")){
                    answer = value / 100000;
                    result.setText(String.valueOf(answer));

                }
            }

            if (selected1.equals("Feet")){
                if (selected2.equals("Inches")){
                    answer = value * 12;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Centimeters")){
                    answer = value * 0.3;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Feet")){
                    answer = value ;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Meters")) {
                    answer = value * 0.3;
                    result.setText(String.valueOf(answer));

                }

                if (selected2.equals("Miles")){
                    answer = value * 0.000189394;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Kilometres")){
                    answer = value * 0.0003048;
                    result.setText(String.valueOf(answer));

                }
            }

            if (selected1.equals("Meters")){
                if (selected2.equals("Inches")){
                    answer = value * 39.37;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Centimeters")){
                    answer = value * 100;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Feet")){
                    answer = value * 3.28084;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Meters")) {
                    answer = value ;
                    result.setText(String.valueOf(answer));
                }

                if (selected2.equals("Miles")){
                    answer = value ;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Kilometres")){
                    answer = value / 1000;
                    result.setText(String.valueOf(answer));

                }
            }

            if (selected1.equals("Miles")){
                if (selected2.equals("Inches")){
                    answer = value * 63360;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Centimeters")){
                    answer = value * 160934;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Feet")){
                    answer = value * 52580;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Meters")) {
                    answer = value *1609.34;
                    result.setText(String.valueOf(answer));
                }

                if (selected2.equals("Miles")){
                    answer = value ;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Kilometres")){
                    answer = value * 1.6;
                    result.setText(String.valueOf(answer));

                }
            }

            if (selected1.equals("Kilometers")){
                if (selected2.equals("Inches")){
                    answer = value * 39370;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Centimeters")){
                    answer = value * 100000;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Feet")){
                    answer = value * 3280.84;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Meters")) {
                    answer = value * 1000;
                    result.setText(String.valueOf(answer));

                }

                if (selected2.equals("Miles")){
                    answer = value / 1.6;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Kilometres")){
                    answer = value ;
                    result.setText(String.valueOf(answer));

                }
            }

            if (selected1.equals("Celsius")) {
                if (selected2.equals("Celsius")) {
                    answer = value ;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Fahrenheit")) {
                    answer = (value * 9 /5) + 32 ;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Kelvin")) {
                    answer = value + 273;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Rankine")) {
                    answer = (value + 273.15) * 9 / 5;
                    result.setText(String.valueOf(answer));
                }
            }

            if (selected1.equals("Fahrenheit")) {
                if (selected2.equals("Celsius")) {
                    answer = (value - 32) / 9 * 5;
                    result.setText(String.valueOf(answer));
                }
                if (selected2.equals("Fahrenheit")) {
                    answer = value ;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Kelvin")) {
                    answer = ((value - 32) / 9 * 5) + 273;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Rankine")) {
                    answer = value + 459.67;
                    result.setText(String.valueOf(answer));
                }
            }

            if (selected1.equals("Kelvin")){
                if (selected2.equals("Celsius")){
                    answer = value - 273;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Fahrenheit")){
                    answer = (value * 9 / 5) - 459.67;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Kelvin")){
                    answer = value ;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Rankine")){
                    answer = value * 9/5;
                    result.setText(String.valueOf(answer));
                }
            }
            if (selected1.equals("Rankine")) {
                if (selected2.equals("Celsius")) {
                    answer = (value - 491.67) * 5 / 9;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Fahrenheit")) {
                    answer = value - 459.67;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Kelvin")) {
                    answer = value * 5/ 9;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Rankine")) {
                    answer = value ;
                    result.setText(String.valueOf(answer));
                }
            }
            if (selected1.equals("Kilograms")) {
                if (selected2.equals("Kilograms")) {
                    answer = value;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Grams")) {
                    answer = value *1000;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Ounces")) {
                    answer = value * 35.274;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Pounds")) {
                    answer = value * 2.2;
                    result.setText(String.valueOf(answer));
                }
            }
            if (selected1.equals("Grams")) {
                if (selected2.equals("Kilograms")) {
                    answer = value / 1000;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Grams")) {
                    answer = value ;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Ounces")) {
                    answer = value * 35.274 / 1000;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Pounds")) {
                    answer = value * 2.2 /1000;
                    result.setText(String.valueOf(answer));
                }
            }
            if (selected1.equals("Ounces")) {
                if (selected2.equals("Kilograms")) {
                    answer = value * 0.028;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Grams")) {
                    answer = value * 28;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Ounces")) {
                    answer = value ;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Pounds")) {
                    answer = value * 0.063;
                    result.setText(String.valueOf(answer));
                }
            }
            if (selected1.equals("Pounds")) {
                if (selected2.equals("Kilograms")) {
                    answer = value * 0.45;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Grams")) {
                    answer = value * 453.59;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Ounces")) {
                    answer = value * 16;
                    result.setText(String.valueOf(answer));

                }
                if (selected2.equals("Pounds")) {
                    answer = value ;
                    result.setText(String.valueOf(answer));
                }
            }




        }
    }


    public void onClick(View view){
        clearButton = (Button) findViewById(R.id.clearButton);
        selectButton = (Button) findViewById(R.id.select);
        result = (TextView) findViewById(R.id.result);
        inputText = (EditText) findViewById(R.id.userInput);
        if (view == clearButton){
            result.setText("0");
            inputText.setText("0");
        }
        if (view == selectButton){
            Intent intent = new Intent(this,settings.class);
            startActivity(intent);
            }
        }

    @Override
    protected void onStart(){
        super.onStart();
        final Spinner input = (Spinner) findViewById(R.id.input);
        final Spinner output = (Spinner) findViewById(R.id.output);
        category = (TextView) findViewById(R.id.category);
        String getCategory = preferences.getString("category","length");
        if (getCategory.equals("length")){
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.length_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            input.setAdapter(adapter);
            output.setAdapter(adapter);
            category.setText("Length Conversion");

        }
        if (getCategory.equals("temp")){
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.temp_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            input.setAdapter(adapter);
            output.setAdapter(adapter);
            category.setText("Temperature Conversion");
        }
        if (getCategory.equals("mass")){
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.mass_array, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            input.setAdapter(adapter);
            output.setAdapter(adapter);
            category.setText("Mass Conversion");
        }
}
}















/**
input.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
Object selected1 = parent.getItemAtPosition(position);
final String converted1 = selected1.toString();
output.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

@Override
public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
Object selected2 = parent.getItemAtPosition(position);
String converted2 = selected2.toString();
if (converted1.equals(converted2)){
result.setText(value);
}
}

@Override
public void onNothingSelected(AdapterView<?> parent) {

}
});
}

@Override
public void onNothingSelected(AdapterView<?> parent) {

}
});





 public void spinnerLength(){

 result = (TextView) findViewById(R.id.result);

 Spinner input = (Spinner) findViewById(R.id.input);
 final Spinner output = (Spinner) findViewById(R.id.output);
 ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
 R.array.length_array, android.R.layout.simple_spinner_item);
 adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
 input.setAdapter(adapter);
 output.setAdapter(adapter);
 String selected1 = input.getSelectedItem().toString();
 String selected2 = output.getSelectedItem().toString();
 checker(selected1,selected2);
 }


 public void checker(final String selected1, final String selected2){
 result = (TextView) findViewById(R.id.result);
 inputText = (EditText) findViewById(R.id.userInput);
 calculateButton = (Button) findViewById(R.id.calculateButton);
 calculateButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
if (selected1.equalsIgnoreCase("meters")){
System.out.println("OIOIOIOIOIOIOIOIOIOIOIOI");
}
}
});







 public void onClick(View view){

 reverseButton = (Button) findViewById(R.id.reverseButton);
 clearButton = (Button) findViewById(R.id.clearButton);
 inputText = (EditText) findViewById(R.id.inputText);
 outputUnit = (TextView) findViewById(R.id.outputUnit);
 inputUnit = (TextView) findViewById(R.id.inputUnit);
 temp = (TextView) findViewById(R.id.temp);



 if (view == reverseButton){
 temp.setText(inputUnit.getText());
 inputUnit.setText(outputUnit.getText());
 outputUnit.setText(temp.getText());
 maths();
 }

 if (view == clearButton){
 inputText.setText("0");
 }
 }

 public void maths(){
 inputText = (EditText) findViewById(R.id.inputText);
 outputText = (TextView) findViewById(R.id.outputText);
 inputText.addTextChangedListener(new TextWatcher() {
@Override
public void beforeTextChanged(CharSequence s, int start, int count, int after) {

}

@Override
public void onTextChanged(CharSequence s, int start, int before, int count) {
int input = Integer.parseInt(s.toString());
double output = input * 0.393701;
String converted = Double.toString(output);
outputText.setText(converted);
}

@Override
public void afterTextChanged(Editable s) {
int input = Integer.parseInt(s.toString());
double output = input * 0.393701;
String converted = Double.toString(output);
outputText.setText(converted);

}
});
 }

 **/