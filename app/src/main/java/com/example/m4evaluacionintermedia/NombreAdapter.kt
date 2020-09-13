package com.example.m4evaluacionintermedia

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.m4evaluacionintermedia.DataBase.Nombre
import kotlinx.android.synthetic.main.nombreitem_list.view.*

class NombreAdapter(var mPasstheData: PassTheData) :RecyclerView.Adapter<NombreAdapter.NombreViewHolder>()  {

    private var dataList = emptyList<Nombre>()

    fun updateList(mDataList: List<Nombre>) {
        dataList = mDataList
        notifyDataSetChanged()

    }

    inner class NombreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val nombreText = itemView.idtv1
        val nombreText2 = itemView.idtv2
        val nombreText3 = itemView.idtv3
        val chekNombre = itemView.cb2
        val itemView = itemView.setOnClickListener(this)

        override  fun onClick(p0: View?) {

            mPasstheData.passTheData(dataList[adapterPosition])
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NombreViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.nombreitem_list,parent,false)
        return NombreViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NombreViewHolder, position: Int) {
       val mNombre: Nombre = dataList[position]
        holder.nombreText.text = mNombre.nombre
        holder.nombreText2.inputType = mNombre.cantidad.toInt()
        holder.nombreText3.inputType = mNombre.precio.toInt()
        holder.chekNombre.isChecked = mNombre.completeNombre
    }

    override fun getItemCount() = dataList.size

   interface  PassTheData{
       fun passTheData(mNombre: Nombre)
    }


}