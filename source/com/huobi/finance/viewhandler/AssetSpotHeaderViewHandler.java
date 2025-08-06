package com.huobi.finance.viewhandler;

import al.p;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import bl.a1;
import bl.b1;
import bl.c1;
import bl.d1;
import bl.e1;
import bl.f1;
import bl.g1;
import bl.h1;
import bl.i1;
import bl.j1;
import bl.k1;
import bl.l1;
import bl.m1;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.YbbUserAssetInfoData;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$string;
import com.huobi.asset.feature.account.spot.AssetSpotFragment;
import com.huobi.asset.widget.AssetHeadView;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.ui.g7;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.k;
import i6.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import qh.i0;
import rx.Observable;
import uh.b;
import uh.i;
import v9.c;

public class AssetSpotHeaderViewHandler extends AssetHeaderViewHandler<AssetSpotFragment.a> {

    public class a implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f67597b;

        public a(Context context) {
            this.f67597b = context;
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            AssetModuleConfig.a().P0(this.f67597b, "btcusdt", false);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(Void voidR) {
        AssetHeadView<T> assetHeadView = this.f67577c;
        b.b(assetHeadView.f42424i, assetHeadView.getContext().getString(R$string.n_asset_spot_ybb_total_notice), PixelUtils.a(30.0f));
        BaseModuleConfig.a().w("app_spot_spotNetAssets_explanation_click", (HashMap) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void B(Void voidR) {
        AssetHeadView<T> assetHeadView = this.f67577c;
        b.b(assetHeadView.f42425j, assetHeadView.getContext().getString(R$string.n_asset_spot_total_notice), PixelUtils.a(30.0f));
        BaseModuleConfig.a().w("app_spot_balancesNetAssets_explanation_click", (HashMap) null);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void C(View view) {
        AssetModuleConfig.a().i1(view.getContext());
        AssetModuleConfig.a().track("app_spot_spotOrders_icon_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void D(AssetSpotFragment.a aVar) {
        AssetModuleConfig.a().E0(Boolean.TRUE);
        aVar.g().Jh();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void E(AssetSpotFragment.a aVar, View view) {
        new g7(this.f67577c.f42430o.getContext(), aVar.g(), new b1(aVar)).f();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void F(c cVar, View view) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("Page_name", "app_assets_Exchange_view");
        BaseModuleConfig.a().w("app_assets_balances_daily_click", hashMap);
        AssetModuleConfig.a().d1(cVar.itemView.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void u(View view) {
        AssetModuleConfig.a().r0(view.getContext());
        HashMap hashMap = new HashMap(1);
        hashMap.put("app_spot_topButton_click_button", "earn");
        AssetModuleConfig.a().track("app_spot_topButton_click", hashMap);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void v(View view) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("Page_name", "app_assets_Exchange_view");
        BaseModuleConfig.a().w("app_assets_transfer_click", hashMap);
        BaseModuleConfig.a().b("3525", (Map<String, Object>) null);
        AssetModuleConfig.a().q((Activity) view.getContext());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void w(View view) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("Page_name", "app_assets_Exchange_view");
        BaseModuleConfig.a().w("app_assets_deposit_click", hashMap);
        if (AssetModuleConfig.a().c()) {
            HuobiToastUtil.j(R$string.n_balance_subaccount_deposit_nosupport);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        BaseModuleConfig.a().b("3523", (Map<String, Object>) null);
        AssetModuleConfig.a().v0((Activity) view.getContext(), "1");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void x(View view) {
        HashMap hashMap = new HashMap(1);
        hashMap.put("Page_name", "app_assets_Exchange_view");
        BaseModuleConfig.a().w("app_assets_withdraw_click", hashMap);
        if (AssetModuleConfig.a().c()) {
            HuobiToastUtil.j(R$string.n_balance_subaccount_withdraw_nosupport);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        BaseModuleConfig.a().b("3524", (Map<String, Object>) null);
        AssetModuleConfig.a().v0((Activity) view.getContext(), "2");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void y(View view) {
        H(view.getContext(), this.f67577c.getContext().getString(R$string.n_asset_ybb_stop_total_balance_tips));
        AssetModuleConfig.a().track("app_spot_allAssets_illstrate_icon_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void z(View view) {
        String str;
        if (com.huobi.asset2.index.util.b.a().d()) {
            str = this.f67577c.getContext().getString(R$string.n_asset_risk_through_notice);
        } else {
            str = this.f67577c.getContext().getString(R$string.n_asset_risk_notice);
        }
        H(view.getContext(), str);
        AssetModuleConfig.a().track("app_spot_risk_explanation_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void H(Context context, String str) {
        String string = context.getString(R$string.n_introduction);
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
        new DialogUtils.b.d(fragmentActivity).c1(string).i1(5).R0(str).P0(context.getString(R$string.contract_trade_i_know)).T0(true).x0(false).q0(false).Q0(m1.f12666a).j0().show(fragmentActivity.getSupportFragmentManager(), "");
    }

    public final void I() {
        boolean z11 = false;
        this.f67577c.f42419d.setVisibility(0);
        this.f67577c.f42420e.setVisibility(0);
        this.f67577c.findViewById(R$id.profit_tips).setVisibility(0);
        Boolean F = AssetModuleConfig.a().F();
        if (F != null && F.booleanValue()) {
            z11 = true;
        }
        Boolean valueOf = Boolean.valueOf(z11);
        ViewUtil.m(this.f67577c.f42430o, true ^ valueOf.booleanValue());
        ViewUtil.m(this.f67577c.f42428m, valueOf.booleanValue());
        ViewUtil.m(this.f67577c.f42429n, valueOf.booleanValue());
    }

    public String b() {
        return "1";
    }

    public final void q(c cVar) {
        Resources resources = cVar.itemView.getResources();
        Context context = cVar.itemView.getContext();
        String string = resources.getString(R$string.balance_detail_deposit);
        String string2 = resources.getString(R$string.balance_detail_withdraw);
        String string3 = resources.getString(R$string.n_asset_ybb_stop_financial);
        String string4 = resources.getString(R$string.balance_margin_transfer);
        ArrayList arrayList = new ArrayList();
        if (AssetModuleConfig.a().j0()) {
            arrayList.add(new vk.c(resources.getString(R$string.n_balance_asset_disposal), new a(context)));
        } else if (!AssetModuleConfig.a().w()) {
            arrayList.add(new vk.c(string, i1.f12616b));
        }
        arrayList.add(new vk.c(string2, h1.f12604b));
        arrayList.add(new vk.c(string3, j1.f12632b));
        arrayList.add(new vk.c(string4, l1.f12656b));
        this.f67577c.i(arrayList);
    }

    public final void r(AssetSpotFragment.a aVar) {
        String str;
        if (aVar != null && aVar.c() != null) {
            YbbUserAssetInfoData ybbAsset = ((BalanceDataTotal) aVar.c()).getYbbAsset();
            this.f67577c.C.setVisibility(0);
            ViewUtil.m(this.f67577c.f42419d, false);
            this.f67577c.D(true, new e1(this));
            boolean e11 = com.huobi.asset2.index.util.b.a().e();
            ViewUtil.m(this.f67577c.f42423h, e11);
            if (e11) {
                this.f67577c.f42423h.setText(com.huobi.asset2.index.util.b.a().c(this.f67577c.getContext()));
                AssetHeadView<T> assetHeadView = this.f67577c;
                assetHeadView.f42423h.setBackgroundColor(assetHeadView.getResources().getColor(com.huobi.asset2.index.util.b.a().b()));
                if (com.huobi.asset2.index.util.b.a().c(this.f67577c.getContext()).equals(this.f67577c.getContext().getString(R$string.n_spot_order_not_risk))) {
                    this.f67577c.B.setVisibility(8);
                } else {
                    this.f67577c.B.setVisibility(0);
                }
            } else {
                this.f67577c.f42423h.setVisibility(8);
                this.f67577c.B.setVisibility(8);
            }
            this.f67577c.setSpotAssetDebtsTipsState(new a1(this));
            ViewUtil.m(this.f67577c.f42421f, false);
            ViewUtil.m(this.f67577c.A, false);
            ViewUtil.m(this.f67577c.f42424i, true);
            Observable<Void> a11 = dw.a.a(this.f67577c.f42424i);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            a11.throttleFirst(300, timeUnit).subscribe(new d1(this));
            ViewUtil.n(this.f67577c.f42422g, false);
            ViewUtil.m(this.f67577c.f42425j, true);
            dw.a.a(this.f67577c.f42425j).throttleFirst(300, timeUnit).subscribe(new c1(this));
            String netAssetToBtc = aVar.c().getNetAssetToBtc();
            String netAsset = aVar.c().getNetAsset();
            boolean z11 = i.d().f() && !m.b0(netAsset);
            if (!p.u()) {
                this.f67577c.C.l(z11);
                return;
            }
            BalanceProfitLossData c11 = i0.d().c();
            if (c11 != null) {
                String s11 = s(c11.getTodayCoinProfit());
                String todayCoinProfitRate = c11.getTodayCoinProfitRate();
                if (TextUtils.isEmpty(todayCoinProfitRate)) {
                    str = m.a(todayCoinProfitRate).toPlainString();
                } else {
                    str = m.Q(todayCoinProfitRate, 2, 1).replace("%", "");
                }
                this.f67577c.C.w(netAssetToBtc, netAsset, s11, str, ybbAsset, z11);
                if (ybbAsset == null) {
                    uh.a.b(this.f67577c.f42426k, (String) null, aVar.d());
                    return;
                }
                uh.a.b(this.f67577c.f42426k, s(p.i(m.a(m.a(netAssetToBtc).add(m.a(ybbAsset.getDigitalAssetTotalAmountByConvertCurrency())).toPlainString()).toPlainString(), k.C().p("btc"))), aVar.d());
            }
        }
    }

    public final String s(String str) {
        if (!m.a0(str)) {
            return "0.00";
        }
        String d11 = LegalCurrencyConfigUtil.d();
        if (!"btc".equals(d11)) {
            if ("usdt".equals(d11)) {
                str = m.u0(LegalCurrencyConfigUtil.U(str, false, "btcusdt", TradeType.PRO), 12, 2);
            } else {
                str = LegalCurrencyConfigUtil.D(str, "btcusdt", TradeType.PRO);
            }
        }
        if (!m.a0(str)) {
            return "0.00";
        }
        return str;
    }

    /* renamed from: t */
    public void handleView(c cVar, int i11, AssetSpotFragment.a aVar, ViewGroup viewGroup) {
        super.handleView(cVar, i11, aVar, viewGroup);
        I();
        q(cVar);
        this.f67577c.setRecordEntrance(k1.f12646b);
        this.f67577c.f42430o.setOnClickListener(new f1(this, aVar));
        r(aVar);
        AssetHeadView<T> assetHeadView = this.f67577c;
        assetHeadView.f42421f.setText(al.b.a(assetHeadView.getContext(), 1));
        AssetHeadView<T> assetHeadView2 = this.f67577c;
        assetHeadView2.f42424i.setBottomLineText(al.b.a(assetHeadView2.getContext(), 16));
        this.f67577c.f42419d.setOnClickListener(new g1(cVar));
    }
}
