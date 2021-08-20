package fragments

import adapters.ColorAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.dimitrisligi.listofapirequests.R
import kotlinx.android.synthetic.main.fragment_colors.*
import models.colormodels.ColorData
import viewmodels.RecyclerViewViewModel


class ColorFragment : Fragment() {
    private lateinit var colorAdapter: ColorAdapter
    private lateinit var mainViewModel: RecyclerViewViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentActivity = activity
        val decor = DividerItemDecoration(fragmentActivity,VERTICAL)
        mainViewModel = ViewModelProvider(this).get(RecyclerViewViewModel::class.java)

        rv_home.apply {
            layoutManager = LinearLayoutManager(context)
            colorAdapter = ColorAdapter(context)
            adapter = colorAdapter
            decor.setDrawable(AppCompatResources.getDrawable(fragmentActivity!!,
                R.drawable.decor_line
            )!!)
            addItemDecoration(decor)
        }
        getData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_colors, container, false)

        return view
    }

    private fun getData() {
        mainViewModel.listOfColorData.observe(this.viewLifecycleOwner, {
            if (it != null) {
                colorAdapter.apply {
                    setColorListData(it.data as ArrayList<ColorData>)
                    notifyDataSetChanged()
                }
            } else {
                Toast.makeText(context, "Error getting the data", Toast.LENGTH_SHORT).show()
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        mainViewModel.cancelJobs()
    }

}