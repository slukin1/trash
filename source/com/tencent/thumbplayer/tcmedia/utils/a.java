package com.tencent.thumbplayer.tcmedia.utils;

import android.content.Context;
import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, a> f49682a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private C0629a f49683b;

    /* renamed from: com.tencent.thumbplayer.tcmedia.utils.a$a  reason: collision with other inner class name */
    public static class C0629a {

        /* renamed from: a  reason: collision with root package name */
        public File f49684a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final AtomicLong f49685b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f49686c;

        /* renamed from: d  reason: collision with root package name */
        private final long f49687d;

        /* renamed from: e  reason: collision with root package name */
        private final int f49688e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final Map<File, Long> f49689f;

        private C0629a(File file, long j11, int i11) {
            this.f49689f = Collections.synchronizedMap(new HashMap());
            this.f49684a = file;
            this.f49687d = j11;
            this.f49688e = i11;
            this.f49685b = new AtomicLong();
            this.f49686c = new AtomicInteger();
            a();
        }

        /* access modifiers changed from: private */
        public File a(String str) {
            File b11 = b(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            b11.setLastModified(valueOf.longValue());
            this.f49689f.put(b11, valueOf);
            return b11;
        }

        private void a() {
            o.a().d().execute(new Runnable() {
                public void run() {
                    File[] listFiles = C0629a.this.f49684a.listFiles();
                    if (listFiles != null) {
                        int i11 = 0;
                        int i12 = 0;
                        for (File file : listFiles) {
                            i11 = (int) (((long) i11) + C0629a.this.b(file));
                            i12++;
                            C0629a.this.f49689f.put(file, Long.valueOf(file.lastModified()));
                        }
                        C0629a.this.f49685b.set((long) i11);
                        C0629a.this.f49686c.set(i12);
                    }
                }
            });
        }

        /* access modifiers changed from: private */
        public void a(File file) {
            int i11 = this.f49686c.get();
            while (i11 + 1 > this.f49688e) {
                this.f49685b.addAndGet(-c());
                i11 = this.f49686c.addAndGet(-1);
            }
            this.f49686c.addAndGet(1);
            long b11 = b(file);
            long j11 = this.f49685b.get();
            while (j11 + b11 > this.f49687d) {
                j11 = this.f49685b.addAndGet(-c());
            }
            this.f49685b.addAndGet(b11);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.f49689f.put(file, valueOf);
        }

        /* access modifiers changed from: private */
        public long b(File file) {
            if (file == null) {
                return 0;
            }
            return file.length();
        }

        /* access modifiers changed from: private */
        public File b(String str) {
            File file = this.f49684a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str.hashCode());
            return new File(file, sb2.toString());
        }

        /* access modifiers changed from: private */
        public void b() {
            this.f49689f.clear();
            this.f49685b.set(0);
            this.f49686c.set(0);
            File[] listFiles = this.f49684a.listFiles();
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }

        private long c() {
            File file;
            if (this.f49689f.isEmpty()) {
                return 0;
            }
            Set<Map.Entry<File, Long>> entrySet = this.f49689f.entrySet();
            synchronized (this.f49689f) {
                file = null;
                Long l11 = null;
                for (Map.Entry next : entrySet) {
                    if (file == null) {
                        file = (File) next.getKey();
                        l11 = (Long) next.getValue();
                    } else {
                        Long l12 = (Long) next.getValue();
                        if (l12.longValue() < l11.longValue()) {
                            file = (File) next.getKey();
                            l11 = l12;
                        }
                    }
                }
            }
            if (file == null) {
                return 0;
            }
            long b11 = b(file);
            if (file.delete()) {
                this.f49689f.remove(file);
            }
            return b11;
        }

        /* access modifiers changed from: private */
        public boolean c(String str) {
            File a11 = a(str);
            long b11 = b(a11);
            if (!a11.delete()) {
                return false;
            }
            this.f49686c.addAndGet(-1);
            this.f49685b.addAndGet(-b11);
            return true;
        }
    }

    public static class b {
        private static int a(byte[] bArr, char c11) {
            for (int i11 = 0; i11 < bArr.length; i11++) {
                if (bArr[i11] == c11) {
                    return i11;
                }
            }
            return -1;
        }

        private static String a(int i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(System.currentTimeMillis());
            String sb3 = sb2.toString();
            while (sb3.length() < 13) {
                sb3 = "0".concat(sb3);
            }
            return sb3 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + i11 + ' ';
        }

        private static byte[] a(byte[] bArr, int i11, int i12) {
            int i13 = i12 - i11;
            if (i13 >= 0) {
                byte[] bArr2 = new byte[i13];
                System.arraycopy(bArr, i11, bArr2, 0, Math.min(bArr.length - i11, i13));
                return bArr2;
            }
            throw new IllegalArgumentException(i11 + " > " + i12);
        }

        /* access modifiers changed from: private */
        public static byte[] b(int i11, byte[] bArr) {
            byte[] bytes = a(i11).getBytes();
            byte[] bArr2 = new byte[(bytes.length + bArr.length)];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }

        /* access modifiers changed from: private */
        public static boolean c(byte[] bArr) {
            String[] f11 = f(bArr);
            if (f11 != null && f11.length == 2) {
                String str = f11[0];
                while (str.startsWith("0")) {
                    str = str.substring(1, str.length());
                }
                try {
                    if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(f11[1]).longValue() * 1000)) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }

        /* access modifiers changed from: private */
        public static byte[] d(byte[] bArr) {
            return e(bArr) ? a(bArr, a(bArr, ' ') + 1, bArr.length) : bArr;
        }

        private static boolean e(byte[] bArr) {
            return bArr != null && bArr.length > 15 && bArr[13] == 45 && a(bArr, ' ') > 14;
        }

        private static String[] f(byte[] bArr) {
            if (!e(bArr)) {
                return null;
            }
            return new String[]{new String(a(bArr, 0, 13)), new String(a(bArr, 14, a(bArr, ' ')))};
        }
    }

    private a(File file, long j11, int i11) {
        if (file.exists() || file.mkdirs()) {
            this.f49683b = new C0629a(file, j11, i11);
        } else {
            this.f49683b = null;
        }
    }

    public static a a(Context context, String str) {
        return a(new File(context.getCacheDir(), str), 50000000, Integer.MAX_VALUE);
    }

    public static a a(File file, long j11, int i11) {
        a aVar;
        try {
            Map<String, a> map = f49682a;
            aVar = map.get(file.getAbsoluteFile() + b());
        } catch (Exception unused) {
            aVar = null;
        }
        if (aVar != null) {
            return aVar;
        }
        try {
            a aVar2 = new a(file, j11, i11);
            try {
                Map<String, a> map2 = f49682a;
                map2.put(file.getAbsolutePath() + b(), aVar2);
            } catch (Throwable unused2) {
            }
            return aVar2;
        } catch (Throwable unused3) {
            return aVar;
        }
    }

    private static String b() {
        return "_" + Process.myPid();
    }

    public void a() {
        C0629a aVar = this.f49683b;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void a(String str, Serializable serializable) {
        a(str, serializable, -1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x002c A[SYNTHETIC, Splitter:B:19:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0037 A[SYNTHETIC, Splitter:B:26:0x0037] */
    /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x0032=Splitter:B:23:0x0032, B:16:0x0027=Splitter:B:16:0x0027} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r4, java.io.Serializable r5, int r6) {
        /*
            r3 = this;
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0031, all -> 0x0026 }
            r1.<init>()     // Catch:{ Exception -> 0x0031, all -> 0x0026 }
            java.io.ObjectOutputStream r2 = new java.io.ObjectOutputStream     // Catch:{ Exception -> 0x0031, all -> 0x0026 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0031, all -> 0x0026 }
            r2.writeObject(r5)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            byte[] r5 = r1.toByteArray()     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r0 = -1
            if (r6 == r0) goto L_0x0019
            r3.a((java.lang.String) r4, (byte[]) r5, (int) r6)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            goto L_0x001c
        L_0x0019:
            r3.a((java.lang.String) r4, (byte[]) r5)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
        L_0x001c:
            r2.close()     // Catch:{ all -> 0x001f }
        L_0x001f:
            return
        L_0x0020:
            r4 = move-exception
            r0 = r2
            goto L_0x0027
        L_0x0023:
            r4 = move-exception
            r0 = r2
            goto L_0x0032
        L_0x0026:
            r4 = move-exception
        L_0x0027:
            r4.printStackTrace()     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0030
            r0.close()     // Catch:{ all -> 0x0030 }
        L_0x0030:
            return
        L_0x0031:
            r4 = move-exception
        L_0x0032:
            r4.printStackTrace()     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ all -> 0x003b }
        L_0x003b:
            return
        L_0x003c:
            r4 = move-exception
            if (r0 == 0) goto L_0x0042
            r0.close()     // Catch:{ all -> 0x0042 }
        L_0x0042:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.a.a(java.lang.String, java.io.Serializable, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0031 A[SYNTHETIC, Splitter:B:23:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x003c A[SYNTHETIC, Splitter:B:27:0x003c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r3, byte[] r4) {
        /*
            r2 = this;
            com.tencent.thumbplayer.tcmedia.utils.a$a r0 = r2.f49683b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.io.File r3 = r0.b((java.lang.String) r3)
            r0 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x002b }
            r1.<init>(r3)     // Catch:{ Exception -> 0x002b }
            r1.write(r4)     // Catch:{ Exception -> 0x0026, all -> 0x0023 }
            r1.flush()     // Catch:{ IOException -> 0x0019 }
            r1.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            r4 = move-exception
        L_0x001a:
            r4.printStackTrace()
        L_0x001d:
            com.tencent.thumbplayer.tcmedia.utils.a$a r4 = r2.f49683b
            r4.a((java.io.File) r3)
            return
        L_0x0023:
            r4 = move-exception
            r0 = r1
            goto L_0x003a
        L_0x0026:
            r4 = move-exception
            r0 = r1
            goto L_0x002c
        L_0x0029:
            r4 = move-exception
            goto L_0x003a
        L_0x002b:
            r4 = move-exception
        L_0x002c:
            r4.printStackTrace()     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x001d
            r0.flush()     // Catch:{ IOException -> 0x0038 }
            r0.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x001d
        L_0x0038:
            r4 = move-exception
            goto L_0x001a
        L_0x003a:
            if (r0 == 0) goto L_0x0047
            r0.flush()     // Catch:{ IOException -> 0x0043 }
            r0.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0047:
            com.tencent.thumbplayer.tcmedia.utils.a$a r0 = r2.f49683b
            r0.a((java.io.File) r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.a.a(java.lang.String, byte[]):void");
    }

    public void a(String str, byte[] bArr, int i11) {
        a(str, b.b(i11, bArr));
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0058 A[SYNTHETIC, Splitter:B:37:0x0058] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0065 A[SYNTHETIC, Splitter:B:45:0x0065] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] a(java.lang.String r6) {
        /*
            r5 = this;
            com.tencent.thumbplayer.tcmedia.utils.a$a r0 = r5.f49683b
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.io.File r0 = r0.a((java.lang.String) r6)     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            boolean r2 = r0.exists()     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            if (r2 != 0) goto L_0x0011
            return r1
        L_0x0011:
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            java.lang.String r3 = "r"
            r2.<init>(r0, r3)     // Catch:{ Exception -> 0x0051, all -> 0x004f }
            long r3 = r2.length()     // Catch:{ Exception -> 0x004d }
            int r0 = (int) r3     // Catch:{ Exception -> 0x004d }
            byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x004d }
            int r3 = r2.read(r0)     // Catch:{ Exception -> 0x004d }
            if (r3 <= 0) goto L_0x0044
            boolean r3 = com.tencent.thumbplayer.tcmedia.utils.a.b.c(r0)     // Catch:{ Exception -> 0x004d }
            if (r3 != 0) goto L_0x0038
            byte[] r6 = com.tencent.thumbplayer.tcmedia.utils.a.b.d(r0)     // Catch:{ Exception -> 0x004d }
            r2.close()     // Catch:{ IOException -> 0x0033 }
            goto L_0x0037
        L_0x0033:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0037:
            return r6
        L_0x0038:
            r2.close()     // Catch:{ IOException -> 0x003c }
            goto L_0x0040
        L_0x003c:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0040:
            r5.c(r6)
            return r1
        L_0x0044:
            r2.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x004c
        L_0x0048:
            r6 = move-exception
            r6.printStackTrace()
        L_0x004c:
            return r1
        L_0x004d:
            r6 = move-exception
            goto L_0x0053
        L_0x004f:
            r6 = move-exception
            goto L_0x0063
        L_0x0051:
            r6 = move-exception
            r2 = r1
        L_0x0053:
            r6.printStackTrace()     // Catch:{ all -> 0x0061 }
            if (r2 == 0) goto L_0x0060
            r2.close()     // Catch:{ IOException -> 0x005c }
            goto L_0x0060
        L_0x005c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0060:
            return r1
        L_0x0061:
            r6 = move-exception
            r1 = r2
        L_0x0063:
            if (r1 == 0) goto L_0x006d
            r1.close()     // Catch:{ IOException -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r0 = move-exception
            r0.printStackTrace()
        L_0x006d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.a.a(java.lang.String):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x003d A[SYNTHETIC, Splitter:B:29:0x003d] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0047 A[SYNTHETIC, Splitter:B:34:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0053 A[SYNTHETIC, Splitter:B:41:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x005d A[SYNTHETIC, Splitter:B:46:0x005d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(java.lang.String r5) {
        /*
            r4 = this;
            byte[] r5 = r4.a(r5)
            r0 = 0
            if (r5 == 0) goto L_0x0066
            java.io.ByteArrayInputStream r1 = new java.io.ByteArrayInputStream     // Catch:{ Exception -> 0x0035, all -> 0x0030 }
            r1.<init>(r5)     // Catch:{ Exception -> 0x0035, all -> 0x0030 }
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x002d, all -> 0x0028 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x002d, all -> 0x0028 }
            java.lang.Object r0 = r5.readObject()     // Catch:{ Exception -> 0x0026 }
            r1.close()     // Catch:{ IOException -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            r1 = move-exception
            r1.printStackTrace()
        L_0x001d:
            r5.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0025
        L_0x0021:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0025:
            return r0
        L_0x0026:
            r2 = move-exception
            goto L_0x0038
        L_0x0028:
            r5 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
            goto L_0x0051
        L_0x002d:
            r2 = move-exception
            r5 = r0
            goto L_0x0038
        L_0x0030:
            r5 = move-exception
            r1 = r0
            r0 = r5
            r5 = r1
            goto L_0x0051
        L_0x0035:
            r2 = move-exception
            r5 = r0
            r1 = r5
        L_0x0038:
            r2.printStackTrace()     // Catch:{ all -> 0x0050 }
            if (r1 == 0) goto L_0x0045
            r1.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0045
        L_0x0041:
            r1 = move-exception
            r1.printStackTrace()
        L_0x0045:
            if (r5 == 0) goto L_0x004f
            r5.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004f
        L_0x004b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x004f:
            return r0
        L_0x0050:
            r0 = move-exception
        L_0x0051:
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r1 = move-exception
            r1.printStackTrace()
        L_0x005b:
            if (r5 == 0) goto L_0x0065
            r5.close()     // Catch:{ IOException -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0065:
            throw r0
        L_0x0066:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.utils.a.b(java.lang.String):java.lang.Object");
    }

    public boolean c(String str) {
        C0629a aVar = this.f49683b;
        if (aVar == null) {
            return false;
        }
        return aVar.c(str);
    }
}
