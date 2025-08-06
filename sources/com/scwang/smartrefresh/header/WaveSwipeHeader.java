package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.huobi.view.roundimg.RoundedDrawable;
import com.scwang.smartrefresh.header.waveswipe.AnimationImageView;
import com.scwang.smartrefresh.header.waveswipe.WaveView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.g;
import ky.i;
import ky.j;

public class WaveSwipeHeader extends ViewGroup implements g {

    /* renamed from: b  reason: collision with root package name */
    public WaveView f29618b;

    /* renamed from: c  reason: collision with root package name */
    public RefreshState f29619c;

    /* renamed from: d  reason: collision with root package name */
    public ProgressAnimationImageView f29620d;

    /* renamed from: e  reason: collision with root package name */
    public float f29621e;

    public class ProgressAnimationImageView extends AnimationImageView {

        /* renamed from: c  reason: collision with root package name */
        public final gy.b f29622c;

        public ProgressAnimationImageView(Context context) {
            super(context);
            gy.b bVar = new gy.b(context, WaveSwipeHeader.this);
            this.f29622c = bVar;
            bVar.e(0);
            if (jy.a.a(getContext())) {
                bVar.n(0);
            }
            setImageDrawable(bVar);
        }

        public final int a(int i11) {
            return View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        }

        public void b() {
            this.f29622c.setAlpha(255);
        }

        public void c() {
            int intrinsicWidth = this.f29622c.getIntrinsicWidth();
            measure(a(intrinsicWidth), a(intrinsicWidth));
        }

        public void d(float f11) {
            setScaleX(f11);
            setScaleY(f11);
        }

        public void e(float f11) {
            this.f29622c.d(f11);
        }

        public void f(int... iArr) {
            this.f29622c.f(iArr);
        }

        public void g(float f11) {
            this.f29622c.g(f11);
        }

        public void h(float f11, float f12) {
            this.f29622c.j(f11, f12);
        }

        public void i(boolean z11) {
            this.f29622c.l(z11);
        }

        public void j() {
            this.f29622c.start();
        }

        public void k() {
            this.f29622c.stop();
        }
    }

    public enum VERTICAL_DRAG_THRESHOLD {
        FIRST(0.1f),
        SECOND(r0.val + 0.16f),
        THIRD(r0.val + 0.5f);
        
        public final float val;

