package com.scwang.smartrefresh.layout.footer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.f;
import ky.i;
import ky.j;

public class ClassicsFooter extends RelativeLayout implements f {

    /* renamed from: p  reason: collision with root package name */
    public static String f29818p = "上拉加载更多";

    /* renamed from: q  reason: collision with root package name */
    public static String f29819q = "释放立即加载";

    /* renamed from: r  reason: collision with root package name */
    public static String f29820r = "正在加载...";

    /* renamed from: s  reason: collision with root package name */
    public static String f29821s = "正在刷新...";

    /* renamed from: t  reason: collision with root package name */
    public static String f29822t = "加载完成";

    /* renamed from: u  reason: collision with root package name */
    public static String f29823u = "加载失败";

    /* renamed from: v  reason: collision with root package name */
    public static String f29824v = "没有更多数据了";

    /* renamed from: b  reason: collision with root package name */
    public TextView f29825b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f29826c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f29827d;

    /* renamed from: e  reason: collision with root package name */
    public PathsDrawable f29828e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressDrawable f29829f;

    /* renamed from: g  reason: collision with root package name */
    public SpinnerStyle f29830g = SpinnerStyle.Translate;

    /* renamed from: h  reason: collision with root package name */
    public i f29831h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f29832i;

    /* renamed from: j  reason: collision with root package name */
    public Integer f29833j;

    /* renamed from: k  reason: collision with root package name */
    public int f29834k;

    /* renamed from: l  reason: collision with root package name */
    public int f29835l = 500;

    /* renamed from: m  reason: collision with root package name */
    public int f29836m = 20;

    /* renamed from: n  reason: collision with root package name */
    public int f29837n = 20;

