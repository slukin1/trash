package com.huobi.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.model.PositionData;
import pro.huobi.R;
import q10.b;

public class LineIndicator extends View implements b {
    private Bitmap bitmap;
    private float mAnchorX;
    private int mLineColor;
    private int mLineHeight;
    private Paint mPaint;
    private List<PositionData> mPositionDataList;
    private Interpolator mStartInterpolator = new LinearInterpolator();
    private int mTriangleHeight;
    private int mTriangleWidth;
    private float mYOffset;

    public LineIndicator(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mLineHeight = UIUtil.a(context, 3.0d);
        this.mTriangleWidth = UIUtil.a(context, 14.0d);
        this.mTriangleHeight = UIUtil.a(context, 8.0d);
        this.bitmap = ((BitmapDrawable) getResources().getDrawable(R.drawable.order_type_indicator)).getBitmap();
    }

    public int getLineColor() {
        return this.mLineColor;
    }

    public int getLineHeight() {
        return this.mLineHeight;
    }

    public Interpolator getStartInterpolator() {
        return this.mStartInterpolator;
    }

    public int getTriangleHeight() {
        return this.mTriangleHeight;
    }

    public int getTriangleWidth() {
        return this.mTriangleWidth;
    }

    public float getYOffset() {
        return this.mYOffset;
    }

    public void onDraw(Canvas canvas) {
        this.mPaint.setColor(this.mLineColor);
        canvas.drawRect(0.0f, ((float) (getHeight() - this.mLineHeight)) - this.mYOffset, (float) getWidth(), ((float) getHeight()) - this.mYOffset, this.mPaint);
    }

    public void onPageScrollStateChanged(int i11) {
    }

    public void onPageScrolled(int i11, float f11, int i12) {
        List<PositionData> list = this.mPositionDataList;
        if (list != null && !list.isEmpty()) {
            int min = Math.min(this.mPositionDataList.size() - 1, i11);
            int min2 = Math.min(this.mPositionDataList.size() - 1, i11 + 1);
            PositionData positionData = this.mPositionDataList.get(min);
            PositionData positionData2 = this.mPositionDataList.get(min2);
            int i13 = positionData.f58515a;
            float f12 = (float) (i13 + ((positionData.f58517c - i13) / 2));
            int i14 = positionData2.f58515a;
            this.mAnchorX = f12 + ((((float) (i14 + ((positionData2.f58517c - i14) / 2))) - f12) * this.mStartInterpolator.getInterpolation(f11));
            invalidate();
        }
    }

    public void onPageSelected(int i11) {
    }

    public void onPositionDataProvide(List<PositionData> list) {
        this.mPositionDataList = list;
    }

    public void setLineColor(int i11) {
        this.mLineColor = i11;
    }

    public void setLineHeight(int i11) {
        this.mLineHeight = i11;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.mStartInterpolator = interpolator;
        if (interpolator == null) {
            this.mStartInterpolator = new LinearInterpolator();
        }
    }

    public void setTriangleHeight(int i11) {
        this.mTriangleHeight = i11;
    }

    public void setTriangleWidth(int i11) {
        this.mTriangleWidth = i11;
    }

    public void setYOffset(float f11) {
        this.mYOffset = f11;
    }
}
