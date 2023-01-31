package com.faisal.eps.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.faisal.eps.adapter.HomeOrderAdapter
import com.faisal.eps.data.OrderRequestJson
import com.faisal.eps.data.OrderResponseItem
import com.faisal.eps.data.ShopRequestJson
import com.faisal.eps.databinding.FragmentHomeBinding
import com.faisal.eps.view_model.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {


    private var list : MutableList<OrderResponseItem> =mutableListOf()

    private lateinit var mAdapter :HomeOrderAdapter
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
       setAdapter()
        return binding.root
    }

    override fun onResume() {
        super.onResume()


//        if (Constant.SORT_BY.equals(Constant.DATE)) binding.btnSort.text=" sort by star"

//        else binding.btnSort.text=" sort by date"
        viewModel.loadShopData(ShopRequestJson(29,8,120))
        viewModel.loadOrderData(OrderRequestJson(29,8,12,120))


        setObserver()
        setListener()

    }
    fun setObserver(){
        HomeViewModel.shopResponse.observe(viewLifecycleOwner){

            viewModel.isLoading.value=false
            //Log.e("Dim",it.shopName)
            binding.tvShopName.text=it.shopName
            binding.tvAddress.text=it.address


        }

        HomeViewModel.orderResponse.observe(viewLifecycleOwner){

            viewModel.isLoading.value=false
            Log.e("Dim", it.size.toString())

            if(it.size!=0) {
                for (i in 0..it.size) {
                    list.add(it.get(i))
                }
                mAdapter.notifyDataSetChanged()
            }


//            binding.tvShopName.text=it.shopName
//            binding.tvAddress.text=it.address


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

    fun setAdapter (){
         mAdapter = HomeOrderAdapter(list)

        binding.rvRepositoryList.apply {
            this.layoutManager= LinearLayoutManager(requireContext())
            this.setHasFixedSize(true)
            this.adapter=mAdapter
        }
    }

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
