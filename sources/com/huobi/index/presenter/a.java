package com.huobi.index.presenter;

import com.huobi.index.presenter.g;
import java.util.ArrayList;
import java.util.List;

public abstract class a implements g {

    /* renamed from: a  reason: collision with root package name */
    public g.a f73423a = null;

    /* renamed from: b  reason: collision with root package name */
    public List<? extends g.b> f73424b;

    public a(g.a aVar) {
        g(aVar);
        if (e()) {
            this.f73424b = new ArrayList();
            if (aVar != null) {
                aVar.onUpdate();
                return;
            }
            return;
        }
        d(aVar);
    }

    public List<? extends g.b> a() {
        return this.f73424b;
    }

    public void b(boolean z11) {
        if (!z11) {
            f();
        } else if (e()) {
            f();
            this.f73424b = new ArrayList();
            g.a aVar = this.f73423a;
            if (aVar != null) {
                aVar.onUpdate();
            }
        } else {
            d(this.f73423a);
            c();
        }
    }

    public abstract void c();

    public abstract void d(g.a aVar);

    public abstract boolean e();

    public abstract void f();

    public void g(g.a aVar) {
        this.f73423a = aVar;
        if (!e()) {
            c();
        }
    }

    public void onRefresh() {
        if (e()) {
            f();
            this.f73424b = new ArrayList();
            g.a aVar = this.f73423a;
            if (aVar != null) {
                aVar.onUpdate();
                return;
            }
            return;
        }
        d(this.f73423a);
        c();
    }
}
