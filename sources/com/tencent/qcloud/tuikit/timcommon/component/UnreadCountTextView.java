package com.tencent.qcloud.tuikit.timcommon.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.qcloud.tuikit.timcommon.R;

public class UnreadCountTextView extends AppCompatTextView {
    private int mNormalSize;
    private Paint mPaint;

    public UnreadCountTextView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private int dp2px(float f11) {
        return (int) TypedValue.applyDimension(1, f11, getResources().getDisplayMetrics());
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.mNormalSize = dp2px(18.4f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.UnreadCountTextView);
        int color = obtainStyledAttributes.getColor(R.styleable.UnreadCountTextView_paint_color, getResources().getColor(R.color.read_dot_bg));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(color);
        this.mPaint.setAntiAlias(true);
    }

    public void onDraw(Canvas canvas) {
        if (getText().length() == 0) {
            int measuredWidth = (getMeasuredWidth() - dp2px(6.0f)) / 2;
            int measuredWidth2 = getMeasuredWidth() - measuredWidth;
            float f11 = (float) measuredWidth;
            float f12 = (float) measuredWidth2;
            canvas.drawOval(new RectF(f11, f11, f12, f12), this.mPaint);
        } else if (getText().length() == 1) {
            int i11 = this.mNormalSize;
            canvas.drawOval(new RectF(0.0f, 0.0f, (float) i11, (float) i11), this.mPaint);
        } else if (getText().length() > 1) {
            canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight()), (float) (getMeasuredHeight() / 2), (float) (getMeasuredHeight() / 2), this.mPaint);
        }
        super.onDraw(canvas);
    }

    public void onMeasure(int i11, int i12) {
        int i13 = this.mNormalSize;
        setMeasuredDimension(getText().length() > 1 ? this.mNormalSize + dp2px((float) ((getText().length() - 1) * 10)) : i13, i13);
    }

    public void setPaintColor(int i11) {
        Paint paint = this.mPaint;
        if (paint != null) {
            paint.setColor(i11);
        }
    }

    public UnreadCountTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public UnreadCountTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
