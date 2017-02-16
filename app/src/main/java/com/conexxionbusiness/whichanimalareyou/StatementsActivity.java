package com.conexxionbusiness.whichanimalareyou;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StatementsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private StatementBank mStatementBank = new StatementBank();
    private List<Statement> mStatements = new ArrayList<Statement>();
    private List<String> mOptions = new ArrayList<String>();
    private TextView mStatementView;
    private Button mSubmitAnswer;
    private int mStatementCounter = 0;
    private Spinner mSpinner;
    private int mScore = 0;
    private RelativeLayout mRelativeLayoutActivityStatements;
    private ColorWheel mColorWheel = new ColorWheel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statements);

        // Get activity IDs
        mStatementView = (TextView) findViewById(R.id.statementView);
        mSubmitAnswer = (Button) findViewById(R.id.submitButton);
        mSpinner = (Spinner) findViewById(R.id.statementSpinner);
        mRelativeLayoutActivityStatements = (RelativeLayout) findViewById(R.id.activity_statements);

        // Get statements
        mStatements = mStatementBank.loadStatements();
        // Get the options
        mOptions = mStatementBank.getOptions();
        // Set statement in the textview
        loadStatement();
        // Load spinner
        loadSpinner();



        // Create the listener for the submit button
        View.OnClickListener submitListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sendToast("Selected: " + String.valueOf(mSpinner.getSelectedItem()));

                // Set background color and button text color
                int color = mColorWheel.getColor();
                mRelativeLayoutActivityStatements.setBackgroundColor(color);
                mSubmitAnswer.setTextColor(color);

                // Get the score from selected option
                mScore = 0;
                String selected = String.valueOf(mSpinner.getSelectedItem());
                for (int i = mOptions.size(); i > 0; i--) {
                    if (selected == mOptions.get(i-1)) {
                        mScore = i+1;
                    }
                }

                //Set score
                Animal animal = mStatements.get(mStatementCounter).getAnimal();
                animal.setScore(animal.getScore() + mScore);

                // Repeat process with next statement
                mStatementCounter++;
                loadStatement();
                loadSpinner();
            }
        };
        mSubmitAnswer.setOnClickListener(submitListener);
    }

    private void loadStatement() {
        if (mStatementCounter < mStatements.size()) {
            mStatementView.setText(mStatements.get(mStatementCounter).getStatement());
        } else {
            Animal animal = evaluateScore();
            Context context = getApplicationContext();
            Intent intent = new Intent(context, ResultsActivity.class);
            // Send the animal to the results intent
            Bundle bundle = new Bundle();
            bundle.putSerializable("animal", animal);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }

    private Animal evaluateScore() {
        // Select the animal with highest score
        Animal animalResult = mStatements.get(0).getAnimal();
        for (Statement statement : mStatements) {
            if (statement.getAnimal().getScore() > animalResult.getScore()) {
                animalResult = statement.getAnimal();
            }
        }
        return animalResult;
    }

    private void loadSpinner() {
        mOptions.clear();
        // Spinner listener
        mSpinner.setOnItemSelectedListener(this);
        // Add spinner elements
        mOptions = mStatementBank.getOptions();
        // Create adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mOptions);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // attaching data adapter to spinner
        mSpinner.setAdapter(dataAdapter);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //String item = adapterView.getItemAtPosition(i).toString();
        //sendToast("Selected: " + item);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void sendToast(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

}
