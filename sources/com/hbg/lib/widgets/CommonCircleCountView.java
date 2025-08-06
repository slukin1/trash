package com.hbg.lib.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CommonCircleCountView extends View {

    /* renamed from: b  reason: collision with root package name */
    public final Paint f71070b;

    /* renamed from: c  reason: collision with root package name */
    public int f71071c;

    /* renamed from: d  reason: collision with root package name */
    public int f71072d;

    /* renamed from: e  reason: collision with root package name */
    public int f71073e;

    public CommonCircleCountView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onDraw(Canvas canvas) {
        int i11;
        int i12;
        super.onDraw(canvas);
        if (this.f71071c > 0) {
            int width = (getWidth() - (this.f71072d * 2)) / (this.f71071c - 1);
            int i13 = 0;
            int i14 = 0;
            while (true) {
                int i15 = this.f71071c;
                if (i13 < i15) {
                    if (i13 == 0) {
                        i12 = this.f71073e;
                        i11 = 0;
                    } else if (i13 == i15 - 1) {
                        i11 = this.f71073e;
                        i12 = 0;
                    } else {
                        i12 = 0;
                        i11 = 0;
                    }
                    canvas.drawCircle((float) (((i12 + this.f71072d) + i14) - i11), (float) (getHeight() >> 1), (float) this.f71072d, this.f71070b);
                    i14 += width;
                    i13++;
                } else {
                    return;
                }
            }
        }
    }

    public void setCount(int i11) {
        this.f71071c = i11;
        invalidate();
    }

    public CommonCircleCountView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CommonCircleCountView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Paint paint = new Paint();
        this.f71070b = paint;
        this.f71071c = 5;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setColor(getResources().getColor(R$color.global_seek_bar_circle_color));
        this.f71072d = getResources().getDimensionPixelOffset(R$dimen.dimen_2_5);
        this.f71073e = getResources().getDimensionPixelOffset(R$dimen.dimen_1_5);
    }
}
