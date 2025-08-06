package com.hbg.module.huobi.im.RedPoint;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.RedPoint.a;
import ed.a;
import java.util.ArrayList;

public class b {

    /* renamed from: e  reason: collision with root package name */
    public static volatile b f19636e;

    /* renamed from: a  reason: collision with root package name */
    public a f19637a;

    /* renamed from: b  reason: collision with root package name */
    public a f19638b;

    /* renamed from: c  reason: collision with root package name */
    public ProxyRedPointNode f19639c = new ProxyRedPointNode();

    /* renamed from: d  reason: collision with root package name */
    public ProxyRedPointNode f19640d = new ProxyRedPointNode();

    public b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f19639c);
        arrayList.add(this.f19640d);
        this.f19638b = new a(arrayList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f19638b);
        this.f19637a = new a(arrayList2);
    }

    public static b a() {
        if (f19636e == null) {
            synchronized (b.class) {
                if (f19636e == null) {
                    f19636e = new b();
                }
            }
        }
        return f19636e;
    }

    public a b() {
        return this.f19637a;
    }

    public TextView c(Context context, ViewGroup viewGroup) {
        return (TextView) LayoutInflater.from(context).inflate(R$layout.layout_red_point_count, viewGroup, false);
    }

    public View d(Context context, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R$layout.layout_red_point_pure, viewGroup, false);
    }

    public void e(AbsRedPointNodeImp absRedPointNodeImp) {
        this.f19639c.f(absRedPointNodeImp);
    }

    public void f(a.C0138a aVar) {
        this.f19639c.e(aVar);
    }

    public void g(a.C0138a aVar) {
        this.f19638b.e(aVar);
    }

    public void h(a.C0138a aVar) {
        this.f19637a.e(aVar);
    }

    public void i(AbsRedPointNodeImp absRedPointNodeImp) {
        this.f19640d.f(absRedPointNodeImp);
    }

    public void j(a.C0138a aVar) {
        this.f19640d.e(aVar);
    }
}
