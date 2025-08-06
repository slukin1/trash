package com.github.mikephil.charting.listener;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.github.mikephil.charting.charts.PieRadarChartBase;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;

public class c extends ChartTouchListener<PieRadarChartBase<?>> {

    /* renamed from: g  reason: collision with root package name */
    public MPPointF f65519g = MPPointF.c(0.0f, 0.0f);

    /* renamed from: h  reason: collision with root package name */
    public float f65520h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    public ArrayList<a> f65521i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    public long f65522j = 0;

    /* renamed from: k  reason: collision with root package name */
    public float f65523k = 0.0f;

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public long f65524a;

        /* renamed from: b  reason: collision with root package name */
        public float f65525b;

        public a(long j11, float f11) {
            this.f65524a = j11;
            this.f65525b = f11;
        }
    }

    public c(PieRadarChartBase<?> pieRadarChartBase) {
        super(pieRadarChartBase);
    }

    public final float f() {
        if (this.f65521i.isEmpty()) {
            return 0.0f;
        }
        boolean z11 = false;
        a aVar = this.f65521i.get(0);
        ArrayList<a> arrayList = this.f65521i;
        a aVar2 = arrayList.get(arrayList.size() - 1);
        a aVar3 = aVar;
        for (int size = this.f65521i.size() - 1; size >= 0; size--) {
            aVar3 = this.f65521i.get(size);
            if (aVar3.f65525b != aVar2.f65525b) {
                break;
            }
        }
        float f11 = ((float) (aVar2.f65524a - aVar.f65524a)) / 1000.0f;
        if (f11 == 0.0f) {
            f11 = 0.1f;
        }
        float f12 = aVar2.f65525b;
        float f13 = aVar3.f65525b;
        if (f12 >= f13) {
            z11 = true;
        }
        if (((double) Math.abs(f12 - f13)) > 270.0d) {
            z11 = !z11;
        }
        float f14 = aVar2.f65525b;
        float f15 = aVar.f65525b;
        if (((double) (f14 - f15)) > 180.0d) {
            aVar.f65525b = (float) (((double) f15) + 360.0d);
        } else if (((double) (f15 - f14)) > 180.0d) {
            aVar2.f65525b = (float) (((double) f14) + 360.0d);
        }
        float abs = Math.abs((aVar2.f65525b - aVar.f65525b) / f11);
        return !z11 ? -abs : abs;
    }

    public void g() {
        if (this.f65523k != 0.0f) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f65523k *= ((PieRadarChartBase) this.f65504f).getDragDecelerationFrictionCoef();
            T t11 = this.f65504f;
            ((PieRadarChartBase) t11).setRotationAngle(((PieRadarChartBase) t11).getRotationAngle() + (this.f65523k * (((float) (currentAnimationTimeMillis - this.f65522j)) / 1000.0f)));
            this.f65522j = currentAnimationTimeMillis;
            if (((double) Math.abs(this.f65523k)) >= 0.001d) {
                Utils.x(this.f65504f);
            } else {
                k();
            }
        }
    }

    public final void h() {
        this.f65521i.clear();
    }

    public final void i(float f11, float f12) {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        this.f65521i.add(new a(currentAnimationTimeMillis, ((PieRadarChartBase) this.f65504f).y(f11, f12)));
        for (int size = this.f65521i.size(); size - 2 > 0 && currentAnimationTimeMillis - this.f65521i.get(0).f65524a > 1000; size--) {
            this.f65521i.remove(0);
        }
    }

    public void j(float f11, float f12) {
        this.f65520h = ((PieRadarChartBase) this.f65504f).y(f11, f12) - ((PieRadarChartBase) this.f65504f).getRawRotationAngle();
    }

    public void k() {
        this.f65523k = 0.0f;
    }

    public void l(float f11, float f12) {
        T t11 = this.f65504f;
        ((PieRadarChartBase) t11).setRotationAngle(((PieRadarChartBase) t11).y(f11, f12) - this.f65520h);
    }

    public void onLongPress(MotionEvent motionEvent) {
        this.f65500b = ChartTouchListener.ChartGesture.LONG_PRESS;
        b onChartGestureListener = ((PieRadarChartBase) this.f65504f).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartLongPressed(motionEvent);
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return true;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.f65500b = ChartTouchListener.ChartGesture.SINGLE_TAP;
        b onChartGestureListener = ((PieRadarChartBase) this.f65504f).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.onChartSingleTapped(motionEvent);
        }
        if (!((PieRadarChartBase) this.f65504f).q()) {
            return false;
        }
        c(((PieRadarChartBase) this.f65504f).k(motionEvent.getX(), motionEvent.getY()), motionEvent);
        return true;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f65503e.onTouchEvent(motionEvent) && ((PieRadarChartBase) this.f65504f).C()) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            int action = motionEvent.getAction();
            if (action == 0) {
                e(motionEvent);
                k();
                h();
                if (((PieRadarChartBase) this.f65504f).o()) {
                    i(x11, y11);
                }
                j(x11, y11);
                MPPointF mPPointF = this.f65519g;
                mPPointF.f65546c = x11;
                mPPointF.f65547d = y11;
            } else if (action == 1) {
                if (((PieRadarChartBase) this.f65504f).o()) {
                    k();
                    i(x11, y11);
                    float f11 = f();
                    this.f65523k = f11;
                    if (f11 != 0.0f) {
                        this.f65522j = AnimationUtils.currentAnimationTimeMillis();
                        Utils.x(this.f65504f);
                    }
                }
                ((PieRadarChartBase) this.f65504f).j();
                this.f65501c = 0;
                b(motionEvent);
            } else if (action == 2) {
                if (((PieRadarChartBase) this.f65504f).o()) {
                    i(x11, y11);
                }
                if (this.f65501c == 0) {
                    MPPointF mPPointF2 = this.f65519g;
                    if (ChartTouchListener.a(x11, mPPointF2.f65546c, y11, mPPointF2.f65547d) > Utils.e(8.0f)) {
                        this.f65500b = ChartTouchListener.ChartGesture.ROTATE;
                        this.f65501c = 6;
                        ((PieRadarChartBase) this.f65504f).g();
                        b(motionEvent);
                    }
                }
                if (this.f65501c == 6) {
                    l(x11, y11);
                    ((PieRadarChartBase) this.f65504f).invalidate();
                }
                b(motionEvent);
            }
        }
        return true;
    }
}
