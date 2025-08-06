package okhttp3.internal.http2;

import d10.a;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskQueue$execute$1;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2Reader;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class Http2Connection implements Closeable {
    public static final int AWAIT_PING = 3;
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static final Settings DEFAULT_SETTINGS;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    /* access modifiers changed from: private */
    public long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    /* access modifiers changed from: private */
    public final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    /* access modifiers changed from: private */
    public long degradedPongsReceived;
    /* access modifiers changed from: private */
    public long intervalPingsSent;
    /* access modifiers changed from: private */
    public long intervalPongsReceived;
    /* access modifiers changed from: private */
    public boolean isShutdown;
    private int lastGoodStreamId;
    private final Listener listener;
    private int nextStreamId;
    private final Settings okHttpSettings;
    private Settings peerSettings;
    /* access modifiers changed from: private */
    public final PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final ReaderRunnable readerRunnable;
    /* access modifiers changed from: private */
    public final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, Http2Stream> streams = new LinkedHashMap();
    /* access modifiers changed from: private */
    public final TaskRunner taskRunner;
    /* access modifiers changed from: private */
    public long writeBytesMaximum;
    private long writeBytesTotal;
    private final Http2Writer writer;
    /* access modifiers changed from: private */
    public final TaskQueue writerQueue;

    public static final class Builder {
        private boolean client;
        public String connectionName;
        private Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        private int pingIntervalMillis;
        private PushObserver pushObserver = PushObserver.CANCEL;
        public BufferedSink sink;
        public Socket socket;
        public BufferedSource source;
        private final TaskRunner taskRunner;

        public Builder(boolean z11, TaskRunner taskRunner2) {
            this.client = z11;
            this.taskRunner = taskRunner2;
        }

        public static /* synthetic */ Builder socket$default(Builder builder, Socket socket2, String str, BufferedSource bufferedSource, BufferedSink bufferedSink, int i11, Object obj) throws IOException {
            if ((i11 & 2) != 0) {
                str = Util.peerName(socket2);
            }
            if ((i11 & 4) != 0) {
                bufferedSource = Okio.buffer(Okio.source(socket2));
            }
            if ((i11 & 8) != 0) {
                bufferedSink = Okio.buffer(Okio.sink(socket2));
            }
            return builder.socket(socket2, str, bufferedSource, bufferedSink);
        }

        public final Http2Connection build() {
            return new Http2Connection(this);
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final String getConnectionName$okhttp() {
            String str = this.connectionName;
            if (str != null) {
                return str;
            }
            return null;
        }

        public final Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final BufferedSink getSink$okhttp() {
            BufferedSink bufferedSink = this.sink;
            if (bufferedSink != null) {
                return bufferedSink;
            }
            return null;
        }

        public final Socket getSocket$okhttp() {
            Socket socket2 = this.socket;
            if (socket2 != null) {
                return socket2;
            }
            return null;
        }

        public final BufferedSource getSource$okhttp() {
            BufferedSource bufferedSource = this.source;
            if (bufferedSource != null) {
                return bufferedSource;
            }
            return null;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final Builder listener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public final Builder pingIntervalMillis(int i11) {
            this.pingIntervalMillis = i11;
            return this;
        }

        public final Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public final void setClient$okhttp(boolean z11) {
            this.client = z11;
        }

        public final void setConnectionName$okhttp(String str) {
            this.connectionName = str;
        }

        public final void setListener$okhttp(Listener listener2) {
            this.listener = listener2;
        }

        public final void setPingIntervalMillis$okhttp(int i11) {
            this.pingIntervalMillis = i11;
        }

        public final void setPushObserver$okhttp(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
        }

        public final void setSink$okhttp(BufferedSink bufferedSink) {
            this.sink = bufferedSink;
        }

        public final void setSocket$okhttp(Socket socket2) {
            this.socket = socket2;
        }

        public final void setSource$okhttp(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        public final Builder socket(Socket socket2) throws IOException {
            return socket$default(this, socket2, (String) null, (BufferedSource) null, (BufferedSink) null, 14, (Object) null);
        }

        public final Builder socket(Socket socket2, String str) throws IOException {
            return socket$default(this, socket2, str, (BufferedSource) null, (BufferedSink) null, 12, (Object) null);
        }

        public final Builder socket(Socket socket2, String str, BufferedSource bufferedSource) throws IOException {
            return socket$default(this, socket2, str, bufferedSource, (BufferedSink) null, 8, (Object) null);
        }

        public final Builder socket(Socket socket2, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) throws IOException {
            String str2;
            setSocket$okhttp(socket2);
            if (this.client) {
                str2 = Util.okHttpName + ' ' + str;
            } else {
                str2 = "MockWebServer " + str;
            }
            setConnectionName$okhttp(str2);
            setSource$okhttp(bufferedSource);
            setSink$okhttp(bufferedSink);
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final Settings getDEFAULT_SETTINGS() {
            return Http2Connection.DEFAULT_SETTINGS;
        }
    }

    public static abstract class Listener {
        public static final Companion Companion = new Companion((r) null);
        public static final Listener REFUSE_INCOMING_STREAMS = new Http2Connection$Listener$Companion$REFUSE_INCOMING_STREAMS$1();

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(r rVar) {
                this();
            }
        }

        public void onSettings(Http2Connection http2Connection, Settings settings) {
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    public final class ReaderRunnable implements Http2Reader.Handler, a<Unit> {
        private final Http2Reader reader;

        public ReaderRunnable(Http2Reader http2Reader) {
            this.reader = http2Reader;
        }

        public void ackSettings() {
        }

        public void alternateService(int i11, String str, ByteString byteString, String str2, int i12, long j11) {
        }

        public final void applyAndAckSettings(boolean z11, T t11) {
            long initialWindowSize;
            int i11;
            Http2Stream[] http2StreamArr;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Http2Writer writer = Http2Connection.this.getWriter();
            Http2Connection http2Connection = Http2Connection.this;
            synchronized (writer) {
                synchronized (http2Connection) {
                    Settings peerSettings = http2Connection.getPeerSettings();
                    if (!z11) {
                        T settings = new Settings();
                        settings.merge(peerSettings);
                        settings.merge(t11);
                        t11 = settings;
                    }
                    ref$ObjectRef.element = t11;
                    initialWindowSize = ((long) t11.getInitialWindowSize()) - ((long) peerSettings.getInitialWindowSize());
                    if (initialWindowSize != 0) {
                        if (!http2Connection.getStreams$okhttp().isEmpty()) {
                            http2StreamArr = (Http2Stream[]) http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                            http2Connection.setPeerSettings((Settings) ref$ObjectRef.element);
                            http2Connection.settingsListenerQueue.schedule(new Http2Connection$ReaderRunnable$applyAndAckSettings$lambda$7$lambda$6$$inlined$execute$default$1(http2Connection.getConnectionName$okhttp() + " onSettings", true, http2Connection, ref$ObjectRef), 0);
                            Unit unit = Unit.f56620a;
                        }
                    }
                    http2StreamArr = null;
                    http2Connection.setPeerSettings((Settings) ref$ObjectRef.element);
                    http2Connection.settingsListenerQueue.schedule(new Http2Connection$ReaderRunnable$applyAndAckSettings$lambda$7$lambda$6$$inlined$execute$default$1(http2Connection.getConnectionName$okhttp() + " onSettings", true, http2Connection, ref$ObjectRef), 0);
                    Unit unit2 = Unit.f56620a;
                }
                try {
                    http2Connection.getWriter().applyAndAckSettings((Settings) ref$ObjectRef.element);
                } catch (IOException e11) {
                    http2Connection.failConnection(e11);
                }
                Unit unit3 = Unit.f56620a;
            }
            if (http2StreamArr != null) {
                for (Http2Stream http2Stream : http2StreamArr) {
                    synchronized (http2Stream) {
                        http2Stream.addBytesToWriteWindow(initialWindowSize);
                        Unit unit4 = Unit.f56620a;
                    }
                }
            }
        }

        public void data(boolean z11, int i11, BufferedSource bufferedSource, int i12) throws IOException {
            if (Http2Connection.this.pushedStream$okhttp(i11)) {
                Http2Connection.this.pushDataLater$okhttp(i11, bufferedSource, i12, z11);
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i11);
            if (stream == null) {
                Http2Connection.this.writeSynResetLater$okhttp(i11, ErrorCode.PROTOCOL_ERROR);
                long j11 = (long) i12;
                Http2Connection.this.updateConnectionFlowControl$okhttp(j11);
                bufferedSource.skip(j11);
                return;
            }
            stream.receiveData(bufferedSource, i12);
            if (z11) {
                stream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        public final Http2Reader getReader$okhttp() {
            return this.reader;
        }

        public void goAway(int i11, ErrorCode errorCode, ByteString byteString) {
            int i12;
            Object[] array;
            byteString.size();
            Http2Connection http2Connection = Http2Connection.this;
            synchronized (http2Connection) {
                array = http2Connection.getStreams$okhttp().values().toArray(new Http2Stream[0]);
                http2Connection.isShutdown = true;
                Unit unit = Unit.f56620a;
            }
            for (Http2Stream http2Stream : (Http2Stream[]) array) {
                if (http2Stream.getId() > i11 && http2Stream.isLocallyInitiated()) {
                    http2Stream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.removeStream$okhttp(http2Stream.getId());
                }
            }
        }

        public void headers(boolean z11, int i11, int i12, List<Header> list) {
            if (Http2Connection.this.pushedStream$okhttp(i11)) {
                Http2Connection.this.pushHeadersLater$okhttp(i11, list, z11);
                return;
            }
            Http2Connection http2Connection = Http2Connection.this;
            synchronized (http2Connection) {
                Http2Stream stream = http2Connection.getStream(i11);
                if (stream != null) {
                    Unit unit = Unit.f56620a;
                    stream.receiveHeaders(Util.toHeaders(list), z11);
                } else if (!http2Connection.isShutdown) {
                    if (i11 > http2Connection.getLastGoodStreamId$okhttp()) {
                        if (i11 % 2 != http2Connection.getNextStreamId$okhttp() % 2) {
                            Http2Stream http2Stream = new Http2Stream(i11, http2Connection, false, z11, Util.toHeaders(list));
                            http2Connection.setLastGoodStreamId$okhttp(i11);
                            http2Connection.getStreams$okhttp().put(Integer.valueOf(i11), http2Stream);
                            TaskQueue newQueue = http2Connection.taskRunner.newQueue();
                            newQueue.schedule(new Http2Connection$ReaderRunnable$headers$lambda$2$$inlined$execute$default$1(http2Connection.getConnectionName$okhttp() + '[' + i11 + "] onStream", true, http2Connection, http2Stream), 0);
                        }
                    }
                }
            }
        }

        public void ping(boolean z11, int i11, int i12) {
            if (z11) {
                Http2Connection http2Connection = Http2Connection.this;
                synchronized (http2Connection) {
                    if (i11 == 1) {
                        http2Connection.intervalPongsReceived = http2Connection.intervalPongsReceived + 1;
                    } else if (i11 != 2) {
                        if (i11 == 3) {
                            http2Connection.awaitPongsReceived = http2Connection.awaitPongsReceived + 1;
                            http2Connection.notifyAll();
                        }
                        Unit unit = Unit.f56620a;
                    } else {
                        http2Connection.degradedPongsReceived = http2Connection.degradedPongsReceived + 1;
                    }
                }
                return;
            }
            TaskQueue access$getWriterQueue$p = Http2Connection.this.writerQueue;
            access$getWriterQueue$p.schedule(new Http2Connection$ReaderRunnable$ping$$inlined$execute$default$1(Http2Connection.this.getConnectionName$okhttp() + " ping", true, Http2Connection.this, i11, i12), 0);
        }

        public void priority(int i11, int i12, int i13, boolean z11) {
        }

        public void pushPromise(int i11, int i12, List<Header> list) {
            Http2Connection.this.pushRequestLater$okhttp(i12, list);
        }

        public void rstStream(int i11, ErrorCode errorCode) {
            if (Http2Connection.this.pushedStream$okhttp(i11)) {
                Http2Connection.this.pushResetLater$okhttp(i11, errorCode);
                return;
            }
            Http2Stream removeStream$okhttp = Http2Connection.this.removeStream$okhttp(i11);
            if (removeStream$okhttp != null) {
                removeStream$okhttp.receiveRstStream(errorCode);
            }
        }

        public void settings(boolean z11, Settings settings) {
            TaskQueue access$getWriterQueue$p = Http2Connection.this.writerQueue;
            access$getWriterQueue$p.schedule(new Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1(Http2Connection.this.getConnectionName$okhttp() + " applyAndAckSettings", true, this, z11, settings), 0);
        }

        public void windowUpdate(int i11, long j11) {
            if (i11 == 0) {
                Http2Connection http2Connection = Http2Connection.this;
                synchronized (http2Connection) {
                    http2Connection.writeBytesMaximum = http2Connection.getWriteBytesMaximum() + j11;
                    http2Connection.notifyAll();
                    Unit unit = Unit.f56620a;
                }
                return;
            }
            Http2Stream stream = Http2Connection.this.getStream(i11);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j11);
                    Unit unit2 = Unit.f56620a;
                }
            }
        }

        public void invoke() {
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            e = null;
            try {
                this.reader.readConnectionPreface(this);
                do {
                } while (this.reader.nextFrame(false, this));
                errorCode = ErrorCode.NO_ERROR;
                try {
                    Http2Connection.this.close$okhttp(errorCode, ErrorCode.CANCEL, (IOException) null);
                } catch (IOException e11) {
                    e = e11;
                    try {
                        ErrorCode errorCode3 = ErrorCode.PROTOCOL_ERROR;
                        Http2Connection.this.close$okhttp(errorCode3, errorCode3, e);
                        Util.closeQuietly((Closeable) this.reader);
                    } catch (Throwable th2) {
                        th = th2;
                        Http2Connection.this.close$okhttp(errorCode, errorCode2, e);
                        Util.closeQuietly((Closeable) this.reader);
                        throw th;
                    }
                }
            } catch (IOException e12) {
                e = e12;
                errorCode = errorCode2;
                ErrorCode errorCode32 = ErrorCode.PROTOCOL_ERROR;
                Http2Connection.this.close$okhttp(errorCode32, errorCode32, e);
                Util.closeQuietly((Closeable) this.reader);
            } catch (Throwable th3) {
                th = th3;
                errorCode = errorCode2;
                Http2Connection.this.close$okhttp(errorCode, errorCode2, e);
                Util.closeQuietly((Closeable) this.reader);
                throw th;
            }
            Util.closeQuietly((Closeable) this.reader);
        }
    }

    static {
        Settings settings = new Settings();
        settings.set(7, 65535);
        settings.set(5, 16384);
        DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(Builder builder) {
        boolean client$okhttp = builder.getClient$okhttp();
        this.client = client$okhttp;
        this.listener = builder.getListener$okhttp();
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        this.nextStreamId = builder.getClient$okhttp() ? 3 : 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        TaskQueue newQueue = taskRunner$okhttp.newQueue();
        this.writerQueue = newQueue;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(7, 16777216);
        }
        this.okHttpSettings = settings;
        Settings settings2 = DEFAULT_SETTINGS;
        this.peerSettings = settings2;
        this.writeBytesMaximum = (long) settings2.getInitialWindowSize();
        this.socket = builder.getSocket$okhttp();
        this.writer = new Http2Writer(builder.getSink$okhttp(), client$okhttp);
        this.readerRunnable = new ReaderRunnable(new Http2Reader(builder.getSource$okhttp(), client$okhttp));
        this.currentPushRequests = new LinkedHashSet();
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos((long) builder.getPingIntervalMillis$okhttp());
            newQueue.schedule(new Http2Connection$special$$inlined$schedule$1(connectionName$okhttp + " ping", this, nanos), nanos);
        }
    }

    /* access modifiers changed from: private */
    public final void failConnection(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(errorCode, errorCode, iOException);
    }

    public static /* synthetic */ void start$default(Http2Connection http2Connection, boolean z11, TaskRunner taskRunner2, int i11, Object obj) throws IOException {
        if ((i11 & 1) != 0) {
            z11 = true;
        }
        if ((i11 & 2) != 0) {
            taskRunner2 = TaskRunner.INSTANCE;
        }
        http2Connection.start(z11, taskRunner2);
    }

    public final synchronized void awaitPong() throws InterruptedException {
        while (this.awaitPongsReceived < this.awaitPingsSent) {
            wait();
        }
    }

    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, (IOException) null);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x006a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void close$okhttp(okhttp3.internal.http2.ErrorCode r4, okhttp3.internal.http2.ErrorCode r5, java.io.IOException r6) {
        /*
            r3 = this;
            boolean r0 = okhttp3.internal.Util.assertionsEnabled
            if (r0 == 0) goto L_0x0032
            boolean r0 = java.lang.Thread.holdsLock(r3)
            if (r0 != 0) goto L_0x000b
            goto L_0x0032
        L_0x000b:
            java.lang.AssertionError r4 = new java.lang.AssertionError
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Thread "
            r5.append(r6)
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            java.lang.String r6 = r6.getName()
            r5.append(r6)
            java.lang.String r6 = " MUST NOT hold lock on "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        L_0x0032:
            r3.shutdown(r4)     // Catch:{ IOException -> 0x0035 }
        L_0x0035:
            r4 = 0
            monitor-enter(r3)
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r0 = r3.streams     // Catch:{ all -> 0x007f }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x007f }
            r0 = r0 ^ 1
            r1 = 0
            if (r0 == 0) goto L_0x0053
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r4 = r3.streams     // Catch:{ all -> 0x007f }
            java.util.Collection r4 = r4.values()     // Catch:{ all -> 0x007f }
            okhttp3.internal.http2.Http2Stream[] r0 = new okhttp3.internal.http2.Http2Stream[r1]     // Catch:{ all -> 0x007f }
            java.lang.Object[] r4 = r4.toArray(r0)     // Catch:{ all -> 0x007f }
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r0 = r3.streams     // Catch:{ all -> 0x007f }
            r0.clear()     // Catch:{ all -> 0x007f }
        L_0x0053:
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x007f }
            monitor-exit(r3)
            okhttp3.internal.http2.Http2Stream[] r4 = (okhttp3.internal.http2.Http2Stream[]) r4
            if (r4 == 0) goto L_0x0065
            int r0 = r4.length
        L_0x005b:
            if (r1 >= r0) goto L_0x0065
            r2 = r4[r1]
            r2.close(r5, r6)     // Catch:{ IOException -> 0x0062 }
        L_0x0062:
            int r1 = r1 + 1
            goto L_0x005b
        L_0x0065:
            okhttp3.internal.http2.Http2Writer r4 = r3.writer     // Catch:{ IOException -> 0x006a }
            r4.close()     // Catch:{ IOException -> 0x006a }
        L_0x006a:
            java.net.Socket r4 = r3.socket     // Catch:{ IOException -> 0x006f }
            r4.close()     // Catch:{ IOException -> 0x006f }
        L_0x006f:
            okhttp3.internal.concurrent.TaskQueue r4 = r3.writerQueue
            r4.shutdown()
            okhttp3.internal.concurrent.TaskQueue r4 = r3.pushQueue
            r4.shutdown()
            okhttp3.internal.concurrent.TaskQueue r4 = r3.settingsListenerQueue
            r4.shutdown()
            return
        L_0x007f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.close$okhttp(okhttp3.internal.http2.ErrorCode, okhttp3.internal.http2.ErrorCode, java.io.IOException):void");
    }

    public final void flush() throws IOException {
        this.writer.flush();
    }

    public final boolean getClient$okhttp() {
        return this.client;
    }

    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    public final Listener getListener$okhttp() {
        return this.listener;
    }

    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    public final Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    public final Settings getPeerSettings() {
        return this.peerSettings;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    public final synchronized Http2Stream getStream(int i11) {
        return this.streams.get(Integer.valueOf(i11));
    }

    public final Map<Integer, Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final Http2Writer getWriter() {
        return this.writer;
    }

    public final synchronized boolean isHealthy(long j11) {
        if (this.isShutdown) {
            return false;
        }
        if (this.degradedPongsReceived >= this.degradedPingsSent || j11 < this.degradedPongDeadlineNs) {
            return true;
        }
        return false;
    }

    public final Http2Stream newStream(List<Header> list, boolean z11) throws IOException {
        return newStream(0, list, z11);
    }

    public final synchronized int openStreamCount() {
        return this.streams.size();
    }

    public final void pushDataLater$okhttp(int i11, BufferedSource bufferedSource, int i12, boolean z11) throws IOException {
        Buffer buffer = new Buffer();
        long j11 = (long) i12;
        bufferedSource.require(j11);
        bufferedSource.read(buffer, j11);
        TaskQueue taskQueue = this.pushQueue;
        taskQueue.schedule(new Http2Connection$pushDataLater$$inlined$execute$default$1(this.connectionName + '[' + i11 + "] onData", true, this, i11, buffer, i12, z11), 0);
    }

    public final void pushHeadersLater$okhttp(int i11, List<Header> list, boolean z11) {
        TaskQueue taskQueue = this.pushQueue;
        taskQueue.schedule(new Http2Connection$pushHeadersLater$$inlined$execute$default$1(this.connectionName + '[' + i11 + "] onHeaders", true, this, i11, list, z11), 0);
    }

    public final void pushRequestLater$okhttp(int i11, List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i11))) {
                writeSynResetLater$okhttp(i11, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i11));
            TaskQueue taskQueue = this.pushQueue;
            taskQueue.schedule(new Http2Connection$pushRequestLater$$inlined$execute$default$1(this.connectionName + '[' + i11 + "] onRequest", true, this, i11, list), 0);
        }
    }

    public final void pushResetLater$okhttp(int i11, ErrorCode errorCode) {
        TaskQueue taskQueue = this.pushQueue;
        taskQueue.schedule(new Http2Connection$pushResetLater$$inlined$execute$default$1(this.connectionName + '[' + i11 + "] onReset", true, this, i11, errorCode), 0);
    }

    public final Http2Stream pushStream(int i11, List<Header> list, boolean z11) throws IOException {
        if (!this.client) {
            return newStream(i11, list, z11);
        }
        throw new IllegalStateException("Client cannot push requests.".toString());
    }

    public final boolean pushedStream$okhttp(int i11) {
        return i11 != 0 && (i11 & 1) == 0;
    }

    public final synchronized Http2Stream removeStream$okhttp(int i11) {
        Http2Stream remove;
        remove = this.streams.remove(Integer.valueOf(i11));
        notifyAll();
        return remove;
    }

    public final void sendDegradedPingLater$okhttp() {
        synchronized (this) {
            long j11 = this.degradedPongsReceived;
            long j12 = this.degradedPingsSent;
            if (j11 >= j12) {
                this.degradedPingsSent = j12 + 1;
                this.degradedPongDeadlineNs = System.nanoTime() + ((long) 1000000000);
                Unit unit = Unit.f56620a;
                TaskQueue taskQueue = this.writerQueue;
                taskQueue.schedule(new Http2Connection$sendDegradedPingLater$$inlined$execute$default$1(this.connectionName + " ping", true, this), 0);
            }
        }
    }

    public final void setLastGoodStreamId$okhttp(int i11) {
        this.lastGoodStreamId = i11;
    }

    public final void setNextStreamId$okhttp(int i11) {
        this.nextStreamId = i11;
    }

    public final void setPeerSettings(Settings settings) {
        this.peerSettings = settings;
    }

    public final void setSettings(Settings settings) throws IOException {
        synchronized (this.writer) {
            synchronized (this) {
                if (!this.isShutdown) {
                    this.okHttpSettings.merge(settings);
                    Unit unit = Unit.f56620a;
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            this.writer.settings(settings);
        }
    }

    public final void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.writer) {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            synchronized (this) {
                if (!this.isShutdown) {
                    this.isShutdown = true;
                    int i11 = this.lastGoodStreamId;
                    ref$IntRef.element = i11;
                    Unit unit = Unit.f56620a;
                    this.writer.goAway(i11, errorCode, Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public final void start() throws IOException {
        start$default(this, false, (TaskRunner) null, 3, (Object) null);
    }

    public final void start(boolean z11) throws IOException {
        start$default(this, z11, (TaskRunner) null, 2, (Object) null);
    }

    public final void start(boolean z11, TaskRunner taskRunner2) throws IOException {
        if (z11) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            int initialWindowSize = this.okHttpSettings.getInitialWindowSize();
            if (initialWindowSize != 65535) {
                this.writer.windowUpdate(0, (long) (initialWindowSize - 65535));
            }
        }
        taskRunner2.newQueue().schedule(new TaskQueue$execute$1(this.connectionName, true, this.readerRunnable), 0);
    }

    public final synchronized void updateConnectionFlowControl$okhttp(long j11) {
        long j12 = this.readBytesTotal + j11;
        this.readBytesTotal = j12;
        long j13 = j12 - this.readBytesAcknowledged;
        if (j13 >= ((long) (this.okHttpSettings.getInitialWindowSize() / 2))) {
            writeWindowUpdateLater$okhttp(0, j13);
            this.readBytesAcknowledged += j13;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:27|28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.writer.maxDataLength());
        r6 = (long) r2;
        r8.writeBytesTotal += r6;
        r4 = kotlin.Unit.f56620a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0069, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void writeData(int r9, boolean r10, okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto L_0x000d
            okhttp3.internal.http2.Http2Writer r12 = r8.writer
            r12.data(r10, r9, r11, r3)
            return
        L_0x000d:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x006c
            monitor-enter(r8)
        L_0x0012:
            long r4 = r8.writeBytesTotal     // Catch:{ InterruptedException -> 0x005d }
            long r6 = r8.writeBytesMaximum     // Catch:{ InterruptedException -> 0x005d }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0032
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r2 = r8.streams     // Catch:{ InterruptedException -> 0x005d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x005d }
            boolean r2 = r2.containsKey(r4)     // Catch:{ InterruptedException -> 0x005d }
            if (r2 == 0) goto L_0x002a
            r8.wait()     // Catch:{ InterruptedException -> 0x005d }
            goto L_0x0012
        L_0x002a:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005d }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x005d }
            throw r9     // Catch:{ InterruptedException -> 0x005d }
        L_0x0032:
            long r6 = r6 - r4
            long r4 = java.lang.Math.min(r12, r6)     // Catch:{ all -> 0x005b }
            int r2 = (int) r4     // Catch:{ all -> 0x005b }
            okhttp3.internal.http2.Http2Writer r4 = r8.writer     // Catch:{ all -> 0x005b }
            int r4 = r4.maxDataLength()     // Catch:{ all -> 0x005b }
            int r2 = java.lang.Math.min(r2, r4)     // Catch:{ all -> 0x005b }
            long r4 = r8.writeBytesTotal     // Catch:{ all -> 0x005b }
            long r6 = (long) r2     // Catch:{ all -> 0x005b }
            long r4 = r4 + r6
            r8.writeBytesTotal = r4     // Catch:{ all -> 0x005b }
            kotlin.Unit r4 = kotlin.Unit.f56620a     // Catch:{ all -> 0x005b }
            monitor-exit(r8)
            long r12 = r12 - r6
            okhttp3.internal.http2.Http2Writer r4 = r8.writer
            if (r10 == 0) goto L_0x0056
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L_0x0056
            r5 = 1
            goto L_0x0057
        L_0x0056:
            r5 = r3
        L_0x0057:
            r4.data(r5, r9, r11, r2)
            goto L_0x000d
        L_0x005b:
            r9 = move-exception
            goto L_0x006a
        L_0x005d:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x005b }
            r9.interrupt()     // Catch:{ all -> 0x005b }
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x005b }
            r9.<init>()     // Catch:{ all -> 0x005b }
            throw r9     // Catch:{ all -> 0x005b }
        L_0x006a:
            monitor-exit(r8)
            throw r9
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.writeData(int, boolean, okio.Buffer, long):void");
    }

    public final void writeHeaders$okhttp(int i11, boolean z11, List<Header> list) throws IOException {
        this.writer.headers(z11, i11, list);
    }

    public final void writePing(boolean z11, int i11, int i12) {
        try {
            this.writer.ping(z11, i11, i12);
        } catch (IOException e11) {
            failConnection(e11);
        }
    }

    public final void writePingAndAwaitPong() throws InterruptedException {
        writePing();
        awaitPong();
    }

    public final void writeSynReset$okhttp(int i11, ErrorCode errorCode) throws IOException {
        this.writer.rstStream(i11, errorCode);
    }

    public final void writeSynResetLater$okhttp(int i11, ErrorCode errorCode) {
        TaskQueue taskQueue = this.writerQueue;
        taskQueue.schedule(new Http2Connection$writeSynResetLater$$inlined$execute$default$1(this.connectionName + '[' + i11 + "] writeSynReset", true, this, i11, errorCode), 0);
    }

    public final void writeWindowUpdateLater$okhttp(int i11, long j11) {
        TaskQueue taskQueue = this.writerQueue;
        taskQueue.schedule(new Http2Connection$writeWindowUpdateLater$$inlined$execute$default$1(this.connectionName + '[' + i11 + "] windowUpdate", true, this, i11, j11), 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final okhttp3.internal.http2.Http2Stream newStream(int r11, java.util.List<okhttp3.internal.http2.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            okhttp3.internal.http2.Http2Writer r7 = r10.writer
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x0084 }
            int r0 = r10.nextStreamId     // Catch:{ all -> 0x0081 }
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L_0x0013
            okhttp3.internal.http2.ErrorCode r0 = okhttp3.internal.http2.ErrorCode.REFUSED_STREAM     // Catch:{ all -> 0x0081 }
            r10.shutdown(r0)     // Catch:{ all -> 0x0081 }
        L_0x0013:
            boolean r0 = r10.isShutdown     // Catch:{ all -> 0x0081 }
            if (r0 != 0) goto L_0x007b
            int r8 = r10.nextStreamId     // Catch:{ all -> 0x0081 }
            int r0 = r8 + 2
            r10.nextStreamId = r0     // Catch:{ all -> 0x0081 }
            okhttp3.internal.http2.Http2Stream r9 = new okhttp3.internal.http2.Http2Stream     // Catch:{ all -> 0x0081 }
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0081 }
            r0 = 1
            if (r13 == 0) goto L_0x0041
            long r1 = r10.writeBytesTotal     // Catch:{ all -> 0x0081 }
            long r3 = r10.writeBytesMaximum     // Catch:{ all -> 0x0081 }
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 >= 0) goto L_0x0041
            long r1 = r9.getWriteBytesTotal()     // Catch:{ all -> 0x0081 }
            long r3 = r9.getWriteBytesMaximum()     // Catch:{ all -> 0x0081 }
            int r13 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r13 < 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r13 = 0
            goto L_0x0042
        L_0x0041:
            r13 = r0
        L_0x0042:
            boolean r1 = r9.isOpen()     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0051
            java.util.Map<java.lang.Integer, okhttp3.internal.http2.Http2Stream> r1 = r10.streams     // Catch:{ all -> 0x0081 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0081 }
            r1.put(r2, r9)     // Catch:{ all -> 0x0081 }
        L_0x0051:
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0081 }
            monitor-exit(r10)     // Catch:{ all -> 0x0084 }
            if (r11 != 0) goto L_0x005c
            okhttp3.internal.http2.Http2Writer r11 = r10.writer     // Catch:{ all -> 0x0084 }
            r11.headers(r6, r8, r12)     // Catch:{ all -> 0x0084 }
            goto L_0x0066
        L_0x005c:
            boolean r1 = r10.client     // Catch:{ all -> 0x0084 }
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x006f
            okhttp3.internal.http2.Http2Writer r0 = r10.writer     // Catch:{ all -> 0x0084 }
            r0.pushPromise(r11, r8, r12)     // Catch:{ all -> 0x0084 }
        L_0x0066:
            monitor-exit(r7)
            if (r13 == 0) goto L_0x006e
            okhttp3.internal.http2.Http2Writer r11 = r10.writer
            r11.flush()
        L_0x006e:
            return r9
        L_0x006f:
            java.lang.String r11 = "client streams shouldn't have associated stream IDs"
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0084 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0084 }
            r12.<init>(r11)     // Catch:{ all -> 0x0084 }
            throw r12     // Catch:{ all -> 0x0084 }
        L_0x007b:
            okhttp3.internal.http2.ConnectionShutdownException r11 = new okhttp3.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0081 }
            r11.<init>()     // Catch:{ all -> 0x0081 }
            throw r11     // Catch:{ all -> 0x0081 }
        L_0x0081:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0084 }
            throw r11     // Catch:{ all -> 0x0084 }
        L_0x0084:
            r11 = move-exception
            monitor-exit(r7)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.newStream(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    public final void writePing() throws InterruptedException {
        synchronized (this) {
            this.awaitPingsSent++;
        }
        writePing(false, 3, 1330343787);
    }
}
