package com.huobi.contract.viewhandler;

import a7.e;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTriggerOrderInfo;
import com.huobi.contract.entity.ContractTriggerOrderRspInfo;
import com.huobi.contract.helper.ContractOrderHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dw.a;
import ej.f;
import ej.g;
import fj.m;
import fj.n;
import i6.r;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import s9.c;

public class ContractStopOrderListItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void e(aj.c cVar, View view) {
        if (cVar.c() != null) {
            cVar.c().c(cVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void f(aj.c cVar, LinearLayout linearLayout, Void voidR) {
        if (cVar.c() != null) {
            cVar.c().b(cVar, linearLayout.getContext());
        }
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, aj.c cVar2, ViewGroup viewGroup) {
        String str;
        TextView textView;
        String str2;
        String str3;
        int i12;
        String str4;
        aj.c cVar3 = cVar2;
        if (cVar3 != null) {
            ContractTriggerOrderRspInfo e11 = cVar2.e();
            r e12 = cVar.e();
            Resources resources = cVar.itemView.getResources();
            TextView textView2 = (TextView) e12.b(R$id.item_contract_order_tv_title_type);
            TextView textView3 = (TextView) e12.b(R$id.item_contract_order_tv_title_symbol);
            TextView textView4 = (TextView) e12.b(R$id.item_contract_order_tv_title_date);
            TextView textView5 = (TextView) e12.b(R$id.item_contract_order_tv_title_cancel);
            TextView textView6 = (TextView) e12.b(R$id.item_contract_order_tv_order_volume);
            TextView textView7 = (TextView) e12.b(R$id.item_contract_order_tv_order_volume_title);
            TextView textView8 = (TextView) e12.b(R$id.item_contract_order_tv_order_trigger);
            TextView textView9 = (TextView) e12.b(R$id.item_contract_order_tv_order_trigger_title);
            TextView textView10 = (TextView) e12.b(R$id.item_contract_order_tv_order_price);
            TextView textView11 = (TextView) e12.b(R$id.item_contract_order_tv_order_price_title);
            e12.b(R$id.item_contract_order_data_ll);
            TradeType tradeType = TradeType.CONTRACT;
            if (e.E(tradeType)) {
                str = e11.getSymbol();
            } else {
                str = resources.getString(R$string.contract_market_vol_sheet);
            }
            r rVar = e12;
            Locale locale = Locale.US;
            TextView textView12 = textView8;
            TextView textView13 = textView2;
            TradeType tradeType2 = tradeType;
            textView7.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_volume), new Object[]{str}));
            textView9.setText(String.format(locale, resources.getString(R$string.trade_trend_trigger_price_unit), new Object[]{"usd".toUpperCase(locale)}));
            textView11.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_price), new Object[]{"usd".toUpperCase(locale)}));
            textView5.setTag(e11);
            textView5.setOnClickListener(new m(cVar3));
            textView3.setText(g.e(textView3.getContext(), e11.getSymbol(), e11.getContractCode(), e11.getContractType()));
            textView4.setText(String.format("%s %s", new Object[]{resources.getString(R$string.n_contract_order_time), DateTimeUtils.C(e11.getCreatedAt())}));
            String str5 = "--";
            if (TextUtils.equals(e11.getOrderPriceType(), "tpsl_position_trigger")) {
                textView10.setText(resources.getString(R$string.n_copy_trading_market_price));
                textView6.setText(resources.getString(R$string.n_contract_all_position));
            } else {
                String str6 = null;
                if (!TextUtils.isEmpty(e11.getOrderPriceType()) && e11.getOrderPriceType().contains("_")) {
                    String[] split = e11.getOrderPriceType().split("_");
                    if (split.length <= 1 || TextUtils.isEmpty(split[1])) {
                        str4 = null;
                    } else {
                        str4 = String.format(locale, resources.getString(R$string.contract_order_trigger_optimal), new Object[]{split[1]});
                        str6 = e11.getTriggerPrice();
                    }
                    String str7 = str6;
                    str6 = str4;
                    str3 = str7;
                } else if (TextUtils.equals(e11.getOrderPriceType(), PrimeRounds.ROUND_TRADE_MARKET_TYPE)) {
                    str6 = resources.getString(R$string.n_exchange_order_list_market);
                    str3 = e11.getTriggerPrice();
                } else {
                    str3 = null;
                }
                if (TextUtils.isEmpty(str6)) {
                    str6 = i6.m.n(e11.getOrderPrice(), f.p(e11.getContractCode()), str5);
                    str3 = e11.getOrderPrice();
                }
                textView10.setText(str6);
                boolean E = e.E(tradeType2);
                String e13 = ContractOrderHelper.e(e11.getVolume(), str3, cVar2.d());
                if (E) {
                    i12 = f.n(e11.getContractCode());
                } else {
                    i12 = f.t(e11.getSymbol());
                }
                textView6.setText(i6.m.m(e13, i12));
            }
            if (cVar2.f()) {
                textView = textView13;
                textView.setTextColor(resources.getColor(w.h()));
            } else {
                textView = textView13;
                textView.setTextColor(resources.getColor(w.d()));
            }
            if (cVar2.i()) {
                if (cVar2.f()) {
                    str2 = resources.getString(R$string.n_contract_trade_open_more);
                } else {
                    str2 = resources.getString(R$string.n_contract_trade_open_low);
                }
            } else if (cVar2.g()) {
                str2 = resources.getString(R$string.currency_detail_contract_status_force_delivry);
            } else if (cVar2.h()) {
                str2 = resources.getString(R$string.currency_detail_contract_status_force_flat);
            } else if (cVar2.f()) {
                str2 = resources.getString(R$string.n_contract_trade_close_low);
            } else {
                str2 = resources.getString(R$string.n_contract_trade_close_more);
            }
            textView.setText(e11.getLeverRate() + "X·" + str2);
            if ("ge".equalsIgnoreCase(e11.getTriggerType())) {
                str5 = resources.getString(R$string.n_contract_latest_price) + resources.getString(R$string.string_flag_bigger_equals);
            } else if ("le".equalsIgnoreCase(e11.getTriggerType())) {
                str5 = resources.getString(R$string.n_contract_latest_price) + resources.getString(R$string.string_flag_smaller_equals);
            } else if (LinearSwapTriggerOrderInfo.GE_MARK.equalsIgnoreCase(e11.getTriggerType())) {
                str5 = resources.getString(R$string.n_contract_mark_price) + resources.getString(R$string.string_flag_bigger_equals);
            } else if (LinearSwapTriggerOrderInfo.LE_MARK.equalsIgnoreCase(e11.getTriggerType())) {
                str5 = resources.getString(R$string.n_contract_mark_price) + resources.getString(R$string.string_flag_smaller_equals);
            }
            textView12.setText(String.format(locale, str5, new Object[]{i6.m.m(e11.getTriggerPrice(), f.p(e11.getContractCode()))}));
            r rVar2 = rVar;
            LinearLayout linearLayout = (LinearLayout) rVar2.b(R$id.id_ll_edit);
            TextView textView14 = (TextView) rVar2.b(R$id.item_contract_order_tv_sltp);
            if ("sl".equals(e11.getTpslOrderType())) {
                textView14.setText(R$string.n_contract_stop_loss);
                textView14.setVisibility(0);
                linearLayout.setVisibility(0);
            } else if ("tp".equals(e11.getTpslOrderType())) {
                textView14.setText(R$string.n_contract_take_profit);
                textView14.setVisibility(0);
                linearLayout.setVisibility(0);
            } else {
                textView14.setVisibility(4);
                linearLayout.setVisibility(8);
            }
            a.a(linearLayout).throttleFirst(1, TimeUnit.SECONDS).subscribe(new n(cVar3, linearLayout));
        }
    }

    public int getResId() {
        return R$layout.item_contract_current_trigger_order_list;
    }
}
