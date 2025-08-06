package com.twitter.sdk.android.tweetui.internal;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

public class SwipeToDismissTouchListener implements View.OnTouchListener {
    private Callback callback;
    private final float closeThreshold;
    private float initialY;
    private boolean isMoving;
    private float lastX;
    private float lastY;
    private final float maxTranslate;
    private int pointerIndex;
    private int touchSlop;

    public interface Callback {
        void onDismiss();

        void onMove(float f11);
    }

    public interface SwipeableViewProvider {
        boolean canBeSwiped();
    }

    public SwipeToDismissTouchListener(Callback callback2, int i11, float f11) {
        this(callback2, i11, f11, 0.2f * f11);
    }

    public static SwipeToDismissTouchListener createFromView(View view, Callback callback2) {
        return new SwipeToDismissTouchListener(callback2, ViewConfiguration.get(view.getContext()).getScaledTouchSlop(), ((float) view.getContext().getResources().getDisplayMetrics().heightPixels) * 0.5f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$settleView$0(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onMove(floatValue);
        }
    }

    public float bound(float f11) {
        float f12 = this.maxTranslate;
        if (f11 < (-f12)) {
            return -f12;
        }
        return f11 > f12 ? f12 : f11;
    }

    public double calculateTension(float f11) {
        return 1.0d - (Math.pow((double) Math.abs(f11), 2.0d) / Math.pow((double) (this.closeThreshold * 2.0f), 2.0d));
    }

    public boolean handleTouchEvent(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    float rawX = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    float f11 = rawY - this.initialY;
                    float f12 = rawX - this.lastX;
                    float f13 = rawY - this.lastY;
                    this.lastX = rawX;
                    this.lastY = rawY;
                    if (!isValidPointer(motionEvent)) {
                        return false;
                    }
                    if (!this.isMoving && (!hasMovedEnoughInProperYDirection(f11) || !hasMovedMoreInYDirectionThanX(f12, f13))) {
                        return false;
                    }
                    this.isMoving = true;
                    moveView(view, f13);
                    return false;
                } else if (actionMasked != 3) {
                    if (actionMasked != 5) {
                        return false;
                    }
                    settleView(view);
                    this.isMoving = false;
                    this.pointerIndex = -1;
                    return false;
                }
            }
            boolean z11 = (!isValidPointer(motionEvent) || !this.isMoving) ? false : settleOrCloseView(view);
            this.isMoving = false;
            return z11;
        }
        this.lastX = motionEvent.getRawX();
        float rawY2 = motionEvent.getRawY();
        this.lastY = rawY2;
        this.initialY = rawY2;
        this.isMoving = false;
        this.pointerIndex = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
        return false;
    }

    public boolean hasMovedEnoughInProperYDirection(float f11) {
        return Math.abs(f11) > ((float) this.touchSlop);
    }

    public boolean hasMovedMoreInYDirectionThanX(float f11, float f12) {
        return Math.abs(f12) > Math.abs(f11);
    }

    public boolean isMoving() {
        return this.isMoving;
    }

    public boolean isValidPointer(MotionEvent motionEvent) {
        return this.pointerIndex >= 0 && motionEvent.getPointerCount() == 1;
    }

    public void moveView(View view, float f11) {
        float translationY = view.getTranslationY();
        float bound = bound(translationY + ((float) (((double) f11) * calculateTension(translationY))));
        view.setTranslationY(bound);
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onMove(bound);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z11;
        if (!(view instanceof SwipeableViewProvider) || ((SwipeableViewProvider) view).canBeSwiped() || isMoving()) {
            z11 = handleTouchEvent(view, motionEvent);
        } else {
            z11 = false;
        }
        if (z11 || view.onTouchEvent(motionEvent)) {
            return true;
        }
        return false;
    }

    public void setCallback(Callback callback2) {
        this.callback = callback2;
    }

    public boolean settleOrCloseView(View view) {
        float translationY = view.getTranslationY();
        float f11 = this.closeThreshold;
        if (translationY > f11 || translationY < (-f11)) {
            Callback callback2 = this.callback;
            if (callback2 == null) {
                return true;
            }
            callback2.onDismiss();
            return true;
        }
        settleView(view);
        return false;
    }

    public void settleView(View view) {
        if (view.getTranslationY() != 0.0f) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{0.0f}).setDuration(100);
            duration.addUpdateListener(new c(this));
            duration.start();
        }
    }

    public SwipeToDismissTouchListener(Callback callback2, int i11, float f11, float f12) {
        setCallback(callback2);
        this.touchSlop = i11;
        this.maxTranslate = f11;
        this.closeThreshold = f12;
    }
}
