package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.scwang.smartrefresh.header.storehouse.StoreHousePath;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.ArrayList;
import ky.g;
import ky.i;
import ky.j;

public class StoreHouseHeader extends View implements g {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<hy.a> f29563b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public int f29564c = -1;

    /* renamed from: d  reason: collision with root package name */
    public float f29565d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public int f29566e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f29567f = -1;

    /* renamed from: g  reason: collision with root package name */
    public float f29568g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public int f29569h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f29570i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f29571j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f29572k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f29573l = 1000;

    /* renamed from: m  reason: collision with root package name */
    public int f29574m = 1000;

    /* renamed from: n  reason: collision with root package name */
    public int f29575n = -1;

    /* renamed from: o  reason: collision with root package name */
    public int f29576o = 0;

    /* renamed from: p  reason: collision with root package name */
    public boolean f29577p = false;

    /* renamed from: q  reason: collision with root package name */
    public boolean f29578q = false;

    /* renamed from: r  reason: collision with root package name */
    public Matrix f29579r = new Matrix();

    /* renamed from: s  reason: collision with root package name */
    public i f29580s;

    /* renamed from: t  reason: collision with root package name */
    public b f29581t = new b(this, (a) null);

    /* renamed from: u  reason: collision with root package name */
    public Transformation f29582u = new Transformation();

    public class a extends Animation {
        public a() {
            setDuration(250);
            setInterpolator(new AccelerateInterpolator());
        }

        public void applyTransformation(float f11, Transformation transformation) {
            StoreHouseHeader.this.setProgress(1.0f - f11);
            StoreHouseHeader.this.invalidate();
            if (f11 == 1.0f) {
                for (int i11 = 0; i11 < StoreHouseHeader.this.f29563b.size(); i11++) {
                    StoreHouseHeader.this.f29563b.get(i11).c(StoreHouseHeader.this.f29567f);
                }
            }
        }
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        g(context, attributeSet);
    }

    private int getBottomOffset() {
        return getPaddingBottom() + DensityUtil.b(10.0f);
    }

    private int getTopOffset() {
        return getPaddingTop() + DensityUtil.b(10.0f);
    }

    /* access modifiers changed from: private */
    public void setProgress(float f11) {
        this.f29568g = f11;
    }

    public final void f() {
        this.f29577p = true;
        this.f29581t.c();
        invalidate();
    }

