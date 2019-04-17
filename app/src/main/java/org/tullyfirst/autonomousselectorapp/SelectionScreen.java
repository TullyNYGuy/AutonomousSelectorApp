package org.tullyfirst.autonomousselectorapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.List;

// need the OnClickListener to handle the button click
// need the OnItemSelectedListener to handle the spinner selection
public class SelectionScreen extends AppCompatActivity implements AdapterView.OnItemSelectedListener, OnClickListener {
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
        // Alliance Color Spinner
        //*****************************************************************************************

        // Spinner element
        Spinner spinnerAllianceColor = (Spinner) findViewById(R.id.spinnerAllianceColor);

        // Spinner click listener
        spinnerAllianceColor.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> allianceColor = new ArrayList<String>();
        allianceColor.add("");
        allianceColor.add("Red");
        allianceColor.add("Blue");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterAllianceColorSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, allianceColor);

        // Drop down layout style - list view with radio button
        dataAdapterAllianceColorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerAllianceColor.setAdapter(dataAdapterAllianceColorSpinner);

        //*****************************************************************************************
        // Match Number Spinner
        //*****************************************************************************************

        // Spinner element
        Spinner spinnerMatchNumber = (Spinner) findViewById(R.id.spinnerMatchNumber);

        // Spinner click listener
        spinnerMatchNumber.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> matchNumber = new ArrayList<String>();
        matchNumber.add("Practice");
        matchNumber.add("1");
        matchNumber.add("2");
        matchNumber.add("3");
        matchNumber.add("4");
        matchNumber.add("5");
        matchNumber.add("6");
        matchNumber.add("7");
        matchNumber.add("8");
        matchNumber.add("9");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterMatchNumberSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, matchNumber);

        // Drop down layout style - list view with radio button
        dataAdapterMatchNumberSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerMatchNumber.setAdapter(dataAdapterMatchNumberSpinner);

        //*****************************************************************************************
        // Delay Number Entry
        //*****************************************************************************************

        // all of the code below runs at init time to setup the app user interface
        // the user has not even had a chance to change the delay value yet so this is on the wrong
        // place. It needs to be when the user has entered a delay value.

        EditText delayEditText = (EditText) findViewById(R.id.editDelayValue);
        double delay = Double.parseDouble(delayEditText.getText().toString().trim());

        if (delay > 30) {
            delay = 0;

            // Toast myToast = Toast.makeText(this, message, duration);
            Toast delayValue = Toast.makeText(this, "Maximum Value Exeeded (Max: 30)", Toast.LENGTH_SHORT);

            delayValue.show();
        }

        //*****************************************************************************************
        // Full send Button - setup a listener for button clicks
        //*****************************************************************************************

        Button button = (Button) findViewById(R.id.buttonFullSend);
        button.setOnClickListener(this);
    }

    /**
     * This is the handler for the full send button getting clicked.
     *
     * @param view
     */
    @Override
    public void onClick(View view) {

        // the switch is not really needed now since there is only one button. But it shows how you
        // would handle multiple buttons. Just use a case for the id on each.
        switch (view.getId()) {
            case R.id.buttonFullSend:
                // when the full send button is clicked check the value of the delay
                EditText delayEditText = (EditText) findViewById(R.id.editDelayValue);
                double delay = Double.parseDouble(delayEditText.getText().toString().trim());

                // delay can't be bigger than 30 seconds. If it is set it back to 0
                if (delay > 30) {
                    delay = 0;
                    delayEditText.setText(String.valueOf(delay));
                    // show a toast to warn the user that the value has been changed - you can do it Jared!

                }

                // now set the delay in the config file object - you can do it Jared!

                // do we have write permissions to the config file? If not the method will ask for permission.
                if (isWriteStoragePermissionGranted()) {
                    // yes so write it
                    writeConfigFile();
                }
                break;
        }

    }

    // codes for read and write permissions - the number is not important. It just has to be something.
    private static final int READ = 1;
    private static final int WRITE = 2;

    /**
     * Check if we have read permissions to external storage area. If not ask the user to allow us to
     * read external storage.
     *
     * @return
     */
    public boolean isReadStoragePermissionGranted() {
        boolean permissionGranted = false;

        // if android version is less than 23 there are no read permissions needed
        if (Build.VERSION.SDK_INT >= 23) {
            // versions 23 and up require you to get permission
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                permissionGranted = true;
            } else {
                // We do not have permission. So make a request to the user for permission.
                // This request creates a dialog box that the user has to answer to give permission.
                // The answer is asynchronous. In other words this call return immediately and does not wait for an answer.
                // When the answer does come, it uses a callback onRequestPermissionsResult() to provide the answer.
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, READ);
                permissionGranted = false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            permissionGranted = true;
        }
        return permissionGranted;
    }

    /**
     * Check if we have write permissions to external storage. If not ask the user to allow us to
     * write to external storage.
     *
     * @return
     */
    public boolean isWriteStoragePermissionGranted() {
        boolean permissionGranted = false;
        // if android version is less than 23 there are no read permissions needed
        if (Build.VERSION.SDK_INT >= 23) {
            // versions 23 and up require you to get permission
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                permissionGranted = true;
            } else {
                // We do not have permission. So make a request to the user for permission.
                // This request creates a dialog box that the user has to answer to give permission.
                // The answer is asynchronous. In other words this call return immediately and does not wait for an answer.
                // When the answer does come, it uses a callback onRequestPermissionsResult() to provide the answer.
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE);
                permissionGranted = false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            permissionGranted = true;
        }
        return permissionGranted;
    }

    /**
     * This method is called when the user answers whether to give the app permission to read or write
     * to an external file. If we get permission we write the config file.
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case WRITE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //resume tasks needing this permission
                    writeConfigFile();
                } else {
                    // do something to handle write permissions denied - or maybe do nothing
                }
                break;

            // this case is just a placeholder for now. We don't actually read anything at this
            // time
            case READ:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // you got permission to read. do something with it
                } else {
                    // do something to handle read permissions denied
                }
                break;
        }
    }

    /**
     * Write the config file and show a message that it was done.
     */
    private void writeConfigFile() {
        autonomousConfigurationFile.writeConfigurationFile();
        Toast writeSuccessToast = Toast.makeText(this, "Wrote config file", Toast.LENGTH_SHORT);
        writeSuccessToast.show();
    }

    /**
     * terminate the app
     */
    private void terminateApp() {
        Toast closeToast = Toast.makeText(this, "Closing app ...", Toast.LENGTH_SHORT);
        closeToast.show();
        // delay for 5 seoonds then quite the app
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        }, 5000);
        finish();
    }

    /**
     * This is the handler for a spinner selection
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String itemSelected = "nothing";
        // On selecting a spinner item figure out which spinner was selected by getting the id and
        // doing a switch on it.
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
            case R.id.spinnerAllianceColor:
                itemSelected = parent.getItemAtPosition(position).toString();
                switch (itemSelected) {
                    case "Red":
                        autonomousConfigurationFile.setAllianceColor(AutonomousConfigurationFile.AllianceColor.RED);
                        break;
                    case "Blue":
                        autonomousConfigurationFile.setAllianceColor(AutonomousConfigurationFile.AllianceColor.BLUE);
                        break;
                }
            case R.id.spinnerMatchNumber:
                itemSelected = parent.getItemAtPosition(position).toString();
                switch (itemSelected) {
                    case "Practice":
                        autonomousConfigurationFile.setMatchNumber(AutonomousConfigurationFile.MatchNumber.PRACTICE);
                        break;
                    case "1":
                        autonomousConfigurationFile.setMatchNumber(AutonomousConfigurationFile.MatchNumber.ONE);
                        break;
                    case "2":
                        autonomousConfigurationFile.setMatchNumber(AutonomousConfigurationFile.MatchNumber.TWO);
                        break;
                    case "3":
                        autonomousConfigurationFile.setMatchNumber(AutonomousConfigurationFile.MatchNumber.THREE);
                        break;
                    case "4":
                        autonomousConfigurationFile.setMatchNumber(AutonomousConfigurationFile.MatchNumber.FOUR);
                        break;
                    case "5":
                        autonomousConfigurationFile.setMatchNumber(AutonomousConfigurationFile.MatchNumber.FIVE);
                        break;
                    case "6":
                        autonomousConfigurationFile.setMatchNumber(AutonomousConfigurationFile.MatchNumber.SIX);
                        break;
                    case "7":
                        autonomousConfigurationFile.setMatchNumber(AutonomousConfigurationFile.MatchNumber.SEVEN);
                        break;
                    case "8":
                        autonomousConfigurationFile.setMatchNumber(AutonomousConfigurationFile.MatchNumber.EIGHT);
                        break;
                    case "9":
                        autonomousConfigurationFile.setMatchNumber(AutonomousConfigurationFile.MatchNumber.NINE);
                        break;
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
