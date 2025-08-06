package com.hbg.module.kline.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import bj.o0;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.AppLanguageHelper;
import com.hbg.lib.core.util.p;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.FundSituationBean;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.R$color;
import com.hbg.module.kline.R$drawable;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$string;
import com.hbg.module.kline.presenter.MarketInfoCapitalFlowPresenter;
import com.hbg.module.kline.view.HistogramLayout;
import com.hbg.module.kline.view.histogram.HistogramChartBean;
import com.huobi.view.barchart.BarChart;
import com.huobi.view.barchart.BarChartBean;
import com.huobi.view.realline.RealLineBean;
import com.huobi.view.realline.RealLineChart;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d7.a1;
import ee.a;
import i6.m;
import java.text.DecimalFormat;
import java.util.Objects;

public class MarketInfoCapitalFlowFragment extends BaseFragment<MarketInfoCapitalFlowPresenter, MarketInfoCapitalFlowPresenter.b> implements MarketInfoCapitalFlowPresenter.b, RadioGroup.OnCheckedChangeListener {
    public TextView A;
    public TextView B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public ImageView H;
    public HistogramLayout I;
    public SymbolBean J;
    public String K = "";
    public DecimalFormat L = new DecimalFormat("##0.0000");
    public TextView M;
    public LoadingLayout N;

    /* renamed from: l  reason: collision with root package name */
    public BarChart f23932l;

    /* renamed from: m  reason: collision with root package name */
    public RealLineChart f23933m;

    /* renamed from: n  reason: collision with root package name */
    public RadioButton f23934n;

    /* renamed from: o  reason: collision with root package name */
    public RadioButton f23935o;

    /* renamed from: p  reason: collision with root package name */
    public RadioButton f23936p;

    /* renamed from: q  reason: collision with root package name */
    public RadioButton f23937q;

    /* renamed from: r  reason: collision with root package name */
    public RadioButton f23938r;

    /* renamed from: s  reason: collision with root package name */
    public RadioButton f23939s;

    /* renamed from: t  reason: collision with root package name */
    public TextView f23940t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f23941u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f23942v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f23943w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f23944x;

    /* renamed from: y  reason: collision with root package name */
    public TextView f23945y;

