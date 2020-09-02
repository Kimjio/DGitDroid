package com.kimjio.dgitdroid.model;

public class Response<T> {
    private String message;
    private T data;
    private Throwable throwable;

    private Response(String message, T data, Throwable throwable) {
        this.message = message;
        this.data = data;
        this.throwable = throwable;
    }

    @SuppressWarnings("unchecked")
    public static <T> Response<T> create(T body) {
        if (body instanceof Response) {
            return new Response<T>(((Response<T>) body).message, ((Response<T>) body).data, ((Response<T>) body).throwable);
        }
        return null;
    }

    public static <T> Response<T> create(Throwable throwable) {
        return new Response<T>(null, null, throwable);
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
