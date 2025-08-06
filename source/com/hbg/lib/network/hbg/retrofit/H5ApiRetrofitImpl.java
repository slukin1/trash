package com.hbg.lib.network.hbg.retrofit;

import android.content.Context;
import c9.b;
import com.hbg.lib.network.hbg.retrofit.service.H5Service;
import com.hbg.lib.network.retrofit.util.RetrofitLogger;
import d9.a;
import java.util.Map;
import okhttp3.ResponseBody;
import v7.c;

public class H5ApiRetrofitImpl implements c {

    /* renamed from: a  reason: collision with root package name */
    public b f70288a;

    /* renamed from: b  reason: collision with root package name */
    public String f70289b;

    public void a(String str, Context context, b bVar) {
        this.f70289b = str;
        RetrofitLogger.a(this.f70289b + "-->init");
        this.f70288a = bVar;
        H5Retrofit.b().init(str, context, bVar);
    }

    public a<ResponseBody> postH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2) {
        return new a<>(((H5Service) H5Retrofit.request(H5Service.class)).postH5UrlRequest(str, map, map2));
    }

    public a<ResponseBody> putH5UrlRequest(String str, Map<String, String> map, Map<String, Object> map2) {
        return new a<>(((H5Service) H5Retrofit.request(H5Service.class)).putH5UrlRequest(str, map, map2));
    }
}
