package com.business.common.airdrop.view;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.v;
import com.business.common.airdrop.data.AirdropHeaderBean;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
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

public final class AirdropView$bind$1$1 extends Lambda implements l<AirdropHeaderBean, Unit> {
    public final /* synthetic */ FragmentActivity $this_apply;
    public final /* synthetic */ AirdropView this$0;

    @d(c = "com.business.common.airdrop.view.AirdropView$bind$1$1$1", f = "AirdropView.kt", l = {133}, m = "invokeSuspend")
    /* renamed from: com.business.common.airdrop.view.AirdropView$bind$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(airdropHeaderBean, airdropView, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.label;
            if (i11 == 0) {
                k.b(obj);
                LogAndWoodRecorder.a("Airdrop", "Header-Observe(" + f.f(airdropHeaderBean) + ')');
                AirdropView airdropView = airdropView;
                AirdropHeaderBean airdropHeaderBean = airdropHeaderBean;
                this.label = 1;
                if (airdropView.w(airdropHeaderBean, this) == d11) {
                    return d11;
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
    public AirdropView$bind$1$1(FragmentActivity fragmentActivity, AirdropView airdropView) {
        super(1);
        this.$this_apply = fragmentActivity;
        this.this$0 = airdropView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AirdropHeaderBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(final AirdropHeaderBean airdropHeaderBean) {
        LifecycleCoroutineScope a11 = v.a(this.$this_apply);
        final AirdropView airdropView = this.this$0;
        n1 unused = i.d(a11, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
    }
}
