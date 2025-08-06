package com.huobi.app.rms;

import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class HBRMSManager$downloadResourceWithModel$2 extends Lambda implements p<Long, Long, Unit> {
    public final /* synthetic */ p<Long, Long, Unit> $downloadProgressBlock;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HBRMSManager$downloadResourceWithModel$2(p<? super Long, ? super Long, Unit> pVar) {
        super(2);
        this.$downloadProgressBlock = pVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).longValue(), ((Number) obj2).longValue());
        return Unit.f56620a;
    }

    public final void invoke(long j11, long j12) {
        p<Long, Long, Unit> pVar = this.$downloadProgressBlock;
        if (pVar != null) {
            pVar.invoke(Long.valueOf(j11), Long.valueOf(j12));
        }
    }
}
