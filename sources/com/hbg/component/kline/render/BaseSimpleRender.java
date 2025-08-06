package com.hbg.component.kline.render;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.hbg.lib.common.utils.PixelUtils;
import i6.d;

public abstract class BaseSimpleRender implements m {

    /* renamed from: j  reason: collision with root package name */
    public static final int f67195j = PixelUtils.a(276.0f);

    /* renamed from: k  reason: collision with root package name */
    public static final int f67196k = PixelUtils.a(56.0f);

    /* renamed from: b  reason: collision with root package name */
    public boolean f67197b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67198c = false;

    /* renamed from: d  reason: collision with root package name */
    public View f67199d;

    /* renamed from: e  reason: collision with root package name */
    public Resources f67200e;

    /* renamed from: f  reason: collision with root package name */
    public int f67201f;

    /* renamed from: g  reason: collision with root package name */
    public int f67202g;

    /* renamed from: h  reason: collision with root package name */
    public int f67203h;

    /* renamed from: i  reason: collision with root package name */
    public int f67204i;

    public void a(Canvas canvas) {
    }

    public boolean b(MotionEvent motionEvent) {
        return true;
    }

    public void c(boolean z11, int i11, int i12, int i13, int i14) {
    }

    public int computeVerticalScrollExtent() {
        return this.f67201f;
    }

    public int computeVerticalScrollOffset() {
        return this.f67203h;
    }

    public int computeVerticalScrollRange() {
        return this.f67201f;
    }

    public void d(int i11, int i12) {
    }

    public int e() {
        return this.f67204i;
    }

    public void f() {
    }

    public void g(int i11, int i12, int i13, int i14) {
        if (this.f67201f != i11 || this.f67202g != i12) {
            this.f67201f = i12;
            this.f67202g = i11;
            n();
        }
    }

    public int h() {
        return this.f67202g;
    }

    public int i() {
        return this.f67202g;
    }

    public void j(View view, Context context, AttributeSet attributeSet, int i11) {
        this.f67199d = view;
        this.f67200e = view.getResources();
        this.f67199d.setLayerType(1, (Paint) null);
    }

    public int k() {
        return h() - i();
    }

    public String l(int i11) {
        Resources resources = this.f67200e;
        if (resources != null) {
            return resources.getString(i11);
        }
        return null;
    }

    public void m() {
        View view = this.f67199d;
        if (view != null) {
            view.invalidate();
        }
    }

    public void n() {
    }

    public void o(boolean z11) {
    }

    public void onAttachedToWindow() {
    }

    public void onDetachedFromWindow() {
    }

    public void p(Runnable runnable) {
        View view = this.f67199d;
        if (view != null) {
            view.post(runnable);
        }
    }

    public void q() {
        View view = this.f67199d;
        if (view != null) {
            view.postInvalidate();
        }
    }

    public void r() {
        if (Build.VERSION.SDK_INT >= 16) {
            this.f67199d.postInvalidateOnAnimation();
        }
    }

    public void s(Runnable runnable) {
        View view = this.f67199d;
        if (view != null) {
            view.removeCallbacks(runnable);
        }
    }

    public void t(boolean z11) {
        View view = this.f67199d;
        if (view != null) {
            view.getParent().requestDisallowInterceptTouchEvent(z11);
        }
    }

    public void u(Matrix matrix) {
        matrix.reset();
        matrix.preTranslate(0.0f, (float) this.f67201f);
        matrix.preScale(1.0f, -1.0f);
    }

    public void v(Runnable runnable) {
        View view = this.f67199d;
        if (view != null) {
            view.post(runnable);
        }
    }

    public void w(int i11, int i12) {
        d.d("scrollBy  : " + Math.min(this.f67204i + i11, k()));
        this.f67204i = Math.max(0, Math.min(this.f67204i + i11, k()));
        this.f67203h = Math.max(0, Math.min(this.f67203h + i12, computeVerticalScrollRange() - computeVerticalScrollExtent()));
    }

    public void x(int i11, int i12) {
        d.d("scrollTo  : " + Math.min(i11, k()));
        this.f67204i = Math.max(0, Math.min(i11, k()));
        this.f67203h = Math.max(0, Math.min(i12, computeVerticalScrollRange() - computeVerticalScrollExtent()));
    }
}
