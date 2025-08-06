package t8;

import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class b extends ResponseBody {

    /* renamed from: f  reason: collision with root package name */
    public static final String f70929f = b.class.getName();

    /* renamed from: b  reason: collision with root package name */
    public ResponseBody f70930b;

    /* renamed from: c  reason: collision with root package name */
    public a f70931c;

    /* renamed from: d  reason: collision with root package name */
    public BufferedSource f70932d;

    /* renamed from: e  reason: collision with root package name */
    public HttpUrl f70933e;

    public class a extends ForwardingSource {

        /* renamed from: b  reason: collision with root package name */
        public long f70934b = 0;

        public a(Source source) {
            super(source);
        }

        public long read(Buffer buffer, long j11) throws IOException {
            long read = super.read(buffer, j11);
            int i11 = (read > -1 ? 1 : (read == -1 ? 0 : -1));
            this.f70934b += i11 != 0 ? read : 0;
            if (b.this.f70931c != null) {
                b.this.f70931c.a(b.this.f70933e, this.f70934b, b.this.f70930b.contentLength(), i11 == 0);
            }
            return read;
        }
    }

    public b(HttpUrl httpUrl, ResponseBody responseBody, a aVar) {
        this.f70930b = responseBody;
        this.f70931c = aVar;
        this.f70933e = httpUrl;
    }

    public long contentLength() {
        return this.f70930b.contentLength();
    }

    public MediaType contentType() {
        return this.f70930b.contentType();
    }

    public final Source f(Source source) {
        return new a(source);
    }

    public BufferedSource source() {
        if (this.f70932d == null) {
            this.f70932d = Okio.buffer(f(this.f70930b.source()));
        }
        return this.f70932d;
    }
}
