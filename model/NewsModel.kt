package mdeveloping.mine.myapplication.model

data class NewsModel (
    val uri: String,
    val url: String,
    val id: Long,
    val asset_id: Long,
    val source: String,
    val published_date: String,
    val updated: String,
    val section: String,
    val subsection: String,
    val nytsection: String,
    val adx_keywords: String,
    val byline: String,
    val type: String,
    val title: String,
    val abstract:String,
    val media: ArrayList<MediaModel>,
    val eta_id: Int,
    var isExpanded : Boolean = false
        )