    public final void g(Context context, AttributeSet attributeSet) {
        DensityUtil densityUtil = new DensityUtil();
        this.f29564c = densityUtil.a(1.0f);
        this.f29566e = densityUtil.a(40.0f);
        this.f29567f = Resources.getSystem().getDisplayMetrics().widthPixels / 2;
        this.f29576o = -13421773;
        l(-3355444);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.StoreHouseHeader);
        this.f29564c = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.StoreHouseHeader_shhLineWidth, this.f29564c);
        this.f29566e = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.StoreHouseHeader_shhDropHeight, this.f29566e);
        this.f29578q = obtainStyledAttributes.getBoolean(R$styleable.StoreHouseHeader_shhEnableFadeAnimation, this.f29578q);
        int i11 = R$styleable.StoreHouseHeader_shhText;
        if (obtainStyledAttributes.hasValue(i11)) {
            i(obtainStyledAttributes.getString(i11));
        } else {
            i("StoreHouse");
        }
        obtainStyledAttributes.recycle();
        setMinimumHeight(this.f29570i + DensityUtil.b(40.0f));
    }

    public int getLoadingAniDuration() {
        return this.f29573l;
    }

    public float getScale() {
        return this.f29565d;
    }

    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Translate;
    }

    public View getView() {
        return this;
    }

    public StoreHouseHeader h(ArrayList<float[]> arrayList) {
        boolean z11 = this.f29563b.size() > 0;
        this.f29563b.clear();
        DensityUtil densityUtil = new DensityUtil();
        float f11 = 0.0f;
        float f12 = 0.0f;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            float[] fArr = arrayList.get(i11);
            PointF pointF = new PointF(((float) densityUtil.a(fArr[0])) * this.f29565d, ((float) densityUtil.a(fArr[1])) * this.f29565d);
            PointF pointF2 = new PointF(((float) densityUtil.a(fArr[2])) * this.f29565d, ((float) densityUtil.a(fArr[3])) * this.f29565d);
            f11 = Math.max(Math.max(f11, pointF.x), pointF2.x);
            f12 = Math.max(Math.max(f12, pointF.y), pointF2.y);
            hy.a aVar = new hy.a(i11, pointF, pointF2, this.f29575n, this.f29564c);
            aVar.c(this.f29567f);
            this.f29563b.add(aVar);
        }
        this.f29569h = (int) Math.ceil((double) f11);
        this.f29570i = (int) Math.ceil((double) f12);
        if (z11) {
            requestLayout();
        }
        return this;
    }

    public StoreHouseHeader i(String str) {
        j(str, 25);
        return this;
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public StoreHouseHeader j(String str, int i11) {
        h(StoreHousePath.b(str, ((float) i11) * 0.01f, 14));
        return this;
    }

    public final void k() {
        this.f29577p = false;
        this.f29581t.d();
    }

    public StoreHouseHeader l(int i11) {
        this.f29575n = i11;
        for (int i12 = 0; i12 < this.f29563b.size(); i12++) {
            this.f29563b.get(i12).e(i11);
        }
        return this;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f29580s = null;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int save = canvas.save();
        int size = this.f29563b.size();
        float f11 = isInEditMode() ? 1.0f : this.f29568g;
        for (int i11 = 0; i11 < size; i11++) {
            canvas.save();
            hy.a aVar = this.f29563b.get(i11);
            PointF pointF = aVar.f37197b;
            float f12 = ((float) this.f29571j) + pointF.x;
            float f13 = ((float) this.f29572k) + pointF.y;
            if (this.f29577p) {
                aVar.getTransformation(getDrawingTime(), this.f29582u);
                canvas.translate(f12, f13);
            } else {
                float f14 = 0.0f;
                if (f11 == 0.0f) {
                    aVar.c(this.f29567f);
                } else {
                    float f15 = (((float) i11) * 0.3f) / ((float) size);
                    float f16 = 0.3f - f15;
                    if (f11 == 1.0f || f11 >= 1.0f - f16) {
                        canvas.translate(f12, f13);
                        aVar.d(0.4f);
                    } else {
                        if (f11 > f15) {
                            f14 = Math.min(1.0f, (f11 - f15) / 0.7f);
                        }
                        float f17 = 1.0f - f14;
                        float f18 = f12 + (aVar.f37198c * f17);
                        float f19 = f13 + (((float) (-this.f29566e)) * f17);
                        this.f29579r.reset();
                        this.f29579r.postRotate(360.0f * f14);
                        this.f29579r.postScale(f14, f14);
                        this.f29579r.postTranslate(f18, f19);
                        aVar.d(f14 * 0.4f);
                        canvas.concat(this.f29579r);
                    }
                }
            }
            aVar.b(canvas);
            canvas.restore();
        }
        if (this.f29577p) {
            invalidate();
        }
        canvas.restoreToCount(save);
    }

    public int onFinish(j jVar, boolean z11) {
        k();
        if (!z11 || !this.f29578q) {
            for (int i11 = 0; i11 < this.f29563b.size(); i11++) {
                this.f29563b.get(i11).c(this.f29567f);
            }
            return 0;
        }
        startAnimation(new a());
        return 250;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
        iVar.c(this.f29576o);
        this.f29580s = iVar;
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i11), View.resolveSize(getSuggestedMinimumHeight(), i12));
        this.f29571j = (getMeasuredWidth() - this.f29569h) / 2;
        this.f29572k = (getMeasuredHeight() - this.f29570i) / 2;
        this.f29566e = getMeasuredHeight() / 2;
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        setProgress(f11 * 0.8f);
        invalidate();
    }

    public void onReleased(j jVar, int i11, int i12) {
        f();
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
        setProgress(f11 * 0.8f);
        invalidate();
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.f29576o = iArr[0];
            i iVar = this.f29580s;
            if (iVar != null) {
                iVar.c(iArr[0]);
            }
            if (iArr.length > 1) {
                l(iArr[1]);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public int f29584b;

        /* renamed from: c  reason: collision with root package name */
        public int f29585c;

        /* renamed from: d  reason: collision with root package name */
        public int f29586d;

        /* renamed from: e  reason: collision with root package name */
        public int f29587e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f29588f;

        public b() {
            this.f29584b = 0;
            this.f29585c = 0;
            this.f29586d = 0;
            this.f29587e = 0;
            this.f29588f = true;
        }

        public final void c() {
            this.f29588f = true;
            this.f29584b = 0;
            this.f29587e = StoreHouseHeader.this.f29573l / StoreHouseHeader.this.f29563b.size();
            this.f29585c = StoreHouseHeader.this.f29574m / this.f29587e;
            this.f29586d = (StoreHouseHeader.this.f29563b.size() / this.f29585c) + 1;
            run();
        }

        public final void d() {
            this.f29588f = false;
            StoreHouseHeader.this.removeCallbacks(this);
        }

        public void run() {
            int i11 = this.f29584b % this.f29585c;
            for (int i12 = 0; i12 < this.f29586d; i12++) {
                int i13 = (this.f29585c * i12) + i11;
                if (i13 <= this.f29584b) {
                    hy.a aVar = StoreHouseHeader.this.f29563b.get(i13 % StoreHouseHeader.this.f29563b.size());
                    aVar.setFillAfter(false);
                    aVar.setFillEnabled(true);
                    aVar.setFillBefore(false);
                    aVar.setDuration(400);
                    aVar.g(1.0f, 0.4f);
                }
            }
            this.f29584b++;
            if (this.f29588f && StoreHouseHeader.this.f29580s != null) {
                StoreHouseHeader.this.f29580s.f().getLayout().postDelayed(this, (long) this.f29587e);
            }
        }

        public /* synthetic */ b(StoreHouseHeader storeHouseHeader, a aVar) {
            this();
        }
    }

    public StoreHouseHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        g(context, attributeSet);
    }
}
