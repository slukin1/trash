package com.tencent.tpns.baseapi.base.logger;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.core.net.HttpRequestCallback;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class TBaseLogger {

    /* renamed from: a  reason: collision with root package name */
    public static volatile ExecutorService f49773a = Executors.newSingleThreadExecutor(new MinPriorityThreadFactory());

    /* renamed from: b  reason: collision with root package name */
    private static boolean f49774b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f49775c = false;

    /* renamed from: d  reason: collision with root package name */
    private static String f49776d = ("tencent" + File.separator + ".TPush");

    /* renamed from: e  reason: collision with root package name */
    private static int f49777e = 2;

    /* renamed from: f  reason: collision with root package name */
    private static List<String> f49778f = Collections.synchronizedList(new ArrayList());

    /* renamed from: g  reason: collision with root package name */
    private static boolean f49779g = false;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f49780h = false;

    /* renamed from: i  reason: collision with root package name */
    private static String f49781i = null;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static String f49782j = null;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public static Context f49783k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static DeviceInfo f49784l;

    /* renamed from: m  reason: collision with root package name */
    private static boolean f49785m = false;

    /* renamed from: n  reason: collision with root package name */
    private static LoggerInterface f49786n = new DefaultLogger();

    public static class MinPriorityThreadFactory implements ThreadFactory {
        private MinPriorityThreadFactory() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("tpns-log");
            thread.setPriority(10);
            return thread;
        }
    }

    public interface WriteFileCallback {
        void onFinished();
    }

    public static void addThirdLog(int i11, String str, String str2, Throwable th2) {
        if (i11 == 2) {
            vv(str, str2, th2);
        } else if (i11 == 3) {
            dd(str, str2, th2);
        } else if (i11 == 4) {
            ii(str, str2, th2);
        } else if (i11 == 5) {
            ww(str, str2, th2);
        } else if (i11 != 6) {
            ee(str, "illegal log level: " + str2, th2);
        } else {
            ee(str, str2, th2);
        }
    }

    public static void dd(String str, String str2) {
        if (a(3)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.d("TPush", "[" + str + "] " + str2);
            a("DEBUG", str, str2, (Throwable) null);
        }
    }

    public static void e(String str, String str2) {
        if (f49774b && a(6)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.e("TPush", "[" + str + "] " + str2);
        }
        a("ERROR", str, str2, (Throwable) null);
    }

    public static void ee(String str, String str2) {
        if (a(6)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.e("TPush", "[" + str + "] " + str2);
        }
        a("ERROR", str, str2, (Throwable) null);
    }

    public static void enableDebug(Context context, boolean z11) {
        f49774b = z11;
        f49775c = z11;
        init(context);
    }

    /* access modifiers changed from: private */
    public static String f() {
        String str = f49781i;
        if (str != null) {
            return str;
        }
        try {
            Context context = f49783k;
            if (context != null) {
                f49781i = context.getExternalFilesDir(f49776d).getAbsolutePath();
            }
            return f49781i;
        } catch (Throwable th2) {
            w("TBase - TPush", "TLogger ->getFileNamePre:" + th2.getMessage());
            return null;
        }
    }

    public static void flush() {
        flush((WriteFileCallback) null);
    }

    public static Context getAppContent() {
        return f49783k;
    }

    public static String getStackTraceString(Throwable th2) {
        return Log.getStackTraceString(th2);
    }

    public static void i(String str, String str2) {
        if (f49774b && a(4)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.i("TPush", "[" + str + "] " + str2);
            if (f49775c) {
                a("INFO", str, str2, (Throwable) null);
            }
        }
    }

    public static void ii(String str, String str2) {
        if (a(4)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.i("TPush", "[" + str + "] " + str2);
            a("INFO", str, str2, (Throwable) null);
        }
    }

    public static void init(Context context) {
        if (context != null) {
            if (f49783k == null) {
                f49783k = context.getApplicationContext();
            }
            f49779g = LogUtil.isSDCardMounted(f49783k);
        }
    }

    public static boolean isFileEnabled() {
        return f49775c;
    }

    public static void removeOldDebugLogFiles(int i11) {
        int i12 = 7;
        try {
            String f11 = f();
            if (!TextUtils.isEmpty(f11)) {
                String str = f11 + File.separator + "Logs";
                File file = new File(str);
                if (file.exists()) {
                    int length = str.length() + 5;
                    int length2 = LogUtil.PATTERN_DATETIME_FILENAME.length() + length;
                    File[] listFiles = file.listFiles();
                    if (listFiles != null && listFiles.length > 0) {
                        for (File file2 : listFiles) {
                            if (file2.isFile()) {
                                String absolutePath = file2.getAbsolutePath();
                                Date parseDateInFilename = LogUtil.parseDateInFilename(absolutePath.substring(length, length2));
                                if (i11 > 0) {
                                    i12 -= i11;
                                }
                                if (LogUtil.isDaysAgo(parseDateInFilename, i12)) {
                                    d("TBase - TPush", "delete logs file " + absolutePath);
                                    file2.delete();
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            e("TBase - TPush", "removeOldDebugLogFiles", th2);
        }
    }

    public static void setDebugLevel(int i11) {
        if (i11 >= 2 && i11 <= 6) {
            f49777e = i11;
        }
    }

    public static void setLogger(LoggerInterface loggerInterface) {
        f49786n = loggerInterface;
        f49785m = true;
        loggerInterface.i("TBase - TPush", "set third logger delegate");
    }

    public static synchronized void uploadLogFile(final Context context, final HttpRequestCallback httpRequestCallback) {
        synchronized (TBaseLogger.class) {
            init(context);
            final String f11 = f();
            flush(new WriteFileCallback() {
                public void onFinished() {
                    LogUploadUtil.uploadFile(context, f11, "Logs", "tmp", httpRequestCallback);
                }
            });
        }
    }

    public static void v(String str, String str2) {
        if (f49774b && a(2)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.v("TPush", "[" + str + "] " + str2);
            if (f49775c) {
                a("TRACE", str, str2, (Throwable) null);
            }
        }
    }

    public static void vv(String str, String str2) {
        if (a(2)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.v("TPush", "[" + str + "] " + str2);
            a("TRACE", str, str2, (Throwable) null);
        }
    }

    public static void w(String str, String str2) {
        if (f49774b && a(5)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.w("TPush", "[" + str + "] " + str2);
        }
        a("WARN", str, str2, (Throwable) null);
    }

    public static void ww(String str, String str2) {
        if (a(5)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.w("TPush", "[" + str + "] " + str2);
        }
        a("WARN", str, str2, (Throwable) null);
    }

    private static void b(String str) {
        if (!f49780h) {
            f49778f.add(str);
            if (f49778f.size() == 100) {
                List<String> list = f49778f;
                f49778f = Collections.synchronizedList(new ArrayList());
                boolean isSDCardMounted = LogUtil.isSDCardMounted(f49783k);
                f49779g = isSDCardMounted;
                if (isSDCardMounted) {
                    v("TBase - TPush", "have writable external storage, write log file!");
                    a(list, (WriteFileCallback) null);
                    return;
                }
                v("TBase - TPush", "no writable external storage");
            }
        }
    }

    public static void d(String str, String str2) {
        if (f49774b && a(3)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.d("TPush", "[" + str + "] " + str2);
            if (f49775c) {
                a("DEBUG", str, str2, (Throwable) null);
            }
        }
    }

    public static void flush(WriteFileCallback writeFileCallback) {
        f49780h = true;
        List<String> list = f49778f;
        f49778f = Collections.synchronizedList(new ArrayList());
        if (f49779g) {
            a(list, writeFileCallback);
        }
        f49780h = false;
    }

    private static boolean a(int i11) {
        return i11 >= f49777e;
    }

    public static void dd(String str, String str2, Throwable th2) {
        if (a(3)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.d("TPush", "[" + str + "] " + str2, th2);
            a("DEBUG", str, str2, th2);
        }
    }

    public static void e(String str, String str2, Throwable th2) {
        if (f49774b && a(6)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.e("TPush", "[" + str + "] " + str2, th2);
        }
        a("ERROR", str, str2, th2);
    }

    public static void ee(String str, String str2, Throwable th2) {
        if (a(6)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.e("TPush", "[" + str + "] " + str2, th2);
        }
        a("ERROR", str, str2, th2);
    }

    public static void ii(String str, String str2, Throwable th2) {
        if (a(4)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.i("TPush", "[" + str + "] " + str2, th2);
            a("INFO", str, str2, th2);
        }
    }

    public static void vv(String str, String str2, Throwable th2) {
        if (a(2)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.v("TPush", "[" + str + "] " + str2, th2);
            a("TRACE", str, str2, th2);
        }
    }

    public static void w(String str, String str2, Throwable th2) {
        if (f49774b && a(5)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.w("TPush", "[" + str + "] " + str2, th2);
        }
        a("WARN", str, str2, th2);
    }

    public static void ww(String str, String str2, Throwable th2) {
        if (a(5)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.w("TPush", "[" + str + "] " + str2, th2);
        }
        a("WARN", str, str2, th2);
    }

    private static void a(String str, String str2, String str3, Throwable th2) {
        String formatDate;
        if (!f49785m) {
            if (str2 == null || str2.trim().equals("")) {
                str2 = "TBase - TPush";
            }
            try {
                formatDate = LogUtil.formatDate(new Date(), "MM.dd_HH:mm:ss_SSS");
                if (str3 == null) {
                    str3 = "";
                }
                BufferedReader bufferedReader = new BufferedReader(new StringReader(str3), 256);
                String str4 = "[" + str2 + "]";
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    b(formatDate + " " + e() + " " + str + " " + str4 + " " + readLine);
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            } catch (Throwable unused) {
                return;
            }
            if (th2 != null) {
                StringWriter stringWriter = new StringWriter();
                th2.printStackTrace(new PrintWriter(stringWriter));
                b(formatDate + " " + e() + " " + str + stringWriter.toString());
            }
        }
    }

    public static void i(String str, String str2, Throwable th2) {
        if (f49774b && a(4)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.i("TPush", "[" + str + "] " + str2, th2);
            if (f49775c) {
                a("INFO", str, str2, th2);
            }
        }
    }

    public static void v(String str, String str2, Throwable th2) {
        if (f49774b && a(2)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.v("TPush", "[" + str + "] " + str2, th2);
            if (f49775c) {
                a("TRACE", str, str2, th2);
            }
        }
    }

    public static void d(String str, String str2, Throwable th2) {
        if (f49774b && a(3)) {
            LoggerInterface loggerInterface = f49786n;
            loggerInterface.d("TPush", "[" + str + "] " + str2, th2);
            if (f49775c) {
                a("DEBUG", str, str2, th2);
            }
        }
    }

    private static String e() {
        try {
            return Process.myPid() + " " + Thread.currentThread().getId();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static void a(final List<String> list, final WriteFileCallback writeFileCallback) {
        try {
            f49773a.execute(new TTask() {
                /* JADX WARNING: Removed duplicated region for block: B:52:0x0169 A[Catch:{ all -> 0x016d }] */
                /* JADX WARNING: Removed duplicated region for block: B:57:0x0175  */
                /* JADX WARNING: Removed duplicated region for block: B:58:0x0179  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void TRun() {
                    /*
                        r13 = this;
                        java.lang.String r0 = "close file stream error"
                        java.lang.String r1 = "TBase - TPush"
                        r2 = 0
                        java.lang.String r3 = com.tencent.tpns.baseapi.base.logger.TBaseLogger.f()     // Catch:{ all -> 0x015c }
                        boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x015c }
                        if (r4 == 0) goto L_0x0021
                        com.tencent.tpns.baseapi.base.logger.TBaseLogger$WriteFileCallback r3 = com.tencent.tpns.baseapi.base.logger.TBaseLogger.WriteFileCallback.this     // Catch:{ all -> 0x015c }
                        if (r3 == 0) goto L_0x0016
                        r3.onFinished()     // Catch:{ all -> 0x015c }
                    L_0x0016:
                        java.util.List r2 = r2     // Catch:{ all -> 0x001c }
                        r2.clear()     // Catch:{ all -> 0x001c }
                        goto L_0x0020
                    L_0x001c:
                        r2 = move-exception
                        com.tencent.tpns.baseapi.base.logger.TBaseLogger.e(r1, r0, r2)
                    L_0x0020:
                        return
                    L_0x0021:
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x015c }
                        r4.<init>()     // Catch:{ all -> 0x015c }
                        r4.append(r3)     // Catch:{ all -> 0x015c }
                        java.lang.String r3 = java.io.File.separator     // Catch:{ all -> 0x015c }
                        r4.append(r3)     // Catch:{ all -> 0x015c }
                        java.lang.String r5 = "Logs"
                        r4.append(r5)     // Catch:{ all -> 0x015c }
                        r4.append(r3)     // Catch:{ all -> 0x015c }
                        java.lang.String r3 = "log"
                        r4.append(r3)     // Catch:{ all -> 0x015c }
                        java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x015c }
                        java.lang.String r4 = com.tencent.tpns.baseapi.base.logger.TBaseLogger.f49782j     // Catch:{ all -> 0x015c }
                        boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x015c }
                        java.lang.String r6 = ".txt"
                        java.lang.String r7 = "-"
                        if (r5 == 0) goto L_0x0066
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x015c }
                        r4.<init>()     // Catch:{ all -> 0x015c }
                        r4.append(r3)     // Catch:{ all -> 0x015c }
                        r4.append(r7)     // Catch:{ all -> 0x015c }
                        java.lang.String r5 = com.tencent.tpns.baseapi.base.logger.LogUtil.getTodayDateTimeForFilename()     // Catch:{ all -> 0x015c }
                        r4.append(r5)     // Catch:{ all -> 0x015c }
                        r4.append(r6)     // Catch:{ all -> 0x015c }
                        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x015c }
                    L_0x0066:
                        java.io.File r5 = new java.io.File     // Catch:{ all -> 0x015c }
                        r5.<init>(r4)     // Catch:{ all -> 0x015c }
                        java.io.File r8 = r5.getParentFile()     // Catch:{ all -> 0x015c }
                        r8.mkdirs()     // Catch:{ all -> 0x015c }
                        boolean r8 = r5.exists()     // Catch:{ all -> 0x015c }
                        if (r8 == 0) goto L_0x00c3
                        long r8 = r5.length()     // Catch:{ all -> 0x015c }
                        r10 = 1048576(0x100000, double:5.180654E-318)
                        int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                        if (r8 <= 0) goto L_0x00c3
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x015c }
                        r4.<init>()     // Catch:{ all -> 0x015c }
                        java.lang.String r8 = "length:"
                        r4.append(r8)     // Catch:{ all -> 0x015c }
                        long r8 = r5.length()     // Catch:{ all -> 0x015c }
                        r4.append(r8)     // Catch:{ all -> 0x015c }
                        java.lang.String r5 = ", max size:"
                        r4.append(r5)     // Catch:{ all -> 0x015c }
                        r5 = 1048576(0x100000, float:1.469368E-39)
                        r4.append(r5)     // Catch:{ all -> 0x015c }
                        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x015c }
                        com.tencent.tpns.baseapi.base.logger.TBaseLogger.v(r1, r4)     // Catch:{ all -> 0x015c }
                        java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x015c }
                        r4.<init>()     // Catch:{ all -> 0x015c }
                        r4.append(r3)     // Catch:{ all -> 0x015c }
                        r4.append(r7)     // Catch:{ all -> 0x015c }
                        java.lang.String r3 = com.tencent.tpns.baseapi.base.logger.LogUtil.getTodayDateTimeForFilename()     // Catch:{ all -> 0x015c }
                        r4.append(r3)     // Catch:{ all -> 0x015c }
                        r4.append(r6)     // Catch:{ all -> 0x015c }
                        java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x015c }
                        java.io.File r5 = new java.io.File     // Catch:{ all -> 0x015c }
                        r5.<init>(r4)     // Catch:{ all -> 0x015c }
                    L_0x00c3:
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x015c }
                        r3.<init>()     // Catch:{ all -> 0x015c }
                        java.lang.String r6 = "Write log file: "
                        r3.append(r6)     // Catch:{ all -> 0x015c }
                        r3.append(r4)     // Catch:{ all -> 0x015c }
                        java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x015c }
                        com.tencent.tpns.baseapi.base.logger.TBaseLogger.v(r1, r3)     // Catch:{ all -> 0x015c }
                        java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ all -> 0x015c }
                        java.io.FileWriter r6 = new java.io.FileWriter     // Catch:{ all -> 0x015c }
                        r7 = 1
                        r6.<init>(r4, r7)     // Catch:{ all -> 0x015c }
                        r3.<init>(r6)     // Catch:{ all -> 0x015c }
                        long r5 = r5.length()     // Catch:{ all -> 0x0157 }
                        r7 = 0
                        int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                        java.lang.String r5 = "\n"
                        if (r2 != 0) goto L_0x0126
                        com.tencent.tpns.baseapi.base.logger.DeviceInfo r2 = com.tencent.tpns.baseapi.base.logger.TBaseLogger.f49784l     // Catch:{ all -> 0x0157 }
                        if (r2 != 0) goto L_0x0106
                        android.content.Context r2 = com.tencent.tpns.baseapi.base.logger.TBaseLogger.f49783k     // Catch:{ all -> 0x0157 }
                        if (r2 == 0) goto L_0x0106
                        com.tencent.tpns.baseapi.base.logger.DeviceInfo r2 = new com.tencent.tpns.baseapi.base.logger.DeviceInfo     // Catch:{ all -> 0x0157 }
                        android.content.Context r6 = com.tencent.tpns.baseapi.base.logger.TBaseLogger.f49783k     // Catch:{ all -> 0x0157 }
                        r2.<init>(r6)     // Catch:{ all -> 0x0157 }
                        com.tencent.tpns.baseapi.base.logger.DeviceInfo unused = com.tencent.tpns.baseapi.base.logger.TBaseLogger.f49784l = r2     // Catch:{ all -> 0x0157 }
                    L_0x0106:
                        com.tencent.tpns.baseapi.base.logger.DeviceInfo r2 = com.tencent.tpns.baseapi.base.logger.TBaseLogger.f49784l     // Catch:{ all -> 0x0157 }
                        if (r2 == 0) goto L_0x0126
                        java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0157 }
                        r2.<init>()     // Catch:{ all -> 0x0157 }
                        com.tencent.tpns.baseapi.base.logger.DeviceInfo r6 = com.tencent.tpns.baseapi.base.logger.TBaseLogger.f49784l     // Catch:{ all -> 0x0157 }
                        java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0157 }
                        r2.append(r6)     // Catch:{ all -> 0x0157 }
                        r2.append(r5)     // Catch:{ all -> 0x0157 }
                        java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0157 }
                        r3.write(r2)     // Catch:{ all -> 0x0157 }
                    L_0x0126:
                        java.util.List r2 = r2     // Catch:{ all -> 0x0157 }
                        java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0157 }
                    L_0x012c:
                        boolean r6 = r2.hasNext()     // Catch:{ all -> 0x0157 }
                        if (r6 == 0) goto L_0x014b
                        java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x0157 }
                        java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0157 }
                        java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0157 }
                        r7.<init>()     // Catch:{ all -> 0x0157 }
                        r7.append(r6)     // Catch:{ all -> 0x0157 }
                        r7.append(r5)     // Catch:{ all -> 0x0157 }
                        java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0157 }
                        r3.write(r6)     // Catch:{ all -> 0x0157 }
                        goto L_0x012c
                    L_0x014b:
                        java.lang.String unused = com.tencent.tpns.baseapi.base.logger.TBaseLogger.f49782j = r4     // Catch:{ all -> 0x0157 }
                        java.util.List r2 = r2     // Catch:{ all -> 0x016d }
                        r2.clear()     // Catch:{ all -> 0x016d }
                        r3.close()     // Catch:{ all -> 0x016d }
                        goto L_0x0171
                    L_0x0157:
                        r2 = move-exception
                        r12 = r3
                        r3 = r2
                        r2 = r12
                        goto L_0x015d
                    L_0x015c:
                        r3 = move-exception
                    L_0x015d:
                        java.lang.String r4 = "write logs to file error"
                        com.tencent.tpns.baseapi.base.logger.TBaseLogger.i(r1, r4, r3)     // Catch:{ all -> 0x017e }
                        java.util.List r3 = r2     // Catch:{ all -> 0x016d }
                        r3.clear()     // Catch:{ all -> 0x016d }
                        if (r2 == 0) goto L_0x0171
                        r2.close()     // Catch:{ all -> 0x016d }
                        goto L_0x0171
                    L_0x016d:
                        r2 = move-exception
                        com.tencent.tpns.baseapi.base.logger.TBaseLogger.e(r1, r0, r2)
                    L_0x0171:
                        com.tencent.tpns.baseapi.base.logger.TBaseLogger$WriteFileCallback r0 = com.tencent.tpns.baseapi.base.logger.TBaseLogger.WriteFileCallback.this
                        if (r0 == 0) goto L_0x0179
                        r0.onFinished()
                        goto L_0x017d
                    L_0x0179:
                        r0 = 0
                        com.tencent.tpns.baseapi.base.logger.TBaseLogger.removeOldDebugLogFiles(r0)
                    L_0x017d:
                        return
                    L_0x017e:
                        r3 = move-exception
                        java.util.List r4 = r2     // Catch:{ all -> 0x018a }
                        r4.clear()     // Catch:{ all -> 0x018a }
                        if (r2 == 0) goto L_0x018e
                        r2.close()     // Catch:{ all -> 0x018a }
                        goto L_0x018e
                    L_0x018a:
                        r2 = move-exception
                        com.tencent.tpns.baseapi.base.logger.TBaseLogger.e(r1, r0, r2)
                    L_0x018e:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.baseapi.base.logger.TBaseLogger.AnonymousClass2.TRun():void");
                }
            });
        } catch (Throwable th2) {
            e("TBase - TPush", "savelog error", th2);
        }
    }
}
