package com.hbg.module.kline.bean;

import a7.e;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.kline.R$color;
import com.hbg.module.kline.R$dimen;
import i6.d;
import i6.m;
import k6.c;
import td.h;
import td.i;

public class KlineBuySellItem implements c.a {

    /* renamed from: a  reason: collision with root package name */
    public double f23507a;

    /* renamed from: b  reason: collision with root package name */
    public double f23508b;

    /* renamed from: c  reason: collision with root package name */
    public int f23509c;

    /* renamed from: d  reason: collision with root package name */
    public int f23510d;

    /* renamed from: e  reason: collision with root package name */
    public int f23511e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f23512f;

    /* renamed from: g  reason: collision with root package name */
    public String f23513g;

    /* renamed from: h  reason: collision with root package name */
    public String f23514h;

    /* renamed from: i  reason: collision with root package name */
    public String f23515i;

    /* renamed from: j  reason: collision with root package name */
    public String f23516j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f23517k;

    /* renamed from: l  reason: collision with root package name */
    public int f23518l;

    /* renamed from: m  reason: collision with root package name */
    public TradeType f23519m;

    public void A(boolean z11) {
        this.f23512f = z11;
    }

    public void B(String str) {
        this.f23514h = str;
    }

    public void C(int i11) {
        this.f23510d = i11;
    }

    public void D(double d11) {
        this.f23507a = d11;
    }

    public void E(int i11) {
        this.f23511e = i11;
    }

    public String E0() {
        return this.f23515i;
    }

    public void F(String str) {
        this.f23513g = str;
    }

    public void G(int i11) {
        this.f23518l = i11;
    }

    public void H(int i11) {
        this.f23509c = i11;
    }

    public double a() {
        return this.f23507a;
    }

    public String b() {
        if (Double.compare(a(), 0.0d) == 0) {
            return "--";
        }
        int i11 = this.f23518l;
        if (i11 == 1 || i11 == 0) {
            return m.w(a(), PrecisionUtil.e(o0()));
        }
        if (i11 == 3) {
            return m.w(a(), i.a().b().z(E0()));
        }
        if (i11 == 4) {
            return m.w(a(), i.a().b().y(o0()));
        }
        if (q() == TradeType.CONTRACT) {
            return m.w(a(), i.a().b().z(E0()));
        }
        if (q() == TradeType.SWAP) {
            return m.w(a(), i.a().b().y(o0()));
        }
        if (TradeType.isOption(q())) {
            return m.w(a(), FuturePrecisionUtil.y("", p(), r()));
        }
        if (TradeType.isLinearSwap(q())) {
            return m.w(a(), FuturePrecisionUtil.y(E0(), p(), ""));
        }
        return m.w(a(), PrecisionUtil.e(o0()));
    }

    public boolean c() {
        if (Double.compare(a(), 0.0d) == 0) {
            return false;
        }
        return v();
    }

    public int d(Context context) {
        int i11;
        if (t() == 0) {
            if (w.l()) {
                i11 = R$color.base_trade_sell_click_color;
            } else {
                i11 = R$color.base_trade_buy_click_color;
            }
        } else if (w.l()) {
            i11 = R$color.base_trade_buy_click_color;
        } else {
            i11 = R$color.base_trade_sell_click_color;
        }
        return ContextCompat.getColor(context, i11);
    }

    public double e() {
        return this.f23508b;
    }

    public boolean f() {
        int i11 = this.f23518l;
        if (i11 == 1) {
            return false;
        }
        return i11 == 0 || i11 == 2;
    }

    public int g(Context context) {
        if (t() == 0) {
            if (w.l()) {
                return ContextCompat.getColor(context, R$color.trade_market_sell_item_progress);
            }
            return ContextCompat.getColor(context, R$color.trade_market_buy_item_progress);
        } else if (w.l()) {
            return ContextCompat.getColor(context, R$color.trade_market_buy_item_progress);
        } else {
            return ContextCompat.getColor(context, R$color.trade_market_sell_item_progress);
        }
    }

    public String getIndex() {
        return String.valueOf(this.f23510d);
    }

    public int h() {
        int i11 = this.f23518l;
        if (i11 == 1) {
            return 0;
        }
        return (i11 == 0 || i11 == 2) ? this.f23509c == 0 ? 1 : 0 : (i11 == 3 || i11 == 4 || this.f23509c != 0) ? 0 : 1;
    }

