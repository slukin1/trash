package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import com.tencent.rtmp.TXLivePushConfig;
import ky.g;
import ky.i;
import ky.j;

public class BezierCircleHeader extends View implements g {

    /* renamed from: b  reason: collision with root package name */
    public Path f29455b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f29456c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f29457d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f29458e;

    /* renamed from: f  reason: collision with root package name */
    public float f29459f;

    /* renamed from: g  reason: collision with root package name */
    public float f29460g;

    /* renamed from: h  reason: collision with root package name */
    public float f29461h;

    /* renamed from: i  reason: collision with root package name */
    public float f29462i;

    /* renamed from: j  reason: collision with root package name */
    public RefreshState f29463j;

    /* renamed from: k  reason: collision with root package name */
    public float f29464k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f29465l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f29466m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f29467n;

    /* renamed from: o  reason: collision with root package name */
    public float f29468o;

    /* renamed from: p  reason: collision with root package name */
    public int f29469p = 90;

    /* renamed from: q  reason: collision with root package name */
    public int f29470q = 90;

    /* renamed from: r  reason: collision with root package name */
    public boolean f29471r = true;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        public float f29472b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        public float f29473c;

        /* renamed from: d  reason: collision with root package name */
        public float f29474d = 0.0f;

        /* renamed from: e  reason: collision with root package name */
        public int f29475e = 0;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f29476f;

