package com.huochat.community.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.huochat.community.util.ScreemTool;
import kotlin.jvm.internal.r;

public final class DragImageHelperLayout extends FrameLayout {
    private final PointF currentPosition;
    private final boolean enableDrag;
    private boolean isIntercept;
    private int maxMoveExitLength;
    private float minScale;
    private OnMoveExitListener moveExitListener;
    private final PointF orgPosition;
    private int screenHeight;
    private final PointF topPosition;

    public interface OnMoveExitListener {
        void onExit();

        void onMove(float f11);

        void restore();
    }

    public DragImageHelperLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxMoveExitLength = ScreemTool.getScreenHeight(context) / 4;
        this.minScale = 0.4f;
        this.enableDrag = true;
        this.screenHeight = ScreemTool.getScreenHeight(context);
        this.orgPosition = new PointF();
        this.currentPosition = new PointF();
        this.topPosition = new PointF();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.enableDrag || motionEvent.getPointerCount() > 1) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.topPosition.x = getX();
            this.topPosition.y = getY();
            this.orgPosition.x = motionEvent.getRawX();
            this.orgPosition.y = motionEvent.getRawY();
        } else if (actionMasked == 2) {
            this.currentPosition.x = motionEvent.getRawX();
            this.currentPosition.y = motionEvent.getRawY();
            if (this.isIntercept) {
                setX((this.currentPosition.x - this.orgPosition.x) + this.topPosition.x);
                setY((this.currentPosition.y - this.orgPosition.y) + this.topPosition.y);
                float f11 = this.currentPosition.y;
                float f12 = this.orgPosition.y;
                float f13 = 0.0f;
                if (f11 - f12 > 0.0f) {
                    f13 = ((f11 - f12) * 1.0f) / ((float) this.screenHeight);
                }
                float min = Math.min(1.0f, Math.max(this.minScale, ((float) 1) - f13));
                OnMoveExitListener onMoveExitListener = this.moveExitListener;
                if (onMoveExitListener != null) {
                    onMoveExitListener.onMove(min);
                }
                setScaleX(min);
                setScaleY(min);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final boolean getEnableDrag() {
        return this.enableDrag;
    }

    public final int getMaxMoveExitLength() {
        return this.maxMoveExitLength;
    }

    public final float getMinScale() {
        return this.minScale;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.enableDrag || motionEvent.getPointerCount() > 1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked != 2) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        float abs = Math.abs(this.currentPosition.y - this.orgPosition.y);
        float abs2 = Math.abs(this.currentPosition.x - this.orgPosition.x);
        float f11 = (float) scaledTouchSlop;
        if (abs < f11 && abs2 >= f11) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (abs <= abs2) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        this.isIntercept = true;
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.enableDrag) {
            return super.onTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z11 = true;
        if (actionMasked == 1 || actionMasked == 3) {
            this.isIntercept = false;
            if (Math.abs(this.currentPosition.y - this.orgPosition.y) < ((float) this.maxMoveExitLength)) {
                z11 = false;
            }
            if (z11) {
                OnMoveExitListener onMoveExitListener = this.moveExitListener;
                if (onMoveExitListener != null) {
                    onMoveExitListener.onExit();
                }
            } else {
                OnMoveExitListener onMoveExitListener2 = this.moveExitListener;
                if (onMoveExitListener2 != null) {
                    onMoveExitListener2.restore();
                }
                animate().setDuration(200).x(this.topPosition.x).y(this.topPosition.y).scaleX(1.0f).scaleY(1.0f).start();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setMaxMoveExitLength(int i11) {
        this.maxMoveExitLength = i11;
    }

    public final void setMinScale(float f11) {
        this.minScale = f11;
    }

    public final void setOnMoveExitListener(OnMoveExitListener onMoveExitListener) {
        this.moveExitListener = onMoveExitListener;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DragImageHelperLayout(Context context, AttributeSet attributeSet, int i11, r rVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }
}
