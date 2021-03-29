package mdeveloping.mine.myapplication.repository

import mdeveloping.mine.myapplication.api.RetrofitInstance
import mdeveloping.mine.myapplication.model.NewsModel
import mdeveloping.mine.myapplication.model.ResultModel
import retrofit2.Response

class Repository {
    suspend fun getNews(): Response<ResultModel> {
        return RetrofitInstance.api.getNews()
    }
}