package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import vx.b;

public final class LoadAndDisplayImageTask implements Runnable, b.a {

    /* renamed from: b  reason: collision with root package name */
    public final d f28331b;

    /* renamed from: c  reason: collision with root package name */
    public final e f28332c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f28333d;

    /* renamed from: e  reason: collision with root package name */
    public final c f28334e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageDownloader f28335f;

    /* renamed from: g  reason: collision with root package name */
    public final ImageDownloader f28336g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageDownloader f28337h;

    /* renamed from: i  reason: collision with root package name */
    public final px.b f28338i;

    /* renamed from: j  reason: collision with root package name */
    public final String f28339j;

    /* renamed from: k  reason: collision with root package name */
    public final String f28340k;

    /* renamed from: l  reason: collision with root package name */
    public final sx.a f28341l;

    /* renamed from: m  reason: collision with root package name */
    public final ox.c f28342m;

    /* renamed from: n  reason: collision with root package name */
    public final DisplayImageOptions f28343n;

    /* renamed from: o  reason: collision with root package name */
    public final tx.a f28344o;

    /* renamed from: p  reason: collision with root package name */
    public final tx.b f28345p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f28346q;

    /* renamed from: r  reason: collision with root package name */
    public LoadedFrom f28347r = LoadedFrom.NETWORK;

    public class TaskCancelledException extends Exception {
        public TaskCancelledException() {
        }
    }

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f28348b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f28349c;

        public a(int i11, int i12) {
            this.f28348b = i11;
            this.f28349c = i12;
        }

        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask.f28345p.a(loadAndDisplayImageTask.f28339j, loadAndDisplayImageTask.f28341l.c(), this.f28348b, this.f28349c);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FailReason.FailType f28351b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Throwable f28352c;

        public b(FailReason.FailType failType, Throwable th2) {
            this.f28351b = failType;
            this.f28352c = th2;
        }

        public void run() {
            if (LoadAndDisplayImageTask.this.f28343n.O()) {
                LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                loadAndDisplayImageTask.f28341l.d(loadAndDisplayImageTask.f28343n.A(loadAndDisplayImageTask.f28334e.f28380a));
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask2 = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask2.f28344o.b(loadAndDisplayImageTask2.f28339j, loadAndDisplayImageTask2.f28341l.c(), new FailReason(this.f28351b, this.f28352c));
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
            loadAndDisplayImageTask.f28344o.d(loadAndDisplayImageTask.f28339j, loadAndDisplayImageTask.f28341l.c());
        }
    }

    public LoadAndDisplayImageTask(d dVar, e eVar, Handler handler) {
        this.f28331b = dVar;
        this.f28332c = eVar;
        this.f28333d = handler;
        c cVar = dVar.f28428a;
        this.f28334e = cVar;
        this.f28335f = cVar.f28395p;
        this.f28336g = cVar.f28398s;
        this.f28337h = cVar.f28399t;
        this.f28338i = cVar.f28396q;
        this.f28339j = eVar.f28454a;
        this.f28340k = eVar.f28455b;
        this.f28341l = eVar.f28456c;
        this.f28342m = eVar.f28457d;
        DisplayImageOptions displayImageOptions = eVar.f28458e;
        this.f28343n = displayImageOptions;
        this.f28344o = eVar.f28459f;
        this.f28345p = eVar.f28460g;
        this.f28346q = displayImageOptions.J();
    }

    public static void t(Runnable runnable, boolean z11, Handler handler, d dVar) {
        if (z11) {
            runnable.run();
        } else if (handler == null) {
            dVar.f(runnable);
        } else {
            handler.post(runnable);
        }
    }

    public boolean a(int i11, int i12) {
        return this.f28346q || l(i11, i12);
    }

    public final void c() throws TaskCancelledException {
        if (o()) {
            throw new TaskCancelledException();
        }
    }

    public final void d() throws TaskCancelledException {
        e();
        f();
    }

    public final void e() throws TaskCancelledException {
        if (q()) {
            throw new TaskCancelledException();
        }
    }

    public final void f() throws TaskCancelledException {
        if (r()) {
            throw new TaskCancelledException();
        }
    }

    public final Bitmap g(String str) throws IOException {
        String str2 = str;
        return this.f28338i.a(new px.c(this.f28340k, str2, this.f28339j, this.f28342m, this.f28341l.a(), m(), this.f28343n));
    }

