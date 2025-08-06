package okhttp3;

import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import okhttp3.Headers;
import okhttp3.internal.connection.Exchange;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;

public final class Response implements Closeable {
    private final ResponseBody body;
    private final Response cacheResponse;
    private final int code;
    private final Exchange exchange;
    private final Handshake handshake;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String message;
    private final Response networkResponse;
    private final Response priorResponse;
    private final Protocol protocol;
    private final long receivedResponseAtMillis;
    private final Request request;
    private final long sentRequestAtMillis;

    public Response(Request request2, Protocol protocol2, String str, int i11, Handshake handshake2, Headers headers2, ResponseBody responseBody, Response response, Response response2, Response response3, long j11, long j12, Exchange exchange2) {
        this.request = request2;
        this.protocol = protocol2;
        this.message = str;
        this.code = i11;
        this.handshake = handshake2;
        this.headers = headers2;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j11;
        this.receivedResponseAtMillis = j12;
        this.exchange = exchange2;
    }

    public static /* synthetic */ String header$default(Response response, String str, String str2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        return response.header(str, str2);
    }

    /* renamed from: -deprecated_body  reason: not valid java name */
    public final ResponseBody m3202deprecated_body() {
        return this.body;
    }

    /* renamed from: -deprecated_cacheControl  reason: not valid java name */
    public final CacheControl m3203deprecated_cacheControl() {
        return cacheControl();
    }

    /* renamed from: -deprecated_cacheResponse  reason: not valid java name */
    public final Response m3204deprecated_cacheResponse() {
        return this.cacheResponse;
    }

    /* renamed from: -deprecated_code  reason: not valid java name */
    public final int m3205deprecated_code() {
        return this.code;
    }

    /* renamed from: -deprecated_handshake  reason: not valid java name */
    public final Handshake m3206deprecated_handshake() {
        return this.handshake;
    }

    /* renamed from: -deprecated_headers  reason: not valid java name */
    public final Headers m3207deprecated_headers() {
        return this.headers;
    }

    /* renamed from: -deprecated_message  reason: not valid java name */
    public final String m3208deprecated_message() {
        return this.message;
    }

    /* renamed from: -deprecated_networkResponse  reason: not valid java name */
    public final Response m3209deprecated_networkResponse() {
        return this.networkResponse;
    }

    /* renamed from: -deprecated_priorResponse  reason: not valid java name */
    public final Response m3210deprecated_priorResponse() {
        return this.priorResponse;
    }

    /* renamed from: -deprecated_protocol  reason: not valid java name */
    public final Protocol m3211deprecated_protocol() {
        return this.protocol;
    }

    /* renamed from: -deprecated_receivedResponseAtMillis  reason: not valid java name */
    public final long m3212deprecated_receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    /* renamed from: -deprecated_request  reason: not valid java name */
    public final Request m3213deprecated_request() {
        return this.request;
    }

    /* renamed from: -deprecated_sentRequestAtMillis  reason: not valid java name */
    public final long m3214deprecated_sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public final ResponseBody body() {
        return this.body;
    }

