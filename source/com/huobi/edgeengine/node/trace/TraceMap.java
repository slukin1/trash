package com.huobi.edgeengine.node.trace;

import android.text.TextUtils;
import android.util.Log;
import com.huobi.edgeengine.node.trace.ArrayListener;
import com.huobi.edgeengine.node.trace.error.TraceValueError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import wj.c;
import wj.o;
import wj.x;

public class TraceMap implements c, x {

    /* renamed from: d  reason: collision with root package name */
    public static final String f44065d = "TraceMap";

    /* renamed from: b  reason: collision with root package name */
    public Map<String, x> f44066b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public ConcurrentHashMap<String, TraceListener> f44067c = new ConcurrentHashMap<>();

    public interface a {
        void destroy();
    }

    public TraceMap() {
    }

    public synchronized void a(TraceListener traceListener) throws TraceValueError {
        if (traceListener.e() != null) {
            ConcurrentHashMap<String, TraceListener> e11 = traceListener.e();
            this.f44067c = e11;
            for (String next : e11.keySet()) {
                x xVar = this.f44066b.get(next);
                TraceListener traceListener2 = e11.get(next);
                if (xVar != null) {
                    traceListener2.h(xVar);
                    if (xVar instanceof c) {
                        ((c) xVar).a(traceListener2);
                    }
                } else {
                    traceListener2.d((x) null);
                }
            }
        }
    }

    public void c() {
        this.f44067c.clear();
    }

    public TraceMap d(String str) throws TraceValueError {
        TraceMap traceMap = new TraceMap();
        this.f44066b.put(str, traceMap);
        TraceListener traceListener = this.f44067c.get(str);
        if (traceListener != null) {
            traceMap.a(traceListener);
        }
        return traceMap;
    }

