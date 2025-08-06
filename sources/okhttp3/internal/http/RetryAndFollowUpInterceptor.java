package okhttp3.internal.http;

import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.text.Regex;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;

public final class RetryAndFollowUpInterceptor implements Interceptor {
    public static final Companion Companion = new Companion((r) null);
    private static final int MAX_FOLLOW_UPS = 20;
    private final OkHttpClient client;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        this.client = okHttpClient;
    }

    private final Request buildRedirectRequest(Response response, String str) {
        String header$default;
        HttpUrl resolve;
        RequestBody requestBody = null;
        if (!this.client.followRedirects() || (header$default = Response.header$default(response, HttpHeaders.LOCATION, (String) null, 2, (Object) null)) == null || (resolve = response.request().url().resolve(header$default)) == null) {
            return null;
        }
        if (!x.b(resolve.scheme(), response.request().url().scheme()) && !this.client.followSslRedirects()) {
            return null;
        }
        Request.Builder newBuilder = response.request().newBuilder();
        if (HttpMethod.permitsRequestBody(str)) {
            int code = response.code();
            HttpMethod httpMethod = HttpMethod.INSTANCE;
            boolean z11 = httpMethod.redirectsWithBody(str) || code == 308 || code == 307;
            if (!httpMethod.redirectsToGet(str) || code == 308 || code == 307) {
                if (z11) {
                    requestBody = response.request().body();
                }
                newBuilder.method(str, requestBody);
            } else {
                newBuilder.method("GET", (RequestBody) null);
            }
            if (!z11) {
                newBuilder.removeHeader(HttpHeaders.TRANSFER_ENCODING);
                newBuilder.removeHeader("Content-Length");
                newBuilder.removeHeader("Content-Type");
            }
        }
        if (!Util.canReuseConnectionFor(response.request().url(), resolve)) {
            newBuilder.removeHeader("Authorization");
        }
        return newBuilder.url(resolve).build();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r1 = r7.getConnection$okhttp();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final okhttp3.Request followUpRequest(okhttp3.Response r6, okhttp3.internal.connection.Exchange r7) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
            if (r7 == 0) goto L_0x000e
            okhttp3.internal.connection.RealConnection r1 = r7.getConnection$okhttp()
            if (r1 == 0) goto L_0x000e
            okhttp3.Route r1 = r1.route()
            goto L_0x000f
        L_0x000e:
            r1 = r0
        L_0x000f:
            int r2 = r6.code()
            okhttp3.Request r3 = r6.request()
            java.lang.String r3 = r3.method()
            r4 = 307(0x133, float:4.3E-43)
            if (r2 == r4) goto L_0x00dc
            r4 = 308(0x134, float:4.32E-43)
            if (r2 == r4) goto L_0x00dc
            r4 = 401(0x191, float:5.62E-43)
            if (r2 == r4) goto L_0x00d1
            r4 = 421(0x1a5, float:5.9E-43)
            if (r2 == r4) goto L_0x00aa
            r7 = 503(0x1f7, float:7.05E-43)
            if (r2 == r7) goto L_0x008e
            r7 = 407(0x197, float:5.7E-43)
            if (r2 == r7) goto L_0x006f
            r7 = 408(0x198, float:5.72E-43)
            if (r2 == r7) goto L_0x003b
            switch(r2) {
                case 300: goto L_0x00dc;
                case 301: goto L_0x00dc;
                case 302: goto L_0x00dc;
                case 303: goto L_0x00dc;
                default: goto L_0x003a;
            }
        L_0x003a:
            return r0
        L_0x003b:
            okhttp3.OkHttpClient r1 = r5.client
            boolean r1 = r1.retryOnConnectionFailure()
            if (r1 != 0) goto L_0x0044
            return r0
        L_0x0044:
            okhttp3.Request r1 = r6.request()
            okhttp3.RequestBody r1 = r1.body()
            if (r1 == 0) goto L_0x0055
            boolean r1 = r1.isOneShot()
            if (r1 == 0) goto L_0x0055
            return r0
        L_0x0055:
            okhttp3.Response r1 = r6.priorResponse()
            if (r1 == 0) goto L_0x0062
            int r1 = r1.code()
            if (r1 != r7) goto L_0x0062
            return r0
        L_0x0062:
            r7 = 0
            int r7 = r5.retryAfter(r6, r7)
            if (r7 <= 0) goto L_0x006a
            return r0
        L_0x006a:
            okhttp3.Request r6 = r6.request()
            return r6
        L_0x006f:
            java.net.Proxy r7 = r1.proxy()
            java.net.Proxy$Type r7 = r7.type()
            java.net.Proxy$Type r0 = java.net.Proxy.Type.HTTP
            if (r7 != r0) goto L_0x0086
            okhttp3.OkHttpClient r7 = r5.client
            okhttp3.Authenticator r7 = r7.proxyAuthenticator()
            okhttp3.Request r6 = r7.authenticate(r1, r6)
            return r6
        L_0x0086:
            java.net.ProtocolException r6 = new java.net.ProtocolException
            java.lang.String r7 = "Received HTTP_PROXY_AUTH (407) code while not using proxy"
            r6.<init>(r7)
            throw r6
        L_0x008e:
            okhttp3.Response r1 = r6.priorResponse()
            if (r1 == 0) goto L_0x009b
            int r1 = r1.code()
            if (r1 != r7) goto L_0x009b
            return r0
        L_0x009b:
            r7 = 2147483647(0x7fffffff, float:NaN)
            int r7 = r5.retryAfter(r6, r7)
            if (r7 != 0) goto L_0x00a9
            okhttp3.Request r6 = r6.request()
            return r6
        L_0x00a9:
            return r0
        L_0x00aa:
            okhttp3.Request r1 = r6.request()
            okhttp3.RequestBody r1 = r1.body()
            if (r1 == 0) goto L_0x00bb
            boolean r1 = r1.isOneShot()
            if (r1 == 0) goto L_0x00bb
            return r0
        L_0x00bb:
            if (r7 == 0) goto L_0x00d0
            boolean r1 = r7.isCoalescedConnection$okhttp()
            if (r1 != 0) goto L_0x00c4
            goto L_0x00d0
        L_0x00c4:
            okhttp3.internal.connection.RealConnection r7 = r7.getConnection$okhttp()
            r7.noCoalescedConnections$okhttp()
            okhttp3.Request r6 = r6.request()
            return r6
        L_0x00d0:
            return r0
        L_0x00d1:
            okhttp3.OkHttpClient r7 = r5.client
            okhttp3.Authenticator r7 = r7.authenticator()
            okhttp3.Request r6 = r7.authenticate(r1, r6)
            return r6
        L_0x00dc:
            okhttp3.Request r6 = r5.buildRedirectRequest(r6, r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.RetryAndFollowUpInterceptor.followUpRequest(okhttp3.Response, okhttp3.internal.connection.Exchange):okhttp3.Request");
    }

    private final boolean isRecoverable(IOException iOException, boolean z11) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z11) {
                return false;
            }
            return true;
        } else if ((!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException)) {
            return true;
        } else {
            return false;
        }
    }

    private final boolean recover(IOException iOException, RealCall realCall, Request request, boolean z11) {
        if (!this.client.retryOnConnectionFailure()) {
            return false;
        }
        if ((!z11 || !requestIsOneShot(iOException, request)) && isRecoverable(iOException, z11) && realCall.retryAfterFailure()) {
            return true;
        }
        return false;
    }

    private final boolean requestIsOneShot(IOException iOException, Request request) {
        RequestBody body = request.body();
        return (body != null && body.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final int retryAfter(Response response, int i11) {
        String header$default = Response.header$default(response, HttpHeaders.RETRY_AFTER, (String) null, 2, (Object) null);
        if (header$default == null) {
            return i11;
        }
        if (new Regex("\\d+").matches(header$default)) {
            return Integer.valueOf(header$default).intValue();
        }
        return Integer.MAX_VALUE;
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request$okhttp = realInterceptorChain.getRequest$okhttp();
        RealCall call$okhttp = realInterceptorChain.getCall$okhttp();
        List k11 = CollectionsKt__CollectionsKt.k();
        Response response = null;
        boolean z11 = true;
        int i11 = 0;
        while (true) {
            call$okhttp.enterNetworkInterceptorExchange(request$okhttp, z11);
            try {
                if (!call$okhttp.isCanceled()) {
                    Response proceed = realInterceptorChain.proceed(request$okhttp);
                    if (response != null) {
                        proceed = proceed.newBuilder().priorResponse(response.newBuilder().body((ResponseBody) null).build()).build();
                    }
                    response = proceed;
                    Exchange interceptorScopedExchange$okhttp = call$okhttp.getInterceptorScopedExchange$okhttp();
                    Request followUpRequest = followUpRequest(response, interceptorScopedExchange$okhttp);
                    if (followUpRequest == null) {
                        if (interceptorScopedExchange$okhttp != null && interceptorScopedExchange$okhttp.isDuplex$okhttp()) {
                            call$okhttp.timeoutEarlyExit();
                        }
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                    RequestBody body = followUpRequest.body();
                    if (body == null || !body.isOneShot()) {
                        ResponseBody body2 = response.body();
                        if (body2 != null) {
                            Util.closeQuietly((Closeable) body2);
                        }
                        i11++;
                        if (i11 <= 20) {
                            call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                            request$okhttp = followUpRequest;
                            z11 = true;
                        } else {
                            throw new ProtocolException("Too many follow-up requests: " + i11);
                        }
                    } else {
                        call$okhttp.exitNetworkInterceptorExchange$okhttp(false);
                        return response;
                    }
                } else {
                    throw new IOException("Canceled");
                }
            } catch (RouteException e11) {
                if (recover(e11.getLastConnectException(), call$okhttp, request$okhttp, false)) {
                    k11 = CollectionsKt___CollectionsKt.r0(k11, e11.getFirstConnectException());
                    call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                    z11 = false;
                } else {
                    throw Util.withSuppressed(e11.getFirstConnectException(), k11);
                }
            } catch (IOException e12) {
                if (recover(e12, call$okhttp, request$okhttp, !(e12 instanceof ConnectionShutdownException))) {
                    k11 = CollectionsKt___CollectionsKt.r0(k11, e12);
                    call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                    z11 = false;
                } else {
                    throw Util.withSuppressed(e12, k11);
                }
            } catch (Throwable th2) {
                call$okhttp.exitNetworkInterceptorExchange$okhttp(true);
                throw th2;
            }
        }
    }
}
