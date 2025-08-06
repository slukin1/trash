package com.scwang.smartrefresh.layout.header;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import ky.g;
import ky.i;
import ky.j;

public class ClassicsHeader extends RelativeLayout implements g {
    public static String A = "上次更新 M-d HH:mm";
    public static String B = "释放进入二楼";

    /* renamed from: u  reason: collision with root package name */
    public static String f29864u = "下拉可以刷新";

    /* renamed from: v  reason: collision with root package name */
    public static String f29865v = "正在刷新...";

    /* renamed from: w  reason: collision with root package name */
    public static String f29866w = "正在加载...";

    /* renamed from: x  reason: collision with root package name */
    public static String f29867x = "释放立即刷新";

    /* renamed from: y  reason: collision with root package name */
    public static String f29868y = "刷新完成";

    /* renamed from: z  reason: collision with root package name */
    public static String f29869z = "刷新失败";

    /* renamed from: b  reason: collision with root package name */
    public String f29870b = "LAST_UPDATE_TIME";

    /* renamed from: c  reason: collision with root package name */
    public Date f29871c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f29872d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f29873e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f29874f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f29875g;

    /* renamed from: h  reason: collision with root package name */
    public SharedPreferences f29876h;

    /* renamed from: i  reason: collision with root package name */
    public i f29877i;

    /* renamed from: j  reason: collision with root package name */
    public PathsDrawable f29878j;

    /* renamed from: k  reason: collision with root package name */
    public ProgressDrawable f29879k;

    /* renamed from: l  reason: collision with root package name */
    public SpinnerStyle f29880l = SpinnerStyle.Translate;

    /* renamed from: m  reason: collision with root package name */
    public DateFormat f29881m = new SimpleDateFormat(A, Locale.getDefault());

    /* renamed from: n  reason: collision with root package name */
    public Integer f29882n;

    /* renamed from: o  reason: collision with root package name */
    public Integer f29883o;

    /* renamed from: p  reason: collision with root package name */
    public int f29884p;

    /* renamed from: q  reason: collision with root package name */
    public int f29885q = 500;

    /* renamed from: r  reason: collision with root package name */
    public int f29886r = 20;

    /* renamed from: s  reason: collision with root package name */
    public int f29887s = 20;