    /* renamed from: o  reason: collision with root package name */
    public boolean f29838o = false;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29839a;

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
                f29839a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29839a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f29839a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f29839a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadReleased     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f29839a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToLoad     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f29839a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.footer.ClassicsFooter.a.<clinit>():void");
        }
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i11) {
        DensityUtil densityUtil = new DensityUtil();
        TextView textView = new TextView(context);
        this.f29825b = textView;
        textView.setId(16908312);
        this.f29825b.setTextColor(-10066330);
        this.f29825b.setText(f29818p);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(this.f29825b, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(densityUtil.a(20.0f), densityUtil.a(20.0f));
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, 16908312);
        ImageView imageView = new ImageView(context);
        this.f29826c = imageView;
        addView(imageView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(layoutParams2);
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, 16908312);
        ImageView imageView2 = new ImageView(context);
        this.f29827d = imageView2;
        imageView2.animate().setInterpolator(new LinearInterpolator());
        addView(this.f29827d, layoutParams3);
        if (!isInEditMode()) {
            this.f29827d.setVisibility(8);
        } else {
            this.f29826c.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClassicsFooter);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClassicsFooter_srlDrawableMarginRight, densityUtil.a(20.0f));
        layoutParams3.rightMargin = dimensionPixelSize;
        layoutParams2.rightMargin = dimensionPixelSize;
        int i12 = R$styleable.ClassicsHeader_srlDrawableArrowSize;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i12, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i12, layoutParams2.height);
        int i13 = R$styleable.ClassicsHeader_srlDrawableProgressSize;
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i13, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i13, layoutParams3.height);
        int i14 = R$styleable.ClassicsHeader_srlDrawableSize;
        layoutParams2.width = obtainStyledAttributes.getLayoutDimension(i14, layoutParams2.width);
        layoutParams2.height = obtainStyledAttributes.getLayoutDimension(i14, layoutParams2.height);
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i14, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i14, layoutParams3.height);
        this.f29835l = obtainStyledAttributes.getInt(R$styleable.ClassicsFooter_srlFinishDuration, this.f29835l);
        this.f29830g = SpinnerStyle.values()[obtainStyledAttributes.getInt(R$styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.f29830g.ordinal())];
        int i15 = R$styleable.ClassicsFooter_srlDrawableArrow;
        if (obtainStyledAttributes.hasValue(i15)) {
            this.f29826c.setImageDrawable(obtainStyledAttributes.getDrawable(i15));
        } else {
            PathsDrawable pathsDrawable = new PathsDrawable();
            this.f29828e = pathsDrawable;
            pathsDrawable.h(-10066330);
            this.f29828e.i("M20,12l-1.41,-1.41L13,16.17V4h-2v12.17l-5.58,-5.59L4,12l8,8 8,-8z");
            this.f29826c.setImageDrawable(this.f29828e);
        }
        int i16 = R$styleable.ClassicsFooter_srlDrawableProgress;
        if (obtainStyledAttributes.hasValue(i16)) {
            this.f29827d.setImageDrawable(obtainStyledAttributes.getDrawable(i16));
        } else {
            ProgressDrawable progressDrawable = new ProgressDrawable();
            this.f29829f = progressDrawable;
            progressDrawable.c(-10066330);
            this.f29827d.setImageDrawable(this.f29829f);
        }
        int i17 = R$styleable.ClassicsFooter_srlTextSizeTitle;
        if (obtainStyledAttributes.hasValue(i17)) {
            this.f29825b.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(i17, DensityUtil.b(16.0f)));
        } else {
            this.f29825b.setTextSize(16.0f);
        }
        int i18 = R$styleable.ClassicsFooter_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i18)) {
            c(obtainStyledAttributes.getColor(i18, 0));
        }
        int i19 = R$styleable.ClassicsFooter_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i19)) {
            b(obtainStyledAttributes.getColor(i19, 0));
        }
        obtainStyledAttributes.recycle();
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int a11 = densityUtil.a(20.0f);
                this.f29836m = a11;
                int paddingRight = getPaddingRight();
                int a12 = densityUtil.a(20.0f);
                this.f29837n = a12;
                setPadding(paddingLeft, a11, paddingRight, a12);
                return;
            }
            int paddingLeft2 = getPaddingLeft();
            int a13 = densityUtil.a(20.0f);
            this.f29836m = a13;
            int paddingRight2 = getPaddingRight();
            int paddingBottom = getPaddingBottom();
            this.f29837n = paddingBottom;
            setPadding(paddingLeft2, a13, paddingRight2, paddingBottom);
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f29836m = paddingTop;
            int paddingRight3 = getPaddingRight();
            int a14 = densityUtil.a(20.0f);
            this.f29837n = a14;
            setPadding(paddingLeft3, paddingTop, paddingRight3, a14);
        } else {
            this.f29836m = getPaddingTop();
            this.f29837n = getPaddingBottom();
        }
    }

    public ClassicsFooter b(int i11) {
        this.f29832i = Integer.valueOf(i11);
        this.f29825b.setTextColor(i11);
        ProgressDrawable progressDrawable = this.f29829f;
        if (progressDrawable != null) {
            progressDrawable.c(i11);
        }
        PathsDrawable pathsDrawable = this.f29828e;
        if (pathsDrawable != null) {
            pathsDrawable.h(i11);
        }
        return this;
    }

    public ClassicsFooter c(int i11) {
        Integer valueOf = Integer.valueOf(i11);
        this.f29833j = valueOf;
        this.f29834k = valueOf.intValue();
        i iVar = this.f29831h;
        if (iVar != null) {
            iVar.d(this.f29833j.intValue());
        }
        return this;
    }

    public ImageView getArrowView() {
        return this.f29826c;
    }

    public ImageView getProgressView() {
        return this.f29827d;
    }

    public SpinnerStyle getSpinnerStyle() {
        return this.f29830g;
    }

    public TextView getTitleText() {
        return this.f29825b;
    }

    public View getView() {
        return this;
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public int onFinish(j jVar, boolean z11) {
        if (this.f29838o) {
            return 0;
        }
        ProgressDrawable progressDrawable = this.f29829f;
        if (progressDrawable != null) {
            progressDrawable.stop();
        } else {
            this.f29827d.animate().rotation(0.0f).setDuration(300);
        }
        this.f29827d.setVisibility(8);
        if (z11) {
            this.f29825b.setText(f29822t);
        } else {
            this.f29825b.setText(f29823u);
        }
        return this.f29835l;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
        this.f29831h = iVar;
        iVar.d(this.f29834k);
    }

    public void onMeasure(int i11, int i12) {
        if (View.MeasureSpec.getMode(i12) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.f29836m, getPaddingRight(), this.f29837n);
        }
        super.onMeasure(i11, i12);
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
    }

    public void onReleased(j jVar, int i11, int i12) {
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
        if (!this.f29838o) {
            this.f29827d.setVisibility(0);
            ProgressDrawable progressDrawable = this.f29829f;
            if (progressDrawable != null) {
                progressDrawable.start();
                return;
            }
            Drawable drawable = this.f29827d.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                this.f29827d.animate().rotation(36000.0f).setDuration(IndexSeeker.MIN_TIME_BETWEEN_POINTS_US);
            }
        }
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        if (!this.f29838o) {
            switch (a.f29839a[refreshState2.ordinal()]) {
                case 1:
                    this.f29826c.setVisibility(0);
                    break;
                case 2:
                    break;
                case 3:
                case 4:
                    this.f29826c.setVisibility(8);
                    this.f29825b.setText(f29820r);
                    return;
                case 5:
                    this.f29825b.setText(f29819q);
                    this.f29826c.animate().rotation(0.0f);
                    return;
                case 6:
                    this.f29825b.setText(f29821s);
                    this.f29827d.setVisibility(8);
                    this.f29826c.setVisibility(8);
                    return;
                default:
                    return;
            }
            this.f29825b.setText(f29818p);
            this.f29826c.animate().rotation(180.0f);
        }
    }

    public boolean setNoMoreData(boolean z11) {
        if (this.f29838o == z11) {
            return true;
        }
        this.f29838o = z11;
        if (z11) {
            this.f29825b.setText(f29824v);
            this.f29826c.setVisibility(8);
        } else {
            this.f29825b.setText(f29818p);
            this.f29826c.setVisibility(0);
        }
        ProgressDrawable progressDrawable = this.f29829f;
        if (progressDrawable != null) {
            progressDrawable.stop();
        } else {
            this.f29827d.animate().rotation(0.0f).setDuration(300);
        }
        this.f29827d.setVisibility(8);
        return true;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (this.f29830g == SpinnerStyle.FixedBehind && iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable)) {
                c(iArr[0]);
            }
            if (iArr.length > 1) {
                b(iArr[1]);
                return;
            }
            int i11 = -1;
            if (iArr[0] == -1) {
                i11 = -10066330;
            }
            b(i11);
        }
    }

    public ClassicsFooter(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet, i11);
    }
}
