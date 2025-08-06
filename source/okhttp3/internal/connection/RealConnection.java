package okhttp3.internal.connection;

import com.google.common.net.HttpHeaders;
import com.huobi.woodpecker.aop.WoodPeckerHttpDNSFailRetryAspect;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerInitConfig;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.reflect.c;
import x10.a;

public final class RealConnection extends Http2Connection.Listener implements Connection {
    public static final Companion Companion = new Companion((r) null);
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    private int allocationLimit = 1;
    private final List<Reference<RealCall>> calls = new ArrayList();
    private final RealConnectionPool connectionPool;
    /* access modifiers changed from: private */
    public Handshake handshake;
    private Http2Connection http2Connection;
    private long idleAtNs = Long.MAX_VALUE;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    private Protocol protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    private int routeFailureCount;
    private BufferedSink sink;
    /* access modifiers changed from: private */
    public Socket socket;
    private BufferedSource source;
    private int successCount;

    public class AjcClosure1 extends AroundClosure {
        public AjcClosure1(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            RealConnection.connectSocket_aroundBody0((RealConnection) objArr2[0], a.b(objArr2[1]), a.b(objArr2[2]), (Call) objArr2[3], (EventListener) objArr2[4], (JoinPoint) objArr2[5]);
            return null;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final RealConnection newTestConnection(RealConnectionPool realConnectionPool, Route route, Socket socket, long j11) {
            RealConnection realConnection = new RealConnection(realConnectionPool, route);
            realConnection.socket = socket;
            realConnection.setIdleAtNs$okhttp(j11);
            return realConnection;
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                java.net.Proxy$Type[] r0 = java.net.Proxy.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                java.net.Proxy$Type r1 = java.net.Proxy.Type.DIRECT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                java.net.Proxy$Type r1 = java.net.Proxy.Type.HTTP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.WhenMappings.<clinit>():void");
        }
    }

    static {
        ajc$preClinit();
    }

    public RealConnection(RealConnectionPool realConnectionPool, Route route2) {
        this.connectionPool = realConnectionPool;
        this.route = route2;
    }

    private static /* synthetic */ void ajc$preClinit() {
        c cVar = new c("RealConnection.kt", RealConnection.class);
        ajc$tjp_0 = cVar.h("method-execution", cVar.g("12", "connectSocket", "okhttp3.internal.connection.RealConnection", "int:int:okhttp3.Call:okhttp3.EventListener", "connectTimeout:readTimeout:call:eventListener", "java.io.IOException", "void"), 283);
    }

