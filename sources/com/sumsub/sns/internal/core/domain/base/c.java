package com.sumsub.sns.internal.core.domain.base;

import com.sumsub.sns.internal.core.domain.model.a;
import d10.l;
import d10.p;
import kotlin.Unit;

public final class c {
    public static final <L, R> void a(a<? extends L, ? extends R> aVar, l<? super L, Unit> lVar, l<? super R, Unit> lVar2) {
        if (aVar.b()) {
            lVar2.invoke(((a.b) aVar).d());
        } else if (aVar.a()) {
            lVar.invoke(((a.C0372a) aVar).d());
        }
    }

    public static final <L, R> Object a(a<? extends L, ? extends R> aVar, p<? super L, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar, p<? super R, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar2, kotlin.coroutines.c<? super Unit> cVar) {
        if (aVar.b()) {
            Object invoke = pVar2.invoke(((a.b) aVar).d(), cVar);
            return invoke == IntrinsicsKt__IntrinsicsKt.d() ? invoke : Unit.f56620a;
        } else if (!aVar.a()) {
            return Unit.f56620a;
        } else {
            Object invoke2 = pVar.invoke(((a.C0372a) aVar).d(), cVar);
            return invoke2 == IntrinsicsKt__IntrinsicsKt.d() ? invoke2 : Unit.f56620a;
        }
    }
}
