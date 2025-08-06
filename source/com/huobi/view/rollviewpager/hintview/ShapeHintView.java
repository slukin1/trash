package com.huobi.view.rollviewpager.hintview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

public abstract class ShapeHintView extends LinearLayout implements HintView {
    private Drawable dot_focus;
    private Drawable dot_normal;
    private int lastPosition = 0;
    private int length = 0;
    private ImageView[] mDots;

    public ShapeHintView(Context context) {
        super(context);
    }

    public void initView(int i11, int i12) {
        removeAllViews();
        this.lastPosition = 0;
        setOrientation(0);
        if (i12 == 0) {
            setGravity(19);
        } else if (i12 == 1) {
            setGravity(17);
        } else if (i12 == 2) {
            setGravity(21);
        }
        this.length = i11;
        this.mDots = new ImageView[i11];
        this.dot_focus = makeFocusDrawable();
        this.dot_normal = makeNormalDrawable();
        for (int i13 = 0; i13 < i11; i13++) {
            this.mDots[i13] = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.setMargins(10, 0, 10, 0);
            this.mDots[i13].setLayoutParams(layoutParams);
            this.mDots[i13].setBackgroundDrawable(this.dot_normal);
            addView(this.mDots[i13]);
        }
        setCurrent(0);
    }

    public abstract Drawable makeFocusDrawable();

    public abstract Drawable makeNormalDrawable();

    public void setCurrent(int i11) {
        if (i11 >= 0 && i11 <= this.length - 1) {
            this.mDots[this.lastPosition].setBackgroundDrawable(this.dot_normal);
            this.mDots[i11].setBackgroundDrawable(this.dot_focus);
            this.lastPosition = i11;
        }
    }

    public ShapeHintView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
