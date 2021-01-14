package sheridan.sharmupm.restmanagerapplication.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*
import sheridan.sharmupm.restmanagerapplication.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        //val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
           // textView.text = it
           //button.setOnClickListener{showInput()}
            order_card.setOnClickListener{showTables()}
            menu_card.setOnClickListener { showInput() }
            manage_users.setOnClickListener{
                this.findNavController().navigate(R.id.action_nav_home_to_userCreateFragment)
            }
            manage_menu.setOnClickListener{
                this.findNavController().navigate(R.id.action_nav_home_to_menuItem)
            }

        })
        //button.setOnClickListener{showInput()}



        return root
    }

    private fun showTables() {
        this.findNavController().navigate(R.id.action_nav_home_to_tableFragment)
    }

    private fun showInput() {
        this.findNavController().navigate(R.id.action_nav_home_to_nav_gallery)

    }

}