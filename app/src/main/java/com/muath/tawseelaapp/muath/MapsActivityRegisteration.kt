package com.muath.tawseelaapp.muath

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.muath.tawseelaapp.R
import com.muath.tawseelaapp.muath.applogic.MapListener
import com.muath.tawseelaapp.muath.applogic.Registration

class MapsActivityRegisteration : AppCompatActivity(), OnMapReadyCallback, MapListener {
    val latLngDefault = LatLng(31.456784148673258, 34.390605742057915)
    var latLng: LatLng = latLngDefault

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_registeration)
        //getLocation


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near latLng, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in latLng and move the camera
        intializeMap()


        mMap.setOnMapClickListener { loc ->
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 16f))
            AlertDialog.Builder(this)
                .setIcon(R.drawable.ic_question)
                .setTitle("تأكيد")
                .setMessage("هل أنت متأكد من اختيار هذا المكان")
                .setPositiveButton("نعم") { _, _ -> doWhenLocationChosed(loc) }
                .show()
        }
    }

    private fun doWhenLocationChosed(loc: LatLng) {
        Registration(this).updateLocation(loc,this)

    }

    private fun intializeMap() {
        Dexter.withContext(this)
            .withPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
            .withListener(object : PermissionListener {
                @SuppressLint("MissingPermission")
                override fun onPermissionGranted(response: PermissionGrantedResponse) {
                    LocationServices.getFusedLocationProviderClient(this@MapsActivityRegisteration)
                        .lastLocation.addOnSuccessListener { location ->
                            try {
                                latLng = location.latitude.let { LatLng(it, location.longitude) }
                            }catch (e:Exception){
                                latLng = latLngDefault
                            }

                        }.addOnFailureListener {
                            Toast.makeText(
                                this@MapsActivityRegisteration,
                                it.localizedMessage,
                                Toast.LENGTH_LONG
                            ).show()
                            latLng = latLngDefault
                        }
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) {
                    latLng = latLngDefault
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest,
                    token: PermissionToken
                ) { /* ... */
                    token.continuePermissionRequest()
                }
            }).check()
        mMap.addMarker(MarkerOptions().position(latLng).title("Marker in Your Location"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14f))
    }

    override fun onSuccess() {

    }

    override fun onError() {

    }
}