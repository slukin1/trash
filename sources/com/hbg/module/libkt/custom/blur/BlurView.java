package com.hbg.module.libkt.custom.blur;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import com.hbg.module.libkt.R$styleable;
import le.b;
import le.d;
import le.e;
import le.f;

public class BlurView extends FrameLayout {

    /* renamed from: h  reason: collision with root package name */
    public static final String f24757h = BlurView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public b f24758b = new NoOpController();

    /* renamed from: c  reason: collision with root package name */
    public int f24759c;

    /* renamed from: d  reason: collision with root package name */
    public float f24760d;

    /* renamed from: e  reason: collision with root package name */
    public float f24761e;

    /* renamed from: f  reason: collision with root package name */
    public float f24762f;

    /* renamed from: g  reason: collision with root package name */
    public float f24763g;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        public void getOutline(View view, Outline outline) {
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, (float) BlurView.this.getWidth(), (float) BlurView.this.getHeight()), new float[]{BlurView.this.f24760d, BlurView.this.f24760d, BlurView.this.f24761e, BlurView.this.f24761e, BlurView.this.f24763g, BlurView.this.f24763g, BlurView.this.f24762f, BlurView.this.f24762f}, Path.Direction.CW);
            outline.setConvexPath(path);
        }
    }

    public BlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        e(attributeSet, 0);
    }

    private le.a getBlurAlgorithm() {
        if (Build.VERSION.SDK_INT >= 31) {
            return new RenderEffectBlur();
        }
        return new f(getContext());
    }

    public void draw(Canvas canvas) {
        if (this.f24758b.draw(canvas)) {
            super.draw(canvas);
        }
    }

    public final void e(AttributeSet attributeSet, int i11) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.BlurView, i11, 0);
        this.f24759c = obtainStyledAttributes.getColor(R$styleable.BlurView_blurOverlayColor, Color.parseColor("#80646464"));
        obtainStyledAttributes.recycle();
    }

    public d f(ViewGroup viewGroup) {
        return g(viewGroup, getBlurAlgorithm());
    }

    public d g(ViewGroup viewGroup, le.a aVar) {
        this.f24758b.destroy();
        e eVar = new e(this, viewGroup, this.f24759c, aVar);
        this.f24758b = eVar;
        return eVar;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isHardwareAccelerated()) {
            Log.e(f24757h, "BlurView can't be used in not hardware-accelerated window!");
        } else {
            this.f24758b.b(true);
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f24758b.b(false);
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        setOutlineProvider(new a());
        setClipToOutline(true);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f24758b.a();
    }

    public BlurView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        e(attributeSet, i11);
    }
}
