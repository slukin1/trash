package com.hbg.lib.widgets.adapter.viewhandler;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.adapter.bean.CommonEmptyItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import s9.c;
import w9.a;

public class CommonEmptyItemHandler implements c {
    @SensorsDataInstrumented
    public static /* synthetic */ void d(CommonEmptyItem commonEmptyItem, View view) {
        if (commonEmptyItem.e() != null) {
            commonEmptyItem.e().a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, CommonEmptyItem commonEmptyItem, ViewGroup viewGroup) {
        int i12;
        int i13;
        Resources resources = cVar.itemView.getResources();
        r e11 = cVar.e();
        ImageView imageView = (ImageView) e11.b(R$id.id_common_empty_item_iv);
        TextView textView = (TextView) e11.b(R$id.id_common_empty_item_tv);
        TextView textView2 = (TextView) e11.b(R$id.id_common_empty_item_btn);
        if (commonEmptyItem != null) {
            if (commonEmptyItem.f() != 0) {
                imageView.setImageResource(commonEmptyItem.f());
            }
            if (commonEmptyItem.h() != 0) {
                i12 = commonEmptyItem.h();
            } else {
                i12 = resources.getDimensionPixelOffset(R$dimen.dimen_60);
            }
            if (commonEmptyItem.h() != 0) {
                i13 = commonEmptyItem.c();
            } else {
                i13 = resources.getDimensionPixelOffset(R$dimen.dimen_20);
            }
            cVar.itemView.setPadding(0, i12, 0, i13);
            if (!TextUtils.isEmpty(commonEmptyItem.g())) {
                textView.setText(commonEmptyItem.g());
            }
            if (TextUtils.isEmpty(commonEmptyItem.d())) {
                ViewUtil.m(textView2, false);
                return;
            }
            ViewUtil.m(textView2, true);
            textView2.setText(commonEmptyItem.d());
            textView2.setOnClickListener(new a(commonEmptyItem));
        }
    }

    public int getResId() {
        return R$layout.common_empty_item_layout;
    }
}
