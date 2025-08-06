package com.huobi.points.viewhandler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gq.a;
import i6.r;
import java.util.Locale;
import pro.huobi.R;
import s9.c;

public class PointsBuyCurrencyViewHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(int i11, a aVar, TextView textView, View view) {
        view.setTag(R.id.item_data1, Integer.valueOf(i11));
        if (!aVar.d()) {
            textView.setBackgroundResource(R.drawable.ads_filter_item_select);
        }
        View.OnClickListener c11 = aVar.c();
        if (c11 != null) {
            c11.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        Context context = cVar.itemView.getContext();
        TextView textView = (TextView) e11.b(R.id.quote_currency_tv);
        if (aVar.d()) {
            textView.setBackgroundResource(R.drawable.ads_filter_item_select);
            textView.setTextColor(ContextCompat.getColor(context, R.color.global_small_area_bg_color));
        } else {
            textView.setBackgroundResource(R.drawable.ads_filter_item_normal);
            textView.setTextColor(ContextCompat.getColor(context, R.color.global_main_text_color));
        }
        textView.setText(aVar.a().toUpperCase(Locale.US));
        cVar.itemView.setOnClickListener(new kq.a(i11, aVar, textView));
    }

    public int getResId() {
        return R.layout.item_points_buy_currency;
    }
}
