package com.huobi.view.rollviewpager.hintview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import com.hbg.lib.common.utils.PixelUtils;

public class ColorPointHintView extends ShapeHintView {
    private int focusColor;
    private int normalColor;

    public ColorPointHintView(Context context, int i11, int i12) {
        super(context);
        this.focusColor = i11;
        this.normalColor = i12;
    }

    public Drawable makeFocusDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.focusColor);
        gradientDrawable.setCornerRadius((float) PixelUtils.a(4.0f));
        gradientDrawable.setSize(PixelUtils.a(8.0f), PixelUtils.a(8.0f));
        return gradientDrawable;
    }

    public Drawable makeNormalDrawable() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.normalColor);
        gradientDrawable.setCornerRadius((float) PixelUtils.a(4.0f));
        gradientDrawable.setSize(PixelUtils.a(8.0f), PixelUtils.a(8.0f));
        return gradientDrawable;
    }
}
