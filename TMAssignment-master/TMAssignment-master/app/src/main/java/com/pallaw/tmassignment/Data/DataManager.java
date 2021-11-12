package com.pallaw.tmassignment.Data;

import android.app.Activity;
import android.content.Context;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.pallaw.tmassignment.R;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pallaw Pathak on 2019-06-14. - https://www.linkedin.com/in/pallaw-pathak-a6a324a1/
 */
public class DataManager {

    public static final String HEADER_CACHE_CONTROL = "Cache-Control";
    public static final String HEADER_PRAGMA = "Pragma";
    private static final String TAG = DataManager.class.getSimpleName();
    private ApiServices apiServices;
    private Activity mContext;

    public DataManager(Activity mContext) {
        this.mContext = mContext;

        init();
    }

    public void init() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        File httpCacheDirectory = new File(mContext.getCacheDir(), "offlineCache");

        //10 MB
        Cache cache = new Cache(httpCacheDirectory, 10 * 1024 * 1024);

        OkHttpClient httpClient = new OkHttpClient.Builder().cache(cache)
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(provideCacheInterceptor())
                .addInterceptor(provideOfflineCacheInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .client(httpClient)
                .baseUrl(ApiServices.BASE_URL)
                .build();

        apiServices = retrofit.create(ApiServices.class);
    }

    private Interceptor provideOfflineCacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();

                if (!isConnected()) {
                    CacheControl cacheControl = new CacheControl.Builder().maxStale(7, TimeUnit.DAYS)
                            .build();

                    request = request.newBuilder()
                            .removeHeader(HEADER_PRAGMA)
                            .removeHeader(HEADER_CACHE_CONTROL)
                            .cacheControl(cacheControl)
                            .build();
                }

                return chain.proceed(request);
            }
        };
    }

    private Interceptor provideCacheInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response response = chain.proceed(chain.request());

                CacheControl cacheControl;

                if (isConnected()) {
                    cacheControl = new CacheControl.Builder().maxAge(0, TimeUnit.SECONDS).build();
                } else {
                    cacheControl = new CacheControl.Builder().maxStale(7, TimeUnit.DAYS).build();
                }

                return response.newBuilder()
                        .removeHeader(HEADER_PRAGMA)
                        .removeHeader(HEADER_CACHE_CONTROL)
                        .header(HEADER_CACHE_CONTROL, cacheControl.toString())
                        .build();

            }

            ;

        };
    }

    private boolean isConnected() {
        try {
            android.net.ConnectivityManager e = (android.net.ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetwork = e.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
            if (!isConnected) {
                showConnectionErrorMsg();
            }
            return isConnected;
        } catch (Exception e) {
            Log.w(TAG, e.toString());
        }

        return false;
    }

    private void showConnectionErrorMsg() {
        Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mContext, mContext.getResources()
                        .getString(R.string.error_connection), Toast.LENGTH_LONG).show();
            }
        });
    }

    public ApiServices getApiService() {
        if (null == apiServices) {
            try {
                throw new Exception("Data Manager is not initialized \n Please use DataManager.getInstance().init() to before using getApiService");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return apiServices;
    }
}
