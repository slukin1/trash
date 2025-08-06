package com.hbg.lib.widgets.bean;

import com.hbg.lib.widgets.viewhandler.CommonDateTabItemHandler;

public class CommonDateSelectorItemBean implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public String f71753b;

    /* renamed from: c  reason: collision with root package name */
    public int f71754c;

    /* renamed from: d  reason: collision with root package name */
    public int f71755d;

    /* renamed from: e  reason: collision with root package name */
    public a f71756e;

    public interface a {
        void a(CommonDateSelectorItemBean commonDateSelectorItemBean);

        boolean b(CommonDateSelectorItemBean commonDateSelectorItemBean);
    }

    public CommonDateSelectorItemBean() {
    }

    public int a() {
        return this.f71754c;
    }

    public int c() {
        return this.f71755d;
    }

    public String d() {
        return this.f71753b;
    }

    public boolean e() {
        a aVar = this.f71756e;
        return aVar != null && aVar.b(this);
    }

    public void f() {
        a aVar = this.f71756e;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void g(a aVar) {
        this.f71756e = aVar;
    }

    public String getViewHandlerName() {
        return CommonDateTabItemHandler.class.getName();
    }

    public CommonDateSelectorItemBean(int i11, String str, int i12) {
        this.f71755d = i11;
        this.f71753b = str;
        this.f71754c = i12;
    }
}
