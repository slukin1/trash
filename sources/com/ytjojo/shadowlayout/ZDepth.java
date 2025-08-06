package com.ytjojo.shadowlayout;

import android.content.Context;
import android.graphics.Color;
import com.ytjojo.shadowlayout.utils.DisplayUtils;

public enum ZDepth {
    Depth0(0, 0, 0.0f, 0.0f, 0.0f, 0.0f),
    Depth1(28, 50, 1.0f, 1.0f, 1.5f, 1.0f),
    Depth2(40, 58, 3.0f, 3.0f, 3.0f, 3.0f),
    Depth3(48, 58, 10.0f, 6.0f, 10.0f, 3.0f),
    Depth4(64, 56, 14.0f, 10.0f, 14.0f, 5.0f),
    Depth5(76, 56, 19.0f, 15.0f, 19.0f, 6.0f),
    Depth6(80, 58, 26.0f, 19.0f, 23.0f, 7.0f);
    
    public int mAlphaBottomShadow;
    public int mAlphaTopShadow;
    public final float mBlurBottomShadow;
    public float mBlurBottomShadowPx;
    public final float mBlurTopShadow;
    public float mBlurTopShadowPx;
    public final float mOffsetYBottomShadow;
    public float mOffsetYBottomShadowPx;
    public final float mOffsetYTopShadow;
    public float mOffsetYTopShadowPx;

    private ZDepth(int i11, int i12, float f11, float f12, float f13, float f14) {
        this.mAlphaTopShadow = i11;
        this.mAlphaBottomShadow = i12;
        this.mOffsetYTopShadow = f11;
        this.mOffsetYBottomShadow = f12;
        this.mBlurTopShadow = f13;
        this.mBlurBottomShadow = f14;
    }

    public int getAlphaBottomShadow() {
        return this.mAlphaBottomShadow;
    }

    public int getAlphaTopShadow() {
        return this.mAlphaTopShadow;
    }

    public float getBlurBottomShadowPx(Context context) {
        return (float) DisplayUtils.a(context, this.mBlurBottomShadow);
    }

    public float getBlurTopShadowPx(Context context) {
        return (float) DisplayUtils.a(context, this.mBlurTopShadow);
    }

    public int getColorBottomShadow() {
        return Color.argb(this.mAlphaBottomShadow, 0, 0, 0);
    }

    public int getColorTopShadow() {
        return Color.argb(this.mAlphaTopShadow, 0, 0, 0);
    }

    public float getOffsetYBottomShadowPx(Context context) {
        return (float) DisplayUtils.a(context, this.mOffsetYBottomShadow);
    }

    public float getOffsetYTopShadowPx(Context context) {
        return (float) DisplayUtils.a(context, this.mOffsetYTopShadow);
    }

    public void initZDepth(Context context) {
        this.mOffsetYTopShadowPx = getOffsetYTopShadowPx(context);
        this.mOffsetYBottomShadowPx = getOffsetYBottomShadowPx(context);
        this.mBlurTopShadowPx = getBlurTopShadowPx(context);
        this.mBlurBottomShadowPx = getBlurBottomShadowPx(context);
    }
}
