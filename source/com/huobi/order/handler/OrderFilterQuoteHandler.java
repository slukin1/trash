package com.huobi.order.handler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.huobi.order.bean.OrderFilterQuoteItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;
import wo.a;

public class OrderFilterQuoteHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(int i11, OrderFilterQuoteItem orderFilterQuoteItem, TextView textView, View view) {
        view.setTag(R.id.item_data1, Integer.valueOf(i11));
        if (!orderFilterQuoteItem.d()) {
            textView.setSelected(true);
        }
        View.OnClickListener a11 = orderFilterQuoteItem.a();
        if (a11 != null) {
            a11.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, OrderFilterQuoteItem orderFilterQuoteItem, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        TextView textView = (TextView) e11.b(R.id.quote_currency_tv);
        if (orderFilterQuoteItem.d()) {
            textView.setTextColor(ContextCompat.getColor(context, R.color.baseColorMajorTheme100));
        } else {
            textView.setTextColor(ContextCompat.getColor(context, R.color.baseColorSecondaryTextNew));
        }
        textView.setSelected(orderFilterQuoteItem.d());
        textView.setText(orderFilterQuoteItem.c());
        cVar.itemView.setOnClickListener(new a(i11, orderFilterQuoteItem, textView));
    }

    public int getResId() {
        return R.layout.item_order_filter_quote;
    }
}
