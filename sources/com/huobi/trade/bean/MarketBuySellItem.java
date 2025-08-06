package com.huobi.trade.bean;

import a7.e;
import android.content.Context;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.R$color;
import com.hbg.lib.data.R$dimen;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import ej.f;
import i6.d;
import i6.m;
import k6.c;
import us.i;

public class MarketBuySellItem implements c.a {

    /* renamed from: a  reason: collision with root package name */
    public double f81928a;

    /* renamed from: b  reason: collision with root package name */
    public double f81929b;

    /* renamed from: c  reason: collision with root package name */
    public int f81930c;

    /* renamed from: d  reason: collision with root package name */
    public int f81931d;

    /* renamed from: e  reason: collision with root package name */
    public int f81932e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f81933f;

    /* renamed from: g  reason: collision with root package name */
    public String f81934g;

    /* renamed from: h  reason: collision with root package name */
    public String f81935h;

    /* renamed from: i  reason: collision with root package name */
    public String f81936i;

    /* renamed from: j  reason: collision with root package name */
    public String f81937j;

    /* renamed from: k  reason: collision with root package name */
    public ct.c f81938k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f81939l;

    /* renamed from: m  reason: collision with root package name */
    public int f81940m;

    /* renamed from: n  reason: collision with root package name */
    public double f81941n;

    /* renamed from: o  reason: collision with root package name */
    public TradeType f81942o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f81943p = true;

    /* renamed from: q  reason: collision with root package name */
    public boolean f81944q;

    public MarketBuySellItem() {
    }

    public void A(boolean z11) {
        this.f81944q = z11;
    }

    public void B(ct.c cVar) {
        this.f81938k = cVar;
    }

    public void C(TradeType tradeType) {
        this.f81942o = tradeType;
    }

    public void D(boolean z11) {
        this.f81933f = z11;
    }

    public void E(boolean z11) {
        this.f81939l = z11;
    }

    public String E0() {
        return this.f81935h;
    }

    public void F(double d11) {
        this.f81941n = d11;
    }

    public void G(int i11) {
        this.f81931d = i11;
    }

    public void H(double d11) {
        this.f81928a = d11;
    }

    public void I(int i11) {
        this.f81932e = i11;
    }

    public void J(String str) {
        this.f81934g = str;
    }

    public void K(int i11) {
        this.f81930c = i11;
    }

    public double a() {
        return this.f81928a;
    }

