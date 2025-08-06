package com.iproov.sdk;

import com.iproov.sdk.IProov;
import java.util.UUID;
import kotlin.Metadata;
import kotlinx.coroutines.flow.e;

@Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/r", "Lkotlinx/coroutines/flow/e;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
public final class IProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1 implements e<IProov.IProovSessionState> {
    public final /* synthetic */ UUID $uuid$inlined;
    public final /* synthetic */ IProovCallbackLauncher this$0;

    public IProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1(UUID uuid, IProovCallbackLauncher iProovCallbackLauncher) {
        this.$uuid$inlined = uuid;
        this.this$0 = iProovCallbackLauncher;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object emit(com.iproov.sdk.IProov.IProovSessionState r5, kotlin.coroutines.c<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.iproov.sdk.IProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.iproov.sdk.IProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1$1 r0 = (com.iproov.sdk.IProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.iproov.sdk.IProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1$1 r0 = new com.iproov.sdk.IProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r5 = r0.L$1
            com.iproov.sdk.IProov$IProovSessionState r5 = (com.iproov.sdk.IProov.IProovSessionState) r5
            java.lang.Object r0 = r0.L$0
            com.iproov.sdk.IProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1 r0 = (com.iproov.sdk.IProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1) r0
            kotlin.k.b(r6)
            goto L_0x0065
        L_0x0031:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0039:
            kotlin.k.b(r6)
            com.iproov.sdk.IProov$IProovSessionState r5 = (com.iproov.sdk.IProov.IProovSessionState) r5
            if (r5 != 0) goto L_0x0041
            goto L_0x009b
        L_0x0041:
            com.iproov.sdk.IProov$Session r6 = r5.getSession()
            java.util.UUID r6 = r6.getUuid()
            java.util.UUID r2 = r4.$uuid$inlined
            boolean r6 = kotlin.jvm.internal.x.b(r6, r2)
            if (r6 == 0) goto L_0x009b
            com.iproov.sdk.IProovCallbackLauncher r6 = r4.this$0
            com.iproov.sdk.IProov$IProovState r2 = r5.getState()
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.dispatchToListener(r2, r0)
            if (r6 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r0 = r4
        L_0x0065:
            com.iproov.sdk.IProov$IProovState r6 = r5.getState()
            boolean r6 = r6.isFinal()
            if (r6 == 0) goto L_0x009b
            com.iproov.sdk.IProovCallbackLauncher r6 = r0.this$0
            java.util.Map r6 = r6.jobs
            com.iproov.sdk.IProov$Session r1 = r5.getSession()
            java.util.UUID r1 = r1.getUuid()
            java.lang.Object r6 = r6.get(r1)
            kotlinx.coroutines.n1 r6 = (kotlinx.coroutines.n1) r6
            if (r6 != 0) goto L_0x0086
            goto L_0x008a
        L_0x0086:
            r1 = 0
            kotlinx.coroutines.n1.a.a(r6, r1, r3, r1)
        L_0x008a:
            com.iproov.sdk.IProovCallbackLauncher r6 = r0.this$0
            java.util.Map r6 = r6.jobs
            com.iproov.sdk.IProov$Session r5 = r5.getSession()
            java.util.UUID r5 = r5.getUuid()
            r6.remove(r5)
        L_0x009b:
            kotlin.Unit r5 = kotlin.Unit.f56620a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.IProovCallbackLauncher$createListenerJob$job$1$invokeSuspend$$inlined$collect$1.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }
}
