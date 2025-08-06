package com.huobi.copytrading.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.huobi.copytrading.widget.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import s9.c;

public final class CopyTradingPopWindowItemHandler implements c, View.OnClickListener {
    /* renamed from: b */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        View view;
        String str = null;
        View view2 = cVar != null ? cVar.itemView : null;
        if (view2 != null) {
            view2.setTag(aVar);
        }
        if (!(cVar == null || (view = cVar.itemView) == null)) {
            view.setOnClickListener(this);
        }
        r e11 = cVar != null ? cVar.e() : null;
        ImageView imageView = e11 != null ? (ImageView) e11.b(R.id.id_contract_trade_popwindow_item_img) : null;
        TextView textView = e11 != null ? (TextView) e11.b(R.id.id_contract_trade_popwindow_item_name) : null;
        if (aVar != null) {
            int c11 = aVar.c();
            if (imageView != null) {
                imageView.setImageResource(c11);
            }
        }
        if (textView != null) {
            if (aVar != null) {
                str = aVar.e();
            }
            textView.setText(str);
        }
    }

    public int getResId() {
        return R.layout.item_copytrading_popwindow;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a.C0566a a11;
        a aVar = (a) (view != null ? view.getTag() : null);
        if (!(aVar == null || (a11 = aVar.a()) == null)) {
            a11.a(aVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
