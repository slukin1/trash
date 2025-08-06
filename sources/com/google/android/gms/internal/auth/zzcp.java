package com.google.android.gms.internal.auth;

public final class zzcp {
    private static volatile zzdh zza;

    private zzcp() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:68|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        throw r14;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:68:0x015e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.auth.zzdh zza(android.content.Context r14) {
        /*
            java.lang.Class<com.google.android.gms.internal.auth.zzcp> r0 = com.google.android.gms.internal.auth.zzcp.class
            monitor-enter(r0)
            com.google.android.gms.internal.auth.zzdh r1 = zza     // Catch:{ all -> 0x0179 }
            if (r1 != 0) goto L_0x0177
            java.lang.String r1 = android.os.Build.TYPE     // Catch:{ all -> 0x0179 }
            java.lang.String r2 = android.os.Build.TAGS     // Catch:{ all -> 0x0179 }
            java.lang.String r3 = "eng"
            boolean r3 = r1.equals(r3)     // Catch:{ all -> 0x0179 }
            if (r3 != 0) goto L_0x001c
            java.lang.String r3 = "userdebug"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x0179 }
            if (r1 == 0) goto L_0x002e
        L_0x001c:
            java.lang.String r1 = "dev-keys"
            boolean r1 = r2.contains(r1)     // Catch:{ all -> 0x0179 }
            if (r1 != 0) goto L_0x0035
            java.lang.String r1 = "test-keys"
            boolean r1 = r2.contains(r1)     // Catch:{ all -> 0x0179 }
            if (r1 == 0) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            com.google.android.gms.internal.auth.zzdh r14 = com.google.android.gms.internal.auth.zzdh.zzc()     // Catch:{ all -> 0x0179 }
        L_0x0032:
            r1 = r14
            goto L_0x016f
        L_0x0035:
            boolean r1 = com.google.android.gms.internal.auth.zzcc.zzb()     // Catch:{ all -> 0x0179 }
            if (r1 == 0) goto L_0x0045
            boolean r1 = r14.isDeviceProtectedStorage()     // Catch:{ all -> 0x0179 }
            if (r1 != 0) goto L_0x0045
            android.content.Context r14 = r14.createDeviceProtectedStorageContext()     // Catch:{ all -> 0x0179 }
        L_0x0045:
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()     // Catch:{ all -> 0x0179 }
            android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ all -> 0x0172 }
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ RuntimeException -> 0x006a }
            java.lang.String r4 = "phenotype_hermetic"
            java.io.File r4 = r14.getDir(r4, r2)     // Catch:{ RuntimeException -> 0x006a }
            java.lang.String r5 = "overrides.txt"
            r3.<init>(r4, r5)     // Catch:{ RuntimeException -> 0x006a }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0172 }
            if (r4 == 0) goto L_0x0065
            com.google.android.gms.internal.auth.zzdh r3 = com.google.android.gms.internal.auth.zzdh.zzd(r3)     // Catch:{ all -> 0x0172 }
            goto L_0x0076
        L_0x0065:
            com.google.android.gms.internal.auth.zzdh r3 = com.google.android.gms.internal.auth.zzdh.zzc()     // Catch:{ all -> 0x0172 }
            goto L_0x0076
        L_0x006a:
            r3 = move-exception
            java.lang.String r4 = "HermeticFileOverrides"
            java.lang.String r5 = "no data dir"
            android.util.Log.e(r4, r5, r3)     // Catch:{ all -> 0x0172 }
            com.google.android.gms.internal.auth.zzdh r3 = com.google.android.gms.internal.auth.zzdh.zzc()     // Catch:{ all -> 0x0172 }
        L_0x0076:
            boolean r4 = r3.zzb()     // Catch:{ all -> 0x0172 }
            if (r4 == 0) goto L_0x0166
            java.lang.Object r3 = r3.zza()     // Catch:{ all -> 0x0172 }
            java.io.File r3 = (java.io.File) r3     // Catch:{ all -> 0x0172 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x015f }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x015f }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x015f }
            r6.<init>(r3)     // Catch:{ IOException -> 0x015f }
            r5.<init>(r6)     // Catch:{ IOException -> 0x015f }
            r4.<init>(r5)     // Catch:{ IOException -> 0x015f }
            r5 = 1
            androidx.collection.SimpleArrayMap r6 = new androidx.collection.SimpleArrayMap     // Catch:{ all -> 0x0143 }
            r6.<init>()     // Catch:{ all -> 0x0143 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0143 }
            r7.<init>()     // Catch:{ all -> 0x0143 }
        L_0x009c:
            java.lang.String r8 = r4.readLine()     // Catch:{ all -> 0x0143 }
            if (r8 == 0) goto L_0x0110
            java.lang.String r9 = " "
            r10 = 3
            java.lang.String[] r9 = r8.split(r9, r10)     // Catch:{ all -> 0x0143 }
            int r11 = r9.length     // Catch:{ all -> 0x0143 }
            if (r11 == r10) goto L_0x00c3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0143 }
            r9.<init>()     // Catch:{ all -> 0x0143 }
            java.lang.String r10 = "Invalid: "
            r9.append(r10)     // Catch:{ all -> 0x0143 }
            r9.append(r8)     // Catch:{ all -> 0x0143 }
            java.lang.String r8 = "HermeticFileOverrides"
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0143 }
            android.util.Log.e(r8, r9)     // Catch:{ all -> 0x0143 }
            goto L_0x009c
        L_0x00c3:
            r8 = r9[r2]     // Catch:{ all -> 0x0143 }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x0143 }
            r10.<init>(r8)     // Catch:{ all -> 0x0143 }
            r8 = r9[r5]     // Catch:{ all -> 0x0143 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0143 }
            r11.<init>(r8)     // Catch:{ all -> 0x0143 }
            java.lang.String r8 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x0143 }
            r11 = 2
            r12 = r9[r11]     // Catch:{ all -> 0x0143 }
            java.lang.Object r12 = r7.get(r12)     // Catch:{ all -> 0x0143 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0143 }
            if (r12 != 0) goto L_0x00f8
            r9 = r9[r11]     // Catch:{ all -> 0x0143 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0143 }
            r11.<init>(r9)     // Catch:{ all -> 0x0143 }
            java.lang.String r12 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x0143 }
            int r9 = r12.length()     // Catch:{ all -> 0x0143 }
            r13 = 1024(0x400, float:1.435E-42)
            if (r9 < r13) goto L_0x00f5
            if (r12 != r11) goto L_0x00f8
        L_0x00f5:
            r7.put(r11, r12)     // Catch:{ all -> 0x0143 }
        L_0x00f8:
            boolean r9 = r6.containsKey(r10)     // Catch:{ all -> 0x0143 }
            if (r9 != 0) goto L_0x0106
            androidx.collection.SimpleArrayMap r9 = new androidx.collection.SimpleArrayMap     // Catch:{ all -> 0x0143 }
            r9.<init>()     // Catch:{ all -> 0x0143 }
            r6.put(r10, r9)     // Catch:{ all -> 0x0143 }
        L_0x0106:
            java.lang.Object r9 = r6.get(r10)     // Catch:{ all -> 0x0143 }
            androidx.collection.SimpleArrayMap r9 = (androidx.collection.SimpleArrayMap) r9     // Catch:{ all -> 0x0143 }
            r9.put(r8, r12)     // Catch:{ all -> 0x0143 }
            goto L_0x009c
        L_0x0110:
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0143 }
            java.lang.String r14 = r14.getPackageName()     // Catch:{ all -> 0x0143 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0143 }
            r7.<init>()     // Catch:{ all -> 0x0143 }
            java.lang.String r8 = "Parsed "
            r7.append(r8)     // Catch:{ all -> 0x0143 }
            r7.append(r3)     // Catch:{ all -> 0x0143 }
            java.lang.String r3 = " for Android package "
            r7.append(r3)     // Catch:{ all -> 0x0143 }
            r7.append(r14)     // Catch:{ all -> 0x0143 }
            java.lang.String r14 = "HermeticFileOverrides"
            java.lang.String r3 = r7.toString()     // Catch:{ all -> 0x0143 }
            android.util.Log.w(r14, r3)     // Catch:{ all -> 0x0143 }
            com.google.android.gms.internal.auth.zzci r14 = new com.google.android.gms.internal.auth.zzci     // Catch:{ all -> 0x0143 }
            r14.<init>(r6)     // Catch:{ all -> 0x0143 }
            r4.close()     // Catch:{ IOException -> 0x015f }
            com.google.android.gms.internal.auth.zzdh r14 = com.google.android.gms.internal.auth.zzdh.zzd(r14)     // Catch:{ all -> 0x0172 }
            goto L_0x016a
        L_0x0143:
            r14 = move-exception
            r4.close()     // Catch:{ all -> 0x0148 }
            goto L_0x015e
        L_0x0148:
            r3 = move-exception
            java.lang.Class[] r4 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x015e }
            java.lang.Class<java.lang.Throwable> r6 = java.lang.Throwable.class
            r4[r2] = r6     // Catch:{ Exception -> 0x015e }
            java.lang.Class<java.lang.Throwable> r6 = java.lang.Throwable.class
            java.lang.String r7 = "addSuppressed"
            java.lang.reflect.Method r4 = r6.getDeclaredMethod(r7, r4)     // Catch:{ Exception -> 0x015e }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x015e }
            r5[r2] = r3     // Catch:{ Exception -> 0x015e }
            r4.invoke(r14, r5)     // Catch:{ Exception -> 0x015e }
        L_0x015e:
            throw r14     // Catch:{ IOException -> 0x015f }
        L_0x015f:
            r14 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0172 }
            r2.<init>(r14)     // Catch:{ all -> 0x0172 }
            throw r2     // Catch:{ all -> 0x0172 }
        L_0x0166:
            com.google.android.gms.internal.auth.zzdh r14 = com.google.android.gms.internal.auth.zzdh.zzc()     // Catch:{ all -> 0x0172 }
        L_0x016a:
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ all -> 0x0179 }
            goto L_0x0032
        L_0x016f:
            zza = r1     // Catch:{ all -> 0x0179 }
            goto L_0x0177
        L_0x0172:
            r14 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ all -> 0x0179 }
            throw r14     // Catch:{ all -> 0x0179 }
        L_0x0177:
            monitor-exit(r0)     // Catch:{ all -> 0x0179 }
            return r1
        L_0x0179:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0179 }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.auth.zzcp.zza(android.content.Context):com.google.android.gms.internal.auth.zzdh");
    }
}
