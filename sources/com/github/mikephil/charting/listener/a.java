package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarLineScatterCandleBubbleData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import e5.d;
import g5.b;
import g5.e;

public class a extends ChartTouchListener<BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends b<? extends Entry>>>> {

    /* renamed from: g  reason: collision with root package name */
    public Matrix f65505g = new Matrix();

    /* renamed from: h  reason: collision with root package name */
    public Matrix f65506h = new Matrix();

    /* renamed from: i  reason: collision with root package name */
    public MPPointF f65507i = MPPointF.c(0.0f, 0.0f);

    /* renamed from: j  reason: collision with root package name */
    public MPPointF f65508j = MPPointF.c(0.0f, 0.0f);

    /* renamed from: k  reason: collision with root package name */
    public float f65509k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    public float f65510l = 1.0f;

    /* renamed from: m  reason: collision with root package name */
    public float f65511m = 1.0f;

    /* renamed from: n  reason: collision with root package name */
    public e f65512n;

    /* renamed from: o  reason: collision with root package name */
    public VelocityTracker f65513o;

    /* renamed from: p  reason: collision with root package name */
    public long f65514p = 0;

    /* renamed from: q  reason: collision with root package name */
    public MPPointF f65515q = MPPointF.c(0.0f, 0.0f);

    /* renamed from: r  reason: collision with root package name */
    public MPPointF f65516r = MPPointF.c(0.0f, 0.0f);

    /* renamed from: s  reason: collision with root package name */
    public float f65517s;

    /* renamed from: t  reason: collision with root package name */
    public float f65518t;

    public a(BarLineChartBase<? extends BarLineScatterCandleBubbleData<? extends b<? extends Entry>>> barLineChartBase, Matrix matrix, float f11) {
        super(barLineChartBase);
        this.f65505g = matrix;
        this.f65517s = Utils.e(f11);
        this.f65518t = Utils.e(3.5f);
    }

    public static float h(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
    }

    public static float i(MotionEvent motionEvent) {
        return Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
    }

    public static void k(MPPointF mPPointF, MotionEvent motionEvent) {
        mPPointF.f65546c = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
        mPPointF.f65547d = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
    }

    public static float p(MotionEvent motionEvent) {
        float x11 = motionEvent.getX(0) - motionEvent.getX(1);
        float y11 = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((double) ((x11 * x11) + (y11 * y11)));
    }

    public void f() {
        MPPointF mPPointF = this.f65516r;
        float f11 = 0.0f;
        if (mPPointF.f65546c != 0.0f || mPPointF.f65547d != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f65516r.f65546c *= ((BarLineChartBase) this.f65504f).getDragDecelerationFrictionCoef();
            this.f65516r.f65547d *= ((BarLineChartBase) this.f65504f).getDragDecelerationFrictionCoef();
            float f12 = ((float) (currentAnimationTimeMillis - this.f65514p)) / 1000.0f;
            MPPointF mPPointF2 = this.f65516r;
            float f13 = mPPointF2.f65546c * f12;
            float f14 = mPPointF2.f65547d * f12;
            MPPointF mPPointF3 = this.f65515q;
            float f15 = mPPointF3.f65546c + f13;
            mPPointF3.f65546c = f15;
            float f16 = mPPointF3.f65547d + f14;
            mPPointF3.f65547d = f16;
            MotionEvent obtain = MotionEvent.obtain(currentAnimationTimeMillis, currentAnimationTimeMillis, 2, f15, f16, 0);
            float f17 = ((BarLineChartBase) this.f65504f).H() ? this.f65515q.f65546c - this.f65507i.f65546c : 0.0f;
            if (((BarLineChartBase) this.f65504f).I()) {
                f11 = this.f65515q.f65547d - this.f65507i.f65547d;
            }
            l(obtain, f17, f11);
            obtain.recycle();
            this.f65505g = ((BarLineChartBase) this.f65504f).getViewPortHandler().J(this.f65505g, this.f65504f, false);
            this.f65514p = currentAnimationTimeMillis;
            if (((double) Math.abs(this.f65516r.f65546c)) >= 0.01d || ((double) Math.abs(this.f65516r.f65547d)) >= 0.01d) {
                Utils.x(this.f65504f);
                return;
            }
            ((BarLineChartBase) this.f65504f).f();
            ((BarLineChartBase) this.f65504f).postInvalidate();
            q();
        }
    }

