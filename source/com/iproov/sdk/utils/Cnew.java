package com.iproov.sdk.utils;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.iproov.sdk.utils.new  reason: invalid class name */
public class Cnew {

    /* renamed from: com.iproov.sdk.utils.new$do  reason: invalid class name */
    public static /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f2386do;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.iproov.sdk.utils.new$new[] r0 = com.iproov.sdk.utils.Cnew.Cnew.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f2386do = r0
                com.iproov.sdk.utils.new$new r1 = com.iproov.sdk.utils.Cnew.Cnew.RUN_TASK_ONLY_IF_IDLE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f2386do     // Catch:{ NoSuchFieldError -> 0x001d }
                com.iproov.sdk.utils.new$new r1 = com.iproov.sdk.utils.Cnew.Cnew.QUEUE_MAX_ONE_TASK_REPLACING_IF_BUSY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f2386do     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.iproov.sdk.utils.new$new r1 = com.iproov.sdk.utils.Cnew.Cnew.QUEUE_TASKS_FIFO     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.iproov.sdk.utils.Cnew.Cdo.<clinit>():void");
        }
    }

    /* renamed from: com.iproov.sdk.utils.new$for  reason: invalid class name */
    public enum Cfor {
        LOW(1),
        MEDIUM(5),
        HIGH(10);
        

        /* renamed from: do  reason: not valid java name */
        private int f2391do;

        private Cfor(int i11) {
            this.f2391do = i11;
        }

        /* renamed from: do  reason: not valid java name */
        public int m2284do() {
            return this.f2391do;
        }
    }

    /* renamed from: com.iproov.sdk.utils.new$if  reason: invalid class name */
    public static final class Cif implements ThreadFactory {

        /* renamed from: do  reason: not valid java name */
        private String f2392do;

        /* renamed from: if  reason: not valid java name */
        private int f2393if;

        public Cif(String str, int i11) {
            this.f2392do = str;
            this.f2393if = i11;
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f2392do);
            thread.setPriority(this.f2393if);
            return thread;
        }
    }

    /* renamed from: com.iproov.sdk.utils.new$new  reason: invalid class name */
    public enum Cnew {
        RUN_TASK_ONLY_IF_IDLE,
        QUEUE_MAX_ONE_TASK_REPLACING_IF_BUSY,
        QUEUE_TASKS_FIFO
    }

    /* renamed from: do  reason: not valid java name */
    public static ExecutorService m2283do(String str, Cfor forR, Cnew newR) {
        int i11 = Cdo.f2386do[newR.ordinal()];
        if (i11 == 1) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardPolicy());
            threadPoolExecutor.setThreadFactory(new Cif(str, forR.m2284do()));
            return threadPoolExecutor;
        } else if (i11 != 2) {
            return Executors.newSingleThreadExecutor(new Cif(str, forR.m2284do()));
        } else {
            ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(1), new ThreadPoolExecutor.DiscardOldestPolicy());
            threadPoolExecutor2.setThreadFactory(new Cif(str, forR.m2284do()));
            return threadPoolExecutor2;
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static Thread m2282do(String str, Cfor forR, Runnable runnable) {
        return new Cif(str, forR.m2284do()).newThread(runnable);
    }
}
