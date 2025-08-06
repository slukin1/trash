package com.scwang.smartrefresh.header;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.huobi.view.roundimg.RoundedDrawable;
import com.scwang.smartrefresh.header.material.CircleImageView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import gy.b;
import ky.g;
import ky.i;
import ky.j;

public class MaterialHeader extends ViewGroup implements g {

    /* renamed from: b  reason: collision with root package name */
    public boolean f29534b;

    /* renamed from: c  reason: collision with root package name */
    public int f29535c;

    /* renamed from: d  reason: collision with root package name */
    public CircleImageView f29536d;

    /* renamed from: e  reason: collision with root package name */
    public b f29537e;

    /* renamed from: f  reason: collision with root package name */
    public int f29538f;

    /* renamed from: g  reason: collision with root package name */
    public int f29539g;

    /* renamed from: h  reason: collision with root package name */
    public Path f29540h;

    /* renamed from: i  reason: collision with root package name */
    public Paint f29541i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f29542j = false;

    /* renamed from: k  reason: collision with root package name */
    public RefreshState f29543k;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29544a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29544a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29544a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f29544a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f29544a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.header.MaterialHeader.a.<clinit>():void");
        }
    }

    public MaterialHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        setMinimumHeight(DensityUtil.b(100.0f));
        b bVar = new b(context, this);
        this.f29537e = bVar;
        bVar.e(-328966);
        this.f29537e.setAlpha(255);
        this.f29537e.f(-16737844, -48060, -10053376, -5609780, -30720);
        CircleImageView circleImageView = new CircleImageView(context, -328966);
        this.f29536d = circleImageView;
        circleImageView.setImageDrawable(this.f29537e);
        addView(this.f29536d);
        this.f29535c = (int) (getResources().getDisplayMetrics().density * 40.0f);
        this.f29540h = new Path();
        Paint paint = new Paint();
        this.f29541i = paint;
        paint.setAntiAlias(true);
        this.f29541i.setStyle(Paint.Style.FILL);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MaterialHeader);
        this.f29542j = obtainStyledAttributes.getBoolean(R$styleable.MaterialHeader_mhShowBezierWave, this.f29542j);
        this.f29541i.setColor(obtainStyledAttributes.getColor(R$styleable.MaterialHeader_mhPrimaryColor, -15614977));
        int i11 = R$styleable.MaterialHeader_mhShadowRadius;
        if (obtainStyledAttributes.hasValue(i11)) {
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(i11, 0);
            this.f29541i.setShadowLayer((float) dimensionPixelOffset, 0.0f, 0.0f, obtainStyledAttributes.getColor(R$styleable.MaterialHeader_mhShadowColor, RoundedDrawable.DEFAULT_BORDER_COLOR));
            setLayerType(1, (Paint) null);
        }
        obtainStyledAttributes.recycle();
    }

    public void dispatchDraw(Canvas canvas) {
        if (this.f29542j) {
            this.f29540h.reset();
            this.f29540h.lineTo(0.0f, (float) this.f29539g);
            this.f29540h.quadTo((float) (getMeasuredWidth() / 2), ((float) this.f29539g) + (((float) this.f29538f) * 1.9f), (float) getMeasuredWidth(), (float) this.f29539g);
            this.f29540h.lineTo((float) getMeasuredWidth(), 0.0f);
            canvas.drawPath(this.f29540h, this.f29541i);
        }
        super.dispatchDraw(canvas);
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
        this.f29537e.stop();
        this.f29536d.animate().scaleX(0.0f).scaleY(0.0f);
        this.f29534b = true;
        return 0;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
        if (!this.f29542j) {
            iVar.l(false);
        }
        if (isInEditMode()) {
            int i13 = i11 / 2;
            this.f29539g = i13;
            this.f29538f = i13;
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int i15;
        if (getChildCount() != 0) {
            int measuredWidth = getMeasuredWidth();
            int measuredWidth2 = this.f29536d.getMeasuredWidth();
            int measuredHeight = this.f29536d.getMeasuredHeight();
            if (!isInEditMode() || (i15 = this.f29539g) <= 0) {
                int i16 = measuredWidth / 2;
                int i17 = measuredWidth2 / 2;
                int i18 = this.f29535c;
                this.f29536d.layout(i16 - i17, -i18, i16 + i17, measuredHeight - i18);
                return;
            }
            int i19 = i15 - (measuredHeight / 2);
            int i21 = measuredWidth / 2;
            int i22 = measuredWidth2 / 2;
            this.f29536d.layout(i21 - i22, i19, i21 + i22, measuredHeight + i19);
            this.f29537e.l(true);
            this.f29537e.j(0.0f, 0.8f);
            this.f29537e.d(1.0f);
            this.f29536d.setAlpha(1.0f);
            this.f29536d.setVisibility(0);
        }
    }

    public void onMeasure(int i11, int i12) {
        setMeasuredDimension(View.MeasureSpec.getSize(i11), View.MeasureSpec.getSize(i12));
        this.f29536d.measure(View.MeasureSpec.makeMeasureSpec(this.f29535c, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f29535c, 1073741824));
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        if (this.f29542j) {
            this.f29539g = Math.min(i11, i12);
            this.f29538f = Math.max(0, i11 - i12);
            postInvalidate();
        }
        if (this.f29543k != RefreshState.Refreshing) {
            float f12 = (float) i12;
            float f13 = (((float) i11) * 1.0f) / f12;
            float max = (((float) Math.max(((double) Math.min(1.0f, Math.abs(f13))) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
            double max2 = (double) (Math.max(0.0f, Math.min((float) (Math.abs(i11) - i12), f12 * 2.0f) / f12) / 4.0f);
            this.f29537e.l(true);
            this.f29537e.j(0.0f, Math.min(0.8f, max * 0.8f));
            this.f29537e.d(Math.min(1.0f, max));
            this.f29537e.g((((max * 0.4f) - 16.0f) + (((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f * 2.0f)) * 0.5f);
            this.f29536d.setAlpha(Math.min(1.0f, f13 * 2.0f));
        }
        this.f29536d.setTranslationY(Math.min((float) i11, (float) ((i11 / 2) + (this.f29535c / 2))));
    }

    public void onReleased(j jVar, int i11, int i12) {
        this.f29537e.start();
        int i13 = i11 / 2;
        if (((int) this.f29536d.getTranslationY()) != (this.f29535c / 2) + i13) {
            this.f29536d.animate().translationY((float) (i13 + (this.f29535c / 2)));
        }
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
        if (!this.f29537e.isRunning() && !this.f29534b) {
            onPulling(f11, i11, i12, i13);
        } else if (this.f29542j) {
            this.f29539g = Math.min(i11, i12);
            this.f29538f = Math.max(0, i11 - i12);
            postInvalidate();
        }
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f29543k = refreshState2;
        if (a.f29544a[refreshState2.ordinal()] == 2) {
            this.f29534b = false;
            this.f29536d.setVisibility(0);
            this.f29536d.setScaleX(1.0f);
            this.f29536d.setScaleY(1.0f);
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.f29541i.setColor(iArr[0]);
        }
    }

    public MaterialHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet);
    }
}
