package com.yalantis.ucrop.util;

import android.view.MotionEvent;

public class RotationGestureDetector {
    private static final int INVALID_POINTER_INDEX = -1;
    private float fX;
    private float fY;
    private float mAngle;
    private boolean mIsFirstTouch;
    private OnRotationGestureListener mListener;
    private int mPointerIndex1 = -1;
    private int mPointerIndex2 = -1;
    private float sX;
    private float sY;

    public interface OnRotationGestureListener {
        boolean onRotation(RotationGestureDetector rotationGestureDetector);
    }

    public static class SimpleOnRotationGestureListener implements OnRotationGestureListener {
        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            return false;
        }
    }

    public RotationGestureDetector(OnRotationGestureListener onRotationGestureListener) {
        this.mListener = onRotationGestureListener;
    }

    private float calculateAngleBetweenLines(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        return calculateAngleDelta((float) Math.toDegrees((double) ((float) Math.atan2((double) (f12 - f14), (double) (f11 - f13)))), (float) Math.toDegrees((double) ((float) Math.atan2((double) (f16 - f18), (double) (f15 - f17)))));
    }

    private float calculateAngleDelta(float f11, float f12) {
        float f13 = (f12 % 360.0f) - (f11 % 360.0f);
        this.mAngle = f13;
        if (f13 < -180.0f) {
            this.mAngle = f13 + 360.0f;
        } else if (f13 > 180.0f) {
            this.mAngle = f13 - 360.0f;
        }
        return this.mAngle;
    }

    public float getAngle() {
        return this.mAngle;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.sX = motionEvent.getX();
            this.sY = motionEvent.getY();
            this.mPointerIndex1 = motionEvent2.findPointerIndex(motionEvent2.getPointerId(0));
            this.mAngle = 0.0f;
            this.mIsFirstTouch = true;
        } else if (actionMasked == 1) {
            this.mPointerIndex1 = -1;
        } else if (actionMasked != 2) {
            if (actionMasked == 5) {
                this.fX = motionEvent.getX();
                this.fY = motionEvent.getY();
                this.mPointerIndex2 = motionEvent2.findPointerIndex(motionEvent2.getPointerId(motionEvent.getActionIndex()));
                this.mAngle = 0.0f;
                this.mIsFirstTouch = true;
            } else if (actionMasked == 6) {
                this.mPointerIndex2 = -1;
            }
        } else if (!(this.mPointerIndex1 == -1 || this.mPointerIndex2 == -1 || motionEvent.getPointerCount() <= this.mPointerIndex2)) {
            float x11 = motionEvent2.getX(this.mPointerIndex1);
            float y11 = motionEvent2.getY(this.mPointerIndex1);
            float x12 = motionEvent2.getX(this.mPointerIndex2);
            float y12 = motionEvent2.getY(this.mPointerIndex2);
            if (this.mIsFirstTouch) {
                this.mAngle = 0.0f;
                this.mIsFirstTouch = false;
            } else {
                calculateAngleBetweenLines(this.fX, this.fY, this.sX, this.sY, x12, y12, x11, y11);
            }
            OnRotationGestureListener onRotationGestureListener = this.mListener;
            if (onRotationGestureListener != null) {
                onRotationGestureListener.onRotation(this);
            }
            this.fX = x12;
            this.fY = y12;
            this.sX = x11;
            this.sY = y11;
        }
        return true;
    }
}
