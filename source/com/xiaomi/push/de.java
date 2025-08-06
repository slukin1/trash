package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class de implements LoggerInterface {

    /* renamed from: a  reason: collision with root package name */
    private static volatile de f51582a;

    /* renamed from: a  reason: collision with other field name */
    public static String f2663a = "/MiPushLog";

    /* renamed from: a  reason: collision with other field name */
    private static final SimpleDateFormat f2664a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aaa");

    /* renamed from: a  reason: collision with other field name */
    private static List<Pair<String, Throwable>> f2665a = Collections.synchronizedList(new ArrayList());

    /* renamed from: a  reason: collision with other field name */
    private Context f2666a;

    /* renamed from: a  reason: collision with other field name */
    private Handler f2667a;

    /* renamed from: b  reason: collision with root package name */
    private String f51583b;

    private de(Context context) {
        this.f2666a = context;
        if (context.getApplicationContext() != null) {
            this.f2666a = context.getApplicationContext();
        }
        this.f51583b = this.f2666a.getPackageName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Process.myPid();
        HandlerThread handlerThread = new HandlerThread("Log2FileHandlerThread");
        handlerThread.start();
        this.f2667a = new Handler(handlerThread.getLooper());
    }

    public final void log(String str) {
        log(str, (Throwable) null);
    }

    public final void setTag(String str) {
        this.f51583b = str;
    }

    public final void log(final String str, final Throwable th2) {
        this.f2667a.post(new Runnable() {
            public void run() {
                de.a().add(new Pair(String.format("%1$s %2$s %3$s ", new Object[]{de.a().format(new Date()), de.a(de.this), str}), th2));
                if (de.a().size() > 20000) {
                    int size = (de.a().size() - 20000) + 50;
                    for (int i11 = 0; i11 < size; i11++) {
                        try {
                            if (de.a().size() > 0) {
                                de.a().remove(0);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                        }
                    }
                    de.a().add(new Pair(String.format("%1$s %2$s %3$s ", new Object[]{de.a().format(new Date()), de.a(de.this), "flush " + size + " lines logs."}), (Object) null));
                }
                try {
                    de.a(de.this);
                } catch (Exception e11) {
                    Log.e(de.a(de.this), "", e11);
                }
            }
        });
    }

    public static de a(Context context) {
        if (f51582a == null) {
            synchronized (de.class) {
                if (f51582a == null) {
                    f51582a = new de(context);
                }
            }
        }
        return f51582a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0138 A[SYNTHETIC, Splitter:B:68:0x0138] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0156 A[SYNTHETIC, Splitter:B:80:0x0156] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0164 A[SYNTHETIC, Splitter:B:86:0x0164] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0182 A[SYNTHETIC, Splitter:B:98:0x0182] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a() {
        /*
            r11 = this;
            java.lang.String r0 = "log1.txt"
            java.lang.String r1 = ""
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            android.content.Context r4 = r11.f2666a     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r5 = f2663a     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r3.<init>(r4, r5)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            boolean r4 = com.xiaomi.push.w.a((java.io.File) r3)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            if (r4 != 0) goto L_0x002f
            java.lang.String r0 = r11.f51583b     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r4.<init>()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r5 = "Cannot wirte internal file: "
            r4.append(r5)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            r4.append(r3)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            android.util.Log.w(r0, r3)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            return
        L_0x002f:
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            if (r4 == 0) goto L_0x003b
            boolean r4 = r3.isDirectory()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            if (r4 != 0) goto L_0x0049
        L_0x003b:
            boolean r4 = r3.mkdirs()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            if (r4 != 0) goto L_0x0049
            java.lang.String r0 = r11.f51583b     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r3 = "Create mipushlog directory fail."
            android.util.Log.w(r0, r3)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            return
        L_0x0049:
            java.io.File r4 = new java.io.File     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r5 = "log.lock"
            r4.<init>(r3, r5)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            boolean r5 = r4.exists()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            if (r5 == 0) goto L_0x005c
            boolean r5 = r4.isDirectory()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            if (r5 == 0) goto L_0x005f
        L_0x005c:
            r4.createNewFile()     // Catch:{ Exception -> 0x012e, all -> 0x012a }
        L_0x005f:
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.lang.String r6 = "rw"
            r5.<init>(r4, r6)     // Catch:{ Exception -> 0x012e, all -> 0x012a }
            java.nio.channels.FileChannel r4 = r5.getChannel()     // Catch:{ Exception -> 0x0127, all -> 0x0124 }
            java.nio.channels.FileLock r4 = r4.lock()     // Catch:{ Exception -> 0x0127, all -> 0x0124 }
            java.io.BufferedWriter r6 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0122 }
            java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0122 }
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0122 }
            java.io.File r9 = new java.io.File     // Catch:{ Exception -> 0x0122 }
            r9.<init>(r3, r0)     // Catch:{ Exception -> 0x0122 }
            r10 = 1
            r8.<init>(r9, r10)     // Catch:{ Exception -> 0x0122 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x0122 }
            r6.<init>(r7)     // Catch:{ Exception -> 0x0122 }
        L_0x0083:
            java.util.List<android.util.Pair<java.lang.String, java.lang.Throwable>> r7 = f2665a     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            boolean r7 = r7.isEmpty()     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            if (r7 != 0) goto L_0x00d7
            java.util.List<android.util.Pair<java.lang.String, java.lang.Throwable>> r7 = f2665a     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            r8 = 0
            java.lang.Object r7 = r7.remove(r8)     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            android.util.Pair r7 = (android.util.Pair) r7     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            java.lang.Object r8 = r7.first     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            java.lang.Object r9 = r7.second     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            java.lang.String r10 = "\n"
            if (r9 == 0) goto L_0x00c4
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            r9.<init>()     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            r9.append(r8)     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            r9.append(r10)     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            r9.<init>()     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            r9.append(r8)     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            java.lang.Object r7 = r7.second     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            java.lang.Throwable r7 = (java.lang.Throwable) r7     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            java.lang.String r7 = android.util.Log.getStackTraceString(r7)     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            r9.append(r7)     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            java.lang.String r8 = r9.toString()     // Catch:{ Exception -> 0x011f, all -> 0x011c }
        L_0x00c4:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            r7.<init>()     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            r7.append(r8)     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            r7.append(r10)     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            r6.write(r7)     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            goto L_0x0083
        L_0x00d7:
            r6.flush()     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            r6.close()     // Catch:{ Exception -> 0x011f, all -> 0x011c }
            java.io.File r6 = new java.io.File     // Catch:{ Exception -> 0x0122 }
            r6.<init>(r3, r0)     // Catch:{ Exception -> 0x0122 }
            long r7 = r6.length()     // Catch:{ Exception -> 0x0122 }
            r9 = 1048576(0x100000, double:5.180654E-318)
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x0106
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x0122 }
            java.lang.String r7 = "log0.txt"
            r0.<init>(r3, r7)     // Catch:{ Exception -> 0x0122 }
            boolean r3 = r0.exists()     // Catch:{ Exception -> 0x0122 }
            if (r3 == 0) goto L_0x0103
            boolean r3 = r0.isFile()     // Catch:{ Exception -> 0x0122 }
            if (r3 == 0) goto L_0x0103
            r0.delete()     // Catch:{ Exception -> 0x0122 }
        L_0x0103:
            r6.renameTo(r0)     // Catch:{ Exception -> 0x0122 }
        L_0x0106:
            if (r4 == 0) goto L_0x0118
            boolean r0 = r4.isValid()
            if (r0 == 0) goto L_0x0118
            r4.release()     // Catch:{ IOException -> 0x0112 }
            goto L_0x0118
        L_0x0112:
            r0 = move-exception
            java.lang.String r2 = r11.f51583b
            android.util.Log.e(r2, r1, r0)
        L_0x0118:
            r5.close()     // Catch:{ IOException -> 0x015a }
            goto L_0x0160
        L_0x011c:
            r0 = move-exception
            r2 = r6
            goto L_0x0162
        L_0x011f:
            r0 = move-exception
            r2 = r6
            goto L_0x0131
        L_0x0122:
            r0 = move-exception
            goto L_0x0131
        L_0x0124:
            r0 = move-exception
            r4 = r2
            goto L_0x0162
        L_0x0127:
            r0 = move-exception
            r4 = r2
            goto L_0x0131
        L_0x012a:
            r0 = move-exception
            r4 = r2
            r5 = r4
            goto L_0x0162
        L_0x012e:
            r0 = move-exception
            r4 = r2
            r5 = r4
        L_0x0131:
            java.lang.String r3 = r11.f51583b     // Catch:{ all -> 0x0161 }
            android.util.Log.e(r3, r1, r0)     // Catch:{ all -> 0x0161 }
            if (r2 == 0) goto L_0x0142
            r2.close()     // Catch:{ IOException -> 0x013c }
            goto L_0x0142
        L_0x013c:
            r0 = move-exception
            java.lang.String r2 = r11.f51583b
            android.util.Log.e(r2, r1, r0)
        L_0x0142:
            if (r4 == 0) goto L_0x0154
            boolean r0 = r4.isValid()
            if (r0 == 0) goto L_0x0154
            r4.release()     // Catch:{ IOException -> 0x014e }
            goto L_0x0154
        L_0x014e:
            r0 = move-exception
            java.lang.String r2 = r11.f51583b
            android.util.Log.e(r2, r1, r0)
        L_0x0154:
            if (r5 == 0) goto L_0x0160
            r5.close()     // Catch:{ IOException -> 0x015a }
            goto L_0x0160
        L_0x015a:
            r0 = move-exception
            java.lang.String r2 = r11.f51583b
            android.util.Log.e(r2, r1, r0)
        L_0x0160:
            return
        L_0x0161:
            r0 = move-exception
        L_0x0162:
            if (r2 == 0) goto L_0x016e
            r2.close()     // Catch:{ IOException -> 0x0168 }
            goto L_0x016e
        L_0x0168:
            r2 = move-exception
            java.lang.String r3 = r11.f51583b
            android.util.Log.e(r3, r1, r2)
        L_0x016e:
            if (r4 == 0) goto L_0x0180
            boolean r2 = r4.isValid()
            if (r2 == 0) goto L_0x0180
            r4.release()     // Catch:{ IOException -> 0x017a }
            goto L_0x0180
        L_0x017a:
            r2 = move-exception
            java.lang.String r3 = r11.f51583b
            android.util.Log.e(r3, r1, r2)
        L_0x0180:
            if (r5 == 0) goto L_0x018c
            r5.close()     // Catch:{ IOException -> 0x0186 }
            goto L_0x018c
        L_0x0186:
            r2 = move-exception
            java.lang.String r3 = r11.f51583b
            android.util.Log.e(r3, r1, r2)
        L_0x018c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.de.a():void");
    }
}
