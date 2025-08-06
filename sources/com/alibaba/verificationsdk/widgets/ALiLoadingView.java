package com.alibaba.verificationsdk.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import java.lang.reflect.Field;

public class ALiLoadingView extends View {
    private final int ROTATE_STEP = 10;
    private boolean mClockwise = true;
    private Context mContext;
    private Bitmap mForeBitmap;
    private int mHeight;
    private boolean mIsAnimation;
    private Matrix mMatrix = new Matrix();
    private PaintFlagsDrawFilter mPaintFlagsDrawFilter;
    private int mType = 0;
    private int mWidth;
    private int rotate;

    public ALiLoadingView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    private int getResID() {
        int i11 = this.mType;
        if (i11 == 0) {
            return getResources().getIdentifier("ali_vsdk_shadu_icon_dengdai", "drawable", this.mContext.getPackageName());
        }
        if (i11 != 1) {
            return getResources().getIdentifier("ali_vsdk_shadu_icon_dengdai", "drawable", this.mContext.getPackageName());
        }
        return getResources().getIdentifier("ali_vsdk_button_icon_dengdai", "drawable", this.mContext.getPackageName());
    }

    private static Object getResourceId(Context context, String str, String str2) {
        try {
            for (Class cls : Class.forName(context.getPackageName() + ".R").getClasses()) {
                if (cls.getSimpleName().equals(str2)) {
                    for (Field field : cls.getFields()) {
                        String name = field.getName();
                        if (name.equals(str)) {
                            System.out.println(name);
                            return field.get((Object) null);
                        }
                    }
                    continue;
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return null;
    }

    public static int getStyleable(Context context, String str) {
        return ((Integer) getResourceId(context, str, "styleable")).intValue();
    }

    public static int[] getStyleableArray(Context context, String str) {
        return (int[]) getResourceId(context, str, "styleable");
    }

    private void init() {
        this.mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
        this.mForeBitmap = ((BitmapDrawable) this.mContext.getResources().getDrawable(getResID())).getBitmap();
        invalidate();
    }

    public void onDeAttachedToWindow() {
        stopRotationAnimation();
        super.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mForeBitmap.isRecycled() && this.mIsAnimation) {
            init();
        }
        if (!this.mForeBitmap.isRecycled()) {
            this.mMatrix.setRotate((float) this.rotate, (float) (this.mForeBitmap.getWidth() / 2), (float) (this.mForeBitmap.getHeight() / 2));
            canvas.setDrawFilter(this.mPaintFlagsDrawFilter);
            canvas.drawBitmap(this.mForeBitmap, this.mMatrix, (Paint) null);
            if (this.mIsAnimation) {
                int i11 = this.rotate;
                int i12 = i11 + 10 > 360 ? 0 : i11 + 10;
                this.rotate = i12;
                if (!this.mClockwise) {
                    i12 = -i12;
                }
                this.rotate = i12;
                postInvalidate();
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.mWidth = this.mForeBitmap.getWidth();
        int height = this.mForeBitmap.getHeight();
        this.mHeight = height;
        setMeasuredDimension(this.mWidth, height);
    }

    public void startRotationAnimation() {
        this.mIsAnimation = true;
        invalidate();
    }

    public void stopRotationAnimation() {
        this.mIsAnimation = false;
    }

    public ALiLoadingView(Context context, int i11) {
        super(context);
        this.mContext = context;
        this.mType = i11;
        init();
    }

    public ALiLoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mType = 0;
        init();
    }
}
