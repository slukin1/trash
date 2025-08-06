package com.hbg.lib.network.hbg.retrofit;

import c9.b;
import okhttp3.OkHttpClient;

public class H5Retrofit extends c9.a<b> {

    /* renamed from: a  reason: collision with root package name */
    public String f70290a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static H5Retrofit f70291a = new H5Retrofit();
    }

    public static H5Retrofit b() {
        return a.f70291a;
    }

    public static <T> T request(Class<T> cls) {
        return b().doRequest(cls);
    }

    public String a() {
        return this.f70290a;
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        super.buildOkHttpClient(builder);
    }

    public void c(String str) {
        this.f70290a = str;
    }
}
