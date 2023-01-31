package com.faisal.eps.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.faisal.eps.adapter.HomeOrderAdapter
import com.faisal.eps.data.OrderRequestJson
import com.faisal.eps.data.OrderResponseItem
import com.faisal.eps.data.ShopRequestJson
import com.faisal.eps.databinding.FragmentHomeBinding
import com.faisal.eps.util.NetworkManager
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



        if(NetworkManager.isNetConnectionAvailable(requireContext())){
            viewModel.loadShopData(ShopRequestJson(29,8,120))
            viewModel.loadOrderData(OrderRequestJson(29,8,12,120))
        }else Toast.makeText(context,"No internet found. please connect it",Toast.LENGTH_LONG).show()


        setObserver()
        setListener()

    }
    private fun setObserver(){
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
                list.clear()
                for (i in 0..it.size-1) {
                    list.add(it.get(i))
                }
                mAdapter.updateData(list)
            }



        }


        viewModel.isLoading.observe(viewLifecycleOwner){
            if(it)
                binding.progressBar.visibility=View.VISIBLE
            else
                binding.progressBar.visibility=View.INVISIBLE
        }
    }

    private fun setAdapter (){
         mAdapter = HomeOrderAdapter(list)

        binding.rvOrderList.apply {
            this.layoutManager= LinearLayoutManager(requireContext())
            this.setHasFixedSize(true)
            this.adapter=mAdapter
        }
    }

    private fun setListener(){
        binding.btnConfirm.setOnClickListener {
            if(NetworkManager.isNetConnectionAvailable(requireContext())){
                clearList()
                viewModel.loadOrderData(OrderRequestJson(29,8,12,120))
            }else Toast.makeText(context,"No internet found. please connect it",Toast.LENGTH_LONG).show()

        }
        binding.btnPartialDeliver.setOnClickListener {
            if(NetworkManager.isNetConnectionAvailable(requireContext())){
                clearList()
                viewModel.loadOrderData(OrderRequestJson(29,8,15,120))
            }else Toast.makeText(context,"No internet found. please connect it",Toast.LENGTH_LONG).show()


        }
        binding.btnDelivered.setOnClickListener {
            if(NetworkManager.isNetConnectionAvailable(requireContext())){
                clearList()
                viewModel.loadOrderData(OrderRequestJson(29,8,9,120))
            }else Toast.makeText(context,"No internet found. please connect it",Toast.LENGTH_LONG).show()

        }


    }



private fun clearList(){
    list.clear()
    mAdapter.updateData(list)
}


}
