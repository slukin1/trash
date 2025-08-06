package k3;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final File f66417b;

    /* renamed from: c  reason: collision with root package name */
    public final File f66418c;

    /* renamed from: d  reason: collision with root package name */
    public final File f66419d;

    /* renamed from: e  reason: collision with root package name */
    public final File f66420e;

    /* renamed from: f  reason: collision with root package name */
    public final int f66421f;

    /* renamed from: g  reason: collision with root package name */
    public long f66422g;

    /* renamed from: h  reason: collision with root package name */
    public final int f66423h;

    /* renamed from: i  reason: collision with root package name */
    public long f66424i = 0;

    /* renamed from: j  reason: collision with root package name */
    public Writer f66425j;

    /* renamed from: k  reason: collision with root package name */
    public final LinkedHashMap<String, d> f66426k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l  reason: collision with root package name */
    public int f66427l;

    /* renamed from: m  reason: collision with root package name */
    public long f66428m = 0;

    /* renamed from: n  reason: collision with root package name */
    public final ThreadPoolExecutor f66429n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b((C0721a) null));

    /* renamed from: o  reason: collision with root package name */
    public final Callable<Void> f66430o = new C0721a();

    /* renamed from: k3.a$a  reason: collision with other inner class name */
    public class C0721a implements Callable<Void> {
        public C0721a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                k3.a r0 = k3.a.this
                monitor-enter(r0)
                k3.a r1 = k3.a.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f66425j     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                k3.a r1 = k3.a.this     // Catch:{ all -> 0x0028 }
                r1.E()     // Catch:{ all -> 0x0028 }
                k3.a r1 = k3.a.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.w()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                k3.a r1 = k3.a.this     // Catch:{ all -> 0x0028 }
                r1.B()     // Catch:{ all -> 0x0028 }
                k3.a r1 = k3.a.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.f66427l = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: k3.a.C0721a.call():java.lang.Void");
        }
    }

    public static final class b implements ThreadFactory {
        public b() {
        }

        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }

        public /* synthetic */ b(C0721a aVar) {
            this();
        }
    }

    public final class c {

        /* renamed from: a  reason: collision with root package name */
        public final d f66432a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f66433b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f66434c;

        public /* synthetic */ c(a aVar, d dVar, C0721a aVar2) {
            this(dVar);
        }

        public void a() throws IOException {
            a.this.o(this, false);
        }

        public void b() {
            if (!this.f66434c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() throws IOException {
            a.this.o(this, true);
            this.f66434c = true;
        }

        public File f(int i11) throws IOException {
            File k11;
            synchronized (a.this) {
                if (this.f66432a.f66441f == this) {
                    if (!this.f66432a.f66440e) {
                        this.f66433b[i11] = true;
                    }
                    k11 = this.f66432a.k(i11);
                    if (!a.this.f66417b.exists()) {
                        a.this.f66417b.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return k11;
        }

        public c(d dVar) {
            this.f66432a = dVar;
            this.f66433b = dVar.f66440e ? null : new boolean[a.this.f66423h];
        }
    }

    public final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f66436a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f66437b;

        /* renamed from: c  reason: collision with root package name */
        public File[] f66438c;

        /* renamed from: d  reason: collision with root package name */
        public File[] f66439d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f66440e;

        /* renamed from: f  reason: collision with root package name */
        public c f66441f;

        /* renamed from: g  reason: collision with root package name */
        public long f66442g;

        public /* synthetic */ d(a aVar, String str, C0721a aVar2) {
            this(str);
        }

        public File j(int i11) {
            return this.f66438c[i11];
        }

        public File k(int i11) {
            return this.f66439d[i11];
        }

        public String l() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long append : this.f66437b) {
                sb2.append(' ');
                sb2.append(append);
            }
            return sb2.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length == a.this.f66423h) {
                int i11 = 0;
                while (i11 < strArr.length) {
                    try {
                        this.f66437b[i11] = Long.parseLong(strArr[i11]);
                        i11++;
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public d(String str) {
            this.f66436a = str;
            this.f66437b = new long[a.this.f66423h];
            this.f66438c = new File[a.this.f66423h];
            this.f66439d = new File[a.this.f66423h];
            StringBuilder sb2 = new StringBuilder(str);
            sb2.append('.');
            int length = sb2.length();
            for (int i11 = 0; i11 < a.this.f66423h; i11++) {
                sb2.append(i11);
                this.f66438c[i11] = new File(a.this.f66417b, sb2.toString());
                sb2.append(".tmp");
                this.f66439d[i11] = new File(a.this.f66417b, sb2.toString());
                sb2.setLength(length);
            }
        }
    }

    public final class e {

        /* renamed from: a  reason: collision with root package name */
        public final String f66444a;

        /* renamed from: b  reason: collision with root package name */
        public final long f66445b;

        /* renamed from: c  reason: collision with root package name */
        public final long[] f66446c;

        /* renamed from: d  reason: collision with root package name */
        public final File[] f66447d;

        public /* synthetic */ e(a aVar, String str, long j11, File[] fileArr, long[] jArr, C0721a aVar2) {
            this(str, j11, fileArr, jArr);
        }

        public File a(int i11) {
            return this.f66447d[i11];
        }

        public e(String str, long j11, File[] fileArr, long[] jArr) {
            this.f66444a = str;
            this.f66445b = j11;
            this.f66447d = fileArr;
            this.f66446c = jArr;
        }
    }

    public a(File file, int i11, int i12, long j11) {
        File file2 = file;
        this.f66417b = file2;
        this.f66421f = i11;
        this.f66418c = new File(file2, "journal");
        this.f66419d = new File(file2, "journal.tmp");
        this.f66420e = new File(file2, "journal.bkp");
        this.f66423h = i12;
        this.f66422g = j11;
    }

    public static void D(File file, File file2, boolean z11) throws IOException {
        if (z11) {
            r(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void n(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void r(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void u(Writer writer) throws IOException {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static a x(File file, int i11, int i12, long j11) throws IOException {
        if (j11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i12 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    D(file2, file3, false);
                }
            }
            a aVar = new a(file, i11, i12, j11);
            if (aVar.f66418c.exists()) {
                try {
                    aVar.z();
                    aVar.y();
                    return aVar;
                } catch (IOException e11) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e11.getMessage() + ", removing");
                    aVar.p();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i11, i12, j11);
            aVar2.B();
            return aVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    public final void A(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i11 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i11);
            if (indexOf2 == -1) {
                str2 = str.substring(i11);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f66426k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i11, indexOf2);
            }
            d dVar = this.f66426k.get(str2);
            if (dVar == null) {
                dVar = new d(this, str2, (C0721a) null);
                this.f66426k.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = dVar.f66440e = true;
                c unused2 = dVar.f66441f = null;
                dVar.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                c unused3 = dVar.f66441f = new c(this, dVar, (C0721a) null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void B() throws IOException {
        Writer writer = this.f66425j;
        if (writer != null) {
            n(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f66419d), c.f66455a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f66421f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f66423h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d next : this.f66426k.values()) {
                if (next.f66441f != null) {
                    bufferedWriter.write("DIRTY " + next.f66436a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f66436a + next.l() + 10);
                }
            }
            n(bufferedWriter);
            if (this.f66418c.exists()) {
                D(this.f66418c, this.f66420e, true);
            }
            D(this.f66419d, this.f66418c, false);
            this.f66420e.delete();
            this.f66425j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f66418c, true), c.f66455a));
        } catch (Throwable th2) {
            n(bufferedWriter);
            throw th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean C(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.m()     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, k3.a$d> r0 = r7.f66426k     // Catch:{ all -> 0x008f }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x008f }
            k3.a$d r0 = (k3.a.d) r0     // Catch:{ all -> 0x008f }
            r1 = 0
            if (r0 == 0) goto L_0x008d
            k3.a$c r2 = r0.f66441f     // Catch:{ all -> 0x008f }
            if (r2 == 0) goto L_0x0017
            goto L_0x008d
        L_0x0017:
            int r2 = r7.f66423h     // Catch:{ all -> 0x008f }
            if (r1 >= r2) goto L_0x0059
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x008f }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x0043
            boolean r3 = r2.delete()     // Catch:{ all -> 0x008f }
            if (r3 == 0) goto L_0x002c
            goto L_0x0043
        L_0x002c:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x008f }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r0.<init>()     // Catch:{ all -> 0x008f }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x008f }
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x008f }
            r8.<init>(r0)     // Catch:{ all -> 0x008f }
            throw r8     // Catch:{ all -> 0x008f }
        L_0x0043:
            long r2 = r7.f66424i     // Catch:{ all -> 0x008f }
            long[] r4 = r0.f66437b     // Catch:{ all -> 0x008f }
            r5 = r4[r1]     // Catch:{ all -> 0x008f }
            long r2 = r2 - r5
            r7.f66424i = r2     // Catch:{ all -> 0x008f }
            long[] r2 = r0.f66437b     // Catch:{ all -> 0x008f }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x008f }
            int r1 = r1 + 1
            goto L_0x0017
        L_0x0059:
            int r0 = r7.f66427l     // Catch:{ all -> 0x008f }
            r1 = 1
            int r0 = r0 + r1
            r7.f66427l = r0     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f66425j     // Catch:{ all -> 0x008f }
            java.lang.String r2 = "REMOVE"
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f66425j     // Catch:{ all -> 0x008f }
            r2 = 32
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f66425j     // Catch:{ all -> 0x008f }
            r0.append(r8)     // Catch:{ all -> 0x008f }
            java.io.Writer r0 = r7.f66425j     // Catch:{ all -> 0x008f }
            r2 = 10
            r0.append(r2)     // Catch:{ all -> 0x008f }
            java.util.LinkedHashMap<java.lang.String, k3.a$d> r0 = r7.f66426k     // Catch:{ all -> 0x008f }
            r0.remove(r8)     // Catch:{ all -> 0x008f }
            boolean r8 = r7.w()     // Catch:{ all -> 0x008f }
            if (r8 == 0) goto L_0x008b
            java.util.concurrent.ThreadPoolExecutor r8 = r7.f66429n     // Catch:{ all -> 0x008f }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.f66430o     // Catch:{ all -> 0x008f }
            r8.submit(r0)     // Catch:{ all -> 0x008f }
        L_0x008b:
            monitor-exit(r7)
            return r1
        L_0x008d:
            monitor-exit(r7)
            return r1
        L_0x008f:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.a.C(java.lang.String):boolean");
    }

    public final void E() throws IOException {
        while (this.f66424i > this.f66422g) {
            C((String) this.f66426k.entrySet().iterator().next().getKey());
        }
    }

    public synchronized void close() throws IOException {
        if (this.f66425j != null) {
            Iterator it2 = new ArrayList(this.f66426k.values()).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (dVar.f66441f != null) {
                    dVar.f66441f.a();
                }
            }
            E();
            n(this.f66425j);
            this.f66425j = null;
        }
    }

    public final void m() {
        if (this.f66425j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0107, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void o(k3.a.c r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            k3.a$d r0 = r10.f66432a     // Catch:{ all -> 0x010e }
            k3.a$c r1 = r0.f66441f     // Catch:{ all -> 0x010e }
            if (r1 != r10) goto L_0x0108
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.f66440e     // Catch:{ all -> 0x010e }
            if (r2 != 0) goto L_0x004d
            r2 = r1
        L_0x0015:
            int r3 = r9.f66423h     // Catch:{ all -> 0x010e }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r10.f66433b     // Catch:{ all -> 0x010e }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x010e }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.k(r2)     // Catch:{ all -> 0x010e }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x010e }
            if (r3 != 0) goto L_0x0030
            r10.a()     // Catch:{ all -> 0x010e }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.a()     // Catch:{ all -> 0x010e }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            r11.<init>()     // Catch:{ all -> 0x010e }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x010e }
            r11.append(r2)     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x010e }
            r10.<init>(r11)     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x004d:
            int r10 = r9.f66423h     // Catch:{ all -> 0x010e }
            if (r1 >= r10) goto L_0x0081
            java.io.File r10 = r0.k(r1)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x007b
            boolean r2 = r10.exists()     // Catch:{ all -> 0x010e }
            if (r2 == 0) goto L_0x007e
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x010e }
            r10.renameTo(r2)     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f66437b     // Catch:{ all -> 0x010e }
            r3 = r10[r1]     // Catch:{ all -> 0x010e }
            long r5 = r2.length()     // Catch:{ all -> 0x010e }
            long[] r10 = r0.f66437b     // Catch:{ all -> 0x010e }
            r10[r1] = r5     // Catch:{ all -> 0x010e }
            long r7 = r9.f66424i     // Catch:{ all -> 0x010e }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f66424i = r7     // Catch:{ all -> 0x010e }
            goto L_0x007e
        L_0x007b:
            r(r10)     // Catch:{ all -> 0x010e }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.f66427l     // Catch:{ all -> 0x010e }
            r1 = 1
            int r10 = r10 + r1
            r9.f66427l = r10     // Catch:{ all -> 0x010e }
            r10 = 0
            k3.a.c unused = r0.f66441f = r10     // Catch:{ all -> 0x010e }
            boolean r10 = r0.f66440e     // Catch:{ all -> 0x010e }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00c9
            boolean unused = r0.f66440e = r1     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f66425j     // Catch:{ all -> 0x010e }
            java.lang.String r1 = "CLEAN"
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f66425j     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f66425j     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.f66436a     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f66425j     // Catch:{ all -> 0x010e }
            java.lang.String r1 = r0.l()     // Catch:{ all -> 0x010e }
            r10.append(r1)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f66425j     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
            if (r11 == 0) goto L_0x00ec
            long r10 = r9.f66428m     // Catch:{ all -> 0x010e }
            r1 = 1
            long r1 = r1 + r10
            r9.f66428m = r1     // Catch:{ all -> 0x010e }
            long unused = r0.f66442g = r10     // Catch:{ all -> 0x010e }
            goto L_0x00ec
        L_0x00c9:
            java.util.LinkedHashMap<java.lang.String, k3.a$d> r10 = r9.f66426k     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.f66436a     // Catch:{ all -> 0x010e }
            r10.remove(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f66425j     // Catch:{ all -> 0x010e }
            java.lang.String r11 = "REMOVE"
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f66425j     // Catch:{ all -> 0x010e }
            r10.append(r3)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f66425j     // Catch:{ all -> 0x010e }
            java.lang.String r11 = r0.f66436a     // Catch:{ all -> 0x010e }
            r10.append(r11)     // Catch:{ all -> 0x010e }
            java.io.Writer r10 = r9.f66425j     // Catch:{ all -> 0x010e }
            r10.append(r2)     // Catch:{ all -> 0x010e }
        L_0x00ec:
            java.io.Writer r10 = r9.f66425j     // Catch:{ all -> 0x010e }
            u(r10)     // Catch:{ all -> 0x010e }
            long r10 = r9.f66424i     // Catch:{ all -> 0x010e }
            long r0 = r9.f66422g     // Catch:{ all -> 0x010e }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x00ff
            boolean r10 = r9.w()     // Catch:{ all -> 0x010e }
            if (r10 == 0) goto L_0x0106
        L_0x00ff:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f66429n     // Catch:{ all -> 0x010e }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f66430o     // Catch:{ all -> 0x010e }
            r10.submit(r11)     // Catch:{ all -> 0x010e }
        L_0x0106:
            monitor-exit(r9)
            return
        L_0x0108:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x010e }
            r10.<init>()     // Catch:{ all -> 0x010e }
            throw r10     // Catch:{ all -> 0x010e }
        L_0x010e:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.a.o(k3.a$c, boolean):void");
    }

    public void p() throws IOException {
        close();
        c.b(this.f66417b);
    }

    public c s(String str) throws IOException {
        return t(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized k3.a.c t(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.m()     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, k3.a$d> r0 = r5.f66426k     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x005d }
            k3.a$d r0 = (k3.a.d) r0     // Catch:{ all -> 0x005d }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x001f
            if (r0 == 0) goto L_0x001d
            long r3 = r0.f66442g     // Catch:{ all -> 0x005d }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x001f
        L_0x001d:
            monitor-exit(r5)
            return r2
        L_0x001f:
            if (r0 != 0) goto L_0x002c
            k3.a$d r0 = new k3.a$d     // Catch:{ all -> 0x005d }
            r0.<init>(r5, r6, r2)     // Catch:{ all -> 0x005d }
            java.util.LinkedHashMap<java.lang.String, k3.a$d> r7 = r5.f66426k     // Catch:{ all -> 0x005d }
            r7.put(r6, r0)     // Catch:{ all -> 0x005d }
            goto L_0x0034
        L_0x002c:
            k3.a$c r7 = r0.f66441f     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x0034
            monitor-exit(r5)
            return r2
        L_0x0034:
            k3.a$c r7 = new k3.a$c     // Catch:{ all -> 0x005d }
            r7.<init>(r5, r0, r2)     // Catch:{ all -> 0x005d }
            k3.a.c unused = r0.f66441f = r7     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f66425j     // Catch:{ all -> 0x005d }
            java.lang.String r0 = "DIRTY"
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f66425j     // Catch:{ all -> 0x005d }
            r0 = 32
            r8.append(r0)     // Catch:{ all -> 0x005d }
            java.io.Writer r8 = r5.f66425j     // Catch:{ all -> 0x005d }
            r8.append(r6)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f66425j     // Catch:{ all -> 0x005d }
            r8 = 10
            r6.append(r8)     // Catch:{ all -> 0x005d }
            java.io.Writer r6 = r5.f66425j     // Catch:{ all -> 0x005d }
            u(r6)     // Catch:{ all -> 0x005d }
            monitor-exit(r5)
            return r7
        L_0x005d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.a.t(java.lang.String, long):k3.a$c");
    }

    public synchronized e v(String str) throws IOException {
        m();
        d dVar = this.f66426k.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f66440e) {
            return null;
        }
        for (File exists : dVar.f66438c) {
            if (!exists.exists()) {
                return null;
            }
        }
        this.f66427l++;
        this.f66425j.append("READ");
        this.f66425j.append(' ');
        this.f66425j.append(str);
        this.f66425j.append(10);
        if (w()) {
            this.f66429n.submit(this.f66430o);
        }
        return new e(this, str, dVar.f66442g, dVar.f66438c, dVar.f66437b, (C0721a) null);
    }

    public final boolean w() {
        int i11 = this.f66427l;
        return i11 >= 2000 && i11 >= this.f66426k.size();
    }

    public final void y() throws IOException {
        r(this.f66419d);
        Iterator<d> it2 = this.f66426k.values().iterator();
        while (it2.hasNext()) {
            d next = it2.next();
            int i11 = 0;
            if (next.f66441f == null) {
                while (i11 < this.f66423h) {
                    this.f66424i += next.f66437b[i11];
                    i11++;
                }
            } else {
                c unused = next.f66441f = null;
                while (i11 < this.f66423h) {
                    r(next.j(i11));
                    r(next.k(i11));
                    i11++;
                }
                it2.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f66427l = r0 - r9.f66426k.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.e() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        B();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.f66425j = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f66418c, true), k3.c.f66455a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            k3.b r1 = new k3.b
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f66418c
            r2.<init>(r3)
            java.nio.charset.Charset r3 = k3.c.f66455a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.f()     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = r1.f()     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = r1.f()     // Catch:{ all -> 0x00bb }
            java.lang.String r5 = r1.f()     // Catch:{ all -> 0x00bb }
            java.lang.String r6 = r1.f()     // Catch:{ all -> 0x00bb }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00bb }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00bb }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.f66421f     // Catch:{ all -> 0x00bb }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00bb }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00bb }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.f66423h     // Catch:{ all -> 0x00bb }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00bb }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00bb }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00bb }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.f()     // Catch:{ EOFException -> 0x005f }
            r9.A(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, k3.a$d> r2 = r9.f66426k     // Catch:{ all -> 0x00bb }
            int r2 = r2.size()     // Catch:{ all -> 0x00bb }
            int r0 = r0 - r2
            r9.f66427l = r0     // Catch:{ all -> 0x00bb }
            boolean r0 = r1.e()     // Catch:{ all -> 0x00bb }
            if (r0 == 0) goto L_0x0072
            r9.B()     // Catch:{ all -> 0x00bb }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00bb }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00bb }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00bb }
            java.io.File r4 = r9.f66418c     // Catch:{ all -> 0x00bb }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00bb }
            java.nio.charset.Charset r4 = k3.c.f66455a     // Catch:{ all -> 0x00bb }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00bb }
            r0.<init>(r2)     // Catch:{ all -> 0x00bb }
            r9.f66425j = r0     // Catch:{ all -> 0x00bb }
        L_0x0088:
            k3.c.a(r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00bb }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bb }
            r7.<init>()     // Catch:{ all -> 0x00bb }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00bb }
            r7.append(r2)     // Catch:{ all -> 0x00bb }
            r7.append(r0)     // Catch:{ all -> 0x00bb }
            r7.append(r3)     // Catch:{ all -> 0x00bb }
            r7.append(r0)     // Catch:{ all -> 0x00bb }
            r7.append(r5)     // Catch:{ all -> 0x00bb }
            r7.append(r0)     // Catch:{ all -> 0x00bb }
            r7.append(r6)     // Catch:{ all -> 0x00bb }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00bb }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00bb }
            r4.<init>(r0)     // Catch:{ all -> 0x00bb }
            throw r4     // Catch:{ all -> 0x00bb }
        L_0x00bb:
            r0 = move-exception
            k3.c.a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k3.a.z():void");
    }
}
