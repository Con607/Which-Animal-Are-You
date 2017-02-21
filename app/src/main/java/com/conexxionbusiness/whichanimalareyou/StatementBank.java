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
            "You like to take a nap or two during the day.", "Lion",
            "You believe in monogamy.", "Penguin",
            "You like to socialize and be the leader of the group.", "Wolf",
            "When someone bothers you you feel like throwing a punch or two.", "Kangaroo",
            "When it comes to food you are not picky and eat anything in front of you.", "Bear",
            "You couldn't live without your long hair.", "Lion",
            "You feel like dancing on ice when you're happy!", "Penguin",
            "When enjoying a party you feel like shouting and yelling into the sky!!!", "Wolf",
            "You like to carry your cellphone everywhere, it is your baby!", "Kangaroo",
            "You live by the saying:\n'Life is short, lick the bowl!'", "Bear"/*,
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
