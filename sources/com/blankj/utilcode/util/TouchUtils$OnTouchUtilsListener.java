package com.blankj.utilcode.util;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;

public abstract class TouchUtils$OnTouchUtilsListener implements View.OnTouchListener {

    /* renamed from: b  reason: collision with root package name */
    public int f63523b;

    /* renamed from: c  reason: collision with root package name */
    public int f63524c;

    /* renamed from: d  reason: collision with root package name */
    public int f63525d;

    /* renamed from: e  reason: collision with root package name */
    public int f63526e;

    /* renamed from: f  reason: collision with root package name */
    public int f63527f;

    /* renamed from: g  reason: collision with root package name */
    public int f63528g;

    /* renamed from: h  reason: collision with root package name */
    public int f63529h;

    /* renamed from: i  reason: collision with root package name */
    public VelocityTracker f63530i;

    /* renamed from: j  reason: collision with root package name */
    public int f63531j;

    /* renamed from: k  reason: collision with root package name */
    public int f63532k;

    public TouchUtils$OnTouchUtilsListener() {
        g(-1, -1);
    }

    public abstract boolean a(View view, int i11, int i12, MotionEvent motionEvent);

    public abstract boolean b(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, MotionEvent motionEvent);

    public abstract boolean c(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, MotionEvent motionEvent);

    public boolean d(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        g(rawX, rawY);
        view.setPressed(true);
        return a(view, rawX, rawY, motionEvent);
    }

    public boolean e(View view, MotionEvent motionEvent) {
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        if (this.f63524c == -1) {
            g(rawX, rawY);
            view.setPressed(true);
        }
        if (this.f63528g != 1) {
            if (Math.abs(rawX - this.f63526e) < this.f63523b && Math.abs(rawY - this.f63527f) < this.f63523b) {
                return true;
            }
            this.f63528g = 1;
            if (Math.abs(rawX - this.f63526e) >= Math.abs(rawY - this.f63527f)) {
                if (rawX - this.f63526e < 0) {
                    this.f63529h = 1;
                } else {
                    this.f63529h = 4;
                }
            } else if (rawY - this.f63527f < 0) {
                this.f63529h = 2;
            } else {
                this.f63529h = 8;
            }
        }
        boolean b11 = b(view, this.f63529h, rawX, rawY, rawX - this.f63526e, rawY - this.f63527f, rawX - this.f63524c, rawY - this.f63525d, motionEvent);
        this.f63526e = rawX;
        this.f63527f = rawY;
        return b11;
    }

    public boolean f(View view, MotionEvent motionEvent) {
        int i11;
        int i12;
        int rawX = (int) motionEvent.getRawX();
        int rawY = (int) motionEvent.getRawY();
        VelocityTracker velocityTracker = this.f63530i;
        if (velocityTracker != null) {
            velocityTracker.computeCurrentVelocity(1000, (float) this.f63531j);
            int xVelocity = (int) this.f63530i.getXVelocity();
            int yVelocity = (int) this.f63530i.getYVelocity();
            this.f63530i.recycle();
            if (Math.abs(xVelocity) < this.f63532k) {
                xVelocity = 0;
            }
            if (Math.abs(yVelocity) < this.f63532k) {
                yVelocity = 0;
            }
            this.f63530i = null;
            i12 = xVelocity;
            i11 = yVelocity;
        } else {
            i12 = 0;
            i11 = 0;
        }
        view.setPressed(false);
        boolean c11 = c(view, this.f63529h, rawX, rawY, rawX - this.f63524c, rawY - this.f63525d, i12, i11, motionEvent);
        if (motionEvent.getAction() == 1 && this.f63528g == 0) {
            if (motionEvent.getEventTime() - motionEvent.getDownTime() <= 1000) {
                view.performClick();
            } else {
                view.performLongClick();
            }
        }
        g(-1, -1);
        return c11;
    }

    public final void g(int i11, int i12) {
        this.f63524c = i11;
        this.f63525d = i12;
        this.f63526e = i11;
        this.f63527f = i12;
        this.f63528g = 0;
        this.f63529h = 0;
        VelocityTracker velocityTracker = this.f63530i;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f63523b == 0) {
            this.f63523b = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        }
        if (this.f63531j == 0) {
            this.f63531j = ViewConfiguration.get(view.getContext()).getScaledMaximumFlingVelocity();
        }
        if (this.f63532k == 0) {
            this.f63532k = ViewConfiguration.get(view.getContext()).getScaledMinimumFlingVelocity();
        }
        if (this.f63530i == null) {
            this.f63530i = VelocityTracker.obtain();
        }
        this.f63530i.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            return d(view, motionEvent);
        }
        if (action != 1) {
            if (action == 2) {
                return e(view, motionEvent);
            }
            if (action != 3) {
                return false;
            }
        }
        return f(view, motionEvent);
    }
}
