package com.huobi.setting.pricing.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import ir.a;
import pro.huobi.R;
import s9.c;

public class PricingMethodItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        if (cVar != null && aVar != null) {
            r e11 = cVar.e();
            ImageView imageView = (ImageView) e11.b(R.id.iv_pricing_method_item_flag);
            TextView textView = (TextView) e11.b(R.id.id_pricing_method_item_title);
            View b11 = e11.b(R.id.id_pricing_method_item_icon);
            cVar.itemView.setTag(aVar);
            cVar.itemView.setOnClickListener(this);
            a.C0869a aVar2 = aVar.f84296b;
            if (aVar2 != null) {
                Object G9 = aVar2.G9(aVar.f84297c);
                if (G9 instanceof Integer) {
                    int intValue = ((Integer) G9).intValue();
                    if (intValue != -1) {
                        imageView.setImageResource(intValue);
                    } else {
                        return;
                    }
                } else if (G9 instanceof String) {
                    f6.c.a().e(imageView, (String) G9);
                }
                textView.setText(aVar.f84296b.nc(aVar.f84297c));
                a.C0869a aVar3 = aVar.f84296b;
                b11.setVisibility((aVar3 == null || !aVar3.Vg(aVar.f84297c)) ? 8 : 0);
            }
        }
    }

    public int getResId() {
        return R.layout.layout_pricing_method_item;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a.C0869a aVar;
        a aVar2 = (a) view.getTag();
        if (!(aVar2 == null || (aVar = aVar2.f84296b) == null)) {
            aVar.j(aVar2.f84297c);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
