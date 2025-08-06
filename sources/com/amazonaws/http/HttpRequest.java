package com.amazonaws.http;

import com.amazonaws.util.StringUtils;
import java.io.InputStream;
import java.net.URI;
import java.util.Collections;
import java.util.Map;

public class HttpRequest {

    /* renamed from: a  reason: collision with root package name */
    public final String f14884a;

    /* renamed from: b  reason: collision with root package name */
    public URI f14885b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, String> f14886c;

    /* renamed from: d  reason: collision with root package name */
    public final InputStream f14887d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f14888e;

    public HttpRequest(String str, URI uri, Map<String, String> map, InputStream inputStream) {
        Map<String, String> map2;
        this.f14884a = StringUtils.c(str);
        this.f14885b = uri;
        if (map == null) {
            map2 = Collections.EMPTY_MAP;
        } else {
            map2 = Collections.unmodifiableMap(map);
        }
        this.f14886c = map2;
        this.f14887d = inputStream;
    }

    public InputStream a() {
        return this.f14887d;
    }

    public long b() {
        String str;
        Map<String, String> map = this.f14886c;
        if (map == null || (str = map.get("Content-Length")) == null || str.isEmpty()) {
            return 0;
        }
        return Long.valueOf(str).longValue();
    }

    public Map<String, String> c() {
        return this.f14886c;
    }

    public String d() {
        return this.f14884a;
    }

    public URI e() {
        return this.f14885b;
    }

    public boolean f() {
        return this.f14888e;
    }

    public void g(boolean z11) {
        this.f14888e = z11;
    }
}
