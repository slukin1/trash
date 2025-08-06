package io.reactivex.rxjava3.internal.operators.maybe;

import h00.g;
import j00.h;
import z20.b;

public enum MaybeToPublisher implements h<g<Object>, b<Object>> {
    INSTANCE;

    public static <T> h<g<T>, b<T>> instance() {
        return INSTANCE;
    }

    public b<Object> apply(g<Object> gVar) {
        return new MaybeToFlowable(gVar);
    }
}
