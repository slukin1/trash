package com.hbg.module.huobi.im.RedPoint;

import com.hbg.module.huobi.im.RedPoint.a;

public abstract class AbsRedPointNodeImp implements a {

    /* renamed from: a  reason: collision with root package name */
    public a f19633a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0138a f19634b;

    public void c() {
        a.C0138a aVar = this.f19634b;
        if (aVar != null) {
            aVar.a(this);
        }
        a aVar2 = this.f19633a;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    public void d(a aVar) {
        this.f19633a = aVar;
    }

    public void e(a.C0138a aVar) {
        this.f19634b = aVar;
        if (aVar != null) {
            aVar.a(this);
        }
    }
}
