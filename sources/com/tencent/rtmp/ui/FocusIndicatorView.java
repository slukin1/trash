package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.ScaleAnimation;

public class FocusIndicatorView extends View {

    /* renamed from: a  reason: collision with root package name */
    public final ScaleAnimation f48662a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f48663b;

    /* renamed from: c  reason: collision with root package name */
    private final int f48664c;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f48665d;

    public FocusIndicatorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onDraw(Canvas canvas) {
        int i11 = this.f48664c / 2;
        Rect rect = this.f48665d;
        rect.left = i11;
        rect.top = i11;
        rect.right = getWidth() - i11;
        this.f48665d.bottom = getHeight() - i11;
        canvas.drawRect(this.f48665d, this.f48663b);
    }

    public FocusIndicatorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FocusIndicatorView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f48665d = new Rect();
        int i12 = (int) ((getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
        this.f48664c = i12;
        Paint paint = new Paint();
        this.f48663b = paint;
        paint.setColor(-1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) i12);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 0.5f, 1, 0.5f);
        this.f48662a = scaleAnimation;
        scaleAnimation.setDuration(200);
    }
}
