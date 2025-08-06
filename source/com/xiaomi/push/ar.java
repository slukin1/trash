package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;

class ar implements aj {

    /* renamed from: a  reason: collision with root package name */
    private static String f51394a = "content://com.vivo.vms.IdProvider/IdentifierId/";

    /* renamed from: b  reason: collision with root package name */
    private static String f51395b = (f51394a + "OAID");

    /* renamed from: c  reason: collision with root package name */
    private static String f51396c = (f51394a + "VAID_");

    /* renamed from: d  reason: collision with root package name */
    private static String f51397d = (f51394a + "AAID_");

    /* renamed from: e  reason: collision with root package name */
    private static String f51398e = (f51394a + "OAIDSTATUS");

    /* renamed from: f  reason: collision with root package name */
    private static String f51399f = "persist.sys.identifierid.supported";

    /* renamed from: a  reason: collision with other field name */
    private Context f2539a;

    public ar(Context context) {
        this.f2539a = context;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2399a() {
        return "1".equals(q.a(f51399f, "0"));
    }

    public String a() {
        return a(f51395b);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002a, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r10 != null) goto L_0x002a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r10 != null) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 0
            android.content.Context r1 = r9.f2539a     // Catch:{ Exception -> 0x0038, all -> 0x002e }
            android.content.ContentResolver r2 = r1.getContentResolver()     // Catch:{ Exception -> 0x0038, all -> 0x002e }
            android.net.Uri r3 = android.net.Uri.parse(r10)     // Catch:{ Exception -> 0x0038, all -> 0x002e }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0038, all -> 0x002e }
            if (r10 == 0) goto L_0x0028
            boolean r1 = r10.moveToNext()     // Catch:{ Exception -> 0x0039, all -> 0x0026 }
            if (r1 == 0) goto L_0x0028
            java.lang.String r1 = "value"
            int r1 = r10.getColumnIndex(r1)     // Catch:{ Exception -> 0x0039, all -> 0x0026 }
            java.lang.String r0 = r10.getString(r1)     // Catch:{ Exception -> 0x0039, all -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            r0 = move-exception
            goto L_0x0032
        L_0x0028:
            if (r10 == 0) goto L_0x003c
        L_0x002a:
            r10.close()
            goto L_0x003c
        L_0x002e:
            r10 = move-exception
            r8 = r0
            r0 = r10
            r10 = r8
        L_0x0032:
            if (r10 == 0) goto L_0x0037
            r10.close()
        L_0x0037:
            throw r0
        L_0x0038:
            r10 = r0
        L_0x0039:
            if (r10 == 0) goto L_0x003c
            goto L_0x002a
        L_0x003c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.ar.a(java.lang.String):java.lang.String");
    }

    public static boolean a(Context context) {
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(f51394a).getAuthority(), 128);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
