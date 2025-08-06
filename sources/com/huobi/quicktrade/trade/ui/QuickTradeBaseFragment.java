package com.huobi.quicktrade.trade.ui;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.alibaba.verificationsdk.ui.IActivityCallback;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.alibaba.verificationsdk.ui.VerifyType;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.VibrateManager;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.data.clear.controller.ClearDialogConfigController;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.index.bean.IndexFeature;
import com.huobi.quicktrade.trade.presenter.QuickTradeBasePresenter;
import com.huobi.trade.bean.MarketCurrentPriceItem;
import com.huobi.trade.bean.OrderPlaceBean;
import com.huobi.trade.helper.EtpRiskHintUtil;
import com.huobi.trade.helper.c0;
import com.huobi.trade.prime.bean.AliToken;
import com.huobi.trade.prime.bean.TradeOrderNum;
import com.huobi.trade.ui.TradeFiatGuideDialogFragment;
import com.huobi.trade.ui.TradeFiatGuideTwoDialogFragment;
import com.huobi.trade.ui.g1;
import com.huobi.trade.ui.h1;
import com.huobi.trade.ui.j;
import com.huobi.trade.ui.r;
import com.huobi.utils.a0;
import com.huobi.utils.d1;
import com.huobi.utils.v0;
import com.huobi.view.keyboard.CustomBoardView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import k6.b;
import pro.huobi.R;
import sq.h;

public abstract class QuickTradeBaseFragment<P extends QuickTradeBasePresenter<V>, V extends h1> extends BaseFragment<P, V> implements h1, j {

    /* renamed from: l  reason: collision with root package name */
    public int f80618l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f80619m = 0;

    /* renamed from: n  reason: collision with root package name */
    public CustomBoardView f80620n;

    /* renamed from: o  reason: collision with root package name */
    public QuickTradeHeadView f80621o;

    /* renamed from: p  reason: collision with root package name */
    public HBDialogFragment f80622p;

    /* renamed from: q  reason: collision with root package name */
    public HBDialogFragment f80623q;

    /* renamed from: r  reason: collision with root package name */
    public View f80624r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f80625s;

    /* renamed from: t  reason: collision with root package name */
    public ImageView f80626t;

    /* renamed from: u  reason: collision with root package name */
    public g f80627u;

    /* renamed from: v  reason: collision with root package name */
    public TradeFiatGuideDialogFragment f80628v = new TradeFiatGuideDialogFragment();

    /* renamed from: w  reason: collision with root package name */
    public TradeFiatGuideTwoDialogFragment f80629w = new TradeFiatGuideTwoDialogFragment();

    /* renamed from: x  reason: collision with root package name */
    public int f80630x = 1;

    /* renamed from: y  reason: collision with root package name */
    public int f80631y = 1;

    /* renamed from: z  reason: collision with root package name */
    public k6.b f80632z;

    public class a implements b.C0742b {
        public a() {
        }

        public void a(k6.b bVar) {
            ((QuickTradeBasePresenter) QuickTradeBaseFragment.this.yh()).L0();
            VibrateManager.a(QuickTradeBaseFragment.this.f80621o.getPriceView());
        }

        public void b(k6.b bVar) {
        }
    }

    public class b implements TradeFiatGuideTwoDialogFragment.a {
        public b() {
        }

        public void a() {
            QuickTradeBaseFragment.this.Ih();
        }

        public TradeType b() {
            return TradeType.PRO;
        }

        public void c() {
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            sn.f.A(QuickTradeBaseFragment.this.getActivity(), ((QuickTradeBasePresenter) QuickTradeBaseFragment.this.yh()).o0(), false, false, ((QuickTradeBasePresenter) QuickTradeBaseFragment.this.yh()).u0(), true);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class d extends ClickableSpan {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            HBBaseWebActivity.showWebView(QuickTradeBaseFragment.this.getContext(), a0.p(), "", "", false);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
        }
    }

    public class e extends ClickableSpan {
        public e() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            v0.e(QuickTradeBaseFragment.this.getActivity(), "94881242131745");
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        public void updateDrawState(TextPaint textPaint) {
        }
    }

