package com.pranasabda.android.restphotoapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;
import android.widget.Toast;

import com.pranasabda.android.restphotoapi.adapter.DataAdapter;
import com.pranasabda.android.restphotoapi.api.RequestInterface;
import com.pranasabda.android.restphotoapi.models.photoModels;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<photoModels> data;
    private DataAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }

    private void loadJSON(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);

        Call<List<photoModels>> call = request.getJSON();
        call.enqueue(new Callback<List<photoModels>>() {

            @Override
            public void onResponse(Call<List<photoModels>> call, Response<List<photoModels>> response) {
                List<photoModels> respon = response.body();

                data = new ArrayList<>(respon);
                adapter = new DataAdapter(MainActivity.this,data);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<photoModels>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Tidak Ada Koneksi/Repo ngga ada", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
