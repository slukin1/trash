package com.hbg.module.option.viewhandler;

import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.util.FuturePrecisionUtil;
import com.hbg.lib.data.future.util.FutureUnitUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.option.core.bean.OptionOrderInfo;
import com.hbg.module.option.R$color;
import com.hbg.module.option.R$id;
import com.hbg.module.option.R$layout;
import com.hbg.module.option.R$string;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Locale;
import s9.c;
import sf.a;

public class OptionCurrentOrderItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(a aVar, View view) {
        if (aVar.c() != null) {
            aVar.c().a(aVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        TextView textView;
        TextView textView2;
        String str;
        int i12;
        int i13;
        String str2;
        TextView textView3;
        String str3;
        v9.c cVar2 = cVar;
        r e11 = cVar.e();
        Context context = cVar2.itemView.getContext();
        Resources resources = cVar2.itemView.getResources();
        String i14 = StringUtils.i(aVar.getQuoteCurrency());
        TextView textView4 = (TextView) e11.b(R$id.id_option_current_order_item_title2);
        View b11 = e11.b(R$id.id_option_current_order_item_cancel);
        TextView textView5 = (TextView) e11.b(R$id.id_option_current_order_item_order_amount_title);
        TextView textView6 = (TextView) e11.b(R$id.id_option_current_order_item_order_amount);
        TextView textView7 = (TextView) e11.b(R$id.id_option_current_order_item_order_price_title);
        TextView textView8 = (TextView) e11.b(R$id.id_option_current_order_item_order_price);
        TextView textView9 = (TextView) e11.b(R$id.id_option_current_order_item_amount_title);
        TextView textView10 = (TextView) e11.b(R$id.id_option_current_order_item_amount);
        TextView textView11 = (TextView) e11.b(R$id.id_option_current_order_item_price_title);
        View view = b11;
        TextView textView12 = (TextView) e11.b(R$id.id_option_current_order_item_title);
        TextView textView13 = (TextView) e11.b(R$id.id_option_current_order_item_fee_title);
        TextView textView14 = (TextView) e11.b(R$id.id_option_current_order_item_frozen);
        TextView textView15 = (TextView) e11.b(R$id.id_option_current_order_item_fee);
        TextView textView16 = (TextView) e11.b(R$id.id_option_current_order_item_time);
        OptionOrderInfo d11 = aVar.d();
        TextView textView17 = (TextView) e11.b(R$id.id_option_current_order_item_frozen_title);
        String symbol = d11.getSymbol();
        TextView textView18 = (TextView) e11.b(R$id.id_option_current_order_item_price);
        String i15 = StringUtils.i(d11.getSymbol());
        TradeType tradeType = TradeType.OPTION;
        if (e.E(tradeType)) {
            textView = textView8;
            textView2 = textView10;
            str = d11.getSymbol();
        } else {
            textView2 = textView10;
            str = resources.getString(R$string.contract_market_vol_sheet);
            textView = textView8;
        }
        Locale locale = Locale.US;
        TextView textView19 = textView6;
        TradeType tradeType2 = tradeType;
        textView5.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_volume), new Object[]{str}));
        textView7.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_price), new Object[]{i14}));
        textView9.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_finish_volume), new Object[]{str}));
        textView11.setText(String.format(locale, resources.getString(R$string.contract_current_order_trade_price), new Object[]{i14}));
        textView13.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_fee), new Object[]{i14}));
        textView4.setText(e.z(symbol, d11.getOptionCode(), context, resources.getColor(R$color.baseColorPrimaryText)));
        textView16.setText(resources.getString(R$string.otc_order_detail_payed_order_time) + " " + DateTimeUtils.C(d11.getCreatedAt()));
        boolean E = e.E(tradeType2);
        TradeType tradeType3 = tradeType2;
        String a11 = FutureUnitUtil.a(d11.getVolume(), d11.getPrice(), d11.getContractFace(), tradeType3);
        if (E) {
            i12 = FuturePrecisionUtil.s(d11.getContractCode(), (String) null, d11.getOptionCode());
        } else {
            i12 = FuturePrecisionUtil.B();
        }
        textView19.setText(m.m(a11, i12));
        String str4 = "--";
        textView.setText(m.n(d11.getPrice(), FuturePrecisionUtil.y(d11.getContractCode(), (String) null, d11.getOptionCode()), str4));
        String price = d11.getPrice();
        if (E && m.a(d11.getTradeAvgPrice()).compareTo(BigDecimal.ZERO) > 0) {
            price = d11.getTradeAvgPrice();
        }
        String a12 = FutureUnitUtil.a(d11.getTradeVolume(), price, d11.getContractFace(), tradeType3);
        if (E) {
            i13 = FuturePrecisionUtil.s(d11.getContractCode(), (String) null, d11.getOptionCode());
        } else {
            i13 = FuturePrecisionUtil.B();
        }
        textView2.setText(m.m(a12, i13));
        textView18.setText(m.a(d11.getTradeAvgPrice()).compareTo(BigDecimal.ZERO) != 0 ? m.m(d11.getTradeAvgPrice(), FuturePrecisionUtil.y(d11.getContractCode(), (String) null, d11.getOptionCode())) : str4);
        int o11 = FuturePrecisionUtil.o(i14);
        int w11 = FuturePrecisionUtil.w(d11.getContractCode(), (String) null, d11.getOptionCode());
        if (d11.isBuy()) {
            str4 = m.m(d11.getFrozenPremium(), o11);
            str2 = String.format(locale, resources.getString(R$string.n_option_frozen_asset_buyer), new Object[]{i14});
        } else {
            String string = resources.getString(R$string.n_option_frozen_asset_seller);
            if (!d11.isOpen()) {
                str2 = string;
            } else if (d11.isRiseType()) {
                str4 = m.m(d11.getMarginFrozen(), w11);
                str2 = string + "(" + i15 + ")";
            } else {
                str4 = m.m(d11.getMarginFrozen(), o11);
                str2 = string + "(" + i14 + ")";
            }
        }
        textView17.setText(str2);
        textView14.setText(str4);
        textView15.setText(m.m(d11.getFee(), FuturePrecisionUtil.m("USDT")));
        if (d11.isBuy()) {
            textView3 = textView12;
            textView3.setTextColor(resources.getColor(w.h()));
        } else {
            textView3 = textView12;
            textView3.setTextColor(resources.getColor(w.d()));
        }
        if (d11.isOpen()) {
            if (d11.isBuy()) {
                str3 = resources.getString(R$string.n_contract_trade_open_more);
            } else {
                str3 = resources.getString(R$string.n_contract_trade_open_low);
            }
        } else if (d11.isDelivery()) {
            str3 = resources.getString(R$string.currency_detail_contract_status_force_delivry);
        } else if (d11.isBuy()) {
            str3 = resources.getString(R$string.n_contract_trade_close_low);
        } else {
            str3 = resources.getString(R$string.n_contract_trade_close_more);
        }
        textView3.setText(str3);
        view.setOnClickListener(new tf.a(aVar));
    }

    public int getResId() {
        return R$layout.layout_option_current_order_list_item;
    }
}
