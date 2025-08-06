package com.sumsub.sentry;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public final j0 f30297a;

    public b0(j0 j0Var) {
        Objects.requireNonNull(j0Var, "The SentryStackTraceFactory is required.");
        this.f30297a = j0Var;
    }

    public final List<a0> a(Deque<a0> deque) {
        return new ArrayList(deque);
    }

    public final List<a0> b(Throwable th2) {
        return a(a(th2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.sumsub.sentry.a0 a(java.lang.Throwable r14, com.sumsub.sentry.o r15, java.lang.Thread r16, boolean r17) {
        /*
            r13 = this;
            java.lang.Class r0 = r14.getClass()
            java.lang.Package r0 = r0.getPackage()
            java.lang.Class r1 = r14.getClass()
            java.lang.String r2 = r1.getName()
            java.lang.String r1 = r14.getMessage()
            if (r0 == 0) goto L_0x0034
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r0.getName()
            r3.append(r4)
            r4 = 46
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r4 = ""
            java.lang.String r2 = kotlin.text.StringsKt__StringsJVMKt.G(r2, r3, r4, r5, r6, r7)
        L_0x0034:
            r4 = r2
            r2 = 0
            if (r0 == 0) goto L_0x003f
            java.lang.String r0 = r0.getName()
            r6 = r0
            r0 = r13
            goto L_0x0041
        L_0x003f:
            r0 = r13
            r6 = r2
        L_0x0041:
            com.sumsub.sentry.j0 r3 = r0.f30297a
            java.lang.StackTraceElement[] r5 = r14.getStackTrace()
            java.util.List r8 = r3.a((java.lang.StackTraceElement[]) r5)
            if (r8 == 0) goto L_0x0072
            boolean r3 = r8.isEmpty()
            r3 = r3 ^ 1
            if (r3 == 0) goto L_0x0057
            r3 = r8
            goto L_0x0058
        L_0x0057:
            r3 = r2
        L_0x0058:
            if (r3 == 0) goto L_0x0072
            r9 = 0
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r17)
            boolean r5 = r3.booleanValue()
            if (r5 == 0) goto L_0x0067
            r10 = r3
            goto L_0x0068
        L_0x0067:
            r10 = r2
        L_0x0068:
            com.sumsub.sentry.i0 r3 = new com.sumsub.sentry.i0
            r11 = 2
            r12 = 0
            r7 = r3
            r7.<init>((java.util.List) r8, (java.util.Map) r9, (java.lang.Boolean) r10, (int) r11, (kotlin.jvm.internal.r) r12)
            r8 = r3
            goto L_0x0073
        L_0x0072:
            r8 = r2
        L_0x0073:
            if (r16 == 0) goto L_0x007d
            long r2 = r16.getId()
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
        L_0x007d:
            r7 = r2
            com.sumsub.sentry.a0 r2 = new com.sumsub.sentry.a0
            r3 = r2
            r5 = r1
            r9 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.b0.a(java.lang.Throwable, com.sumsub.sentry.o, java.lang.Thread, boolean):com.sumsub.sentry.a0");
    }

    public final Deque<a0> a(Throwable th2) {
        Thread thread;
        boolean z11;
        o oVar;
        ArrayDeque arrayDeque = new ArrayDeque();
        HashSet hashSet = new HashSet();
        while (th2 != null && hashSet.add(th2)) {
            if (th2 instanceof i) {
                i iVar = (i) th2;
                oVar = iVar.a();
                Throwable c11 = iVar.c();
                thread = iVar.b();
                Throwable th3 = c11;
                z11 = iVar.d();
                th2 = th3;
            } else {
                thread = Thread.currentThread();
                z11 = false;
                oVar = null;
            }
            arrayDeque.addFirst(a(th2, oVar, thread, z11));
            th2 = th2.getCause();
        }
        return arrayDeque;
    }
}
