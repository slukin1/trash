package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.hbg.module.otc.R$layout;

public class OtcOperation1000uBannerView extends RelativeLayout {
    public OtcOperation1000uBannerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public OtcOperation1000uBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.otc_operation_1000u_banner_view, this);
    }
}
