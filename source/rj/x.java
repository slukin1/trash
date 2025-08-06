package rj;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.eclipsesource.v8.utils.MemoryManager;
import com.huobi.edgeengine.ability.a0;
import com.huobi.edgeengine.ability.c0;
import com.huobi.edgeengine.ability.d;
import com.huobi.edgeengine.ability.e0;
import com.huobi.edgeengine.ability.f;
import com.huobi.edgeengine.ability.i;
import com.huobi.edgeengine.ability.u;
import com.huobi.edgeengine.debugger.j;
import com.huobi.edgeengine.debugger.l;
import com.huobi.edgeengine.debugger.r;
import com.huobi.edgeengine.debugger.t;
import com.huobi.edgeengine.node.trace.TraceMap;
import com.huobi.edgeengine.node.trace.a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import vj.b;

public class x {

    /* renamed from: a  reason: collision with root package name */
    public V8 f47800a;

    /* renamed from: b  reason: collision with root package name */
    public a f47801b;

    /* renamed from: c  reason: collision with root package name */
    public V8Object f47802c;

    /* renamed from: d  reason: collision with root package name */
    public V8Object f47803d;

    /* renamed from: e  reason: collision with root package name */
    public V8Object f47804e;

    /* renamed from: f  reason: collision with root package name */
    public Handler f47805f;

    /* renamed from: g  reason: collision with root package name */
    public HandlerThread f47806g;

    /* renamed from: h  reason: collision with root package name */
    public Looper f47807h;

    /* renamed from: i  reason: collision with root package name */
    public b f47808i;

    /* renamed from: j  reason: collision with root package name */
    public MemoryManager f47809j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f47810k = false;

    /* renamed from: l  reason: collision with root package name */
    public ExecutorService f47811l;

    /* renamed from: m  reason: collision with root package name */
    public Future<V8> f47812m;

    /* renamed from: n  reason: collision with root package name */
    public u f47813n;

    public x(Context context, b bVar, TraceMap traceMap) {
        HandlerThread handlerThread = new HandlerThread("js_thread");
        this.f47806g = handlerThread;
        handlerThread.start();
        this.f47807h = this.f47806g.getLooper();
        this.f47805f = new Handler(this.f47807h);
        this.f47808i = bVar;
        if (r.f44050a.h()) {
            this.f47805f.post(new s(this, context, traceMap));
            return;
        }
        j jVar = new j(this.f47805f);
        this.f47811l = jVar;
        this.f47812m = t.f44059a.b(jVar, "global", true);
        this.f47811l.submit(new r(this, context, traceMap));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(Context context, TraceMap traceMap) {
        this.f47800a = V8.createV8Runtime();
        j(context, traceMap);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void l(Context context, TraceMap traceMap) {
        try {
            this.f47800a = this.f47812m.get();
            j(context, traceMap);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(b bVar, Object obj) {
        if (obj != null) {
            this.f47808i.r(new v(bVar, obj));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(String str, b bVar) {
        if (!this.f47810k) {
            this.f47801b.v(str, new w(this, bVar));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p() {
        if (!this.f47810k) {
            this.f47810k = true;
            this.f47802c.release();
            this.f47803d.close();
            this.f47804e.close();
            this.f47809j.release();
            h().c();
            this.f47800a.close();
            this.f47806g.quit();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(String str) {
        if (!this.f47810k) {
            try {
                this.f47800a.executeVoidScript(str);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public final u h() {
        if (this.f47813n == null) {
            this.f47813n = new u(this.f47805f);
        }
        return this.f47813n;
    }

    public final void i(TraceMap traceMap) {
        a aVar = new a(this.f47800a, traceMap);
        this.f47801b = aVar;
        this.f47800a.add("rootTraceMap", (V8Value) aVar);
        a0 a0Var = new a0(this.f47800a, this.f47808i);
        this.f47802c = a0Var;
        this.f47800a.add("nativeAPI", (V8Value) a0Var);
        V8 v82 = this.f47800a;
        v82.add("console", (V8Value) new i(v82));
        V8 v83 = this.f47800a;
        v83.add("setInterval", (V8Value) new c0(v83, h()));
        V8 v84 = this.f47800a;
        v84.add("clearInterval", (V8Value) new d(v84, h()));
        V8 v85 = this.f47800a;
        v85.add("setTimeout", (V8Value) new e0(v85));
        com.huobi.edgeengine.ability.r rVar = new com.huobi.edgeengine.ability.r(this.f47800a, new WeakReference(this.f47808i));
        this.f47804e = rVar;
        this.f47800a.add("I18nInternal", (V8Value) rVar);
        f fVar = new f(this.f47800a, new WeakReference(this.f47808i));
        this.f47803d = fVar;
        this.f47800a.add("ColorInternal", (V8Value) fVar);
    }

    public final void j(Context context, TraceMap traceMap) {
        this.f47809j = new MemoryManager(this.f47800a);
        i(traceMap);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open("framework.js")));
            StringBuilder sb2 = new StringBuilder();
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                sb2.append(readLine);
                if (!r.f44050a.h()) {
                    sb2.append("\n");
                }
            }
            String sb3 = sb2.toString();
            l.f44036a.a("framework.js", sb3);
            this.f47800a.executeVoidScript(sb3, "framework.js", 0);
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public void r(Runnable runnable) {
        v(runnable);
    }

    @Deprecated
    public void s(String str, b bVar) {
        v(new u(this, str, bVar));
    }

    public void t() {
        tj.a.f47897a.a();
        v(new q(this));
    }

    public void u(String str) {
        v(new t(this, str));
    }

    public final void v(Runnable runnable) {
        if (Looper.myLooper() == this.f47807h) {
            runnable.run();
        } else if (r.f44050a.h()) {
            this.f47805f.post(runnable);
        } else {
            ExecutorService executorService = this.f47811l;
            if (executorService != null) {
                executorService.submit(runnable);
            }
        }
    }

    public void w(String str, String str2) {
        this.f47800a.executeVoidScript(str, str2, 0);
    }
}
