package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CornerImageView extends ImageView {

    /* renamed from: b  reason: collision with root package name */
    public final Path f71332b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f71333c;

    /* renamed from: d  reason: collision with root package name */
    public int f71334d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f71335e;

    public CornerImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onDraw(Canvas canvas) {
        if (this.f71334d > 0) {
            this.f71333c.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f71332b.addRoundRect(this.f71333c, this.f71335e, Path.Direction.CCW);
            try {
                canvas.clipPath(this.f71332b);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        super.onDraw(canvas);
    }

    public CornerImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71332b = new Path();
        this.f71333c = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CornerImageView, i11, 0);
        this.f71334d = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CornerImageView_img_corner_radius, 0);
        obtainStyledAttributes.recycle();
        int i12 = this.f71334d;
        this.f71335e = new float[]{(float) i12, (float) i12, (float) i12, (float) i12, (float) i12, (float) i12, (float) i12, (float) i12};
    }
}
