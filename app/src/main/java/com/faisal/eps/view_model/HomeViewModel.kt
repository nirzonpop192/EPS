package com.faisal.eps.view_model
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faisal.eps.data.OrderRequestJson
import com.faisal.eps.data.OrderResponse
import com.faisal.eps.data.ShopRequestJson
import com.faisal.eps.data.ShopResponse
import com.faisal.eps.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel(){

    companion object{
        var shopResponse : MutableLiveData<ShopResponse> =MutableLiveData()
        var orderResponse : MutableLiveData<OrderResponse> =MutableLiveData()

    }
    var isLoading:MutableLiveData<Boolean> =MutableLiveData()
//    lateinit var pagingDataList: LiveData<PagingData<Item>>







//
//    fun deleteAllRecords(){
//        viewModelScope.launch {
//            repository.deleteAllRepositories()
//            repository.deleteAllLicense()
//            repository.deleteAllOwner()
//        }
//    }



    /**
     * load method invoke the
     */
    fun loadShopData(body: ShopRequestJson) {
        isLoading.value=true
        viewModelScope.launch {
            shopResponse.value= repository.fetchShopApi(body)

        }
    }

    fun loadOrderData(body: OrderRequestJson) {
        isLoading.value=true
        viewModelScope.launch {
            orderResponse.value= repository.fetchOrderApi(body)


        }

    }

//    override fun invokeApi(query: String, sort: String, order: String, per_page: Int) {
//        pagingDataList=repository.fetchRepositoryApi(query , sort, order, per_page).cachedIn(viewModelScope)
//
//    }
}