package com.hbg.module.kline.ui;

import ad.b;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.EtpInfo;
import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.kline.R$attr;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.presenter.MarketInfoEtpDetailPresenter;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import i6.d;
import i6.m;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import td.i;
import ud.a;

public class MarketInfoEtpDetailFragment extends BaseFragment<MarketInfoEtpDetailPresenter, MarketInfoEtpDetailPresenter.e> implements MarketInfoEtpDetailPresenter.e, f0 {
    public RelativeLayout A;
    public RelativeLayout B;
    public RelativeLayout C;
    public LoadingLayout D;
    public EtpInfo E;
    public String F;
    public View G;
    public EasyRecyclerView<a> H;
    public TextView I;
    public TextView J;
    public TextView K;
    public EtpRebalInfo L;
    public final SimpleDateFormat M = new SimpleDateFormat("HH:mm", Locale.US);
    public NestedScrollView N;
    public String O;

    /* renamed from: l  reason: collision with root package name */
    public TextView f24000l;

    /* renamed from: m  reason: collision with root package name */
    public TextView f24001m;

    /* renamed from: n  reason: collision with root package name */
    public TextView f24002n;

    /* renamed from: o  reason: collision with root package name */
    public TextView f24003o;

    /* renamed from: p  reason: collision with root package name */
    public TextView f24004p;

    /* renamed from: q  reason: collision with root package name */
    public TextView f24005q;

    /* renamed from: r  reason: collision with root package name */
    public TextView f24006r;

