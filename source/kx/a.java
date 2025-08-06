package kx;

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

    /* renamed from: r  reason: collision with root package name */
    public static final Pattern f29089r = Pattern.compile("[a-z0-9_-]{1,64}");

    /* renamed from: s  reason: collision with root package name */
    public static final OutputStream f29090s = new b();

    /* renamed from: b  reason: collision with root package name */
    public final File f29091b;

    /* renamed from: c  reason: collision with root package name */
    public final File f29092c;

    /* renamed from: d  reason: collision with root package name */
    public final File f29093d;

    /* renamed from: e  reason: collision with root package name */
    public final File f29094e;

    /* renamed from: f  reason: collision with root package name */
    public final int f29095f;

    /* renamed from: g  reason: collision with root package name */
    public long f29096g;

    /* renamed from: h  reason: collision with root package name */
    public int f29097h;

    /* renamed from: i  reason: collision with root package name */
    public final int f29098i;

    /* renamed from: j  reason: collision with root package name */
    public long f29099j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f29100k = 0;

    /* renamed from: l  reason: collision with root package name */
    public Writer f29101l;

    /* renamed from: m  reason: collision with root package name */
    public final LinkedHashMap<String, d> f29102m = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: n  reason: collision with root package name */
    public int f29103n;

    /* renamed from: o  reason: collision with root package name */
    public long f29104o = 0;

    /* renamed from: p  reason: collision with root package name */
    public final ThreadPoolExecutor f29105p = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: q  reason: collision with root package name */
    public final Callable<Void> f29106q = new C0255a();

    /* renamed from: kx.a$a  reason: collision with other inner class name */
    public class C0255a implements Callable<Void> {
        public C0255a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
            return null;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r4 = this;
                kx.a r0 = kx.a.this
                monitor-enter(r0)
                kx.a r1 = kx.a.this     // Catch:{ all -> 0x002d }
                java.io.Writer r1 = r1.f29101l     // Catch:{ all -> 0x002d }
                r2 = 0
                if (r1 != 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                return r2
            L_0x000e:
                kx.a r1 = kx.a.this     // Catch:{ all -> 0x002d }
                r1.F()     // Catch:{ all -> 0x002d }
                kx.a r1 = kx.a.this     // Catch:{ all -> 0x002d }
                r1.E()     // Catch:{ all -> 0x002d }
                kx.a r1 = kx.a.this     // Catch:{ all -> 0x002d }
                boolean r1 = r1.w()     // Catch:{ all -> 0x002d }
                if (r1 == 0) goto L_0x002b
                kx.a r1 = kx.a.this     // Catch:{ all -> 0x002d }
                r1.B()     // Catch:{ all -> 0x002d }
                kx.a r1 = kx.a.this     // Catch:{ all -> 0x002d }
                r3 = 0
                int unused = r1.f29103n = r3     // Catch:{ all -> 0x002d }
            L_0x002b:
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                return r2
            L_0x002d:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002d }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kx.a.C0255a.call():java.lang.Void");
        }
    }

    public static class b extends OutputStream {
        public void write(int i11) throws IOException {
        }
    }

    public final class c {

        /* renamed from: a  reason: collision with root package name */
        public final d f29108a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean[] f29109b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f29110c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f29111d;

        /* renamed from: kx.a$c$a  reason: collision with other inner class name */
        public class C0256a extends FilterOutputStream {
            public /* synthetic */ C0256a(c cVar, OutputStream outputStream, C0255a aVar) {
                this(outputStream);
            }

            public void close() {
                try {
                    this.out.close();
                } catch (IOException unused) {
                    boolean unused2 = c.this.f29110c = true;
                }
            }

            public void flush() {
                try {
                    this.out.flush();
                } catch (IOException unused) {
                    boolean unused2 = c.this.f29110c = true;
                }
            }

            public void write(int i11) {
                try {
                    this.out.write(i11);
                } catch (IOException unused) {
                    boolean unused2 = c.this.f29110c = true;
                }
            }

            public C0256a(OutputStream outputStream) {
                super(outputStream);
            }

            public void write(byte[] bArr, int i11, int i12) {
                try {
                    this.out.write(bArr, i11, i12);
                } catch (IOException unused) {
                    boolean unused2 = c.this.f29110c = true;
                }
            }
        }

        public /* synthetic */ c(a aVar, d dVar, C0255a aVar2) {
            this(dVar);
        }

        public void a() throws IOException {
            a.this.p(this, false);
        }

        public void e() throws IOException {
            if (this.f29110c) {
                a.this.p(this, false);
                a.this.C(this.f29108a.f29114a);
            } else {
                a.this.p(this, true);
            }
            this.f29111d = true;
        }

        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0024 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.io.OutputStream f(int r4) throws java.io.IOException {
            /*
                r3 = this;
                kx.a r0 = kx.a.this
                monitor-enter(r0)
                kx.a$d r1 = r3.f29108a     // Catch:{ all -> 0x0046 }
                kx.a$c r1 = r1.f29117d     // Catch:{ all -> 0x0046 }
                if (r1 != r3) goto L_0x0040
                kx.a$d r1 = r3.f29108a     // Catch:{ all -> 0x0046 }
                boolean r1 = r1.f29116c     // Catch:{ all -> 0x0046 }
                if (r1 != 0) goto L_0x0018
                boolean[] r1 = r3.f29109b     // Catch:{ all -> 0x0046 }
                r2 = 1
                r1[r4] = r2     // Catch:{ all -> 0x0046 }
            L_0x0018:
                kx.a$d r1 = r3.f29108a     // Catch:{ all -> 0x0046 }
                java.io.File r4 = r1.k(r4)     // Catch:{ all -> 0x0046 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0024 }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0024 }
                goto L_0x0032
            L_0x0024:
                kx.a r1 = kx.a.this     // Catch:{ all -> 0x0046 }
                java.io.File r1 = r1.f29091b     // Catch:{ all -> 0x0046 }
                r1.mkdirs()     // Catch:{ all -> 0x0046 }
                java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x003a }
                r1.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003a }
            L_0x0032:
                kx.a$c$a r4 = new kx.a$c$a     // Catch:{ all -> 0x0046 }
                r2 = 0
                r4.<init>(r3, r1, r2)     // Catch:{ all -> 0x0046 }
                monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                return r4
            L_0x003a:
                java.io.OutputStream r4 = kx.a.f29090s     // Catch:{ all -> 0x0046 }
                monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                return r4
            L_0x0040:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0046 }
                r4.<init>()     // Catch:{ all -> 0x0046 }
                throw r4     // Catch:{ all -> 0x0046 }
            L_0x0046:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0046 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kx.a.c.f(int):java.io.OutputStream");
        }

        public c(d dVar) {
            this.f29108a = dVar;
            this.f29109b = dVar.f29116c ? null : new boolean[a.this.f29098i];
        }
    }

    public final class d {

        /* renamed from: a  reason: collision with root package name */
        public final String f29114a;

        /* renamed from: b  reason: collision with root package name */
        public final long[] f29115b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f29116c;

        /* renamed from: d  reason: collision with root package name */
        public c f29117d;

        /* renamed from: e  reason: collision with root package name */
        public long f29118e;

        public /* synthetic */ d(a aVar, String str, C0255a aVar2) {
            this(str);
        }

        public File j(int i11) {
            File g11 = a.this.f29091b;
            return new File(g11, this.f29114a + "" + i11);
        }

        public File k(int i11) {
            File g11 = a.this.f29091b;
            return new File(g11, this.f29114a + "" + i11 + ".tmp");
        }

        public String l() throws IOException {
            StringBuilder sb2 = new StringBuilder();
            for (long append : this.f29115b) {
                sb2.append(' ');
                sb2.append(append);
            }
            return sb2.toString();
        }

        public final IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public final void n(String[] strArr) throws IOException {
            if (strArr.length == a.this.f29098i) {
                int i11 = 0;
                while (i11 < strArr.length) {
                    try {
                        this.f29115b[i11] = Long.parseLong(strArr[i11]);
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
            this.f29114a = str;
            this.f29115b = new long[a.this.f29098i];
        }
    }

    public final class e implements Closeable {

        /* renamed from: b  reason: collision with root package name */
        public final String f29120b;

        /* renamed from: c  reason: collision with root package name */
        public final long f29121c;

        /* renamed from: d  reason: collision with root package name */
        public File[] f29122d;

        /* renamed from: e  reason: collision with root package name */
        public final InputStream[] f29123e;

        /* renamed from: f  reason: collision with root package name */
        public final long[] f29124f;

        public /* synthetic */ e(a aVar, String str, long j11, File[] fileArr, InputStream[] inputStreamArr, long[] jArr, C0255a aVar2) {
            this(str, j11, fileArr, inputStreamArr, jArr);
        }

        public File a(int i11) {
            return this.f29122d[i11];
        }

        public void close() {
            for (InputStream a11 : this.f29123e) {
                d.a(a11);
            }
        }

        public e(String str, long j11, File[] fileArr, InputStream[] inputStreamArr, long[] jArr) {
            this.f29120b = str;
            this.f29121c = j11;
            this.f29122d = fileArr;
            this.f29123e = inputStreamArr;
            this.f29124f = jArr;
        }
    }

    public a(File file, int i11, int i12, long j11, int i13) {
        File file2 = file;
        this.f29091b = file2;
        this.f29095f = i11;
        this.f29092c = new File(file2, "journal");
        this.f29093d = new File(file2, "journal.tmp");
        this.f29094e = new File(file2, "journal.bkp");
        this.f29098i = i12;
        this.f29096g = j11;
        this.f29097h = i13;
    }

    public static void D(File file, File file2, boolean z11) throws IOException {
        if (z11) {
            s(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static void s(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static a x(File file, int i11, int i12, long j11, int i13) throws IOException {
        if (j11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i13 <= 0) {
            throw new IllegalArgumentException("maxFileCount <= 0");
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
            a aVar = new a(file, i11, i12, j11, i13);
            if (aVar.f29092c.exists()) {
                try {
                    aVar.z();
                    aVar.y();
                    aVar.f29101l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aVar.f29092c, true), d.f29139a));
                    return aVar;
                } catch (IOException e11) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e11.getMessage() + ", removing");
                    aVar.r();
                }
            }
            file.mkdirs();
            a aVar2 = new a(file, i11, i12, j11, i13);
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
                    this.f29102m.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i11, indexOf2);
            }
            d dVar = this.f29102m.get(str2);
            if (dVar == null) {
                dVar = new d(this, str2, (C0255a) null);
                this.f29102m.put(str2, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                boolean unused = dVar.f29116c = true;
                c unused2 = dVar.f29117d = null;
                dVar.n(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                c unused3 = dVar.f29117d = new c(this, dVar, (C0255a) null);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void B() throws IOException {
        Writer writer = this.f29101l;
        if (writer != null) {
            writer.close();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f29093d), d.f29139a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f29095f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f29098i));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d next : this.f29102m.values()) {
                if (next.f29117d != null) {
                    bufferedWriter.write("DIRTY " + next.f29114a + 10);
                } else {
                    bufferedWriter.write("CLEAN " + next.f29114a + next.l() + 10);
                }
            }
            bufferedWriter.close();
            if (this.f29092c.exists()) {
                D(this.f29092c, this.f29094e, true);
            }
            D(this.f29093d, this.f29092c, false);
            this.f29094e.delete();
            this.f29101l = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f29092c, true), d.f29139a));
        } catch (Throwable th2) {
            bufferedWriter.close();
            throw th2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0095, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0097, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean C(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.o()     // Catch:{ all -> 0x0098 }
            r8.G(r9)     // Catch:{ all -> 0x0098 }
            java.util.LinkedHashMap<java.lang.String, kx.a$d> r0 = r8.f29102m     // Catch:{ all -> 0x0098 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x0098 }
            kx.a$d r0 = (kx.a.d) r0     // Catch:{ all -> 0x0098 }
            r1 = 0
            if (r0 == 0) goto L_0x0096
            kx.a$c r2 = r0.f29117d     // Catch:{ all -> 0x0098 }
            if (r2 == 0) goto L_0x001a
            goto L_0x0096
        L_0x001a:
            int r2 = r8.f29098i     // Catch:{ all -> 0x0098 }
            r3 = 1
            if (r1 >= r2) goto L_0x0062
            java.io.File r2 = r0.j(r1)     // Catch:{ all -> 0x0098 }
            boolean r4 = r2.exists()     // Catch:{ all -> 0x0098 }
            if (r4 == 0) goto L_0x0047
            boolean r4 = r2.delete()     // Catch:{ all -> 0x0098 }
            if (r4 == 0) goto L_0x0030
            goto L_0x0047
        L_0x0030:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r0.<init>()     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = "failed to delete "
            r0.append(r1)     // Catch:{ all -> 0x0098 }
            r0.append(r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0098 }
            r9.<init>(r0)     // Catch:{ all -> 0x0098 }
            throw r9     // Catch:{ all -> 0x0098 }
        L_0x0047:
            long r4 = r8.f29099j     // Catch:{ all -> 0x0098 }
            long[] r2 = r0.f29115b     // Catch:{ all -> 0x0098 }
            r6 = r2[r1]     // Catch:{ all -> 0x0098 }
            long r4 = r4 - r6
            r8.f29099j = r4     // Catch:{ all -> 0x0098 }
            int r2 = r8.f29100k     // Catch:{ all -> 0x0098 }
            int r2 = r2 - r3
            r8.f29100k = r2     // Catch:{ all -> 0x0098 }
            long[] r2 = r0.f29115b     // Catch:{ all -> 0x0098 }
            r3 = 0
            r2[r1] = r3     // Catch:{ all -> 0x0098 }
            int r1 = r1 + 1
            goto L_0x001a
        L_0x0062:
            int r0 = r8.f29103n     // Catch:{ all -> 0x0098 }
            int r0 = r0 + r3
            r8.f29103n = r0     // Catch:{ all -> 0x0098 }
            java.io.Writer r0 = r8.f29101l     // Catch:{ all -> 0x0098 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0098 }
            r1.<init>()     // Catch:{ all -> 0x0098 }
            java.lang.String r2 = "REMOVE "
            r1.append(r2)     // Catch:{ all -> 0x0098 }
            r1.append(r9)     // Catch:{ all -> 0x0098 }
            r2 = 10
            r1.append(r2)     // Catch:{ all -> 0x0098 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0098 }
            r0.append(r1)     // Catch:{ all -> 0x0098 }
            java.util.LinkedHashMap<java.lang.String, kx.a$d> r0 = r8.f29102m     // Catch:{ all -> 0x0098 }
            r0.remove(r9)     // Catch:{ all -> 0x0098 }
            boolean r9 = r8.w()     // Catch:{ all -> 0x0098 }
            if (r9 == 0) goto L_0x0094
            java.util.concurrent.ThreadPoolExecutor r9 = r8.f29105p     // Catch:{ all -> 0x0098 }
            java.util.concurrent.Callable<java.lang.Void> r0 = r8.f29106q     // Catch:{ all -> 0x0098 }
            r9.submit(r0)     // Catch:{ all -> 0x0098 }
        L_0x0094:
            monitor-exit(r8)
            return r3
        L_0x0096:
            monitor-exit(r8)
            return r1
        L_0x0098:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kx.a.C(java.lang.String):boolean");
    }

    public final void E() throws IOException {
        while (this.f29100k > this.f29097h) {
            C((String) this.f29102m.entrySet().iterator().next().getKey());
        }
    }

    public final void F() throws IOException {
        while (this.f29099j > this.f29096g) {
            C((String) this.f29102m.entrySet().iterator().next().getKey());
        }
    }

    public final void G(String str) {
        if (!f29089r.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,64}: \"" + str + "\"");
        }
    }

    public synchronized void close() throws IOException {
        if (this.f29101l != null) {
            Iterator it2 = new ArrayList(this.f29102m.values()).iterator();
            while (it2.hasNext()) {
                d dVar = (d) it2.next();
                if (dVar.f29117d != null) {
                    dVar.f29117d.a();
                }
            }
            F();
            E();
            this.f29101l.close();
            this.f29101l = null;
        }
    }

    public final void o() {
        if (this.f29101l == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0114, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void p(kx.a.c r11, boolean r12) throws java.io.IOException {
        /*
            r10 = this;
            monitor-enter(r10)
            kx.a$d r0 = r11.f29108a     // Catch:{ all -> 0x011b }
            kx.a$c r1 = r0.f29117d     // Catch:{ all -> 0x011b }
            if (r1 != r11) goto L_0x0115
            r1 = 0
            if (r12 == 0) goto L_0x004d
            boolean r2 = r0.f29116c     // Catch:{ all -> 0x011b }
            if (r2 != 0) goto L_0x004d
            r2 = r1
        L_0x0015:
            int r3 = r10.f29098i     // Catch:{ all -> 0x011b }
            if (r2 >= r3) goto L_0x004d
            boolean[] r3 = r11.f29109b     // Catch:{ all -> 0x011b }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x011b }
            if (r3 == 0) goto L_0x0033
            java.io.File r3 = r0.k(r2)     // Catch:{ all -> 0x011b }
            boolean r3 = r3.exists()     // Catch:{ all -> 0x011b }
            if (r3 != 0) goto L_0x0030
            r11.a()     // Catch:{ all -> 0x011b }
            monitor-exit(r10)
            return
        L_0x0030:
            int r2 = r2 + 1
            goto L_0x0015
        L_0x0033:
            r11.a()     // Catch:{ all -> 0x011b }
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x011b }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
            r12.<init>()     // Catch:{ all -> 0x011b }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r12.append(r0)     // Catch:{ all -> 0x011b }
            r12.append(r2)     // Catch:{ all -> 0x011b }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x011b }
            r11.<init>(r12)     // Catch:{ all -> 0x011b }
            throw r11     // Catch:{ all -> 0x011b }
        L_0x004d:
            int r11 = r10.f29098i     // Catch:{ all -> 0x011b }
            r2 = 1
            if (r1 >= r11) goto L_0x0087
            java.io.File r11 = r0.k(r1)     // Catch:{ all -> 0x011b }
            if (r12 == 0) goto L_0x0081
            boolean r3 = r11.exists()     // Catch:{ all -> 0x011b }
            if (r3 == 0) goto L_0x0084
            java.io.File r3 = r0.j(r1)     // Catch:{ all -> 0x011b }
            r11.renameTo(r3)     // Catch:{ all -> 0x011b }
            long[] r11 = r0.f29115b     // Catch:{ all -> 0x011b }
            r4 = r11[r1]     // Catch:{ all -> 0x011b }
            long r6 = r3.length()     // Catch:{ all -> 0x011b }
            long[] r11 = r0.f29115b     // Catch:{ all -> 0x011b }
            r11[r1] = r6     // Catch:{ all -> 0x011b }
            long r8 = r10.f29099j     // Catch:{ all -> 0x011b }
            long r8 = r8 - r4
            long r8 = r8 + r6
            r10.f29099j = r8     // Catch:{ all -> 0x011b }
            int r11 = r10.f29100k     // Catch:{ all -> 0x011b }
            int r11 = r11 + r2
            r10.f29100k = r11     // Catch:{ all -> 0x011b }
            goto L_0x0084
        L_0x0081:
            s(r11)     // Catch:{ all -> 0x011b }
        L_0x0084:
            int r1 = r1 + 1
            goto L_0x004d
        L_0x0087:
            int r11 = r10.f29103n     // Catch:{ all -> 0x011b }
            int r11 = r11 + r2
            r10.f29103n = r11     // Catch:{ all -> 0x011b }
            r11 = 0
            kx.a.c unused = r0.f29117d = r11     // Catch:{ all -> 0x011b }
            boolean r11 = r0.f29116c     // Catch:{ all -> 0x011b }
            r11 = r11 | r12
            r1 = 10
            if (r11 == 0) goto L_0x00cd
            boolean unused = r0.f29116c = r2     // Catch:{ all -> 0x011b }
            java.io.Writer r11 = r10.f29101l     // Catch:{ all -> 0x011b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
            r2.<init>()     // Catch:{ all -> 0x011b }
            java.lang.String r3 = "CLEAN "
            r2.append(r3)     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r0.f29114a     // Catch:{ all -> 0x011b }
            r2.append(r3)     // Catch:{ all -> 0x011b }
            java.lang.String r3 = r0.l()     // Catch:{ all -> 0x011b }
            r2.append(r3)     // Catch:{ all -> 0x011b }
            r2.append(r1)     // Catch:{ all -> 0x011b }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x011b }
            r11.write(r1)     // Catch:{ all -> 0x011b }
            if (r12 == 0) goto L_0x00f3
            long r11 = r10.f29104o     // Catch:{ all -> 0x011b }
            r1 = 1
            long r1 = r1 + r11
            r10.f29104o = r1     // Catch:{ all -> 0x011b }
            long unused = r0.f29118e = r11     // Catch:{ all -> 0x011b }
            goto L_0x00f3
        L_0x00cd:
            java.util.LinkedHashMap<java.lang.String, kx.a$d> r11 = r10.f29102m     // Catch:{ all -> 0x011b }
            java.lang.String r12 = r0.f29114a     // Catch:{ all -> 0x011b }
            r11.remove(r12)     // Catch:{ all -> 0x011b }
            java.io.Writer r11 = r10.f29101l     // Catch:{ all -> 0x011b }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x011b }
            r12.<init>()     // Catch:{ all -> 0x011b }
            java.lang.String r2 = "REMOVE "
            r12.append(r2)     // Catch:{ all -> 0x011b }
            java.lang.String r0 = r0.f29114a     // Catch:{ all -> 0x011b }
            r12.append(r0)     // Catch:{ all -> 0x011b }
            r12.append(r1)     // Catch:{ all -> 0x011b }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x011b }
            r11.write(r12)     // Catch:{ all -> 0x011b }
        L_0x00f3:
            java.io.Writer r11 = r10.f29101l     // Catch:{ all -> 0x011b }
            r11.flush()     // Catch:{ all -> 0x011b }
            long r11 = r10.f29099j     // Catch:{ all -> 0x011b }
            long r0 = r10.f29096g     // Catch:{ all -> 0x011b }
            int r11 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r11 > 0) goto L_0x010c
            int r11 = r10.f29100k     // Catch:{ all -> 0x011b }
            int r12 = r10.f29097h     // Catch:{ all -> 0x011b }
            if (r11 > r12) goto L_0x010c
            boolean r11 = r10.w()     // Catch:{ all -> 0x011b }
            if (r11 == 0) goto L_0x0113
        L_0x010c:
            java.util.concurrent.ThreadPoolExecutor r11 = r10.f29105p     // Catch:{ all -> 0x011b }
            java.util.concurrent.Callable<java.lang.Void> r12 = r10.f29106q     // Catch:{ all -> 0x011b }
            r11.submit(r12)     // Catch:{ all -> 0x011b }
        L_0x0113:
            monitor-exit(r10)
            return
        L_0x0115:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x011b }
            r11.<init>()     // Catch:{ all -> 0x011b }
            throw r11     // Catch:{ all -> 0x011b }
        L_0x011b:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kx.a.p(kx.a$c, boolean):void");
    }

    public void r() throws IOException {
        close();
        d.b(this.f29091b);
    }

    public c t(String str) throws IOException {
        return u(str, -1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized kx.a.c u(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.o()     // Catch:{ all -> 0x0061 }
            r5.G(r6)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, kx.a$d> r0 = r5.f29102m     // Catch:{ all -> 0x0061 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0061 }
            kx.a$d r0 = (kx.a.d) r0     // Catch:{ all -> 0x0061 }
            r1 = -1
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            r2 = 0
            if (r1 == 0) goto L_0x0022
            if (r0 == 0) goto L_0x0020
            long r3 = r0.f29118e     // Catch:{ all -> 0x0061 }
            int r7 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0022
        L_0x0020:
            monitor-exit(r5)
            return r2
        L_0x0022:
            if (r0 != 0) goto L_0x002f
            kx.a$d r0 = new kx.a$d     // Catch:{ all -> 0x0061 }
            r0.<init>(r5, r6, r2)     // Catch:{ all -> 0x0061 }
            java.util.LinkedHashMap<java.lang.String, kx.a$d> r7 = r5.f29102m     // Catch:{ all -> 0x0061 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0061 }
            goto L_0x0037
        L_0x002f:
            kx.a$c r7 = r0.f29117d     // Catch:{ all -> 0x0061 }
            if (r7 == 0) goto L_0x0037
            monitor-exit(r5)
            return r2
        L_0x0037:
            kx.a$c r7 = new kx.a$c     // Catch:{ all -> 0x0061 }
            r7.<init>(r5, r0, r2)     // Catch:{ all -> 0x0061 }
            kx.a.c unused = r0.f29117d = r7     // Catch:{ all -> 0x0061 }
            java.io.Writer r8 = r5.f29101l     // Catch:{ all -> 0x0061 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0061 }
            r0.<init>()     // Catch:{ all -> 0x0061 }
            java.lang.String r1 = "DIRTY "
            r0.append(r1)     // Catch:{ all -> 0x0061 }
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            r6 = 10
            r0.append(r6)     // Catch:{ all -> 0x0061 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0061 }
            r8.write(r6)     // Catch:{ all -> 0x0061 }
            java.io.Writer r6 = r5.f29101l     // Catch:{ all -> 0x0061 }
            r6.flush()     // Catch:{ all -> 0x0061 }
            monitor-exit(r5)
            return r7
        L_0x0061:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kx.a.u(java.lang.String, long):kx.a$c");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:32|33|28|27) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r12.f29103n++;
        r12.f29101l.append("READ " + r13 + 10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
        if (w() == false) goto L_0x0066;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
        r12.f29105p.submit(r12.f29106q);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0078, code lost:
        return new kx.a.e(r12, r13, kx.a.d.c(r0), r8, r9, kx.a.d.a(r0), (kx.a.C0255a) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008a, code lost:
        return null;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0079 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized kx.a.e v(java.lang.String r13) throws java.io.IOException {
        /*
            r12 = this;
            monitor-enter(r12)
            r12.o()     // Catch:{ all -> 0x008b }
            r12.G(r13)     // Catch:{ all -> 0x008b }
            java.util.LinkedHashMap<java.lang.String, kx.a$d> r0 = r12.f29102m     // Catch:{ all -> 0x008b }
            java.lang.Object r0 = r0.get(r13)     // Catch:{ all -> 0x008b }
            kx.a$d r0 = (kx.a.d) r0     // Catch:{ all -> 0x008b }
            r1 = 0
            if (r0 != 0) goto L_0x0014
            monitor-exit(r12)
            return r1
        L_0x0014:
            boolean r2 = r0.f29116c     // Catch:{ all -> 0x008b }
            if (r2 != 0) goto L_0x001c
            monitor-exit(r12)
            return r1
        L_0x001c:
            int r2 = r12.f29098i     // Catch:{ all -> 0x008b }
            java.io.File[] r8 = new java.io.File[r2]     // Catch:{ all -> 0x008b }
            java.io.InputStream[] r9 = new java.io.InputStream[r2]     // Catch:{ all -> 0x008b }
            r2 = 0
            r3 = r2
        L_0x0024:
            int r4 = r12.f29098i     // Catch:{ FileNotFoundException -> 0x0079 }
            if (r3 >= r4) goto L_0x0038
            java.io.File r4 = r0.j(r3)     // Catch:{ FileNotFoundException -> 0x0079 }
            r8[r3] = r4     // Catch:{ FileNotFoundException -> 0x0079 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0079 }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0079 }
            r9[r3] = r5     // Catch:{ FileNotFoundException -> 0x0079 }
            int r3 = r3 + 1
            goto L_0x0024
        L_0x0038:
            int r1 = r12.f29103n     // Catch:{ all -> 0x008b }
            int r1 = r1 + 1
            r12.f29103n = r1     // Catch:{ all -> 0x008b }
            java.io.Writer r1 = r12.f29101l     // Catch:{ all -> 0x008b }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r2.<init>()     // Catch:{ all -> 0x008b }
            java.lang.String r3 = "READ "
            r2.append(r3)     // Catch:{ all -> 0x008b }
            r2.append(r13)     // Catch:{ all -> 0x008b }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x008b }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x008b }
            r1.append(r2)     // Catch:{ all -> 0x008b }
            boolean r1 = r12.w()     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x0066
            java.util.concurrent.ThreadPoolExecutor r1 = r12.f29105p     // Catch:{ all -> 0x008b }
            java.util.concurrent.Callable<java.lang.Void> r2 = r12.f29106q     // Catch:{ all -> 0x008b }
            r1.submit(r2)     // Catch:{ all -> 0x008b }
        L_0x0066:
            kx.a$e r1 = new kx.a$e     // Catch:{ all -> 0x008b }
            long r6 = r0.f29118e     // Catch:{ all -> 0x008b }
            long[] r10 = r0.f29115b     // Catch:{ all -> 0x008b }
            r11 = 0
            r3 = r1
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r8, r9, r10, r11)     // Catch:{ all -> 0x008b }
            monitor-exit(r12)
            return r1
        L_0x0079:
            int r13 = r12.f29098i     // Catch:{ all -> 0x008b }
            if (r2 >= r13) goto L_0x0089
            r13 = r9[r2]     // Catch:{ all -> 0x008b }
            if (r13 == 0) goto L_0x0089
            r13 = r9[r2]     // Catch:{ all -> 0x008b }
            kx.d.a(r13)     // Catch:{ all -> 0x008b }
            int r2 = r2 + 1
            goto L_0x0079
        L_0x0089:
            monitor-exit(r12)
            return r1
        L_0x008b:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: kx.a.v(java.lang.String):kx.a$e");
    }

    public final boolean w() {
        int i11 = this.f29103n;
        return i11 >= 2000 && i11 >= this.f29102m.size();
    }

    public final void y() throws IOException {
        s(this.f29093d);
        Iterator<d> it2 = this.f29102m.values().iterator();
        while (it2.hasNext()) {
            d next = it2.next();
            int i11 = 0;
            if (next.f29117d == null) {
                while (i11 < this.f29098i) {
                    this.f29099j += next.f29115b[i11];
                    this.f29100k++;
                    i11++;
                }
            } else {
                c unused = next.f29117d = null;
                while (i11 < this.f29098i) {
                    s(next.j(i11));
                    s(next.k(i11));
                    i11++;
                }
                it2.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:16|17|18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f29103n = r0 - r9.f29102m.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006b, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005f */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x006c=Splitter:B:20:0x006c, B:16:0x005f=Splitter:B:16:0x005f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void z() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            kx.c r1 = new kx.c
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.File r3 = r9.f29092c
            r2.<init>(r3)
            java.nio.charset.Charset r3 = kx.d.f29139a
            r1.<init>(r2, r3)
            java.lang.String r2 = r1.e()     // Catch:{ all -> 0x009a }
            java.lang.String r3 = r1.e()     // Catch:{ all -> 0x009a }
            java.lang.String r4 = r1.e()     // Catch:{ all -> 0x009a }
            java.lang.String r5 = r1.e()     // Catch:{ all -> 0x009a }
            java.lang.String r6 = r1.e()     // Catch:{ all -> 0x009a }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x006c
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x009a }
            if (r7 == 0) goto L_0x006c
            int r7 = r9.f29095f     // Catch:{ all -> 0x009a }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x009a }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x009a }
            if (r4 == 0) goto L_0x006c
            int r4 = r9.f29098i     // Catch:{ all -> 0x009a }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x009a }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x009a }
            if (r4 == 0) goto L_0x006c
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x009a }
            if (r4 == 0) goto L_0x006c
            r0 = 0
        L_0x0055:
            java.lang.String r2 = r1.e()     // Catch:{ EOFException -> 0x005f }
            r9.A(r2)     // Catch:{ EOFException -> 0x005f }
            int r0 = r0 + 1
            goto L_0x0055
        L_0x005f:
            java.util.LinkedHashMap<java.lang.String, kx.a$d> r2 = r9.f29102m     // Catch:{ all -> 0x009a }
            int r2 = r2.size()     // Catch:{ all -> 0x009a }
            int r0 = r0 - r2
            r9.f29103n = r0     // Catch:{ all -> 0x009a }
            kx.d.a(r1)
            return
        L_0x006c:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r7.<init>()     // Catch:{ all -> 0x009a }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x009a }
            r7.append(r2)     // Catch:{ all -> 0x009a }
            r7.append(r0)     // Catch:{ all -> 0x009a }
            r7.append(r3)     // Catch:{ all -> 0x009a }
            r7.append(r0)     // Catch:{ all -> 0x009a }
            r7.append(r5)     // Catch:{ all -> 0x009a }
            r7.append(r0)     // Catch:{ all -> 0x009a }
            r7.append(r6)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x009a }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x009a }
            r4.<init>(r0)     // Catch:{ all -> 0x009a }
            throw r4     // Catch:{ all -> 0x009a }
        L_0x009a:
            r0 = move-exception
            kx.d.a(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kx.a.z():void");
    }
}
