package com.mahdi_abdurrahman.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private String lineEnd;

    public Validator() {
        this.lineEnd = "\n";
    }

    public Validator(String lineEnd) {
        this.lineEnd = lineEnd;
    }

    public String isPresent(String value, String name) {
        String msg = "";
        if (value.isEmpty()) {
            msg = name + " is required." + lineEnd;
        }
        return msg;

    }//end of the isPresent Method

    public String isDouble(String value, String name) {
        String msg = "";
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            msg = name + " must be a valid number." + lineEnd;
        }
        return msg;

    }//end of the isDouble Method

    public String isInteger(String value, String name) {
        String msg = "";
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            msg = name + " must be an integer." + lineEnd;
        }
        return msg;

    }//end of the isInteger Method

    public String isEmailValid(String value, String name) {
        String msg = "";
        String emailRegex = "^[A-Za-z\\.\\-_0-9]*[@][A-Za-z]*[\\.][a-z]{2,4}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(value);

        if (value.isEmpty()) {
            msg += value + "Email address is required!" + lineEnd;

        } else if (!matcher.matches()) {
            msg += name + " enter valid email address!" + lineEnd;
        }
        return msg;

    }//end of the isEmailValid Method

    public String isFullNameValid(String value, String name) {
        String msg = "";
        String fullNameRegex = "^([a-zA-Z]{2,}\\s[a-zA-z]{1,}'?-?[a-zA-Z]{1,}\\s?([a-zA-Z]{1,})?)";
        Pattern pattern = Pattern.compile(fullNameRegex);
        Matcher matcher = pattern.matcher(value);

        if (value.isEmpty()) {
            msg += value + "First and last name is required!" + lineEnd;

        } else if (!matcher.matches()) {
            msg += name + " enter your first and last name!" + lineEnd;
        }

        return msg;

    }//end of the isFullNameValid Method

    public String isPasswordValid(String value, String name) {
        String msg = "";
        /*Minimum eight characters, at least one uppercase letter, one lowercase letter,
         one number and one special character:*/
        String passwordRegex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(value);

        if (value.isEmpty()) {
            msg += value + "Password is required!" + lineEnd;

        } else if (!matcher.matches()) {
            msg += name + " entered is invalid!" + lineEnd;
        }

        return msg;
    }//end of the isPasswordValid Method

}//end of the Validator Class