    /* renamed from: e */
    public Map<String, Object> b() {
        Object obj;
        HashMap hashMap = new HashMap();
        for (String next : this.f44066b.keySet()) {
            x xVar = this.f44066b.get(next);
            if (xVar == null) {
                obj = null;
            } else {
                obj = xVar.b();
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    public x f(String str) throws TraceValueError {
        if (!TextUtils.isEmpty(str)) {
            return g(str, new ArrayList(Arrays.asList(str.split("\\."))));
        }
        throw new TraceValueError(TraceValueError.TRACE_MAP_GET_KEY_IS_EMPTY);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0061, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized wj.x g(java.lang.String r6, java.util.List<java.lang.String> r7) throws com.huobi.edgeengine.node.trace.error.TraceValueError {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            java.lang.Object r1 = r7.get(r0)     // Catch:{ all -> 0x00b7 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00b7 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x00b7 }
            if (r2 != 0) goto L_0x00af
            java.util.Map<java.lang.String, wj.x> r2 = r5.f44066b     // Catch:{ all -> 0x00b7 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x00b7 }
            wj.x r2 = (wj.x) r2     // Catch:{ all -> 0x00b7 }
            if (r2 != 0) goto L_0x001b
            r6 = 0
            monitor-exit(r5)
            return r6
        L_0x001b:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.edgeengine.node.trace.TraceListener> r3 = r5.f44067c     // Catch:{ all -> 0x00b7 }
            java.lang.Object r1 = r3.get(r1)     // Catch:{ all -> 0x00b7 }
            com.huobi.edgeengine.node.trace.TraceListener r1 = (com.huobi.edgeengine.node.trace.TraceListener) r1     // Catch:{ all -> 0x00b7 }
            if (r1 != 0) goto L_0x002a
            com.huobi.edgeengine.node.trace.TraceListener r1 = new com.huobi.edgeengine.node.trace.TraceListener     // Catch:{ all -> 0x00b7 }
            r1.<init>()     // Catch:{ all -> 0x00b7 }
        L_0x002a:
            int r3 = r7.size()     // Catch:{ all -> 0x00b7 }
            r4 = 1
            if (r3 != r4) goto L_0x0064
            boolean r6 = r2 instanceof com.huobi.edgeengine.node.trace.TraceMap     // Catch:{ all -> 0x00b7 }
            if (r6 == 0) goto L_0x0039
            r6 = r2
            com.huobi.edgeengine.node.trace.TraceMap r6 = (com.huobi.edgeengine.node.trace.TraceMap) r6     // Catch:{ all -> 0x00b7 }
            goto L_0x0044
        L_0x0039:
            boolean r6 = r2 instanceof com.huobi.edgeengine.node.trace.a     // Catch:{ all -> 0x00b7 }
            if (r6 == 0) goto L_0x0062
            r6 = r2
            com.huobi.edgeengine.node.trace.a r6 = (com.huobi.edgeengine.node.trace.a) r6     // Catch:{ all -> 0x00b7 }
            com.huobi.edgeengine.node.trace.TraceMap r6 = r6.m()     // Catch:{ all -> 0x00b7 }
        L_0x0044:
            java.util.concurrent.ConcurrentHashMap r7 = r1.e()     // Catch:{ all -> 0x00b7 }
            if (r7 == 0) goto L_0x005b
            java.util.concurrent.ConcurrentHashMap r7 = r1.e()     // Catch:{ all -> 0x00b7 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.edgeengine.node.trace.TraceListener> r6 = r6.f44067c     // Catch:{ all -> 0x00b7 }
            if (r7 != r6) goto L_0x0053
            goto L_0x0060
        L_0x0053:
            com.huobi.edgeengine.node.trace.error.TraceValueError r6 = new com.huobi.edgeengine.node.trace.error.TraceValueError     // Catch:{ all -> 0x00b7 }
            java.lang.String r7 = "监听的深度监听表的引用和下游节点的监听表不是同一个"
            r6.<init>(r7)     // Catch:{ all -> 0x00b7 }
            throw r6     // Catch:{ all -> 0x00b7 }
        L_0x005b:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.edgeengine.node.trace.TraceListener> r6 = r6.f44067c     // Catch:{ all -> 0x00b7 }
            r1.i(r6)     // Catch:{ all -> 0x00b7 }
        L_0x0060:
            monitor-exit(r5)
            return r2
        L_0x0062:
            monitor-exit(r5)
            return r2
        L_0x0064:
            boolean r3 = r2 instanceof com.huobi.edgeengine.node.trace.TraceMap     // Catch:{ all -> 0x00b7 }
            if (r3 != 0) goto L_0x007d
            boolean r3 = r2 instanceof com.huobi.edgeengine.node.trace.a     // Catch:{ all -> 0x00b7 }
            if (r3 == 0) goto L_0x006d
            goto L_0x007d
        L_0x006d:
            com.huobi.edgeengine.node.trace.error.TraceValueError r7 = new com.huobi.edgeengine.node.trace.error.TraceValueError     // Catch:{ all -> 0x00b7 }
            java.lang.String r1 = "从 Object 中取值的深度路径 %s 中有不是对象导致无法取值"
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ all -> 0x00b7 }
            r2[r0] = r6     // Catch:{ all -> 0x00b7 }
            java.lang.String r6 = java.lang.String.format(r1, r2)     // Catch:{ all -> 0x00b7 }
            r7.<init>(r6)     // Catch:{ all -> 0x00b7 }
            throw r7     // Catch:{ all -> 0x00b7 }
        L_0x007d:
            boolean r3 = r2 instanceof com.huobi.edgeengine.node.trace.TraceMap     // Catch:{ all -> 0x00b7 }
            if (r3 == 0) goto L_0x0084
            com.huobi.edgeengine.node.trace.TraceMap r2 = (com.huobi.edgeengine.node.trace.TraceMap) r2     // Catch:{ all -> 0x00b7 }
            goto L_0x008a
        L_0x0084:
            com.huobi.edgeengine.node.trace.a r2 = (com.huobi.edgeengine.node.trace.a) r2     // Catch:{ all -> 0x00b7 }
            com.huobi.edgeengine.node.trace.TraceMap r2 = r2.m()     // Catch:{ all -> 0x00b7 }
        L_0x008a:
            java.util.concurrent.ConcurrentHashMap r3 = r1.e()     // Catch:{ all -> 0x00b7 }
            if (r3 == 0) goto L_0x00a1
            java.util.concurrent.ConcurrentHashMap r1 = r1.e()     // Catch:{ all -> 0x00b7 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.edgeengine.node.trace.TraceListener> r3 = r2.f44067c     // Catch:{ all -> 0x00b7 }
            if (r1 != r3) goto L_0x0099
            goto L_0x00a6
        L_0x0099:
            com.huobi.edgeengine.node.trace.error.TraceValueError r6 = new com.huobi.edgeengine.node.trace.error.TraceValueError     // Catch:{ all -> 0x00b7 }
            java.lang.String r7 = "监听的深度监听表的引用和下游节点的监听表不是同一个"
            r6.<init>(r7)     // Catch:{ all -> 0x00b7 }
            throw r6     // Catch:{ all -> 0x00b7 }
        L_0x00a1:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.huobi.edgeengine.node.trace.TraceListener> r3 = r2.f44067c     // Catch:{ all -> 0x00b7 }
            r1.i(r3)     // Catch:{ all -> 0x00b7 }
        L_0x00a6:
            r7.remove(r0)     // Catch:{ all -> 0x00b7 }
            wj.x r6 = r2.g(r6, r7)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r5)
            return r6
        L_0x00af:
            com.huobi.edgeengine.node.trace.error.TraceValueError r6 = new com.huobi.edgeengine.node.trace.error.TraceValueError     // Catch:{ all -> 0x00b7 }
            java.lang.String r7 = "从 Object 中访问的下标是空字符串"
            r6.<init>(r7)     // Catch:{ all -> 0x00b7 }
            throw r6     // Catch:{ all -> 0x00b7 }
        L_0x00b7:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.node.trace.TraceMap.g(java.lang.String, java.util.List):wj.x");
    }

    public int getType() {
        return 4;
    }

    public final synchronized a h(String str, List<String> list, vj.a aVar) throws TraceValueError {
        TraceMap traceMap;
        if (list != null) {
            if (!list.isEmpty() && !TextUtils.isEmpty(list.get(0))) {
                String str2 = list.get(0);
                TraceListener traceListener = this.f44067c.get(str2);
                if (traceListener == null) {
                    traceListener = new TraceListener();
                    this.f44067c.put(str2, traceListener);
                }
                Object obj = null;
                if (list.size() == 1) {
                    x xVar = this.f44066b.get(str2);
                    if (xVar != null) {
                        obj = xVar.b();
                    }
                    aVar.onCallback(obj);
                    return traceListener.g(aVar);
                }
                list.remove(0);
                x xVar2 = this.f44066b.get(str2);
                if (xVar2 != null) {
                    if (xVar2 instanceof TraceMap) {
                        traceMap = (TraceMap) xVar2;
                    } else if (xVar2 instanceof a) {
                        traceMap = ((a) xVar2).m();
                    } else {
                        String str3 = f44065d;
                        Log.e(str3, "监听到错误的路径：" + str);
                        return null;
                    }
                    if (traceListener.e() == null) {
                        traceListener.i(traceMap.f44067c);
                    } else if (traceListener.e() != traceMap.f44067c) {
                        String str4 = f44065d;
                        Log.e(str4, "深度监听不匹配：" + str);
                        return null;
                    }
                    return traceMap.h(str, list, aVar);
                }
                traceListener.c(list, aVar);
                return null;
            }
        }
        throw new TraceValueError(TraceValueError.TRACE_MAP_GET_KEY_IS_EMPTY);
    }

    public a i(String str, vj.a aVar) {
        try {
            return m(str, aVar);
        } catch (TraceValueError e11) {
            Log.e(f44065d, e11.getMessage());
            return null;
        }
    }

    public a j(String str, ArrayListener.a aVar) {
        try {
            return l(str, aVar);
        } catch (TraceValueError e11) {
            Log.e(f44065d, e11.getMessage());
            return null;
        }
    }

    public final synchronized a k(String str, List<String> list, ArrayListener.a aVar) throws TraceValueError {
        TraceMap traceMap;
        TraceArray traceArray;
        if (list != null) {
            if (!list.isEmpty() && !TextUtils.isEmpty(list.get(0))) {
                String str2 = list.get(0);
                TraceListener traceListener = this.f44067c.get(str2);
                if (list.size() == 1) {
                    if (traceListener == null) {
                        traceListener = new ArrayListener();
                        this.f44067c.put(str2, traceListener);
                    }
                    x xVar = this.f44066b.get(str2);
                    if (xVar != null) {
                        if (xVar instanceof TraceArray) {
                            traceArray = (TraceArray) xVar;
                        } else if (xVar instanceof o) {
                            traceArray = ((o) xVar).o();
                        } else {
                            throw new TraceValueError(String.format(TraceValueError.TRACE_MAP_LISTEN_ARRAY_BUT_PREVIOUS_IS_NOT_ARRAY, new Object[]{str}));
                        }
                        traceArray.f44062c = (ArrayListener) traceListener;
                        return traceArray.g(aVar);
                    } else if (traceListener instanceof ArrayListener) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(0);
                        aVar.a(0, new ArrayList(), arrayList);
                        return ((ArrayListener) traceListener).l(aVar);
                    } else {
                        throw new TraceValueError(String.format(TraceValueError.TRACE_MAP_LISTENER_ARRAY_BUT_PREVIOUS_IS_NOT_ARRAY, new Object[]{str}));
                    }
                } else {
                    if (traceListener == null) {
                        traceListener = new TraceListener();
                        this.f44067c.put(str2, traceListener);
                    }
                    list.remove(0);
                    x xVar2 = this.f44066b.get(str2);
                    if (xVar2 != null) {
                        if (xVar2 instanceof TraceMap) {
                            traceMap = (TraceMap) xVar2;
                        } else if (xVar2 instanceof a) {
                            traceMap = ((a) xVar2).m();
                        } else {
                            throw new TraceValueError(String.format("从 Object 中取值的深度路径 %s 中有不是对象导致无法取值", new Object[]{str}));
                        }
                        if (traceListener.e() == null) {
                            traceListener.i(traceMap.f44067c);
                        } else if (traceListener.e() != traceMap.f44067c) {
                            throw new TraceValueError(TraceValueError.TRACE_MAP_LISTEN_DEEP_MAP_NOT_EQUAL);
                        }
                        return traceMap.k(str, list, aVar);
                    }
                    return traceListener.b(list, aVar);
                }
            }
        }
        throw new TraceValueError(TraceValueError.TRACE_MAP_GET_KEY_IS_EMPTY);
    }

    public final a l(String str, ArrayListener.a aVar) throws TraceValueError {
        if (!TextUtils.isEmpty(str)) {
            return k(str, new ArrayList(Arrays.asList(str.split("\\."))), aVar);
        }
        throw new TraceValueError(TraceValueError.TRACE_MAP_GET_KEY_IS_EMPTY);
    }

    public final a m(String str, vj.a aVar) throws TraceValueError {
        return h(str, new ArrayList(Arrays.asList(str.split("\\."))), aVar);
    }

    public void n(Object obj, String str) throws TraceValueError {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList(Arrays.asList(str.split("\\.")));
            x xVar = null;
            if (obj != null) {
                xVar = TraceValueConverter.c(obj);
            }
            o(xVar, str, arrayList);
            return;
        }
        throw new TraceValueError(TraceValueError.TRACE_MAP_GET_KEY_IS_EMPTY);
    }

