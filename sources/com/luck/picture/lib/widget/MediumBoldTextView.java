package com.luck.picture.lib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.luck.picture.lib.R;

public class MediumBoldTextView extends AppCompatTextView {
    private float mStrokeWidth;

    public MediumBoldTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public void onDraw(Canvas canvas) {
        TextPaint paint = getPaint();
        float strokeWidth = paint.getStrokeWidth();
        float f11 = this.mStrokeWidth;
        if (strokeWidth != f11) {
            paint.setStrokeWidth(f11);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
        super.onDraw(canvas);
    }

    public void setStrokeWidth(float f11) {
        this.mStrokeWidth = f11;
        invalidate();
    }

    public MediumBoldTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediumBoldTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mStrokeWidth = 0.6f;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PictureMediumBoldTextView, i11, 0);
        this.mStrokeWidth = obtainStyledAttributes.getFloat(R.styleable.PictureMediumBoldTextView_stroke_Width, this.mStrokeWidth);
        obtainStyledAttributes.recycle();
    }
}
