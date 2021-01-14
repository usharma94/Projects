package sheridan.sharmupm.restmanagerapplication.presentation.userManagement.userDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import sheridan.sharmupm.restmanagerapplication.application.userDetail.UserDetailViewModel
import sheridan.sharmupm.restmanagerapplication.application.userDetail.UserDetailViewModelFactory
import sheridan.sharmupm.restmanagerapplication.databinding.FragmentUserDetailBinding

class UserDetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        val application = requireNotNull(activity).application
        val binding = FragmentUserDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val user = UserDetailFragmentArgs.fromBundle(requireArguments()).selectedUser
        val viewModelFactory = UserDetailViewModelFactory(user, application)
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(UserDetailViewModel::class.java)

        return binding.root
    }
}