package com.huobi.view.showcaseview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import pro.huobi.R;

public class MaterialShowcaseDrawer implements ShowcaseDrawer {
    private int backgroundColor;
    private final Paint basicPaint = new Paint();
    private final Paint eraserPaint;
    private final float radius;

    public MaterialShowcaseDrawer(Resources resources) {
        this.radius = resources.getDimension(R.dimen.showcase_radius_material);
        Paint paint = new Paint();
        this.eraserPaint = paint;
        paint.setColor(FlexItem.MAX_SIZE);
        paint.setAlpha(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        paint.setAntiAlias(true);
    }

    public void drawShowcase(Bitmap bitmap, float f11, float f12, float f13) {
        new Canvas(bitmap).drawCircle(f11, f12, this.radius, this.eraserPaint);
    }

    public void drawToCanvas(Canvas canvas, Bitmap bitmap) {
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.basicPaint);
    }

    public void erase(Bitmap bitmap) {
        bitmap.eraseColor(this.backgroundColor);
    }

    public float getBlockedRadius() {
        return this.radius;
    }

    public int getShowcaseHeight() {
        return (int) (this.radius * 2.0f);
    }

    public int getShowcaseWidth() {
        return (int) (this.radius * 2.0f);
    }

    public void setBackgroundColour(int i11) {
        this.backgroundColor = i11;
    }

    public void setShowcaseColour(int i11) {
    }
}
