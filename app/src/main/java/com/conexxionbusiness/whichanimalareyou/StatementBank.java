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
            "Statement 1", "Animal 1",
            "Statement 2", "Animal 2",
            "Statement 3", "Animal 3",
            "Statement 4", "Animal 4",
            "Statement 5", "Animal 5",
            "Statement 6", "Animal 1",
            "Statement 7", "Animal 2",
            "Statement 8", "Animal 3",
            "Statement 9", "Animal 4",
            "Statement 10", "Animal 5"
    };

    private String[] mOptions = {
            "That's me!",
            "Most likely me",
            "Maybe",
            "Unlikely me",
            "Not like me"
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
