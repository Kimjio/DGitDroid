package com.kimjio.dgitdroid.util;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.kimjio.dgitdroid.model.Response;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;

public class LiveDataCallAdapter<R> implements CallAdapter<R, LiveData<Response<R>>> {
    private Type responseType;

    public LiveDataCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @NonNull
    @Override
    public Type responseType() {
        return this.responseType;
    }

    @NonNull
    @Override
    public LiveData<Response<R>> adapt(@NonNull Call<R> call) {
        return new LiveData<Response<R>>() {
            private AtomicBoolean started = new AtomicBoolean(false);

            @Override
            protected void onActive() {
                super.onActive();
                if (started.compareAndSet(false, true)) {
                    call.enqueue(new Callback<R>() {
                        @Override
                        public void onResponse(@NonNull Call<R> call, @NonNull retrofit2.Response<R> response) {
                            if (response.body() instanceof Response)
                                postValue(Response.create(response.body()));
                        }

                        @Override
                        public void onFailure(@NonNull Call<R> call, @NonNull Throwable t) {
                            t.printStackTrace();
                            postValue(Response.create(t));
                        }
                    });
                }
            }
        };
    }
}
