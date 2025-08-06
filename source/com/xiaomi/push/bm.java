package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;
import net.sf.scuba.smartcards.ISO7816;

public class bm {
    public static String a() {
        return Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + j.e();
    }

    @TargetApi(9)
    public static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(az.a(str), 16);
        copyOf[0] = ISO7816.INS_REHABILITATE_CHV;
        copyOf[15] = 84;
        return copyOf;
    }

    public static String a(Context context) {
        String a11 = bn.a(context).a("sp_client_report_status", "sp_client_report_key", "");
        if (!TextUtils.isEmpty(a11)) {
            return a11;
        }
        String a12 = bc.a(20);
        bn.a(context).a("sp_client_report_status", "sp_client_report_key", a12);
        return a12;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2441a(Context context) {
        try {
            if (context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    public static void a(Context context, List<String> list) {
        if (list != null && list.size() > 0 && a(context)) {
            for (String next : list) {
                if (!TextUtils.isEmpty(next)) {
                    a(context, next);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f2, code lost:
        if (r7 == null) goto L_0x00f7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0112  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            if (r11 == 0) goto L_0x0132
            if (r12 == 0) goto L_0x0132
            if (r13 != 0) goto L_0x0008
            goto L_0x0132
        L_0x0008:
            java.io.File r0 = new java.io.File
            java.io.File r1 = r11.getFilesDir()
            r0.<init>(r1, r13)
            boolean r13 = r0.exists()
            if (r13 != 0) goto L_0x001a
            r0.mkdirs()
        L_0x001a:
            java.io.File r13 = new java.io.File
            java.io.File r11 = r11.getFilesDir()
            r13.<init>(r11, r12)
            boolean r11 = r13.exists()
            if (r11 != 0) goto L_0x002d
            r13.mkdirs()
            return
        L_0x002d:
            com.xiaomi.push.bm$1 r11 = new com.xiaomi.push.bm$1
            r11.<init>()
            java.io.File[] r11 = r13.listFiles(r11)
            if (r11 == 0) goto L_0x0132
            int r12 = r11.length
            if (r12 > 0) goto L_0x003d
            goto L_0x0132
        L_0x003d:
            long r12 = java.lang.System.currentTimeMillis()
            int r1 = r11.length
            r2 = 0
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0046:
            if (r2 >= r1) goto L_0x0132
            r6 = r11[r2]
            if (r6 == 0) goto L_0x0116
            java.lang.String r7 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00d8, all -> 0x00d6 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x00d8, all -> 0x00d6 }
            if (r7 == 0) goto L_0x0058
            goto L_0x0116
        L_0x0058:
            java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x00d8, all -> 0x00d6 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00d8, all -> 0x00d6 }
            r8.<init>()     // Catch:{ Exception -> 0x00d8, all -> 0x00d6 }
            java.lang.String r9 = r6.getAbsolutePath()     // Catch:{ Exception -> 0x00d8, all -> 0x00d6 }
            r8.append(r9)     // Catch:{ Exception -> 0x00d8, all -> 0x00d6 }
            java.lang.String r9 = ".lock"
            r8.append(r9)     // Catch:{ Exception -> 0x00d8, all -> 0x00d6 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00d8, all -> 0x00d6 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x00d8, all -> 0x00d6 }
            com.xiaomi.push.x.a((java.io.File) r7)     // Catch:{ Exception -> 0x00d1, all -> 0x00cf }
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x00d1, all -> 0x00cf }
            java.lang.String r8 = "rw"
            r5.<init>(r7, r8)     // Catch:{ Exception -> 0x00d1, all -> 0x00cf }
            java.nio.channels.FileChannel r4 = r5.getChannel()     // Catch:{ Exception -> 0x00cd }
            java.nio.channels.FileLock r3 = r4.lock()     // Catch:{ Exception -> 0x00cd }
            java.lang.String r4 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x00cd }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00cd }
            r8.<init>()     // Catch:{ Exception -> 0x00cd }
            r8.append(r4)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r4 = java.io.File.separator     // Catch:{ Exception -> 0x00cd }
            r8.append(r4)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r4 = r6.getName()     // Catch:{ Exception -> 0x00cd }
            r8.append(r4)     // Catch:{ Exception -> 0x00cd }
            r8.append(r12)     // Catch:{ Exception -> 0x00cd }
            java.lang.String r4 = r8.toString()     // Catch:{ Exception -> 0x00cd }
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00cd }
            r8.<init>(r4)     // Catch:{ Exception -> 0x00cd }
            com.xiaomi.push.x.b(r6, r8)     // Catch:{ IOException -> 0x00ac }
            goto L_0x00b6
        L_0x00ac:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ Exception -> 0x00cd }
            r6.delete()     // Catch:{ Exception -> 0x00cd }
            r8.delete()     // Catch:{ Exception -> 0x00cd }
        L_0x00b6:
            r6.delete()     // Catch:{ Exception -> 0x00cd }
            if (r3 == 0) goto L_0x00c9
            boolean r4 = r3.isValid()
            if (r4 == 0) goto L_0x00c9
            r3.release()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00c9
        L_0x00c5:
            r4 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r4)
        L_0x00c9:
            com.xiaomi.push.x.a((java.io.Closeable) r5)
            goto L_0x00f4
        L_0x00cd:
            r4 = move-exception
            goto L_0x00dc
        L_0x00cf:
            r11 = move-exception
            goto L_0x00fc
        L_0x00d1:
            r5 = move-exception
            r10 = r5
            r5 = r4
            r4 = r10
            goto L_0x00dc
        L_0x00d6:
            r11 = move-exception
            goto L_0x00fd
        L_0x00d8:
            r6 = move-exception
            r7 = r5
            r5 = r4
            r4 = r6
        L_0x00dc:
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r4)     // Catch:{ all -> 0x00fa }
            if (r3 == 0) goto L_0x00ef
            boolean r4 = r3.isValid()
            if (r4 == 0) goto L_0x00ef
            r3.release()     // Catch:{ IOException -> 0x00eb }
            goto L_0x00ef
        L_0x00eb:
            r4 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r4)
        L_0x00ef:
            com.xiaomi.push.x.a((java.io.Closeable) r5)
            if (r7 == 0) goto L_0x00f7
        L_0x00f4:
            r7.delete()
        L_0x00f7:
            r4 = r5
            r5 = r7
            goto L_0x012e
        L_0x00fa:
            r11 = move-exception
            r4 = r5
        L_0x00fc:
            r5 = r7
        L_0x00fd:
            if (r3 == 0) goto L_0x010d
            boolean r12 = r3.isValid()
            if (r12 == 0) goto L_0x010d
            r3.release()     // Catch:{ IOException -> 0x0109 }
            goto L_0x010d
        L_0x0109:
            r12 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r12)
        L_0x010d:
            com.xiaomi.push.x.a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x0115
            r5.delete()
        L_0x0115:
            throw r11
        L_0x0116:
            if (r3 == 0) goto L_0x0126
            boolean r6 = r3.isValid()
            if (r6 == 0) goto L_0x0126
            r3.release()     // Catch:{ IOException -> 0x0122 }
            goto L_0x0126
        L_0x0122:
            r6 = move-exception
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r6)
        L_0x0126:
            com.xiaomi.push.x.a((java.io.Closeable) r4)
            if (r5 == 0) goto L_0x012e
            r5.delete()
        L_0x012e:
            int r2 = r2 + 1
            goto L_0x0046
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bm.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m2442a(Context context, String str) {
        File file = new File(str);
        long maxFileLength = a.a(context).a().getMaxFileLength();
        if (file.exists()) {
            try {
                if (file.length() > maxFileLength) {
                    return false;
                }
            } catch (Exception e11) {
                b.a((Throwable) e11);
                return false;
            }
        } else {
            x.a(file);
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static File[] m2443a(Context context, String str) {
        return new File(context.getFilesDir(), str).listFiles(new FilenameFilter() {
            public boolean accept(File file, String str) {
                return !TextUtils.isEmpty(str) && !str.toLowerCase().endsWith(".lock");
            }
        });
    }
}
