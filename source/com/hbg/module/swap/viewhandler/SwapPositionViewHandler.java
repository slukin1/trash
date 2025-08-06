package com.hbg.module.swap.viewhandler;

import a7.e;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import bg.b;
import bg.d;
import bg.f;
import bg.h;
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
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.option.core.util.OptionDirection;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapPosition;
import com.hbg.lib.network.swap.core.controller.SwapAllowLevelController;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.swap.bean.SwapPositionItem;
import com.huobi.feature.ui.LeverSelectDialogFragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import s9.c;
import u6.g;
import us.i;
import us.j;

public class SwapPositionViewHandler implements c, View.OnClickListener {

    public class a extends BaseSubscriber<List<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SwapPosition f37469b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ LeverSelectDialogFragment f37470c;

        public a(SwapPosition swapPosition, LeverSelectDialogFragment leverSelectDialogFragment) {
            this.f37469b = swapPosition;
            this.f37470c = leverSelectDialogFragment;
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            if (TextUtils.equals(this.f37469b.getContractCode(), this.f37470c.bi())) {
                this.f37470c.tc(list);
                this.f37470c.ti(this.f37469b.getLeverRate());
            }
        }
    }

    public static /* synthetic */ void n(SwapPositionItem swapPositionItem, Void voidR) {
        if (swapPositionItem.c() != null) {
            swapPositionItem.c().c(swapPositionItem);
        }
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void o(SwapPositionItem swapPositionItem, View view) {
        if (swapPositionItem.c() != null) {
            swapPositionItem.c().f(swapPositionItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void q(Context context, View view) {
        DialogUtils.X((FragmentActivity) context, context.getString(R$string.n_contract_ADL_auto_stock_alert_title), context.getString(R$string.n_contract_ADL_auto_stock_alert_content), "", context.getString(R$string.n_known), h.f12373a);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void s(SwapPosition swapPosition, Context context, SwapPositionItem swapPositionItem, View view) {
        LeverSelectDialogFragment leverSelectDialogFragment = new LeverSelectDialogFragment();
        leverSelectDialogFragment.ui(true);
        leverSelectDialogFragment.si(swapPosition.getContractCode());
        List<String> c11 = SwapAllowLevelController.c(swapPosition.getSymbol());
        if (c11 == null || c11.size() <= 0) {
            SwapAllowLevelController.b(true, swapPosition.getSymbol()).compose(RxJavaHelper.t((g) null)).retry(5).subscribe(new a(swapPosition, leverSelectDialogFragment));
        } else {
            leverSelectDialogFragment.tc(c11);
        }
        leverSelectDialogFragment.bc(swapPosition.getSymbol());
        leverSelectDialogFragment.xi(j.f(swapPosition.getSymbol(), context));
        leverSelectDialogFragment.ti(swapPosition.getLeverRate());
        leverSelectDialogFragment.setTradeType(TradeType.SWAP);
        if (swapPositionItem.c() != null) {
            leverSelectDialogFragment.zi(swapPositionItem.c().a());
            leverSelectDialogFragment.vi(swapPositionItem.c().g(swapPositionItem, swapPosition));
        }
        leverSelectDialogFragment.setDialogDismissListener(new bg.g(leverSelectDialogFragment));
        leverSelectDialogFragment.show(((FragmentActivity) context).getSupportFragmentManager(), getClass().getSimpleName());
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void t(SwapPositionItem swapPositionItem, View view) {
        if (swapPositionItem.c() != null) {
            swapPositionItem.c().d(swapPositionItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void u(SwapPositionItem swapPositionItem, View view) {
        if (swapPositionItem.c() != null) {
            swapPositionItem.c().d(swapPositionItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void v(SwapPositionItem swapPositionItem, View view) {
        if (swapPositionItem.c() != null) {
            swapPositionItem.c().d(swapPositionItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public int getResId() {
        return R$layout.layout_contract_position_list_item;
    }

    public final int k(Context context, String str) {
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

    public final String l(String str, String str2) {
        BigDecimal a11 = m.a(str);
        String q11 = m.q(a11.multiply(m.f68179a), i.s(str2));
        if (a11.compareTo(BigDecimal.ZERO) > 0) {
            return AppUtil.b("+", q11, "%");
        } else if (a11.compareTo(BigDecimal.ZERO) < 0) {
            return AppUtil.b(q11, "%");
        } else {
            return AppUtil.b(q11, "%");
        }
    }

    /* renamed from: m */
    public void handleView(v9.c cVar, int i11, SwapPositionItem swapPositionItem, ViewGroup viewGroup) {
        SwapPositionItem swapPositionItem2 = swapPositionItem;
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        SwapPosition d11 = swapPositionItem.d();
        TextView textView = (TextView) e11.b(R$id.contract_position_label_tv);
        TextView textView2 = (TextView) e11.b(R$id.contract_position_profit_rate_tv);
        TextView textView3 = (TextView) e11.b(R$id.contract_position_amount_label_tv);
        TextView textView4 = (TextView) e11.b(R$id.contract_position_amount_value_tv);
        TextView textView5 = (TextView) e11.b(R$id.contract_position_profit_unreal_label_tv);
        TextView textView6 = (TextView) e11.b(R$id.contract_position_profit_unreal_value_tv);
        View b11 = e11.b(R$id.contract_position_close_quick);
        TextView textView7 = (TextView) e11.b(R$id.contract_position_open_value_tv);
        View b12 = e11.b(R$id.status_button_contract_item_stop_profit);
        ImageView imageView = (ImageView) e11.b(R$id.contract_position_share_iv);
        TextView textView8 = (TextView) e11.b(R$id.contract_position_close_tv);
        View view = b11;
        dw.a.a(e11.b(R$id.contract_position_reverse)).throttleFirst(1, TimeUnit.SECONDS).subscribe(new bg.i(swapPositionItem2));
        TextView textView9 = (TextView) e11.b(R$id.tv_contract_position_direction);
        if (w.l()) {
            if (OptionDirection.BUY.direction.equalsIgnoreCase(d11.getDirection())) {
                textView9.setText(context.getString(R$string.n_contract_position_buy_label));
                textView9.setBackground(ContextCompat.getDrawable(context, R$drawable.shape_fill_red_radius));
            } else {
                textView9.setText(context.getString(R$string.n_contract_position_sell_label));
                textView9.setBackground(ContextCompat.getDrawable(context, R$drawable.shape_fill_green_radius));
            }
        } else if (OptionDirection.BUY.direction.equalsIgnoreCase(d11.getDirection())) {
            textView9.setText(context.getString(R$string.n_contract_position_buy_label));
            textView9.setBackground(ContextCompat.getDrawable(context, R$drawable.shape_fill_green_radius));
        } else {
            textView9.setText(context.getString(R$string.n_contract_position_sell_label));
            textView9.setBackground(ContextCompat.getDrawable(context, R$drawable.shape_fill_red_radius));
        }
        TextView textView10 = (TextView) e11.b(R$id.contract_position_longshort_tv);
        TextView textView11 = (TextView) e11.b(R$id.contract_position_marginmode_tv);
        TextView textView12 = (TextView) e11.b(R$id.contract_position_lever_tv);
        r rVar = e11;
        textView10.setText(context.getString(OptionDirection.BUY.direction.equalsIgnoreCase(d11.getDirection()) ? R$string.contarct_position_more : R$string.contarct_position_empty));
        ViewUtil.m(textView11, false);
        textView12.setText(d11.getLeverRate() + "X");
        int m11 = i.m(d11.getSymbol());
        textView.setText(j.g(context, d11.getSymbol()));
        if (e.E(TradeType.SWAP)) {
            textView3.setText(String.format(context.getString(R$string.n_contarct_position_volume_label), new Object[]{d11.getSymbol()}));
            if (m.a(d11.getLastPrice()).compareTo(BigDecimal.ZERO) == 0) {
                textView4.setText(m.m("0", i.k(d11.getSymbol())));
            } else {
                String contractFace = swapPositionItem.e() != null ? swapPositionItem.e().getContractFace() : "";
                BigDecimal divide = m.a(d11.getVolume()).multiply(m.a(contractFace)).divide(m.a(d11.getLastPrice()), 32, 1);
                m.a(d11.getAvailable()).multiply(m.a(contractFace)).divide(m.a(d11.getLastPrice()), 32, 1);
                textView4.setText(m.q(divide, i.k(d11.getSymbol())));
            }
        } else {
            textView3.setText(String.format(context.getString(R$string.n_contarct_position_volume_label), new Object[]{context.getString(R$string.contract_market_vol_sheet)}));
            textView4.setText(m.m(d11.getVolume(), i.l(d11.getSymbol())));
        }
        String m12 = m.m(d11.getCostOpen(), i.m(d11.getSymbol()));
        d11.costOpenDisplay = m12;
        textView7.setText(m12);
        textView5.setText(String.format(context.getString(R$string.contarct_position_profit_unreal_label), new Object[]{d11.getSymbol()}));
        int k11 = k(context, d11.getProfitRate());
        textView6.setText(m.m(d11.getProfit(), i.t(d11.getSymbol())));
        textView6.setTextColor(k11);
        textView2.setText(l(d11.getProfitRate(), d11.getSymbol()));
        textView2.setTextColor(k11);
        int i12 = R$id.item_data1;
        TextView textView13 = textView8;
        textView13.setTag(i12, swapPositionItem2);
        int i13 = R$id.item_data2;
        textView13.setTag(i13, Integer.valueOf(i11));
        textView13.setOnClickListener(this);
        View view2 = view;
        view2.setTag(i12, swapPositionItem2);
        view2.setTag(i13, Integer.valueOf(i11));
        view2.setOnClickListener(this);
        ImageView imageView2 = imageView;
        imageView2.setTag(i12, swapPositionItem2);
        imageView2.setOnClickListener(this);
        View view3 = b12;
        view3.setOnClickListener(this);
        view3.setTag(i12, swapPositionItem2);
        view3.setTag(i13, Integer.valueOf(i11));
        cVar.itemView.setOnClickListener(new b(swapPositionItem2));
        r rVar2 = rVar;
        ((TextView) rVar2.b(R$id.contract_position_current_price_label_tv)).setText(context.getString(R$string.index_price_text, new Object[]{StringUtils.i("usd")}));
        String m13 = m.m(d11.getLastPrice(), i.m(d11.getSymbol()));
        d11.lastPriceDisplay = m13;
        ((TextView) rVar2.b(R$id.contract_position_current_price_value_tv)).setText(m13);
        ((TextView) rVar2.b(R$id.contract_position_cost_hold_label_tv)).setText(context.getString(R$string.n_contarct_position_original_margin, new Object[]{d11.getSymbol()}));
        TextView textView14 = (TextView) rVar2.b(R$id.contract_position_cost_hold_value_tv);
        if (!TextUtils.isEmpty(d11.getPositionMargin())) {
            textView14.setText(m.q(m.a(d11.getPositionMargin()), i.c(d11.getSymbol())));
        } else {
            textView14.setText("--");
        }
        TextView textView15 = (TextView) rVar2.b(R$id.contract_position_margin_value_tv);
        if (!TextUtils.isEmpty(d11.getLiquidationPrice())) {
            textView15.setText(m.q(m.a(d11.getLiquidationPrice()), m11));
        } else {
            textView15.setText("--");
        }
        TextView textView16 = (TextView) rVar2.b(R$id.contract_position_guarantee_asset_rate);
        if (!TextUtils.isEmpty(d11.getNewRiskRate())) {
            textView16.setText(m.Q(m.a(d11.getNewRiskRate()).toPlainString(), i.n(d11.getSymbol()), 1));
        } else {
            textView16.setText("--");
        }
        ImageView imageView3 = (ImageView) rVar2.b(R$id.iv_adl_level);
        if (d11.isAdl()) {
            ViewUtil.m(imageView3, true);
            if (d11.getAdlRiskPercent() == 1) {
                imageView3.setImageResource(R$drawable.icon_adl_level_1);
            } else if (d11.getAdlRiskPercent() == 2) {
                imageView3.setImageResource(R$drawable.icon_adl_level_2);
            } else if (d11.getAdlRiskPercent() == 3) {
                imageView3.setImageResource(R$drawable.icon_adl_level_3);
            } else if (d11.getAdlRiskPercent() == 4) {
                imageView3.setImageResource(R$drawable.icon_adl_level_4);
            } else if (d11.getAdlRiskPercent() == 5) {
                imageView3.setImageResource(R$drawable.icon_adl_level_5);
            } else {
                ViewUtil.m(imageView3, false);
            }
        } else {
            ViewUtil.m(imageView3, false);
        }
        imageView3.setOnClickListener(new bg.a(context));
        ((ImageView) rVar2.b(R$id.iv_item_edit)).setOnClickListener(new f(this, d11, context, swapPositionItem2));
        View b13 = rVar2.b(R$id.ll_position_tpsl);
        TextView textView17 = (TextView) rVar2.b(R$id.contract_position_tpsl_title_tv);
        TextView textView18 = (TextView) rVar2.b(R$id.contract_position_tpsl_value_tv);
        if (!TextUtils.isEmpty(d11.tpTriggerPrice) && !TextUtils.isEmpty(d11.slTriggerPrice)) {
            b13.setVisibility(0);
            b13.setOnClickListener(new d(swapPositionItem2));
            textView17.setText(context.getString(R$string.n_contract_position_tab_second));
            textView18.setText(m.m(d11.tpTriggerPrice, m11) + "/" + m.m(d11.slTriggerPrice, m11));
        } else if (!TextUtils.isEmpty(d11.tpTriggerPrice)) {
            b13.setVisibility(0);
            b13.setOnClickListener(new bg.c(swapPositionItem2));
            textView17.setText(context.getString(R$string.n_contract_position_tp));
            textView18.setText(m.m(d11.tpTriggerPrice, m11));
        } else if (!TextUtils.isEmpty(d11.slTriggerPrice)) {
            b13.setVisibility(0);
            b13.setOnClickListener(new bg.e(swapPositionItem2));
            textView17.setText(context.getString(R$string.n_contract_position_sl));
            textView18.setText(m.m(d11.slTriggerPrice, m11));
        } else {
            b13.setVisibility(8);
            b13.setOnClickListener((View.OnClickListener) null);
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SwapPositionItem swapPositionItem = (SwapPositionItem) view.getTag(R$id.item_data1);
        int id2 = view.getId();
        if (id2 == R$id.contract_position_close_quick) {
            int intValue = ((Integer) view.getTag(R$id.item_data2)).intValue();
            if (swapPositionItem.c() != null) {
                swapPositionItem.c().e(1, swapPositionItem, intValue, view.getContext());
            }
        } else if (id2 == R$id.contract_position_close_tv) {
            int intValue2 = ((Integer) view.getTag(R$id.item_data2)).intValue();
            if (swapPositionItem.c() != null) {
                swapPositionItem.c().e(0, swapPositionItem, intValue2, view.getContext());
            }
        } else if (id2 == R$id.contract_position_share_iv) {
            if (swapPositionItem.c() != null) {
                swapPositionItem.c().b(swapPositionItem);
            }
        } else if (id2 == R$id.status_button_contract_item_stop_profit) {
            int intValue3 = ((Integer) view.getTag(R$id.item_data2)).intValue();
            if (swapPositionItem.c() != null) {
                swapPositionItem.c().e(2, swapPositionItem, intValue3, view.getContext());
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
