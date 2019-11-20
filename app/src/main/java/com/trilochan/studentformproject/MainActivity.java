package com.trilochan.studentformproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText etname;
    RadioGroup rdogrp;
    RadioButton rdomale, rdofemale, rdoothers;
    Spinner spcountry;
    TextView tvname, tvgender, tvcountry, tvbatch;
    AutoCompleteTextView actvbatch;
    String[] batch = {"22A", "22B", "22C"};
    Button btnsave;
    Button closeButton;
    AlertDialog.Builder builder;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvbatch = findViewById(R.id.tvbatch);

        tvgender = findViewById(R.id.tvgender);
        tvcountry = findViewById(R.id.tvcountry);
        tvname = findViewById(R.id.tvname);
        etname = findViewById(R.id.etname);
        rdogrp = findViewById(R.id.rdogrp);
        rdomale = findViewById(R.id.rdomale);
        rdofemale = findViewById(R.id.rdofemale);
        rdoothers = findViewById(R.id.rdoother);
        spcountry = findViewById(R.id.spcountry);
        actvbatch = findViewById(R.id.actvbatch);
        btnsave = findViewById(R.id.btnsave);

        //analog display

        builder = new AlertDialog.Builder(this);

        String countries[] = {"Nepal", "India", "Bhutan", "Pakistan", "China"};

        ArrayAdapter adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, countries
                );

        spcountry.setAdapter(adapter);

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, batch);

        actvbatch.setAdapter(stringArrayAdapter);
        actvbatch.setThreshold(1);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setMessage("Do you want to close this application?")
                        .setCancelable(false)
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Toast.makeText(MainActivity.this, "you clicked yes", Toast.LENGTH_SHORT).show();

                                int selectedId = rdogrp.getCheckedRadioButtonId();
                                RadioButton radioButton;
                                radioButton =findViewById(selectedId);
                                tvgender.setText(radioButton.getText());

                                tvname.setText(etname.getText());
                                tvbatch.setText(actvbatch.getText());
                                tvcountry.setText(spcountry.getSelectedItem().toString());
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                Toast.makeText(MainActivity.this, "you clicked no", Toast.LENGTH_SHORT).show();
                            }
                        });

                //creating dialog boc
                AlertDialog alert =  builder.create();
                alert.setTitle("my title");
                alert.show();



            }

        });


    }


}

