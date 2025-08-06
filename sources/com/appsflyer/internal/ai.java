package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

final class ai {
    private static ai AFInAppEventType = new ai();

    private ai() {
    }

    public static List<h> AFInAppEventParameterName(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(context.getFilesDir(), "AFRequestCache");
            if (!file.exists()) {
                file.mkdir();
            } else {
                for (File file2 : file.listFiles()) {
                    StringBuilder sb2 = new StringBuilder("Found cached request");
                    sb2.append(file2.getName());
                    AFLogger.AFKeystoreWrapper(sb2.toString());
                    arrayList.add(AFInAppEventParameterName(file2));
                }
            }
        } catch (Exception e11) {
            AFLogger.AFInAppEventType("Could not cache request", (Throwable) e11);
        }
        return arrayList;
    }

    public static ai AFKeystoreWrapper() {
        return AFInAppEventType;
    }

    public static void valueOf(String str, Context context) {
        File file = new File(new File(context.getFilesDir(), "AFRequestCache"), str);
        StringBuilder sb2 = new StringBuilder("Deleting ");
        sb2.append(str);
        sb2.append(" from cache");
        AFLogger.AFKeystoreWrapper(sb2.toString());
        if (file.exists()) {
            try {
                file.delete();
            } catch (Exception e11) {
                StringBuilder sb3 = new StringBuilder("Could not delete ");
                sb3.append(str);
                sb3.append(" from cache");
                AFLogger.AFInAppEventType(sb3.toString(), (Throwable) e11);
            }
        }
    }

    public static File AFKeystoreWrapper(Context context) {
        return new File(context.getFilesDir(), "AFRequestCache");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a A[SYNTHETIC, Splitter:B:14:0x002a] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0036 A[SYNTHETIC, Splitter:B:23:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.h AFInAppEventParameterName(java.io.File r4) {
        /*
            r0 = 0
            java.io.FileReader r1 = new java.io.FileReader     // Catch:{ Exception -> 0x0033, all -> 0x0027 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x0033, all -> 0x0027 }
            long r2 = r4.length()     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            int r2 = (int) r2     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            char[] r2 = new char[r2]     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            r1.read(r2)     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            com.appsflyer.internal.h r3 = new com.appsflyer.internal.h     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            java.lang.String r4 = r4.getName()     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            r3.valueOf = r4     // Catch:{ Exception -> 0x0034, all -> 0x0024 }
            r1.close()     // Catch:{ IOException -> 0x001f }
            goto L_0x0023
        L_0x001f:
            r4 = move-exception
            com.appsflyer.AFLogger.values((java.lang.Throwable) r4)
        L_0x0023:
            return r3
        L_0x0024:
            r4 = move-exception
            r0 = r1
            goto L_0x0028
        L_0x0027:
            r4 = move-exception
        L_0x0028:
            if (r0 == 0) goto L_0x0032
            r0.close()     // Catch:{ IOException -> 0x002e }
            goto L_0x0032
        L_0x002e:
            r0 = move-exception
            com.appsflyer.AFLogger.values((java.lang.Throwable) r0)
        L_0x0032:
            throw r4
        L_0x0033:
            r1 = r0
        L_0x0034:
            if (r1 == 0) goto L_0x003e
            r1.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r4 = move-exception
            com.appsflyer.AFLogger.values((java.lang.Throwable) r4)
        L_0x003e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ai.AFInAppEventParameterName(java.io.File):com.appsflyer.internal.h");
    }
}
