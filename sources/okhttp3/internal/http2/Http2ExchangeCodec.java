package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okio.Sink;
import okio.Source;

public final class Http2ExchangeCodec implements ExchangeCodec {
    private static final String CONNECTION = "connection";
    public static final Companion Companion = new Companion((r) null);
    private static final String ENCODING = "encoding";
    private static final String HOST = "host";
    /* access modifiers changed from: private */
    public static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf(CONNECTION, "host", KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD_UTF8, Header.TARGET_PATH_UTF8, Header.TARGET_SCHEME_UTF8, Header.TARGET_AUTHORITY_UTF8);
    /* access modifiers changed from: private */
    public static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf(CONNECTION, "host", KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE);
    private static final String KEEP_ALIVE = "keep-alive";
    private static final String PROXY_CONNECTION = "proxy-connection";
    private static final String TE = "te";
    private static final String TRANSFER_ENCODING = "transfer-encoding";
    private static final String UPGRADE = "upgrade";
    private volatile boolean canceled;
    private final RealInterceptorChain chain;
    private final RealConnection connection;
    private final Http2Connection http2Connection;
    private final Protocol protocol;
    private volatile Http2Stream stream;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final List<Header> http2HeadersList(Request request) {
            Headers headers = request.headers();
            ArrayList arrayList = new ArrayList(headers.size() + 4);
            arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
            arrayList.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(request.url())));
            String header = request.header("Host");
            if (header != null) {
                arrayList.add(new Header(Header.TARGET_AUTHORITY, header));
            }
            arrayList.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
            int size = headers.size();
            for (int i11 = 0; i11 < size; i11++) {
                String lowerCase = headers.name(i11).toLowerCase(Locale.US);
                if (!Http2ExchangeCodec.HTTP_2_SKIPPED_REQUEST_HEADERS.contains(lowerCase) || (x.b(lowerCase, Http2ExchangeCodec.TE) && x.b(headers.value(i11), "trailers"))) {
                    arrayList.add(new Header(lowerCase, headers.value(i11)));
                }
            }
            return arrayList;
        }

        public final Response.Builder readHttp2HeadersList(Headers headers, Protocol protocol) {
            Headers.Builder builder = new Headers.Builder();
            int size = headers.size();
            StatusLine statusLine = null;
            for (int i11 = 0; i11 < size; i11++) {
                String name = headers.name(i11);
                String value = headers.value(i11);
                if (x.b(name, Header.RESPONSE_STATUS_UTF8)) {
                    StatusLine.Companion companion = StatusLine.Companion;
                    statusLine = companion.parse("HTTP/1.1 " + value);
                } else if (!Http2ExchangeCodec.HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                    builder.addLenient$okhttp(name, value);
                }
            }
            if (statusLine != null) {
                return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
            }
            throw new ProtocolException("Expected ':status' header not present");
        }
    }

    public Http2ExchangeCodec(OkHttpClient okHttpClient, RealConnection realConnection, RealInterceptorChain realInterceptorChain, Http2Connection http2Connection2) {
        this.connection = realConnection;
        this.chain = realInterceptorChain;
        this.http2Connection = http2Connection2;
        List<Protocol> protocols = okHttpClient.protocols();
        Protocol protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
        this.protocol = !protocols.contains(protocol2) ? Protocol.HTTP_2 : protocol2;
    }

    public void cancel() {
        this.canceled = true;
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }

    public Sink createRequestBody(Request request, long j11) {
        return this.stream.getSink();
    }

    public void finishRequest() {
        this.stream.getSink().close();
    }

    public void flushRequest() {
        this.http2Connection.flush();
    }

    public RealConnection getConnection() {
        return this.connection;
    }

    public Source openResponseBodySource(Response response) {
        return this.stream.getSource$okhttp();
    }

    public Response.Builder readResponseHeaders(boolean z11) {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            Response.Builder readHttp2HeadersList = Companion.readHttp2HeadersList(http2Stream.takeHeaders(), this.protocol);
            if (!z11 || readHttp2HeadersList.getCode$okhttp() != 100) {
                return readHttp2HeadersList;
            }
            return null;
        }
        throw new IOException("stream wasn't created");
    }

    public long reportedContentLength(Response response) {
        if (!HttpHeaders.promisesBody(response)) {
            return 0;
        }
        return Util.headersContentLength(response);
    }

    public Headers trailers() {
        return this.stream.trailers();
    }

    public void writeRequestHeaders(Request request) {
        if (this.stream == null) {
            this.stream = this.http2Connection.newStream(Companion.http2HeadersList(request), request.body() != null);
            if (!this.canceled) {
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                this.stream.readTimeout().timeout((long) this.chain.getReadTimeoutMillis$okhttp(), timeUnit);
                this.stream.writeTimeout().timeout((long) this.chain.getWriteTimeoutMillis$okhttp(), timeUnit);
                return;
            }
            this.stream.closeLater(ErrorCode.CANCEL);
            throw new IOException("Canceled");
        }
    }
}
