package com.huobi.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.huobi.utils.j0;
import i6.n;
import java.io.InputStream;
import java.util.LinkedList;
import pro.huobi.R;

public class HomeRankSkeletonView extends LinearLayout {
    public LinkedList<LottieAnimationView> lottieAnimationViews;

    public HomeRankSkeletonView(Context context) {
        super(context);
        initView(context);
    }

    private void addLottieAnimationView(Context context, int i11, float f11, float f12) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        InputStream openRawResource = context.getResources().openRawResource(i11);
        lottieAnimationView.setAnimation(openRawResource, "rawRes_" + (getResources().getConfiguration().uiMode & 32) + "_" + i11);
        lottieAnimationView.setRepeatCount(-1);
        int g11 = n.g(context) - context.getResources().getDimensionPixelSize(R.dimen.dimen_20);
        addView(lottieAnimationView, new LinearLayout.LayoutParams(g11, (int) (((f12 * ((float) g11)) / f11) + 0.5f)));
        this.lottieAnimationViews.add(lottieAnimationView);
    }

    /* access modifiers changed from: private */
    public void initSkeleton() {
        Context context = getContext();
        this.lottieAnimationViews = new LinkedList<>();
        addLottieAnimationView(context, j0.f(), 710.0f, 90.0f);
        addLottieAnimationView(context, j0.g(), 710.0f, 70.0f);
        for (int i11 = 0; i11 < 4; i11++) {
            addLottieAnimationView(context, j0.h(), 710.0f, 100.0f);
        }
    }

    private void initView(Context context) {
        setOrientation(1);
        initSkeleton();
    }

    public void cancelAnim() {
        if (this.lottieAnimationViews != null) {
            for (int i11 = 0; i11 < this.lottieAnimationViews.size(); i11++) {
                this.lottieAnimationViews.get(i11).cancelAnimation();
            }
        }
    }

    public void dismissSkeleton() {
        cancelAnim();
        setVisibility(8);
    }

    public void showSkeleton() {
        LinkedList<LottieAnimationView> linkedList = this.lottieAnimationViews;
        if (linkedList == null || linkedList.size() == 0) {
            post(new r0(this));
            return;
        }
        for (int i11 = 0; i11 < this.lottieAnimationViews.size(); i11++) {
            this.lottieAnimationViews.get(i11).playAnimation();
        }
    }

    public boolean showing() {
        return getVisibility() == 0;
    }

    public HomeRankSkeletonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public HomeRankSkeletonView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context);
    }

    public HomeRankSkeletonView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        initView(context);
    }
}
