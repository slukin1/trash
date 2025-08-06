package com.dianping.logan;

import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.dianping.logan.LoganModel;
import com.dianping.logan.SendLogRunnable;
import com.hbg.lib.network.pro.core.util.Period;
import java.io.File;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class d extends Thread {

    /* renamed from: b  reason: collision with root package name */
    public final Object f64862b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final Object f64863c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f64864d = true;

    /* renamed from: e  reason: collision with root package name */
    public long f64865e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64866f;

    /* renamed from: g  reason: collision with root package name */
    public File f64867g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64868h;

    /* renamed from: i  reason: collision with root package name */
    public long f64869i;

    /* renamed from: j  reason: collision with root package name */
    public b f64870j;

    /* renamed from: k  reason: collision with root package name */
    public ConcurrentLinkedQueue<LoganModel> f64871k;

    /* renamed from: l  reason: collision with root package name */
    public String f64872l;

    /* renamed from: m  reason: collision with root package name */
    public String f64873m;

    /* renamed from: n  reason: collision with root package name */
    public long f64874n;

    /* renamed from: o  reason: collision with root package name */
    public long f64875o;

    /* renamed from: p  reason: collision with root package name */
    public long f64876p;

    /* renamed from: q  reason: collision with root package name */
    public String f64877q;

    /* renamed from: r  reason: collision with root package name */
    public String f64878r;

    /* renamed from: s  reason: collision with root package name */
    public int f64879s;

    /* renamed from: t  reason: collision with root package name */
    public ConcurrentLinkedQueue<LoganModel> f64880t = new ConcurrentLinkedQueue<>();

    /* renamed from: u  reason: collision with root package name */
    public ExecutorService f64881u;

    public class a implements e {
        public a() {
        }

        public void a(String str, int i11) {
            Logan.b(str, i11);
        }
    }

    public class b implements SendLogRunnable.a {
        public b() {
        }

        public void a(int i11) {
            synchronized (d.this.f64863c) {
                int unused = d.this.f64879s = i11;
                if (i11 == 10002) {
                    d.this.f64871k.addAll(d.this.f64880t);
                    d.this.f64880t.clear();
                    d.this.n();
                }
            }
        }
    }

    public class c implements ThreadFactory {
        public c() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(Thread.currentThread().getThreadGroup(), runnable, "logan-thread-send-log", 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    public d(ConcurrentLinkedQueue<LoganModel> concurrentLinkedQueue, String str, String str2, long j11, long j12, long j13, String str3, String str4) {
        this.f64871k = concurrentLinkedQueue;
        this.f64872l = str;
        this.f64873m = str2;
        this.f64874n = j11;
        this.f64875o = j12;
        this.f64876p = j13;
        this.f64877q = str3;
        this.f64878r = str4;
    }

    public final void e(LoganModel loganModel) {
        if (loganModel != null && loganModel.a()) {
            if (this.f64870j == null) {
                b g11 = b.g();
                this.f64870j = g11;
                g11.f(new a());
                this.f64870j.b(this.f64872l, this.f64873m, (int) this.f64875o, this.f64877q, this.f64878r);
                this.f64870j.e(Logan.f64824c);
            }
            LoganModel.Action action = loganModel.f64840a;
            if (action == LoganModel.Action.WRITE) {
                j(loganModel.f64841b);
            } else if (action == LoganModel.Action.SEND) {
                if (loganModel.f64842c.f64888d != null) {
                    synchronized (this.f64863c) {
                        if (this.f64879s == 10001) {
                            this.f64880t.add(loganModel);
                        } else {
                            i(loganModel.f64842c);
                        }
                    }
                }
            } else if (action == LoganModel.Action.FLUSH) {
                h();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0055 A[SYNTHETIC, Splitter:B:39:0x0055] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x005f A[SYNTHETIC, Splitter:B:44:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x006a A[SYNTHETIC, Splitter:B:51:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0074 A[SYNTHETIC, Splitter:B:56:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x007b A[SYNTHETIC, Splitter:B:61:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0085 A[SYNTHETIC, Splitter:B:66:0x0085] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:36:0x0050=Splitter:B:36:0x0050, B:48:0x0065=Splitter:B:48:0x0065} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x004e, all -> 0x004b }
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x004e, all -> 0x004b }
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x004e, all -> 0x004b }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0063, IOException -> 0x004e, all -> 0x004b }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0043, all -> 0x003f }
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0043, all -> 0x003f }
            r3.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0043, all -> 0x003f }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0047, IOException -> 0x0043, all -> 0x003f }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003b, all -> 0x0039 }
        L_0x001a:
            int r0 = r2.read(r6)     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003b, all -> 0x0039 }
            if (r0 < 0) goto L_0x0027
            r5.write(r6, r1, r0)     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003b, all -> 0x0039 }
            r5.flush()     // Catch:{ FileNotFoundException -> 0x003d, IOException -> 0x003b, all -> 0x0039 }
            goto L_0x001a
        L_0x0027:
            r1 = 1
            r2.close()     // Catch:{ Exception -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0030:
            r5.close()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0077
        L_0x0034:
            r5 = move-exception
            r5.printStackTrace()
            goto L_0x0077
        L_0x0039:
            r6 = move-exception
            goto L_0x0041
        L_0x003b:
            r6 = move-exception
            goto L_0x0045
        L_0x003d:
            r6 = move-exception
            goto L_0x0049
        L_0x003f:
            r6 = move-exception
            r5 = r0
        L_0x0041:
            r0 = r2
            goto L_0x0079
        L_0x0043:
            r6 = move-exception
            r5 = r0
        L_0x0045:
            r0 = r2
            goto L_0x0050
        L_0x0047:
            r6 = move-exception
            r5 = r0
        L_0x0049:
            r0 = r2
            goto L_0x0065
        L_0x004b:
            r6 = move-exception
            r5 = r0
            goto L_0x0079
        L_0x004e:
            r6 = move-exception
            r5 = r0
        L_0x0050:
            r6.printStackTrace()     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x005d
            r0.close()     // Catch:{ Exception -> 0x0059 }
            goto L_0x005d
        L_0x0059:
            r6 = move-exception
            r6.printStackTrace()
        L_0x005d:
            if (r5 == 0) goto L_0x0077
            r5.close()     // Catch:{ Exception -> 0x0034 }
            goto L_0x0077
        L_0x0063:
            r6 = move-exception
            r5 = r0
        L_0x0065:
            r6.printStackTrace()     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0072
            r0.close()     // Catch:{ Exception -> 0x006e }
            goto L_0x0072
        L_0x006e:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0072:
            if (r5 == 0) goto L_0x0077
            r5.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0077:
            return r1
        L_0x0078:
            r6 = move-exception
        L_0x0079:
            if (r0 == 0) goto L_0x0083
            r0.close()     // Catch:{ Exception -> 0x007f }
            goto L_0x0083
        L_0x007f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0083:
            if (r5 == 0) goto L_0x008d
            r5.close()     // Catch:{ Exception -> 0x0089 }
            goto L_0x008d
        L_0x0089:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008d:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.dianping.logan.d.f(java.lang.String, java.lang.String):boolean");
    }

    public final void g(long j11) {
        String[] list;
        File file = new File(this.f64873m);
        if (file.isDirectory() && (list = file.list()) != null) {
            for (String str : list) {
                try {
                    if (!TextUtils.isEmpty(str)) {
                        String[] split = str.split("\\.");
                        if (split.length > 0 && Long.valueOf(split[0]).longValue() <= j11 && split.length == 1) {
                            new File(this.f64873m, str).delete();
                        }
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public final void h() {
        if (Logan.f64824c) {
            Log.d("LoganThread", "Logan flush start");
        }
        b bVar = this.f64870j;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void i(f fVar) {
        if (Logan.f64824c) {
            Log.d("LoganThread", "Logan send start");
        }
        if (!TextUtils.isEmpty(this.f64873m) && fVar != null && fVar.a()) {
            if (o(fVar)) {
                fVar.f64888d.d(fVar);
                fVar.f64888d.c(new b());
                this.f64879s = 10001;
                if (this.f64881u == null) {
                    this.f64881u = Executors.newSingleThreadExecutor(new c());
                }
                this.f64881u.execute(fVar.f64888d);
            } else if (Logan.f64824c) {
                Log.d("LoganThread", "Logan prepare log file failed, can't find log file");
            }
        }
    }

    public final void j(g gVar) {
        if (Logan.f64824c) {
            Log.d("LoganThread", "Logan write start");
        }
        if (this.f64867g == null) {
            this.f64867g = new File(this.f64873m);
        }
        if (!l()) {
            long a11 = Util.a();
            g(a11 - this.f64874n);
            this.f64865e = a11;
            this.f64870j.d(String.valueOf(a11));
        }
        if (System.currentTimeMillis() - this.f64869i > 60000) {
            this.f64868h = k();
        }
        this.f64869i = System.currentTimeMillis();
        if (this.f64868h) {
            this.f64870j.c(gVar.f64894f, gVar.f64889a, gVar.f64893e, gVar.f64892d, gVar.f64891c, gVar.f64890b);
        }
    }

    public final boolean k() {
        try {
            StatFs statFs = new StatFs(this.f64873m);
            if (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize()) > this.f64876p) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public final boolean l() {
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = this.f64865e;
        return j11 < currentTimeMillis && j11 + Period.DAY_MILLS > currentTimeMillis;
    }

    public final boolean m(String str) {
        if (TextUtils.isEmpty(this.f64873m)) {
            return false;
        }
        File file = new File(this.f64873m + File.separator + str);
        if (!file.exists() || !file.isFile()) {
            return false;
        }
        return true;
    }

    public void n() {
        if (!this.f64866f) {
            synchronized (this.f64862b) {
                this.f64862b.notify();
            }
        }
    }

    public final boolean o(f fVar) {
        if (Logan.f64824c) {
            Log.d("LoganThread", "prepare log file");
        }
        if (m(fVar.f64886b)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f64873m);
            String str = File.separator;
            sb2.append(str);
            sb2.append(fVar.f64886b);
            String sb3 = sb2.toString();
            if (fVar.f64886b.equals(String.valueOf(Util.a()))) {
                h();
                String str2 = this.f64873m + str + fVar.f64886b + ".copy";
                if (!f(sb3, str2)) {
                    return false;
                }
                fVar.f64887c = str2;
                return true;
            }
            fVar.f64887c = sb3;
            return true;
        }
        fVar.f64887c = "";
        return false;
    }

    public void run() {
        super.run();
        while (this.f64864d) {
            synchronized (this.f64862b) {
                this.f64866f = true;
                try {
                    LoganModel poll = this.f64871k.poll();
                    if (poll == null) {
                        this.f64866f = false;
                        this.f64862b.wait();
                        this.f64866f = true;
                    } else {
                        e(poll);
                    }
                } catch (InterruptedException e11) {
                    e11.printStackTrace();
                    this.f64866f = false;
                }
            }
        }
    }
}