    /* renamed from: z  reason: collision with root package name */
    public TextView f23946z;

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Gh(View view) {
        a.a((FragmentActivity) oa.a.g().b(), !KLineHelper.f() ? 1 : 0, getResources().getString(R$string.n_kline_money_flow_analyze), getResources().getString(R$string.n_kline_money_flow_dialog_content), (String) null, (String) null, getResources().getString(R$string.n_dialog_ok), (DialogUtils.b.f) null, o0.f12469a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Hh(View view) {
        ((MarketInfoCapitalFlowPresenter) yh()).R();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: Eh */
    public MarketInfoCapitalFlowPresenter xh() {
        return new MarketInfoCapitalFlowPresenter();
    }

    /* renamed from: Fh */
    public MarketInfoCapitalFlowPresenter.b zh() {
        return this;
    }

    public final void Ih(boolean z11, TextView textView, Double d11) {
        if (z11) {
            if (w.l()) {
                textView.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorShadeButtonRedStart));
            } else {
                textView.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorShadeButtonGreenStart));
            }
        } else if (w.l()) {
            textView.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorShadeButtonGreenStart));
        } else {
            textView.setTextColor(ContextCompat.getColor(getContext(), R$color.baseColorShadeButtonRedStart));
        }
        if (d11 != null) {
            textView.setText(m.f(d11.toString(), AppLanguageHelper.getInstance().isChineseLanguage()));
        } else {
            textView.setText("--");
        }
    }

    public void Mb(HistogramChartBean histogramChartBean) {
        this.I.setData(histogramChartBean);
        this.N.g();
    }

    public void O4(RealLineBean[] realLineBeanArr) {
        this.f23933m.setTotalInflows(realLineBeanArr);
        this.N.g();
    }

    public void Sf(BarChartBean barChartBean) {
        this.f23932l.addChartData(barChartBean);
        this.N.g();
    }

    public SymbolBean T4() {
        Bundle arguments;
        if (this.J == null && (arguments = getArguments()) != null) {
            String string = arguments.getString("symbolId", "");
            TradeType parse = TradeType.parse(arguments.getString("market_tradetype", ""));
            if (parse == null) {
                parse = TradeType.PRO;
            }
            this.J = a1.v().J(string, parse);
        }
        return this.J;
    }

    public void initViews() {
        super.initViews();
        this.N = (LoadingLayout) this.f67460i.b(R$id.loading_layout_fund_situation);
        this.f23932l = (BarChart) this.f67460i.b(R$id.bar_chart_market_fund_situation);
        this.f23933m = (RealLineChart) this.f67460i.b(R$id.real_line_chart_market_fund_situation);
        this.H = (ImageView) this.f67460i.b(R$id.text_view_bar_chart_center_text);
        this.f23934n = (RadioButton) this.f67460i.b(R$id.radio_button_fund_situation_15_min);
        this.f23935o = (RadioButton) this.f67460i.b(R$id.radio_button_fund_situation_30_min);
        this.f23936p = (RadioButton) this.f67460i.b(R$id.radio_button_fund_situation_1_h);
        this.f23937q = (RadioButton) this.f67460i.b(R$id.radio_button_fund_situation_2_h);
        this.f23938r = (RadioButton) this.f67460i.b(R$id.radio_button_fund_situation_4_h);
        this.f23939s = (RadioButton) this.f67460i.b(R$id.radio_button_fund_situation_1_d);
        this.f23940t = (TextView) this.f67460i.b(R$id.text_view_fund_situation_table_head_in);
        this.f23941u = (TextView) this.f67460i.b(R$id.text_view_fund_situation_table_head_out);
        this.f23942v = (TextView) this.f67460i.b(R$id.text_view_fund_situation_large_in);
        this.f23943w = (TextView) this.f67460i.b(R$id.text_view_fund_situation_large_out);
        this.f23944x = (TextView) this.f67460i.b(R$id.text_view_fund_situation_mid_in);
        this.f23945y = (TextView) this.f67460i.b(R$id.text_view_fund_situation_mid_out);
        this.f23946z = (TextView) this.f67460i.b(R$id.text_view_fund_situation_small_in);
        this.A = (TextView) this.f67460i.b(R$id.text_view_fund_situation_small_out);
        this.B = (TextView) this.f67460i.b(R$id.text_view_fund_situation_total_in);
        this.C = (TextView) this.f67460i.b(R$id.text_view_fund_situation_total_out);
        this.D = (TextView) this.f67460i.b(R$id.text_view_fund_situation_total_large);
        this.E = (TextView) this.f67460i.b(R$id.text_view_fund_situation_total_mid);
        this.F = (TextView) this.f67460i.b(R$id.text_view_fund_situation_total_small);
        this.G = (TextView) this.f67460i.b(R$id.text_view_fund_situation_total_total);
        ((RadioGroup) this.f67460i.b(R$id.radio_group_fund_situation)).setOnCheckedChangeListener(this);
        this.M = (TextView) this.f67460i.b(R$id.text_view_real_line_title);
        this.I = (HistogramLayout) this.f67460i.b(R$id.histogram_chart_market_layout);
        Context context = getContext();
        Objects.requireNonNull(context);
        Context context2 = context;
        if (p.h(context) && !p.i(getContext())) {
            this.H.setImageDrawable(getContext().getDrawable(R$drawable.kline_water_logo_zh_cn));
        }
        if (w.l()) {
            this.I.setRiseColor(R$color.baseColorShadeButtonRedStart);
            this.I.setFallColor(R$color.baseColorShadeButtonGreenStart);
            if (KLineHelper.f()) {
                this.f23932l.setColors(new int[]{Color.parseColor("#E94359"), Color.parseColor("#ED697A"), Color.parseColor("#F28E9B"), Color.parseColor("#66C7AA"), Color.parseColor("#33B48D"), Color.parseColor("#00A171")});
            } else {
                this.f23932l.setColors(new int[]{Color.parseColor("#E94359"), Color.parseColor("#C03C4D"), Color.parseColor("#983442"), Color.parseColor("#0C6D50"), Color.parseColor("#068760"), Color.parseColor("#00A171")});
            }
        } else {
            this.I.setRiseColor(R$color.baseColorShadeButtonGreenStart);
            this.I.setFallColor(R$color.baseColorShadeButtonRedStart);
            if (KLineHelper.f()) {
                this.f23932l.setColors(new int[]{Color.parseColor("#00A171"), Color.parseColor("#33B48D"), Color.parseColor("#66C7AA"), Color.parseColor("#F28E9B"), Color.parseColor("#ED697A"), Color.parseColor("#E94359")});
            } else {
                this.f23932l.setColors(new int[]{Color.parseColor("#00A171"), Color.parseColor("#068760"), Color.parseColor("#0C6D50"), Color.parseColor("#983442"), Color.parseColor("#C03C4D"), Color.parseColor("#E94359")});
            }
        }
        if (T4() != null && !TextUtils.isEmpty(T4().getBaseCurrencyDisplayName())) {
            TextView textView = this.M;
            int i11 = R$string.n_kline_one_day_money_flow;
            textView.setText(String.format(getString(i11), new Object[]{T4().getBaseCurrencyDisplayName()}));
            this.f67460i.b(R$id.font_icon_text_view_fund_situation).setOnClickListener(new t0(this));
            if (T4() == null || TextUtils.isEmpty(T4().getBaseCurrencyDisplayName())) {
                this.M.setText(String.format(getString(i11), new Object[]{"--"}));
                this.I.setTitleText("--");
            } else {
                this.I.setTitleText(T4().getBaseCurrencyDisplayName());
            }
            this.I.setFlowEnterText("--");
        }
        this.N.p();
    }

    public String k1() {
        Bundle arguments;
        if (TextUtils.isEmpty(this.K) && (arguments = getArguments()) != null) {
            this.K = arguments.getString("symbolId", "");
        }
        return this.K;
    }

    public void m0() {
        this.N.k();
        this.N.setOnRetryClickListener(new u0(this));
    }

    @SensorsDataInstrumented
    public void onCheckedChanged(RadioGroup radioGroup, int i11) {
        if (i11 == R$id.radio_button_fund_situation_15_min) {
            ((MarketInfoCapitalFlowPresenter) yh()).k0(Period.min15);
        } else if (i11 == R$id.radio_button_fund_situation_30_min) {
            ((MarketInfoCapitalFlowPresenter) yh()).k0(Period.min30);
        } else if (i11 == R$id.radio_button_fund_situation_1_h) {
            ((MarketInfoCapitalFlowPresenter) yh()).k0(Period.min60);
        } else if (i11 == R$id.radio_button_fund_situation_2_h) {
            ((MarketInfoCapitalFlowPresenter) yh()).k0(Period.hour2);
        } else if (i11 == R$id.radio_button_fund_situation_4_h) {
            ((MarketInfoCapitalFlowPresenter) yh()).k0(Period.hour4);
        } else if (i11 == R$id.radio_button_fund_situation_1_d) {
            ((MarketInfoCapitalFlowPresenter) yh()).k0(Period.day);
        }
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    public View ph(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R$layout.fragment_layout_market_info_capital_flow, viewGroup, false);
    }

    public void r9() {
        this.f23934n.setChecked(true);
    }

    public void zg(FundSituationBean.FundSituationItem fundSituationItem) {
        this.N.g();
        this.f23940t.setText(getString(R$string.n_kline_money_flow_order_buy) + "（" + this.J.getBaseCurrencyDisplayName() + "）");
        this.f23941u.setText(getString(R$string.n_kline_money_flow_order_sell) + "（" + this.J.getBaseCurrencyDisplayName() + "）");
        boolean z11 = false;
        if (fundSituationItem != null) {
            Ih(true, this.f23946z, Double.valueOf(fundSituationItem.getSmallBuy()));
            Ih(true, this.f23944x, Double.valueOf(fundSituationItem.getMiddleBuy()));
            Ih(true, this.f23942v, Double.valueOf(fundSituationItem.getBigBuy()));
            Ih(false, this.A, Double.valueOf(fundSituationItem.getSmallSell()));
            Ih(false, this.f23945y, Double.valueOf(fundSituationItem.getMiddleSell()));
            Ih(false, this.f23943w, Double.valueOf(fundSituationItem.getBigSell()));
            double bigInflow = fundSituationItem.getBigInflow();
            Ih(bigInflow > 0.0d, this.D, Double.valueOf(bigInflow));
            double middleInflow = fundSituationItem.getMiddleInflow();
            Ih(middleInflow > 0.0d, this.E, Double.valueOf(middleInflow));
            double smallInflow = fundSituationItem.getSmallInflow();
            Ih(smallInflow > 0.0d, this.F, Double.valueOf(smallInflow));
            Ih(true, this.B, Double.valueOf(fundSituationItem.getTotalBuy()));
            Ih(false, this.C, Double.valueOf(fundSituationItem.getTotalSell()));
            double totalInflow = fundSituationItem.getTotalInflow();
            if (totalInflow > 0.0d) {
                z11 = true;
            }
            Ih(z11, this.G, Double.valueOf(totalInflow));
            return;
        }
        Ih(true, this.f23946z, (Double) null);
        Ih(true, this.f23944x, (Double) null);
        Ih(true, this.f23942v, (Double) null);
        Ih(false, this.A, (Double) null);
        Ih(false, this.f23945y, (Double) null);
        Ih(false, this.f23943w, (Double) null);
        Ih(true, this.D, (Double) null);
        Ih(true, this.E, (Double) null);
        Ih(true, this.F, (Double) null);
        Ih(true, this.B, (Double) null);
        Ih(false, this.C, (Double) null);
        Ih(true, this.G, (Double) null);
    }
}
