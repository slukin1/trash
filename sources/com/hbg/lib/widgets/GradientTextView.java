package com.hbg.lib.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class GradientTextView extends AppCompatTextView {

    /* renamed from: b  reason: collision with root package name */
    public int[] f71386b;

    /* renamed from: c  reason: collision with root package name */
    public float[] f71387c;

    /* renamed from: d  reason: collision with root package name */
    public LinearGradient f71388d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f71389e;

    /* renamed from: f  reason: collision with root package name */
    public int f71390f;

    /* renamed from: g  reason: collision with root package name */
    public int f71391g;

    /* renamed from: h  reason: collision with root package name */
    public Rect f71392h;

    public GradientTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public int[] getColors() {
        return this.f71386b;
    }

    public float[] getPercents() {
        return this.f71387c;
    }

    public void onDraw(Canvas canvas) {
        this.f71390f = getMeasuredWidth();
        this.f71391g = getMeasuredHeight();
        this.f71389e = getPaint();
        String charSequence = getText().toString();
        this.f71389e.getTextBounds(charSequence, 0, charSequence.length(), this.f71392h);
        if (this.f71388d == null) {
            this.f71388d = new LinearGradient(0.0f, 0.0f, (float) this.f71390f, (float) this.f71391g, this.f71386b, this.f71387c, Shader.TileMode.CLAMP);
        }
        this.f71389e.setShader(this.f71388d);
        super.onDraw(canvas);
    }

    public void setColors(int[] iArr) {
        this.f71386b = iArr;
    }

    public void setPercents(float[] fArr) {
        this.f71387c = fArr;
    }

    public GradientTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f71390f = 0;
        this.f71391g = 0;
        this.f71392h = new Rect();
    }
}
