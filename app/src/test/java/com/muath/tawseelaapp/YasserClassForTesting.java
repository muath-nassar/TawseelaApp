package com.muath.tawseelaapp;

import com.muath.tawseelaapp.interfaces_mock_muath.MobileVerificationActivity;
import com.muath.tawseelaapp.interfaces_mock_muath.Registration;
import com.muath.tawseelaapp.interfaces_mock_yasser.ChatActivity;
import com.muath.tawseelaapp.interfaces_mock_yasser.Notifi;
import com.muath.tawseelaapp.interfaces_mock_yasser.NotificationActicity;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.Mock;


@RunWith(MockitoJUnitRunner.class)
public class YasserClassForTesting {
    @Mock
    ChatActivity chatActivity;
    @Mock
    NotificationActicity notificationActicity;

    @BeforeClass
    public static void setup(){
        System.out.println("Testing begins");
    }

    @Test
    public void testSharedPref(){
        String flag = chatActivity.sendNotifi(1, 2, "Hi");
        Assert.assertTrue(Boolean.parseBoolean(flag));
    }

    @Test
    public void testChat_sendNotifi(){
        String flag = chatActivity.sendNotifi(
                1,
                2,
                "t1");
        Assert.assertTrue(Boolean.parseBoolean(flag));
    }

    @Test
    public void testChat_sendNotifi_WithErrorExpected(){
        String flag = chatActivity.sendNotifi(
                1,
                2,
                "");
        Assert.assertTrue(Boolean.parseBoolean(flag));
    }

    @Test
    public void testContentTxtNotifi(){
        String flag = notificationActicity.txtNotifi("Hi");
        Assert.assertTrue(Boolean.parseBoolean(flag));
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Testing ends");
    }
}
