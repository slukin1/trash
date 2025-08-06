package com.hbg.lib.core.page;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.core.R$color;
import com.hbg.lib.core.R$raw;
import com.hbg.lib.widgets.SafeLottieView;
import com.scwang.smartrefresh.layout.R$styleable;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.Date;
import java.util.List;
import ky.g;
import ky.i;
import ky.j;

public class SmartRefreshHeader extends RelativeLayout implements g {

    /* renamed from: b  reason: collision with root package name */
    public i f68463b;

    /* renamed from: c  reason: collision with root package name */
    public SpinnerStyle f68464c = SpinnerStyle.Scale;

    /* renamed from: d  reason: collision with root package name */
    public Integer f68465d;

    /* renamed from: e  reason: collision with root package name */
    public int f68466e;

    /* renamed from: f  reason: collision with root package name */
    public int f68467f = 500;

    /* renamed from: g  reason: collision with root package name */
    public boolean f68468g = true;

    /* renamed from: h  reason: collision with root package name */
    public float f68469h = 2.5f;

    /* renamed from: i  reason: collision with root package name */
    public LottieAnimationView f68470i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f68471j;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f68472a;

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
                f68472a = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f68472a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullDownToRefresh     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f68472a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f68472a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.RefreshReleased     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f68472a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToRefresh     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f68472a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToTwoLevel     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f68472a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.core.page.SmartRefreshHeader.a.<clinit>():void");
        }
    }

    public SmartRefreshHeader(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        FragmentManager supportFragmentManager;
        List<Fragment> B0;
        DensityUtil densityUtil = new DensityUtil();
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        SafeLottieView safeLottieView = new SafeLottieView(getContext());
        this.f68470i = safeLottieView;
        safeLottieView.setRepeatCount(-1);
        this.f68470i.setAnimation(R$raw.refresh_header);
        linearLayout.addView(this.f68470i, new RelativeLayout.LayoutParams(densityUtil.a(48.0f), densityUtil.a((float) (getArrowViewHeightDp() - 8))));
        TextView textView = new TextView(getContext());
        this.f68471j = textView;
        textView.setTextSize(1, 12.0f);
        this.f68471j.setTextColor(context.getResources().getColor(R$color.baseColorMajorTheme100));
        this.f68471j.setText("HTX.com");
        linearLayout.addView(this.f68471j, new RelativeLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(linearLayout, layoutParams);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClassicsHeader);
        this.f68467f = obtainStyledAttributes.getInt(R$styleable.ClassicsHeader_srlFinishDuration, this.f68467f);
        this.f68468g = obtainStyledAttributes.getBoolean(R$styleable.ClassicsHeader_srlEnableLastTime, this.f68468g);
        this.f68464c = SpinnerStyle.values()[obtainStyledAttributes.getInt(R$styleable.ClassicsHeader_srlClassicsSpinnerStyle, this.f68464c.ordinal())];
        int i11 = R$styleable.ClassicsHeader_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i11)) {
            d(obtainStyledAttributes.getColor(i11, 0));
        }
        obtainStyledAttributes.recycle();
        try {
            if ((context instanceof FragmentActivity) && (supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager()) != null && (B0 = supportFragmentManager.B0()) != null && B0.size() > 0) {
                c(new Date());
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public SmartRefreshHeader b(CharSequence charSequence) {
        return this;
    }

    public SmartRefreshHeader c(Date date) {
        return this;
    }

    public SmartRefreshHeader d(int i11) {
        Integer valueOf = Integer.valueOf(i11);
        this.f68465d = valueOf;
        this.f68466e = valueOf.intValue();
        i iVar = this.f68463b;
        if (iVar != null) {
            iVar.c(this.f68465d.intValue());
        }
        return this;
    }

    public int getArrowViewHeightDp() {
        return 48;
    }

    public SpinnerStyle getSpinnerStyle() {
        return this.f68464c;
    }

    public View getView() {
        return this;
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public int onFinish(j jVar, boolean z11) {
        return this.f68467f;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
        this.f68463b = iVar;
        iVar.c(this.f68466e);
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
        if (f11 >= 1.0f) {
            this.f68470i.setScaleX(1.0f);
            this.f68470i.setScaleY(1.0f);
            this.f68470i.setAlpha(1.0f);
            return;
        }
        this.f68470i.setScaleX(f11);
        this.f68470i.setScaleY(f11);
        this.f68470i.setAlpha(f11);
    }

    public void onReleased(j jVar, int i11, int i12) {
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
        if (f11 >= 1.0f) {
            this.f68470i.setScaleX(1.0f);
            this.f68470i.setScaleY(1.0f);
            this.f68470i.setAlpha(1.0f);
            return;
        }
        this.f68470i.setScaleX(f11);
        this.f68470i.setScaleY(f11);
        this.f68470i.setAlpha(f11);
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        int i11 = a.f68472a[refreshState2.ordinal()];
        if (i11 == 1) {
            this.f68470i.pauseAnimation();
        } else if (i11 == 2) {
            this.f68470i.playAnimation();
        }
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0 && !(getBackground() instanceof BitmapDrawable) && this.f68465d == null) {
            d(iArr[0]);
            this.f68465d = null;
        }
    }

    public void setTextColor(int i11) {
        TextView textView = this.f68471j;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public SmartRefreshHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public SmartRefreshHeader(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet);
    }
}
