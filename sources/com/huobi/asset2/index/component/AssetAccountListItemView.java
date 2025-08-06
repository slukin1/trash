package com.huobi.asset2.index.component;

import al.p;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.asset.feature.summary.AssetSummaryAccountType;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gi.a;
import i6.m;

public class AssetAccountListItemView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public final TextView f42605b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f42606c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f42607d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f42608e;

    /* renamed from: f  reason: collision with root package name */
    public final View f42609f;

    /* renamed from: g  reason: collision with root package name */
    public final View f42610g;

    public AssetAccountListItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e(BalanceProfitLossData.AccountBalance accountBalance, View view) {
        c(accountBalance);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SuppressLint({"SetTextI18n"})
    public final void b(BalanceProfitLossData.AccountBalance accountBalance) {
        if (p.u()) {
            String u02 = m.u0(accountBalance.getAccountBalance(), 12, 8);
            String d11 = LegalCurrencyConfigUtil.d();
            TextView textView = this.f42606c;
            textView.setText(p.j(u02, "btc") + " BTC");
            if ("btc".equals(d11)) {
                this.f42607d.setText(LegalCurrencyConfigUtil.u(getContext(), u02));
            } else if ("usdt".equals(d11)) {
                this.f42607d.setText(LegalCurrencyConfigUtil.u(getContext(), m.u0(LegalCurrencyConfigUtil.U(u02, false, "btcusdt", TradeType.PRO), 12, 2)));
            } else {
                this.f42607d.setText(LegalCurrencyConfigUtil.u(getContext(), LegalCurrencyConfigUtil.D(u02, "btcusdt", TradeType.PRO)));
            }
        } else {
            this.f42606c.setText("*****");
            this.f42607d.setText("*****");
        }
    }

    public final void c(BalanceProfitLossData.AccountBalance accountBalance) {
        AssetSummaryAccountType assetSummaryAccountType = AssetSummaryAccountType.get(accountBalance.getDistributionType());
        if (assetSummaryAccountType != null) {
            AssetAccountType assetAccountType = assetSummaryAccountType.getAssetAccountType();
            if (getContext() instanceof Activity) {
                BaseModuleConfig.a().S((Activity) getContext(), assetAccountType.toString());
                a.l(assetAccountType.toString());
            }
        }
    }

    public void d(boolean z11) {
        ViewUtil.m(this.f42610g, !z11);
    }

    public void setData(BalanceProfitLossData.AccountBalance accountBalance) {
        this.f42605b.setText(accountBalance.getDistributionName());
        this.f42609f.setOnClickListener(new xh.a(this, accountBalance));
        boolean j11 = al.a.j(accountBalance);
        ViewUtil.m(this.f42608e, j11);
        ViewUtil.m(this.f42606c, !j11);
        ViewUtil.m(this.f42607d, !j11);
        if (j11) {
            this.f42608e.setText(R$string.contract_trade_safeguard);
        } else {
            b(accountBalance);
        }
    }

    public AssetAccountListItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssetAccountListItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f42609f = LayoutInflater.from(context).inflate(R$layout.item_asset_account_list, this);
        this.f42605b = (TextView) findViewById(R$id.tv_title);
        this.f42606c = (TextView) findViewById(R$id.tv_amount);
        this.f42607d = (TextView) findViewById(R$id.tv_amount_legal);
        this.f42608e = (TextView) findViewById(R$id.tv_state);
        this.f42610g = findViewById(R$id.tv_amount_bottom_line);
    }
}
