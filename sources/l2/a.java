package l2;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.List;

public class a {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006a A[SYNTHETIC, Splitter:B:24:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0076 A[SYNTHETIC, Splitter:B:30:0x0076] */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a() {
        /*
            int r0 = android.os.Process.myPid()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r3.<init>()     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            java.lang.String r4 = "/proc/"
            r3.append(r4)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r3.append(r0)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            java.lang.String r0 = "/cmdline"
            r3.append(r0)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            boolean r0 = r2.exists()     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            if (r0 == 0) goto L_0x003e
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            java.io.FileReader r3 = new java.io.FileReader     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0050, all -> 0x004b }
            java.lang.String r2 = r0.readLine()     // Catch:{ Exception -> 0x003c }
            java.lang.String r1 = r2.trim()     // Catch:{ Exception -> 0x003c }
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x003f
        L_0x003c:
            r2 = move-exception
            goto L_0x0052
        L_0x003e:
            r0 = r1
        L_0x003f:
            if (r1 == 0) goto L_0x0049
            r1.close()     // Catch:{ IOException -> 0x0045 }
            goto L_0x0049
        L_0x0045:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0049:
            r1 = r0
            goto L_0x0072
        L_0x004b:
            r0 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0074
        L_0x0050:
            r2 = move-exception
            r0 = r1
        L_0x0052:
            java.lang.String r3 = "CrashUtils"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r4.<init>()     // Catch:{ all -> 0x0073 }
            java.lang.String r5 = "getProcessNameByPid error: "
            r4.append(r5)     // Catch:{ all -> 0x0073 }
            r4.append(r2)     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0073 }
            android.util.Log.d(r3, r2)     // Catch:{ all -> 0x0073 }
            if (r0 == 0) goto L_0x0072
            r0.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0072:
            return r1
        L_0x0073:
            r1 = move-exception
        L_0x0074:
            if (r0 == 0) goto L_0x007e
            r0.close()     // Catch:{ IOException -> 0x007a }
            goto L_0x007e
        L_0x007a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x007e:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.a.a():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0102, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void b(android.content.Context r8, com.alibaba.sdk.android.crashdefend.a.a r9, java.util.List<com.alibaba.sdk.android.crashdefend.a.b> r10) {
        /*
            java.lang.Class<l2.a> r0 = l2.a.class
            monitor-enter(r0)
            if (r8 == 0) goto L_0x0101
            if (r10 != 0) goto L_0x0009
            goto L_0x0101
        L_0x0009:
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            r2.<init>()     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            if (r9 == 0) goto L_0x0018
            java.lang.String r3 = "startSerialNumber"
            long r4 = r9.f14492a     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            r2.put(r3, r4)     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
        L_0x0018:
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ JSONException -> 0x007e }
            r9.<init>()     // Catch:{ JSONException -> 0x007e }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ JSONException -> 0x007e }
        L_0x0021:
            boolean r3 = r10.hasNext()     // Catch:{ JSONException -> 0x007e }
            if (r3 == 0) goto L_0x0078
            java.lang.Object r3 = r10.next()     // Catch:{ JSONException -> 0x007e }
            com.alibaba.sdk.android.crashdefend.a.b r3 = (com.alibaba.sdk.android.crashdefend.a.b) r3     // Catch:{ JSONException -> 0x007e }
            if (r3 != 0) goto L_0x0030
            goto L_0x0021
        L_0x0030:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x007e }
            r4.<init>()     // Catch:{ JSONException -> 0x007e }
            java.lang.String r5 = "sdkId"
            java.lang.String r6 = r3.f14493b     // Catch:{ JSONException -> 0x007e }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r5 = "sdkVersion"
            java.lang.String r6 = r3.f14494c     // Catch:{ JSONException -> 0x007e }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r5 = "crashLimit"
            int r6 = r3.f14495d     // Catch:{ JSONException -> 0x007e }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r5 = "crashCount"
            int r6 = r3.f14496e     // Catch:{ JSONException -> 0x007e }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r5 = "waitTime"
            int r6 = r3.f14497f     // Catch:{ JSONException -> 0x007e }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r5 = "registerSerialNumber"
            long r6 = r3.f14498g     // Catch:{ JSONException -> 0x007e }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r5 = "startSerialNumber"
            long r6 = r3.f14499h     // Catch:{ JSONException -> 0x007e }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r5 = "restoreCount"
            int r6 = r3.f14500i     // Catch:{ JSONException -> 0x007e }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x007e }
            java.lang.String r5 = "nextRestoreInterval"
            long r6 = r3.f14501j     // Catch:{ JSONException -> 0x007e }
            r4.put(r5, r6)     // Catch:{ JSONException -> 0x007e }
            r9.put(r4)     // Catch:{ JSONException -> 0x007e }
            goto L_0x0021
        L_0x0078:
            java.lang.String r10 = "sdkList"
            r2.put(r10, r9)     // Catch:{ JSONException -> 0x007e }
            goto L_0x0086
        L_0x007e:
            r9 = move-exception
            java.lang.String r10 = "CrashUtils"
            java.lang.String r3 = "save sdk json fail:"
            android.util.Log.e(r10, r3, r9)     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
        L_0x0086:
            java.lang.String r9 = r2.toString()     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            boolean r10 = c(r8)     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            r2 = 0
            if (r10 == 0) goto L_0x0099
            java.lang.String r10 = "com_alibaba_aliyun_crash_defend_sdk_info"
        L_0x0093:
            java.io.FileOutputStream r8 = r8.openFileOutput(r10, r2)     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            r1 = r8
            goto L_0x00af
        L_0x0099:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            r10.<init>()     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            java.lang.String r3 = "com_alibaba_aliyun_crash_defend_sdk_info_"
            r10.append(r3)     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            java.lang.String r3 = d(r8)     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            r10.append(r3)     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            goto L_0x0093
        L_0x00af:
            byte[] r8 = r9.getBytes()     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            r1.write(r8)     // Catch:{ IOException -> 0x00d9, Exception -> 0x00c5 }
            r1.close()     // Catch:{ IOException -> 0x00ba }
            goto L_0x00ed
        L_0x00ba:
            r8 = move-exception
            java.lang.String r9 = "CrashUtils"
            java.lang.String r10 = "save sdk io fail:"
        L_0x00bf:
            android.util.Log.e(r9, r10, r8)     // Catch:{ all -> 0x00fe }
            goto L_0x00ed
        L_0x00c3:
            r8 = move-exception
            goto L_0x00ef
        L_0x00c5:
            r8 = move-exception
            java.lang.String r9 = "CrashUtils"
            java.lang.String r10 = "save sdk exception:"
            l2.b.b(r9, r10, r8)     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x00ed
            r1.close()     // Catch:{ IOException -> 0x00d3 }
            goto L_0x00ed
        L_0x00d3:
            r8 = move-exception
            java.lang.String r9 = "CrashUtils"
            java.lang.String r10 = "save sdk io fail:"
            goto L_0x00bf
        L_0x00d9:
            r8 = move-exception
            java.lang.String r9 = "CrashUtils"
            java.lang.String r10 = "save sdk io fail:"
            l2.b.b(r9, r10, r8)     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x00ed
            r1.close()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x00ed
        L_0x00e7:
            r8 = move-exception
            java.lang.String r9 = "CrashUtils"
            java.lang.String r10 = "save sdk io fail:"
            goto L_0x00bf
        L_0x00ed:
            monitor-exit(r0)
            return
        L_0x00ef:
            if (r1 == 0) goto L_0x00fd
            r1.close()     // Catch:{ IOException -> 0x00f5 }
            goto L_0x00fd
        L_0x00f5:
            r9 = move-exception
            java.lang.String r10 = "CrashUtils"
            java.lang.String r1 = "save sdk io fail:"
            android.util.Log.e(r10, r1, r9)     // Catch:{ all -> 0x00fe }
        L_0x00fd:
            throw r8     // Catch:{ all -> 0x00fe }
        L_0x00fe:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        L_0x0101:
            monitor-exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.a.b(android.content.Context, com.alibaba.sdk.android.crashdefend.a.a, java.util.List):void");
    }

    public static boolean c(Context context) {
        return context.getPackageName().equalsIgnoreCase(d(context));
    }

    public static String d(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return Application.getProcessName();
            }
        } catch (Throwable th2) {
            Log.e("CrashUtils", "Application gerProcessName error: " + Log.getStackTraceString(th2));
        }
        String g11 = g(context);
        if (!TextUtils.isEmpty(g11)) {
            return g11;
        }
        String a11 = a();
        return !TextUtils.isEmpty(a11) ? a11 : f(context);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:97:0x017d, code lost:
        return false;
     */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00ce A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d0 A[SYNTHETIC, Splitter:B:67:0x00d0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean e(android.content.Context r10, com.alibaba.sdk.android.crashdefend.a.a r11, java.util.List<com.alibaba.sdk.android.crashdefend.a.b> r12) {
        /*
            java.lang.Class<l2.a> r0 = l2.a.class
            monitor-enter(r0)
            r1 = 0
            if (r10 == 0) goto L_0x017c
            if (r12 != 0) goto L_0x000a
            goto L_0x017c
        L_0x000a:
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0179 }
            r3.<init>()     // Catch:{ all -> 0x0179 }
            r4 = -1
            java.io.File r5 = r10.getFilesDir()     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            boolean r6 = c(r10)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            if (r6 == 0) goto L_0x0023
            java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            java.lang.String r7 = "com_alibaba_aliyun_crash_defend_sdk_info"
            r6.<init>(r5, r7)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            goto L_0x003d
        L_0x0023:
            java.io.File r6 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            java.lang.String r8 = "com_alibaba_aliyun_crash_defend_sdk_info_"
            r7.append(r8)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            java.lang.String r8 = d(r10)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            r7.append(r8)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            java.lang.String r7 = r7.toString()     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            r6.<init>(r5, r7)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
        L_0x003d:
            boolean r5 = r6.exists()     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            if (r5 != 0) goto L_0x0045
            monitor-exit(r0)
            return r1
        L_0x0045:
            boolean r5 = c(r10)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            if (r5 == 0) goto L_0x0053
            java.lang.String r5 = "com_alibaba_aliyun_crash_defend_sdk_info"
        L_0x004d:
            java.io.FileInputStream r10 = r10.openFileInput(r5)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            r2 = r10
            goto L_0x0069
        L_0x0053:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            java.lang.String r6 = "com_alibaba_aliyun_crash_defend_sdk_info_"
            r5.append(r6)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            java.lang.String r6 = d(r10)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            r5.append(r6)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            goto L_0x004d
        L_0x0069:
            r10 = 512(0x200, float:7.175E-43)
            byte[] r10 = new byte[r10]     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
        L_0x006d:
            int r5 = r2.read(r10)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            if (r5 == r4) goto L_0x007c
            java.lang.String r6 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            r6.<init>(r10, r1, r5)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            r3.append(r6)     // Catch:{ FileNotFoundException -> 0x00b4, IOException -> 0x00a0, Exception -> 0x008c }
            goto L_0x006d
        L_0x007c:
            r2.close()     // Catch:{ IOException -> 0x0080 }
            goto L_0x00c8
        L_0x0080:
            r10 = move-exception
            java.lang.String r2 = "CrashUtils"
            java.lang.String r5 = "load sdk io fail:"
        L_0x0085:
            android.util.Log.e(r2, r5, r10)     // Catch:{ all -> 0x0179 }
            goto L_0x00c8
        L_0x0089:
            r10 = move-exception
            goto L_0x016a
        L_0x008c:
            r10 = move-exception
            java.lang.String r5 = "CrashUtils"
            java.lang.String r6 = "load sdk exception:"
            l2.b.b(r5, r6, r10)     // Catch:{ all -> 0x0089 }
            if (r2 == 0) goto L_0x00c8
            r2.close()     // Catch:{ IOException -> 0x009a }
            goto L_0x00c8
        L_0x009a:
            r10 = move-exception
            java.lang.String r2 = "CrashUtils"
            java.lang.String r5 = "load sdk io fail:"
            goto L_0x0085
        L_0x00a0:
            r10 = move-exception
            java.lang.String r5 = "CrashUtils"
            java.lang.String r6 = "load sdk io fail:"
            l2.b.b(r5, r6, r10)     // Catch:{ all -> 0x0089 }
            if (r2 == 0) goto L_0x00c8
            r2.close()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00c8
        L_0x00ae:
            r10 = move-exception
            java.lang.String r2 = "CrashUtils"
            java.lang.String r5 = "load sdk io fail:"
            goto L_0x0085
        L_0x00b4:
            r10 = move-exception
            java.lang.String r5 = "CrashUtils"
            java.lang.String r6 = "load sdk file fail:"
            l2.b.b(r5, r6, r10)     // Catch:{ all -> 0x0089 }
            if (r2 == 0) goto L_0x00c8
            r2.close()     // Catch:{ IOException -> 0x00c2 }
            goto L_0x00c8
        L_0x00c2:
            r10 = move-exception
            java.lang.String r2 = "CrashUtils"
            java.lang.String r5 = "load sdk io fail:"
            goto L_0x0085
        L_0x00c8:
            int r10 = r3.length()     // Catch:{ all -> 0x0179 }
            if (r10 != 0) goto L_0x00d0
            monitor-exit(r0)
            return r1
        L_0x00d0:
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r2 = r3.toString()     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r10.<init>(r2)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r2 = "startSerialNumber"
            r5 = 1
            long r2 = r10.optLong(r2, r5)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r11.f14492a = r2     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r11 = "sdkList"
            org.json.JSONArray r10 = r10.getJSONArray(r11)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r11 = r1
        L_0x00ea:
            int r2 = r10.length()     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            if (r11 >= r2) goto L_0x0167
            org.json.JSONObject r2 = r10.getJSONObject(r11)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            if (r2 == 0) goto L_0x0155
            com.alibaba.sdk.android.crashdefend.a.b r3 = new com.alibaba.sdk.android.crashdefend.a.b     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r3.<init>()     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r5 = "sdkId"
            java.lang.String r6 = ""
            java.lang.String r5 = r2.optString(r5, r6)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r3.f14493b = r5     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r5 = "sdkVersion"
            java.lang.String r6 = ""
            java.lang.String r5 = r2.optString(r5, r6)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r3.f14494c = r5     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r5 = "crashLimit"
            int r5 = r2.optInt(r5, r4)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r3.f14495d = r5     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r5 = "crashCount"
            int r5 = r2.optInt(r5, r1)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r3.f14496e = r5     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r5 = "waitTime"
            int r5 = r2.optInt(r5, r1)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r3.f14497f = r5     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r5 = "registerSerialNumber"
            r6 = 0
            long r8 = r2.optLong(r5, r6)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r3.f14498g = r8     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r5 = "startSerialNumber"
            long r5 = r2.optLong(r5, r6)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r3.f14499h = r5     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r5 = "restoreCount"
            int r5 = r2.optInt(r5, r1)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r3.f14500i = r5     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r5 = "nextRestoreInterval"
            int r2 = r2.optInt(r5, r1)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            long r5 = (long) r2     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            r3.f14501j = r5     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            java.lang.String r2 = r3.f14493b     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
            if (r2 != 0) goto L_0x0155
            r12.add(r3)     // Catch:{ JSONException -> 0x0161, Exception -> 0x0158 }
        L_0x0155:
            int r11 = r11 + 1
            goto L_0x00ea
        L_0x0158:
            r10 = move-exception
            java.lang.String r11 = "CrashUtils"
            java.lang.String r12 = "load sdk exception:"
        L_0x015d:
            l2.b.b(r11, r12, r10)     // Catch:{ all -> 0x0179 }
            goto L_0x0167
        L_0x0161:
            r10 = move-exception
            java.lang.String r11 = "CrashUtils"
            java.lang.String r12 = "load sdk json fail:"
            goto L_0x015d
        L_0x0167:
            monitor-exit(r0)
            r10 = 1
            return r10
        L_0x016a:
            if (r2 == 0) goto L_0x0178
            r2.close()     // Catch:{ IOException -> 0x0170 }
            goto L_0x0178
        L_0x0170:
            r11 = move-exception
            java.lang.String r12 = "CrashUtils"
            java.lang.String r1 = "load sdk io fail:"
            android.util.Log.e(r12, r1, r11)     // Catch:{ all -> 0x0179 }
        L_0x0178:
            throw r10     // Catch:{ all -> 0x0179 }
        L_0x0179:
            r10 = move-exception
            monitor-exit(r0)
            throw r10
        L_0x017c:
            monitor-exit(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l2.a.e(android.content.Context, com.alibaba.sdk.android.crashdefend.a.a, java.util.List):boolean");
    }

    public static String f(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == myPid) {
                return next.processName;
            }
        }
        return "";
    }

    public static String g(Context context) {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, context.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            return (String) declaredMethod.invoke((Object) null, new Object[0]);
        } catch (Exception e11) {
            Log.d("CrashUtils", "getProcessNameByActivityThread error: " + e11);
            return null;
        }
    }
}
