package com.huobi.view.showcaseview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import pro.huobi.R;

class StandardShowcaseDrawer implements ShowcaseDrawer {
    public int backgroundColour;
    private final Paint basicPaint = new Paint();
    public final Paint eraserPaint;
    public final Drawable showcaseDrawable;
    private final float showcaseRadius;

    public StandardShowcaseDrawer(Resources resources, Resources.Theme theme) {
        PorterDuffXfermode porterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
        Paint paint = new Paint();
        this.eraserPaint = paint;
        paint.setColor(FlexItem.MAX_SIZE);
        paint.setAlpha(0);
        paint.setXfermode(porterDuffXfermode);
        paint.setAntiAlias(true);
        this.showcaseRadius = resources.getDimension(R.dimen.dimen_94);
        this.showcaseDrawable = ResourcesCompat.f(resources, R.drawable.cling_bleached, theme);
    }

    public void drawShowcase(Bitmap bitmap, float f11, float f12, float f13) {
        Canvas canvas = new Canvas(bitmap);
        canvas.drawCircle(f11, f12, this.showcaseRadius, this.eraserPaint);
        int showcaseWidth = (int) (f11 - ((float) (getShowcaseWidth() / 2)));
        int showcaseHeight = (int) (f12 - ((float) (getShowcaseHeight() / 2)));
        this.showcaseDrawable.setBounds(showcaseWidth, showcaseHeight, getShowcaseWidth() + showcaseWidth, getShowcaseHeight() + showcaseHeight);
        this.showcaseDrawable.draw(canvas);
    }

    public void drawToCanvas(Canvas canvas, Bitmap bitmap) {
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.basicPaint);
    }

    public void erase(Bitmap bitmap) {
        bitmap.eraseColor(this.backgroundColour);
    }

    public float getBlockedRadius() {
        return this.showcaseRadius;
    }

    public int getShowcaseHeight() {
        return this.showcaseDrawable.getIntrinsicHeight();
    }

    public int getShowcaseWidth() {
        return this.showcaseDrawable.getIntrinsicWidth();
    }

    public void setBackgroundColour(int i11) {
        this.backgroundColour = i11;
    }

    public void setShowcaseColour(int i11) {
        this.showcaseDrawable.setColorFilter(i11, PorterDuff.Mode.MULTIPLY);
    }
}
