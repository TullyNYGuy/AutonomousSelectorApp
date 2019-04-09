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
    private AutonomousConfigurationFile autonomousConfigurationFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        autonomousConfigurationFile = new AutonomousConfigurationFile();
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
        // Sample Spinner
        //*****************************************************************************************

        // Spinner element
        Spinner spinnerSample = (Spinner) findViewById(R.id.spinnerSample);

        // Spinner click listener
        spinnerSample.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> sampleChoices = new ArrayList<String>();
        sampleChoices.add("");
        sampleChoices.add("Sample Crater");
        sampleChoices.add("Sample Depot");
        sampleChoices.add("Sample Both");
        sampleChoices.add("Don't Sample");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterSampleSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sampleChoices);

        // Drop down layout style - list view with radio button
        dataAdapterSampleSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerSample.setAdapter(dataAdapterSampleSpinner);

        //*****************************************************************************************
        // Depot Spinner
        //*****************************************************************************************

        // Spinner element
        Spinner spinnerDepot = (Spinner) findViewById(R.id.spinnerDepot);

        // Spinner click listener
        spinnerDepot.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> depotChoices = new ArrayList<String>();
        depotChoices.add("");
        depotChoices.add("Claim");
        depotChoices.add("Don't Claim");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterDepotSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, depotChoices);

        // Drop down layout style - list view with radio button
        dataAdapterDepotSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerDepot.setAdapter(dataAdapterDepotSpinner);

        //*****************************************************************************************
        // Park Location Spinner
        //*****************************************************************************************

        // Spinner element
        Spinner spinnerParkLocation = (Spinner) findViewById(R.id.spinnerParkLocation);

        // Spinner click listener
        spinnerParkLocation.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> parkLocationChoices = new ArrayList<String>();
        parkLocationChoices.add("");
        parkLocationChoices.add("Our Crater");
        parkLocationChoices.add("Other Crater");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterParkLocationSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, parkLocationChoices);

        // Drop down layout style - list view with radio button
        dataAdapterParkLocationSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerParkLocation.setAdapter(dataAdapterParkLocationSpinner);


        //*****************************************************************************************
        // Delay Number Entry
        //*****************************************************************************************

        EditText delayEditText = (EditText) findViewById(R.id.editDelayValue);
        double delay = Double.parseDouble(delayEditText.getText().toString().trim());


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String itemSelected = "nothing";
        // On selecting a spinner item
        switch (parent.getId()) {
            case R.id.spinnerHangPosition:
                itemSelected = parent.getItemAtPosition(position).toString();
                switch (itemSelected) {
                    case "Crater Side":
                        autonomousConfigurationFile.setHangLocation(AutonomousConfigurationFile.HangLocation.CRATER_SIDE);
                        break;
                    case "Depot Side":
                        autonomousConfigurationFile.setHangLocation(AutonomousConfigurationFile.HangLocation.DEPOT_SIDE);
                        break;
                    case "Not Hanging":
                        autonomousConfigurationFile.setHangLocation(AutonomousConfigurationFile.HangLocation.DONT_HANG);
                        break;
                }
                break;
            case R.id.spinnerSample:
                itemSelected = parent.getItemAtPosition(position).toString();
                switch (itemSelected) {
                    case "Sample Crater":
                        autonomousConfigurationFile.setSample(AutonomousConfigurationFile.Sample.CRATER_SIDE);
                        break;
                    case "Sample Depot":
                        autonomousConfigurationFile.setSample(AutonomousConfigurationFile.Sample.DEPOT_SIDE);
                        break;
                    case "Sample Both":
                        autonomousConfigurationFile.setSample(AutonomousConfigurationFile.Sample.BOTH);
                        break;
                    case "Don't Sample":
                        autonomousConfigurationFile.setSample(AutonomousConfigurationFile.Sample.NO_SAMPLE);
                        break;
                }
                break;
            case R.id.spinnerDepot:
                itemSelected = parent.getItemAtPosition(position).toString();
                switch (itemSelected) {
                    case "Claim":
                        autonomousConfigurationFile.setClaimDepot(true);
                        break;
                    case "Don't Claim":
                        autonomousConfigurationFile.setClaimDepot(false);
                        break;
                }
                break;
            case R.id.spinnerParkLocation:
                itemSelected = parent.getItemAtPosition(position).toString();
                switch (itemSelected) {
                    case "Our Crater":
                        autonomousConfigurationFile.setParkLocation(AutonomousConfigurationFile.ParkLocation.OUR_CRATER);
                        break;
                    case "Other Crater":
                        autonomousConfigurationFile.setParkLocation(AutonomousConfigurationFile.ParkLocation.OTHER_CRATER);
                        break;
                }
                    break;
                case R.id.

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
