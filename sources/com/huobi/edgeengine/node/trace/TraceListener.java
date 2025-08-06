package com.huobi.edgeengine.node.trace;

import android.text.TextUtils;
import com.huobi.edgeengine.node.trace.ArrayListener;
import com.huobi.edgeengine.node.trace.TraceMap;
import com.huobi.edgeengine.node.trace.error.TraceValueError;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import vj.a;
import wj.w;
import wj.x;

public class TraceListener {

    /* renamed from: a  reason: collision with root package name */
    public List<a> f44063a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<String, TraceListener> f44064b;

    /* access modifiers changed from: private */
    public /* synthetic */ void f(a aVar) {
        this.f44063a.remove(aVar);
    }

    public TraceMap.a b(List<String> list, ArrayListener.a aVar) throws TraceValueError {
        if (list == null || list.isEmpty()) {
            throw new TraceValueError(TraceValueError.TRACE_MAP_GET_KEY_IS_EMPTY);
        }
        String str = list.get(0);
        if (!TextUtils.isEmpty(str)) {
            ConcurrentHashMap<String, TraceListener> concurrentHashMap = this.f44064b;
            if (concurrentHashMap == null) {
                concurrentHashMap = new ConcurrentHashMap<>();
                this.f44064b = concurrentHashMap;
            }
            if (list.size() == 1) {
                Object obj = concurrentHashMap.get(str);
                if (obj == null) {
                    obj = new ArrayListener();
                    concurrentHashMap.put(str, obj);
                }
                if (obj instanceof ArrayListener) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(0);
                    aVar.a(0, new ArrayList(), arrayList);
                    return ((ArrayListener) obj).l(aVar);
                }
                throw new TraceValueError(String.format(TraceValueError.TRACE_MAP_LISTENER_ARRAY_BUT_PREVIOUS_IS_NOT_ARRAY, new Object[]{str}));
            }
            TraceListener traceListener = concurrentHashMap.get(str);
            if (traceListener == null) {
                traceListener = new TraceListener();
                concurrentHashMap.put(str, traceListener);
            }
            list.remove(0);
            return traceListener.b(list, aVar);
        }
        throw new TraceValueError(TraceValueError.TRACE_MAP_GET_KEY_IS_EMPTY);
    }

    public TraceMap.a c(List<String> list, a aVar) {
        if (list == null || list.isEmpty()) {
            return g(aVar);
        }
        String str = list.get(0);
        if (TextUtils.isEmpty(str)) {
            return g(aVar);
        }
        ConcurrentHashMap<String, TraceListener> concurrentHashMap = this.f44064b;
        if (concurrentHashMap == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
            this.f44064b = concurrentHashMap;
        }
        TraceListener traceListener = concurrentHashMap.get(str);
        if (traceListener == null) {
            traceListener = new TraceListener();
            concurrentHashMap.put(str, traceListener);
        }
        list.remove(0);
        return traceListener.c(list, aVar);
    }

    public void d(x xVar) {
        h(xVar);
        ConcurrentHashMap<String, TraceListener> concurrentHashMap = this.f44064b;
        if (concurrentHashMap != null) {
            for (TraceListener d11 : concurrentHashMap.values()) {
                d11.d(xVar);
            }
        }
    }

    public ConcurrentHashMap<String, TraceListener> e() {
        return this.f44064b;
    }

    public TraceMap.a g(a aVar) {
        this.f44063a.add(aVar);
        return new w(this, aVar);
    }

    public void h(x xVar) {
        Object b11 = xVar == null ? null : xVar.b();
        if (b11 != null) {
            for (a onCallback : this.f44063a) {
                onCallback.onCallback(b11);
            }
        }
    }

    public void i(ConcurrentHashMap<String, TraceListener> concurrentHashMap) {
        this.f44064b = concurrentHashMap;
    }
}
