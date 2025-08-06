package io.reactivex.rxjava3.disposables;

import z20.d;

final class SubscriptionDisposable extends ReferenceDisposable<d> {
    private static final long serialVersionUID = -707001650852963139L;

    public SubscriptionDisposable(d dVar) {
        super(dVar);
    }

    public void onDisposed(d dVar) {
        dVar.cancel();
    }
}
