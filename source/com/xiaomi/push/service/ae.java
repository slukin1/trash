package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import com.xiaomi.push.bc;
import com.xiaomi.push.x;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class ae {

    /* renamed from: a  reason: collision with root package name */
    private static long f52439a = 0;

    /* renamed from: a  reason: collision with other field name */
    private static boolean f3320a = false;

    /* renamed from: b  reason: collision with root package name */
    private static long f52440b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f52441a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f3321a;

        public a(byte[] bArr, int i11) {
            this.f3321a = bArr;
            this.f52441a = i11;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f52442a;

        /* renamed from: a  reason: collision with other field name */
        public Bitmap f3322a;

        public b(Bitmap bitmap, long j11) {
            this.f3322a = bitmap;
            this.f52442a = j11;
        }
    }

    public static b a(Context context, String str, boolean z11) {
        ByteArrayInputStream byteArrayInputStream = null;
        b bVar = new b((Bitmap) null, 0);
        try {
            Bitmap b11 = b(context, str);
            if (b11 != null) {
                bVar.f3322a = b11;
                x.a((Closeable) null);
                return bVar;
            }
            a a11 = a(str, z11);
            if (a11 == null) {
                x.a((Closeable) null);
                return bVar;
            }
            bVar.f52442a = (long) a11.f52441a;
            byte[] bArr = a11.f3321a;
            if (bArr != null) {
                if (z11) {
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(bArr);
                    try {
                        int a12 = a(context, (InputStream) byteArrayInputStream2);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inSampleSize = a12;
                        bVar.f3322a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
                        byteArrayInputStream = byteArrayInputStream2;
                    } catch (Exception e11) {
                        e = e11;
                        byteArrayInputStream = byteArrayInputStream2;
                        try {
                            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
                            x.a((Closeable) byteArrayInputStream);
                            return bVar;
                        } catch (Throwable th2) {
                            th = th2;
                            x.a((Closeable) byteArrayInputStream);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        byteArrayInputStream = byteArrayInputStream2;
                        x.a((Closeable) byteArrayInputStream);
                        throw th;
                    }
                } else {
                    bVar.f3322a = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                }
            }
            a(context, a11.f3321a, str);
            x.a((Closeable) byteArrayInputStream);
            return bVar;
        } catch (Exception e12) {
            e = e12;
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
            x.a((Closeable) byteArrayInputStream);
            return bVar;
        }
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [android.graphics.Bitmap, java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized android.graphics.Bitmap b(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.Class<com.xiaomi.push.service.ae> r0 = com.xiaomi.push.service.ae.class
            monitor-enter(r0)
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x0050 }
            java.lang.String r6 = a((android.content.Context) r6)     // Catch:{ all -> 0x0050 }
            java.lang.String r7 = com.xiaomi.push.bc.a((java.lang.String) r7)     // Catch:{ all -> 0x0050 }
            r2.<init>(r6, r7)     // Catch:{ all -> 0x0050 }
            boolean r6 = r2.exists()     // Catch:{ all -> 0x0050 }
            if (r6 != 0) goto L_0x001c
            com.xiaomi.push.x.a((java.io.Closeable) r1)     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)
            return r1
        L_0x001c:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0050 }
            long r3 = r2.lastModified()     // Catch:{ all -> 0x0050 }
            long r6 = r6 - r3
            r3 = 1209600000(0x48190800, double:5.97621805E-315)
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x0036
            java.lang.String r6 = "The pic cache has expired."
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r6)     // Catch:{ all -> 0x0050 }
            com.xiaomi.push.x.a((java.io.Closeable) r1)     // Catch:{ all -> 0x0071 }
            monitor-exit(r0)
            return r1
        L_0x0036:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ all -> 0x0050 }
            r6.<init>(r2)     // Catch:{ all -> 0x0050 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r6)     // Catch:{ all -> 0x004a }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x004a }
            r2.setLastModified(r3)     // Catch:{ all -> 0x004a }
            com.xiaomi.push.x.a((java.io.Closeable) r6)     // Catch:{ all -> 0x0071 }
            goto L_0x006a
        L_0x004a:
            r7 = move-exception
            r5 = r1
            r1 = r6
            r6 = r7
            r7 = r5
            goto L_0x0052
        L_0x0050:
            r6 = move-exception
            r7 = r1
        L_0x0052:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006c }
            r2.<init>()     // Catch:{ all -> 0x006c }
            java.lang.String r3 = "Load bmp from cache error: "
            r2.append(r3)     // Catch:{ all -> 0x006c }
            r2.append(r6)     // Catch:{ all -> 0x006c }
            java.lang.String r6 = r2.toString()     // Catch:{ all -> 0x006c }
            com.xiaomi.channel.commonutils.logger.b.d(r6)     // Catch:{ all -> 0x006c }
            com.xiaomi.push.x.a((java.io.Closeable) r1)     // Catch:{ all -> 0x0071 }
            r1 = r7
        L_0x006a:
            monitor-exit(r0)
            return r1
        L_0x006c:
            r6 = move-exception
            com.xiaomi.push.x.a((java.io.Closeable) r1)     // Catch:{ all -> 0x0071 }
            throw r6     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ae.b(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    private static synchronized void b(Context context) {
        String str;
        synchronized (ae.class) {
            if (!f3320a) {
                f52439a = 0;
                f52440b = 0;
                try {
                    File file = new File(a(context));
                    if (!file.exists()) {
                        f3320a = true;
                        com.xiaomi.channel.commonutils.logger.b.b("Init pic cache finish.");
                        return;
                    }
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        for (File file2 : listFiles) {
                            f52439a += file2.length();
                            long j11 = f52440b;
                            if (j11 <= 0) {
                                f52440b = file2.lastModified();
                            } else {
                                f52440b = Math.min(j11, file2.lastModified());
                            }
                        }
                    }
                    f3320a = true;
                    str = "Init pic cache finish.";
                    com.xiaomi.channel.commonutils.logger.b.b(str);
                    return;
                } catch (Throwable th2) {
                    f3320a = true;
                    com.xiaomi.channel.commonutils.logger.b.b("Init pic cache finish.");
                    throw th2;
                }
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d8, code lost:
        if (r1 == null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00da, code lost:
        r1.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00f7, code lost:
        if (r1 == null) goto L_0x00fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00fa, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00e0 */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0102  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:55:0x00e0=Splitter:B:55:0x00e0, B:48:0x00d2=Splitter:B:48:0x00d2} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.xiaomi.push.service.ae.a a(java.lang.String r10, boolean r11) {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ SocketTimeoutException -> 0x00de, IOException -> 0x00cf, all -> 0x00cc }
            r1.<init>(r10)     // Catch:{ SocketTimeoutException -> 0x00de, IOException -> 0x00cf, all -> 0x00cc }
            java.net.URLConnection r1 = r1.openConnection()     // Catch:{ SocketTimeoutException -> 0x00de, IOException -> 0x00cf, all -> 0x00cc }
            java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ SocketTimeoutException -> 0x00de, IOException -> 0x00cf, all -> 0x00cc }
            r2 = 8000(0x1f40, float:1.121E-41)
            r1.setConnectTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            r2 = 20000(0x4e20, float:2.8026E-41)
            r1.setReadTimeout(r2)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            java.lang.String r2 = "User-agent"
            java.lang.String r3 = "Mozilla/5.0 (Linux; U;) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/71.0.3578.141 Mobile Safari/537.36 XiaoMi/MiuiBrowser"
            r1.setRequestProperty(r2, r3)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            r1.connect()     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            int r2 = r1.getContentLength()     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            r3 = 102400(0x19000, float:1.43493E-40)
            if (r11 == 0) goto L_0x0053
            if (r2 <= r3) goto L_0x0053
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            r11.<init>()     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            java.lang.String r3 = "Bitmap size is too big, max size is 102400  contentLen size is "
            r11.append(r3)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            r11.append(r2)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            java.lang.String r2 = " from url "
            r11.append(r2)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            r2 = 3
            java.lang.String r2 = com.xiaomi.push.bc.a((java.lang.String) r10, (int) r2)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            r11.append(r2)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            java.lang.String r11 = r11.toString()     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r11)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            com.xiaomi.push.x.a((java.io.Closeable) r0)
            r1.disconnect()
            return r0
        L_0x0053:
            int r2 = r1.getResponseCode()     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 == r4) goto L_0x007b
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            r11.<init>()     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            java.lang.String r3 = "Invalid Http Response Code "
            r11.append(r3)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            r11.append(r2)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            java.lang.String r2 = " received"
            r11.append(r2)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            java.lang.String r11 = r11.toString()     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r11)     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            com.xiaomi.push.x.a((java.io.Closeable) r0)
            r1.disconnect()
            return r0
        L_0x007b:
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ SocketTimeoutException -> 0x00ca, IOException -> 0x00c7, all -> 0x00c5 }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ SocketTimeoutException -> 0x00e0, IOException -> 0x00c3 }
            r4.<init>()     // Catch:{ SocketTimeoutException -> 0x00e0, IOException -> 0x00c3 }
            if (r11 == 0) goto L_0x0088
            r11 = r3
            goto L_0x008b
        L_0x0088:
            r11 = 2048000(0x1f4000, float:2.869859E-39)
        L_0x008b:
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r5]     // Catch:{ SocketTimeoutException -> 0x00e0, IOException -> 0x00c3 }
        L_0x008f:
            if (r11 <= 0) goto L_0x009f
            r7 = 0
            int r8 = r2.read(r6, r7, r5)     // Catch:{ SocketTimeoutException -> 0x00e0, IOException -> 0x00c3 }
            r9 = -1
            if (r8 != r9) goto L_0x009a
            goto L_0x009f
        L_0x009a:
            int r11 = r11 - r8
            r4.write(r6, r7, r8)     // Catch:{ SocketTimeoutException -> 0x00e0, IOException -> 0x00c3 }
            goto L_0x008f
        L_0x009f:
            if (r11 > 0) goto L_0x00b2
            java.lang.String r11 = "length 102400 exhausted."
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.String) r11)     // Catch:{ SocketTimeoutException -> 0x00e0, IOException -> 0x00c3 }
            com.xiaomi.push.service.ae$a r11 = new com.xiaomi.push.service.ae$a     // Catch:{ SocketTimeoutException -> 0x00e0, IOException -> 0x00c3 }
            r11.<init>(r0, r3)     // Catch:{ SocketTimeoutException -> 0x00e0, IOException -> 0x00c3 }
            com.xiaomi.push.x.a((java.io.Closeable) r2)
            r1.disconnect()
            return r11
        L_0x00b2:
            byte[] r11 = r4.toByteArray()     // Catch:{ SocketTimeoutException -> 0x00e0, IOException -> 0x00c3 }
            com.xiaomi.push.service.ae$a r3 = new com.xiaomi.push.service.ae$a     // Catch:{ SocketTimeoutException -> 0x00e0, IOException -> 0x00c3 }
            int r4 = r11.length     // Catch:{ SocketTimeoutException -> 0x00e0, IOException -> 0x00c3 }
            r3.<init>(r11, r4)     // Catch:{ SocketTimeoutException -> 0x00e0, IOException -> 0x00c3 }
            com.xiaomi.push.x.a((java.io.Closeable) r2)
            r1.disconnect()
            return r3
        L_0x00c3:
            r10 = move-exception
            goto L_0x00d2
        L_0x00c5:
            r10 = move-exception
            goto L_0x00fd
        L_0x00c7:
            r10 = move-exception
            r2 = r0
            goto L_0x00d2
        L_0x00ca:
            r2 = r0
            goto L_0x00e0
        L_0x00cc:
            r10 = move-exception
            r1 = r0
            goto L_0x00fd
        L_0x00cf:
            r10 = move-exception
            r1 = r0
            r2 = r1
        L_0x00d2:
            com.xiaomi.channel.commonutils.logger.b.a((java.lang.Throwable) r10)     // Catch:{ all -> 0x00fb }
            com.xiaomi.push.x.a((java.io.Closeable) r2)
            if (r1 == 0) goto L_0x00fa
        L_0x00da:
            r1.disconnect()
            goto L_0x00fa
        L_0x00de:
            r1 = r0
            r2 = r1
        L_0x00e0:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r11.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r3 = "Connect timeout to "
            r11.append(r3)     // Catch:{ all -> 0x00fb }
            r11.append(r10)     // Catch:{ all -> 0x00fb }
            java.lang.String r10 = r11.toString()     // Catch:{ all -> 0x00fb }
            com.xiaomi.channel.commonutils.logger.b.d(r10)     // Catch:{ all -> 0x00fb }
            com.xiaomi.push.x.a((java.io.Closeable) r2)
            if (r1 == 0) goto L_0x00fa
            goto L_0x00da
        L_0x00fa:
            return r0
        L_0x00fb:
            r10 = move-exception
            r0 = r2
        L_0x00fd:
            com.xiaomi.push.x.a((java.io.Closeable) r0)
            if (r1 == 0) goto L_0x0105
            r1.disconnect()
        L_0x0105:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ae.a(java.lang.String, boolean):com.xiaomi.push.service.ae$a");
    }

    public static Bitmap a(Context context, String str) {
        InputStream inputStream;
        InputStream inputStream2;
        int a11;
        Uri parse = Uri.parse(str);
        InputStream inputStream3 = null;
        try {
            inputStream = context.getContentResolver().openInputStream(parse);
            try {
                a11 = a(context, inputStream);
                inputStream2 = context.getContentResolver().openInputStream(parse);
            } catch (IOException e11) {
                e = e11;
                inputStream2 = null;
                try {
                    com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
                    x.a((Closeable) inputStream2);
                    x.a((Closeable) inputStream);
                    return null;
                } catch (Throwable th2) {
                    th = th2;
                    inputStream3 = inputStream2;
                    x.a((Closeable) inputStream3);
                    x.a((Closeable) inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                x.a((Closeable) inputStream3);
                x.a((Closeable) inputStream);
                throw th;
            }
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = a11;
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream2, (Rect) null, options);
                x.a((Closeable) inputStream2);
                x.a((Closeable) inputStream);
                return decodeStream;
            } catch (IOException e12) {
                e = e12;
                com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
                x.a((Closeable) inputStream2);
                x.a((Closeable) inputStream);
                return null;
            }
        } catch (IOException e13) {
            e = e13;
            inputStream2 = null;
            inputStream = null;
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e);
            x.a((Closeable) inputStream2);
            x.a((Closeable) inputStream);
            return null;
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            x.a((Closeable) inputStream3);
            x.a((Closeable) inputStream);
            throw th;
        }
    }

    private static int a(Context context, InputStream inputStream) {
        int i11;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, (Rect) null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            com.xiaomi.channel.commonutils.logger.b.a("decode dimension failed for bitmap.");
            return 1;
        }
        int round = Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * 48.0f);
        int i12 = options.outWidth;
        if (i12 <= round || (i11 = options.outHeight) <= round) {
            return 1;
        }
        return Math.min(i12 / round, i11 / round);
    }

    private static void a(Context context, byte[] bArr, String str) {
        FileOutputStream fileOutputStream;
        BufferedOutputStream bufferedOutputStream;
        if (bArr == null) {
            com.xiaomi.channel.commonutils.logger.b.a("cannot save small icon cause bitmap is null");
            return;
        }
        a(context);
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            File file = new File(a(context));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, bc.a(str));
            if (!file2.exists()) {
                file2.createNewFile();
            }
            fileOutputStream = new FileOutputStream(file2);
            try {
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            } catch (Exception e11) {
                e = e11;
                try {
                    com.xiaomi.channel.commonutils.logger.b.d("Save pic error: " + e);
                    x.a((Closeable) bufferedOutputStream2);
                    x.a((Closeable) fileOutputStream);
                } catch (Throwable th2) {
                    th = th2;
                    x.a((Closeable) bufferedOutputStream2);
                    x.a((Closeable) fileOutputStream);
                    throw th;
                }
            }
            try {
                bufferedOutputStream.write(bArr);
                bufferedOutputStream.flush();
                f52439a += file2.length();
                long j11 = f52440b;
                if (j11 <= 0) {
                    f52440b = file2.lastModified();
                } else {
                    f52440b = Math.min(j11, file2.lastModified());
                }
                x.a((Closeable) bufferedOutputStream);
            } catch (Exception e12) {
                e = e12;
                bufferedOutputStream2 = bufferedOutputStream;
                com.xiaomi.channel.commonutils.logger.b.d("Save pic error: " + e);
                x.a((Closeable) bufferedOutputStream2);
                x.a((Closeable) fileOutputStream);
            } catch (Throwable th3) {
                th = th3;
                bufferedOutputStream2 = bufferedOutputStream;
                x.a((Closeable) bufferedOutputStream2);
                x.a((Closeable) fileOutputStream);
                throw th;
            }
        } catch (Exception e13) {
            e = e13;
            fileOutputStream = null;
            com.xiaomi.channel.commonutils.logger.b.d("Save pic error: " + e);
            x.a((Closeable) bufferedOutputStream2);
            x.a((Closeable) fileOutputStream);
        } catch (Throwable th4) {
            th = th4;
            fileOutputStream = null;
            x.a((Closeable) bufferedOutputStream2);
            x.a((Closeable) fileOutputStream);
            throw th;
        }
        x.a((Closeable) fileOutputStream);
    }

    /* renamed from: a  reason: collision with other method in class */
    private static synchronized void m2972a(Context context) {
        long j11;
        synchronized (ae.class) {
            b(context);
            if (f52439a >= 62914560 || System.currentTimeMillis() - f52440b >= 1209600000) {
                try {
                    File file = new File(a(context));
                    if (!file.exists()) {
                        com.xiaomi.channel.commonutils.logger.b.a("The pic cache dir do not exists.");
                        return;
                    }
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        a(listFiles);
                        long j12 = f52439a;
                        int length = listFiles.length - 1;
                        while (true) {
                            if (length < 0) {
                                j11 = 0;
                                break;
                            }
                            File file2 = listFiles[length];
                            if (file2 != null) {
                                if (j12 <= 31457280) {
                                    if (System.currentTimeMillis() - file2.lastModified() <= 864000000) {
                                        j11 = file2.lastModified();
                                        break;
                                    }
                                }
                                j12 -= file2.length();
                                file2.delete();
                            }
                            length--;
                        }
                        f52439a = Math.max(j12, 0);
                        f52440b = j11;
                    } else {
                        com.xiaomi.channel.commonutils.logger.b.a("The pic cache file list is null.");
                    }
                } catch (Throwable th2) {
                    com.xiaomi.channel.commonutils.logger.b.d("Clear pic cache error: " + th2);
                }
            } else {
                return;
            }
        }
        return;
    }

    private static void a(File[] fileArr) {
        if (fileArr != null) {
            try {
                if (fileArr.length > 1) {
                    Arrays.sort(fileArr, new Comparator<File>() {
                        /* renamed from: a */
                        public int compare(File file, File file2) {
                            if (file == file2) {
                                return 0;
                            }
                            if (file == null) {
                                return 1;
                            }
                            if (file2 == null) {
                                return -1;
                            }
                            int i11 = ((file.lastModified() - file2.lastModified()) > 0 ? 1 : ((file.lastModified() - file2.lastModified()) == 0 ? 0 : -1));
                            if (i11 == 0) {
                                return 0;
                            }
                            return i11 < 0 ? 1 : -1;
                        }
                    });
                }
            } catch (Throwable th2) {
                com.xiaomi.channel.commonutils.logger.b.d("Sort pic cache error: " + th2);
            }
        }
    }

    private static String a(Context context) {
        return context.getCacheDir().getPath() + File.separator + "mipush_icon";
    }
}
