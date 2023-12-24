package com.example.question1

import android.adservices.common.AdData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.question1.databinding.ActivitySecondScreenBinding
import com.example.question1.databinding.ActivityThirdScreenBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdScreenBinding
    private lateinit var adapter: RecycleViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityThirdScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RecycleViewAdapter(this@ThirdScreenActivity, arrayListOf())

        binding.rvMain.adapter = adapter
        binding.rvMain.setHasFixedSize(true)

        remoteGetUser()
    }


    fun remoteGetUser() {
        ApiClient.apiService.getUsers().enqueue(object : Callback<ArrayList<ResponseModel>> {
            override fun onResponse(
                call: Call<ArrayList<ResponseModel>>,
                response: Response<ArrayList<ResponseModel>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    Log.d("API_SUCCESS", "Data: $data")
                    setDataToAdaptor(data!!)
                } else {
                    Log.e("API_ERROR", "Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<ArrayList<ResponseModel>>, t: Throwable) {
                Log.e("API_FAILURE", "Error: ${t.message}")
            }
        })
    }

    fun setDataToAdaptor(data: ArrayList<ResponseModel>){
        adapter.setData(data)
    }
}