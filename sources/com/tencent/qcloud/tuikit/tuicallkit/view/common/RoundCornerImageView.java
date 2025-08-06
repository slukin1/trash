package com.tencent.qcloud.tuikit.tuicallkit.view.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.tencent.qcloud.tuikit.tuicallkit.R;

public class RoundCornerImageView extends AppCompatImageView {
    private final PaintFlagsDrawFilter aliasFilter = new PaintFlagsDrawFilter(0, 3);
    private int leftBottomRadius;
    private int leftTopRadius;
    private final Path path = new Path();
    private int radius;
    private final RectF rectF = new RectF();
    private int rightBottomRadius;
    private int rightTopRadius;

    public RoundCornerImageView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setLayerType(2, (Paint) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundCornerImageView);
            this.radius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_corner_radius, 0);
            this.leftTopRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_left_top_radius, 0);
            this.rightTopRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_right_top_radius, 0);
            this.rightBottomRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_right_bottom_radius, 0);
            this.leftBottomRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundCornerImageView_left_bottom_radius, 0);
            obtainStyledAttributes.recycle();
        }
        if (this.leftTopRadius == 0) {
            this.leftTopRadius = this.radius;
        }
        if (this.rightTopRadius == 0) {
            this.rightTopRadius = this.radius;
        }
        if (this.rightBottomRadius == 0) {
            this.rightBottomRadius = this.radius;
        }
        if (this.leftBottomRadius == 0) {
            this.leftBottomRadius = this.radius;
        }
    }

    public int getLeftBottomRadius() {
        return this.leftBottomRadius;
    }

    public int getLeftTopRadius() {
        return this.leftTopRadius;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getRightBottomRadius() {
        return this.rightBottomRadius;
    }

    public int getRightTopRadius() {
        return this.rightTopRadius;
    }

    public void onDraw(Canvas canvas) {
        this.path.reset();
        canvas.setDrawFilter(this.aliasFilter);
        this.rectF.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        int i11 = this.leftTopRadius;
        int i12 = this.rightTopRadius;
        int i13 = this.rightBottomRadius;
        int i14 = this.leftBottomRadius;
        this.path.addRoundRect(this.rectF, new float[]{(float) i11, (float) i11, (float) i12, (float) i12, (float) i13, (float) i13, (float) i14, (float) i14}, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.onDraw(canvas);
    }

    public void setLeftBottomRadius(int i11) {
        this.leftBottomRadius = i11;
    }

    public void setLeftTopRadius(int i11) {
        this.leftTopRadius = i11;
    }

    public void setRadius(int i11) {
        this.radius = i11;
        this.leftBottomRadius = i11;
        this.rightBottomRadius = i11;
        this.rightTopRadius = i11;
        this.leftTopRadius = i11;
    }

    public void setRightBottomRadius(int i11) {
        this.rightBottomRadius = i11;
    }

    public void setRightTopRadius(int i11) {
        this.rightTopRadius = i11;
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public RoundCornerImageView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
