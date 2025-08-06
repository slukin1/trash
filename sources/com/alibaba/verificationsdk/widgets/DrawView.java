package com.alibaba.verificationsdk.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

public class DrawView extends View {
    public static final int STATUS_END = 3;
    public static final int STATUS_FINISH = 2;
    public static final int STATUS_IN_BOUND = 1;
    public static final int STATUS_START = 0;
    private Bitmap[] bitmap = new Bitmap[10];
    private Bitmap bitmap1 = null;
    private Bitmap bitmap2 = null;
    private float boundaryX = 0.0f;
    private float boundaryY = 0.0f;
    private float centerX = 0.0f;
    private float centerX1 = 0.0f;
    private float centerY = 0.0f;
    private float centerY1 = 0.0f;
    private float currentX = 40.0f;
    private float currentY = 50.0f;
    private int mScreenHeight = 0;
    private int mScreenWidth = 0;
    private Paint paint = null;
    private float radius = 120.0f;
    private float radiusInner = 60.0f;
    private float radiusInner1 = 80.0f;
    private int status = 0;

    public DrawView(Context context) {
        super(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        this.mScreenWidth = displayMetrics.widthPixels;
        this.mScreenHeight = displayMetrics.heightPixels;
        this.bitmap2 = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("ali_vsdk_frame1", "drawable", context.getPackageName()));
        this.bitmap[0] = BitmapFactory.decodeResource(getResources(), getResources().getIdentifier("ali_vsdk_frame", "drawable", context.getPackageName()));
        Bitmap bitmap3 = this.bitmap[0];
        this.bitmap1 = bitmap3;
        this.radius = (float) (bitmap3.getWidth() / 2);
        this.radiusInner = (float) (this.bitmap1.getWidth() / 2);
        this.radiusInner1 = (float) (this.bitmap1.getWidth() / 2);
        this.paint = new Paint();
        float f11 = this.radius;
        initPostion(((float) this.mScreenWidth) - f11, f11);
    }

    public float getBoundaryBottom() {
        return this.boundaryY + (this.radiusInner * 2.0f);
    }

    public float getBoundaryLeft() {
        return this.boundaryX;
    }

    public float getBoundaryRight() {
        return this.boundaryX + (this.radiusInner * 2.0f);
    }

    public float getBoundaryTop() {
        return this.boundaryY;
    }

    public float getCenterX() {
        return this.centerX;
    }

    public float getCenterX1() {
        return this.centerX1;
    }

    public float getCenterY() {
        return this.centerY;
    }

    public float getCenterY1() {
        return this.centerY1;
    }

    public float getRadius() {
        return this.radius;
    }

    public int getStatus() {
        return this.status;
    }

    public void initPostion(float f11, float f12) {
        setStatus(0);
        this.currentX = f11;
        this.currentY = f12;
        Bitmap bitmap3 = this.bitmap[0];
        this.bitmap1 = bitmap3;
        this.centerX = ((float) (bitmap3.getWidth() / 2)) + this.currentX;
        this.centerY = ((float) (this.bitmap1.getHeight() / 2)) + this.currentY;
        this.centerX1 = ((float) (this.bitmap1.getWidth() / 2)) + this.currentX;
        float f13 = this.currentY;
        this.centerY1 = ((float) (this.bitmap1.getHeight() / 2)) + f13;
        float f14 = this.currentX;
        float f15 = this.radius;
        float f16 = this.radiusInner;
        this.boundaryX = (f14 + f15) - f16;
        this.boundaryY = (f13 + f15) - f16;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i11 = this.status;
        if (i11 == 0) {
            Bitmap bitmap3 = this.bitmap1;
            float f11 = this.currentX;
            float f12 = this.radius;
            float f13 = this.radiusInner1;
            canvas.drawBitmap(bitmap3, (f11 + f12) - f13, (this.currentY + f12) - f13, this.paint);
        } else if (i11 == 1) {
            Bitmap bitmap4 = this.bitmap2;
            float f14 = this.currentX;
            float f15 = this.radius;
            float f16 = this.radiusInner;
            canvas.drawBitmap(bitmap4, (f14 + f15) - f16, (this.currentY + f15) - f16, this.paint);
        }
    }

    public void setStatus(int i11) {
        this.status = i11;
    }
}
