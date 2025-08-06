package com.hbg.lite.record.viewhandler;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.network.otc.core.bean.OrderInfoListBean;
import com.hbg.lite.R$color;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$string;
import com.hbg.lite.record.bean.OtcOrderList;
import i6.m;
import i6.r;
import s9.c;

public class OtcOrderViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, OtcOrderList otcOrderList, ViewGroup viewGroup) {
        View view = cVar.itemView;
        Context context = view.getContext();
        Resources resources = view.getResources();
        r e11 = cVar.e();
        TextView textView = (TextView) e11.b(R$id.otc_order_type);
        TextView textView2 = (TextView) e11.b(R$id.otc_order_currency);
        TextView textView3 = (TextView) e11.b(R$id.otc_order_status);
        TextView textView4 = (TextView) e11.b(R$id.otc_order_time);
        TextView textView5 = (TextView) e11.b(R$id.otc_order_amount);
        TextView textView6 = (TextView) e11.b(R$id.otc_order_total);
        TextView textView7 = (TextView) e11.b(R$id.otc_order_single_price_value_tv);
        OrderInfoListBean d11 = otcOrderList.d();
        if (otcOrderList.e()) {
            textView.setText(resources.getString(R$string.otc_sell));
            textView.setTextColor(ContextCompat.getColor(context, R$color.base_down_color));
        } else {
            textView.setText(resources.getString(R$string.otc_buy));
            textView.setTextColor(ContextCompat.getColor(context, R$color.base_up_color));
        }
        textView4.setText(DateTimeUtils.C(d11.getGmtCreate().longValue()));
        textView2.setText(d11.getCryptoAssetName());
        if (otcOrderList.f()) {
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        int intValue = d11.getOrderStatus().intValue();
        if (intValue == 0) {
            if (otcOrderList.e()) {
                textView3.setText(resources.getString(R$string.otc_order_detail_seller_waiting_pay_status_text));
            } else {
                textView3.setText(resources.getString(R$string.n_otc_trade_order_status_not_pay_buy_show));
            }
            textView3.setTextColor(ContextCompat.getColor(context, R$color.baseColorMajorTheme100));
        } else if (intValue == 1) {
            if (otcOrderList.e()) {
                textView3.setText(resources.getString(R$string.otc_order_status_sell_paid));
            } else {
                textView3.setText(resources.getString(R$string.otc_order_status_buy_paid));
            }
            textView3.setTextColor(ContextCompat.getColor(context, R$color.baseColorMajorTheme100));
        } else if (intValue == 2) {
            textView3.setText(resources.getString(R$string.otc_order_status_cancel));
            textView3.setTextColor(ContextCompat.getColor(context, R$color.baseColorSecondaryText));
        } else if (intValue == 3) {
            textView3.setText(resources.getString(R$string.otc_order_status_finished));
            textView3.setTextColor(ContextCompat.getColor(context, R$color.baseColorSecondaryText));
        } else if (intValue == 4) {
            textView3.setText(resources.getString(R$string.n_otc_order_status_appeal));
            textView3.setTextColor(ContextCompat.getColor(context, R$color.baseColorMajorTheme100));
        } else if (intValue == 100) {
            textView3.setText(resources.getString(R$string.otc_order_status_price_invalid));
            textView3.setTextColor(ContextCompat.getColor(context, R$color.baseColorMajorTheme100));
        }
        textView7.setText(d11.getQuoteAssetSymbol() + nb.c.b(d11.getQuote(), m.U(d11.getQuote())));
        textView5.setText(String.format(context.getString(R$string.two_label_with_space), new Object[]{d11.getQuantity(), d11.getCryptoAssetName()}));
        textView6.setText(d11.getQuoteAssetSymbol() + nb.c.b(d11.getAmount(), m.U(d11.getAmount())));
    }

    public int getResId() {
        return R$layout.item_lite_otc_order_list;
    }
}
