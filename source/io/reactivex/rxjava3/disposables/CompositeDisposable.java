package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.OpenHashSet;
import java.util.ArrayList;
import java.util.Objects;

public final class CompositeDisposable implements b, c {

    /* renamed from: b  reason: collision with root package name */
    public OpenHashSet<b> f55435b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f55436c;

    public boolean a(b bVar) {
        Objects.requireNonNull(bVar, "disposable is null");
        if (!this.f55436c) {
            synchronized (this) {
                if (!this.f55436c) {
                    OpenHashSet<b> openHashSet = this.f55435b;
                    if (openHashSet == null) {
                        openHashSet = new OpenHashSet<>();
                        this.f55435b = openHashSet;
                    }
                    openHashSet.a(bVar);
                    return true;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(io.reactivex.rxjava3.disposables.b r3) {
        /*
            r2 = this;
            java.lang.String r0 = "disposable is null"
            java.util.Objects.requireNonNull(r3, r0)
            boolean r0 = r2.f55436c
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f55436c     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            io.reactivex.rxjava3.internal.util.OpenHashSet<io.reactivex.rxjava3.disposables.b> r0 = r2.f55435b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.e(r3)     // Catch:{ all -> 0x0022 }
            if (r3 != 0) goto L_0x001d
            goto L_0x0020
        L_0x001d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            r3 = 1
            return r3
        L_0x0020:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0022:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.disposables.CompositeDisposable.b(io.reactivex.rxjava3.disposables.b):boolean");
    }

    public boolean c(b bVar) {
        if (!b(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    public void d(OpenHashSet<b> openHashSet) {
        if (openHashSet != null) {
            ArrayList arrayList = null;
            for (Object obj : openHashSet.b()) {
                if (obj instanceof b) {
                    try {
                        ((b) obj).dispose();
                    } catch (Throwable th2) {
                        a.b(th2);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(th2);
                    }
                }
            }
            if (arrayList == null) {
                return;
            }
            if (arrayList.size() == 1) {
                throw ExceptionHelper.g((Throwable) arrayList.get(0));
            }
            throw new CompositeException((Iterable<? extends Throwable>) arrayList);
        }
    }

    public void dispose() {
        if (!this.f55436c) {
            synchronized (this) {
                if (!this.f55436c) {
                    this.f55436c = true;
                    OpenHashSet<b> openHashSet = this.f55435b;
                    this.f55435b = null;
                    d(openHashSet);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int e() {
        /*
            r2 = this;
            boolean r0 = r2.f55436c
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r2)
            boolean r0 = r2.f55436c     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x000d:
            io.reactivex.rxjava3.internal.util.OpenHashSet<io.reactivex.rxjava3.disposables.b> r0 = r2.f55435b     // Catch:{ all -> 0x0017 }
            if (r0 == 0) goto L_0x0015
            int r1 = r0.g()     // Catch:{ all -> 0x0017 }
        L_0x0015:
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            return r1
        L_0x0017:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0017 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.disposables.CompositeDisposable.e():int");
    }

    public boolean isDisposed() {
        return this.f55436c;
    }
}
