package mdeveloping.mine.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
/*

class NewsAdapter(private val context :Context , private val dataSource : ArrayList<News>) : BaseAdapter {

    private val inflater : LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    //1
    override fun getCount(): Int {
        return dataSource.size
    }

    //2
    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    //3
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    //4
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_news, parent, false)

        val titleTextView = rowView.findViewById(R.id.newsTitle) as TextView
        val detailsTextView = rowView.findViewById(R.id.newsDetails) as TextView
        val thumbnailImageView = rowView.findViewById(R.id.newsImage) as ImageView
        return rowView
    }
}*/
