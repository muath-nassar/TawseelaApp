package com.muath.tawseelaapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.android.gms.maps.model.LatLng
import com.muath.tawseelaapp.interfaces_mock_muath.Registration
import com.muath.tawseelaapp.muath_models.User
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner
import org.junit.Assert.*
import org.mockito.Mockito.mock
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import javax.annotation.meta.When

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class MuathTestingClass{
    @Mock
    lateinit var reg: Registration

    @Test
    fun testRegistration() {

        // Context of the app under test.
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // assertEquals("wn.it.dev.yasser.tawsila", context.packageName)
        val user = User()
        val test = reg.registerNewUser(user, "555555")
        CountDownLatch(1).await(5, TimeUnit.SECONDS)
        assertTrue(test)

    }
}
