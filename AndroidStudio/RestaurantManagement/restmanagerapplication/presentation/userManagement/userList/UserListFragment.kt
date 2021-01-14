package sheridan.sharmupm.restmanagerapplication.presentation.userManagement.userList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sheridan.sharmupm.restmanagerapplication.application.userList.UserListViewModel
import sheridan.sharmupm.restmanagerapplication.databinding.FragmentUserListBinding


class UserListFragment : Fragment() {

    private lateinit var viewModel: UserListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = FragmentUserListBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        // Make adapter to link to user details page
        binding.usersGrid.adapter = UserListAdapter(UserListAdapter.OnClickListener {
            viewModel.displayUserDetails(it)
        })

        viewModel.navigateToSelectedUser.observe(viewLifecycleOwner, {
            if (null != it) {
                // Must find the NavController from the Fragment
                this.findNavController().navigate(UserListFragmentDirections.actionShowUserDetail(it))
                viewModel.displayUserDetailsComplete()
            }
        })

        setHasOptionsMenu(true)
        return binding.root
    }
}