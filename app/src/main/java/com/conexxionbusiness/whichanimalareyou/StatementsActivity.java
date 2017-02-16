package com.conexxionbusiness.whichanimalareyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class StatementsActivity extends AppCompatActivity {
    StatementBank mStatementBank = new StatementBank();
    List<Statement> mStatements = new ArrayList<Statement>();
    List<String> mOptions = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statements);

        // Get statements
        mStatements = mStatementBank.loadStatements();
        // Get the options
        mOptions = mStatementBank.getOptions();

    }
}
