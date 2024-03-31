package ir.misterdeveloper.educationalapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import ir.misterdeveloper.educationalapplication.databinding.ItemDataAutocompleteBinding
import ir.misterdeveloper.educationalapplication.model.DataItemResponse


class AutoCompleteAdapter(
    context: Context,
    itemsList: MutableList<DataItemResponse>
): ArrayAdapter<DataItemResponse>(context, 0, itemsList) {

    private var itemsListFull: MutableList<DataItemResponse> = itemsList
    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getView(
        position: Int,
        convertView: View?,
        parent: ViewGroup
    ): View {
        val binding: ItemDataAutocompleteBinding
        val view: View

        if (convertView == null) {
            binding = ItemDataAutocompleteBinding.inflate(inflater, parent, false)
            view = binding.root
            view.tag = binding
        } else {
            binding = convertView.tag as ItemDataAutocompleteBinding
            view = convertView
        }

        val name = binding.tvName
        val phone = binding.tvPhone

        val item = getItem(position)

        if (item != null) {
            name.text = item.name
            phone.text = item.phone
        }

        return view
    }

    override fun getCount(): Int {
        return itemsListFull.size
    }

    override fun getItem(position: Int): DataItemResponse? {
        return if (position >= 0 && position < itemsListFull.size) {
            itemsListFull[position]
        } else {
            null
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
}
