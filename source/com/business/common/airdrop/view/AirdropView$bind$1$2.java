package com.business.common.airdrop.view;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.v;
import com.business.common.airdrop.data.AirdropChannelBean;
import com.hbg.module.libkt.base.ext.f;
import d10.l;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Lambda;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class AirdropView$bind$1$2 extends Lambda implements l<AirdropChannelBean, Unit> {
    public final /* synthetic */ FragmentActivity $this_apply;
    public final /* synthetic */ AirdropView this$0;

    @d(c = "com.business.common.airdrop.view.AirdropView$bind$1$2$1", f = "AirdropView.kt", l = {140}, m = "invokeSuspend")
    /* renamed from: com.business.common.airdrop.view.AirdropView$bind$1$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(airdropChannelBean, airdropView, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.label;
            if (i11 == 0) {
                k.b(obj);
                Long ts2 = airdropChannelBean.getTs();
                if ((ts2 != null ? ts2.longValue() : 0) >= airdropView.f64313j) {
                    AirdropView airdropView = airdropView;
                    AirdropChannelBean airdropChannelBean = airdropChannelBean;
                    this.label = 1;
                    if (airdropView.u(airdropChannelBean, this) == d11) {
                        return d11;
                    }
                } else {
                    AirdropView airdropView2 = airdropView;
                    airdropView2.A("旧数据 : " + f.f(airdropChannelBean));
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirdropView$bind$1$2(FragmentActivity fragmentActivity, AirdropView airdropView) {
        super(1);
        this.$this_apply = fragmentActivity;
        this.this$0 = airdropView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AirdropChannelBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(final AirdropChannelBean airdropChannelBean) {
        LifecycleCoroutineScope a11 = v.a(this.$this_apply);
        final AirdropView airdropView = this.this$0;
        n1 unused = i.d(a11, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
