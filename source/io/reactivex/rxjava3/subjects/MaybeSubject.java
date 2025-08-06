package io.reactivex.rxjava3.subjects;

import h00.f;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import o00.a;

public final class MaybeSubject<T> extends Maybe<T> implements f<T> {

    /* renamed from: f  reason: collision with root package name */
    public static final MaybeDisposable[] f55762f = new MaybeDisposable[0];

    /* renamed from: g  reason: collision with root package name */
    public static final MaybeDisposable[] f55763g = new MaybeDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<MaybeDisposable<T>[]> f55764b = new AtomicReference<>(f55762f);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f55765c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public T f55766d;

    /* renamed from: e  reason: collision with root package name */
    public Throwable f55767e;

    public static final class MaybeDisposable<T> extends AtomicReference<MaybeSubject<T>> implements b {
        private static final long serialVersionUID = -7650903191002190468L;
        public final f<? super T> downstream;

        public MaybeDisposable(f<? super T> fVar, MaybeSubject<T> maybeSubject) {
            this.downstream = fVar;
            lazySet(maybeSubject);
        }

        public void dispose() {
            MaybeSubject maybeSubject = (MaybeSubject) getAndSet((Object) null);
            if (maybeSubject != null) {
                maybeSubject.d(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public void b(f<? super T> fVar) {
        MaybeDisposable maybeDisposable = new MaybeDisposable(fVar, this);
        fVar.onSubscribe(maybeDisposable);
        if (!c(maybeDisposable)) {
            Throwable th2 = this.f55767e;
            if (th2 != null) {
                fVar.onError(th2);
                return;
            }
            T t11 = this.f55766d;
            if (t11 == null) {
                fVar.onComplete();
            } else {
                fVar.onSuccess(t11);
            }
        } else if (maybeDisposable.isDisposed()) {
            d(maybeDisposable);
        }
    }

    public boolean c(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.f55764b.get();
            if (maybeDisposableArr == f55763g) {
                return false;
            }
            int length = maybeDisposableArr.length;
            maybeDisposableArr2 = new MaybeDisposable[(length + 1)];
            System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr2, 0, length);
            maybeDisposableArr2[length] = maybeDisposable;
        } while (!this.f55764b.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
        return true;
    }

    public void d(MaybeDisposable<T> maybeDisposable) {
        MaybeDisposable<T>[] maybeDisposableArr;
        MaybeDisposable[] maybeDisposableArr2;
        do {
            maybeDisposableArr = (MaybeDisposable[]) this.f55764b.get();
            int length = maybeDisposableArr.length;
            if (length != 0) {
                int i11 = -1;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (maybeDisposableArr[i12] == maybeDisposable) {
                        i11 = i12;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        maybeDisposableArr2 = f55762f;
                    } else {
                        MaybeDisposable[] maybeDisposableArr3 = new MaybeDisposable[(length - 1)];
                        System.arraycopy(maybeDisposableArr, 0, maybeDisposableArr3, 0, i11);
                        System.arraycopy(maybeDisposableArr, i11 + 1, maybeDisposableArr3, i11, (length - i11) - 1);
                        maybeDisposableArr2 = maybeDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f55764b.compareAndSet(maybeDisposableArr, maybeDisposableArr2));
    }

    public void onComplete() {
        if (this.f55765c.compareAndSet(false, true)) {
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f55764b.getAndSet(f55763g)) {
                maybeDisposable.downstream.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        ExceptionHelper.c(th2, "onError called with a null Throwable.");
        if (this.f55765c.compareAndSet(false, true)) {
            this.f55767e = th2;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f55764b.getAndSet(f55763g)) {
                maybeDisposable.downstream.onError(th2);
            }
            return;
        }
        a.n(th2);
    }

    public void onSubscribe(b bVar) {
        if (this.f55764b.get() == f55763g) {
            bVar.dispose();
        }
    }

    public void onSuccess(T t11) {
        ExceptionHelper.c(t11, "onSuccess called with a null value.");
        if (this.f55765c.compareAndSet(false, true)) {
            this.f55766d = t11;
            for (MaybeDisposable maybeDisposable : (MaybeDisposable[]) this.f55764b.getAndSet(f55763g)) {
                maybeDisposable.downstream.onSuccess(t11);
            }
        }
    }
}
