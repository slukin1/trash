package com.huochat.community.widget.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.huochat.community.R;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.ProgressDrawable;
import com.scwang.smartrefresh.layout.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import ky.f;
import ky.i;
import ky.j;

@SuppressLint({"RestrictedApi"})
public class ComSmartRefreshFooter extends RelativeLayout implements f {
    private static String refreshFooterAllloaded;
    private static String refreshFooterFailed;
    private static String refreshFooterFinish;
    private static String refreshFooterLoading;
    private static String refreshFooterPullup;
    private static String refreshFooterRefreshing;
    private static String refreshFooterRelease;
    public View footerDivider;
    public Integer mAccentColor;
    public PathsDrawable mArrowDrawable;
    public int mBackgroundColor;
    public int mFinishDuration = 500;
    public boolean mNoMoreData = false;
    public int mPaddingBottom = 20;
    public int mPaddingTop = 20;
    public Integer mPrimaryColor;
    public ProgressDrawable mProgressDrawable;
    public LottieAnimationView mProgressView;
    public i mRefreshKernel;
    public SpinnerStyle mSpinnerStyle = SpinnerStyle.Translate;
    public TextView mTitleText;

    /* renamed from: com.huochat.community.widget.refresh.ComSmartRefreshFooter$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState;

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
                $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState = r0
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.None     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.PullUpToLoad     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Loading     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.LoadReleased     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x003e }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.ReleaseToLoad     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.scwang.smartrefresh.layout.constant.RefreshState r1 = com.scwang.smartrefresh.layout.constant.RefreshState.Refreshing     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.widget.refresh.ComSmartRefreshFooter.AnonymousClass1.<clinit>():void");
        }
    }

    public ComSmartRefreshFooter(Context context) {
        super(context);
        initView(context, (AttributeSet) null, 0);
    }

    private void initView(Context context, AttributeSet attributeSet, int i11) {
        new DensityUtil();
        refreshFooterPullup = context.getString(R.string.pull_footer_load_more);
        refreshFooterRelease = context.getString(R.string.pull_footer_release_load_more);
        refreshFooterLoading = context.getString(R.string.pull_footer_load_moreing);
        refreshFooterRefreshing = context.getString(R.string.pull_footer_load_more_refresh);
        refreshFooterFinish = context.getString(R.string.pull_footer_load_more_released);
        refreshFooterFailed = context.getString(R.string.pull_footer_load_more_failed);
        refreshFooterAllloaded = context.getString(R.string.no_more);
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_smart_refresh_footer, this);
        TextView textView = (TextView) inflate.findViewById(R.id.classic_footer_title);
        this.mTitleText = textView;
        textView.setText(refreshFooterPullup);
        this.mProgressView = (LottieAnimationView) inflate.findViewById(R.id.classic_footer_progressbar);
        this.footerDivider = inflate.findViewById(R.id.classic_footer_divider);
        if (!isInEditMode()) {
            this.mProgressView.setVisibility(8);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClassicsFooter);
        this.mFinishDuration = obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlFinishDuration, this.mFinishDuration);
        this.mSpinnerStyle = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.ClassicsFooter_srlClassicsSpinnerStyle, this.mSpinnerStyle.ordinal())];
        int i12 = R.styleable.ClassicsFooter_srlPrimaryColor;
        if (obtainStyledAttributes.hasValue(i12)) {
            setPrimaryColor(obtainStyledAttributes.getColor(i12, 0));
        }
        int i13 = R.styleable.ClassicsFooter_srlAccentColor;
        if (obtainStyledAttributes.hasValue(i13)) {
            setAccentColor(obtainStyledAttributes.getColor(i13, 0));
        }
        obtainStyledAttributes.recycle();
    }

    public ImageView getProgressView() {
        return this.mProgressView;
    }

    public SpinnerStyle getSpinnerStyle() {
        return this.mSpinnerStyle;
    }

    public TextView getTitleText() {
        return this.mTitleText;
    }

    public View getView() {
        return this;
    }

    public boolean isSupportHorizontalDrag() {
        return false;
    }

    public int onFinish(j jVar, boolean z11) {
        if (this.mNoMoreData) {
            return this.mFinishDuration;
        }
        this.mProgressView.cancelAnimation();
        this.mProgressView.setVisibility(8);
        if (z11) {
            this.mTitleText.setText(refreshFooterFinish);
        } else {
            this.mTitleText.setText(refreshFooterFailed);
        }
        return this.mFinishDuration;
    }

    public void onHorizontalDrag(float f11, int i11, int i12) {
    }

    public void onInitialized(i iVar, int i11, int i12) {
        this.mRefreshKernel = iVar;
        iVar.d(this.mBackgroundColor);
    }

    public void onPulling(float f11, int i11, int i12, int i13) {
    }

    public void onReleased(j jVar, int i11, int i12) {
    }

    public void onReleasing(float f11, int i11, int i12, int i13) {
    }

    public void onStartAnimator(j jVar, int i11, int i12) {
        if (!this.mNoMoreData) {
            this.mProgressView.setVisibility(0);
            ProgressDrawable progressDrawable = this.mProgressDrawable;
            if (progressDrawable != null) {
                progressDrawable.start();
            } else {
                this.mProgressView.playAnimation();
            }
        }
    }

    public void onStateChanged(j jVar, RefreshState refreshState, RefreshState refreshState2) {
        if (!this.mNoMoreData) {
            switch (AnonymousClass1.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState2.ordinal()]) {
                case 1:
                case 2:
                    this.mTitleText.setText(refreshFooterPullup);
                    return;
                case 3:
                case 4:
                    this.mTitleText.setText(refreshFooterLoading);
                    return;
                case 5:
                    this.mTitleText.setText(refreshFooterRelease);
                    return;
                case 6:
                    this.mTitleText.setText(refreshFooterRefreshing);
                    this.mProgressView.setVisibility(8);
                    return;
                default:
                    return;
            }
        } else if (AnonymousClass1.$SwitchMap$com$scwang$smartrefresh$layout$constant$RefreshState[refreshState2.ordinal()] == 2) {
            this.mTitleText.setText(refreshFooterAllloaded);
        }
    }

    public ComSmartRefreshFooter setAccentColor(int i11) {
        this.mAccentColor = Integer.valueOf(i11);
        this.mTitleText.setTextColor(i11);
        ProgressDrawable progressDrawable = this.mProgressDrawable;
        if (progressDrawable != null) {
            progressDrawable.c(i11);
        }
        PathsDrawable pathsDrawable = this.mArrowDrawable;
        if (pathsDrawable != null) {
            pathsDrawable.h(i11);
        }
        return this;
    }

    public ComSmartRefreshFooter setAccentColorId(int i11) {
        setAccentColor(ContextCompat.getColor(getContext(), i11));
        return this;
    }

    public ComSmartRefreshFooter setDrawableProgressSize(float f11) {
        return setDrawableProgressSizePx(DensityUtil.b(f11));
    }

    public ComSmartRefreshFooter setDrawableProgressSizePx(int i11) {
        ViewGroup.LayoutParams layoutParams = this.mProgressView.getLayoutParams();
        layoutParams.width = i11;
        layoutParams.height = i11;
        this.mProgressView.setLayoutParams(layoutParams);
        return this;
    }

    public ComSmartRefreshFooter setFinishDuration(int i11) {
        this.mFinishDuration = i11;
        return this;
    }

    public void setFooterDividerColor(int i11) {
        this.footerDivider.setBackgroundColor(i11);
    }

    public void setFooterDividerVisible(boolean z11) {
        if (!z11) {
            this.footerDivider.setVisibility(8);
        } else {
            this.footerDivider.setVisibility(0);
        }
    }

    public boolean setNoMoreData(boolean z11) {
        if (this.mNoMoreData == z11) {
            return true;
        }
        this.mNoMoreData = z11;
        if (z11) {
            this.mTitleText.setText(refreshFooterAllloaded);
        } else {
            this.mTitleText.setText(refreshFooterPullup);
        }
        this.mProgressView.setVisibility(8);
        return true;
    }

    public ComSmartRefreshFooter setPrimaryColor(int i11) {
        Integer valueOf = Integer.valueOf(i11);
        this.mPrimaryColor = valueOf;
        this.mBackgroundColor = i11;
        i iVar = this.mRefreshKernel;
        if (iVar != null) {
            iVar.d(valueOf.intValue());
        }
        return this;
    }

    public ComSmartRefreshFooter setPrimaryColorId(int i11) {
        setPrimaryColor(ContextCompat.getColor(getContext(), i11));
        return this;
    }

    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (this.mSpinnerStyle == SpinnerStyle.FixedBehind && iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable)) {
                setPrimaryColor(iArr[0]);
            }
            if (iArr.length > 1) {
                setAccentColor(iArr[1]);
                return;
            }
            int i11 = -1;
            if (iArr[0] == -1) {
                i11 = -10066330;
            }
            setAccentColor(i11);
        }
    }

    public ComSmartRefreshFooter setSpinnerStyle(SpinnerStyle spinnerStyle) {
        this.mSpinnerStyle = spinnerStyle;
        return this;
    }

    public ComSmartRefreshFooter setTextSizeTitle(float f11) {
        this.mTitleText.setTextSize(f11);
        i iVar = this.mRefreshKernel;
        if (iVar != null) {
            iVar.o();
        }
        return this;
    }

    public ComSmartRefreshFooter setTextSizeTitle(int i11, float f11) {
        this.mTitleText.setTextSize(i11, f11);
        i iVar = this.mRefreshKernel;
        if (iVar != null) {
            iVar.o();
        }
        return this;
    }

    public ComSmartRefreshFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context, attributeSet, 0);
    }

    public ComSmartRefreshFooter(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context, attributeSet, i11);
    }
}
