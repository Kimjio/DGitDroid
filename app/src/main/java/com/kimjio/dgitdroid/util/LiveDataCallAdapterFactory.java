package com.kimjio.dgitdroid.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;

import com.kimjio.dgitdroid.model.Response;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

public class LiveDataCallAdapterFactory extends CallAdapter.Factory {
    @Nullable
    @Override
    public CallAdapter<?, ?> get(@NonNull Type returnType, @NonNull Annotation[] annotations, @NonNull Retrofit retrofit) {
        if (getRawType(returnType) != LiveData.class)
        return null;

        Type observableType = getParameterUpperBound(0, (ParameterizedType) returnType);
        Type rawObservableType = getRawType(observableType);
        if (rawObservableType != Response.class)
            throw new IllegalArgumentException("type must be a resource");
        if (!(observableType instanceof ParameterizedType))
            throw new IllegalArgumentException("resource must be parameterized");
        return new LiveDataCallAdapter<>(observableType);
    }
}
