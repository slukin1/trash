package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;

public class FoucsView extends View {
    private int center_x;
    private int center_y;
    private int length;
    private Paint mPaint;
    private int size;

    public FoucsView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i11 = this.center_x;
        int i12 = this.length;
        int i13 = this.center_y;
        Canvas canvas2 = canvas;
        canvas2.drawRect((float) (i11 - i12), (float) (i13 - i12), (float) (i11 + i12), (float) (i13 + i12), this.mPaint);
        canvas.drawLine(2.0f, (float) (getHeight() / 2), (float) (this.size / 10), (float) (getHeight() / 2), this.mPaint);
        Canvas canvas3 = canvas;
        canvas3.drawLine((float) (getWidth() - 2), (float) (getHeight() / 2), (float) (getWidth() - (this.size / 10)), (float) (getHeight() / 2), this.mPaint);
        canvas3.drawLine((float) (getWidth() / 2), 2.0f, (float) (getWidth() / 2), (float) (this.size / 10), this.mPaint);
        canvas.drawLine((float) (getWidth() / 2), (float) (getHeight() - 2), (float) (getWidth() / 2), (float) (getHeight() - (this.size / 10)), this.mPaint);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int i13 = this.size;
        this.center_x = (int) (((double) i13) / 2.0d);
        this.center_y = (int) (((double) i13) / 2.0d);
        this.length = ((int) (((double) i13) / 2.0d)) - 2;
        setMeasuredDimension(i13, i13);
    }

    public FoucsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FoucsView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.size = ScreenUtil.getScreenWidth(context) / 3;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setColor(-300503530);
        this.mPaint.setStrokeWidth(4.0f);
        this.mPaint.setStyle(Paint.Style.STROKE);
    }
}
