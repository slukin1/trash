package com.huobi.swap.handler;

import a7.e;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.swap.core.bean.SwapTrackOrderInfo;
import com.huobi.contract.helper.ContractOrderHelper;
import com.huobi.swap.bean.SwapCurrentTrackOrderItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.util.Locale;
import pro.huobi.R;
import s9.c;
import us.i;
import us.j;

public class SwapCurrentTrackOrderHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, SwapCurrentTrackOrderItem swapCurrentTrackOrderItem, ViewGroup viewGroup) {
        TextView textView;
        String str;
        int i12;
        TextView textView2;
        String str2;
        String str3;
        v9.c cVar2 = cVar;
        SwapCurrentTrackOrderItem swapCurrentTrackOrderItem2 = swapCurrentTrackOrderItem;
        Context context = cVar2.itemView.getContext();
        if (swapCurrentTrackOrderItem2 != null) {
            SwapTrackOrderInfo e11 = swapCurrentTrackOrderItem.e();
            r e12 = cVar.e();
            Resources resources = cVar2.itemView.getResources();
            TextView textView3 = (TextView) e12.b(R.id.item_contract_order_tv_title_type);
            TextView textView4 = (TextView) e12.b(R.id.item_contract_order_tv_title_symbol);
            TextView textView5 = (TextView) e12.b(R.id.item_contract_order_tv_title_date);
            TextView textView6 = (TextView) e12.b(R.id.item_contract_order_tv_title_cancel);
            TextView textView7 = (TextView) e12.b(R.id.item_contract_order_tv_order_volume);
            TextView textView8 = (TextView) e12.b(R.id.item_contract_order_tv_order_volume_title);
            TextView textView9 = (TextView) e12.b(R.id.item_contract_order_tv_order_trigger);
            TextView textView10 = (TextView) e12.b(R.id.item_contract_order_tv_order_trigger_title);
            TextView textView11 = (TextView) e12.b(R.id.item_contract_order_tv_order_price);
            TextView textView12 = (TextView) e12.b(R.id.item_contract_order_tv_order_price_title);
            TextView textView13 = (TextView) e12.b(R.id.item_contract_order_tv_call_back_rate);
            TextView textView14 = (TextView) e12.b(R.id.item_contract_order_tv_state);
            TradeType tradeType = TradeType.SWAP;
            if (e.E(tradeType)) {
                str = e11.getSymbol();
                textView = textView14;
            } else {
                textView = textView14;
                str = resources.getString(R.string.contract_market_vol_sheet);
            }
            Locale locale = Locale.US;
            TextView textView15 = textView9;
            TextView textView16 = textView3;
            TextView textView17 = textView7;
            textView8.setText(String.format(locale, resources.getString(R.string.contract_entrust_order_volume), new Object[]{str}));
            textView10.setText(String.format(locale, resources.getString(R.string.n_contract_track_order_unit), new Object[]{"usd".toUpperCase(locale)}));
            textView12.setText(String.format(locale, resources.getString(R.string.contract_entrust_order_price), new Object[]{"usd".toUpperCase(locale)}));
            textView6.setTag(swapCurrentTrackOrderItem2);
            textView6.setOnClickListener(this);
            textView4.setText(j.g(context, e11.getSymbol()));
            textView5.setText(String.format("%s %s", new Object[]{resources.getString(R.string.n_contract_order_time), DateTimeUtils.C(e11.getCreatedAt())}));
            String str4 = null;
            if (!TextUtils.isEmpty(e11.getOrderPriceType()) && e11.getOrderPriceType().contains("_")) {
                if ("formula_price".equalsIgnoreCase(e11.getOrderPriceType())) {
                    str4 = resources.getString(R.string.n_contract_theoretical_price);
                } else {
                    String[] split = e11.getOrderPriceType().split("_");
                    if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                        str4 = String.format(locale, resources.getString(R.string.contract_order_trigger_optimal), new Object[]{split[1]});
                    }
                }
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = m.n(e11.getOrderPrice(), i.m(e11.getSymbol()), "--");
            }
            textView11.setText(str4);
            boolean E = e.E(tradeType);
            String f11 = ContractOrderHelper.f(e11.getVolume(), e11.getActivePrice(), swapCurrentTrackOrderItem.d(), tradeType);
            if (E) {
                i12 = i.p(e11.getSymbol());
            } else {
                i12 = i.z(e11.getSymbol());
            }
            textView17.setText(m.m(f11, i12));
            if (swapCurrentTrackOrderItem.f()) {
                textView2 = textView16;
                textView2.setTextColor(resources.getColor(w.h()));
            } else {
                textView2 = textView16;
                textView2.setTextColor(resources.getColor(w.d()));
            }
            if (swapCurrentTrackOrderItem.i()) {
                if (swapCurrentTrackOrderItem.f()) {
                    str2 = resources.getString(R.string.n_contract_trade_open_more);
                } else {
                    str2 = resources.getString(R.string.n_contract_trade_open_low);
                }
            } else if (swapCurrentTrackOrderItem.g()) {
                str2 = resources.getString(R.string.currency_detail_contract_status_force_delivry);
            } else if (swapCurrentTrackOrderItem.h()) {
                str2 = resources.getString(R.string.currency_detail_contract_status_force_flat);
            } else if (swapCurrentTrackOrderItem.f()) {
                str2 = resources.getString(R.string.n_contract_trade_close_low);
            } else {
                str2 = resources.getString(R.string.n_contract_trade_close_more);
            }
            textView2.setText(e11.getLeverRate() + "X·" + str2);
            if ("ge".equalsIgnoreCase(e11.getActiveType())) {
                str3 = BaseApplication.c(R.string.string_flag_bigger_equals);
            } else {
                str3 = BaseApplication.c(R.string.string_flag_smaller_equals);
            }
            TextView textView18 = textView15;
            textView18.setText(String.format(locale, str3, new Object[]{m.m(e11.getActivePrice(), i.m(e11.getSymbol()))}));
            textView13.setText(m.Q(e11.getCallbackRate(), 1, 1));
            if (e11.getIsActive() == 1) {
                textView.setText(R.string.n_contract_track_order_state_order);
            } else {
                textView.setText(R.string.n_contract_track_order_state_active);
            }
        }
    }

    public int getResId() {
        return R.layout.item_contract_current_track_order_list;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SwapCurrentTrackOrderItem swapCurrentTrackOrderItem = (SwapCurrentTrackOrderItem) view.getTag();
        if (!(view.getId() != R.id.item_contract_order_tv_title_cancel || swapCurrentTrackOrderItem == null || swapCurrentTrackOrderItem.c() == null)) {
            swapCurrentTrackOrderItem.c().a(swapCurrentTrackOrderItem);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
