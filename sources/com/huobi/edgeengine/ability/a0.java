package com.huobi.edgeengine.ability;

import android.util.Log;
import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import java.lang.ref.WeakReference;
import rj.b;

public class a0 extends V8Object {

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<b> f43907b;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ V8Function f43908b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f43909c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Object f43910d;

        public a(V8Function v8Function, boolean z11, Object obj) {
            this.f43908b = v8Function;
            this.f43909c = z11;
            this.f43910d = obj;
        }

        public void run() {
            if (!this.f43908b.isReleased()) {
                V8Array v8Array = new V8Array(a0.this.f64941v8);
                v8Array.push(this.f43909c);
                v8Array.push(this.f43910d);
                this.f43908b.call(a0.this, v8Array);
                v8Array.release();
                this.f43908b.release();
            }
        }
    }

    public a0(V8 v82, b bVar) {
        super(v82);
        this.f43907b = new WeakReference<>(bVar);
        registerJavaMethod((JavaCallback) new v(this, v82), "invokeAPI");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void n(b bVar, V8Function v8Function, boolean z11, Object obj) {
        bVar.q(new a(v8Function, z11, obj));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o(V8Function v8Function, boolean z11, Object obj) {
        if (!v8Function.isReleased()) {
            V8Array v8Array = new V8Array(this.f64941v8);
            v8Array.push(z11);
            v8Array.push(obj);
            v8Function.call(this, v8Array);
            v8Array.release();
            v8Function.release();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(b bVar, V8Function v8Function, boolean z11, Object obj) {
        bVar.q(new y(this, v8Function, z11, obj));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(s sVar, b bVar, Object obj, V8Function v8Function) {
        if (sVar != null) {
            sVar.a(bVar, obj, new w(this, bVar, v8Function));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object s(V8 v82, V8Object v8Object, V8Array v8Array) {
        if (v8Array != null && v8Array.length() != 0) {
            return m(v8Array.getString(0), v8Array);
        }
        V8Object v8Object2 = new V8Object(v82);
        v8Object2.add("success", false);
        v8Object2.add("message", "invalidate params!");
        return v8Object2;
    }

    public V8Object m(String str, V8Array v8Array) {
        s sVar;
        s sVar2;
        V8Object v8Object = new V8Object(this.f64941v8);
        b bVar = (b) this.f43907b.get();
        if (bVar == null) {
            sVar2 = null;
        } else {
            try {
                sVar2 = (s) bVar.c(str).newInstance();
            } catch (Throwable th2) {
                Log.e("EdgeEngine", "get ability exception:", th2);
                sVar = null;
            }
        }
        sVar = sVar2;
        if (sVar == null) {
            v8Object.add("success", false);
            v8Object.add("message", "not found ability " + str);
            return null;
        } else if (bVar == null) {
            v8Object.add("success", false);
            v8Object.add("message", "edge engine null!");
            return v8Object;
        } else {
            Object obj = v8Array.get(1);
            V8Function v8Function = (V8Function) v8Array.get(2);
            if (!(sVar instanceof AbstractAbility) || ((AbstractAbility) sVar).b()) {
                bVar.r(new z(this, sVar, bVar, obj, v8Function));
            } else {
                sVar.a(bVar, obj, new x(this, bVar, v8Function));
            }
            v8Object.add("success", true);
            return v8Object;
        }
    }
}
