package com.anupam.h1215.retrofit;

import com.anupam.h1215.retrofit.User;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

public interface ApiService {

    @GET("users/{userId}")
    Call<ResponseBody> getUserById(@Path("userId") String userId);

    @GET("hello")
    Call<ResponseBody> welcome();

    @GET("group/{id}/users")
    @Headers("Cache-Control: max-age=640000")
    Call<List<User>> groupList(@Path("id") int groupId, @QueryMap Map<String, String> options);

    @POST("users/new")
    Call<User> createUser(@Body User user);

//    @FormUrlEncoded
//    @POST("user/edit")
//    Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);
//
//    @Multipart
//    @PUT("user/photo")
//    Call<User> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);

}
