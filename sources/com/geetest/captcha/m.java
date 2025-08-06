package com.geetest.captcha;

final class m {
    /* JADX WARNING: Can't wrap try/catch for region: R(13:7|8|9|(2:11|(2:13|14))|15|16|(2:18|(2:20|21))|22|23|(1:25)(3:26|(1:28)|33)|29|(2:31|32)|33) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x005e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x008e */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f A[Catch:{ Exception -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0099 A[Catch:{ Exception -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a3 A[Catch:{ Exception -> 0x00da }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d2 A[Catch:{ Exception -> 0x00da }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r10) {
        /*
            java.lang.String r0 = "deviceid"
            java.lang.String r1 = "/sdcard/baidu/.cuid"
            java.lang.String r2 = "$unknown"
            java.lang.String r3 = "/sdcard/backups/.SystemConfig/.cuid"
            java.lang.String r4 = "30212102dicudiab"
            java.lang.String r5 = "utf-8"
            java.lang.String r6 = "gt_db"
            java.lang.String r7 = com.geetest.captcha.f.a(r10, r6)
            boolean r8 = com.geetest.captcha.f.a(r7)
            if (r8 != 0) goto L_0x001a
            return r7
        L_0x001a:
            android.content.ContentResolver r7 = r10.getContentResolver()
            java.lang.String r8 = "com.baidu.deviceid"
            java.lang.String r7 = android.provider.Settings.System.getString(r7, r8)
            boolean r8 = com.geetest.captcha.f.a(r7)
            if (r8 != 0) goto L_0x002e
            com.geetest.captcha.f.a(r10, r6, r7)
            return r7
        L_0x002e:
            r7 = 2
            android.content.ContentResolver r8 = r10.getContentResolver()     // Catch:{ Exception -> 0x005e }
            java.lang.String r9 = "com.baidu.deviceid.v2"
            java.lang.String r8 = android.provider.Settings.System.getString(r8, r9)     // Catch:{ Exception -> 0x005e }
            boolean r9 = com.geetest.captcha.f.a(r8)     // Catch:{ Exception -> 0x005e }
            if (r9 != 0) goto L_0x005e
            byte[] r8 = android.util.Base64.decode(r8, r7)     // Catch:{ Exception -> 0x005e }
            byte[] r8 = com.geetest.captcha.e.a((byte[]) r8, (java.lang.String) r4, (java.lang.String) r4)     // Catch:{ Exception -> 0x005e }
            java.lang.String r8 = com.geetest.captcha.l.a((byte[]) r8, (java.lang.String) r5)     // Catch:{ Exception -> 0x005e }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x005e }
            r9.<init>(r8)     // Catch:{ Exception -> 0x005e }
            java.lang.String r8 = r9.getString(r0)     // Catch:{ Exception -> 0x005e }
            boolean r9 = com.geetest.captcha.f.a(r8)     // Catch:{ Exception -> 0x005e }
            if (r9 != 0) goto L_0x005e
            com.geetest.captcha.f.a(r10, r6, r8)     // Catch:{ Exception -> 0x005e }
            return r8
        L_0x005e:
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ Exception -> 0x008e }
            java.lang.String r9 = "/sdcard/backups/.SystemConfig/.cuid2"
            r8.<init>(r9)     // Catch:{ Exception -> 0x008e }
            java.lang.String r8 = com.geetest.captcha.l.a((java.io.InputStream) r8, (java.lang.String) r5)     // Catch:{ Exception -> 0x008e }
            boolean r9 = com.geetest.captcha.f.a(r8)     // Catch:{ Exception -> 0x008e }
            if (r9 != 0) goto L_0x008e
            byte[] r8 = android.util.Base64.decode(r8, r7)     // Catch:{ Exception -> 0x008e }
            byte[] r8 = com.geetest.captcha.e.a((byte[]) r8, (java.lang.String) r4, (java.lang.String) r4)     // Catch:{ Exception -> 0x008e }
            java.lang.String r8 = com.geetest.captcha.l.a((byte[]) r8, (java.lang.String) r5)     // Catch:{ Exception -> 0x008e }
            org.json.JSONObject r9 = new org.json.JSONObject     // Catch:{ Exception -> 0x008e }
            r9.<init>(r8)     // Catch:{ Exception -> 0x008e }
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x008e }
            boolean r8 = com.geetest.captcha.f.a(r0)     // Catch:{ Exception -> 0x008e }
            if (r8 != 0) goto L_0x008e
            com.geetest.captcha.f.a(r10, r6, r0)     // Catch:{ Exception -> 0x008e }
            return r0
        L_0x008e:
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00da }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00da }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x00da }
            if (r0 == 0) goto L_0x00a3
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00da }
            r0.<init>(r3)     // Catch:{ Exception -> 0x00da }
            java.lang.String r0 = com.geetest.captcha.l.a((java.io.InputStream) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x00da }
            goto L_0x00b7
        L_0x00a3:
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x00da }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00da }
            boolean r0 = r0.exists()     // Catch:{ Exception -> 0x00da }
            if (r0 == 0) goto L_0x00da
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00da }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00da }
            java.lang.String r0 = com.geetest.captcha.l.a((java.io.InputStream) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x00da }
        L_0x00b7:
            byte[] r0 = android.util.Base64.decode(r0, r7)     // Catch:{ Exception -> 0x00da }
            byte[] r0 = com.geetest.captcha.e.a((byte[]) r0, (java.lang.String) r4, (java.lang.String) r4)     // Catch:{ Exception -> 0x00da }
            java.lang.String r0 = com.geetest.captcha.l.a((byte[]) r0, (java.lang.String) r5)     // Catch:{ Exception -> 0x00da }
            java.lang.String r1 = "="
            java.lang.String[] r0 = r0.split(r1)     // Catch:{ Exception -> 0x00da }
            r1 = 1
            r3 = r0[r1]     // Catch:{ Exception -> 0x00da }
            boolean r3 = com.geetest.captcha.f.a(r3)     // Catch:{ Exception -> 0x00da }
            if (r3 != 0) goto L_0x00da
            r3 = r0[r1]     // Catch:{ Exception -> 0x00da }
            com.geetest.captcha.f.a(r10, r6, r3)     // Catch:{ Exception -> 0x00da }
            r10 = r0[r1]     // Catch:{ Exception -> 0x00da }
            return r10
        L_0x00da:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.geetest.captcha.m.a(android.content.Context):java.lang.String");
    }
}
