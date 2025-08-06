package com.huobi.edgeengine.node.trace;

import android.util.Log;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.huobi.edgeengine.node.trace.TraceMap;
import com.huobi.edgeengine.node.trace.error.TraceValueError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import wj.c;
import wj.p;
import wj.q;
import wj.r;
import wj.s;
import wj.t;
import wj.u;
import wj.x;

public class a extends V8Object implements x, c {

    /* renamed from: b  reason: collision with root package name */
    public TraceMap f44068b;

    public a(V8 v82, TraceMap traceMap) {
        super(v82);
        this.f44068b = traceMap;
        n();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object o(V8Object v8Object, V8Array v8Array) {
        V8Object v8Object2 = new V8Object(this.f64941v8);
        if (v8Array == null || v8Array.length() != 3 || !(v8Array.get(0) instanceof String) || !(v8Array.get(2) instanceof String)) {
            v8Object2.add("success", false);
            v8Object2.add("message", "invalidate params");
            return v8Object2;
        }
        String string = v8Array.getString(0);
        String string2 = v8Array.getString(2);
        try {
            this.f44068b.o(TraceValueConverter.f(this.f64941v8, v8Array.getType(1), v8Array.get(1)), string2, Collections.singletonList(string));
        } catch (TraceValueError e11) {
            Log.e("EdgeEngine", "jsSet exception: " + e11.getMessage());
        } catch (Throwable th2) {
            v8Object2.add("success", false);
            v8Object2.add("message", th2.getMessage());
            return v8Object2;
        }
        v8Object2.add("success", true);
        return v8Object2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object p(V8Object v8Object, V8Array v8Array) {
        V8Object v8Object2 = new V8Object(this.f64941v8);
        if (v8Array == null || v8Array.length() != 2 || !(v8Array.get(0) instanceof String) || !(v8Array.get(1) instanceof String)) {
            v8Object2.add("success", false);
            v8Object2.add("message", "invalidate params");
            return v8Object2;
        }
        try {
            this.f44068b.o((x) null, v8Array.getString(1), Collections.singletonList(v8Array.getString(0)));
        } catch (TraceValueError e11) {
            Log.e("EdgeEngine", "jsDelete exception: " + e11.getMessage());
        } catch (Throwable th2) {
            v8Object2.add("success", false);
            v8Object2.add("message", th2.getMessage());
            return v8Object2;
        }
        v8Object2.add("success", true);
        return v8Object2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object r(V8Object v8Object, V8Array v8Array) {
        V8Object v8Object2 = new V8Object(this.f64941v8);
        if (v8Array == null || v8Array.length() != 2 || !(v8Array.get(0) instanceof String) || !(v8Array.get(1) instanceof String)) {
            v8Object2.add("success", false);
            v8Object2.add("message", "invalidate params");
            return v8Object2;
        }
        try {
            x g11 = this.f44068b.g(v8Array.getString(1), new ArrayList(Arrays.asList(new String[]{v8Array.getString(0)})));
            if (g11 != null) {
                v8Object2.add("success", true);
                TraceValueConverter.b(this.f64941v8, v8Object2, g11);
                return v8Object2;
            }
            v8Object2.add("success", false);
            v8Object2.add("type", 0);
            return v8Object2;
        } catch (Throwable th2) {
            v8Object2.add("success", false);
            v8Object2.add("message", th2.getMessage());
            return v8Object2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object s(V8Object v8Object, V8Array v8Array) {
        V8Object v8Object2 = new V8Object(this.f64941v8);
        v8Object2.add("success", true);
        TraceValueConverter.a("value", v8Object2, TraceValueConverter.d(this.f64941v8, this.f44068b));
        return v8Object2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object t(V8Object v8Object, V8Array v8Array) {
        try {
            Map<String, Object> e11 = this.f44068b.b();
            V8Array v8Array2 = new V8Array(this.f64941v8);
            for (String push : e11.keySet()) {
                v8Array2.push(push);
            }
            return v8Array2;
        } catch (Throwable th2) {
            Log.e("EdgeEngine", th2.getMessage(), th2);
            return new V8Array(this.f64941v8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object u(V8Object v8Object, V8Array v8Array) {
        try {
            Map<String, Object> e11 = this.f44068b.b();
            V8Array v8Array2 = new V8Array(this.f64941v8);
            for (String f11 : e11.keySet()) {
                v8Array2.push(TraceValueConverter.d(this.f64941v8, this.f44068b.f(f11)));
            }
            return v8Array2;
        } catch (Throwable th2) {
            Log.e("EdgeEngine", th2.getMessage(), th2);
            return new V8Array(this.f64941v8);
        }
    }

    public void a(TraceListener traceListener) throws TraceValueError {
        this.f44068b.a(traceListener);
    }

    public Object b() {
        return this.f44068b.b();
    }

    public void close() {
        super.close();
        this.f44068b.c();
    }

    public int getType() {
        return this.f44068b.getType();
    }

    public TraceMap m() {
        return this.f44068b;
    }

    public final void n() {
        registerJavaMethod((JavaCallback) new t(this), "jsSet");
        registerJavaMethod((JavaCallback) new r(this), "jsDelete");
        registerJavaMethod((JavaCallback) new p(this), "jsGet");
        registerJavaMethod((JavaCallback) new u(this), "jsRawObject");
        registerJavaMethod((JavaCallback) new s(this), "jsKeys");
        registerJavaMethod((JavaCallback) new q(this), "jsValues");
    }

    public TraceMap.a v(String str, vj.a aVar) {
        return this.f44068b.i(str, aVar);
    }
}
