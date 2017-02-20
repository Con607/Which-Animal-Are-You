package com.conexxionbusiness.whichanimalareyou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IRVING on 15/02/2017.
 */

public class StatementBank {
    private String[] mStatementsArray = {
            "Statement 1", "Lion",
            "Statement 2", "Penguin",
            "Statement 3", "Wolf",
            "Statement 4", "Kangaroo",
            "Statement 5", "Bear",
            "Statement 6", "Lion",
            "Statement 7", "Penguin",
            "Statement 8", "Wolf",
            "Statement 9", "Kangaroo",
            "Statement 10", "Bear"/*,
            "Statement 11", "Lion",
            "Statement 12", "Penguin",
            "Statement 13", "Wolf",
            "Statement 14", "Kangaroo",
            "Statement 15", "Bear"*/
    };

    private String[] mOptions = {
            "Not like me",
            "Unlikely me",
            "Maybe",
            "Most likely me",
            "That's me!"
    };

    public List<Statement> loadStatements() {
        List<Statement> statements = new ArrayList<Statement>();
        for (int i=0; i < mStatementsArray.length ;i=i+2) {
            Statement statement = new Statement(mStatementsArray[i], mStatementsArray[i+1]);
            statements.add(statement);
        }
        return statements;
    }

    public ArrayList<String> getOptions() {
        List<String> optionsList = new ArrayList<String>();
        Collections.addAll(optionsList, mOptions);
        return (ArrayList<String>) optionsList;
    }
}
