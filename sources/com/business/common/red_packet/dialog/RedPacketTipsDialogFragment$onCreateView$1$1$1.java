package com.business.common.red_packet.dialog;

import com.business.common.red_packet.RedPacketManager;
import com.hbg.lib.core.BaseModuleConfig;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import ku.b;

@d(c = "com.business.common.red_packet.dialog.RedPacketTipsDialogFragment$onCreateView$1$1$1", f = "RedPacketTipsDialogFragment.kt", l = {53}, m = "invokeSuspend")
public final class RedPacketTipsDialogFragment$onCreateView$1$1$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ RedPacketTipsDialogFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RedPacketTipsDialogFragment$onCreateView$1$1$1(RedPacketTipsDialogFragment redPacketTipsDialogFragment, c<? super RedPacketTipsDialogFragment$onCreateView$1$1$1> cVar) {
        super(2, cVar);
        this.this$0 = redPacketTipsDialogFragment;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new RedPacketTipsDialogFragment$onCreateView$1$1$1(this.this$0, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((RedPacketTipsDialogFragment$onCreateView$1$1$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        String str = "";
        if (i11 == 0) {
            k.b(obj);
            String h11 = b.e().h(this.this$0.requireContext());
            String codeWord = this.this$0.f64343b.getCodeWord();
            if (codeWord == null) {
                codeWord = str;
            }
            this.label = 1;
            obj = RedPacketManager.c(codeWord, h11, this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Boolean) obj).booleanValue()) {
            String redCollectDetailUrl = this.this$0.f64343b.getRedCollectDetailUrl();
            if (redCollectDetailUrl != null) {
                str = redCollectDetailUrl;
            }
            String k11 = BaseModuleConfig.a().k(StringsKt__StringsKt.A0(str, "/"));
            BaseModuleConfig.a a11 = BaseModuleConfig.a();
            if (a11 != null) {
                a11.k0(k11);
            }
        }
        this.this$0.dismiss();
        return Unit.f56620a;
    }
}
