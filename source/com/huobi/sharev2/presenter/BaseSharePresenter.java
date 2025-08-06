package com.huobi.sharev2.presenter;

import ur.a;

public class BaseSharePresenter<V extends a> {

    /* renamed from: a  reason: collision with root package name */
    public V f81142a;

    public void a(V v11) {
        this.f81142a = v11;
    }

    public void b() {
        if (this.f81142a != null) {
            this.f81142a = null;
        }
    }

    public V c() {
        return this.f81142a;
    }

    public boolean d() {
        return this.f81142a != null;
    }
}
