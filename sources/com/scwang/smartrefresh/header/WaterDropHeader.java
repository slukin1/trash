package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.scwang.smartrefresh.header.waterdrop.WaterDropView;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.g;
import ky.i;
import ky.j;

public class WaterDropHeader extends ViewGroup implements g {

    /* renamed from: b  reason: collision with root package name */
    public RefreshState f29610b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f29611c;

    /* renamed from: d  reason: collision with root package name */
    public WaterDropView f29612d;

    /* renamed from: e  reason: collision with root package name */
    public ProgressDrawable f29613e;

    /* renamed from: f  reason: collision with root package name */
    public gy.b f29614f;

    /* renamed from: g  reason: collision with root package name */
    public int f29615g = 0;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            WaterDropHeader.this.f29612d.setVisibility(8);
            WaterDropHeader.this.f29612d.setAlpha(1.0f);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29617a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29617a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29617a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f29617a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownCanceled     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f29617a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f29617a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f29617a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshFinish     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.header.WaterDropHeader.b.<clinit>():void");
        }
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public final void b(Context context) {
        DensityUtil densityUtil = new DensityUtil();
        WaterDropView waterDropView = new WaterDropView(context);
        this.f29612d = waterDropView;
        addView(waterDropView, -1, -1);
        this.f29612d.e(0);
        ProgressDrawable progressDrawable = new ProgressDrawable();
        this.f29613e = progressDrawable;
        progressDrawable.setBounds(0, 0, densityUtil.a(20.0f), densityUtil.a(20.0f));
        this.f29613e.setCallback(this);
        this.f29611c = new ImageView(context);
        gy.b bVar = new gy.b(context, this.f29611c);
        this.f29614f = bVar;
        bVar.e(-1);
        this.f29614f.setAlpha(255);
        this.f29614f.f(-1, -16737844, -48060, -10053376, -5609780, -30720);
        this.f29611c.setImageDrawable(this.f29614f);
        addView(this.f29611c, densityUtil.a(30.0f), densityUtil.a(30.0f));
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f29610b == RefreshState.Refreshing) {
            canvas.save();
            canvas.translate((float) ((getWidth() / 2) - (this.f29613e.e() / 2)), (float) ((this.f29612d.getMaxCircleRadius() + this.f29612d.getPaddingTop()) - (this.f29613e.b() / 2)));
            this.f29613e.draw(canvas);
            canvas.restore();
        }
    }

    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    public View getView() {
        return this;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.f29613e) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public int onFinish(j jVar, boolean z11) {
        this.f29613e.stop();
        return 0;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = this.f29612d.getMeasuredWidth();
        int i15 = measuredWidth / 2;
        int i16 = measuredWidth2 / 2;
        int i17 = i15 - i16;
        this.f29612d.layout(i17, 0, i17 + measuredWidth2, this.f29612d.getMeasuredHeight() + 0);
        int measuredWidth3 = this.f29611c.getMeasuredWidth();
        int measuredHeight = this.f29611c.getMeasuredHeight();
        int i18 = measuredWidth3 / 2;
        int i19 = i15 - i18;
        int i21 = i16 - i18;
        int i22 = (measuredWidth2 - measuredWidth3) / 2;
        if (i21 + measuredHeight > this.f29612d.getBottom() - i22) {
            i21 = (this.f29612d.getBottom() - i22) - measuredHeight;
        }
        this.f29611c.layout(i19, i21, measuredWidth3 + i19, measuredHeight + i21);
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        ViewGroup.LayoutParams layoutParams = this.f29611c.getLayoutParams();
        this.f29611c.measure(View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824), View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
        this.f29612d.measure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i11), Integer.MIN_VALUE), i12);
        setMeasuredDimension(ViewGroup.resolveSize(Math.max(this.f29611c.getMeasuredWidth(), this.f29612d.getMeasuredHeight()), i11), ViewGroup.resolveSize(Math.max(this.f29611c.getMeasuredHeight(), this.f29612d.getMeasuredHeight()), i12));
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        this.f29612d.f(i11, i13 + i12);
        this.f29612d.postInvalidate();
        float f12 = (float) i12;
        float max = (((float) Math.max(((double) Math.min(1.0f, Math.abs((((float) i11) * 1.0f) / f12))) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        double max2 = (double) (Math.max(0.0f, Math.min((float) (Math.abs(i11) - i12), f12 * 2.0f) / f12) / 4.0f);
        this.f29614f.l(true);
        this.f29614f.j(0.0f, Math.min(0.8f, max * 0.8f));
        this.f29614f.d(Math.min(1.0f, max));
        this.f29614f.g((((0.4f * max) - 16.0f) + (((float) (max2 - Math.pow(max2, 2.0d))) * 2.0f * 2.0f)) * 0.5f);
    }

    public void onReleased(j jVar, int i11, int i12) {
        this.f29613e.start();
        this.f29612d.a().start();
        this.f29612d.animate().alpha(0.0f).setListener(new a());
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
        RefreshState refreshState = this.f29610b;
        if (refreshState != RefreshState.Refreshing && refreshState != RefreshState.RefreshReleased) {
            this.f29612d.f(Math.max(i11, 0), i12 + i13);
            this.f29612d.postInvalidate();
        }
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f29610b = refreshState2;
        int i11 = b.f29617a[refreshState2.ordinal()];
        if (i11 == 1) {
            this.f29612d.setVisibility(0);
        } else if (i11 == 2) {
            this.f29612d.setVisibility(0);
        } else if (i11 == 4) {
            this.f29612d.setVisibility(0);
        } else if (i11 == 6) {
            this.f29612d.setVisibility(8);
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            this.f29612d.setIndicatorColor(iArr[0]);
        }
    }

    public WaterDropHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context);
    }
}
