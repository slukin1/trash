package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class ArrayCompositeDisposable extends AtomicReferenceArray<b> implements b {
    private static final long serialVersionUID = 2746389416410565408L;

    public ArrayCompositeDisposable(int i11) {
        super(i11);
    }

    public void dispose() {
        b bVar;
        if (get(0) != DisposableHelper.DISPOSED) {
            int length = length();
            for (int i11 = 0; i11 < length; i11++) {
                b bVar2 = (b) get(i11);
                DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
                if (!(bVar2 == disposableHelper || (bVar = (b) getAndSet(i11, disposableHelper)) == disposableHelper || bVar == null)) {
                    bVar.dispose();
                }
            }
        }
    }

    public boolean isDisposed() {
        return get(0) == DisposableHelper.DISPOSED;
    }

    public b replaceResource(int i11, b bVar) {
        b bVar2;
        do {
            bVar2 = (b) get(i11);
            if (bVar2 == DisposableHelper.DISPOSED) {
                bVar.dispose();
                return null;
            }
        } while (!compareAndSet(i11, bVar2, bVar));
        return bVar2;
    }

    public boolean setResource(int i11, b bVar) {
        b bVar2;
        do {
            bVar2 = (b) get(i11);
            if (bVar2 == DisposableHelper.DISPOSED) {
                bVar.dispose();
                return false;
            }
        } while (!compareAndSet(i11, bVar2, bVar));
        if (bVar2 == null) {
            return true;
        }
        bVar2.dispose();
        return true;
    }
}
