package com.huobi.edgeengine.node.trace;

import android.util.Log;
import com.eclipsesource.v8.V8Value;
import com.huobi.edgeengine.node.trace.ArrayListener;
import com.huobi.edgeengine.node.trace.TraceMap;
import com.huobi.edgeengine.node.trace.error.TraceValueError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import wj.c;
import wj.x;
import wj.y;

public class TraceArray implements x, c {

    /* renamed from: b  reason: collision with root package name */
    public List<x> f44061b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public ArrayListener f44062c;

    public TraceArray() {
    }

    public synchronized void a(TraceListener traceListener) throws TraceValueError {
        Log.e("EdgeEngine", "array restore " + traceListener);
        if (traceListener instanceof ArrayListener) {
            this.f44062c = (ArrayListener) traceListener;
            ArrayList arrayList = new ArrayList();
            for (x b11 : this.f44061b) {
                arrayList.add(b11.b());
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(0);
            this.f44062c.m(4, arrayList, arrayList2);
        } else {
            traceListener.h(this);
        }
    }

    /* JADX WARNING: type inference failed for: r3v3, types: [wj.x] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.huobi.edgeengine.node.trace.TraceMap c(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 0
            java.util.List<wj.x> r1 = r2.f44061b     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0028
            if (r3 < 0) goto L_0x0028
            int r1 = r1.size()     // Catch:{ all -> 0x002a }
            if (r3 >= r1) goto L_0x0028
            java.util.List<wj.x> r1 = r2.f44061b     // Catch:{ all -> 0x002a }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x002a }
            wj.x r3 = (wj.x) r3     // Catch:{ all -> 0x002a }
            boolean r1 = r3 instanceof com.huobi.edgeengine.node.trace.a     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0021
            com.huobi.edgeengine.node.trace.a r3 = (com.huobi.edgeengine.node.trace.a) r3     // Catch:{ all -> 0x002a }
            com.huobi.edgeengine.node.trace.TraceMap r0 = r3.m()     // Catch:{ all -> 0x002a }
            goto L_0x0028
        L_0x0021:
            boolean r1 = r3 instanceof com.huobi.edgeengine.node.trace.TraceMap     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0028
            r0 = r3
            com.huobi.edgeengine.node.trace.TraceMap r0 = (com.huobi.edgeengine.node.trace.TraceMap) r0     // Catch:{ all -> 0x002a }
        L_0x0028:
            monitor-exit(r2)
            return r0
        L_0x002a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.node.trace.TraceArray.c(int):com.huobi.edgeengine.node.trace.TraceMap");
    }

    public List<x> d() {
        return this.f44061b;
    }

    /* renamed from: e */
    public List<Object> b() {
        Object obj;
        ArrayList arrayList = new ArrayList();
        for (x next : this.f44061b) {
            if (next == null) {
                obj = null;
            } else {
                obj = next.b();
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void f(java.util.List<wj.x> r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            if (r6 == 0) goto L_0x0050
            boolean r0 = r6.isEmpty()     // Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x000a
            goto L_0x0050
        L_0x000a:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x004d }
            r0.<init>()     // Catch:{ all -> 0x004d }
            java.util.List<wj.x> r1 = r5.f44061b     // Catch:{ all -> 0x004d }
            int r1 = r1.size()     // Catch:{ all -> 0x004d }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x004d }
            r2.<init>()     // Catch:{ all -> 0x004d }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x004d }
        L_0x001e:
            boolean r3 = r6.hasNext()     // Catch:{ all -> 0x004d }
            if (r3 == 0) goto L_0x0041
            java.lang.Object r3 = r6.next()     // Catch:{ all -> 0x004d }
            wj.x r3 = (wj.x) r3     // Catch:{ all -> 0x004d }
            java.util.List<wj.x> r4 = r5.f44061b     // Catch:{ all -> 0x004d }
            r4.add(r3)     // Catch:{ all -> 0x004d }
            java.lang.Object r3 = r3.b()     // Catch:{ all -> 0x004d }
            r2.add(r3)     // Catch:{ all -> 0x004d }
            int r3 = r1 + 1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x004d }
            r0.add(r1)     // Catch:{ all -> 0x004d }
            r1 = r3
            goto L_0x001e
        L_0x0041:
            com.huobi.edgeengine.node.trace.ArrayListener r6 = r5.f44062c     // Catch:{ all -> 0x004d }
            if (r6 != 0) goto L_0x0047
            monitor-exit(r5)
            return
        L_0x0047:
            r1 = 1
            r6.m(r1, r2, r0)     // Catch:{ all -> 0x004d }
            monitor-exit(r5)
            return
        L_0x004d:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        L_0x0050:
            monitor-exit(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.edgeengine.node.trace.TraceArray.f(java.util.List):void");
    }

    public synchronized TraceMap.a g(ArrayListener.a aVar) {
        Object obj;
        ArrayListener arrayListener = this.f44062c;
        if (arrayListener == null) {
            return null;
        }
        TraceMap.a l11 = arrayListener.l(aVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(0);
        for (int i11 = 0; i11 < this.f44061b.size(); i11++) {
            x xVar = this.f44061b.get(i11);
            if (xVar == null) {
                obj = null;
            } else {
                obj = xVar.b();
            }
            arrayList.add(obj);
        }
        aVar.a(0, arrayList, arrayList2);
        return l11;
    }

    public int getType() {
        return 5;
    }

    public void h() {
        this.f44062c = null;
    }

    public synchronized void i(int i11, int i12, List<x> list) {
        Object obj;
        Object obj2;
        ArrayList arrayList = new ArrayList();
        if (i11 > 0) {
            for (int i13 = 0; i13 < i11; i13++) {
                arrayList.add(this.f44061b.get(i13));
            }
        }
        for (int i14 = 0; i14 < list.size(); i14++) {
            arrayList.add(list.get(i14));
        }
        int i15 = i11 + i12;
        for (int i16 = i15; i16 < this.f44061b.size(); i16++) {
            arrayList.add(this.f44061b.get(i16));
        }
        this.f44061b = arrayList;
        if (this.f44062c != null) {
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            if (i12 == 0) {
                while (i11 < this.f44061b.size()) {
                    x xVar = this.f44061b.get(i11);
                    arrayList2.add(Integer.valueOf(i11));
                    if (xVar == null) {
                        obj2 = null;
                    } else {
                        obj2 = xVar.b();
                    }
                    arrayList3.add(obj2);
                    i11++;
                }
                this.f44062c.m(1, arrayList3, arrayList2);
            } else if (list.size() == 0) {
                while (i11 < i15) {
                    arrayList2.add(Integer.valueOf(i11));
                    i11++;
                }
                this.f44062c.m(2, arrayList3, arrayList2);
            } else {
                for (int i17 = 0; i17 < list.size(); i17++) {
                    x xVar2 = list.get(i17);
                    arrayList2.add(Integer.valueOf(i17 + i11));
                    if (xVar2 == null) {
                        obj = null;
                    } else {
                        obj = xVar2.b();
                    }
                    arrayList3.add(obj);
                }
                this.f44062c.m(2, arrayList3, arrayList2);
            }
        }
    }

    public synchronized void j(List<x> list) {
        Object obj;
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        this.f44061b = list;
        for (int i11 = 0; i11 < list.size(); i11++) {
            x xVar = list.get(i11);
            arrayList.add(Integer.valueOf(i11));
            if (xVar == null) {
                obj = null;
            } else {
                obj = xVar.b();
            }
            arrayList2.add(obj);
        }
        ArrayListener arrayListener = this.f44062c;
        if (arrayListener != null) {
            arrayListener.m(4, arrayList2, arrayList);
        }
    }

    public synchronized void k(x xVar, int i11) {
        if (i11 >= this.f44061b.size()) {
            for (int size = this.f44061b.size(); size < i11; size++) {
                this.f44061b.add(new y((V8Value) null));
            }
            this.f44061b.add(xVar);
        } else {
            this.f44061b.set(i11, xVar);
        }
        ArrayListener arrayListener = this.f44062c;
        if (arrayListener != null) {
            arrayListener.m(3, Collections.singletonList(xVar), Collections.singletonList(Integer.valueOf(i11)));
        }
    }

    public TraceArray(List<x> list, ArrayListener arrayListener) {
        if (list != null) {
            this.f44061b = list;
        }
        this.f44062c = arrayListener;
    }
}
