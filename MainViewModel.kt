package mdeveloping.mine.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mdeveloping.mine.myapplication.model.NewsModel
import mdeveloping.mine.myapplication.model.ResultModel
import mdeveloping.mine.myapplication.repository.Repository
import retrofit2.Response

class MainViewModel (private val repository: Repository) : ViewModel() {

    val myResponse: MutableLiveData<Response<ResultModel>> = MutableLiveData()
    fun getNews() {
        viewModelScope.launch{

            val response = repository.getNews()
            myResponse.value = response
        }
    }
}