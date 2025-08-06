package me.weishu.reflection;

import java.lang.reflect.Method;

public final class BootstrapClass {

    /* renamed from: a  reason: collision with root package name */
    public static Object f58217a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f58218b;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L_0x0069
            java.lang.Class<java.lang.Class> r1 = java.lang.Class.class
            java.lang.String r2 = "forName"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ all -> 0x0061 }
            r5 = 0
            r4[r5] = r0     // Catch:{ all -> 0x0061 }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r4)     // Catch:{ all -> 0x0061 }
            java.lang.Class<java.lang.Class> r2 = java.lang.Class.class
            java.lang.String r4 = "getDeclaredMethod"
            r6 = 2
            java.lang.Class[] r7 = new java.lang.Class[r6]     // Catch:{ all -> 0x0061 }
            r7[r5] = r0     // Catch:{ all -> 0x0061 }
            java.lang.Class<java.lang.Class[]> r0 = java.lang.Class[].class
            r7[r3] = r0     // Catch:{ all -> 0x0061 }
            java.lang.reflect.Method r0 = r2.getDeclaredMethod(r4, r7)     // Catch:{ all -> 0x0061 }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = "dalvik.system.VMRuntime"
            r2[r5] = r4     // Catch:{ all -> 0x0061 }
            r4 = 0
            java.lang.Object r1 = r1.invoke(r4, r2)     // Catch:{ all -> 0x0061 }
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x0061 }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ all -> 0x0061 }
            java.lang.String r7 = "getRuntime"
            r2[r5] = r7     // Catch:{ all -> 0x0061 }
            r2[r3] = r4     // Catch:{ all -> 0x0061 }
            java.lang.Object r2 = r0.invoke(r1, r2)     // Catch:{ all -> 0x0061 }
            java.lang.reflect.Method r2 = (java.lang.reflect.Method) r2     // Catch:{ all -> 0x0061 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0061 }
            java.lang.String r7 = "setHiddenApiExemptions"
            r6[r5] = r7     // Catch:{ all -> 0x0061 }
            java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ all -> 0x0061 }
            java.lang.Class<java.lang.String[]> r8 = java.lang.String[].class
            r7[r5] = r8     // Catch:{ all -> 0x0061 }
            r6[r3] = r7     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.invoke(r1, r6)     // Catch:{ all -> 0x0061 }
            java.lang.reflect.Method r0 = (java.lang.reflect.Method) r0     // Catch:{ all -> 0x0061 }
            f58218b = r0     // Catch:{ all -> 0x0061 }
            java.lang.Object[] r0 = new java.lang.Object[r5]     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r2.invoke(r4, r0)     // Catch:{ all -> 0x0061 }
            f58217a = r0     // Catch:{ all -> 0x0061 }
            goto L_0x0069
        L_0x0061:
            r0 = move-exception
            java.lang.String r1 = "BootstrapClass"
            java.lang.String r2 = "reflect bootstrap failed:"
            android.util.Log.w(r1, r2, r0)
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: me.weishu.reflection.BootstrapClass.<clinit>():void");
    }

    public static boolean a(String... strArr) {
        Method method;
        Object obj = f58217a;
        if (!(obj == null || (method = f58218b) == null)) {
            try {
                method.invoke(obj, new Object[]{strArr});
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean b() {
        return a("L");
    }
}
