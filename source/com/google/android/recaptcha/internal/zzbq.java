package com.google.android.recaptcha.internal;

public final class zzbq {
    private final zzh zza;
    private final zzbg zzb;

    public zzbq(zzh zzh, zzbg zzbg) {
        this.zza = zzh;
        this.zzb = zzbg;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:12|13|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0051, code lost:
        throw new com.google.android.recaptcha.internal.zzp(com.google.android.recaptcha.internal.zzn.zzc, com.google.android.recaptcha.internal.zzl.zzR, (java.lang.String) null);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0048 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.recaptcha.internal.zzoe zza(java.lang.String r4, byte[] r5, com.google.android.recaptcha.internal.zzbd r6) throws com.google.android.recaptcha.internal.zzp {
        /*
            r3 = this;
            com.google.android.recaptcha.internal.zzne r0 = com.google.android.recaptcha.internal.zzne.VALIDATE_INPUT
            com.google.android.recaptcha.internal.zzbb r6 = r6.zza(r0)
            com.google.android.recaptcha.internal.zzbg r0 = r3.zzb
            r1 = 0
            r2 = 2
            r0.zze.put(r6, new com.google.android.recaptcha.internal.zzbf(r6, r0.zza, new com.google.android.recaptcha.internal.zzac()))
            java.net.URL r0 = new java.net.URL     // Catch:{ zzp -> 0x0088 }
            r0.<init>(r4)     // Catch:{ zzp -> 0x0088 }
            java.net.URLConnection r4 = r0.openConnection()     // Catch:{ zzp -> 0x0088 }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ zzp -> 0x0088 }
            java.lang.String r0 = "POST"
            r4.setRequestMethod(r0)     // Catch:{ zzp -> 0x0088 }
            r0 = 1
            r4.setDoOutput(r0)     // Catch:{ zzp -> 0x0088 }
            java.lang.String r0 = "Accept"
            java.lang.String r2 = "application/x-protobuffer"
            r4.setRequestProperty(r0, r2)     // Catch:{ zzp -> 0x0088 }
            r4.connect()     // Catch:{ Exception -> 0x0076 }
            java.io.OutputStream r0 = r4.getOutputStream()     // Catch:{ Exception -> 0x0076 }
            r0.write(r5)     // Catch:{ Exception -> 0x0076 }
            int r5 = r4.getResponseCode()     // Catch:{ Exception -> 0x0076 }
            r0 = 200(0xc8, float:2.8E-43)
            if (r5 != r0) goto L_0x0052
            java.io.InputStream r4 = r4.getInputStream()     // Catch:{ Exception -> 0x0048 }
            com.google.android.recaptcha.internal.zzoe r4 = com.google.android.recaptcha.internal.zzoe.zzi(r4)     // Catch:{ Exception -> 0x0048 }
            com.google.android.recaptcha.internal.zzbg r5 = r3.zzb     // Catch:{ zzp -> 0x0088 }
            r5.zza(r6)     // Catch:{ zzp -> 0x0088 }
            return r4
        L_0x0048:
            com.google.android.recaptcha.internal.zzp r4 = new com.google.android.recaptcha.internal.zzp     // Catch:{ Exception -> 0x0076 }
            com.google.android.recaptcha.internal.zzn r5 = com.google.android.recaptcha.internal.zzn.zzc     // Catch:{ Exception -> 0x0076 }
            com.google.android.recaptcha.internal.zzl r0 = com.google.android.recaptcha.internal.zzl.zzR     // Catch:{ Exception -> 0x0076 }
            r4.<init>(r5, r0, r1)     // Catch:{ Exception -> 0x0076 }
            throw r4     // Catch:{ Exception -> 0x0076 }
        L_0x0052:
            int r5 = r4.getResponseCode()     // Catch:{ Exception -> 0x0076 }
            r0 = 400(0x190, float:5.6E-43)
            if (r5 != r0) goto L_0x006d
            java.io.InputStream r4 = r4.getErrorStream()     // Catch:{ Exception -> 0x0076 }
            com.google.android.recaptcha.internal.zzoz r4 = com.google.android.recaptcha.internal.zzoz.zzg(r4)     // Catch:{ Exception -> 0x0076 }
            com.google.android.recaptcha.internal.zzo r5 = com.google.android.recaptcha.internal.zzp.zza     // Catch:{ Exception -> 0x0076 }
            com.google.android.recaptcha.internal.zzpb r4 = r4.zzi()     // Catch:{ Exception -> 0x0076 }
            com.google.android.recaptcha.internal.zzp r4 = com.google.android.recaptcha.internal.zzo.zza(r4)     // Catch:{ Exception -> 0x0076 }
            goto L_0x0075
        L_0x006d:
            int r4 = r4.getResponseCode()     // Catch:{ Exception -> 0x0076 }
            com.google.android.recaptcha.internal.zzp r4 = com.google.android.recaptcha.internal.zzbr.zza(r4)     // Catch:{ Exception -> 0x0076 }
        L_0x0075:
            throw r4     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            r4 = move-exception
            boolean r5 = r4 instanceof com.google.android.recaptcha.internal.zzp     // Catch:{ zzp -> 0x0088 }
            if (r5 == 0) goto L_0x007e
            com.google.android.recaptcha.internal.zzp r4 = (com.google.android.recaptcha.internal.zzp) r4     // Catch:{ zzp -> 0x0088 }
            goto L_0x0087
        L_0x007e:
            com.google.android.recaptcha.internal.zzp r4 = new com.google.android.recaptcha.internal.zzp     // Catch:{ zzp -> 0x0088 }
            com.google.android.recaptcha.internal.zzn r5 = com.google.android.recaptcha.internal.zzn.zze     // Catch:{ zzp -> 0x0088 }
            com.google.android.recaptcha.internal.zzl r0 = com.google.android.recaptcha.internal.zzl.zzQ     // Catch:{ zzp -> 0x0088 }
            r4.<init>(r5, r0, r1)     // Catch:{ zzp -> 0x0088 }
        L_0x0087:
            throw r4     // Catch:{ zzp -> 0x0088 }
        L_0x0088:
            r4 = move-exception
            com.google.android.recaptcha.internal.zzbg r5 = r3.zzb
            r5.zzb(r6, r4, r1)
            com.google.android.recaptcha.RecaptchaException r4 = r4.zzc()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbq.zza(java.lang.String, byte[], com.google.android.recaptcha.internal.zzbd):com.google.android.recaptcha.internal.zzoe");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:39|40|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r11.zzb.zzb(r4, new com.google.android.recaptcha.internal.zzp(com.google.android.recaptcha.internal.zzn.zzn, com.google.android.recaptcha.internal.zzl.zzad, (java.lang.String) null), (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e0, code lost:
        throw new com.google.android.recaptcha.internal.zzp(com.google.android.recaptcha.internal.zzn.zze, com.google.android.recaptcha.internal.zzl.zzab, (java.lang.String) null);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00c8 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00d7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A[Catch:{ Exception -> 0x011c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzb(com.google.android.recaptcha.internal.zzoe r12, com.google.android.recaptcha.internal.zzbd r13) throws com.google.android.recaptcha.internal.zzp {
        /*
            r11 = this;
            java.lang.String r0 = "gzip"
            r1 = 0
            java.lang.String r2 = r12.zzk()     // Catch:{ Exception -> 0x011c }
            java.lang.String r3 = r12.zzH()     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzh r4 = r11.zza     // Catch:{ Exception -> 0x011c }
            boolean r4 = r4.zzd(r3)     // Catch:{ Exception -> 0x011c }
            r5 = 1
            r6 = 2
            if (r4 != r5) goto L_0x004a
            com.google.android.recaptcha.internal.zzne r4 = com.google.android.recaptcha.internal.zzne.LOAD_CACHE_JS     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzbb r4 = r13.zza(r4)     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzbg r7 = r11.zzb     // Catch:{ Exception -> 0x011c }
            r7.zze.put(r4, new com.google.android.recaptcha.internal.zzbf(r4, r7.zza, new com.google.android.recaptcha.internal.zzac()))     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzh r7 = r11.zza     // Catch:{ Exception -> 0x002e }
            java.lang.String r7 = r7.zza(r3)     // Catch:{ Exception -> 0x002e }
            if (r7 == 0) goto L_0x003c
            com.google.android.recaptcha.internal.zzbg r8 = r11.zzb     // Catch:{ Exception -> 0x002e }
            r8.zza(r4)     // Catch:{ Exception -> 0x002e }
            goto L_0x004b
        L_0x002e:
            com.google.android.recaptcha.internal.zzbg r7 = r11.zzb     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzp r8 = new com.google.android.recaptcha.internal.zzp     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzn r9 = com.google.android.recaptcha.internal.zzn.zzn     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzl r10 = com.google.android.recaptcha.internal.zzl.zzad     // Catch:{ Exception -> 0x011c }
            r8.<init>(r9, r10, r1)     // Catch:{ Exception -> 0x011c }
            r7.zzb(r4, r8, r1)     // Catch:{ Exception -> 0x011c }
        L_0x003c:
            com.google.android.recaptcha.internal.zzbg r7 = r11.zzb     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzp r8 = new com.google.android.recaptcha.internal.zzp     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzn r9 = com.google.android.recaptcha.internal.zzn.zzn     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzl r10 = com.google.android.recaptcha.internal.zzl.zzae     // Catch:{ Exception -> 0x011c }
            r8.<init>(r9, r10, r1)     // Catch:{ Exception -> 0x011c }
            r7.zzb(r4, r8, r1)     // Catch:{ Exception -> 0x011c }
        L_0x004a:
            r7 = r1
        L_0x004b:
            if (r7 != 0) goto L_0x010d
            com.google.android.recaptcha.internal.zzh r4 = r11.zza     // Catch:{ Exception -> 0x011c }
            r4.zzb()     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzne r4 = com.google.android.recaptcha.internal.zzne.DOWNLOAD_JS     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzbb r4 = r13.zza(r4)     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzbg r7 = r11.zzb     // Catch:{ zzp -> 0x0106 }
            r7.zze.put(r4, new com.google.android.recaptcha.internal.zzbf(r4, r7.zza, new com.google.android.recaptcha.internal.zzac()))     // Catch:{ zzp -> 0x0106 }
            java.net.URL r7 = new java.net.URL     // Catch:{ Exception -> 0x00fc }
            r7.<init>(r2)     // Catch:{ Exception -> 0x00fc }
            java.net.URLConnection r2 = r7.openConnection()     // Catch:{ Exception -> 0x00f2 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r7 = "GET"
            r2.setRequestMethod(r7)     // Catch:{ Exception -> 0x00f2 }
            r2.setDoInput(r5)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r5 = "Accept"
            java.lang.String r7 = "application/x-protobuffer"
            r2.setRequestProperty(r5, r7)     // Catch:{ Exception -> 0x00f2 }
            java.lang.String r5 = "Accept-Encoding"
            r2.setRequestProperty(r5, r0)     // Catch:{ Exception -> 0x00f2 }
            r2.connect()     // Catch:{ Exception -> 0x00f2 }
            int r5 = r2.getResponseCode()     // Catch:{ zzp -> 0x0106 }
            r7 = 200(0xc8, float:2.8E-43)
            if (r5 != r7) goto L_0x00e1
            java.lang.String r5 = r2.getContentEncoding()     // Catch:{ Exception -> 0x00d7 }
            boolean r0 = kotlin.jvm.internal.x.b(r0, r5)     // Catch:{ Exception -> 0x00d7 }
            if (r0 == 0) goto L_0x00a0
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00d7 }
            java.util.zip.GZIPInputStream r5 = new java.util.zip.GZIPInputStream     // Catch:{ Exception -> 0x00d7 }
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x00d7 }
            r5.<init>(r2)     // Catch:{ Exception -> 0x00d7 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x00d7 }
            goto L_0x00a9
        L_0x00a0:
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x00d7 }
            java.io.InputStream r2 = r2.getInputStream()     // Catch:{ Exception -> 0x00d7 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x00d7 }
        L_0x00a9:
            java.lang.String r7 = kotlin.io.g.c(r0)     // Catch:{ Exception -> 0x00d7 }
            com.google.android.recaptcha.internal.zzbg r0 = r11.zzb     // Catch:{ zzp -> 0x0106 }
            r0.zza(r4)     // Catch:{ zzp -> 0x0106 }
            com.google.android.recaptcha.internal.zzne r0 = com.google.android.recaptcha.internal.zzne.SAVE_CACHE_JS     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzbb r13 = r13.zza(r0)     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzbg r0 = r11.zzb     // Catch:{ Exception -> 0x00c8 }
            r0.zze.put(r13, new com.google.android.recaptcha.internal.zzbf(r13, r0.zza, new com.google.android.recaptcha.internal.zzac()))     // Catch:{ Exception -> 0x00c8 }
            com.google.android.recaptcha.internal.zzh r0 = r11.zza     // Catch:{ Exception -> 0x00c8 }
            r0.zzc(r3, r7)     // Catch:{ Exception -> 0x00c8 }
            com.google.android.recaptcha.internal.zzbg r0 = r11.zzb     // Catch:{ Exception -> 0x00c8 }
            r0.zza(r13)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x010d
        L_0x00c8:
            com.google.android.recaptcha.internal.zzbg r0 = r11.zzb     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzp r2 = new com.google.android.recaptcha.internal.zzp     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzn r3 = com.google.android.recaptcha.internal.zzn.zzn     // Catch:{ Exception -> 0x011c }
            com.google.android.recaptcha.internal.zzl r4 = com.google.android.recaptcha.internal.zzl.zzaf     // Catch:{ Exception -> 0x011c }
            r2.<init>(r3, r4, r1)     // Catch:{ Exception -> 0x011c }
            r0.zzb(r13, r2, r1)     // Catch:{ Exception -> 0x011c }
            goto L_0x010d
        L_0x00d7:
            com.google.android.recaptcha.internal.zzp r12 = new com.google.android.recaptcha.internal.zzp     // Catch:{ zzp -> 0x0106 }
            com.google.android.recaptcha.internal.zzn r13 = com.google.android.recaptcha.internal.zzn.zze     // Catch:{ zzp -> 0x0106 }
            com.google.android.recaptcha.internal.zzl r0 = com.google.android.recaptcha.internal.zzl.zzab     // Catch:{ zzp -> 0x0106 }
            r12.<init>(r13, r0, r1)     // Catch:{ zzp -> 0x0106 }
            throw r12     // Catch:{ zzp -> 0x0106 }
        L_0x00e1:
            com.google.android.recaptcha.internal.zzp r12 = new com.google.android.recaptcha.internal.zzp     // Catch:{ zzp -> 0x0106 }
            com.google.android.recaptcha.internal.zzn r13 = com.google.android.recaptcha.internal.zzn.zze     // Catch:{ zzp -> 0x0106 }
            com.google.android.recaptcha.internal.zzl r0 = new com.google.android.recaptcha.internal.zzl     // Catch:{ zzp -> 0x0106 }
            int r2 = r2.getResponseCode()     // Catch:{ zzp -> 0x0106 }
            r0.<init>(r2)     // Catch:{ zzp -> 0x0106 }
            r12.<init>(r13, r0, r1)     // Catch:{ zzp -> 0x0106 }
            throw r12     // Catch:{ zzp -> 0x0106 }
        L_0x00f2:
            com.google.android.recaptcha.internal.zzp r12 = new com.google.android.recaptcha.internal.zzp     // Catch:{ zzp -> 0x0106 }
            com.google.android.recaptcha.internal.zzn r13 = com.google.android.recaptcha.internal.zzn.zze     // Catch:{ zzp -> 0x0106 }
            com.google.android.recaptcha.internal.zzl r0 = com.google.android.recaptcha.internal.zzl.zzaa     // Catch:{ zzp -> 0x0106 }
            r12.<init>(r13, r0, r1)     // Catch:{ zzp -> 0x0106 }
            throw r12     // Catch:{ zzp -> 0x0106 }
        L_0x00fc:
            com.google.android.recaptcha.internal.zzp r12 = new com.google.android.recaptcha.internal.zzp     // Catch:{ zzp -> 0x0106 }
            com.google.android.recaptcha.internal.zzn r13 = com.google.android.recaptcha.internal.zzn.zzc     // Catch:{ zzp -> 0x0106 }
            com.google.android.recaptcha.internal.zzl r0 = com.google.android.recaptcha.internal.zzl.zzZ     // Catch:{ zzp -> 0x0106 }
            r12.<init>(r13, r0, r1)     // Catch:{ zzp -> 0x0106 }
            throw r12     // Catch:{ zzp -> 0x0106 }
        L_0x0106:
            r12 = move-exception
            com.google.android.recaptcha.internal.zzbg r13 = r11.zzb     // Catch:{ Exception -> 0x011c }
            r13.zzb(r4, r12, r1)     // Catch:{ Exception -> 0x011c }
            throw r12     // Catch:{ Exception -> 0x011c }
        L_0x010d:
            r4 = r7
            java.lang.String r2 = r12.zzj()     // Catch:{ Exception -> 0x011c }
            java.lang.String r3 = "JAVASCRIPT_TAG"
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r12 = kotlin.text.StringsKt__StringsJVMKt.G(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x011c }
            return r12
        L_0x011c:
            r12 = move-exception
            boolean r13 = r12 instanceof com.google.android.recaptcha.internal.zzp
            if (r13 == 0) goto L_0x0122
            throw r12
        L_0x0122:
            com.google.android.recaptcha.internal.zzp r12 = new com.google.android.recaptcha.internal.zzp
            com.google.android.recaptcha.internal.zzn r13 = com.google.android.recaptcha.internal.zzn.zzc
            com.google.android.recaptcha.internal.zzl r0 = com.google.android.recaptcha.internal.zzl.zzX
            r12.<init>(r13, r0, r1)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzbq.zzb(com.google.android.recaptcha.internal.zzoe, com.google.android.recaptcha.internal.zzbd):java.lang.String");
    }
}
