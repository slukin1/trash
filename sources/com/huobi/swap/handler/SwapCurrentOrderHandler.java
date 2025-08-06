package com.huobi.swap.handler;

import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.common.utils.AppUtil;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.swap.core.bean.SwapCurrentOrderInfo;
import com.huobi.contract.helper.ContractOrderHelper;
import com.huobi.feature.util.FutureLimitOrderEditDialogHelper;
import com.huobi.swap.bean.SwapCurrentOrderItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import rs.b;
import s9.c;
import us.i;
import us.j;

public class SwapCurrentOrderHandler implements c, View.OnClickListener {

    public interface a {
        void a(SwapCurrentOrderInfo swapCurrentOrderInfo);

        void b(SwapCurrentOrderInfo swapCurrentOrderInfo, Context context);
    }

    @SensorsDataInstrumented
    public static /* synthetic */ void e(SwapCurrentOrderItem swapCurrentOrderItem, SwapCurrentOrderInfo swapCurrentOrderInfo, Context context, View view) {
        if (swapCurrentOrderItem.c() != null) {
            swapCurrentOrderItem.c().b(swapCurrentOrderInfo, context);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void f(SwapCurrentOrderItem swapCurrentOrderItem, String str, String str2, Void voidR) {
        FragmentActivity fragmentActivity = (FragmentActivity) oa.a.g().b();
        SwapCurrentOrderInfo d11 = swapCurrentOrderItem.d();
        FutureLimitOrderEditDialogHelper.s(fragmentActivity, (FutureLimitOrderEditDialogHelper.c) null, d11.getOrderId() + "", str, str2, d11.getContractCode(), d11.getOrderPriceType(), d11.getOffset(), d11.getDirection(), d11.getLeverRate() == null ? "0" : d11.getLeverRate().toString());
    }

    /* renamed from: d */
    public void handleView(v9.c cVar, int i11, SwapCurrentOrderItem swapCurrentOrderItem, ViewGroup viewGroup) {
        String str;
        Context context;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        TextView textView;
        String str2;
        v9.c cVar2 = cVar;
        SwapCurrentOrderItem swapCurrentOrderItem2 = swapCurrentOrderItem;
        if (swapCurrentOrderItem2 != null) {
            Context context2 = cVar2.itemView.getContext();
            SwapCurrentOrderInfo d11 = swapCurrentOrderItem.d();
            r e11 = cVar.e();
            Resources resources = cVar2.itemView.getResources();
            TextView textView2 = (TextView) e11.b(R.id.item_contract_order_tv_title_symbol);
            TextView textView3 = (TextView) e11.b(R.id.item_contract_order_tv_title_date);
            View b11 = e11.b(R.id.id_current_order_item_edit);
            TextView textView4 = (TextView) e11.b(R.id.item_contract_order_tv_title_cancel);
            TextView textView5 = (TextView) e11.b(R.id.item_contract_order_tv_order_volume);
            TextView textView6 = (TextView) e11.b(R.id.item_contract_order_tv_order_volume_title);
            TextView textView7 = (TextView) e11.b(R.id.item_contract_order_tv_order_price_title);
            TextView textView8 = (TextView) e11.b(R.id.item_contract_order_tv_order_money_title);
            View view = b11;
            TextView textView9 = (TextView) e11.b(R.id.item_contract_order_tv_title_type);
            TextView textView10 = (TextView) e11.b(R.id.item_contract_order_tv_trade_volume_title);
            TextView textView11 = (TextView) e11.b(R.id.item_contract_order_tv_trade_volume);
            TextView textView12 = (TextView) e11.b(R.id.item_contract_order_tv_trade_price);
            TextView textView13 = (TextView) e11.b(R.id.item_contract_order_tv_trade_price_title);
            TextView textView14 = (TextView) e11.b(R.id.item_contract_order_tv_order_money);
            TextView textView15 = (TextView) e11.b(R.id.item_contract_order_tv_trade_fee);
            TextView textView16 = (TextView) e11.b(R.id.item_contract_order_tv_trade_fee_title);
            TextView textView17 = (TextView) e11.b(R.id.item_contract_order_tv_order_price);
            TextView textView18 = (TextView) e11.b(R.id.item_contract_order_tv_title_stop);
            LinearLayout linearLayout = (LinearLayout) e11.b(R.id.item_contract_order_data_ll);
            LinearLayout linearLayout2 = (LinearLayout) e11.b(R.id.item_contract_order_deal_data_ll);
            TradeType tradeType = TradeType.SWAP;
            if (e.E(tradeType)) {
                str = d11.getSymbol();
            } else {
                str = resources.getString(R.string.contract_market_vol_sheet);
            }
            TextView textView19 = textView5;
            TradeType tradeType2 = tradeType;
            TextView textView20 = textView3;
            textView6.setText(AppUtil.b(resources.getString(R.string.n_exchange_order_list_entrust_amount), "(", str, ")"));
            Locale locale = Locale.US;
            TextView textView21 = textView2;
            textView7.setText(AppUtil.b(resources.getString(R.string.n_exchange_order_list_entrust_price), "(", "usd".toUpperCase(locale), ")"));
            if (d11.isOpen()) {
                textView8.setText(resources.getString(R.string.n_bond) + "(" + d11.getSymbol() + ")");
                context = context2;
                i13 = 4;
                i12 = 1;
            } else {
                context = context2;
                i12 = 1;
                textView8.setText(String.format(locale, resources.getString(R.string.contract_entrust_order_get_money), new Object[]{d11.getSymbol()}));
                i13 = 4;
            }
            Object[] objArr = new Object[i13];
            objArr[0] = resources.getString(R.string.n_exchange_order_detail_trade_amount);
            objArr[i12] = "(";
            objArr[2] = str;
            objArr[3] = ")";
            textView10.setText(AppUtil.b(objArr));
            String string = resources.getString(R.string.contract_current_order_trade_price);
            Object[] objArr2 = new Object[i12];
            objArr2[0] = "usd".toUpperCase(locale);
            textView13.setText(String.format(locale, string, objArr2));
            String string2 = resources.getString(R.string.contract_entrust_order_fee);
            Object[] objArr3 = new Object[i12];
            objArr3[0] = d11.getSymbol();
            textView16.setText(String.format(locale, string2, objArr3));
            textView4.setTag(swapCurrentOrderItem2);
            textView4.setOnClickListener(this);
            Context context3 = context;
            textView21.setText(j.g(context3, d11.getSymbol()));
            textView20.setText(String.format("%s %s", new Object[]{resources.getString(R.string.n_contract_order_time), DateTimeUtils.C(d11.getCreatedAt().longValue())}));
            boolean E = e.E(tradeType2);
            TradeType tradeType3 = tradeType2;
            String f11 = ContractOrderHelper.f(d11.getVolume(), d11.getPrice(), d11.getContractFace(), tradeType3);
            if (E) {
                i14 = i.p(d11.getSymbol());
            } else {
                i14 = i.z(d11.getSymbol());
            }
            textView19.setText(m.m(f11, i14));
            String f12 = ContractOrderHelper.f(m.a(d11.getVolume()).subtract(m.a(d11.getTradeVolume())).toPlainString(), d11.getPrice(), d11.getContractFace(), tradeType3);
            if (E) {
                i15 = i.p(d11.getSymbol());
            } else {
                i15 = i.z(d11.getSymbol());
            }
            String m11 = m.m(f12, i15);
            String str3 = "--";
            String n11 = m.n(d11.getPrice(), i.m(d11.getSymbol()), str3);
            textView17.setText(n11);
            if (d11.isOpen()) {
                textView14.setText(m.m(d11.getMarginFrozen(), i.c(d11.getSymbol())));
            } else {
                textView14.setText(d11.getCreatedAt().longValue() >= 1611936000000L ? m.m(d11.getRealProfit(), i.t(d11.getSymbol())) : str3);
            }
            String price = d11.getPrice();
            if (E && m.a(d11.getTradeAvgPrice()).compareTo(BigDecimal.ZERO) > 0) {
                price = d11.getTradeAvgPrice();
            }
            String f13 = ContractOrderHelper.f(d11.getTradeVolume(), price, d11.getContractFace(), tradeType3);
            if (E) {
                i16 = i.h(d11.getSymbol());
            } else {
                i16 = i.b(d11.getSymbol());
            }
            textView11.setText(m.m(f13, i16));
            if (!TextUtils.isEmpty(d11.getTradeAvgPrice())) {
                str3 = m.m(d11.getTradeAvgPrice(), i.m(d11.getSymbol()));
            }
            textView12.setText(str3);
            textView15.setText(m.m(d11.getFee(), i.g(d11.getSymbol())));
            if (d11.isBuy()) {
                textView = textView9;
                textView.setTextColor(resources.getColor(w.h()));
            } else {
                textView = textView9;
                textView.setTextColor(resources.getColor(w.d()));
            }
            if (d11.isOpen()) {
                if (d11.isBuy()) {
                    str2 = resources.getString(R.string.n_contract_trade_open_more);
                } else {
                    str2 = resources.getString(R.string.n_contract_trade_open_low);
                }
            } else if (d11.isDelivery()) {
                str2 = resources.getString(R.string.currency_detail_contract_status_force_delivry);
            } else if (d11.isExplose()) {
                str2 = resources.getString(R.string.currency_detail_contract_status_force_flat);
            } else if (d11.isBuy()) {
                str2 = resources.getString(R.string.n_contract_trade_close_low);
            } else {
                str2 = resources.getString(R.string.n_contract_trade_close_more);
            }
            textView.setText(d11.getLeverRate() + "X·" + str2);
            TextView textView22 = textView18;
            ViewUtil.m(textView22, d11.isTpsl());
            textView22.setOnClickListener(new rs.a(swapCurrentOrderItem2, d11, context3));
            dw.a.a(view).throttleFirst(1, TimeUnit.SECONDS).subscribe(new b(swapCurrentOrderItem2, n11, m11));
        }
    }

    public int getResId() {
        return R.layout.item_contract_current_order_list;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SwapCurrentOrderItem swapCurrentOrderItem = (SwapCurrentOrderItem) view.getTag();
        if (!(view.getId() != R.id.item_contract_order_tv_title_cancel || swapCurrentOrderItem == null || swapCurrentOrderItem.c() == null)) {
            swapCurrentOrderItem.c().a(swapCurrentOrderItem.d());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
