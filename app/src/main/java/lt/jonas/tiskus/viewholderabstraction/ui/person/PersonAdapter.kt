package lt.jonas.tiskus.viewholderabstraction.ui.person

import android.view.LayoutInflater
import android.view.ViewGroup

import lt.jonas.tiskus.viewholderabstraction.utils.ListDiffCallback
import lt.jonas.tiskus.viewholderabstraction.data.model.Person
import lt.jonas.tiskus.viewholderabstraction.databinding.ItemPersonBinding
import lt.jonas.tiskus.viewholderabstraction.utils.BindingViewHolder
import lt.jonas.tiskus.viewholderabstraction.utils.ListAdapter

class PersonAdapter :
    ListAdapter<Person, BindingViewHolder<ItemPersonBinding>>(ListDiffCallback(
        onItemsTheSame = { old, new -> old.id == new.id },
        onContentsTheSame = { old, new -> old == new }
    )) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ItemPersonBinding> =
        BindingViewHolder(
            ItemPersonBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: BindingViewHolder<ItemPersonBinding>, position: Int) {
        val person = currentList[position]
        holder.binding.model = person
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = currentList.size
}