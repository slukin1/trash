package com.huobi.view.showcaseview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import pro.huobi.R;

class NewShowcaseDrawer extends StandardShowcaseDrawer {
    private static final int ALPHA_60_PERCENT = 153;
    private final float innerRadius;
    private final float outerRadius;

    public NewShowcaseDrawer(Resources resources, Resources.Theme theme) {
        super(resources, theme);
        this.outerRadius = resources.getDimension(R.dimen.dimen_128);
        this.innerRadius = resources.getDimension(R.dimen.dimen_96);
    }

    public void drawShowcase(Bitmap bitmap, float f11, float f12, float f13) {
        Canvas canvas = new Canvas(bitmap);
        this.eraserPaint.setAlpha(153);
        canvas.drawCircle(f11, f12, this.outerRadius, this.eraserPaint);
        this.eraserPaint.setAlpha(0);
        canvas.drawCircle(f11, f12, this.innerRadius, this.eraserPaint);
    }

    public float getBlockedRadius() {
        return this.innerRadius;
    }

    public int getShowcaseHeight() {
        return (int) (this.outerRadius * 2.0f);
    }

    public int getShowcaseWidth() {
        return (int) (this.outerRadius * 2.0f);
    }

    public void setShowcaseColour(int i11) {
        this.eraserPaint.setColor(i11);
    }
}
