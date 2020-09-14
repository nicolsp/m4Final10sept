package com.example.m4evaluacionintermedia

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.m4evaluacionintermedia.DataBase.Nombre
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() , NombreAdapter.PassTheData{

    lateinit var viewModel: NombreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NombreViewModel::class.java)
    }

  override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?
  ): View {

      return inflater.inflate(R.layout.fragment_second,container,false)
  }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mRecyclerView = recyclerView

        val mAdapter = NombreAdapter(this)
        mRecyclerView.adapter = mAdapter
        mRecyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.allNombre.observe(viewLifecycleOwner, Observer {
            Log.d("OBJETO", it.toString())

            mAdapter.updateList(it)
        })


        fab2.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

    }

    override fun passTheData(mNombre: Nombre) {
        val mBundle = Bundle()
        mBundle.putInt("id", mNombre.id)
        Toast.makeText(context, mNombre.id.toString(), Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment, mBundle)
    }
  }
