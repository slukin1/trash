package com.hbg.component.kline.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.viewpager.widget.ViewPager;
import com.hbg.component.kline.render.RenderRegister;
import com.hbg.component.kline.render.m;
import com.hbg.module.kline.R$styleable;

public class RenderView extends View {

    /* renamed from: b  reason: collision with root package name */
    public m f67405b;

    public RenderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(boolean z11) {
        try {
            ViewParent parent = getParent();
            while (parent != null && !(parent instanceof ViewPager)) {
                parent = parent.getParent();
            }
            if (parent == null) {
                getParent().requestDisallowInterceptTouchEvent(z11);
            } else {
                parent.requestDisallowInterceptTouchEvent(z11);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public int computeHorizontalScrollExtent() {
        return this.f67405b.i();
    }

    public int computeHorizontalScrollOffset() {
        return this.f67405b.e();
    }

    public int computeHorizontalScrollRange() {
        return this.f67405b.h();
    }

    public void computeScroll() {
        super.computeScroll();
        this.f67405b.f();
    }

    public int computeVerticalScrollExtent() {
        return this.f67405b.computeVerticalScrollExtent();
    }

    public int computeVerticalScrollOffset() {
        return this.f67405b.computeVerticalScrollOffset();
    }

    public int computeVerticalScrollRange() {
        return this.f67405b.computeVerticalScrollRange();
    }

    public m getRender() {
        return this.f67405b;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f67405b.onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f67405b.onDetachedFromWindow();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f67405b.a(canvas);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        this.f67405b.c(z11, i11, i12, i13, i14);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        this.f67405b.d(i11, i12);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f67405b.g(i11, i12, i13, i14);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            a(true);
        } else if (action == 1 || action == 3) {
            a(false);
        }
        return this.f67405b.b(motionEvent);
    }

    public RenderView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RenderView, i11, 0);
        String string = obtainStyledAttributes.getString(R$styleable.RenderView_renderClass);
        obtainStyledAttributes.recycle();
        Class a11 = RenderRegister.a(string);
        if (a11 != null) {
            try {
                Object newInstance = a11.newInstance();
                if (newInstance != null && (newInstance instanceof m)) {
                    this.f67405b = (m) newInstance;
                }
            } catch (Exception unused) {
            }
        }
        m mVar = this.f67405b;
        if (mVar != null) {
            mVar.j(this, context, attributeSet, i11);
            return;
        }
        throw new IllegalArgumentException("must have attr renderClass");
    }
}
