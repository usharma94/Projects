package sheridan.sharmupm.restmanagerapplication.presentation.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sheridan.sharmupm.restmanagerapplication.R
import sheridan.sharmupm.restmanagerapplication.application.models.MenuItem

class MenuAdapter(
        private val colorList: List<MenuItem>,
        private val onClickListener: OnClickListener
) :
        ListAdapter<MenuItem, MenuAdapter.ColorViewHolder>(
                DiffCallback
        ) {

    class ColorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val colorNameTextView: TextView = itemView.findViewById(R.id.item_color_text_view)
        val menuPriceTextView: TextView = itemView.findViewById(R.id.item_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder(
                LayoutInflater.from(parent.context).inflate(
                        R.layout.item_menu,
                        parent,
                        false
                )
        )
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        val item: MenuItem = colorList[position]
        holder.colorNameTextView.text = item.itemName
        holder.menuPriceTextView.text = item.itemPrice.toString()

        holder.itemView.setOnClickListener{
            onClickListener.onClick(item)
        }
    }

    override fun getItemCount() = colorList.size

    class OnClickListener(val clickListener: (color: MenuItem) -> Unit) {
        fun onClick(color: MenuItem) = clickListener(color)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<MenuItem>() {
        override fun areItemsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MenuItem, newItem: MenuItem): Boolean {
            return oldItem.itemName == newItem.itemName
        }
    }
}