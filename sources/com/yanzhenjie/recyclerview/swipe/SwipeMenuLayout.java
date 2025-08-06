package com.yanzhenjie.recyclerview.swipe;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.TextView;
import androidx.core.view.h0;
import com.yanzhenjie.recyclerview.swipe.SwipeHorizontal;
import dz.h;

public class SwipeMenuLayout extends FrameLayout implements h {

    /* renamed from: b  reason: collision with root package name */
    public int f52636b;

    /* renamed from: c  reason: collision with root package name */
    public int f52637c;

    /* renamed from: d  reason: collision with root package name */
    public int f52638d;

    /* renamed from: e  reason: collision with root package name */
    public float f52639e;

    /* renamed from: f  reason: collision with root package name */
    public int f52640f;

    /* renamed from: g  reason: collision with root package name */
    public int f52641g;

    /* renamed from: h  reason: collision with root package name */
    public int f52642h;

    /* renamed from: i  reason: collision with root package name */
    public int f52643i;

    /* renamed from: j  reason: collision with root package name */
    public int f52644j;

    /* renamed from: k  reason: collision with root package name */
    public int f52645k;

    /* renamed from: l  reason: collision with root package name */
    public View f52646l;

    /* renamed from: m  reason: collision with root package name */
    public a f52647m;

    /* renamed from: n  reason: collision with root package name */
    public b f52648n;

    /* renamed from: o  reason: collision with root package name */
    public SwipeHorizontal f52649o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f52650p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f52651q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f52652r;

    /* renamed from: s  reason: collision with root package name */
    public OverScroller f52653s;

    /* renamed from: t  reason: collision with root package name */
    public VelocityTracker f52654t;

    /* renamed from: u  reason: collision with root package name */
    public int f52655u;

    /* renamed from: v  reason: collision with root package name */
    public int f52656v;

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public boolean a() {
        return g() || k();
    }

    public float b(float f11) {
        return (float) Math.sin((double) ((float) (((double) (f11 - 0.5f)) * 0.4712389167638204d)));
    }

    public final int c(MotionEvent motionEvent, int i11) {
        int i12;
        int x11 = (int) (motionEvent.getX() - ((float) getScrollX()));
        int g11 = this.f52649o.g();
        int i13 = g11 / 2;
        float f11 = (float) g11;
        float f12 = (float) i13;
        float b11 = f12 + (b(Math.min(1.0f, (((float) Math.abs(x11)) * 1.0f) / f11)) * f12);
        if (i11 > 0) {
            i12 = Math.round(Math.abs(b11 / ((float) i11)) * 1000.0f) * 4;
        } else {
            i12 = (int) (((((float) Math.abs(x11)) / f11) + 1.0f) * 100.0f);
        }
        return Math.min(i12, this.f52640f);
    }

    public void computeScroll() {
        SwipeHorizontal swipeHorizontal;
        if (this.f52653s.computeScrollOffset() && (swipeHorizontal = this.f52649o) != null) {
            if (swipeHorizontal instanceof b) {
                scrollTo(Math.abs(this.f52653s.getCurrX()), 0);
                invalidate();
                return;
            }
            scrollTo(-Math.abs(this.f52653s.getCurrX()), 0);
            invalidate();
        }
    }

    public boolean d() {
        a aVar = this.f52647m;
        return aVar != null && aVar.c();
    }

    public boolean e() {
        b bVar = this.f52648n;
        return bVar != null && bVar.c();
    }

    public boolean f() {
        a aVar = this.f52647m;
        return aVar != null && !aVar.i(getScrollX());
    }

    public boolean g() {
        a aVar = this.f52647m;
        return aVar != null && aVar.j(getScrollX());
    }

    public float getOpenPercent() {
        return this.f52639e;
    }

    public boolean h() {
        a aVar = this.f52647m;
        return aVar != null && aVar.k(getScrollX());
    }

    public boolean i() {
        return h() || l();
    }

    public boolean j() {
        b bVar = this.f52648n;
        return bVar != null && !bVar.i(getScrollX());
    }

    public boolean k() {
        b bVar = this.f52648n;
        return bVar != null && bVar.j(getScrollX());
    }

    public boolean l() {
        b bVar = this.f52648n;
        return bVar != null && bVar.k(getScrollX());
    }

    public boolean m() {
        return this.f52652r;
    }

    public final void n(int i11, int i12) {
        if (this.f52649o == null) {
            return;
        }
        if (((float) Math.abs(getScrollX())) < ((float) this.f52649o.f().getWidth()) * this.f52639e) {
            o();
        } else if (Math.abs(i11) > this.f52641g || Math.abs(i12) > this.f52641g) {
            if (i()) {
                o();
            } else {
                q();
            }
        } else if (a()) {
            o();
        } else {
            q();
        }
    }

