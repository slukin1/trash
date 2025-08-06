package io.reactivex.rxjava3.internal.operators.mixed;

import h00.a;
import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSwitchMapCompletable$SwitchMapCompletableObserver<T> implements e<T>, b {

    public static final class SwitchMapInnerObserver extends AtomicReference<b> implements a {
        private static final long serialVersionUID = -8003404460084760287L;
        public final FlowableSwitchMapCompletable$SwitchMapCompletableObserver<?> parent;

        public SwitchMapInnerObserver(FlowableSwitchMapCompletable$SwitchMapCompletableObserver<?> flowableSwitchMapCompletable$SwitchMapCompletableObserver) {
        }

        public void dispose() {
            DisposableHelper.dispose(this);
        }

        public void onComplete() {
            throw null;
        }

        public void onError(Throwable th2) {
            throw null;
        }

        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }
}
