package com.muath.tawseelaapp;


import com.muath.tawseelaapp.interfaces_mock_majed.add_tawseela;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class MajedClassForTesting {

    @Mock
    add_tawseela activityAdd_tawseela;

    @Test
    public void addToSharedPreftest(){

        Assert.assertTrue(activityAdd_tawseela.addRequestToSharedPreferences(
                "food",
                40.0,
                2.0,
                3.2,
                "10:00pm",
                "fridday"));
    }

}
