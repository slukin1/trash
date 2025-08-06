package com.yanzhenjie.recyclerview.swipe.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.yanzhenjie.loading.LoadingView;
import com.yanzhenjie.recyclerview.swipe.R$color;
import com.yanzhenjie.recyclerview.swipe.R$id;
import com.yanzhenjie.recyclerview.swipe.R$layout;
import com.yanzhenjie.recyclerview.swipe.R$string;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

public class DefaultLoadMoreView extends LinearLayout implements SwipeMenuRecyclerView.e, View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public LoadingView f52696b = ((LoadingView) findViewById(R$id.loading_view));

    /* renamed from: c  reason: collision with root package name */
    public TextView f52697c = ((TextView) findViewById(R$id.tv_load_more_message));

    /* renamed from: d  reason: collision with root package name */
    public SwipeMenuRecyclerView.d f52698d;

    public DefaultLoadMoreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setGravity(17);
        setVisibility(8);
        setMinimumHeight((int) (((double) (getResources().getDisplayMetrics().density * 60.0f)) + 0.5d));
        LinearLayout.inflate(getContext(), R$layout.recycler_swipe_view_load_more, this);
        this.f52696b.a(ContextCompat.getColor(getContext(), R$color.recycler_swipe_color_loading_color1), ContextCompat.getColor(getContext(), R$color.recycler_swipe_color_loading_color2), ContextCompat.getColor(getContext(), R$color.recycler_swipe_color_loading_color3));
        setOnClickListener(this);
    }

    public void b() {
        setVisibility(0);
        this.f52696b.setVisibility(0);
        this.f52697c.setVisibility(0);
        this.f52697c.setText(R$string.recycler_swipe_load_more_message);
    }

    public void c(SwipeMenuRecyclerView.d dVar) {
        this.f52698d = dVar;
        setVisibility(0);
        this.f52696b.setVisibility(8);
        this.f52697c.setVisibility(0);
        this.f52697c.setText(R$string.recycler_swipe_click_load_more);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        SwipeMenuRecyclerView.d dVar = this.f52698d;
        if (dVar != null) {
            dVar.a();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
