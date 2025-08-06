package com.huobi.asset.widget;

import al.p;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.widgets.LittlePieChartAnimView;
import com.hbg.lib.widgets.NumAnimTextView;
import com.hbg.lib.widgets.NumberAnimView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$drawable;
import com.hbg.module.asset.R$font;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$string;
import com.huobi.asset.widget.AssetHeadView.AssetHeadData;
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
import com.huobi.finance.widget.RiskPanelNew;
import com.huobi.supermargin.bean.MarginOverview;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import i8.s;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import m9.z;
import org.greenrobot.eventbus.EventBus;
import vh.e;
import vh.f;
import vh.g;
import vh.h;
import vh.i;
import vh.j;
import vh.k;
import z6.l;

public class AssetHeadView<T extends AssetHeadData> extends FrameLayout {
    public View A;
    public View B;
    public AssetSpotYbbHeaderView C;
    public boolean D = false;

    /* renamed from: b  reason: collision with root package name */
    public String f42417b;

    /* renamed from: c  reason: collision with root package name */
    public String f42418c;

    /* renamed from: d  reason: collision with root package name */
    public View f42419d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f42420e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f42421f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f42422g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f42423h;

    /* renamed from: i  reason: collision with root package name */
    public BottomLineTextView f42424i;

    /* renamed from: j  reason: collision with root package name */
    public BottomLineTextView f42425j;

    /* renamed from: k  reason: collision with root package name */
    public NumAnimTextView f42426k;

    /* renamed from: l  reason: collision with root package name */
    public NumAnimTextView f42427l;

    /* renamed from: m  reason: collision with root package name */
    public View f42428m;

    /* renamed from: n  reason: collision with root package name */
    public View f42429n;

    /* renamed from: o  reason: collision with root package name */
    public View f42430o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f42431p;

    /* renamed from: q  reason: collision with root package name */
    public NumAnimTextView f42432q;

    /* renamed from: r  reason: collision with root package name */
    public NumAnimTextView f42433r;

    /* renamed from: s  reason: collision with root package name */
    public String f42434s;

    /* renamed from: t  reason: collision with root package name */
    public ImageView f42435t;

    /* renamed from: u  reason: collision with root package name */
    public ImageView f42436u;

    /* renamed from: v  reason: collision with root package name */
    public LittlePieChartAnimView f42437v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f42438w;

    /* renamed from: x  reason: collision with root package name */
    public RiskPanelNew f42439x;

    /* renamed from: y  reason: collision with root package name */
    public BaseAssetTotal f42440y;

    /* renamed from: z  reason: collision with root package name */
    public View f42441z;

    public static abstract class AssetHeadData implements s9.a {

        /* renamed from: b  reason: collision with root package name */
        public BaseAssetTotal f42442b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f42443c = true;

        public boolean a(Object obj) {
            return obj instanceof AssetHeadData;
        }

        public BaseAssetTotal c() {
            return this.f42442b;
        }

        public boolean d() {
            return this.f42443c;
        }

