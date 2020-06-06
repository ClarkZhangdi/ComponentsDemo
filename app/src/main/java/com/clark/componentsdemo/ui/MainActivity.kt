package com.clark.componentsdemo.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.clark.componentsdemo.R
import com.clark.componentsdemo.bean.JumpBean
import kotlinx.android.synthetic.main.activity_main.*

/**
 * note 需要在此处处理各种未解决的问题
 */
class MainActivity : AppCompatActivity() {

    private val data = ArrayList<JumpBean>()

    init {
        data.add(JumpBean("Okhttp详解", OkHttpDemoActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvData.adapter =
            HardQuestionAdapter(data)

    }


    class HardQuestionAdapter(private var data: ArrayList<JumpBean>) :
        RecyclerView.Adapter<HardQuestionHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HardQuestionHolder {
            val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.item_hard, parent, false)
            return HardQuestionHolder(
                itemView
            )

        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: HardQuestionHolder, position: Int) {
            holder.content.text = data[position].content
            holder.content.setOnClickListener {
                it.context.startActivity(Intent(it.context, data[position].openClazz))
            }
        }

    }

    class HardQuestionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView.findViewById(R.id.tvContent)
    }
}
