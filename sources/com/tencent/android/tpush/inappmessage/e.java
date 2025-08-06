package com.tencent.android.tpush.inappmessage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import com.huobi.view.roundimg.RoundedDrawable;

public class e extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f69374a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    private Paint f69375b = new Paint();

    /* renamed from: c  reason: collision with root package name */
    private Paint f69376c = new Paint();

    /* renamed from: d  reason: collision with root package name */
    private float f69377d;

    /* renamed from: e  reason: collision with root package name */
    private float f69378e;

    /* renamed from: f  reason: collision with root package name */
    private float f69379f;

    /* renamed from: g  reason: collision with root package name */
    private float f69380g;

    /* renamed from: h  reason: collision with root package name */
    private float f69381h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f69382i = false;

    public e(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f69374a.setAntiAlias(true);
        this.f69374a.setColor(-2236963);
        this.f69374a.setStrokeWidth(2.0f);
        this.f69374a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f69375b.setAntiAlias(true);
        this.f69375b.setColor(-6710887);
        this.f69375b.setStrokeWidth(2.0f);
        this.f69375b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f69376c.setAntiAlias(true);
        this.f69376c.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.f69376c.setStrokeWidth(3.0f);
        this.f69376c.setStyle(Paint.Style.FILL_AND_STROKE);
        float f11 = (float) SizeUtil.dp30;
        this.f69377d = f11;
        this.f69378e = f11 * 0.33333334f;
        this.f69380g = f11 * 0.6666667f;
        this.f69379f = 0.33333334f * f11;
        this.f69381h = f11 * 0.6666667f;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, (((float) getWidth()) / 2.0f) - 1.0f, this.f69382i ? this.f69375b : this.f69374a);
        canvas.drawLine(this.f69378e, this.f69379f, this.f69380g, this.f69381h, this.f69376c);
        canvas.drawLine(this.f69380g, this.f69379f, this.f69378e, this.f69381h, this.f69376c);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i11);
        float f11 = this.f69377d;
        setMeasuredDimension((int) f11, (int) f11);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f69382i = true;
            invalidate();
            return true;
        } else if (motionEvent.getAction() != 1) {
            return super.onTouchEvent(motionEvent);
        } else {
            this.f69382i = false;
            invalidate();
            performClick();
            return true;
        }
    }

    public boolean performClick() {
        return super.performClick();
    }
}
