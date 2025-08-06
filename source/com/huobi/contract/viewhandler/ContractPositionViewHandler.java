package com.huobi.contract.viewhandler;

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
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.contract.core.controller.ContractAllowLevelController;
import com.hbg.lib.network.option.core.util.OptionDirection;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ej.f;
import ej.g;
import fj.h;
import fj.i;
import fj.j;
import fj.k;
import fj.l;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import s9.c;

public class ContractPositionViewHandler implements c, View.OnClickListener {

    public class a extends BaseSubscriber<List<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ContractPosition f43583b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LeverSelectDialogFragment f43584c;

        public a(ContractPosition contractPosition, LeverSelectDialogFragment leverSelectDialogFragment) {
            this.f43583b = contractPosition;
            this.f43584c = leverSelectDialogFragment;
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            if (TextUtils.equals(this.f43583b.getSymbol(), this.f43584c.o0())) {
                this.f43584c.tc(list);
                this.f43584c.ti(this.f43583b.getLeverRate());
            }
        }
    }

    public static /* synthetic */ void j(ContractPosition contractPosition, Void voidR) {
        if (contractPosition.getClickListener() != null) {
            contractPosition.getClickListener().c(contractPosition);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void k(ContractPosition contractPosition, View view) {
        if (contractPosition.getClickListener() != null) {
            contractPosition.getClickListener().g(contractPosition);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void m(Context context, View view) {
        DialogUtils.X((FragmentActivity) context, context.getString(R$string.n_contract_ADL_auto_stock_alert_title), context.getString(R$string.n_contract_ADL_auto_stock_alert_content), "", context.getString(R$string.n_known), k.f54621a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final int g(Context context, String str) {
        BigDecimal a11 = m.a(str);
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

    public int getResId() {
        return R$layout.layout_contract_position_list_item;
    }

    public final String h(String str, String str2) {
        BigDecimal a11 = m.a(str);
        String q11 = m.q(a11.multiply(m.f68179a), f.i(str2));
        if (a11.compareTo(BigDecimal.ZERO) > 0) {
            return AppUtil.b("+", q11, "%");
        } else if (a11.compareTo(BigDecimal.ZERO) < 0) {
            return AppUtil.b(q11, "%");
        } else {
            return AppUtil.b(q11, "%");
        }
    }

    /* renamed from: i */
    public void handleView(v9.c cVar, int i11, ContractPosition contractPosition, ViewGroup viewGroup) {
        ContractPosition contractPosition2 = contractPosition;
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        TextView textView = (TextView) e11.b(R$id.contract_position_label_tv);
        TextView textView2 = (TextView) e11.b(R$id.contract_position_profit_rate_tv);
        TextView textView3 = (TextView) e11.b(R$id.contract_position_amount_label_tv);
        TextView textView4 = (TextView) e11.b(R$id.contract_position_amount_value_tv);
        TextView textView5 = (TextView) e11.b(R$id.contract_position_profit_unreal_label_tv);
        TextView textView6 = (TextView) e11.b(R$id.contract_position_profit_unreal_value_tv);
        TextView textView7 = (TextView) e11.b(R$id.contract_position_close_tv);
        View b11 = e11.b(R$id.contract_position_close_quick);
        TextView textView8 = (TextView) e11.b(R$id.contract_position_open_value_tv);
        TextView textView9 = (TextView) e11.b(R$id.contract_position_margin_label_tv);
        View b12 = e11.b(R$id.status_button_contract_item_stop_profit);
        b12.setOnClickListener(this);
        View view = b12;
        View view2 = b11;
        ImageView imageView = (ImageView) e11.b(R$id.contract_position_share_iv);
        dw.a.a(e11.b(R$id.contract_position_reverse)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new l(contractPosition2));
        TextView textView10 = (TextView) e11.b(R$id.tv_contract_position_direction);
        if (w.l()) {
            if (OptionDirection.BUY.direction.equalsIgnoreCase(contractPosition.getDirection())) {
                textView10.setText(context.getString(R$string.n_contract_position_buy_label));
                textView10.setBackground(ContextCompat.getDrawable(context, R$drawable.shape_fill_red_radius));
            } else {
                textView10.setText(context.getString(R$string.n_contract_position_sell_label));
                textView10.setBackground(ContextCompat.getDrawable(context, R$drawable.shape_fill_green_radius));
            }
        } else if (OptionDirection.BUY.direction.equalsIgnoreCase(contractPosition.getDirection())) {
            textView10.setText(context.getString(R$string.n_contract_position_buy_label));
            textView10.setBackground(ContextCompat.getDrawable(context, R$drawable.shape_fill_green_radius));
        } else {
            textView10.setText(context.getString(R$string.n_contract_position_sell_label));
            textView10.setBackground(ContextCompat.getDrawable(context, R$drawable.shape_fill_red_radius));
        }
        TextView textView11 = (TextView) e11.b(R$id.contract_position_longshort_tv);
        TextView textView12 = (TextView) e11.b(R$id.contract_position_marginmode_tv);
        TextView textView13 = (TextView) e11.b(R$id.contract_position_lever_tv);
        r rVar = e11;
        textView11.setText(context.getString(OptionDirection.BUY.direction.equalsIgnoreCase(contractPosition.getDirection()) ? R$string.contarct_position_more : R$string.contarct_position_empty));
        ViewUtil.m(textView12, false);
        textView13.setText(contractPosition.getLeverRate() + "X");
        if (contractPosition.getContractCurrencyInfo() != null) {
            textView.setText(g.h(contractPosition.getContractCurrencyInfo().getContractShortType(), contractPosition.getContractCode(), 2));
        }
        Resources resources = context.getResources();
        int p11 = f.p(contractPosition.getContractCode());
        if (e.E(TradeType.CONTRACT)) {
            textView3.setText(String.format(context.getString(R$string.n_contarct_position_volume_label), new Object[]{contractPosition.getSymbol()}));
            if (m.a(contractPosition.getLastPrice()).compareTo(BigDecimal.ZERO) == 0) {
                textView4.setText(m.m("0", f.n(contractPosition.getContractCode())));
            } else {
                String contractFace = contractPosition.getContractCurrencyInfo() != null ? contractPosition.getContractCurrencyInfo().getContractFace() : "";
                BigDecimal divide = m.a(contractPosition.getVolume()).multiply(m.a(contractFace)).divide(m.a(contractPosition.getLastPrice()), 32, 1);
                m.a(contractPosition.getAvailable()).multiply(m.a(contractFace)).divide(m.a(contractPosition.getLastPrice()), 32, 1);
                textView4.setText(m.q(divide, f.n(contractPosition.getContractCode())));
            }
        } else {
            textView3.setText(String.format(context.getString(R$string.n_contarct_position_volume_label), new Object[]{context.getString(R$string.contract_market_vol_sheet)}));
            textView4.setText(m.m(contractPosition.getVolume(), f.g(contractPosition.getSymbol())));
        }
        String m11 = m.m(contractPosition.getCostOpen(), f.p(contractPosition.getContractCode()));
        contractPosition2.setCostOpenDisplay(m11);
        textView8.setText(m11);
        textView5.setText(String.format(context.getString(R$string.contarct_position_profit_unreal_label), new Object[]{contractPosition.getSymbol()}));
        int g11 = g(context, contractPosition.getProfitRate());
        textView6.setText(m.m(contractPosition.getProfit(), f.n(contractPosition.getContractCode())));
        textView6.setTextColor(g11);
        textView2.setText(h(contractPosition.getProfitRate(), contractPosition.getSymbol()));
        textView2.setTextColor(g11);
        int i12 = R$id.item_data1;
        textView7.setTag(i12, contractPosition2);
        int i13 = R$id.item_data2;
        textView7.setTag(i13, Integer.valueOf(i11));
        textView7.setOnClickListener(this);
        View view3 = view2;
        view3.setTag(i12, contractPosition2);
        view3.setTag(i13, Integer.valueOf(i11));
        view3.setOnClickListener(this);
        ImageView imageView2 = imageView;
        imageView2.setTag(i12, contractPosition2);
        imageView2.setOnClickListener(this);
        View view4 = view;
        view4.setTag(i12, contractPosition2);
        view4.setTag(i13, Integer.valueOf(i11));
        cVar.itemView.setOnClickListener(new i(contractPosition2));
        r rVar2 = rVar;
        ((TextView) rVar2.b(R$id.contract_position_current_price_label_tv)).setText(context.getString(R$string.index_price_text, new Object[]{StringUtils.i("usd")}));
        String m12 = m.m(contractPosition.getLastPrice(), p11);
        contractPosition2.setLastPriceDisplay(m12);
        ((TextView) rVar2.b(R$id.contract_position_current_price_value_tv)).setText(m12);
        ((TextView) rVar2.b(R$id.contract_position_cost_hold_label_tv)).setText(resources.getString(R$string.n_contarct_position_original_margin, new Object[]{contractPosition.getSymbol()}));
        ((TextView) rVar2.b(R$id.contract_position_cost_hold_value_tv)).setText(m.m(contractPosition.getPositionMargin(), f.n(contractPosition.getContractCode())));
        TextView textView14 = (TextView) rVar2.b(R$id.contract_position_margin_value_tv);
        if (!TextUtils.isEmpty(contractPosition.getLiquidationPrice())) {
            textView14.setText(m.q(m.a(contractPosition.getLiquidationPrice()), f.p(contractPosition.getContractCurrencyInfo().getContractCode())));
        } else {
            textView14.setText("--");
        }
        TextView textView15 = (TextView) rVar2.b(R$id.contract_position_guarantee_asset_rate);
        if (!TextUtils.isEmpty(contractPosition.getNewRiskRate())) {
            textView15.setText(m.Q(m.a(contractPosition.getNewRiskRate()).toPlainString(), FuturePrecisionUtil.i(contractPosition.getSymbol()), 1));
        } else {
            textView15.setText("--");
        }
        ImageView imageView3 = (ImageView) rVar2.b(R$id.iv_adl_level);
        if (contractPosition.isAdl()) {
            ViewUtil.m(imageView3, true);
            if (contractPosition.getAdlRiskPercent() == 1) {
                imageView3.setImageResource(R$drawable.icon_adl_level_1);
            } else if (contractPosition.getAdlRiskPercent() == 2) {
                imageView3.setImageResource(R$drawable.icon_adl_level_2);
            } else if (contractPosition.getAdlRiskPercent() == 3) {
                imageView3.setImageResource(R$drawable.icon_adl_level_3);
            } else if (contractPosition.getAdlRiskPercent() == 4) {
                imageView3.setImageResource(R$drawable.icon_adl_level_4);
            } else if (contractPosition.getAdlRiskPercent() == 5) {
                imageView3.setImageResource(R$drawable.icon_adl_level_5);
            } else {
                ViewUtil.m(imageView3, false);
            }
        } else {
            ViewUtil.m(imageView3, false);
        }
        imageView3.setOnClickListener(new h(context));
        ImageView imageView4 = (ImageView) rVar2.b(R$id.iv_item_edit);
        imageView4.setTag(i12, contractPosition2);
        imageView4.setTag(i13, Integer.valueOf(i11));
        imageView4.setOnClickListener(this);
        View b13 = rVar2.b(R$id.ll_position_tpsl);
        TextView textView16 = (TextView) rVar2.b(R$id.contract_position_tpsl_title_tv);
        TextView textView17 = (TextView) rVar2.b(R$id.contract_position_tpsl_value_tv);
        if (!TextUtils.isEmpty(contractPosition2.tpTriggerPrice) && !TextUtils.isEmpty(contractPosition2.slTriggerPrice)) {
            b13.setVisibility(0);
            b13.setTag(i12, contractPosition2);
            b13.setTag(i13, Integer.valueOf(i11));
            b13.setOnClickListener(this);
            textView16.setText(context.getString(R$string.n_contract_position_tab_second));
            textView17.setText(m.m(contractPosition2.tpTriggerPrice, p11) + "/" + m.m(contractPosition2.slTriggerPrice, p11));
        } else if (!TextUtils.isEmpty(contractPosition2.tpTriggerPrice)) {
            b13.setVisibility(0);
            b13.setTag(i12, contractPosition2);
            b13.setTag(i13, Integer.valueOf(i11));
            b13.setOnClickListener(this);
            textView16.setText(context.getString(R$string.n_contract_position_tp));
            textView17.setText(m.m(contractPosition2.tpTriggerPrice, p11));
        } else if (!TextUtils.isEmpty(contractPosition2.slTriggerPrice)) {
            b13.setVisibility(0);
            b13.setTag(i12, contractPosition2);
            b13.setTag(i13, Integer.valueOf(i11));
            b13.setOnClickListener(this);
            textView16.setText(context.getString(R$string.n_contract_position_sl));
            textView17.setText(m.m(contractPosition2.slTriggerPrice, p11));
        } else {
            b13.setVisibility(8);
            b13.setOnClickListener((View.OnClickListener) null);
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        ContractPosition contractPosition = (ContractPosition) view.getTag(R$id.item_data1);
        if (view.getId() == R$id.contract_position_close_quick) {
            int intValue = ((Integer) view.getTag(R$id.item_data2)).intValue();
            if (contractPosition.getClickListener() != null) {
                contractPosition.getClickListener().h(1, contractPosition, intValue, view.getContext());
            }
        } else if (view.getId() == R$id.contract_position_close_tv) {
            int intValue2 = ((Integer) view.getTag(R$id.item_data2)).intValue();
            if (contractPosition.getClickListener() != null) {
                contractPosition.getClickListener().h(0, contractPosition, intValue2, view.getContext());
            }
        } else if (view.getId() == R$id.contract_position_share_iv) {
            if (contractPosition.getClickListener() != null) {
                contractPosition.getClickListener().f(contractPosition);
            }
        } else if (view.getId() == R$id.status_button_contract_item_stop_profit) {
            int intValue3 = ((Integer) view.getTag(R$id.item_data2)).intValue();
            if (contractPosition.getClickListener() != null) {
                contractPosition.getClickListener().h(2, contractPosition, intValue3, view.getContext());
            }
        } else if (view.getId() == R$id.iv_item_edit) {
            LeverSelectDialogFragment leverSelectDialogFragment = new LeverSelectDialogFragment();
            leverSelectDialogFragment.ui(true);
            leverSelectDialogFragment.si(contractPosition.getContractCode());
            List<String> c11 = ContractAllowLevelController.c(contractPosition.getSymbol());
            if (c11 == null || c11.size() <= 0) {
                ContractAllowLevelController.b(true, contractPosition.getSymbol()).retry(5).compose(RxJavaHelper.t((u6.g) null)).subscribe(new a(contractPosition, leverSelectDialogFragment));
            } else {
                leverSelectDialogFragment.tc(c11);
            }
            leverSelectDialogFragment.bc(contractPosition.getSymbol());
            leverSelectDialogFragment.xi(g.d(contractPosition.getContractCurrencyInfo().getContractShortType(), contractPosition.getContractCode(), 2));
            leverSelectDialogFragment.ti(contractPosition.getLeverRate());
            leverSelectDialogFragment.setTradeType(TradeType.CONTRACT);
            if (contractPosition.getClickListener() != null) {
                leverSelectDialogFragment.zi(contractPosition.getClickListener().a());
                leverSelectDialogFragment.vi(contractPosition.getClickListener().e(contractPosition));
            }
            leverSelectDialogFragment.setDialogDismissListener(new j(leverSelectDialogFragment));
            leverSelectDialogFragment.show(((FragmentActivity) view.getContext()).getSupportFragmentManager(), getClass().getSimpleName());
        } else if (view.getId() == R$id.ll_position_tpsl && contractPosition.getClickListener() != null) {
            contractPosition.getClickListener().d(contractPosition);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
