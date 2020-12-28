package com.muath.tawseelaapp;

import android.content.Context;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import interfaces_mock_mahmoud_tawseelaapp.DeleiveryDetails;
import interfaces_mock_mahmoud_tawseelaapp.UserProfile;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class MahmoudClassForTesting {
    Context appContext;

    @Mock
    DeleiveryDetails deleiveryDetails ;
    @Mock
    UserProfile userProfile ;

    @BeforeClass
    public static void beforClassMethod() {
        System.out.println("    @BeforeClass\n");
    }
    @Before
    public  void beforMethod(){
        System.out.println("Befor");
    }
    @Test
    public void useAppContext() {
        // Context of the app under test.
        assertEquals("com.example.explosivesengineering", appContext.getPackageName());
    }
    @Test
    public void test_setAdress(){
        String add= deleiveryDetails.setAddress("Gaza","THE CENTERAL",
                "KALED BN ALWLEED","ALSNA MOSQUE");
        Assert.assertTrue(Boolean.parseBoolean(add));
    }
    /*
    @Test
    public void activityLaunch() {
        onView(withId(R.id.textview_login)).perform(click());
        onView(withId(R.id.username_login))
                .check(matches(isDisplayed()));
        onView(withId(R.id.btn_logout)).perform(click());
        onView(withId(R.id.password_login))
                .check(matches(isDisplayed()));
        onView(withId(R.id.nameOfdetail))
                .check(matches(isDisplayed()));
        onView(withId(R.id.detail))
                .check(matches(isDisplayed()));
    }
    */
    @After
    public void afterMethod(){

        System.out.println("@After");
    }
    @AfterClass
    public static void afterClassMethod(){
        System.out.println("@After Class");
    }
}
