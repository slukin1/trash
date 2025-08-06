package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class ObservableBuffer$BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements k<T>, b {
    private static final long serialVersionUID = -8223395059921494546L;
    public final j00.k<U> bufferSupplier;
    public final ArrayDeque<U> buffers = new ArrayDeque<>();
    public final int count;
    public final k<? super U> downstream;
    public long index;
    public final int skip;
    public b upstream;

    public ObservableBuffer$BufferSkipObserver(k<? super U> kVar, int i11, int i12, j00.k<U> kVar2) {
        this.downstream = kVar;
        this.count = i11;
        this.skip = i12;
        this.bufferSupplier = kVar2;
    }

    public void dispose() {
        this.upstream.dispose();
    }

    public boolean isDisposed() {
        return this.upstream.isDisposed();
    }

    public void onComplete() {
        while (!this.buffers.isEmpty()) {
            this.downstream.onNext(this.buffers.poll());
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.buffers.clear();
        this.downstream.onError(th2);
    }

    public void onNext(T t11) {
        long j11 = this.index;
        this.index = 1 + j11;
        if (j11 % ((long) this.skip) == 0) {
            try {
                this.buffers.offer((Collection) ExceptionHelper.c(this.bufferSupplier.get(), "The bufferSupplier returned a null Collection."));
            } catch (Throwable th2) {
                a.b(th2);
                this.buffers.clear();
                this.upstream.dispose();
                this.downstream.onError(th2);
                return;
            }
        }
        Iterator<U> it2 = this.buffers.iterator();
        while (it2.hasNext()) {
            Collection collection = (Collection) it2.next();
            collection.add(t11);
            if (this.count <= collection.size()) {
                it2.remove();
                this.downstream.onNext(collection);
            }
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }
}
