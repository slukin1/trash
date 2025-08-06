package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import ky.g;
import ky.i;
import ky.j;

public class TaurusHeader extends View implements g {

    /* renamed from: r  reason: collision with root package name */
    public static final Interpolator f29590r = new AccelerateDecelerateInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public PathsDrawable f29591b;

    /* renamed from: c  reason: collision with root package name */
    public PathsDrawable f29592c;

    /* renamed from: d  reason: collision with root package name */
    public Matrix f29593d;

    /* renamed from: e  reason: collision with root package name */
    public float f29594e;

    /* renamed from: f  reason: collision with root package name */
    public int f29595f;

    /* renamed from: g  reason: collision with root package name */
    public Animation f29596g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29597h = false;

    /* renamed from: i  reason: collision with root package name */
    public float f29598i;

    /* renamed from: j  reason: collision with root package name */
    public float f29599j;

    /* renamed from: k  reason: collision with root package name */
    public Random f29600k;

    /* renamed from: l  reason: collision with root package name */
    public Map<Float, Float> f29601l;

    /* renamed from: m  reason: collision with root package name */
    public Paint f29602m;

    /* renamed from: n  reason: collision with root package name */
    public float f29603n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f29604o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f29605p;

    /* renamed from: q  reason: collision with root package name */
    public float f29606q;

    public enum AnimationPart {
        FIRST,
        SECOND,
        THIRD,
        FOURTH
    }

    public class a extends Animation {
        public a() {
            setDuration(100);
            setInterpolator(new AccelerateInterpolator());
        }

        public void applyTransformation(float f11, Transformation transformation) {
            if (f11 == 1.0f) {
                boolean unused = TaurusHeader.this.f29597h = false;
            }
            float unused2 = TaurusHeader.this.f29606q = f11;
            TaurusHeader.this.invalidate();
        }
    }

    public class b extends Animation {
        public b() {
        }

        public void applyTransformation(float f11, Transformation transformation) {
            TaurusHeader.this.setLoadingAnimationTime(f11);
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29609a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.scwang.smartrefresh.header.TaurusHeader$AnimationPart[] r0 = com.scwang.smartrefresh.header.TaurusHeader.AnimationPart.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29609a = r0
                com.scwang.smartrefresh.header.TaurusHeader$AnimationPart r1 = com.scwang.smartrefresh.header.TaurusHeader.AnimationPart.FIRST     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29609a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.header.TaurusHeader$AnimationPart r1 = com.scwang.smartrefresh.header.TaurusHeader.AnimationPart.SECOND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f29609a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.header.TaurusHeader$AnimationPart r1 = com.scwang.smartrefresh.header.TaurusHeader.AnimationPart.THIRD     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f29609a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.header.TaurusHeader$AnimationPart r1 = com.scwang.smartrefresh.header.TaurusHeader.AnimationPart.FOURTH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.header.TaurusHeader.c.<clinit>():void");
        }
    }

