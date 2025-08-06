package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.hbg.lib.widgets.R$styleable;

public class ColorGradientView extends View {
    private int mEndColor;
    private int mStartColor;

    public ColorGradientView(Context context) {
        super(context);
    }

    private void getAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ColorGradientViewAttr);
        this.mStartColor = obtainStyledAttributes.getColor(R$styleable.ColorGradientViewAttr_start_color, 0);
        this.mEndColor = obtainStyledAttributes.getColor(R$styleable.ColorGradientViewAttr_end_color, 0);
        obtainStyledAttributes.recycle();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mStartColor != 0 && this.mEndColor != 0) {
            int width = getWidth();
            int height = getHeight();
            Paint paint = new Paint();
            float f11 = (float) height;
            float f12 = (float) width;
            paint.setShader(new LinearGradient(0.0f, f11, f12, 0.0f, this.mStartColor, this.mEndColor, Shader.TileMode.CLAMP));
            canvas.drawRect(0.0f, 0.0f, f12, f11, paint);
        }
    }

    public void setEndColor(int i11) {
        this.mEndColor = i11;
        invalidate();
    }

    public void setStartColor(int i11) {
        this.mStartColor = i11;
        invalidate();
    }

    public ColorGradientView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        getAttrs(context, attributeSet);
    }

    public ColorGradientView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        getAttrs(context, attributeSet);
    }

    public ColorGradientView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        getAttrs(context, attributeSet);
    }
}
