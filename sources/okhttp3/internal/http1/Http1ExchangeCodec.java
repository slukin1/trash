package okhttp3.internal.http1;

import com.huobi.points.entity.PointsPack;
import com.jumio.commons.log.LogUtils;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.r;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class Http1ExchangeCodec implements ExchangeCodec {
    public static final Companion Companion = new Companion((r) null);
    private static final long NO_CHUNK_YET = -1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    /* access modifiers changed from: private */
    public final OkHttpClient client;
    private final RealConnection connection;
    /* access modifiers changed from: private */
    public final HeadersReader headersReader;
    /* access modifiers changed from: private */
    public final BufferedSink sink;
    /* access modifiers changed from: private */
    public final BufferedSource source;
    /* access modifiers changed from: private */
    public int state;
    /* access modifiers changed from: private */
    public Headers trailers;

    public abstract class AbstractSource implements Source {
        private boolean closed;
        private final ForwardingTimeout timeout;

        public AbstractSource() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.source.timeout());
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final ForwardingTimeout getTimeout() {
            return this.timeout;
        }

        public long read(Buffer buffer, long j11) {
            try {
                return Http1ExchangeCodec.this.source.read(buffer, j11);
            } catch (IOException e11) {
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                responseBodyComplete();
                throw e11;
            }
        }

        public final void responseBodyComplete() {
            if (Http1ExchangeCodec.this.state != 6) {
                if (Http1ExchangeCodec.this.state == 5) {
                    Http1ExchangeCodec.this.detachTimeout(this.timeout);
                    Http1ExchangeCodec.this.state = 6;
                    return;
                }
                throw new IllegalStateException("state: " + Http1ExchangeCodec.this.state);
            }
        }

        public final void setClosed(boolean z11) {
            this.closed = z11;
        }

        public Timeout timeout() {
            return this.timeout;
        }
    }

    public final class ChunkedSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout;

        public ChunkedSink() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.sink.timeout());
        }

        public synchronized void close() {
            if (!this.closed) {
                this.closed = true;
                Http1ExchangeCodec.this.sink.writeUtf8("0\r\n\r\n");
                Http1ExchangeCodec.this.detachTimeout(this.timeout);
                Http1ExchangeCodec.this.state = 3;
            }
        }

        public synchronized void flush() {
            if (!this.closed) {
                Http1ExchangeCodec.this.sink.flush();
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j11) {
            if (!(!this.closed)) {
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            } else if (j11 != 0) {
                Http1ExchangeCodec.this.sink.writeHexadecimalUnsignedLong(j11);
                Http1ExchangeCodec.this.sink.writeUtf8(LogUtils.NEW_LINE);
                Http1ExchangeCodec.this.sink.write(buffer, j11);
                Http1ExchangeCodec.this.sink.writeUtf8(LogUtils.NEW_LINE);
            }
        }
    }

    public final class ChunkedSource extends AbstractSource {
        private long bytesRemainingInChunk = -1;
        private boolean hasMoreChunks = true;
        private final HttpUrl url;

        public ChunkedSource(HttpUrl httpUrl) {
            super();
            this.url = httpUrl;
        }

        private final void readChunkSize() {
            if (this.bytesRemainingInChunk != -1) {
                Http1ExchangeCodec.this.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = Http1ExchangeCodec.this.source.readHexadecimalUnsignedLong();
                String obj = StringsKt__StringsKt.i1(Http1ExchangeCodec.this.source.readUtf8LineStrict()).toString();
                if (this.bytesRemainingInChunk >= 0) {
                    if (!(obj.length() > 0) || StringsKt__StringsJVMKt.M(obj, ";", false, 2, (Object) null)) {
                        if (this.bytesRemainingInChunk == 0) {
                            this.hasMoreChunks = false;
                            Http1ExchangeCodec http1ExchangeCodec = Http1ExchangeCodec.this;
                            http1ExchangeCodec.trailers = http1ExchangeCodec.headersReader.readHeaders();
                            HttpHeaders.receiveHeaders(Http1ExchangeCodec.this.client.cookieJar(), this.url, Http1ExchangeCodec.this.trailers);
                            responseBodyComplete();
                            return;
                        }
                        return;
                    }
                }
                throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + obj + '\"');
            } catch (NumberFormatException e11) {
                throw new ProtocolException(e11.getMessage());
            }
        }

        public void close() {
            if (!getClosed()) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                    responseBodyComplete();
                }
                setClosed(true);
            }
        }

        public long read(Buffer buffer, long j11) {
            if (!(j11 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
            } else if (!(!getClosed())) {
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            } else if (!this.hasMoreChunks) {
                return -1;
            } else {
                long j12 = this.bytesRemainingInChunk;
                if (j12 == 0 || j12 == -1) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return -1;
                    }
                }
                long read = super.read(buffer, Math.min(j11, this.bytesRemainingInChunk));
                if (read != -1) {
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete();
                throw protocolException;
            }
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public final class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j11) {
            super();
            this.bytesRemaining = j11;
            if (j11 == 0) {
                responseBodyComplete();
            }
        }

        public void close() {
            if (!getClosed()) {
                if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                    responseBodyComplete();
                }
                setClosed(true);
            }
        }

        public long read(Buffer buffer, long j11) {
            if (!(j11 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
            } else if (!getClosed()) {
                long j12 = this.bytesRemaining;
                if (j12 == 0) {
                    return -1;
                }
                long read = super.read(buffer, Math.min(j12, j11));
                if (read != -1) {
                    long j13 = this.bytesRemaining - read;
                    this.bytesRemaining = j13;
                    if (j13 == 0) {
                        responseBodyComplete();
                    }
                    return read;
                }
                Http1ExchangeCodec.this.getConnection().noNewExchanges$okhttp();
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                responseBodyComplete();
                throw protocolException;
            } else {
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            }
        }
    }

    public final class KnownLengthSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout;

        public KnownLengthSink() {
            this.timeout = new ForwardingTimeout(Http1ExchangeCodec.this.sink.timeout());
        }

        public void close() {
            if (!this.closed) {
                this.closed = true;
                Http1ExchangeCodec.this.detachTimeout(this.timeout);
                Http1ExchangeCodec.this.state = 3;
            }
        }

        public void flush() {
            if (!this.closed) {
                Http1ExchangeCodec.this.sink.flush();
            }
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void write(Buffer buffer, long j11) {
            if (!this.closed) {
                Util.checkOffsetAndCount(buffer.size(), 0, j11);
                Http1ExchangeCodec.this.sink.write(buffer, j11);
                return;
            }
            throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
        }
    }

    public final class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        public UnknownLengthSource() {
            super();
        }

        public void close() {
            if (!getClosed()) {
                if (!this.inputExhausted) {
                    responseBodyComplete();
                }
                setClosed(true);
            }
        }

        public long read(Buffer buffer, long j11) {
            if (!(j11 >= 0)) {
                throw new IllegalArgumentException(("byteCount < 0: " + j11).toString());
            } else if (!(!getClosed())) {
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            } else if (this.inputExhausted) {
                return -1;
            } else {
                long read = super.read(buffer, j11);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                responseBodyComplete();
                return -1;
            }
        }
    }

    public Http1ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.client = okHttpClient;
        this.connection = realConnection;
        this.source = bufferedSource;
        this.sink = bufferedSink;
        this.headersReader = new HeadersReader(bufferedSource);
    }

    /* access modifiers changed from: private */
    public final void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout delegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        delegate.clearDeadline();
        delegate.clearTimeout();
    }

    private final boolean isChunked(Response response) {
        return StringsKt__StringsJVMKt.w("chunked", Response.header$default(response, com.google.common.net.HttpHeaders.TRANSFER_ENCODING, (String) null, 2, (Object) null), true);
    }

    private final Sink newChunkedSink() {
        boolean z11 = true;
        if (this.state != 1) {
            z11 = false;
        }
        if (z11) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Source newChunkedSource(HttpUrl httpUrl) {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(httpUrl);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Source newFixedLengthSource(long j11) {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j11);
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Sink newKnownLengthSink() {
        boolean z11 = true;
        if (this.state != 1) {
            z11 = false;
        }
        if (z11) {
            this.state = 2;
            return new KnownLengthSink();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    private final Source newUnknownLengthSource() {
        if (this.state == 4) {
            this.state = 5;
            getConnection().noNewExchanges$okhttp();
            return new UnknownLengthSource();
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    public void cancel() {
        getConnection().cancel();
    }

    public Sink createRequestBody(Request request, long j11) {
        if (request.body() != null && request.body().isDuplex()) {
            throw new ProtocolException("Duplex connections are not supported for HTTP/1");
        } else if (isChunked(request)) {
            return newChunkedSink();
        } else {
            if (j11 != -1) {
                return newKnownLengthSink();
            }
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        }
    }

    public void finishRequest() {
        this.sink.flush();
    }

    public void flushRequest() {
        this.sink.flush();
    }

    public RealConnection getConnection() {
        return this.connection;
    }

    public final boolean isClosed() {
        return this.state == 6;
    }

    public Source openResponseBodySource(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return newFixedLengthSource(0);
        }
        if (isChunked(response)) {
            return newChunkedSource(response.request().url());
        }
        long headersContentLength = Util.headersContentLength(response);
        if (headersContentLength != -1) {
            return newFixedLengthSource(headersContentLength);
        }
        return newUnknownLengthSource();
    }

    public Response.Builder readResponseHeaders(boolean z11) {
        int i11 = this.state;
        boolean z12 = false;
        if (i11 == 1 || i11 == 2 || i11 == 3) {
            try {
                StatusLine parse = StatusLine.Companion.parse(this.headersReader.readLine());
                Response.Builder headers = new Response.Builder().protocol(parse.protocol).code(parse.code).message(parse.message).headers(this.headersReader.readHeaders());
                if (z11 && parse.code == 100) {
                    return null;
                }
                int i12 = parse.code;
                if (i12 == 100) {
                    this.state = 3;
                    return headers;
                }
                if (102 <= i12 && i12 < 200) {
                    z12 = true;
                }
                if (z12) {
                    this.state = 3;
                    return headers;
                }
                this.state = 4;
                return headers;
            } catch (EOFException e11) {
                throw new IOException("unexpected end of stream on " + getConnection().route().address().url().redact(), e11);
            }
        } else {
            throw new IllegalStateException(("state: " + this.state).toString());
        }
    }

    public long reportedContentLength(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return 0;
        }
        if (isChunked(response)) {
            return -1;
        }
        return Util.headersContentLength(response);
    }

    public final void skipConnectBody(Response response) {
        long headersContentLength = Util.headersContentLength(response);
        if (headersContentLength != -1) {
            Source newFixedLengthSource = newFixedLengthSource(headersContentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
        }
    }

    public Headers trailers() {
        if (this.state == 6) {
            Headers headers = this.trailers;
            return headers == null ? Util.EMPTY_HEADERS : headers;
        }
        throw new IllegalStateException("too early; can't read the trailers yet".toString());
    }

    public final void writeRequest(Headers headers, String str) {
        if (this.state == 0) {
            this.sink.writeUtf8(str).writeUtf8(LogUtils.NEW_LINE);
            int size = headers.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.sink.writeUtf8(headers.name(i11)).writeUtf8(l.f34627b).writeUtf8(headers.value(i11)).writeUtf8(LogUtils.NEW_LINE);
            }
            this.sink.writeUtf8(LogUtils.NEW_LINE);
            this.state = 1;
            return;
        }
        throw new IllegalStateException(("state: " + this.state).toString());
    }

    public void writeRequestHeaders(Request request) {
        writeRequest(request.headers(), RequestLine.INSTANCE.get(request, getConnection().route().proxy().type()));
    }

    private final boolean isChunked(Request request) {
        return StringsKt__StringsJVMKt.w("chunked", request.header(com.google.common.net.HttpHeaders.TRANSFER_ENCODING), true);
    }
}
