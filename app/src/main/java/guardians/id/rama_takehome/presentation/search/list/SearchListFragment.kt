package guardians.id.rama_takehome.presentation.search.list

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import guardians.id.rama_takehome.R
import guardians.id.rama_takehome.domain.common.UseCaseConstant
import guardians.id.rama_takehome.presentation.common.ResultData
import guardians.id.rama_takehome.presentation.common.base.BaseFragment
import guardians.id.rama_takehome.presentation.common.widget.paged.PagedState
import guardians.id.rama_takehome.presentation.search.SearchActivityViewModel
import guardians.id.rama_takehome.presentation.search.SearchListAdapter
import guardians.id.rama_takehome.shared.extensions.onLoading
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.search_list_fragment.*
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class SearchListFragment : BaseFragment() {
    override val resourceLayout: Int = R.layout.search_list_fragment
    private val viewModel: SearchListViewModel by inject { parametersOf(q,args.q) }
    private  val args: SearchListFragmentArgs by navArgs()
    private val q by lazy { arguments?.getString(ARG_Q, "") }
    private val searchListAdapterPaged =
        SearchListAdapterPaged(
            onItemClicked = {},
            onRetry = { viewModel.retryLoadAtLast() }
        )

    override fun onInitViews() {
        //super.onInitViews()
        swipeRefresh.setOnRefreshListener { viewModel.searches.value?.dataSource?.invalidate() }
        with(recyclerView) {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = searchListAdapterPaged
        }
    }

    override fun onInitObservers() {
        viewModel.searches.observe(viewLifecycleOwner, Observer(searchListAdapterPaged::submitList))
        viewModel.searchesState.observe(viewLifecycleOwner, Observer {
            if (it.isInitial) {
                shimmerView.onLoading(it is PagedState.Loading)
                if (it !is PagedState.Loading) swipeRefresh.isRefreshing = false
            } else {
                if (it !is PagedState.Loading) swipeRefresh.isRefreshing = false
                searchListAdapterPaged.currentState = it
            }
        })


        //super.onInitObservers()
    }
    companion object {
        private const val ARG_Q = "ARG_Q"
        fun newInstance(q: String) = SearchListFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_Q, q)
            }
        }
    }
}