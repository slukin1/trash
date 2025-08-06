package com.scwang.smartrefresh.layout.header.bezierradar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class WaveView extends View {

    /* renamed from: b  reason: collision with root package name */
    public int f29909b;

    /* renamed from: c  reason: collision with root package name */
    public int f29910c;

    /* renamed from: d  reason: collision with root package name */
    public Path f29911d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f29912e;

    /* renamed from: f  reason: collision with root package name */
    public int f29913f;

    public WaveView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public final void a() {
        this.f29911d = new Path();
        Paint paint = new Paint();
        this.f29912e = paint;
        paint.setColor(-14736346);
        this.f29912e.setAntiAlias(true);
    }

    public int getHeadHeight() {
        return this.f29910c;
    }

    public int getWaveHeight() {
        return this.f29909b;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        this.f29911d.reset();
        this.f29911d.lineTo(0.0f, (float) this.f29910c);
        Path path = this.f29911d;
        int i11 = this.f29913f;
        if (i11 < 0) {
            i11 = width / 2;
        }
        int i12 = this.f29910c;
        float f11 = (float) width;
        path.quadTo((float) i11, (float) (this.f29909b + i12), f11, (float) i12);
        this.f29911d.lineTo(f11, 0.0f);
        canvas.drawPath(this.f29911d, this.f29912e);
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i11), View.resolveSize(getSuggestedMinimumHeight(), i12));
    }

    public void setHeadHeight(int i11) {
        this.f29910c = i11;
    }

    public void setWaveColor(int i11) {
        this.f29912e.setColor(i11);
    }

    public void setWaveHeight(int i11) {
        this.f29909b = i11;
    }

    public void setWaveOffsetX(int i11) {
        this.f29913f = i11;
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f29913f = -1;
        a();
    }
}
