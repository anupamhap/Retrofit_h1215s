package com.anupam.h1215.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.anupam.h1215.retrofit.ApiUrls.BASE_URL;

public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private ApiService userService;
    private String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Application.ApplicationContext = getApplicationContext();

    }

    public void makeApiCall(View view) {

      ApiServiceImpl.displayWelcome(this,(TextView)findViewById(R.id.textViewWelcome));

    }
}
