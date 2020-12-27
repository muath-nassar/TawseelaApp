package com.muath.tawseelaapp;

import com.muath.tawseelaapp.interfaces_mock_muath.MobileVerificationActivity;
import com.muath.tawseelaapp.interfaces_mock_muath.Registration;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;

@RunWith(MockitoJUnitRunner.class)
public class MuathClassForTesting {
    @Mock
    MobileVerificationActivity activityMobileVerify;
    @Mock
    Registration registration;

    @BeforeClass
    public static void setup(){
        System.out.println("Testing begins");

    }
    @AfterClass
    public static void tearDown(){
        System.out.println("Testing ends");

    }
    @Test
    public void testSharedPref(){
        boolean flag = registration.writeIdToSharedPreferences("123456789");
        Assert.assertTrue(flag);
    }
    @Test
    public void testNumbersCodeIs6(){
        boolean flag = activityMobileVerify.isAll6NumbersEntered(
                "t1",
                "t1",
                "t1",
                "t1",
                "t1",
                "t1"
        );
        Assert.assertTrue(flag);
    }
    @Test
    public void testNumbersCodeIs6WithErrorExpected(){
        boolean flag = activityMobileVerify.isAll6NumbersEntered(
                "t1",
                "t1",
                "t1",
                "t1",
                "t1",
                ""
        );
        Assert.assertFalse(flag);
    }
}
