package com.muath.tawseelaapp.yasser.helper;

import androidx.fragment.app.Fragment;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import app.com.coronaapp.ui.main.fragments.ChatFragment;
import app.com.coronaapp.ui.main.fragments.HomeFragment;
import app.com.coronaapp.ui.main.fragments.StaticFragment;

public class Constant {
    public static final Fragment homeFragment = new HomeFragment();
    public static final Fragment staticFragment = new StaticFragment();
    public static final Fragment chatFragment = new ChatFragment();
    public static final String TYPE_DAILY = "daily";
    public static final String TYPE_TOTAL = "total";

    public static String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
