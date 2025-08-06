package com.amazonaws.http;

public interface HttpResponseHandler<T> {
    boolean a();

    T b(HttpResponse httpResponse) throws Exception;
}
