package com.amazonaws.http;

import com.facebook.stetho.inspector.network.DecompressionHelper;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class HttpResponse {

    /* renamed from: a  reason: collision with root package name */
    public final String f14889a;

    /* renamed from: b  reason: collision with root package name */
    public final int f14890b;

    /* renamed from: c  reason: collision with root package name */
    public final InputStream f14891c;

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, String> f14892d;

    /* renamed from: e  reason: collision with root package name */
    public InputStream f14893e;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f14894a;

        /* renamed from: b  reason: collision with root package name */
        public int f14895b;

        /* renamed from: c  reason: collision with root package name */
        public InputStream f14896c;

        /* renamed from: d  reason: collision with root package name */
        public final Map<String, String> f14897d = new HashMap();

        public HttpResponse a() {
            return new HttpResponse(this.f14894a, this.f14895b, Collections.unmodifiableMap(this.f14897d), this.f14896c);
        }

        public Builder b(InputStream inputStream) {
            this.f14896c = inputStream;
            return this;
        }

        public Builder c(String str, String str2) {
            this.f14897d.put(str, str2);
            return this;
        }

        public Builder d(int i11) {
            this.f14895b = i11;
            return this;
        }

        public Builder e(String str) {
            this.f14894a = str;
            return this;
        }
    }

    public static Builder a() {
        return new Builder();
    }

    public InputStream b() throws IOException {
        if (this.f14893e == null) {
            synchronized (this) {
                if (this.f14891c == null || !DecompressionHelper.GZIP_ENCODING.equals(this.f14892d.get(HttpHeaders.CONTENT_ENCODING))) {
                    this.f14893e = this.f14891c;
                } else {
                    this.f14893e = new GZIPInputStream(this.f14891c);
                }
            }
        }
        return this.f14893e;
    }

    public Map<String, String> c() {
        return this.f14892d;
    }

    public InputStream d() throws IOException {
        return this.f14891c;
    }

    public int e() {
        return this.f14890b;
    }

    public String f() {
        return this.f14889a;
    }

    public HttpResponse(String str, int i11, Map<String, String> map, InputStream inputStream) {
        this.f14889a = str;
        this.f14890b = i11;
        this.f14892d = map;
        this.f14891c = inputStream;
    }
}