    public MPPointF g(float f11, float f12) {
        float f13;
        ViewPortHandler viewPortHandler = ((BarLineChartBase) this.f65504f).getViewPortHandler();
        float G = f11 - viewPortHandler.G();
        if (j()) {
            f13 = -(f12 - viewPortHandler.I());
        } else {
            f13 = -((((float) ((BarLineChartBase) this.f65504f).getMeasuredHeight()) - f12) - viewPortHandler.F());
        }
        return MPPointF.c(G, f13);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r0 = r2.f65512n;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean j() {
        /*
            r2 = this;
            g5.e r0 = r2.f65512n
            if (r0 != 0) goto L_0x000e
            T r0 = r2.f65504f
            com.github.mikephil.charting.charts.BarLineChartBase r0 = (com.github.mikephil.charting.charts.BarLineChartBase) r0
            boolean r0 = r0.D()
            if (r0 != 0) goto L_0x0020
        L_0x000e:
            g5.e r0 = r2.f65512n
            if (r0 == 0) goto L_0x0022
            T r1 = r2.f65504f
            com.github.mikephil.charting.charts.BarLineChartBase r1 = (com.github.mikephil.charting.charts.BarLineChartBase) r1
            com.github.mikephil.charting.components.YAxis$AxisDependency r0 = r0.getAxisDependency()
            boolean r0 = r1.e(r0)
            if (r0 == 0) goto L_0x0022
        L_0x0020:
            r0 = 1
            goto L_0x0023
        L_0x0022:
            r0 = 0
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.listener.a.j():boolean");
    }

    public final void l(MotionEvent motionEvent, float f11, float f12) {
        this.f65500b = ChartTouchListener.ChartGesture.DRAG;
        this.f65505g.set(this.f65506h);
        b onChartGestureListener = ((BarLineChartBase) this.f65504f).getOnChartGestureListener();
        if (j()) {
            if (this.f65504f instanceof HorizontalBarChart) {
                f11 = -f11;
            } else {
                f12 = -f12;
            }
        }
        this.f65505g.postTranslate(f11, f12);
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartTranslate(motionEvent, f11, f12);
        }
    }

    public final void m(MotionEvent motionEvent) {
        d k11 = ((BarLineChartBase) this.f65504f).k(motionEvent.getX(), motionEvent.getY());
        if (k11 != null && !k11.a(this.f65502d)) {
            this.f65502d = k11;
            ((BarLineChartBase) this.f65504f).m(k11, true);
        }
    }

    public final void n(MotionEvent motionEvent) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (motionEvent.getPointerCount() >= 2) {
            b onChartGestureListener = ((BarLineChartBase) this.f65504f).getOnChartGestureListener();
            float p11 = p(motionEvent);
            if (p11 > this.f65518t) {
                MPPointF mPPointF = this.f65508j;
                MPPointF g11 = g(mPPointF.f65546c, mPPointF.f65547d);
                ViewPortHandler viewPortHandler = ((BarLineChartBase) this.f65504f).getViewPortHandler();
                int i11 = this.f65501c;
                boolean z15 = true;
                float f11 = 1.0f;
                if (i11 == 4) {
                    this.f65500b = ChartTouchListener.ChartGesture.PINCH_ZOOM;
                    float f12 = p11 / this.f65511m;
                    if (f12 >= 1.0f) {
                        z15 = false;
                    }
                    if (z15) {
                        z13 = viewPortHandler.c();
                    } else {
                        z13 = viewPortHandler.a();
                    }
                    if (z15) {
                        z14 = viewPortHandler.d();
                    } else {
                        z14 = viewPortHandler.b();
                    }
                    float f13 = ((BarLineChartBase) this.f65504f).M() ? f12 : 1.0f;
                    if (((BarLineChartBase) this.f65504f).N()) {
                        f11 = f12;
                    }
                    if (z14 || z13) {
                        this.f65505g.set(this.f65506h);
                        this.f65505g.postScale(f13, f11, g11.f65546c, g11.f65547d);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, f13, f11);
                        }
                    }
                } else if (i11 == 2 && ((BarLineChartBase) this.f65504f).M()) {
                    this.f65500b = ChartTouchListener.ChartGesture.X_ZOOM;
                    float h11 = h(motionEvent) / this.f65509k;
                    if (h11 >= 1.0f) {
                        z15 = false;
                    }
                    if (z15) {
                        z12 = viewPortHandler.c();
                    } else {
                        z12 = viewPortHandler.a();
                    }
                    if (z12) {
                        this.f65505g.set(this.f65506h);
                        this.f65505g.postScale(h11, 1.0f, g11.f65546c, g11.f65547d);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, h11, 1.0f);
                        }
                    }
                } else if (this.f65501c == 3 && ((BarLineChartBase) this.f65504f).N()) {
                    this.f65500b = ChartTouchListener.ChartGesture.Y_ZOOM;
                    float i12 = i(motionEvent) / this.f65510l;
                    if (i12 >= 1.0f) {
                        z15 = false;
                    }
                    if (z15) {
                        z11 = viewPortHandler.d();
                    } else {
                        z11 = viewPortHandler.b();
                    }
                    if (z11) {
                        this.f65505g.set(this.f65506h);
                        this.f65505g.postScale(1.0f, i12, g11.f65546c, g11.f65547d);
                        if (onChartGestureListener != null) {
                            onChartGestureListener.onChartScale(motionEvent, 1.0f, i12);
                        }
                    }
                }
                MPPointF.f(g11);
            }
        }
    }

    public final void o(MotionEvent motionEvent) {
        this.f65506h.set(this.f65505g);
        this.f65507i.f65546c = motionEvent.getX();
        this.f65507i.f65547d = motionEvent.getY();
        this.f65512n = ((BarLineChartBase) this.f65504f).B(motionEvent.getX(), motionEvent.getY());
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.f65500b = ChartTouchListener.ChartGesture.DOUBLE_TAP;
        b onChartGestureListener = ((BarLineChartBase) this.f65504f).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartDoubleTapped(motionEvent);
        }
        if (((BarLineChartBase) this.f65504f).F() && ((BarLineScatterCandleBubbleData) ((BarLineChartBase) this.f65504f).getData()).h() > 0) {
            MPPointF g11 = g(motionEvent.getX(), motionEvent.getY());
            T t11 = this.f65504f;
            BarLineChartBase barLineChartBase = (BarLineChartBase) t11;
            float f11 = 1.4f;
            float f12 = ((BarLineChartBase) t11).M() ? 1.4f : 1.0f;
            if (!((BarLineChartBase) this.f65504f).N()) {
                f11 = 1.0f;
            }
            barLineChartBase.Q(f12, f11, g11.f65546c, g11.f65547d);
            if (((BarLineChartBase) this.f65504f).r()) {
                Log.i("BarlineChartTouch", "Double-Tap, Zooming In, x: " + g11.f65546c + ", y: " + g11.f65547d);
            }
            MPPointF.f(g11);
        }
        return super.onDoubleTap(motionEvent);
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        this.f65500b = ChartTouchListener.ChartGesture.FLING;
        b onChartGestureListener = ((BarLineChartBase) this.f65504f).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartFling(motionEvent, motionEvent2, f11, f12);
        }
        return super.onFling(motionEvent, motionEvent2, f11, f12);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.f65500b = ChartTouchListener.ChartGesture.LONG_PRESS;
        b onChartGestureListener = ((BarLineChartBase) this.f65504f).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f65500b = ChartTouchListener.ChartGesture.SINGLE_TAP;
        b onChartGestureListener = ((BarLineChartBase) this.f65504f).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        if (!((BarLineChartBase) this.f65504f).q()) {
            return false;
        }
        c(((BarLineChartBase) this.f65504f).k(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return super.onSingleTapUp(motionEvent);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (this.f65513o == null) {
            this.f65513o = VelocityTracker.obtain();
        }
        this.f65513o.addMovement(motionEvent);
        int i11 = 3;
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.f65513o) != null) {
            velocityTracker.recycle();
            this.f65513o = null;
        }
        if (this.f65501c == 0) {
            this.f65503e.onTouchEvent(motionEvent);
        }
        if (!((BarLineChartBase) this.f65504f).G() && !((BarLineChartBase) this.f65504f).M() && !((BarLineChartBase) this.f65504f).N()) {
            return true;
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            boolean z11 = false;
            if (action == 1) {
                VelocityTracker velocityTracker2 = this.f65513o;
                int pointerId = motionEvent.getPointerId(0);
                velocityTracker2.computeCurrentVelocity(1000, (float) Utils.o());
                float yVelocity = velocityTracker2.getYVelocity(pointerId);
                float xVelocity = velocityTracker2.getXVelocity(pointerId);
                if ((Math.abs(xVelocity) > ((float) Utils.p()) || Math.abs(yVelocity) > ((float) Utils.p())) && this.f65501c == 1 && ((BarLineChartBase) this.f65504f).o()) {
                    q();
                    this.f65514p = AnimationUtils.currentAnimationTimeMillis();
                    this.f65515q.f65546c = motionEvent.getX();
                    this.f65515q.f65547d = motionEvent.getY();
                    MPPointF mPPointF = this.f65516r;
                    mPPointF.f65546c = xVelocity;
                    mPPointF.f65547d = yVelocity;
                    Utils.x(this.f65504f);
                }
                int i12 = this.f65501c;
                if (i12 == 2 || i12 == 3 || i12 == 4 || i12 == 5) {
                    ((BarLineChartBase) this.f65504f).f();
                    ((BarLineChartBase) this.f65504f).postInvalidate();
                }
                this.f65501c = 0;
                ((BarLineChartBase) this.f65504f).j();
                VelocityTracker velocityTracker3 = this.f65513o;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f65513o = null;
                }
                b(motionEvent);
            } else if (action == 2) {
                int i13 = this.f65501c;
                if (i13 == 1) {
                    ((BarLineChartBase) this.f65504f).g();
                    float f11 = 0.0f;
                    float x11 = ((BarLineChartBase) this.f65504f).H() ? motionEvent.getX() - this.f65507i.f65546c : 0.0f;
                    if (((BarLineChartBase) this.f65504f).I()) {
                        f11 = motionEvent.getY() - this.f65507i.f65547d;
                    }
                    l(motionEvent, x11, f11);
                } else if (i13 == 2 || i13 == 3 || i13 == 4) {
                    ((BarLineChartBase) this.f65504f).g();
                    if (((BarLineChartBase) this.f65504f).M() || ((BarLineChartBase) this.f65504f).N()) {
                        n(motionEvent);
                    }
                } else if (i13 == 0 && Math.abs(ChartTouchListener.a(motionEvent.getX(), this.f65507i.f65546c, motionEvent.getY(), this.f65507i.f65547d)) > this.f65517s && ((BarLineChartBase) this.f65504f).G()) {
                    if (!((BarLineChartBase) this.f65504f).J() || !((BarLineChartBase) this.f65504f).C()) {
                        z11 = true;
                    }
                    if (z11) {
                        float abs = Math.abs(motionEvent.getX() - this.f65507i.f65546c);
                        float abs2 = Math.abs(motionEvent.getY() - this.f65507i.f65547d);
                        if ((((BarLineChartBase) this.f65504f).H() || abs2 >= abs) && (((BarLineChartBase) this.f65504f).I() || abs2 <= abs)) {
                            this.f65500b = ChartTouchListener.ChartGesture.DRAG;
                            this.f65501c = 1;
                        }
                    } else if (((BarLineChartBase) this.f65504f).K()) {
                        this.f65500b = ChartTouchListener.ChartGesture.DRAG;
                        if (((BarLineChartBase) this.f65504f).K()) {
                            m(motionEvent);
                        }
                    }
                }
            } else if (action == 3) {
                this.f65501c = 0;
                b(motionEvent);
            } else if (action != 5) {
                if (action == 6) {
                    Utils.z(motionEvent, this.f65513o);
                    this.f65501c = 5;
                }
            } else if (motionEvent.getPointerCount() >= 2) {
                ((BarLineChartBase) this.f65504f).g();
                o(motionEvent);
                this.f65509k = h(motionEvent);
                this.f65510l = i(motionEvent);
                float p11 = p(motionEvent);
                this.f65511m = p11;
                if (p11 > 10.0f) {
                    if (((BarLineChartBase) this.f65504f).L()) {
                        this.f65501c = 4;
                    } else if (((BarLineChartBase) this.f65504f).M() != ((BarLineChartBase) this.f65504f).N()) {
                        if (((BarLineChartBase) this.f65504f).M()) {
                            i11 = 2;
                        }
                        this.f65501c = i11;
                    } else {
                        if (this.f65509k > this.f65510l) {
                            i11 = 2;
                        }
                        this.f65501c = i11;
                    }
                }
                k(this.f65508j, motionEvent);
            }
        } else {
            e(motionEvent);
            q();
            o(motionEvent);
        }
        this.f65505g = ((BarLineChartBase) this.f65504f).getViewPortHandler().J(this.f65505g, this.f65504f, true);
        return true;
    }

    public void q() {
        MPPointF mPPointF = this.f65516r;
        mPPointF.f65546c = 0.0f;
        mPPointF.f65547d = 0.0f;
    }
}
