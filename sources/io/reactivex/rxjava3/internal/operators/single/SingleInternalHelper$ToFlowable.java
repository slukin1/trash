package io.reactivex.rxjava3.internal.operators.single;

import h00.o;
import j00.h;
import z20.b;

enum SingleInternalHelper$ToFlowable implements h<o, b> {
    INSTANCE;

    public b apply(o oVar) {
        return new SingleToFlowable(oVar);
    }
}
