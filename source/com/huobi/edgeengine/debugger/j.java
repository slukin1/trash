package com.huobi.edgeengine.debugger;

import android.os.Handler;
import android.os.Looper;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\u001a\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\"\u0004\b\u0000\u0010\u00112\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0012H\u0016J-\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014\"\u0004\b\u0000\u0010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0016\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0015\u0010\u0017J\u0016\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J2\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0007\"\u0004\b\u0000\u0010\u00112\u0016\u0010\u0019\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0018\u00010\u0018H\u0016JD\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0007\"\u0004\b\u0000\u0010\u00112\u0016\u0010\u0019\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J-\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00112\u0016\u0010\u0019\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0018\u00010\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ?\u0010\u001b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00112\u0016\u0010\u0019\u001a\u0012\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0018\u00010\u00182\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u001b\u0010\u001dR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/huobi/edgeengine/debugger/j;", "Ljava/util/concurrent/ExecutorService;", "Ljava/lang/Runnable;", "command", "", "execute", "shutdown", "", "shutdownNow", "", "isShutdown", "isTerminated", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "awaitTermination", "T", "Ljava/util/concurrent/Callable;", "task", "Ljava/util/concurrent/Future;", "submit", "result", "(Ljava/lang/Runnable;Ljava/lang/Object;)Ljava/util/concurrent/Future;", "", "tasks", "invokeAll", "invokeAny", "(Ljava/util/Collection;)Ljava/lang/Object;", "(Ljava/util/Collection;JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "<init>", "(Landroid/os/Handler;)V", "a", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class j implements ExecutorService {

    /* renamed from: b  reason: collision with root package name */
    public Handler f44014b;

    public j(Handler handler) {
        this.f44014b = handler;
    }

    public boolean awaitTermination(long j11, TimeUnit timeUnit) {
        return true;
    }

    public void execute(Runnable runnable) {
        this.f44014b.post(runnable);
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        throw new UnsupportedOperationException();
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean isShutdown() {
        return !this.f44014b.getLooper().getThread().isAlive();
    }

    public boolean isTerminated() {
        return isShutdown();
    }

    public void shutdown() {
        this.f44014b.getLooper().quit();
    }

    public List<Runnable> shutdownNow() {
        this.f44014b.removeCallbacksAndMessages((Object) null);
        return Collections.emptyList();
    }

    public <T> Future<T> submit(Callable<T> callable) {
        a aVar = new a(callable);
        execute(aVar);
        return aVar;
    }

    @Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0019\b\u0016\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011B\u001d\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0014\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0010\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/huobi/edgeengine/debugger/j$a;", "T", "Ljava/util/concurrent/FutureTask;", "value", "", "set", "(Ljava/lang/Object;)V", "", "throwable", "setException", "Landroid/os/Handler;", "b", "Landroid/os/Handler;", "handler", "Ljava/util/concurrent/Callable;", "callable", "<init>", "(Ljava/util/concurrent/Callable;)V", "Ljava/lang/Runnable;", "runnable", "result", "(Ljava/lang/Runnable;Ljava/lang/Object;)V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
    public static final class a<T> extends FutureTask<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f44015b = new Handler(Looper.getMainLooper());

        public a(Callable<T> callable) {
            super(callable);
        }

        public static final void c(a aVar, Object obj) {
            aVar.set(obj);
        }

        public static final void d(a aVar, Throwable th2) {
            aVar.setException(th2);
        }

        public void set(T t11) {
            if (this.f44015b.getLooper().getThread() == Thread.currentThread()) {
                super.set(t11);
            } else {
                this.f44015b.post(new h(this, t11));
            }
        }

        public void setException(Throwable th2) {
            if (this.f44015b.getLooper().getThread() == Thread.currentThread()) {
                super.setException(th2);
            } else {
                this.f44015b.post(new i(this, th2));
            }
        }

        public a(Runnable runnable, T t11) {
            super(runnable, t11);
        }
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j11, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j11, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public <T> Future<T> submit(Runnable runnable, T t11) {
        a aVar = new a(runnable, t11);
        execute(aVar);
        return aVar;
    }

    public Future<?> submit(Runnable runnable) {
        a aVar = new a(runnable, null);
        execute(aVar);
        return aVar;
    }
}
