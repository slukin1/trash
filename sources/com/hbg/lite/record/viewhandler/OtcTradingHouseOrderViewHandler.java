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
import com.hbg.lite.record.bean.OtcTradingHouseOrderList;
import i6.r;
import s9.c;

public class OtcTradingHouseOrderViewHandler implements c {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, OtcTradingHouseOrderList otcTradingHouseOrderList, ViewGroup viewGroup) {
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
        OrderInfoListBean d11 = otcTradingHouseOrderList.d();
        if (otcTradingHouseOrderList.f()) {
            textView.setText(resources.getString(R$string.otc_sell));
            textView.setTextColor(ContextCompat.getColor(context, R$color.base_down_color));
        } else {
            textView.setText(resources.getString(R$string.otc_buy));
            textView.setTextColor(ContextCompat.getColor(context, R$color.base_up_color));
        }
        textView4.setText(DateTimeUtils.C(d11.getGmtCreate().longValue()));
        textView2.setText(otcTradingHouseOrderList.e());
        if (otcTradingHouseOrderList.g()) {
            textView2.setVisibility(0);
        } else {
            textView2.setVisibility(8);
        }
        int intValue = d11.getOrderStatus().intValue();
        if (intValue == 2) {
            textView3.setText(resources.getString(R$string.otc_order_status_cancel));
            textView3.setTextColor(ContextCompat.getColor(context, R$color.baseColorSecondaryText));
        } else if (intValue == 3) {
            textView3.setText(resources.getString(R$string.otc_order_status_finished));
            textView3.setTextColor(ContextCompat.getColor(context, R$color.baseColorSecondaryText));
        }
        int i12 = R$string.two_label_with_space;
        textView7.setText(String.format(resources.getString(i12), new Object[]{d11.getQuote(), d11.getQuoteAssetName()}));
        textView5.setText(String.format(context.getString(i12), new Object[]{d11.getQuantity(), otcTradingHouseOrderList.e()}));
        textView6.setText(String.format(resources.getString(i12), new Object[]{d11.getAmount(), otcTradingHouseOrderList.c()}));
    }

    public int getResId() {
        return R$layout.item_lite_otc_order_list;
    }
}
