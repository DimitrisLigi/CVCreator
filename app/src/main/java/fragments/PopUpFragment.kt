package fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.dimitrisligi.listofapirequests.FragmentComm
import com.dimitrisligi.listofapirequests.R
import kotlinx.android.synthetic.main.pop_up_color_details.*
import models.ColorData

class PopUpFragment(): DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.pop_up_color_details,container,false)



        return rootView
    }
}