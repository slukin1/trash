package com.huobi.app.util;

import android.os.Handler;
import bh.j;
import com.huobi.app.HuobiApplicationUtil;
import dh.e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StartAppUtil {

    /* renamed from: a  reason: collision with root package name */
    public static long f42183a;

    /* renamed from: b  reason: collision with root package name */
    public static long f42184b;

    /* renamed from: c  reason: collision with root package name */
    public static long f42185c;

    /* renamed from: d  reason: collision with root package name */
    public static long f42186d;

    /* renamed from: e  reason: collision with root package name */
    public static Handler f42187e = new Handler(j.c().getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    public static boolean f42188f = false;

    /* renamed from: g  reason: collision with root package name */
    public static List<a> f42189g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public static final ExecutorService f42190h = Executors.newSingleThreadExecutor(e.f53634b);

    public interface a {
        void a();
    }

    public static synchronized void b(a aVar) {
        synchronized (StartAppUtil.class) {
            if (aVar != null) {
                f42188f = true;
                aVar.a();
            }
        }
    }

    public static void c(Runnable runnable) {
        f42190h.execute(runnable);
    }

    public static /* synthetic */ Thread d(Runnable runnable) {
        Thread thread = new Thread(runnable, HuobiApplicationUtil.class.getSimpleName() + "-thread-");
        thread.setPriority(10);
        return thread;
    }

    public static synchronized void e() {
        synchronized (StartAppUtil.class) {
            f42188f = true;
            for (a a11 : f42189g) {
                a11.a();
            }
            f42189g.clear();
        }
    }

    public static void f(Runnable runnable) {
        f42187e.post(runnable);
    }
}