    /* renamed from: s  reason: collision with root package name */
    public TextView f24007s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f24008t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f24009u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f24010v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f24011w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f24012x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f24013y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f24014z;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Mh(View view) {
        ViewUtil.m(this.G, false);
        ViewUtil.m(this.D, true);
        ViewUtil.m(this.N, true);
        this.I.setTextColor(Kh(R$attr.kline_primary_text_color));
        this.J.setTextColor(Kh(R$attr.kline_index_setting_text_color));
        ((MarketInfoEtpDetailPresenter) yh()).d0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Nh(View view) {
        ((MarketInfoEtpDetailPresenter) yh()).d0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        String simpleName = MarketInfoEtpDetailFragment.class.getSimpleName();
        d.c(simpleName, "EtpUrl = " + i.a().b().r());
        HBBaseWebActivity.showWebView(getContext(), i.a().b().r(), "", "", false);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        if (this.E == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        String p11 = a1.v().p(((MarketInfoEtpDetailPresenter) yh()).c0());
        Ph(getString(R$string.n_kline_etp_asset_size), getString(R$string.n_kline_etp_dialog_apply_amount_tips, p11));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        EtpInfo etpInfo = this.E;
        if (etpInfo == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (etpInfo.getBasket() == null || this.E.getBasket().size() != 2) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            String p11 = a1.v().p(((MarketInfoEtpDetailPresenter) yh()).c0());
            String upperCase = this.E.getBasket().get(0).getCurrency().toUpperCase();
            String upperCase2 = this.E.getBasket().get(1).getCurrency().toUpperCase();
            Ph(getString(R$string.n_kline_etp_basket), getString(R$string.n_kline_etp_dialog_basket_tips, p11, upperCase, upperCase2));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$4(View view) {
        EtpRebalInfo etpRebalInfo = this.L;
        if (etpRebalInfo == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        String format = etpRebalInfo.getChargeFeeTime() > 0 ? this.M.format(Long.valueOf(this.L.getChargeFeeTime())) : "--";
        String string = getString(R$string.n_kline_etp_fee);
        int i11 = R$string.n_trade_etp_chargeFee_hint_content;
        Ph(string, getString(i11, format, this.L.getChargeFee() + "%"));
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$5(View view) {
        ViewUtil.m(this.G, true);
        ViewUtil.m(this.D, false);
        ViewUtil.m(this.N, false);
        this.J.setTextColor(Kh(R$attr.kline_primary_text_color));
        this.I.setTextColor(Kh(R$attr.kline_index_setting_text_color));
        ((MarketInfoEtpDetailPresenter) yh()).d0();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void Ah() {
        super.Ah();
        this.f24014z.setOnClickListener(new w1(this));
        this.A.setOnClickListener(new z1(this));
        this.B.setOnClickListener(new x1(this));
        this.C.setOnClickListener(new c2(this));
        this.I.setOnClickListener(new y1(this));
        this.J.setOnClickListener(new b2(this));
    }

    public void B7(String str) {
        String str2;
        this.O = str;
        EtpInfo etpInfo = this.E;
        if (etpInfo != null) {
            if (TextUtils.isEmpty(etpInfo.getInitUnit())) {
                str2 = "";
            } else {
                str2 = this.E.getInitUnit().toUpperCase();
            }
            TextView textView = this.f24006r;
            if (textView != null) {
                textView.setText(this.O + " " + str2);
            }
        }
    }

    /* renamed from: Jh */
    public MarketInfoEtpDetailPresenter xh() {
        return new MarketInfoEtpDetailPresenter();
    }

    public int Kh(int i11) {
        TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(i11, typedValue, true);
        return typedValue.data;
    }

    /* renamed from: Lh */
    public MarketInfoEtpDetailPresenter.e zh() {
        return this;
    }

    public final void Oh() {
        HashMap hashMap = new HashMap();
        hashMap.put("TransPair_current_id", this.F);
        BaseModuleConfig.a().w("App_markets_kline_firtab_etpinfo_view", hashMap);
    }

    public final void Ph(String str, String str2) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            DialogUtils.b.d dVar = new DialogUtils.b.d(activity);
            dVar.c1(str);
            dVar.C0(str2);
            dVar.q0(false);
            dVar.P0(getString(R$string.n_known));
            dVar.Q0(b.f3517a);
            dVar.k0().show(activity.getSupportFragmentManager(), "");
        }
    }

    public void Td() {
        String p11 = a1.v().p(((MarketInfoEtpDetailPresenter) yh()).c0());
        this.f24000l.setText(p11.toUpperCase());
        this.f24002n.setText(getString(R$string.n_kline_etp_apply_amount, p11));
    }

    public void a8(EtpInfo etpInfo) {
        String str;
        String str2;
        this.E = etpInfo;
        if (etpInfo == null) {
            this.f24003o.setText("");
            this.f24004p.setText("");
            this.f24006r.setText("");
            this.f24007s.setText("");
            this.f24008t.setText("");
            this.f24009u.setText("");
            this.f24010v.setText("");
            this.f24011w.setText("");
            this.f24005q.setText("");
            this.f24014z.setVisibility(8);
            this.f24013y.setVisibility(8);
            this.f24012x.setVisibility(8);
            return;
        }
        String F2 = a1.v().F(((MarketInfoEtpDetailPresenter) yh()).c0());
        String p11 = a1.v().p(((MarketInfoEtpDetailPresenter) yh()).c0());
        this.f24000l.setText(p11.toUpperCase());
        if (!TextUtils.isEmpty(etpInfo.getCurrencyName())) {
            this.f24001m.setText("(" + etpInfo.getCurrencyName() + ")");
        }
        this.f24002n.setText(getString(R$string.n_kline_etp_apply_amount, p11));
        this.f24003o.setText(m.k(etpInfo.getCreationAmount(), 0, true));
        this.f24004p.setText(m.k(etpInfo.getChargeAmount(), 0, true) + " " + F2);
        if (TextUtils.isEmpty(etpInfo.getInitUnit())) {
            str = "";
        } else {
            str = etpInfo.getInitUnit().toUpperCase();
        }
        TextView textView = this.f24006r;
        if (textView != null) {
            textView.setText(this.O + " " + str);
        }
        if (this.L != null) {
            int Ph = ((AbstractKlineActivity) getActivity()).Ph();
            if (this.L.getOptionState() != EtpRebalInfo.OPTION_STATE_NOT_NORMAL) {
                str2 = m.m(this.L.getRebalNav(), Ph) + " " + str;
            } else {
                str2 = "--";
            }
            this.f24007s.setText(str2);
            this.K.setText(m.m(this.L.getActualLeverage(), 4));
        }
        if (TextUtils.isEmpty(etpInfo.getLastChargeFee())) {
            this.f24008t.setText("");
        } else {
            this.f24008t.setText(etpInfo.getLastChargeFee() + "%");
        }
        if (TextUtils.isEmpty(etpInfo.getChargeFee())) {
            this.f24009u.setText("");
        } else {
            this.f24009u.setText(etpInfo.getChargeFee() + "%");
        }
        this.f24010v.setText(etpInfo.getRebalTimeRule());
        this.f24011w.setText(etpInfo.getRebalUnTimeRule());
        if (TextUtils.isEmpty(etpInfo.getCurrencyIntroduce())) {
            this.f24013y.setVisibility(8);
            this.f24012x.setVisibility(8);
            this.f24014z.setVisibility(8);
        } else {
            this.f24013y.setVisibility(0);
            this.f24012x.setVisibility(0);
            this.f24014z.setVisibility(0);
            this.f24012x.setText(etpInfo.getCurrencyIntroduce());
        }
        StringBuilder sb2 = new StringBuilder();
        if (etpInfo.getBasket() != null) {
            int size = etpInfo.getBasket().size();
            for (int i11 = 0; i11 < size; i11++) {
                EtpInfo.Basket basket = etpInfo.getBasket().get(i11);
                sb2.append(m.k(basket.getAmount(), 8, false));
                sb2.append(" ");
                sb2.append(basket.getCurrency().toUpperCase());
                if (i11 < size - 1) {
                    sb2.append("\n");
                }
            }
        }
        this.f24005q.setText(sb2.toString());
    }

    public void b0(EtpRebalInfo etpRebalInfo) {
        this.L = etpRebalInfo;
        a8(this.E);
    }

    public void d0(List<a> list) {
        this.H.setData(list);
        if (this.H.getItemCount() > 0) {
            this.D.g();
        } else {
            this.D.i();
        }
    }

    public void initViews() {
        super.initViews();
        this.f24000l = (TextView) this.f67460i.b(R$id.marketInfoEtpName);
        this.f24001m = (TextView) this.f67460i.b(R$id.marketInfoEtpDetailName);
        this.f24002n = (TextView) this.f67460i.b(R$id.marketInfoEtpApplyCountLabel);
        this.f24003o = (TextView) this.f67460i.b(R$id.marketInfoEtpApplyCount);
        this.f24004p = (TextView) this.f67460i.b(R$id.marketInfoEtpAssetSize);
        this.f24005q = (TextView) this.f67460i.b(R$id.marketInfoEtpBasket);
        this.f24006r = (TextView) this.f67460i.b(R$id.marketInfoEtpInitialValue_newest);
        this.f24007s = (TextView) this.f67460i.b(R$id.marketInfoEtpInitialValue_change);
        this.f24008t = (TextView) this.f67460i.b(R$id.marketInfoEtpFee);
        this.f24009u = (TextView) this.f67460i.b(R$id.marketInfoEtpFee_today);
        this.f24010v = (TextView) this.f67460i.b(R$id.marketInfoEtpFixedTimeRule);
        this.f24011w = (TextView) this.f67460i.b(R$id.marketInfoEtpUnFixedTimeRule);
        this.f24012x = (TextView) this.f67460i.b(R$id.marketInfoEtpIntro);
        this.f24014z = (TextView) this.f67460i.b(R$id.moreInfoBtn);
        this.A = (RelativeLayout) this.f67460i.b(R$id.assetSizeLayout);
        this.B = (RelativeLayout) this.f67460i.b(R$id.basketLayout);
        this.C = (RelativeLayout) this.f67460i.b(R$id.manageFeeLayout);
        this.f24013y = (TextView) this.f67460i.b(R$id.marketInfoEtpIntroTitle);
        this.G = this.f67460i.b(R$id.market_info_etp_detail_content_layout);
        this.H = (EasyRecyclerView) this.f67460i.b(R$id.market_info_etp_detail_question_recyclerView);
        this.I = (TextView) this.f67460i.b(R$id.market_info_etp_detail_tab_info);
        this.J = (TextView) this.f67460i.b(R$id.market_info_etp_detail_tab_risk);
        this.K = (TextView) this.f67460i.b(R$id.market_info_etp_detail_real_margin_tv);
        this.D = (LoadingLayout) this.f67460i.b(R$id.market_info_etp_detail_question_loadingLayout);
        this.N = (NestedScrollView) this.f67460i.b(R$id.nested_scroll_view);
        this.H.setFocusable(false);
        this.D.setOnRetryClickListener(new a2(this));
    }

    public void m0() {
        this.D.k();
    }

    public void onResume() {
        super.onResume();
        Oh();
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_market_info_etp_detail, viewGroup, false);
    }

    public void showLoading() {
        this.D.p();
    }

    public void uh(boolean z11) {
        super.uh(z11);
        if (z11) {
            getActivity();
        }
    }
}
