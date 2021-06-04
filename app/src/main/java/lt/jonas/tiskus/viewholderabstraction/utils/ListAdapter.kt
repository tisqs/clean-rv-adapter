package lt.jonas.tiskus.viewholderabstraction.utils

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

abstract class ListAdapter<T, VH : RecyclerView.ViewHolder>(diffUtil: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, VH>(diffUtil) {

    override fun submitList(list: MutableList<T>?) =
        super.submitList(list?.let { ArrayList(it) } ?: emptyList())

    override fun submitList(list: MutableList<T>?, commitCallback: Runnable?) =
        super.submitList(list?.let { ArrayList(it) } ?: emptyList(), commitCallback)

}