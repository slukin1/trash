package okhttp3.internal.connection;

import com.huobi.points.entity.PointsPack;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketException;
import kotlin.jvm.internal.x;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.ws.RealWebSocket;
import okio.Buffer;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Exchange {
    private final RealCall call;
    private final ExchangeCodec codec;
    private final RealConnection connection;
    private final EventListener eventListener;
    private final ExchangeFinder finder;
    private boolean hasFailure;
    private boolean isDuplex;

    public final class RequestBodySink extends ForwardingSink {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;

        public RequestBodySink(Sink sink, long j11) {
            super(sink);
            this.contentLength = j11;
        }

        private final <E extends IOException> E complete(E e11) {
            if (this.completed) {
                return e11;
            }
            this.completed = true;
            return Exchange.this.bodyComplete(this.bytesReceived, false, true, e11);
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                long j11 = this.contentLength;
                if (j11 == -1 || this.bytesReceived == j11) {
                    try {
                        super.close();
                        complete((IOException) null);
                    } catch (IOException e11) {
                        throw complete(e11);
                    }
                } else {
                    throw new ProtocolException("unexpected end of stream");
                }
            }
        }

        public void flush() throws IOException {
            try {
                super.flush();
            } catch (IOException e11) {
                throw complete(e11);
            }
        }

        public void write(Buffer buffer, long j11) throws IOException {
            if (!this.closed) {
                long j12 = this.contentLength;
                if (j12 == -1 || this.bytesReceived + j11 <= j12) {
                    try {
                        super.write(buffer, j11);
                        this.bytesReceived += j11;
                    } catch (IOException e11) {
                        throw complete(e11);
                    }
                } else {
                    throw new ProtocolException("expected " + this.contentLength + " bytes but received " + (this.bytesReceived + j11));
                }
            } else {
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            }
        }
    }

    public final class ResponseBodySource extends ForwardingSource {
        private long bytesReceived;
        private boolean closed;
        private boolean completed;
        private final long contentLength;
        private boolean invokeStartEvent = true;

        public ResponseBodySource(Source source, long j11) {
            super(source);
            this.contentLength = j11;
            if (j11 == 0) {
                complete((IOException) null);
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                try {
                    super.close();
                    complete((IOException) null);
                } catch (IOException e11) {
                    throw complete(e11);
                }
            }
        }

        public final <E extends IOException> E complete(E e11) {
            if (this.completed) {
                return e11;
            }
            this.completed = true;
            if (e11 == null && this.invokeStartEvent) {
                this.invokeStartEvent = false;
                Exchange.this.getEventListener$okhttp().responseBodyStart(Exchange.this.getCall$okhttp());
            }
            return Exchange.this.bodyComplete(this.bytesReceived, true, false, e11);
        }

        public long read(Buffer buffer, long j11) throws IOException {
            if (!this.closed) {
                try {
                    long read = delegate().read(buffer, j11);
                    if (this.invokeStartEvent) {
                        this.invokeStartEvent = false;
                        Exchange.this.getEventListener$okhttp().responseBodyStart(Exchange.this.getCall$okhttp());
                    }
                    if (read == -1) {
                        complete((IOException) null);
                        return -1;
                    }
                    long j12 = this.bytesReceived + read;
                    long j13 = this.contentLength;
                    if (j13 != -1) {
                        if (j12 > j13) {
                            throw new ProtocolException("expected " + this.contentLength + " bytes but received " + j12);
                        }
                    }
                    this.bytesReceived = j12;
                    if (j12 == j13) {
                        complete((IOException) null);
                    }
                    return read;
                } catch (IOException e11) {
                    throw complete(e11);
                }
            } else {
                throw new IllegalStateException(PointsPack.STATE_CLOSED.toString());
            }
        }
    }

    public Exchange(RealCall realCall, EventListener eventListener2, ExchangeFinder exchangeFinder, ExchangeCodec exchangeCodec) {
        this.call = realCall;
        this.eventListener = eventListener2;
        this.finder = exchangeFinder;
        this.codec = exchangeCodec;
        this.connection = exchangeCodec.getConnection();
    }

    private final void trackFailure(IOException iOException) {
        this.hasFailure = true;
        this.finder.trackFailure(iOException);
        this.codec.getConnection().trackFailure$okhttp(this.call, iOException);
    }

    public final <E extends IOException> E bodyComplete(long j11, boolean z11, boolean z12, E e11) {
        if (e11 != null) {
            trackFailure(e11);
        }
        if (z12) {
            if (e11 != null) {
                this.eventListener.requestFailed(this.call, e11);
            } else {
                this.eventListener.requestBodyEnd(this.call, j11);
            }
        }
        if (z11) {
            if (e11 != null) {
                this.eventListener.responseFailed(this.call, e11);
            } else {
                this.eventListener.responseBodyEnd(this.call, j11);
            }
        }
        return this.call.messageDone$okhttp(this, z12, z11, e11);
    }

    public final void cancel() {
        this.codec.cancel();
    }

    public final Sink createRequestBody(Request request, boolean z11) throws IOException {
        this.isDuplex = z11;
        long contentLength = request.body().contentLength();
        this.eventListener.requestBodyStart(this.call);
        return new RequestBodySink(this.codec.createRequestBody(request, contentLength), contentLength);
    }

    public final void detachWithViolence() {
        this.codec.cancel();
        this.call.messageDone$okhttp(this, true, true, null);
    }

    public final void finishRequest() throws IOException {
        try {
            this.codec.finishRequest();
        } catch (IOException e11) {
            this.eventListener.requestFailed(this.call, e11);
            trackFailure(e11);
            throw e11;
        }
    }

    public final void flushRequest() throws IOException {
        try {
            this.codec.flushRequest();
        } catch (IOException e11) {
            this.eventListener.requestFailed(this.call, e11);
            trackFailure(e11);
            throw e11;
        }
    }

    public final RealCall getCall$okhttp() {
        return this.call;
    }

    public final RealConnection getConnection$okhttp() {
        return this.connection;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final ExchangeFinder getFinder$okhttp() {
        return this.finder;
    }

    public final boolean getHasFailure$okhttp() {
        return this.hasFailure;
    }

    public final boolean isCoalescedConnection$okhttp() {
        return !x.b(this.finder.getAddress$okhttp().url().host(), this.connection.route().address().url().host());
    }

    public final boolean isDuplex$okhttp() {
        return this.isDuplex;
    }

    public final RealWebSocket.Streams newWebSocketStreams() throws SocketException {
        this.call.timeoutEarlyExit();
        return this.codec.getConnection().newWebSocketStreams$okhttp(this);
    }

    public final void noNewExchangesOnConnection() {
        this.codec.getConnection().noNewExchanges$okhttp();
    }

    public final void noRequestBody() {
        this.call.messageDone$okhttp(this, true, false, null);
    }

    public final ResponseBody openResponseBody(Response response) throws IOException {
        try {
            String header$default = Response.header$default(response, "Content-Type", (String) null, 2, (Object) null);
            long reportedContentLength = this.codec.reportedContentLength(response);
            return new RealResponseBody(header$default, reportedContentLength, Okio.buffer((Source) new ResponseBodySource(this.codec.openResponseBodySource(response), reportedContentLength)));
        } catch (IOException e11) {
            this.eventListener.responseFailed(this.call, e11);
            trackFailure(e11);
            throw e11;
        }
    }

    public final Response.Builder readResponseHeaders(boolean z11) throws IOException {
        try {
            Response.Builder readResponseHeaders = this.codec.readResponseHeaders(z11);
            if (readResponseHeaders != null) {
                readResponseHeaders.initExchange$okhttp(this);
            }
            return readResponseHeaders;
        } catch (IOException e11) {
            this.eventListener.responseFailed(this.call, e11);
            trackFailure(e11);
            throw e11;
        }
    }

    public final void responseHeadersEnd(Response response) {
        this.eventListener.responseHeadersEnd(this.call, response);
    }

    public final void responseHeadersStart() {
        this.eventListener.responseHeadersStart(this.call);
    }

    public final Headers trailers() throws IOException {
        return this.codec.trailers();
    }

    public final void webSocketUpgradeFailed() {
        bodyComplete(-1, true, true, (IOException) null);
    }

    public final void writeRequestHeaders(Request request) throws IOException {
        try {
            this.eventListener.requestHeadersStart(this.call);
            this.codec.writeRequestHeaders(request);
            this.eventListener.requestHeadersEnd(this.call, request);
        } catch (IOException e11) {
            this.eventListener.requestFailed(this.call, e11);
            trackFailure(e11);
            throw e11;
        }
    }
}
