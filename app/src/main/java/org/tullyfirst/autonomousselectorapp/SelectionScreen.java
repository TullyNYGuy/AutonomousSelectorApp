package org.tullyfirst.autonomousselectorapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SelectionScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);

        //*****************************************************************************************
        // Hanging Location Spinner
        //*****************************************************************************************

        // Spinner element
        Spinner spinnerHangingLocation = (Spinner) findViewById(R.id.spinnerHangPosition);

        // Spinner click listener
        spinnerHangingLocation.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> hangingChoices = new ArrayList<String>();
        hangingChoices.add("");
        hangingChoices.add("Crater Side");
        hangingChoices.add("Depot Side");
        hangingChoices.add("Not Hanging");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterHangingSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, hangingChoices);

        // Drop down layout style - list view with radio button
        dataAdapterHangingSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerHangingLocation.setAdapter(dataAdapterHangingSpinner);


        //*****************************************************************************************
        // Delay Number Entry
        //*****************************************************************************************

        EditText delayEditText = (EditText) findViewById(R.id.editDelayValue);
        double delay = Double.parseDouble(delayEditText.getText().toString().trim());

        Toast.makeText(SelectionScreen.this, "Input: " + delay, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String itemSelected = "nothing";
        // On selecting a spinner item
        switch(parent.getId()) {
            case R.id.spinnerHangPosition:
                itemSelected = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinnerSample:
                itemSelected = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinnerDepot:
                itemSelected = parent.getItemAtPosition(position).toString();
                break;
            case R.id.spinnerParkLocation:
                itemSelected = parent.getItemAtPosition(position).toString();
                break;
        }

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + itemSelected, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
