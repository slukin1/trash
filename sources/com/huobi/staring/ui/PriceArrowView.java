package com.huobi.staring.ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.hbg.lib.core.util.w;
import pro.huobi.R;

public class PriceArrowView extends AppCompatImageView {
    public PriceArrowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void c(boolean z11) {
        int i11;
        int i12;
        if (w.l()) {
            i12 = R.drawable.alert_arrow_red;
            i11 = R.drawable.alert_down_green;
        } else {
            i12 = R.drawable.alert_arrow_green;
            i11 = R.drawable.alert_down_red;
        }
        if (z11) {
            setImageResource(i12);
        } else {
            setImageResource(i11);
        }
        invalidate();
    }

    public PriceArrowView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(true);
    }
}
