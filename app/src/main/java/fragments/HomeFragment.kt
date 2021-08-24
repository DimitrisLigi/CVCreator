package fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.dimitrisligi.listofapirequests.R
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_home, container, false)

        view.btn_go_to_colors_fragm.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_colorsFragment)
        }
        view.btn_get_users.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_listOfUsersFragment)
        }
        return view
    }
}