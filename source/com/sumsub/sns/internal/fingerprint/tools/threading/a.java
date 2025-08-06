package com.sumsub.sns.internal.fingerprint.tools.threading;

import kotlin.Result;
import kotlin.Unit;
import kotlin.k;

public final class a {
    public static final Object a(d10.a<Unit> aVar) {
        try {
            Result.a aVar2 = Result.Companion;
            b.b().submit(new c(aVar));
            return Result.m3072constructorimpl(Unit.f56620a);
        } catch (Throwable th2) {
            Result.a aVar3 = Result.Companion;
            return Result.m3072constructorimpl(k.a(th2));
        }
    }

    public static final void b(d10.a aVar) {
        aVar.invoke();
    }
}
