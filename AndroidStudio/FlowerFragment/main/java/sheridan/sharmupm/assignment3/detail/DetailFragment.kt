package sheridan.sharmupm.assignment3.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import sheridan.sharmupm.assignment3.databinding.FragmentDetailBinding

/**
 * This [Fragment] shows the detailed information about a selected piece of Mars real estate.
 * It sets this information in the [DetailViewModel], which it gets as a Parcelable property
 * through Jetpack Navigation's SafeArgs.
 */
class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        val application = requireNotNull(activity).application
        val binding = FragmentDetailBinding.inflate(inflater,container, false)
        val flowerProperty = DetailFragmentArgs.fromBundle(requireArguments()).selectedProperty
        val viewModelFactory = DetailViewModelFactory(flowerProperty, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(DetailViewModel::class.java)
        binding.button.setOnClickListener{showInput()}
        return binding.root

    }
    private fun showInput() {
        val action = DetailFragmentDirections.actionDetailFragmentToFlowerListFragment()
        findNavController().navigate(action)
    }
}