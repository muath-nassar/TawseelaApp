package com.muath.tawseelaapp.interfaces_mock_muath;

import com.muath.tawseelaapp.muath_models.User;

public interface Registration {
    public boolean writeIdToSharedPreferences(String id);
    public boolean registerNewUser(User user, String pass);
}
