package okhttp3;

import com.google.common.net.HttpHeaders;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

public final class Request {
    private final RequestBody body;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Map<Class<?>, Object> tags;
    private final HttpUrl url;

    public static class Builder {
        private RequestBody body;
        private Headers.Builder headers;
        private String method;
        private Map<Class<?>, Object> tags;
        private HttpUrl url;

        public Builder() {
            this.tags = new LinkedHashMap();
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public static /* synthetic */ Builder delete$default(Builder builder, RequestBody requestBody, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 1) != 0) {
                    requestBody = Util.EMPTY_REQUEST;
                }
                return builder.delete(requestBody);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            HttpUrl httpUrl = this.url;
            if (httpUrl != null) {
                return new Request(httpUrl, this.method, this.headers.build(), this.body, Util.toImmutableMap(this.tags));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            if (cacheControl2.length() == 0) {
                return removeHeader(HttpHeaders.CACHE_CONTROL);
            }
            return header(HttpHeaders.CACHE_CONTROL, cacheControl2);
        }

        public final Builder delete() {
            return delete$default(this, (RequestBody) null, 1, (Object) null);
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder get() {
            return method("GET", (RequestBody) null);
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final Map<Class<?>, Object> getTags$okhttp() {
            return this.tags;
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public Builder head() {
            return method("HEAD", (RequestBody) null);
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers2) {
            this.headers = headers2.newBuilder();
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            if (str.length() > 0) {
                if (requestBody == null) {
                    if (!(true ^ HttpMethod.requiresRequestBody(str))) {
                        throw new IllegalArgumentException(("method " + str + " must have a request body.").toString());
                    }
                } else if (!HttpMethod.permitsRequestBody(str)) {
                    throw new IllegalArgumentException(("method " + str + " must not have a request body.").toString());
                }
                this.method = str;
                this.body = requestBody;
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return method("POST", requestBody);
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            this.headers = builder;
        }

        public final void setMethod$okhttp(String str) {
            this.method = str;
        }

        public final void setTags$okhttp(Map<Class<?>, Object> map) {
            this.tags = map;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public Builder tag(Object obj) {
            return tag(Object.class, obj);
        }

        public Builder url(HttpUrl httpUrl) {
            this.url = httpUrl;
            return this;
        }

        public <T> Builder tag(Class<? super T> cls, T t11) {
            if (t11 == null) {
                this.tags.remove(cls);
            } else {
                if (this.tags.isEmpty()) {
                    this.tags = new LinkedHashMap();
                }
                this.tags.put(cls, cls.cast(t11));
            }
            return this;
        }

        public Builder url(String str) {
            if (StringsKt__StringsJVMKt.K(str, "ws:", true)) {
                str = "http:" + str.substring(3);
            } else if (StringsKt__StringsJVMKt.K(str, "wss:", true)) {
                str = "https:" + str.substring(4);
            }
            return url(HttpUrl.Companion.get(str));
        }

        public Builder(Request request) {
            Map<Class<?>, Object> map;
            this.tags = new LinkedHashMap();
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            if (request.getTags$okhttp().isEmpty()) {
                map = new LinkedHashMap<>();
            } else {
                map = MapsKt__MapsKt.y(request.getTags$okhttp());
            }
            this.tags = map;
            this.headers = request.headers().newBuilder();
        }

        public Builder url(URL url2) {
            return url(HttpUrl.Companion.get(url2.toString()));
        }
    }

    public Request(HttpUrl httpUrl, String str, Headers headers2, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        this.url = httpUrl;
        this.method = str;
        this.headers = headers2;
        this.body = requestBody;
        this.tags = map;
    }

    /* renamed from: -deprecated_body  reason: not valid java name */
    public final RequestBody m3197deprecated_body() {
        return this.body;
    }

    /* renamed from: -deprecated_cacheControl  reason: not valid java name */
    public final CacheControl m3198deprecated_cacheControl() {
        return cacheControl();
    }

    /* renamed from: -deprecated_headers  reason: not valid java name */
    public final Headers m3199deprecated_headers() {
        return this.headers;
    }

    /* renamed from: -deprecated_method  reason: not valid java name */
    public final String m3200deprecated_method() {
        return this.method;
    }

    /* renamed from: -deprecated_url  reason: not valid java name */
    public final HttpUrl m3201deprecated_url() {
        return this.url;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = parse;
        return parse;
    }

    public final Map<Class<?>, Object> getTags$okhttp() {
        return this.tags;
    }

    public final String header(String str) {
        return this.headers.get(str);
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public final String method() {
        return this.method;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final Object tag() {
        return tag(Object.class);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Request{method=");
        sb2.append(this.method);
        sb2.append(", url=");
        sb2.append(this.url);
        if (this.headers.size() != 0) {
            sb2.append(", headers=[");
            int i11 = 0;
            for (Object next : this.headers) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
                Pair pair = (Pair) next;
                String str = (String) pair.component1();
                String str2 = (String) pair.component2();
                if (i11 > 0) {
                    sb2.append(", ");
                }
                sb2.append(str);
                sb2.append(':');
                sb2.append(str2);
                i11 = i12;
            }
            sb2.append(']');
        }
        if (!this.tags.isEmpty()) {
            sb2.append(", tags=");
            sb2.append(this.tags);
        }
        sb2.append('}');
        return sb2.toString();
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final List<String> headers(String str) {
        return this.headers.values(str);
    }

    public final <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.tags.get(cls));
    }
}
