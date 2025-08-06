package com.business.common.airdrop.view;

import com.hbg.lib.network.hbg.core.bean.AirdropDetailBean;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Ref$LongRef;
import kotlinx.coroutines.h0;

@d(c = "com.business.common.airdrop.view.AirdropView$showClaimCountdown$job$1", f = "AirdropView.kt", l = {483}, m = "invokeSuspend")
public final class AirdropView$showClaimCountdown$job$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public final /* synthetic */ Ref$LongRef $countdownSecond;
    public final /* synthetic */ AirdropDetailBean $data;
    private /* synthetic */ Object L$0;
    public int label;
    public final /* synthetic */ AirdropView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AirdropView$showClaimCountdown$job$1(Ref$LongRef ref$LongRef, AirdropView airdropView, AirdropDetailBean airdropDetailBean, c<? super AirdropView$showClaimCountdown$job$1> cVar) {
        super(2, cVar);
        this.$countdownSecond = ref$LongRef;
        this.this$0 = airdropView;
        this.$data = airdropDetailBean;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        AirdropView$showClaimCountdown$job$1 airdropView$showClaimCountdown$job$1 = new AirdropView$showClaimCountdown$job$1(this.$countdownSecond, this.this$0, this.$data, cVar);
        airdropView$showClaimCountdown$job$1.L$0 = obj;
        return airdropView$showClaimCountdown$job$1;
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((AirdropView$showClaimCountdown$job$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r10.label
            r2 = 1
            if (r1 == 0) goto L_0x001d
            if (r1 != r2) goto L_0x0015
            java.lang.Object r1 = r10.L$0
            kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
            kotlin.k.b(r11)
            r11 = r10
            goto L_0x00a1
        L_0x0015:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x001d:
            kotlin.k.b(r11)
            java.lang.Object r11 = r10.L$0
            kotlinx.coroutines.h0 r11 = (kotlinx.coroutines.h0) r11
            r1 = r11
            r11 = r10
        L_0x0026:
            boolean r3 = kotlinx.coroutines.i0.i(r1)
            if (r3 == 0) goto L_0x00ac
            kotlin.jvm.internal.Ref$LongRef r3 = r11.$countdownSecond
            long r3 = r3.element
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0068
            com.business.common.airdrop.view.AirdropView r0 = r11.this$0
            boolean r0 = r0.z()
            if (r0 == 0) goto L_0x00ac
            com.business.common.airdrop.view.AirdropView r0 = r11.this$0
            i4.k r0 = r0.f64305b
            com.huobi.view.roundview.RoundTextView r0 = r0.D
            com.business.common.airdrop.view.AirdropView r1 = r11.this$0
            android.content.Context r1 = r1.getContext()
            com.hbg.lib.network.hbg.core.bean.AirdropDetailBean r11 = r11.$data
            java.lang.Integer r11 = r11.getAwarded()
            if (r11 != 0) goto L_0x0055
            goto L_0x005e
        L_0x0055:
            int r11 = r11.intValue()
            if (r11 != r2) goto L_0x005e
            int r11 = com.business.common.R$string.n_content_ugc_coin_received
            goto L_0x0060
        L_0x005e:
            int r11 = com.business.common.R$string.n_coupon_draw_btn_title
        L_0x0060:
            java.lang.String r11 = r1.getString(r11)
            r0.setText(r11)
            goto L_0x00ac
        L_0x0068:
            com.business.common.airdrop.view.AirdropView r3 = r11.this$0
            boolean r3 = r3.z()
            if (r3 == 0) goto L_0x0094
            com.business.common.airdrop.view.AirdropView r3 = r11.this$0
            i4.k r3 = r3.f64305b
            com.huobi.view.roundview.RoundTextView r3 = r3.D
            com.business.common.airdrop.view.AirdropView r4 = r11.this$0
            android.content.Context r4 = r4.getContext()
            int r5 = com.business.common.R$string.n_airdrop_count_down_claim_second
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r7 = 0
            kotlin.jvm.internal.Ref$LongRef r8 = r11.$countdownSecond
            long r8 = r8.element
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r6[r7] = r8
            java.lang.String r4 = r4.getString(r5, r6)
            r3.setText(r4)
        L_0x0094:
            r3 = 1000(0x3e8, double:4.94E-321)
            r11.L$0 = r1
            r11.label = r2
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.b(r3, r11)
            if (r3 != r0) goto L_0x00a1
            return r0
        L_0x00a1:
            kotlin.jvm.internal.Ref$LongRef r3 = r11.$countdownSecond
            long r4 = r3.element
            r6 = 1
            long r4 = r4 - r6
            r3.element = r4
            goto L_0x0026
        L_0x00ac:
            kotlin.Unit r11 = kotlin.Unit.f56620a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.common.airdrop.view.AirdropView$showClaimCountdown$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
