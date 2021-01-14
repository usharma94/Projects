package sheridan.sharmupm.restmanagerapplication.presentation.userManagement.userCreate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sheridan.sharmupm.restmanagerapplication.databinding.FragmentUserCreateBinding


/**
 * A simple [Fragment] subclass.
 * Use the [UserCreateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserCreateFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val binding = FragmentUserCreateBinding.inflate(inflater)
        binding.lifecycleOwner = this

        return binding.root
    }
}