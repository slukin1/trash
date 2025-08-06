package com.hbg.lib.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class NetworkErrorLayout extends LinearLayout implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public a f71544b;

    public interface a {
        void a();
    }

    public NetworkErrorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(Context context) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        imageView.setImageResource(R$drawable.common_no_network_icon);
        addView(imageView);
        TextView textView = new TextView(context);
        textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        textView.setText(getResources().getString(R$string.common_no_internet_access));
        textView.setTextColor(getResources().getColor(R$color.global_default_text_color));
        textView.setTextSize(0, (float) getResources().getDimensionPixelOffset(R$dimen.common_error_tip_text_size));
        addView(textView);
        TextView textView2 = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R$dimen.dimen_125), getResources().getDimensionPixelOffset(R$dimen.dimen_40));
        layoutParams.topMargin = getResources().getDimensionPixelOffset(R$dimen.dimen_20);
        textView2.setLayoutParams(layoutParams);
        textView2.setGravity(17);
        textView2.setBackgroundResource(R$drawable.shape_common_middle_btn);
        textView2.setText(getResources().getString(R$string.common_reloading));
        textView2.setTextColor(getResources().getColor(R$color.global_jump_btn_color));
        textView2.setTextSize(0, (float) getResources().getDimensionPixelOffset(R$dimen.global_text_size_14));
        addView(textView2);
        textView2.setOnClickListener(this);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        a aVar = this.f71544b;
        if (aVar != null) {
            aVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setCallback(a aVar) {
        this.f71544b = aVar;
    }

    public NetworkErrorLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setOrientation(1);
        setGravity(17);
        a(context);
    }
}
