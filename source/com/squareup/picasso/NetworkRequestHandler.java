package com.squareup.picasso;

import android.net.NetworkInfo;
import com.adjust.sdk.Constants;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import okhttp3.CacheControl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Source;

public class NetworkRequestHandler extends RequestHandler {

    /* renamed from: a  reason: collision with root package name */
    public final i f29947a;

    /* renamed from: b  reason: collision with root package name */
    public final t f29948b;

    public static class ContentLengthException extends IOException {
        public ContentLengthException(String str) {
            super(str);
        }
    }

    public static final class ResponseException extends IOException {
        public final int code;
        public final int networkPolicy;

        public ResponseException(int i11, int i12) {
            super("HTTP " + i11);
            this.code = i11;
            this.networkPolicy = i12;
        }
    }

    public NetworkRequestHandler(i iVar, t tVar) {
        this.f29947a = iVar;
        this.f29948b = tVar;
    }

    public static Request j(q qVar, int i11) {
        CacheControl cacheControl;
        if (i11 == 0) {
            cacheControl = null;
        } else if (NetworkPolicy.isOfflineOnly(i11)) {
            cacheControl = CacheControl.FORCE_CACHE;
        } else {
            CacheControl.Builder builder = new CacheControl.Builder();
            if (!NetworkPolicy.shouldReadFromDiskCache(i11)) {
                builder.noCache();
            }
            if (!NetworkPolicy.shouldWriteToDiskCache(i11)) {
                builder.noStore();
            }
            cacheControl = builder.build();
        }
        Request.Builder url = new Request.Builder().url(qVar.f30085d.toString());
        if (cacheControl != null) {
            url.cacheControl(cacheControl);
        }
        return url.build();
    }

    public boolean c(q qVar) {
        String scheme = qVar.f30085d.getScheme();
        return "http".equals(scheme) || Constants.SCHEME.equals(scheme);
    }

    public int e() {
        return 2;
    }

    public RequestHandler.a f(q qVar, int i11) throws IOException {
        Response a11 = this.f29947a.a(j(qVar, i11));
        ResponseBody body = a11.body();
        if (a11.isSuccessful()) {
            Picasso.LoadedFrom loadedFrom = a11.cacheResponse() == null ? Picasso.LoadedFrom.NETWORK : Picasso.LoadedFrom.DISK;
            if (loadedFrom == Picasso.LoadedFrom.DISK && body.contentLength() == 0) {
                body.close();
                throw new ContentLengthException("Received response with 0 content-length header.");
            }
            if (loadedFrom == Picasso.LoadedFrom.NETWORK && body.contentLength() > 0) {
                this.f29948b.f(body.contentLength());
            }
            return new RequestHandler.a((Source) body.source(), loadedFrom);
        }
        body.close();
        throw new ResponseException(a11.code(), qVar.f30084c);
    }

    public boolean h(boolean z11, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    public boolean i() {
        return true;
    }
}
