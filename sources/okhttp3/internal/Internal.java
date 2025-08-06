package okhttp3.internal;

import javax.net.ssl.SSLSocket;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

public final class Internal {
    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str) {
        return builder.addLenient$okhttp(str);
    }

    public static final void applyConnectionSpec(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z11) {
        connectionSpec.apply$okhttp(sSLSocket, z11);
    }

    public static final Response cacheGet(Cache cache, Request request) {
        return cache.get$okhttp(request);
    }

    public static final String cookieToString(Cookie cookie, boolean z11) {
        return cookie.toString$okhttp(z11);
    }

    public static final Cookie parseCookie(long j11, HttpUrl httpUrl, String str) {
        return Cookie.Companion.parse$okhttp(j11, httpUrl, str);
    }

    public static final Headers.Builder addHeaderLenient(Headers.Builder builder, String str, String str2) {
        return builder.addLenient$okhttp(str, str2);
    }
}
