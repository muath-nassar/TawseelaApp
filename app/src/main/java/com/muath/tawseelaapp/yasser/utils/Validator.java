package com.muath.tawseelaapp.yasser.utils;

import android.app.Activity;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

import java.util.regex.Pattern;

import app.com.coronaapp.R;

import static com.basgeekball.awesomevalidation.ValidationStyle.BASIC;

/**
 * Created by ibraheem on 29/06/2017.
 */

public class Validator {

    public static String regexBoxNumber = "^[0-9]$";

    public static String regexDate = "[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])";
    // private static String reqexPhone = "(((009|\\+9)|(?=.*[1-9]))).{9,18}";
    public static String reqexPhone = "((?=.*[1-9])).{9,13}";

    public static String regexTextArea = "^(?!\\s*$).+";
    // public static String regexTextArea = "^(?!(\\s|\\n|\\t|\\x0B|\\f|\\r|\\S)*).+";
    // public static String regexMultilineTextArea = "^(?=\\\\s*\\\\S).*$";
    public static String regexMultilineTextArea = regexTextArea;
    public static String regexTransferNumber = "(?=.*[0-9])";
    public static String regexName = "^(?!\\s*$).+";
    public static String regexGender = "(male|female|Male|Female)";
    public static String regexTime = "^([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$";
    public static String regexPrice = "^\\d{0,8}(\\.\\d{1,4})?$";
    public static String regexHeight = "^.{10,275}$";
    public static String regexCarSpeed = "((?=.*[0-9]))";
    public static String regexWeight = "^.{1,500}$";
    public static String regexCodeNumber = "((?=.*[0-9])).{6}";
    public static String regexOptionalEmailAddress = "^$|[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
            "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+";


    // private static String regexYouTubeUrl = "^(https?\\:\\/\\/)?((www\\|m\\).youtube\\.com|youtu\\.?be)\\/.+$";
    public static String regexYouTubeUrl = "(?:https?:\\/\\/)?(?:(www|m)\\.)?youtu\\.?be(?:\\.com)?\\/?.*(?:watch|embed)?(?:.*v=|v\\/|\\/)([\\w\\-_]+)\\&?";
    ///private static String regexPrice = "^[1-9]\\d{0,7}(?:\\.\\d{1,4})?$";
    //private static String reqexPhone = "^(?:0|\\(?\\+966\\)?\\s?|00966\\s?)[1-79](?:[\\.\\-\\s]?\\d\\d){4}$";
//    public static String regexPassword = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{6,}";

    public static String regexPassword = "[0-9a-zA-Z~`!@#\\\\$%\\\\^&\\\\*\\\\(\\\\)\\\\-_\\\\+=\\\\{\\\\}\\\\[\\\\]\\\\|\\\\;:\\\"<>,./\\\\0-9]{6,}";
    AwesomeValidation mAwesomeValidation;
    Activity mContext;

    public Validator(Activity context, ValidationStyle validationStyle) {
        mAwesomeValidation = new AwesomeValidation(validationStyle);
        mContext = context;
        mAwesomeValidation.setContext(mContext);
    }


    public Validator(Activity context) {
        mAwesomeValidation = new AwesomeValidation(BASIC);
        mContext = context;
    }


    public void validateUserName(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexName, R.string.err_name);
    }

    public void validateFirstName(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexName, R.string.err_title);
    }

    public void validateLastName(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexName, R.string.err_desc);
    }

    public void validateEditText(EditText editText, String pattern, int str) {
        mAwesomeValidation.addValidation(editText, Pattern.compile(pattern), mContext.getResources().getString(str));
    }

    public void validateEditText(EditText editText, Pattern pattert, int str) {
        mAwesomeValidation.addValidation(editText, pattert, mContext.getResources().getString(str));
    }


    public void validateEmail(int id) {
        mAwesomeValidation.addValidation(mContext, id, android.util.Patterns.EMAIL_ADDRESS, R.string.err_email);
    }

    public void validateOpationalEmail(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexOptionalEmailAddress, R.string.err_email);
    }

    public void validatePassword(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexPassword, R.string.err_password);
    }

    public void validateConfirmPassword(int idPassword, int idConfirm) {
        mAwesomeValidation.addValidation(mContext, idConfirm, idPassword, R.string.err_password_confirmation);

    }

    public void validatePhone(int id) {
        mAwesomeValidation.addValidation(mContext, id, reqexPhone, R.string.invalid);

    }

    public void validateHeight(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexHeight, R.string.err_height);

    }

    public void validateWeight(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexWeight, R.string.err_weight);

    }

    public void validateCode(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexCodeNumber, R.string.err_code_number);

    }

    public void validateTrackedNumber(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexCarSpeed, R.string.err_speed_tracked);

    }


    public void validateDate(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexDate, R.string.err_date);

    }


    public void validateTextArea(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexTextArea, R.string.err_empty);

    }

    public void validateInput(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexName, R.string.err_add_data);

    }

    public void validatePrice(int id) {
        mAwesomeValidation.addValidation(mContext, id, regexPrice, R.string.err_add_price);

    }

    public void validateClear() {
        mAwesomeValidation.clear();

    }


    public boolean isValid() {
        return mAwesomeValidation.validate();
    }


}
