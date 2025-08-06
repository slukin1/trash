package t8;

import com.hbg.lib.network.otc.core.FileUploadSubscriber;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public class c<T> extends RequestBody {

    /* renamed from: a  reason: collision with root package name */
    public RequestBody f70936a;

    /* renamed from: b  reason: collision with root package name */
    public FileUploadSubscriber<Object> f70937b;

    /* renamed from: c  reason: collision with root package name */
    public long f70938c = 0;

    public class a extends ForwardingSink {
        public a(Sink sink) {
            super(sink);
        }

        public void write(Buffer buffer, long j11) throws IOException {
            super.write(buffer, j11);
            c.b(c.this, j11);
            if (c.this.f70937b != null) {
                c.this.f70937b.b(c.this.f70938c, c.this.contentLength());
            }
        }
    }

    public c(RequestBody requestBody, FileUploadSubscriber<Object> fileUploadSubscriber) {
        this.f70936a = requestBody;
        this.f70937b = fileUploadSubscriber;
    }

    public static /* synthetic */ long b(c cVar, long j11) {
        long j12 = cVar.f70938c + j11;
        cVar.f70938c = j12;
        return j12;
    }

    public long contentLength() throws IOException {
        return this.f70936a.contentLength();
    }

    public MediaType contentType() {
        return this.f70936a.contentType();
    }

    public final Sink d(Sink sink) {
        return new a(sink);
    }

    public void writeTo(BufferedSink bufferedSink) throws IOException {
        if (bufferedSink instanceof Buffer) {
            this.f70936a.writeTo(bufferedSink);
            return;
        }
        BufferedSink buffer = Okio.buffer(d(bufferedSink));
        this.f70936a.writeTo(buffer);
        buffer.flush();
    }
}
