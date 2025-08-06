package kotlinx.coroutines;

import d10.p;
import f10.b;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;

public final class TimeoutKt {
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r4 == null) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlinx.coroutines.TimeoutCancellationException a(long r2, kotlinx.coroutines.p0 r4, kotlinx.coroutines.n1 r5) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.q0
            if (r0 == 0) goto L_0x0007
            kotlinx.coroutines.q0 r4 = (kotlinx.coroutines.q0) r4
            goto L_0x0008
        L_0x0007:
            r4 = 0
        L_0x0008:
            if (r4 == 0) goto L_0x0018
            kotlin.time.b$a r0 = kotlin.time.b.f56931c
            kotlin.time.DurationUnit r0 = kotlin.time.DurationUnit.MILLISECONDS
            long r0 = kotlin.time.d.t(r2, r0)
            java.lang.String r4 = r4.r(r0)
            if (r4 != 0) goto L_0x002e
        L_0x0018:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Timed out waiting for "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = " ms"
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L_0x002e:
            kotlinx.coroutines.TimeoutCancellationException r2 = new kotlinx.coroutines.TimeoutCancellationException
            r2.<init>(r4, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.a(long, kotlinx.coroutines.p0, kotlinx.coroutines.n1):kotlinx.coroutines.TimeoutCancellationException");
    }

    public static final <U, T extends U> Object b(m2<U, ? super T> m2Var, p<? super h0, ? super c<? super T>, ? extends Object> pVar) {
        p1.h(m2Var, DelayKt.c(m2Var.f57351e.getContext()).u(m2Var.f57381f, m2Var, m2Var.getContext()));
        return b.d(m2Var, m2Var, pVar);
    }

    public static final <T> Object c(long j11, p<? super h0, ? super c<? super T>, ? extends Object> pVar, c<? super T> cVar) {
        if (j11 > 0) {
            Object b11 = b(new m2(j11, cVar), pVar);
            if (b11 == IntrinsicsKt__IntrinsicsKt.d()) {
                f.c(cVar);
            }
            return b11;
        }
        throw new TimeoutCancellationException("Timed out immediately");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object d(long r7, d10.p<? super kotlinx.coroutines.h0, ? super kotlin.coroutines.c<? super T>, ? extends java.lang.Object> r9, kotlin.coroutines.c<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = (kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 r0 = new kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            java.lang.Object r7 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref$ObjectRef) r7
            java.lang.Object r8 = r0.L$0
            d10.p r8 = (d10.p) r8
            kotlin.k.b(r10)     // Catch:{ TimeoutCancellationException -> 0x0032 }
            goto L_0x006b
        L_0x0032:
            r8 = move-exception
            goto L_0x006e
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            kotlin.k.b(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L_0x0046
            return r3
        L_0x0046:
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            r0.L$0 = r9     // Catch:{ TimeoutCancellationException -> 0x006c }
            r0.L$1 = r10     // Catch:{ TimeoutCancellationException -> 0x006c }
            r0.J$0 = r7     // Catch:{ TimeoutCancellationException -> 0x006c }
            r0.label = r4     // Catch:{ TimeoutCancellationException -> 0x006c }
            kotlinx.coroutines.m2 r2 = new kotlinx.coroutines.m2     // Catch:{ TimeoutCancellationException -> 0x006c }
            r2.<init>(r7, r0)     // Catch:{ TimeoutCancellationException -> 0x006c }
            r10.element = r2     // Catch:{ TimeoutCancellationException -> 0x006c }
            java.lang.Object r7 = b(r2, r9)     // Catch:{ TimeoutCancellationException -> 0x006c }
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()     // Catch:{ TimeoutCancellationException -> 0x006c }
            if (r7 != r8) goto L_0x0067
            kotlin.coroutines.jvm.internal.f.c(r0)     // Catch:{ TimeoutCancellationException -> 0x006c }
        L_0x0067:
            if (r7 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r10 = r7
        L_0x006b:
            return r10
        L_0x006c:
            r8 = move-exception
            r7 = r10
        L_0x006e:
            kotlinx.coroutines.n1 r9 = r8.coroutine
            T r7 = r7.element
            if (r9 != r7) goto L_0x0075
            return r3
        L_0x0075:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.TimeoutKt.d(long, d10.p, kotlin.coroutines.c):java.lang.Object");
    }
}
