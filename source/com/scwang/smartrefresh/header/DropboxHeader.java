package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.g;
import ky.i;
import ky.j;

public class DropboxHeader extends View implements g {

    /* renamed from: b  reason: collision with root package name */
    public Path f29489b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f29490c;

    /* renamed from: d  reason: collision with root package name */
    public e f29491d;

    /* renamed from: e  reason: collision with root package name */
    public int f29492e;

    /* renamed from: f  reason: collision with root package name */
    public int f29493f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29494g;

    /* renamed from: h  reason: collision with root package name */
    public Drawable f29495h;

    /* renamed from: i  reason: collision with root package name */
    public Drawable f29496i;

    /* renamed from: j  reason: collision with root package name */
    public Drawable f29497j;

    /* renamed from: k  reason: collision with root package name */
    public float f29498k;

    /* renamed from: l  reason: collision with root package name */
    public float f29499l;

    /* renamed from: m  reason: collision with root package name */
    public ValueAnimator f29500m;

    /* renamed from: n  reason: collision with root package name */
    public ValueAnimator f29501n;

    /* renamed from: o  reason: collision with root package name */
    public RefreshState f29502o;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = DropboxHeader.this.f29499l = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            DropboxHeader.this.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        public void onAnimationEnd(Animator animator) {
            if (DropboxHeader.this.f29502o == RefreshState.Refreshing && DropboxHeader.this.f29501n != null) {
                DropboxHeader.this.f29501n.start();
            }
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (DropboxHeader.this.f29498k < 1.0f || DropboxHeader.this.f29498k >= 3.0f) {
                float unused = DropboxHeader.this.f29498k = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            } else if (DropboxHeader.this.f29498k < 2.0f) {
                float unused2 = DropboxHeader.this.f29498k = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 1.0f;
            } else if (DropboxHeader.this.f29498k < 3.0f) {
                float unused3 = DropboxHeader.this.f29498k = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 2.0f;
                if (DropboxHeader.this.f29498k == 3.0f) {
                    boolean unused4 = DropboxHeader.this.f29494g = true;
                }
            }
            DropboxHeader.this.invalidate();
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        public void onAnimationEnd(Animator animator) {
            if (DropboxHeader.this.f29500m != null) {
                DropboxHeader.this.f29500m.start();
            }
        }
    }

    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public int f29507a;

        /* renamed from: b  reason: collision with root package name */
        public int f29508b;

        /* renamed from: c  reason: collision with root package name */
        public int f29509c;

        /* renamed from: d  reason: collision with root package name */
        public int f29510d;

        /* renamed from: e  reason: collision with root package name */
        public int f29511e;

        /* renamed from: f  reason: collision with root package name */
        public int f29512f;

        /* renamed from: g  reason: collision with root package name */
        public int f29513g;

        /* renamed from: h  reason: collision with root package name */
        public int f29514h;

        /* renamed from: i  reason: collision with root package name */
        public int f29515i;

        public e() {
        }

