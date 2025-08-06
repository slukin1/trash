package com.huobi.page;

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
import com.huobi.R$styleable;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.f;
import ky.i;
import ky.j;
import pro.huobi.R;

public class SmartRefreshFooter extends RelativeLayout implements f {

    /* renamed from: p  reason: collision with root package name */
    public static String f80233p;

    /* renamed from: q  reason: collision with root package name */
    public static String f80234q;

    /* renamed from: r  reason: collision with root package name */
    public static String f80235r;

    /* renamed from: s  reason: collision with root package name */
    public static String f80236s;

    /* renamed from: t  reason: collision with root package name */
    public static String f80237t;

    /* renamed from: u  reason: collision with root package name */
    public static String f80238u;

    /* renamed from: v  reason: collision with root package name */
    public static String f80239v;

    /* renamed from: b  reason: collision with root package name */
    public TextView f80240b;

    /* renamed from: c  reason: collision with root package name */
    public View f80241c;

    /* renamed from: d  reason: collision with root package name */
    public LottieAnimationView f80242d;

    /* renamed from: e  reason: collision with root package name */
    public PathsDrawable f80243e;

    /* renamed from: f  reason: collision with root package name */
    public ProgressDrawable f80244f;

    /* renamed from: g  reason: collision with root package name */
    public SpinnerStyle f80245g = SpinnerStyle.Translate;

    /* renamed from: h  reason: collision with root package name */
    public i f80246h;

    /* renamed from: i  reason: collision with root package name */
    public Integer f80247i;

    /* renamed from: j  reason: collision with root package name */
    public Integer f80248j;

    /* renamed from: k  reason: collision with root package name */
    public int f80249k;

    /* renamed from: l  reason: collision with root package name */
    public int f80250l = 500;

    /* renamed from: m  reason: collision with root package name */
    public int f80251m = 20;

    /* renamed from: n  reason: collision with root package name */
    public int f80252n = 20;

    /* renamed from: o  reason: collision with root package name */
    public boolean f80253o = false;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f80254a;

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
                f80254a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f80254a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f80254a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f80254a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadReleased     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f80254a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToLoad     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f80254a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.page.SmartRefreshFooter.a.<clinit>():void");
        }
    }

    public SmartRefreshFooter(Context context) {
        super(context);
        a(context, (AttributeSet) null, 0);
    }

    public final void a(Context context, AttributeSet attributeSet, int i11) {
        new DensityUtil();
        f80233p = context.getString(R.string.pull_footer_load_more);
        f80234q = context.getString(R.string.pull_footer_release_load_more);
        f80235r = context.getString(R.string.pull_footer_load_moreing);
        f80236s = context.getString(R.string.pull_footer_load_more_refresh);
        f80237t = context.getString(R.string.pull_footer_load_more_released);
        f80238u = context.getString(R.string.pull_footer_load_more_failed);
        f80239v = context.getString(R.string.no_more);
        View inflate = LayoutInflater.from(context).inflate(R.layout.smart_default_footer, this);
        TextView textView = (TextView) inflate.findViewById(R.id.classic_footer_title);
        this.f80240b = textView;
        textView.setText(f80233p);
        this.f80242d = (LottieAnimationView) inflate.findViewById(R.id.classic_footer_progressbar);
        this.f80241c = inflate.findViewById(R.id.classic_footer_divider);
        if (!isInEditMode()) {
            this.f80242d.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClassicsFooter);
        this.f80250l = obtainStyledAttributes.getInt(8, this.f80250l);
        this.f80245g = SpinnerStyle.values()[obtainStyledAttributes.getInt(1, this.f80245g.ordinal())];
        if (obtainStyledAttributes.hasValue(9)) {
            c(obtainStyledAttributes.getColor(9, 0));
        }
        if (obtainStyledAttributes.hasValue(0)) {
            b(obtainStyledAttributes.getColor(0, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public SmartRefreshFooter b(int i11) {
        this.f80247i = Integer.valueOf(i11);
        this.f80240b.setTextColor(i11);
        ProgressDrawable progressDrawable = this.f80244f;
        if (progressDrawable != null) {
            progressDrawable.c(i11);
        }
        PathsDrawable pathsDrawable = this.f80243e;
        if (pathsDrawable != null) {
            pathsDrawable.h(i11);
        }
        return this;
    }

    public SmartRefreshFooter c(int i11) {
        Integer valueOf = Integer.valueOf(i11);
        this.f80248j = valueOf;
        this.f80249k = valueOf.intValue();
        i iVar = this.f80246h;
        if (iVar != null) {
            iVar.d(this.f80248j.intValue());
        }
        return this;
    }

    public ImageView getProgressView() {
        return this.f80242d;
    }

    public SpinnerStyle getSpinnerStyle() {
        return this.f80245g;
    }

    public TextView getTitleText() {
        return this.f80240b;
    }

    public View getView() {
        return this;
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public int onFinish(j jVar, boolean z11) {
        if (this.f80253o) {
            return 0;
        }
        this.f80242d.cancelAnimation();
        this.f80242d.setVisibility(8);
        if (z11) {
            this.f80240b.setText(f80237t);
        } else {
            this.f80240b.setText(f80238u);
        }
        return this.f80250l;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
        this.f80246h = iVar;
        iVar.d(this.f80249k);
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
    }

    public void onReleased(j jVar, int i11, int i12) {
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
        if (!this.f80253o) {
            this.f80242d.setVisibility(0);
            ProgressDrawable progressDrawable = this.f80244f;
            if (progressDrawable != null) {
                progressDrawable.start();
            } else {
                this.f80242d.playAnimation();
            }
        }
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        if (!this.f80253o) {
            switch (a.f80254a[refreshState2.ordinal()]) {
                case 1:
                case 2:
                    this.f80240b.setText(f80233p);
                    return;
                case 3:
                case 4:
                    this.f80240b.setText(f80235r);
                    return;
                case 5:
                    this.f80240b.setText(f80234q);
                    return;
                case 6:
                    this.f80240b.setText(f80236s);
                    this.f80242d.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    public void setFooterDividerVisible(boolean z11) {
        if (!z11) {
            this.f80241c.setVisibility(8);
        } else {
            this.f80241c.setVisibility(0);
        }
    }

    public boolean setNoMoreData(boolean z11) {
        if (this.f80253o == z11) {
            return true;
        }
        this.f80253o = z11;
        if (z11) {
            this.f80240b.setText(f80239v);
        } else {
            this.f80240b.setText(f80233p);
        }
        this.f80242d.setVisibility(8);
        return true;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (this.f80245g == SpinnerStyle.FixedBehind && iArr.length > 0) {
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
