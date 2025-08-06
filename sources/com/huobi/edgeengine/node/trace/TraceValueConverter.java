package com.huobi.edgeengine.node.trace;

import android.util.Log;
import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8Value;
import com.huobi.edgeengine.node.trace.error.TraceValueError;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import wj.b;
import wj.d;
import wj.f;
import wj.o;
import wj.v;
import wj.x;

public class TraceValueConverter {
    public static void a(String str, V8Object v8Object, Object obj) {
        if (obj instanceof Integer) {
            v8Object.add(str, ((Integer) obj).intValue());
        } else if (obj instanceof String) {
            v8Object.add(str, (String) obj);
        } else if (obj instanceof Double) {
            v8Object.add(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            v8Object.add(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof V8Value) {
            v8Object.add(str, (V8Value) obj);
        } else {
            v8Object.addNull(str);
        }
    }

    public static void b(V8 v82, V8Object v8Object, x xVar) {
        v8Object.add("type", xVar.getType());
        switch (xVar.getType()) {
            case 0:
                v8Object.addUndefined("value");
                return;
            case 1:
                v8Object.add("value", ((Integer) xVar.b()).intValue());
                return;
            case 2:
                v8Object.add("value", ((Boolean) xVar.b()).booleanValue());
                return;
            case 3:
                v8Object.add("value", (String) xVar.b());
                return;
            case 4:
                if (xVar instanceof a) {
                    v8Object.add("value", (V8Value) (a) xVar);
                    return;
                } else if (xVar instanceof TraceMap) {
                    v8Object.add("value", (V8Value) new a(v82, (TraceMap) xVar));
                    return;
                } else {
                    return;
                }
            case 5:
                if (xVar instanceof o) {
                    v8Object.add("value", (V8Value) (o) xVar);
                    return;
                } else if (xVar instanceof TraceArray) {
                    v8Object.add("value", (V8Value) new o(v82, (TraceArray) xVar));
                    return;
                } else {
                    return;
                }
            case 6:
                v8Object.add("value", ((Double) xVar.b()).doubleValue());
                return;
            case 7:
                v8Object.addNull("value");
                return;
            case 8:
                v8Object.add("value", (V8Value) (V8Function) xVar.b());
                return;
            default:
                return;
        }
    }

    public static x c(Object obj) throws TraceValueError {
        if (obj == null) {
            return new NullTraceValue();
        }
        if (obj instanceof String) {
            return new v((String) obj);
        }
        if (obj instanceof Integer) {
            return new f((Integer) obj);
        }
        if (obj instanceof Double) {
            return new d((Double) obj);
        }
        if (obj instanceof Long) {
            return new d(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new b((Boolean) obj);
        }
        if (obj instanceof Map) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            Map map = (Map) obj;
            for (Object next : map.keySet()) {
                if (next instanceof String) {
                    String str = (String) next;
                    concurrentHashMap.put(str, c(map.get(str)));
                } else {
                    throw new TraceValueError(TraceValueError.OBJECT_KEY_NOT_STRING);
                }
            }
            return new TraceMap(concurrentHashMap);
        } else if (obj instanceof List) {
            List<Object> list = (List) obj;
            if (list.isEmpty()) {
                return new TraceArray();
            }
            ArrayList arrayList = new ArrayList();
            for (Object c11 : list) {
                arrayList.add(c(c11));
            }
            return new TraceArray(arrayList, (ArrayListener) null);
        } else {
            throw new TraceValueError(TraceValueError.TRACE_MAP_SET_VALUE_TYPE_NOT_ALLOWED);
        }
    }

    public static Object d(V8 v82, x xVar) {
        TraceMap traceMap;
        TraceArray traceArray;
        int type = xVar.getType();
        if (type == 4) {
            if (xVar instanceof a) {
                traceMap = ((a) xVar).m();
            } else {
                traceMap = (TraceMap) xVar;
            }
            V8Object v8Object = new V8Object(v82);
            for (String next : traceMap.b().keySet()) {
                try {
                    a(next, v8Object, d(v82, traceMap.f(next)));
                } catch (TraceValueError e11) {
                    Log.e("EdgeEngine", "convert add " + e11.getMessage(), e11);
                }
            }
            return v8Object;
        } else if (type != 5) {
            return xVar.b();
        } else {
            if (xVar instanceof o) {
                traceArray = ((o) xVar).o();
            } else {
                traceArray = (TraceArray) xVar;
            }
            V8Array v8Array = new V8Array(v82);
            for (x d11 : traceArray.f44061b) {
                v8Array.push(d(v82, d11));
            }
            return v8Array;
        }
    }

    public static List<x> e(V8 v82, V8Array v8Array) throws TraceValueError {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < v8Array.length(); i11++) {
            arrayList.add(f(v82, v8Array.getType(i11), v8Array.get(i11)));
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0064, code lost:
        return new wj.d((java.lang.Double) r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static wj.x f(com.eclipsesource.v8.V8 r2, int r3, java.lang.Object r4) throws com.huobi.edgeengine.node.trace.error.TraceValueError {
        /*
            if (r4 != 0) goto L_0x0008
            com.huobi.edgeengine.node.trace.NullTraceValue r2 = new com.huobi.edgeengine.node.trace.NullTraceValue
            r2.<init>()
            return r2
        L_0x0008:
            r0 = 9
            if (r3 == r0) goto L_0x0073
            r0 = 11
            if (r3 == r0) goto L_0x0073
            r0 = 99
            if (r3 == r0) goto L_0x006b
            switch(r3) {
                case 0: goto L_0x0065;
                case 1: goto L_0x0073;
                case 2: goto L_0x005d;
                case 3: goto L_0x0055;
                case 4: goto L_0x004b;
                case 5: goto L_0x0039;
                case 6: goto L_0x0028;
                case 7: goto L_0x0020;
                default: goto L_0x0017;
            }
        L_0x0017:
            switch(r3) {
                case 13: goto L_0x0073;
                case 14: goto L_0x0073;
                case 15: goto L_0x0073;
                case 16: goto L_0x005d;
                default: goto L_0x001a;
            }
        L_0x001a:
            com.huobi.edgeengine.node.trace.error.TraceValueError r2 = new com.huobi.edgeengine.node.trace.error.TraceValueError
            r2.<init>()
            throw r2
        L_0x0020:
            wj.e r2 = new wj.e
            com.eclipsesource.v8.V8Function r4 = (com.eclipsesource.v8.V8Function) r4
            r2.<init>(r4)
            return r2
        L_0x0028:
            com.huobi.edgeengine.node.trace.a r3 = new com.huobi.edgeengine.node.trace.a
            com.huobi.edgeengine.node.trace.TraceMap r0 = new com.huobi.edgeengine.node.trace.TraceMap
            com.eclipsesource.v8.V8Object r4 = (com.eclipsesource.v8.V8Object) r4
            java.util.concurrent.ConcurrentHashMap r4 = g(r2, r4)
            r0.<init>(r4)
            r3.<init>(r2, r0)
            return r3
        L_0x0039:
            wj.o r3 = new wj.o
            com.huobi.edgeengine.node.trace.TraceArray r0 = new com.huobi.edgeengine.node.trace.TraceArray
            com.eclipsesource.v8.V8Array r4 = (com.eclipsesource.v8.V8Array) r4
            java.util.List r4 = e(r2, r4)
            r1 = 0
            r0.<init>(r4, r1)
            r3.<init>(r2, r0)
            return r3
        L_0x004b:
            wj.v r2 = new wj.v
            java.lang.String r3 = java.lang.String.valueOf(r4)
            r2.<init>(r3)
            return r2
        L_0x0055:
            wj.b r2 = new wj.b
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            r2.<init>(r4)
            return r2
        L_0x005d:
            wj.d r2 = new wj.d
            java.lang.Double r4 = (java.lang.Double) r4
            r2.<init>(r4)
            return r2
        L_0x0065:
            com.huobi.edgeengine.node.trace.NullTraceValue r2 = new com.huobi.edgeengine.node.trace.NullTraceValue
            r2.<init>()
            return r2
        L_0x006b:
            wj.y r2 = new wj.y
            com.eclipsesource.v8.V8Value r4 = (com.eclipsesource.v8.V8Value) r4
            r2.<init>(r4)
            return r2
        L_0x0073:
            wj.f r2 = new wj.f
            java.lang.Integer r4 = (java.lang.Integer) r4
            r2.<init>(r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.node.trace.TraceValueConverter.f(com.eclipsesource.v8.V8, int, java.lang.Object):wj.x");
    }

    public static ConcurrentHashMap<String, x> g(V8 v82, V8Object v8Object) throws TraceValueError {
        ConcurrentHashMap<String, x> concurrentHashMap = new ConcurrentHashMap<>();
        for (String str : v8Object.getKeys()) {
            concurrentHashMap.put(str, f(v82, v8Object.getType(str), v8Object.get(str)));
        }
        return concurrentHashMap;
    }
}