    private final boolean certificateSupportHost(HttpUrl httpUrl, Handshake handshake2) {
        List<Certificate> peerCertificates = handshake2.peerCertificates();
        if (!(!peerCertificates.isEmpty()) || !OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate) peerCertificates.get(0))) {
            return false;
        }
        return true;
    }

    private final void connectSocket(int i11, int i12, Call call, EventListener eventListener) throws IOException {
        JoinPoint e11 = c.e(ajc$tjp_0, this, this, new Object[]{a.a(i11), a.a(i12), call, eventListener});
        WoodPeckerHttpDNSFailRetryAspect.d().h(new AjcClosure1(new Object[]{this, a.a(i11), a.a(i12), call, eventListener, e11}).linkClosureAndJoinPoint(69648));
    }

    public static final /* synthetic */ void connectSocket_aroundBody0(RealConnection realConnection, int i11, int i12, Call call, EventListener eventListener, JoinPoint joinPoint) {
        Socket socket2;
        Proxy proxy = realConnection.route.proxy();
        Address address = realConnection.route.address();
        Proxy.Type type = proxy.type();
        int i13 = type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i13 == 1 || i13 == 2) {
            socket2 = address.socketFactory().createSocket();
        } else {
            socket2 = new Socket(proxy);
        }
        realConnection.rawSocket = socket2;
        eventListener.connectStart(call, realConnection.route.socketAddress(), proxy);
        socket2.setSoTimeout(i12);
        try {
            Platform.Companion.get().connectSocket(socket2, realConnection.route.socketAddress(), i11);
            try {
                realConnection.source = Okio.buffer(Okio.source(socket2));
                realConnection.sink = Okio.buffer(Okio.sink(socket2));
            } catch (NullPointerException e11) {
                if (x.b(e11.getMessage(), NPE_THROW_WITH_NULL)) {
                    throw new IOException(e11);
                }
            }
        } catch (ConnectException e12) {
            ConnectException connectException = new ConnectException("Failed to connect to " + realConnection.route.socketAddress());
            connectException.initCause(e12);
            throw connectException;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0166  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void connectTls(okhttp3.internal.connection.ConnectionSpecSelector r11) throws java.io.IOException {
        /*
            r10 = this;
            okhttp3.Route r0 = r10.route
            okhttp3.Address r0 = r0.address()
            javax.net.ssl.SSLSocketFactory r1 = r0.sslSocketFactory()
            r2 = 0
            java.net.Socket r3 = r10.rawSocket     // Catch:{ all -> 0x0158 }
            okhttp3.HttpUrl r4 = r0.url()     // Catch:{ all -> 0x0158 }
            java.lang.String r4 = r4.host()     // Catch:{ all -> 0x0158 }
            okhttp3.HttpUrl r5 = r0.url()     // Catch:{ all -> 0x0158 }
            int r5 = r5.port()     // Catch:{ all -> 0x0158 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ all -> 0x0158 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ all -> 0x0158 }
            okhttp3.ConnectionSpec r11 = r11.configureSecureSocket(r1)     // Catch:{ all -> 0x0155 }
            boolean r3 = r11.supportsTlsExtensions()     // Catch:{ all -> 0x0155 }
            if (r3 == 0) goto L_0x0043
            okhttp3.internal.platform.Platform$Companion r3 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x0155 }
            okhttp3.internal.platform.Platform r3 = r3.get()     // Catch:{ all -> 0x0155 }
            okhttp3.HttpUrl r4 = r0.url()     // Catch:{ all -> 0x0155 }
            java.lang.String r4 = r4.host()     // Catch:{ all -> 0x0155 }
            java.util.List r5 = r0.protocols()     // Catch:{ all -> 0x0155 }
            r3.configureTlsExtensions(r1, r4, r5)     // Catch:{ all -> 0x0155 }
        L_0x0043:
            r1.startHandshake()     // Catch:{ all -> 0x0155 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ all -> 0x0155 }
            okhttp3.Handshake$Companion r4 = okhttp3.Handshake.Companion     // Catch:{ all -> 0x0155 }
            okhttp3.Handshake r4 = r4.get(r3)     // Catch:{ all -> 0x0155 }
            javax.net.ssl.HostnameVerifier r5 = r0.hostnameVerifier()     // Catch:{ all -> 0x0155 }
            okhttp3.HttpUrl r7 = r0.url()     // Catch:{ all -> 0x0155 }
            java.lang.String r7 = r7.host()     // Catch:{ all -> 0x0155 }
            boolean r3 = r5.verify(r7, r3)     // Catch:{ all -> 0x0155 }
            if (r3 != 0) goto L_0x00ec
            java.util.List r11 = r4.peerCertificates()     // Catch:{ all -> 0x0155 }
            boolean r3 = r11.isEmpty()     // Catch:{ all -> 0x0155 }
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x00c8
            r3 = 0
            java.lang.Object r11 = r11.get(r3)     // Catch:{ all -> 0x0155 }
            java.security.cert.X509Certificate r11 = (java.security.cert.X509Certificate) r11     // Catch:{ all -> 0x0155 }
            javax.net.ssl.SSLPeerUnverifiedException r3 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x0155 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0155 }
            r4.<init>()     // Catch:{ all -> 0x0155 }
            java.lang.String r5 = "\n              |Hostname "
            r4.append(r5)     // Catch:{ all -> 0x0155 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ all -> 0x0155 }
            java.lang.String r0 = r0.host()     // Catch:{ all -> 0x0155 }
            r4.append(r0)     // Catch:{ all -> 0x0155 }
            java.lang.String r0 = " not verified:\n              |    certificate: "
            r4.append(r0)     // Catch:{ all -> 0x0155 }
            okhttp3.CertificatePinner$Companion r0 = okhttp3.CertificatePinner.Companion     // Catch:{ all -> 0x0155 }
            java.lang.String r0 = r0.pin(r11)     // Catch:{ all -> 0x0155 }
            r4.append(r0)     // Catch:{ all -> 0x0155 }
            java.lang.String r0 = "\n              |    DN: "
            r4.append(r0)     // Catch:{ all -> 0x0155 }
            java.security.Principal r0 = r11.getSubjectDN()     // Catch:{ all -> 0x0155 }
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0155 }
            r4.append(r0)     // Catch:{ all -> 0x0155 }
            java.lang.String r0 = "\n              |    subjectAltNames: "
            r4.append(r0)     // Catch:{ all -> 0x0155 }
            okhttp3.internal.tls.OkHostnameVerifier r0 = okhttp3.internal.tls.OkHostnameVerifier.INSTANCE     // Catch:{ all -> 0x0155 }
            java.util.List r11 = r0.allSubjectAltNames(r11)     // Catch:{ all -> 0x0155 }
            r4.append(r11)     // Catch:{ all -> 0x0155 }
            java.lang.String r11 = "\n              "
            r4.append(r11)     // Catch:{ all -> 0x0155 }
            java.lang.String r11 = r4.toString()     // Catch:{ all -> 0x0155 }
            java.lang.String r11 = kotlin.text.StringsKt__IndentKt.h(r11, r2, r6, r2)     // Catch:{ all -> 0x0155 }
            r3.<init>(r11)     // Catch:{ all -> 0x0155 }
            throw r3     // Catch:{ all -> 0x0155 }
        L_0x00c8:
            javax.net.ssl.SSLPeerUnverifiedException r11 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ all -> 0x0155 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0155 }
            r2.<init>()     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = "Hostname "
            r2.append(r3)     // Catch:{ all -> 0x0155 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ all -> 0x0155 }
            java.lang.String r0 = r0.host()     // Catch:{ all -> 0x0155 }
            r2.append(r0)     // Catch:{ all -> 0x0155 }
            java.lang.String r0 = " not verified (no certificates)"
            r2.append(r0)     // Catch:{ all -> 0x0155 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0155 }
            r11.<init>(r0)     // Catch:{ all -> 0x0155 }
            throw r11     // Catch:{ all -> 0x0155 }
        L_0x00ec:
            okhttp3.CertificatePinner r3 = r0.certificatePinner()     // Catch:{ all -> 0x0155 }
            okhttp3.Handshake r5 = new okhttp3.Handshake     // Catch:{ all -> 0x0155 }
            okhttp3.TlsVersion r6 = r4.tlsVersion()     // Catch:{ all -> 0x0155 }
            okhttp3.CipherSuite r7 = r4.cipherSuite()     // Catch:{ all -> 0x0155 }
            java.util.List r8 = r4.localCertificates()     // Catch:{ all -> 0x0155 }
            okhttp3.internal.connection.RealConnection$connectTls$1 r9 = new okhttp3.internal.connection.RealConnection$connectTls$1     // Catch:{ all -> 0x0155 }
            r9.<init>(r3, r4, r0)     // Catch:{ all -> 0x0155 }
            r5.<init>(r6, r7, r8, r9)     // Catch:{ all -> 0x0155 }
            r10.handshake = r5     // Catch:{ all -> 0x0155 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ all -> 0x0155 }
            java.lang.String r0 = r0.host()     // Catch:{ all -> 0x0155 }
            okhttp3.internal.connection.RealConnection$connectTls$2 r4 = new okhttp3.internal.connection.RealConnection$connectTls$2     // Catch:{ all -> 0x0155 }
            r4.<init>(r10)     // Catch:{ all -> 0x0155 }
            r3.check$okhttp(r0, r4)     // Catch:{ all -> 0x0155 }
            boolean r11 = r11.supportsTlsExtensions()     // Catch:{ all -> 0x0155 }
            if (r11 == 0) goto L_0x0128
            okhttp3.internal.platform.Platform$Companion r11 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x0155 }
            okhttp3.internal.platform.Platform r11 = r11.get()     // Catch:{ all -> 0x0155 }
            java.lang.String r2 = r11.getSelectedProtocol(r1)     // Catch:{ all -> 0x0155 }
        L_0x0128:
            r10.socket = r1     // Catch:{ all -> 0x0155 }
            okio.Source r11 = okio.Okio.source((java.net.Socket) r1)     // Catch:{ all -> 0x0155 }
            okio.BufferedSource r11 = okio.Okio.buffer((okio.Source) r11)     // Catch:{ all -> 0x0155 }
            r10.source = r11     // Catch:{ all -> 0x0155 }
            okio.Sink r11 = okio.Okio.sink((java.net.Socket) r1)     // Catch:{ all -> 0x0155 }
            okio.BufferedSink r11 = okio.Okio.buffer((okio.Sink) r11)     // Catch:{ all -> 0x0155 }
            r10.sink = r11     // Catch:{ all -> 0x0155 }
            if (r2 == 0) goto L_0x0147
            okhttp3.Protocol$Companion r11 = okhttp3.Protocol.Companion     // Catch:{ all -> 0x0155 }
            okhttp3.Protocol r11 = r11.get(r2)     // Catch:{ all -> 0x0155 }
            goto L_0x0149
        L_0x0147:
            okhttp3.Protocol r11 = okhttp3.Protocol.HTTP_1_1     // Catch:{ all -> 0x0155 }
        L_0x0149:
            r10.protocol = r11     // Catch:{ all -> 0x0155 }
            okhttp3.internal.platform.Platform$Companion r11 = okhttp3.internal.platform.Platform.Companion
            okhttp3.internal.platform.Platform r11 = r11.get()
            r11.afterHandshake(r1)
            return
        L_0x0155:
            r11 = move-exception
            r2 = r1
            goto L_0x0159
        L_0x0158:
            r11 = move-exception
        L_0x0159:
            if (r2 == 0) goto L_0x0164
            okhttp3.internal.platform.Platform$Companion r0 = okhttp3.internal.platform.Platform.Companion
            okhttp3.internal.platform.Platform r0 = r0.get()
            r0.afterHandshake(r2)
        L_0x0164:
            if (r2 == 0) goto L_0x0169
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r2)
        L_0x0169:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connectTls(okhttp3.internal.connection.ConnectionSpecSelector):void");
    }

    private final void connectTunnel(int i11, int i12, int i13, Call call, EventListener eventListener) throws IOException {
        Request createTunnelRequest = createTunnelRequest();
        HttpUrl url = createTunnelRequest.url();
        int i14 = 0;
        while (i14 < 21) {
            connectSocket(i11, i12, call, eventListener);
            createTunnelRequest = createTunnel(i12, i13, createTunnelRequest, url);
            if (createTunnelRequest != null) {
                Socket socket2 = this.rawSocket;
                if (socket2 != null) {
                    Util.closeQuietly(socket2);
                }
                this.rawSocket = null;
                this.sink = null;
                this.source = null;
                eventListener.connectEnd(call, this.route.socketAddress(), this.route.proxy(), (Protocol) null);
                i14++;
            } else {
                return;
            }
        }
    }

    private final Request createTunnel(int i11, int i12, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + Util.toHostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            BufferedSource bufferedSource = this.source;
            BufferedSink bufferedSink = this.sink;
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec((OkHttpClient) null, this, bufferedSource, bufferedSink);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            bufferedSource.timeout().timeout((long) i11, timeUnit);
            bufferedSink.timeout().timeout((long) i12, timeUnit);
            http1ExchangeCodec.writeRequest(request.headers(), str);
            http1ExchangeCodec.finishRequest();
            Response build = http1ExchangeCodec.readResponseHeaders(false).request(request).build();
            http1ExchangeCodec.skipConnectBody(build);
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, build);
                    if (authenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if (StringsKt__StringsJVMKt.w("close", Response.header$default(build, HttpHeaders.CONNECTION, (String) null, 2, (Object) null), true)) {
                        return authenticate;
                    } else {
                        request = authenticate;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
                }
            } else if (bufferedSource.getBuffer().exhausted() && bufferedSink.getBuffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    private final Request createTunnelRequest() throws IOException {
        Request build = new Request.Builder().url(this.route.address().url()).method("CONNECT", (RequestBody) null).header("Host", Util.toHostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Util.userAgent).build();
        Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(TPNativePlayerInitConfig.BOOL_ENABLE_COLOR_MANAGEMENT).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header(HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive").build());
        return authenticate == null ? build : authenticate;
    }

    private final void establishProtocol(ConnectionSpecSelector connectionSpecSelector, int i11, Call call, EventListener eventListener) throws IOException {
        if (this.route.address().sslSocketFactory() == null) {
            List<Protocol> protocols = this.route.address().protocols();
            Protocol protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (protocols.contains(protocol2)) {
                this.socket = this.rawSocket;
                this.protocol = protocol2;
                startHttp2(i11);
                return;
            }
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
            return;
        }
        eventListener.secureConnectStart(call);
        connectTls(connectionSpecSelector);
        eventListener.secureConnectEnd(call, this.handshake);
        if (this.protocol == Protocol.HTTP_2) {
            startHttp2(i11);
        }
    }

    private final boolean routeMatchesAny(List<Route> list) {
        boolean z11;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Route route2 : list) {
                if (route2.proxy().type() == Proxy.Type.DIRECT && this.route.proxy().type() == Proxy.Type.DIRECT && x.b(this.route.socketAddress(), route2.socketAddress())) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    return true;
                }
            }
        }
        return false;
    }

    private final void startHttp2(int i11) throws IOException {
        Socket socket2 = this.socket;
        BufferedSource bufferedSource = this.source;
        BufferedSink bufferedSink = this.sink;
        socket2.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true, TaskRunner.INSTANCE).socket(socket2, this.route.address().url().host(), bufferedSource, bufferedSink).listener(this).pingIntervalMillis(i11).build();
        this.http2Connection = build;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        Http2Connection.start$default(build, false, (TaskRunner) null, 3, (Object) null);
    }

    private final boolean supportsUrl(HttpUrl httpUrl) {
        Handshake handshake2;
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            HttpUrl url = this.route.address().url();
            if (httpUrl.port() != url.port()) {
                return false;
            }
            if (x.b(httpUrl.host(), url.host())) {
                return true;
            }
            if (this.noCoalescedConnections || (handshake2 = this.handshake) == null || !certificateSupportHost(httpUrl, handshake2)) {
                return false;
            }
            return true;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final void cancel() {
        Socket socket2 = this.rawSocket;
        if (socket2 != null) {
            Util.closeQuietly(socket2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0098 A[Catch:{ IOException -> 0x00f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void connect(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            okhttp3.Protocol r0 = r7.protocol
            r10 = 1
            if (r0 != 0) goto L_0x000d
            r0 = r10
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0150
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address()
            java.util.List r0 = r0.connectionSpecs()
            okhttp3.internal.connection.ConnectionSpecSelector r11 = new okhttp3.internal.connection.ConnectionSpecSelector
            r11.<init>(r0)
            okhttp3.Route r1 = r7.route
            okhttp3.Address r1 = r1.address()
            javax.net.ssl.SSLSocketFactory r1 = r1.sslSocketFactory()
            if (r1 != 0) goto L_0x007c
            okhttp3.ConnectionSpec r1 = okhttp3.ConnectionSpec.CLEARTEXT
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x006f
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address()
            okhttp3.HttpUrl r0 = r0.url()
            java.lang.String r0 = r0.host()
            okhttp3.internal.platform.Platform$Companion r1 = okhttp3.internal.platform.Platform.Companion
            okhttp3.internal.platform.Platform r1 = r1.get()
            boolean r1 = r1.isCleartextTrafficPermitted(r0)
            if (r1 == 0) goto L_0x004e
            goto L_0x008e
        L_0x004e:
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CLEARTEXT communication to "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x006f:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x007c:
            okhttp3.Route r0 = r7.route
            okhttp3.Address r0 = r0.address()
            java.util.List r0 = r0.protocols()
            okhttp3.Protocol r1 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0143
        L_0x008e:
            r12 = 0
            r13 = r12
        L_0x0090:
            okhttp3.Route r0 = r7.route     // Catch:{ IOException -> 0x00f3 }
            boolean r0 = r0.requiresTunnel()     // Catch:{ IOException -> 0x00f3 }
            if (r0 == 0) goto L_0x00b1
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.connectTunnel(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00f3 }
            java.net.Socket r0 = r7.rawSocket     // Catch:{ IOException -> 0x00f3 }
            if (r0 != 0) goto L_0x00ac
            goto L_0x00ce
        L_0x00ac:
            r14 = r17
            r15 = r18
            goto L_0x00b8
        L_0x00b1:
            r14 = r17
            r15 = r18
            r7.connectSocket(r14, r15, r8, r9)     // Catch:{ IOException -> 0x00f1 }
        L_0x00b8:
            r6 = r20
            r7.establishProtocol(r11, r6, r8, r9)     // Catch:{ IOException -> 0x00ef }
            okhttp3.Route r0 = r7.route     // Catch:{ IOException -> 0x00ef }
            java.net.InetSocketAddress r0 = r0.socketAddress()     // Catch:{ IOException -> 0x00ef }
            okhttp3.Route r1 = r7.route     // Catch:{ IOException -> 0x00ef }
            java.net.Proxy r1 = r1.proxy()     // Catch:{ IOException -> 0x00ef }
            okhttp3.Protocol r2 = r7.protocol     // Catch:{ IOException -> 0x00ef }
            r9.connectEnd(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00ef }
        L_0x00ce:
            okhttp3.Route r0 = r7.route
            boolean r0 = r0.requiresTunnel()
            if (r0 == 0) goto L_0x00e8
            java.net.Socket r0 = r7.rawSocket
            if (r0 == 0) goto L_0x00db
            goto L_0x00e8
        L_0x00db:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.ProtocolException r1 = new java.net.ProtocolException
            java.lang.String r2 = "Too many tunnel connections attempted: 21"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x00e8:
            long r0 = java.lang.System.nanoTime()
            r7.idleAtNs = r0
            return
        L_0x00ef:
            r0 = move-exception
            goto L_0x00fa
        L_0x00f1:
            r0 = move-exception
            goto L_0x00f8
        L_0x00f3:
            r0 = move-exception
            r14 = r17
            r15 = r18
        L_0x00f8:
            r6 = r20
        L_0x00fa:
            java.net.Socket r1 = r7.socket
            if (r1 == 0) goto L_0x0101
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r1)
        L_0x0101:
            java.net.Socket r1 = r7.rawSocket
            if (r1 == 0) goto L_0x0108
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r1)
        L_0x0108:
            r7.socket = r12
            r7.rawSocket = r12
            r7.source = r12
            r7.sink = r12
            r7.handshake = r12
            r7.protocol = r12
            r7.http2Connection = r12
            r7.allocationLimit = r10
            okhttp3.Route r1 = r7.route
            java.net.InetSocketAddress r3 = r1.socketAddress()
            okhttp3.Route r1 = r7.route
            java.net.Proxy r4 = r1.proxy()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.connectFailed(r2, r3, r4, r5, r6)
            if (r13 != 0) goto L_0x0135
            okhttp3.internal.connection.RouteException r13 = new okhttp3.internal.connection.RouteException
            r13.<init>(r0)
            goto L_0x0138
        L_0x0135:
            r13.addConnectException(r0)
        L_0x0138:
            if (r21 == 0) goto L_0x0142
            boolean r0 = r11.connectionFailed(r0)
            if (r0 == 0) goto L_0x0142
            goto L_0x0090
        L_0x0142:
            throw r13
        L_0x0143:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0150:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    public final void connectFailed$okhttp(OkHttpClient okHttpClient, Route route2, IOException iOException) {
        if (route2.proxy().type() != Proxy.Type.DIRECT) {
            Address address = route2.address();
            address.proxySelector().connectFailed(address.url().uri(), route2.proxy().address(), iOException);
        }
        okHttpClient.getRouteDatabase().failed(route2);
    }

    public final List<Reference<RealCall>> getCalls() {
        return this.calls;
    }

    public final RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final long getIdleAtNs$okhttp() {
        return this.idleAtNs;
    }

    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public final synchronized void incrementSuccessCount$okhttp() {
        this.successCount++;
    }

    public final boolean isEligible$okhttp(Address address, List<Route> list) {
        if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
        } else if (this.calls.size() >= this.allocationLimit || this.noNewExchanges || !this.route.address().equalsNonHost$okhttp(address)) {
            return false;
        } else {
            if (x.b(address.url().host(), route().address().url().host())) {
                return true;
            }
            if (this.http2Connection == null || list == null || !routeMatchesAny(list) || address.hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
                return false;
            }
            try {
                address.certificatePinner().check(address.url().host(), (List<? extends Certificate>) handshake().peerCertificates());
                return true;
            } catch (SSLPeerUnverifiedException unused) {
                return false;
            }
        }
    }

    public final boolean isHealthy(boolean z11) {
        long j11;
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            long nanoTime = System.nanoTime();
            Socket socket2 = this.rawSocket;
            Socket socket3 = this.socket;
            BufferedSource bufferedSource = this.source;
            if (socket2.isClosed() || socket3.isClosed() || socket3.isInputShutdown() || socket3.isOutputShutdown()) {
                return false;
            }
            Http2Connection http2Connection2 = this.http2Connection;
            if (http2Connection2 != null) {
                return http2Connection2.isHealthy(nanoTime);
            }
            synchronized (this) {
                j11 = nanoTime - this.idleAtNs;
            }
            if (j11 < IDLE_CONNECTION_HEALTHY_NS || !z11) {
                return true;
            }
            return Util.isHealthy(socket3, bufferedSource);
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    public final boolean isMultiplexed$okhttp() {
        return this.http2Connection != null;
    }

    public final ExchangeCodec newCodec$okhttp(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) throws SocketException {
        Socket socket2 = this.socket;
        BufferedSource bufferedSource = this.source;
        BufferedSink bufferedSink = this.sink;
        Http2Connection http2Connection2 = this.http2Connection;
        if (http2Connection2 != null) {
            return new Http2ExchangeCodec(okHttpClient, this, realInterceptorChain, http2Connection2);
        }
        socket2.setSoTimeout(realInterceptorChain.readTimeoutMillis());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        bufferedSource.timeout().timeout((long) realInterceptorChain.getReadTimeoutMillis$okhttp(), timeUnit);
        bufferedSink.timeout().timeout((long) realInterceptorChain.getWriteTimeoutMillis$okhttp(), timeUnit);
        return new Http1ExchangeCodec(okHttpClient, this, bufferedSource, bufferedSink);
    }

    public final RealWebSocket.Streams newWebSocketStreams$okhttp(Exchange exchange) throws SocketException {
        Socket socket2 = this.socket;
        BufferedSource bufferedSource = this.source;
        BufferedSink bufferedSink = this.sink;
        socket2.setSoTimeout(0);
        noNewExchanges$okhttp();
        return new RealConnection$newWebSocketStreams$1(bufferedSource, bufferedSink, exchange);
    }

    public final synchronized void noCoalescedConnections$okhttp() {
        this.noCoalescedConnections = true;
    }

    public final synchronized void noNewExchanges$okhttp() {
        this.noNewExchanges = true;
    }

    public synchronized void onSettings(Http2Connection http2Connection2, Settings settings) {
        this.allocationLimit = settings.getMaxConcurrentStreams();
    }

    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM, (IOException) null);
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public Route route() {
        return this.route;
    }

    public final void setIdleAtNs$okhttp(long j11) {
        this.idleAtNs = j11;
    }

    public final void setNoNewExchanges(boolean z11) {
        this.noNewExchanges = z11;
    }

    public final void setRouteFailureCount$okhttp(int i11) {
        this.routeFailureCount = i11;
    }

    public Socket socket() {
        return this.socket;
    }

    public String toString() {
        Object obj;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Connection{");
        sb2.append(this.route.address().url().host());
        sb2.append(':');
        sb2.append(this.route.address().url().port());
        sb2.append(", proxy=");
        sb2.append(this.route.proxy());
        sb2.append(" hostAddress=");
        sb2.append(this.route.socketAddress());
        sb2.append(" cipherSuite=");
        Handshake handshake2 = this.handshake;
        if (handshake2 == null || (obj = handshake2.cipherSuite()) == null) {
            obj = "none";
        }
        sb2.append(obj);
        sb2.append(" protocol=");
        sb2.append(this.protocol);
        sb2.append('}');
        return sb2.toString();
    }

    public final synchronized void trackFailure$okhttp(RealCall realCall, IOException iOException) {
        if (iOException instanceof StreamResetException) {
            if (((StreamResetException) iOException).errorCode == ErrorCode.REFUSED_STREAM) {
                int i11 = this.refusedStreamCount + 1;
                this.refusedStreamCount = i11;
                if (i11 > 1) {
                    this.noNewExchanges = true;
                    this.routeFailureCount++;
                }
            } else if (((StreamResetException) iOException).errorCode != ErrorCode.CANCEL || !realCall.isCanceled()) {
                this.noNewExchanges = true;
                this.routeFailureCount++;
            }
        } else if (!isMultiplexed$okhttp() || (iOException instanceof ConnectionShutdownException)) {
            this.noNewExchanges = true;
            if (this.successCount == 0) {
                if (iOException != null) {
                    connectFailed$okhttp(realCall.getClient(), this.route, iOException);
                }
                this.routeFailureCount++;
            }
        }
    }
}
