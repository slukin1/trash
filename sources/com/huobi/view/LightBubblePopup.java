package com.huobi.view;

import android.view.View;
import com.cpiz.android.bubbleview.BubbleStyle;
import com.cpiz.android.bubbleview.c;
import com.hbg.lib.common.utils.PixelUtils;

public class LightBubblePopup extends c {
    public LightBubblePopup(View view, BubbleStyle bubbleStyle, boolean z11) {
        super(view, bubbleStyle);
        float f11;
        if (z11) {
            f11 = 0.0f;
        } else {
            f11 = (float) PixelUtils.a(0.5f);
        }
        bubbleStyle.setBorderWidth(f11);
        setCancelOnTouch(true);
        setCancelOnTouchOutside(true);
    }
}
