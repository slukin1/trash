package com.bbc876219.lib.spi.provider.utils;

import android.app.Application;
import androidx.annotation.Keep;
import androidx.fragment.app.FragmentActivity;
import com.bbc876219.lib.spi.provider.service.AppAttachBaseContextService;
import com.bbc876219.lib.spi.provider.service.AppOnCreateService;
import com.bbc876219.lib.spi.provider.service.HomeActivityAttachBaseContextService;
import com.bbc876219.lib.spi.provider.service.InsertMethodHookService;
import com.bbc876219.lib.task.TaskManager;
import com.bbc876219.lib.task.Worker;
import com.bbc876219.lib.zlog.ZLog;
import java.util.List;

@Keep
public class ApplicationHook {
    private static final String TAG = "ApplicationHook";
    public static final int warnCost = 50;

    public static class a extends Worker {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InsertMethodHookService f63216c;

        public a(InsertMethodHookService insertMethodHookService) {
            this.f63216c = insertMethodHookService;
        }

        public void a() {
            this.f63216c.hookBefore((Object) null, (Object[]) null);
        }
    }

    public static class b extends Worker {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InsertMethodHookService f63217c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Object f63218d;

        public b(InsertMethodHookService insertMethodHookService, Object obj) {
            this.f63217c = insertMethodHookService;
            this.f63218d = obj;
        }

        public void a() {
            this.f63217c.hookBefore(this.f63218d, (Object[]) null);
        }
    }

    public static class c extends Worker {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InsertMethodHookService f63219c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Object f63220d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object[] f63221e;

        public c(InsertMethodHookService insertMethodHookService, Object obj, Object[] objArr) {
            this.f63219c = insertMethodHookService;
            this.f63220d = obj;
            this.f63221e = objArr;
        }

        public void a() {
            this.f63219c.hookBefore(this.f63220d, this.f63221e);
        }
    }

    public static class d extends Worker {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InsertMethodHookService f63222c;

        public d(InsertMethodHookService insertMethodHookService) {
            this.f63222c = insertMethodHookService;
        }

        public void a() {
            this.f63222c.hookAfter((Object) null, (Object[]) null);
        }
    }

    public static class e extends Worker {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InsertMethodHookService f63223c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Object f63224d;

        public e(InsertMethodHookService insertMethodHookService, Object obj) {
            this.f63223c = insertMethodHookService;
            this.f63224d = obj;
        }

        public void a() {
            this.f63223c.hookAfter(this.f63224d, (Object[]) null);
        }
    }

    public static class f extends Worker {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ InsertMethodHookService f63225c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Object f63226d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Object[] f63227e;

        public f(InsertMethodHookService insertMethodHookService, Object obj, Object[] objArr) {
            this.f63225c = insertMethodHookService;
            this.f63226d = obj;
            this.f63227e = objArr;
        }

        public void a() {
            this.f63225c.hookAfter(this.f63226d, this.f63227e);
        }
    }

    public static class g extends Worker {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AppAttachBaseContextService f63228c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Application f63229d;

        public g(AppAttachBaseContextService appAttachBaseContextService, Application application) {
            this.f63228c = appAttachBaseContextService;
            this.f63229d = application;
        }

        public void a() {
            this.f63228c.attachBaseContext(this.f63229d);
        }
    }

    public static class h extends Worker {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ AppOnCreateService f63230c;

        public h(AppOnCreateService appOnCreateService) {
            this.f63230c = appOnCreateService;
        }

        public void a() {
            this.f63230c.onCreate();
        }
    }

    public static class i extends Worker {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ HomeActivityAttachBaseContextService f63231c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f63232d;

        public i(HomeActivityAttachBaseContextService homeActivityAttachBaseContextService, FragmentActivity fragmentActivity) {
            this.f63231c = homeActivityAttachBaseContextService;
            this.f63232d = fragmentActivity;
        }

        public void a() {
            this.f63231c.attachBaseContext(this.f63232d);
        }
    }

    public static void hookAHomeActivityAttachBaseContext(FragmentActivity fragmentActivity) {
        long currentTimeMillis = System.currentTimeMillis();
        List<HomeActivityAttachBaseContextService> i11 = com.bbc876219.lib.spi.provider.a.i(HomeActivityAttachBaseContextService.class);
        if (i11 == null || i11.isEmpty()) {
            ZLog.c(TAG, "hookAHomeActivityAttachBaseContext: 没有获取到实现列表");
            return;
        }
        ZLog.b(TAG, "hookAHomeActivityAttachBaseContext() called with:  get  " + i11.size() + " ins");
        for (int i12 = 0; i12 < i11.size(); i12++) {
            HomeActivityAttachBaseContextService homeActivityAttachBaseContextService = i11.get(i12);
            if (homeActivityAttachBaseContextService != null) {
                if (homeActivityAttachBaseContextService.isRunInMainThread()) {
                    homeActivityAttachBaseContextService.attachBaseContext(fragmentActivity);
                } else {
                    TaskManager.f(new i(homeActivityAttachBaseContextService, fragmentActivity));
                }
            }
        }
        statisCost(currentTimeMillis, "hookAHomeActivityAttachBaseContext", i11.size());
    }

