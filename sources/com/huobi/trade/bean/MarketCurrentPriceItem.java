package com.huobi.trade.bean;

import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import ej.f;
import i6.m;
import java.math.BigDecimal;
import k6.b;
import us.i;

public class MarketCurrentPriceItem implements b.a {

    /* renamed from: a  reason: collision with root package name */
    public double f81945a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f81946b;

    /* renamed from: c  reason: collision with root package name */
    public String f81947c;

    /* renamed from: d  reason: collision with root package name */
    public String f81948d;

    /* renamed from: e  reason: collision with root package name */
    public String f81949e;

    /* renamed from: f  reason: collision with root package name */
    public String f81950f;

    /* renamed from: g  reason: collision with root package name */
    public int f81951g;

    /* renamed from: h  reason: collision with root package name */
    public String f81952h;

    /* renamed from: i  reason: collision with root package name */
    public String f81953i;

    /* renamed from: j  reason: collision with root package name */
    public int f81954j;

    /* renamed from: k  reason: collision with root package name */
    public int f81955k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f81956l;

    public String E0() {
        return this.f81948d;
    }

    public double a() {
        return this.f81945a;
    }

    public String b() {
        if (Double.compare(a(), 0.0d) == 0) {
            return "--";
        }
        int i11 = this.f81951g;
        if (i11 == 3) {
            return m.i(a(), f.p(E0()));
        }
        if (i11 == 4) {
            return m.i(a(), i.f(o0()));
        }
        if (i11 == 5) {
            return m.i(a(), FuturePrecisionUtil.y("", "", this.f81949e));
        }
        if (i11 == 6) {
            return m.i(a(), FuturePrecisionUtil.y(this.f81948d, this.f81950f, ""));
        }
        return m.w(a(), PrecisionUtil.e(o0()));
    }

    public int c() {
        return this.f81954j;
    }

    public int d() {
        return this.f81955k;
    }

    public boolean e() {
        return this.f81956l;
    }

    public int f() {
        if (i()) {
            return ContextCompat.getColor(BaseApplication.b(), w.h());
        }
        return ContextCompat.getColor(BaseApplication.b(), w.d());
    }

    public String g() {
        if (TextUtils.isEmpty(this.f81952h) || BigDecimal.ZERO.compareTo(new BigDecimal(this.f81952h)) == 0) {
            this.f81952h = null;
        }
        return this.f81952h;
    }

    public String h() {
        return this.f81953i;
    }

    public boolean i() {
        return this.f81946b;
    }

    public void j() {
        this.f81945a = 0.0d;
        this.f81952h = "";
    }

    public void k(String str) {
        this.f81948d = str;
    }

    public void l(String str) {
        this.f81950f = str;
    }

    public void m(String str) {
        this.f81953i = str;
    }

    public void n(boolean z11) {
        this.f81946b = z11;
    }

    public void o(String str) {
        this.f81952h = str;
    }

    public String o0() {
        return this.f81947c;
    }

    public void p(double d11) {
        this.f81945a = d11;
    }

    public void q(String str) {
        this.f81947c = str;
    }

    public void r(int i11) {
        this.f81951g = i11;
    }
}
