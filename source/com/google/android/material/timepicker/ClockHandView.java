package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.h0;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.List;

class ClockHandView extends View {
    private static final int ANIMATION_DURATION = 200;
    private boolean animatingOnTouchUp;
    private final float centerDotRadius;
    private boolean changedDuringTouch;
    private int circleRadius;
    private double degRad;
    private float downX;
    private float downY;
    private boolean isInTapRegion;
    private final List<OnRotateListener> listeners;
    private OnActionUpListener onActionUpListener;
    private float originalDeg;
    private final Paint paint;
    private ValueAnimator rotationAnimator;
    private int scaledTouchSlop;
    private final RectF selectorBox;
    private final int selectorRadius;
    private final int selectorStrokeWidth;

    public interface OnActionUpListener {
        void onActionUp(float f11, boolean z11);
    }

    public interface OnRotateListener {
        void onRotate(float f11, boolean z11);
    }

    public ClockHandView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void drawSelector(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f11 = (float) width;
        float f12 = (float) height;
        this.paint.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) this.circleRadius) * ((float) Math.cos(this.degRad))) + f11, (((float) this.circleRadius) * ((float) Math.sin(this.degRad))) + f12, (float) this.selectorRadius, this.paint);
        double sin = Math.sin(this.degRad);
        double cos = Math.cos(this.degRad);
        double d11 = (double) ((float) (this.circleRadius - this.selectorRadius));
        float f13 = (float) (width + ((int) (cos * d11)));
        float f14 = (float) (height + ((int) (d11 * sin)));
        this.paint.setStrokeWidth((float) this.selectorStrokeWidth);
        canvas.drawLine(f11, f12, f13, f14, this.paint);
        canvas.drawCircle(f11, f12, this.centerDotRadius, this.paint);
    }

    private int getDegreesFromXY(float f11, float f12) {
        int degrees = ((int) Math.toDegrees(Math.atan2((double) (f12 - ((float) (getHeight() / 2))), (double) (f11 - ((float) (getWidth() / 2)))))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    private Pair<Float, Float> getValuesForAnimation(float f11) {
        float handRotation = getHandRotation();
        if (Math.abs(handRotation - f11) > 180.0f) {
            if (handRotation > 180.0f && f11 < 180.0f) {
                f11 += 360.0f;
            }
            if (handRotation < 180.0f && f11 > 180.0f) {
                handRotation += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(handRotation), Float.valueOf(f11));
    }

    private boolean handleTouchInput(float f11, float f12, boolean z11, boolean z12, boolean z13) {
        float degreesFromXY = (float) getDegreesFromXY(f11, f12);
        boolean z14 = false;
        boolean z15 = getHandRotation() != degreesFromXY;
        if (z12 && z15) {
            return true;
        }
        if (!z15 && !z11) {
            return false;
        }
        if (z13 && this.animatingOnTouchUp) {
            z14 = true;
        }
        setHandRotation(degreesFromXY, z14);
        return true;
    }

    /* access modifiers changed from: private */
    public void setHandRotationInternal(float f11, boolean z11) {
        float f12 = f11 % 360.0f;
        this.originalDeg = f12;
        this.degRad = Math.toRadians((double) (f12 - 90.0f));
        float width = ((float) (getWidth() / 2)) + (((float) this.circleRadius) * ((float) Math.cos(this.degRad)));
        float height = ((float) (getHeight() / 2)) + (((float) this.circleRadius) * ((float) Math.sin(this.degRad)));
        RectF rectF = this.selectorBox;
        int i11 = this.selectorRadius;
        rectF.set(width - ((float) i11), height - ((float) i11), width + ((float) i11), height + ((float) i11));
        for (OnRotateListener onRotate : this.listeners) {
            onRotate.onRotate(f12, z11);
        }
        invalidate();
    }

    public void addOnRotateListener(OnRotateListener onRotateListener) {
        this.listeners.add(onRotateListener);
    }

    public RectF getCurrentSelectorBox() {
        return this.selectorBox;
    }

    public float getHandRotation() {
        return this.originalDeg;
    }

    public int getSelectorRadius() {
        return this.selectorRadius;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSelector(canvas);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        setHandRotation(getHandRotation());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z11;
        boolean z12;
        boolean z13;
        OnActionUpListener onActionUpListener2;
        int actionMasked = motionEvent.getActionMasked();
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        if (actionMasked == 0) {
            this.downX = x11;
            this.downY = y11;
            this.isInTapRegion = true;
            this.changedDuringTouch = false;
            z13 = false;
            z12 = false;
            z11 = true;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i11 = (int) (x11 - this.downX);
            int i12 = (int) (y11 - this.downY);
            this.isInTapRegion = (i11 * i11) + (i12 * i12) > this.scaledTouchSlop;
            boolean z14 = this.changedDuringTouch;
            z13 = actionMasked == 1;
            z11 = false;
            z12 = z14;
        } else {
            z13 = false;
            z12 = false;
            z11 = false;
        }
        boolean handleTouchInput = handleTouchInput(x11, y11, z12, z11, z13) | this.changedDuringTouch;
        this.changedDuringTouch = handleTouchInput;
        if (handleTouchInput && z13 && (onActionUpListener2 = this.onActionUpListener) != null) {
            onActionUpListener2.onActionUp((float) getDegreesFromXY(x11, y11), this.isInTapRegion);
        }
        return true;
    }

    public void setAnimateOnTouchUp(boolean z11) {
        this.animatingOnTouchUp = z11;
    }

    public void setCircleRadius(int i11) {
        this.circleRadius = i11;
        invalidate();
    }

    public void setHandRotation(float f11) {
        setHandRotation(f11, false);
    }

    public void setOnActionUpListener(OnActionUpListener onActionUpListener2) {
        this.onActionUpListener = onActionUpListener2;
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    public void setHandRotation(float f11, boolean z11) {
        ValueAnimator valueAnimator = this.rotationAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z11) {
            setHandRotationInternal(f11, false);
            return;
        }
        Pair<Float, Float> valuesForAnimation = getValuesForAnimation(f11);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{((Float) valuesForAnimation.first).floatValue(), ((Float) valuesForAnimation.second).floatValue()});
        this.rotationAnimator = ofFloat;
        ofFloat.setDuration(200);
        this.rotationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClockHandView.this.setHandRotationInternal(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
            }
        });
        this.rotationAnimator.addListener(new AnimatorListenerAdapter() {
            public void onAnimationCancel(Animator animator) {
                animator.end();
            }
        });
        this.rotationAnimator.start();
    }

    public ClockHandView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.listeners = new ArrayList();
        Paint paint2 = new Paint();
        this.paint = paint2;
        this.selectorBox = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockHandView, i11, R.style.Widget_MaterialComponents_TimePicker_Clock);
        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_materialCircleRadius, 0);
        this.selectorRadius = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.selectorStrokeWidth = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.centerDotRadius = (float) resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(R.styleable.ClockHandView_clockHandColor, 0);
        paint2.setAntiAlias(true);
        paint2.setColor(color);
        setHandRotation(0.0f);
        this.scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        h0.I0(this, 2);
        obtainStyledAttributes.recycle();
    }
}
