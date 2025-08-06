package com.huawei.hms.adapter;

import android.content.Context;

public class OuterBinderAdapter extends BinderAdapter {

    /* renamed from: j  reason: collision with root package name */
    private static final Object f37730j = new Object();

    /* renamed from: k  reason: collision with root package name */
    private static BinderAdapter f37731k;

    /* renamed from: l  reason: collision with root package name */
    private static String f37732l;

    /* renamed from: m  reason: collision with root package name */
    private static String f37733m;

    private OuterBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.huawei.hms.adapter.BinderAdapter getInstance(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "OuterBinderAdapter"
            java.lang.String r1 = "OuterBinderAdapter getInstance."
            com.huawei.hms.support.log.HMSLog.i(r0, r1)
            java.lang.Object r0 = f37730j
            monitor-enter(r0)
            com.huawei.hms.adapter.BinderAdapter r1 = f37731k     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x001a
            f37732l = r4     // Catch:{ all -> 0x004b }
            f37733m = r5     // Catch:{ all -> 0x004b }
            com.huawei.hms.adapter.OuterBinderAdapter r1 = new com.huawei.hms.adapter.OuterBinderAdapter     // Catch:{ all -> 0x004b }
            r1.<init>(r3, r4, r5)     // Catch:{ all -> 0x004b }
            f37731k = r1     // Catch:{ all -> 0x004b }
            goto L_0x0047
        L_0x001a:
            java.lang.String r1 = f37732l     // Catch:{ all -> 0x004b }
            boolean r1 = com.huawei.hms.common.internal.Objects.equal(r1, r4)     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x002d
            java.lang.String r1 = f37733m     // Catch:{ all -> 0x004b }
            boolean r1 = com.huawei.hms.common.internal.Objects.equal(r1, r5)     // Catch:{ all -> 0x004b }
            if (r1 != 0) goto L_0x002b
            goto L_0x002d
        L_0x002b:
            r1 = 0
            goto L_0x002e
        L_0x002d:
            r1 = 1
        L_0x002e:
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = "OuterBinderAdapter"
            java.lang.String r2 = "OuterBinderAdapter getInstance refresh adapter"
            com.huawei.hms.support.log.HMSLog.i(r1, r2)     // Catch:{ all -> 0x004b }
            f37732l = r4     // Catch:{ all -> 0x004b }
            f37733m = r5     // Catch:{ all -> 0x004b }
            com.huawei.hms.adapter.BinderAdapter r1 = f37731k     // Catch:{ all -> 0x004b }
            r1.unBind()     // Catch:{ all -> 0x004b }
            com.huawei.hms.adapter.OuterBinderAdapter r1 = new com.huawei.hms.adapter.OuterBinderAdapter     // Catch:{ all -> 0x004b }
            r1.<init>(r3, r4, r5)     // Catch:{ all -> 0x004b }
            f37731k = r1     // Catch:{ all -> 0x004b }
        L_0x0047:
            com.huawei.hms.adapter.BinderAdapter r3 = f37731k     // Catch:{ all -> 0x004b }
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            return r3
        L_0x004b:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.adapter.OuterBinderAdapter.getInstance(android.content.Context, java.lang.String, java.lang.String):com.huawei.hms.adapter.BinderAdapter");
    }

    public int getConnTimeOut() {
        return 1001;
    }

    public int getMsgDelayDisconnect() {
        return 1002;
    }
}
