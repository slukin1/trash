package com.huobi.edgeengine.template.widget;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import com.huobi.edgeengine.node.trace.ArrayListener;
import com.huobi.edgeengine.node.trace.TraceMap;
import java.util.ArrayList;
import java.util.List;
import rj.n;

public class NodeSequence implements ArrayListener.a {

    /* renamed from: a  reason: collision with root package name */
    public List<Widget> f44088a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<Pair<Widget, n>> f44089b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<ArrayListener.a> f44090c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public n f44091d;

    /* renamed from: e  reason: collision with root package name */
    public List<TraceMap.a> f44092e = new ArrayList();

    public static NodeSequence e(NodeSequence nodeSequence) {
        NodeSequence nodeSequence2 = new NodeSequence();
        nodeSequence2.f44088a = nodeSequence.f44088a;
        return nodeSequence2;
    }

    public void a(int i11, List<Object> list, List<Integer> list2) {
        f(this.f44091d);
        for (ArrayListener.a a11 : this.f44090c) {
            a11.a(i11, list, list2);
        }
    }

    public void b(Widget widget) {
        this.f44088a.add(widget);
    }

    public void c(ArrayListener.a aVar) {
        this.f44090c.add(aVar);
    }

    public View d(Context context, int i11) {
        if (i11 < 0 || i11 >= this.f44089b.size()) {
            return new View(context);
        }
        Pair pair = this.f44089b.get(i11);
        return ((Widget) pair.first).Q(context, (n) pair.second);
    }

    public void f(n nVar) {
        if (nVar != null) {
            for (Pair<Widget, n> pair : this.f44089b) {
                ((Widget) pair.first).O();
            }
            this.f44089b.clear();
            for (Widget next : this.f44088a) {
                if (next instanceof ForWidget) {
                    this.f44089b.addAll(((ForWidget) next).Z(nVar));
                } else {
                    this.f44089b.add(new Pair(next, nVar));
                }
            }
        }
    }

    public List<Pair<Widget, n>> g() {
        return this.f44089b;
    }

    public int h() {
        return this.f44089b.size();
    }

    public void i() {
        for (TraceMap.a next : this.f44092e) {
            if (next != null) {
                next.destroy();
            }
        }
        this.f44092e.clear();
        for (Pair<Widget, n> pair : this.f44089b) {
            ((Widget) pair.first).O();
        }
    }

    public void j(Context context, n nVar) {
        TraceMap.a c02;
        this.f44091d = nVar;
        this.f44089b.clear();
        for (Widget next : this.f44088a) {
            if (!(next instanceof ForWidget)) {
                this.f44089b.add(new Pair(next, nVar));
            }
        }
        for (Widget next2 : this.f44088a) {
            if ((next2 instanceof ForWidget) && (c02 = ((ForWidget) next2).c0(context, nVar, this)) != null) {
                this.f44092e.add(c02);
            }
        }
    }
}
