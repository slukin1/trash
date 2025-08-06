package com.huobi.finance.bean;

import al.t;
import android.text.TextUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.asset.AssetAccountType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.viewhandler.AssetPositionCoinItemViewHandler;
import com.xiaomi.mipush.sdk.Constants;
import i6.m;
import java.math.BigDecimal;
import wi.a;

public class AssetPositionCoinData extends BasePositionSortAccountItem<AssetPositionCoinData> {

    /* renamed from: b  reason: collision with root package name */
    public String f45255b;

    /* renamed from: c  reason: collision with root package name */
    public String f45256c;

    /* renamed from: d  reason: collision with root package name */
    public String f45257d;

    /* renamed from: e  reason: collision with root package name */
    public String f45258e;

    /* renamed from: f  reason: collision with root package name */
    public String f45259f;

    /* renamed from: g  reason: collision with root package name */
    public String f45260g;

    /* renamed from: h  reason: collision with root package name */
    public String f45261h;

    /* renamed from: i  reason: collision with root package name */
    public String f45262i;

    /* renamed from: j  reason: collision with root package name */
    public String f45263j;

    /* renamed from: k  reason: collision with root package name */
    public String f45264k;

    /* renamed from: l  reason: collision with root package name */
    public BalanceDetailInfo f45265l;

    /* renamed from: m  reason: collision with root package name */
    public String f45266m;

    /* renamed from: n  reason: collision with root package name */
    public String f45267n;

    /* renamed from: o  reason: collision with root package name */
    public AssetAccountType f45268o = AssetAccountType.SPOT;

    public String A() {
        if (TextUtils.isEmpty(this.f45259f)) {
            return "--";
        }
        return LegalCurrencyConfigUtil.E("usdt", this.f45259f);
    }

    public String B() {
        if (TextUtils.isEmpty(this.f45260g)) {
            return "--".equals(A()) ? "" : "--";
        }
        return g(m.Q(this.f45260g, 2, 1));
    }

    public void C(String str) {
        this.f45257d = str;
    }

    public void D(String str) {
        this.f45261h = str;
    }

    public void E(String str) {
        this.f45264k = str;
    }

    public void F(String str) {
        this.f45256c = str;
    }

    public void G(String str) {
        this.f45258e = str;
    }

    public void H(String str) {
        this.f45266m = str;
    }

    public void I(String str) {
        this.f45267n = str;
    }

    public void J(String str) {
        this.f45262i = str;
    }

    public void K(String str) {
        this.f45263j = str;
    }

    public void L(String str) {
        this.f45255b = str;
    }

    public void M(String str) {
        this.f45259f = str;
    }

    public void N(String str) {
        this.f45260g = str;
    }

    public boolean c() {
        BigDecimal b11 = t.b(this.f45255b, this.f45258e, (BigDecimal) null);
        if (b11 == null) {
            if (m.a(this.f45258e).compareTo(BigDecimal.ZERO) != 0 || m.a(this.f45264k).compareTo(BigDecimal.ZERO) < 0) {
                return false;
            }
            return true;
        } else if (b11.abs().compareTo(a.f48036a) >= 0 || m.a(this.f45264k).compareTo(BigDecimal.ZERO) < 0) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: e */
    public int a(int i11, AssetPositionCoinData assetPositionCoinData) {
        int f11 = f(i11, assetPositionCoinData);
        return f11 == 0 ? z().compareTo(assetPositionCoinData.z()) : f11;
    }

    public int f(int i11, AssetPositionCoinData assetPositionCoinData) {
        if (i11 == 1) {
            return m.a(LegalCurrencyConfigUtil.E(z(), this.f45258e)).compareTo(m.a(LegalCurrencyConfigUtil.E(assetPositionCoinData.z(), assetPositionCoinData.s())));
        } else if (i11 == 2) {
            return m.a(LegalCurrencyConfigUtil.E(z(), u())).compareTo(m.a(LegalCurrencyConfigUtil.E(assetPositionCoinData.z(), assetPositionCoinData.u())));
        } else {
            if (i11 != 3) {
                return 0;
            }
            return m.a(v()).compareTo(m.a(assetPositionCoinData.v()));
        }
    }

    public final String g(String str) {
        String str2 = str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER) ? "" : "+";
        return str2 + str;
    }

    public String getViewHandlerName() {
        return AssetPositionCoinItemViewHandler.class.getName();
    }

    public String h() {
        return g(x());
    }

    public String i() {
        return y();
    }

    public String j() {
        return this.f45257d;
    }

    public String k() {
        if (TextUtils.isEmpty(this.f45261h)) {
            return "--";
        }
        return LegalCurrencyConfigUtil.E("usdt", this.f45261h);
    }

    public String l() {
        return this.f45264k;
    }

    public String m() {
        return k();
    }

    public String n() {
        return LegalCurrencyConfigUtil.E(this.f45255b, "1");
    }

    public String o() {
        return g(A());
    }

    public String p() {
        return B();
    }

    public BalanceDetailInfo q() {
        BalanceDetailInfo balanceDetailInfo = this.f45265l;
        if (balanceDetailInfo != null) {
            return balanceDetailInfo;
        }
        BalanceDetailInfo balanceDetailInfo2 = new BalanceDetailInfo();
        balanceDetailInfo2.setCurrency(this.f45255b);
        balanceDetailInfo2.setAvaialAble(this.f45257d);
        balanceDetailInfo2.setOnOrders(this.f45267n);
        balanceDetailInfo2.setEstimateAmount(LegalCurrencyConfigUtil.E(this.f45255b, this.f45257d));
        balanceDetailInfo2.setDisplayName(this.f45256c);
        balanceDetailInfo2.setLock(this.f45266m);
        balanceDetailInfo2.setTradeType(TradeType.PRO);
        return balanceDetailInfo2;
    }

    public String r() {
        return this.f45256c;
    }

    public String s() {
        return this.f45258e;
    }

    public AssetAccountType t() {
        return this.f45268o;
    }

    public String u() {
        return this.f45259f;
    }

    public String v() {
        return this.f45260g;
    }

    public String w() {
        return LegalCurrencyConfigUtil.E(this.f45255b, s());
    }

    public String x() {
        if (TextUtils.isEmpty(this.f45262i)) {
            return "--";
        }
        return LegalCurrencyConfigUtil.E("usdt", this.f45262i);
    }

    public String y() {
        if (TextUtils.isEmpty(this.f45263j)) {
            return "--".equals(x()) ? "" : "--";
        }
        return g(m.Q(this.f45263j, 2, 1));
    }

    public String z() {
        return this.f45255b;
    }
}
