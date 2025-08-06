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
import com.huobi.contract.entity.ContractCurrentTrackOrderItem;
import com.huobi.contract.entity.ContractTrackOrderInfo;
import com.huobi.contract.helper.ContractOrderHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ej.f;
import ej.g;
import i6.m;
import i6.r;
import java.util.Locale;
import s9.c;

public class ContractCurrentTrackOrderHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, ContractCurrentTrackOrderItem contractCurrentTrackOrderItem, ViewGroup viewGroup) {
        TextView textView;
        String str;
        int i12;
        TextView textView2;
        String str2;
        String str3;
        ContractCurrentTrackOrderItem contractCurrentTrackOrderItem2 = contractCurrentTrackOrderItem;
        if (contractCurrentTrackOrderItem2 != null) {
            ContractTrackOrderInfo e11 = contractCurrentTrackOrderItem.e();
            r e12 = cVar.e();
            Resources resources = cVar.itemView.getResources();
            TextView textView3 = (TextView) e12.b(R$id.item_contract_order_tv_title_type);
            TextView textView4 = (TextView) e12.b(R$id.item_contract_order_tv_title_symbol);
            TextView textView5 = (TextView) e12.b(R$id.item_contract_order_tv_title_date);
            TextView textView6 = (TextView) e12.b(R$id.item_contract_order_tv_title_cancel);
            TextView textView7 = (TextView) e12.b(R$id.item_contract_order_tv_order_volume);
            TextView textView8 = (TextView) e12.b(R$id.item_contract_order_tv_order_volume_title);
            TextView textView9 = (TextView) e12.b(R$id.item_contract_order_tv_order_trigger);
            TextView textView10 = (TextView) e12.b(R$id.item_contract_order_tv_order_trigger_title);
            TextView textView11 = (TextView) e12.b(R$id.item_contract_order_tv_call_back_rate);
            TextView textView12 = (TextView) e12.b(R$id.item_contract_order_tv_order_price);
            TextView textView13 = (TextView) e12.b(R$id.item_contract_order_tv_order_price_title);
            TextView textView14 = (TextView) e12.b(R$id.item_contract_order_tv_state);
            TradeType tradeType = TradeType.CONTRACT;
            if (e.E(tradeType)) {
                str = e11.getSymbol();
                textView = textView14;
            } else {
                textView = textView14;
                str = resources.getString(R$string.contract_market_vol_sheet);
            }
            Locale locale = Locale.US;
            TextView textView15 = textView11;
            TextView textView16 = textView9;
            TextView textView17 = textView3;
            textView8.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_volume), new Object[]{str}));
            textView10.setText(String.format(locale, resources.getString(R$string.n_contract_track_order_unit), new Object[]{"usd".toUpperCase(locale)}));
            textView13.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_price), new Object[]{"usd".toUpperCase(locale)}));
            textView6.setTag(contractCurrentTrackOrderItem2);
            textView6.setOnClickListener(this);
            textView4.setText(g.e(textView4.getContext(), e11.getSymbol(), e11.getContractCode(), e11.getContractType()));
            textView5.setText(String.format("%s %s", new Object[]{resources.getString(R$string.n_contract_order_time), DateTimeUtils.C(e11.getCreatedAt())}));
            String str4 = null;
            if (!TextUtils.isEmpty(e11.getOrderPriceType()) && e11.getOrderPriceType().contains("_")) {
                if ("formula_price".equalsIgnoreCase(e11.getOrderPriceType())) {
                    str4 = resources.getString(R$string.n_contract_theoretical_price);
                } else {
                    String[] split = e11.getOrderPriceType().split("_");
                    if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                        str4 = String.format(locale, resources.getString(R$string.contract_order_trigger_optimal), new Object[]{split[1]});
                    }
                }
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = m.n(e11.getOrderPrice(), f.p(e11.getContractCode()), "--");
            }
            textView12.setText(str4);
            boolean E = e.E(tradeType);
            String e13 = ContractOrderHelper.e(e11.getVolume(), e11.getActivePrice(), contractCurrentTrackOrderItem.d());
            if (E) {
                i12 = f.n(e11.getContractCode());
            } else {
                i12 = f.t(e11.getSymbol());
            }
            textView7.setText(m.m(e13, i12));
            if (contractCurrentTrackOrderItem.f()) {
                textView2 = textView17;
                textView2.setTextColor(resources.getColor(w.h()));
            } else {
                textView2 = textView17;
                textView2.setTextColor(resources.getColor(w.d()));
            }
            if (contractCurrentTrackOrderItem.i()) {
                if (contractCurrentTrackOrderItem.f()) {
                    str2 = resources.getString(R$string.n_contract_trade_open_more);
                } else {
                    str2 = resources.getString(R$string.n_contract_trade_open_low);
                }
            } else if (contractCurrentTrackOrderItem.g()) {
                str2 = resources.getString(R$string.currency_detail_contract_status_force_delivry);
            } else if (contractCurrentTrackOrderItem.h()) {
                str2 = resources.getString(R$string.currency_detail_contract_status_force_flat);
            } else if (contractCurrentTrackOrderItem.f()) {
                str2 = resources.getString(R$string.n_contract_trade_close_low);
            } else {
                str2 = resources.getString(R$string.n_contract_trade_close_more);
            }
            textView2.setText(e11.getLeverRate() + "X·" + str2);
            if ("ge".equalsIgnoreCase(e11.getActiveType())) {
                str3 = BaseApplication.c(R$string.string_flag_bigger_equals);
            } else {
                str3 = BaseApplication.c(R$string.string_flag_smaller_equals);
            }
            textView16.setText(String.format(locale, str3, new Object[]{m.m(e11.getActivePrice(), f.p(e11.getContractCode()))}));
            textView15.setText(m.Q(e11.getCallbackRate(), 1, 1));
            if (e11.getIsActive() == 1) {
                textView.setText(R$string.n_contract_track_order_state_order);
                return;
            }
            textView.setText(R$string.n_contract_track_order_state_active);
        }
    }

    public int getResId() {
        return R$layout.item_contract_current_track_order_list;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        ContractCurrentTrackOrderItem contractCurrentTrackOrderItem = (ContractCurrentTrackOrderItem) view.getTag();
        if (!(view.getId() != R$id.item_contract_order_tv_title_cancel || contractCurrentTrackOrderItem == null || contractCurrentTrackOrderItem.c() == null)) {
            contractCurrentTrackOrderItem.c().a(contractCurrentTrackOrderItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
