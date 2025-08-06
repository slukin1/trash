package com.bbc876219.lib.zlog;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

public class Log {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f63261a = true;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f63262b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f63263c = true;

    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r7, java.lang.String r8) {
        /*
            boolean r0 = f63262b
            r1 = 0
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0084
            if (r7 == 0) goto L_0x0084
            java.lang.String r0 = "StacktraceBlockImpl"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0014
            r7 = 8
            goto L_0x0015
        L_0x0014:
            r7 = 5
        L_0x0015:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0080 }
            r0.<init>()     // Catch:{ Exception -> 0x0080 }
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x007d }
            java.lang.StackTraceElement[] r3 = r3.getStackTrace()     // Catch:{ Exception -> 0x007d }
            r4 = r3[r7]     // Catch:{ Exception -> 0x007d }
            java.lang.String r4 = r4.getClassName()     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = "ZLog"
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x007d }
            if (r4 == 0) goto L_0x0031
            return r8
        L_0x0031:
            r4 = r3[r7]     // Catch:{ Exception -> 0x007d }
            java.lang.String r4 = r4.getFileName()     // Catch:{ Exception -> 0x007d }
            r5 = r3[r7]     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = r5.getMethodName()     // Catch:{ Exception -> 0x007d }
            r7 = r3[r7]     // Catch:{ Exception -> 0x007d }
            int r7 = r7.getLineNumber()     // Catch:{ Exception -> 0x007d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x007d }
            r3.<init>()     // Catch:{ Exception -> 0x007d }
            java.lang.String r6 = r5.substring(r1, r2)     // Catch:{ Exception -> 0x007d }
            java.lang.String r6 = r6.toUpperCase()     // Catch:{ Exception -> 0x007d }
            r3.append(r6)     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = r5.substring(r2)     // Catch:{ Exception -> 0x007d }
            r3.append(r5)     // Catch:{ Exception -> 0x007d }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x007d }
            java.lang.String r5 = "[ ("
            r0.append(r5)     // Catch:{ Exception -> 0x007d }
            r0.append(r4)     // Catch:{ Exception -> 0x007d }
            java.lang.String r4 = ":"
            r0.append(r4)     // Catch:{ Exception -> 0x007d }
            r0.append(r7)     // Catch:{ Exception -> 0x007d }
            java.lang.String r7 = ")#"
            r0.append(r7)     // Catch:{ Exception -> 0x007d }
            r0.append(r3)     // Catch:{ Exception -> 0x007d }
            java.lang.String r7 = " ] "
            r0.append(r7)     // Catch:{ Exception -> 0x007d }
            r3 = r0
            goto L_0x0084
        L_0x007d:
            r7 = move-exception
            r3 = r0
            goto L_0x0081
        L_0x0080:
            r7 = move-exception
        L_0x0081:
            r7.printStackTrace()
        L_0x0084:
            boolean r7 = f63261a
            java.lang.String r0 = ""
            r4 = 2
            if (r7 == 0) goto L_0x00ac
            java.util.Locale r7 = java.util.Locale.US
            r5 = 3
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Thread r6 = java.lang.Thread.currentThread()
            java.lang.String r6 = r6.getName()
            r5[r1] = r6
            if (r3 != 0) goto L_0x009d
            goto L_0x00a1
        L_0x009d:
            java.lang.String r0 = r3.toString()
        L_0x00a1:
            r5[r2] = r0
            r5[r4] = r8
            java.lang.String r8 = "[%s]%s %s"
            java.lang.String r7 = java.lang.String.format(r7, r8, r5)
            return r7
        L_0x00ac:
            java.util.Locale r7 = java.util.Locale.US
            java.lang.Object[] r4 = new java.lang.Object[r4]
            if (r3 != 0) goto L_0x00b3
            goto L_0x00b7
        L_0x00b3:
            java.lang.String r0 = r3.toString()
        L_0x00b7:
            r4[r1] = r0
            r4[r2] = r8
            java.lang.String r8 = "%s %s"
            java.lang.String r7 = java.lang.String.format(r7, r8, r4)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bbc876219.lib.zlog.Log.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static int b(String str, String str2) {
        return g(3, str, str2);
    }

    public static int c(String str, String str2) {
        return g(6, str, str2);
    }

    public static int d(String str, String str2, Throwable th2) {
        return g(6, str, str2 + 10 + e(th2));
    }

    public static String e(Throwable th2) {
        if (th2 == null) {
            return "";
        }
        for (Throwable th3 = th2; th3 != null; th3 = th3.getCause()) {
            if (th3 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th2.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static int f(String str, String str2) {
        return g(4, str, str2);
    }

    public static int g(int i11, String str, String str2) {
        String str3 = "ZLog_" + str;
        if (i11 != 2) {
            if (i11 != 3) {
                if (i11 != 4) {
                    if (i11 != 5) {
                        if (i11 == 6) {
                            if (f63263c) {
                                android.util.Log.e(str3, a(str3, str2));
                            } else {
                                System.out.println(str3 + "\t" + a(str3, str2));
                            }
                        }
                    } else if (f63263c) {
                        android.util.Log.w(str3, a(str3, str2));
                    } else {
                        System.out.println(str3 + "\t" + a(str3, str2));
                    }
                } else if (f63263c) {
                    android.util.Log.i(str3, a(str3, str2));
                } else {
                    System.out.println(str3 + "\t" + a(str3, str2));
                }
            } else if (f63263c) {
                android.util.Log.d(str3, a(str3, str2));
            } else {
                System.out.println(str3 + "\t" + a(str3, str2));
            }
        } else if (f63263c) {
            android.util.Log.v(str3, a(str3, str2));
        } else {
            System.out.println(str3 + "\t" + a(str3, str2));
        }
        return i11;
    }

    public static int h(String str, String str2) {
        return g(5, str, str2);
    }

    public static int i(String str, String str2, Throwable th2) {
        return g(5, str, str2 + 10 + e(th2));
    }
}
