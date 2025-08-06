package com.nostra13.universalimageloader.core;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.deque.LIFOLinkedBlockingDeque;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import kx.b;
import vx.c;
import vx.e;

public class DefaultConfigurationFactory {

    public static class a implements ThreadFactory {

        /* renamed from: f  reason: collision with root package name */
        public static final AtomicInteger f28288f = new AtomicInteger(1);

        /* renamed from: b  reason: collision with root package name */
        public final ThreadGroup f28289b;

        /* renamed from: c  reason: collision with root package name */
        public final AtomicInteger f28290c = new AtomicInteger(1);

        /* renamed from: d  reason: collision with root package name */
        public final String f28291d;

        /* renamed from: e  reason: collision with root package name */
        public final int f28292e;

        public a(int i11, String str) {
            this.f28292e = i11;
            this.f28289b = Thread.currentThread().getThreadGroup();
            this.f28291d = str + f28288f.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.f28289b;
            Thread thread = new Thread(threadGroup, runnable, this.f28291d + this.f28290c.getAndIncrement(), 0);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.f28292e);
            return thread;
        }
    }

    public static qx.a a() {
        return new SimpleBitmapDisplayer();
    }

    public static ix.a b(Context context, lx.a aVar, long j11, int i11) {
        File h11 = h(context);
        if (j11 > 0 || i11 > 0) {
            try {
                return new b(e.d(context), h11, aVar, j11, i11);
            } catch (IOException e11) {
                c.c(e11);
            }
        }
        return new jx.b(e.a(context), h11, aVar);
    }

    public static Executor c(int i11, int i12, QueueProcessingType queueProcessingType) {
        return new ThreadPoolExecutor(i11, i11, 0, TimeUnit.MILLISECONDS, queueProcessingType == QueueProcessingType.LIFO ? new LIFOLinkedBlockingDeque() : new LinkedBlockingQueue(), j(i12, "uil-pool-"));
    }

    public static lx.a d() {
        return new HashCodeFileNameGenerator();
    }

    public static px.b e(boolean z11) {
        return new px.a(z11);
    }

    public static ImageDownloader f(Context context) {
        return new com.nostra13.universalimageloader.core.download.a(context);
    }

    public static mx.a g(Context context, int i11) {
        if (i11 == 0) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int memoryClass = activityManager.getMemoryClass();
            if (l() && m(context)) {
                memoryClass = k(activityManager);
            }
            i11 = (memoryClass * 1048576) / 8;
        }
        return new nx.b(i11);
    }

    public static File h(Context context) {
        File b11 = e.b(context, false);
        File file = new File(b11, "uil-images");
        return (file.exists() || file.mkdir()) ? file : b11;
    }

    public static Executor i() {
        return Executors.newCachedThreadPool(j(5, "uil-pool-d-"));
    }

    public static ThreadFactory j(int i11, String str) {
        return new a(i11, str);
    }

    @TargetApi(11)
    public static int k(ActivityManager activityManager) {
        return activityManager.getLargeMemoryClass();
    }

    public static boolean l() {
        return Build.VERSION.SDK_INT >= 11;
    }

    @TargetApi(11)
    public static boolean m(Context context) {
        return (context.getApplicationInfo().flags & 1048576) != 0;
    }
}
