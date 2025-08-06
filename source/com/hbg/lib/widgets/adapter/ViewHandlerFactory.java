package com.hbg.lib.widgets.adapter;

import java.util.HashMap;
import java.util.Map;
import s9.c;

public class ViewHandlerFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final String f71733a = "ViewHandlerFactory";

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, c> f71734b = new HashMap();

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends s9.c> T a(java.lang.String r5) {
        /*
            java.util.Map<java.lang.String, s9.c> r0 = f71734b
            java.lang.Object r0 = r0.get(r5)
            s9.c r0 = (s9.c) r0
            if (r0 != 0) goto L_0x0028
            java.lang.Class r1 = java.lang.Class.forName(r5)     // Catch:{ Exception -> 0x001c }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ Exception -> 0x001c }
            s9.c r1 = (s9.c) r1     // Catch:{ Exception -> 0x001c }
            java.util.Map<java.lang.String, s9.c> r0 = f71734b     // Catch:{ Exception -> 0x001a }
            r0.put(r5, r1)     // Catch:{ Exception -> 0x001a }
            goto L_0x0027
        L_0x001a:
            r0 = move-exception
            goto L_0x0020
        L_0x001c:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0020:
            java.lang.String r2 = f71733a
            java.lang.String r3 = "Exception!"
            android.util.Log.e(r2, r3, r0)
        L_0x0027:
            r0 = r1
        L_0x0028:
            if (r0 == 0) goto L_0x002b
            return r0
        L_0x002b:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "IViewHandler create failed:"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.adapter.ViewHandlerFactory.a(java.lang.String):s9.c");
    }
}
