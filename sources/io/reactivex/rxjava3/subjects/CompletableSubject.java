package io.reactivex.rxjava3.subjects;

import h00.a;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubject extends Completable implements a {

    /* renamed from: e  reason: collision with root package name */
    public static final CompletableDisposable[] f55757e = new CompletableDisposable[0];

    /* renamed from: f  reason: collision with root package name */
    public static final CompletableDisposable[] f55758f = new CompletableDisposable[0];

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<CompletableDisposable[]> f55759b = new AtomicReference<>(f55757e);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f55760c = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    public Throwable f55761d;

    public static final class CompletableDisposable extends AtomicReference<CompletableSubject> implements b {
        private static final long serialVersionUID = -7650903191002190468L;
        public final a downstream;

        public CompletableDisposable(a aVar, CompletableSubject completableSubject) {
            this.downstream = aVar;
            lazySet(completableSubject);
        }

        public void dispose() {
            CompletableSubject completableSubject = (CompletableSubject) getAndSet((Object) null);
            if (completableSubject != null) {
                completableSubject.e(this);
            }
        }

        public boolean isDisposed() {
            return get() == null;
        }
    }

    public void b(a aVar) {
        CompletableDisposable completableDisposable = new CompletableDisposable(aVar, this);
        aVar.onSubscribe(completableDisposable);
        if (!d(completableDisposable)) {
            Throwable th2 = this.f55761d;
            if (th2 != null) {
                aVar.onError(th2);
            } else {
                aVar.onComplete();
            }
        } else if (completableDisposable.isDisposed()) {
            e(completableDisposable);
        }
    }

    public boolean d(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f55759b.get();
            if (completableDisposableArr == f55758f) {
                return false;
            }
            int length = completableDisposableArr.length;
            completableDisposableArr2 = new CompletableDisposable[(length + 1)];
            System.arraycopy(completableDisposableArr, 0, completableDisposableArr2, 0, length);
            completableDisposableArr2[length] = completableDisposable;
        } while (!this.f55759b.compareAndSet(completableDisposableArr, completableDisposableArr2));
        return true;
    }

    public void e(CompletableDisposable completableDisposable) {
        CompletableDisposable[] completableDisposableArr;
        CompletableDisposable[] completableDisposableArr2;
        do {
            completableDisposableArr = this.f55759b.get();
            int length = completableDisposableArr.length;
            if (length != 0) {
                int i11 = -1;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (completableDisposableArr[i12] == completableDisposable) {
                        i11 = i12;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        completableDisposableArr2 = f55757e;
                    } else {
                        CompletableDisposable[] completableDisposableArr3 = new CompletableDisposable[(length - 1)];
                        System.arraycopy(completableDisposableArr, 0, completableDisposableArr3, 0, i11);
                        System.arraycopy(completableDisposableArr, i11 + 1, completableDisposableArr3, i11, (length - i11) - 1);
                        completableDisposableArr2 = completableDisposableArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f55759b.compareAndSet(completableDisposableArr, completableDisposableArr2));
    }

    public void onComplete() {
        if (this.f55760c.compareAndSet(false, true)) {
            for (CompletableDisposable completableDisposable : this.f55759b.getAndSet(f55758f)) {
                completableDisposable.downstream.onComplete();
            }
        }
    }

    public void onError(Throwable th2) {
        ExceptionHelper.c(th2, "onError called with a null Throwable.");
        if (this.f55760c.compareAndSet(false, true)) {
            this.f55761d = th2;
            for (CompletableDisposable completableDisposable : this.f55759b.getAndSet(f55758f)) {
                completableDisposable.downstream.onError(th2);
            }
            return;
        }
        o00.a.n(th2);
    }

    public void onSubscribe(b bVar) {
        if (this.f55759b.get() == f55758f) {
            bVar.dispose();
        }
    }
}
