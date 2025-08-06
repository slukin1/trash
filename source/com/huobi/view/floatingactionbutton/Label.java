package com.huobi.view.floatingactionbutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Animation;
import android.widget.TextView;

public class Label extends TextView {
    /* access modifiers changed from: private */
    public static final Xfermode PORTER_DUFF_CLEAR = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
    private static final int TWO = 2;
    private Drawable mBackgroundDrawable;
    /* access modifiers changed from: private */
    public int mColorNormal;
    private int mColorPressed;
    private int mColorRipple;
    /* access modifiers changed from: private */
    public int mCornerRadius;
    /* access modifiers changed from: private */
    public FloatingActionButton mFab;
    public GestureDetector mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
        public boolean onDown(MotionEvent motionEvent) {
            Label.this.onActionDown();
            if (Label.this.mFab != null) {
                Label.this.mFab.onActionDown();
            }
            return super.onDown(motionEvent);
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            Label.this.onActionUp();
            if (Label.this.mFab != null) {
                Label.this.mFab.onActionUp();
            }
            return super.onSingleTapUp(motionEvent);
        }
    });
    private boolean mHandleVisibilityChanges = true;
    private Animation mHideAnimation;
    /* access modifiers changed from: private */
    public int mRawHeight;
    /* access modifiers changed from: private */
    public int mRawWidth;
    /* access modifiers changed from: private */
    public int mShadowColor;
    /* access modifiers changed from: private */
    public int mShadowRadius;
    /* access modifiers changed from: private */
    public int mShadowXOffset;
    /* access modifiers changed from: private */
    public int mShadowYOffset;
    private Animation mShowAnimation;
    private boolean mShowShadow = true;
    private boolean mUsingStyle;

    public final class Shadow extends Drawable {
        private Paint mErase;
        private Paint mPaint;

        private void init() {
            Label.this.setLayerType(1, (Paint) null);
            this.mPaint.setStyle(Paint.Style.FILL);
            this.mPaint.setColor(Label.this.mColorNormal);
            this.mErase.setXfermode(Label.PORTER_DUFF_CLEAR);
            if (!Label.this.isInEditMode()) {
                this.mPaint.setShadowLayer((float) Label.this.mShadowRadius, (float) Label.this.mShadowXOffset, (float) Label.this.mShadowYOffset, Label.this.mShadowColor);
            }
        }

        public void draw(Canvas canvas) {
            RectF rectF = new RectF((float) (Label.this.mShadowRadius + Math.abs(Label.this.mShadowXOffset)), (float) (Label.this.mShadowRadius + Math.abs(Label.this.mShadowYOffset)), (float) Label.this.mRawWidth, (float) Label.this.mRawHeight);
            canvas.drawRoundRect(rectF, (float) Label.this.mCornerRadius, (float) Label.this.mCornerRadius, this.mPaint);
            canvas.drawRoundRect(rectF, (float) Label.this.mCornerRadius, (float) Label.this.mCornerRadius, this.mErase);
        }

        public int getOpacity() {
            return 0;
        }

        public void setAlpha(int i11) {
        }

        public void setColorFilter(ColorFilter colorFilter) {
        }

        private Shadow() {
            this.mPaint = new Paint(1);
            this.mErase = new Paint(1);
            init();
        }
    }

    public Label(Context context) {
        super(context);
    }

    private int calculateMeasuredHeight() {
        if (this.mRawHeight == 0) {
            this.mRawHeight = getMeasuredHeight();
        }
        return getMeasuredHeight() + calculateShadowHeight();
    }

    private int calculateMeasuredWidth() {
        if (this.mRawWidth == 0) {
            this.mRawWidth = getMeasuredWidth();
        }
        return getMeasuredWidth() + calculateShadowWidth();
    }

    @TargetApi(21)
    private Drawable createFillDrawable() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, createRectDrawable(this.mColorPressed));
        stateListDrawable.addState(new int[0], createRectDrawable(this.mColorNormal));
        if (Util.hasLollipop()) {
            RippleDrawable rippleDrawable = new RippleDrawable(new ColorStateList(new int[][]{new int[0]}, new int[]{this.mColorRipple}), stateListDrawable, (Drawable) null);
            setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    outline.setOval(0, 0, view.getWidth(), view.getHeight());
                }
            });
            setClipToOutline(true);
            this.mBackgroundDrawable = rippleDrawable;
            return rippleDrawable;
        }
        this.mBackgroundDrawable = stateListDrawable;
        return stateListDrawable;
    }

    private Drawable createRectDrawable(int i11) {
        int i12 = this.mCornerRadius;
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i12, (float) i12, (float) i12, (float) i12, (float) i12, (float) i12, (float) i12, (float) i12}, (RectF) null, (float[]) null));
        shapeDrawable.getPaint().setColor(i11);
        return shapeDrawable;
    }

    private void playHideAnimation() {
        if (this.mHideAnimation != null) {
            this.mShowAnimation.cancel();
            startAnimation(this.mHideAnimation);
        }
    }

    private void playShowAnimation() {
        if (this.mShowAnimation != null) {
            this.mHideAnimation.cancel();
            startAnimation(this.mShowAnimation);
        }
    }

    @TargetApi(21)
    private void setBackgroundCompat(Drawable drawable) {
        if (Util.hasJellyBean()) {
            setBackground(drawable);
        } else {
            setBackgroundDrawable(drawable);
        }
    }

    private void setShadow(FloatingActionButton floatingActionButton) {
        this.mShadowColor = floatingActionButton.getShadowColor();
        this.mShadowRadius = floatingActionButton.getShadowRadius();
        this.mShadowXOffset = floatingActionButton.getShadowXOffset();
        this.mShadowYOffset = floatingActionButton.getShadowYOffset();
        this.mShowShadow = floatingActionButton.hasShadow();
    }

    public int calculateShadowHeight() {
        if (this.mShowShadow) {
            return this.mShadowRadius + Math.abs(this.mShadowYOffset);
        }
        return 0;
    }

    public int calculateShadowWidth() {
        if (this.mShowShadow) {
            return this.mShadowRadius + Math.abs(this.mShadowXOffset);
        }
        return 0;
    }

    public void hide(boolean z11) {
        if (z11) {
            playHideAnimation();
        }
        setVisibility(4);
    }

    public boolean isHandleVisibilityChanges() {
        return this.mHandleVisibilityChanges;
    }

    @TargetApi(21)
    public void onActionDown() {
        if (this.mUsingStyle) {
            this.mBackgroundDrawable = getBackground();
        }
        Drawable drawable = this.mBackgroundDrawable;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[]{16842919});
        } else if (Util.hasLollipop()) {
            Drawable drawable2 = this.mBackgroundDrawable;
            if (drawable2 instanceof RippleDrawable) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable2;
                rippleDrawable.setState(new int[]{16842910, 16842919});
                rippleDrawable.setHotspot((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2));
                rippleDrawable.setVisible(true, true);
            }
        }
    }

    @TargetApi(21)
    public void onActionUp() {
        if (this.mUsingStyle) {
            this.mBackgroundDrawable = getBackground();
        }
        Drawable drawable = this.mBackgroundDrawable;
        if (drawable instanceof StateListDrawable) {
            ((StateListDrawable) drawable).setState(new int[0]);
        } else if (Util.hasLollipop()) {
            Drawable drawable2 = this.mBackgroundDrawable;
            if (drawable2 instanceof RippleDrawable) {
                RippleDrawable rippleDrawable = (RippleDrawable) drawable2;
                rippleDrawable.setState(new int[0]);
                rippleDrawable.setHotspot((float) (getMeasuredWidth() / 2), (float) (getMeasuredHeight() / 2));
                rippleDrawable.setVisible(true, true);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        setMeasuredDimension(calculateMeasuredWidth(), calculateMeasuredHeight());
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        FloatingActionButton floatingActionButton = this.mFab;
        if (floatingActionButton == null || floatingActionButton.getOnClickListener() == null || !this.mFab.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 1) {
            onActionUp();
            this.mFab.onActionUp();
        } else if (action == 3) {
            onActionUp();
            this.mFab.onActionUp();
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    public void setColors(int i11, int i12, int i13) {
        this.mColorNormal = i11;
        this.mColorPressed = i12;
        this.mColorRipple = i13;
    }

    public void setCornerRadius(int i11) {
        this.mCornerRadius = i11;
    }

    public void setFab(FloatingActionButton floatingActionButton) {
        this.mFab = floatingActionButton;
        setShadow(floatingActionButton);
    }

    public void setHandleVisibilityChanges(boolean z11) {
        this.mHandleVisibilityChanges = z11;
    }

    public void setHideAnimation(Animation animation) {
        this.mHideAnimation = animation;
    }

    public void setShowAnimation(Animation animation) {
        this.mShowAnimation = animation;
    }

    public void setShowShadow(boolean z11) {
        this.mShowShadow = z11;
    }

    public void setUsingStyle(boolean z11) {
        this.mUsingStyle = z11;
    }

    public void show(boolean z11) {
        if (z11) {
            playShowAnimation();
        }
        setVisibility(0);
    }

    public void updateBackground() {
        LayerDrawable layerDrawable;
        if (this.mShowShadow) {
            layerDrawable = new LayerDrawable(new Drawable[]{new Shadow(), createFillDrawable()});
            layerDrawable.setLayerInset(1, this.mShadowRadius + Math.abs(this.mShadowXOffset), this.mShadowRadius + Math.abs(this.mShadowYOffset), this.mShadowRadius + Math.abs(this.mShadowXOffset), this.mShadowRadius + Math.abs(this.mShadowYOffset));
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{createFillDrawable()});
        }
        setBackgroundCompat(layerDrawable);
    }

    public Label(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Label(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