    public final boolean h() {
        if (!this.f28343n.K()) {
            return false;
        }
        vx.c.a("Delay %d ms before loading...  [%s]", Integer.valueOf(this.f28343n.v()), this.f28340k);
        try {
            Thread.sleep((long) this.f28343n.v());
            return p();
        } catch (InterruptedException unused) {
            vx.c.b("Task was interrupted [%s]", this.f28340k);
            return true;
        }
    }

    public final boolean i() throws IOException {
        InputStream a11 = m().a(this.f28339j, this.f28343n.x());
        if (a11 == null) {
            vx.c.b("No stream for image [%s]", this.f28340k);
            return false;
        }
        try {
            return this.f28334e.f28394o.a(this.f28339j, a11, this);
        } finally {
            vx.b.a(a11);
        }
    }

    public final void j() {
        if (!this.f28346q && !o()) {
            t(new c(), false, this.f28333d, this.f28331b);
        }
    }

    public final void k(FailReason.FailType failType, Throwable th2) {
        if (!this.f28346q && !o() && !p()) {
            t(new b(failType, th2), false, this.f28333d, this.f28331b);
        }
    }

    public final boolean l(int i11, int i12) {
        if (o() || p()) {
            return false;
        }
        if (this.f28345p == null) {
            return true;
        }
        t(new a(i11, i12), false, this.f28333d, this.f28331b);
        return true;
    }

    public final ImageDownloader m() {
        if (this.f28331b.m()) {
            return this.f28336g;
        }
        if (this.f28331b.n()) {
            return this.f28337h;
        }
        return this.f28335f;
    }

    public String n() {
        return this.f28339j;
    }

    public final boolean o() {
        if (!Thread.interrupted()) {
            return false;
        }
        vx.c.a("Task was interrupted [%s]", this.f28340k);
        return true;
    }

    public final boolean p() {
        return q() || r();
    }

    public final boolean q() {
        if (!this.f28341l.e()) {
            return false;
        }
        vx.c.a("ImageAware was collected by GC. Task is cancelled. [%s]", this.f28340k);
        return true;
    }

