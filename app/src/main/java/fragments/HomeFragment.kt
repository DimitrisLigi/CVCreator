package fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.dimitrisligi.listofapirequests.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view =  inflater.inflate(R.layout.fragment_home, container, false)
        view.btn_go_to_colors_fragm.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_colorsFragment)
        }
        view.btn_get_users.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_listOfUsersFragment)
        }
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        btn_go_to_colors_fragm.setOnClickListener {
//
//            val colorFragment = ColorFragment()
//            val fragmentManager = activity?.supportFragmentManager
//            val transaction = fragmentManager?.beginTransaction()
//            transaction?.apply {
//                replace(R.id.fragmentContainerView,colorFragment).addToBackStack(null).commit()
//            }
//
//        }
    }
}