package com.muath.tawseelaapp.majed

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.muath.tawseelaapp.R
import com.muath.tawseelaapp.majed.Adapter.myAdapter
import com.muath.tawseelaapp.majed.models.Request
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    companion object{
        val Requestlist = ArrayList<Request>()
    }
    val currentTime = Calendar.getInstance()
    val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
    val currentDate = sdf.format(Date())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val root = inflater.inflate(R.layout.fragment_home, container, false)





        val r1 =Request("food",20.9, 0.0,0.0,currentTime,currentDate)
        val r2 =Request("book",30.9,0.0,0.0 ,currentTime,currentDate)


        Requestlist.add(r1)
        Requestlist.add(r2)


        val adapter = myAdapter(activity!!,Requestlist)
        root.recycle_view.layoutManager = GridLayoutManager(activity,1)

        root.recycle_view?.adapter = adapter
        return root
    }



}