    public synchronized void o(x xVar, String str, List<String> list) throws TraceValueError {
        TraceMap traceMap;
        if (list != null) {
            if (!list.isEmpty()) {
                String str2 = list.get(0);
                if (TextUtils.isEmpty(str2)) {
                    throw new TraceValueError(TraceValueError.TRACE_MAP_GET_KEY_IS_EMPTY);
                } else if (list.size() == 1) {
                    this.f44066b.put(str2, xVar);
                    TraceListener traceListener = this.f44067c.get(str2);
                    if (traceListener != null) {
                        if (xVar.getType() != 4) {
                            if (traceListener.e() != null) {
                                throw new TraceValueError(String.format(TraceValueError.TRACE_MAP_SET_VALUE_OTHER_TYPE_BUT_PREVIOUS_IS_OBJECT, new Object[]{str, xVar.b()}));
                            }
                        }
                        traceListener.h(xVar);
                        if (xVar instanceof c) {
                            ((c) xVar).a(traceListener);
                        }
                    }
                } else {
                    Object obj = this.f44066b.get(str2);
                    if (obj == null) {
                        obj = d(str2);
                    }
                    if (!(obj instanceof TraceMap)) {
                        if (!(obj instanceof a)) {
                            throw new TraceValueError(String.format("从 Object 中取值的深度路径 %s 中有不是对象导致无法取值", new Object[]{str}));
                        }
                    }
                    if (obj instanceof TraceMap) {
                        traceMap = (TraceMap) obj;
                    } else {
                        traceMap = ((a) obj).m();
                    }
                    list.remove(0);
                    traceMap.o(xVar, str, list);
                }
            }
        }
        throw new TraceValueError(TraceValueError.TRACE_MAP_GET_KEY_IS_EMPTY);
    }

    public TraceMap(ConcurrentHashMap<String, x> concurrentHashMap) {
        this.f44066b = concurrentHashMap;
    }
}
