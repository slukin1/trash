package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CornerConstraintLayout extends ConstraintLayout {

    /* renamed from: b  reason: collision with root package name */
    public final Path f71328b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f71329c;

    /* renamed from: d  reason: collision with root package name */
    public int f71330d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f71331e;

    public CornerConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onDraw(Canvas canvas) {
        if (this.f71330d > 0) {
            this.f71329c.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f71328b.addRoundRect(this.f71329c, this.f71331e, Path.Direction.CCW);
            try {
                canvas.clipPath(this.f71328b);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        super.onDraw(canvas);
    }

    public CornerConstraintLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71328b = new Path();
        this.f71329c = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CornerConstraintLayout, i11, 0);
        this.f71330d = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.CornerConstraintLayout_constraint_corner_radius, 0);
        obtainStyledAttributes.recycle();
        int i12 = this.f71330d;
        this.f71331e = new float[]{(float) i12, (float) i12, (float) i12, (float) i12, (float) i12, (float) i12, (float) i12, (float) i12};
        setWillNotDraw(false);
    }
}
