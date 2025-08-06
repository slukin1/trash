package okhttp3.internal.connection;

import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.internal.x;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;
import okio.AsyncTimeout;

public final class RealCall implements Call {
    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private RealConnection connection;
    private final RealConnectionPool connectionPool;
    private volatile RealConnection connectionToCancel;
    private final EventListener eventListener;
    private volatile Exchange exchange;
    private ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed = new AtomicBoolean();
    private boolean expectMoreExchanges = true;
    private final boolean forWebSocket;
    private Exchange interceptorScopedExchange;
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    /* access modifiers changed from: private */
    public final RealCall$timeout$1 timeout;
    private boolean timeoutEarlyExit;

    public final class AsyncCall implements Runnable {
        private volatile AtomicInteger callsPerHost = new AtomicInteger(0);
        private final Callback responseCallback;

        public AsyncCall(Callback callback) {
            this.responseCallback = callback;
        }

        public final void executeOn(ExecutorService executorService) {
            Dispatcher dispatcher = RealCall.this.getClient().dispatcher();
            if (!Util.assertionsEnabled || !Thread.holdsLock(dispatcher)) {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e11) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e11);
                    RealCall.this.noMoreExchanges$okhttp(interruptedIOException);
                    this.responseCallback.onFailure(RealCall.this, interruptedIOException);
                    RealCall.this.getClient().dispatcher().finished$okhttp(this);
                } catch (Throwable th2) {
                    RealCall.this.getClient().dispatcher().finished$okhttp(this);
                    throw th2;
                }
            } else {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
            }
        }

        public final RealCall getCall() {
            return RealCall.this;
        }

        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        public final String getHost() {
            return RealCall.this.getOriginalRequest().url().host();
        }

        public final Request getRequest() {
            return RealCall.this.getOriginalRequest();
        }

        public final void reuseCallsPerHostFrom(AsyncCall asyncCall) {
            this.callsPerHost = asyncCall.callsPerHost;
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x004f A[Catch:{ all -> 0x006e, all -> 0x00b4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0076 A[Catch:{ all -> 0x006e, all -> 0x00b4 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0096 A[Catch:{ all -> 0x006e, all -> 0x00b4 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "OkHttp "
                r0.append(r1)
                okhttp3.internal.connection.RealCall r1 = okhttp3.internal.connection.RealCall.this
                java.lang.String r1 = r1.redactedUrl$okhttp()
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                okhttp3.internal.connection.RealCall r1 = okhttp3.internal.connection.RealCall.this
                java.lang.Thread r2 = java.lang.Thread.currentThread()
                java.lang.String r3 = r2.getName()
                r2.setName(r0)
                r0 = 0
                okhttp3.internal.connection.RealCall$timeout$1 r4 = r1.timeout     // Catch:{ all -> 0x00b4 }
                r4.enter()     // Catch:{ all -> 0x00b4 }
                okhttp3.Response r0 = r1.getResponseWithInterceptorChain$okhttp()     // Catch:{ IOException -> 0x0070, all -> 0x0046 }
                r4 = 1
                okhttp3.Callback r5 = r8.responseCallback     // Catch:{ IOException -> 0x0044, all -> 0x0042 }
                r5.onResponse(r1, r0)     // Catch:{ IOException -> 0x0044, all -> 0x0042 }
                okhttp3.OkHttpClient r0 = r1.getClient()     // Catch:{ all -> 0x00b4 }
                okhttp3.Dispatcher r0 = r0.dispatcher()     // Catch:{ all -> 0x00b4 }
            L_0x003e:
                r0.finished$okhttp((okhttp3.internal.connection.RealCall.AsyncCall) r8)     // Catch:{ all -> 0x00b4 }
                goto L_0x00a4
            L_0x0042:
                r0 = move-exception
                goto L_0x004a
            L_0x0044:
                r0 = move-exception
                goto L_0x0074
            L_0x0046:
                r4 = move-exception
                r7 = r4
                r4 = r0
                r0 = r7
            L_0x004a:
                r1.cancel()     // Catch:{ all -> 0x006e }
                if (r4 != 0) goto L_0x006d
                java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x006e }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
                r5.<init>()     // Catch:{ all -> 0x006e }
                java.lang.String r6 = "canceled due to "
                r5.append(r6)     // Catch:{ all -> 0x006e }
                r5.append(r0)     // Catch:{ all -> 0x006e }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006e }
                r4.<init>(r5)     // Catch:{ all -> 0x006e }
                kotlin.ExceptionsKt__ExceptionsKt.a(r4, r0)     // Catch:{ all -> 0x006e }
                okhttp3.Callback r5 = r8.responseCallback     // Catch:{ all -> 0x006e }
                r5.onFailure(r1, r4)     // Catch:{ all -> 0x006e }
            L_0x006d:
                throw r0     // Catch:{ all -> 0x006e }
            L_0x006e:
                r0 = move-exception
                goto L_0x00a8
            L_0x0070:
                r4 = move-exception
                r7 = r4
                r4 = r0
                r0 = r7
            L_0x0074:
                if (r4 == 0) goto L_0x0096
                okhttp3.internal.platform.Platform$Companion r4 = okhttp3.internal.platform.Platform.Companion     // Catch:{ all -> 0x006e }
                okhttp3.internal.platform.Platform r4 = r4.get()     // Catch:{ all -> 0x006e }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
                r5.<init>()     // Catch:{ all -> 0x006e }
                java.lang.String r6 = "Callback failure for "
                r5.append(r6)     // Catch:{ all -> 0x006e }
                java.lang.String r6 = r1.toLoggableString()     // Catch:{ all -> 0x006e }
                r5.append(r6)     // Catch:{ all -> 0x006e }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x006e }
                r6 = 4
                r4.log(r5, r6, r0)     // Catch:{ all -> 0x006e }
                goto L_0x009b
            L_0x0096:
                okhttp3.Callback r4 = r8.responseCallback     // Catch:{ all -> 0x006e }
                r4.onFailure(r1, r0)     // Catch:{ all -> 0x006e }
            L_0x009b:
                okhttp3.OkHttpClient r0 = r1.getClient()     // Catch:{ all -> 0x00b4 }
                okhttp3.Dispatcher r0 = r0.dispatcher()     // Catch:{ all -> 0x00b4 }
                goto L_0x003e
            L_0x00a4:
                r2.setName(r3)
                return
            L_0x00a8:
                okhttp3.OkHttpClient r1 = r1.getClient()     // Catch:{ all -> 0x00b4 }
                okhttp3.Dispatcher r1 = r1.dispatcher()     // Catch:{ all -> 0x00b4 }
                r1.finished$okhttp((okhttp3.internal.connection.RealCall.AsyncCall) r8)     // Catch:{ all -> 0x00b4 }
                throw r0     // Catch:{ all -> 0x00b4 }
            L_0x00b4:
                r0 = move-exception
                r2.setName(r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.AsyncCall.run():void");
        }
    }

    public static final class CallReference extends WeakReference<RealCall> {
        private final Object callStackTrace;

        public CallReference(RealCall realCall, Object obj) {
            super(realCall);
            this.callStackTrace = obj;
        }

        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z11) {
        this.client = okHttpClient;
        this.originalRequest = request;
        this.forWebSocket = z11;
        this.connectionPool = okHttpClient.connectionPool().getDelegate$okhttp();
        this.eventListener = okHttpClient.eventListenerFactory().create(this);
        RealCall$timeout$1 realCall$timeout$1 = new RealCall$timeout$1(this);
        realCall$timeout$1.timeout((long) okHttpClient.callTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.timeout = realCall$timeout$1;
    }

    private final <E extends IOException> E callDone(E e11) {
        Socket releaseConnectionNoEvents$okhttp;
        boolean z11 = Util.assertionsEnabled;
        if (!z11 || !Thread.holdsLock(this)) {
            RealConnection realConnection = this.connection;
            if (realConnection != null) {
                if (!z11 || !Thread.holdsLock(realConnection)) {
                    synchronized (realConnection) {
                        releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
                    }
                    if (this.connection == null) {
                        if (releaseConnectionNoEvents$okhttp != null) {
                            Util.closeQuietly(releaseConnectionNoEvents$okhttp);
                        }
                        this.eventListener.connectionReleased(this, realConnection);
                    } else {
                        if (!(releaseConnectionNoEvents$okhttp == null)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    }
                } else {
                    throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + realConnection);
                }
            }
            E timeoutExit = timeoutExit(e11);
            if (e11 != null) {
                this.eventListener.callFailed(this, timeoutExit);
            } else {
                this.eventListener.callEnd(this);
            }
            return timeoutExit;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    private final Address createAddress(HttpUrl httpUrl) {
        CertificatePinner certificatePinner;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory;
        if (httpUrl.isHttps()) {
            SSLSocketFactory sslSocketFactory = this.client.sslSocketFactory();
            hostnameVerifier = this.client.hostnameVerifier();
            sSLSocketFactory = sslSocketFactory;
            certificatePinner = this.client.certificatePinner();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            certificatePinner = null;
        }
        return new Address(httpUrl.host(), httpUrl.port(), this.client.dns(), this.client.socketFactory(), sSLSocketFactory, hostnameVerifier, certificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
    }

    private final <E extends IOException> E timeoutExit(E e11) {
        if (this.timeoutEarlyExit || !this.timeout.exit()) {
            return e11;
        }
        E interruptedIOException = new InterruptedIOException(OptionsBridge.TIMEOUT_KEY);
        if (e11 != null) {
            interruptedIOException.initCause(e11);
        }
        return interruptedIOException;
    }

    /* access modifiers changed from: private */
    public final String toLoggableString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isCanceled() ? "canceled " : "");
        sb2.append(this.forWebSocket ? "web socket" : TUIConstants.TUICalling.METHOD_NAME_CALL);
        sb2.append(" to ");
        sb2.append(redactedUrl$okhttp());
        return sb2.toString();
    }

    public final void acquireConnectionNoEvents(RealConnection realConnection) {
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            if (this.connection == null) {
                this.connection = realConnection;
                realConnection.getCalls().add(new CallReference(this, this.callStackTrace));
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    public void cancel() {
        if (!this.canceled) {
            this.canceled = true;
            Exchange exchange2 = this.exchange;
            if (exchange2 != null) {
                exchange2.cancel();
            }
            RealConnection realConnection = this.connectionToCancel;
            if (realConnection != null) {
                realConnection.cancel();
            }
            this.eventListener.canceled(this);
        }
    }

    public void enqueue(Callback callback) {
        if (this.executed.compareAndSet(false, true)) {
            callStart();
            this.client.dispatcher().enqueue$okhttp(new AsyncCall(callback));
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void enterNetworkInterceptorExchange(Request request, boolean z11) {
        if (this.interceptorScopedExchange == null) {
            synchronized (this) {
                if (!(!this.responseBodyOpen)) {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                } else if (!this.requestBodyOpen) {
                    Unit unit = Unit.f56620a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            if (z11) {
                this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(request.url()), this, this.eventListener);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public Response execute() {
        if (this.executed.compareAndSet(false, true)) {
            this.timeout.enter();
            callStart();
            try {
                this.client.dispatcher().executed$okhttp(this);
                return getResponseWithInterceptorChain$okhttp();
            } finally {
                this.client.dispatcher().finished$okhttp(this);
            }
        } else {
            throw new IllegalStateException("Already Executed".toString());
        }
    }

    public final void exitNetworkInterceptorExchange$okhttp(boolean z11) {
        Exchange exchange2;
        synchronized (this) {
            if (this.expectMoreExchanges) {
                Unit unit = Unit.f56620a;
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z11 && (exchange2 = this.exchange) != null) {
            exchange2.detachWithViolence();
        }
        this.interceptorScopedExchange = null;
    }

    public final OkHttpClient getClient() {
        return this.client;
    }

    public final RealConnection getConnection() {
        return this.connection;
    }

    public final RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    public final Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.Response getResponseWithInterceptorChain$okhttp() throws java.io.IOException {
        /*
            r11 = this;
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            okhttp3.OkHttpClient r0 = r11.client
            java.util.List r0 = r0.interceptors()
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.A(r2, r0)
            okhttp3.internal.http.RetryAndFollowUpInterceptor r0 = new okhttp3.internal.http.RetryAndFollowUpInterceptor
            okhttp3.OkHttpClient r1 = r11.client
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.BridgeInterceptor r0 = new okhttp3.internal.http.BridgeInterceptor
            okhttp3.OkHttpClient r1 = r11.client
            okhttp3.CookieJar r1 = r1.cookieJar()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.cache.CacheInterceptor r0 = new okhttp3.internal.cache.CacheInterceptor
            okhttp3.OkHttpClient r1 = r11.client
            okhttp3.Cache r1 = r1.cache()
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.connection.ConnectInterceptor r0 = okhttp3.internal.connection.ConnectInterceptor.INSTANCE
            r2.add(r0)
            boolean r0 = r11.forWebSocket
            if (r0 != 0) goto L_0x0046
            okhttp3.OkHttpClient r0 = r11.client
            java.util.List r0 = r0.networkInterceptors()
            boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.A(r2, r0)
        L_0x0046:
            okhttp3.internal.http.CallServerInterceptor r0 = new okhttp3.internal.http.CallServerInterceptor
            boolean r1 = r11.forWebSocket
            r0.<init>(r1)
            r2.add(r0)
            okhttp3.internal.http.RealInterceptorChain r9 = new okhttp3.internal.http.RealInterceptorChain
            r3 = 0
            r4 = 0
            okhttp3.Request r5 = r11.originalRequest
            okhttp3.OkHttpClient r0 = r11.client
            int r6 = r0.connectTimeoutMillis()
            okhttp3.OkHttpClient r0 = r11.client
            int r7 = r0.readTimeoutMillis()
            okhttp3.OkHttpClient r0 = r11.client
            int r8 = r0.writeTimeoutMillis()
            r0 = r9
            r1 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r0 = 0
            r1 = 0
            okhttp3.Request r2 = r11.originalRequest     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            okhttp3.Response r2 = r9.proceed(r2)     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            boolean r3 = r11.isCanceled()     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            if (r3 != 0) goto L_0x007f
            r11.noMoreExchanges$okhttp(r1)
            return r2
        L_0x007f:
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            java.lang.String r3 = "Canceled"
            r2.<init>(r3)     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            throw r2     // Catch:{ IOException -> 0x008c, all -> 0x008a }
        L_0x008a:
            r2 = move-exception
            goto L_0x0097
        L_0x008c:
            r0 = move-exception
            r2 = 1
            java.io.IOException r0 = r11.noMoreExchanges$okhttp(r0)     // Catch:{ all -> 0x0093 }
            throw r0     // Catch:{ all -> 0x0093 }
        L_0x0093:
            r0 = move-exception
            r10 = r2
            r2 = r0
            r0 = r10
        L_0x0097:
            if (r0 != 0) goto L_0x009c
            r11.noMoreExchanges$okhttp(r1)
        L_0x009c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.getResponseWithInterceptorChain$okhttp():okhttp3.Response");
    }

    public final Exchange initExchange$okhttp(RealInterceptorChain realInterceptorChain) {
        synchronized (this) {
            if (!this.expectMoreExchanges) {
                throw new IllegalStateException("released".toString());
            } else if (!(!this.responseBodyOpen)) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!this.requestBodyOpen) {
                Unit unit = Unit.f56620a;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ExchangeFinder exchangeFinder2 = this.exchangeFinder;
        Exchange exchange2 = new Exchange(this, this.eventListener, exchangeFinder2, exchangeFinder2.find(this.client, realInterceptorChain));
        this.interceptorScopedExchange = exchange2;
        this.exchange = exchange2;
        synchronized (this) {
            this.requestBodyOpen = true;
            this.responseBodyOpen = true;
        }
        if (!this.canceled) {
            return exchange2;
        }
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    public boolean isExecuted() {
        return this.executed.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x001c A[Catch:{ all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0020 A[Catch:{ all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x002b A[Catch:{ all -> 0x0012 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x002d A[Catch:{ all -> 0x0012 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <E extends java.io.IOException> E messageDone$okhttp(okhttp3.internal.connection.Exchange r2, boolean r3, boolean r4, E r5) {
        /*
            r1 = this;
            okhttp3.internal.connection.Exchange r0 = r1.exchange
            boolean r2 = kotlin.jvm.internal.x.b(r2, r0)
            if (r2 != 0) goto L_0x0009
            return r5
        L_0x0009:
            monitor-enter(r1)
            r2 = 0
            if (r3 == 0) goto L_0x0014
            boolean r0 = r1.requestBodyOpen     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x001a
            goto L_0x0014
        L_0x0012:
            r2 = move-exception
            goto L_0x0054
        L_0x0014:
            if (r4 == 0) goto L_0x003c
            boolean r0 = r1.responseBodyOpen     // Catch:{ all -> 0x0012 }
            if (r0 == 0) goto L_0x003c
        L_0x001a:
            if (r3 == 0) goto L_0x001e
            r1.requestBodyOpen = r2     // Catch:{ all -> 0x0012 }
        L_0x001e:
            if (r4 == 0) goto L_0x0022
            r1.responseBodyOpen = r2     // Catch:{ all -> 0x0012 }
        L_0x0022:
            boolean r3 = r1.requestBodyOpen     // Catch:{ all -> 0x0012 }
            r4 = 1
            if (r3 != 0) goto L_0x002d
            boolean r0 = r1.responseBodyOpen     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x002d
            r0 = r4
            goto L_0x002e
        L_0x002d:
            r0 = r2
        L_0x002e:
            if (r3 != 0) goto L_0x0039
            boolean r3 = r1.responseBodyOpen     // Catch:{ all -> 0x0012 }
            if (r3 != 0) goto L_0x0039
            boolean r3 = r1.expectMoreExchanges     // Catch:{ all -> 0x0012 }
            if (r3 != 0) goto L_0x0039
            r2 = r4
        L_0x0039:
            r3 = r2
            r2 = r0
            goto L_0x003d
        L_0x003c:
            r3 = r2
        L_0x003d:
            kotlin.Unit r4 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0012 }
            monitor-exit(r1)
            if (r2 == 0) goto L_0x004c
            r2 = 0
            r1.exchange = r2
            okhttp3.internal.connection.RealConnection r2 = r1.connection
            if (r2 == 0) goto L_0x004c
            r2.incrementSuccessCount$okhttp()
        L_0x004c:
            if (r3 == 0) goto L_0x0053
            java.io.IOException r2 = r1.callDone(r5)
            return r2
        L_0x0053:
            return r5
        L_0x0054:
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealCall.messageDone$okhttp(okhttp3.internal.connection.Exchange, boolean, boolean, java.io.IOException):java.io.IOException");
    }

    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        boolean z11;
        synchronized (this) {
            z11 = false;
            if (this.expectMoreExchanges) {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen && !this.responseBodyOpen) {
                    z11 = true;
                }
            }
            Unit unit = Unit.f56620a;
        }
        return z11 ? callDone(iOException) : iOException;
    }

    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    public final Socket releaseConnectionNoEvents$okhttp() {
        RealConnection realConnection = this.connection;
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            List<Reference<RealCall>> calls = realConnection.getCalls();
            Iterator<Reference<RealCall>> it2 = calls.iterator();
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    i11 = -1;
                    break;
                } else if (x.b(it2.next().get(), this)) {
                    break;
                } else {
                    i11++;
                }
            }
            if (i11 != -1) {
                z11 = true;
            }
            if (z11) {
                calls.remove(i11);
                this.connection = null;
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs$okhttp(System.nanoTime());
                    if (this.connectionPool.connectionBecameIdle(realConnection)) {
                        return realConnection.socket();
                    }
                }
                return null;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    public Request request() {
        return this.originalRequest;
    }

    public final boolean retryAfterFailure() {
        return this.exchangeFinder.retryAfterFailure();
    }

    public final void setConnectionToCancel(RealConnection realConnection) {
        this.connectionToCancel = realConnection;
    }

    public final void timeoutEarlyExit() {
        if (!this.timeoutEarlyExit) {
            this.timeoutEarlyExit = true;
            this.timeout.exit();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public AsyncTimeout timeout() {
        return this.timeout;
    }

    public RealCall clone() {
        return new RealCall(this.client, this.originalRequest, this.forWebSocket);
    }
}
