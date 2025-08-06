package com.sumsub.sns.internal.core.data.model;

public final class k {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f32639a;

        static {
            int[] iArr = new int[ReviewStatusType.values().length];
            iArr[ReviewStatusType.Init.ordinal()] = 1;
            iArr[ReviewStatusType.Queued.ordinal()] = 2;
            iArr[ReviewStatusType.Pending.ordinal()] = 3;
            iArr[ReviewStatusType.Prechecked.ordinal()] = 4;
            iArr[ReviewStatusType.Completed.ordinal()] = 5;
            iArr[ReviewStatusType.Unknown.ordinal()] = 6;
            f32639a = iArr;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00ea, code lost:
        r0 = r0.j();
     */
    /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x012b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.core.data.model.SNSSDKState a(com.sumsub.sns.internal.core.data.model.g r4, java.util.List<com.sumsub.sns.internal.core.data.model.Document> r5) {
        /*
            com.sumsub.sns.internal.core.data.model.ReviewStatusType r0 = r4.K()
            int[] r1 = com.sumsub.sns.internal.core.data.model.k.a.f32639a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 0
            r2 = 0
            r3 = 1
            switch(r0) {
                case 1: goto L_0x0071;
                case 2: goto L_0x0036;
                case 3: goto L_0x0036;
                case 4: goto L_0x0036;
                case 5: goto L_0x0018;
                case 6: goto L_0x012d;
                default: goto L_0x0012;
            }
        L_0x0012:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        L_0x0018:
            boolean r5 = r4.M()
            if (r5 == 0) goto L_0x0022
            com.sumsub.sns.core.data.model.SNSSDKState$Approved r1 = com.sumsub.sns.core.data.model.SNSSDKState.Approved.INSTANCE
            goto L_0x012d
        L_0x0022:
            boolean r5 = r4.O()
            if (r5 == 0) goto L_0x002c
            com.sumsub.sns.core.data.model.SNSSDKState$FinallyRejected r1 = com.sumsub.sns.core.data.model.SNSSDKState.FinallyRejected.INSTANCE
            goto L_0x012d
        L_0x002c:
            boolean r4 = r4.P()
            if (r4 == 0) goto L_0x012d
            com.sumsub.sns.core.data.model.SNSSDKState$TemporarilyDeclined r1 = com.sumsub.sns.core.data.model.SNSSDKState.TemporarilyDeclined.INSTANCE
            goto L_0x012d
        L_0x0036:
            com.sumsub.sns.internal.core.data.model.g$c r0 = r4.I()
            boolean r0 = r0.k()
            if (r0 == 0) goto L_0x006d
            java.util.List r4 = com.sumsub.sns.internal.core.common.i.a((java.util.List<com.sumsub.sns.internal.core.data.model.Document>) r5, (com.sumsub.sns.internal.core.data.model.g) r4)
            boolean r5 = r4 instanceof java.util.Collection
            if (r5 == 0) goto L_0x004f
            boolean r5 = r4.isEmpty()
            if (r5 == 0) goto L_0x004f
            goto L_0x0067
        L_0x004f:
            java.util.Iterator r4 = r4.iterator()
        L_0x0053:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0067
            java.lang.Object r5 = r4.next()
            com.sumsub.sns.internal.core.data.model.Document r5 = (com.sumsub.sns.internal.core.data.model.Document) r5
            boolean r5 = r5.isSubmitted()
            r5 = r5 ^ r3
            if (r5 == 0) goto L_0x0053
            r2 = r3
        L_0x0067:
            if (r2 == 0) goto L_0x006d
            com.sumsub.sns.core.data.model.SNSSDKState$Incomplete r1 = com.sumsub.sns.core.data.model.SNSSDKState.Incomplete.INSTANCE
            goto L_0x012d
        L_0x006d:
            com.sumsub.sns.core.data.model.SNSSDKState$Pending r1 = com.sumsub.sns.core.data.model.SNSSDKState.Pending.INSTANCE
            goto L_0x012d
        L_0x0071:
            boolean r4 = r5.isEmpty()
            if (r4 == 0) goto L_0x007b
            com.sumsub.sns.core.data.model.SNSSDKState$Failed$ApplicantMisconfigured r1 = com.sumsub.sns.core.data.model.SNSSDKState.Failed.ApplicantMisconfigured.INSTANCE
            goto L_0x012d
        L_0x007b:
            boolean r4 = r5.isEmpty()
            if (r4 == 0) goto L_0x0082
            goto L_0x009f
        L_0x0082:
            java.util.Iterator r4 = r5.iterator()
        L_0x0086:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x009f
            java.lang.Object r0 = r4.next()
            com.sumsub.sns.internal.core.data.model.Document r0 = (com.sumsub.sns.internal.core.data.model.Document) r0
            com.sumsub.sns.internal.core.data.model.Document$b r0 = r0.getResult()
            if (r0 != 0) goto L_0x009a
            r0 = r3
            goto L_0x009b
        L_0x009a:
            r0 = r2
        L_0x009b:
            if (r0 != 0) goto L_0x0086
            r4 = r2
            goto L_0x00a0
        L_0x009f:
            r4 = r3
        L_0x00a0:
            if (r4 == 0) goto L_0x00a6
            com.sumsub.sns.core.data.model.SNSSDKState$Initial r1 = com.sumsub.sns.core.data.model.SNSSDKState.Initial.INSTANCE
            goto L_0x012d
        L_0x00a6:
            boolean r4 = r5.isEmpty()
            if (r4 == 0) goto L_0x00ad
            goto L_0x00ca
        L_0x00ad:
            java.util.Iterator r4 = r5.iterator()
        L_0x00b1:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x00ca
            java.lang.Object r0 = r4.next()
            com.sumsub.sns.internal.core.data.model.Document r0 = (com.sumsub.sns.internal.core.data.model.Document) r0
            com.sumsub.sns.internal.core.data.model.Document$b r0 = r0.getResult()
            if (r0 == 0) goto L_0x00c5
            r0 = r3
            goto L_0x00c6
        L_0x00c5:
            r0 = r2
        L_0x00c6:
            if (r0 == 0) goto L_0x00b1
            r4 = r3
            goto L_0x00cb
        L_0x00ca:
            r4 = r2
        L_0x00cb:
            if (r4 == 0) goto L_0x0105
            boolean r4 = r5.isEmpty()
            if (r4 == 0) goto L_0x00d4
            goto L_0x00ff
        L_0x00d4:
            java.util.Iterator r4 = r5.iterator()
        L_0x00d8:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x00ff
            java.lang.Object r0 = r4.next()
            com.sumsub.sns.internal.core.data.model.Document r0 = (com.sumsub.sns.internal.core.data.model.Document) r0
            com.sumsub.sns.internal.core.data.model.Document$b r0 = r0.getResult()
            if (r0 == 0) goto L_0x00f5
            com.sumsub.sns.internal.core.data.model.Document$b$b r0 = r0.j()
            if (r0 == 0) goto L_0x00f5
            com.sumsub.sns.internal.core.data.model.ReviewAnswerType r0 = r0.e()
            goto L_0x00f6
        L_0x00f5:
            r0 = r1
        L_0x00f6:
            if (r0 != 0) goto L_0x00fa
            r0 = r3
            goto L_0x00fb
        L_0x00fa:
            r0 = r2
        L_0x00fb:
            if (r0 == 0) goto L_0x00d8
            r4 = r3
            goto L_0x0100
        L_0x00ff:
            r4 = r2
        L_0x0100:
            if (r4 == 0) goto L_0x0105
            com.sumsub.sns.core.data.model.SNSSDKState$Incomplete r1 = com.sumsub.sns.core.data.model.SNSSDKState.Incomplete.INSTANCE
            goto L_0x012d
        L_0x0105:
            boolean r4 = r5.isEmpty()
            if (r4 == 0) goto L_0x010c
            goto L_0x0128
        L_0x010c:
            java.util.Iterator r4 = r5.iterator()
        L_0x0110:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0128
            java.lang.Object r5 = r4.next()
            com.sumsub.sns.internal.core.data.model.Document r5 = (com.sumsub.sns.internal.core.data.model.Document) r5
            com.sumsub.sns.internal.core.data.model.Document$b r5 = r5.getResult()
            if (r5 == 0) goto L_0x0124
            r5 = r3
            goto L_0x0125
        L_0x0124:
            r5 = r2
        L_0x0125:
            if (r5 != 0) goto L_0x0110
            goto L_0x0129
        L_0x0128:
            r2 = r3
        L_0x0129:
            if (r2 == 0) goto L_0x012d
            com.sumsub.sns.core.data.model.SNSSDKState$Pending r1 = com.sumsub.sns.core.data.model.SNSSDKState.Pending.INSTANCE
        L_0x012d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.k.a(com.sumsub.sns.internal.core.data.model.g, java.util.List):com.sumsub.sns.core.data.model.SNSSDKState");
    }
}
