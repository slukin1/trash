package io.reactivex.rxjava3.internal.operators.flowable;

import j00.g;
import z20.d;

public enum FlowableInternalHelper$RequestMax implements g<d> {
    INSTANCE;

    public void accept(d dVar) {
        dVar.request(Long.MAX_VALUE);
    }
}