    public float i(Context context) {
        int i11 = this.f23518l;
        if (i11 == 0 || i11 == 2) {
            return (float) context.getResources().getDimensionPixelOffset(R$dimen.dimen_5);
        }
        return 0.0f;
    }

    public float j(Context context) {
        return (float) context.getResources().getDimensionPixelOffset(f() ? R$dimen.dimen_42 : R$dimen.global_margin_right);
    }

    public boolean k() {
        return u();
    }

    public float l() {
        return ((float) s()) / 100.0f;
    }

    public int m(Context context) {
        if (t() == 0) {
            return ContextCompat.getColor(context, w.h());
        }
        return ContextCompat.getColor(context, w.d());
    }

    public String n() {
        int i11;
        String i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        if (Double.compare(e(), 0.0d) == 0) {
            return "--";
        }
        h b11 = i.a().b();
        int i18 = this.f23518l;
        if (i18 == 1) {
            return m.X(m.i(e(), PrecisionUtil.d(o0())));
        }
        if (i18 == 0) {
            return m.i(e(), PrecisionUtil.d(o0()));
        }
        if (i18 == 3) {
            double e11 = e();
            if (e.E(this.f23519m)) {
                i17 = b11.t(E0());
            } else {
                i17 = b11.D(E0());
            }
            return m.X(m.i(e11, i17));
        }
        if (i18 == 4) {
            if (e.E(TradeType.SWAP)) {
                i16 = b11.G(o0());
            } else {
                i16 = b11.j(o0());
            }
            i12 = m.X(m.i(e(), i16));
            d.b("MarketBuySellItem-->getStringAmount1-->  symbol:" + o0() + " getAmount():" + e() + " precision:" + i16 + " amountStr:" + i12);
        } else if (q() == TradeType.CONTRACT) {
            double e12 = e();
            if (e.E(this.f23519m)) {
                i15 = b11.t(E0());
            } else {
                i15 = b11.D(E0());
            }
            return m.i(e12, i15);
        } else {
            TradeType q11 = q();
            TradeType tradeType = TradeType.SWAP;
            if (q11 == tradeType) {
                if (e.E(tradeType)) {
                    i14 = b11.G(o0());
                } else {
                    i14 = b11.j(o0());
                }
                i12 = m.i(e(), i14);
                d.b("MarketBuySellItem-->getStringAmount2-->  symbol:" + o0() + " getAmount():" + e() + " precision:" + i14 + " amountStr:" + i12);
            } else if (TradeType.isOption(q())) {
                if (e.E(this.f23519m)) {
                    i13 = FuturePrecisionUtil.s(E0(), "", r());
                } else {
                    i13 = FuturePrecisionUtil.B();
                }
                i12 = m.i(e(), i13);
                d.b("MarketBuySellItem-->getStringAmount2-->  symbol:" + o0() + " getAmount():" + e() + " precision:" + i13 + " amountStr:" + i12);
            } else if (!TradeType.isLinearSwap(q())) {
                return m.i(e(), PrecisionUtil.d(o0()));
            } else {
                if (e.F(this.f23519m)) {
                    i11 = FuturePrecisionUtil.s(E0(), p(), "");
                } else {
                    i11 = FuturePrecisionUtil.B();
                }
                i12 = m.i(e(), i11);
                d.b("MarketBuySellItem-->getStringAmount2-->  symbol:" + o0() + " getAmount():" + e() + " precision:" + i11 + " amountStr:" + i12);
            }
        }
        return i12;
    }

    public int o() {
        int i11 = this.f23518l;
        if (i11 == 1) {
            return 1;
        }
        if ((i11 == 0 || i11 == 2) && this.f23509c != 0) {
            return 0;
        }
        return 1;
    }

    public String o0() {
        return this.f23513g;
    }

    public String p() {
        return this.f23516j;
    }

    public TradeType q() {
        return this.f23519m;
    }

    public String r() {
        return this.f23514h;
    }

    public int s() {
        return this.f23511e;
    }

    public int t() {
        return this.f23509c;
    }

    public boolean u() {
        return this.f23512f;
    }

    public boolean v() {
        return this.f23517k;
    }

    public void w(double d11) {
        this.f23508b = d11;
    }

    public void x(String str) {
        this.f23515i = str;
    }

    public void y(String str) {
        this.f23516j = str;
    }

    public void z(TradeType tradeType) {
        this.f23519m = tradeType;
    }
}
