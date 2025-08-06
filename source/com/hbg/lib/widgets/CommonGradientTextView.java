package com.hbg.lib.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

public class CommonGradientTextView extends TextView {

    /* renamed from: b  reason: collision with root package name */
    public int[] f71104b;

    /* renamed from: c  reason: collision with root package name */
    public LinearGradient f71105c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f71106d;

    /* renamed from: e  reason: collision with root package name */
    public int f71107e;

    /* renamed from: f  reason: collision with root package name */
    public int f71108f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f71109g;

    public CommonGradientTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onDraw(Canvas canvas) {
        this.f71107e = getMeasuredWidth();
        this.f71108f = getMeasuredHeight();
        this.f71106d = getPaint();
        String charSequence = getText().toString();
        this.f71106d.getTextBounds(charSequence, 0, charSequence.length(), this.f71109g);
        if (this.f71105c == null) {
            this.f71105c = new LinearGradient(0.0f, 0.0f, 0.0f, (float) this.f71108f, this.f71104b, new float[]{0.0f, 0.3f, 0.6f, 1.0f}, Shader.TileMode.CLAMP);
        }
        this.f71106d.setShader(this.f71105c);
        super.onDraw(canvas);
    }

    public void setColors(int[] iArr) {
        this.f71104b = iArr;
    }

    public CommonGradientTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71104b = new int[]{-26349, -36340, -38646, -51456};
        this.f71107e = 0;
        this.f71108f = 0;
        this.f71109g = new Rect();
    }
}
