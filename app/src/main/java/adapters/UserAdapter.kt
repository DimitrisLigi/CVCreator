package adapters

import android.content.Context
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dimitrisligi.listofapirequests.R
import fragments.UserDetailsFragment
import kotlinx.android.synthetic.main.user_recycler_row.view.*
import models.usermodels.UserDataFromDomainModel
import utils.Communicator
import java.lang.StringBuilder

class UserAdapter(val context: Context,var mCom: Communicator) :RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    private var userList = ArrayList<UserDataFromDomainModel>()

    fun setUserListData(listOfUsers: ArrayList<UserDataFromDomainModel>){
        this.userList = listOfUsers
    }


    inner class UserViewHolder(view: View,communicator: Communicator): RecyclerView.ViewHolder(view){
        private val userAvatar = view.iv_user_avatar
        private val userFullName = view.tv_user_fullname
        private val userEmail = view.tv_user_email

        init {
            mCom = communicator
        }

        fun binding(userData: UserDataFromDomainModel){
            val sb = StringBuilder()
            val url = userData.avatar

            sb.append(userData.firstName).append(" ").append(userData.lastName)

            //Full name
            userFullName.text = sb

            //Email
            userEmail.text = userData.email

            //Avatar
            Glide.with(userAvatar)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.default_thumb)
                .error(R.drawable.default_thumb)
                .fallback(R.drawable.default_thumb)
                .into(userAvatar)

            itemView.setOnClickListener {
                mCom.passData(userData)
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val v =  LayoutInflater.from(parent.context).inflate(R.layout.user_recycler_row,parent,false)
        val holder = UserViewHolder(v,this.mCom)
        return UserViewHolder(holder.itemView,this.mCom)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        holder.binding(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}