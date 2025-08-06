package com.amazonaws;

import com.amazonaws.http.HttpResponse;

public final class Response<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f14808a;

    /* renamed from: b  reason: collision with root package name */
    public final HttpResponse f14809b;

    public Response(T t11, HttpResponse httpResponse) {
        this.f14808a = t11;
        this.f14809b = httpResponse;
    }

    public T a() {
        return this.f14808a;
    }

    public HttpResponse b() {
        return this.f14809b;
    }
}