        public e j(int i11, int i12, int i13, int i14) {
            this.f29515i = i13;
            int i15 = i11 / 2;
            this.f29507a = i15;
            int i16 = i12 - i14;
            this.f29509c = i16;
            this.f29510d = i16 - (i13 * 2);
            int sin = i15 - ((int) (((double) i13) * Math.sin(1.0471975511965976d)));
            this.f29511e = sin;
            int i17 = i13 / 2;
            this.f29512f = this.f29510d + i17;
            int i18 = this.f29509c;
            this.f29513g = i18 - i17;
            this.f29514h = i11 - sin;
            this.f29508b = i18 - i13;
            return this;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }
    }

    public DropboxHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n(context, attributeSet);
    }

    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    public View getView() {
        return this;
    }

    public final e h(int i11, int i12, int i13) {
        return this.f29491d.j(i11, i12, i13, i13 / 2);
    }

    public final Path i(e eVar) {
        this.f29489b.reset();
        this.f29489b.moveTo((float) eVar.f29511e, (float) eVar.f29513g);
        this.f29489b.lineTo((float) eVar.f29507a, (float) eVar.f29509c);
        this.f29489b.lineTo((float) eVar.f29514h, (float) eVar.f29513g);
        this.f29489b.quadTo(((float) eVar.f29514h) + (((float) (eVar.f29515i / 2)) * this.f29499l), (float) eVar.f29508b, (float) eVar.f29514h, (float) eVar.f29512f);
        this.f29489b.lineTo((float) eVar.f29507a, (float) eVar.f29510d);
        this.f29489b.lineTo((float) eVar.f29511e, (float) eVar.f29512f);
        this.f29489b.quadTo(((float) eVar.f29511e) - (((float) (eVar.f29515i / 2)) * this.f29499l), (float) eVar.f29508b, (float) eVar.f29511e, (float) eVar.f29513g);
        this.f29489b.close();
        return this.f29489b;
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public final Path j(e eVar) {
        this.f29489b.reset();
        double d11 = ((double) this.f29499l) * 1.2566370614359172d;
        float a11 = (float) (((eVar.f29507a - eVar.f29511e) * 4) / 5);
        double d12 = 1.0471975511965976d - (d11 / 2.0d);
        float sin = ((float) Math.sin(d12)) * a11;
        float cos = ((float) Math.cos(d12)) * a11;
        this.f29489b.moveTo((float) eVar.f29511e, (float) eVar.f29512f);
        this.f29489b.lineTo((float) eVar.f29507a, (float) eVar.f29510d);
        this.f29489b.lineTo(((float) eVar.f29507a) - sin, ((float) eVar.f29510d) - cos);
        this.f29489b.lineTo(((float) eVar.f29511e) - sin, ((float) eVar.f29512f) - cos);
        this.f29489b.close();
        double d13 = d11 + 1.0471975511965976d;
        float sin2 = ((float) Math.sin(d13)) * a11;
        float cos2 = ((float) Math.cos(d13)) * a11;
        this.f29489b.moveTo((float) eVar.f29511e, (float) eVar.f29512f);
        this.f29489b.lineTo((float) eVar.f29507a, (float) ((eVar.f29509c + eVar.f29510d) / 2));
        this.f29489b.lineTo(((float) eVar.f29507a) - sin2, ((float) ((eVar.f29509c + eVar.f29510d) / 2)) + cos2);
        this.f29489b.lineTo(((float) eVar.f29511e) - sin2, ((float) eVar.f29512f) + cos2);
        this.f29489b.close();
        float sin3 = ((float) Math.sin(d12)) * a11;
        float cos3 = ((float) Math.cos(d12)) * a11;
        this.f29489b.moveTo((float) eVar.f29514h, (float) eVar.f29512f);
        this.f29489b.lineTo((float) eVar.f29507a, (float) eVar.f29510d);
        this.f29489b.lineTo(((float) eVar.f29507a) + sin3, ((float) eVar.f29510d) - cos3);
        this.f29489b.lineTo(((float) eVar.f29514h) + sin3, ((float) eVar.f29512f) - cos3);
        this.f29489b.close();
        float sin4 = ((float) Math.sin(d13)) * a11;
        float cos4 = a11 * ((float) Math.cos(d13));
        this.f29489b.moveTo((float) eVar.f29514h, (float) eVar.f29512f);
        this.f29489b.lineTo((float) eVar.f29507a, (float) ((eVar.f29509c + eVar.f29510d) / 2));
        this.f29489b.lineTo(((float) eVar.f29507a) + sin4, ((float) ((eVar.f29509c + eVar.f29510d) / 2)) + cos4);
        this.f29489b.lineTo(((float) eVar.f29514h) + sin4, ((float) eVar.f29512f) + cos4);
        this.f29489b.close();
        return this.f29489b;
    }

    public final Path k(e eVar, int i11) {
        this.f29489b.reset();
        this.f29489b.lineTo(0.0f, (float) eVar.f29512f);
        this.f29489b.lineTo((float) eVar.f29511e, (float) eVar.f29512f);
        this.f29489b.lineTo((float) eVar.f29507a, (float) eVar.f29508b);
        this.f29489b.lineTo((float) eVar.f29514h, (float) eVar.f29512f);
        float f11 = (float) i11;
        this.f29489b.lineTo(f11, (float) eVar.f29512f);
        this.f29489b.lineTo(f11, 0.0f);
        this.f29489b.close();
        return this.f29489b;
    }

    public final int l() {
        return this.f29493f / 5;
    }

    public final void m() {
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f, 0.0f});
        this.f29500m = ofFloat;
        ofFloat.setInterpolator(accelerateInterpolator);
        this.f29500m.setDuration(300);
        this.f29500m.addUpdateListener(new a());
        this.f29500m.addListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f29501n = ofFloat2;
        ofFloat2.setInterpolator(accelerateInterpolator);
        this.f29501n.setDuration(300);
        this.f29501n.addUpdateListener(new c());
        this.f29501n.addListener(new d());
    }

    public final void n(Context context, AttributeSet attributeSet) {
        this.f29489b = new Path();
        this.f29490c = new Paint();
        this.f29491d = new e((a) null);
        this.f29490c.setAntiAlias(true);
        this.f29492e = -9524737;
        setBackgroundColor(-14141883);
        setMinimumHeight(DensityUtil.b(150.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DropboxHeader);
        int i11 = R$styleable.DropboxHeader_dhDrawable1;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f29495h = obtainStyledAttributes.getDrawable(i11);
        } else {
            PathsDrawable pathsDrawable = new PathsDrawable();
            pathsDrawable.i("M3 2h18v20h-18z", "m4,1c-1.105,0 -2,0.895 -2,2v3,11 3,1c0,1.105 0.895,2 2,2h2,12 2c1.105,0 2,-0.895 2,-2v-1,-3 -11,-3c0,-1.105 -0.895,-2 -2,-2h-2,-12 -2zM3.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5z");
            pathsDrawable.h(-1249039, -245496);
            this.f29495h = pathsDrawable;
        }
        int i12 = R$styleable.DropboxHeader_dhDrawable2;
        if (obtainStyledAttributes.hasValue(i12)) {
            this.f29496i = obtainStyledAttributes.getDrawable(i12);
        } else {
            PathsDrawable pathsDrawable2 = new PathsDrawable();
            pathsDrawable2.i("M49,16.5l-14,-14l-27,0l0,53l41,0z", "m16,23.5h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,21.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "m16,15.5h10c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,13.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "M41,29.5L16,29.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,37.5L16,37.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,45.5L16,45.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M49,16.5l-14,-14l0,14z");
            pathsDrawable2.h(-76695, -2773417);
            this.f29496i = pathsDrawable2;
        }
        int i13 = R$styleable.DropboxHeader_dhDrawable3;
        if (obtainStyledAttributes.hasValue(i13)) {
            this.f29497j = obtainStyledAttributes.getDrawable(i13);
        } else {
            PathsDrawable pathsDrawable3 = new PathsDrawable();
            pathsDrawable3.i("M6.021,2.188L6.021,11.362C5.46,11.327 4.843,11.414 4.229,11.663C2.624,12.312 1.696,13.729 2.155,14.825C2.62,15.924 4.294,16.284 5.898,15.634C7.131,15.134 7.856,14.184 7.965,13.272L7.958,4.387L15.02,3.028L15.02,9.406C14.422,9.343 13.746,9.432 13.076,9.703C11.471,10.353 10.544,11.77 11.004,12.866C11.467,13.964 13.141,14.325 14.746,13.675C15.979,13.174 16.836,12.224 16.947,11.313L16.958,0.002L6.021,2.188L6.021,2.188Z");
            pathsDrawable3.h(-6760607);
            this.f29497j = pathsDrawable3;
        }
        obtainStyledAttributes.recycle();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.f29500m;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.f29500m.removeAllListeners();
            this.f29500m = null;
        }
        ValueAnimator valueAnimator2 = this.f29501n;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.f29501n.removeAllListeners();
            this.f29501n = null;
        }
    }

    public void onDraw(Canvas canvas) {
        int width = getWidth();
        e h11 = h(width, getHeight(), l());
        this.f29490c.setColor(iy.a.d(this.f29492e, 150));
        canvas.drawPath(i(h11), this.f29490c);
        this.f29490c.setColor(this.f29492e);
        canvas.drawPath(j(h11), this.f29490c);
        if (isInEditMode()) {
            this.f29498k = 2.5f;
        }
        if (this.f29498k > 0.0f) {
            canvas.clipPath(k(h11, width));
            float min = Math.min(this.f29498k, 1.0f);
            Rect bounds = this.f29495h.getBounds();
            int i11 = width / 2;
            bounds.offsetTo(i11 - (bounds.width() / 2), ((int) (((float) ((h11.f29508b - (bounds.height() / 2)) + bounds.height())) * min)) - bounds.height());
            this.f29495h.draw(canvas);
            float min2 = Math.min(Math.max(this.f29498k - 1.0f, 0.0f), 1.0f);
            Rect bounds2 = this.f29496i.getBounds();
            bounds2.offsetTo(i11 - (bounds2.width() / 2), ((int) (((float) ((h11.f29508b - (bounds2.height() / 2)) + bounds2.height())) * min2)) - bounds2.height());
            this.f29496i.draw(canvas);
            float min3 = Math.min(Math.max(this.f29498k - 2.0f, 0.0f), 1.0f);
            Rect bounds3 = this.f29497j.getBounds();
            bounds3.offsetTo(i11 - (bounds3.width() / 2), ((int) (((float) ((h11.f29508b - (bounds3.height() / 2)) + bounds3.height())) * min3)) - bounds3.height());
            this.f29497j.draw(canvas);
            if (this.f29494g) {
                bounds.offsetTo(i11 - (bounds.width() / 2), h11.f29508b - (bounds.height() / 2));
                this.f29495h.draw(canvas);
                bounds2.offsetTo(i11 - (bounds2.width() / 2), h11.f29508b - (bounds2.height() / 2));
                this.f29496i.draw(canvas);
                bounds3.offsetTo(i11 - (bounds3.width() / 2), h11.f29508b - (bounds3.height() / 2));
                this.f29497j.draw(canvas);
            }
        }
    }

    public int onFinish(j jVar, boolean z11) {
        this.f29498k = 0.0f;
        return 0;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
        this.f29493f = i11;
        int l11 = l();
        this.f29495h.setBounds(0, 0, l11, l11);
        this.f29496i.setBounds(0, 0, l11, l11);
        this.f29497j.setBounds(0, 0, l11, l11);
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i11), View.resolveSize(getSuggestedMinimumHeight(), i12));
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        if (this.f29502o != RefreshState.Refreshing) {
            this.f29499l = (((float) Math.max(0, i11 - i12)) * 1.0f) / ((float) i13);
        }
    }

    public void onReleased(j jVar, int i11, int i12) {
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
        this.f29499l = (((float) Math.max(0, i11 - i12)) * 1.0f) / ((float) i13);
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
        ValueAnimator valueAnimator = this.f29501n;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f29502o = refreshState2;
        if (refreshState2 == RefreshState.None) {
            this.f29494g = false;
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            setBackgroundColor(iArr[0]);
            if (iArr.length > 1) {
                this.f29492e = iArr[1];
            }
        }
    }

    public DropboxHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        n(context, attributeSet);
    }
}
