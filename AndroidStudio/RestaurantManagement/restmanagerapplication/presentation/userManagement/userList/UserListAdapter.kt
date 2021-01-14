package sheridan.sharmupm.restmanagerapplication.presentation.userManagement.userList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sheridan.sharmupm.restmanagerapplication.application.models.User
import sheridan.sharmupm.restmanagerapplication.databinding.UserListViewItemBinding

class UserListAdapter( private val onClickListener: OnClickListener) : ListAdapter<User,
        UserListAdapter.UserViewHolder>(DiffCallback) {

    class UserViewHolder(private var binding: UserListViewItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.user = user
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): UserViewHolder {
        return UserViewHolder(UserListViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(user)
        }
        holder.bind(user)
    }

    class OnClickListener(val clickListener: (user:User) -> Unit) {
        fun onClick(user:User) = clickListener(user)
    }
}
