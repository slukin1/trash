package com.huobi.finance.bean;

import al.t;
import com.huobi.asset.AssetAccountType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.viewhandler.AssetPositionOtcItemViewHandler;
import i6.m;
import wi.a;

public class AssetPositionOtcData extends BasePositionSortAccountItem<AssetPositionOtcData> {

    /* renamed from: b  reason: collision with root package name */
    public AssetAccountType f45316b = AssetAccountType.OTC;

    /* renamed from: c  reason: collision with root package name */
    public String f45317c;

    /* renamed from: d  reason: collision with root package name */
    public String f45318d;

    /* renamed from: e  reason: collision with root package name */
    public String f45319e;

    /* renamed from: f  reason: collision with root package name */
    public String f45320f;

    /* renamed from: g  reason: collision with root package name */
    public int f45321g;

    public boolean c() {
        return t.a(i(), m.a(g()).add(m.a(l())).toPlainString()).abs().compareTo(a.f48036a) < 0;
    }

    /* renamed from: e */
    public int a(int i11, AssetPositionOtcData assetPositionOtcData) {
        if (i11 != 1 && i11 != 2 && i11 != 3) {
            return 0;
        }
        return m.a(LegalCurrencyConfigUtil.E(this.f45317c, f())).compareTo(m.a(LegalCurrencyConfigUtil.E(assetPositionOtcData.i(), assetPositionOtcData.f())));
    }

    public String f() {
        return m.a(g()).add(m.a(l())).toPlainString();
    }

    public String g() {
        return this.f45320f;
    }

    public String getViewHandlerName() {
        return AssetPositionOtcItemViewHandler.class.getName();
    }

    public int h() {
        return this.f45321g;
    }

    public String i() {
        return this.f45317c;
    }

    public String j() {
        return this.f45318d;
    }

    public AssetAccountType k() {
        return this.f45316b;
    }

    public String l() {
        return this.f45319e;
    }

    public void m(String str) {
        this.f45320f = str;
    }

    public void n(int i11) {
        this.f45321g = i11;
    }

    public void o(String str) {
        this.f45317c = str;
    }

    public void p(String str) {
        this.f45318d = str;
    }

    public void q(String str) {
        this.f45319e = str;
    }
}