        public void e(BaseAssetTotal baseAssetTotal) {
            this.f42442b = baseAssetTotal;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AssetHeadData)) {
                return false;
            }
            AssetHeadData assetHeadData = (AssetHeadData) obj;
            if (!assetHeadData.a(this)) {
                return false;
            }
            BaseAssetTotal c11 = c();
            BaseAssetTotal c12 = assetHeadData.c();
            if (c11 != null ? c11.equals(c12) : c12 == null) {
                return d() == assetHeadData.d();
            }
            return false;
        }

        public void f(boolean z11) {
            this.f42443c = z11;
        }

        public int hashCode() {
            BaseAssetTotal c11 = c();
            return (((c11 == null ? 43 : c11.hashCode()) + 59) * 59) + (d() ? 79 : 97);
        }

        public String toString() {
            return "AssetHeadView.AssetHeadData(assetTotal=" + c() + ", showAnim=" + d() + ")";
        }
    }

    public static class b implements NumberAnimView.b {
        public b() {
        }

        public String a(String str) {
            if (!m.a0(str)) {
                return str;
            }
            String str2 = m.a(str).compareTo(BigDecimal.ZERO) > 0 ? "+" : "";
            String str3 = "%";
            if (m.a(str).compareTo(m.a("10000")) > 0) {
                str3 = "⁺" + str3;
                str = "10000";
            }
            if (m.a(str).compareTo(m.a("-100")) < 0) {
                str = "-100";
            }
            return str2 + str + str3;
        }
    }

    public static class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public WeakReference<LittlePieChartAnimView> f42444b;

        public c(LittlePieChartAnimView littlePieChartAnimView) {
            this.f42444b = new WeakReference<>(littlePieChartAnimView);
        }

        public void run() {
            LittlePieChartAnimView littlePieChartAnimView = (LittlePieChartAnimView) this.f42444b.get();
            if (littlePieChartAnimView != null) {
                littlePieChartAnimView.o(3);
                AssetAnimHelper.c(false);
            }
        }
    }

    public AssetHeadView(Context context) {
        super(context);
        s(context);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void A(BaseAssetTotal baseAssetTotal, View view) {
        C();
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

    public static /* synthetic */ String t(String str) {
        if (!m.a0(str)) {
            return str;
        }
        String str2 = m.a(str).compareTo(BigDecimal.ZERO) > 0 ? "+" : "";
        return str2 + str;
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void u(Resources resources, View view) {
        DialogUtils.X((FragmentActivity) oa.a.g().b(), resources.getString(R$string.setting_quickly_withdraw_dialog_title), resources.getString(R$string.income_today_tips), "", resources.getString(R$string.otc_ppace_order_dialog_btn_know), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ String v(String str) {
        if (!m.a0(str)) {
            return str;
        }
        return "≈ " + str + " " + LegalCurrencyConfigUtil.d().toUpperCase(Locale.US);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void w(View view) {
        p.v();
        boolean u11 = p.u();
        H();
        EventBus.d().k(new gh.b(u11));
        AssetModuleConfig.a().track("app_spot_hide_click", (HashMap) null);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void x(View view) {
        Context context = view.getContext();
        DialogUtils.X((FragmentActivity) oa.a.g().b(), context.getResources().getString(R$string.setting_quickly_withdraw_dialog_title), context.getResources().getString(R$string.super_margin_risk_rate_desc), (String) null, context.getResources().getString(R$string.allow_access_dialog_positive_btn), ad.b.f3517a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void y(View view) {
        HuobiToastUtil.j(R$string.balance_detail_no_asset_toast);
        C();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void z(BaseAssetTotal baseAssetTotal, View view) {
        C();
        x2.a aVar = baseAssetTotal.showCallback;
        if (aVar != null) {
            aVar.I(baseAssetTotal);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void B(SuperMarginDataTotal superMarginDataTotal) {
        this.f42439x.setVisibility(0);
        MarginOverview marginOverview = superMarginDataTotal.getMarginOverview();
        if (marginOverview == null) {
            this.f42439x.setData((MarginOverview) null);
        } else if (marginOverview.isLiquidation() || marginOverview.isNegativeAccount() || m.a(marginOverview.getTotalAmount()).compareTo(BigDecimal.ZERO) != 0) {
            this.f42439x.setData(marginOverview);
        } else {
            this.f42439x.setData((MarginOverview) null);
        }
        this.f42439x.setOnRateClickListener(j.f61039b);
    }

    public final void C() {
        String str;
        BaseAssetTotal baseAssetTotal = this.f42440y;
        if (baseAssetTotal instanceof BalanceDataTotal) {
            str = "app_assets_Exchange_view";
        } else if (baseAssetTotal instanceof ContractDataTotal) {
            str = "app_assets_derivatives_coin_M_futures_view";
        } else if (baseAssetTotal instanceof SwapDataTotal) {
            str = "app_assets_derivatives_coin_M_swaps_view";
        } else if (baseAssetTotal instanceof LinearSwapDataTotal) {
            str = "app_assets_derivatives_usdt_M_swaps_view";
        } else {
            str = baseAssetTotal instanceof OptionDataTotal ? "app_assets_derivatives_options_view" : null;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("Page_name", str);
        BaseModuleConfig.a().w("app_assets_analysis_click", hashMap);
        if (!TextUtils.isEmpty(this.f42434s) && this.f42434s.equals("1")) {
            BaseModuleConfig.a().w("app_spot_assetsDistribution_icon_click", (HashMap) null);
        }
    }

    public void D(boolean z11, View.OnClickListener onClickListener) {
        ViewUtil.m(this.A, z11);
        if (onClickListener != null) {
            this.A.setOnClickListener(onClickListener);
        }
    }

    public final void E() {
        String upperCase = LegalCurrencyConfigUtil.d().toUpperCase(Locale.US);
        this.f42431p.setText(getResources().getString(R$string.n_balance_today_profit, new Object[]{StringUtils.i(upperCase)}));
    }

    public final boolean F() {
        return p.u();
    }

    public final void G(BaseAssetTotal baseAssetTotal, ImageView imageView, LittlePieChartAnimView littlePieChartAnimView) {
        int i11;
        if (!AssetAnimHelper.b()) {
            littlePieChartAnimView.setVisibility(8);
            imageView.setVisibility(0);
            if (BaseAssetTotal.isZeroAsset(baseAssetTotal)) {
                i11 = R$drawable.balance_btn_pie_grey_new;
            } else {
                i11 = R$drawable.balance_btn_pie_highlight_new;
            }
            imageView.setImageResource(i11);
            imageView.setOnClickListener(new h(this, baseAssetTotal));
        } else if (BaseAssetTotal.isZeroAsset(baseAssetTotal)) {
            imageView.setVisibility(0);
            imageView.setOnClickListener(new f(this));
            imageView.setImageResource(R$drawable.balance_btn_pie_grey_new);
            littlePieChartAnimView.setVisibility(8);
        } else {
            imageView.setVisibility(8);
            littlePieChartAnimView.setVisibility(0);
            littlePieChartAnimView.setOnClickListener(new i(this, baseAssetTotal));
            if (AssetAnimHelper.a()) {
                i6.i.b().g(new c(littlePieChartAnimView), 2000);
            }
        }
    }

    public final void H() {
        int i11;
        ImageView imageView = this.f42435t;
        if (p.u()) {
            i11 = R$drawable.balances_show;
        } else {
            i11 = R$drawable.balances_hide;
        }
        imageView.setImageResource(i11);
    }

    public void i(List<vk.c> list) {
        if (!CollectionsUtils.b(list)) {
            this.f42420e.removeAllViews();
            for (int i11 = 0; i11 < list.size(); i11++) {
                LinearLayout linearLayout = this.f42420e;
                linearLayout.addView(j(linearLayout, i11, list.get(i11)));
            }
            this.f42420e.setVisibility(0);
        }
    }

    public final View j(LinearLayout linearLayout, int i11, vk.c cVar) {
        TextView textView = (TextView) LayoutInflater.from(linearLayout.getContext()).inflate(R$layout.layout_asset_header_action, linearLayout, false);
        if (i11 > 0) {
            ((LinearLayout.LayoutParams) textView.getLayoutParams()).leftMargin = linearLayout.getResources().getDimensionPixelSize(R$dimen.dimen_8);
        }
        textView.setText(cVar.b());
        if (cVar.c() != null) {
            textView.setOnClickListener(cVar.c());
        }
        return textView;
    }

    public void k(T t11) {
        ContractUserInfo.UserBean userInfo;
        H();
        BaseAssetTotal c11 = t11.c();
        this.f42440y = c11;
        if (c11 != null) {
            m();
            BaseAssetTotal baseAssetTotal = this.f42440y;
            String str = null;
            String l11 = baseAssetTotal != null ? l(baseAssetTotal) : null;
            BaseAssetTotal baseAssetTotal2 = this.f42440y;
            if (baseAssetTotal2 != null) {
                str = baseAssetTotal2.getNetAsset();
            }
            String d11 = LegalCurrencyConfigUtil.d();
            boolean z11 = false;
            if ("btc".equals(d11)) {
                str = m.u0(l11, 12, 8);
            } else if ("usdt".equals(d11)) {
                str = m.u0(LegalCurrencyConfigUtil.U(l11, false, "btcusdt", TradeType.PRO), 12, 2);
            }
            boolean z12 = true;
            if (!(!(this.f42440y instanceof ContractDataTotal) || (userInfo = AssetModuleConfig.a().getUserInfo()) == null || 1 == userInfo.getActiveState())) {
                z11 = true;
            }
            if ((this.f42440y instanceof SwapDataTotal) && !z.f().k()) {
                z11 = true;
            }
            if ((this.f42440y instanceof OptionDataTotal) && !l.c().h()) {
                z11 = true;
            }
            if (!(this.f42440y instanceof LinearSwapDataTotal) || s.d().f().getActiveState() == 1) {
                z12 = z11;
            }
            if (F() && z12) {
                this.f42426k.setText(this.f42417b);
            } else if (!F()) {
                this.f42426k.setText(this.f42418c);
            } else if (!this.D) {
                uh.a.b(this.f42426k, m.a(str).toPlainString(), t11.d());
            }
            BaseAssetTotal baseAssetTotal3 = this.f42440y;
            if (baseAssetTotal3 instanceof SuperMarginDataTotal) {
                B((SuperMarginDataTotal) baseAssetTotal3);
            }
            n();
        }
    }

    public String l(BaseAssetTotal baseAssetTotal) {
        return baseAssetTotal.getNetAssetToBtc();
    }

    public final void m() {
        if (this.f42440y instanceof LegalDataTotal) {
            this.f42438w.setVisibility(0);
            String y11 = m.y(((LegalDataTotal) this.f42440y).getTotalBurrow(), 6);
            if (m.e0(m.a(y11), BigDecimal.ZERO)) {
                this.f42438w.setVisibility(8);
                return;
            }
            boolean F = F();
            String string = getResources().getString(R$string.balance_legal_bond);
            Object[] objArr = new Object[1];
            objArr[0] = F ? p.h(y11) : this.f42418c;
            UiFillUtil.a(this.f42438w, String.format(string, objArr));
            return;
        }
        this.f42438w.setVisibility(8);
    }

    public final void n() {
        if (o(this.f42440y)) {
            G(this.f42440y, this.f42436u, this.f42437v);
            return;
        }
        this.f42436u.setVisibility(8);
        this.f42437v.setVisibility(8);
    }

    public final boolean o(BaseAssetTotal baseAssetTotal) {
        return (baseAssetTotal instanceof BalanceDataTotal) || (baseAssetTotal instanceof ContractDataTotal) || (baseAssetTotal instanceof SwapDataTotal) || (baseAssetTotal instanceof LinearSwapDataTotal) || (baseAssetTotal instanceof OptionDataTotal);
    }

    public final void p(Resources resources, Context context, r rVar) {
        String upperCase = LegalCurrencyConfigUtil.d().toUpperCase(Locale.US);
        ((TextView) rVar.b(R$id.tv_profit_title)).setText(resources.getString(R$string.n_balance_today_profit, new Object[]{StringUtils.i(upperCase)}));
        this.f42419d = rVar.b(R$id.header_asset_analysis);
        this.f42428m = rVar.b(R$id.asset_analysis_title);
        this.f42429n = rVar.b(R$id.analysis_num);
        this.f42430o = rVar.b(R$id.asset_header_open_analysis_panel);
        NumAnimTextView numAnimTextView = (NumAnimTextView) rVar.b(R$id.profit_amount);
        this.f42432q = numAnimTextView;
        numAnimTextView.setText("--");
        this.f42432q.setTypeface(ResourcesCompat.h(getContext(), R$font.roboto_medium));
        this.f42432q.setCallback(k.f61041a);
        NumAnimTextView numAnimTextView2 = (NumAnimTextView) rVar.b(R$id.profit_amount_ratio);
        this.f42433r = numAnimTextView2;
        numAnimTextView2.setText("--");
        this.f42433r.setCallback(new b());
        rVar.b(R$id.profit_tips).setOnClickListener(new e(resources));
        E();
    }

    public final void q(Resources resources, r rVar) {
        this.f42426k = (NumAnimTextView) rVar.b(R$id.total_balance_header_balance);
        this.f42427l = (NumAnimTextView) rVar.b(R$id.total_balance_header_cny);
        this.f42426k.setText("--");
        this.f42427l.setText("--");
        this.f42427l.setVisibility(8);
        this.f42427l.setCallback(vh.l.f61043a);
        this.f42435t = (ImageView) rVar.b(R$id.header_iv_asset_show);
        H();
        this.f42435t.setVisibility(0);
        this.f42435t.setOnClickListener(new g(this));
    }

    public final void r() {
        if (this.f42417b == null) {
            this.f42417b = getResources().getString(R$string.global_crossbar);
        }
        if (this.f42418c == null) {
            this.f42418c = getResources().getString(R$string.balance_hide_star);
        }
    }

    public final void s(Context context) {
        LayoutInflater.from(context).inflate(R$layout.item_asset_header, this);
        r();
        r rVar = new r((View) this);
        this.f42421f = (TextView) rVar.b(R$id.header_tv_asset_total_title);
        this.f42422g = (TextView) rVar.b(R$id.asset_header_spot_balance_title);
        this.f42423h = (TextView) rVar.b(R$id.header_account_debts_action);
        this.f42424i = (BottomLineTextView) rVar.b(R$id.header_tv_asset_total_title_spot);
        this.f42425j = (BottomLineTextView) rVar.b(R$id.asset_header_spot_balance_title_ybb);
        this.f42431p = (TextView) rVar.b(R$id.tv_profit_title);
        BottomLineTextView bottomLineTextView = this.f42424i;
        int i11 = R$color.balance_margin_text_color;
        bottomLineTextView.setTextColor(i11);
        this.f42425j.setTextColor(i11);
        q(getResources(), rVar);
        p(getResources(), context, rVar);
        this.f42438w = (TextView) rVar.b(R$id.asset_header_bond_panel);
        this.f42439x = (RiskPanelNew) rVar.b(R$id.asset_header_risk_status_panel);
        this.f42436u = (ImageView) rVar.b(R$id.asset_header_iv_analysis_chart);
        this.f42437v = (LittlePieChartAnimView) rVar.b(R$id.asset_header_chart_anim);
        this.f42420e = (LinearLayout) rVar.b(R$id.asset_header_actions_container);
        this.A = rVar.b(R$id.header_tv_asset_total_title_tips);
        this.B = rVar.b(R$id.iv_asset_debts_tips);
        this.C = (AssetSpotYbbHeaderView) rVar.b(R$id.asset_header_ybb_view);
        this.f42441z = rVar.b(R$id.iv_record);
    }

    public void setChildUpdateBalance(boolean z11) {
        this.D = z11;
    }

    public void setDistributionType(String str) {
        this.f42434s = str;
    }

    public void setRecordEntrance(View.OnClickListener onClickListener) {
        this.f42441z.setVisibility(0);
        this.f42441z.setOnClickListener(onClickListener);
    }

    public void setSpotAssetDebtsTipsState(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.B.setOnClickListener(onClickListener);
        }
    }

    public AssetHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        s(context);
    }

    public AssetHeadView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        s(context);
    }
}
