package com.example.m4evaluacionintermedia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.m4evaluacionintermedia.DataBase.Nombre
import kotlinx.android.synthetic.main.fragment_first.*


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    lateinit var mViewModel: NombreViewModel
    private var idNombre: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel = ViewModelProvider(this).get(NombreViewModel::class.java)

        arguments?.let {
            idNombre = it.getInt("id")
            Log.d("OBJ", idNombre.toString())
        }
      // setContentView(R.layout.fragment_first)


    }

   fun multiplicarClick() {
      cb.setOnCheckedChangeListener({buttonView,isChecked ->
          if(isChecked ) {
              var n1: Int =(tv3.text.toString()).toInt()
              var n2: Int =(tv4.text.toString()).toInt()
              var total: String = (n1 * n2).toString()
                Log.d("El valor total es ", total)
              idnumber.setText(total)
          }
      })

      }
       //   cb.setOnClickListener(){





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        multiplicarClick()
        idNombre?.let {
            mViewModel.run {
                getOneNombreByID(it).observe(viewLifecycleOwner, Observer {
                    Log.d("OBJ_LIV", it.nombre)
                    tv1.setText(it.nombre)
                    tv3.setText(it.cantidad.toInt())
                    cb.isChecked = it.completeNombre
                    tv4.setText(it.precio.toInt())

                })
            }
        }


            button.setOnClickListener {

                val textNombre = tv1.text.toString()
               val precio = tv3.text.toString().toInt()
                val cantidad = tv4.text.toString().toDouble()
                val checkBox = cb.isChecked
                val nombre = Nombre(0, textNombre, true, precio, cantidad)


                if (textNombre.isNotEmpty()) {
                    if (idNombre != null) {
                        Log.d("OBJ_ID_TASK", idNombre.toString())
                        val mNombre = Nombre(
                            nombre = textNombre, precio = precio.toDouble(), cantidad = cantidad.toInt(),
                            completeNombre = checkBox !!
                        )
                        mViewModel.updateNombre(mNombre)
                    } else {
                        val mNombre = Nombre(
                            nombre = textNombre, precio = precio.toDouble(), cantidad = cantidad.toInt(),
                            completeNombre = checkBox,
                        )
                        mViewModel.insertNombre(mNombre)
                    }
                } else {
                    Toast.makeText(context, "Debe llenar todos los espacios", Toast.LENGTH_LONG)
                        .show()
                }
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)

            }

        }
    }


//private fun <T> LiveData<T>.observe(viewLifecycleOwner: LifecycleOwner, observer: Any, function: () -> Unit): T {

//}
