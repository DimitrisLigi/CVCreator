package fragments

import adapters.MainAdapter
import android.app.Activity
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
import kotlinx.android.synthetic.main.fragment_home.*
import models.ColorData
import viewmodels.RecyclerViewViewModel


class HomeFragment : Fragment() {
    private lateinit var mainAdapter: MainAdapter
    private lateinit var mainViewModel: RecyclerViewViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentActivity = activity
        val decor = DividerItemDecoration(fragmentActivity,VERTICAL)
        mainViewModel = ViewModelProvider(this).get(RecyclerViewViewModel::class.java)

        rv_home.apply {
            layoutManager = LinearLayoutManager(context)
            mainAdapter = MainAdapter(context)
            adapter = mainAdapter
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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun getData() {
        mainViewModel.listOfColorData.observe(this.viewLifecycleOwner, {
            if (it != null) {
                mainAdapter.apply {
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