    public void o() {
        p(this.f52640f);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        int i11 = this.f52636b;
        if (i11 != 0 && this.f52647m == null) {
            this.f52647m = new a(findViewById(i11));
        }
        int i12 = this.f52638d;
        if (i12 != 0 && this.f52648n == null) {
            this.f52648n = new b(findViewById(i12));
        }
        int i13 = this.f52637c;
        if (i13 == 0 || this.f52646l != null) {
            TextView textView = new TextView(getContext());
            textView.setClickable(true);
            textView.setGravity(17);
            textView.setTextSize(16.0f);
            textView.setText("You may not have set the ContentView.");
            this.f52646l = textView;
            addView(textView);
            return;
        }
        this.f52646l = findViewById(i13);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            int x11 = (int) motionEvent.getX();
            this.f52642h = x11;
            this.f52644j = x11;
            this.f52645k = (int) motionEvent.getY();
            return false;
        } else if (action == 1) {
            SwipeHorizontal swipeHorizontal = this.f52649o;
            boolean z11 = swipeHorizontal != null && swipeHorizontal.h(getWidth(), motionEvent.getX());
            if (!a() || !z11) {
                return false;
            }
            o();
            return true;
        } else if (action == 2) {
            int x12 = (int) (motionEvent.getX() - ((float) this.f52644j));
            int y11 = (int) (motionEvent.getY() - ((float) this.f52645k));
            if (Math.abs(x12) <= this.f52641g || Math.abs(x12) <= Math.abs(y11)) {
                return false;
            }
            return true;
        } else if (action != 3) {
            return onInterceptTouchEvent;
        } else {
            if (!this.f52653s.isFinished()) {
                this.f52653s.abortAnimation();
            }
            return false;
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        View view = this.f52646l;
        if (view != null) {
            int measuredWidthAndState = view.getMeasuredWidthAndState();
            int measuredHeightAndState = this.f52646l.getMeasuredHeightAndState();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop() + ((FrameLayout.LayoutParams) this.f52646l.getLayoutParams()).topMargin;
            this.f52646l.layout(paddingLeft, paddingTop, measuredWidthAndState + paddingLeft, measuredHeightAndState + paddingTop);
        }
        a aVar = this.f52647m;
        if (aVar != null) {
            View f11 = aVar.f();
            int measuredWidthAndState2 = f11.getMeasuredWidthAndState();
            int measuredHeightAndState2 = f11.getMeasuredHeightAndState();
            int paddingTop2 = getPaddingTop() + ((FrameLayout.LayoutParams) f11.getLayoutParams()).topMargin;
            f11.layout(-measuredWidthAndState2, paddingTop2, 0, measuredHeightAndState2 + paddingTop2);
        }
        b bVar = this.f52648n;
        if (bVar != null) {
            View f12 = bVar.f();
            int measuredWidthAndState3 = f12.getMeasuredWidthAndState();
            int measuredHeightAndState3 = f12.getMeasuredHeightAndState();
            int paddingTop3 = getPaddingTop() + ((FrameLayout.LayoutParams) f12.getLayoutParams()).topMargin;
            int measuredWidthAndState4 = getMeasuredWidthAndState();
            f12.layout(measuredWidthAndState4, paddingTop3, measuredWidthAndState3 + measuredWidthAndState4, measuredHeightAndState3 + paddingTop3);
        }
    }

