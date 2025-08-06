package com.hbg.module.linear.swap.viewhandler;

import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.contract.R$color;
import com.hbg.lib.contract.R$drawable;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.controller.LinearSwapAllowLevelController;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapPosition;
import com.hbg.lib.network.option.core.util.OptionDirection;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.retrofit.util.SPUtil;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.contract.ContractModuleConfig;
import com.hbg.module.linear.swap.bean.LinearSwapPositionOrderItem;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.xiaomi.mipush.sdk.Constants;
import i6.k;
import i6.r;
import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import s9.c;
import u6.g;
import ze.j;
import ze.l;
import ze.m;
import ze.n;
import ze.o;
import ze.p;
import ze.q;
import ze.s;
import ze.t;
import ze.u;
import ze.v;

public class LinearSwapPositionOrderItemHandler implements c {

    public class a extends BaseSubscriber<List<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinearSwapPosition f26412b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LeverSelectDialogFragment f26413c;

        public a(LinearSwapPosition linearSwapPosition, LeverSelectDialogFragment leverSelectDialogFragment) {
            this.f26412b = linearSwapPosition;
            this.f26413c = leverSelectDialogFragment;
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            if (TextUtils.equals(this.f26412b.getContractCode(), this.f26413c.bi())) {
                this.f26413c.tc(list);
                this.f26413c.ti(this.f26412b.getLeverRate());
            }
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void A(LinearSwapPositionOrderItem linearSwapPositionOrderItem, View view) {
        if (linearSwapPositionOrderItem.c() != null) {
            linearSwapPositionOrderItem.c().e(linearSwapPositionOrderItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void B(LinearSwapPositionOrderItem linearSwapPositionOrderItem, View view) {
        if (linearSwapPositionOrderItem.c() != null) {
            linearSwapPositionOrderItem.c().i(linearSwapPositionOrderItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void C(LinearSwapPositionOrderItem linearSwapPositionOrderItem, View view) {
        if (linearSwapPositionOrderItem.c() != null) {
            linearSwapPositionOrderItem.c().b(linearSwapPositionOrderItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void D(LinearSwapPositionOrderItem linearSwapPositionOrderItem, View view) {
        if (linearSwapPositionOrderItem.c() != null) {
            linearSwapPositionOrderItem.c().d(linearSwapPositionOrderItem, 0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void E(LinearSwapPositionOrderItem linearSwapPositionOrderItem, Void voidR) {
        if (linearSwapPositionOrderItem.c() != null) {
            linearSwapPositionOrderItem.c().h(linearSwapPositionOrderItem);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void F(View view, LinearSwapPositionOrderItem linearSwapPositionOrderItem, View view2) {
        if (view.getVisibility() == 0 && linearSwapPositionOrderItem.c() != null) {
            linearSwapPositionOrderItem.c().c(linearSwapPositionOrderItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view2);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void t(Context context, View view) {
        DialogUtils.X((FragmentActivity) context, context.getString(R$string.n_contract_ADL_auto_stock_alert_title), context.getString(R$string.n_contract_ADL_auto_stock_alert_content), "", context.getString(R$string.n_known), m.f62158a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void u(LinearSwapPositionOrderItem linearSwapPositionOrderItem, View view) {
        if (linearSwapPositionOrderItem.c() != null) {
            linearSwapPositionOrderItem.c().f(linearSwapPositionOrderItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void v(LinearSwapPositionOrderItem linearSwapPositionOrderItem, View view) {
        if (linearSwapPositionOrderItem.c() != null) {
            linearSwapPositionOrderItem.c().d(linearSwapPositionOrderItem, 1);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void w(LinearSwapPositionOrderItem linearSwapPositionOrderItem, View view) {
        if (linearSwapPositionOrderItem.c() != null) {
            linearSwapPositionOrderItem.c().d(linearSwapPositionOrderItem, 1);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void x(LinearSwapPositionOrderItem linearSwapPositionOrderItem, View view) {
        if (linearSwapPositionOrderItem.c() != null) {
            linearSwapPositionOrderItem.c().d(linearSwapPositionOrderItem, 1);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void z(LinearSwapPosition linearSwapPosition, int i11, Context context, String str, LinearSwapPositionOrderItem linearSwapPositionOrderItem, FutureContractInfo futureContractInfo, View view) {
        LeverSelectDialogFragment leverSelectDialogFragment = new LeverSelectDialogFragment();
        leverSelectDialogFragment.ui(true);
        leverSelectDialogFragment.si(linearSwapPosition.getContractCode());
        List<String> d11 = LinearSwapAllowLevelController.d(linearSwapPosition.getContractCode(), i11);
        if (d11 == null || d11.size() <= 0) {
            LinearSwapAllowLevelController.c(true, linearSwapPosition.getContractCode(), i11).compose(RxJavaHelper.t((g) null)).retry(5).subscribe(new a(linearSwapPosition, leverSelectDialogFragment));
        } else {
            leverSelectDialogFragment.tc(d11);
        }
        leverSelectDialogFragment.wi(i11);
        leverSelectDialogFragment.bc(linearSwapPosition.getSymbol());
        leverSelectDialogFragment.xi(e.m(context, linearSwapPosition.getSymbol(), str, linearSwapPosition.getContractCode(), linearSwapPosition.getContractType(), i11));
        leverSelectDialogFragment.ti(linearSwapPosition.getLeverRate());
        leverSelectDialogFragment.setTradeType(TradeType.LINEAR_SWAP);
        if (linearSwapPositionOrderItem.c() != null) {
            leverSelectDialogFragment.zi(linearSwapPositionOrderItem.c().a());
            leverSelectDialogFragment.vi(linearSwapPositionOrderItem.c().g(futureContractInfo, i11));
        }
        leverSelectDialogFragment.setDialogDismissListener(new l(leverSelectDialogFragment));
        leverSelectDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), getClass().getSimpleName());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getResId() {
        return R$layout.layout_contract_position_list_item;
    }

    public final int p(Context context, String str) {
        BigDecimal a11 = i6.m.a(str);
        if (a11.compareTo(BigDecimal.ZERO) > 0) {
            if (w.l()) {
                return context.getColor(R$color.global_huobi_color);
            }
            return context.getColor(R$color.global_quotation_down_color);
        } else if (a11.compareTo(BigDecimal.ZERO) >= 0) {
            return context.getColor(R$color.global_default_text_color);
        } else {
            if (w.l()) {
                return context.getColor(R$color.global_quotation_down_color);
            }
            return context.getColor(R$color.global_huobi_color);
        }
    }

    public final String q(String str, String str2) {
        BigDecimal a11 = i6.m.a(str);
        String q11 = i6.m.q(a11.multiply(i6.m.f68179a), FuturePrecisionUtil.q(str2));
        if (a11.compareTo(BigDecimal.ZERO) > 0) {
            return AppUtil.b("+", q11, "%");
        } else if (a11.compareTo(BigDecimal.ZERO) < 0) {
            return AppUtil.b(q11, "%");
        } else {
            return AppUtil.b(q11, "%");
        }
    }

    /* renamed from: r */
    public void handleView(v9.c cVar, int i11, LinearSwapPositionOrderItem linearSwapPositionOrderItem, ViewGroup viewGroup) {
        String str;
        View.OnClickListener onClickListener;
        LinearSwapPositionOrderItem linearSwapPositionOrderItem2 = linearSwapPositionOrderItem;
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        Resources resources = context.getResources();
        LinearSwapPosition e12 = linearSwapPositionOrderItem.e();
        FutureContractInfo d11 = linearSwapPositionOrderItem.d();
        if (d11 == null) {
            String str2 = "LinearSwapPositionOrderItemHandler-->symbol:" + e12.getSymbol();
            k.e(str2);
            BaseModuleConfig.a().x(str2);
            return;
        }
        String contractShortType = d11.getContractShortType();
        String contractFace = d11.getContractFace();
        String i12 = StringUtils.i(d11.getQuoteCurrency());
        int s11 = FuturePrecisionUtil.s(e12.getContractCode(), contractShortType, (String) null);
        int y11 = FuturePrecisionUtil.y(e12.getContractCode(), contractShortType, (String) null);
        int w11 = FuturePrecisionUtil.w(e12.getContractCode(), contractShortType, (String) null);
        TextView textView = (TextView) e11.b(R$id.contract_position_label_tv);
        TextView textView2 = (TextView) e11.b(R$id.contract_position_profit_rate_tv);
        TextView textView3 = (TextView) e11.b(R$id.contract_position_amount_value_tv);
        TextView textView4 = (TextView) e11.b(R$id.contract_position_open_label_tv);
        TextView textView5 = (TextView) e11.b(R$id.contract_position_open_value_tv);
        TextView textView6 = (TextView) e11.b(R$id.contract_position_profit_unreal_label_tv);
        TextView textView7 = (TextView) e11.b(R$id.contract_position_profit_unreal_value_tv);
        TextView textView8 = (TextView) e11.b(R$id.contract_position_close_tv);
        TextView textView9 = (TextView) e11.b(R$id.contract_position_close_quick);
        View b11 = e11.b(R$id.contract_position_share_iv);
        View b12 = e11.b(R$id.status_button_contract_item_stop_profit);
        View b13 = e11.b(R$id.contract_position_reverse);
        TextView textView10 = (TextView) e11.b(R$id.tv_contract_position_direction);
        int i13 = w11;
        ImageView imageView = (ImageView) e11.b(R$id.iv_adl_level);
        int i14 = y11;
        ImageView imageView2 = (ImageView) e11.b(R$id.iv_item_edit);
        View b14 = e11.b(R$id.v_fake_bond);
        View b15 = e11.b(R$id.iv_contract_bond_add);
        int i15 = s11;
        TextView textView11 = (TextView) e11.b(R$id.contract_position_amount_label_tv);
        int i16 = FutureContractInfo.MARGIN_CROSS.equalsIgnoreCase(e12.getMarginMode()) ? 1 : 2;
        if (!ContractModuleConfig.a().b() || i16 != 2) {
            b15.setVisibility(8);
        } else {
            b15.setVisibility(0);
        }
        textView.setText(e.t(context, SPUtil.j() ? linearSwapPositionOrderItem2.f26410c.symbol : e12.getSymbol(), i12, e12.getContractType()));
        TextView textView12 = (TextView) e11.b(R$id.contract_position_longshort_tv);
        TextView textView13 = (TextView) e11.b(R$id.contract_position_marginmode_tv);
        TextView textView14 = (TextView) e11.b(R$id.contract_position_lever_tv);
        View view = b15;
        OptionDirection optionDirection = OptionDirection.BUY;
        r rVar = e11;
        textView12.setText(context.getString(optionDirection.direction.equalsIgnoreCase(e12.getDirection()) ? R$string.contarct_position_more : R$string.contarct_position_empty));
        if (i16 == 1) {
            str = context.getResources().getString(R$string.n_contract_super_margin);
        } else {
            str = context.getResources().getString(R$string.n_contract_trade_margin);
        }
        textView13.setText(str);
        textView14.setText(e12.getLeverRate() + "X");
        if (w.l()) {
            if (optionDirection.direction.equalsIgnoreCase(e12.getDirection())) {
                textView10.setText(context.getString(R$string.n_contract_position_buy_label));
                textView10.setBackground(ContextCompat.getDrawable(context, R$drawable.shape_fill_red_radius));
            } else {
                textView10.setText(context.getString(R$string.n_contract_position_sell_label));
                textView10.setBackground(ContextCompat.getDrawable(context, R$drawable.shape_fill_green_radius));
            }
        } else if (optionDirection.direction.equalsIgnoreCase(e12.getDirection())) {
            textView10.setText(context.getString(R$string.n_contract_position_buy_label));
            textView10.setBackground(ContextCompat.getDrawable(context, R$drawable.shape_fill_green_radius));
        } else {
            textView10.setText(context.getString(R$string.n_contract_position_sell_label));
            textView10.setBackground(ContextCompat.getDrawable(context, R$drawable.shape_fill_red_radius));
        }
        if (SPUtil.j()) {
            ViewUtil.m(imageView, true);
            if (e12.getAdlRiskPercent() == 1) {
                imageView.setImageResource(R$drawable.icon_adl_level_1);
            } else if (e12.getAdlRiskPercent() == 2) {
                imageView.setImageResource(R$drawable.icon_adl_level_2);
            } else if (e12.getAdlRiskPercent() == 3) {
                imageView.setImageResource(R$drawable.icon_adl_level_3);
            } else if (e12.getAdlRiskPercent() == 4) {
                imageView.setImageResource(R$drawable.icon_adl_level_4);
            } else if (e12.getAdlRiskPercent() == 5) {
                imageView.setImageResource(R$drawable.icon_adl_level_5);
            } else {
                ViewUtil.m(imageView, false);
            }
        } else if (e12.isAdl()) {
            ViewUtil.m(imageView, true);
            if (e12.getAdlRiskPercent() == 1) {
                imageView.setImageResource(R$drawable.icon_adl_level_1);
            } else if (e12.getAdlRiskPercent() == 2) {
                imageView.setImageResource(R$drawable.icon_adl_level_2);
            } else if (e12.getAdlRiskPercent() == 3) {
                imageView.setImageResource(R$drawable.icon_adl_level_3);
            } else if (e12.getAdlRiskPercent() == 4) {
                imageView.setImageResource(R$drawable.icon_adl_level_4);
            } else if (e12.getAdlRiskPercent() == 5) {
                imageView.setImageResource(R$drawable.icon_adl_level_5);
            } else {
                ViewUtil.m(imageView, false);
            }
        } else {
            ViewUtil.m(imageView, false);
        }
        imageView.setOnClickListener(new j(context));
        TextView textView15 = textView5;
        TextView textView16 = textView6;
        TextView textView17 = textView7;
        TextView textView18 = textView8;
        TextView textView19 = textView9;
        View view2 = b11;
        View view3 = b12;
        TextView textView20 = textView4;
        int i17 = i13;
        View view4 = b14;
        View view5 = view;
        TextView textView21 = textView3;
        String str3 = contractFace;
        int i18 = i15;
        TextView textView22 = textView21;
        TextView textView23 = textView11;
        String str4 = i12;
        imageView2.setOnClickListener(new ze.k(this, e12, i16, context, i12, linearSwapPositionOrderItem, d11));
        textView20.setText(resources.getString(R$string.n_contarct_position_cost_open_label2) + "(" + str4 + ")");
        TradeType tradeType = TradeType.LINEAR_SWAP;
        if (e.E(tradeType)) {
            textView23.setText(String.format(context.getString(R$string.n_contarct_position_volume_label), new Object[]{e12.getSymbol()}));
            if (i6.m.a(e12.getPositionPrice()).compareTo(BigDecimal.ZERO) == 0) {
                textView22.setText(i6.m.m("0", i15));
            } else {
                textView22.setText(i6.m.m(FutureUnitUtil.a(e12.getVolume(), e12.getPositionPrice(), str3, tradeType), i15));
            }
        } else {
            String str5 = str3;
            TextView textView24 = textView22;
            int i19 = i15;
            if (e.G(tradeType)) {
                textView23.setText(String.format(context.getString(R$string.n_contarct_position_volume_label), new Object[]{"usdt".toUpperCase(Locale.US)}));
                if (i6.m.a(e12.getPositionPrice()).compareTo(BigDecimal.ZERO) == 0) {
                    textView24.setText(i6.m.m("0", i19));
                } else {
                    textView24.setText(FutureUnitUtil.b(e12.getVolume(), e12.getPositionPrice(), str5, tradeType, FuturePrecisionUtil.g(e12.getSymbol())));
                }
            } else {
                textView23.setText(String.format(context.getString(R$string.n_contarct_position_volume_label), new Object[]{context.getString(R$string.contract_market_vol_sheet)}));
                textView24.setText(i6.m.m(e12.getVolume(), FuturePrecisionUtil.B()));
            }
        }
        int i21 = i14;
        String m11 = i6.m.m(e12.getAvgCostPrice(), i21);
        e12.setCostOpenDisplay(m11);
        textView5.setText(m11);
        textView6.setText(String.format(context.getString(R$string.contarct_position_profit_unreal_label), new Object[]{str4}));
        int p11 = p(context, e12.getProfitRate());
        int i22 = i17;
        TextView textView25 = textView17;
        textView25.setText(i6.m.m(e12.getProfit(), i22));
        textView25.setTextColor(p11);
        TextView textView26 = textView2;
        textView26.setText(q(e12.getProfitRate(), e12.getSymbol()));
        textView26.setTextColor(p11);
        LinearSwapPositionOrderItem linearSwapPositionOrderItem3 = linearSwapPositionOrderItem;
        textView18.setOnClickListener(new p(linearSwapPositionOrderItem3));
        textView19.setOnClickListener(new t(linearSwapPositionOrderItem3));
        view2.setOnClickListener(new u(linearSwapPositionOrderItem3));
        view3.setOnClickListener(new ze.r(linearSwapPositionOrderItem3));
        dw.a.a(b13).throttleFirst(1, TimeUnit.SECONDS).subscribe(new n(linearSwapPositionOrderItem3));
        view4.setOnClickListener(new o(view5, linearSwapPositionOrderItem3));
        cVar.itemView.setOnClickListener(new q(linearSwapPositionOrderItem3));
        r rVar2 = rVar;
        ((TextView) rVar2.b(R$id.contract_position_current_price_label_tv)).setText(resources.getString(R$string.index_price_text, new Object[]{str4}));
        String m12 = i6.m.m(e12.getPositionPrice(), i21);
        e12.setLastPriceDisplay(m12);
        ((TextView) rVar2.b(R$id.contract_position_current_price_value_tv)).setText(m12);
        ((TextView) rVar2.b(R$id.contract_position_cost_hold_label_tv)).setText(resources.getString(R$string.n_contarct_position_original_margin, new Object[]{str4}));
        ((TextView) rVar2.b(R$id.contract_position_cost_hold_value_tv)).setText(i6.m.m(e12.getFinalPositionMargin(), i22));
        ((TextView) rVar2.b(R$id.contract_position_margin_label_tv)).setText(String.format(Locale.US, resources.getString(R$string.n_linear_swap_prediction_of_strong_parity), new Object[]{"(" + str4 + ")"}));
        TextView textView27 = (TextView) rVar2.b(R$id.contract_position_margin_value_tv);
        String liquidationPrice = e12.getLiquidationPrice();
        if (TextUtils.isEmpty(liquidationPrice) || liquidationPrice.contains(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            onClickListener = null;
            textView27.setText("--");
        } else {
            onClickListener = null;
            textView27.setText(i6.m.q(i6.m.a(liquidationPrice), FuturePrecisionUtil.y(linearSwapPositionOrderItem.d().getContractCode(), linearSwapPositionOrderItem.d().getContractShortType(), (String) null)));
        }
        TextView textView28 = (TextView) rVar2.b(R$id.contract_position_guarantee_asset_rate);
        if (ContractModuleConfig.a().b()) {
            if (!TextUtils.isEmpty(e12.getNewPositionRate())) {
                textView28.setText(i6.m.Q(i6.m.a(e12.getNewPositionRate()).toPlainString(), FuturePrecisionUtil.i(e12.getSymbol()), 1));
            } else {
                textView28.setText("--");
            }
        } else if (!TextUtils.isEmpty(e12.getPositionRate())) {
            textView28.setText(i6.m.Q(i6.m.a(e12.getPositionRate()).toPlainString(), FuturePrecisionUtil.i(e12.getSymbol()), 1));
        } else {
            textView28.setText("--");
        }
        if (linearSwapPositionOrderItem3.f26409b.isFromNet()) {
            View b16 = rVar2.b(R$id.ll_position_tpsl);
            TextView textView29 = (TextView) rVar2.b(R$id.contract_position_tpsl_title_tv);
            TextView textView30 = (TextView) rVar2.b(R$id.contract_position_tpsl_value_tv);
            if (!TextUtils.isEmpty(e12.tpTriggerPrice) && !TextUtils.isEmpty(e12.slTriggerPrice)) {
                b16.setVisibility(0);
                b16.setOnClickListener(new s(linearSwapPositionOrderItem3));
                textView29.setText(resources.getString(R$string.n_contract_position_tab_second));
                textView30.setText(i6.m.m(e12.tpTriggerPrice, i21) + "/" + i6.m.m(e12.slTriggerPrice, i21));
            } else if (!TextUtils.isEmpty(e12.tpTriggerPrice)) {
                b16.setVisibility(0);
                b16.setOnClickListener(new ze.w(linearSwapPositionOrderItem3));
                textView29.setText(resources.getString(R$string.n_contract_position_tp));
                textView30.setText(i6.m.m(e12.tpTriggerPrice, i21));
            } else if (!TextUtils.isEmpty(e12.slTriggerPrice)) {
                b16.setVisibility(0);
                b16.setOnClickListener(new v(linearSwapPositionOrderItem3));
                textView29.setText(resources.getString(R$string.n_contract_position_sl));
                textView30.setText(i6.m.m(e12.slTriggerPrice, i21));
            } else {
                b16.setVisibility(8);
                b16.setOnClickListener(onClickListener);
            }
        }
    }
}
