package com.hbg.module.linear.swap.viewhandler;

import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCurrentOrderInfo;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.module.contract.ContractModuleConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import s9.c;
import ye.a;
import ze.b;
import ze.d;

public class LinearSwapCurrentOrderItemHandler implements c {
    public static /* synthetic */ void h(a aVar, LinearSwapCurrentOrderInfo linearSwapCurrentOrderInfo, String str, String str2, Void voidR) {
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
        String str3 = aVar.g().getOrderId() + "";
        String contractCode = linearSwapCurrentOrderInfo.getContractCode();
        String orderPriceType = linearSwapCurrentOrderInfo.getOrderPriceType();
        String offset = linearSwapCurrentOrderInfo.getOffset();
        String buyOrSell = linearSwapCurrentOrderInfo.getBuyOrSell();
        ContractModuleConfig.a().i(fragmentActivity, str3, str, str2, contractCode, orderPriceType, offset, buyOrSell, linearSwapCurrentOrderInfo.getLeverRate() == null ? "0" : linearSwapCurrentOrderInfo.getLeverRate().toString(), aVar.f() + "");
    }

    public static /* synthetic */ void j(a aVar, HBDialogFragment hBDialogFragment) {
        if (aVar.c() != null) {
            aVar.c().b(aVar);
        }
        hBDialogFragment.dismiss();
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void k(LinearSwapCurrentOrderInfo linearSwapCurrentOrderInfo, a aVar, View view) {
        if (linearSwapCurrentOrderInfo.isGrid()) {
            DialogUtils.c0((FragmentActivity) oa.a.g().b(), view.getResources().getString(R$string.n_order_revoke_hint), "", view.getContext().getString(R$string.cancel_upgrade), view.getContext().getString(R$string.string_confirm), d.f62138a, new ze.c(aVar));
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (aVar.c() != null) {
            aVar.c().b(aVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void l(a aVar, View view) {
        if (aVar.c() != null) {
            aVar.c().a(aVar, view.getContext());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: g */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        String str;
        TextView textView;
        String str2;
        String str3;
        TextView textView2;
        TradeType tradeType;
        String str4;
        String str5;
        TextView textView3;
        String str6;
        View view;
        View view2;
        int i12;
        v9.c cVar2 = cVar;
        a aVar2 = aVar;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        Resources resources = cVar2.itemView.getResources();
        String i13 = StringUtils.i(aVar.getQuoteCurrency());
        String d11 = aVar.d();
        TextView textView4 = (TextView) e11.b(R$id.contract_position_some_id);
        TextView textView5 = (TextView) e11.b(R$id.id_current_order_contract_name);
        TextView textView6 = (TextView) e11.b(R$id.id_current_order_contract_sub_name);
        View b11 = e11.b(R$id.id_current_order_item_edit);
        View b12 = e11.b(R$id.id_option_current_order_item_cancel);
        View b13 = e11.b(R$id.split_line_cancel);
        TextView textView7 = (TextView) e11.b(R$id.id_option_current_order_item_order_amount_title);
        TextView textView8 = (TextView) e11.b(R$id.id_option_current_order_item_order_amount);
        TextView textView9 = (TextView) e11.b(R$id.id_option_current_order_item_order_price_title);
        View view3 = b11;
        View view4 = b12;
        TextView textView10 = (TextView) e11.b(R$id.id_option_current_order_item_amount_title);
        View view5 = b13;
        TextView textView11 = (TextView) e11.b(R$id.id_option_current_order_item_frozen);
        TextView textView12 = (TextView) e11.b(R$id.id_option_current_order_item_price_title);
        TextView textView13 = (TextView) e11.b(R$id.id_option_current_order_item_frozen_title);
        TextView textView14 = (TextView) e11.b(R$id.id_option_current_order_item_price);
        TextView textView15 = (TextView) e11.b(R$id.id_option_current_order_item_fee_title);
        TextView textView16 = (TextView) e11.b(R$id.id_option_current_order_item_fee);
        TextView textView17 = (TextView) e11.b(R$id.id_option_current_order_item_time);
        TextView textView18 = (TextView) e11.b(R$id.id_option_current_order_item_amount);
        LinearSwapCurrentOrderInfo g11 = aVar.g();
        TextView textView19 = (TextView) e11.b(R$id.item_contract_order_tv_title_stop);
        String symbol = g11.getSymbol();
        StringUtils.i(g11.getSymbol());
        TextView textView20 = (TextView) e11.b(R$id.id_option_current_order_item_order_price);
        TradeType tradeType2 = TradeType.LINEAR_SWAP;
        boolean E = e.E(tradeType2);
        boolean G = e.G(tradeType2);
        if (G) {
            textView = textView8;
            str = d11;
            str2 = "usdt".toUpperCase(Locale.US);
        } else {
            str = d11;
            textView = textView8;
            if (e.E(tradeType2)) {
                str2 = g11.getSymbol();
            } else {
                str2 = resources.getString(R$string.contract_market_vol_sheet);
            }
        }
        TradeType tradeType3 = tradeType2;
        TextView textView21 = textView17;
        textView7.setText(AppUtil.b(resources.getString(R$string.n_exchange_order_list_entrust_amount), "(", str2, ")"));
        TextView textView22 = textView6;
        textView9.setText(AppUtil.b(resources.getString(R$string.n_exchange_order_list_entrust_price), "(", i13, ")"));
        textView10.setText(AppUtil.b(resources.getString(R$string.n_exchange_order_detail_trade_amount), "(", str2, ")"));
        Locale locale = Locale.US;
        textView12.setText(String.format(locale, resources.getString(R$string.contract_current_order_trade_price), new Object[]{i13}));
        if (g11.isGrid()) {
            textView4.setVisibility(0);
        } else {
            textView4.setVisibility(8);
        }
        String str7 = e.u(context, symbol, i13, g11.getContractCode(), aVar.e()) + "·";
        if (aVar.f() == 2) {
            str3 = str7 + context.getString(R$string.n_contract_trade_margin);
        } else {
            str3 = str7 + context.getString(R$string.n_contract_super_margin);
        }
        textView5.setText(str3);
        String str8 = g11.getLeverRate() + "X " + e.C(context, g11.getOffset(), g11.isBuy(), g11.isDelivery());
        if (g11.isBuy()) {
            textView2 = textView22;
            textView2.setTextColor(ContextCompat.getColor(context, w.h()));
        } else {
            textView2 = textView22;
            textView2.setTextColor(ContextCompat.getColor(context, w.d()));
        }
        textView2.setText(str8);
        textView21.setText(resources.getString(R$string.otc_order_detail_payed_order_time) + " " + DateTimeUtils.C(g11.getCreateTime()));
        String plainString = m.a(g11.getVolume()).subtract(m.a(g11.getTradeVolume())).toPlainString();
        if (G) {
            tradeType = tradeType3;
            str5 = FutureUnitUtil.b(g11.getVolume(), g11.getPrice(), g11.getContractFace(), tradeType, FuturePrecisionUtil.g(symbol));
            str6 = FutureUnitUtil.b(plainString, g11.getPrice(), g11.getContractFace(), tradeType, FuturePrecisionUtil.g(symbol));
            textView3 = textView;
            str4 = str;
        } else {
            tradeType = tradeType3;
            str4 = str;
            str5 = m.m(FutureUnitUtil.a(g11.getVolume(), g11.getPrice(), g11.getContractFace(), tradeType), FuturePrecisionUtil.s(g11.getContractCode(), str4, (String) null));
            str6 = m.m(FutureUnitUtil.a(plainString, g11.getPrice(), g11.getContractFace(), tradeType), FuturePrecisionUtil.s(g11.getContractCode(), str4, (String) null));
            textView3 = textView;
        }
        textView3.setText(str5);
        String str9 = "--";
        String n11 = m.n(g11.getPrice(), FuturePrecisionUtil.y(g11.getContractCode(), str4, (String) null), str9);
        textView20.setText(n11);
        String price = g11.getPrice();
        if (E || (G && m.a(g11.getTradeAvgPrice()).compareTo(BigDecimal.ZERO) > 0)) {
            price = g11.getTradeAvgPrice();
        }
        if (G) {
            textView18.setText(FutureUnitUtil.b(g11.getTradeVolume(), price, g11.getContractFace(), tradeType, FuturePrecisionUtil.g(g11.getSymbol())));
        } else {
            TextView textView23 = textView18;
            String a11 = FutureUnitUtil.a(g11.getTradeVolume(), price, g11.getContractFace(), tradeType);
            if (E) {
                i12 = FuturePrecisionUtil.s(g11.getContractCode(), str4, (String) null);
            } else {
                i12 = FuturePrecisionUtil.B();
            }
            textView23.setText(m.m(a11, i12));
        }
        if (m.a(g11.getTradeAvgPrice()).compareTo(BigDecimal.ZERO) != 0) {
            str9 = m.m(g11.getTradeAvgPrice(), FuturePrecisionUtil.y(g11.getContractCode(), str4, (String) null));
        }
        textView14.setText(str9);
        int w11 = FuturePrecisionUtil.w(g11.getContractCode(), str4, (String) null);
        if (g11.isUseFeeOnly()) {
            textView15.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_fee), new Object[]{i13}));
            textView16.setText(m.m(g11.getFee(), FuturePrecisionUtil.u(g11.getContractCode(), str4, (String) null)));
        } else {
            textView15.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_fee), new Object[]{g11.getFeeUnit()}));
            textView16.setText(m.m(g11.getFeeAmount(), FuturePrecisionUtil.u(g11.getContractCode(), str4, (String) null)));
        }
        g11.isOpen();
        textView13.setText(resources.getString(R$string.n_bond) + "(" + i13 + ")");
        textView11.setText(m.m(g11.getMarginFrozen(), w11));
        if (g11.isHideCancelAndEdit()) {
            view5.setVisibility(4);
            view2 = view4;
            view2.setVisibility(4);
            view = view3;
            view.setVisibility(4);
        } else {
            view = view3;
            view2 = view4;
            view5.setVisibility(0);
            view2.setVisibility(0);
            view.setVisibility(0);
        }
        a aVar3 = aVar;
        dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new ze.e(aVar3, g11, n11, str6));
        view2.setOnClickListener(new ze.a(g11, aVar3));
        TextView textView24 = textView19;
        ViewUtil.m(textView24, g11.isTpsl());
        textView24.setOnClickListener(new b(aVar3));
    }

    public int getResId() {
        return R$layout.layout_linear_swap_current_order_list_item;
    }
}
