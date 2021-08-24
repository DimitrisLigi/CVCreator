package fragments

import android.annotation.SuppressLint
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.dimitrisligi.listofapirequests.R
import kotlinx.android.synthetic.main.fragment_user_details.*
import models.usermodels.UserDataFromDomainModel
import utils.Communicator


class UserDetailsFragment : Fragment(){

    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_user_details, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments?.isEmpty == true){
            Toast.makeText(context,"Einai null to bundle!!",Toast.LENGTH_SHORT).show()
        }else{
            name = arguments?.getString("name")
            tv_user_name_card.text = name
            tv_user_lastname_card.text = arguments?.getString("lastname")
            tv_user_email_card.text = arguments?.getString("email")
            tv_user_id_card.text = arguments?.getInt("id").toString()

            Glide.with(iv_user_avatar_card.context).load(Uri.parse(arguments?.getString("avatar"))).into(iv_user_avatar_card)
        }
    }
}
