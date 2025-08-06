package com.huobi.finance.bean;

import al.t;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.AssetOptionsInfo;
import com.huobi.asset.AssetAccountType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.viewhandler.AssetPositionWarrantItemViewHandler;
import i6.m;
import wi.a;

public class AssetPositionWarrantData extends BasePositionSortAccountItem<AssetPositionWarrantData> {

    /* renamed from: b  reason: collision with root package name */
    public AssetAccountType f45337b = AssetAccountType.WARRANT;

    /* renamed from: c  reason: collision with root package name */
    public AssetOptionsInfo f45338c;

    public boolean c() {
        return t.a(this.f45338c.getCurrency(), this.f45338c.getPosition()).abs().compareTo(a.f48036a) < 0;
    }

    /* renamed from: e */
    public int a(int i11, AssetPositionWarrantData assetPositionWarrantData) {
        if (i11 == 1) {
            return m.a(this.f45338c.getPosition()).compareTo(m.a(assetPositionWarrantData.f45338c.getPosition()));
        }
        if (i11 == 2) {
            return m.a(this.f45338c.getProfitLoss()).compareTo(m.a(assetPositionWarrantData.f45338c.getProfitLoss()));
        }
        if (i11 != 3) {
            return 0;
        }
        return m.a(this.f45338c.getProfitRate()).compareTo(m.a(assetPositionWarrantData.f45338c.getProfitRate()));
    }

    public OtcOptionsDetailInfo f() {
        if (this.f45338c == null) {
            return null;
        }
        OtcOptionsDetailInfo otcOptionsDetailInfo = new OtcOptionsDetailInfo();
        otcOptionsDetailInfo.setCurrency(this.f45338c.getCurrency());
        otcOptionsDetailInfo.setAvaialAble(this.f45338c.getAvailable());
        otcOptionsDetailInfo.setOnOrders(m.a(this.f45338c.getPosition()).subtract(m.a(this.f45338c.getAvailable())).toPlainString());
        otcOptionsDetailInfo.setEstimateAmount(LegalCurrencyConfigUtil.G(this.f45338c.getPosition(), this.f45338c.getCurrency(), TradeType.PRO));
        return otcOptionsDetailInfo;
    }

    public AssetOptionsInfo g() {
        return this.f45338c;
    }

    public String getViewHandlerName() {
        return AssetPositionWarrantItemViewHandler.class.getName();
    }

    public AssetAccountType h() {
        return this.f45337b;
    }

    public String i() {
        AssetOptionsInfo assetOptionsInfo = this.f45338c;
        return assetOptionsInfo != null ? assetOptionsInfo.getCurrency() : "";
    }

    public void j(AssetOptionsInfo assetOptionsInfo) {
        this.f45338c = assetOptionsInfo;
    }
}
