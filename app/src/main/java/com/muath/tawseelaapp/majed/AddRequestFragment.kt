package com.muath.tawseelaapp.majed

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.muath.tawseelaapp.R
import com.muath.tawseelaapp.interfaces_mock_majed.add_tawseela
import com.muath.tawseelaapp.majed.HomeFragment.Companion.Requestlist
import com.muath.tawseelaapp.majed.models.Request
import com.muath.tawseelaapp.muath.MapsActivityRegisteration
import kotlinx.android.synthetic.main.fragment_add_request.view.*
import java.text.SimpleDateFormat
import java.util.*


class AddRequestFragment : Fragment() , add_tawseela {

    val currentTime = Calendar.getInstance()
    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    val currentDate = sdf.format(Date())
    val lat :Double =0.0
    val Lng :Double =0.0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val root =inflater.inflate(R.layout.fragment_add_request, container, false)

        var nameRequest =  root.txtName.text.toString()
        var Pris =  root.txtPris.text.toString().toDouble()

        root.btnAddloc.setOnClickListener {
            val intent = Intent(activity, MapsActivityRegisteration::class.java)
            activity!!.startActivity(intent)
        }
        root.btnAdd.setOnClickListener {
            val r = Request(nameRequest,Pris,lat,Lng,currentTime,currentDate)
            Requestlist.add(r)
            addRequestToSharedPreferences(nameRequest,Pris,lat,Lng,currentTime,currentDate)
        }









        return root
    }

    override fun addRequestToSharedPreferences(
        nameRequest: String?,
        prise: Double?,
        lat: Double?,
        Lng: Double?,
        time: Calendar,
        day: String?
    ): Boolean {
        val sharedPref = activity!!.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        val nameRequest = editor.putString("nameRequest",nameRequest).toString()
        val Pris = editor.putFloat("prise", prise!!.toDouble().toFloat()).toString().toDouble()
        val lat = editor.putFloat("lat",lat!!.toFloat()).toString().toDouble()
        val Lng =editor.putFloat("lat",Lng!!.toFloat()).toString().toDouble()
        editor.putString("time",time.toString()).toString()
        editor.putString("day",day).toString()

        val r = Request(nameRequest,Pris,lat,Lng,currentTime,currentDate)
        Requestlist.add(r)
        val b =  editor.commit()
        if(b) {
            Toast.makeText(activity, "Added Successfully", Toast.LENGTH_SHORT).show()
            return true
        } else {
            Toast.makeText(activity, "Add Failed", Toast.LENGTH_SHORT).show()
            return false
        }

    }

}