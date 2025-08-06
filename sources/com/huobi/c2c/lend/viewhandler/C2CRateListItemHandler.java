package com.huobi.c2c.lend.viewhandler;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.huobi.c2c.util.o;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import oi.b;
import pro.huobi.R;
import ri.d;
import s9.c;

public class C2CRateListItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(b bVar, View view) {
        if (bVar.d() != null) {
            bVar.d().a(bVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, b bVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        ViewGroup viewGroup2 = (ViewGroup) e11.b(R.id.c2c_lend_rate_item);
        TextView textView = (TextView) e11.b(R.id.c2c_lend_rate_item_rate);
        TextView textView2 = (TextView) e11.b(R.id.c2c_lend_rate_item_amount);
        String str = "--";
        textView.setText(!TextUtils.isEmpty(bVar.f()) ? m.Q(bVar.f(), o.e(), 1) : str);
        if (!TextUtils.isEmpty(bVar.c())) {
            str = m.X(m.m(bVar.c(), 2));
        }
        textView2.setText(str);
        viewGroup2.setOnClickListener(new d(bVar));
    }

    public int getResId() {
        return R.layout.c2c_lend_rate_item;
    }
}
