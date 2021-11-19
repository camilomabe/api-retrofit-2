import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun main(){

    val eject = MainActivity()
    eject.onCreate()
}

class MainActivity {

    private lateinit var service: ApiService
    fun onCreate() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(ApiService::class.java)
        getPostByIdKg()
    }

    private fun getPostByIdKg() {
        var post: Post?
        service.getPostById(3).enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>?, response: Response<Post>?) {
                post = response?.body()
                println(Gson().toJson(post))
            }
            override fun onFailure(call: Call<Post>?, t: Throwable?) {
                t?.printStackTrace()
            }
        })
    }
}