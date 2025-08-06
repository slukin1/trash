package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import java.util.Objects;
import z20.c;

public final class h<T, U> extends a<T, U> {

    /* renamed from: d  reason: collision with root package name */
    public final j00.h<? super T, ? extends U> f55517d;

    public static final class a<T, U> extends m00.a<T, U> {

        /* renamed from: g  reason: collision with root package name */
        public final j00.h<? super T, ? extends U> f55518g;

        public a(k00.a<? super U> aVar, j00.h<? super T, ? extends U> hVar) {
            super(aVar);
            this.f55518g = hVar;
        }

        public void onNext(T t11) {
            if (!this.f58090e) {
                if (this.f58091f != 0) {
                    this.f58087b.onNext(null);
                    return;
                }
                try {
                    Object apply = this.f55518g.apply(t11);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.f58087b.onNext(apply);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        public U poll() throws Throwable {
            T poll = this.f58089d.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.f55518g.apply(poll);
            Objects.requireNonNull(apply, "The mapper function returned a null value.");
            return apply;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }

        public boolean tryOnNext(T t11) {
            if (this.f58090e) {
                return false;
            }
            try {
                Object apply = this.f55518g.apply(t11);
                Objects.requireNonNull(apply, "The mapper function returned a null value.");
                return this.f58087b.tryOnNext(apply);
            } catch (Throwable th2) {
                c(th2);
                return true;
            }
        }
    }

    public static final class b<T, U> extends m00.b<T, U> {

        /* renamed from: g  reason: collision with root package name */
        public final j00.h<? super T, ? extends U> f55519g;

        public b(c<? super U> cVar, j00.h<? super T, ? extends U> hVar) {
            super(cVar);
            this.f55519g = hVar;
        }

        public void onNext(T t11) {
            if (!this.f58095e) {
                if (this.f58096f != 0) {
                    this.f58092b.onNext(null);
                    return;
                }
                try {
                    Object apply = this.f55519g.apply(t11);
                    Objects.requireNonNull(apply, "The mapper function returned a null value.");
                    this.f58092b.onNext(apply);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        public U poll() throws Throwable {
            T poll = this.f58094d.poll();
            if (poll == null) {
                return null;
            }
            U apply = this.f55519g.apply(poll);
            Objects.requireNonNull(apply, "The mapper function returned a null value.");
            return apply;
        }

        public int requestFusion(int i11) {
            return d(i11);
        }
    }

    public h(Flowable<T> flowable, j00.h<? super T, ? extends U> hVar) {
        super(flowable);
        this.f55517d = hVar;
    }

    public void j(c<? super U> cVar) {
        if (cVar instanceof k00.a) {
            this.f55511c.i(new a((k00.a) cVar, this.f55517d));
        } else {
            this.f55511c.i(new b(cVar, this.f55517d));
        }
    }
}
