package com.conexxionbusiness.whichanimalareyou;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {
    private Animal mAnimal;
    private TextView mAnimalNameView;
    private ImageView mTryAgainImage;
    private RelativeLayout mResultsActivity;
    private boolean mChupacabra = false;
    private TextView mCaptionView;
    private EditText mEditCaptionView;
    private Button mSaveButton;
    //private Button mExitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Get view IDs
        mAnimalNameView = (TextView) findViewById(R.id.animalNameView);
        mTryAgainImage = (ImageView) findViewById(R.id.tryAgainImage);
        //mExitButton = (Button) findViewById(R.id.exitButton);
        mResultsActivity = (RelativeLayout) findViewById(R.id.activity_results);
        mCaptionView = (TextView) findViewById(R.id.captionView);
        mEditCaptionView = (EditText) findViewById(R.id.editCaptionView);
        mSaveButton = (Button) findViewById(R.id.saveButton);

        // Set caption text to an empty string
        mCaptionView.setText("");

        // Retrieve the animal result from statements activity
        mAnimal = (Animal) getIntent().getExtras().getSerializable("animal");
        mChupacabra = getIntent().getExtras().getBoolean("chupacabra");

        // Set animal name in text view
        if (mChupacabra) {
            mAnimalNameView.setText("Chupacabra");
            sendToast("You are a Chupacabra.");
        } else {
            mAnimalNameView.setText(mAnimal.getName());
            sendToast("You are a " + mAnimal.getName() + ".");
        }

        // Set background image
        showAnimal();

        // Add edit caption text listener
        mEditCaptionView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                mCaptionView.setText(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //mEditCaptionView.setText(editable);
            }
        });

        // Start Save Button listener
        View.OnClickListener saveButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Hide keyboard
                // Got it from one of the answers here http://stackoverflow.com/questions/3553779/android-dismiss-keyboard
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(mEditCaptionView.getWindowToken(), 0);
                // Hide caption edit text
                mEditCaptionView.setVisibility(View.INVISIBLE);
                // Hide save button
                mSaveButton.setVisibility(View.INVISIBLE);
            }
        };
        mSaveButton.setOnClickListener(saveButton);


        // Start Try Again button listener
        View.OnClickListener tryAgainListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                finish();
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
            }
        };
        mTryAgainImage.setOnClickListener(tryAgainListener);


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

    private void showAnimal() {
        Context context = getApplicationContext();
        Drawable d;
        String animalName;
        if (mChupacabra) {
            animalName = "Chupacabra";
        } else {
            animalName = mAnimal.getName();
        }
        switch (animalName) {
            case "Lion" :
                mResultsActivity.setBackgroundResource(R.drawable.lion);
                break;
            case "Penguin" :
                mResultsActivity.setBackgroundResource(R.drawable.penguin);
                break;
            case "Wolf" :
                mResultsActivity.setBackgroundResource(R.drawable.wolf);
                break;
            case "Kangaroo" :
                mResultsActivity.setBackgroundResource(R.drawable.kangaroo);
                break;
            case "Bear" :
                mResultsActivity.setBackgroundResource(R.drawable.bear);
                break;
            case "Chupacabra" :
                mResultsActivity.setBackgroundResource(R.drawable.chupacabra);
                break;
            default:
                mResultsActivity.setBackgroundResource(R.drawable.chupacabra);
        }
    }

    private void sendToast(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    // Disable the back button functionality
    // Got it from http://stackoverflow.com/questions/4779954/disable-back-button-in-android
    @Override
    public void onBackPressed() {
        // I could also start a new activity here, like going back to mainactivity
    }

}
