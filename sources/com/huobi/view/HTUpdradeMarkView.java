package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.util.NightHelper;
import com.hbg.lib.network.hbg.core.bean.HTUpgradeConfig;
import com.hbg.module.kline.KLineHelper;
import com.hbg.module.kline.ui.MarketInfoActivity;
import com.huobi.utils.HBHTtoHTXManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import pro.huobi.R;

public class HTUpdradeMarkView extends FrameLayout {
    private TextView displayDescription;
    private TextView displayFirstName;
    private ImageView displayIcon;
    private TextView displayJumpName;
    private boolean isLight;
    private View mRootView;

    public HTUpdradeMarkView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.layout_ht_upgrade_mark, this, true);
        setId(R.id.ht_upgrade_mark_view);
        this.displayIcon = (ImageView) this.mRootView.findViewById(R.id.displayIcon);
        this.displayFirstName = (TextView) this.mRootView.findViewById(R.id.displayFirstName);
        this.displayDescription = (TextView) this.mRootView.findViewById(R.id.displayDescription);
        this.displayJumpName = (TextView) this.mRootView.findViewById(R.id.displayJumpName);
        if (context instanceof MarketInfoActivity) {
            this.isLight = KLineHelper.f();
            this.mRootView.findViewById(R.id.ht_upgrade_mark_content).setPadding(0, PixelUtils.a(160.0f), 0, 0);
            View view = new View(context);
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.kline_activity_background_color, typedValue, true);
            view.setBackgroundColor(typedValue.data);
            addView(view, 0, new FrameLayout.LayoutParams(-1, PixelUtils.a(16.0f)));
        } else {
            this.isLight = !NightHelper.e().g();
        }
        refreshView();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$refreshView$0(View view) {
        HBHTtoHTXManager.f83692a.i();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void refreshView() {
        HTUpgradeConfig d11 = HBHTtoHTXManager.f83692a.d();
        if (d11 != null) {
            b.c().h(this.displayIcon, this.isLight ? d11.getDisplayIcon() : d11.getDisplayIconNight());
            this.displayFirstName.setText(d11.getDisplayFirstName());
            this.displayDescription.setText(d11.getDisplayDescription());
            this.displayJumpName.setText(d11.getDisplayJumpName());
            this.displayJumpName.setOnClickListener(f0.f19030b);
        }
    }

    public HTUpdradeMarkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public HTUpdradeMarkView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context);
    }
}
