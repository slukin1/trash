package com.huobi.view.roundview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$styleable;

public class RoundViewDelegate {
    private int backgroundColor;
    private int backgroundPressColor;
    private final Context context;
    private int cornerRadius;
    private int cornerRadiusBottomLeft;
    private int cornerRadiusBottomRight;
    private int cornerRadiusTopLeft;
    private int cornerRadiusTopRight;
    private final GradientDrawable gdBackground = new GradientDrawable();
    private final GradientDrawable gdBackgroundPress = new GradientDrawable();
    private boolean isRadiusHalfHeight;
    private boolean isRippleEnable;
    private boolean isWidthHeightEqual;
    private final float[] radiusArr = new float[8];
    private int strokeColor;
    private int strokePressColor;
    private int strokeWidth;
    private int textPressColor;
    private final View view;

    public RoundViewDelegate(View view2, Context context2, AttributeSet attributeSet) {
        this.view = view2;
        this.context = context2;
        obtainAttributes(context2, attributeSet);
    }

    @TargetApi(11)
    private ColorStateList getPressedColorSelector(int i11, int i12) {
        return new ColorStateList(new int[][]{new int[]{16842919}, new int[]{16842908}, new int[]{16843518}, new int[0]}, new int[]{i12, i12, i12, i11});
    }

