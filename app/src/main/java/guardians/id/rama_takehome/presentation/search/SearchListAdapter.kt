package guardians.id.rama_takehome.presentation.search

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import guardians.id.rama_takehome.domain.search.Search

class SearchListAdapter(
    private val onItemClicked: (Search) -> Unit
) : RecyclerView.Adapter<SearchHolder>() {
    private var items = mutableListOf<Search>()
    fun addItems(items:List<Search>){
        this.items.clear()
        this.items.addAll(items)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder =
        SearchHolder.newInstance(parent,onItemClicked)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
        holder.onBind(items[position])
    }

}