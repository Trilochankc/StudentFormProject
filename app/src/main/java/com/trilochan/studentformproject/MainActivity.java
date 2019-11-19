package com.trilochan.studentformproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private Button Btnsave;
    private TextView txtresult;

    private RadioGroup radioGroupId;
    private RadioButton radioGenderButton;
    private Button button;


    Spinner spinner;
    private AutoCompleteTextView autoCompleteTextView;
    private String[] language = {"C", "C++", "C#", "JAVA", "PYTHON"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for name entry
        Name =findViewById(R.id.edttextName);
        //Soinner starts
        Spinner spinner = (Spinner) findViewById(R.id.country);
        autoCompleteTextView = findViewById(R.id.auto);

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Kathmandu");
        spinnerArray.add("Bhaktapur");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.select_dialog_item,
                language
        );
        autoCompleteTextView.setAdapter(stringArrayAdapter);
        autoCompleteTextView.setThreshold(1);
            addButtonListener();

    }

    public void addButtonListener() {

        radioGroupId = (RadioGroup) findViewById(R.id.radioGenderGroup);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                // get the selected radio button from the group
                int selectedOption = radioGroupId.getCheckedRadioButtonId();

                // find the radiobutton by the previously returned id
                radioGenderButton = (RadioButton) findViewById(selectedOption);

                Toast.makeText(MainActivity.this, radioGenderButton.getText(), Toast.LENGTH_SHORT).show();

            }


});
}
}