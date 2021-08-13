package adapters

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.dimitrisligi.listofapirequests.FragmentComm
import fragments.PopUpFragment
import com.dimitrisligi.listofapirequests.R
import kotlinx.android.synthetic.main.card_color.view.*
import models.ColorData


class MainAdapter(var context: Context): RecyclerView.Adapter<MainAdapter.ColorViewHolder>(){

    private var colorDataList = ArrayList<ColorData>()

    fun setColorListData(listOfColors: ArrayList<ColorData>){
        this.colorDataList = listOfColors
    }

    inner class ColorViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val colorView = view.v_color_preview
        private val colorName = view.tv_color_name
        private var currentView = view



        fun binding(colorData: ColorData){
            colorView.setBackgroundColor(Color.parseColor(colorData.color))
            colorName.text = colorData.name
            val dialog = Dialog(context)
            dialog.setContentView(R.layout.pop_up_color_details)
            this.currentView.setOnClickListener {
//                Toast.makeText(context,"My name is ${colorData.name}",Toast.LENGTH_SHORT).show()
                val colorView = dialog.findViewById<View>(R.id.v_popup_color)
                val colorName = dialog.findViewById<TextView>(R.id.tv_popup_name)
                colorView.setBackgroundColor(Color.parseColor(colorData.color))
                colorName.text = colorData.name
                dialog.show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_color,parent,false)
        return ColorViewHolder(v)
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.binding(colorDataList[position])
    }

    override fun getItemCount(): Int {
        return colorDataList.size
    }
}