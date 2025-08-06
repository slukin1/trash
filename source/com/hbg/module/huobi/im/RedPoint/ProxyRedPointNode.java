package com.hbg.module.huobi.im.RedPoint;

public class ProxyRedPointNode extends AbsRedPointNodeImp {

    /* renamed from: c  reason: collision with root package name */
    public AbsRedPointNodeImp f19635c;

    public boolean a() {
        AbsRedPointNodeImp absRedPointNodeImp = this.f19635c;
        if (absRedPointNodeImp == null) {
            return false;
        }
        return absRedPointNodeImp.a();
    }

    public int b() {
        AbsRedPointNodeImp absRedPointNodeImp = this.f19635c;
        if (absRedPointNodeImp == null) {
            return 0;
        }
        return absRedPointNodeImp.b();
    }

    public void f(AbsRedPointNodeImp absRedPointNodeImp) {
        this.f19635c = absRedPointNodeImp;
        absRedPointNodeImp.d(this);
    }
}
