package vu;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class g implements Handler.Callback, Executor {

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicInteger f23428d = new AtomicInteger(1);

    /* renamed from: e  reason: collision with root package name */
    public static g f23429e;

    /* renamed from: f  reason: collision with root package name */
    public static b f23430f = new b();

    /* renamed from: b  reason: collision with root package name */
    public Handler f23431b;

    /* renamed from: c  reason: collision with root package name */
    public Set<Handler.Callback> f23432c = new HashSet();

    public static class b implements Thread.UncaughtExceptionHandler {
        public b() {
        }

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        public void uncaughtException(java.lang.Thread r10, java.lang.Throwable r11) {
            /*
                r9 = this;
                java.lang.String r0 = "ZpUncaughtExceptionHandle"
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "捕获SDK后台工作线程(Name="
                r1.append(r2)
                java.lang.String r2 = r10.getName()
                r1.append(r2)
                java.lang.String r2 = ", Id="
                r1.append(r2)
                long r2 = r10.getId()
                r1.append(r2)
                java.lang.String r10 = ")异常, 重新加载SDK后台工作线程"
                r1.append(r10)
                java.lang.String r10 = r1.toString()
                kv.e.i(r0, r10, r11)
                java.lang.Class<vu.g> r10 = vu.g.class
                monitor-enter(r10)
                vu.g r11 = vu.g.f23429e     // Catch:{ all -> 0x00c2 }
                android.os.Handler r11 = r11.f23431b     // Catch:{ all -> 0x00c2 }
                vu.g r0 = vu.g.f23429e     // Catch:{ all -> 0x00c2 }
                r0.f()     // Catch:{ all -> 0x00c2 }
                if (r11 == 0) goto L_0x00c0
                int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00c2 }
                r1 = 23
                if (r0 < r1) goto L_0x00aa
                android.os.Looper r0 = r11.getLooper()     // Catch:{ Exception -> 0x00a2 }
                android.os.MessageQueue r0 = r0.getQueue()     // Catch:{ Exception -> 0x00a2 }
                java.lang.Class<android.os.Message> r1 = android.os.Message.class
                java.lang.Class<android.os.MessageQueue> r2 = android.os.MessageQueue.class
                java.lang.String r3 = "mMessages"
                r4 = 1
                java.lang.Object r1 = com.huobi.woodpecker.utils.ReflectUtils.a(r1, r2, r3, r0, r4)     // Catch:{ Exception -> 0x00a2 }
                android.os.Message r1 = (android.os.Message) r1     // Catch:{ Exception -> 0x00a2 }
                if (r1 == 0) goto L_0x00c0
                monitor-enter(r0)     // Catch:{ Exception -> 0x00a2 }
                long r2 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x009f }
            L_0x0061:
                if (r1 == 0) goto L_0x0092
                android.os.Message r5 = android.os.Message.obtain(r1)     // Catch:{ all -> 0x009f }
                vu.g r6 = vu.g.f23429e     // Catch:{ all -> 0x009f }
                android.os.Handler r6 = r6.f23431b     // Catch:{ all -> 0x009f }
                r5.setTarget(r6)     // Catch:{ all -> 0x009f }
                long r6 = r1.getWhen()     // Catch:{ all -> 0x009f }
                long r6 = java.lang.Math.max(r2, r6)     // Catch:{ all -> 0x009f }
                vu.g r8 = vu.g.f23429e     // Catch:{ all -> 0x009f }
                android.os.Handler r8 = r8.f23431b     // Catch:{ all -> 0x009f }
                r8.sendMessageAtTime(r5, r6)     // Catch:{ all -> 0x009f }
                java.lang.Class<android.os.Message> r5 = android.os.Message.class
                java.lang.Class<android.os.Message> r6 = android.os.Message.class
                java.lang.String r7 = "next"
                java.lang.Object r1 = com.huobi.woodpecker.utils.ReflectUtils.a(r5, r6, r7, r1, r4)     // Catch:{ all -> 0x009f }
                android.os.Message r1 = (android.os.Message) r1     // Catch:{ all -> 0x009f }
                goto L_0x0061
            L_0x0092:
                monitor-exit(r0)     // Catch:{ all -> 0x009f }
                r0 = 0
                r11.removeMessages(r0)     // Catch:{ Exception -> 0x00a2 }
                android.os.Looper r11 = r11.getLooper()     // Catch:{ Exception -> 0x00a2 }
                r11.quitSafely()     // Catch:{ Exception -> 0x00a2 }
                goto L_0x00c0
            L_0x009f:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x009f }
                throw r11     // Catch:{ Exception -> 0x00a2 }
            L_0x00a2:
                java.lang.String r11 = "ZpUncaughtExceptionHandle"
                java.lang.String r0 = "WorkHandler未完成任务迁移失败!!!"
                kv.e.h(r11, r0)     // Catch:{ all -> 0x00c2 }
                goto L_0x00c0
            L_0x00aa:
                r1 = 18
                if (r0 < r1) goto L_0x00b5
                android.os.Looper r0 = r11.getLooper()     // Catch:{ all -> 0x00c2 }
                r0.quitSafely()     // Catch:{ all -> 0x00c2 }
            L_0x00b5:
                android.os.Looper r11 = r11.getLooper()     // Catch:{ all -> 0x00c2 }
                java.lang.Thread r11 = r11.getThread()     // Catch:{ all -> 0x00c2 }
                r11.interrupt()     // Catch:{ all -> 0x00c2 }
            L_0x00c0:
                monitor-exit(r10)     // Catch:{ all -> 0x00c2 }
                return
            L_0x00c2:
                r11 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00c2 }
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: vu.g.b.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
        }
    }

    public g() {
        f();
    }

    public static g d() {
        g gVar = f23429e;
        if (gVar == null || gVar.f23431b == null) {
            synchronized (g.class) {
                g gVar2 = f23429e;
                if (gVar2 == null) {
                    f23429e = new g();
                } else if (gVar2.f23431b == null) {
                    gVar2.f();
                }
            }
        }
        return f23429e;
    }

    public boolean e(int i11) {
        return this.f23431b.hasMessages(i11);
    }

    public void execute(Runnable runnable) {
        h(runnable);
    }

    public final void f() {
        HandlerThread handlerThread = new HandlerThread("WP-WorkHandler#" + f23428d.getAndIncrement());
        handlerThread.setUncaughtExceptionHandler(f23430f);
        handlerThread.start();
        this.f23431b = new Handler(handlerThread.getLooper(), this);
    }

    public final Message g(Runnable runnable) {
        Message obtain = Message.obtain();
        obtain.what = 999999999;
        obtain.obj = runnable;
        return obtain;
    }

    public void h(Runnable runnable) {
        this.f23431b.post(runnable);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x003a A[LOOP:0: B:7:0x003a->B:10:0x004a, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "handleMessage msg="
            r0.append(r1)
            java.lang.String r1 = r4.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "WP-WorkHandler"
            kv.e.e(r1, r0)
            int r0 = r4.what
            r1 = 1
            r2 = 999999999(0x3b9ac9ff, float:0.004723787)
            if (r0 != r2) goto L_0x0034
            java.lang.Object r0 = r4.obj
            boolean r0 = r0 instanceof java.lang.Runnable
            if (r0 == 0) goto L_0x0033
            vu.f r0 = vu.f.c()
            java.lang.Object r4 = r4.obj
            java.lang.Runnable r4 = (java.lang.Runnable) r4
            r0.execute(r4)
        L_0x0033:
            return r1
        L_0x0034:
            java.util.Set<android.os.Handler$Callback> r0 = r3.f23432c
            java.util.Iterator r0 = r0.iterator()
        L_0x003a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x004c
            java.lang.Object r2 = r0.next()
            android.os.Handler$Callback r2 = (android.os.Handler.Callback) r2
            boolean r2 = r2.handleMessage(r4)
            if (r2 == 0) goto L_0x003a
        L_0x004c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: vu.g.handleMessage(android.os.Message):boolean");
    }

    public void i(Runnable runnable) {
        this.f23431b.sendMessage(g(runnable));
    }

    public void j(Handler.Callback callback) {
        this.f23432c.add(callback);
    }

    public void k(int i11) {
        this.f23431b.removeMessages(i11);
    }

    public void l(int i11) {
        this.f23431b.sendEmptyMessage(i11);
    }

    public void n(int i11, long j11) {
        this.f23431b.sendEmptyMessageDelayed(i11, j11);
    }

    public void o(Message message, long j11) {
        this.f23431b.sendMessageDelayed(message, j11);
    }
}
