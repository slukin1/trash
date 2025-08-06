package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;

public class n {

    /* renamed from: a  reason: collision with root package name */
    private static long f52562a;

    /* renamed from: b  reason: collision with root package name */
    private static long f52563b;

    /* renamed from: c  reason: collision with root package name */
    private static long f52564c;

    /* renamed from: a  reason: collision with other field name */
    private final a f3400a;

    /* renamed from: a  reason: collision with other field name */
    private final c f3401a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final c f52565a;

        public a(c cVar) {
            this.f52565a = cVar;
        }

        public void finalize() {
            try {
                synchronized (this.f52565a) {
                    boolean unused = this.f52565a.f52569c = true;
                    this.f52565a.notify();
                }
                super.finalize();
            } catch (Throwable th2) {
                super.finalize();
                throw th2;
            }
        }
    }

    public static abstract class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public int f52566a;

        public b(int i11) {
            this.f52566a = i11;
        }
    }

    static {
        long j11 = 0;
        if (SystemClock.elapsedRealtime() > 0) {
            j11 = SystemClock.elapsedRealtime();
        }
        f52562a = j11;
        f52563b = j11;
    }

    public n(String str, boolean z11) {
        Objects.requireNonNull(str, "name == null");
        c cVar = new c(str, z11);
        this.f3401a = cVar;
        this.f3400a = new a(cVar);
    }

    public static synchronized long a() {
        long j11;
        synchronized (n.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j12 = f52563b;
            if (elapsedRealtime > j12) {
                f52562a += elapsedRealtime - j12;
            }
            f52563b = elapsedRealtime;
            j11 = f52562a;
        }
        return j11;
    }

    private static synchronized long b() {
        long j11;
        synchronized (n.class) {
            j11 = f52564c;
            f52564c = 1 + j11;
        }
        return j11;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m3030b() {
        synchronized (this.f3401a) {
            c.a(this.f3401a).a();
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f52573a;

        /* renamed from: a  reason: collision with other field name */
        public long f3406a;

        /* renamed from: a  reason: collision with other field name */
        public b f3407a;

        /* renamed from: a  reason: collision with other field name */
        public final Object f3408a = new Object();

        /* renamed from: a  reason: collision with other field name */
        public boolean f3409a;

        /* renamed from: b  reason: collision with root package name */
        private long f52574b;

        public void a(long j11) {
            synchronized (this.f3408a) {
                this.f52574b = j11;
            }
        }

        public boolean a() {
            boolean z11;
            synchronized (this.f3408a) {
                z11 = !this.f3409a && this.f3406a > 0;
                this.f3409a = true;
            }
            return z11;
        }
    }

    public static final class c extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private volatile long f52567a = 0;

        /* renamed from: a  reason: collision with other field name */
        private a f3402a = new a();

        /* renamed from: a  reason: collision with other field name */
        private volatile boolean f3403a = false;

        /* renamed from: b  reason: collision with root package name */
        private long f52568b = 50;

        /* renamed from: b  reason: collision with other field name */
        private boolean f3404b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public boolean f52569c;

        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private int f52570a;

            /* renamed from: a  reason: collision with other field name */
            private d[] f3405a;

            /* renamed from: b  reason: collision with root package name */
            private int f52571b;

            /* renamed from: c  reason: collision with root package name */
            private int f52572c;

            private a() {
                this.f52570a = 256;
                this.f3405a = new d[256];
                this.f52571b = 0;
                this.f52572c = 0;
            }

            private void c() {
                int i11 = this.f52571b - 1;
                int i12 = (i11 - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f3405a;
                    if (dVarArr[i11].f3406a < dVarArr[i12].f3406a) {
                        d dVar = dVarArr[i11];
                        dVarArr[i11] = dVarArr[i12];
                        dVarArr[i12] = dVar;
                        int i13 = i12;
                        i12 = (i12 - 1) / 2;
                        i11 = i13;
                    } else {
                        return;
                    }
                }
            }

            public void b(int i11) {
                int i12;
                if (i11 >= 0 && i11 < (i12 = this.f52571b)) {
                    d[] dVarArr = this.f3405a;
                    int i13 = i12 - 1;
                    this.f52571b = i13;
                    dVarArr[i11] = dVarArr[i13];
                    dVarArr[i13] = null;
                    c(i11);
                }
            }

            public d a() {
                return this.f3405a[0];
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m3034a() {
                return this.f52571b == 0;
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m3033a(d dVar) {
                d[] dVarArr = this.f3405a;
                int length = dVarArr.length;
                int i11 = this.f52571b;
                if (length == i11) {
                    d[] dVarArr2 = new d[(i11 * 2)];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i11);
                    this.f3405a = dVarArr2;
                }
                d[] dVarArr3 = this.f3405a;
                int i12 = this.f52571b;
                this.f52571b = i12 + 1;
                dVarArr3[i12] = dVar;
                c();
            }

            public void b() {
                int i11 = 0;
                while (i11 < this.f52571b) {
                    if (this.f3405a[i11].f3409a) {
                        this.f52572c++;
                        b(i11);
                        i11--;
                    }
                    i11++;
                }
            }

            private void c(int i11) {
                int i12 = (i11 * 2) + 1;
                while (true) {
                    int i13 = this.f52571b;
                    if (i12 < i13 && i13 > 0) {
                        int i14 = i12 + 1;
                        if (i14 < i13) {
                            d[] dVarArr = this.f3405a;
                            if (dVarArr[i14].f3406a < dVarArr[i12].f3406a) {
                                i12 = i14;
                            }
                        }
                        d[] dVarArr2 = this.f3405a;
                        if (dVarArr2[i11].f3406a >= dVarArr2[i12].f3406a) {
                            d dVar = dVarArr2[i11];
                            dVarArr2[i11] = dVarArr2[i12];
                            dVarArr2[i12] = dVar;
                            int i15 = i12;
                            i12 = (i12 * 2) + 1;
                            i11 = i15;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }

            /* renamed from: a  reason: collision with other method in class */
            public boolean m3035a(int i11) {
                for (int i12 = 0; i12 < this.f52571b; i12++) {
                    if (this.f3405a[i12].f52573a == i11) {
                        return true;
                    }
                }
                return false;
            }

            public void a(int i11) {
                for (int i12 = 0; i12 < this.f52571b; i12++) {
                    d[] dVarArr = this.f3405a;
                    if (dVarArr[i12].f52573a == i11) {
                        dVarArr[i12].a();
                    }
                }
                b();
            }

            public void a(int i11, b bVar) {
                for (int i12 = 0; i12 < this.f52571b; i12++) {
                    d[] dVarArr = this.f3405a;
                    if (dVarArr[i12].f3407a == bVar) {
                        dVarArr[i12].a();
                    }
                }
                b();
            }

            /* renamed from: a  reason: collision with other method in class */
            public void m3032a() {
                this.f3405a = new d[this.f52570a];
                this.f52571b = 0;
            }

            /* access modifiers changed from: private */
            public int a(d dVar) {
                int i11 = 0;
                while (true) {
                    d[] dVarArr = this.f3405a;
                    if (i11 >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i11] == dVar) {
                        return i11;
                    }
                    i11++;
                }
            }
        }

        public c(String str, boolean z11) {
            setName(str);
            setDaemon(z11);
            start();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
            r10.f52567a = android.os.SystemClock.uptimeMillis();
            r10.f3403a = true;
            r2.f3407a.run();
            r10.f3403a = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x00a3, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x00a4, code lost:
            monitor-enter(r10);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            r10.f3404b = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00a8, code lost:
            throw r1;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0018 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:40:0x0055 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
            L_0x0000:
                monitor-enter(r10)
                boolean r0 = r10.f3404b     // Catch:{ all -> 0x00b2 }
                if (r0 == 0) goto L_0x0007
                monitor-exit(r10)     // Catch:{ all -> 0x00b2 }
                return
            L_0x0007:
                com.xiaomi.push.service.n$c$a r0 = r10.f3402a     // Catch:{ all -> 0x00b2 }
                boolean r0 = r0.a()     // Catch:{ all -> 0x00b2 }
                if (r0 == 0) goto L_0x001a
                boolean r0 = r10.f52569c     // Catch:{ all -> 0x00b2 }
                if (r0 == 0) goto L_0x0015
                monitor-exit(r10)     // Catch:{ all -> 0x00b2 }
                return
            L_0x0015:
                r10.wait()     // Catch:{ InterruptedException -> 0x0018 }
            L_0x0018:
                monitor-exit(r10)     // Catch:{ all -> 0x00b2 }
                goto L_0x0000
            L_0x001a:
                long r0 = com.xiaomi.push.service.n.a()     // Catch:{ all -> 0x00b2 }
                com.xiaomi.push.service.n$c$a r2 = r10.f3402a     // Catch:{ all -> 0x00b2 }
                com.xiaomi.push.service.n$d r2 = r2.a()     // Catch:{ all -> 0x00b2 }
                java.lang.Object r3 = r2.f3408a     // Catch:{ all -> 0x00b2 }
                monitor-enter(r3)     // Catch:{ all -> 0x00b2 }
                boolean r4 = r2.f3409a     // Catch:{ all -> 0x00af }
                r5 = 0
                if (r4 == 0) goto L_0x0034
                com.xiaomi.push.service.n$c$a r0 = r10.f3402a     // Catch:{ all -> 0x00af }
                r0.b(r5)     // Catch:{ all -> 0x00af }
                monitor-exit(r3)     // Catch:{ all -> 0x00af }
                monitor-exit(r10)     // Catch:{ all -> 0x00b2 }
                goto L_0x0000
            L_0x0034:
                long r6 = r2.f3406a     // Catch:{ all -> 0x00af }
                long r6 = r6 - r0
                monitor-exit(r3)     // Catch:{ all -> 0x00af }
                r0 = 0
                int r3 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                r8 = 50
                if (r3 <= 0) goto L_0x0057
                long r0 = r10.f52568b     // Catch:{ all -> 0x00b2 }
                int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
                if (r2 <= 0) goto L_0x0047
                r6 = r0
            L_0x0047:
                long r0 = r0 + r8
                r10.f52568b = r0     // Catch:{ all -> 0x00b2 }
                r2 = 500(0x1f4, double:2.47E-321)
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 <= 0) goto L_0x0052
                r10.f52568b = r2     // Catch:{ all -> 0x00b2 }
            L_0x0052:
                r10.wait(r6)     // Catch:{ InterruptedException -> 0x0055 }
            L_0x0055:
                monitor-exit(r10)     // Catch:{ all -> 0x00b2 }
                goto L_0x0000
            L_0x0057:
                r10.f52568b = r8     // Catch:{ all -> 0x00b2 }
                java.lang.Object r3 = r2.f3408a     // Catch:{ all -> 0x00b2 }
                monitor-enter(r3)     // Catch:{ all -> 0x00b2 }
                com.xiaomi.push.service.n$c$a r4 = r10.f3402a     // Catch:{ all -> 0x00ac }
                com.xiaomi.push.service.n$d r4 = r4.a()     // Catch:{ all -> 0x00ac }
                long r6 = r4.f3406a     // Catch:{ all -> 0x00ac }
                long r8 = r2.f3406a     // Catch:{ all -> 0x00ac }
                int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r4 == 0) goto L_0x0071
                com.xiaomi.push.service.n$c$a r4 = r10.f3402a     // Catch:{ all -> 0x00ac }
                int r4 = r4.a((com.xiaomi.push.service.n.d) r2)     // Catch:{ all -> 0x00ac }
                goto L_0x0072
            L_0x0071:
                r4 = r5
            L_0x0072:
                boolean r6 = r2.f3409a     // Catch:{ all -> 0x00ac }
                if (r6 == 0) goto L_0x0083
                com.xiaomi.push.service.n$c$a r0 = r10.f3402a     // Catch:{ all -> 0x00ac }
                int r1 = r0.a((com.xiaomi.push.service.n.d) r2)     // Catch:{ all -> 0x00ac }
                r0.b(r1)     // Catch:{ all -> 0x00ac }
                monitor-exit(r3)     // Catch:{ all -> 0x00ac }
                monitor-exit(r10)     // Catch:{ all -> 0x00b2 }
                goto L_0x0000
            L_0x0083:
                long r6 = r2.f3406a     // Catch:{ all -> 0x00ac }
                r2.a(r6)     // Catch:{ all -> 0x00ac }
                com.xiaomi.push.service.n$c$a r6 = r10.f3402a     // Catch:{ all -> 0x00ac }
                r6.b(r4)     // Catch:{ all -> 0x00ac }
                r2.f3406a = r0     // Catch:{ all -> 0x00ac }
                monitor-exit(r3)     // Catch:{ all -> 0x00ac }
                monitor-exit(r10)     // Catch:{ all -> 0x00b2 }
                r0 = 1
                long r3 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00a3 }
                r10.f52567a = r3     // Catch:{ all -> 0x00a3 }
                r10.f3403a = r0     // Catch:{ all -> 0x00a3 }
                com.xiaomi.push.service.n$b r1 = r2.f3407a     // Catch:{ all -> 0x00a3 }
                r1.run()     // Catch:{ all -> 0x00a3 }
                r10.f3403a = r5     // Catch:{ all -> 0x00a3 }
                goto L_0x0000
            L_0x00a3:
                r1 = move-exception
                monitor-enter(r10)
                r10.f3404b = r0     // Catch:{ all -> 0x00a9 }
                monitor-exit(r10)     // Catch:{ all -> 0x00a9 }
                throw r1
            L_0x00a9:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00a9 }
                throw r0
            L_0x00ac:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x00ac }
                throw r0     // Catch:{ all -> 0x00b2 }
            L_0x00af:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x00af }
                throw r0     // Catch:{ all -> 0x00b2 }
            L_0x00b2:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00b2 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.n.c.run():void");
        }

        /* access modifiers changed from: private */
        public void a(d dVar) {
            this.f3402a.a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f3404b = true;
            this.f3402a.a();
            notify();
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m3031a() {
            return this.f3403a && SystemClock.uptimeMillis() - this.f52567a > 600000;
        }
    }

    public n(String str) {
        this(str, false);
    }

    private void b(b bVar, long j11) {
        synchronized (this.f3401a) {
            if (!c.a(this.f3401a)) {
                long a11 = j11 + a();
                if (a11 >= 0) {
                    d dVar = new d();
                    dVar.f52573a = bVar.f52566a;
                    dVar.f3407a = bVar;
                    dVar.f3406a = a11;
                    this.f3401a.a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a11);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    public n(boolean z11) {
        this("Timer-" + b(), z11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m3027a() {
        com.xiaomi.channel.commonutils.logger.b.a("quit. finalizer:" + this.f3400a);
        this.f3401a.a();
    }

    public n() {
        this(false);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m3029a(int i11) {
        boolean a11;
        synchronized (this.f3401a) {
            a11 = c.a(this.f3401a).a(i11);
        }
        return a11;
    }

    public void a(int i11) {
        synchronized (this.f3401a) {
            c.a(this.f3401a).a(i11);
        }
    }

    public void a(int i11, b bVar) {
        synchronized (this.f3401a) {
            c.a(this.f3401a).a(i11, bVar);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m3028a() {
        return this.f3401a.a();
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() >= 1 || Thread.currentThread() == this.f3401a) {
            bVar.run();
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j11) {
        if (j11 >= 0) {
            b(bVar, j11);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j11);
    }
}