    private void obtainAttributes(Context context2, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.RoundTextView);
        this.backgroundColor = obtainStyledAttributes.getColor(R$styleable.RoundTextView_rv_backgroundColor, 0);
        this.backgroundPressColor = obtainStyledAttributes.getColor(R$styleable.RoundTextView_rv_backgroundPressColor, Integer.MAX_VALUE);
        this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RoundTextView_rv_cornerRadius, 0);
        this.strokeWidth = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RoundTextView_rv_strokeWidth, 0);
        this.strokeColor = obtainStyledAttributes.getColor(R$styleable.RoundTextView_rv_strokeColor, 0);
        this.strokePressColor = obtainStyledAttributes.getColor(R$styleable.RoundTextView_rv_strokePressColor, Integer.MAX_VALUE);
        this.textPressColor = obtainStyledAttributes.getColor(R$styleable.RoundTextView_rv_textPressColor, Integer.MAX_VALUE);
        this.isRadiusHalfHeight = obtainStyledAttributes.getBoolean(R$styleable.RoundTextView_rv_isRadiusHalfHeight, false);
        this.isWidthHeightEqual = obtainStyledAttributes.getBoolean(R$styleable.RoundTextView_rv_isWidthHeightEqual, false);
        this.cornerRadiusTopLeft = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RoundTextView_rv_cornerRadius_TL, 0);
        this.cornerRadiusTopRight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RoundTextView_rv_cornerRadius_TR, 0);
        this.cornerRadiusBottomLeft = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RoundTextView_rv_cornerRadius_BL, 0);
        this.cornerRadiusBottomRight = obtainStyledAttributes.getDimensionPixelSize(R$styleable.RoundTextView_rv_cornerRadius_BR, 0);
        this.isRippleEnable = obtainStyledAttributes.getBoolean(R$styleable.RoundTextView_rv_isRippleEnable, true);
        obtainStyledAttributes.recycle();
    }

    private void setDrawable(GradientDrawable gradientDrawable, int i11, int i12) {
        gradientDrawable.setColor(i11);
        int i13 = this.cornerRadiusTopLeft;
        if (i13 > 0 || this.cornerRadiusTopRight > 0 || this.cornerRadiusBottomRight > 0 || this.cornerRadiusBottomLeft > 0) {
            float[] fArr = this.radiusArr;
            fArr[0] = (float) i13;
            fArr[1] = (float) i13;
            int i14 = this.cornerRadiusTopRight;
            fArr[2] = (float) i14;
            fArr[3] = (float) i14;
            int i15 = this.cornerRadiusBottomRight;
            fArr[4] = (float) i15;
            fArr[5] = (float) i15;
            int i16 = this.cornerRadiusBottomLeft;
            fArr[6] = (float) i16;
            fArr[7] = (float) i16;
            gradientDrawable.setCornerRadii(fArr);
        } else {
            gradientDrawable.setCornerRadius((float) this.cornerRadius);
        }
        gradientDrawable.setStroke(this.strokeWidth, i12);
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public int getBackgroundPressColor() {
        return this.backgroundPressColor;
    }

    public int getCornerRadius() {
        return this.cornerRadius;
    }

    public int getCornerRadiusBottomLeft() {
        return this.cornerRadiusBottomLeft;
    }

    public int getCornerRadiusBottomRight() {
        return this.cornerRadiusBottomRight;
    }

    public int getCornerRadiusTopLeft() {
        return this.cornerRadiusTopLeft;
    }

    public int getCornerRadiusTopRight() {
        return this.cornerRadiusTopRight;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokePressColor() {
        return this.strokePressColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public int getTextPressColor() {
        return this.textPressColor;
    }

    public View getView() {
        return this.view;
    }

    public boolean isRadiusHalfHeight() {
        return this.isRadiusHalfHeight;
    }

    public boolean isWidthHeightEqual() {
        return this.isWidthHeightEqual;
    }

    public void setBackgroundColor(int i11) {
        this.backgroundColor = i11;
        setBgSelector();
    }

    public void setBackgroundPressColor(int i11) {
        this.backgroundPressColor = i11;
        setBgSelector();
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public void setBgSelector() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 21 || !this.isRippleEnable) {
            setDrawable(this.gdBackground, this.backgroundColor, this.strokeColor);
            stateListDrawable.addState(new int[]{-16842919}, this.gdBackground);
            int i12 = this.backgroundPressColor;
            if (!(i12 == Integer.MAX_VALUE && this.strokePressColor == Integer.MAX_VALUE)) {
                GradientDrawable gradientDrawable = this.gdBackgroundPress;
                if (i12 == Integer.MAX_VALUE) {
                    i12 = this.backgroundColor;
                }
                int i13 = this.strokePressColor;
                if (i13 == Integer.MAX_VALUE) {
                    i13 = this.strokeColor;
                }
                setDrawable(gradientDrawable, i12, i13);
                stateListDrawable.addState(new int[]{16842919}, this.gdBackgroundPress);
            }
            if (i11 >= 16) {
                this.view.setBackground(stateListDrawable);
            } else {
                this.view.setBackgroundDrawable(stateListDrawable);
            }
        } else {
            setDrawable(this.gdBackground, this.backgroundColor, this.strokeColor);
            this.view.setBackground(new RippleDrawable(getPressedColorSelector(this.backgroundColor, this.backgroundPressColor), this.gdBackground, (Drawable) null));
        }
        View view2 = this.view;
        if ((view2 instanceof TextView) && this.textPressColor != Integer.MAX_VALUE) {
            ((TextView) this.view).setTextColor(new ColorStateList(new int[][]{new int[]{-16842919}, new int[]{16842919}}, new int[]{((TextView) view2).getTextColors().getDefaultColor(), this.textPressColor}));
        }
    }

    public void setCornerRadius(int i11) {
        this.cornerRadius = PixelUtils.a((float) i11);
        setBgSelector();
    }

    public void setCornerRadiusBottomLeft(int i11) {
        this.cornerRadiusBottomLeft = i11;
        setBgSelector();
    }

    public void setCornerRadiusBottomRight(int i11) {
        this.cornerRadiusBottomRight = i11;
        setBgSelector();
    }

    public void setCornerRadiusTopLeft(int i11) {
        this.cornerRadiusTopLeft = i11;
        setBgSelector();
    }

    public void setCornerRadiusTopRight(int i11) {
        this.cornerRadiusTopRight = i11;
        setBgSelector();
    }

    public void setIsRadiusHalfHeight(boolean z11) {
        this.isRadiusHalfHeight = z11;
        setBgSelector();
    }

    public void setIsWidthHeightEqual(boolean z11) {
        this.isWidthHeightEqual = z11;
        setBgSelector();
    }

    public void setStrokeColor(int i11) {
        this.strokeColor = i11;
        setBgSelector();
    }

    public void setStrokePressColor(int i11) {
        this.strokePressColor = i11;
        setBgSelector();
    }

    public void setStrokeWidth(int i11) {
        this.strokeWidth = PixelUtils.a((float) i11);
        setBgSelector();
    }

    public void setTextPressColor(int i11) {
        this.textPressColor = i11;
        setBgSelector();
    }
}
