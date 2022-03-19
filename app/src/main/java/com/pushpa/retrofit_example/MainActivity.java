package com.pushpa.retrofit_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.pushpa.retrofit_example.model.Contact;
import com.pushpa.retrofit_example.model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);

        rv.setLayoutManager(new GridLayoutManager(this,1));



        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Example> data = apiInterface.getContacts();
        Log.e("TAG", "onCreate:Don");
        data.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Example ex=response.body();
                Log.e("response", "onResponse: "+ response.body() );

                List<Contact> myData=ex.getContacts();
                rv.setAdapter(new CustomAdapter(MainActivity.this,myData));
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                Log.e("response", "onResponse: "+ t.getMessage() );

            }
        });
        //        data.enqueue(new Callback<List<Example>>() {
//            @Override
//            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
//                List<Example> data = response.body();
//                Log.e("response", "onResponse: "+ response.body() );
//                rv.setAdapter(new CustomAdapter(MainActivity.this,data));
//            }
//
//            @Override
//            public void onFailure(Call<List<Example>> call, Throwable t) {
//                Log.e("TAG", "onCreate:failed");
//                Log.e("TAG", "onFailure: "+t.getMessage() );
//
//            }
//        });

    }

}