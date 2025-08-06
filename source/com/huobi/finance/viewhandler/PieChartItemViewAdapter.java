package com.huobi.finance.viewhandler;

import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bl.z2;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.module.asset.R$color;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.huobi.view.chart.data.PieEntry;
import com.huobi.view.drawable.BgColorDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.m;
import i6.r;
import java.math.BigDecimal;
import s9.c;

public class PieChartItemViewAdapter implements c {

    /* renamed from: b  reason: collision with root package name */
    public float f67621b = ((float) PixelUtils.a(5.0f));

    /* renamed from: c  reason: collision with root package name */
    public float f67622c = ((float) PixelUtils.a(0.5f));

    /* renamed from: d  reason: collision with root package name */
    public int f67623d;

    @SensorsDataInstrumented
    public static /* synthetic */ void d(PieEntry pieEntry, int i11, View view) {
        if (pieEntry.getPieChartHandleCallback() != null) {
            pieEntry.getPieChartHandleCallback().onPieItemClick(i11, pieEntry);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: c */
    public void handleView(v9.c cVar, int i11, PieEntry pieEntry, ViewGroup viewGroup) {
        View view = cVar.itemView;
        r e11 = cVar.e();
        if (i11 == 0) {
            this.f67623d = ContextCompat.getColor(view.getContext(), R$color.baseColorPrimarySeparator);
        }
        TextView e12 = e11.e(R$id.item_balance_currency_name);
        View b11 = e11.b(R$id.item_balance_chart_label);
        TextView e13 = e11.e(R$id.item_balance_chart_amount);
        e12.setText(pieEntry.getTitle());
        e13.setText(m.q(new BigDecimal(String.valueOf(pieEntry.getValue())).multiply(new BigDecimal("100")), 2) + "%");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f67621b);
        if (pieEntry.getColor() != null) {
            e12.setTextColor(pieEntry.getColor().intValue());
            b11.setBackground(new BgColorDrawable(pieEntry.getColor().intValue(), (float) PixelUtils.a(5.0f)));
            if (pieEntry.isSelected()) {
                gradientDrawable.setStroke((int) this.f67622c, pieEntry.getColor().intValue());
            } else {
                gradientDrawable.setStroke((int) this.f67622c, this.f67623d);
            }
        } else {
            gradientDrawable.setStroke((int) this.f67622c, this.f67623d);
        }
        view.setBackground(gradientDrawable);
        view.setTag(R$id.item_data, pieEntry);
        view.setOnClickListener(new z2(pieEntry, i11));
    }

    public int getResId() {
        return R$layout.item_balance_piechart;
    }
}
