package com.hbg.lib.common.network.params;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import okhttp3.CacheControl;

public abstract class AbstractParams implements IParams {
    public CacheControl cacheControl;
    public Map<String, Object> headers = new HashMap();
    public Map<String, Object> requestParams = new HashMap();
    public Object tag;
    public String url;

    public static abstract class Builder<B extends Builder<B, T>, T extends AbstractParams> {

        /* renamed from: a  reason: collision with root package name */
        public T f67471a;

        /* renamed from: b  reason: collision with root package name */
        public String f67472b;

        /* renamed from: c  reason: collision with root package name */
        public Object f67473c;

        /* renamed from: d  reason: collision with root package name */
        public CacheControl f67474d;

        /* renamed from: e  reason: collision with root package name */
        public Map<String, Object> f67475e = new HashMap();

        /* renamed from: f  reason: collision with root package name */
        public Map<String, Object> f67476f = new HashMap();
    }

    public AbstractParams(Builder builder) {
        T t11 = builder.f67471a;
        if (t11 != null) {
            this.url = t11.url;
            this.tag = t11.tag;
            this.headers.putAll(t11.headers);
            this.requestParams.putAll(builder.f67471a.requestParams);
        }
        if (!TextUtils.isEmpty(builder.f67472b)) {
            this.url = builder.f67472b;
        }
        if (this.tag != null) {
            this.tag = builder.f67473c;
        }
        this.headers.putAll(builder.f67475e);
        this.requestParams.putAll(builder.f67476f);
        this.cacheControl = builder.f67474d;
    }

    public CacheControl getCacheControl() {
        return this.cacheControl;
    }

    public Map<String, Object> getHeaders() {
        return this.headers;
    }

    public Map<String, Object> getParams() {
        return this.requestParams;
    }

    public Object getTag() {
        return this.tag;
    }

    public String getUrl() {
        return this.url;
    }
}
