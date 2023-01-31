package com.faisal.eps.view_model
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faisal.eps.data.ShopRequestJson
import com.faisal.eps.data.ShopResponse
import com.faisal.eps.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel(){

    companion object{
        var response : MutableLiveData<ShopResponse> =MutableLiveData()

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
     * load method invoke the pager
     */
    fun loadData(body: ShopRequestJson) {
        isLoading.value=true
        viewModelScope.launch {
            response.value= repository.fetchShopApi(body)


        }

    }

//    override fun invokeApi(query: String, sort: String, order: String, per_page: Int) {
//        pagingDataList=repository.fetchRepositoryApi(query , sort, order, per_page).cachedIn(viewModelScope)
//
//    }
}