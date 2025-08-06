package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class db {

    /* renamed from: a  reason: collision with root package name */
    private static String f51568a = "/MiPushLog";

    /* renamed from: a  reason: collision with other field name */
    private int f2644a;
    @SuppressLint({"SimpleDateFormat"})

    /* renamed from: a  reason: collision with other field name */
    private final SimpleDateFormat f2645a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* renamed from: a  reason: collision with other field name */
    private ArrayList<File> f2646a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private boolean f2647a;

    /* renamed from: b  reason: collision with root package name */
    private int f51569b = 2097152;

    /* renamed from: b  reason: collision with other field name */
    private String f2648b;

    /* renamed from: c  reason: collision with root package name */
    private String f51570c;

    public db a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f2648b = this.f2645a.format(date2);
            this.f51570c = this.f2645a.format(date);
        } else {
            this.f2648b = this.f2645a.format(date);
            this.f51570c = this.f2645a.format(date2);
        }
        return this;
    }

    public void a(int i11) {
        if (i11 != 0) {
            this.f51569b = i11;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public db m2517a(File file) {
        if (file.exists()) {
            this.f2646a.add(file);
        }
        return this;
    }

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) {
        char[] cArr = new char[4096];
        int read = bufferedReader.read(cArr);
        boolean z11 = false;
        while (read != -1 && !z11) {
            String str = new String(cArr, 0, read);
            Matcher matcher = pattern.matcher(str);
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i11 >= read || !matcher.find(i11)) {
                    break;
                }
                int start = matcher.start();
                String substring = str.substring(start, this.f2648b.length() + start);
                if (this.f2647a) {
                    if (substring.compareTo(this.f51570c) > 0) {
                        z11 = true;
                        read = start;
                        break;
                    }
                } else if (substring.compareTo(this.f2648b) >= 0) {
                    this.f2647a = true;
                    i12 = start;
                }
                int indexOf = str.indexOf(10, start);
                if (indexOf == -1) {
                    indexOf = this.f2648b.length();
                }
                i11 = start + indexOf;
            }
            if (this.f2647a) {
                int i13 = read - i12;
                this.f2644a += i13;
                if (z11) {
                    bufferedWriter.write(cArr, i12, i13);
                    return;
                }
                bufferedWriter.write(cArr, i12, i13);
                if (this.f2644a > this.f51569b) {
                    return;
                }
            }
            read = bufferedReader.read(cArr);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: java.io.BufferedReader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v22, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v23, resolved type: java.io.BufferedWriter} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: java.io.BufferedWriter} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.io.File r9) {
        /*
            r8 = this;
            java.lang.String r0 = "LOG: filter error = "
            java.lang.String r1 = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            r2 = 0
            java.io.BufferedWriter r3 = new java.io.BufferedWriter     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00c4, all -> 0x00c1 }
            java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00c4, all -> 0x00c1 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00c4, all -> 0x00c1 }
            r5.<init>(r9)     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00c4, all -> 0x00c1 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00c4, all -> 0x00c1 }
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00dd, IOException -> 0x00c4, all -> 0x00c1 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r4 = "model :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r4 = com.xiaomi.push.k.a()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r4 = "; os :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r4 = com.xiaomi.push.j.e()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r4 = "; uid :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r4 = com.xiaomi.push.service.ax.a()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r4 = "; lng :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.util.Locale r4 = java.util.Locale.getDefault()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r4 = "; sdk :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r4 = 48
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r4 = "; andver :"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r4 = "\n"
            r9.append(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r9 = r9.toString()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r3.write(r9)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r9 = 0
            r8.f2644a = r9     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.util.ArrayList<java.io.File> r9 = r8.f2646a     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
        L_0x007a:
            boolean r4 = r9.hasNext()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            if (r4 == 0) goto L_0x00a3
            java.lang.Object r4 = r9.next()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.io.File r4 = (java.io.File) r4     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r7.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r6.<init>(r7)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r8.a(r5, r3, r1)     // Catch:{ FileNotFoundException -> 0x00a1, IOException -> 0x009f, all -> 0x009d }
            r5.close()     // Catch:{ FileNotFoundException -> 0x00a1, IOException -> 0x009f, all -> 0x009d }
            r2 = r5
            goto L_0x007a
        L_0x009d:
            r9 = move-exception
            goto L_0x00b7
        L_0x009f:
            r9 = move-exception
            goto L_0x00bb
        L_0x00a1:
            r9 = move-exception
            goto L_0x00bf
        L_0x00a3:
            com.xiaomi.push.ch r9 = com.xiaomi.push.ch.a()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            java.lang.String r9 = r9.c()     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            r3.write(r9)     // Catch:{ FileNotFoundException -> 0x00bd, IOException -> 0x00b9, all -> 0x00b5 }
            com.xiaomi.push.x.a((java.io.Closeable) r3)
            com.xiaomi.push.x.a((java.io.Closeable) r2)
            goto L_0x00fb
        L_0x00b5:
            r9 = move-exception
            r5 = r2
        L_0x00b7:
            r2 = r3
            goto L_0x00fd
        L_0x00b9:
            r9 = move-exception
            r5 = r2
        L_0x00bb:
            r2 = r3
            goto L_0x00c6
        L_0x00bd:
            r9 = move-exception
            r5 = r2
        L_0x00bf:
            r2 = r3
            goto L_0x00df
        L_0x00c1:
            r9 = move-exception
            r5 = r2
            goto L_0x00fd
        L_0x00c4:
            r9 = move-exception
            r5 = r2
        L_0x00c6:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fc }
            r1.<init>()     // Catch:{ all -> 0x00fc }
            r1.append(r0)     // Catch:{ all -> 0x00fc }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00fc }
            r1.append(r9)     // Catch:{ all -> 0x00fc }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x00fc }
            com.xiaomi.channel.commonutils.logger.b.c(r9)     // Catch:{ all -> 0x00fc }
            goto L_0x00f5
        L_0x00dd:
            r9 = move-exception
            r5 = r2
        L_0x00df:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fc }
            r1.<init>()     // Catch:{ all -> 0x00fc }
            r1.append(r0)     // Catch:{ all -> 0x00fc }
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00fc }
            r1.append(r9)     // Catch:{ all -> 0x00fc }
            java.lang.String r9 = r1.toString()     // Catch:{ all -> 0x00fc }
            com.xiaomi.channel.commonutils.logger.b.c(r9)     // Catch:{ all -> 0x00fc }
        L_0x00f5:
            com.xiaomi.push.x.a((java.io.Closeable) r2)
            com.xiaomi.push.x.a((java.io.Closeable) r5)
        L_0x00fb:
            return
        L_0x00fc:
            r9 = move-exception
        L_0x00fd:
            com.xiaomi.push.x.a((java.io.Closeable) r2)
            com.xiaomi.push.x.a((java.io.Closeable) r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.db.a(java.io.File):void");
    }

    public File a(Context context, Date date, Date date2, File file) {
        File file2;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            file2 = da.a(context);
            if (file2 == null) {
                return null;
            }
            a(new File(file2, "xmsf.log.1"));
            a(new File(file2, "xmsf.log"));
        } else {
            File file3 = new File(context.getFilesDir() + f51568a);
            if (!w.a(file3)) {
                return null;
            }
            a(new File(file3, "log0.txt"));
            a(new File(file3, "log1.txt"));
            file2 = file3;
        }
        if (!file2.isDirectory()) {
            return null;
        }
        File file4 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
        if (file4.exists()) {
            return null;
        }
        a(date, date2);
        long currentTimeMillis = System.currentTimeMillis();
        File file5 = new File(file, "log.txt");
        a(file5);
        b.c("LOG: filter cost = " + (System.currentTimeMillis() - currentTimeMillis));
        if (file5.exists()) {
            long currentTimeMillis2 = System.currentTimeMillis();
            x.a(file4, file5);
            b.c("LOG: zip cost = " + (System.currentTimeMillis() - currentTimeMillis2));
            file5.delete();
            if (file4.exists()) {
                return file4;
            }
        }
        return null;
    }
}
