package com.huobi.domain.data;

import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlinx.coroutines.h0;

@d(c = "com.huobi.domain.data.SmartDomainHelper$domainTestOther$1", f = "SmartDomainHelper.kt", l = {248}, m = "invokeSuspend")
final class SmartDomainHelper$domainTestOther$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public Object L$0;
    public Object L$1;
    public int label;

    public SmartDomainHelper$domainTestOther$1(c<? super SmartDomainHelper$domainTestOther$1> cVar) {
        super(2, cVar);
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new SmartDomainHelper$domainTestOther$1(cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((SmartDomainHelper$domainTestOther$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r9.label
            java.lang.String r2 = "DOMAIN_TEST"
            r3 = 1
            if (r1 == 0) goto L_0x002d
            if (r1 != r3) goto L_0x0025
            java.lang.Object r1 = r9.L$1
            okhttp3.Request r1 = (okhttp3.Request) r1
            java.lang.Object r4 = r9.L$0
            java.util.Iterator r4 = (java.util.Iterator) r4
            kotlin.k.b(r10)     // Catch:{ Exception -> 0x001e }
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r9
            goto L_0x0081
        L_0x001e:
            r10 = move-exception
            r5 = r4
            r4 = r1
            r1 = r0
            r0 = r9
            goto L_0x00a1
        L_0x0025:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x002d:
            kotlin.k.b(r10)
            java.util.List r10 = com.huobi.domain.data.SmartDomainHelper.f43847e
            java.util.Iterator r10 = r10.iterator()
            r4 = r10
            r10 = r9
        L_0x003a:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x00c6
            java.lang.Object r1 = r4.next()
            java.lang.String r1 = (java.lang.String) r1
            okhttp3.Request$Builder r5 = new okhttp3.Request$Builder
            r5.<init>()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "https://"
            r6.append(r7)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            okhttp3.Request$Builder r1 = r5.url((java.lang.String) r1)
            okhttp3.Request r1 = r1.build()
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.v0.b()     // Catch:{ Exception -> 0x009a }
            com.huobi.domain.data.SmartDomainHelper$domainTestOther$1$1$response$1 r6 = new com.huobi.domain.data.SmartDomainHelper$domainTestOther$1$1$response$1     // Catch:{ Exception -> 0x009a }
            r7 = 0
            r6.<init>(r1, r7)     // Catch:{ Exception -> 0x009a }
            r10.L$0 = r4     // Catch:{ Exception -> 0x009a }
            r10.L$1 = r1     // Catch:{ Exception -> 0x009a }
            r10.label = r3     // Catch:{ Exception -> 0x009a }
            java.lang.Object r5 = kotlinx.coroutines.g.g(r5, r6, r10)     // Catch:{ Exception -> 0x009a }
            if (r5 != r0) goto L_0x007b
            return r0
        L_0x007b:
            r8 = r0
            r0 = r10
            r10 = r5
            r5 = r4
            r4 = r1
            r1 = r8
        L_0x0081:
            okhttp3.Response r10 = (okhttp3.Response) r10     // Catch:{ Exception -> 0x0098 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0098 }
            r6.<init>()     // Catch:{ Exception -> 0x0098 }
            java.lang.String r7 = "三方域名检测成功："
            r6.append(r7)     // Catch:{ Exception -> 0x0098 }
            r6.append(r10)     // Catch:{ Exception -> 0x0098 }
            java.lang.String r10 = r6.toString()     // Catch:{ Exception -> 0x0098 }
            i6.d.c(r2, r10)     // Catch:{ Exception -> 0x0098 }
            goto L_0x00c1
        L_0x0098:
            r10 = move-exception
            goto L_0x00a1
        L_0x009a:
            r5 = move-exception
            r8 = r0
            r0 = r10
            r10 = r5
            r5 = r4
            r4 = r1
            r1 = r8
        L_0x00a1:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "三方域名检测失败："
            r6.append(r7)
            java.lang.String r10 = r10.getMessage()
            r6.append(r10)
            r10 = 44
            r6.append(r10)
            r6.append(r4)
            java.lang.String r10 = r6.toString()
            i6.d.c(r2, r10)
        L_0x00c1:
            r10 = r0
            r0 = r1
            r4 = r5
            goto L_0x003a
        L_0x00c6:
            kotlin.Unit r10 = kotlin.Unit.f56620a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.domain.data.SmartDomainHelper$domainTestOther$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
