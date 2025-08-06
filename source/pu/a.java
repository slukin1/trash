package pu;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class a implements Closeable {

    /* renamed from: p  reason: collision with root package name */
    public static final Pattern f23272p = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: q  reason: collision with root package name */
    public static final OutputStream f23273q = new b();

    /* renamed from: b  reason: collision with root package name */
    public final File f23274b;

    /* renamed from: c  reason: collision with root package name */
    public final File f23275c;

    /* renamed from: d  reason: collision with root package name */
    public final File f23276d;

    /* renamed from: e  reason: collision with root package name */
    public final File f23277e;

    /* renamed from: f  reason: collision with root package name */
    public final int f23278f;

    /* renamed from: g  reason: collision with root package name */
    public long f23279g;

    /* renamed from: h  reason: collision with root package name */
    public final int f23280h;

    /* renamed from: i  reason: collision with root package name */
    public long f23281i = 0;

    /* renamed from: j  reason: collision with root package name */
    public Writer f23282j;

    /* renamed from: k  reason: collision with root package name */
    public final LinkedHashMap<String, d> f23283k = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: l  reason: collision with root package name */
    public int f23284l;

    /* renamed from: m  reason: collision with root package name */
    public long f23285m = 0;

    /* renamed from: n  reason: collision with root package name */
    public final ThreadPoolExecutor f23286n = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: o  reason: collision with root package name */
    public final Callable<Void> f23287o = new C0206a();

    /* renamed from: pu.a$a  reason: collision with other inner class name */
    public class C0206a implements Callable<Void> {
        public C0206a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                pu.a r0 = pu.a.this
                monitor-enter(r0)
                pu.a r1 = pu.a.this     // Catch:{ all -> 0x0028 }
                java.io.Writer r1 = r1.f23282j     // Catch:{ all -> 0x0028 }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x000e:
                pu.a r1 = pu.a.this     // Catch:{ all -> 0x0028 }
                r1.D()     // Catch:{ all -> 0x0028 }
                pu.a r1 = pu.a.this     // Catch:{ all -> 0x0028 }
                boolean r1 = r1.v()     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0026
                pu.a r1 = pu.a.this     // Catch:{ all -> 0x0028 }
                r1.A()     // Catch:{ all -> 0x0028 }
                pu.a r1 = pu.a.this     // Catch:{ all -> 0x0028 }
                r3 = 0
                int unused = r1.f23284l = r3     // Catch:{ all -> 0x0028 }
            L_0x0026:
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return r2
            L_0x0028:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: pu.a.C0206a.call():java.lang.Void");
        }
    }

    public static class b extends OutputStream {
        public void write(int i11) throws IOException {
        }
    }

    public final class c {

        /* renamed from: a  reason: collision with root package name */
        public final d f23289a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f23290b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f23291c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f23292d;

        /* renamed from: pu.a$c$a  reason: collision with other inner class name */
        public class C0207a extends FilterOutputStream {
            public /* synthetic */ C0207a(c cVar, OutputStream outputStream, C0206a aVar) {
                this(outputStream);
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = c.this.f23291c = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = c.this.f23291c = true;
                }
            }

            public void write(int i11) {
                try {
                    this.out.write(i11);
                } catch (IOException unused) {
                    boolean unused2 = c.this.f23291c = true;
                }
            }

            public C0207a(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(byte[] bArr, int i11, int i12) {
                try {
                    this.out.write(bArr, i11, i12);
                } catch (IOException unused) {
                    boolean unused2 = c.this.f23291c = true;
                }
            }
        }

        public /* synthetic */ c(a aVar, d dVar, C0206a aVar2) {
            this(dVar);
        }

        public void a() throws IOException {
            a.this.o(this, false);
        }

        public void e() throws IOException {
            if (this.f23291c) {
                a.this.o(this, false);
                a.this.B(this.f23289a.f23295a);
            } else {
                a.this.o(this, true);
            }
            this.f23292d = true;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.OutputStream f(int r4) throws java.io.IOException {
            /*
                r3 = this;
                if (r4 < 0) goto L_0x0053
                pu.a r0 = pu.a.this
                int r0 = r0.f23280h
                if (r4 >= r0) goto L_0x0053
                pu.a r0 = pu.a.this
                monitor-enter(r0)
                pu.a$d r1 = r3.f23289a     // Catch:{ all -> 0x0050 }
                pu.a$c r1 = r1.f23298d     // Catch:{ all -> 0x0050 }
                if (r1 != r3) goto L_0x004a
                pu.a$d r1 = r3.f23289a     // Catch:{ all -> 0x0050 }
                boolean r1 = r1.f23297c     // Catch:{ all -> 0x0050 }
                if (r1 != 0) goto L_0x0022
                boolean[] r1 = r3.f23290b     // Catch:{ all -> 0x0050 }
                r2 = 1
                r1[r4] = r2     // Catch:{ all -> 0x0050 }
            L_0x0022:
                pu.a$d r1 = r3.f23289a     // Catch:{ all -> 0x0050 }
                java.io.File r4 = r1.k(r4)     // Catch:{ all -> 0x0050 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x002e }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x002e }
                goto L_0x003c
            L_0x002e:
                pu.a r1 = pu.a.this     // Catch:{ all -> 0x0050 }
                java.io.File r1 = r1.f23274b     // Catch:{ all -> 0x0050 }
                r1.mkdirs()     // Catch:{ all -> 0x0050 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0044 }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0044 }
            L_0x003c:
                pu.a$c$a r4 = new pu.a$c$a     // Catch:{ all -> 0x0050 }
                r2 = 0
                r4.<init>(r3, r1, r2)     // Catch:{ all -> 0x0050 }
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                return r4
            L_0x0044:
                java.io.OutputStream r4 = pu.a.f23273q     // Catch:{ all -> 0x0050 }
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                return r4
            L_0x004a:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0050 }
                r4.<init>()     // Catch:{ all -> 0x0050 }
                throw r4     // Catch:{ all -> 0x0050 }
            L_0x0050:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0050 }
                throw r4
            L_0x0053:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Expected index "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r4 = " to be greater than 0 and less than the maximum value count of "
                r1.append(r4)
                pu.a r4 = pu.a.this
                int r4 = r4.f23280h
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: pu.a.c.f(int):java.io.OutputStream");
        }

        public c(d dVar) {
            this.f23289a = dVar;
            this.f23290b = dVar.f23297c ? null : new boolean[a.this.f23280h];
        }
    }

    public final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f23295a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f23296b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f23297c;

        /* renamed from: d  reason: collision with root package name */
        public c f23298d;

        /* renamed from: e  reason: collision with root package name */
        public long f23299e;

        public /* synthetic */ d(a aVar, String str, C0206a aVar2) {
            this(str);
        }

        public File j(int i11) {
            File f11 = a.this.f23274b;
            return new File(f11, this.f23295a + InstructionFileId.DOT + i11);
        }

        public File k(int i11) {
            File f11 = a.this.f23274b;
            return new File(f11, this.f23295a + InstructionFileId.DOT + i11 + ".tmp");
        }

        public String l() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long append : this.f23296b) {
                sb2.append(' ');
                sb2.append(append);
            }
            return sb2.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length == a.this.f23280h) {
                int i11 = 0;
                while (i11 < strArr.length) {
                    try {
                        this.f23296b[i11] = Long.parseLong(strArr[i11]);
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
            this.f23295a = str;
            this.f23296b = new long[a.this.f23280h];
        }
    }

    public final class e implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        public final String f23301b;

        /* renamed from: c  reason: collision with root package name */
        public final long f23302c;

        /* renamed from: d  reason: collision with root package name */
        public final InputStream[] f23303d;

        /* renamed from: e  reason: collision with root package name */
        public final long[] f23304e;

        public /* synthetic */ e(a aVar, String str, long j11, InputStream[] inputStreamArr, long[] jArr, C0206a aVar2) {
            this(str, j11, inputStreamArr, jArr);
        }

        public InputStream a(int i11) {
            return this.f23303d[i11];
        }

        public void close() {
            for (InputStream a11 : this.f23303d) {
                c.a(a11);
            }
        }

        public e(String str, long j11, InputStream[] inputStreamArr, long[] jArr) {
            this.f23301b = str;
            this.f23302c = j11;
            this.f23303d = inputStreamArr;
            this.f23304e = jArr;
        }
    }

    public a(File file, int i11, int i12, long j11) {
        File file2 = file;
        this.f23274b = file2;
        this.f23278f = i11;
        this.f23275c = new File(file2, "journal");
        this.f23276d = new File(file2, "journal.tmp");
        this.f23277e = new File(file2, "journal.bkp");
        this.f23280h = i12;
        this.f23279g = j11;
    }

    public static void C(File file, File file2, boolean z11) throws IOException {
        if (z11) {
            r(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void r(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static a w(File file, int i11, int i12, long j11) throws IOException {
        if (j11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i12 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    C(file2, file3, false);
                }
            }
            a aVar = new a(file, i11, i12, j11);
            if (aVar.f23275c.exists()) {
                try {
                    aVar.y();
                    aVar.x();
                    return aVar;
                } catch (IOException e11) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e11.getMessage() + ", removing");
                    aVar.p();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i11, i12, j11);
            aVar2.A();
            return aVar2;
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void A() throws IOException {
        Writer writer = this.f23282j;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f23276d), c.f23312a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f23278f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f23280h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d next : this.f23283k.values()) {
                if (next.f23298d != null) {
                    bufferedWriter.write("DIRTY " + next.f23295a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f23295a + next.l() + 10);
                }
            }
            bufferedWriter.close();
            if (this.f23275c.exists()) {
                C(this.f23275c, this.f23277e, true);
            }
            C(this.f23276d, this.f23275c, false);
            this.f23277e.delete();
            this.f23282j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f23275c, true), c.f23312a));
        } catch (Throwable th2) {
            bufferedWriter.close();
            throw th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0090, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0092, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean B(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.n()     // Catch:{ all -> 0x0093 }
            r7.E(r8)     // Catch:{ all -> 0x0093 }
            java.util.LinkedHashMap<java.lang.String, pu.a$d> r0 = r7.f23283k     // Catch:{ all -> 0x0093 }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ all -> 0x0093 }
            pu.a$d r0 = (pu.a.d) r0     // Catch:{ all -> 0x0093 }
            r1 = 0
            if (r0 == 0) goto L_0x0091
            pu.a$c r2 = r0.f23298d     // Catch:{ all -> 0x0093 }
            if (r2 == 0) goto L_0x001a
            goto L_0x0091
        L_0x001a:
            int r2 = r7.f23280h     // Catch:{ all -> 0x0093 }
            if (r1 >= r2) goto L_0x005c
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x0093 }
            boolean r3 = r2.exists()     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x0046
            boolean r3 = r2.delete()     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x002f
            goto L_0x0046
        L_0x002f:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r0.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x0093 }
            r0.append(r2)     // Catch:{ all -> 0x0093 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0093 }
            r8.<init>(r0)     // Catch:{ all -> 0x0093 }
            throw r8     // Catch:{ all -> 0x0093 }
        L_0x0046:
            long r2 = r7.f23281i     // Catch:{ all -> 0x0093 }
            long[] r4 = r0.f23296b     // Catch:{ all -> 0x0093 }
            r5 = r4[r1]     // Catch:{ all -> 0x0093 }
            long r2 = r2 - r5
            r7.f23281i = r2     // Catch:{ all -> 0x0093 }
            long[] r2 = r0.f23296b     // Catch:{ all -> 0x0093 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0093 }
            int r1 = r1 + 1
            goto L_0x001a
        L_0x005c:
            int r0 = r7.f23284l     // Catch:{ all -> 0x0093 }
            r1 = 1
            int r0 = r0 + r1
            r7.f23284l = r0     // Catch:{ all -> 0x0093 }
            java.io.Writer r0 = r7.f23282j     // Catch:{ all -> 0x0093 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0093 }
            r2.<init>()     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "REMOVE "
            r2.append(r3)     // Catch:{ all -> 0x0093 }
            r2.append(r8)     // Catch:{ all -> 0x0093 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0093 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0093 }
            r0.append(r2)     // Catch:{ all -> 0x0093 }
            java.util.LinkedHashMap<java.lang.String, pu.a$d> r0 = r7.f23283k     // Catch:{ all -> 0x0093 }
            r0.remove(r8)     // Catch:{ all -> 0x0093 }
            boolean r8 = r7.v()     // Catch:{ all -> 0x0093 }
            if (r8 == 0) goto L_0x008f
            java.util.concurrent.ThreadPoolExecutor r8 = r7.f23286n     // Catch:{ all -> 0x0093 }
            java.util.concurrent.Callable<java.lang.Void> r0 = r7.f23287o     // Catch:{ all -> 0x0093 }
            r8.submit(r0)     // Catch:{ all -> 0x0093 }
        L_0x008f:
            monitor-exit(r7)
            return r1
        L_0x0091:
            monitor-exit(r7)
            return r1
        L_0x0093:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: pu.a.B(java.lang.String):boolean");
    }

    public final void D() throws IOException {
        while (this.f23281i > this.f23279g) {
            B((String) this.f23283k.entrySet().iterator().next().getKey());
        }
    }

    public final void E(String str) {
        if (!f23272p.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + "\"");
        }
    }

    public synchronized void close() throws IOException {
        if (this.f23282j != null) {
            Iterator it2 = new ArrayList(this.f23283k.values()).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (dVar.f23298d != null) {
                    dVar.f23298d.a();
                }
            }
            D();
            this.f23282j.close();
            this.f23282j = null;
        }
    }

    public synchronized boolean isClosed() {
        return this.f23282j == null;
    }

    public final void n() {
        if (this.f23282j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0109, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void o(pu.a.c r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            pu.a$d r0 = r10.f23289a     // Catch:{ all -> 0x0110 }
            pu.a$c r1 = r0.f23298d     // Catch:{ all -> 0x0110 }
            if (r1 != r10) goto L_0x010a
            r1 = 0
            if (r11 == 0) goto L_0x004d
            boolean r2 = r0.f23297c     // Catch:{ all -> 0x0110 }
            if (r2 != 0) goto L_0x004d
            r2 = r1
        L_0x0015:
            int r3 = r9.f23280h     // Catch:{ all -> 0x0110 }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r10.f23290b     // Catch:{ all -> 0x0110 }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x0110 }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.k(r2)     // Catch:{ all -> 0x0110 }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x0110 }
            if (r3 != 0) goto L_0x0030
            r10.a()     // Catch:{ all -> 0x0110 }
            monitor-exit(r9)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r10.a()     // Catch:{ all -> 0x0110 }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r11.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x0110 }
            r11.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0110 }
            r10.<init>(r11)     // Catch:{ all -> 0x0110 }
            throw r10     // Catch:{ all -> 0x0110 }
        L_0x004d:
            int r10 = r9.f23280h     // Catch:{ all -> 0x0110 }
            if (r1 >= r10) goto L_0x0081
            java.io.File r10 = r0.k(r1)     // Catch:{ all -> 0x0110 }
            if (r11 == 0) goto L_0x007b
            boolean r2 = r10.exists()     // Catch:{ all -> 0x0110 }
            if (r2 == 0) goto L_0x007e
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x0110 }
            r10.renameTo(r2)     // Catch:{ all -> 0x0110 }
            long[] r10 = r0.f23296b     // Catch:{ all -> 0x0110 }
            r3 = r10[r1]     // Catch:{ all -> 0x0110 }
            long r5 = r2.length()     // Catch:{ all -> 0x0110 }
            long[] r10 = r0.f23296b     // Catch:{ all -> 0x0110 }
            r10[r1] = r5     // Catch:{ all -> 0x0110 }
            long r7 = r9.f23281i     // Catch:{ all -> 0x0110 }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f23281i = r7     // Catch:{ all -> 0x0110 }
            goto L_0x007e
        L_0x007b:
            r(r10)     // Catch:{ all -> 0x0110 }
        L_0x007e:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0081:
            int r10 = r9.f23284l     // Catch:{ all -> 0x0110 }
            r1 = 1
            int r10 = r10 + r1
            r9.f23284l = r10     // Catch:{ all -> 0x0110 }
            r10 = 0
            pu.a.c unused = r0.f23298d = r10     // Catch:{ all -> 0x0110 }
            boolean r10 = r0.f23297c     // Catch:{ all -> 0x0110 }
            r10 = r10 | r11
            r2 = 10
            if (r10 == 0) goto L_0x00c8
            boolean unused = r0.f23297c = r1     // Catch:{ all -> 0x0110 }
            java.io.Writer r10 = r9.f23282j     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r1.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = "CLEAN "
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r0.f23295a     // Catch:{ all -> 0x0110 }
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            java.lang.String r3 = r0.l()     // Catch:{ all -> 0x0110 }
            r1.append(r3)     // Catch:{ all -> 0x0110 }
            r1.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0110 }
            r10.write(r1)     // Catch:{ all -> 0x0110 }
            if (r11 == 0) goto L_0x00ee
            long r10 = r9.f23285m     // Catch:{ all -> 0x0110 }
            r1 = 1
            long r1 = r1 + r10
            r9.f23285m = r1     // Catch:{ all -> 0x0110 }
            long unused = r0.f23299e = r10     // Catch:{ all -> 0x0110 }
            goto L_0x00ee
        L_0x00c8:
            java.util.LinkedHashMap<java.lang.String, pu.a$d> r10 = r9.f23283k     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r0.f23295a     // Catch:{ all -> 0x0110 }
            r10.remove(r11)     // Catch:{ all -> 0x0110 }
            java.io.Writer r10 = r9.f23282j     // Catch:{ all -> 0x0110 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0110 }
            r11.<init>()     // Catch:{ all -> 0x0110 }
            java.lang.String r1 = "REMOVE "
            r11.append(r1)     // Catch:{ all -> 0x0110 }
            java.lang.String r0 = r0.f23295a     // Catch:{ all -> 0x0110 }
            r11.append(r0)     // Catch:{ all -> 0x0110 }
            r11.append(r2)     // Catch:{ all -> 0x0110 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x0110 }
            r10.write(r11)     // Catch:{ all -> 0x0110 }
        L_0x00ee:
            java.io.Writer r10 = r9.f23282j     // Catch:{ all -> 0x0110 }
            r10.flush()     // Catch:{ all -> 0x0110 }
            long r10 = r9.f23281i     // Catch:{ all -> 0x0110 }
            long r0 = r9.f23279g     // Catch:{ all -> 0x0110 }
            int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r10 > 0) goto L_0x0101
            boolean r10 = r9.v()     // Catch:{ all -> 0x0110 }
            if (r10 == 0) goto L_0x0108
        L_0x0101:
            java.util.concurrent.ThreadPoolExecutor r10 = r9.f23286n     // Catch:{ all -> 0x0110 }
            java.util.concurrent.Callable<java.lang.Void> r11 = r9.f23287o     // Catch:{ all -> 0x0110 }
            r10.submit(r11)     // Catch:{ all -> 0x0110 }
        L_0x0108:
            monitor-exit(r9)
            return
        L_0x010a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0110 }
            r10.<init>()     // Catch:{ all -> 0x0110 }
            throw r10     // Catch:{ all -> 0x0110 }
        L_0x0110:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: pu.a.o(pu.a$c, boolean):void");
    }

    public void p() throws IOException {
        close();
        c.b(this.f23274b);
    }

    public c s(String str) throws IOException {
        return t(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized pu.a.c t(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.n()     // Catch:{ all -> 0x0061 }
            r5.E(r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, pu.a$d> r0 = r5.f23283k     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0061 }
            pu.a$d r0 = (pu.a.d) r0     // Catch:{ all -> 0x0061 }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r3 = r0.f23299e     // Catch:{ all -> 0x0061 }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0022
        L_0x0020:
            monitor-exit(r5)
            return r2
        L_0x0022:
            if (r0 != 0) goto L_0x002f
            pu.a$d r0 = new pu.a$d     // Catch:{ all -> 0x0061 }
            r0.<init>(r5, r6, r2)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, pu.a$d> r7 = r5.f23283k     // Catch:{ all -> 0x0061 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0061 }
            goto L_0x0037
        L_0x002f:
            pu.a$c r7 = r0.f23298d     // Catch:{ all -> 0x0061 }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r2
        L_0x0037:
            pu.a$c r7 = new pu.a$c     // Catch:{ all -> 0x0061 }
            r7.<init>(r5, r0, r2)     // Catch:{ all -> 0x0061 }
            pu.a.c unused = r0.f23298d = r7     // Catch:{ all -> 0x0061 }
            java.io.Writer r8 = r5.f23282j     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r0.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = "DIRTY "
            r0.append(r1)     // Catch:{ all -> 0x0061 }
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0061 }
            r8.write(r6)     // Catch:{ all -> 0x0061 }
            java.io.Writer r6 = r5.f23282j     // Catch:{ all -> 0x0061 }
            r6.flush()     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)
            return r7
        L_0x0061:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: pu.a.t(java.lang.String, long):pu.a$c");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.f23284l++;
        r11.f23282j.append("READ " + r12 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        if (v() == false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
        r11.f23286n.submit(r11.f23287o);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0074, code lost:
        return new pu.a.e(r11, r12, pu.a.d.c(r0), r8, pu.a.d.a(r0), (pu.a.C0206a) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0086, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0075 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized pu.a.e u(java.lang.String r12) throws java.io.IOException {
        /*
            r11 = this;
            monitor-enter(r11)
            r11.n()     // Catch:{ all -> 0x0087 }
            r11.E(r12)     // Catch:{ all -> 0x0087 }
            java.util.LinkedHashMap<java.lang.String, pu.a$d> r0 = r11.f23283k     // Catch:{ all -> 0x0087 }
            java.lang.Object r0 = r0.get(r12)     // Catch:{ all -> 0x0087 }
            pu.a$d r0 = (pu.a.d) r0     // Catch:{ all -> 0x0087 }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r11)
            return r1
        L_0x0014:
            boolean r2 = r0.f23297c     // Catch:{ all -> 0x0087 }
            if (r2 != 0) goto L_0x001c
            monitor-exit(r11)
            return r1
        L_0x001c:
            int r2 = r11.f23280h     // Catch:{ all -> 0x0087 }
            java.io.InputStream[] r8 = new java.io.InputStream[r2]     // Catch:{ all -> 0x0087 }
            r2 = 0
            r3 = r2
        L_0x0022:
            int r4 = r11.f23280h     // Catch:{ FileNotFoundException -> 0x0075 }
            if (r3 >= r4) goto L_0x0034
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0075 }
            java.io.File r5 = r0.j(r3)     // Catch:{ FileNotFoundException -> 0x0075 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0075 }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x0075 }
            int r3 = r3 + 1
            goto L_0x0022
        L_0x0034:
            int r1 = r11.f23284l     // Catch:{ all -> 0x0087 }
            int r1 = r1 + 1
            r11.f23284l = r1     // Catch:{ all -> 0x0087 }
            java.io.Writer r1 = r11.f23282j     // Catch:{ all -> 0x0087 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0087 }
            r2.<init>()     // Catch:{ all -> 0x0087 }
            java.lang.String r3 = "READ "
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            r2.append(r12)     // Catch:{ all -> 0x0087 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0087 }
            r1.append(r2)     // Catch:{ all -> 0x0087 }
            boolean r1 = r11.v()     // Catch:{ all -> 0x0087 }
            if (r1 == 0) goto L_0x0062
            java.util.concurrent.ThreadPoolExecutor r1 = r11.f23286n     // Catch:{ all -> 0x0087 }
            java.util.concurrent.Callable<java.lang.Void> r2 = r11.f23287o     // Catch:{ all -> 0x0087 }
            r1.submit(r2)     // Catch:{ all -> 0x0087 }
        L_0x0062:
            pu.a$e r1 = new pu.a$e     // Catch:{ all -> 0x0087 }
            long r6 = r0.f23299e     // Catch:{ all -> 0x0087 }
            long[] r9 = r0.f23296b     // Catch:{ all -> 0x0087 }
            r10 = 0
            r3 = r1
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r8, r9, r10)     // Catch:{ all -> 0x0087 }
            monitor-exit(r11)
            return r1
        L_0x0075:
            int r12 = r11.f23280h     // Catch:{ all -> 0x0087 }
            if (r2 >= r12) goto L_0x0085
            r12 = r8[r2]     // Catch:{ all -> 0x0087 }
            if (r12 == 0) goto L_0x0085
            r12 = r8[r2]     // Catch:{ all -> 0x0087 }
            pu.c.a(r12)     // Catch:{ all -> 0x0087 }
            int r2 = r2 + 1
            goto L_0x0075
        L_0x0085:
            monitor-exit(r11)
            return r1
        L_0x0087:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: pu.a.u(java.lang.String):pu.a$e");
    }

    public final boolean v() {
        int i11 = this.f23284l;
        return i11 >= 2000 && i11 >= this.f23283k.size();
    }

    public final void x() throws IOException {
        r(this.f23276d);
        Iterator<d> it2 = this.f23283k.values().iterator();
        while (it2.hasNext()) {
            d next = it2.next();
            int i11 = 0;
            if (next.f23298d == null) {
                while (i11 < this.f23280h) {
                    this.f23281i += next.f23296b[i11];
                    i11++;
                }
            } else {
                c unused = next.f23298d = null;
                while (i11 < this.f23280h) {
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
        r9.f23284l = r0 - r9.f23283k.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r1.e() != false) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006e, code lost:
        A();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        r9.f23282j = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r9.f23275c, true), pu.c.f23312a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x008b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x008c=Splitter:B:23:0x008c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            pu.b r1 = new pu.b
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f23275c
            r2.<init>(r3)
            java.nio.charset.Charset r3 = pu.c.f23312a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.f()     // Catch:{ all -> 0x00ba }
            java.lang.String r3 = r1.f()     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = r1.f()     // Catch:{ all -> 0x00ba }
            java.lang.String r5 = r1.f()     // Catch:{ all -> 0x00ba }
            java.lang.String r6 = r1.f()     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00ba }
            if (r7 == 0) goto L_0x008c
            int r7 = r9.f23278f     // Catch:{ all -> 0x00ba }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00ba }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            int r4 = r9.f23280h     // Catch:{ all -> 0x00ba }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00ba }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00ba }
            if (r4 == 0) goto L_0x008c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.f()     // Catch:{ EOFException -> 0x005f }
            r9.z(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, pu.a$d> r2 = r9.f23283k     // Catch:{ all -> 0x00ba }
            int r2 = r2.size()     // Catch:{ all -> 0x00ba }
            int r0 = r0 - r2
            r9.f23284l = r0     // Catch:{ all -> 0x00ba }
            boolean r0 = r1.e()     // Catch:{ all -> 0x00ba }
            if (r0 == 0) goto L_0x0072
            r9.A()     // Catch:{ all -> 0x00ba }
            goto L_0x0088
        L_0x0072:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x00ba }
            java.io.OutputStreamWriter r2 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x00ba }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x00ba }
            java.io.File r4 = r9.f23275c     // Catch:{ all -> 0x00ba }
            r5 = 1
            r3.<init>(r4, r5)     // Catch:{ all -> 0x00ba }
            java.nio.charset.Charset r4 = pu.c.f23312a     // Catch:{ all -> 0x00ba }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x00ba }
            r0.<init>(r2)     // Catch:{ all -> 0x00ba }
            r9.f23282j = r0     // Catch:{ all -> 0x00ba }
        L_0x0088:
            pu.c.a(r1)
            return
        L_0x008c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r7.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00ba }
            r7.append(r2)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r3)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r5)     // Catch:{ all -> 0x00ba }
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            r7.append(r6)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00ba }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00ba }
            r4.<init>(r0)     // Catch:{ all -> 0x00ba }
            throw r4     // Catch:{ all -> 0x00ba }
        L_0x00ba:
            r0 = move-exception
            pu.c.a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: pu.a.y():void");
    }

    public final void z(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i11 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i11);
            if (indexOf2 == -1) {
                str2 = str.substring(i11);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f23283k.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i11, indexOf2);
            }
            d dVar = this.f23283k.get(str2);
            if (dVar == null) {
                dVar = new d(this, str2, (C0206a) null);
                this.f23283k.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = dVar.f23297c = true;
                c unused2 = dVar.f23298d = null;
                dVar.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                c unused3 = dVar.f23298d = new c(this, dVar, (C0206a) null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }
}
