package mdeveloping.mine.myapplication.api

import mdeveloping.mine.myapplication.model.NewsModel
import mdeveloping.mine.myapplication.model.ResultModel
import retrofit2.Response
import retrofit2.http.GET
interface NewsAPI {

    @GET("7.json?api-key=8UytovCMGBXxAwHwDs3AcRr32i7IskEq")
    suspend fun getNews(): Response<ResultModel>
}