package com.huobi.edgeengine.debugger;

import android.content.Context;
import com.facebook.stetho.InspectorModulesProvider;
import com.facebook.stetho.Stetho;
import com.facebook.stetho.inspector.console.RuntimeReplFactory;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.module.Debugger;
import com.facebook.stetho.inspector.protocol.module.Runtime;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.x;
import tj.c;

@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b6\u00107J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J*\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0007J(\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\b\u0010\u0018\u001a\u00020\u0006H\u0002J(\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002R\u0018\u0010 \u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010!R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010$R\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\"\u0010-\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R*\u00105\u001a\u00020.2\u0006\u0010/\u001a\u00020.8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0017\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/huobi/edgeengine/debugger/r;", "", "Landroid/content/Context;", "context", "", "isRelease", "", "m", "Lcom/huobi/edgeengine/debugger/p;", "scriptSourceProvider", "l", "Lcom/facebook/stetho/InspectorModulesProvider;", "d", "Lcom/huobi/edgeengine/debugger/V8Messenger;", "v8Messenger", "Ljava/util/concurrent/ExecutorService;", "v8Executor", "n", "Lcom/facebook/stetho/inspector/console/RuntimeReplFactory;", "factory", "", "Lcom/facebook/stetho/inspector/protocol/ChromeDevtoolsDomain;", "i", "g", "c", "Lcom/huobi/edgeengine/debugger/Debugger;", "chromeDebugger", "Lcom/huobi/edgeengine/debugger/n;", "chromeRuntime", "b", "f", "Lcom/huobi/edgeengine/debugger/Debugger;", "debugger", "Lcom/huobi/edgeengine/debugger/n;", "runtime", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "v8MessengerRef", "e", "v8ExecutorRef", "Z", "h", "()Z", "setIS_PROJECT_RELEASE", "(Z)V", "IS_PROJECT_RELEASE", "", "value", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "setScriptsPathPrefix", "(Ljava/lang/String;)V", "scriptsPathPrefix", "<init>", "()V", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
public final class r {

    /* renamed from: a  reason: collision with root package name */
    public static final r f44050a = new r();

    /* renamed from: b  reason: collision with root package name */
    public static Debugger f44051b;

    /* renamed from: c  reason: collision with root package name */
    public static n f44052c;

    /* renamed from: d  reason: collision with root package name */
    public static WeakReference<V8Messenger> f44053d;

    /* renamed from: e  reason: collision with root package name */
    public static WeakReference<ExecutorService> f44054e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f44055f;

    /* renamed from: g  reason: collision with root package name */
    public static String f44056g = "";

    @Metadata(bv = {}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"com/huobi/edgeengine/debugger/r$a", "Lcom/huobi/edgeengine/debugger/p;", "", "scriptId", "a", "", "b", "()Ljava/util/Collection;", "allScriptIds", "edgeengine_release"}, k = 1, mv = {1, 5, 1})
    public static final class a implements p {
        public String a(String str) {
            return l.f44036a.b(str);
        }

        public Collection<String> b() {
            return l.f44036a.c();
        }
    }

    public static final InspectorModulesProvider d(Context context, p pVar) {
        return new q(context, pVar);
    }

    public static final Iterable e(Context context, p pVar) {
        return j(f44050a, context, pVar, (RuntimeReplFactory) null, 4, (Object) null);
    }

    public static /* synthetic */ Iterable j(r rVar, Context context, p pVar, RuntimeReplFactory runtimeReplFactory, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            runtimeReplFactory = null;
        }
        return rVar.i(context, pVar, runtimeReplFactory);
    }

    public static final void l(Context context, p pVar) {
        Stetho.initialize(Stetho.newInitializerBuilder(context).enableDumpapp(Stetho.defaultDumperPluginsProvider(context)).enableWebKitInspector(d(context, pVar)).build());
    }

    public static final void m(Context context, boolean z11) {
        f44055f = z11;
        if (!z11) {
            l(context, new a());
        }
    }

    public static final void n(V8Messenger v8Messenger, ExecutorService executorService) {
        r rVar = f44050a;
        f44053d = new WeakReference<>(v8Messenger);
        f44054e = new WeakReference<>(executorService);
        rVar.c();
    }

    public final void b(Debugger debugger, n nVar, ExecutorService executorService, V8Messenger v8Messenger) {
        debugger.j(executorService, v8Messenger);
        nVar.a(v8Messenger);
    }

    public final void c() {
        WeakReference<V8Messenger> weakReference = f44053d;
        ExecutorService executorService = null;
        V8Messenger v8Messenger = weakReference == null ? null : (V8Messenger) weakReference.get();
        WeakReference<ExecutorService> weakReference2 = f44054e;
        if (weakReference2 != null) {
            executorService = (ExecutorService) weakReference2.get();
        }
        Debugger debugger = f44051b;
        boolean z11 = (debugger == null || f44052c == null) ? false : true;
        if (v8Messenger != null && executorService != null && z11) {
            b(debugger, f44052c, executorService, v8Messenger);
        }
    }

    public final Iterable<ChromeDevtoolsDomain> f(Context context, RuntimeReplFactory runtimeReplFactory) {
        return new Stetho.DefaultInspectorModulesBuilder(context).runtimeRepl(runtimeReplFactory).finish();
    }

    public final Iterable<ChromeDevtoolsDomain> g(Context context, p pVar, RuntimeReplFactory runtimeReplFactory) {
        Iterable<ChromeDevtoolsDomain> f11 = f(context, runtimeReplFactory);
        ArrayList arrayList = new ArrayList();
        for (ChromeDevtoolsDomain next : f11) {
            if (!x.b(Reflection.b(Debugger.class), Reflection.b(next.getClass())) && !x.b(Reflection.b(Runtime.class), Reflection.b(next.getClass()))) {
                arrayList.add(next);
            }
        }
        f44051b = new Debugger(pVar);
        f44052c = new n(runtimeReplFactory);
        arrayList.add(f44051b);
        arrayList.add(f44052c);
        c();
        return arrayList;
    }

    public final boolean h() {
        return f44055f;
    }

    public final Iterable<ChromeDevtoolsDomain> i(Context context, p pVar, RuntimeReplFactory runtimeReplFactory) {
        try {
            return g(context, pVar, runtimeReplFactory);
        } catch (Throwable th2) {
            c.a().b("Debugger", "Unable to init Stetho with V8 Debugger. Default set-up will be used", th2);
            return f(context, runtimeReplFactory);
        }
    }

    public final String k() {
        return f44056g;
    }
}
