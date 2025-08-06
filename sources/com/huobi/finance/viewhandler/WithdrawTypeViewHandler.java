package com.huobi.finance.viewhandler;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bl.j3;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.finance.bean.WithdrawTypeItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import pro.huobi.R;
import s9.c;

public class WithdrawTypeViewHandler implements c {

    /* renamed from: b  reason: collision with root package name */
    public float f67644b = ((float) PixelUtils.a(5.0f));

    /* renamed from: c  reason: collision with root package name */
    public float f67645c = ((float) PixelUtils.a(0.5f));

    /* renamed from: d  reason: collision with root package name */
    public int f67646d;

    /* renamed from: e  reason: collision with root package name */
    public int f67647e;

    /* renamed from: f  reason: collision with root package name */
    public int f67648f;

    @SensorsDataInstrumented
    public static /* synthetic */ void d(boolean z11, WithdrawTypeItem withdrawTypeItem, int i11, View view) {
        if (z11) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (withdrawTypeItem.d() == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            withdrawTypeItem.d().a(i11, withdrawTypeItem);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, WithdrawTypeItem withdrawTypeItem, ViewGroup viewGroup) {
        if (withdrawTypeItem != null) {
            TextView textView = (TextView) cVar.e().b(R.id.balance_header_hint);
            if (i11 == 0) {
                this.f67646d = ContextCompat.getColor(cVar.itemView.getContext(), R.color.baseColorMajorTheme100);
                this.f67647e = ContextCompat.getColor(cVar.itemView.getContext(), R.color.baseColorDeepestBackground);
                this.f67648f = ContextCompat.getColor(cVar.itemView.getContext(), R.color.baseColorPrimaryText);
            }
            textView.setText(withdrawTypeItem.e());
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.f67644b);
            boolean z11 = withdrawTypeItem.d() != null && withdrawTypeItem.d().b(i11, withdrawTypeItem);
            if (z11) {
                gradientDrawable.setStroke((int) this.f67645c, this.f67646d);
                textView.setTextColor(this.f67646d);
            } else {
                gradientDrawable.setColor(this.f67647e);
                textView.setTextColor(this.f67648f);
            }
            gradientDrawable.setCornerRadius(this.f67644b);
            cVar.itemView.setBackground(gradientDrawable);
            cVar.itemView.setOnClickListener(new j3(z11, withdrawTypeItem, i11));
        }
    }

    public int getResId() {
        return R.layout.item_chain_withdraw;
    }
}
