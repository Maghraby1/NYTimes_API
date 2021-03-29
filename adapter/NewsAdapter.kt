package mdeveloping.mine.myapplication.adapter

import android.R.attr.button
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import mdeveloping.mine.myapplication.R
import mdeveloping.mine.myapplication.model.NewsModel


class NewsAdapter(val newsList: ArrayList<NewsModel>) : RecyclerView.Adapter<NewsAdapter.NewsNH>() {
    class NewsNH(itemView: View) : RecyclerView.ViewHolder(itemView){
        var moreBtn : ImageButton = itemView.findViewById(R.id.moreBtn)
        var newsThumb : ImageView = itemView.findViewById(R.id.newsThumb)
        var textTitle : TextView = itemView.findViewById(R.id.textTitle)
        var detailedTitle : TextView = itemView.findViewById(R.id.detailedTitle)
        var detailedNews : TextView = itemView.findViewById(R.id.detailedNews)
        var date: TextView = itemView.findViewById(R.id.textDate)
        var author : TextView = itemView.findViewById(R.id.textAuthor)
        var detailedDate: TextView = itemView.findViewById(R.id.detailedDate)
        var detailedAuthor : TextView = itemView.findViewById(R.id.detailedAuthor)
        var linearLayout: LinearLayout = itemView.findViewById(R.id.linearLayout)
        var expandableLayout: ConstraintLayout = itemView.findViewById(R.id.expandableLayout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsNH {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.news_item,
            parent,
            false
        )

        return NewsNH(view)
    }

    override fun onBindViewHolder(holder: NewsNH, position: Int) {
        val news : NewsModel = newsList[position]
        holder.detailedNews.text = news.abstract
        holder.detailedTitle.text = news.title
        holder.textTitle.text = news.title
        holder.author.text = news.byline
        holder.date.text = news.published_date
        holder.detailedAuthor.text = news.byline
        val lastUpdated = StringBuilder()
        lastUpdated.append("Published date: ").append(news.published_date).append(System.lineSeparator()).append(
            "Last Updated: "
        ).append(news.updated)
        holder.detailedDate.text =  lastUpdated.toString()
        val picasso = Picasso.get()
        try{
            picasso.load(news.media[0].media_metadata[0].url).into(holder.newsThumb)
        }catch (e: Exception){
            picasso.load("https//:").error(R.drawable.ic_baseline_image_not_supported_24).into(holder.newsThumb)
        }
        val isExpanded : Boolean = newsList[position].isExpanded
        if (isExpanded){
            holder.expandableLayout.visibility = View.VISIBLE
            holder.textTitle.visibility  = View.GONE
            holder.author.visibility = View.GONE
            holder.date.visibility = View.GONE
            holder.moreBtn.setImageResource(R.drawable.ic_baseline_expand_less_24);
        }else{
            holder.expandableLayout.visibility = View.GONE
            holder.textTitle.visibility = View.VISIBLE
            holder.author.visibility = View.VISIBLE
            holder.date.visibility = View.VISIBLE
            holder.moreBtn.setImageResource(R.drawable.ic_baseline_expand_more_24);
        }

        holder.moreBtn.setOnClickListener {
            val news = newsList[position]
            news.isExpanded = !news.isExpanded

            notifyItemChanged(position)

        }
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}