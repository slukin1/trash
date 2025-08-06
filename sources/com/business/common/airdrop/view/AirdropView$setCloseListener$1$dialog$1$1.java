package com.business.common.airdrop.view;

import com.business.common.airdrop.AirdropManager;
import com.business.common.airdrop.data.AirdropCloseIdBean;
import com.hbg.module.libkt.base.ext.g;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;

@d(c = "com.business.common.airdrop.view.AirdropView$setCloseListener$1$dialog$1$1", f = "AirdropView.kt", l = {632}, m = "invokeSuspend")
public final class AirdropView$setCloseListener$1$dialog$1$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ AirdropView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirdropView$setCloseListener$1$dialog$1$1(AirdropView airdropView, c<? super AirdropView$setCloseListener$1$dialog$1$1> cVar) {
        super(2, cVar);
        this.this$0 = airdropView;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new AirdropView$setCloseListener$1$dialog$1$1(this.this$0, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((AirdropView$setCloseListener$1$dialog$1$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object d11 = IntrinsicsKt__IntrinsicsKt.d();
        int i11 = this.label;
        if (i11 == 0) {
            k.b(obj);
            AirdropManager airdropManager = AirdropManager.f64272a;
            int k11 = this.this$0.f64308e;
            String j11 = this.this$0.f64309f;
            this.label = 1;
            obj = airdropManager.k(k11, j11, this);
            if (obj == d11) {
                return d11;
            }
        } else if (i11 == 1) {
            k.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((g) obj) instanceof g.b) {
            AirdropManager.f64272a.h().g(new AirdropCloseIdBean(this.this$0.f64315l));
        }
        return Unit.f56620a;
    }
}
