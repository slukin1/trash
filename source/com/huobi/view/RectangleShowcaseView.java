package com.huobi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.huobi.view.showcaseview.ShowcaseDrawer;
import pro.huobi.R;

public class RectangleShowcaseView implements ShowcaseDrawer {
    private final Paint basicPaint;
    private Context context;
    private final int eraseColour;
    private final Paint eraserPaint;
    private final float height;
    private int padding;
    private final RectF renderRect;
    private final float width;

    public RectangleShowcaseView(View view) {
        this(view, 0);
    }

    public void drawShowcase(Bitmap bitmap, float f11, float f12, float f13) {
        Canvas canvas = new Canvas(bitmap);
        RectF rectF = this.renderRect;
        float f14 = this.width;
        int i11 = this.padding;
        rectF.left = (f11 - (f14 / 2.0f)) - ((float) i11);
        rectF.right = f11 + (f14 / 2.0f) + ((float) i11);
        float f15 = this.height;
        rectF.top = (f12 - (f15 / 2.0f)) - ((float) i11);
        rectF.bottom = f12 + (f15 / 2.0f) + ((float) i11);
        float dimension = (float) ((int) this.context.getResources().getDimension(R.dimen.dimen_2));
        canvas.drawRoundRect(this.renderRect, dimension, dimension, this.eraserPaint);
    }

    public void drawToCanvas(Canvas canvas, Bitmap bitmap) {
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.basicPaint);
    }

    public void erase(Bitmap bitmap) {
        bitmap.eraseColor(this.eraseColour);
    }

    public float getBlockedRadius() {
        return this.width;
    }

    public int getShowcaseHeight() {
        return (int) this.height;
    }

    public int getShowcaseWidth() {
        return (int) this.width;
    }

    public void setBackgroundColour(int i11) {
    }

    public void setShowcaseColour(int i11) {
    }

    public RectangleShowcaseView(View view, int i11) {
        this.context = view.getContext();
        this.width = (float) view.getWidth();
        this.height = (float) view.getHeight();
        Paint paint = new Paint();
        this.eraserPaint = paint;
        paint.setColor(FlexItem.MAX_SIZE);
        paint.setAlpha(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        this.eraseColour = ContextCompat.getColor(this.context, R.color.case_view_bg);
        this.basicPaint = new Paint();
        this.renderRect = new RectF();
        this.padding = i11;
    }
}
