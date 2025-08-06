package com.huobi.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.hbg.lib.widgets.R$styleable;

public class ConstraintRatioRelativeLayout extends RelativeLayout {
    private int fixHeight;
    private int mConstraintType;
    private float mRatio;

    public ConstraintRatioRelativeLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    private void initAtts(TypedArray typedArray) {
        if (typedArray != null) {
            this.mConstraintType = typedArray.getInt(R$styleable.ConstraintRatioRelativeLayout_constraint_type, 0);
            this.mRatio = typedArray.getFloat(R$styleable.ConstraintRatioRelativeLayout_constraint_ratio, 1.0f);
            typedArray.recycle();
        }
    }

    public int getFixHeight() {
        return this.fixHeight;
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        if (isInEditMode()) {
            super.onMeasure(i11, i12);
            return;
        }
        if (this.mConstraintType == 0) {
            i13 = View.MeasureSpec.getSize(i11);
            this.fixHeight = Math.round(((float) i13) * this.mRatio);
        } else {
            int size = View.MeasureSpec.getSize(i12);
            this.fixHeight = size;
            i13 = Math.round(((float) size) * this.mRatio);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i13, 1073741824), View.MeasureSpec.makeMeasureSpec(this.fixHeight, 1073741824));
    }

    public ConstraintRatioRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ConstraintRatioRelativeLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initAtts(getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintRatioRelativeLayout));
    }
}
