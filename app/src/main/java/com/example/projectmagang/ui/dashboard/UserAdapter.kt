package com.example.projectmagang.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectmagang.R
import com.example.projectmagang.model.UserResultResponse

/** Raihan Chaira on 1/4/2024
 * raihanchaira21@gmail.com
 */
class UserAdapter (var listUser : List<UserResultResponse>?) :
    RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    
    fun setData(data: UserResultResponse){
        //listUser = data
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.name)
        val tvEmail: TextView = view.findViewById(R.id.email)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        )
    }

    override fun getItemCount(): Int = listUser?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = listUser?.get(position)
        if (user != null) {
            holder.tvName.text = user.name
            holder.tvEmail.text = user.email
        }
    }

}