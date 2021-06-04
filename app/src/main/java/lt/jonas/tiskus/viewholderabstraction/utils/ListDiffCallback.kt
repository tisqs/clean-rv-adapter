package lt.jonas.tiskus.viewholderabstraction.utils

import androidx.recyclerview.widget.DiffUtil

class ListDiffCallback<T>(
    val onItemsTheSame: (T, T) -> Boolean,
    val onContentsTheSame: (T, T) -> Boolean
) : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean = onItemsTheSame(oldItem, newItem)
    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean = onContentsTheSame(oldItem, newItem)
}