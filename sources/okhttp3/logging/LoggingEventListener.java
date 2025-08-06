package okhttp3.logging;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.r;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public final class LoggingEventListener extends EventListener {
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger2) {
        this.logger = logger2;
    }

    public /* synthetic */ LoggingEventListener(HttpLoggingInterceptor.Logger logger2, r rVar) {
        this(logger2);
    }

    private final void logWithTime(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        HttpLoggingInterceptor.Logger logger2 = this.logger;
        logger2.log('[' + millis + " ms] " + str);
    }

    public void cacheConditionalHit(Call call, Response response) {
        logWithTime("cacheConditionalHit: " + response);
    }

    public void cacheHit(Call call, Response response) {
        logWithTime("cacheHit: " + response);
    }

    public void cacheMiss(Call call) {
        logWithTime("cacheMiss");
    }

    public void callEnd(Call call) {
        logWithTime("callEnd");
    }

    public void callFailed(Call call, IOException iOException) {
        logWithTime("callFailed: " + iOException);
    }

    public void callStart(Call call) {
        this.startNs = System.nanoTime();
        logWithTime("callStart: " + call.request());
    }

    public void canceled(Call call) {
        logWithTime("canceled");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        logWithTime("connectEnd: " + protocol);
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        logWithTime("connectFailed: " + protocol + ' ' + iOException);
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        logWithTime("connectStart: " + inetSocketAddress + ' ' + proxy);
    }

    public void connectionAcquired(Call call, Connection connection) {
        logWithTime("connectionAcquired: " + connection);
    }

    public void connectionReleased(Call call, Connection connection) {
        logWithTime("connectionReleased");
    }

    public void dnsEnd(Call call, String str, List<? extends InetAddress> list) {
        logWithTime("dnsEnd: " + list);
    }

    public void dnsStart(Call call, String str) {
        logWithTime("dnsStart: " + str);
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<? extends Proxy> list) {
        logWithTime("proxySelectEnd: " + list);
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
        logWithTime("proxySelectStart: " + httpUrl);
    }

    public void requestBodyEnd(Call call, long j11) {
        logWithTime("requestBodyEnd: byteCount=" + j11);
    }

    public void requestBodyStart(Call call) {
        logWithTime("requestBodyStart");
    }

    public void requestFailed(Call call, IOException iOException) {
        logWithTime("requestFailed: " + iOException);
    }

    public void requestHeadersEnd(Call call, Request request) {
        logWithTime("requestHeadersEnd");
    }

    public void requestHeadersStart(Call call) {
        logWithTime("requestHeadersStart");
    }

    public void responseBodyEnd(Call call, long j11) {
        logWithTime("responseBodyEnd: byteCount=" + j11);
    }

    public void responseBodyStart(Call call) {
        logWithTime("responseBodyStart");
    }

    public void responseFailed(Call call, IOException iOException) {
        logWithTime("responseFailed: " + iOException);
    }

    public void responseHeadersEnd(Call call, Response response) {
        logWithTime("responseHeadersEnd: " + response);
    }

    public void responseHeadersStart(Call call) {
        logWithTime("responseHeadersStart");
    }

    public void satisfactionFailure(Call call, Response response) {
        logWithTime("satisfactionFailure: " + response);
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        logWithTime("secureConnectEnd: " + handshake);
    }

    public void secureConnectStart(Call call) {
        logWithTime("secureConnectStart");
    }

    public static class Factory implements EventListener.Factory {
        private final HttpLoggingInterceptor.Logger logger;

        public Factory() {
            this((HttpLoggingInterceptor.Logger) null, 1, (r) null);
        }

        public Factory(HttpLoggingInterceptor.Logger logger2) {
            this.logger = logger2;
        }

        public EventListener create(Call call) {
            return new LoggingEventListener(this.logger, (r) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Factory(HttpLoggingInterceptor.Logger logger2, int i11, r rVar) {
            this((i11 & 1) != 0 ? HttpLoggingInterceptor.Logger.DEFAULT : logger2);
        }
    }
}
