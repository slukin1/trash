package io.reactivex.rxjava3.subjects;

import h00.m;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

public final class SingleSubject<T> extends Single<T> implements m<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final SingleDisposable[] f55768f = new SingleDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    public static final SingleDisposable[] f55769g = new SingleDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<SingleDisposable<T>[]> f55770b = new AtomicReference<>(f55768f);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f55771c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public T f55772d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f55773e;

    public static final class SingleDisposable<T> extends AtomicReference<SingleSubject<T>> implements b {
        private static final long serialVersionUID = -7650903191002190468L;
        public final m<? super T> downstream;

        public SingleDisposable(m<? super T> mVar, SingleSubject<T> singleSubject) {
            this.downstream = mVar;
            lazySet(singleSubject);
        }

        public void dispose() {
            SingleSubject singleSubject = (SingleSubject) getAndSet((Object) null);
            if (singleSubject != null) {
                singleSubject.h(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public void f(m<? super T> mVar) {
        SingleDisposable singleDisposable = new SingleDisposable(mVar, this);
        mVar.onSubscribe(singleDisposable);
        if (!g(singleDisposable)) {
            Throwable th2 = this.f55773e;
            if (th2 != null) {
                mVar.onError(th2);
            } else {
                mVar.onSuccess(this.f55772d);
            }
        } else if (singleDisposable.isDisposed()) {
            h(singleDisposable);
        }
    }

    public boolean g(SingleDisposable<T> singleDisposable) {
        SingleDisposable[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f55770b.get();
            if (singleDisposableArr == f55769g) {
                return false;
            }
            int length = singleDisposableArr.length;
            singleDisposableArr2 = new SingleDisposable[(length + 1)];
            System.arraycopy(singleDisposableArr, 0, singleDisposableArr2, 0, length);
            singleDisposableArr2[length] = singleDisposable;
        } while (!this.f55770b.compareAndSet(singleDisposableArr, singleDisposableArr2));
        return true;
    }

    public void h(SingleDisposable<T> singleDisposable) {
        SingleDisposable<T>[] singleDisposableArr;
        SingleDisposable[] singleDisposableArr2;
        do {
            singleDisposableArr = (SingleDisposable[]) this.f55770b.get();
            int length = singleDisposableArr.length;
            if (length != 0) {
                int i11 = -1;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (singleDisposableArr[i12] == singleDisposable) {
                        i11 = i12;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        singleDisposableArr2 = f55768f;
                    } else {
                        SingleDisposable[] singleDisposableArr3 = new SingleDisposable[(length - 1)];
                        System.arraycopy(singleDisposableArr, 0, singleDisposableArr3, 0, i11);
                        System.arraycopy(singleDisposableArr, i11 + 1, singleDisposableArr3, i11, (length - i11) - 1);
                        singleDisposableArr2 = singleDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f55770b.compareAndSet(singleDisposableArr, singleDisposableArr2));
    }

    public void onError(Throwable th2) {
        ExceptionHelper.c(th2, "onError called with a null Throwable.");
        if (this.f55771c.compareAndSet(false, true)) {
            this.f55773e = th2;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f55770b.getAndSet(f55769g)) {
                singleDisposable.downstream.onError(th2);
            }
            return;
        }
        a.n(th2);
    }

    public void onSubscribe(b bVar) {
        if (this.f55770b.get() == f55769g) {
            bVar.dispose();
        }
    }

    public void onSuccess(T t11) {
        ExceptionHelper.c(t11, "onSuccess called with a null value.");
        if (this.f55771c.compareAndSet(false, true)) {
            this.f55772d = t11;
            for (SingleDisposable singleDisposable : (SingleDisposable[]) this.f55770b.getAndSet(f55769g)) {
                singleDisposable.downstream.onSuccess(t11);
            }
        }
    }
}
