package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import h00.g;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCache<T> extends Maybe<T> implements f<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final CacheDisposable[] f55530f = new CacheDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    public static final CacheDisposable[] f55531g = new CacheDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<g<T>> f55532b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<CacheDisposable<T>[]> f55533c;

    /* renamed from: d  reason: collision with root package name */
    public T f55534d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f55535e;

    public static final class CacheDisposable<T> extends AtomicReference<MaybeCache<T>> implements b {
        private static final long serialVersionUID = -5791853038359966195L;
        public final f<? super T> downstream;

        public CacheDisposable(f<? super T> fVar, MaybeCache<T> maybeCache) {
            super(maybeCache);
            this.downstream = fVar;
        }

        public void dispose() {
            MaybeCache maybeCache = (MaybeCache) getAndSet((Object) null);
            if (maybeCache != null) {
                maybeCache.d(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public void b(f<? super T> fVar) {
        CacheDisposable cacheDisposable = new CacheDisposable(fVar, this);
        fVar.onSubscribe(cacheDisposable);
        if (c(cacheDisposable)) {
            if (cacheDisposable.isDisposed()) {
                d(cacheDisposable);
                return;
            }
            g andSet = this.f55532b.getAndSet((Object) null);
            if (andSet != null) {
                andSet.a(this);
            }
        } else if (!cacheDisposable.isDisposed()) {
            Throwable th2 = this.f55535e;
            if (th2 != null) {
                fVar.onError(th2);
                return;
            }
            T t11 = this.f55534d;
            if (t11 != null) {
                fVar.onSuccess(t11);
            } else {
                fVar.onComplete();
            }
        }
    }

    public boolean c(CacheDisposable<T> cacheDisposable) {
        CacheDisposable[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f55533c.get();
            if (cacheDisposableArr == f55531g) {
                return false;
            }
            int length = cacheDisposableArr.length;
            cacheDisposableArr2 = new CacheDisposable[(length + 1)];
            System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr2, 0, length);
            cacheDisposableArr2[length] = cacheDisposable;
        } while (!this.f55533c.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
        return true;
    }

    public void d(CacheDisposable<T> cacheDisposable) {
        CacheDisposable<T>[] cacheDisposableArr;
        CacheDisposable[] cacheDisposableArr2;
        do {
            cacheDisposableArr = (CacheDisposable[]) this.f55533c.get();
            int length = cacheDisposableArr.length;
            if (length != 0) {
                int i11 = -1;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (cacheDisposableArr[i12] == cacheDisposable) {
                        i11 = i12;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        cacheDisposableArr2 = f55530f;
                    } else {
                        CacheDisposable[] cacheDisposableArr3 = new CacheDisposable[(length - 1)];
                        System.arraycopy(cacheDisposableArr, 0, cacheDisposableArr3, 0, i11);
                        System.arraycopy(cacheDisposableArr, i11 + 1, cacheDisposableArr3, i11, (length - i11) - 1);
                        cacheDisposableArr2 = cacheDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f55533c.compareAndSet(cacheDisposableArr, cacheDisposableArr2));
    }

    public void onComplete() {
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f55533c.getAndSet(f55531g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        this.f55535e = th2;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f55533c.getAndSet(f55531g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onError(th2);
            }
        }
    }

    public void onSubscribe(b bVar) {
    }

    public void onSuccess(T t11) {
        this.f55534d = t11;
        for (CacheDisposable cacheDisposable : (CacheDisposable[]) this.f55533c.getAndSet(f55531g)) {
            if (!cacheDisposable.isDisposed()) {
                cacheDisposable.downstream.onSuccess(t11);
            }
        }
    }
}
