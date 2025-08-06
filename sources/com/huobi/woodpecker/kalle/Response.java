package com.huobi.woodpecker.kalle;

import com.huobi.woodpecker.kalle.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;

public final class Response implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final int f21027b;

    /* renamed from: c  reason: collision with root package name */
    public final Headers f21028c;

    /* renamed from: d  reason: collision with root package name */
    public final m f21029d;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f21030a;

        /* renamed from: b  reason: collision with root package name */
        public Headers f21031b;

        /* renamed from: c  reason: collision with root package name */
        public m f21032c;

        public Builder d(m mVar) {
            this.f21032c = mVar;
            return this;
        }

        public Response e() {
            return new Response(this);
        }

        public Builder f(int i11) {
            this.f21030a = i11;
            return this;
        }

        public Builder g(Headers headers) {
            this.f21031b = headers;
            return this;
        }
    }

    public static Builder g() {
        return new Builder();
    }

    public m a() {
        return this.f21029d;
    }

    public int b() {
        return this.f21027b;
    }

    public void close() throws IOException {
        IOUtils.a(this.f21029d);
    }

    public Headers e() {
        return this.f21028c;
    }

    public boolean f() {
        int i11 = this.f21027b;
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
        this.f21027b = builder.f21030a;
        this.f21028c = builder.f21031b;
        this.f21029d = builder.f21032c;
    }
}
