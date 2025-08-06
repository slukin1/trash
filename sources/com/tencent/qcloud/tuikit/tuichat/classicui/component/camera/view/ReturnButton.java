package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class ReturnButton extends View {
    private int center_X;
    private int center_Y;
    private Paint paint;
    public Path path;
    private int size;
    private float strokeWidth;

    public ReturnButton(Context context, int i11) {
        this(context);
        this.size = i11;
        int i12 = i11 / 2;
        this.center_X = i12;
        this.center_Y = i12;
        this.strokeWidth = ((float) i11) / 15.0f;
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setAntiAlias(true);
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(this.strokeWidth);
        this.path = new Path();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path2 = this.path;
        float f11 = this.strokeWidth;
        path2.moveTo(f11, f11 / 2.0f);
        this.path.lineTo((float) this.center_X, ((float) this.center_Y) - (this.strokeWidth / 2.0f));
        Path path3 = this.path;
        float f12 = this.strokeWidth;
        path3.lineTo(((float) this.size) - f12, f12 / 2.0f);
        canvas.drawPath(this.path, this.paint);
    }

    public void onMeasure(int i11, int i12) {
        int i13 = this.size;
        setMeasuredDimension(i13, i13 / 2);
    }

    public ReturnButton(Context context) {
        super(context);
    }
}
