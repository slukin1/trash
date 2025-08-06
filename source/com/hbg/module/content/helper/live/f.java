package com.hbg.module.content.helper.live;

import com.hbg.module.content.ui.activity.live.GiftListFragment;
import com.hbg.module.libkt.utils.event.bean.Financial;
import we.c;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f18246a = new f();

    /* renamed from: b  reason: collision with root package name */
    public static int f18247b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static Financial f18248c;

    /* renamed from: d  reason: collision with root package name */
    public static a f18249d;

    /* renamed from: e  reason: collision with root package name */
    public static GiftListFragment f18250e;

    /* renamed from: f  reason: collision with root package name */
    public static int f18251f;

    public final Financial a() {
        return f18248c;
    }

    public final int b() {
        return f18251f;
    }

    public final int c() {
        return f18247b;
    }

    public final void d() {
        a aVar = f18249d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void e() {
        f18247b = -1;
        f18248c = null;
        f18249d = null;
        f18250e = null;
    }

    public final void f(Financial financial) {
        f18248c = financial;
    }

    public final void g(a aVar) {
        f18249d = aVar;
    }

    public final void h(int i11) {
        f18251f = i11;
    }

    public final void i(int i11) {
        f18247b = i11;
    }

    public final void j(int i11) {
        if (i11 >= 0) {
            c.s(i11);
        }
    }
}
