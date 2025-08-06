package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.huobi.R$styleable;
import pro.huobi.R;

public class UnderLineTextView extends AppCompatTextView {
    private int color;
    private boolean dash = true;
    private DashPathEffect mDashPathEffect = new DashPathEffect(new float[]{8.0f, 8.0f}, 0.0f);
    private Paint mPaint;
    private Path mPath;

    public UnderLineTextView(Context context) {
        super(context);
    }

    private float getTextWidth() {
        float f11 = 0.0f;
        for (int i11 = 0; i11 < getLineCount(); i11++) {
            if (f11 < getLayout().getLineWidth(i11)) {
                f11 = getLayout().getLineWidth(i11);
            }
        }
        return f11 == 0.0f ? (float) getWidth() : f11;
    }

    private void initPaint() {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setColor(getResources().getColor(this.color));
        this.mPaint.setStrokeWidth(3.0f);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPath = new Path();
        setPadding(0, 0, 0, 3);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        this.color = R.color.textColor;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DashTextView);
            if (obtainStyledAttributes.hasValue(0)) {
                this.color = obtainStyledAttributes.getResourceId(0, R.color.textColor);
            }
            if (obtainStyledAttributes.hasValue(1)) {
                this.dash = obtainStyledAttributes.getBoolean(1, true);
            }
        }
        initPaint();
        setLayerType(1, (Paint) null);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.dash) {
            this.mPath.reset();
            this.mPath.moveTo(0.0f, (float) getHeight());
            this.mPath.lineTo(getTextWidth(), (float) getHeight());
            this.mPaint.setPathEffect(this.mDashPathEffect);
            canvas.drawPath(this.mPath, this.mPaint);
        }
    }

    public void setDash(boolean z11) {
        this.dash = z11;
        invalidate();
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet);
    }

    public UnderLineTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context, attributeSet);
    }
}
