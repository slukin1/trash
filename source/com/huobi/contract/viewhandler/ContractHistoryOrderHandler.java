package com.huobi.contract.viewhandler;

import a7.e;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.contract.R$drawable;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.contract.ContractModuleConfig;
import com.huobi.contract.entity.ContractHistoryOrderInfo;
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

public class ContractHistoryOrderHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, ContractHistoryOrderInfo contractHistoryOrderInfo, ViewGroup viewGroup) {
        TradeType tradeType;
        String str;
        TextView textView;
        TextView textView2;
        int i12;
        char c11;
        boolean z11;
        int i13;
        ImageView imageView;
        int i14;
        int i15;
        TextView textView3;
        String str2;
        int i16;
        String str3;
        v9.c cVar2 = cVar;
        if (contractHistoryOrderInfo != null) {
            r e11 = cVar.e();
            Resources resources = cVar2.itemView.getResources();
            TextView textView4 = (TextView) e11.b(R$id.item_contract_order_tv_title_symbol);
            LinearLayout linearLayout = (LinearLayout) e11.b(R$id.item_contract_order_tv_title_date_ll);
            TextView textView5 = (TextView) e11.b(R$id.item_contract_order_tv_title_date);
            ImageView imageView2 = (ImageView) e11.b(R$id.item_contract_order_tv_title_date_risk);
            TextView textView6 = (TextView) e11.b(R$id.item_contract_order_tv_order_volume_title);
            TextView textView7 = (TextView) e11.b(R$id.item_contract_order_tv_order_price_title);
            TextView textView8 = (TextView) e11.b(R$id.item_contract_order_tv_title_status);
            TextView textView9 = (TextView) e11.b(R$id.item_contract_order_tv_order_money_title);
            TextView textView10 = (TextView) e11.b(R$id.item_contract_order_tv_title_type);
            TextView textView11 = (TextView) e11.b(R$id.item_contract_order_tv_trade_volume);
            TextView textView12 = (TextView) e11.b(R$id.item_contract_order_tv_trade_volume_title);
            TextView textView13 = (TextView) e11.b(R$id.item_contract_order_tv_order_money);
            TextView textView14 = (TextView) e11.b(R$id.item_contract_order_tv_trade_price);
            TextView textView15 = (TextView) e11.b(R$id.item_contract_order_tv_trade_price_title);
            TextView textView16 = (TextView) e11.b(R$id.item_contract_order_tv_order_price);
            TextView textView17 = (TextView) e11.b(R$id.item_contract_order_tv_trade_fee);
            TextView textView18 = (TextView) e11.b(R$id.item_contract_order_tv_trade_fee_title);
            TextView textView19 = (TextView) e11.b(R$id.item_contract_order_tv_order_volume);
            View b11 = e11.b(R$id.bottom_ll);
            TradeType tradeType2 = TradeType.CONTRACT;
            if (e.E(tradeType2)) {
                tradeType = tradeType2;
                str = contractHistoryOrderInfo.getSymbol();
            } else {
                tradeType = tradeType2;
                str = resources.getString(R$string.contract_market_vol_sheet);
            }
            ImageView imageView3 = imageView2;
            LinearLayout linearLayout2 = linearLayout;
            if (contractHistoryOrderInfo.isLiquidationExplose()) {
                Locale locale = Locale.US;
                textView2 = textView5;
                textView = textView4;
                c11 = 0;
                textView6.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_force_liquidation_amount), new Object[]{str}));
                i12 = 1;
                textView7.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_force_liquidation_price), new Object[]{"usd".toUpperCase(locale)}));
                b11.setVisibility(8);
            } else {
                textView = textView4;
                textView2 = textView5;
                c11 = 0;
                i12 = 1;
                Locale locale2 = Locale.US;
                textView6.setText(String.format(locale2, resources.getString(R$string.contract_entrust_order_volume), new Object[]{str}));
                textView7.setText(String.format(locale2, resources.getString(R$string.contract_entrust_order_price), new Object[]{"usd".toUpperCase(locale2)}));
                b11.setVisibility(0);
            }
            Locale locale3 = Locale.US;
            String string = resources.getString(R$string.contract_entrust_order_get_money);
            Object[] objArr = new Object[i12];
            objArr[c11] = contractHistoryOrderInfo.getSymbol();
            textView9.setText(String.format(locale3, string, objArr));
            String string2 = resources.getString(R$string.contract_entrust_order_finish_volume);
            Object[] objArr2 = new Object[i12];
            objArr2[c11] = str;
            textView12.setText(String.format(locale3, string2, objArr2));
            String string3 = resources.getString(R$string.contract_current_order_trade_price);
            Object[] objArr3 = new Object[i12];
            objArr3[c11] = "usd".toUpperCase(locale3);
            textView15.setText(String.format(locale3, string3, objArr3));
            String string4 = resources.getString(R$string.contract_entrust_order_fee);
            Object[] objArr4 = new Object[i12];
            objArr4[c11] = contractHistoryOrderInfo.getSymbol();
            textView18.setText(String.format(locale3, string4, objArr4));
            ContractHistoryOrderInfo contractHistoryOrderInfo2 = contractHistoryOrderInfo;
            cVar2.itemView.setTag(contractHistoryOrderInfo2);
            View view = cVar2.itemView;
            view.setOnClickListener(this);
            textView.setText(g.e(textView.getContext(), contractHistoryOrderInfo.getSymbol(), contractHistoryOrderInfo.getContractCode(), contractHistoryOrderInfo.getContractType()));
            if (contractHistoryOrderInfo.isQuestionExplose()) {
                z11 = true;
                textView2.setText(String.format("%s %s", new Object[]{resources.getString(R$string.n_contract_strong_flat_time), DateTimeUtils.C(contractHistoryOrderInfo.getCreateDate().longValue())}));
            } else {
                z11 = true;
                textView2.setText(String.format("%s %s", new Object[]{resources.getString(R$string.n_contract_order_time), DateTimeUtils.C(contractHistoryOrderInfo.getCreateDate().longValue())}));
            }
            LinearLayout linearLayout3 = linearLayout2;
            linearLayout3.setOnClickListener(this);
            linearLayout3.setTag(contractHistoryOrderInfo2);
            if (contractHistoryOrderInfo.isQuestionExplose()) {
                imageView = imageView3;
                i13 = 0;
            } else {
                imageView = imageView3;
                i13 = 8;
            }
            imageView.setVisibility(i13);
            boolean E = e.E(tradeType);
            String e12 = ContractOrderHelper.e(contractHistoryOrderInfo.getVolume(), contractHistoryOrderInfo.getPrice(), contractHistoryOrderInfo.getContractFace());
            if (E) {
                i14 = f.o(contractHistoryOrderInfo.getSymbol());
            } else {
                i14 = f.t(contractHistoryOrderInfo.getSymbol());
            }
            textView19.setText(m.m(e12, i14));
            textView16.setText(m.n(contractHistoryOrderInfo.getPrice(), f.r(contractHistoryOrderInfo.getSymbol()), "--"));
            textView13.setText(m.m(contractHistoryOrderInfo.getProfit(), f.o(contractHistoryOrderInfo.getSymbol())));
            String price = contractHistoryOrderInfo.getPrice();
            if (E && m.a(contractHistoryOrderInfo.getTradeAvgPrice()).compareTo(BigDecimal.ZERO) > 0) {
                price = contractHistoryOrderInfo.getTradeAvgPrice();
            }
            String e13 = ContractOrderHelper.e(contractHistoryOrderInfo.getTradeVolume(), price, contractHistoryOrderInfo.getContractFace());
            if (E) {
                i15 = f.o(contractHistoryOrderInfo.getSymbol());
            } else {
                i15 = f.c(contractHistoryOrderInfo.getSymbol());
            }
            textView11.setText(m.m(e13, i15));
            textView14.setText(m.n(contractHistoryOrderInfo.getTradeAvgPrice(), f.r(contractHistoryOrderInfo.getSymbol()), "--"));
            textView17.setText(m.u(contractHistoryOrderInfo.getFee(), f.m(contractHistoryOrderInfo.getSymbol())));
            if (contractHistoryOrderInfo.isBuy()) {
                textView3 = textView10;
                textView3.setTextColor(resources.getColor(w.h()));
            } else {
                textView3 = textView10;
                textView3.setTextColor(resources.getColor(w.d()));
            }
            if (contractHistoryOrderInfo.isOpen()) {
                if (contractHistoryOrderInfo.isBuy()) {
                    str2 = resources.getString(R$string.contract_trade_open_more);
                } else {
                    str2 = resources.getString(R$string.contract_trade_open_low);
                }
            } else if (contractHistoryOrderInfo.isDelivery()) {
                str2 = resources.getString(R$string.currency_detail_contract_status_force_delivry);
            } else if (contractHistoryOrderInfo.isExplose()) {
                str2 = resources.getString(R$string.currency_detail_contract_status_force_flat);
            } else if (contractHistoryOrderInfo.isBuy()) {
                str2 = resources.getString(R$string.contract_trade_close_low);
            } else {
                str2 = resources.getString(R$string.contract_trade_close_more);
            }
            textView3.setText(str2 + "·" + contractHistoryOrderInfo.getLeverRate() + "X");
            int status = contractHistoryOrderInfo.getStatus();
            if (status == 4 || status == 5) {
                str3 = resources.getString(R$string.contract_order_part_finished);
                i16 = R$drawable.lite_form_right_arrow;
            } else if (status == 6) {
                str3 = resources.getString(R$string.contract_order_finished);
                i16 = R$drawable.lite_form_right_arrow;
            } else if (status != 7) {
                str3 = "";
                i16 = 0;
            } else {
                str3 = resources.getString(R$string.contract_order_canceled);
                i16 = R$drawable.lite_form_right_arrow;
            }
            if (contractHistoryOrderInfo.isExplose()) {
                i16 = "4".equalsIgnoreCase(contractHistoryOrderInfo.getLiquidationType()) ? R$drawable.lite_form_right_arrow : 0;
            }
            if (contractHistoryOrderInfo.isDelivery()) {
                i16 = 0;
            }
            if (i16 == 0) {
                z11 = false;
            }
            contractHistoryOrderInfo2.setHasDetail(z11);
            TextView textView20 = textView8;
            textView20.setCompoundDrawablesWithIntrinsicBounds(0, 0, i16, 0);
            textView20.setText(str3);
        }
    }

    public int getResId() {
        return R$layout.item_contract_history_order_list;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        ContractHistoryOrderInfo contractHistoryOrderInfo = (ContractHistoryOrderInfo) view.getTag();
        if (view.getId() == R$id.item_contract_order_tv_title_date_ll) {
            if (contractHistoryOrderInfo.isQuestionExplose()) {
                ContractModuleConfig.a().f((FragmentActivity) view.getContext(), contractHistoryOrderInfo);
            }
        } else if (view.getId() == R$id.item_contract_history_order && contractHistoryOrderInfo.isHasDetail()) {
            ContractModuleConfig.a().l(view.getContext(), contractHistoryOrderInfo);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
