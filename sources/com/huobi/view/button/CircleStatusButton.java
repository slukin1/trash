package com.huobi.view.button;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$styleable;
import com.sumsub.sns.internal.ml.autocapture.a;

public class CircleStatusButton extends LinearLayout {
    public static final int BACKGROUND_TYPE_FILL = 1;
    public static final int BACKGROUND_TYPE_LIVE = 2;
    public static final int BACKGROUND_TYPE_STROKE = 0;
    private ValueAnimator mAnimator;
    private int mFillBackground;
    private ImageView mImageView;
    private ILoadingShape mLoadingShape;
    private boolean mShowIcon;
    private boolean mShowProgress;
    private TextView mTextView;

    public CircleStatusButton(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startAnimator$0(ValueAnimator valueAnimator) {
        this.mLoadingShape.exeAnim(((Float) valueAnimator.getAnimatedValue()).floatValue());
        invalidate();
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.mTextView.setTextColor(colorStateList);
        } else if (this.mFillBackground == 1) {
            this.mTextView.setTextColor(-1);
        } else {
            this.mTextView.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
        }
    }

    private void startAnimator() {
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(new float[]{0.0f, 15.0f});
        this.mAnimator = ofFloat;
        ofFloat.setDuration(a.f34923p);
        this.mAnimator.setRepeatCount(-1);
        this.mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mAnimator.addUpdateListener(new eu.a(this));
        this.mAnimator.start();
    }

    public void dismissAnimator() {
        this.mShowProgress = false;
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (this.mShowIcon) {
            this.mImageView.setVisibility(0);
        }
        this.mTextView.setVisibility(0);
    }

    public boolean hasShowAnimator() {
        return this.mShowProgress;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mAnimator = null;
        }
    }

    public void onDraw(Canvas canvas) {
        ILoadingShape iLoadingShape;
        super.onDraw(canvas);
        if (this.mShowProgress && (iLoadingShape = this.mLoadingShape) != null) {
            iLoadingShape.render(canvas);
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
    }

    public void setButtonBackground(int i11) {
        this.mFillBackground = i11;
        if (i11 == 0) {
            setBackgroundResource(R$drawable.selector_button_stroke);
        } else if (i11 == 1) {
            setBackgroundResource(R$drawable.selector_button_fill);
        } else if (i11 == 2) {
            setBackgroundResource(R$drawable.im_bg_gift_bottom_btn);
        }
        setTextColor((ColorStateList) null);
    }

    public void setButtonIcon(int i11) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageResource(i11);
        }
    }

    public void setButtonText(String str) {
        this.mTextView.setText(str);
    }

    public void setButtonTextCaps(boolean z11) {
        this.mTextView.setAllCaps(z11);
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        this.mTextView.setEnabled(z11);
    }

    public void setIconVisible(int i11) {
        if (i11 == 0) {
            this.mShowIcon = true;
        }
        this.mImageView.setVisibility(i11);
    }

    public void setTextSize(float f11) {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setTextSize(0, f11);
        }
    }

    public void showAnimator() {
        if (!this.mShowProgress) {
            this.mTextView.setVisibility(4);
            this.mImageView.setVisibility(8);
            this.mShowProgress = true;
            startAnimator();
        }
    }

    public CircleStatusButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void setButtonText(int i11) {
        this.mTextView.setText(i11);
    }

    public CircleStatusButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        setWillNotDraw(false);
        setGravity(17);
        setClickable(true);
        LayoutInflater.from(context).inflate(R$layout.widget_circle_status_button, this, true);
        this.mImageView = (ImageView) findViewById(R$id.iv_circle_status);
        this.mTextView = (TextView) findViewById(R$id.tv_circle_status);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CircleStatusButton);
        setButtonBackground(obtainStyledAttributes.getInt(R$styleable.CircleStatusButton_buttonBackgroundFill, 1));
        setIconVisible(obtainStyledAttributes.getInt(R$styleable.CircleStatusButton_iconVisible, 8));
        setTextSize(obtainStyledAttributes.getDimension(R$styleable.CircleStatusButton_buttonTextSize, getResources().getDimension(R$dimen.global_text_size_16)));
        float dimension = obtainStyledAttributes.getDimension(R$styleable.CircleStatusButton_animProgressWidth, 6.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.CircleStatusButton_animProgressRadius, 24.0f);
        setTextColor(obtainStyledAttributes.getColorStateList(R$styleable.CircleStatusButton_buttonTextColor));
        setButtonIcon(obtainStyledAttributes.getResourceId(R$styleable.CircleStatusButton_buttonIcon, 0));
        setButtonText(obtainStyledAttributes.getString(R$styleable.CircleStatusButton_buttonText));
        setButtonTextCaps(obtainStyledAttributes.getBoolean(R$styleable.CircleStatusButton_buttonTextAllCaps, false));
        setEnabled(obtainStyledAttributes.getBoolean(R$styleable.CircleStatusButton_buttonEnable, true));
        obtainStyledAttributes.recycle();
        this.mLoadingShape = new ArcProgressShape(108.0f, dimension, dimension2, -65536);
    }

    public void setTextColor(int i11) {
        this.mTextView.setTextColor(i11);
    }

    public void dismissAnimator(String str) {
        this.mTextView.setText(str);
        dismissAnimator();
    }
}
