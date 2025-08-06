package com.youth.banner.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import com.youth.banner.R;

public class DrawableIndicator extends BaseIndicator {
    private Bitmap normalBitmap;
    private Bitmap selectedBitmap;

    public DrawableIndicator(Context context, int i11, int i12) {
        super(context);
        this.normalBitmap = BitmapFactory.decodeResource(getResources(), i11);
        this.selectedBitmap = BitmapFactory.decodeResource(getResources(), i12);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1 && this.normalBitmap != null && this.selectedBitmap != null) {
            int i11 = 0;
            float f11 = 0.0f;
            while (i11 < indicatorSize) {
                canvas.drawBitmap(this.config.getCurrentPosition() == i11 ? this.selectedBitmap : this.normalBitmap, f11, 0.0f, this.mPaint);
                f11 += (float) (this.normalBitmap.getWidth() + this.config.getIndicatorSpace());
                i11++;
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int indicatorSize = this.config.getIndicatorSize();
        if (indicatorSize > 1) {
            int i13 = indicatorSize - 1;
            setMeasuredDimension((this.selectedBitmap.getWidth() * i13) + this.selectedBitmap.getWidth() + (this.config.getIndicatorSpace() * i13), Math.max(this.normalBitmap.getHeight(), this.selectedBitmap.getHeight()));
        }
    }

    public DrawableIndicator(Context context) {
        this(context, (AttributeSet) null);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawableIndicator(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DrawableIndicator);
        if (obtainStyledAttributes != null) {
            this.normalBitmap = ((BitmapDrawable) obtainStyledAttributes.getDrawable(R.styleable.DrawableIndicator_normal_drawable)).getBitmap();
            this.selectedBitmap = ((BitmapDrawable) obtainStyledAttributes.getDrawable(R.styleable.DrawableIndicator_selected_drawable)).getBitmap();
        }
    }
}
