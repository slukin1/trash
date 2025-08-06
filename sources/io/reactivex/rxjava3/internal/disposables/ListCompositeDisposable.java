package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.disposables.c;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class ListCompositeDisposable implements b, c {

    /* renamed from: b  reason: collision with root package name */
    public List<b> f55440b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f55441c;

    public boolean a(b bVar) {
        Objects.requireNonNull(bVar, "d is null");
        if (!this.f55441c) {
            synchronized (this) {
                if (!this.f55441c) {
                    List list = this.f55440b;
                    if (list == null) {
                        list = new LinkedList();
                        this.f55440b = list;
                    }
                    list.add(bVar);
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
            java.lang.String r0 = "Disposable item is null"
            java.util.Objects.requireNonNull(r3, r0)
            boolean r0 = r2.f55441c
            r1 = 0
            if (r0 == 0) goto L_0x000b
            return r1
        L_0x000b:
            monitor-enter(r2)
            boolean r0 = r2.f55441c     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0012
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return r1
        L_0x0012:
            java.util.List<io.reactivex.rxjava3.disposables.b> r0 = r2.f55440b     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x0022 }
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
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable.b(io.reactivex.rxjava3.disposables.b):boolean");
    }

    public boolean c(b bVar) {
        if (!b(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    public void d(List<b> list) {
        if (list != null) {
            ArrayList arrayList = null;
            for (b dispose : list) {
                try {
                    dispose.dispose();
                } catch (Throwable th2) {
                    a.b(th2);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
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
        if (!this.f55441c) {
            synchronized (this) {
                if (!this.f55441c) {
                    this.f55441c = true;
                    List<b> list = this.f55440b;
                    this.f55440b = null;
                    d(list);
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.f55441c;
    }
}