    public final boolean r() {
        if (!(!this.f28340k.equals(this.f28331b.g(this.f28341l)))) {
            return false;
        }
        vx.c.a("ImageAware is reused for another image. Task is cancelled. [%s]", this.f28340k);
        return true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:41|42|43|44) */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fb, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0103, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0104, code lost:
        r0.unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0107, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00fd */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d2 A[Catch:{ TaskCancelledException -> 0x00fd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            boolean r0 = r7.w()
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            boolean r0 = r7.h()
            if (r0 == 0) goto L_0x000e
            return
        L_0x000e:
            com.nostra13.universalimageloader.core.e r0 = r7.f28332c
            java.util.concurrent.locks.ReentrantLock r0 = r0.f28461h
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = r7.f28340k
            r4 = 0
            r2[r4] = r3
            java.lang.String r3 = "Start display image task [%s]"
            vx.c.a(r3, r2)
            boolean r2 = r0.isLocked()
            if (r2 == 0) goto L_0x0030
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r3 = r7.f28340k
            r2[r4] = r3
            java.lang.String r3 = "Image already is loading. Waiting... [%s]"
            vx.c.a(r3, r2)
        L_0x0030:
            r0.lock()
            r7.d()     // Catch:{ TaskCancelledException -> 0x00fd }
            com.nostra13.universalimageloader.core.c r2 = r7.f28334e     // Catch:{ TaskCancelledException -> 0x00fd }
            mx.a r2 = r2.f28393n     // Catch:{ TaskCancelledException -> 0x00fd }
            java.lang.String r3 = r7.f28340k     // Catch:{ TaskCancelledException -> 0x00fd }
            android.graphics.Bitmap r2 = r2.get(r3)     // Catch:{ TaskCancelledException -> 0x00fd }
            if (r2 == 0) goto L_0x0059
            boolean r3 = r2.isRecycled()     // Catch:{ TaskCancelledException -> 0x00fd }
            if (r3 == 0) goto L_0x0049
            goto L_0x0059
        L_0x0049:
            com.nostra13.universalimageloader.core.assist.LoadedFrom r3 = com.nostra13.universalimageloader.core.assist.LoadedFrom.MEMORY_CACHE     // Catch:{ TaskCancelledException -> 0x00fd }
            r7.f28347r = r3     // Catch:{ TaskCancelledException -> 0x00fd }
            java.lang.String r3 = "...Get cached bitmap from memory after waiting. [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ TaskCancelledException -> 0x00fd }
            java.lang.String r6 = r7.f28340k     // Catch:{ TaskCancelledException -> 0x00fd }
            r5[r4] = r6     // Catch:{ TaskCancelledException -> 0x00fd }
            vx.c.a(r3, r5)     // Catch:{ TaskCancelledException -> 0x00fd }
            goto L_0x00b1
        L_0x0059:
            android.graphics.Bitmap r2 = r7.v()     // Catch:{ TaskCancelledException -> 0x00fd }
            if (r2 != 0) goto L_0x0063
            r0.unlock()
            return
        L_0x0063:
            r7.d()     // Catch:{ TaskCancelledException -> 0x00fd }
            r7.c()     // Catch:{ TaskCancelledException -> 0x00fd }
            com.nostra13.universalimageloader.core.DisplayImageOptions r3 = r7.f28343n     // Catch:{ TaskCancelledException -> 0x00fd }
            boolean r3 = r3.M()     // Catch:{ TaskCancelledException -> 0x00fd }
            if (r3 == 0) goto L_0x0093
            java.lang.String r3 = "PreProcess image before caching in memory [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ TaskCancelledException -> 0x00fd }
            java.lang.String r6 = r7.f28340k     // Catch:{ TaskCancelledException -> 0x00fd }
            r5[r4] = r6     // Catch:{ TaskCancelledException -> 0x00fd }
            vx.c.a(r3, r5)     // Catch:{ TaskCancelledException -> 0x00fd }
            com.nostra13.universalimageloader.core.DisplayImageOptions r3 = r7.f28343n     // Catch:{ TaskCancelledException -> 0x00fd }
            ux.a r3 = r3.E()     // Catch:{ TaskCancelledException -> 0x00fd }
            android.graphics.Bitmap r2 = r3.a(r2)     // Catch:{ TaskCancelledException -> 0x00fd }
            if (r2 != 0) goto L_0x0093
            java.lang.String r3 = "Pre-processor returned null [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ TaskCancelledException -> 0x00fd }
            java.lang.String r6 = r7.f28340k     // Catch:{ TaskCancelledException -> 0x00fd }
            r5[r4] = r6     // Catch:{ TaskCancelledException -> 0x00fd }
            vx.c.b(r3, r5)     // Catch:{ TaskCancelledException -> 0x00fd }
        L_0x0093:
            if (r2 == 0) goto L_0x00b1
            com.nostra13.universalimageloader.core.DisplayImageOptions r3 = r7.f28343n     // Catch:{ TaskCancelledException -> 0x00fd }
            boolean r3 = r3.F()     // Catch:{ TaskCancelledException -> 0x00fd }
            if (r3 == 0) goto L_0x00b1
            java.lang.String r3 = "Cache image in memory [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ TaskCancelledException -> 0x00fd }
            java.lang.String r6 = r7.f28340k     // Catch:{ TaskCancelledException -> 0x00fd }
            r5[r4] = r6     // Catch:{ TaskCancelledException -> 0x00fd }
            vx.c.a(r3, r5)     // Catch:{ TaskCancelledException -> 0x00fd }
            com.nostra13.universalimageloader.core.c r3 = r7.f28334e     // Catch:{ TaskCancelledException -> 0x00fd }
            mx.a r3 = r3.f28393n     // Catch:{ TaskCancelledException -> 0x00fd }
            java.lang.String r5 = r7.f28340k     // Catch:{ TaskCancelledException -> 0x00fd }
            r3.a(r5, r2)     // Catch:{ TaskCancelledException -> 0x00fd }
        L_0x00b1:
            if (r2 == 0) goto L_0x00dd
            com.nostra13.universalimageloader.core.DisplayImageOptions r3 = r7.f28343n     // Catch:{ TaskCancelledException -> 0x00fd }
            boolean r3 = r3.L()     // Catch:{ TaskCancelledException -> 0x00fd }
            if (r3 == 0) goto L_0x00dd
            java.lang.String r3 = "PostProcess image before displaying [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ TaskCancelledException -> 0x00fd }
            java.lang.String r6 = r7.f28340k     // Catch:{ TaskCancelledException -> 0x00fd }
            r5[r4] = r6     // Catch:{ TaskCancelledException -> 0x00fd }
            vx.c.a(r3, r5)     // Catch:{ TaskCancelledException -> 0x00fd }
            com.nostra13.universalimageloader.core.DisplayImageOptions r3 = r7.f28343n     // Catch:{ TaskCancelledException -> 0x00fd }
            ux.a r3 = r3.D()     // Catch:{ TaskCancelledException -> 0x00fd }
            android.graphics.Bitmap r2 = r3.a(r2)     // Catch:{ TaskCancelledException -> 0x00fd }
            if (r2 != 0) goto L_0x00dd
            java.lang.String r3 = "Post-processor returned null [%s]"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ TaskCancelledException -> 0x00fd }
            java.lang.String r5 = r7.f28340k     // Catch:{ TaskCancelledException -> 0x00fd }
            r1[r4] = r5     // Catch:{ TaskCancelledException -> 0x00fd }
            vx.c.b(r3, r1)     // Catch:{ TaskCancelledException -> 0x00fd }
        L_0x00dd:
            r7.d()     // Catch:{ TaskCancelledException -> 0x00fd }
            r7.c()     // Catch:{ TaskCancelledException -> 0x00fd }
            r0.unlock()
            com.nostra13.universalimageloader.core.a r0 = new com.nostra13.universalimageloader.core.a
            com.nostra13.universalimageloader.core.e r1 = r7.f28332c
            com.nostra13.universalimageloader.core.d r3 = r7.f28331b
            com.nostra13.universalimageloader.core.assist.LoadedFrom r4 = r7.f28347r
            r0.<init>(r2, r1, r3, r4)
            boolean r1 = r7.f28346q
            android.os.Handler r2 = r7.f28333d
            com.nostra13.universalimageloader.core.d r3 = r7.f28331b
            t(r0, r1, r2, r3)
            return
        L_0x00fb:
            r1 = move-exception
            goto L_0x0104
        L_0x00fd:
            r7.j()     // Catch:{ all -> 0x00fb }
            r0.unlock()
            return
        L_0x0104:
            r0.unlock()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.run():void");
    }

