package com.huobi.view;

import android.content.Context;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.view.rollviewpager.hintview.AnimHintView;

public class WelcomeOldAnimHintView extends AnimHintView {
    public WelcomeOldAnimHintView(Context context) {
        super(context);
        setDotWidth(PixelUtils.a(79.0f));
        setDotHeight(PixelUtils.a(4.0f));
        setDotPadding(PixelUtils.a(0.0f));
    }
}
