package com.huobi.finance.viewhandler;

import ad.b;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bl.b2;
import bl.c2;
import bl.d2;
import bl.e2;
import com.hbg.lib.widgets.LittlePieChartAnimView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.contract.entity.ContractUserInfo;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.bean.BalanceDataTotal;
import com.huobi.finance.bean.BaseAssetTotal;
import com.huobi.finance.bean.ContractDataTotal;
import com.huobi.finance.bean.LegalDataTotal;
import com.huobi.finance.bean.LinearSwapDataTotal;
import com.huobi.finance.bean.OptionDataTotal;
import com.huobi.finance.bean.SuperMarginDataTotal;
import com.huobi.finance.bean.SwapDataTotal;
import com.huobi.finance.ui.x2;
import com.huobi.finance.utils.AssetAnimHelper;
import com.huobi.finance.utils.UiFillUtil;
import com.huobi.finance.widget.RiskPanel;
import com.huobi.supermargin.bean.MarginOverview;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.i;
import i6.m;
import i6.r;
import i8.s;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.Map;
import m9.z;
import s9.c;
import z6.l;

public class AssetTotalViewHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public String f67610b;

    /* renamed from: c  reason: collision with root package name */
    public String f67611c;

    public static class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<LittlePieChartAnimView> f67612b;

        public a(LittlePieChartAnimView littlePieChartAnimView) {
            this.f67612b = new WeakReference<>(littlePieChartAnimView);
        }

        public void run() {
            LittlePieChartAnimView littlePieChartAnimView = (LittlePieChartAnimView) this.f67612b.get();
            if (littlePieChartAnimView != null) {
                littlePieChartAnimView.o(3);
                AssetAnimHelper.c(false);
            }
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void i(View view) {
        Context context = view.getContext();
        DialogUtils.X((FragmentActivity) oa.a.g().b(), context.getResources().getString(R$string.setting_quickly_withdraw_dialog_title), context.getResources().getString(R$string.super_margin_risk_rate_desc), (String) null, context.getResources().getString(R$string.allow_access_dialog_positive_btn), b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void j(BaseAssetTotal baseAssetTotal, View view) {
        HuobiToastUtil.j(R$string.balance_detail_no_asset_toast);
        if (baseAssetTotal instanceof BalanceDataTotal) {
            n();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void k(BaseAssetTotal baseAssetTotal, View view) {
        if (baseAssetTotal instanceof BalanceDataTotal) {
            n();
        }
        x2.a aVar = baseAssetTotal.showCallback;
        if (aVar != null) {
            aVar.I(baseAssetTotal);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void l(BaseAssetTotal baseAssetTotal, View view) {
        if (BaseAssetTotal.isZeroAsset(baseAssetTotal)) {
            HuobiToastUtil.j(R$string.balance_detail_no_asset_toast);
        } else {
            x2.a aVar = baseAssetTotal.showCallback;
            if (aVar != null) {
                aVar.I(baseAssetTotal);
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public String f(BaseAssetTotal baseAssetTotal) {
        return baseAssetTotal.getNetAssetToBtc();
    }

    /* renamed from: g */
    public void handleView(v9.c cVar, int i11, BaseAssetTotal baseAssetTotal, ViewGroup viewGroup) {
        String str;
        String str2;
        String str3;
        ContractUserInfo.UserBean userInfo;
        if (this.f67610b == null) {
            this.f67610b = cVar.itemView.getResources().getString(R$string.global_crossbar);
        }
        if (this.f67611c == null) {
            this.f67611c = cVar.itemView.getResources().getString(R$string.balance_hide_star);
        }
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.balance_header_hint);
        TextView textView2 = (TextView) e11.b(R$id.total_balance_header_bond);
        TextView textView3 = (TextView) e11.b(R$id.tv_total_amount);
        TextView textView4 = (TextView) e11.b(R$id.tv_total_amount_legal);
        ImageView imageView = (ImageView) e11.b(R$id.total_balance_header_chart);
        LittlePieChartAnimView littlePieChartAnimView = (LittlePieChartAnimView) e11.b(R$id.total_balance_header_chart_anim);
        if (baseAssetTotal == null) {
            str = "";
        } else {
            str = baseAssetTotal.getTitle();
        }
        UiFillUtil.a(textView, str);
        boolean z11 = baseAssetTotal instanceof LegalDataTotal;
        boolean z12 = false;
        boolean z13 = true;
        if (z11) {
            textView2.setVisibility(0);
            if (z11) {
                String y11 = m.y(((LegalDataTotal) baseAssetTotal).getTotalBurrow(), 0);
                String string = cVar.itemView.getResources().getString(R$string.balance_legal_bond);
                Object[] objArr = new Object[1];
                if (!baseAssetTotal.isShow()) {
                    y11 = this.f67611c;
                } else if (TextUtils.isEmpty(y11)) {
                    y11 = "0";
                }
                objArr[0] = y11;
                UiFillUtil.a(textView2, String.format(string, objArr));
            } else {
                UiFillUtil.a(textView2, String.format(cVar.itemView.getResources().getString(R$string.balance_legal_bond), new Object[]{this.f67610b}));
            }
        } else {
            textView2.setVisibility(8);
        }
        String str4 = null;
        String f11 = baseAssetTotal != null ? f(baseAssetTotal) : null;
        if (baseAssetTotal != null) {
            str4 = baseAssetTotal.getNetAsset();
        }
        if (!(!(baseAssetTotal instanceof ContractDataTotal) || (userInfo = AssetModuleConfig.a().getUserInfo()) == null || 1 == userInfo.getActiveState())) {
            z12 = true;
        }
        if ((baseAssetTotal instanceof SwapDataTotal) && !z.f().k()) {
            z12 = true;
        }
        if ((baseAssetTotal instanceof OptionDataTotal) && !l.c().h()) {
            z12 = true;
        }
        if (!(baseAssetTotal instanceof LinearSwapDataTotal) || s.d().f().getActiveState() == 1) {
            z13 = z12;
        }
        if (TextUtils.isEmpty(f11) || (baseAssetTotal.isShow() && z13)) {
            str2 = this.f67610b;
        } else if (baseAssetTotal.isShow()) {
            str2 = m.u0(f11, 12, 8);
        } else {
            str2 = this.f67611c;
        }
        if (TextUtils.isEmpty(str4) || (baseAssetTotal.isShow() && z13)) {
            str3 = this.f67610b;
        } else if (baseAssetTotal.isShow()) {
            str3 = LegalCurrencyConfigUtil.J(textView4.getContext(), str4);
        } else {
            str3 = this.f67611c;
        }
        UiFillUtil.a(textView4, str3);
        UiFillUtil.a(textView3, str2);
        if (h(baseAssetTotal)) {
            o(baseAssetTotal, imageView, littlePieChartAnimView);
        } else {
            imageView.setVisibility(8);
            littlePieChartAnimView.setVisibility(8);
        }
        if (baseAssetTotal instanceof SuperMarginDataTotal) {
            m((SuperMarginDataTotal) baseAssetTotal, e11);
        }
    }

    public int getResId() {
        return R$layout.item_balance_total;
    }

    public final boolean h(BaseAssetTotal baseAssetTotal) {
        return (baseAssetTotal instanceof BalanceDataTotal) || (baseAssetTotal instanceof ContractDataTotal) || (baseAssetTotal instanceof SwapDataTotal) || (baseAssetTotal instanceof LinearSwapDataTotal) || (baseAssetTotal instanceof OptionDataTotal);
    }

    public final void m(SuperMarginDataTotal superMarginDataTotal, r rVar) {
        RiskPanel riskPanel = (RiskPanel) rVar.b(R$id.risk_panel);
        riskPanel.setVisibility(0);
        MarginOverview marginOverview = superMarginDataTotal.getMarginOverview();
        if (marginOverview == null) {
            riskPanel.setData((MarginOverview) null);
        } else if (marginOverview.isLiquidation() || marginOverview.isNegativeAccount() || m.a(marginOverview.getTotalAmount()).compareTo(BigDecimal.ZERO) != 0) {
            riskPanel.setData(marginOverview);
        } else {
            riskPanel.setData((MarginOverview) null);
        }
        riskPanel.setOnRateClickListener(e2.f12575b);
    }

    public final void n() {
        AssetModuleConfig.a().L0("256", (Map<String, Object>) null);
    }

    public final void o(BaseAssetTotal baseAssetTotal, ImageView imageView, LittlePieChartAnimView littlePieChartAnimView) {
        int i11;
        if (!AssetAnimHelper.b()) {
            littlePieChartAnimView.setVisibility(8);
            imageView.setVisibility(0);
            if (BaseAssetTotal.isZeroAsset(baseAssetTotal)) {
                i11 = R$drawable.balance_btn_pie_gray;
            } else {
                i11 = R$drawable.balance_btn_pie;
            }
            imageView.setImageResource(i11);
            imageView.setOnClickListener(new b2(baseAssetTotal));
        } else if (BaseAssetTotal.isZeroAsset(baseAssetTotal)) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new d2(this, baseAssetTotal));
            imageView.setImageResource(R$drawable.balance_btn_pie_gray);
            littlePieChartAnimView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            littlePieChartAnimView.setVisibility(0);
            littlePieChartAnimView.setOnClickListener(new c2(this, baseAssetTotal));
            if (AssetAnimHelper.a()) {
                i.b().g(new a(littlePieChartAnimView), 2000);
            }
        }
    }
}