    public final boolean s(int i11, int i12) throws IOException {
        File file = this.f28334e.f28394o.get(this.f28339j);
        if (file == null || !file.exists()) {
            return false;
        }
        Bitmap a11 = this.f28338i.a(new px.c(this.f28340k, ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), this.f28339j, new ox.c(i11, i12), ViewScaleType.FIT_INSIDE, m(), new DisplayImageOptions.Builder().x(this.f28343n).z(ImageScaleType.IN_SAMPLE_INT).u()));
        if (!(a11 == null || this.f28334e.f28385f == null)) {
            vx.c.a("Process image before cache on disk [%s]", this.f28340k);
            a11 = this.f28334e.f28385f.a(a11);
            if (a11 == null) {
                vx.c.b("Bitmap processor for disk cache returned null [%s]", this.f28340k);
            }
        }
        if (a11 == null) {
            return false;
        }
        boolean b11 = this.f28334e.f28394o.b(this.f28339j, a11);
        a11.recycle();
        return b11;
    }

    public final boolean u() throws TaskCancelledException {
        vx.c.a("Cache image on disk [%s]", this.f28340k);
        try {
            boolean i11 = i();
            if (i11) {
                c cVar = this.f28334e;
                int i12 = cVar.f28383d;
                int i13 = cVar.f28384e;
                if (i12 > 0 || i13 > 0) {
                    vx.c.a("Resize image in disk cache [%s]", this.f28340k);
                    s(i12, i13);
                }
            }
            return i11;
        } catch (IOException e11) {
            vx.c.c(e11);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a0, code lost:
        r8 = r1;
        r1 = r0;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a5, code lost:
        r8 = r1;
        r1 = r0;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
        r8 = r1;
        r1 = r0;
        r0 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ce, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00cd A[ExcHandler: TaskCancelledException (r0v1 'e' com.nostra13.universalimageloader.core.LoadAndDisplayImageTask$TaskCancelledException A[CUSTOM_DECLARE]), Splitter:B:1:0x0001] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap v() throws com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.TaskCancelledException {
        /*
            r9 = this;
            r0 = 0
            com.nostra13.universalimageloader.core.c r1 = r9.f28334e     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            ix.a r1 = r1.f28394o     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            java.lang.String r2 = r9.f28339j     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            java.io.File r1 = r1.get(r2)     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0040
            boolean r4 = r1.exists()     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            if (r4 == 0) goto L_0x0040
            long r4 = r1.length()     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            r6 = 0
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0040
            java.lang.String r4 = "Load image from disk cache [%s]"
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            java.lang.String r6 = r9.f28340k     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            r5[r2] = r6     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            vx.c.a(r4, r5)     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            com.nostra13.universalimageloader.core.assist.LoadedFrom r4 = com.nostra13.universalimageloader.core.assist.LoadedFrom.DISC_CACHE     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            r9.f28347r = r4     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            r9.d()     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r4 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            java.lang.String r1 = r4.wrap(r1)     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            android.graphics.Bitmap r1 = r9.g(r1)     // Catch:{ IllegalStateException -> 0x00cf, TaskCancelledException -> 0x00cd, IOException -> 0x00c2, OutOfMemoryError -> 0x00b8, all -> 0x00ae }
            goto L_0x0041
        L_0x0040:
            r1 = r0
        L_0x0041:
            if (r1 == 0) goto L_0x004f
            int r4 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            if (r4 <= 0) goto L_0x004f
            int r4 = r1.getHeight()     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            if (r4 > 0) goto L_0x00d5
        L_0x004f:
            java.lang.String r4 = "Load image from network [%s]"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            java.lang.String r5 = r9.f28340k     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            r3[r2] = r5     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            vx.c.a(r4, r3)     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            com.nostra13.universalimageloader.core.assist.LoadedFrom r2 = com.nostra13.universalimageloader.core.assist.LoadedFrom.NETWORK     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            r9.f28347r = r2     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            java.lang.String r2 = r9.f28339j     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            com.nostra13.universalimageloader.core.DisplayImageOptions r3 = r9.f28343n     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            boolean r3 = r3.G()     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            if (r3 == 0) goto L_0x0084
            boolean r3 = r9.u()     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            if (r3 == 0) goto L_0x0084
            com.nostra13.universalimageloader.core.c r3 = r9.f28334e     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            ix.a r3 = r3.f28394o     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            java.lang.String r4 = r9.f28339j     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            java.io.File r3 = r3.get(r4)     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            if (r3 == 0) goto L_0x0084
            com.nostra13.universalimageloader.core.download.ImageDownloader$Scheme r2 = com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.FILE     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            java.lang.String r2 = r2.wrap(r3)     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
        L_0x0084:
            r9.d()     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            android.graphics.Bitmap r1 = r9.g(r2)     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            if (r1 == 0) goto L_0x0099
            int r2 = r1.getWidth()     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            if (r2 <= 0) goto L_0x0099
            int r2 = r1.getHeight()     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            if (r2 > 0) goto L_0x00d5
        L_0x0099:
            com.nostra13.universalimageloader.core.assist.FailReason$FailType r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.DECODING_ERROR     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            r9.k(r2, r0)     // Catch:{ IllegalStateException -> 0x00d0, TaskCancelledException -> 0x00cd, IOException -> 0x00a9, OutOfMemoryError -> 0x00a4, all -> 0x009f }
            goto L_0x00d5
        L_0x009f:
            r0 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L_0x00af
        L_0x00a4:
            r0 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L_0x00b9
        L_0x00a9:
            r0 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L_0x00c3
        L_0x00ae:
            r1 = move-exception
        L_0x00af:
            vx.c.c(r1)
            com.nostra13.universalimageloader.core.assist.FailReason$FailType r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.UNKNOWN
            r9.k(r2, r1)
            goto L_0x00cb
        L_0x00b8:
            r1 = move-exception
        L_0x00b9:
            vx.c.c(r1)
            com.nostra13.universalimageloader.core.assist.FailReason$FailType r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.OUT_OF_MEMORY
            r9.k(r2, r1)
            goto L_0x00cb
        L_0x00c2:
            r1 = move-exception
        L_0x00c3:
            vx.c.c(r1)
            com.nostra13.universalimageloader.core.assist.FailReason$FailType r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.IO_ERROR
            r9.k(r2, r1)
        L_0x00cb:
            r1 = r0
            goto L_0x00d5
        L_0x00cd:
            r0 = move-exception
            throw r0
        L_0x00cf:
            r1 = r0
        L_0x00d0:
            com.nostra13.universalimageloader.core.assist.FailReason$FailType r2 = com.nostra13.universalimageloader.core.assist.FailReason.FailType.NETWORK_DENIED
            r9.k(r2, r0)
        L_0x00d5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.v():android.graphics.Bitmap");
    }

    public final boolean w() {
        AtomicBoolean i11 = this.f28331b.i();
        if (i11.get()) {
            synchronized (this.f28331b.j()) {
                if (i11.get()) {
                    vx.c.a("ImageLoader is paused. Waiting...  [%s]", this.f28340k);
                    try {
                        this.f28331b.j().wait();
                        vx.c.a(".. Resume loading [%s]", this.f28340k);
                    } catch (InterruptedException unused) {
                        vx.c.b("Task was interrupted [%s]", this.f28340k);
                        return true;
                    }
                }
            }
        }
        return p();
    }
}
