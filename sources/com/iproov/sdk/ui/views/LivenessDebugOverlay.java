package com.iproov.sdk.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class LivenessDebugOverlay extends View {

    /* renamed from: case  reason: not valid java name */
    private Paint f2360case;

    /* renamed from: do  reason: not valid java name */
    private Rect f2361do;

    /* renamed from: else  reason: not valid java name */
    private Paint f2362else;

    /* renamed from: for  reason: not valid java name */
    private Rect f2363for;

    /* renamed from: goto  reason: not valid java name */
    private Paint f2364goto;

    /* renamed from: if  reason: not valid java name */
    private Rect f2365if;

    /* renamed from: new  reason: not valid java name */
    private Rect f2366new;

    /* renamed from: try  reason: not valid java name */
    private Paint f2367try;

    public LivenessDebugOverlay(Context context) {
        super(context);
        m2217for();
    }

    /* renamed from: for  reason: not valid java name */
    private void m2217for() {
        Paint paint = m2216do();
        this.f2367try = paint;
        paint.setColor(-16711936);
        Paint paint2 = m2216do();
        this.f2360case = paint2;
        paint2.setColor(-65536);
        Paint paint3 = m2216do();
        this.f2364goto = paint3;
        paint3.setColor(-65281);
        Paint paint4 = m2216do();
        this.f2362else = paint4;
        paint4.setColor(-16776961);
    }

    /* renamed from: do  reason: not valid java name */
    public void m2218do(Rect rect) {
        this.f2363for = rect;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    /* renamed from: if  reason: not valid java name */
    public void m2221if(Rect rect) {
        this.f2361do = rect;
    }

    /* renamed from: new  reason: not valid java name */
    public void m2222new(Rect rect) {
        this.f2366new = rect;
    }

    public void onDraw(Canvas canvas) {
        Rect rect = this.f2361do;
        if (rect != null) {
            canvas.drawRect(rect, this.f2367try);
            canvas.drawCircle(this.f2361do.exactCenterX(), this.f2361do.exactCenterY(), 4.0f, this.f2367try);
        }
        Rect rect2 = this.f2365if;
        if (rect2 != null) {
            canvas.drawRect(rect2, this.f2360case);
            canvas.drawCircle(this.f2365if.exactCenterX(), this.f2365if.exactCenterY(), 4.0f, this.f2360case);
        }
        Rect rect3 = this.f2363for;
        if (rect3 != null) {
            canvas.drawRect(rect3, this.f2362else);
            canvas.drawCircle(this.f2363for.exactCenterX(), this.f2363for.exactCenterY(), 4.0f, this.f2362else);
        }
        Rect rect4 = this.f2366new;
        if (rect4 != null) {
            canvas.drawRect(rect4, this.f2364goto);
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static Paint m2216do() {
        Paint paint = new Paint();
        paint.setStrokeWidth(8.0f);
        paint.setStyle(Paint.Style.STROKE);
        return paint;
    }

    /* renamed from: if  reason: not valid java name */
    public void m2220if() {
        invalidate();
    }

    public LivenessDebugOverlay(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2217for();
    }

    public LivenessDebugOverlay(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        m2217for();
    }

    public LivenessDebugOverlay(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        m2217for();
    }

    /* renamed from: for  reason: not valid java name */
    public void m2219for(Rect rect) {
        this.f2365if = rect;
    }
}
