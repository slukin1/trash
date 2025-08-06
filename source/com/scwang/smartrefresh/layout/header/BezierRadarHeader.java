package com.scwang.smartrefresh.layout.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.header.bezierradar.RippleView;
import com.scwang.smartrefresh.layout.header.bezierradar.RoundDotView;
import com.scwang.smartrefresh.layout.header.bezierradar.RoundProgressView;
import com.scwang.smartrefresh.layout.header.bezierradar.WaveView;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.g;
import ky.i;
import ky.j;

public class BezierRadarHeader extends FrameLayout implements g {

    /* renamed from: b  reason: collision with root package name */
    public WaveView f29850b;

    /* renamed from: c  reason: collision with root package name */
    public RippleView f29851c;

    /* renamed from: d  reason: collision with root package name */
    public RoundDotView f29852d;

    /* renamed from: e  reason: collision with root package name */
    public RoundProgressView f29853e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29854f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29855g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f29856h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f29857i;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierRadarHeader.this.f29850b.setWaveHeight(((Integer) valueAnimator.getAnimatedValue()).intValue() / 2);
            BezierRadarHeader.this.f29850b.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ j f29859b;

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                BezierRadarHeader.this.f29853e.c();
            }
        }

        public b(j jVar) {
            this.f29859b = jVar;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            BezierRadarHeader.this.f29852d.setVisibility(4);
            BezierRadarHeader.this.f29853e.animate().scaleX(1.0f);
            BezierRadarHeader.this.f29853e.animate().scaleY(1.0f);
            this.f29859b.getLayout().postDelayed(new a(), 200);
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierRadarHeader.this.f29852d.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29863a;

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
                f29863a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29863a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f29863a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f29863a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f29863a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.header.BezierRadarHeader.d.<clinit>():void");
        }
    }

    public BezierRadarHeader(Context context) {
        this(context, (AttributeSet) null);
    }

    public final void d(Context context, AttributeSet attributeSet, int i11) {
        setMinimumHeight(DensityUtil.b(100.0f));
        this.f29850b = new WaveView(getContext());
        this.f29851c = new RippleView(getContext());
        this.f29852d = new RoundDotView(getContext());
        this.f29853e = new RoundProgressView(getContext());
        if (isInEditMode()) {
            addView(this.f29850b, -1, -1);
            addView(this.f29853e, -1, -1);
            this.f29850b.setHeadHeight(1000);
        } else {
            addView(this.f29850b, -1, -1);
            addView(this.f29852d, -1, -1);
            addView(this.f29853e, -1, -1);
            addView(this.f29851c, -1, -1);
            this.f29853e.setScaleX(0.0f);
            this.f29853e.setScaleY(0.0f);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.BezierRadarHeader);
        this.f29854f = obtainStyledAttributes.getBoolean(R$styleable.BezierRadarHeader_srlEnableHorizontalDrag, this.f29854f);
        int i12 = R$styleable.BezierRadarHeader_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i12)) {
            f(obtainStyledAttributes.getColor(i12, 0));
        }
        int i13 = R$styleable.BezierRadarHeader_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i13)) {
            e(obtainStyledAttributes.getColor(i13, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public BezierRadarHeader e(int i11) {
        this.f29856h = Integer.valueOf(i11);
        this.f29852d.setDotColor(i11);
        this.f29851c.setFrontColor(i11);
        this.f29853e.setFrontColor(i11);
        return this;
    }

    public BezierRadarHeader f(int i11) {
        this.f29857i = Integer.valueOf(i11);
        this.f29850b.setWaveColor(i11);
        this.f29853e.setBackColor(i11);
        return this;
    }

    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    public View getView() {
        return this;
    }

    public boolean isSupportHorizontalDrag() {
        return this.f29854f;
    }

    public int onFinish(j jVar, boolean z11) {
        this.f29853e.d();
        this.f29853e.animate().scaleX(0.0f);
        this.f29853e.animate().scaleY(0.0f);
        this.f29851c.setVisibility(0);
        this.f29851c.b();
        return 400;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
        this.f29850b.setWaveOffsetX(i11);
        this.f29850b.invalidate();
    }

    public void onInitialized(i iVar, int i11, int i12) {
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        this.f29850b.setHeadHeight(Math.min(i12, i11));
        this.f29850b.setWaveHeight((int) (((float) Math.max(0, i11 - i12)) * 1.9f));
        this.f29852d.setFraction(f11);
        if (this.f29855g) {
            this.f29850b.invalidate();
        }
    }

    public void onReleased(j jVar, int i11, int i12) {
        this.f29855g = true;
        this.f29850b.setHeadHeight(i11);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f29850b.getWaveHeight(), 0, -((int) (((double) this.f29850b.getWaveHeight()) * 0.8d)), 0, -((int) (((float) this.f29850b.getWaveHeight()) * 0.4f)), 0});
        ofInt.addUpdateListener(new a());
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.setDuration(800);
        ofInt.start();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        ofFloat.addListener(new b(jVar));
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.setDuration(300);
        ofFloat.addUpdateListener(new c());
        ofFloat.start();
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
        onPulling(f11, i11, i12, i13);
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        int i11 = d.f29863a[refreshState2.ordinal()];
        if (i11 == 1) {
            this.f29851c.setVisibility(8);
            this.f29852d.setAlpha(1.0f);
            this.f29852d.setVisibility(0);
        } else if (i11 == 2) {
            this.f29853e.setScaleX(0.0f);
            this.f29853e.setScaleY(0.0f);
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0 && this.f29857i == null) {
            f(iArr[0]);
            this.f29857i = null;
        }
        if (iArr.length > 1 && this.f29856h == null) {
            e(iArr[1]);
            this.f29856h = null;
        }
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierRadarHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f29854f = false;
        d(context, attributeSet, i11);
    }
}
