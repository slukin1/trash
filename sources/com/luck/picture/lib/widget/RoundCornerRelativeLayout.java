package com.luck.picture.lib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.luck.picture.lib.R;

public class RoundCornerRelativeLayout extends RelativeLayout {
    private final float cornerSize;
    private final boolean isBottomNormal;
    private final boolean isTopNormal;
    private final RectF mRect;
    private final Path path;

    public RoundCornerRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.path.reset();
        RectF rectF = this.mRect;
        rectF.right = (float) i11;
        rectF.bottom = (float) i12;
        boolean z11 = this.isTopNormal;
        if (z11 || this.isBottomNormal) {
            if (z11) {
                float f11 = this.cornerSize;
                this.path.addRoundRect(rectF, new float[]{0.0f, 0.0f, 0.0f, 0.0f, f11, f11, f11, f11}, Path.Direction.CW);
            }
            if (this.isBottomNormal) {
                float f12 = this.cornerSize;
                this.path.addRoundRect(this.mRect, new float[]{f12, f12, f12, f12, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
                return;
            }
            return;
        }
        Path path2 = this.path;
        float f13 = this.cornerSize;
        path2.addRoundRect(rectF, f13, f13, Path.Direction.CW);
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundCornerRelativeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mRect = new RectF();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PictureRoundCornerRelativeLayout, i11, 0);
        this.cornerSize = obtainStyledAttributes.getDimension(R.styleable.PictureRoundCornerRelativeLayout_psCorners, 0.0f);
        this.isTopNormal = obtainStyledAttributes.getBoolean(R.styleable.PictureRoundCornerRelativeLayout_psTopNormal, false);
        this.isBottomNormal = obtainStyledAttributes.getBoolean(R.styleable.PictureRoundCornerRelativeLayout_psBottomNormal, false);
        obtainStyledAttributes.recycle();
        this.path = new Path();
    }
}