    public String b() {
        if (this.f81943p) {
            return "--";
        }
        int i11 = this.f81940m;
        if (i11 == 1 || i11 == 0) {
            return m.w(a(), PrecisionUtil.e(o0()));
        }
        if (i11 == 3) {
            return m.w(a(), f.p(E0()));
        }
        if (i11 == 4) {
            return m.w(a(), i.f(o0()));
        }
        if (i11 == 5) {
            return m.w(a(), FuturePrecisionUtil.y(E0(), p(), r()));
        }
        if (i11 == 6) {
            return m.w(a(), FuturePrecisionUtil.y(E0(), p(), r()));
        }
        if (q() == TradeType.CONTRACT) {
            return m.w(a(), f.p(E0()));
        }
        if (q() == TradeType.SWAP) {
            return m.w(a(), i.f(o0()));
        }
        if (TradeType.isOption(q())) {
            return m.w(a(), FuturePrecisionUtil.y(E0(), p(), r()));
        }
        if (TradeType.isLinearSwap(q())) {
            return m.w(a(), FuturePrecisionUtil.y(E0(), p(), r()));
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
        return this.f81929b;
    }

    public boolean f() {
        int i11;
        if (this.f81944q || (i11 = this.f81940m) == 1) {
            return false;
        }
        if (i11 == 0 || i11 == 2) {
            return true;
        }
        return false;
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
        return String.valueOf(this.f81931d);
    }

    public int h() {
        if (this.f81944q) {
            return this.f81930c == 0 ? 1 : 0;
        }
        int i11 = this.f81940m;
        if (i11 == 1) {
            return 0;
        }
        return (i11 == 0 || i11 == 2) ? this.f81930c == 0 ? 1 : 0 : (i11 == 3 || i11 == 4 || i11 == 5 || i11 == 6 || this.f81930c != 0) ? 0 : 1;
    }

    public float i(Context context) {
        if (this.f81944q) {
            return 0.0f;
        }
        int i11 = this.f81940m;
        if (i11 == 0 || i11 == 2) {
            return (float) context.getResources().getDimensionPixelOffset(R$dimen.dimen_5);
        }
        return 0.0f;
    }

    public float j(Context context) {
        if (this.f81944q) {
            return 0.0f;
        }
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
        int i12;
        String i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        if (Double.compare(e(), 0.0d) == 0) {
            return "--";
        }
        if (this.f81944q) {
            return m.X(m.i(e(), PrecisionUtil.d(o0())));
        }
        int i19 = this.f81940m;
        if (i19 == 1) {
            return m.X(m.i(e(), PrecisionUtil.d(o0())));
        }
        if (i19 == 0) {
            return m.i(e(), PrecisionUtil.d(o0()));
        }
        if (i19 == 3) {
            double e11 = e();
            if (e.E(TradeType.CONTRACT)) {
                i18 = f.n(E0());
            } else {
                i18 = f.t(E0());
            }
            return m.X(m.i(e11, i18));
        }
        if (i19 == 4) {
            if (e.E(TradeType.SWAP)) {
                i17 = i.e(o0());
            } else {
                i17 = i.z(o0());
            }
            i13 = m.X(m.i(e(), i17));
            d.b("MarketBuySellItem-->getStringAmount1-->  symbol:" + o0() + " getAmount():" + e() + " precision:" + i17 + " amountStr:" + i13);
        } else if (i19 == 5) {
            if (e.E(this.f81942o)) {
                i16 = FuturePrecisionUtil.s(E0(), p(), r());
            } else {
                i16 = FuturePrecisionUtil.B();
            }
            return m.X(m.i(e(), i16));
        } else if (i19 == 6) {
            if (e.E(this.f81942o)) {
                i15 = FuturePrecisionUtil.s(E0(), p(), r());
            } else {
                i15 = FuturePrecisionUtil.B();
            }
            if (e.G(this.f81942o)) {
                i15 = FuturePrecisionUtil.g(this.f81934g);
            }
            return m.X(m.i(e(), i15));
        } else {
            TradeType q11 = q();
            TradeType tradeType = TradeType.CONTRACT;
            if (q11 == tradeType) {
                double e12 = e();
                if (e.E(tradeType)) {
                    i14 = f.n(E0());
                } else {
                    i14 = f.t(E0());
                }
                return m.i(e12, i14);
            }
            TradeType q12 = q();
            TradeType tradeType2 = TradeType.SWAP;
            if (q12 == tradeType2) {
                if (e.E(tradeType2)) {
                    i12 = i.e(o0());
                } else {
                    i12 = i.z(o0());
                }
                i13 = m.i(e(), i12);
                d.b("MarketBuySellItem-->getStringAmount2-->  symbol:" + o0() + " getAmount():" + e() + " precision:" + i12 + " amountStr:" + i13);
            } else {
                TradeType q13 = q();
                TradeType tradeType3 = TradeType.OPTION;
                if (q13 != tradeType3) {
                    return m.i(e(), PrecisionUtil.d(o0()));
                }
                if (e.E(tradeType3)) {
                    i11 = FuturePrecisionUtil.s(E0(), p(), r());
                } else {
                    i11 = FuturePrecisionUtil.B();
                }
                return m.i(e(), i11);
            }
        }
        return i13;
    }

    public int o() {
        if (this.f81944q) {
            return this.f81930c == 0 ? 1 : 0;
        }
        int i11 = this.f81940m;
        if (i11 == 1) {
            return 1;
        }
        return ((i11 == 0 || i11 == 2) && this.f81930c != 0) ? 0 : 1;
    }

    public String o0() {
        return this.f81934g;
    }

    public String p() {
        return this.f81936i;
    }

    public TradeType q() {
        return this.f81942o;
    }

    public String r() {
        return this.f81937j;
    }

    public int s() {
        return this.f81932e;
    }

    public int t() {
        return this.f81930c;
    }

    public boolean u() {
        return this.f81933f;
    }

    public boolean v() {
        return this.f81939l;
    }

    public void w(double d11) {
        this.f81929b = d11;
    }

    public void x(String str) {
        this.f81935h = str;
    }

    public void y(String str) {
        this.f81936i = str;
    }

    public void z(boolean z11) {
        this.f81943p = z11;
    }

    public MarketBuySellItem(int i11, int i12) {
        this.f81930c = i11;
        this.f81940m = i12;
    }
}
