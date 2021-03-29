package mdeveloping.mine.myapplication

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import mdeveloping.mine.myapplication.adapter.NewsAdapter
import mdeveloping.mine.myapplication.model.NewsModel
import mdeveloping.mine.myapplication.repository.Repository


class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)

        val repository = Repository()

        if (getConnectionType(this) != 0) {
            val viewModelFactory = MainViewModelFactory(repository)
            viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
            viewModel.getNews()
            viewModel.myResponse.observe(this, Observer { response ->
                if (response.isSuccessful) {
                    var _newsList = ArrayList<NewsModel>(response.body()?.results)
                    setRecyclerView(_newsList)
                    Log.d("Response title", response.body()?.status.toString())
                } else {
                    myToast("Something wrong happened! Please try again later.")
                    Log.d("Response error", response.code().toString())
                }
            })
        } else {
            myToast("No internet connection!")
        }
    }

    private fun setRecyclerView(newsList: ArrayList<NewsModel>) {
        val newsAdapter = NewsAdapter(newsList)
        recyclerView.adapter = newsAdapter
        recyclerView.setHasFixedSize(false)

    }

    fun getConnectionType(context: Context): Int {
        var result = 0 // Returns connection type. 0: none; 1: mobile data; 2: wifi
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        cm?.run {
            cm.getNetworkCapabilities(cm.activeNetwork)?.run {
                if (hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    result = 2
                } else if (hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    result = 1
                } else if (hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                    result = 3
                }
            }
        }
        return result
    }

    fun myToast(toastText: String) {
        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show()
    }

}