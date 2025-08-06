package com.huobi.edgeengine.node.trace;

import com.huobi.edgeengine.node.trace.TraceMap;
import java.util.ArrayList;
import java.util.List;

public class ArrayListener extends TraceListener {

    /* renamed from: c  reason: collision with root package name */
    public List<a> f44060c = new ArrayList();

    public interface a {
        void a(int i11, List<Object> list, List<Integer> list2);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void k(a aVar) {
        this.f44060c.remove(aVar);
    }

    public TraceMap.a l(a aVar) {
        this.f44060c.add(aVar);
        return new wj.a(this, aVar);
    }

    public void m(int i11, List<Object> list, List<Integer> list2) {
        for (a a11 : this.f44060c) {
            a11.a(i11, list, list2);
        }
    }
}
