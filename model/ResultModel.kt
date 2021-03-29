package mdeveloping.mine.myapplication.model

data class ResultModel (
        val status: String,
        val copyright: String,
        val num_results: Int,
        val results:ArrayList<NewsModel>

        )