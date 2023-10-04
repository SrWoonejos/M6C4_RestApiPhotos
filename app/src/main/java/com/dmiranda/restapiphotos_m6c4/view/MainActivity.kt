package com.dmiranda.restapiphotos_m6c4.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmiranda.restapiphotos_m6c4.databinding.ActivityMainBinding
import com.dmiranda.restapiphotos_m6c4.model.Photo
import com.dmiranda.restapiphotos_m6c4.retrofit.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadApiData()
    }

    private fun initRecyclerView(photos: ArrayList<Photo>) {
        val recyclerView = binding.recyclerViewPhotos
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PhotoAdapter(photos)
    }

    private fun loadApiData() {
        CoroutineScope(Dispatchers.IO).launch {
            val service = RetrofitClient.retrofitInstance()
            val call: Response<ArrayList<Photo>> = service.getAllPhotos()
            val photos: ArrayList<Photo>? = call.body()

            runOnUiThread {
                if (call.isSuccessful) {
                    if (photos != null) {
                        initRecyclerView(photos)
                    }
                }else
                {
                    showToast()
                }
            }
        }
    }

    private fun runOnUiThread(function: () -> Unit) {

    }

    private fun showToast(){
        Toast.makeText(this,"No se pudo cargar los datos desde la API",Toast.LENGTH_SHORT).show()
    }
}

