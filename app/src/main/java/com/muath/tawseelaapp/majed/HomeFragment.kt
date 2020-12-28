package com.muath.tawseelaapp.majed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.maps.model.LatLng
import com.muath.tawseelaapp.R
import com.muath.tawseelaapp.majed.Adapter.myAdapter
import com.muath.tawseelaapp.majed.models.Request
import kotlinx.android.synthetic.main.fragment_home.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    val list = ArrayList<Request>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val root = inflater.inflate(R.layout.fragment_home, container, false)

        val r1 =Request("food",20.9, " ","10:09 am","Friday")
        val r2 =Request("book",30.9," " ,"10:09 am","Friday")
        val r3 =Request("food",20.9, " ","10:09 am","Friday")
        val r4 =Request("book",30.9," " ,"10:09 am","Friday")
        val r5 =Request("food",20.9, " ","10:09 am","Friday")
        val r6 =Request("book",30.9," " ,"10:09 am","Friday")

        list.add(r1)
        list.add(r2)
        list.add(r3)
        list.add(r4)
        list.add(r5)
        list.add(r6)


        val adapter = myAdapter(activity!!,list)
        root.recycle_view.layoutManager = GridLayoutManager(activity,1)

        root.recycle_view?.adapter = adapter
        return root
    }



}