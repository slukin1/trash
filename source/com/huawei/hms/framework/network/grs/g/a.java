package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.c;
import java.util.concurrent.Callable;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public d f38023a;

    /* renamed from: b  reason: collision with root package name */
    private final String f38024b;

    /* renamed from: c  reason: collision with root package name */
    private final c f38025c;

    /* renamed from: d  reason: collision with root package name */
    private final int f38026d;

    /* renamed from: e  reason: collision with root package name */
    private final Context f38027e;

    /* renamed from: f  reason: collision with root package name */
    private final String f38028f;

    /* renamed from: g  reason: collision with root package name */
    private final GrsBaseInfo f38029g;

    /* renamed from: h  reason: collision with root package name */
    private final c f38030h;

    public a(String str, int i11, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, c cVar2) {
        this.f38024b = str;
        this.f38025c = cVar;
        this.f38026d = i11;
        this.f38027e = context;
        this.f38028f = str2;
        this.f38029g = grsBaseInfo;
        this.f38030h = cVar2;
    }

    public Context a() {
        return this.f38027e;
    }

    public c b() {
        return this.f38025c;
    }

    public String c() {
        return this.f38024b;
    }

    public int d() {
        return this.f38026d;
    }

    public String e() {
        return this.f38028f;
    }

    public c f() {
        return this.f38030h;
    }

    public Callable<d> g() {
        return new f(this.f38024b, this.f38026d, this.f38025c, this.f38027e, this.f38028f, this.f38029g, this.f38030h);
    }
}
