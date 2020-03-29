package guardians.id.rama_takehome.presentation.search

import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import guardians.id.rama_takehome.R
import guardians.id.rama_takehome.domain.common.UseCaseConstant.q
import guardians.id.rama_takehome.presentation.common.ResultData
import guardians.id.rama_takehome.presentation.common.base.BaseActivity
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SearchActivity : BaseActivity(){
    override val resourceLayout: Int = R.layout.activity_search
    private val viewModel: SearchActivityViewModel by viewModel { parametersOf(q)}
    private val searchListAdapter = SearchListAdapter(
        onItemClicked = {}
    )
    override fun onInitViews() {
        //super.onInitViews()
        with(recycleListSearch){
            layoutManager = LinearLayoutManager(context)
            adapter = searchListAdapter
        }
        searchView.onActionViewExpanded()
        searchView.clearFocus()
        searchView.setOnQueryTextListener(object:androidx.appcompat.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                Toast.makeText(applicationContext, query, Toast.LENGTH_SHORT).show()
                lifecycleScope.launch{
                    viewModel.getListOfSearch(query)
                }
                return false
            }
        })
    }

    override fun onInitObservers() {
        viewModel.items.observe(this, Observer {
          when(it){
              is ResultData.Success -> it.data.run(searchListAdapter::addItems)
          }
        })
        //super.onInitObservers()
    }
}