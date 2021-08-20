package fragments

import adapters.UserAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.dimitrisligi.listofapirequests.R
import kotlinx.android.synthetic.main.fragment_list_of_users.*
import models.usermodels.UserDataFromDomainModel
import viewmodels.RecyclerViewViewModel

class ListOfUsersFragment : Fragment() {

    private lateinit var usersAdapter: UserAdapter
    private lateinit var recyclerViewViewModel: RecyclerViewViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fragmentActivity = activity
        val decor = DividerItemDecoration(fragmentActivity, VERTICAL)
        recyclerViewViewModel = ViewModelProvider(this).get(RecyclerViewViewModel::class.java)

        rv_users.apply {
            layoutManager = LinearLayoutManager(context)
            usersAdapter = UserAdapter(context)
            adapter = usersAdapter
            decor.setDrawable(AppCompatResources.getDrawable(fragmentActivity!!,R.drawable.decor_line)!!)
            addItemDecoration(decor)
        }
        getUserData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_of_users, container, false)
    }



    @SuppressLint("NotifyDataSetChanged")
    fun getUserData(){
        recyclerViewViewModel.listOfUsers.observe(this.viewLifecycleOwner,{
            if (it != null){
                usersAdapter.apply {
                    setUserListData(it.data as ArrayList<UserDataFromDomainModel>)
                    notifyDataSetChanged()
                }
            }else{
                Toast.makeText(context,"Error getting the users data",Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        recyclerViewViewModel.cancelJobs()
    }
}