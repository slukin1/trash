package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import j00.a;

final class ActionDisposable extends ReferenceDisposable<a> {
    private static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(a aVar) {
        super(aVar);
    }

    public String toString() {
        return "ActionDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }

    public void onDisposed(a aVar) {
        try {
            aVar.run();
        } catch (Throwable th2) {
            throw ExceptionHelper.g(th2);
        }
    }
}
