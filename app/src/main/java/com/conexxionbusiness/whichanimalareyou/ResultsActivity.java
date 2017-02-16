package com.conexxionbusiness.whichanimalareyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    private Animal mAnimal;
    private TextView mAnimalNameView;
    private Button mTryAgainButton;
    //private Button mExitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Get view IDs
        mAnimalNameView = (TextView) findViewById(R.id.animalNameView);
        mTryAgainButton = (Button) findViewById(R.id.tryAgainButton);
        //mExitButton = (Button) findViewById(R.id.exitButton);

        // Retrieve the animal result from statements activity
        mAnimal = (Animal) getIntent().getExtras().getSerializable("animal");

        // Set animal name in text view
        mAnimalNameView.setText(mAnimal.getName());


        // Start Try Again button listener
        View.OnClickListener tryAgainListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
        mTryAgainButton.setOnClickListener(tryAgainListener);


        /*
        // Start Exit button listener
        View.OnClickListener exitListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        };
        mExitButton.setOnClickListener(exitListener);
        */
    }

}
