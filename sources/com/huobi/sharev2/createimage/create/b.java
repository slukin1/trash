package com.huobi.sharev2.createimage.create;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;

public class b extends Drawable {

    /* renamed from: a  reason: collision with root package name */
    public final CanvasImageReady f81055a;

    /* renamed from: b  reason: collision with root package name */
    public final Paint f81056b;

    /* renamed from: c  reason: collision with root package name */
    public final TextPaint f81057c;

    static {
        Class<b> cls = b.class;
    }

    public b(CanvasImageReady canvasImageReady) {
        this.f81055a = canvasImageReady;
        Paint paint = new Paint(1);
        this.f81056b = paint;
        paint.setAntiAlias(true);
        TextPaint textPaint = new TextPaint();
        this.f81057c = textPaint;
        textPaint.setAntiAlias(true);
    }

    public void a(Canvas canvas) {
        if (this.f81055a.b() != null) {
            canvas.drawColor(Color.parseColor(this.f81055a.b()));
        }
    }

    public final void b(Canvas canvas) {
        this.f81055a.a().a();
    }

    public void draw(Canvas canvas) {
        a(canvas);
        b(canvas);
    }

    public int getIntrinsicHeight() {
        return this.f81055a.c();
    }

    public int getIntrinsicWidth() {
        return this.f81055a.d();
    }

    public int getOpacity() {
        return -2;
    }

    public void setAlpha(int i11) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
