package com.huobi.contract.viewhandler;

import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.contract.R$id;
import com.hbg.lib.contract.R$layout;
import com.hbg.lib.contract.R$string;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.module.contract.ContractModuleConfig;
import com.huobi.contract.entity.ContractCurrentOrderInfo;
import com.huobi.contract.entity.ContractCurrentOrderItem;
import com.huobi.contract.helper.ContractOrderHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import ej.f;
import ej.g;
import fj.d;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import s9.c;

public class ContractCurrentOrderHandler implements c, View.OnClickListener {

    public interface a {
        void a(ContractCurrentOrderInfo contractCurrentOrderInfo, Context context);

        void b(ContractCurrentOrderInfo contractCurrentOrderInfo);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void e(ContractCurrentOrderItem contractCurrentOrderItem, ContractCurrentOrderInfo contractCurrentOrderInfo, View view) {
        if (contractCurrentOrderItem.c() != null) {
            contractCurrentOrderItem.c().a(contractCurrentOrderInfo, view.getContext());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void f(ContractCurrentOrderItem contractCurrentOrderItem, String str, String str2, Void voidR) {
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
        ContractCurrentOrderInfo d11 = contractCurrentOrderItem.d();
        ContractModuleConfig.a().e(fragmentActivity, d11.getOrderId() + "", str, str2, d11.getContractCode(), d11.getOrderPriceType(), d11.getOffset(), d11.getDirection(), d11.getLeverRate() == null ? "0" : d11.getLeverRate().toString());
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, ContractCurrentOrderItem contractCurrentOrderItem, ViewGroup viewGroup) {
        TextView textView;
        TextView textView2;
        String str;
        TextView textView3;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        TextView textView4;
        String str2;
        ContractCurrentOrderItem contractCurrentOrderItem2 = contractCurrentOrderItem;
        if (contractCurrentOrderItem2 != null) {
            ContractCurrentOrderInfo d11 = contractCurrentOrderItem.d();
            r e11 = cVar.e();
            Resources resources = cVar.itemView.getResources();
            TextView textView5 = (TextView) e11.b(R$id.item_contract_order_tv_title_symbol);
            TextView textView6 = (TextView) e11.b(R$id.item_contract_order_tv_title_date);
            View b11 = e11.b(R$id.id_current_order_item_edit);
            TextView textView7 = (TextView) e11.b(R$id.item_contract_order_tv_title_cancel);
            TextView textView8 = (TextView) e11.b(R$id.item_contract_order_tv_order_volume);
            TextView textView9 = (TextView) e11.b(R$id.item_contract_order_tv_order_volume_title);
            TextView textView10 = (TextView) e11.b(R$id.item_contract_order_tv_order_price);
            TextView textView11 = (TextView) e11.b(R$id.item_contract_order_tv_order_price_title);
            TextView textView12 = (TextView) e11.b(R$id.item_contract_order_tv_order_money_title);
            View view = b11;
            TextView textView13 = (TextView) e11.b(R$id.item_contract_order_tv_trade_volume_title);
            TextView textView14 = (TextView) e11.b(R$id.item_contract_order_tv_title_type);
            TextView textView15 = (TextView) e11.b(R$id.item_contract_order_tv_trade_price);
            TextView textView16 = (TextView) e11.b(R$id.item_contract_order_tv_trade_price_title);
            TextView textView17 = (TextView) e11.b(R$id.item_contract_order_tv_trade_volume);
            TextView textView18 = (TextView) e11.b(R$id.item_contract_order_tv_trade_fee);
            TextView textView19 = (TextView) e11.b(R$id.item_contract_order_tv_trade_fee_title);
            TextView textView20 = (TextView) e11.b(R$id.item_contract_order_tv_order_money);
            TextView textView21 = (TextView) e11.b(R$id.item_contract_order_tv_title_stop);
            TradeType tradeType = TradeType.CONTRACT;
            if (e.E(tradeType)) {
                textView = textView10;
                textView2 = textView21;
                str = d11.getSymbol();
            } else {
                textView2 = textView21;
                str = resources.getString(R$string.contract_market_vol_sheet);
                textView = textView10;
            }
            TextView textView22 = textView8;
            TradeType tradeType2 = tradeType;
            textView9.setText(AppUtil.b(resources.getString(R$string.n_exchange_order_list_entrust_amount), "(", str, ")"));
            Locale locale = Locale.US;
            TextView textView23 = textView6;
            textView11.setText(AppUtil.b(resources.getString(R$string.n_exchange_order_list_entrust_price), "(", "usd".toUpperCase(locale), ")"));
            if (d11.isOpen()) {
                textView12.setText(resources.getString(R$string.n_bond) + "(" + d11.getSymbol() + ")");
                textView3 = textView5;
                i13 = 4;
                i12 = 1;
            } else {
                textView3 = textView5;
                i12 = 1;
                textView12.setText(String.format(locale, resources.getString(R$string.contract_entrust_order_get_money), new Object[]{d11.getSymbol()}));
                i13 = 4;
            }
            Object[] objArr = new Object[i13];
            objArr[0] = resources.getString(R$string.n_exchange_order_detail_trade_amount);
            objArr[i12] = "(";
            objArr[2] = str;
            objArr[3] = ")";
            textView13.setText(AppUtil.b(objArr));
            String string = resources.getString(R$string.contract_current_order_trade_price);
            Object[] objArr2 = new Object[i12];
            objArr2[0] = "usd".toUpperCase(locale);
            textView16.setText(String.format(locale, string, objArr2));
            String string2 = resources.getString(R$string.contract_entrust_order_fee);
            Object[] objArr3 = new Object[i12];
            objArr3[0] = d11.getSymbol();
            textView19.setText(String.format(locale, string2, objArr3));
            textView7.setTag(contractCurrentOrderItem2);
            textView7.setOnClickListener(this);
            textView3.setText(g.e(textView3.getContext(), d11.getSymbol(), d11.getContractCode(), d11.getContractType()));
            textView23.setText(String.format("%s %s", new Object[]{resources.getString(R$string.otc_order_detail_payed_order_time), DateTimeUtils.C(d11.getCreatedAt().longValue())}));
            boolean E = e.E(tradeType2);
            String e12 = ContractOrderHelper.e(d11.getVolume(), d11.getPrice(), d11.getContractFace());
            if (E) {
                i14 = f.n(d11.getContractCode());
            } else {
                i14 = f.t(d11.getSymbol());
            }
            textView22.setText(m.m(e12, i14));
            String e13 = ContractOrderHelper.e(m.a(d11.getVolume()).subtract(m.a(d11.getTradeVolume())).toPlainString(), d11.getPrice(), d11.getContractFace());
            if (E) {
                i15 = f.n(d11.getContractCode());
            } else {
                i15 = f.t(d11.getSymbol());
            }
            String m11 = m.m(e13, i15);
            String str3 = "--";
            String n11 = m.n(d11.getPrice(), f.p(d11.getContractCode()), str3);
            textView.setText(n11);
            if (d11.isOpen()) {
                textView20.setText(m.m(d11.getMarginFrozen(), f.n(d11.getContractCode())));
            } else {
                textView20.setText(d11.getCreatedAt().longValue() >= 1611936000000L ? m.m(d11.getRealProfit(), f.n(d11.getContractCode())) : str3);
            }
            String price = d11.getPrice();
            if (E && m.a(d11.getTradeAvgPrice()).compareTo(BigDecimal.ZERO) > 0) {
                price = d11.getTradeAvgPrice();
            }
            String e14 = ContractOrderHelper.e(d11.getTradeVolume(), price, d11.getContractFace());
            if (E) {
                i16 = f.n(d11.getContractCode());
            } else {
                i16 = f.c(d11.getSymbol());
            }
            textView17.setText(m.m(e14, i16));
            if (!TextUtils.isEmpty(d11.getTradeAvgPrice())) {
                str3 = m.m(d11.getTradeAvgPrice(), f.p(d11.getContractCode()));
            }
            textView15.setText(str3);
            textView18.setText(m.u(d11.getFee(), f.l(d11.getContractCode())));
            if (d11.isBuy()) {
                textView4 = textView14;
                textView4.setTextColor(resources.getColor(w.h()));
            } else {
                textView4 = textView14;
                textView4.setTextColor(resources.getColor(w.d()));
            }
            if (d11.isOpen()) {
                if (d11.isBuy()) {
                    str2 = resources.getString(R$string.n_contract_trade_open_more);
                } else {
                    str2 = resources.getString(R$string.n_contract_trade_open_low);
                }
            } else if (d11.isDelivery()) {
                str2 = resources.getString(R$string.currency_detail_contract_status_force_delivry);
            } else if (d11.isExplose()) {
                str2 = resources.getString(R$string.currency_detail_contract_status_force_flat);
            } else if (d11.isBuy()) {
                str2 = resources.getString(R$string.n_contract_trade_close_low);
            } else {
                str2 = resources.getString(R$string.n_contract_trade_close_more);
            }
            textView4.setText(d11.getLeverRate() + "X·" + str2);
            TextView textView24 = textView2;
            ViewUtil.m(textView24, d11.isTpsl());
            textView24.setOnClickListener(new fj.c(contractCurrentOrderItem2, d11));
            dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new d(contractCurrentOrderItem2, n11, m11));
        }
    }

    public int getResId() {
        return R$layout.item_contract_current_order_list;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        ContractCurrentOrderItem contractCurrentOrderItem = (ContractCurrentOrderItem) view.getTag();
        if (!(view.getId() != R$id.item_contract_order_tv_title_cancel || contractCurrentOrderItem == null || contractCurrentOrderItem.c() == null)) {
            contractCurrentOrderItem.c().b(contractCurrentOrderItem.d());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
