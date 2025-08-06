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
import com.hbg.lib.widgets.AutoSizeTextView;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$styleable;
import com.sumsub.sns.internal.ml.autocapture.a;
import eu.b;

public class StatusButton extends LinearLayout {
    public static final int BACKGROUND_TYPE_FILL = 1;
    public static final int BACKGROUND_TYPE_LIVE = 2;
    public static final int BACKGROUND_TYPE_STROKE = 0;
    private int fillBackground;
    private ImageView imageViewWidgetStatusButtonIcon;
    private ILoadingShape shape;
    private boolean showIcon;
    private boolean showProgress;
    private AutoSizeTextView textViewWidgetStatusButtonText;
    private ValueAnimator valueAnimator;

    public StatusButton(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        setGravity(17);
        setClickable(true);
        LayoutInflater.from(context).inflate(R$layout.widget_status_button, this, true);
        this.imageViewWidgetStatusButtonIcon = (ImageView) findViewById(R$id.image_view_widget_status_button_icon);
        this.textViewWidgetStatusButtonText = (AutoSizeTextView) findViewById(R$id.text_view_widget_status_button_text);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.StatusButton);
        setButtonBackground(obtainStyledAttributes.getInt(R$styleable.StatusButton_buttonBackgroundFill, 1));
        setIconVisible(obtainStyledAttributes.getInt(R$styleable.StatusButton_iconVisible, 8));
        setTextSize(obtainStyledAttributes.getDimension(R$styleable.StatusButton_buttonTextSize, getResources().getDimension(R$dimen.global_text_size_14)));
        float dimension = obtainStyledAttributes.getDimension(R$styleable.StatusButton_animProgressWidth, 6.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R$styleable.StatusButton_animProgressRadius, 24.0f);
        setTextColor(obtainStyledAttributes.getColorStateList(R$styleable.StatusButton_buttonTextColor));
        setButtonIcon(obtainStyledAttributes.getResourceId(R$styleable.StatusButton_buttonIcon, 0));
        setButtonText(obtainStyledAttributes.getString(R$styleable.StatusButton_buttonText));
        setButtonTextCaps(obtainStyledAttributes.getBoolean(R$styleable.StatusButton_buttonTextAllCaps, false));
        setEnabled(obtainStyledAttributes.getBoolean(R$styleable.StatusButton_buttonEnable, true));
        obtainStyledAttributes.recycle();
        this.shape = new ArcProgressShape(108.0f, dimension, dimension2, -65536);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$startAnim$0(ValueAnimator valueAnimator2) {
        this.shape.exeAnim(((Float) valueAnimator2.getAnimatedValue()).floatValue());
        invalidate();
    }

    private void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.textViewWidgetStatusButtonText.setTextColor(colorStateList);
        } else if (this.fillBackground == 1) {
            this.textViewWidgetStatusButtonText.setTextColor(-1);
        } else {
            this.textViewWidgetStatusButtonText.setTextColor(getResources().getColor(R$color.baseColorPrimaryText));
        }
    }

    private void startAnim() {
        ValueAnimator ofFloat = ObjectAnimator.ofFloat(new float[]{0.0f, 15.0f});
        this.valueAnimator = ofFloat;
        ofFloat.setDuration(a.f34923p);
        this.valueAnimator.setRepeatCount(-1);
        this.valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.valueAnimator.addUpdateListener(new b(this));
        this.valueAnimator.start();
    }

    public void dismissAnim() {
        this.showProgress = false;
        ValueAnimator valueAnimator2 = this.valueAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        if (this.showIcon) {
            this.imageViewWidgetStatusButtonIcon.setVisibility(0);
        }
        this.textViewWidgetStatusButtonText.setVisibility(0);
    }

    public boolean hasShowAnim() {
        return this.showProgress;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator2 = this.valueAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.valueAnimator = null;
        }
    }

    public void onDraw(Canvas canvas) {
        ILoadingShape iLoadingShape;
        super.onDraw(canvas);
        if (this.showProgress && (iLoadingShape = this.shape) != null) {
            iLoadingShape.render(canvas);
        }
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
    }

    public void setButtonBackground(int i11) {
        this.fillBackground = i11;
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
        ImageView imageView = this.imageViewWidgetStatusButtonIcon;
        if (imageView != null) {
            imageView.setImageResource(i11);
        }
    }

    public void setButtonText(String str) {
        this.textViewWidgetStatusButtonText.setText(str);
    }

    public void setButtonTextCaps(boolean z11) {
        this.textViewWidgetStatusButtonText.setAllCaps(z11);
    }

    public void setEnabled(boolean z11) {
        super.setEnabled(z11);
        this.textViewWidgetStatusButtonText.setEnabled(z11);
    }

    public void setIconVisible(int i11) {
        if (i11 == 0) {
            this.showIcon = true;
        }
        this.imageViewWidgetStatusButtonIcon.setVisibility(i11);
    }

    public void setMinTextSize(float f11) {
        this.textViewWidgetStatusButtonText.setMinTextSize(f11);
    }

    public void setTextSize(float f11) {
        AutoSizeTextView autoSizeTextView = this.textViewWidgetStatusButtonText;
        if (autoSizeTextView != null) {
            autoSizeTextView.setTextSize(0, f11);
        }
    }

    public void showAnim() {
        if (!this.showProgress) {
            this.textViewWidgetStatusButtonText.setVisibility(4);
            this.imageViewWidgetStatusButtonIcon.setVisibility(8);
            this.showProgress = true;
            startAnim();
        }
    }

    public void setButtonText(int i11) {
        this.textViewWidgetStatusButtonText.setText(i11);
    }

    public StatusButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public StatusButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }

    public void setTextColor(int i11) {
        this.textViewWidgetStatusButtonText.setTextColor(i11);
    }

    public void dismissAnim(String str) {
        this.textViewWidgetStatusButtonText.setText(str);
        dismissAnim();
    }
}
