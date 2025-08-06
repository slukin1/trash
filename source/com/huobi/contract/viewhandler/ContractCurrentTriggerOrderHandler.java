package com.huobi.contract.viewhandler;

import a7.e;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTriggerOrderInfo;
import com.huobi.contract.entity.ContractCurrentTriggerOrderInfo;
import com.huobi.contract.helper.ContractOrderHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ej.f;
import ej.g;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Locale;
import s9.c;

public class ContractCurrentTriggerOrderHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, ContractCurrentTriggerOrderInfo contractCurrentTriggerOrderInfo, ViewGroup viewGroup) {
        String str;
        TextView textView;
        String str2;
        String c11;
        String str3;
        int i12;
        ContractCurrentTriggerOrderInfo contractCurrentTriggerOrderInfo2 = contractCurrentTriggerOrderInfo;
        if (contractCurrentTriggerOrderInfo2 != null) {
            r e11 = cVar.e();
            Resources resources = cVar.itemView.getResources();
            TextView textView2 = (TextView) e11.b(R$id.item_contract_order_tv_title_type);
            TextView textView3 = (TextView) e11.b(R$id.item_contract_order_tv_title_symbol);
            TextView textView4 = (TextView) e11.b(R$id.item_contract_order_tv_title_date);
            TextView textView5 = (TextView) e11.b(R$id.item_contract_order_tv_title_cancel);
            TextView textView6 = (TextView) e11.b(R$id.item_contract_order_tv_order_volume);
            TextView textView7 = (TextView) e11.b(R$id.item_contract_order_tv_order_volume_title);
            TextView textView8 = (TextView) e11.b(R$id.item_contract_order_tv_order_trigger);
            TextView textView9 = (TextView) e11.b(R$id.item_contract_order_tv_order_trigger_title);
            TextView textView10 = (TextView) e11.b(R$id.item_contract_order_tv_order_price);
            TextView textView11 = (TextView) e11.b(R$id.item_contract_order_tv_order_price_title);
            e11.b(R$id.item_contract_order_data_ll);
            TradeType tradeType = TradeType.CONTRACT;
            if (e.E(tradeType)) {
                str = contractCurrentTriggerOrderInfo.getSymbol();
            } else {
                str = resources.getString(R$string.contract_market_vol_sheet);
            }
            Locale locale = Locale.US;
            r rVar = e11;
            TextView textView12 = textView8;
            TextView textView13 = textView2;
            textView7.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_volume), new Object[]{str}));
            textView9.setText(String.format(locale, resources.getString(R$string.trade_trend_trigger_price_unit), new Object[]{"usd".toUpperCase(locale)}));
            textView11.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_price), new Object[]{"usd".toUpperCase(locale)}));
            textView5.setTag(contractCurrentTriggerOrderInfo2);
            textView5.setOnClickListener(this);
            textView3.setText(g.e(textView3.getContext(), contractCurrentTriggerOrderInfo.getSymbol(), contractCurrentTriggerOrderInfo.getContractCode(), contractCurrentTriggerOrderInfo.getContractType()));
            textView4.setText(String.format("%s %s", new Object[]{resources.getString(R$string.n_contract_order_time), DateTimeUtils.C(contractCurrentTriggerOrderInfo.getCreatedAt())}));
            if (TextUtils.equals(contractCurrentTriggerOrderInfo.getOrderPriceType(), "tpsl_position_trigger")) {
                textView10.setText(resources.getString(R$string.n_copy_trading_market_price));
                textView6.setText(resources.getString(R$string.n_contract_all_position));
            } else {
                if (m.a(contractCurrentTriggerOrderInfo.getOrderPrice()).compareTo(BigDecimal.ZERO) == 0) {
                    str3 = contractCurrentTriggerOrderInfo.getTriggerPrice();
                } else {
                    str3 = contractCurrentTriggerOrderInfo.getOrderPrice();
                }
                String str4 = null;
                if (!TextUtils.isEmpty(contractCurrentTriggerOrderInfo.getOrderPriceType()) && contractCurrentTriggerOrderInfo.getOrderPriceType().contains("_")) {
                    String[] split = contractCurrentTriggerOrderInfo.getOrderPriceType().split("_");
                    if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                        str4 = String.format(locale, resources.getString(R$string.contract_order_trigger_optimal), new Object[]{split[1]});
                    }
                } else if (TextUtils.equals(contractCurrentTriggerOrderInfo.getOrderPriceType(), PrimeRounds.ROUND_TRADE_MARKET_TYPE)) {
                    str4 = resources.getString(R$string.n_exchange_order_list_market);
                }
                if (TextUtils.isEmpty(str4)) {
                    str4 = m.n(contractCurrentTriggerOrderInfo.getOrderPrice(), f.p(contractCurrentTriggerOrderInfo.getContractCode()), "--");
                }
                textView10.setText(str4);
                boolean E = e.E(tradeType);
                String e12 = ContractOrderHelper.e(contractCurrentTriggerOrderInfo.getVolume(), str3, contractCurrentTriggerOrderInfo.getContractFace());
                if (E) {
                    i12 = f.n(contractCurrentTriggerOrderInfo.getContractCode());
                } else {
                    i12 = f.t(contractCurrentTriggerOrderInfo.getSymbol());
                }
                textView6.setText(m.m(e12, i12));
            }
            if (contractCurrentTriggerOrderInfo.isBuy()) {
                textView = textView13;
                textView.setTextColor(resources.getColor(w.h()));
            } else {
                textView = textView13;
                textView.setTextColor(resources.getColor(w.d()));
            }
            if (contractCurrentTriggerOrderInfo.isOpen()) {
                if (contractCurrentTriggerOrderInfo.isBuy()) {
                    str2 = resources.getString(R$string.contract_trade_open_more);
                } else {
                    str2 = resources.getString(R$string.n_contract_trade_open_low);
                }
            } else if (contractCurrentTriggerOrderInfo.isDelivery()) {
                str2 = resources.getString(R$string.currency_detail_contract_status_force_delivry);
            } else if (contractCurrentTriggerOrderInfo.isExplose()) {
                str2 = resources.getString(R$string.currency_detail_contract_status_force_flat);
            } else if (contractCurrentTriggerOrderInfo.isBuy()) {
                str2 = resources.getString(R$string.n_contract_trade_close_low);
            } else {
                str2 = resources.getString(R$string.n_contract_trade_close_more);
            }
            textView.setText(contractCurrentTriggerOrderInfo.getLeverRate() + "X·" + str2);
            if ("ge".equalsIgnoreCase(contractCurrentTriggerOrderInfo.getTriggerType())) {
                c11 = BaseApplication.c(R$string.string_flag_bigger_equals);
            } else if (LinearSwapTriggerOrderInfo.GE_MARK.equalsIgnoreCase(contractCurrentTriggerOrderInfo.getTriggerType())) {
                c11 = BaseApplication.c(R$string.string_flag_bigger_equals);
            } else {
                c11 = BaseApplication.c(R$string.string_flag_smaller_equals);
            }
            textView12.setText(String.format(locale, c11, new Object[]{m.m(contractCurrentTriggerOrderInfo.getTriggerPrice(), f.p(contractCurrentTriggerOrderInfo.getContractCode()))}));
            TextView textView14 = (TextView) rVar.b(R$id.item_contract_order_tv_sltp);
            if ("sl".equals(contractCurrentTriggerOrderInfo.getTpslOrderType())) {
                textView14.setText(R$string.n_contract_stop_loss);
                textView14.setVisibility(0);
            } else if ("tp".equals(contractCurrentTriggerOrderInfo.getTpslOrderType())) {
                textView14.setText(R$string.n_contract_take_profit);
                textView14.setVisibility(0);
            } else {
                textView14.setVisibility(4);
            }
        }
    }

    public int getResId() {
        return R$layout.item_contract_current_trigger_order_list;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        ContractCurrentTriggerOrderInfo contractCurrentTriggerOrderInfo = (ContractCurrentTriggerOrderInfo) view.getTag();
        if (!(view.getId() != R$id.item_contract_order_tv_title_cancel || contractCurrentTriggerOrderInfo == null || contractCurrentTriggerOrderInfo.getCallback() == null)) {
            contractCurrentTriggerOrderInfo.getCallback().a(contractCurrentTriggerOrderInfo);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
