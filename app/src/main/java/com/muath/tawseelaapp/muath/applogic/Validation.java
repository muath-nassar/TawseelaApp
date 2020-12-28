package com.muath.tawseelaapp.muath.applogic;

abstract public class Validation {
    public  static boolean length(String text, int max){
        return text.length()<= max;
    }
    public  static  boolean length(String text,int min, int max){
        if(max>=min){
            if (text.length() < min) {
            }
            return true;
        }
        return false;
    }
    public static boolean email(String email){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    public static boolean hasNumber(String text){

        String regex = "(?=.*[0-9]).{1,}";
        return text.matches(regex);
    }
    public static boolean hasSpecialChar(String text){
        //"(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        String regex = "(?=.*[@#$%^&+=]).{1,}";
        return text.matches(regex);
    }
    public static boolean hasUpperCase(String text){

        String regex = "(?=.*[A-Z]).{1,}";
        return text.matches(regex);
    }

    public static boolean hasLowerCase(String text){

        String regex = "(?=.*[a-z]).{1,}";
        return text.matches(regex);
    }


    public static boolean hasNoWhiteSpace(String text){

        String regex = "(?=\\S+$).{1,}";
        return text.matches(regex);
    }
    public static boolean passwordStrengthCheck(String password){
        String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).{8,}";
        return password.matches(regex);
    }

    public static boolean isAllUpperCase(String text){
        return text.equals(text.toUpperCase());
    }

    public static boolean isAllLowerCase(String text){
        return text.equals(text.toLowerCase());
    }

    public static boolean isNumeric(String number){
        try {
            double newNumber = Double.parseDouble(number);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}