        private VERTICAL_DRAG_THRESHOLD(float f11) {
            this.val = f11;
        }
    }

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveSwipeHeader.this.f29620d.setTranslationY(WaveSwipeHeader.this.f29618b.getCurrentCircleCenterY() + (((float) WaveSwipeHeader.this.f29620d.getHeight()) / 2.0f));
        }
    }

    public class b extends Animation {
        public b() {
        }

        public void applyTransformation(float f11, Transformation transformation) {
            WaveSwipeHeader.this.f29620d.d(1.0f - f11);
        }
    }

    public class c implements Animation.AnimationListener {
        public c() {
        }

        public void onAnimationEnd(Animation animation) {
            WaveSwipeHeader.this.f29620d.k();
            WaveSwipeHeader.this.f29620d.b();
            WaveSwipeHeader.this.f29618b.q();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29627a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29627a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29627a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f29627a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownCanceled     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f29627a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f29627a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.header.WaveSwipeHeader.d.<clinit>():void");
        }
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context, attributeSet);
    }

    public final void c(Context context, AttributeSet attributeSet) {
        WaveView waveView = new WaveView(context);
        this.f29618b = waveView;
        addView(waveView);
        ProgressAnimationImageView progressAnimationImageView = new ProgressAnimationImageView(getContext());
        this.f29620d = progressAnimationImageView;
        addView(progressAnimationImageView);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.WaveSwipeHeader);
        int color = obtainStyledAttributes.getColor(R$styleable.WaveSwipeHeader_wshPrimaryColor, 0);
        int color2 = obtainStyledAttributes.getColor(R$styleable.WaveSwipeHeader_wshAccentColor, 0);
        if (color != 0) {
            this.f29618b.setWaveColor(color);
        }
        if (color2 != 0) {
            this.f29620d.f(color2);
        } else {
            this.f29620d.f(-1);
        }
        int i11 = R$styleable.WaveSwipeHeader_wshShadowRadius;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f29618b.n(obtainStyledAttributes.getDimensionPixelOffset(i11, 0), obtainStyledAttributes.getColor(R$styleable.WaveSwipeHeader_wshShadowColor, RoundedDrawable.DEFAULT_BORDER_COLOR));
        }
        obtainStyledAttributes.recycle();
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

    public int onFinish(j jVar, boolean z11) {
        b bVar = new b();
        bVar.setDuration(200);
        this.f29620d.setAnimationListener(new c());
        this.f29620d.clearAnimation();
        this.f29620d.startAnimation(bVar);
        return 0;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.f29618b.layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = this.f29620d.getMeasuredWidth();
        this.f29620d.layout((measuredWidth - measuredWidth2) / 2, -this.f29620d.getMeasuredHeight(), (measuredWidth + measuredWidth2) / 2, 0);
        if (isInEditMode()) {
            onPulling(0.99f, DensityUtil.b(99.0f), DensityUtil.b(100.0f), DensityUtil.b(100.0f));
        }
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.MeasureSpec.getSize(i11), View.MeasureSpec.getSize(i12));
        this.f29620d.c();
        this.f29618b.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12), 1073741824));
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        if (this.f29619c != RefreshState.Refreshing) {
            float max = (((float) Math.max(((double) Math.min(1.0f, f11)) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            float f12 = f11 > 3.0f ? 2.0f : f11 > 1.0f ? f11 - 1.0f : 0.0f;
            float f13 = ((4.0f - f12) * f12) / 8.0f;
            if (f11 < 1.0f) {
                this.f29620d.h(0.0f, Math.min(0.8f, max * 0.8f));
                this.f29620d.e(Math.min(1.0f, max));
            }
            this.f29620d.g((((max * 0.4f) - 16.0f) + (f13 * 2.0f)) * 0.5f);
            this.f29620d.setTranslationY(this.f29618b.getCurrentCircleCenterY());
            float min = (((float) i11) * 1.0f) / ((float) Math.min(getMeasuredWidth(), getMeasuredHeight()));
            float f14 = (min * (5.0f - (2.0f * min))) / 3.5f;
            float f15 = VERTICAL_DRAG_THRESHOLD.FIRST.val;
            float f16 = f14 - f15;
            float f17 = VERTICAL_DRAG_THRESHOLD.SECOND.val;
            float f18 = (f14 - f17) / 5.0f;
            this.f29621e = f14;
            if (f14 < f15) {
                this.f29618b.h(f14);
            } else if (f14 < f17) {
                this.f29618b.g(f14, f16);
            } else {
                this.f29618b.i(f14, f16, f18);
            }
        }
    }

    public void onReleased(j jVar, int i11, int i12) {
        this.f29621e = 0.0f;
        this.f29618b.f();
        this.f29620d.b();
        this.f29620d.j();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 0.0f});
        ofFloat.setDuration(500);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new a());
        ofFloat.start();
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f29619c = refreshState2;
        int i11 = d.f29627a[refreshState2.ordinal()];
        if (i11 == 2) {
            this.f29620d.i(true);
            this.f29620d.d(1.0f);
            this.f29620d.b();
        } else if (i11 == 3) {
            this.f29620d.i(false);
            this.f29620d.g(0.0f);
            this.f29620d.h(0.0f, 0.0f);
            this.f29618b.s(this.f29621e);
            this.f29621e = 0.0f;
        }
    }

    public void setColorSchemeColors(int... iArr) {
        this.f29620d.f(iArr);
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.f29618b.setWaveColor(iArr[0]);
            if (iArr.length > 1) {
                this.f29620d.f(iArr[1]);
            }
        }
    }

    public WaveSwipeHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context, attributeSet);
    }
}
