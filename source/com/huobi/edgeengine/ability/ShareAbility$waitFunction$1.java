package com.huobi.edgeengine.ability;

import d10.a;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class ShareAbility$waitFunction$1 extends Lambda implements l<Long, Unit> {
    public final /* synthetic */ a<Unit> $function;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShareAbility$waitFunction$1(a<Unit> aVar) {
        super(1);
        this.$function = aVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Long) obj);
        return Unit.f56620a;
    }

    public final void invoke(Long l11) {
        this.$function.invoke();
    }
}
