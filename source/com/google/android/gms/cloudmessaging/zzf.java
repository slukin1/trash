package com.google.android.gms.cloudmessaging;

import android.os.Handler;

public final /* synthetic */ class zzf implements Handler.Callback {
    public final /* synthetic */ zzm zza;

    public /* synthetic */ zzf(zzm zzm) {
        this.zza = zzm;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        r5 = r5.getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005f, code lost:
        if (r5.getBoolean(com.sumsub.sns.internal.fingerprint.infoproviders.q.f34641a, false) == false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0061, code lost:
        r2.zzc(new com.google.android.gms.cloudmessaging.zzq(4, "Not supported by GmsCore", (java.lang.Throwable) null));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x006e, code lost:
        r2.zza(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r5) {
        /*
            r4 = this;
            com.google.android.gms.cloudmessaging.zzm r0 = r4.zza
            int r1 = r5.arg1
            java.lang.String r2 = "MessengerIpcClient"
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)
            if (r2 == 0) goto L_0x0025
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 41
            r2.<init>(r3)
            java.lang.String r3 = "Received response to request: "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r3 = "MessengerIpcClient"
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r3, r2)
        L_0x0025:
            monitor-enter(r0)
            android.util.SparseArray<com.google.android.gms.cloudmessaging.zzp<?>> r2 = r0.zze     // Catch:{ all -> 0x0073 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0073 }
            com.google.android.gms.cloudmessaging.zzp r2 = (com.google.android.gms.cloudmessaging.zzp) r2     // Catch:{ all -> 0x0073 }
            if (r2 != 0) goto L_0x004a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r2 = 50
            r5.<init>(r2)     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = "Received response for unknown request: "
            r5.append(r2)     // Catch:{ all -> 0x0073 }
            r5.append(r1)     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = "MessengerIpcClient"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0073 }
            android.util.Log.w(r1, r5)     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            goto L_0x0071
        L_0x004a:
            android.util.SparseArray<com.google.android.gms.cloudmessaging.zzp<?>> r3 = r0.zze     // Catch:{ all -> 0x0073 }
            r3.remove(r1)     // Catch:{ all -> 0x0073 }
            r0.zzf()     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            android.os.Bundle r5 = r5.getData()
            java.lang.String r0 = "unsupported"
            r1 = 0
            boolean r0 = r5.getBoolean(r0, r1)
            if (r0 == 0) goto L_0x006e
            com.google.android.gms.cloudmessaging.zzq r5 = new com.google.android.gms.cloudmessaging.zzq
            r0 = 4
            java.lang.String r1 = "Not supported by GmsCore"
            r3 = 0
            r5.<init>(r0, r1, r3)
            r2.zzc(r5)
            goto L_0x0071
        L_0x006e:
            r2.zza(r5)
        L_0x0071:
            r5 = 1
            return r5
        L_0x0073:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cloudmessaging.zzf.handleMessage(android.os.Message):boolean");
    }
}
