import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("posts/{id}")
    fun getPostById(@Path("id") id: Int): Call<Post>

}