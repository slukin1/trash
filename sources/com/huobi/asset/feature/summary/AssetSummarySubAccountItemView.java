package com.huobi.asset.feature.summary;

import al.p;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import qh.f0;

public class AssetSummarySubAccountItemView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f42398b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f42399c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f42400d;

    /* renamed from: e  reason: collision with root package name */
    public View f42401e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42402f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42403g;

    /* renamed from: h  reason: collision with root package name */
    public BalanceProfitLossData.AccountBalance f42404h;

    /* renamed from: i  reason: collision with root package name */
    public String f42405i;

    /* renamed from: j  reason: collision with root package name */
    public String f42406j;

    /* renamed from: k  reason: collision with root package name */
    public String f42407k;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f42408a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.huobi.asset.feature.summary.AssetSummaryAccountType[] r0 = com.huobi.asset.feature.summary.AssetSummaryAccountType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f42408a = r0
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.DELIVERY_CONTRACT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f42408a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.SWAP     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f42408a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.LINEAR_SWAP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f42408a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.asset.feature.summary.AssetSummaryAccountType r1 = com.huobi.asset.feature.summary.AssetSummaryAccountType.OPTION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.asset.feature.summary.AssetSummarySubAccountItemView.a.<clinit>():void");
        }
    }

    public AssetSummarySubAccountItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void e(View view) {
        c();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void b(BalanceProfitLossData.AccountBalance accountBalance) {
        this.f42404h = accountBalance;
        if (accountBalance != null) {
            if (!StringUtils.r(accountBalance.getDistributionName())) {
                this.f42398b.setText(accountBalance.getDistributionName());
            }
            if (!accountBalance.isOpened()) {
                this.f42399c.setVisibility(0);
                this.f42400d.setVisibility(8);
                this.f42401e.setVisibility(8);
            } else if (al.a.k(this.f42404h)) {
                this.f42399c.setVisibility(8);
                this.f42400d.setVisibility(0);
                this.f42401e.setVisibility(8);
            } else {
                this.f42399c.setVisibility(8);
                this.f42400d.setVisibility(8);
                this.f42401e.setVisibility(0);
                String u02 = m.u0(accountBalance.getAccountBalance(), 12, 8);
                this.f42405i = u02;
                this.f42406j = LegalCurrencyConfigUtil.D(u02, "btcusdt", TradeType.PRO);
                this.f42406j = LegalCurrencyConfigUtil.J(getContext(), this.f42406j);
                f();
            }
        }
    }

    public final void c() {
        AssetSummaryAccountType assetSummaryAccountType;
        BalanceProfitLossData.AccountBalance accountBalance = this.f42404h;
        if (accountBalance != null && (assetSummaryAccountType = AssetSummaryAccountType.get(accountBalance.getDistributionType())) != null) {
            TradeType tradeType = null;
            int i11 = a.f42408a[assetSummaryAccountType.ordinal()];
            if (i11 == 1) {
                tradeType = TradeType.CONTRACT;
            } else if (i11 == 2) {
                tradeType = TradeType.SWAP;
            } else if (i11 == 3) {
                tradeType = TradeType.LINEAR_SWAP;
            } else if (i11 == 4) {
                tradeType = TradeType.OPTION;
            }
            if (tradeType != null) {
                AssetModuleConfig.a().g0(getContext(), true, tradeType);
            }
        }
    }

    public final void d() {
        LayoutInflater.from(getContext()).inflate(R$layout.item_asset_summary_account_sub, this);
        this.f42407k = getContext().getResources().getString(R$string.balance_hide_star);
        this.f42398b = (TextView) findViewById(R$id.sub_account_tv_name);
        this.f42399c = (TextView) findViewById(R$id.sub_account_tv_go_open);
        this.f42400d = (TextView) findViewById(R$id.sub_account_tv_maintenance);
        this.f42401e = findViewById(R$id.sub_account_amount_panel);
        this.f42402f = (TextView) findViewById(R$id.sub_account_tv_amount);
        this.f42403g = (TextView) findViewById(R$id.sub_account_tv_amount_cny);
        this.f42399c.setOnClickListener(new f0(this));
    }

    public void f() {
        if (p.u()) {
            TextView textView = this.f42402f;
            textView.setText(p.j(this.f42405i, "btc") + " BTC");
            this.f42403g.setText(this.f42406j);
            return;
        }
        this.f42402f.setText(this.f42407k);
        this.f42403g.setText(this.f42407k);
    }

    public AssetSummarySubAccountItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AssetSummarySubAccountItemView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0);
    }

    public AssetSummarySubAccountItemView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        d();
    }
}
