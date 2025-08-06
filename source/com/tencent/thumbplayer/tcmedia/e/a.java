package com.tencent.thumbplayer.tcmedia.e;

import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f49166a;

    /* renamed from: b  reason: collision with root package name */
    private b f49167b;

    public a(b bVar) {
        this.f49167b = bVar;
        this.f49166a = bVar.a();
    }

    public a(b bVar, String str) {
        b bVar2 = new b(bVar, str);
        this.f49167b = bVar2;
        this.f49166a = bVar2.a();
    }

    public b a() {
        return this.f49167b;
    }

    public void a(b bVar) {
        if (bVar == null) {
            this.f49167b = new b(this.f49166a);
        } else {
            this.f49167b = bVar;
        }
    }

    public void a(Exception exc) {
        TPLogUtil.e(this.f49167b.a(), (Throwable) exc);
    }

    public void a(String str) {
        this.f49167b.a(str);
    }

    public String b() {
        return this.f49167b.a();
    }

    public void b(String str) {
        TPLogUtil.d(this.f49167b.a(), str);
    }

    public void c(String str) {
        TPLogUtil.i(this.f49167b.a(), str);
    }

    public void d(String str) {
        TPLogUtil.w(this.f49167b.a(), str);
    }

    public void e(String str) {
        TPLogUtil.e(this.f49167b.a(), str);
    }
}
