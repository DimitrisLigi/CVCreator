package adapters

import android.service.autofill.UserData
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dimitrisligi.listofapirequests.R
import kotlinx.android.synthetic.main.user_recycler_row.view.*
import models.usermodels.UserDataFromDomainModel
import models.usermodels.UserDomainModel
import java.lang.StringBuilder

class UserAdapter :RecyclerView.Adapter<UserAdapter.UserViewHolder>(){

    private var userList = ArrayList<UserDataFromDomainModel>()

    fun setUserListData(listOfUsers: ArrayList<UserDataFromDomainModel>){
        this.userList = listOfUsers
    }

    inner class UserViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val userAvatar = view.iv_user_avatar
        private val userFullName = view.tv_user_fullname
        private val userEmail = view.tv_user_email

        fun binding(userData: UserDataFromDomainModel){
            val sb = StringBuilder()
            val url = userData.avatar
            sb.append(userData.firstName).append(userData.lastName)
            //Full name
            userFullName.text = sb.toString()

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

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val v =  LayoutInflater.from(parent.context).inflate(R.layout.user_recycler_row,parent,false)
        return UserViewHolder(v)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        holder.binding(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}