package com.huochat.community.widget.skeleton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.huochat.community.CommunityManager;
import com.huochat.community.R;
import com.huochat.community.util.LottieViewTool;
import i6.n;
import java.io.InputStream;
import java.util.LinkedList;
import vv.a;

public final class CommunityListSkeletonView extends LinearLayout {
    private boolean hasLoadData;
    private LinkedList<LottieAnimationView> lottieAnimationViews;
    private Context mContext;
    private boolean showing;

    public CommunityListSkeletonView(Context context) {
        super(context);
        initView(context);
    }

    private final void addLottieAnimationView(Context context, int i11, float f11, float f12, boolean z11) {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(context);
        InputStream openRawResource = context.getResources().openRawResource(i11);
        int i12 = context.getResources().getConfiguration().uiMode & 32;
        String str = CommunityManager.Companion.getInstance().isNightModel() ? "night" : "light";
        lottieAnimationView.setAnimation(openRawResource, "rawRes_" + str + '_' + i12 + '_' + i11);
        lottieAnimationView.setRepeatCount(-1);
        int g11 = n.g(context);
        addView(lottieAnimationView, new LinearLayout.LayoutParams(g11, (int) (((f12 * ((float) g11)) / f11) + 0.5f)));
        if (z11) {
            View view = new View(context);
            view.setBackgroundColor(context.getResources().getColor(getDividingLineColor()));
            addView(view, new LinearLayout.LayoutParams(g11, (int) getResources().getDimension(R.dimen.dimen_0_5)));
        }
        this.lottieAnimationViews.add(lottieAnimationView);
    }

    private final int getDividingLineColor() {
        if (CommunityManager.Companion.getInstance().isNightModel()) {
            return R.color.color_223349;
        }
        return R.color.color_E7EBEE;
    }

    private final void initSkeleton() {
        Context context = getContext();
        if (context != null) {
            LinkedList<LottieAnimationView> linkedList = this.lottieAnimationViews;
            if (linkedList == null || linkedList.isEmpty()) {
                this.lottieAnimationViews = new LinkedList<>();
                LottieViewTool.Companion companion = LottieViewTool.Companion;
                Context context2 = context;
                addLottieAnimationView(context2, companion.loadAutoLoanA(), 750.0f, 370.0f, true);
                addLottieAnimationView(context2, companion.loadAutoLoanA(), 750.0f, 370.0f, true);
                addLottieAnimationView(context2, companion.loadAutoLoanA(), 750.0f, 370.0f, false);
            }
            int size = this.lottieAnimationViews.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.lottieAnimationViews.get(i11).playAnimation();
            }
        }
        setVisibility(0);
    }

    private final void initView(Context context) {
        this.mContext = context;
        setOrientation(1);
    }

    /* access modifiers changed from: private */
    public static final void showSkeleton$lambda$0(CommunityListSkeletonView communityListSkeletonView) {
        communityListSkeletonView.initSkeleton();
    }

    public final void cancelAnim() {
        LinkedList<LottieAnimationView> linkedList = this.lottieAnimationViews;
        if (linkedList != null) {
            int size = linkedList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.lottieAnimationViews.get(i11).cancelAnimation();
            }
        }
    }

    public final void dismissOne() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (i11 < 2) {
                getChildAt(i11).setVisibility(8);
            } else {
                getChildAt(i11).setVisibility(0);
            }
        }
    }

    public final void dismissOneTwo() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            if (i11 < 4) {
                getChildAt(i11).setVisibility(8);
            } else {
                getChildAt(i11).setVisibility(0);
            }
        }
    }

    public final void dismissSkeleton() {
        this.showing = false;
        LinkedList<LottieAnimationView> linkedList = this.lottieAnimationViews;
        if (linkedList != null) {
            int size = linkedList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.lottieAnimationViews.get(i11).cancelAnimation();
            }
        }
        setVisibility(8);
    }

    public final boolean getHasLoadData() {
        return this.hasLoadData;
    }

    public final void setHasLoadData(boolean z11) {
        this.hasLoadData = z11;
    }

    public final void showSkeleton() {
        boolean z11 = true;
        this.showing = true;
        if (!this.hasLoadData) {
            LinkedList<LottieAnimationView> linkedList = this.lottieAnimationViews;
            if (linkedList != null && !linkedList.isEmpty()) {
                z11 = false;
            }
            if (z11) {
                post(new a(this));
            } else {
                int size = this.lottieAnimationViews.size();
                for (int i11 = 0; i11 < size; i11++) {
                    LottieAnimationView lottieAnimationView = this.lottieAnimationViews.get(i11);
                    if (!lottieAnimationView.isAnimating()) {
                        lottieAnimationView.playAnimation();
                    }
                }
            }
        }
        setVisibility(0);
    }

    public final boolean showing() {
        return this.showing;
    }

    public CommunityListSkeletonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public CommunityListSkeletonView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context);
    }
}
