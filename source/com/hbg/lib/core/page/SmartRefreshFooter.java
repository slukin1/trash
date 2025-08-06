package com.hbg.lib.core.page;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.core.R$id;
import com.hbg.lib.core.R$layout;
import com.hbg.lib.core.R$string;
import com.hbg.lib.core.R$styleable;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.f;
import ky.i;
import ky.j;

public class SmartRefreshFooter extends RelativeLayout implements f {

    /* renamed from: q  reason: collision with root package name */
    public static String f68440q;

    /* renamed from: r  reason: collision with root package name */
    public static String f68441r;

    /* renamed from: s  reason: collision with root package name */
    public static String f68442s;

    /* renamed from: t  reason: collision with root package name */
    public static String f68443t;

    /* renamed from: u  reason: collision with root package name */
    public static String f68444u;

    /* renamed from: v  reason: collision with root package name */
    public static String f68445v;

    /* renamed from: w  reason: collision with root package name */
    public static String f68446w;

    /* renamed from: b  reason: collision with root package name */
    public TextView f68447b;

    /* renamed from: c  reason: collision with root package name */
    public View f68448c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f68449d;

    /* renamed from: e  reason: collision with root package name */
    public PathsDrawable f68450e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressDrawable f68451f;

    /* renamed from: g  reason: collision with root package name */
    public SpinnerStyle f68452g = SpinnerStyle.Translate;

    /* renamed from: h  reason: collision with root package name */
    public i f68453h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f68454i;

    /* renamed from: j  reason: collision with root package name */
    public Integer f68455j;

    /* renamed from: k  reason: collision with root package name */
    public int f68456k;

    /* renamed from: l  reason: collision with root package name */
    public int f68457l = 500;

    /* renamed from: m  reason: collision with root package name */
    public int f68458m = 20;

    /* renamed from: n  reason: collision with root package name */
    public int f68459n = 20;

    /* renamed from: o  reason: collision with root package name */
    public boolean f68460o = false;

    /* renamed from: p  reason: collision with root package name */
    public RelativeLayout f68461p;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68462a;

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
                f68462a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f68462a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f68462a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f68462a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadReleased     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f68462a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToLoad     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f68462a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.core.page.SmartRefreshFooter.a.<clinit>():void");
        }
    }

    public SmartRefreshFooter(Context context) {
        super(context);
        a(context, (AttributeSet) null, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i11) {
        new DensityUtil();
        f68440q = context.getString(R$string.pull_footer_load_more);
        f68441r = context.getString(R$string.pull_footer_release_load_more);
        f68442s = context.getString(R$string.pull_footer_load_moreing);
        f68443t = context.getString(R$string.pull_footer_load_more_refresh);
        f68444u = context.getString(R$string.pull_footer_load_more_released);
        f68445v = context.getString(R$string.pull_footer_load_more_failed);
        f68446w = context.getString(R$string.no_more);
        View inflate = LayoutInflater.from(context).inflate(R$layout.smart_default_footer, this);
        this.f68447b = (TextView) inflate.findViewById(R$id.classic_footer_title);
        this.f68461p = (RelativeLayout) inflate.findViewById(R$id.relative_layout_footer_box);
        this.f68447b.setText(f68440q);
        this.f68449d = (LottieAnimationView) inflate.findViewById(R$id.classic_footer_progressbar);
        this.f68448c = inflate.findViewById(R$id.classic_footer_divider);
        if (!isInEditMode()) {
            this.f68449d.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClassicsFooter);
        this.f68457l = obtainStyledAttributes.getInt(R$styleable.ClassicsFooter_srlFinishDuration, this.f68457l);
        this.f68452g = SpinnerStyle.values()[obtainStyledAttributes.getInt(R$styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.f68452g.ordinal())];
        int i12 = R$styleable.ClassicsFooter_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i12)) {
            c(obtainStyledAttributes.getColor(i12, 0));
        }
        int i13 = R$styleable.ClassicsFooter_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i13)) {
            b(obtainStyledAttributes.getColor(i13, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public SmartRefreshFooter b(int i11) {
        this.f68454i = Integer.valueOf(i11);
        this.f68447b.setTextColor(i11);
        ProgressDrawable progressDrawable = this.f68451f;
        if (progressDrawable != null) {
            progressDrawable.c(i11);
        }
        PathsDrawable pathsDrawable = this.f68450e;
        if (pathsDrawable != null) {
            pathsDrawable.h(i11);
        }
        return this;
    }

    public SmartRefreshFooter c(int i11) {
        Integer valueOf = Integer.valueOf(i11);
        this.f68455j = valueOf;
        this.f68456k = valueOf.intValue();
        i iVar = this.f68453h;
        if (iVar != null) {
            iVar.d(this.f68455j.intValue());
        }
        return this;
    }

    public ImageView getProgressView() {
        return this.f68449d;
    }

    public SpinnerStyle getSpinnerStyle() {
        return this.f68452g;
    }

    public TextView getTitleText() {
        return this.f68447b;
    }

    public View getView() {
        return this;
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public int onFinish(j jVar, boolean z11) {
        if (this.f68460o) {
            return 0;
        }
        this.f68449d.cancelAnimation();
        this.f68449d.setVisibility(8);
        if (z11) {
            this.f68447b.setText(f68444u);
        } else {
            this.f68447b.setText(f68445v);
        }
        return this.f68457l;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
        this.f68453h = iVar;
        iVar.d(this.f68456k);
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
    }

    public void onReleased(j jVar, int i11, int i12) {
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
        if (!this.f68460o) {
            this.f68449d.setVisibility(0);
            ProgressDrawable progressDrawable = this.f68451f;
            if (progressDrawable != null) {
                progressDrawable.start();
            } else {
                this.f68449d.playAnimation();
            }
        }
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        if (!this.f68460o) {
            switch (a.f68462a[refreshState2.ordinal()]) {
                case 1:
                case 2:
                    this.f68447b.setText(f68440q);
                    return;
                case 3:
                case 4:
                    this.f68447b.setText(f68442s);
                    return;
                case 5:
                    this.f68447b.setText(f68441r);
                    return;
                case 6:
                    this.f68447b.setText(f68443t);
                    this.f68449d.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    public void setFooterBackgroundColor(int i11) {
        this.f68461p.setBackgroundColor(i11);
    }

    public void setFooterDividerVisible(boolean z11) {
        if (!z11) {
            this.f68448c.setVisibility(8);
        } else {
            this.f68448c.setVisibility(0);
        }
    }

    public boolean setNoMoreData(boolean z11) {
        if (this.f68460o == z11) {
            return true;
        }
        this.f68460o = z11;
        if (z11) {
            this.f68447b.setText(f68446w);
        } else {
            this.f68447b.setText(f68440q);
        }
        this.f68449d.setVisibility(8);
        return true;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (this.f68452g == SpinnerStyle.FixedBehind && iArr.length > 0) {
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

    public SmartRefreshFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public SmartRefreshFooter(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet, i11);
    }
}
