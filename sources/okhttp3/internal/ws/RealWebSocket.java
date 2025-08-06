package okhttp3.internal.ws;

import com.google.common.net.HttpHeaders;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.woodpecker.aop.WoodPeckerWebSocketAspect;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.ranges.h;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.reflect.c;
import x10.a;

public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    public static final Companion Companion = new Companion((r) null);
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = CollectionsKt__CollectionsJVMKt.e(Protocol.HTTP_1_1);
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_1 = null;
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_2 = null;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    /* access modifiers changed from: private */
    public WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    /* access modifiers changed from: private */
    public final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;
    /* access modifiers changed from: private */
    public String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private TaskQueue taskQueue;
    private WebSocketWriter writer;
    private Task writerTask;

    public class AjcClosure1 extends AroundClosure {
        public AjcClosure1(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            RealWebSocket.init$_aroundBody0((RealWebSocket) objArr2[0], (TaskRunner) objArr2[1], (Request) objArr2[2], (WebSocketListener) objArr2[3], (Random) objArr2[4], a.d(objArr2[5]), (WebSocketExtensions) objArr2[6], a.d(objArr2[7]), (JoinPoint) objArr2[8]);
            return null;
        }
    }

    public static final class Close {
        private final long cancelAfterCloseMillis;
        private final int code;
        private final ByteString reason;

        public Close(int i11, ByteString byteString, long j11) {
            this.code = i11;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j11;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        public final ByteString getReason() {
            return this.reason;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public static final class Message {
        private final ByteString data;
        private final int formatOpcode;

        public Message(int i11, ByteString byteString) {
            this.formatOpcode = i11;
            this.data = byteString;
        }

        public final ByteString getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    public static abstract class Streams implements Closeable {
        private final boolean client;
        private final BufferedSink sink;
        private final BufferedSource source;

        public Streams(boolean z11, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.client = z11;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }

        public final boolean getClient() {
            return this.client;
        }

        public final BufferedSink getSink() {
            return this.sink;
        }

        public final BufferedSource getSource() {
            return this.source;
        }
    }

    public final class WriterTask extends Task {
        public WriterTask() {
            super(RealWebSocket.this.name + " writer", false, 2, (r) null);
        }

        public long runOnce() {
            try {
                if (RealWebSocket.this.writeOneFrame$okhttp()) {
                    return 0;
                }
                return -1;
            } catch (IOException e11) {
                RealWebSocket.this.failWebSocket(e11, (Response) null);
                return -1;
            }
        }
    }

    static {
        ajc$preClinit();
    }

    public RealWebSocket(TaskRunner taskRunner, Request request, WebSocketListener webSocketListener, Random random2, long j11, WebSocketExtensions webSocketExtensions, long j12) {
        JoinPoint e11 = c.e(ajc$tjp_0, this, this, new Object[]{taskRunner, request, webSocketListener, random2, a.c(j11), webSocketExtensions, a.c(j12)});
        WoodPeckerWebSocketAspect.e().f(new AjcClosure1(new Object[]{this, taskRunner, request, webSocketListener, random2, a.c(j11), webSocketExtensions, a.c(j12), e11}).linkClosureAndJoinPoint(69648));
    }

    private static /* synthetic */ void ajc$preClinit() {
        c cVar = new c("RealWebSocket.kt", RealWebSocket.class);
        ajc$tjp_0 = cVar.h("constructor-execution", cVar.b("1", "okhttp3.internal.ws.RealWebSocket", "okhttp3.internal.concurrent.TaskRunner:okhttp3.Request:okhttp3.WebSocketListener:java.util.Random:long:okhttp3.internal.ws.WebSocketExtensions:long", "taskRunner:originalRequest:listener:random:pingIntervalMillis:extensions:minimumDeflateSize", ""), 56);
        ajc$tjp_1 = cVar.h("method-call", cVar.g("32", "send", "okhttp3.internal.ws.RealWebSocket", "okio.ByteString:int", "data:formatOpcode", "", "boolean"), 393);
        ajc$tjp_2 = cVar.h("method-call", cVar.g("32", "send", "okhttp3.internal.ws.RealWebSocket", "okio.ByteString:int", "data:formatOpcode", "", "boolean"), 397);
    }

    public static final /* synthetic */ void init$_aroundBody0(RealWebSocket realWebSocket, TaskRunner taskRunner, Request request, WebSocketListener webSocketListener, Random random2, long j11, WebSocketExtensions webSocketExtensions, long j12, JoinPoint joinPoint) {
        realWebSocket.originalRequest = request;
        realWebSocket.listener = webSocketListener;
        realWebSocket.random = random2;
        realWebSocket.pingIntervalMillis = j11;
        realWebSocket.extensions = webSocketExtensions;
        realWebSocket.minimumDeflateSize = j12;
        realWebSocket.taskQueue = taskRunner.newQueue();
        realWebSocket.pongQueue = new ArrayDeque<>();
        realWebSocket.messageAndCloseQueue = new ArrayDeque<>();
        realWebSocket.receivedCloseCode = -1;
        if (x.b("GET", request.method())) {
            ByteString.Companion companion = ByteString.Companion;
            byte[] bArr = new byte[16];
            random2.nextBytes(bArr);
            Unit unit = Unit.f56620a;
            realWebSocket.key = ByteString.Companion.of$default(companion, bArr, 0, 0, 3, (Object) null).base64();
            return;
        }
        throw new IllegalArgumentException(("Request must be GET: " + request.method()).toString());
    }

    /* access modifiers changed from: private */
    public final boolean isValid(WebSocketExtensions webSocketExtensions) {
        if (webSocketExtensions.unknownValues || webSocketExtensions.clientMaxWindowBits != null) {
            return false;
        }
        if (webSocketExtensions.serverMaxWindowBits == null || new h(8, 15).h(webSocketExtensions.serverMaxWindowBits.intValue())) {
            return true;
        }
        return false;
    }

    private final void runWriter() {
        if (!Util.assertionsEnabled || Thread.holdsLock(this)) {
            Task task = this.writerTask;
            if (task != null) {
                TaskQueue.schedule$default(this.taskQueue, task, 0, 2, (Object) null);
                return;
            }
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
    }

    public final void awaitTermination(long j11, TimeUnit timeUnit) throws InterruptedException {
        this.taskQueue.idleLatch().await(j11, timeUnit);
    }

    public void cancel() {
        this.call.cancel();
    }

    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange) throws IOException {
        if (response.code() == 101) {
            String header$default = Response.header$default(response, HttpHeaders.CONNECTION, (String) null, 2, (Object) null);
            if (StringsKt__StringsJVMKt.w(HttpHeaders.UPGRADE, header$default, true)) {
                String header$default2 = Response.header$default(response, HttpHeaders.UPGRADE, (String) null, 2, (Object) null);
                if (StringsKt__StringsJVMKt.w("websocket", header$default2, true)) {
                    String header$default3 = Response.header$default(response, HttpHeaders.SEC_WEBSOCKET_ACCEPT, (String) null, 2, (Object) null);
                    ByteString.Companion companion = ByteString.Companion;
                    String base64 = companion.encodeUtf8(this.key + WebSocketProtocol.ACCEPT_MAGIC).sha1().base64();
                    if (!x.b(base64, header$default3)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header$default3 + '\'');
                    } else if (exchange == null) {
                        throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
                    }
                } else {
                    throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header$default2 + '\'');
                }
            } else {
                throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header$default + '\'');
            }
        } else {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + ' ' + response.message() + '\'');
        }
    }

    public boolean close(int i11, String str) {
        return close(i11, str, 60000);
    }

    public final void connect(OkHttpClient okHttpClient) {
        if (this.originalRequest.header(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS) != null) {
            failWebSocket(new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'"), (Response) null);
            return;
        }
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        Request build2 = this.originalRequest.newBuilder().header(HttpHeaders.UPGRADE, "websocket").header(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE).header(HttpHeaders.SEC_WEBSOCKET_KEY, this.key).header(HttpHeaders.SEC_WEBSOCKET_VERSION, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_WARRANT).header(HttpHeaders.SEC_WEBSOCKET_EXTENSIONS, "permessage-deflate").build();
        RealCall realCall = new RealCall(build, build2, true);
        this.call = realCall;
        realCall.enqueue(new RealWebSocket$connect$1(this, build2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r4.listener.onFailure(r4, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0035, code lost:
        if (r0 != null) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0037, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003a, code lost:
        if (r2 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003c, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003f, code lost:
        if (r3 != null) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0044, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void failWebSocket(java.lang.Exception r5, okhttp3.Response r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.failed     // Catch:{ all -> 0x0045 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            r0 = 1
            r4.failed = r0     // Catch:{ all -> 0x0045 }
            okhttp3.internal.ws.RealWebSocket$Streams r0 = r4.streams     // Catch:{ all -> 0x0045 }
            r1 = 0
            r4.streams = r1     // Catch:{ all -> 0x0045 }
            okhttp3.internal.ws.WebSocketReader r2 = r4.reader     // Catch:{ all -> 0x0045 }
            r4.reader = r1     // Catch:{ all -> 0x0045 }
            okhttp3.internal.ws.WebSocketWriter r3 = r4.writer     // Catch:{ all -> 0x0045 }
            r4.writer = r1     // Catch:{ all -> 0x0045 }
            okhttp3.internal.concurrent.TaskQueue r1 = r4.taskQueue     // Catch:{ all -> 0x0045 }
            r1.shutdown()     // Catch:{ all -> 0x0045 }
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0045 }
            monitor-exit(r4)
            okhttp3.WebSocketListener r1 = r4.listener     // Catch:{ all -> 0x0034 }
            r1.onFailure(r4, r5, r6)     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x0029
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
        L_0x0029:
            if (r2 == 0) goto L_0x002e
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x002e:
            if (r3 == 0) goto L_0x0033
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x0033:
            return
        L_0x0034:
            r5 = move-exception
            if (r0 == 0) goto L_0x003a
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r0)
        L_0x003a:
            if (r2 == 0) goto L_0x003f
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x003f:
            if (r3 == 0) goto L_0x0044
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x0044:
            throw r5
        L_0x0045:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.failWebSocket(java.lang.Exception, okhttp3.Response):void");
    }

    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    public final void initReaderAndWriter(String str, Streams streams2) throws IOException {
        WebSocketExtensions webSocketExtensions = this.extensions;
        synchronized (this) {
            this.name = str;
            this.streams = streams2;
            this.writer = new WebSocketWriter(streams2.getClient(), streams2.getSink(), this.random, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(streams2.getClient()), this.minimumDeflateSize);
            this.writerTask = new WriterTask();
            long j11 = this.pingIntervalMillis;
            if (j11 != 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(j11);
                TaskQueue taskQueue2 = this.taskQueue;
                taskQueue2.schedule(new RealWebSocket$initReaderAndWriter$lambda$3$$inlined$schedule$1(str + " ping", this, nanos), nanos);
            }
            if (!this.messageAndCloseQueue.isEmpty()) {
                runWriter();
            }
            Unit unit = Unit.f56620a;
        }
        this.reader = new WebSocketReader(streams2.getClient(), streams2.getSource(), this, webSocketExtensions.perMessageDeflate, webSocketExtensions.noContextTakeover(!streams2.getClient()));
    }

    public final void loopReader() throws IOException {
        while (this.receivedCloseCode == -1) {
            this.reader.processNextFrame();
        }
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [okhttp3.internal.ws.WebSocketWriter, okhttp3.internal.ws.WebSocketReader, okhttp3.internal.ws.RealWebSocket$Streams] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReadClose(int r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r5 == r2) goto L_0x0007
            r3 = r0
            goto L_0x0008
        L_0x0007:
            r3 = r1
        L_0x0008:
            if (r3 == 0) goto L_0x0078
            monitor-enter(r4)
            int r3 = r4.receivedCloseCode     // Catch:{ all -> 0x0075 }
            if (r3 != r2) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            if (r0 == 0) goto L_0x0069
            r4.receivedCloseCode = r5     // Catch:{ all -> 0x0075 }
            r4.receivedCloseReason = r6     // Catch:{ all -> 0x0075 }
            boolean r0 = r4.enqueuedClose     // Catch:{ all -> 0x0075 }
            r1 = 0
            if (r0 == 0) goto L_0x0037
            java.util.ArrayDeque<java.lang.Object> r0 = r4.messageAndCloseQueue     // Catch:{ all -> 0x0075 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0075 }
            if (r0 == 0) goto L_0x0037
            okhttp3.internal.ws.RealWebSocket$Streams r0 = r4.streams     // Catch:{ all -> 0x0075 }
            r4.streams = r1     // Catch:{ all -> 0x0075 }
            okhttp3.internal.ws.WebSocketReader r2 = r4.reader     // Catch:{ all -> 0x0075 }
            r4.reader = r1     // Catch:{ all -> 0x0075 }
            okhttp3.internal.ws.WebSocketWriter r3 = r4.writer     // Catch:{ all -> 0x0075 }
            r4.writer = r1     // Catch:{ all -> 0x0075 }
            okhttp3.internal.concurrent.TaskQueue r1 = r4.taskQueue     // Catch:{ all -> 0x0075 }
            r1.shutdown()     // Catch:{ all -> 0x0075 }
            r1 = r0
            goto L_0x0039
        L_0x0037:
            r2 = r1
            r3 = r2
        L_0x0039:
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0075 }
            monitor-exit(r4)
            okhttp3.WebSocketListener r0 = r4.listener     // Catch:{ all -> 0x0058 }
            r0.onClosing(r4, r5, r6)     // Catch:{ all -> 0x0058 }
            if (r1 == 0) goto L_0x0048
            okhttp3.WebSocketListener r0 = r4.listener     // Catch:{ all -> 0x0058 }
            r0.onClosed(r4, r5, r6)     // Catch:{ all -> 0x0058 }
        L_0x0048:
            if (r1 == 0) goto L_0x004d
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x004d:
            if (r2 == 0) goto L_0x0052
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0052:
            if (r3 == 0) goto L_0x0057
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x0057:
            return
        L_0x0058:
            r5 = move-exception
            if (r1 == 0) goto L_0x005e
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x005e:
            if (r2 == 0) goto L_0x0063
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r2)
        L_0x0063:
            if (r3 == 0) goto L_0x0068
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r3)
        L_0x0068:
            throw r5
        L_0x0069:
            java.lang.String r5 = "already closed"
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0075 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0075 }
            r6.<init>(r5)     // Catch:{ all -> 0x0075 }
            throw r6     // Catch:{ all -> 0x0075 }
        L_0x0075:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        L_0x0078:
            java.lang.String r5 = "Failed requirement."
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r5 = r5.toString()
            r6.<init>(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.onReadClose(int, java.lang.String):void");
    }

    public void onReadMessage(String str) throws IOException {
        this.listener.onMessage((WebSocket) this, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onReadPing(okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.failed     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0022
            boolean r0 = r1.enqueuedClose     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            java.util.ArrayDeque<java.lang.Object> r0 = r1.messageAndCloseQueue     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            goto L_0x0022
        L_0x0012:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.pongQueue     // Catch:{ all -> 0x0024 }
            r0.add(r2)     // Catch:{ all -> 0x0024 }
            r1.runWriter()     // Catch:{ all -> 0x0024 }
            int r2 = r1.receivedPingCount     // Catch:{ all -> 0x0024 }
            int r2 = r2 + 1
            r1.receivedPingCount = r2     // Catch:{ all -> 0x0024 }
            monitor-exit(r1)
            return
        L_0x0022:
            monitor-exit(r1)
            return
        L_0x0024:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.onReadPing(okio.ByteString):void");
    }

    public synchronized void onReadPong(ByteString byteString) {
        this.receivedPongCount++;
        this.awaitingPong = false;
    }

    public final synchronized boolean pong(ByteString byteString) {
        if (!this.failed) {
            if (!this.enqueuedClose || !this.messageAndCloseQueue.isEmpty()) {
                this.pongQueue.add(byteString);
                runWriter();
                return true;
            }
        }
        return false;
    }

    public final boolean processNextFrame() throws IOException {
        try {
            this.reader.processNextFrame();
            if (this.receivedCloseCode == -1) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            failWebSocket(e11, (Response) null);
            return false;
        }
    }

    public synchronized long queueSize() {
        return this.queueSize;
    }

    public final synchronized int receivedPingCount() {
        return this.receivedPingCount;
    }

    public final synchronized int receivedPongCount() {
        return this.receivedPongCount;
    }

    public Request request() {
        return this.originalRequest;
    }

    public boolean send(String str) {
        ByteString encodeUtf8 = ByteString.Companion.encodeUtf8(str);
        WoodPeckerWebSocketAspect.e().g(c.d(ajc$tjp_1, this, this, encodeUtf8, a.a(1)));
        return send(encodeUtf8, 1);
    }

    public final synchronized int sentPingCount() {
        return this.sentPingCount;
    }

    public final void tearDown() throws InterruptedException {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10, TimeUnit.SECONDS);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007a, code lost:
        if (r2 == null) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r0.writePong(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0084, code lost:
        if ((r5 instanceof okhttp3.internal.ws.RealWebSocket.Message) == false) goto L_0x00a7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0086, code lost:
        r5 = (okhttp3.internal.ws.RealWebSocket.Message) r5;
        r0.writeMessageFrame(r5.getFormatOpcode(), r5.getData());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0093, code lost:
        monitor-enter(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        r13.queueSize -= (long) r5.getData().size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        monitor-exit(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a9, code lost:
        if ((r5 instanceof okhttp3.internal.ws.RealWebSocket.Close) == false) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ab, code lost:
        r5 = (okhttp3.internal.ws.RealWebSocket.Close) r5;
        r0.writeClose(r5.getCode(), r5.getReason());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00b8, code lost:
        if (r1 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00ba, code lost:
        r13.listener.onClosed(r13, r4, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00bf, code lost:
        if (r1 == null) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00c1, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00c4, code lost:
        if (r8 == null) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c6, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00c9, code lost:
        if (r9 == null) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00cb, code lost:
        okhttp3.internal.Util.closeQuietly(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ce, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d4, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00d6, code lost:
        if (r1 != null) goto L_0x00d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00d8, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00db, code lost:
        if (r8 != null) goto L_0x00dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00dd, code lost:
        okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00e0, code lost:
        if (r9 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e2, code lost:
        okhttp3.internal.Util.closeQuietly(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e5, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean writeOneFrame$okhttp() throws java.io.IOException {
        /*
            r13 = this;
            monitor-enter(r13)
            boolean r0 = r13.failed     // Catch:{ all -> 0x00e6 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r13)
            return r1
        L_0x0008:
            okhttp3.internal.ws.WebSocketWriter r0 = r13.writer     // Catch:{ all -> 0x00e6 }
            java.util.ArrayDeque<okio.ByteString> r2 = r13.pongQueue     // Catch:{ all -> 0x00e6 }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x00e6 }
            r3 = 1
            r4 = -1
            r5 = 0
            if (r2 != 0) goto L_0x0073
            java.util.ArrayDeque<java.lang.Object> r6 = r13.messageAndCloseQueue     // Catch:{ all -> 0x00e6 }
            java.lang.Object r6 = r6.poll()     // Catch:{ all -> 0x00e6 }
            boolean r7 = r6 instanceof okhttp3.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x00e6 }
            if (r7 == 0) goto L_0x0069
            int r1 = r13.receivedCloseCode     // Catch:{ all -> 0x00e6 }
            java.lang.String r7 = r13.receivedCloseReason     // Catch:{ all -> 0x00e6 }
            if (r1 == r4) goto L_0x003b
            okhttp3.internal.ws.RealWebSocket$Streams r4 = r13.streams     // Catch:{ all -> 0x00e6 }
            r13.streams = r5     // Catch:{ all -> 0x00e6 }
            okhttp3.internal.ws.WebSocketReader r8 = r13.reader     // Catch:{ all -> 0x00e6 }
            r13.reader = r5     // Catch:{ all -> 0x00e6 }
            okhttp3.internal.ws.WebSocketWriter r9 = r13.writer     // Catch:{ all -> 0x00e6 }
            r13.writer = r5     // Catch:{ all -> 0x00e6 }
            okhttp3.internal.concurrent.TaskQueue r5 = r13.taskQueue     // Catch:{ all -> 0x00e6 }
            r5.shutdown()     // Catch:{ all -> 0x00e6 }
            r5 = r6
            r12 = r4
            r4 = r1
            r1 = r12
            goto L_0x0077
        L_0x003b:
            r4 = r6
            okhttp3.internal.ws.RealWebSocket$Close r4 = (okhttp3.internal.ws.RealWebSocket.Close) r4     // Catch:{ all -> 0x00e6 }
            long r8 = r4.getCancelAfterCloseMillis()     // Catch:{ all -> 0x00e6 }
            okhttp3.internal.concurrent.TaskQueue r4 = r13.taskQueue     // Catch:{ all -> 0x00e6 }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e6 }
            r10.<init>()     // Catch:{ all -> 0x00e6 }
            java.lang.String r11 = r13.name     // Catch:{ all -> 0x00e6 }
            r10.append(r11)     // Catch:{ all -> 0x00e6 }
            java.lang.String r11 = " cancel"
            r10.append(r11)     // Catch:{ all -> 0x00e6 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00e6 }
            java.util.concurrent.TimeUnit r11 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00e6 }
            long r8 = r11.toNanos(r8)     // Catch:{ all -> 0x00e6 }
            okhttp3.internal.ws.RealWebSocket$writeOneFrame$lambda$8$$inlined$execute$default$1 r11 = new okhttp3.internal.ws.RealWebSocket$writeOneFrame$lambda$8$$inlined$execute$default$1     // Catch:{ all -> 0x00e6 }
            r11.<init>(r10, r3, r13)     // Catch:{ all -> 0x00e6 }
            r4.schedule(r11, r8)     // Catch:{ all -> 0x00e6 }
            r4 = r1
            r1 = r5
            r8 = r1
            goto L_0x0070
        L_0x0069:
            if (r6 != 0) goto L_0x006d
            monitor-exit(r13)
            return r1
        L_0x006d:
            r1 = r5
            r7 = r1
            r8 = r7
        L_0x0070:
            r9 = r8
            r5 = r6
            goto L_0x0077
        L_0x0073:
            r1 = r5
            r7 = r1
            r8 = r7
            r9 = r8
        L_0x0077:
            kotlin.Unit r6 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00e6 }
            monitor-exit(r13)
            if (r2 == 0) goto L_0x0082
            okio.ByteString r2 = (okio.ByteString) r2     // Catch:{ all -> 0x00d5 }
            r0.writePong(r2)     // Catch:{ all -> 0x00d5 }
            goto L_0x00bf
        L_0x0082:
            boolean r2 = r5 instanceof okhttp3.internal.ws.RealWebSocket.Message     // Catch:{ all -> 0x00d5 }
            if (r2 == 0) goto L_0x00a7
            okhttp3.internal.ws.RealWebSocket$Message r5 = (okhttp3.internal.ws.RealWebSocket.Message) r5     // Catch:{ all -> 0x00d5 }
            int r2 = r5.getFormatOpcode()     // Catch:{ all -> 0x00d5 }
            okio.ByteString r4 = r5.getData()     // Catch:{ all -> 0x00d5 }
            r0.writeMessageFrame(r2, r4)     // Catch:{ all -> 0x00d5 }
            monitor-enter(r13)     // Catch:{ all -> 0x00d5 }
            long r6 = r13.queueSize     // Catch:{ all -> 0x00a4 }
            okio.ByteString r0 = r5.getData()     // Catch:{ all -> 0x00a4 }
            int r0 = r0.size()     // Catch:{ all -> 0x00a4 }
            long r4 = (long) r0     // Catch:{ all -> 0x00a4 }
            long r6 = r6 - r4
            r13.queueSize = r6     // Catch:{ all -> 0x00a4 }
            monitor-exit(r13)     // Catch:{ all -> 0x00d5 }
            goto L_0x00bf
        L_0x00a4:
            r0 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x00d5 }
            throw r0     // Catch:{ all -> 0x00d5 }
        L_0x00a7:
            boolean r2 = r5 instanceof okhttp3.internal.ws.RealWebSocket.Close     // Catch:{ all -> 0x00d5 }
            if (r2 == 0) goto L_0x00cf
            okhttp3.internal.ws.RealWebSocket$Close r5 = (okhttp3.internal.ws.RealWebSocket.Close) r5     // Catch:{ all -> 0x00d5 }
            int r2 = r5.getCode()     // Catch:{ all -> 0x00d5 }
            okio.ByteString r5 = r5.getReason()     // Catch:{ all -> 0x00d5 }
            r0.writeClose(r2, r5)     // Catch:{ all -> 0x00d5 }
            if (r1 == 0) goto L_0x00bf
            okhttp3.WebSocketListener r0 = r13.listener     // Catch:{ all -> 0x00d5 }
            r0.onClosed(r13, r4, r7)     // Catch:{ all -> 0x00d5 }
        L_0x00bf:
            if (r1 == 0) goto L_0x00c4
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x00c4:
            if (r8 == 0) goto L_0x00c9
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8)
        L_0x00c9:
            if (r9 == 0) goto L_0x00ce
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9)
        L_0x00ce:
            return r3
        L_0x00cf:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x00d5 }
            r0.<init>()     // Catch:{ all -> 0x00d5 }
            throw r0     // Catch:{ all -> 0x00d5 }
        L_0x00d5:
            r0 = move-exception
            if (r1 == 0) goto L_0x00db
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r1)
        L_0x00db:
            if (r8 == 0) goto L_0x00e0
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r8)
        L_0x00e0:
            if (r9 == 0) goto L_0x00e5
            okhttp3.internal.Util.closeQuietly((java.io.Closeable) r9)
        L_0x00e5:
            throw r0
        L_0x00e6:
            r0 = move-exception
            monitor-exit(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writeOneFrame$okhttp():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0022, code lost:
        if (r1 == -1) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0024, code lost:
        failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + r7.pingIntervalMillis + "ms (after " + (r1 - 1) + " successful ping/pongs)"), (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0.writePing(okio.ByteString.EMPTY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0054, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        failWebSocket(r0, (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writePingFrame$okhttp() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.failed     // Catch:{ all -> 0x0059 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r7)
            return
        L_0x0007:
            okhttp3.internal.ws.WebSocketWriter r0 = r7.writer     // Catch:{ all -> 0x0059 }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r7)
            return
        L_0x000d:
            boolean r1 = r7.awaitingPong     // Catch:{ all -> 0x0059 }
            r2 = -1
            if (r1 == 0) goto L_0x0015
            int r1 = r7.sentPingCount     // Catch:{ all -> 0x0059 }
            goto L_0x0016
        L_0x0015:
            r1 = r2
        L_0x0016:
            int r3 = r7.sentPingCount     // Catch:{ all -> 0x0059 }
            r4 = 1
            int r3 = r3 + r4
            r7.sentPingCount = r3     // Catch:{ all -> 0x0059 }
            r7.awaitingPong = r4     // Catch:{ all -> 0x0059 }
            kotlin.Unit r3 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0059 }
            monitor-exit(r7)
            r3 = 0
            if (r1 == r2) goto L_0x004e
            java.net.SocketTimeoutException r0 = new java.net.SocketTimeoutException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "sent ping but didn't receive pong within "
            r2.append(r5)
            long r5 = r7.pingIntervalMillis
            r2.append(r5)
            java.lang.String r5 = "ms (after "
            r2.append(r5)
            int r1 = r1 - r4
            r2.append(r1)
            java.lang.String r1 = " successful ping/pongs)"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            r7.failWebSocket(r0, r3)
            return
        L_0x004e:
            okio.ByteString r1 = okio.ByteString.EMPTY     // Catch:{ IOException -> 0x0054 }
            r0.writePing(r1)     // Catch:{ IOException -> 0x0054 }
            goto L_0x0058
        L_0x0054:
            r0 = move-exception
            r7.failWebSocket(r0, r3)
        L_0x0058:
            return
        L_0x0059:
            r0 = move-exception
            monitor-exit(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.writePingFrame$okhttp():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0058, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean close(int r8, java.lang.String r9, long r10) {
        /*
            r7 = this;
            monitor-enter(r7)
            okhttp3.internal.ws.WebSocketProtocol r0 = okhttp3.internal.ws.WebSocketProtocol.INSTANCE     // Catch:{ all -> 0x0059 }
            r0.validateCloseCode(r8)     // Catch:{ all -> 0x0059 }
            r0 = 0
            r1 = 0
            r2 = 1
            if (r9 == 0) goto L_0x003d
            okio.ByteString$Companion r0 = okio.ByteString.Companion     // Catch:{ all -> 0x0059 }
            okio.ByteString r0 = r0.encodeUtf8(r9)     // Catch:{ all -> 0x0059 }
            int r3 = r0.size()     // Catch:{ all -> 0x0059 }
            long r3 = (long) r3     // Catch:{ all -> 0x0059 }
            r5 = 123(0x7b, double:6.1E-322)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x001e
            r3 = r2
            goto L_0x001f
        L_0x001e:
            r3 = r1
        L_0x001f:
            if (r3 == 0) goto L_0x0022
            goto L_0x003d
        L_0x0022:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0059 }
            r8.<init>()     // Catch:{ all -> 0x0059 }
            java.lang.String r10 = "reason.size() > 123: "
            r8.append(r10)     // Catch:{ all -> 0x0059 }
            r8.append(r9)     // Catch:{ all -> 0x0059 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0059 }
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0059 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0059 }
            r9.<init>(r8)     // Catch:{ all -> 0x0059 }
            throw r9     // Catch:{ all -> 0x0059 }
        L_0x003d:
            boolean r9 = r7.failed     // Catch:{ all -> 0x0059 }
            if (r9 != 0) goto L_0x0057
            boolean r9 = r7.enqueuedClose     // Catch:{ all -> 0x0059 }
            if (r9 == 0) goto L_0x0046
            goto L_0x0057
        L_0x0046:
            r7.enqueuedClose = r2     // Catch:{ all -> 0x0059 }
            java.util.ArrayDeque<java.lang.Object> r9 = r7.messageAndCloseQueue     // Catch:{ all -> 0x0059 }
            okhttp3.internal.ws.RealWebSocket$Close r1 = new okhttp3.internal.ws.RealWebSocket$Close     // Catch:{ all -> 0x0059 }
            r1.<init>(r8, r0, r10)     // Catch:{ all -> 0x0059 }
            r9.add(r1)     // Catch:{ all -> 0x0059 }
            r7.runWriter()     // Catch:{ all -> 0x0059 }
            monitor-exit(r7)
            return r2
        L_0x0057:
            monitor-exit(r7)
            return r1
        L_0x0059:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.close(int, java.lang.String, long):boolean");
    }

    public void onReadMessage(ByteString byteString) throws IOException {
        this.listener.onMessage((WebSocket) this, byteString);
    }

    public boolean send(ByteString byteString) {
        WoodPeckerWebSocketAspect.e().g(c.d(ajc$tjp_2, this, this, byteString, a.a(2)));
        return send(byteString, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized boolean send(okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.failed     // Catch:{ all -> 0x003e }
            r1 = 0
            if (r0 != 0) goto L_0x003c
            boolean r0 = r6.enqueuedClose     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000b
            goto L_0x003c
        L_0x000b:
            long r2 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r0 = r7.size()     // Catch:{ all -> 0x003e }
            long r4 = (long) r0     // Catch:{ all -> 0x003e }
            long r2 = r2 + r4
            r4 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0022
            r7 = 1001(0x3e9, float:1.403E-42)
            r8 = 0
            r6.close(r7, r8)     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            return r1
        L_0x0022:
            long r0 = r6.queueSize     // Catch:{ all -> 0x003e }
            int r2 = r7.size()     // Catch:{ all -> 0x003e }
            long r2 = (long) r2     // Catch:{ all -> 0x003e }
            long r0 = r0 + r2
            r6.queueSize = r0     // Catch:{ all -> 0x003e }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.messageAndCloseQueue     // Catch:{ all -> 0x003e }
            okhttp3.internal.ws.RealWebSocket$Message r1 = new okhttp3.internal.ws.RealWebSocket$Message     // Catch:{ all -> 0x003e }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x003e }
            r0.add(r1)     // Catch:{ all -> 0x003e }
            r6.runWriter()     // Catch:{ all -> 0x003e }
            r7 = 1
            monitor-exit(r6)
            return r7
        L_0x003c:
            monitor-exit(r6)
            return r1
        L_0x003e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.send(okio.ByteString, int):boolean");
    }
}
