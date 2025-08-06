package com.hbg.module.libkt.utils;

import com.hbg.lib.network.hbg.core.bean.CommonPkData;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import ue.b;

public final class CommonWidgetHelper$pkVote$1 extends Lambda implements l<CommonPkData, Unit> {
    public final /* synthetic */ b<CommonPkData> $callback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonWidgetHelper$pkVote$1(b<CommonPkData> bVar) {
        super(1);
        this.$callback = bVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommonPkData) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommonPkData commonPkData) {
        b<CommonPkData> bVar = this.$callback;
        if (bVar != null) {
            bVar.onSuccess(commonPkData);
        }
    }
}
