package sheridan.sharmupm.restmanagerapplication.presentation.menu.menuItem

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import sheridan.sharmupm.restmanagerapplication.R

class MenuItem : Fragment() {

    companion object {
        fun newInstance() = MenuItem()
    }

    private lateinit var viewModel: MenuItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.menu_item_fragment, container, false)

        val btnConfirm: Button = view.findViewById(R.id.btn_confirm_item)
        btnConfirm.setOnClickListener { view ->
            val navController = findNavController()
            navController.navigate(R.id.action_global_nav_gallery)
        }

        val btnCancel: Button = view.findViewById(R.id.btn_cancel_item)
        btnCancel.setOnClickListener { view ->
            val navController = findNavController()
            navController.navigate(R.id.action_global_nav_gallery)
        }

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MenuItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}