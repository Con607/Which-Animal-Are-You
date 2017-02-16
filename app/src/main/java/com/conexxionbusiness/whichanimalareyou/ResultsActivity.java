package com.conexxionbusiness.whichanimalareyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    private Animal mAnimal;
    private TextView mAnimalNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);

        // Get view IDs
        mAnimalNameView = (TextView) findViewById(R.id.animalNameView);

        // Retrieve the animal result from statements activity
        mAnimal = (Animal) getIntent().getExtras().getSerializable("animal");

        // Set animal name in text view
        mAnimalNameView.setText(mAnimal.getName());
    }

}
