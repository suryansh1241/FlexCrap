package com.example.hoho;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface apiset {
    @FormUrlEncoded
    @POST("signUp.php")
    Call<sign_up_response_model> getregister(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("mobile") String mobile,
            @Field("address") String address
    );
    @FormUrlEncoded
    @POST("login.php")
    Call<login_response_model> getlogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("get_categories.php")
    Call<List<category>> getCategories();

    @GET("get_products_by_category.php")
    Call<List<Product>> getProductsByCategory(@Query("catid") int catid);
}