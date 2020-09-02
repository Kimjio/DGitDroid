package com.kimjio.dgitdroid.util;

import java.util.Map;
import java.util.WeakHashMap;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RetrofitUtil {

    private static final Map<String, Retrofit> INSTANCES = new WeakHashMap<>();

    private RetrofitUtil() {
    }

    public static Retrofit getInstance(String url) {
        Retrofit retrofit = INSTANCES.get(url);
        if (retrofit == null)
            synchronized (RetrofitUtil.class) {
                if (INSTANCES.get(url) == null) {
                    retrofit = new Retrofit.Builder()
                            .baseUrl(url)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                            .build();
                    INSTANCES.put(url, retrofit);
                }
            }
        return retrofit;
    }
}
