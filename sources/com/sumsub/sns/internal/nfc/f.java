package com.sumsub.sns.internal.nfc;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class f {

    @d(c = "com.sumsub.sns.internal.nfc.RunWithRetryKt", f = "RunWithRetry.kt", l = {20}, m = "runWithRetry")
    public static final class a<T> extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public int f35201a;

        /* renamed from: b  reason: collision with root package name */
        public int f35202b;

        /* renamed from: c  reason: collision with root package name */
        public int f35203c;

        /* renamed from: d  reason: collision with root package name */
        public Object f35204d;

        /* renamed from: e  reason: collision with root package name */
        public /* synthetic */ Object f35205e;

        /* renamed from: f  reason: collision with root package name */
        public int f35206f;

        public a(c<? super a> cVar) {
            super(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f35205e = obj;
            this.f35206f |= Integer.MIN_VALUE;
            return f.a(0, 0, (d10.a) null, this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object a(int r7, int r8, d10.a<? extends T> r9, kotlin.coroutines.c<? super T> r10) {
        /*
            boolean r0 = r10 instanceof com.sumsub.sns.internal.nfc.f.a
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.sumsub.sns.internal.nfc.f$a r0 = (com.sumsub.sns.internal.nfc.f.a) r0
            int r1 = r0.f35206f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f35206f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.nfc.f$a r0 = new com.sumsub.sns.internal.nfc.f$a
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.f35205e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f35206f
            r3 = 1
            if (r2 == 0) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            int r7 = r0.f35203c
            int r8 = r0.f35202b
            int r9 = r0.f35201a
            java.lang.Object r2 = r0.f35204d
            d10.a r2 = (d10.a) r2
            kotlin.k.b(r10)
            r10 = r2
            r6 = r9
            r9 = r8
            r8 = r6
            goto L_0x0064
        L_0x0037:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003f:
            kotlin.k.b(r10)
            r10 = 0
            if (r7 < 0) goto L_0x006a
            r6 = r8
            r8 = r7
            r7 = r10
            r10 = r9
            r9 = r6
        L_0x004a:
            java.lang.Object r7 = r10.invoke()     // Catch:{ all -> 0x004f }
            return r7
        L_0x004f:
            r2 = move-exception
            if (r7 == r8) goto L_0x0069
            long r4 = (long) r9
            r0.f35204d = r10
            r0.f35201a = r8
            r0.f35202b = r9
            r0.f35203c = r7
            r0.f35206f = r3
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.b(r4, r0)
            if (r2 != r1) goto L_0x0064
            return r1
        L_0x0064:
            if (r7 == r8) goto L_0x006a
            int r7 = r7 + 1
            goto L_0x004a
        L_0x0069:
            throw r2
        L_0x006a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Impossible state"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.nfc.f.a(int, int, d10.a, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object a(int i11, int i12, d10.a aVar, c cVar, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 1;
        }
        if ((i13 & 2) != 0) {
            i12 = 300;
        }
        return a(i11, i12, aVar, cVar);
    }
}
