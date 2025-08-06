package io.reactivex.rxjava3.observers;

import h00.a;
import h00.f;
import h00.k;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TestObserver<T> extends BaseTestConsumer<T, TestObserver<T>> implements k<T>, b, f<T>, m<T>, a {

    /* renamed from: h  reason: collision with root package name */
    public final k<? super T> f55733h;

    /* renamed from: i  reason: collision with root package name */
    public final AtomicReference<b> f55734i;

    public enum EmptyObserver implements k<Object> {
        INSTANCE;

        public void onComplete() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(Object obj) {
        }

        public void onSubscribe(b bVar) {
        }
    }

    public TestObserver() {
        this(EmptyObserver.INSTANCE);
    }

    public final void dispose() {
        DisposableHelper.dispose(this.f55734i);
    }

    public final boolean isDisposed() {
        return DisposableHelper.isDisposed(this.f55734i.get());
    }

    public void onComplete() {
        if (!this.f55719g) {
            this.f55719g = true;
            if (this.f55734i.get() == null) {
                this.f55716d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f55718f = Thread.currentThread();
            this.f55717e++;
            this.f55733h.onComplete();
        } finally {
            this.f55714b.countDown();
        }
    }

    public void onError(Throwable th2) {
        if (!this.f55719g) {
            this.f55719g = true;
            if (this.f55734i.get() == null) {
                this.f55716d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f55718f = Thread.currentThread();
            if (th2 == null) {
                this.f55716d.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f55716d.add(th2);
            }
            this.f55733h.onError(th2);
        } finally {
            this.f55714b.countDown();
        }
    }

    public void onNext(T t11) {
        if (!this.f55719g) {
            this.f55719g = true;
            if (this.f55734i.get() == null) {
                this.f55716d.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f55718f = Thread.currentThread();
        this.f55715c.add(t11);
        if (t11 == null) {
            this.f55716d.add(new NullPointerException("onNext received a null value"));
        }
        this.f55733h.onNext(t11);
    }

    public void onSubscribe(b bVar) {
        this.f55718f = Thread.currentThread();
        if (bVar == null) {
            this.f55716d.add(new NullPointerException("onSubscribe received a null Subscription"));
        } else if (!this.f55734i.compareAndSet((Object) null, bVar)) {
            bVar.dispose();
            if (this.f55734i.get() != DisposableHelper.DISPOSED) {
                List<Throwable> list = this.f55716d;
                list.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + bVar));
            }
        } else {
            this.f55733h.onSubscribe(bVar);
        }
    }

    public void onSuccess(T t11) {
        onNext(t11);
        onComplete();
    }

    public TestObserver(k<? super T> kVar) {
        this.f55734i = new AtomicReference<>();
        this.f55733h = kVar;
    }
}
