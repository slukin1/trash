package com.huobi.woodpecker;

import android.text.TextUtils;
import com.facebook.stetho.inspector.network.DecompressionHelper;
import com.google.common.net.HttpHeaders;
import com.huobi.woodpecker.a;
import com.huobi.woodpecker.utils.ReflectUtils;
import java.io.IOException;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealInterceptorChain;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class WoodpeckerEventListenerInterceptor implements Interceptor {

    public static class a extends ResponseBody {

        /* renamed from: b  reason: collision with root package name */
        public final ResponseBody f20939b;

        /* renamed from: c  reason: collision with root package name */
        public final a.c f20940c;

        /* renamed from: d  reason: collision with root package name */
        public BufferedSource f20941d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f20942e;

        /* renamed from: com.huobi.woodpecker.WoodpeckerEventListenerInterceptor$a$a  reason: collision with other inner class name */
        public class C0159a extends ForwardingSource {

            /* renamed from: b  reason: collision with root package name */
            public long f20943b = 0;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Buffer f20944c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0159a(Source source, Buffer buffer) {
                super(source);
                this.f20944c = buffer;
            }

            public long read(Buffer buffer, long j11) throws IOException {
                long read = super.read(buffer, j11);
                try {
                    buffer.copyTo(this.f20944c, 0, buffer.size());
                    int i11 = (read > -1 ? 1 : (read == -1 ? 0 : -1));
                    long j12 = this.f20943b + (i11 != 0 ? read : 0);
                    this.f20943b = j12;
                    if (i11 == 0 || j12 == a.this.f20939b.contentLength()) {
                        a.this.f20940c.a(a.this.f20939b, this.f20944c, a.this.f20942e);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    a.this.f20940c.a(a.this.f20939b, this.f20944c, a.this.f20942e);
                }
                return read;
            }
        }

        public a(ResponseBody responseBody, a.c cVar, boolean z11) {
            this.f20939b = responseBody;
            this.f20940c = cVar;
            this.f20942e = z11;
        }

        public long contentLength() {
            return this.f20939b.contentLength();
        }

        public MediaType contentType() {
            return this.f20939b.contentType();
        }

        public final Source f(Source source) {
            return new C0159a(source, new Buffer());
        }

        public BufferedSource source() {
            if (this.f20941d == null) {
                this.f20941d = Okio.buffer(f(this.f20939b.source()));
            }
            return this.f20941d;
        }
    }

    public final boolean a(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        if (TextUtils.isEmpty(str)) {
            str = headers.get("content-encoding");
        }
        return DecompressionHelper.GZIP_ENCODING.equalsIgnoreCase(str);
    }

    public final boolean b(Headers headers) {
        String str = headers.get("Content-Type");
        if (TextUtils.isEmpty(str)) {
            str = headers.get("content-type");
        }
        if (str == null) {
            return false;
        }
        if (str.toLowerCase().contains("application/json") || str.toLowerCase().contains("text/plain")) {
            return true;
        }
        return false;
    }

    public final EventListener c(RealInterceptorChain realInterceptorChain) {
        Object a11 = ReflectUtils.a(Object.class, RealInterceptorChain.class, "exchange", realInterceptorChain, true);
        return (EventListener) ReflectUtils.a(EventListener.class, a11.getClass(), "eventListener", a11, true);
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Response proceed = chain.proceed(realInterceptorChain.request());
        if (!b(proceed.headers())) {
            return proceed;
        }
        EventListener c11 = c(realInterceptorChain);
        if (!(c11 instanceof a)) {
            return proceed;
        }
        a aVar = (a) c11;
        aVar.i();
        boolean a11 = a(proceed.headers());
        return proceed.newBuilder().body(new a(proceed.body(), aVar.f20964r, a11)).build();
    }
}