    public TaurusHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(context, attributeSet);
    }

    /* access modifiers changed from: private */
    public void setLoadingAnimationTime(float f11) {
        this.f29598i = (f11 / 6.0f) * 80.0f;
        invalidate();
    }

    public final boolean d(AnimationPart animationPart) {
        int i11 = c.f29609a[animationPart.ordinal()];
        if (i11 != 1) {
            if (i11 == 2 || i11 == 3) {
                if (this.f29598i < ((float) j(animationPart))) {
                    return true;
                }
                return false;
            } else if (i11 == 4 && this.f29598i > ((float) j(AnimationPart.THIRD))) {
                return true;
            } else {
                return false;
            }
        } else if (this.f29598i < ((float) j(AnimationPart.FOURTH))) {
            return true;
        } else {
            return false;
        }
    }

    public final void e(Canvas canvas, int i11, int i12) {
        float f11;
        float i13;
        float i14;
        Matrix matrix = this.f29593d;
        matrix.reset();
        float f12 = this.f29594e;
        if (isInEditMode()) {
            this.f29595f = i12;
            f12 = 1.0f;
        }
        if (f12 > 1.0f) {
            f11 = ((float) (1.0d - Math.pow(100.0d, (double) ((-(f12 - 1.0f)) / 2.0f)))) * 20.0f;
            f12 = 1.0f;
        } else {
            f11 = 0.0f;
        }
        float n11 = ((((float) i11) * f12) / 2.0f) - ((float) (this.f29591b.n() / 2));
        float f13 = (((float) this.f29595f) * (1.0f - (f12 / 2.0f))) - ((float) (this.f29591b.f() / 2));
        float f14 = this.f29606q;
        if (f14 > 0.0f) {
            f13 += (0.0f - f13) * f14;
            n11 += (((float) (i11 + this.f29591b.n())) - n11) * this.f29606q;
        }
        if (this.f29597h) {
            AnimationPart animationPart = AnimationPart.FIRST;
            if (d(animationPart)) {
                i14 = i(animationPart);
            } else {
                AnimationPart animationPart2 = AnimationPart.SECOND;
                if (d(animationPart2)) {
                    i14 = i(animationPart2);
                } else {
                    AnimationPart animationPart3 = AnimationPart.THIRD;
                    if (d(animationPart3)) {
                        i13 = i(animationPart3);
                    } else {
                        AnimationPart animationPart4 = AnimationPart.FOURTH;
                        if (d(animationPart4)) {
                            i13 = i(animationPart4);
                        }
                    }
                    f13 += i13;
                }
            }
            f13 -= i14;
        }
        if (f11 > 0.0f) {
            matrix.postRotate(f11, (float) (this.f29591b.n() / 2), (float) (this.f29591b.f() / 2));
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(n11, f13);
        canvas.concat(matrix);
        this.f29591b.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    public final void f(Canvas canvas, int i11, int i12) {
        boolean z11;
        float f11;
        float f12;
        float i13;
        float f13;
        float i14;
        Matrix matrix = this.f29593d;
        matrix.reset();
        float min = Math.min(1.0f, Math.abs(this.f29594e));
        if (isInEditMode()) {
            this.f29595f = i12;
            min = 1.0f;
        }
        float f14 = this.f29594e;
        boolean z12 = true;
        if (f14 > 1.0f) {
            f11 = Math.abs(1.0f - f14);
            z11 = true;
        } else {
            z11 = false;
            f11 = 0.0f;
        }
        float f15 = min - 0.5f;
        float f16 = 0.8f;
        if (f15 > 0.0f) {
            f16 = 0.8f + ((f15 / 0.5f) * 0.19999999f);
        }
        int i15 = this.f29595f;
        float f17 = ((float) i15) * min;
        float f18 = (float) (i15 - (this.f29592c.f() / 2));
        if (f17 > f18) {
            f12 = f17 - f18;
        } else {
            z12 = false;
            f12 = 0.0f;
        }
        float n11 = (float) ((i11 / 2) - (this.f29592c.n() / 2));
        float f19 = f17 - (z12 ? ((float) (this.f29592c.f() / 2)) + f12 : (float) (this.f29592c.f() / 2));
        float f21 = z11 ? (f11 / 4.0f) + f16 : f16;
        float f22 = z11 ? (f11 / 2.0f) + f16 : f16;
        if (this.f29597h && !z11) {
            AnimationPart animationPart = AnimationPart.FIRST;
            if (d(animationPart)) {
                i14 = i(animationPart);
            } else {
                AnimationPart animationPart2 = AnimationPart.SECOND;
                if (d(animationPart2)) {
                    i14 = i(animationPart2);
                } else {
                    AnimationPart animationPart3 = AnimationPart.THIRD;
                    if (d(animationPart3)) {
                        i13 = i(animationPart3);
                    } else {
                        AnimationPart animationPart4 = AnimationPart.FOURTH;
                        if (d(animationPart4)) {
                            i13 = i(animationPart4);
                        }
                        f22 = f21;
                    }
                    f13 = f16 + ((i13 / 80.0f) / 6.0f);
                    f21 = f13;
                    f22 = f21;
                }
            }
            f13 = f16 - ((i14 / 80.0f) / 8.0f);
            f21 = f13;
            f22 = f21;
        }
        matrix.postScale(f21, f22, (float) (this.f29592c.n() / 2), 0.0f);
        float f23 = (float) (i12 + 2);
        if ((((float) this.f29592c.f()) * f22) + f19 < f23) {
            f19 = f23 - (f22 * ((float) this.f29592c.f()));
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(n11, f19);
        canvas.concat(matrix);
        this.f29592c.draw(canvas);
        canvas.restoreToCount(saveCount);
    }

    public final void g(Canvas canvas, int i11, int i12) {
        float i13;
        float i14;
        Matrix matrix = this.f29593d;
        matrix.reset();
        PathsDrawable pathsDrawable = this.f29592c;
        float min = Math.min(1.0f, Math.abs(this.f29594e));
        if (isInEditMode()) {
            this.f29595f = i12;
            min = 1.0f;
        }
        float f11 = min - 0.5f;
        float f12 = 0.6f;
        if (f11 > 0.0f) {
            f12 = 0.6f + ((f11 / 0.5f) * 0.39999998f);
        }
        float f13 = ((float) this.f29595f) * (1.0f - min);
        float n11 = (float) (0 - (pathsDrawable.n() / 2));
        float n12 = (float) (i11 - (pathsDrawable.n() / 2));
        if (this.f29597h) {
            AnimationPart animationPart = AnimationPart.FIRST;
            if (d(animationPart)) {
                n11 -= (i(animationPart) * 2.0f) / 4.0f;
                i14 = i(animationPart);
            } else {
                AnimationPart animationPart2 = AnimationPart.SECOND;
                if (d(animationPart2)) {
                    n11 -= (i(animationPart2) * 2.0f) / 4.0f;
                    i14 = i(animationPart2);
                } else {
                    AnimationPart animationPart3 = AnimationPart.THIRD;
                    if (d(animationPart3)) {
                        n11 -= i(animationPart3) / 4.0f;
                        i14 = i(animationPart3) * 2.0f;
                    } else {
                        AnimationPart animationPart4 = AnimationPart.FOURTH;
                        if (d(animationPart4)) {
                            n11 -= i(animationPart4) / 2.0f;
                            i13 = (i(animationPart4) * 2.0f) / 4.0f;
                            n12 += i13;
                        }
                    }
                }
            }
            i13 = i14 / 2.0f;
            n12 += i13;
        }
        float f14 = (float) (i12 + 2);
        float f15 = (((float) pathsDrawable.f()) * f12) + f13 < f14 ? f14 - (((float) pathsDrawable.f()) * f12) : f13;
        if ((((float) pathsDrawable.f()) * f12) + f13 < f14) {
            f13 = f14 - (((float) pathsDrawable.f()) * f12);
        }
        int saveCount = canvas.getSaveCount();
        canvas.save();
        canvas.translate(n11, f15);
        matrix.postScale(f12, f12, (float) ((pathsDrawable.n() * 3) / 4), (float) pathsDrawable.f());
        canvas.concat(matrix);
        pathsDrawable.setAlpha(100);
        pathsDrawable.draw(canvas);
        pathsDrawable.setAlpha(255);
        canvas.restoreToCount(saveCount);
        canvas.save();
        canvas.translate(n12, f13);
        matrix.postScale(f12, f12, 0.0f, (float) pathsDrawable.f());
        canvas.concat(matrix);
        pathsDrawable.setAlpha(100);
        pathsDrawable.draw(canvas);
        pathsDrawable.setAlpha(255);
        canvas.restoreToCount(saveCount);
    }

    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    public View getView() {
        return this;
    }

    public final void h(Canvas canvas, float f11, float f12, int i11) {
        float f13 = (float) i11;
        float f14 = (f13 + f12) / 13.0f;
        float f15 = this.f29598i;
        if (this.f29599j - f15 > 0.0f) {
            this.f29605p = true;
            f15 = 13.0f - f15;
        } else {
            this.f29604o = true;
            this.f29605p = false;
        }
        float f16 = (f13 - (f15 * f14)) + f12;
        float f17 = this.f29603n;
        float f18 = f16 - f17;
        canvas.drawLine(f18, f11, f18 + f17, f11, this.f29602m);
    }

    public final float i(AnimationPart animationPart) {
        float f11;
        float j11;
        int i11 = c.f29609a[animationPart.ordinal()];
        if (i11 == 1) {
            return this.f29598i;
        }
        if (i11 != 2) {
            if (i11 == 3) {
                f11 = this.f29598i;
                j11 = (float) j(AnimationPart.SECOND);
            } else if (i11 != 4) {
                return 0.0f;
            } else {
                f11 = (float) j(AnimationPart.THIRD);
                j11 = this.f29598i - ((float) j(AnimationPart.FOURTH));
            }
            return f11 - j11;
        }
        AnimationPart animationPart2 = AnimationPart.FOURTH;
        return ((float) j(animationPart2)) - (this.f29598i - ((float) j(animationPart2)));
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public final int j(AnimationPart animationPart) {
        int i11 = c.f29609a[animationPart.ordinal()];
        if (i11 == 2) {
            return 40;
        }
        if (i11 != 3) {
            return i11 != 4 ? 0 : 20;
        }
        return j(AnimationPart.FOURTH) * 3;
    }

    public final void k(Context context, AttributeSet attributeSet) {
        setMinimumHeight(DensityUtil.b(100.0f));
        this.f29593d = new Matrix();
        this.f29601l = new HashMap();
        this.f29600k = new Random();
        Paint paint = new Paint();
        this.f29602m = paint;
        paint.setColor(-1);
        this.f29602m.setStrokeWidth((float) DensityUtil.b(3.0f));
        this.f29602m.setAlpha(50);
        m();
        n();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TaurusHeader);
        int color = obtainStyledAttributes.getColor(R$styleable.TaurusHeader_thPrimaryColor, 0);
        if (color != 0) {
            setBackgroundColor(color);
        } else {
            setBackgroundColor(-15614977);
        }
        obtainStyledAttributes.recycle();
    }

    public final float l(int i11, int i12) {
        return (float) (this.f29600k.nextInt((i12 - i11) + 1) + i11);
    }

    public final void m() {
        b bVar = new b();
        this.f29596g = bVar;
        bVar.setRepeatCount(-1);
        this.f29596g.setRepeatMode(2);
        this.f29596g.setInterpolator(f29590r);
        this.f29596g.setDuration(1000);
    }

    public final void n() {
        DensityUtil densityUtil = new DensityUtil();
        PathsDrawable pathsDrawable = new PathsDrawable();
        this.f29591b = pathsDrawable;
        pathsDrawable.i("m23.01,81.48c-0.21,-0.3 -0.38,-0.83 -0.38,-1.19 0,-0.55 0.24,-0.78 1.5,-1.48 1.78,-0.97 2.62,-1.94 2.24,-2.57 -0.57,-0.93 -1.97,-1.24 -11.64,-2.59 -5.35,-0.74 -10.21,-1.44 -10.82,-1.54l-1.09,-0.18 1.19,-0.91c0.99,-0.76 1.38,-0.91 2.35,-0.91 0.64,0 6.39,0.33 12.79,0.74 6.39,0.41 12.09,0.71 12.65,0.67l1.03,-0.07 -1.24,-2.19C30.18,66.77 15.91,42 15.13,40.68l-0.51,-0.87 4.19,-1.26c2.3,-0.69 4.27,-1.26 4.37,-1.26 0.1,0 5.95,3.85 13,8.55 14.69,9.81 17.1,11.31 19.7,12.31 4.63,1.78 6.45,1.69 12.94,-0.64 13.18,-4.73 25.22,-9.13 25.75,-9.4 0.69,-0.36 3.6,1.33 -24.38,-14.22L50.73,23.07 46.74,16.42 42.75,9.77 43.63,8.89c0.83,-0.83 0.91,-0.86 1.46,-0.52 0.32,0.2 3.72,3.09 7.55,6.44 3.83,3.34 7.21,6.16 7.5,6.27 0.29,0.11 13.6,2.82 29.58,6.03 15.98,3.21 31.86,6.4 35.3,7.1l6.26,1.26 3.22,-1.13c41.63,-14.63 67.88,-23.23 85.38,-28 14.83,-4.04 23.75,-4.75 32.07,-2.57 7.04,1.84 9.87,4.88 7.71,8.27 -1.6,2.5 -4.6,4.63 -10.61,7.54 -5.94,2.88 -10.22,4.46 -25.4,9.41 -8.15,2.66 -16.66,5.72 -39.01,14.02 -66.79,24.82 -88.49,31.25 -121.66,36.07 -14.56,2.11 -24.17,2.95 -34.08,2.95 -5.43,0 -5.52,-0.01 -5.89,-0.54z");
        this.f29591b.setBounds(0, 0, densityUtil.a(65.0f), densityUtil.a(20.0f));
        this.f29591b.h(-1);
        PathsDrawable pathsDrawable2 = new PathsDrawable();
        this.f29592c = pathsDrawable2;
        pathsDrawable2.i("M551.81,1.01A65.42,65.42 0,0 0,504.38 21.5A50.65,50.65 0,0 0,492.4 20A50.65,50.65 0,0 0,441.75 70.65A50.65,50.65 0,0 0,492.4 121.3A50.65,50.65 0,0 0,511.22 117.64A65.42,65.42 0,0 0,517.45 122L586.25,122A65.42,65.42 0,0 0,599.79 110.78A59.79,59.79 0,0 0,607.81 122L696.34,122A59.79,59.79 0,0 0,711.87 81.9A59.79,59.79 0,0 0,652.07 22.11A59.79,59.79 0,0 0,610.93 38.57A65.42,65.42 0,0 0,551.81 1.01zM246.2,1.71A54.87,54.87 0,0 0,195.14 36.64A46.78,46.78 0,0 0,167.77 27.74A46.78,46.78 0,0 0,120.99 74.52A46.78,46.78 0,0 0,167.77 121.3A46.78,46.78 0,0 0,208.92 96.74A54.87,54.87 0,0 0,246.2 111.45A54.87,54.87 0,0 0,268.71 106.54A39.04,39.04 0,0 0,281.09 122L327.6,122A39.04,39.04 0,0 0,343.38 90.7A39.04,39.04 0,0 0,304.34 51.66A39.04,39.04 0,0 0,300.82 51.85A54.87,54.87 0,0 0,246.2 1.71z", "m506.71,31.37a53.11,53.11 0,0 0,-53.11 53.11,53.11 53.11,0 0,0 15.55,37.5h75.12a53.11,53.11 0,0 0,1.88 -2.01,28.49 28.49,0 0,0 0.81,2.01h212.96a96.72,96.72 0,0 0,-87.09 -54.85,96.72 96.72,0 0,0 -73.14,33.52 28.49,28.49 0,0 0,-26.74 -18.74,28.49 28.49,0 0,0 -13.16,3.23 53.11,53.11 0,0 0,0.03 -0.66,53.11 53.11,0 0,0 -53.11,-53.11zM206.23,31.81a53.81,53.81 0,0 0,-49.99 34.03,74.91 74.91,0 0,0 -47.45,-17 74.91,74.91 0,0 0,-73.54 60.82,31.3 31.3,0 0,0 -10.17,-1.73 31.3,31.3 0,0 0,-26.09 14.05L300.86,121.98a37.63,37.63 0,0 0,0.2 -3.85,37.63 37.63,0 0,0 -37.63,-37.63 37.63,37.63 0,0 0,-3.65 0.21,53.81 53.81,0 0,0 -53.54,-48.9z", "m424.05,36.88a53.46,53.46 0,0 0,-40.89 19.02,53.46 53.46,0 0,0 -1.34,1.76 62.6,62.6 0,0 0,-5.39 -0.27,62.6 62.6,0 0,0 -61.36,50.17 62.6,62.6 0,0 0,-0.53 3.51,15.83 15.83,0 0,0 -10.33,-3.84 15.83,15.83 0,0 0,-8.06 2.23,21.1 21.1,0 0,0 -18.31,-10.67 21.1,21.1 0,0 0,-19.47 12.97,21.81 21.81,0 0,0 -6.56,-1.01 21.81,21.81 0,0 0,-19.09 11.32L522.84,122.07a43.61,43.61 0,0 0,-43.11 -37.35,43.61 43.61,0 0,0 -2.57,0.09 53.46,53.46 0,0 0,-53.11 -47.93zM129.08,38.4a50.29,50.29 0,0 0,-50.29 50.29,50.29 50.29,0 0,0 2.37,15.06 15.48,15.83 0,0 0,-5.87 1.68,15.48 15.83,0 0,0 -0.98,0.58 16.53,16.18 0,0 0,-0.19 -0.21,16.53 16.18,0 0,0 -11.86,-4.91 16.53,16.18 0,0 0,-16.38 14.13,20.05 16.18,0 0,0 -14.97,7.04L223.95,122.07a42.56,42.56 0,0 0,1.14 -9.56,42.56 42.56,0 0,0 -42.56,-42.56 42.56,42.56 0,0 0,-6.58 0.54,50.29 50.29,0 0,0 -0,-0.01 50.29,50.29 0,0 0,-46.88 -32.07zM631.67,82.61a64.01,64.01 0,0 0,-44.9 18.42,26.73 26.73,0 0,0 -10.67,-2.24 26.73,26.73 0,0 0,-22.72 12.71,16.88 16.88,0 0,0 -0.25,-0.12 16.88,16.88 0,0 0,-6.57 -1.33,16.88 16.88,0 0,0 -16.15,12.03h160.36a64.01,64.01 0,0 0,-59.1 -39.46z");
        this.f29592c.h(-1429742351, -571935747, -131587);
        this.f29592c.setBounds(0, 0, densityUtil.a(260.0f), densityUtil.a(45.0f));
    }

    public void onDraw(Canvas canvas) {
        float f11;
        int width = getWidth();
        int height = getHeight();
        if (this.f29597h) {
            while (this.f29601l.size() < 10) {
                float random = (float) (((double) this.f29595f) / (Math.random() * 5.0d));
                float l11 = l(1000, 2000);
                if (this.f29601l.size() > 1) {
                    while (true) {
                        f11 = 0.0f;
                        while (true) {
                            if (f11 != 0.0f) {
                                break;
                            }
                            float random2 = (float) (((double) this.f29595f) / (Math.random() * 5.0d));
                            Iterator<Map.Entry<Float, Float>> it2 = this.f29601l.entrySet().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (Math.abs(((Float) it2.next().getKey()).floatValue() - random2) > ((float) (this.f29595f / 5))) {
                                        f11 = random2;
                                    }
                                }
                            }
                        }
                    }
                    random = f11;
                    break;
                }
                this.f29601l.put(Float.valueOf(random), Float.valueOf(l11));
                h(canvas, random, l11, width);
            }
            if (this.f29601l.size() >= 10) {
                for (Map.Entry next : this.f29601l.entrySet()) {
                    h(canvas, ((Float) next.getKey()).floatValue(), ((Float) next.getValue()).floatValue(), width);
                }
            }
            if (this.f29605p && this.f29604o) {
                this.f29601l.clear();
                this.f29604o = false;
                this.f29603n = l(50, 300);
            }
            this.f29599j = this.f29598i;
        }
        e(canvas, width, height);
        g(canvas, width, height);
        f(canvas, width, height);
    }

    public int onFinish(j jVar, boolean z11) {
        clearAnimation();
        if (z11) {
            startAnimation(new a());
            return 200;
        }
        this.f29597h = false;
        return 0;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i11), View.resolveSize(getSuggestedMinimumHeight(), i12));
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        this.f29594e = f11;
        this.f29595f = i12;
        this.f29606q = 0.0f;
    }

    public void onReleased(j jVar, int i11, int i12) {
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
        this.f29594e = f11;
        this.f29595f = i12;
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
        this.f29597h = true;
        this.f29606q = 0.0f;
        startAnimation(this.f29596g);
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        setBackgroundColor(iArr[0]);
    }

    public TaurusHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        k(context, attributeSet);
    }
}
