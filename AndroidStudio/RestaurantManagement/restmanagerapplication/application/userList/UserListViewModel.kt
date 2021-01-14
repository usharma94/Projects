package sheridan.sharmupm.restmanagerapplication.application.userList

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import sheridan.sharmupm.restmanagerapplication.application.models.User

class UserListViewModel : ViewModel()  {

    private val _users = MutableLiveData<List<User>>()

    val users: LiveData<List<User>>
        get() = _users

    private val _navigateToSelectedUser = MutableLiveData<User>()
    val navigateToSelectedUser: LiveData<User>
        get() = _navigateToSelectedUser

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            try {
                _users.value = null // set to getUsers()
            } catch (e: Exception) {
                _users.value = ArrayList()
            }
        }
    }

    fun displayUserDetails(user: User) {
        _navigateToSelectedUser.value = user
    }

    fun displayUserDetailsComplete() {
        _navigateToSelectedUser.value = null
    }


}