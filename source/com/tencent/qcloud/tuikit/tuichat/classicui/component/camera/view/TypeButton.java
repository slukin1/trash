package com.tencent.qcloud.tuikit.tuichat.classicui.component.camera.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import com.huobi.view.roundimg.RoundedDrawable;

public class TypeButton extends View {
    public static final int TYPE_CANCEL = 1;
    public static final int TYPE_CONFIRM = 2;
    private float button_radius;
    private int button_size;
    private int button_type;
    private float center_X;
    private float center_Y;
    private float index;
    private Paint mPaint;
    private Path path;
    private RectF rectF;
    private float strokeWidth;

    public TypeButton(Context context) {
        super(context);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.button_type == 1) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-287515428);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(this.center_X, this.center_Y, this.button_radius, this.mPaint);
            this.mPaint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            Path path2 = this.path;
            float f11 = this.center_X;
            float f12 = this.index;
            path2.moveTo(f11 - (f12 / 7.0f), this.center_Y + f12);
            Path path3 = this.path;
            float f13 = this.center_X;
            float f14 = this.index;
            path3.lineTo(f13 + f14, this.center_Y + f14);
            this.path.arcTo(this.rectF, 90.0f, -180.0f);
            Path path4 = this.path;
            float f15 = this.center_X;
            float f16 = this.index;
            path4.lineTo(f15 - f16, this.center_Y - f16);
            canvas.drawPath(this.path, this.mPaint);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.path.reset();
            Path path5 = this.path;
            float f17 = this.center_X;
            float f18 = this.index;
            path5.moveTo(f17 - f18, (float) (((double) this.center_Y) - (((double) f18) * 1.5d)));
            Path path6 = this.path;
            float f19 = this.center_X;
            float f21 = this.index;
            path6.lineTo(f19 - f21, (float) (((double) this.center_Y) - (((double) f21) / 2.3d)));
            Path path7 = this.path;
            float f22 = this.index;
            path7.lineTo((float) (((double) this.center_X) - (((double) f22) * 1.6d)), this.center_Y - f22);
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
        }
        if (this.button_type == 2) {
            this.mPaint.setAntiAlias(true);
            this.mPaint.setColor(-1);
            this.mPaint.setStyle(Paint.Style.FILL);
            canvas.drawCircle(this.center_X, this.center_Y, this.button_radius, this.mPaint);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mPaint.setColor(-16724992);
            this.mPaint.setStrokeWidth(this.strokeWidth);
            this.path.moveTo(this.center_X - (((float) this.button_size) / 6.0f), this.center_Y);
            Path path8 = this.path;
            float f23 = this.center_X;
            int i11 = this.button_size;
            path8.lineTo(f23 - (((float) i11) / 21.2f), this.center_Y + (((float) i11) / 7.7f));
            Path path9 = this.path;
            float f24 = this.center_X;
            int i12 = this.button_size;
            path9.lineTo(f24 + (((float) i12) / 4.0f), this.center_Y - (((float) i12) / 8.5f));
            Path path10 = this.path;
            float f25 = this.center_X;
            int i13 = this.button_size;
            path10.lineTo(f25 - (((float) i13) / 21.2f), this.center_Y + (((float) i13) / 9.4f));
            this.path.close();
            canvas.drawPath(this.path, this.mPaint);
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int i13 = this.button_size;
        setMeasuredDimension(i13, i13);
    }

    public TypeButton(Context context, int i11, int i12) {
        super(context);
        this.button_type = i11;
        this.button_size = i12;
        float f11 = (float) i12;
        float f12 = f11 / 2.0f;
        this.button_radius = f12;
        this.center_X = f12;
        this.center_Y = f12;
        this.mPaint = new Paint();
        this.path = new Path();
        this.strokeWidth = f11 / 50.0f;
        this.index = ((float) this.button_size) / 12.0f;
        float f13 = this.center_X;
        float f14 = this.center_Y;
        float f15 = this.index;
        this.rectF = new RectF(f13, f14 - f15, (2.0f * f15) + f13, f14 + f15);
    }
}
