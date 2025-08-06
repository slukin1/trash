package com.huobi.vulcan.core;

import android.os.Handler;
import android.os.HandlerThread;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkHandler implements Handler.Callback, Executor {

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicInteger f20600d = new AtomicInteger(1);

    /* renamed from: e  reason: collision with root package name */
    public static WorkHandler f20601e;

    /* renamed from: f  reason: collision with root package name */
    public static b f20602f = new b();

    /* renamed from: b  reason: collision with root package name */
    public Handler f20603b;

    /* renamed from: c  reason: collision with root package name */
    public Set<Handler.Callback> f20604c = new HashSet();

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
                lu.a.d(r0, r10, r11)
                java.lang.String r10 = "10000"
                java.lang.String r11 = r11.getLocalizedMessage()
                com.huobi.vulcan.utils.ExceptionLogUtil.a(r10, r11)
                java.lang.Class<com.huobi.vulcan.core.WorkHandler> r10 = com.huobi.vulcan.core.WorkHandler.class
                monitor-enter(r10)
                com.huobi.vulcan.core.WorkHandler r11 = com.huobi.vulcan.core.WorkHandler.f20601e     // Catch:{ all -> 0x00cb }
                android.os.Handler r11 = r11.f20603b     // Catch:{ all -> 0x00cb }
                com.huobi.vulcan.core.WorkHandler r0 = com.huobi.vulcan.core.WorkHandler.f20601e     // Catch:{ all -> 0x00cb }
                r0.e()     // Catch:{ all -> 0x00cb }
                if (r11 == 0) goto L_0x00c9
                int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x00cb }
                r1 = 23
                if (r0 < r1) goto L_0x00b3
                android.os.Looper r0 = r11.getLooper()     // Catch:{ Exception -> 0x00ab }
                android.os.MessageQueue r0 = r0.getQueue()     // Catch:{ Exception -> 0x00ab }
                java.lang.Class<android.os.Message> r1 = android.os.Message.class
                java.lang.Class<android.os.MessageQueue> r2 = android.os.MessageQueue.class
                java.lang.String r3 = "mMessages"
                r4 = 1
                java.lang.Object r1 = com.huobi.vulcan.utils.ReflectUtils.a(r1, r2, r3, r0, r4)     // Catch:{ Exception -> 0x00ab }
                android.os.Message r1 = (android.os.Message) r1     // Catch:{ Exception -> 0x00ab }
                if (r1 == 0) goto L_0x00c9
                monitor-enter(r0)     // Catch:{ Exception -> 0x00ab }
                long r2 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x00a8 }
            L_0x006a:
                if (r1 == 0) goto L_0x009b
                android.os.Message r5 = android.os.Message.obtain(r1)     // Catch:{ all -> 0x00a8 }
                com.huobi.vulcan.core.WorkHandler r6 = com.huobi.vulcan.core.WorkHandler.f20601e     // Catch:{ all -> 0x00a8 }
                android.os.Handler r6 = r6.f20603b     // Catch:{ all -> 0x00a8 }
                r5.setTarget(r6)     // Catch:{ all -> 0x00a8 }
                long r6 = r1.getWhen()     // Catch:{ all -> 0x00a8 }
                long r6 = java.lang.Math.max(r2, r6)     // Catch:{ all -> 0x00a8 }
                com.huobi.vulcan.core.WorkHandler r8 = com.huobi.vulcan.core.WorkHandler.f20601e     // Catch:{ all -> 0x00a8 }
                android.os.Handler r8 = r8.f20603b     // Catch:{ all -> 0x00a8 }
                r8.sendMessageAtTime(r5, r6)     // Catch:{ all -> 0x00a8 }
                java.lang.Class<android.os.Message> r5 = android.os.Message.class
                java.lang.Class<android.os.Message> r6 = android.os.Message.class
                java.lang.String r7 = "next"
                java.lang.Object r1 = com.huobi.vulcan.utils.ReflectUtils.a(r5, r6, r7, r1, r4)     // Catch:{ all -> 0x00a8 }
                android.os.Message r1 = (android.os.Message) r1     // Catch:{ all -> 0x00a8 }
                goto L_0x006a
            L_0x009b:
                monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
                r0 = 0
                r11.removeMessages(r0)     // Catch:{ Exception -> 0x00ab }
                android.os.Looper r11 = r11.getLooper()     // Catch:{ Exception -> 0x00ab }
                r11.quitSafely()     // Catch:{ Exception -> 0x00ab }
                goto L_0x00c9
            L_0x00a8:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00a8 }
                throw r11     // Catch:{ Exception -> 0x00ab }
            L_0x00ab:
                java.lang.String r11 = "ZpUncaughtExceptionHandle"
                java.lang.String r0 = "WorkHandler未完成任务迁移失败!!!"
                lu.a.c(r11, r0)     // Catch:{ all -> 0x00cb }
                goto L_0x00c9
            L_0x00b3:
                r1 = 18
                if (r0 < r1) goto L_0x00be
                android.os.Looper r0 = r11.getLooper()     // Catch:{ all -> 0x00cb }
                r0.quitSafely()     // Catch:{ all -> 0x00cb }
            L_0x00be:
                android.os.Looper r11 = r11.getLooper()     // Catch:{ all -> 0x00cb }
                java.lang.Thread r11 = r11.getThread()     // Catch:{ all -> 0x00cb }
                r11.interrupt()     // Catch:{ all -> 0x00cb }
            L_0x00c9:
                monitor-exit(r10)     // Catch:{ all -> 0x00cb }
                return
            L_0x00cb:
                r11 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x00cb }
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.vulcan.core.WorkHandler.b.uncaughtException(java.lang.Thread, java.lang.Throwable):void");
        }
    }

    public WorkHandler() {
        e();
    }

    public static WorkHandler d() {
        WorkHandler workHandler = f20601e;
        if (workHandler == null || workHandler.f20603b == null) {
            synchronized (WorkHandler.class) {
                WorkHandler workHandler2 = f20601e;
                if (workHandler2 == null) {
                    f20601e = new WorkHandler();
                } else if (workHandler2.f20603b == null) {
                    workHandler2.e();
                }
            }
        }
        return f20601e;
    }

    public final void e() {
        HandlerThread handlerThread = new HandlerThread("Vulcan WorkHandler#" + f20600d.getAndIncrement());
        handlerThread.setUncaughtExceptionHandler(f20602f);
        handlerThread.start();
        this.f20603b = new Handler(handlerThread.getLooper(), this);
    }

    public void execute(Runnable runnable) {
        f(runnable);
    }

    public void f(Runnable runnable) {
        this.f20603b.post(runnable);
    }

    public void g(Handler.Callback callback) {
        this.f20604c.add(callback);
    }

    public void h(int i11) {
        this.f20603b.removeMessages(i11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0020 A[LOOP:0: B:1:0x0020->B:4:0x0031, LOOP_START] */
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
            java.lang.String r1 = "Vulcan WorkHandler"
            lu.a.b(r1, r0)
            java.util.Set<android.os.Handler$Callback> r0 = r3.f20604c
            java.util.Iterator r0 = r0.iterator()
        L_0x0020:
            boolean r1 = r0.hasNext()
            r2 = 1
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r0.next()
            android.os.Handler$Callback r1 = (android.os.Handler.Callback) r1
            boolean r1 = r1.handleMessage(r4)
            if (r1 == 0) goto L_0x0020
        L_0x0033:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.vulcan.core.WorkHandler.handleMessage(android.os.Message):boolean");
    }

    public void i(int i11) {
        this.f20603b.sendEmptyMessage(i11);
    }

    public void j(int i11, long j11) {
        this.f20603b.sendEmptyMessageDelayed(i11, j11);
    }
}
