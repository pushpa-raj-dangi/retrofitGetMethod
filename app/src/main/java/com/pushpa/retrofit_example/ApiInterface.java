package com.pushpa.retrofit_example;

import com.pushpa.retrofit_example.model.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("users")
    Call<List<User>> getRequest();

    @GET("contacts")
    Call<Example> getContacts();
}
