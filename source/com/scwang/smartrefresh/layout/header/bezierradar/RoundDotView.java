package com.scwang.smartrefresh.layout.header.bezierradar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.scwang.smartrefresh.layout.util.DensityUtil;

public class RoundDotView extends View {

    /* renamed from: b  reason: collision with root package name */
    public int f29896b = 7;

    /* renamed from: c  reason: collision with root package name */
    public Paint f29897c;

    /* renamed from: d  reason: collision with root package name */
    public float f29898d;

    /* renamed from: e  reason: collision with root package name */
    public float f29899e;

    public RoundDotView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f29897c = paint;
        paint.setAntiAlias(true);
        this.f29897c.setColor(-1);
        this.f29898d = (float) DensityUtil.b(7.0f);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i11 = this.f29896b;
        float f11 = this.f29899e;
        float f12 = 0.0f;
        float f13 = (((float) (width / i11)) * f11) - (f11 > 1.0f ? ((f11 - 1.0f) * ((float) (width / i11))) / f11 : 0.0f);
        float f14 = (float) height;
        float f15 = 2.0f;
        if (f11 > 1.0f) {
            f12 = (((f11 - 1.0f) * f14) / 2.0f) / f11;
        }
        float f16 = f14 - f12;
        int i12 = 0;
        while (true) {
            int i13 = this.f29896b;
            if (i12 < i13) {
                float f17 = (((float) i12) + 1.0f) - ((((float) i13) + 1.0f) / f15);
                float c11 = DensityUtil.c(height);
                this.f29897c.setAlpha((int) (((double) ((1.0f - ((Math.abs(f17) / ((float) this.f29896b)) * f15)) * 255.0f)) * (1.0d - (1.0d / Math.pow((((double) c11) / 800.0d) + 1.0d, 15.0d)))));
                float f18 = this.f29898d * (1.0f - (1.0f / ((c11 / 10.0f) + 1.0f)));
                canvas.drawCircle((((float) (width / 2)) - (f18 / 2.0f)) + (f17 * f13), f16 / 2.0f, f18, this.f29897c);
                i12++;
                f15 = 2.0f;
            } else {
                return;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i11), View.resolveSize(getSuggestedMinimumHeight(), i12));
    }

    public void setDotColor(int i11) {
        this.f29897c.setColor(i11);
    }

    public void setFraction(float f11) {
        this.f29899e = f11;
    }
}