    public static void hookAttachBaseContext(Application application) {
        long currentTimeMillis = System.currentTimeMillis();
        List<AppAttachBaseContextService> i11 = com.bbc876219.lib.spi.provider.a.i(AppAttachBaseContextService.class);
        if (i11 == null || i11.isEmpty()) {
            ZLog.c(TAG, "AppAttachBaseContextService.hookAttachBaseContext: 没有获取到实现列表");
            return;
        }
        ZLog.b(TAG, "AppAttachBaseContextService.hookAttachBaseContext() called with:  get  " + i11.size() + " ins");
        for (int i12 = 0; i12 < i11.size(); i12++) {
            ZLog.b(TAG, "AppAttachBaseContextService.hookAttachBaseContext() called with:  " + i11.get(i12));
        }
        for (int i13 = 0; i13 < i11.size(); i13++) {
            AppAttachBaseContextService appAttachBaseContextService = i11.get(i13);
            if (appAttachBaseContextService != null) {
                if (appAttachBaseContextService.isRunInMainThread()) {
                    appAttachBaseContextService.attachBaseContext(application);
                } else {
                    TaskManager.f(new g(appAttachBaseContextService, application));
                }
            }
        }
        statisCost(currentTimeMillis, "AppAttachBaseContextService.hookAttachBaseContext", i11.size());
    }

    public static void hookMethodAfter(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        List<InsertMethodHookService> j11 = com.bbc876219.lib.spi.provider.a.j(InsertMethodHookService.class, str, HookMethodEnum.HOOK_AFTER);
        if (j11 == null || j11.isEmpty()) {
            ZLog.c(TAG, "InsertMethodHookService.hookMethodAfter: 没有获取到实现列表 " + str);
            return;
        }
        ZLog.b(TAG, "InsertMethodHookService.hookMethodBefore() called with: hookpoint = [" + str + "] get  " + j11.size() + " ins");
        for (int i11 = 0; i11 < j11.size(); i11++) {
            InsertMethodHookService insertMethodHookService = j11.get(i11);
            if (insertMethodHookService != null) {
                if (insertMethodHookService.isRunInMainThread()) {
                    insertMethodHookService.hookAfter((Object) null, (Object[]) null);
                } else {
                    TaskManager.f(new d(insertMethodHookService));
                }
            }
        }
        statisCost(currentTimeMillis, "InsertMethodHookService.hookMethodAfter", j11.size());
    }

    public static void hookMethodBefore(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        List<InsertMethodHookService> j11 = com.bbc876219.lib.spi.provider.a.j(InsertMethodHookService.class, str, HookMethodEnum.HOOK_BEFORE);
        if (j11 == null || j11.isEmpty()) {
            ZLog.c(TAG, "InsertMethodHookService.hookMethodBefore: 没有获取到实现实例列表 " + str);
            return;
        }
        ZLog.b(TAG, "InsertMethodHookService.hookMethodBefore() called with: hookpoint = [" + str + "] get  " + j11.size() + " ins");
        for (int i11 = 0; i11 < j11.size(); i11++) {
            InsertMethodHookService insertMethodHookService = j11.get(i11);
            if (insertMethodHookService != null) {
                if (insertMethodHookService.isRunInMainThread()) {
                    insertMethodHookService.hookBefore((Object) null, (Object[]) null);
                } else {
                    TaskManager.f(new a(insertMethodHookService));
                }
            }
        }
        statisCost(currentTimeMillis, "InsertMethodHookService.hookMethodBefore", j11.size());
    }

