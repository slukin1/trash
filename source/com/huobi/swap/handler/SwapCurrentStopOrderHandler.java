package com.huobi.swap.handler;

import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTriggerOrderInfo;
import com.hbg.lib.network.swap.core.bean.SwapTriggerOrderInfo;
import com.huobi.contract.helper.ContractOrderHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import pro.huobi.R;
import ps.a;
import s9.c;
import us.i;
import us.j;

public class SwapCurrentStopOrderHandler implements c, View.OnClickListener {
    public static /* synthetic */ void d(a aVar, Context context, Void voidR) {
        if (aVar.c() != null) {
            aVar.c().a(aVar, context);
        }
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        r rVar;
        String str;
        TextView textView;
        String str2;
        String str3;
        int i12;
        v9.c cVar2 = cVar;
        a aVar2 = aVar;
        if (aVar2 == null || aVar.e() == null) {
            return;
        }
        Context context = cVar2.itemView.getContext();
        SwapTriggerOrderInfo e11 = aVar.e();
        r e12 = cVar.e();
        Resources resources = cVar2.itemView.getResources();
        TextView textView2 = (TextView) e12.b(R.id.item_contract_order_tv_title_type);
        TextView textView3 = (TextView) e12.b(R.id.item_contract_order_tv_title_symbol);
        TextView textView4 = (TextView) e12.b(R.id.item_contract_order_tv_title_date);
        TextView textView5 = (TextView) e12.b(R.id.item_contract_order_tv_title_cancel);
        TextView textView6 = (TextView) e12.b(R.id.item_contract_order_tv_order_volume);
        TextView textView7 = (TextView) e12.b(R.id.item_contract_order_tv_order_volume_title);
        TextView textView8 = (TextView) e12.b(R.id.item_contract_order_tv_order_trigger);
        TextView textView9 = (TextView) e12.b(R.id.item_contract_order_tv_order_trigger_title);
        TextView textView10 = (TextView) e12.b(R.id.item_contract_order_tv_order_price);
        TextView textView11 = (TextView) e12.b(R.id.item_contract_order_tv_order_price_title);
        TradeType tradeType = TradeType.SWAP;
        if (e.E(tradeType)) {
            str = e11.getSymbol();
            rVar = e12;
        } else {
            rVar = e12;
            str = resources.getString(R.string.contract_market_vol_sheet);
        }
        Locale locale = Locale.US;
        TextView textView12 = textView8;
        TextView textView13 = textView2;
        TradeType tradeType2 = tradeType;
        textView7.setText(String.format(locale, resources.getString(R.string.contract_entrust_order_volume), new Object[]{str}));
        textView9.setText(String.format(locale, resources.getString(R.string.trade_trend_trigger_price_unit), new Object[]{"usd".toUpperCase(locale)}));
        textView11.setText(String.format(locale, resources.getString(R.string.contract_entrust_order_price), new Object[]{"usd".toUpperCase(locale)}));
        textView5.setTag(aVar2);
        textView5.setOnClickListener(this);
        textView3.setText(j.g(context, e11.getSymbol()));
        textView4.setText(String.format("%s %s", new Object[]{resources.getString(R.string.n_contract_order_time), DateTimeUtils.C(e11.getCreatedAt())}));
        String str4 = "--";
        if (TextUtils.equals(e11.getOrderPriceType(), "tpsl_position_trigger")) {
            textView10.setText(resources.getString(R.string.n_copy_trading_market_price));
            textView6.setText(resources.getString(R.string.n_contract_all_position));
        } else {
            if (m.a(e11.getOrderPrice()).compareTo(BigDecimal.ZERO) == 0) {
                str3 = e11.getTriggerPrice();
            } else {
                str3 = e11.getOrderPrice();
            }
            String str5 = null;
            if (!TextUtils.isEmpty(e11.getOrderPriceType()) && e11.getOrderPriceType().contains("_")) {
                String[] split = e11.getOrderPriceType().split("_");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str5 = String.format(locale, resources.getString(R.string.contract_order_trigger_optimal), new Object[]{split[1]});
                }
            } else if (TextUtils.equals(e11.getOrderPriceType(), PrimeRounds.ROUND_TRADE_MARKET_TYPE)) {
                str5 = resources.getString(R.string.n_exchange_order_list_market);
            }
            if (TextUtils.isEmpty(str5)) {
                str5 = m.n(e11.getOrderPrice(), i.m(e11.getSymbol()), str4);
            }
            textView10.setText(str5);
            boolean E = e.E(tradeType2);
            String f11 = ContractOrderHelper.f(e11.getVolume(), str3, aVar.d(), tradeType2);
            if (E) {
                i12 = i.p(e11.getSymbol());
            } else {
                i12 = i.z(e11.getSymbol());
            }
            textView6.setText(m.m(f11, i12));
        }
        if (e11.isBuy()) {
            textView = textView13;
            textView.setTextColor(resources.getColor(w.h()));
        } else {
            textView = textView13;
            textView.setTextColor(resources.getColor(w.d()));
        }
        if (e11.isOpen()) {
            if (e11.isBuy()) {
                str2 = resources.getString(R.string.n_contract_trade_open_more);
            } else {
                str2 = resources.getString(R.string.n_contract_trade_open_low);
            }
        } else if (e11.isDelivery()) {
            str2 = resources.getString(R.string.currency_detail_contract_status_force_delivry);
        } else if (e11.isExplose()) {
            str2 = resources.getString(R.string.currency_detail_contract_status_force_flat);
        } else if (e11.isBuy()) {
            str2 = resources.getString(R.string.n_contract_trade_close_low);
        } else {
            str2 = resources.getString(R.string.n_contract_trade_close_more);
        }
        textView.setText(e11.getLeverRate() + "X·" + str2);
        if ("ge".equalsIgnoreCase(e11.getTriggerType())) {
            str4 = resources.getString(R.string.n_contract_latest_price) + resources.getString(R.string.string_flag_bigger_equals);
        } else if ("le".equalsIgnoreCase(e11.getTriggerType())) {
            str4 = resources.getString(R.string.n_contract_latest_price) + resources.getString(R.string.string_flag_smaller_equals);
        } else if (LinearSwapTriggerOrderInfo.GE_MARK.equalsIgnoreCase(e11.getTriggerType())) {
            str4 = resources.getString(R.string.n_contract_mark_price) + resources.getString(R.string.string_flag_bigger_equals);
        } else if (LinearSwapTriggerOrderInfo.LE_MARK.equalsIgnoreCase(e11.getTriggerType())) {
            str4 = resources.getString(R.string.n_contract_mark_price) + resources.getString(R.string.string_flag_smaller_equals);
        }
        textView12.setText(String.format(locale, str4, new Object[]{m.m(e11.getTriggerPrice(), i.m(e11.getSymbol()))}));
        r rVar2 = rVar;
        LinearLayout linearLayout = (LinearLayout) rVar2.b(R.id.id_ll_edit);
        TextView textView14 = (TextView) rVar2.b(R.id.item_contract_order_tv_sltp);
        if ("sl".equals(e11.getTpslOrderType())) {
            textView14.setText(R.string.n_contract_stop_loss);
            textView14.setVisibility(0);
            linearLayout.setVisibility(0);
        } else if ("tp".equals(e11.getTpslOrderType())) {
            textView14.setText(R.string.n_contract_take_profit);
            textView14.setVisibility(0);
            linearLayout.setVisibility(0);
        } else {
            textView14.setVisibility(4);
            linearLayout.setVisibility(8);
        }
        dw.a.a(linearLayout).throttleFirst(1, TimeUnit.SECONDS).subscribe(new rs.c(aVar2, context));
    }

    public int getResId() {
        return R.layout.item_contract_current_trigger_order_list;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = (a) view.getTag();
        if (!(view.getId() != R.id.item_contract_order_tv_title_cancel || aVar == null || aVar.c() == null)) {
            aVar.c().b(aVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
