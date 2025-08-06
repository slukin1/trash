package com.scwang.smartrefresh.header.fungame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.e;
import ky.g;
import ky.i;
import ky.j;

@SuppressLint({"RestrictedApi"})
public class FunGameBase extends FrameLayout implements g {

    /* renamed from: b  reason: collision with root package name */
    public int f29653b;

    /* renamed from: c  reason: collision with root package name */
    public int f29654c;

    /* renamed from: d  reason: collision with root package name */
    public int f29655d;

    /* renamed from: e  reason: collision with root package name */
    public float f29656e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29657f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29658g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29659h;

    /* renamed from: i  reason: collision with root package name */
    public RefreshState f29660i;

    /* renamed from: j  reason: collision with root package name */
    public i f29661j;

    /* renamed from: k  reason: collision with root package name */
    public e f29662k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f29663l;

    public FunGameBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        setMinimumHeight(DensityUtil.b(100.0f));
        this.f29655d = context.getResources().getDisplayMetrics().heightPixels;
    }

    public void b(float f11, int i11, int i12, int i13) {
    }

    public void c() {
        if (this.f29657f) {
            this.f29659h = false;
            this.f29661j.f().g(this.f29663l);
            if (this.f29656e != -1.0f) {
                onFinish(this.f29661j.f(), this.f29658g);
                this.f29661j.g(RefreshState.RefreshFinish);
                this.f29661j.b(0);
            } else {
                this.f29661j.k(this.f29654c, true);
            }
            View view = this.f29662k.getView();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin -= this.f29654c;
            view.setLayoutParams(marginLayoutParams);
            return;
        }
        this.f29661j.k(0, true);
    }

    public void d() {
        if (!this.f29659h) {
            this.f29659h = true;
            this.f29662k = this.f29661j.m();
            this.f29663l = this.f29661j.f().h();
            this.f29661j.f().g(false);
            View view = this.f29662k.getView();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin += this.f29654c;
            view.setLayoutParams(marginLayoutParams);
        }
    }

    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.MatchLayout;
    }

    public View getView() {
        return this;
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f29661j = null;
        this.f29662k = null;
    }

    public int onFinish(j jVar, boolean z11) {
        this.f29658g = z11;
        if (!this.f29657f) {
            this.f29657f = true;
            if (this.f29659h) {
                if (this.f29656e != -1.0f) {
                    return Integer.MAX_VALUE;
                }
                c();
                onFinish(jVar, z11);
                return 0;
            }
        }
        return 0;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
        this.f29661j = iVar;
        this.f29654c = i11;
        setTranslationY((float) (this.f29653b - i11));
        iVar.e(true);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f29660i == RefreshState.Refreshing || super.onInterceptTouchEvent(motionEvent);
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        if (this.f29659h) {
            b(f11, i11, i12, i13);
            return;
        }
        this.f29653b = i11;
        setTranslationY((float) (i11 - this.f29654c));
    }

    public void onReleased(j jVar, int i11, int i12) {
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
        onPulling(f11, i11, i12, i13);
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
        this.f29657f = false;
        setTranslationY(0.0f);
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f29660i = refreshState2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        RefreshState refreshState = this.f29660i;
        if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.RefreshFinish) {
            return super.onTouchEvent(motionEvent);
        }
        if (!this.f29659h) {
            d();
        }
        int action = motionEvent.getAction() & 255;
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float rawY = motionEvent.getRawY() - this.f29656e;
                    if (rawY >= 0.0f) {
                        double max = Math.max(0.0d, ((double) rawY) * 0.5d);
                        this.f29661j.k((int) Math.min(((double) (this.f29654c * 2)) * (1.0d - Math.pow(100.0d, (-max) / ((double) ((this.f29655d * 2) / 3)))), max), false);
                    } else {
                        double d11 = -Math.min(0.0d, ((double) rawY) * 0.5d);
                        this.f29661j.k((int) (-Math.min(((double) (this.f29654c * 2)) * (1.0d - Math.pow(100.0d, (-d11) / ((double) ((this.f29655d * 2) / 3)))), d11)), false);
                    }
                    return true;
                } else if (action != 3) {
                    return true;
                }
            }
            c();
            this.f29656e = -1.0f;
            if (this.f29657f) {
                this.f29661j.k(this.f29654c, true);
                return true;
            }
            return true;
        }
        this.f29656e = motionEvent.getRawY();
        this.f29661j.k(0, true);
        return true;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
    }

    public void setTranslationY(float f11) {
        if (!isInEditMode()) {
            super.setTranslationY(f11);
        }
    }

    public FunGameBase(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
