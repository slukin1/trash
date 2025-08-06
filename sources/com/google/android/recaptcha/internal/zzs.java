package com.google.android.recaptcha.internal;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.h0;

final class zzs extends SuspendLambda implements p {
    public zzs(c cVar) {
        super(2, cVar);
    }

    public final c create(Object obj, c cVar) {
        return new zzs(cVar);
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        h0 h0Var = (h0) obj;
        return new zzs((c) obj2).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        k.b(obj);
        Thread.currentThread().setPriority(8);
        return Unit.f56620a;
    }
}
