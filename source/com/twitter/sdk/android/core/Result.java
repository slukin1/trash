package com.twitter.sdk.android.core;

import retrofit2.Response;

public class Result<T> {
    public final T data;
    public final Response response;

    public Result(T t11, Response response2) {
        this.data = t11;
        this.response = response2;
    }
}
