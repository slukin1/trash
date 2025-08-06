package okhttp3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.internal.x;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;

public final class Dispatcher {
    private ExecutorService executorServiceOrNull;
    private Runnable idleCallback;
    private int maxRequests;
    private int maxRequestsPerHost;
    private final ArrayDeque<RealCall.AsyncCall> readyAsyncCalls;
    private final ArrayDeque<RealCall.AsyncCall> runningAsyncCalls;
    private final ArrayDeque<RealCall> runningSyncCalls;

    public Dispatcher() {
        this.maxRequests = 64;
        this.maxRequestsPerHost = 5;
        this.readyAsyncCalls = new ArrayDeque<>();
        this.runningAsyncCalls = new ArrayDeque<>();
        this.runningSyncCalls = new ArrayDeque<>();
    }

    private final RealCall.AsyncCall findExistingCallWithHost(String str) {
        Iterator<RealCall.AsyncCall> it2 = this.runningAsyncCalls.iterator();
        while (it2.hasNext()) {
            RealCall.AsyncCall next = it2.next();
            if (x.b(next.getHost(), str)) {
                return next;
            }
        }
        Iterator<RealCall.AsyncCall> it3 = this.readyAsyncCalls.iterator();
        while (it3.hasNext()) {
            RealCall.AsyncCall next2 = it3.next();
            if (x.b(next2.getHost(), str)) {
                return next2;
            }
        }
        return null;
    }

    private final <T> void finished(Deque<T> deque, T t11) {
        Runnable runnable;
        synchronized (this) {
            if (deque.remove(t11)) {
                runnable = this.idleCallback;
                Unit unit = Unit.f56620a;
            } else {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        if (!promoteAndExecute() && runnable != null) {
            runnable.run();
        }
    }

    private final boolean promoteAndExecute() {
        int i11;
        boolean z11;
        if (!Util.assertionsEnabled || !Thread.holdsLock(this)) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                Iterator<RealCall.AsyncCall> it2 = this.readyAsyncCalls.iterator();
                while (it2.hasNext()) {
                    RealCall.AsyncCall next = it2.next();
                    if (this.runningAsyncCalls.size() >= this.maxRequests) {
                        break;
                    } else if (next.getCallsPerHost().get() < this.maxRequestsPerHost) {
                        it2.remove();
                        next.getCallsPerHost().incrementAndGet();
                        arrayList.add(next);
                        this.runningAsyncCalls.add(next);
                    }
                }
                z11 = runningCallsCount() > 0;
                Unit unit = Unit.f56620a;
            }
            int size = arrayList.size();
            for (i11 = 0; i11 < size; i11++) {
                ((RealCall.AsyncCall) arrayList.get(i11)).executeOn(executorService());
            }
            return z11;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + this);
    }

    /* renamed from: -deprecated_executorService  reason: not valid java name */
    public final ExecutorService m3124deprecated_executorService() {
        return executorService();
    }

    public final synchronized void cancelAll() {
        Iterator<RealCall.AsyncCall> it2 = this.readyAsyncCalls.iterator();
        while (it2.hasNext()) {
            it2.next().getCall().cancel();
        }
        Iterator<RealCall.AsyncCall> it3 = this.runningAsyncCalls.iterator();
        while (it3.hasNext()) {
            it3.next().getCall().cancel();
        }
        Iterator<RealCall> it4 = this.runningSyncCalls.iterator();
        while (it4.hasNext()) {
            it4.next().cancel();
        }
    }

    public final void enqueue$okhttp(RealCall.AsyncCall asyncCall) {
        RealCall.AsyncCall findExistingCallWithHost;
        synchronized (this) {
            this.readyAsyncCalls.add(asyncCall);
            if (!asyncCall.getCall().getForWebSocket() && (findExistingCallWithHost = findExistingCallWithHost(asyncCall.getHost())) != null) {
                asyncCall.reuseCallsPerHostFrom(findExistingCallWithHost);
            }
            Unit unit = Unit.f56620a;
        }
        promoteAndExecute();
    }

    public final synchronized void executed$okhttp(RealCall realCall) {
        this.runningSyncCalls.add(realCall);
    }

    public final synchronized ExecutorService executorService() {
        if (this.executorServiceOrNull == null) {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            SynchronousQueue synchronousQueue = new SynchronousQueue();
            this.executorServiceOrNull = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, timeUnit, synchronousQueue, Util.threadFactory(Util.okHttpName + " Dispatcher", false));
        }
        return this.executorServiceOrNull;
    }

    public final void finished$okhttp(RealCall.AsyncCall asyncCall) {
        asyncCall.getCallsPerHost().decrementAndGet();
        finished(this.runningAsyncCalls, asyncCall);
    }

    public final synchronized Runnable getIdleCallback() {
        return this.idleCallback;
    }

    public final synchronized int getMaxRequests() {
        return this.maxRequests;
    }

    public final synchronized int getMaxRequestsPerHost() {
        return this.maxRequestsPerHost;
    }

    public final synchronized List<Call> queuedCalls() {
        ArrayList arrayList;
        ArrayDeque<RealCall.AsyncCall> arrayDeque = this.readyAsyncCalls;
        arrayList = new ArrayList(CollectionsKt__IterablesKt.u(arrayDeque, 10));
        for (RealCall.AsyncCall call : arrayDeque) {
            arrayList.add(call.getCall());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized int queuedCallsCount() {
        return this.readyAsyncCalls.size();
    }

    public final synchronized List<Call> runningCalls() {
        ArrayDeque<RealCall> arrayDeque;
        ArrayList arrayList;
        arrayDeque = this.runningSyncCalls;
        ArrayDeque<RealCall.AsyncCall> arrayDeque2 = this.runningAsyncCalls;
        arrayList = new ArrayList(CollectionsKt__IterablesKt.u(arrayDeque2, 10));
        for (RealCall.AsyncCall call : arrayDeque2) {
            arrayList.add(call.getCall());
        }
        return Collections.unmodifiableList(CollectionsKt___CollectionsKt.q0(arrayDeque, arrayList));
    }

    public final synchronized int runningCallsCount() {
        return this.runningAsyncCalls.size() + this.runningSyncCalls.size();
    }

    public final synchronized void setIdleCallback(Runnable runnable) {
        this.idleCallback = runnable;
    }

    public final void setMaxRequests(int i11) {
        boolean z11 = true;
        if (i11 < 1) {
            z11 = false;
        }
        if (z11) {
            synchronized (this) {
                this.maxRequests = i11;
                Unit unit = Unit.f56620a;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i11).toString());
    }

    public final void setMaxRequestsPerHost(int i11) {
        boolean z11 = true;
        if (i11 < 1) {
            z11 = false;
        }
        if (z11) {
            synchronized (this) {
                this.maxRequestsPerHost = i11;
                Unit unit = Unit.f56620a;
            }
            promoteAndExecute();
            return;
        }
        throw new IllegalArgumentException(("max < 1: " + i11).toString());
    }

    public final void finished$okhttp(RealCall realCall) {
        finished(this.runningSyncCalls, realCall);
    }

    public Dispatcher(ExecutorService executorService) {
        this();
        this.executorServiceOrNull = executorService;
    }
}