    public class f implements TextWatcher {
        public f() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public static class g implements IActivityCallback {

        /* renamed from: a  reason: collision with root package name */
        public WeakReference<QuickTradeBaseFragment> f80639a;

        /* renamed from: b  reason: collision with root package name */
        public OrderPlaceBean f80640b;

        public g(QuickTradeBaseFragment quickTradeBaseFragment) {
            this.f80639a = new WeakReference<>(quickTradeBaseFragment);
        }

        public OrderPlaceBean a() {
            return this.f80640b;
        }

        public void b(OrderPlaceBean orderPlaceBean) {
            this.f80640b = orderPlaceBean;
        }

        public void onNotifyBackPressed() {
        }

        public void onResult(int i11, Map<String, String> map) {
            QuickTradeBaseFragment quickTradeBaseFragment = (QuickTradeBaseFragment) this.f80639a.get();
            if (quickTradeBaseFragment != null) {
                quickTradeBaseFragment.Rh(i11, map);
            }
        }
    }

    public static /* synthetic */ void Lh(int i11, HBDialogFragment hBDialogFragment) {
        ClearDialogConfigController.g(i11);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Mh(String str, int i11, HBDialogFragment hBDialogFragment) {
        HBBaseWebActivity.showWebView(getActivity(), a0.f(str), "", "", false);
        ClearDialogConfigController.g(i11);
        hBDialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Nh(HBDialogFragment hBDialogFragment) {
        HBBaseWebActivity.showWebView(getActivity(), d1.f(), "", "", false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ph(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        sn.f.Q(getActivity(), ((QuickTradeBasePresenter) yh()).o0());
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Qh(View view) {
        HBBaseWebActivity.showWebView(getActivity(), d1.f(), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* synthetic */ void Ab(TradeOrderNum tradeOrderNum) {
        r.c(this, tradeOrderNum);
    }

    public void Ah() {
        super.Ah();
        this.f80628v.Dh(new h(this));
        this.f80629w.Dh(new b());
    }

    public void B2(int i11) {
    }

    public void E2() {
        HBDialogFragment hBDialogFragment = this.f80622p;
        if (hBDialogFragment != null && hBDialogFragment.th()) {
            this.f80622p.dismiss();
        }
        HBDialogFragment hBDialogFragment2 = this.f80623q;
        if (hBDialogFragment2 != null && hBDialogFragment2.th()) {
            this.f80623q.dismiss();
        }
    }

    public void F2() {
        if (this.f80622p == null) {
            this.f80622p = new DialogUtils.b.d(getActivity()).c1(getString(R.string.allow_access_dialog_title)).C0(getString(R.string.n_trade_etp_evaluation_content)).Y0(getString(R.string.n_trade_etp_evaluation_introduce)).a1(new sq.e(this)).s0(getString(R.string.global_string_cancel)).P0(getString(R.string.n_trade_etp_evaluation_start)).N0(sq.g.f26128a).Q0(new sq.d(this)).k0();
        }
        if (!this.f80622p.th()) {
            this.f80622p.show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public void H0(MarketCurrentPriceItem marketCurrentPriceItem) {
        if (getActivity() != null) {
            this.f80632z.e(marketCurrentPriceItem);
            this.f80621o.k();
            ((QuickTradeBasePresenter) yh()).Q0();
        }
    }

    public void Ih() {
        String str;
        String o02 = ((QuickTradeBasePresenter) yh()).o0();
        if (((QuickTradeBasePresenter) yh()).u0() == TradeType.PRO) {
            if (((QuickTradeBasePresenter) yh()).z0()) {
                str = a1.v().E(o02, ((QuickTradeBasePresenter) yh()).u0());
            } else {
                str = a1.v().o(o02, ((QuickTradeBasePresenter) yh()).u0());
            }
            String str2 = str;
            HashMap hashMap = new HashMap(1);
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(str2));
            is.a.i("4109", hashMap);
            UnifyTransferActivity.Vh(getActivity(), str2, "1", true, (String) null, false, 1);
        } else if (((QuickTradeBasePresenter) yh()).u0() == TradeType.C2C) {
            if (o02 != null) {
                HashMap hashMap2 = new HashMap(1);
                hashMap2.put("symbol", StringUtils.g(o02));
                is.a.i("4119", hashMap2);
                UnifyTransferActivity.Uh(getActivity(), (String) null, "8", false, o02, false);
            }
        } else if (o02 != null) {
            String l02 = ((QuickTradeBasePresenter) yh()).l0();
            HashMap hashMap3 = new HashMap(1);
            hashMap3.put(FirebaseAnalytics.Param.CURRENCY, StringUtils.g(l02));
            is.a.i("4118", hashMap3);
            UnifyTransferActivity.Th(getActivity(), l02, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL);
        }
    }

    public void Jh() {
        this.f80620n.hideKeyboardLayout();
    }

    public void K2(String str, String str2, int i11) {
        HBDialogFragment hBDialogFragment = this.f80623q;
        if (hBDialogFragment == null || !hBDialogFragment.isAdded()) {
            DialogUtils.b.d Q0 = new DialogUtils.b.d(getActivity()).c1(getString(R.string.n_trade_etp_clear_dialog_title)).C0(str2).P0(getString(R.string.n_known)).Q0(new sq.c(i11));
            if (!TextUtils.isEmpty(str)) {
                Q0.s0(getString(R.string.n_exchange_filled_orders_tip_view_detail)).N0(new sq.f(this, str, i11));
            }
            HBDialogFragment k02 = Q0.k0();
            this.f80623q = k02;
            k02.show(getActivity().getSupportFragmentManager(), "");
        }
    }

    public final void Kh() {
        this.f80624r = this.f67460i.b(R.id.trade_risk_reminder_ll);
        this.f80625s = (TextView) this.f67460i.b(R.id.trade_reminder_detail_tv);
        this.f80626t = (ImageView) this.f67460i.b(R.id.trade_risk_reminder_tv);
    }

    public void L1(IndexFeature indexFeature) {
        c0.d().f(indexFeature);
    }

    public void L2() {
    }

    public void N1() {
    }

    public void O0(String str, int i11, int i12) {
        this.f80621o.h(str, i11, i12);
    }

    public void O1(String str, TradeType tradeType) {
        this.f80621o.l(a1.v().X(str, tradeType));
    }

    public void O2(int i11, int i12) {
    }

    public void Rh(int i11, Map<String, String> map) {
        if (i11 == 1) {
            ((QuickTradeBasePresenter) yh()).G0(map, this.f80627u.a());
        }
    }

    public int S1() {
        return this.f80618l;
    }

    public /* synthetic */ void V2() {
        r.b(this);
    }

    public /* synthetic */ String Wf() {
        return g1.a(this);
    }

    public boolean X5() {
        CustomBoardView customBoardView = this.f80620n;
        if (customBoardView == null || !customBoardView.keyboardVisible()) {
            return false;
        }
        this.f80620n.hideKeyboardLayout();
        return true;
    }

    public void b(v9.a aVar) {
    }

    public int c2() {
        return this.f80619m;
    }

    public void d(boolean z11) {
    }

    public void d3(int i11) {
    }

    public /* synthetic */ void e3() {
        r.a(this);
    }

    public void f3(boolean z11) {
        if (z11) {
            if (!this.f80628v.isVisible()) {
                this.f80628v.show(getActivity().getSupportFragmentManager(), "fiatGuideDialogFragment");
                gs.g.i("APP_Trade_fiat_expose", (HashMap) null);
            }
        } else if (!this.f80629w.isVisible()) {
            this.f80629w.show(getActivity().getSupportFragmentManager(), "fiatGuideTwoDialogFragment");
        }
    }

    public void finishRefresh() {
    }

    public int getUiPlanTradeBuyMode() {
        return this.f80630x;
    }

    public int getUiPlanTradeSellMode() {
        return this.f80631y;
    }

    public void initViews() {
        super.initViews();
        this.f80621o = (QuickTradeHeadView) this.f67460i.b(R.id.trade_head_view);
        CustomBoardView customBoardView = (CustomBoardView) this.f67460i.b(R.id.boardView);
        this.f80620n = customBoardView;
        customBoardView.hideKeyboardLayout();
        Kh();
        L1(c0.d().c());
        this.f80632z = new k6.b(new a());
        this.f80621o.getPriceView().g(this.f80632z);
    }

    public void j3(OrderPlaceBean orderPlaceBean, AliToken aliToken) {
        if (this.f80627u == null) {
            this.f80627u = new g(this);
        }
        orderPlaceBean.setAliToken(aliToken);
        this.f80627u.b(orderPlaceBean);
        VerifyActivity.startSimpleVerifyUI(getActivity(), VerifyType.NOCAPTCHA, "0335", (String) null, this.f80627u);
    }

    public void k3() {
    }

    public void l1() {
    }

    public void l2(String str) {
    }

    public void o3(int i11, int i12) {
        int i13 = i12;
        SymbolBean J = a1.v().J(((QuickTradeBasePresenter) yh()).o0(), ((QuickTradeBasePresenter) yh()).u0());
        String baseCurrencyDisplayName = J != null ? J.getBaseCurrencyDisplayName() : "";
        if (i13 == 0) {
            this.f80626t.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_normal);
            this.f80625s.setText(String.format(getString(R.string.trade_reminder_had_details), new Object[]{StringUtils.i(baseCurrencyDisplayName)}));
            this.f80625s.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
            this.f80624r.setBackgroundResource(R.drawable.shape_trade_risk_reminder_blue_bg);
        } else if (i13 == 1) {
            this.f80626t.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_risk);
            this.f80625s.setText(String.format(getString(R.string.n_trade_reminder_st_details), new Object[]{StringUtils.i(baseCurrencyDisplayName)}));
            this.f80625s.setTextColor(ContextCompat.getColor(getContext(), R.color.baseColorShadeButtonRedStart));
            this.f80624r.setBackgroundResource(R.drawable.shape_trade_risk_reminder_red_bg);
        } else if (i13 == 2) {
            this.f80626t.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_normal);
            this.f80625s.setText(String.format(getString(R.string.trade_reminder_detail_text), new Object[]{StringUtils.i(baseCurrencyDisplayName)}));
            this.f80625s.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
            this.f80624r.setBackgroundResource(R.drawable.shape_trade_risk_reminder_blue_bg);
        } else if (i13 != 4) {
            if (i13 == 5) {
                this.f80626t.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_normal);
                String string = getString(R.string.n_trade_observation_warning_hint);
                String string2 = getString(R.string.n_trade_observation_warning_more);
                int indexOf = string.toLowerCase().indexOf(string2.toLowerCase());
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
                if (indexOf != -1) {
                    spannableStringBuilder.setSpan(new d(), indexOf, string2.length() + indexOf, 17);
                    spannableStringBuilder.setSpan(new UnderlineSpan(), indexOf, string2.length() + indexOf, 17);
                }
                this.f80625s.setMovementMethod(LinkMovementMethod.getInstance());
                this.f80625s.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
                this.f80625s.setText(spannableStringBuilder);
                this.f80624r.setBackgroundResource(R.drawable.shape_trade_risk_reminder_blue_bg);
            } else if (i13 == 6) {
                this.f80626t.setBackgroundResource(R.drawable.etp_kline_noticeboard_icon_normal);
                String string3 = getString(R.string.n_trade_pioneer_warning_hint);
                String string4 = getString(R.string.n_trade_observation_warning_more);
                int indexOf2 = string3.toLowerCase().indexOf(string4.toLowerCase());
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(string3);
                if (indexOf2 != -1) {
                    spannableStringBuilder2.setSpan(new e(), indexOf2, string4.length() + indexOf2, 17);
                    spannableStringBuilder2.setSpan(new UnderlineSpan(), indexOf2, string4.length() + indexOf2, 17);
                }
                this.f80625s.setMovementMethod(LinkMovementMethod.getInstance());
                this.f80625s.setTextColor(ContextCompat.getColor(getActivity(), R.color.baseColorMajorTheme100));
                this.f80625s.setText(spannableStringBuilder2);
                this.f80624r.setBackgroundResource(R.drawable.shape_trade_risk_reminder_blue_bg);
            }
        } else if (J != null) {
            SpannableStringBuilder f11 = EtpRiskHintUtil.f(x7.d.b(J.getBaseCurrency()), getContext(), J.getBaseCurrencyDisplayName(), StringUtils.i(EtpRiskHintUtil.c(J.getBaseCurrency())), StringUtils.i(J.getQuoteCurrency()), ((QuickTradeBasePresenter) yh()).p0().y(), ((QuickTradeBasePresenter) yh()).p0().B(), PrecisionUtil.e(J.getSymbol()), new sq.b(this), new c(), J.getEtpLeverageRatio(), true, false);
            this.f80626t.setBackgroundResource(EtpRiskHintUtil.g());
            this.f80625s.setText(f11);
            this.f80625s.setMovementMethod(LinkMovementMethod.getInstance());
            this.f80625s.setHighlightColor(ContextCompat.getColor(getActivity(), 17170445));
            this.f80624r.setBackgroundResource(EtpRiskHintUtil.e());
        }
        this.f80624r.setVisibility(i11);
    }

    public void t4() {
    }

    public void uh(boolean z11) {
        QuickTradeHeadView quickTradeHeadView;
        super.uh(z11);
        if (!z11 && (quickTradeHeadView = this.f80621o) != null) {
            quickTradeHeadView.i();
        }
    }

    public void x2(boolean z11, boolean z12, String str) {
    }

    public void y0(boolean z11) {
    }

    public /* synthetic */ boolean z6() {
        return g1.b(this);
    }
}
