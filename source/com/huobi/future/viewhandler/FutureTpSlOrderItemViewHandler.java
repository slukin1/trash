package com.huobi.future.viewhandler;

import a7.e;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.contract.R$drawable;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.data.future.bean.FutureTpSlOrder;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureTypeUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTriggerOrderInfo;
import com.huobi.future.bean.FutureTpSlOrderDialogItem;
import ej.f;
import i6.m;
import i6.r;
import il.a;
import java.util.Locale;
import s9.c;
import us.i;

public class FutureTpSlOrderItemViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, FutureTpSlOrderDialogItem futureTpSlOrderDialogItem, ViewGroup viewGroup) {
        int i12;
        int i13;
        TextView textView;
        String str;
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        FutureTpSlOrder e12 = futureTpSlOrderDialogItem.e();
        TextView textView2 = (TextView) e11.b(R$id.trigger_price_tv);
        TextView textView3 = (TextView) e11.b(R$id.price_value_tv);
        TextView textView4 = (TextView) e11.b(R$id.trigger_time_label_tv);
        TextView textView5 = (TextView) e11.b(R$id.trigger_time_value_tv);
        TextView textView6 = (TextView) e11.b(R$id.amount_value_tv);
        TextView textView7 = (TextView) e11.b(R$id.trigger_status_tv);
        ((TextView) e11.b(R$id.order_title)).setText(a.a(e12.getTpSlOrderType(), e12.getDirection(), context));
        TradeType a11 = FutureTypeUtil.a(e12.getContractCode(), futureTpSlOrderDialogItem.d(), (String) null);
        if (TradeType.isContract(a11)) {
            i13 = f.p(e12.getContractCode());
            i12 = f.n(e12.getContractCode());
        } else if (TradeType.isSwap(a11)) {
            i13 = i.m(e12.getSymbol());
            i12 = i.k(e12.getSymbol());
        } else if (TradeType.isLinearSwap(a11)) {
            i13 = FuturePrecisionUtil.y(e12.getContractCode(), futureTpSlOrderDialogItem.d(), (String) null);
            i12 = FuturePrecisionUtil.s(e12.getContractCode(), futureTpSlOrderDialogItem.d(), (String) null);
        } else {
            i13 = 0;
            i12 = 0;
        }
        String m11 = m.m(e12.getTriggerPrice(), i13);
        if ("le".equals(e12.getTriggerType())) {
            textView = textView7;
            textView2.setText(String.format(Locale.ENGLISH, context.getString(R$string.n_contract_tp_sl_trigger_less_than), new Object[]{m11}));
        } else {
            textView = textView7;
            if (LinearSwapTriggerOrderInfo.LE_MARK.equals(e12.getTriggerType())) {
                textView2.setText(String.format(Locale.ENGLISH, context.getString(R$string.n_contract_tp_sl_trigger_less_than), new Object[]{m11}));
            } else {
                textView2.setText(String.format(Locale.ENGLISH, context.getString(R$string.n_contract_tp_sl_trigger_greater_than), new Object[]{m11}));
            }
        }
        int orderPriceType = e12.getOrderPriceType();
        if (orderPriceType == 2) {
            textView3.setText(R$string.n_exchange_order_list_market);
        } else if (orderPriceType == 7) {
            textView3.setText(R$string.contract_trade_optimal_five);
        } else if (orderPriceType == 8) {
            textView3.setText(R$string.contract_trade_optimal_ten);
        } else if (orderPriceType != 9) {
            textView3.setText(m.m(e12.getOrderPrice(), i13) + " " + futureTpSlOrderDialogItem.f());
        } else {
            textView3.setText(R$string.contract_trade_optimal_twenty);
        }
        textView5.setText(DateTimeUtils.C(e12.getCreatedAt()));
        boolean E = e.E(a11);
        boolean G = e.G(a11);
        if (e12.getOrderPriceType() == 1) {
            str = e12.getOrderPrice();
        } else {
            str = e12.getTriggerPrice();
        }
        if (E) {
            textView6.setText(m.m(FutureUnitUtil.a(String.valueOf(e12.getVolume()), str, futureTpSlOrderDialogItem.c(), a11), i12) + " " + e12.getSymbol());
        } else if (G) {
            textView6.setText(FutureUnitUtil.b(String.valueOf(e12.getVolume()), str, futureTpSlOrderDialogItem.c(), a11, FuturePrecisionUtil.g(e12.getSymbol())) + " " + "usdt".toUpperCase(Locale.US));
        } else {
            textView6.setText(m.m(FutureUnitUtil.a(String.valueOf(e12.getVolume()), str, futureTpSlOrderDialogItem.c(), a11), FuturePrecisionUtil.B()) + " " + context.getString(R$string.contract_market_vol_sheet));
        }
        int status = e12.getStatus();
        if (status == 1) {
            TextView textView8 = textView;
            textView8.setText(R$string.n_contract_tp_sl_not_take_effect);
            textView8.setCompoundDrawablesRelativeWithIntrinsicBounds(R$drawable.future_tp_sl_un_trigger, 0, 0, 0);
            textView4.setVisibility(8);
            textView5.setVisibility(8);
        } else if (status == 2) {
            TextView textView9 = textView;
            textView9.setText(R$string.n_contract_tp_sl_waiting_for_delegation);
            textView9.setCompoundDrawablesRelativeWithIntrinsicBounds(R$drawable.future_tp_sl_un_trigger, 0, 0, 0);
            textView4.setVisibility(8);
            textView5.setVisibility(8);
        } else if (status == 4) {
            TextView textView10 = textView;
            textView10.setText(R$string.n_exchange_order_triggered);
            textView10.setCompoundDrawablesRelativeWithIntrinsicBounds(R$drawable.n_exchange_order_submit, 0, 0, 0);
            textView4.setVisibility(0);
            textView5.setVisibility(0);
        } else if (status == 5) {
            TextView textView11 = textView;
            textView11.setText(R$string.n_exchange_order_rejected);
            textView11.setCompoundDrawablesRelativeWithIntrinsicBounds(R$drawable.future_tp_sl_un_trigger, 0, 0, 0);
            textView4.setVisibility(0);
            textView5.setVisibility(0);
        } else if (status == 6) {
            TextView textView12 = textView;
            textView12.setText(R$string.n_exchange_order_canceled);
            textView12.setCompoundDrawablesRelativeWithIntrinsicBounds(R$drawable.future_tp_sl_un_trigger, 0, 0, 0);
            textView4.setVisibility(8);
            textView5.setVisibility(8);
        } else if (status != 11) {
            textView4.setVisibility(8);
            textView5.setVisibility(8);
        } else {
            TextView textView13 = textView;
            textView13.setText(R$string.n_contract_tp_sl_invalid);
            textView13.setCompoundDrawablesRelativeWithIntrinsicBounds(R$drawable.future_tp_sl_un_trigger, 0, 0, 0);
            textView4.setVisibility(8);
            textView5.setVisibility(8);
        }
    }

    public int getResId() {
        return R$layout.item_dialog_future_tp_sl_order;
    }
}
