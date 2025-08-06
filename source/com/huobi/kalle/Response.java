package com.huobi.kalle;

import com.huobi.kalle.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;

public final class Response implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final int f74669b;

    /* renamed from: c  reason: collision with root package name */
    public final Headers f74670c;

    /* renamed from: d  reason: collision with root package name */
    public final m f74671d;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f74672a;

        /* renamed from: b  reason: collision with root package name */
        public Headers f74673b;

        /* renamed from: c  reason: collision with root package name */
        public m f74674c;

        public Builder d(m mVar) {
            this.f74674c = mVar;
            return this;
        }

        public Response e() {
            return new Response(this);
        }

        public Builder f(int i11) {
            this.f74672a = i11;
            return this;
        }

        public Builder g(Headers headers) {
            this.f74673b = headers;
            return this;
        }
    }

    public static Builder g() {
        return new Builder();
    }

    public m a() {
        return this.f74671d;
    }

    public int b() {
        return this.f74669b;
    }

    public void close() throws IOException {
        IOUtils.a(this.f74671d);
    }

    public Headers e() {
        return this.f74670c;
    }

    public boolean f() {
        int i11 = this.f74669b;
        if (i11 == 307 || i11 == 308) {
            return true;
        }
        switch (i11) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public Response(Builder builder) {
        this.f74669b = builder.f74672a;
        this.f74670c = builder.f74673b;
        this.f74671d = builder.f74674c;
    }
}