    public static void hookOnCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        List<AppOnCreateService> i11 = com.bbc876219.lib.spi.provider.a.i(AppOnCreateService.class);
        if (i11 == null || i11.isEmpty()) {
            ZLog.c(TAG, "AppOnCreateService.hookOnCreate: 没有获取到实现列表");
            return;
        }
        ZLog.b(TAG, "AppOnCreateService.hookOnCreate() called with:  get  " + i11.size() + " ins");
        for (int i12 = 0; i12 < i11.size(); i12++) {
            AppOnCreateService appOnCreateService = i11.get(i12);
            if (appOnCreateService != null) {
                if (appOnCreateService.isRunInMainThread()) {
                    appOnCreateService.onCreate();
                } else {
                    TaskManager.f(new h(appOnCreateService));
                }
            }
        }
        statisCost(currentTimeMillis, "AppOnCreateService.hookOnCreate", i11.size());
    }

    private static void statisCost(long j11, String str, int i11) {
        long currentTimeMillis = System.currentTimeMillis() - j11;
        if (currentTimeMillis > 50) {
            ZLog.c(TAG, str + "() called with: cost = " + currentTimeMillis + "  ,hook size = " + i11);
        }
    }

    public static void hookMethodAfter(String str, Object obj) {
        long currentTimeMillis = System.currentTimeMillis();
        List<InsertMethodHookService> j11 = com.bbc876219.lib.spi.provider.a.j(InsertMethodHookService.class, str, HookMethodEnum.HOOK_AFTER);
        if (j11 == null || j11.isEmpty()) {
            ZLog.c(TAG, "InsertMethodHookService.hookMethodAfter: 没有获取到实现列表 " + str);
            return;
        }
        ZLog.b(TAG, "InsertMethodHookService.hookMethodAfter() called with: hookpoint = [" + str + "] get  " + j11.size() + " ins");
        for (int i11 = 0; i11 < j11.size(); i11++) {
            InsertMethodHookService insertMethodHookService = j11.get(i11);
            if (insertMethodHookService != null) {
                if (insertMethodHookService.isRunInMainThread()) {
                    insertMethodHookService.hookAfter(obj, (Object[]) null);
                } else {
                    TaskManager.f(new e(insertMethodHookService, obj));
                }
            }
        }
        statisCost(currentTimeMillis, "InsertMethodHookService.hookMethodAfter", j11.size());
    }

    public static void hookMethodBefore(String str, Object obj) {
        long currentTimeMillis = System.currentTimeMillis();
        List<InsertMethodHookService> j11 = com.bbc876219.lib.spi.provider.a.j(InsertMethodHookService.class, str, HookMethodEnum.HOOK_BEFORE);
        if (j11 == null || j11.isEmpty()) {
            ZLog.c(TAG, "InsertMethodHookService.hookMethodBefore: 没有获取到实现列表 " + str);
            return;
        }
        ZLog.b(TAG, "InsertMethodHookService.hookMethodBefore() called with: hookpoint = [" + str + "] get  " + j11.size() + " ins");
        for (int i11 = 0; i11 < j11.size(); i11++) {
            InsertMethodHookService insertMethodHookService = j11.get(i11);
            if (insertMethodHookService != null) {
                if (insertMethodHookService.isRunInMainThread()) {
                    insertMethodHookService.hookBefore(obj, (Object[]) null);
                } else {
                    TaskManager.f(new b(insertMethodHookService, obj));
                }
            }
        }
        statisCost(currentTimeMillis, "InsertMethodHookService.hookMethodBefore", j11.size());
    }

    public static void hookMethodAfter(String str, Object obj, Object[] objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        List<InsertMethodHookService> j11 = com.bbc876219.lib.spi.provider.a.j(InsertMethodHookService.class, str, HookMethodEnum.HOOK_AFTER);
        if (j11 == null || j11.isEmpty()) {
            ZLog.c(TAG, "InsertMethodHookService.hookMethodAfter: 没有获取到实现列表 " + str);
            return;
        }
        ZLog.b(TAG, "InsertMethodHookService.hookMethodAfter() called with: hookpoint = [" + str + "] get  " + j11.size() + " ins");
        for (int i11 = 0; i11 < j11.size(); i11++) {
            ZLog.b(TAG, "InsertMethodHookService.hookMethodAfter called with:  " + j11.get(i11));
        }
        for (int i12 = 0; i12 < j11.size(); i12++) {
            InsertMethodHookService insertMethodHookService = j11.get(i12);
            if (insertMethodHookService != null) {
                if (insertMethodHookService.isRunInMainThread()) {
                    insertMethodHookService.hookAfter(obj, objArr);
                } else {
                    TaskManager.f(new f(insertMethodHookService, obj, objArr));
                }
            }
        }
        statisCost(currentTimeMillis, "InsertMethodHookService.hookMethodAfter", j11.size());
    }

    public static void hookMethodBefore(String str, Object obj, Object[] objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        List<InsertMethodHookService> j11 = com.bbc876219.lib.spi.provider.a.j(InsertMethodHookService.class, str, HookMethodEnum.HOOK_BEFORE);
        if (j11 == null || j11.isEmpty()) {
            ZLog.c(TAG, "InsertMethodHookService.hookMethodBefore: 没有获取到实现列表 " + str);
            return;
        }
        ZLog.b(TAG, "InsertMethodHookService.hookMethodBefore() called with: hookpoint = [" + str + "] get  " + j11.size() + " ins");
        for (int i11 = 0; i11 < j11.size(); i11++) {
            ZLog.b(TAG, "InsertMethodHookService.hookMethodBefore called with:  " + j11.get(i11));
        }
        for (int i12 = 0; i12 < j11.size(); i12++) {
            InsertMethodHookService insertMethodHookService = j11.get(i12);
            if (insertMethodHookService != null) {
                if (insertMethodHookService.isRunInMainThread()) {
                    insertMethodHookService.hookBefore(obj, objArr);
                } else {
                    TaskManager.f(new c(insertMethodHookService, obj, objArr));
                }
            }
        }
        statisCost(currentTimeMillis, "InsertMethodHookService.hookMethodBefore", j11.size());
    }
}
