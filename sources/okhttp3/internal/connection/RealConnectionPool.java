package okhttp3.internal.connection;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.r;
import okhttp3.ConnectionPool;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;

public final class RealConnectionPool {
    public static final Companion Companion = new Companion((r) null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask = new RealConnectionPool$cleanupTask$1(this, Util.okHttpName + " ConnectionPool");
    private final ConcurrentLinkedQueue<RealConnection> connections = new ConcurrentLinkedQueue<>();
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            return connectionPool.getDelegate$okhttp();
        }
    }

    public RealConnectionPool(TaskRunner taskRunner, int i11, long j11, TimeUnit timeUnit) {
        this.maxIdleConnections = i11;
        this.keepAliveDurationNs = timeUnit.toNanos(j11);
        this.cleanupQueue = taskRunner.newQueue();
        if (!(j11 > 0)) {
            throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j11).toString());
        }
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j11) {
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            List<Reference<RealCall>> calls = realConnection.getCalls();
            int i11 = 0;
            while (i11 < calls.size()) {
                Reference reference = calls.get(i11);
                if (reference.get() != null) {
                    i11++;
                } else {
                    Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                    calls.remove(i11);
                    realConnection.setNoNewExchanges(true);
                    if (calls.isEmpty()) {
                        realConnection.setIdleAtNs$okhttp(j11 - this.keepAliveDurationNs);
                        return 0;
                    }
                }
            }
            return calls.size();
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r1.isMultiplexed$okhttp() != false) goto L_0x001b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean callAcquirePooledConnection(okhttp3.Address r4, okhttp3.internal.connection.RealCall r5, java.util.List<okhttp3.Route> r6, boolean r7) {
        /*
            r3 = this;
            java.util.concurrent.ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> r0 = r3.connections
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r0.next()
            okhttp3.internal.connection.RealConnection r1 = (okhttp3.internal.connection.RealConnection) r1
            monitor-enter(r1)
            if (r7 == 0) goto L_0x001b
            boolean r2 = r1.isMultiplexed$okhttp()     // Catch:{ all -> 0x002b }
            if (r2 == 0) goto L_0x0027
        L_0x001b:
            boolean r2 = r1.isEligible$okhttp(r4, r6)     // Catch:{ all -> 0x002b }
            if (r2 == 0) goto L_0x0027
            r5.acquireConnectionNoEvents(r1)     // Catch:{ all -> 0x002b }
            r4 = 1
            monitor-exit(r1)
            return r4
        L_0x0027:
            kotlin.Unit r2 = kotlin.Unit.f56620a     // Catch:{ all -> 0x002b }
            monitor-exit(r1)
            goto L_0x0006
        L_0x002b:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        L_0x002e:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnectionPool.callAcquirePooledConnection(okhttp3.Address, okhttp3.internal.connection.RealCall, java.util.List, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0072, code lost:
        okhttp3.internal.Util.closeQuietly(r3.socket());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007f, code lost:
        if (r10.connections.isEmpty() == false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0081, code lost:
        r10.cleanupQueue.cancelAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0086, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long cleanup(long r11) {
        /*
            r10 = this;
            java.util.concurrent.ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> r0 = r10.connections
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
            r2 = 0
            r3 = -9223372036854775808
            r4 = r3
            r3 = r2
            r2 = r1
        L_0x000d:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0038
            java.lang.Object r6 = r0.next()
            okhttp3.internal.connection.RealConnection r6 = (okhttp3.internal.connection.RealConnection) r6
            monitor-enter(r6)
            int r7 = r10.pruneAndGetAllocationCount(r6, r11)     // Catch:{ all -> 0x0035 }
            if (r7 <= 0) goto L_0x0023
            int r2 = r2 + 1
            goto L_0x0033
        L_0x0023:
            int r1 = r1 + 1
            long r7 = r6.getIdleAtNs$okhttp()     // Catch:{ all -> 0x0035 }
            long r7 = r11 - r7
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 <= 0) goto L_0x0031
            r3 = r6
            r4 = r7
        L_0x0031:
            kotlin.Unit r7 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0035 }
        L_0x0033:
            monitor-exit(r6)
            goto L_0x000d
        L_0x0035:
            r11 = move-exception
            monitor-exit(r6)
            throw r11
        L_0x0038:
            long r6 = r10.keepAliveDurationNs
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x004d
            int r0 = r10.maxIdleConnections
            if (r1 <= r0) goto L_0x0043
            goto L_0x004d
        L_0x0043:
            if (r1 <= 0) goto L_0x0047
            long r6 = r6 - r4
            return r6
        L_0x0047:
            if (r2 <= 0) goto L_0x004a
            return r6
        L_0x004a:
            r11 = -1
            return r11
        L_0x004d:
            monitor-enter(r3)
            java.util.List r0 = r3.getCalls()     // Catch:{ all -> 0x0087 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0087 }
            r1 = 1
            r0 = r0 ^ r1
            r6 = 0
            if (r0 == 0) goto L_0x005e
            monitor-exit(r3)
            return r6
        L_0x005e:
            long r8 = r3.getIdleAtNs$okhttp()     // Catch:{ all -> 0x0087 }
            long r8 = r8 + r4
            int r11 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r11 == 0) goto L_0x0069
            monitor-exit(r3)
            return r6
        L_0x0069:
            r3.setNoNewExchanges(r1)     // Catch:{ all -> 0x0087 }
            java.util.concurrent.ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> r11 = r10.connections     // Catch:{ all -> 0x0087 }
            r11.remove(r3)     // Catch:{ all -> 0x0087 }
            monitor-exit(r3)
            java.net.Socket r11 = r3.socket()
            okhttp3.internal.Util.closeQuietly((java.net.Socket) r11)
            java.util.concurrent.ConcurrentLinkedQueue<okhttp3.internal.connection.RealConnection> r11 = r10.connections
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x0086
            okhttp3.internal.concurrent.TaskQueue r11 = r10.cleanupQueue
            r11.cancelAll()
        L_0x0086:
            return r6
        L_0x0087:
            r11 = move-exception
            monitor-exit(r3)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnectionPool.cleanup(long):long");
    }

    public final boolean connectionBecameIdle(RealConnection realConnection) {
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
        } else if (realConnection.getNoNewExchanges() || this.maxIdleConnections == 0) {
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            if (!this.connections.isEmpty()) {
                return true;
            }
            this.cleanupQueue.cancelAll();
            return true;
        } else {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
            return false;
        }
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it2 = this.connections.iterator();
        while (it2.hasNext()) {
            RealConnection next = it2.next();
            synchronized (next) {
                if (next.getCalls().isEmpty()) {
                    it2.remove();
                    next.setNoNewExchanges(true);
                    socket = next.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                Util.closeQuietly(socket);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final int idleConnectionCount() {
        boolean isEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i11 = 0;
        if (!(concurrentLinkedQueue instanceof Collection) || !concurrentLinkedQueue.isEmpty()) {
            for (RealConnection realConnection : concurrentLinkedQueue) {
                synchronized (realConnection) {
                    isEmpty = realConnection.getCalls().isEmpty();
                }
                if (isEmpty && (i11 = i11 + 1) < 0) {
                    CollectionsKt__CollectionsKt.s();
                }
            }
        }
        return i11;
    }

    public final void put(RealConnection realConnection) {
        if (!Util.assertionsEnabled || Thread.holdsLock(realConnection)) {
            this.connections.add(realConnection);
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, (Object) null);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + realConnection);
    }
}
