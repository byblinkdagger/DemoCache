package com.blink.dagger.democache;

import android.content.Context;

import com.blink.dagger.democache.cache.CaheInterceptor;
import com.blink.dagger.democache.cache.NovateCookieManger;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lucky on 2017/4/14.
 */
public class RetrofitClient {

    private static volatile Retrofit retrofit;

    public static GirlService singletonGank (Context context){
        if (retrofit == null) {
            synchronized (RetrofitClient.class){
                if (retrofit == null) {
                    retrofit=new Retrofit.Builder().baseUrl("http://gank.io/api/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                            //偷个懒直接写一起
                            .client(new OkHttpClient.Builder()
                                    .cookieJar(new NovateCookieManger(context))
//                                    .cache(new Cache(new File(context.getCacheDir(), "test_cache"),10 * 1024 * 1024))
                                    .cache(new Cache(new File(context.getExternalCacheDir(),"test_cache"),10 * 1024 * 1024))
                                    .addInterceptor(new CaheInterceptor(context))
                                    .addNetworkInterceptor(new CaheInterceptor(context))
                                    .connectTimeout(5, TimeUnit.SECONDS)
                                    .build())
                            .build();
                }
            }
        }
        return retrofit.create(GirlService.class);
    }
}
