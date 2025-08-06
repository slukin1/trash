package com.google.android.gms.internal.measurement;

public final class zzho {
    private static volatile zzii zza;

    private zzho() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:69|70) */
    /* JADX WARNING: Code restructure failed: missing block: B:70:?, code lost:
        throw r14;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x015f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.measurement.zzii zza(android.content.Context r14) {
        /*
            java.lang.Class<com.google.android.gms.internal.measurement.zzho> r0 = com.google.android.gms.internal.measurement.zzho.class
            monitor-enter(r0)
            com.google.android.gms.internal.measurement.zzii r1 = zza     // Catch:{ all -> 0x017a }
            if (r1 != 0) goto L_0x0178
            java.lang.String r1 = android.os.Build.TYPE     // Catch:{ all -> 0x017a }
            java.lang.String r2 = android.os.Build.TAGS     // Catch:{ all -> 0x017a }
            java.lang.String r3 = "eng"
            boolean r3 = r1.equals(r3)     // Catch:{ all -> 0x017a }
            if (r3 != 0) goto L_0x001c
            java.lang.String r3 = "userdebug"
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x002e
        L_0x001c:
            java.lang.String r1 = "dev-keys"
            boolean r1 = r2.contains(r1)     // Catch:{ all -> 0x017a }
            if (r1 != 0) goto L_0x0035
            java.lang.String r1 = "test-keys"
            boolean r1 = r2.contains(r1)     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            com.google.android.gms.internal.measurement.zzii r14 = com.google.android.gms.internal.measurement.zzii.zzc()     // Catch:{ all -> 0x017a }
        L_0x0032:
            r1 = r14
            goto L_0x0170
        L_0x0035:
            boolean r1 = com.google.android.gms.internal.measurement.zzhb.zzb()     // Catch:{ all -> 0x017a }
            if (r1 == 0) goto L_0x0045
            boolean r1 = r14.isDeviceProtectedStorage()     // Catch:{ all -> 0x017a }
            if (r1 != 0) goto L_0x0045
            android.content.Context r14 = r14.createDeviceProtectedStorageContext()     // Catch:{ all -> 0x017a }
        L_0x0045:
            android.os.StrictMode$ThreadPolicy r1 = android.os.StrictMode.allowThreadDiskReads()     // Catch:{ all -> 0x017a }
            android.os.StrictMode.allowThreadDiskWrites()     // Catch:{ all -> 0x0173 }
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ RuntimeException -> 0x006a }
            java.lang.String r4 = "phenotype_hermetic"
            java.io.File r4 = r14.getDir(r4, r2)     // Catch:{ RuntimeException -> 0x006a }
            java.lang.String r5 = "overrides.txt"
            r3.<init>(r4, r5)     // Catch:{ RuntimeException -> 0x006a }
            boolean r4 = r3.exists()     // Catch:{ all -> 0x0173 }
            if (r4 == 0) goto L_0x0065
            com.google.android.gms.internal.measurement.zzii r3 = com.google.android.gms.internal.measurement.zzii.zzd(r3)     // Catch:{ all -> 0x0173 }
            goto L_0x0076
        L_0x0065:
            com.google.android.gms.internal.measurement.zzii r3 = com.google.android.gms.internal.measurement.zzii.zzc()     // Catch:{ all -> 0x0173 }
            goto L_0x0076
        L_0x006a:
            r3 = move-exception
            java.lang.String r4 = "HermeticFileOverrides"
            java.lang.String r5 = "no data dir"
            android.util.Log.e(r4, r5, r3)     // Catch:{ all -> 0x0173 }
            com.google.android.gms.internal.measurement.zzii r3 = com.google.android.gms.internal.measurement.zzii.zzc()     // Catch:{ all -> 0x0173 }
        L_0x0076:
            boolean r4 = r3.zzb()     // Catch:{ all -> 0x0173 }
            if (r4 == 0) goto L_0x0167
            java.lang.Object r3 = r3.zza()     // Catch:{ all -> 0x0173 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0160 }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0160 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0160 }
            r7 = r3
            java.io.File r7 = (java.io.File) r7     // Catch:{ IOException -> 0x0160 }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0160 }
            r5.<init>(r6)     // Catch:{ IOException -> 0x0160 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0160 }
            r5 = 1
            androidx.collection.SimpleArrayMap r6 = new androidx.collection.SimpleArrayMap     // Catch:{ all -> 0x0144 }
            r6.<init>()     // Catch:{ all -> 0x0144 }
            java.util.HashMap r7 = new java.util.HashMap     // Catch:{ all -> 0x0144 }
            r7.<init>()     // Catch:{ all -> 0x0144 }
        L_0x009d:
            java.lang.String r8 = r4.readLine()     // Catch:{ all -> 0x0144 }
            if (r8 == 0) goto L_0x0111
            java.lang.String r9 = " "
            r10 = 3
            java.lang.String[] r9 = r8.split(r9, r10)     // Catch:{ all -> 0x0144 }
            int r11 = r9.length     // Catch:{ all -> 0x0144 }
            if (r11 == r10) goto L_0x00c4
            java.lang.String r9 = "HermeticFileOverrides"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0144 }
            r10.<init>()     // Catch:{ all -> 0x0144 }
            java.lang.String r11 = "Invalid: "
            r10.append(r11)     // Catch:{ all -> 0x0144 }
            r10.append(r8)     // Catch:{ all -> 0x0144 }
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x0144 }
            android.util.Log.e(r9, r8)     // Catch:{ all -> 0x0144 }
            goto L_0x009d
        L_0x00c4:
            r8 = r9[r2]     // Catch:{ all -> 0x0144 }
            java.lang.String r10 = new java.lang.String     // Catch:{ all -> 0x0144 }
            r10.<init>(r8)     // Catch:{ all -> 0x0144 }
            r8 = r9[r5]     // Catch:{ all -> 0x0144 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0144 }
            r11.<init>(r8)     // Catch:{ all -> 0x0144 }
            java.lang.String r8 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x0144 }
            r11 = 2
            r12 = r9[r11]     // Catch:{ all -> 0x0144 }
            java.lang.Object r12 = r7.get(r12)     // Catch:{ all -> 0x0144 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0144 }
            if (r12 != 0) goto L_0x00f9
            r9 = r9[r11]     // Catch:{ all -> 0x0144 }
            java.lang.String r11 = new java.lang.String     // Catch:{ all -> 0x0144 }
            r11.<init>(r9)     // Catch:{ all -> 0x0144 }
            java.lang.String r12 = android.net.Uri.decode(r11)     // Catch:{ all -> 0x0144 }
            int r9 = r12.length()     // Catch:{ all -> 0x0144 }
            r13 = 1024(0x400, float:1.435E-42)
            if (r9 < r13) goto L_0x00f6
            if (r12 != r11) goto L_0x00f9
        L_0x00f6:
            r7.put(r11, r12)     // Catch:{ all -> 0x0144 }
        L_0x00f9:
            boolean r9 = r6.containsKey(r10)     // Catch:{ all -> 0x0144 }
            if (r9 != 0) goto L_0x0107
            androidx.collection.SimpleArrayMap r9 = new androidx.collection.SimpleArrayMap     // Catch:{ all -> 0x0144 }
            r9.<init>()     // Catch:{ all -> 0x0144 }
            r6.put(r10, r9)     // Catch:{ all -> 0x0144 }
        L_0x0107:
            java.lang.Object r9 = r6.get(r10)     // Catch:{ all -> 0x0144 }
            androidx.collection.SimpleArrayMap r9 = (androidx.collection.SimpleArrayMap) r9     // Catch:{ all -> 0x0144 }
            r9.put(r8, r12)     // Catch:{ all -> 0x0144 }
            goto L_0x009d
        L_0x0111:
            java.lang.String r7 = "HermeticFileOverrides"
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0144 }
            java.lang.String r14 = r14.getPackageName()     // Catch:{ all -> 0x0144 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0144 }
            r8.<init>()     // Catch:{ all -> 0x0144 }
            java.lang.String r9 = "Parsed "
            r8.append(r9)     // Catch:{ all -> 0x0144 }
            r8.append(r3)     // Catch:{ all -> 0x0144 }
            java.lang.String r3 = " for Android package "
            r8.append(r3)     // Catch:{ all -> 0x0144 }
            r8.append(r14)     // Catch:{ all -> 0x0144 }
            java.lang.String r14 = r8.toString()     // Catch:{ all -> 0x0144 }
            android.util.Log.w(r7, r14)     // Catch:{ all -> 0x0144 }
            com.google.android.gms.internal.measurement.zzhh r14 = new com.google.android.gms.internal.measurement.zzhh     // Catch:{ all -> 0x0144 }
            r14.<init>(r6)     // Catch:{ all -> 0x0144 }
            r4.close()     // Catch:{ IOException -> 0x0160 }
            com.google.android.gms.internal.measurement.zzii r14 = com.google.android.gms.internal.measurement.zzii.zzd(r14)     // Catch:{ all -> 0x0173 }
            goto L_0x016b
        L_0x0144:
            r14 = move-exception
            r4.close()     // Catch:{ all -> 0x0149 }
            goto L_0x015f
        L_0x0149:
            r3 = move-exception
            java.lang.Class<java.lang.Throwable> r4 = java.lang.Throwable.class
            java.lang.String r6 = "addSuppressed"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x015f }
            java.lang.Class<java.lang.Throwable> r8 = java.lang.Throwable.class
            r7[r2] = r8     // Catch:{ Exception -> 0x015f }
            java.lang.reflect.Method r4 = r4.getDeclaredMethod(r6, r7)     // Catch:{ Exception -> 0x015f }
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x015f }
            r5[r2] = r3     // Catch:{ Exception -> 0x015f }
            r4.invoke(r14, r5)     // Catch:{ Exception -> 0x015f }
        L_0x015f:
            throw r14     // Catch:{ IOException -> 0x0160 }
        L_0x0160:
            r14 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0173 }
            r2.<init>(r14)     // Catch:{ all -> 0x0173 }
            throw r2     // Catch:{ all -> 0x0173 }
        L_0x0167:
            com.google.android.gms.internal.measurement.zzii r14 = com.google.android.gms.internal.measurement.zzii.zzc()     // Catch:{ all -> 0x0173 }
        L_0x016b:
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ all -> 0x017a }
            goto L_0x0032
        L_0x0170:
            zza = r1     // Catch:{ all -> 0x017a }
            goto L_0x0178
        L_0x0173:
            r14 = move-exception
            android.os.StrictMode.setThreadPolicy(r1)     // Catch:{ all -> 0x017a }
            throw r14     // Catch:{ all -> 0x017a }
        L_0x0178:
            monitor-exit(r0)     // Catch:{ all -> 0x017a }
            return r1
        L_0x017a:
            r14 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x017a }
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzho.zza(android.content.Context):com.google.android.gms.internal.measurement.zzii");
    }
}
