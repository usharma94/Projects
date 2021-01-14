package sheridan.sharmupm.restmanagerapplication.presentation.tables

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
import kotlinx.android.synthetic.main.fragment_home.manage_users
import kotlinx.android.synthetic.main.fragment_tables.*
import sheridan.sharmupm.restmanagerapplication.R
import sheridan.sharmupm.restmanagerapplication.presentation.menu.GalleryViewModel

class TableFragment : Fragment() {

    private lateinit var tableViewModel: TableViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        tableViewModel =
                ViewModelProvider(this).get(TableViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tables, container, false)
        //val textView: TextView = root.findViewById(R.id.)
        tableViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it
            table_2.setOnClickListener{
                this.findNavController().navigate(R.id.action_tableFragment_to_nav_gallery)
            }
        })
        return root
    }
}