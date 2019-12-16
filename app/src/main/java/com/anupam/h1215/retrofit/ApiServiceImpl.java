package com.anupam.h1215.retrofit;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.anupam.h1215.retrofit.ApiUrls.BASE_URL;

public class ApiServiceImpl{

    private static ApiService userService;
    private static final String TAG = ApiServiceImpl.class.getName();
    private static final Retrofit retrofit ;

    static {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        try {
            userService = retrofit.create(ApiService.class);
        }catch (Exception ex){
            Log.e(TAG,ex.toString());
        }
    }


    public static ResponseBody displayWelcome(final Context context, TextView textView){

        Call<ResponseBody> call = userService.welcome();
        final ResponseBody[] result = new ResponseBody[1];

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    result[0] = response.body();
                    textView.setText(result[0].string());
                    Log.d(TAG, response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(context,call.toString(),Toast.LENGTH_LONG).show();
                textView.setText(t.getMessage());
                t.printStackTrace();
            }
        });

        return result[0];
    }


}
