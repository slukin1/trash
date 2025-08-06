package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.r;

public abstract class EventListener {
    public static final Companion Companion = new Companion((r) null);
    public static final EventListener NONE = new EventListener$Companion$NONE$1();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response response) {
    }

    public void cacheHit(Call call, Response response) {
    }

    public void cacheMiss(Call call) {
    }

    public void callEnd(Call call) {
    }

    public void callFailed(Call call, IOException iOException) {
    }

    public void callStart(Call call) {
    }

    public void canceled(Call call) {
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
    }

    public void connectionAcquired(Call call, Connection connection) {
    }

    public void connectionReleased(Call call, Connection connection) {
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
    }

    public void dnsStart(Call call, String str) {
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl, List<Proxy> list) {
    }

    public void proxySelectStart(Call call, HttpUrl httpUrl) {
    }

    public void requestBodyEnd(Call call, long j11) {
    }

    public void requestBodyStart(Call call) {
    }

    public void requestFailed(Call call, IOException iOException) {
    }

    public void requestHeadersEnd(Call call, Request request) {
    }

    public void requestHeadersStart(Call call) {
    }

    public void responseBodyEnd(Call call, long j11) {
    }

    public void responseBodyStart(Call call) {
    }

    public void responseFailed(Call call, IOException iOException) {
    }

    public void responseHeadersEnd(Call call, Response response) {
    }

    public void responseHeadersStart(Call call) {
    }

    public void satisfactionFailure(Call call, Response response) {
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
    }

    public void secureConnectStart(Call call) {
    }
}
