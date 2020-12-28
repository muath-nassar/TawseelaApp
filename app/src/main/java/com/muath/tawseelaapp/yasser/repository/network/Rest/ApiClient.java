package com.muath.tawseelaapp.yasser.repository.network.Rest;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {


    public static final String TAG = ApiClient.class.getSimpleName();

    private static final String SERVER_URL = "https://covid-19-data.p.rapidapi.com/";
    private static Retrofit retrofit = null;

    public static ApiInterface getApiClient(Context context) {

        LoggingInterceptor loggingInterceptor = new LoggingInterceptor();


        File cacheFile = new File(context.getCacheDir(), "http_cache");
        cacheFile.mkdir();
        Cache cache = new Cache(cacheFile, 10 * 1000 * 1000);


        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();


        // Gson gson1 = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Gson gson1 = new GsonBuilder()
                .setLenient()
                .create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(SERVER_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson1))
                .client(okHttpClient)
                .build();
        return retrofit.create(ApiInterface.class);

    }


    private static class LoggingInterceptor implements Interceptor {


        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();

//            boolean isLoggedIn = AuthManager.getInstance().isUserLoggedIn();

            request = request.newBuilder()
                    .header("Accept", "application/json")
                    .header("x-rapidapi-key","08c1f75f43mshb92cea66dd4216cp1bdb05jsn99e3cd94c194")
                    .method(request.method(), request.body()).build();

            long t1 = System.nanoTime();

            Response response = chain.proceed(request);
            long t2 = System.nanoTime();

            String responseLog = String.format(Locale.US, "Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers());

            String bodyString = response.body().string();
            Log.d("TAG", "response" + "\n" + responseLog + "\n Response Body : " + bodyString);


            return response.newBuilder()
                    .body(ResponseBody.create(response.body().contentType(), bodyString))

                    .build();
        }
    }
}
