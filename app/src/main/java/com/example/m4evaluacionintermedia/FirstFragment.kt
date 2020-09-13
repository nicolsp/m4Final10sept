package com.example.m4evaluacionintermedia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.m4evaluacionintermedia.DataBase.Nombre
import kotlinx.android.synthetic.main.fragment_first.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    lateinit var mViewModel: NombreViewModel
    private  var idNombre: Int? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(NombreViewModel::class.java)
            arguments?.let {
            idNombre = it.getInt("id")
            Log.d("OBJ", idNombre.toString())
        }
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      //  idNombre?.let {
           // mViewModel.getOneNombreByID(it).Observe(viewLifecycleOwner, Observer, {
             //   Log.d("OBJ_LIV",it.nombre)
          //tv2.setText(it.nombre)
            // AQUI VA LO QUE SE VE EN LAS VISTAS
        //}
        //}

        mViewModel.allNombre.observe(viewLifecycleOwner, Observer {
            Log.d("OBJ",it.toString())
        })

        button.setOnClickListener {
            val textNombre = tv1.text.toString()
            val precio = tv3.text.toString().toInt()
            val cantidad = tv4.text.toString().toDouble()
            val checkBox = cb.isChecked
            val nombre = Nombre(0,textNombre,true,precio,cantidad)

           // Toast.makeText(context,nombre.toString(),Toast.LENGTH_SHORT).show()

            mViewModel.insertNombre(nombre)

        }

        //view.findViewById<Button>(R.id.button).setOnClickListener {
         //   findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        ///

       // }
    }
}
