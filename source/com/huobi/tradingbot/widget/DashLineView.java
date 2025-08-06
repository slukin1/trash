package com.huobi.tradingbot.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.component.kline.utils.DimenUtils;
import pro.huobi.R;

public class DashLineView extends View {

    /* renamed from: b  reason: collision with root package name */
    public Paint f83637b;

    public DashLineView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        Paint paint = new Paint();
        this.f83637b = paint;
        paint.setAntiAlias(true);
        this.f83637b.setDither(true);
        this.f83637b.setStyle(Paint.Style.STROKE);
        this.f83637b.setStrokeWidth((float) DimenUtils.a(0.6f));
        this.f83637b.setColor(context.getColor(R.color.kColorThreeLevelText));
        this.f83637b.setPathEffect(new DashPathEffect(new float[]{(float) DimenUtils.a(1.5f), (float) DimenUtils.a(1.5f)}, 0.0f));
    }

    public void b(int i11, int i12, float f11, float f12) {
        this.f83637b.setStrokeWidth((float) i11);
        this.f83637b.setColor(i12);
        this.f83637b.setPathEffect(new DashPathEffect(new float[]{f11, f12}, 0.0f));
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine((float) getPaddingLeft(), (float) getPaddingTop(), (float) (getWidth() - getPaddingRight()), (float) getPaddingTop(), this.f83637b);
    }

    public DashLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public DashLineView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet);
    }
}
