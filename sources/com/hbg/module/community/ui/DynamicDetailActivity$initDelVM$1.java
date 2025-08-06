package com.hbg.module.community.ui;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.content.R$string;
import com.hbg.module.libkt.base.ext.VmState;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import we.b;
import xe.c;

public final class DynamicDetailActivity$initDelVM$1 extends Lambda implements l<VmState<? extends Object>, Unit> {
    public final /* synthetic */ DynamicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDetailActivity$initDelVM$1(DynamicDetailActivity dynamicDetailActivity) {
        super(1);
        this.this$0 = dynamicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VmState<? extends Object>) (VmState) obj);
        return Unit.f56620a;
    }

    public final void invoke(VmState<? extends Object> vmState) {
        if (vmState instanceof VmState.b) {
            b.m("dynamicDel", (Class) null, 2, (Object) null).g(new c(this.this$0.f17327i));
            this.this$0.finish();
        } else if (vmState instanceof VmState.a) {
            APIStatusErrorException a11 = ((VmState.a) vmState).a();
            if (a11 != null) {
                HuobiToastUtil.i(a11.getErrMsg());
            }
        } else {
            HuobiToastUtil.i(this.this$0.getResources().getString(R$string.n_service_error));
        }
    }
}
