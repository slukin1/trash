package com.tencent.qcloud.tuikit.timcommon.component;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.qcloud.tuikit.timcommon.R;

public class RoundFrameLayout extends FrameLayout {
    private final PaintFlagsDrawFilter aliasFilter = new PaintFlagsDrawFilter(0, 3);
    private int leftBottomRadius;
    private int leftTopRadius;
    private final Path path = new Path();
    private int radius;
    private final RectF rectF = new RectF();
    private int rightBottomRadius;
    private int rightTopRadius;

    public RoundFrameLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setLayerType(2, (Paint) null);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundFrameLayout);
            this.radius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundFrameLayout_corner_radius, 0);
            this.leftTopRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundFrameLayout_left_top_corner_radius, 0);
            this.rightTopRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundFrameLayout_right_top_corner_radius, 0);
            this.rightBottomRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundFrameLayout_right_bottom_corner_radius, 0);
            this.leftBottomRadius = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.RoundFrameLayout_left_bottom_corner_radius, 0);
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

    public void dispatchDraw(Canvas canvas) {
        this.path.reset();
        canvas.setDrawFilter(this.aliasFilter);
        this.rectF.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        int i11 = this.leftTopRadius;
        int i12 = this.rightTopRadius;
        int i13 = this.rightBottomRadius;
        int i14 = this.leftBottomRadius;
        this.path.addRoundRect(this.rectF, new float[]{(float) i11, (float) i11, (float) i12, (float) i12, (float) i13, (float) i13, (float) i14, (float) i14}, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public RoundFrameLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
