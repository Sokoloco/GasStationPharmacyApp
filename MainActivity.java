package com.example.luis.gasstationpharmacyapp;

import android.app.DatePickerDialog;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContentView(R.layout.gestionclientes);

        Button dateBut = (Button)findViewById(R.id.dateButt);

        dateBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"Date Picker");
            }
        });

        Button readyBut = (Button) findViewById(R.id.submitButton);
        readyBut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                JSONHandler jHandler = new JSONHandler();
                String name = ((EditText)findViewById(R.id.nameEditText)).getText().toString();
                String lName = ((EditText)findViewById(R.id.lastNameEditText)).getText().toString();
                String id = ((EditText)findViewById(R.id.iDEditText)).getText().toString();
                String bDate = ((Button)findViewById(R.id.dateButt)).getText().toString();
                String residence = ((EditText)findViewById(R.id.residenceEditText)).getText().toString();
                String numTel = ((EditText)findViewById(R.id.numTelEditText)).getText().toString();
                String history = ((EditText)findViewById(R.id.histEditText)).getText().toString();
                Toast.makeText(getApplicationContext(),"Done",Toast.LENGTH_SHORT).show();
                jHandler.createUser(name,lName,id,residence,bDate,numTel,history,getApplicationContext());
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        String currentDateString = DateFormat.getDateInstance(DateFormat.MEDIUM).format(cal.getTime());
        Button dateBut = (Button)findViewById(R.id. dateButt);
        dateBut.setText(currentDateString);
        /**TextView dateTextView = (TextView)findViewById(R.id.bDateText);
        dateTextView.setText(currentDateString);**/
    }
}