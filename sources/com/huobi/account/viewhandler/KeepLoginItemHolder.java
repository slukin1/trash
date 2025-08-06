package com.huobi.account.viewhandler;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import pro.huobi.R;
import qg.a;
import s9.c;

public class KeepLoginItemHolder implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(a aVar, View view) {
        if (aVar.c() != null) {
            aVar.c().xa(aVar);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, a aVar, ViewGroup viewGroup) {
        r e11 = cVar.e();
        View view = cVar.itemView;
        TextView textView = (TextView) e11.b(R.id.id_keep_login_time_item_title);
        textView.setText(aVar.e(view.getContext()));
        ViewUtil.m((ImageView) e11.b(R.id.id_keep_login_time_item_icon), aVar.g());
        boolean g11 = aVar.g();
        int i12 = R.color.baseColorPrimaryText;
        if (g11) {
            view.setOnClickListener((View.OnClickListener) null);
        } else if (aVar.h()) {
            view.setOnClickListener(new vg.c(aVar));
        } else {
            i12 = R.color.baseColorSecondaryText;
            view.setOnClickListener((View.OnClickListener) null);
        }
        textView.setTextColor(view.getContext().getResources().getColor(i12));
    }

    public int getResId() {
        return R.layout.layout_keep_login_time_item;
    }
}
