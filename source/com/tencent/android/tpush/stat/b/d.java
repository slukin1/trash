package com.tencent.android.tpush.stat.b;

import android.content.Context;
import android.content.SharedPreferences;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f69977a;

    /* JADX WARNING: Can't wrap try/catch for region: R(4:17|18|19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r3 = android.preference.PreferenceManager.getDefaultSharedPreferences(r3);
        f69977a = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0034, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0037, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x002d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized android.content.SharedPreferences a(android.content.Context r3) {
        /*
            java.lang.Class<com.tencent.android.tpush.stat.b.d> r0 = com.tencent.android.tpush.stat.b.d.class
            monitor-enter(r0)
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x002d }
            r2 = 11
            if (r1 < r2) goto L_0x0013
            java.lang.String r1 = ".tpush_mta"
            r2 = 4
            android.content.SharedPreferences r1 = r3.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x002d }
            f69977a = r1     // Catch:{ all -> 0x002d }
            goto L_0x001c
        L_0x0013:
            java.lang.String r1 = ".tpush_mta"
            r2 = 0
            android.content.SharedPreferences r1 = r3.getSharedPreferences(r1, r2)     // Catch:{ all -> 0x002d }
            f69977a = r1     // Catch:{ all -> 0x002d }
        L_0x001c:
            android.content.SharedPreferences r1 = f69977a     // Catch:{ all -> 0x002d }
            if (r1 != 0) goto L_0x0026
            android.content.SharedPreferences r1 = android.preference.PreferenceManager.getDefaultSharedPreferences(r3)     // Catch:{ all -> 0x002d }
            f69977a = r1     // Catch:{ all -> 0x002d }
        L_0x0026:
            android.content.SharedPreferences r3 = f69977a     // Catch:{ all -> 0x002a }
            monitor-exit(r0)
            return r3
        L_0x002a:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        L_0x002d:
            android.content.SharedPreferences r3 = android.preference.PreferenceManager.getDefaultSharedPreferences(r3)     // Catch:{ all -> 0x0035 }
            f69977a = r3     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)
            return r3
        L_0x0035:
            r3 = 0
            monitor-exit(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.stat.b.d.a(android.content.Context):android.content.SharedPreferences");
    }

    public static void b(Context context, String str, long j11) {
        String a11 = b.a(context, "tpush_" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(a11, j11);
        edit.commit();
    }

    public static void b(Context context, String str, int i11) {
        String a11 = b.a(context, "tpush_" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putInt(a11, i11);
        edit.commit();
    }

    public static long a(Context context, String str, long j11) {
        return a(context).getLong(b.a(context, "tpush_" + str), j11);
    }

    public static void b(Context context, String str, String str2) {
        String a11 = b.a(context, "tpush_" + str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putString(a11, str2);
        edit.commit();
    }

    public static int a(Context context, String str, int i11) {
        return a(context).getInt(b.a(context, "tpush_" + str), i11);
    }

    public static String a(Context context, String str, String str2) {
        return a(context).getString(b.a(context, "tpush_" + str), str2);
    }
}
