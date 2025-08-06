package com.huobi.view;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$color;
import com.hbg.module.market.R$dimen;
import java.io.InputStream;
import java.util.LinkedList;

public class MarketSkeletonView extends LinearLayout {
    private boolean hasLoadData;
    public LinkedList<LottieAnimationView> lottieAnimationViews;
    private boolean showing;

    public MarketSkeletonView(Context context) {
        super(context);
        initView(context);
    }

    private void addLottieAnimationView(Context context, int i11, float f11, float f12) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        InputStream openRawResource = context.getResources().openRawResource(i11);
        lottieAnimationView.setAnimation(openRawResource, "rawRes_" + (getResources().getConfiguration().uiMode & 32) + "_" + i11);
        lottieAnimationView.setRepeatCount(-1);
        int p11 = BaseModuleConfig.a().p(context);
        addView(lottieAnimationView, new LinearLayout.LayoutParams(p11, (int) (((f12 * ((float) p11)) / f11) + 0.5f)));
        View view = new View(context);
        view.setBackgroundResource(R$color.baseColorSecondarySeparator);
        addView(view, new LinearLayout.LayoutParams(p11, (int) getResources().getDimension(R$dimen.dimen_0_5)));
        this.lottieAnimationViews.add(lottieAnimationView);
    }

    /* access modifiers changed from: private */
    public void initSkeleton() {
        Context context = getContext();
        if (context != null) {
            ViewParent parent = getParent();
            if ((parent != null && this.lottieAnimationViews == null) || this.lottieAnimationViews.size() == 0) {
                this.lottieAnimationViews = new LinkedList<>();
                addLottieAnimationView(context, MarketModuleConfig.a().A(), 750.0f, 70.0f);
                addLottieAnimationView(context, MarketModuleConfig.a().F(), 750.0f, 88.0f);
                addLottieAnimationView(context, MarketModuleConfig.a().i0(), 750.0f, 60.0f);
                int measuredHeight = (int) (((float) ((ViewGroup) parent).getMeasuredHeight()) / ((((float) BaseModuleConfig.a().p(context)) * 110.0f) / 750.0f));
                int i11 = 0;
                while (context != null && i11 < measuredHeight) {
                    addLottieAnimationView(context, MarketModuleConfig.a().H(), 750.0f, 110.0f);
                    i11++;
                }
            }
            for (int i12 = 0; i12 < this.lottieAnimationViews.size(); i12++) {
                this.lottieAnimationViews.get(i12).playAnimation();
            }
        }
        setVisibility(0);
    }

    private void initView(Context context) {
        setOrientation(1);
    }

    public void cancelAnim() {
        if (this.lottieAnimationViews != null) {
            for (int i11 = 0; i11 < this.lottieAnimationViews.size(); i11++) {
                this.lottieAnimationViews.get(i11).cancelAnimation();
            }
        }
    }

    public void dismissOne() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (i11 < 2) {
                getChildAt(i11).setVisibility(8);
            } else {
                getChildAt(i11).setVisibility(0);
            }
        }
    }

    public void dismissOneTwo() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (i11 < 4) {
                getChildAt(i11).setVisibility(8);
            } else {
                getChildAt(i11).setVisibility(0);
            }
        }
    }

    public void dismissSkeleton() {
        this.showing = false;
        if (this.lottieAnimationViews != null) {
            for (int i11 = 0; i11 < this.lottieAnimationViews.size(); i11++) {
                this.lottieAnimationViews.get(i11).cancelAnimation();
            }
        }
        setVisibility(8);
    }

    public boolean getHasLoadData() {
        return this.hasLoadData;
    }

    public void setHasLoadData(boolean z11) {
        this.hasLoadData = z11;
    }

    public void showSkeleton() {
        this.showing = true;
        if (!this.hasLoadData) {
            LinkedList<LottieAnimationView> linkedList = this.lottieAnimationViews;
            if (linkedList != null && linkedList.size() != 0) {
                for (int i11 = 0; i11 < this.lottieAnimationViews.size(); i11++) {
                    LottieAnimationView lottieAnimationView = this.lottieAnimationViews.get(i11);
                    if (!lottieAnimationView.isAnimating()) {
                        lottieAnimationView.playAnimation();
                    }
                }
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                initSkeleton();
            } else {
                post(new t0(this));
            }
        }
        setVisibility(0);
    }

    public boolean showing() {
        return this.showing;
    }

    public MarketSkeletonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public MarketSkeletonView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context);
    }

    public MarketSkeletonView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        initView(context);
    }
}
