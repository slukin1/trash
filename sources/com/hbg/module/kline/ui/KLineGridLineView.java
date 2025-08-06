package com.hbg.module.kline.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class KLineGridLineView extends View {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f23882b;

    /* renamed from: c  reason: collision with root package name */
    public int f23883c;

    /* renamed from: d  reason: collision with root package name */
    public int f23884d;

    /* renamed from: e  reason: collision with root package name */
    public int f23885e;

    public KLineGridLineView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int i11 = this.f23883c;
        int i12 = (height - i11) / this.f23885e;
        float f11 = (float) i11;
        canvas.drawLine(0.0f, f11, (float) getWidth(), f11, this.f23882b);
        for (int i13 = 0; i13 < this.f23885e - 1; i13++) {
            i11 += i12;
            float f12 = (float) i11;
            canvas.drawLine(0.0f, f12, (float) getWidth(), f12, this.f23882b);
        }
        int width = getWidth() / (this.f23884d + 1);
        int i14 = 0;
        for (int i15 = 0; i15 < this.f23884d; i15++) {
            i14 += width;
            float f13 = (float) i14;
            canvas.drawLine(f13, 0.0f, f13, (float) getHeight(), this.f23882b);
        }
    }

    public KLineGridLineView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f23882b = new Paint();
        this.f23884d = 3;
        this.f23885e = 5;
    }
}