    /* renamed from: t  reason: collision with root package name */
    public boolean f29888t = true;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f29889a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.scwang.smartrefresh.layout.constant.RefreshState[] r0 = com.scwang.smartrefresh.layout.constant.RefreshState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f29889a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f29889a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f29889a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f29889a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshReleased     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f29889a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f29889a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToTwoLevel     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f29889a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.scwang.smartrefresh.layout.header.ClassicsHeader.a.<clinit>():void");
        }
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        FragmentManager supportFragmentManager;
        List<Fragment> B0;
        DensityUtil densityUtil = new DensityUtil();
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setId(16908312);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        this.f29872d = textView;
        textView.setText(f29864u);
        this.f29872d.setTextColor(-10066330);
        TextView textView2 = new TextView(context);
        this.f29873e = textView2;
        textView2.setTextColor(-8618884);
        linearLayout.addView(this.f29872d, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.addView(this.f29873e, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        addView(linearLayout, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(densityUtil.a(20.0f), densityUtil.a(20.0f));
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, 16908312);
        ImageView imageView = new ImageView(context);
        this.f29874f = imageView;
        addView(imageView, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(layoutParams3);
        layoutParams4.addRule(15);
        layoutParams4.addRule(0, 16908312);
        ImageView imageView2 = new ImageView(context);
        this.f29875g = imageView2;
        imageView2.animate().setInterpolator(new LinearInterpolator());
        addView(this.f29875g, layoutParams4);
        int i11 = 8;
        if (isInEditMode()) {
            this.f29874f.setVisibility(8);
            this.f29872d.setText(f29865v);
        } else {
            this.f29875g.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClassicsHeader);
        layoutParams.topMargin = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClassicsHeader_srlTextTimeMarginTop, densityUtil.a(0.0f));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClassicsFooter_srlDrawableMarginRight, densityUtil.a(20.0f));
        layoutParams4.rightMargin = dimensionPixelSize;
        layoutParams3.rightMargin = dimensionPixelSize;
        int i12 = R$styleable.ClassicsHeader_srlDrawableArrowSize;
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i12, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i12, layoutParams3.height);
        int i13 = R$styleable.ClassicsHeader_srlDrawableProgressSize;
        layoutParams4.width = obtainStyledAttributes.getLayoutDimension(i13, layoutParams4.width);
        layoutParams4.height = obtainStyledAttributes.getLayoutDimension(i13, layoutParams4.height);
        int i14 = R$styleable.ClassicsHeader_srlDrawableSize;
        layoutParams3.width = obtainStyledAttributes.getLayoutDimension(i14, layoutParams3.width);
        layoutParams3.height = obtainStyledAttributes.getLayoutDimension(i14, layoutParams3.height);
        layoutParams4.width = obtainStyledAttributes.getLayoutDimension(i14, layoutParams4.width);
        layoutParams4.height = obtainStyledAttributes.getLayoutDimension(i14, layoutParams4.height);
        this.f29885q = obtainStyledAttributes.getInt(R$styleable.ClassicsHeader_srlFinishDuration, this.f29885q);
        this.f29888t = obtainStyledAttributes.getBoolean(R$styleable.ClassicsHeader_srlEnableLastTime, this.f29888t);
        this.f29880l = SpinnerStyle.values()[obtainStyledAttributes.getInt(R$styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.f29880l.ordinal())];
        TextView textView3 = this.f29873e;
        if (this.f29888t) {
            i11 = 0;
        }
        textView3.setVisibility(i11);
        int i15 = R$styleable.ClassicsHeader_srlDrawableArrow;
        if (obtainStyledAttributes.hasValue(i15)) {
            this.f29874f.setImageDrawable(obtainStyledAttributes.getDrawable(i15));
        } else {
            PathsDrawable pathsDrawable = new PathsDrawable();
            this.f29878j = pathsDrawable;
            pathsDrawable.h(-10066330);
            this.f29878j.i("M20,12l-1.41,-1.41L13,16.17V4h-2v12.17l-5.58,-5.59L4,12l8,8 8,-8z");
            this.f29874f.setImageDrawable(this.f29878j);
        }
        int i16 = R$styleable.ClassicsHeader_srlDrawableProgress;
        if (obtainStyledAttributes.hasValue(i16)) {
            this.f29875g.setImageDrawable(obtainStyledAttributes.getDrawable(i16));
        } else {
            ProgressDrawable progressDrawable = new ProgressDrawable();
            this.f29879k = progressDrawable;
            progressDrawable.c(-10066330);
            this.f29875g.setImageDrawable(this.f29879k);
        }
        int i17 = R$styleable.ClassicsHeader_srlTextSizeTitle;
        if (obtainStyledAttributes.hasValue(i17)) {
            this.f29872d.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(i17, DensityUtil.b(16.0f)));
        } else {
            this.f29872d.setTextSize(16.0f);
        }
        int i18 = R$styleable.ClassicsHeader_srlTextSizeTime;
        if (obtainStyledAttributes.hasValue(i18)) {
            this.f29873e.setTextSize(0, (float) obtainStyledAttributes.getDimensionPixelSize(i18, DensityUtil.b(12.0f)));
        } else {
            this.f29873e.setTextSize(12.0f);
        }
        int i19 = R$styleable.ClassicsHeader_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i19)) {
            d(obtainStyledAttributes.getColor(i19, 0));
        }
        int i21 = R$styleable.ClassicsHeader_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i21)) {
            b(obtainStyledAttributes.getColor(i21, 0));
        }
        obtainStyledAttributes.recycle();
        if (getPaddingTop() == 0) {
            if (getPaddingBottom() == 0) {
                int paddingLeft = getPaddingLeft();
                int a11 = densityUtil.a(20.0f);
                this.f29886r = a11;
                int paddingRight = getPaddingRight();
                int a12 = densityUtil.a(20.0f);
                this.f29887s = a12;
                setPadding(paddingLeft, a11, paddingRight, a12);
            } else {
                int paddingLeft2 = getPaddingLeft();
                int a13 = densityUtil.a(20.0f);
                this.f29886r = a13;
                int paddingRight2 = getPaddingRight();
                int paddingBottom = getPaddingBottom();
                this.f29887s = paddingBottom;
                setPadding(paddingLeft2, a13, paddingRight2, paddingBottom);
            }
        } else if (getPaddingBottom() == 0) {
            int paddingLeft3 = getPaddingLeft();
            int paddingTop = getPaddingTop();
            this.f29886r = paddingTop;
            int paddingRight3 = getPaddingRight();
            int a14 = densityUtil.a(20.0f);
            this.f29887s = a14;
            setPadding(paddingLeft3, paddingTop, paddingRight3, a14);
        } else {
            this.f29886r = getPaddingTop();
            this.f29887s = getPaddingBottom();
        }
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && (B0 = supportFragmentManager.B0()) != null && B0.size() > 0) {
                c(new Date());
                return;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f29870b += context.getClass().getName();
        this.f29876h = context.getSharedPreferences("ClassicsHeader", 0);
        c(new Date(this.f29876h.getLong(this.f29870b, System.currentTimeMillis())));
    }

    public ClassicsHeader b(int i11) {
        this.f29882n = Integer.valueOf(i11);
        PathsDrawable pathsDrawable = this.f29878j;
        if (pathsDrawable != null) {
            pathsDrawable.h(i11);
        }
        ProgressDrawable progressDrawable = this.f29879k;
        if (progressDrawable != null) {
            progressDrawable.c(i11);
        }
        this.f29872d.setTextColor(i11);
        this.f29873e.setTextColor((i11 & FlexItem.MAX_SIZE) | -872415232);
        return this;
    }

    public ClassicsHeader c(Date date) {
        this.f29871c = date;
        this.f29873e.setText(this.f29881m.format(date));
        if (this.f29876h != null && !isInEditMode()) {
            this.f29876h.edit().putLong(this.f29870b, date.getTime()).apply();
        }
        return this;
    }

    public ClassicsHeader d(int i11) {
        Integer valueOf = Integer.valueOf(i11);
        this.f29883o = valueOf;
        this.f29884p = valueOf.intValue();
        i iVar = this.f29877i;
        if (iVar != null) {
            iVar.c(this.f29883o.intValue());
        }
        return this;
    }

    public ImageView getArrowView() {
        return this.f29874f;
    }

    public TextView getLastUpdateText() {
        return this.f29873e;
    }

    public ImageView getProgressView() {
        return this.f29875g;
    }

    public SpinnerStyle getSpinnerStyle() {
        return this.f29880l;
    }

    public TextView getTitleText() {
        return this.f29872d;
    }

    public View getView() {
        return this;
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public int onFinish(j jVar, boolean z11) {
        ProgressDrawable progressDrawable = this.f29879k;
        if (progressDrawable != null) {
            progressDrawable.stop();
        } else {
            Drawable drawable = this.f29875g.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).stop();
            } else {
                this.f29875g.animate().rotation(0.0f).setDuration(300);
            }
        }
        this.f29875g.setVisibility(8);
        if (z11) {
            this.f29872d.setText(f29868y);
            if (this.f29871c != null) {
                c(new Date());
            }
        } else {
            this.f29872d.setText(f29869z);
        }
        return this.f29885q;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
        this.f29877i = iVar;
        iVar.c(this.f29884p);
    }

    public void onMeasure(int i11, int i12) {
        if (View.MeasureSpec.getMode(i12) == 1073741824) {
            setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
        } else {
            setPadding(getPaddingLeft(), this.f29886r, getPaddingRight(), this.f29887s);
        }
        super.onMeasure(i11, i12);
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
    }

    public void onReleased(j jVar, int i11, int i12) {
        ProgressDrawable progressDrawable = this.f29879k;
        if (progressDrawable != null) {
            progressDrawable.start();
            return;
        }
        Drawable drawable = this.f29875g.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        } else {
            this.f29875g.animate().rotation(36000.0f).setDuration(IndexSeeker.MIN_TIME_BETWEEN_POINTS_US);
        }
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        int i11 = 8;
        switch (a.f29889a[refreshState2.ordinal()]) {
            case 1:
                this.f29873e.setVisibility(this.f29888t ? 0 : 8);
                break;
            case 2:
                break;
            case 3:
            case 4:
                this.f29872d.setText(f29865v);
                this.f29875g.setVisibility(0);
                this.f29874f.setVisibility(8);
                return;
            case 5:
                this.f29872d.setText(f29867x);
                this.f29874f.animate().rotation(180.0f);
                return;
            case 6:
                this.f29872d.setText(B);
                this.f29874f.animate().rotation(0.0f);
                return;
            case 7:
                this.f29874f.setVisibility(8);
                this.f29875g.setVisibility(8);
                TextView textView = this.f29873e;
                if (this.f29888t) {
                    i11 = 4;
                }
                textView.setVisibility(i11);
                this.f29872d.setText(f29866w);
                return;
            default:
                return;
        }
        this.f29872d.setText(f29864u);
        this.f29874f.setVisibility(0);
        this.f29875g.setVisibility(8);
        this.f29874f.animate().rotation(0.0f);
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && this.f29883o == null) {
                d(iArr[0]);
                this.f29883o = null;
            }
            if (this.f29882n == null) {
                if (iArr.length > 1) {
                    b(iArr[1]);
                } else {
                    int i11 = -1;
                    if (iArr[0] == -1) {
                        i11 = -10066330;
                    }
                    b(i11);
                }
                this.f29882n = null;
            }
        }
    }

    public ClassicsHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet);
    }
}
