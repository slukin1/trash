package androidx.test.runner;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import androidx.test.internal.runner.InstrumentationConnection;
import androidx.test.internal.runner.hidden.ExposedInstrumentationApi;
import androidx.test.internal.runner.intent.IntentMonitorImpl;
import androidx.test.internal.runner.intercepting.DefaultInterceptingActivityFactory;
import androidx.test.internal.runner.lifecycle.ActivityLifecycleMonitorImpl;
import androidx.test.internal.runner.lifecycle.ApplicationLifecycleMonitorImpl;
import androidx.test.internal.util.Checks;
import androidx.test.internal.util.ProcSummary;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.runner.intent.IntentMonitorRegistry;
import androidx.test.runner.intercepting.InterceptingActivityFactory;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitor;
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.ApplicationLifecycleMonitorRegistry;
import androidx.test.runner.lifecycle.ApplicationStage;
import androidx.test.runner.lifecycle.Stage;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.Thread;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class MonitoringInstrumentation extends ExposedInstrumentationApi {

    /* renamed from: p  reason: collision with root package name */
    public static final long f11661p;

    /* renamed from: q  reason: collision with root package name */
    public static final long f11662q;

    /* renamed from: a  reason: collision with root package name */
    public ActivityLifecycleMonitorImpl f11663a = new ActivityLifecycleMonitorImpl();

    /* renamed from: b  reason: collision with root package name */
    public ApplicationLifecycleMonitorImpl f11664b = new ApplicationLifecycleMonitorImpl();

    /* renamed from: c  reason: collision with root package name */
    public IntentMonitorImpl f11665c = new IntentMonitorImpl();

    /* renamed from: d  reason: collision with root package name */
    public ExecutorService f11666d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f11667e;

    /* renamed from: f  reason: collision with root package name */
    public AtomicBoolean f11668f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    public AtomicLong f11669g = new AtomicLong(0);

    /* renamed from: h  reason: collision with root package name */
    public AtomicInteger f11670h = new AtomicInteger(0);

    /* renamed from: i  reason: collision with root package name */
    public String f11671i;

    /* renamed from: j  reason: collision with root package name */
    public AtomicBoolean f11672j = new AtomicBoolean(false);

    /* renamed from: k  reason: collision with root package name */
    public volatile Boolean f11673k = null;

    /* renamed from: l  reason: collision with root package name */
    public ThreadLocal<Boolean> f11674l = new ThreadLocal<>();

    /* renamed from: m  reason: collision with root package name */
    public MessageQueue.IdleHandler f11675m = new MessageQueue.IdleHandler() {
        public boolean queueIdle() {
            MonitoringInstrumentation.this.f11669g.set(System.currentTimeMillis());
            return true;
        }
    };

    /* renamed from: n  reason: collision with root package name */
    public volatile boolean f11676n = false;

    /* renamed from: o  reason: collision with root package name */
    public volatile InterceptingActivityFactory f11677o;

    public class ActivityFinisher implements Runnable {
        public ActivityFinisher() {
        }

        public void run() {
            ArrayList<Activity> arrayList = new ArrayList<>();
            Iterator it2 = EnumSet.range(Stage.CREATED, Stage.STOPPED).iterator();
            while (it2.hasNext()) {
                arrayList.addAll(MonitoringInstrumentation.this.f11663a.a((Stage) it2.next()));
            }
            int size = arrayList.size();
            StringBuilder sb2 = new StringBuilder(60);
            sb2.append("Activities that are still in CREATED to STOPPED: ");
            sb2.append(size);
            Log.i("MonitoringInstr", sb2.toString());
            for (Activity activity : arrayList) {
                if (!activity.isFinishing()) {
                    try {
                        String valueOf = String.valueOf(activity);
                        StringBuilder sb3 = new StringBuilder(valueOf.length() + 20);
                        sb3.append("Finishing activity: ");
                        sb3.append(valueOf);
                        Log.i("MonitoringInstr", sb3.toString());
                        activity.finish();
                    } catch (RuntimeException e11) {
                        Log.e("MonitoringInstr", "Failed to finish activity.", e11);
                    }
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(2);
        f11661p = millis;
        f11662q = millis / 40;
    }

    public void callActivityOnCreate(Activity activity, Bundle bundle) {
        this.f11663a.c(Stage.PRE_ON_CREATE, activity);
        super.callActivityOnCreate(activity, bundle);
        this.f11663a.c(Stage.CREATED, activity);
    }

    public void callActivityOnDestroy(Activity activity) {
        super.callActivityOnDestroy(activity);
        this.f11663a.c(Stage.DESTROYED, activity);
    }

    public void callActivityOnPause(Activity activity) {
        super.callActivityOnPause(activity);
        this.f11663a.c(Stage.PAUSED, activity);
    }

    public void callActivityOnRestart(Activity activity) {
        super.callActivityOnRestart(activity);
        this.f11663a.c(Stage.RESTARTED, activity);
    }

    public void callActivityOnResume(Activity activity) {
        super.callActivityOnResume(activity);
        this.f11663a.c(Stage.RESUMED, activity);
    }

    public void callActivityOnStart(Activity activity) {
        this.f11670h.incrementAndGet();
        try {
            super.callActivityOnStart(activity);
            this.f11663a.c(Stage.STARTED, activity);
        } catch (RuntimeException e11) {
            this.f11670h.decrementAndGet();
            throw e11;
        }
    }

    public void callActivityOnStop(Activity activity) {
        try {
            super.callActivityOnStop(activity);
            this.f11663a.c(Stage.STOPPED, activity);
        } finally {
            this.f11670h.decrementAndGet();
        }
    }

    public void callApplicationOnCreate(Application application) {
        this.f11664b.b(application, ApplicationStage.PRE_ON_CREATE);
        super.callApplicationOnCreate(application);
        this.f11664b.b(application, ApplicationStage.CREATED);
    }

    public void f(String str) {
        Log.e("THREAD_STATE", h());
    }

    public void finish(int i11, Bundle bundle) {
        if (this.f11676n) {
            Log.w("MonitoringInstr", "finish called 2x!");
            return;
        }
        this.f11676n = true;
        this.f11667e.post(new ActivityFinisher());
        long currentTimeMillis = System.currentTimeMillis();
        v();
        Log.i("MonitoringInstr", String.format("waitForActivitiesToComplete() took: %sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
        ActivityLifecycleMonitorRegistry.b((ActivityLifecycleMonitor) null);
        super.finish(i11, bundle);
    }

    public final List<String> g() {
        if (Build.VERSION.SDK_INT < 26) {
            return Collections.emptyList();
        }
        try {
            String str = getContext().getPackageManager().getInstrumentationInfo(getComponentName(), 0).targetProcesses;
            if (str == null) {
                str = "";
            }
            String trim = str.trim();
            if (trim.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String trim2 : trim.split(Constants.ACCEPT_TIME_SEPARATOR_SP, -1)) {
                String trim3 = trim2.trim();
                if (trim3.length() > 0) {
                    arrayList.add(trim3);
                }
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e11) {
            String valueOf = String.valueOf(getComponentName());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 25);
            sb2.append("Cannot locate ourselves: ");
            sb2.append(valueOf);
            Log.wtf("MonitoringInstr", sb2.toString(), e11);
            String valueOf2 = String.valueOf(getComponentName());
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 25);
            sb3.append("Cannot locate ourselves: ");
            sb3.append(valueOf2);
            throw new IllegalStateException(sb3.toString(), e11);
        }
    }

    public String h() {
        Set<Map.Entry<Thread, StackTraceElement[]>> entrySet = Thread.getAllStackTraces().entrySet();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry next : entrySet) {
            StringBuilder sb3 = new StringBuilder("  ");
            sb3.append(next.getKey());
            sb3.append("\n");
            for (StackTraceElement stackTraceElement : (StackTraceElement[]) next.getValue()) {
                sb3.append("    ");
                sb3.append(stackTraceElement.toString());
                sb3.append("\n");
            }
            sb3.append("\n");
            sb2.append(sb3.toString());
        }
        return sb2.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0045, code lost:
        throw new java.lang.RuntimeException("multidex is available at runtime, but calling it failed.", r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004b, code lost:
        throw new java.lang.RuntimeException("multidex is available at runtime, but calling it failed.", r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        android.util.Log.i("MonitoringInstr", "No multidex.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0036, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003a */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[ExcHandler: ClassNotFoundException (unused java.lang.ClassNotFoundException), SYNTHETIC, Splitter:B:3:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0036 A[ExcHandler: IllegalAccessException (r1v2 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:3:0x000e] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0038 A[ExcHandler: InvocationTargetException (r1v1 'e' java.lang.reflect.InvocationTargetException A[CUSTOM_DECLARE]), Splitter:B:3:0x000e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i() {
        /*
            r10 = this;
            java.lang.String r0 = "multidex is available at runtime, but calling it failed."
            java.lang.String r1 = "No multidex."
            java.lang.String r2 = "MonitoringInstr"
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r3 >= r4) goto L_0x0053
            java.lang.Class<androidx.multidex.a> r3 = androidx.multidex.a.class
            java.util.Set<java.io.File> r4 = androidx.multidex.a.f10205a     // Catch:{ ClassNotFoundException -> 0x0050, NoSuchMethodException -> 0x003e, InvocationTargetException -> 0x0038, IllegalAccessException -> 0x0036 }
            java.lang.String r4 = "installInstrumentation"
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x003a, ClassNotFoundException -> 0x0050, InvocationTargetException -> 0x0038, IllegalAccessException -> 0x0036 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r8 = 0
            r6[r8] = r7     // Catch:{ NoSuchMethodException -> 0x003a, ClassNotFoundException -> 0x0050, InvocationTargetException -> 0x0038, IllegalAccessException -> 0x0036 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r9 = 1
            r6[r9] = r7     // Catch:{ NoSuchMethodException -> 0x003a, ClassNotFoundException -> 0x0050, InvocationTargetException -> 0x0038, IllegalAccessException -> 0x0036 }
            java.lang.reflect.Method r4 = r3.getDeclaredMethod(r4, r6)     // Catch:{ NoSuchMethodException -> 0x003a, ClassNotFoundException -> 0x0050, InvocationTargetException -> 0x0038, IllegalAccessException -> 0x0036 }
            r6 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ NoSuchMethodException -> 0x003a, ClassNotFoundException -> 0x0050, InvocationTargetException -> 0x0038, IllegalAccessException -> 0x0036 }
            android.content.Context r7 = r10.getContext()     // Catch:{ NoSuchMethodException -> 0x003a, ClassNotFoundException -> 0x0050, InvocationTargetException -> 0x0038, IllegalAccessException -> 0x0036 }
            r5[r8] = r7     // Catch:{ NoSuchMethodException -> 0x003a, ClassNotFoundException -> 0x0050, InvocationTargetException -> 0x0038, IllegalAccessException -> 0x0036 }
            android.content.Context r7 = r10.getTargetContext()     // Catch:{ NoSuchMethodException -> 0x003a, ClassNotFoundException -> 0x0050, InvocationTargetException -> 0x0038, IllegalAccessException -> 0x0036 }
            r5[r9] = r7     // Catch:{ NoSuchMethodException -> 0x003a, ClassNotFoundException -> 0x0050, InvocationTargetException -> 0x0038, IllegalAccessException -> 0x0036 }
            r4.invoke(r6, r5)     // Catch:{ NoSuchMethodException -> 0x003a, ClassNotFoundException -> 0x0050, InvocationTargetException -> 0x0038, IllegalAccessException -> 0x0036 }
            goto L_0x0053
        L_0x0036:
            r1 = move-exception
            goto L_0x0040
        L_0x0038:
            r1 = move-exception
            goto L_0x0046
        L_0x003a:
            r10.j(r3)     // Catch:{ ClassNotFoundException -> 0x0050, NoSuchMethodException -> 0x003e, InvocationTargetException -> 0x0038, IllegalAccessException -> 0x0036 }
            goto L_0x0053
        L_0x003e:
            r0 = move-exception
            goto L_0x004c
        L_0x0040:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r0, r1)
            throw r2
        L_0x0046:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r0, r1)
            throw r2
        L_0x004c:
            android.util.Log.i(r2, r1, r0)
            goto L_0x0053
        L_0x0050:
            android.util.Log.i(r2, r1)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.runner.MonitoringInstrumentation.i():void");
    }

    public void j(Class<?> cls) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        cls.getDeclaredMethod("install", new Class[]{Context.class}).invoke((Object) null, new Object[]{getTargetContext()});
    }

    public final boolean k(String str, ProcSummary procSummary) {
        int length = str.length();
        int length2 = procSummary.f11613e.length();
        if (length == length2) {
            return str.equals(procSummary.f11613e);
        }
        if (length < length2 || !str.startsWith(procSummary.f11613e) || !str.endsWith(procSummary.f11609a)) {
            return false;
        }
        String valueOf = String.valueOf(procSummary);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 165 + str.length());
        sb2.append("Use smaller processNames in AndroidManifest.xml. Long names are truncated. This process's cmdline is a prefix of the processName and suffix of comm - assuming: ");
        sb2.append(valueOf);
        sb2.append(" is: ");
        sb2.append(str);
        Log.w("MonitoringInstr", sb2.toString());
        return true;
    }

    public final boolean l() {
        Boolean bool = this.f11673k;
        if (bool == null) {
            bool = Boolean.valueOf(m());
            this.f11673k = bool;
        }
        return bool.booleanValue();
    }

    public final boolean m() {
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        List<String> g11 = g();
        if (g11.isEmpty()) {
            return true;
        }
        boolean equals = "*".equals(g11.get(0));
        if (g11.size() == 1 && !equals) {
            return true;
        }
        try {
            ProcSummary c11 = ProcSummary.c("self");
            if (!equals) {
                return k(g11.get(0), c11);
            }
            String str = getTargetContext().getApplicationInfo().processName;
            if (str == null) {
                str = getTargetContext().getPackageName();
            }
            return k(str, c11);
        } catch (ProcSummary.SummaryException e11) {
            Log.w("MonitoringInstr", "Could not list apps for this user, running in sandbox? Assuming primary", e11);
            return false;
        }
    }

    public final boolean n() {
        return l();
    }

    public Activity newActivity(Class<?> cls, Context context, IBinder iBinder, Application application, Intent intent, ActivityInfo activityInfo, CharSequence charSequence, Activity activity, String str, Object obj) throws InstantiationException, IllegalAccessException {
        String name = cls.getPackage().getName();
        String packageName = context.getPackageName();
        ComponentName component = intent.getComponent();
        if (!packageName.equals(component.getPackageName()) && name.equals(component.getPackageName())) {
            intent.setComponent(new ComponentName(packageName, component.getClassName()));
        }
        return super.newActivity(cls, context, iBinder, application, intent, activityInfo, charSequence, activity, str, obj);
    }

    @Deprecated
    public boolean o(String str) {
        return n();
    }

    public void onCreate(Bundle bundle) {
        Log.i("MonitoringInstr", "Instrumentation started!");
        p();
        i();
        InstrumentationRegistry.b(this, bundle);
        androidx.test.InstrumentationRegistry.c(this, bundle);
        ActivityLifecycleMonitorRegistry.b(this.f11663a);
        ApplicationLifecycleMonitorRegistry.b(this.f11664b);
        IntentMonitorRegistry.a(this.f11665c);
        this.f11667e = new Handler(Looper.getMainLooper());
        this.f11666d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory(this) {
            public Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName(MonitoringInstrumentation.class.getSimpleName());
                return newThread;
            }
        });
        Looper.myQueue().addIdleHandler(this.f11675m);
        super.onCreate(bundle);
        s();
        r();
        u();
    }

    public void onDestroy() {
        Log.i("MonitoringInstr", "Instrumentation Finished!");
        Looper.myQueue().removeIdleHandler(this.f11675m);
        InstrumentationConnection.e().h();
        super.onDestroy();
    }

    public boolean onException(Object obj, Throwable th2) {
        Log.e("MonitoringInstr", String.format("Exception encountered by: %s. Dumping thread state to outputs and pining for the fjords.", new Object[]{obj}), th2);
        f("ThreadState-onException.txt");
        Log.e("MonitoringInstr", "Dying now...");
        return super.onException(obj, th2);
    }

    public void onStart() {
        super.onStart();
        String str = this.f11671i;
        if (str != null) {
            t(str);
        }
        waitForIdleSync();
        r();
        InstrumentationConnection.e().f(this, new ActivityFinisher());
    }

    public final void p() {
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.currentThread().getUncaughtExceptionHandler();
        Thread.currentThread().setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable th2) {
                MonitoringInstrumentation.this.onException(thread, th2);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = uncaughtExceptionHandler;
                if (uncaughtExceptionHandler != null) {
                    Log.w("MonitoringInstr", String.format("Invoking uncaught exception handler %s (a %s)", new Object[]{uncaughtExceptionHandler, uncaughtExceptionHandler.getClass()}));
                    uncaughtExceptionHandler.uncaughtException(thread, th2);
                } else {
                    String valueOf = String.valueOf(thread.getName());
                    Log.w("MonitoringInstr", valueOf.length() != 0 ? "Invoking uncaught exception handler for thread: ".concat(valueOf) : new String("Invoking uncaught exception handler for thread: "));
                    thread.getThreadGroup().uncaughtException(thread, th2);
                }
                if (!"robolectric".equals(Build.FINGERPRINT) && Looper.getMainLooper().getThread().equals(thread)) {
                    Log.e("MonitoringInstr", "The main thread has died and the handlers didn't care, exiting");
                    System.exit(-10);
                }
            }
        });
    }

    public final void q(String str) {
        Objects.requireNonNull(str, "JsBridge class name cannot be null!");
        if (!this.f11672j.get()) {
            this.f11671i = str;
            return;
        }
        throw new IllegalStateException("JsBridge is already loaded!");
    }

    public final void r() {
        Boolean bool = Boolean.TRUE;
        if (!bool.equals(this.f11674l.get())) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            ClassLoader classLoader = getTargetContext().getClassLoader();
            Log.i("MonitoringInstr", String.format("Setting context classloader to '%s', Original: '%s'", new Object[]{classLoader.toString(), contextClassLoader.toString()}));
            Thread.currentThread().setContextClassLoader(classLoader);
            this.f11674l.set(bool);
        }
    }

    public void s() {
        System.getProperties().put("dexmaker.dexcache", getTargetContext().getDir("dxmaker_cache", 0).getAbsolutePath());
    }

    public Activity startActivitySync(final Intent intent) {
        Checks.a();
        long j11 = this.f11669g.get();
        if (this.f11668f.compareAndSet(false, true)) {
            intent.addFlags(67108864);
        }
        Future submit = this.f11666d.submit(new Callable<Activity>() {
            /* renamed from: a */
            public Activity call() {
                return MonitoringInstrumentation.super.startActivitySync(intent);
            }
        });
        try {
            return (Activity) submit.get(45, TimeUnit.SECONDS);
        } catch (TimeoutException unused) {
            f("ThreadState-startActivityTimeout.txt");
            submit.cancel(true);
            throw new RuntimeException(String.format("Could not launch intent %s within %s seconds. Perhaps the main thread has not gone idle within a reasonable amount of time? There could be an animation or something constantly repainting the screen. Or the activity is doing network calls on creation? See the threaddump logs. For your reference the last time the event queue was idle before your activity launch request was %s and now the last time the queue went idle was: %s. If these numbers are the same your activity might be hogging the event queue.", new Object[]{intent, 45, Long.valueOf(j11), Long.valueOf(this.f11669g.get())}));
        } catch (ExecutionException e11) {
            throw new RuntimeException("Could not launch activity", e11.getCause());
        } catch (InterruptedException e12) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("interrupted", e12);
        }
    }

    public final void t(final String str) {
        Objects.requireNonNull(str, "JsBridge class name cannot be null!");
        runOnMainSync(new Runnable() {
            public void run() {
                try {
                    Class.forName(str).getDeclaredMethod("installBridge", new Class[0]).invoke((Object) null, new Object[0]);
                    MonitoringInstrumentation.this.f11672j.set(true);
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    Log.i("MonitoringInstr", "No JSBridge.");
                } catch (IllegalAccessException | InvocationTargetException e11) {
                    throw new RuntimeException("JSbridge is available at runtime, but calling it failed.", e11);
                }
            }
        });
    }

    public void u() {
        this.f11677o = new DefaultInterceptingActivityFactory();
    }

    public void v() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            long currentTimeMillis = System.currentTimeMillis() + f11661p;
            int i11 = this.f11670h.get();
            while (i11 > 0 && System.currentTimeMillis() < currentTimeMillis) {
                try {
                    StringBuilder sb2 = new StringBuilder(37);
                    sb2.append("Unstopped activity count: ");
                    sb2.append(i11);
                    Log.i("MonitoringInstr", sb2.toString());
                    Thread.sleep(f11662q);
                    i11 = this.f11670h.get();
                } catch (InterruptedException e11) {
                    Log.i("MonitoringInstr", "Abandoning activity wait due to interruption.", e11);
                }
            }
            if (i11 > 0) {
                f("ThreadState-unstopped.txt");
                Log.w("MonitoringInstr", String.format("Still %s activities active after waiting %s ms.", new Object[]{Integer.valueOf(i11), Long.valueOf(f11661p)}));
                return;
            }
            return;
        }
        throw new IllegalStateException("Cannot be called from main thread!");
    }

    public Activity newActivity(ClassLoader classLoader, String str, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        if (this.f11677o.a(classLoader, str, intent)) {
            return this.f11677o.b(classLoader, str, intent);
        }
        return super.newActivity(classLoader, str, intent);
    }
}
