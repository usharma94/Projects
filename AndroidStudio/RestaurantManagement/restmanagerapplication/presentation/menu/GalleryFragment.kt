package sheridan.sharmupm.restmanagerapplication.presentation.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import sheridan.sharmupm.restmanagerapplication.R
import sheridan.sharmupm.restmanagerapplication.application.models.MenuItem

class GalleryFragment : Fragment() {

    private lateinit var colorList: List<MenuItem>

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_gallery, container, false)

        colorList = listOf(
                MenuItem(false, "Spicy Channa Masala", "Channa Masala", 12.99, false),
                MenuItem(false, "Panear", "Panear", 10.99, false),
                MenuItem(false, "Parantree", "Parantree", 5.99, false),
                MenuItem(false, "Naaaan","Naaaan", 5.99, false),
                MenuItem(false, "Samosia", "Samosia", 5.99, false),
                MenuItem(false, "Aloo Tikii","Aloo Tikii", 5.99, false)

        )

        val fab: FloatingActionButton = view.findViewById(R.id.addMenuItemFab)
        fab.setOnClickListener { view ->
            val navController = findNavController()
            navController.navigate(R.id.action_global_menuItem)
        }

        val recyclerView: RecyclerView = view.findViewById(R.id.color_recycler_view)
        val adapter = MenuAdapter(colorList, MenuAdapter.OnClickListener { colorName ->
//            view.findNavController().navigate(
//                            GalleryFragmentDirections.actionNavGalleryToMenuDetailFragment(colorName)
//
//            )
        })
        recyclerView.adapter = adapter

        return view
    }

}