    public void onMeasure(int i11, int i12) {
        int i13;
        super.onMeasure(i11, i12);
        View view = this.f52646l;
        if (view != null) {
            measureChildWithMargins(view, i11, 0, i12, 0);
            i13 = this.f52646l.getMeasuredHeight();
        } else {
            i13 = 0;
        }
        a aVar = this.f52647m;
        if (aVar != null) {
            View f11 = aVar.f();
            f11.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i13 == 0 ? f11.getMeasuredHeightAndState() : i13, 1073741824));
        }
        b bVar = this.f52648n;
        if (bVar != null) {
            View f12 = bVar.f();
            f12.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i13 == 0 ? f12.getMeasuredHeightAndState() : i13, 1073741824));
        }
        if (i13 > 0) {
            setMeasuredDimension(View.MeasureSpec.getSize(i11), i13);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f52654t == null) {
            this.f52654t = VelocityTracker.obtain();
        }
        this.f52654t.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f52642h = (int) motionEvent.getX();
            this.f52643i = (int) motionEvent.getY();
        } else if (action == 1) {
            int x11 = (int) (((float) this.f52644j) - motionEvent.getX());
            int y11 = (int) (((float) this.f52645k) - motionEvent.getY());
            this.f52651q = false;
            this.f52654t.computeCurrentVelocity(1000, (float) this.f52656v);
            int xVelocity = (int) this.f52654t.getXVelocity();
            int abs = Math.abs(xVelocity);
            if (abs <= this.f52655u) {
                n(x11, y11);
            } else if (this.f52649o != null) {
                int c11 = c(motionEvent, abs);
                if (this.f52649o instanceof b) {
                    if (xVelocity < 0) {
                        r(c11);
                    } else {
                        p(c11);
                    }
                } else if (xVelocity > 0) {
                    r(c11);
                } else {
                    p(c11);
                }
                h0.n0(this);
            }
            this.f52654t.clear();
            this.f52654t.recycle();
            this.f52654t = null;
            if (Math.abs(((float) this.f52644j) - motionEvent.getX()) > ((float) this.f52641g) || Math.abs(((float) this.f52645k) - motionEvent.getY()) > ((float) this.f52641g) || g() || k()) {
                motionEvent.setAction(3);
                super.onTouchEvent(motionEvent);
                return true;
            }
        } else if (action != 2) {
            if (action == 3) {
                this.f52651q = false;
                if (!this.f52653s.isFinished()) {
                    this.f52653s.abortAnimation();
                } else {
                    n((int) (((float) this.f52644j) - motionEvent.getX()), (int) (((float) this.f52645k) - motionEvent.getY()));
                }
            }
        } else if (m()) {
            int x12 = (int) (((float) this.f52642h) - motionEvent.getX());
            int y12 = (int) (((float) this.f52643i) - motionEvent.getY());
            if (!this.f52651q && Math.abs(x12) > this.f52641g && Math.abs(x12) > Math.abs(y12)) {
                this.f52651q = true;
            }
            if (this.f52651q) {
                if (this.f52649o == null || this.f52650p) {
                    if (x12 < 0) {
                        a aVar = this.f52647m;
                        if (aVar != null) {
                            this.f52649o = aVar;
                        } else {
                            this.f52649o = this.f52648n;
                        }
                    } else {
                        b bVar = this.f52648n;
                        if (bVar != null) {
                            this.f52649o = bVar;
                        } else {
                            this.f52649o = this.f52647m;
                        }
                    }
                }
                scrollBy(x12, 0);
                this.f52642h = (int) motionEvent.getX();
                this.f52643i = (int) motionEvent.getY();
                this.f52650p = false;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p(int i11) {
        SwipeHorizontal swipeHorizontal = this.f52649o;
        if (swipeHorizontal != null) {
            swipeHorizontal.a(this.f52653s, getScrollX(), i11);
            invalidate();
        }
    }

    public void q() {
        r(this.f52640f);
    }

    public final void r(int i11) {
        SwipeHorizontal swipeHorizontal = this.f52649o;
        if (swipeHorizontal != null) {
            swipeHorizontal.b(this.f52653s, getScrollX(), i11);
            invalidate();
        }
    }

    public void scrollTo(int i11, int i12) {
        SwipeHorizontal swipeHorizontal = this.f52649o;
        if (swipeHorizontal == null) {
            super.scrollTo(i11, i12);
            return;
        }
        SwipeHorizontal.Checker d11 = swipeHorizontal.d(i11, i12);
        this.f52650p = d11.f52635c;
        if (d11.f52633a != getScrollX()) {
            super.scrollTo(d11.f52633a, d11.f52634b);
        }
    }

    public void setOpenPercent(float f11) {
        this.f52639e = f11;
    }

    public void setScrollerDuration(int i11) {
        this.f52640f = i11;
    }

    public void setSwipeEnable(boolean z11) {
        this.f52652r = z11;
    }

    public SwipeMenuLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f52636b = 0;
        this.f52637c = 0;
        this.f52638d = 0;
        this.f52639e = 0.5f;
        this.f52640f = 200;
        this.f52652r = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.recycler_swipe_SwipeMenuLayout);
        this.f52636b = obtainStyledAttributes.getResourceId(R$styleable.recycler_swipe_SwipeMenuLayout_leftViewId, this.f52636b);
        this.f52637c = obtainStyledAttributes.getResourceId(R$styleable.recycler_swipe_SwipeMenuLayout_contentViewId, this.f52637c);
        this.f52638d = obtainStyledAttributes.getResourceId(R$styleable.recycler_swipe_SwipeMenuLayout_rightViewId, this.f52638d);
        obtainStyledAttributes.recycle();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f52641g = viewConfiguration.getScaledTouchSlop();
        this.f52655u = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f52656v = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f52653s = new OverScroller(getContext());
    }
}
