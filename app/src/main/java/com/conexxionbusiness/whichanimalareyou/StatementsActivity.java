package com.conexxionbusiness.whichanimalareyou;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StatementsActivity extends AppCompatActivity {
    private StatementBank mStatementBank = new StatementBank();
    private List<Statement> mStatements = new ArrayList<Statement>();
    private List<String> mOptions = new ArrayList<String>();
    private TextView mStatementView;
    private Button mSubmitAnswer;
    private int mStatementCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statements);

        // Get activity IDs
        mStatementView = (TextView) findViewById(R.id.statementView);
        mSubmitAnswer = (Button) findViewById(R.id.submitButton);

        // Get statements
        mStatements = mStatementBank.loadStatements();
        // Get the options
        mOptions = mStatementBank.getOptions();
        // Set statement in the textview
        loadStatement();

        // Create the listener for the submit button
        View.OnClickListener submitListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code after button was clicked
                mStatementCounter++;
                loadStatement();
            }
        };
        mSubmitAnswer.setOnClickListener(submitListener);
    }

    private void loadStatement() {
        if (mStatementCounter < mStatements.size()) {
            mStatementView.setText(mStatements.get(mStatementCounter).getStatement());
        } else {
            Context context = getApplicationContext();
            Intent intent = new Intent(context, EvaluationActivity.class);
            startActivity(intent);
        }
    }

}
