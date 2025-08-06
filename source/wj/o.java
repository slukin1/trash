package wj;

import com.eclipsesource.v8.JavaCallback;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.huobi.edgeengine.node.trace.TraceArray;
import com.huobi.edgeengine.node.trace.TraceListener;
import com.huobi.edgeengine.node.trace.TraceValueConverter;
import com.huobi.edgeengine.node.trace.error.TraceValueError;
import java.util.ArrayList;
import java.util.List;

public class o extends V8Object implements x, c {

    /* renamed from: b  reason: collision with root package name */
    public TraceArray f48067b;

    public o(V8 v82, TraceArray traceArray) {
        super(v82);
        this.f48067b = traceArray;
        p();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object r(V8Object v8Object, V8Array v8Array) {
        V8Object v8Object2 = new V8Object(this.f64941v8);
        if (v8Array == null || v8Array.length() != 1 || (!(v8Array.get(0) instanceof Integer) && !(v8Array.get(0) instanceof String))) {
            v8Object2.add("success", false);
            v8Object2.add("message", "invalidate params");
            return v8Object2;
        }
        try {
            List<x> d11 = this.f48067b.d();
            Object obj = v8Array.get(0);
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : Integer.parseInt(obj.toString());
            v8Object2.add("success", true);
            if (intValue >= d11.size()) {
                v8Object2.add("type", 0);
                return v8Object2;
            }
            TraceValueConverter.b(this.f64941v8, v8Object2, d11.get(intValue));
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
        if (v8Array == null || v8Array.length() != 2 || !(v8Array.get(0) instanceof String)) {
            v8Object2.add("success", false);
            v8Object2.add("message", "invalidate params");
            return v8Object2;
        }
        try {
            this.f48067b.k(TraceValueConverter.f(this.f64941v8, v8Array.getType(1), v8Array.get(1)), Integer.parseInt(v8Array.getString(0)));
            v8Object2.add("success", true);
            return v8Object2;
        } catch (Throwable th2) {
            v8Object2.add("success", false);
            v8Object2.add("message", th2.getMessage());
            return v8Object2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object t(V8Object v8Object, V8Array v8Array) {
        V8Object v8Object2 = new V8Object(this.f64941v8);
        if (v8Array == null || v8Array.length() == 0 || !(v8Array.get(0) instanceof V8Array) || ((V8Array) v8Array.get(0)).length() == 0) {
            v8Object2.add("success", false);
            v8Object2.add("message", "invalidate params");
            return v8Object2;
        }
        try {
            V8Array array = v8Array.getArray(0);
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < array.length(); i11++) {
                arrayList.add(TraceValueConverter.f(this.f64941v8, array.getType(i11), array.get(i11)));
            }
            this.f48067b.f(arrayList);
            v8Object2.add("success", true);
            return v8Object2;
        } catch (Throwable th2) {
            v8Object2.add("success", false);
            v8Object2.add("message", th2.getMessage());
            return v8Object2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object u(V8Object v8Object, V8Array v8Array) {
        return Integer.valueOf(this.f48067b.d().size());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object v(V8Object v8Object, V8Array v8Array) {
        V8Object v8Object2 = new V8Object(this.f64941v8);
        if (v8Array == null || v8Array.length() != 2 || !(v8Array.get(0) instanceof Integer) || !(v8Array.get(1) instanceof Integer)) {
            v8Object2.add("success", false);
            v8Object2.add("message", "invalidate params");
            return v8Object2;
        }
        int integer = v8Array.getInteger(0);
        int integer2 = v8Array.getInteger(1);
        if (integer2 <= integer) {
            v8Object2.add("success", false);
            v8Object2.add("message", "end less than start!");
            return v8Object2;
        }
        List<x> d11 = this.f48067b.d();
        if (integer < 0 || integer >= d11.size()) {
            v8Object2.add("success", false);
            v8Object2.add("message", "start index out of bounds!");
            return v8Object2;
        } else if (integer2 > d11.size()) {
            v8Object2.add("success", false);
            v8Object2.add("message", "end index out of bounds!");
            return v8Object2;
        } else {
            try {
                V8Array v8Array2 = new V8Array(this.f64941v8);
                while (integer < integer2) {
                    V8Object v8Object3 = new V8Object(this.f64941v8);
                    TraceValueConverter.b(this.f64941v8, v8Object3, d11.get(integer));
                    v8Array2.push((V8Value) v8Object3);
                    integer++;
                }
                v8Object2.add("success", true);
                v8Object2.add("value", (V8Value) v8Array2);
                return v8Object2;
            } catch (Throwable th2) {
                v8Object2.add("success", false);
                v8Object2.add("message", th2.getMessage());
                return v8Object2;
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object w(V8Object v8Object, V8Array v8Array) {
        V8Object v8Object2 = new V8Object(this.f64941v8);
        if (v8Array == null || v8Array.length() != 3 || !(v8Array.get(0) instanceof Integer) || !(v8Array.get(1) instanceof Integer) || !(v8Array.get(2) instanceof V8Array)) {
            v8Object2.add("success", false);
            v8Object2.add("message", "invalidate params");
            return v8Object2;
        }
        int integer = v8Array.getInteger(0);
        int integer2 = v8Array.getInteger(1);
        V8Array array = v8Array.getArray(2);
        List<x> d11 = this.f48067b.d();
        if (integer < 0) {
            integer += d11.size();
            if (integer < 0) {
                integer = 0;
            }
        } else if (integer >= d11.size()) {
            integer = d11.size();
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < v8Array.length(); i11++) {
                arrayList.add(TraceValueConverter.f(this.f64941v8, array.getType(i11), array.get(i11)));
            }
            this.f48067b.i(integer, integer2, arrayList);
            v8Object2.add("success", true);
            v8Object2.add("value", "");
            return v8Object2;
        } catch (Throwable th2) {
            v8Object2.add("success", false);
            v8Object2.add("message", th2.getMessage());
            return v8Object2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object x(V8Object v8Object, V8Array v8Array) {
        V8Object v8Object2 = new V8Object(this.f64941v8);
        try {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < v8Array.length(); i11++) {
                arrayList.add(TraceValueConverter.f(this.f64941v8, v8Array.getType(1), v8Array.get(1)));
            }
            this.f48067b.j(arrayList);
            v8Object2.add("success", true);
            return v8Object2;
        } catch (Throwable th2) {
            v8Object2.add("success", false);
            v8Object2.add("message", th2.getMessage());
            return v8Object2;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object y(V8Object v8Object, V8Array v8Array) {
        V8Object v8Object2 = new V8Object(this.f64941v8);
        v8Object2.add("success", true);
        TraceValueConverter.a("value", v8Object2, TraceValueConverter.d(this.f64941v8, this.f48067b));
        return v8Object2;
    }

    public void a(TraceListener traceListener) throws TraceValueError {
        this.f48067b.a(traceListener);
    }

    public Object b() {
        return this.f48067b.b();
    }

    public void close() {
        super.close();
        this.f48067b.h();
    }

    public int getType() {
        return this.f48067b.getType();
    }

    public TraceArray o() {
        return this.f48067b;
    }

    public final void p() {
        registerJavaMethod((JavaCallback) new i(this), "jsGet");
        registerJavaMethod((JavaCallback) new n(this), "jsSet");
        registerJavaMethod((JavaCallback) new k(this), "jsPush");
        registerJavaMethod((JavaCallback) new g(this), "jsGetLength");
        registerJavaMethod((JavaCallback) new h(this), "jsSlice");
        registerJavaMethod((JavaCallback) new l(this), "jsSplice");
        registerJavaMethod((JavaCallback) new j(this), "jsReset");
        registerJavaMethod((JavaCallback) new m(this), "jsRawArray");
    }
}
