package io.reactivex.rxjava3.internal.jdk8;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.h;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import o00.a;

final class ObservableFlatMapStream$FlatMapStreamObserver<T, R> extends AtomicInteger implements k<T>, b {
    private static final long serialVersionUID = -5127032662980523968L;
    public volatile boolean disposed;
    public boolean done;
    public final k<? super R> downstream;
    public final h<? super T, ? extends Stream<? extends R>> mapper;
    public b upstream;

    public ObservableFlatMapStream$FlatMapStreamObserver(k<? super R> kVar, h<? super T, ? extends Stream<? extends R>> hVar) {
        this.downstream = kVar;
        this.mapper = hVar;
    }

    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            this.downstream.onComplete();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.done = true;
        this.downstream.onError(th2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004e, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onNext(T r5) {
        /*
            r4 = this;
            boolean r0 = r4.done
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            j00.h<? super T, ? extends java.util.stream.Stream<? extends R>> r0 = r4.mapper     // Catch:{ all -> 0x004f }
            java.lang.Object r5 = r0.apply(r5)     // Catch:{ all -> 0x004f }
            java.lang.String r0 = "The mapper returned a null Stream"
            java.util.Objects.requireNonNull(r5, r0)     // Catch:{ all -> 0x004f }
            java.util.stream.Stream r5 = (java.util.stream.Stream) r5     // Catch:{ all -> 0x004f }
            java.util.Iterator r0 = r5.iterator()     // Catch:{ all -> 0x0043 }
        L_0x0016:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x003f
            boolean r1 = r4.disposed     // Catch:{ all -> 0x0043 }
            r2 = 1
            if (r1 == 0) goto L_0x0024
            r4.done = r2     // Catch:{ all -> 0x0043 }
            goto L_0x003f
        L_0x0024:
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0043 }
            java.lang.String r3 = "The Stream's Iterator.next returned a null value"
            java.util.Objects.requireNonNull(r1, r3)     // Catch:{ all -> 0x0043 }
            boolean r3 = r4.disposed     // Catch:{ all -> 0x0043 }
            if (r3 == 0) goto L_0x0034
            r4.done = r2     // Catch:{ all -> 0x0043 }
            goto L_0x003f
        L_0x0034:
            h00.k<? super R> r3 = r4.downstream     // Catch:{ all -> 0x0043 }
            r3.onNext(r1)     // Catch:{ all -> 0x0043 }
            boolean r1 = r4.disposed     // Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x0016
            r4.done = r2     // Catch:{ all -> 0x0043 }
        L_0x003f:
            r5.close()     // Catch:{ all -> 0x004f }
            goto L_0x005b
        L_0x0043:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r1 = move-exception
            r5.close()     // Catch:{ all -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r5 = move-exception
            r0.addSuppressed(r5)     // Catch:{ all -> 0x004f }
        L_0x004e:
            throw r1     // Catch:{ all -> 0x004f }
        L_0x004f:
            r5 = move-exception
            io.reactivex.rxjava3.exceptions.a.b(r5)
            io.reactivex.rxjava3.disposables.b r0 = r4.upstream
            r0.dispose()
            r4.onError(r5)
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.jdk8.ObservableFlatMapStream$FlatMapStreamObserver.onNext(java.lang.Object):void");
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
