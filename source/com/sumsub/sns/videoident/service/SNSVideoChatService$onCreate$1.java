package com.sumsub.sns.videoident.service;

import d10.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.h0;

@d(c = "com.sumsub.sns.videoident.service.SNSVideoChatService$onCreate$1", f = "SNSVideoChatService.kt", l = {103, 106}, m = "invokeSuspend")
@Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/h0;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class SNSVideoChatService$onCreate$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ SNSVideoChatService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSVideoChatService$onCreate$1(SNSVideoChatService sNSVideoChatService, c<? super SNSVideoChatService$onCreate$1> cVar) {
        super(2, cVar);
        this.this$0 = sNSVideoChatService;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SNSVideoChatService$onCreate$1(this.this$0, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0059 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.k.b(r7)
            goto L_0x005a
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            kotlin.k.b(r7)
            goto L_0x0038
        L_0x001e:
            kotlin.k.b(r7)
            com.sumsub.sns.videoident.service.SNSVideoChatService r7 = r6.this$0
            com.sumsub.sns.internal.core.a r7 = r7.getServiceLocator()
            if (r7 == 0) goto L_0x0041
            com.sumsub.sns.internal.core.data.source.dynamic.b r7 = r7.p()
            if (r7 == 0) goto L_0x0041
            r6.label = r3
            java.lang.Object r7 = r7.d(r6)
            if (r7 != r0) goto L_0x0038
            return r0
        L_0x0038:
            com.sumsub.sns.internal.core.data.source.dynamic.b$c r7 = (com.sumsub.sns.internal.core.data.source.dynamic.b.c) r7
            if (r7 == 0) goto L_0x0041
            com.sumsub.sns.videoident.service.SNSVideoChatService r1 = r6.this$0
            r1.strings = r7
        L_0x0041:
            com.sumsub.sns.videoident.service.SNSVideoChatService r7 = r6.this$0
            androidx.lifecycle.Lifecycle r7 = r7.getLifecycle()
            androidx.lifecycle.Lifecycle$State r1 = androidx.lifecycle.Lifecycle.State.CREATED
            com.sumsub.sns.videoident.service.SNSVideoChatService$onCreate$1$2 r3 = new com.sumsub.sns.videoident.service.SNSVideoChatService$onCreate$1$2
            com.sumsub.sns.videoident.service.SNSVideoChatService r4 = r6.this$0
            r5 = 0
            r3.<init>(r4, r5)
            r6.label = r2
            java.lang.Object r7 = androidx.lifecycle.RepeatOnLifecycleKt.a(r7, r1, r3, r6)
            if (r7 != r0) goto L_0x005a
            return r0
        L_0x005a:
            kotlin.Unit r7 = kotlin.Unit.f56620a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.videoident.service.SNSVideoChatService$onCreate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((SNSVideoChatService$onCreate$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }
}