        public a(float f11) {
            this.f29476f = f11;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (this.f29475e == 0 && floatValue <= 0.0f) {
                this.f29475e = 1;
                this.f29472b = Math.abs(floatValue - BezierCircleHeader.this.f29459f);
            }
            if (this.f29475e == 1) {
                float f11 = (-floatValue) / this.f29476f;
                this.f29474d = f11;
                if (f11 >= BezierCircleHeader.this.f29461h) {
                    float unused = BezierCircleHeader.this.f29461h = this.f29474d;
                    BezierCircleHeader bezierCircleHeader = BezierCircleHeader.this;
                    float unused2 = bezierCircleHeader.f29464k = bezierCircleHeader.f29460g + floatValue;
                    this.f29472b = Math.abs(floatValue - BezierCircleHeader.this.f29459f);
                } else {
                    this.f29475e = 2;
                    float unused3 = BezierCircleHeader.this.f29461h = 0.0f;
                    boolean unused4 = BezierCircleHeader.this.f29465l = true;
                    boolean unused5 = BezierCircleHeader.this.f29466m = true;
                    this.f29473c = BezierCircleHeader.this.f29464k;
                }
            }
            if (this.f29475e == 2 && BezierCircleHeader.this.f29464k > BezierCircleHeader.this.f29460g / 2.0f) {
                BezierCircleHeader bezierCircleHeader2 = BezierCircleHeader.this;
                float unused6 = bezierCircleHeader2.f29464k = Math.max(bezierCircleHeader2.f29460g / 2.0f, BezierCircleHeader.this.f29464k - this.f29472b);
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float f12 = this.f29473c;
                float h11 = (animatedFraction * ((BezierCircleHeader.this.f29460g / 2.0f) - f12)) + f12;
                if (BezierCircleHeader.this.f29464k > h11) {
                    float unused7 = BezierCircleHeader.this.f29464k = h11;
                }
            }
            if (BezierCircleHeader.this.f29466m && floatValue < BezierCircleHeader.this.f29459f) {
                boolean unused8 = BezierCircleHeader.this.f29467n = true;
                boolean unused9 = BezierCircleHeader.this.f29466m = false;
                boolean unused10 = BezierCircleHeader.this.f29471r = true;
                int unused11 = BezierCircleHeader.this.f29470q = 90;
                int unused12 = BezierCircleHeader.this.f29469p = 90;
            }
            float unused13 = BezierCircleHeader.this.f29459f = floatValue;
            BezierCircleHeader.this.invalidate();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = BezierCircleHeader.this.f29462i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BezierCircleHeader.this.invalidate();
        }
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        v(context, attributeSet);
    }

    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    public View getView() {
        return this;
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            this.f29465l = true;
            this.f29467n = true;
            float height = (float) getHeight();
            this.f29460g = height;
            this.f29469p = 270;
            this.f29464k = height / 2.0f;
            this.f29468o = height / 6.0f;
        }
        int width = getWidth();
        u(canvas, width, getHeight());
        t(canvas, width);
        p(canvas, width);
        s(canvas, width);
        r(canvas, width);
    }

    public int onFinish(j jVar, boolean z11) {
        this.f29467n = false;
        this.f29465l = false;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new b());
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(800);
        ofFloat.start();
        return TXLivePushConfig.DEFAULT_MIN_VIDEO_BITRATE;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i11), View.resolveSize(getSuggestedMinimumHeight(), i12));
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        this.f29460g = (float) i12;
        this.f29459f = ((float) Math.max(i11 - i12, 0)) * 0.8f;
    }

    public void onReleased(j jVar, int i11, int i12) {
        this.f29460g = (float) i11;
        this.f29468o = (float) (i11 / 6);
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        float min = Math.min(this.f29459f * 0.8f, this.f29460g / 2.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.f29459f, 0.0f, -(1.0f * min), 0.0f, -(0.4f * min), 0.0f});
        ofFloat.addUpdateListener(new a(min));
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.setDuration(1000);
        ofFloat.start();
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
        RefreshState refreshState = this.f29463j;
        if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.RefreshReleased) {
            onPulling(f11, i11, i12, i13);
        }
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f29463j = refreshState2;
    }

    public final void p(Canvas canvas, int i11) {
        if (this.f29465l) {
            canvas.drawCircle((float) (i11 / 2), this.f29464k, this.f29468o, this.f29457d);
            float f11 = this.f29460g;
            q(canvas, i11, (this.f29459f + f11) / f11);
        }
    }

    public final void q(Canvas canvas, int i11, float f11) {
        if (this.f29466m) {
            float f12 = this.f29460g + this.f29459f;
            float f13 = this.f29464k;
            float f14 = this.f29468o;
            float f15 = f13 + ((f14 * f11) / 2.0f);
            float f16 = (float) (i11 / 2);
            float sqrt = ((float) Math.sqrt((double) (f14 * f14 * (1.0f - ((f11 * f11) / 4.0f))))) + f16;
            float f17 = this.f29468o;
            float f18 = f16 + (((3.0f * f17) / 4.0f) * (1.0f - f11));
            float f19 = f17 + f18;
            this.f29455b.reset();
            this.f29455b.moveTo(sqrt, f15);
            this.f29455b.quadTo(f18, f12, f19, f12);
            float f21 = (float) i11;
            this.f29455b.lineTo(f21 - f19, f12);
            this.f29455b.quadTo(f21 - f18, f12, f21 - sqrt, f15);
            canvas.drawPath(this.f29455b, this.f29457d);
        }
    }

    public final void r(Canvas canvas, int i11) {
        Canvas canvas2 = canvas;
        int i12 = i11;
        if (this.f29462i > 0.0f) {
            int color = this.f29458e.getColor();
            if (((double) this.f29462i) < 0.3d) {
                int i13 = i12 / 2;
                canvas2.drawCircle((float) i13, this.f29464k, this.f29468o, this.f29457d);
                float f11 = this.f29468o;
                float f12 = this.f29462i;
                int strokeWidth = (int) (f11 + (this.f29458e.getStrokeWidth() * 2.0f * ((f12 / 0.3f) + 1.0f)));
                this.f29458e.setColor(Color.argb((int) ((1.0f - (f12 / 0.3f)) * 255.0f), Color.red(color), Color.green(color), Color.blue(color)));
                float f13 = this.f29464k;
                float f14 = (float) strokeWidth;
                canvas.drawArc(new RectF((float) (i13 - strokeWidth), f13 - f14, (float) (i13 + strokeWidth), f13 + f14), 0.0f, 360.0f, false, this.f29458e);
            }
            this.f29458e.setColor(color);
            float f15 = this.f29462i;
            if (((double) f15) >= 0.3d && ((double) f15) < 0.7d) {
                float f16 = (f15 - 0.3f) / 0.4f;
                float f17 = this.f29460g;
                float f18 = (float) ((int) ((f17 / 2.0f) + ((f17 - (f17 / 2.0f)) * f16)));
                this.f29464k = f18;
                canvas2.drawCircle((float) (i12 / 2), f18, this.f29468o, this.f29457d);
                if (this.f29464k >= this.f29460g - (this.f29468o * 2.0f)) {
                    this.f29466m = true;
                    q(canvas2, i12, f16);
                }
                this.f29466m = false;
            }
            float f19 = this.f29462i;
            if (((double) f19) >= 0.7d && f19 <= 1.0f) {
                float f21 = (f19 - 0.7f) / 0.3f;
                float f22 = (float) (i12 / 2);
                float f23 = this.f29468o;
                int i14 = (int) ((f22 - f23) - ((f23 * 2.0f) * f21));
                this.f29455b.reset();
                this.f29455b.moveTo((float) i14, this.f29460g);
                Path path = this.f29455b;
                float f24 = this.f29460g;
                path.quadTo(f22, f24 - (this.f29468o * (1.0f - f21)), (float) (i12 - i14), f24);
                canvas2.drawPath(this.f29455b, this.f29457d);
            }
        }
    }

    public final void s(Canvas canvas, int i11) {
        if (this.f29467n) {
            float strokeWidth = this.f29468o + (this.f29458e.getStrokeWidth() * 2.0f);
            int i12 = this.f29470q;
            boolean z11 = this.f29471r;
            int i13 = 3;
            int i14 = i12 + (z11 ? 3 : 10);
            this.f29470q = i14;
            int i15 = this.f29469p;
            if (z11) {
                i13 = 10;
            }
            int i16 = i15 + i13;
            this.f29469p = i16;
            int i17 = i14 % 360;
            this.f29470q = i17;
            int i18 = i16 % 360;
            this.f29469p = i18;
            int i19 = i18 - i17;
            if (i19 < 0) {
                i19 += 360;
            }
            float f11 = (float) (i11 / 2);
            float f12 = this.f29464k;
            canvas.drawArc(new RectF(f11 - strokeWidth, f12 - strokeWidth, f11 + strokeWidth, f12 + strokeWidth), (float) this.f29470q, (float) i19, false, this.f29458e);
            if (i19 >= 270) {
                this.f29471r = false;
            } else if (i19 <= 10) {
                this.f29471r = true;
            }
            invalidate();
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.f29456c.setColor(iArr[0]);
            if (iArr.length > 1) {
                this.f29457d.setColor(iArr[1]);
                this.f29458e.setColor(iArr[1]);
            }
        }
    }

    public final void t(Canvas canvas, int i11) {
        float f11 = this.f29461h;
        if (f11 > 0.0f) {
            float f12 = (float) (i11 / 2);
            float f13 = this.f29468o;
            float f14 = (f12 - (4.0f * f13)) + (3.0f * f11 * f13);
            if (((double) f11) < 0.9d) {
                this.f29455b.reset();
                this.f29455b.moveTo(f14, this.f29464k);
                Path path = this.f29455b;
                float f15 = this.f29464k;
                path.quadTo(f12, f15 - ((this.f29468o * this.f29461h) * 2.0f), ((float) i11) - f14, f15);
                canvas.drawPath(this.f29455b, this.f29457d);
                return;
            }
            canvas.drawCircle(f12, this.f29464k, f13, this.f29457d);
        }
    }

    public final void u(Canvas canvas, int i11, int i12) {
        float min = Math.min(this.f29460g, (float) i12);
        if (this.f29459f != 0.0f) {
            this.f29455b.reset();
            float f11 = (float) i11;
            this.f29455b.lineTo(f11, 0.0f);
            this.f29455b.lineTo(f11, min);
            this.f29455b.quadTo((float) (i11 / 2), (this.f29459f * 2.0f) + min, 0.0f, min);
            this.f29455b.close();
            canvas.drawPath(this.f29455b, this.f29456c);
            return;
        }
        canvas.drawRect(0.0f, 0.0f, (float) i11, min, this.f29456c);
    }

    public final void v(Context context, AttributeSet attributeSet) {
        setMinimumHeight(DensityUtil.b(100.0f));
        Paint paint = new Paint();
        this.f29456c = paint;
        paint.setColor(-15614977);
        this.f29456c.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f29457d = paint2;
        paint2.setColor(-1);
        this.f29457d.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f29458e = paint3;
        paint3.setAntiAlias(true);
        this.f29458e.setColor(-1);
        this.f29458e.setStyle(Paint.Style.STROKE);
        this.f29458e.setStrokeWidth((float) DensityUtil.b(2.0f));
        this.f29455b = new Path();
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        v(context, attributeSet);
    }
}
