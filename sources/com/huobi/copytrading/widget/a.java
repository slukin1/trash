package com.huobi.copytrading.widget;

public final class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f43729b;

    /* renamed from: c  reason: collision with root package name */
    public int f43730c;

    /* renamed from: d  reason: collision with root package name */
    public String f43731d;

    /* renamed from: e  reason: collision with root package name */
    public C0566a f43732e;

    /* renamed from: com.huobi.copytrading.widget.a$a  reason: collision with other inner class name */
    public interface C0566a {
        void a(a aVar);
    }

    public a(int i11, int i12, String str, C0566a aVar) {
        this.f43729b = i11;
        this.f43730c = i12;
        this.f43731d = str;
        this.f43732e = aVar;
    }

    public final C0566a a() {
        return this.f43732e;
    }

    public final int c() {
        return this.f43730c;
    }

    public final int d() {
        return this.f43729b;
    }

    public final String e() {
        return this.f43731d;
    }

    public String getViewHandlerName() {
        return CopyTradingPopWindowItemHandler.class.getName();
    }
}
