package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.huobi.R$styleable;
import com.huobi.view.roundimg.RoundedDrawable;

public class FullSingleLineTextView extends View {
    public static final int MODE_FIT_TEXT_SIZE = 0;
    public static final int MODE_FIT_VIEW_HEIGHT = 1;
    private Rect bound;
    private int mMode;
    private String placeMeasureHeight;
    private String text;
    private int textColor;
    private Paint textPaint;
    private float textSize;

    public FullSingleLineTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public String getText() {
        return this.text;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!TextUtils.isEmpty(this.text)) {
            canvas.drawText(this.text, (float) (-this.bound.left), (float) ((getHeight() / 2) - this.bound.centerY()), this.textPaint);
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        int i14 = this.mMode;
        if (i14 == 0) {
            if (!TextUtils.isEmpty(this.text)) {
                Paint paint = this.textPaint;
                String str = this.text;
                paint.getTextBounds(str, 0, str.length(), this.bound);
            } else {
                this.bound.setEmpty();
            }
            Rect rect = new Rect();
            if (!TextUtils.isEmpty(this.placeMeasureHeight)) {
                Paint paint2 = this.textPaint;
                String str2 = this.placeMeasureHeight;
                paint2.getTextBounds(str2, 0, str2.length(), rect);
            }
            int width = this.bound.width();
            if (this.bound.height() < rect.height()) {
                i13 = rect.height();
            } else {
                i13 = this.bound.height();
            }
            setMeasuredDimension(width, i13);
        } else if (i14 != 1) {
            super.onMeasure(i11, i12);
        } else {
            super.onMeasure(i11, i12);
        }
    }

    public void setText(String str) {
        this.text = str;
        requestLayout();
    }

    public void setTextColor(int i11) {
        this.textColor = i11;
        this.textPaint.setColor(i11);
        invalidate();
    }

    public void setTextSize(float f11) {
        this.textSize = f11;
        requestLayout();
    }

    public void setTypeface(Typeface typeface) {
        if (this.textPaint.getTypeface() != typeface) {
            this.textPaint.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public FullSingleLineTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FullSingleLineTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.bound = new Rect();
        this.mMode = 0;
        this.textPaint = new Paint();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FullSingleLineTextView, i11, 0);
        this.textColor = obtainStyledAttributes.getColor(3, RoundedDrawable.DEFAULT_BORDER_COLOR);
        this.textSize = (float) obtainStyledAttributes.getDimensionPixelSize(4, 26);
        this.text = obtainStyledAttributes.getString(2);
        this.mMode = obtainStyledAttributes.getInt(0, 0);
        this.placeMeasureHeight = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(this.textSize);
        this.textPaint.setColor(this.textColor);
    }

    public void setText(int i11) {
        setText(getResources().getString(i11));
    }
}