    public final CacheControl cacheControl() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl parse = CacheControl.Companion.parse(this.headers);
        this.lazyCacheControl = parse;
        return parse;
    }

    public final Response cacheResponse() {
        return this.cacheResponse;
    }

    public final List<Challenge> challenges() {
        String str;
        Headers headers2 = this.headers;
        int i11 = this.code;
        if (i11 == 401) {
            str = HttpHeaders.WWW_AUTHENTICATE;
        } else if (i11 != 407) {
            return CollectionsKt__CollectionsKt.k();
        } else {
            str = HttpHeaders.PROXY_AUTHENTICATE;
        }
        return okhttp3.internal.http.HttpHeaders.parseChallenges(headers2, str);
    }

    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
    }

    public final int code() {
        return this.code;
    }

    public final Exchange exchange() {
        return this.exchange;
    }

    public final Handshake handshake() {
        return this.handshake;
    }

    public final String header(String str) {
        return header$default(this, str, (String) null, 2, (Object) null);
    }

    public final String header(String str, String str2) {
        String str3 = this.headers.get(str);
        return str3 == null ? str2 : str3;
    }

    public final Headers headers() {
        return this.headers;
    }

    public final boolean isRedirect() {
        int i11 = this.code;
        if (!(i11 == 307 || i11 == 308)) {
            switch (i11) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    public final boolean isSuccessful() {
        int i11 = this.code;
        return 200 <= i11 && i11 < 300;
    }

    public final String message() {
        return this.message;
    }

    public final Response networkResponse() {
        return this.networkResponse;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final ResponseBody peekBody(long j11) throws IOException {
        BufferedSource peek = this.body.source().peek();
        Buffer buffer = new Buffer();
        peek.request(j11);
        buffer.write((Source) peek, Math.min(j11, peek.getBuffer().size()));
        return ResponseBody.Companion.create((BufferedSource) buffer, this.body.contentType(), buffer.size());
    }

    public final Response priorResponse() {
        return this.priorResponse;
    }

    public final Protocol protocol() {
        return this.protocol;
    }

    public final long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public final Request request() {
        return this.request;
    }

    public final long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    public final Headers trailers() throws IOException {
        Exchange exchange2 = this.exchange;
        if (exchange2 != null) {
            return exchange2.trailers();
        }
        throw new IllegalStateException("trailers not available".toString());
    }

    public final List<String> headers(String str) {
        return this.headers.values(str);
    }

    public static class Builder {
        private ResponseBody body;
        private Response cacheResponse;
        private int code;
        private Exchange exchange;
        private Handshake handshake;
        private Headers.Builder headers;
        private String message;
        private Response networkResponse;
        private Response priorResponse;
        private Protocol protocol;
        private long receivedResponseAtMillis;
        private Request request;
        private long sentRequestAtMillis;

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }

        private final void checkPriorResponse(Response response) {
            if (response != null) {
                if (!(response.body() == null)) {
                    throw new IllegalArgumentException("priorResponse.body != null".toString());
                }
            }
        }

        private final void checkSupportResponse(String str, Response response) {
            if (response != null) {
                boolean z11 = true;
                if (response.body() == null) {
                    if (response.networkResponse() == null) {
                        if (response.cacheResponse() == null) {
                            if (response.priorResponse() != null) {
                                z11 = false;
                            }
                            if (!z11) {
                                throw new IllegalArgumentException((str + ".priorResponse != null").toString());
                            }
                            return;
                        }
                        throw new IllegalArgumentException((str + ".cacheResponse != null").toString());
                    }
                    throw new IllegalArgumentException((str + ".networkResponse != null").toString());
                }
                throw new IllegalArgumentException((str + ".body != null").toString());
            }
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Response build() {
            int i11 = this.code;
            if (i11 >= 0) {
                Request request2 = this.request;
                if (request2 != null) {
                    Protocol protocol2 = this.protocol;
                    if (protocol2 != null) {
                        String str = this.message;
                        if (str != null) {
                            return new Response(request2, protocol2, str, i11, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
                        }
                        throw new IllegalStateException("message == null".toString());
                    }
                    throw new IllegalStateException("protocol == null".toString());
                }
                throw new IllegalStateException("request == null".toString());
            }
            throw new IllegalStateException(("code < 0: " + this.code).toString());
        }

        public Builder cacheResponse(Response response) {
            checkSupportResponse("cacheResponse", response);
            this.cacheResponse = response;
            return this;
        }

        public Builder code(int i11) {
            this.code = i11;
            return this;
        }

        public final ResponseBody getBody$okhttp() {
            return this.body;
        }

        public final Response getCacheResponse$okhttp() {
            return this.cacheResponse;
        }

        public final int getCode$okhttp() {
            return this.code;
        }

        public final Exchange getExchange$okhttp() {
            return this.exchange;
        }

        public final Handshake getHandshake$okhttp() {
            return this.handshake;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final String getMessage$okhttp() {
            return this.message;
        }

        public final Response getNetworkResponse$okhttp() {
            return this.networkResponse;
        }

        public final Response getPriorResponse$okhttp() {
            return this.priorResponse;
        }

        public final Protocol getProtocol$okhttp() {
            return this.protocol;
        }

        public final long getReceivedResponseAtMillis$okhttp() {
            return this.receivedResponseAtMillis;
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }

        public final long getSentRequestAtMillis$okhttp() {
            return this.sentRequestAtMillis;
        }

        public Builder handshake(Handshake handshake2) {
            this.handshake = handshake2;
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers2) {
            this.headers = headers2.newBuilder();
            return this;
        }

        public final void initExchange$okhttp(Exchange exchange2) {
            this.exchange = exchange2;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder networkResponse(Response response) {
            checkSupportResponse("networkResponse", response);
            this.networkResponse = response;
            return this;
        }

        public Builder priorResponse(Response response) {
            checkPriorResponse(response);
            this.priorResponse = response;
            return this;
        }

        public Builder protocol(Protocol protocol2) {
            this.protocol = protocol2;
            return this;
        }

        public Builder receivedResponseAtMillis(long j11) {
            this.receivedResponseAtMillis = j11;
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder request(Request request2) {
            this.request = request2;
            return this;
        }

        public Builder sentRequestAtMillis(long j11) {
            this.sentRequestAtMillis = j11;
            return this;
        }

        public final void setBody$okhttp(ResponseBody responseBody) {
            this.body = responseBody;
        }

        public final void setCacheResponse$okhttp(Response response) {
            this.cacheResponse = response;
        }

        public final void setCode$okhttp(int i11) {
            this.code = i11;
        }

        public final void setExchange$okhttp(Exchange exchange2) {
            this.exchange = exchange2;
        }

        public final void setHandshake$okhttp(Handshake handshake2) {
            this.handshake = handshake2;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            this.headers = builder;
        }

        public final void setMessage$okhttp(String str) {
            this.message = str;
        }

        public final void setNetworkResponse$okhttp(Response response) {
            this.networkResponse = response;
        }

        public final void setPriorResponse$okhttp(Response response) {
            this.priorResponse = response;
        }

        public final void setProtocol$okhttp(Protocol protocol2) {
            this.protocol = protocol2;
        }

        public final void setReceivedResponseAtMillis$okhttp(long j11) {
            this.receivedResponseAtMillis = j11;
        }

        public final void setRequest$okhttp(Request request2) {
            this.request = request2;
        }

        public final void setSentRequestAtMillis$okhttp(long j11) {
            this.sentRequestAtMillis = j11;
        }

        public Builder(Response response) {
            this.code = -1;
            this.request = response.request();
            this.protocol = response.protocol();
            this.code = response.code();
            this.message = response.message();
            this.handshake = response.handshake();
            this.headers = response.headers().newBuilder();
            this.body = response.body();
            this.networkResponse = response.networkResponse();
            this.cacheResponse = response.cacheResponse();
            this.priorResponse = response.priorResponse();
            this.sentRequestAtMillis = response.sentRequestAtMillis();
            this.receivedResponseAtMillis = response.receivedResponseAtMillis();
            this.exchange = response.exchange();
        }
    }
}
