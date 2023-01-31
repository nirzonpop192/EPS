package com.faisal.eps.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.faisal.eps.R
import com.faisal.eps.data.ShopRequestJson
import com.faisal.eps.databinding.FragmentHomeBinding
import com.faisal.eps.view_model.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


//class HomeFragment : Fragment() {
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false)
//    }
//
//
//}
@AndroidEntryPoint
class HomeFragment : Fragment() {


    private val JOB_ID: Int=123
//    lateinit var mAdapter: RepositoryPagingAdapter


    private lateinit var binding: FragmentHomeBinding
    companion object{
        val TAG= HomeFragment::class.java.name
        lateinit var viewModel: HomeViewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
       // setAdapter()
        return binding.root
    }

    override fun onResume() {
        super.onResume()


//        if (Constant.SORT_BY.equals(Constant.DATE)) binding.btnSort.text=" sort by star"

//        else binding.btnSort.text=" sort by date"
        viewModel.loadData(ShopRequestJson(29,8,120))


        setObserver()
        setListener()

    }
    fun setObserver(){
        HomeViewModel.response.observe(viewLifecycleOwner){
          //  Log.e(TAG, "onResume:  size of dim ${it.items.size}", )
            viewModel.isLoading.value=false
            Log.e("Dim",it.shopName)
            binding.tvShopName.text=it.shopName
//            if(it.items.isNotEmpty()){
//                for (repositoryItem in it.items){
//                    Log.e(TAG,"in loop")
//                    viewModel.addRepository(repositoryItem)
//                    repositoryItem.license?.let { it1 -> viewModel.addLicense(it1) }
//                    repositoryItem.owner?.let { it1 -> viewModel.addOwner(it1) }
//
//
//                }
//            }

        }

//        viewModel.pagingDataList.observe(viewLifecycleOwner){
//
//
//            Log.e(TAG, " observing ")
//            mAdapter.submitData(lifecycle, it)
//            Log.e(TAG, "onResume:  size of adapter ${mAdapter.snapshot().items.size}", )
//
//        }
        viewModel.isLoading.observe(viewLifecycleOwner){
            if(it)
                binding.progressBar.visibility=View.VISIBLE
            else
                binding.progressBar.visibility=View.INVISIBLE
        }
    }

//    fun setAdapter (){
//        mAdapter=RepositoryPagingAdapter()
//
//        binding.rvRepositoryList.apply {
//            this.layoutManager= LinearLayoutManager(requireContext())
//            this.setHasFixedSize(true)
//            this.adapter=mAdapter
//        }
//    }

    fun setListener(){
//        binding.btnSort.setOnClickListener {
//            viewModel.deleteAllRecords()
//
//            if (Constant.SORT_BY.equals(Constant.DATE)) Constant.SORT_BY = Constant.STARS
//
//            else Constant.SORT_BY= Constant.DATE
//
//            val id = findNavController().currentDestination?.id
//            findNavController().popBackStack(id!!,true)
//            findNavController().navigate(id)
//        }
//
//        mAdapter.setOnItemClickListener(object :OnItemClickListener{
//            override fun onItemClick(item: Item) {
////                var bundle = bundleOf("repository" to item)
////                findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
//            }
//        })

    }






}
