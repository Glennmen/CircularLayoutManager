package com.leshchenko.circularlayoutmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leshchenko.circularlayoutmanagerlib.CircularRecyclerLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        circularRecycler.layoutManager = CircularRecyclerLayoutManager(
            canScrollHorizontally = false,
            itemsPerCircle = 5,
            anglePerItem = 45.0,
            firstCircleRadius = 200.0,
            angleStepForCircles = 0.0,
            isClockwise = true,
            initialAngle = 270.0
        )
        circularRecycler.adapter = Adapter()
    }

    inner class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false))

        override fun getItemCount() = 5

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {}

        inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)
    }
}
