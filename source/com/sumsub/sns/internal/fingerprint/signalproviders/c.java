package com.sumsub.sns.internal.fingerprint.signalproviders;

public final class c {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34659a;

        static {
            int[] iArr = new int[StabilityLevel.values().length];
            iArr[StabilityLevel.STABLE.ordinal()] = 1;
            iArr[StabilityLevel.OPTIMAL.ordinal()] = 2;
            iArr[StabilityLevel.UNIQUE.ordinal()] = 3;
            f34659a = iArr;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r2.e() == com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel.STABLE) goto L_0x004d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0009 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<com.sumsub.sns.internal.fingerprint.signalproviders.a<?>> a(java.util.List<? extends com.sumsub.sns.internal.fingerprint.signalproviders.a<?>> r7, com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel r8) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x0009:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x0054
            java.lang.Object r1 = r7.next()
            r2 = r1
            com.sumsub.sns.internal.fingerprint.signalproviders.a r2 = (com.sumsub.sns.internal.fingerprint.signalproviders.a) r2
            int[] r3 = com.sumsub.sns.internal.fingerprint.signalproviders.c.a.f34659a
            int r4 = r8.ordinal()
            r3 = r3[r4]
            r4 = 0
            r5 = 1
            if (r3 == r5) goto L_0x0045
            r6 = 2
            if (r3 == r6) goto L_0x002f
            r2 = 3
            if (r3 != r2) goto L_0x0029
            goto L_0x004d
        L_0x0029:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x002f:
            com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel r3 = r2.e()
            com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel r6 = com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel.STABLE
            if (r3 != r6) goto L_0x0039
            r3 = r5
            goto L_0x003a
        L_0x0039:
            r3 = r4
        L_0x003a:
            com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel r2 = r2.e()
            com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel r6 = com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel.OPTIMAL
            if (r2 != r6) goto L_0x0043
            r4 = r5
        L_0x0043:
            r4 = r4 | r3
            goto L_0x004e
        L_0x0045:
            com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel r2 = r2.e()
            com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel r3 = com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel.STABLE
            if (r2 != r3) goto L_0x004e
        L_0x004d:
            r4 = r5
        L_0x004e:
            if (r4 == 0) goto L_0x0009
            r0.add(r1)
            goto L_0x0009
        L_0x0054:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.fingerprint.signalproviders.c.a(java.util.List, com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel):java.util.List");
    }
}
