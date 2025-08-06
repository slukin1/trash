package com.luck.picture.lib.magical;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.ChangeTransform;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import com.luck.picture.lib.basic.InterpolatorFactory;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.utils.DensityUtil;

public class MagicalView extends FrameLayout {
    private final long animationDuration;
    private final int appInScreenHeight;
    /* access modifiers changed from: private */
    public final View backgroundView;
    /* access modifiers changed from: private */
    public final FrameLayout contentLayout;
    /* access modifiers changed from: private */
    public boolean isAnimating;
    private final boolean isPreviewFullScreenMode;
    /* access modifiers changed from: private */
    public float mAlpha;
    /* access modifiers changed from: private */
    public int mOriginHeight;
    /* access modifiers changed from: private */
    public int mOriginLeft;
    /* access modifiers changed from: private */
    public int mOriginTop;
    /* access modifiers changed from: private */
    public int mOriginWidth;
    /* access modifiers changed from: private */
    public final MagicalViewWrapper magicalWrapper;
    /* access modifiers changed from: private */
    public OnMagicalViewCallback onMagicalViewCallback;
    private int realHeight;
    private int realWidth;
    private int screenHeight;
    private int screenWidth;
    private final SelectorConfig selectorConfig;
    private int startX;
    private int startY;
    /* access modifiers changed from: private */
    public int targetEndLeft;
    /* access modifiers changed from: private */
    public int targetImageHeight;
    /* access modifiers changed from: private */
    public int targetImageTop;
    /* access modifiers changed from: private */
    public int targetImageWidth;

    public MagicalView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void backToMinWithTransition() {
        this.contentLayout.post(new Runnable() {
            public void run() {
                TransitionManager.beginDelayedTransition((ViewGroup) MagicalView.this.contentLayout.getParent(), new TransitionSet().setDuration(250).addTransition(new ChangeBounds()).addTransition(new ChangeTransform()).addTransition(new ChangeImageTransform()));
                MagicalView.this.beginBackToMin(true);
                MagicalView.this.contentLayout.setTranslationX(0.0f);
                MagicalView.this.contentLayout.setTranslationY(0.0f);
                MagicalView.this.magicalWrapper.setWidth((float) MagicalView.this.mOriginWidth);
                MagicalView.this.magicalWrapper.setHeight((float) MagicalView.this.mOriginHeight);
                MagicalView.this.magicalWrapper.setMarginTop(MagicalView.this.mOriginTop);
                MagicalView.this.magicalWrapper.setMarginLeft(MagicalView.this.mOriginLeft);
                MagicalView.this.changeBackgroundViewAlpha(true);
            }
        });
    }

    private void backToMinWithoutView() {
        this.contentLayout.animate().alpha(0.0f).setDuration(250).setListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                if (MagicalView.this.onMagicalViewCallback != null) {
                    MagicalView.this.onMagicalViewCallback.onMagicalViewFinish();
                }
            }
        }).start();
        this.backgroundView.animate().alpha(0.0f).setDuration(250).start();
    }

    /* access modifiers changed from: private */
    public void beginBackToMin(boolean z11) {
        if (z11) {
            this.onMagicalViewCallback.onBeginBackMinMagicalFinish(true);
        }
    }

    private void beginShow(boolean z11) {
        Interpolator newInterpolator;
        if (z11) {
            this.mAlpha = 1.0f;
            this.backgroundView.setAlpha(1.0f);
            showNormalMin((float) this.targetImageTop, (float) this.targetEndLeft, (float) this.targetImageWidth, (float) this.targetImageHeight);
            setShowEndParams();
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MagicalView magicalView = MagicalView.this;
                magicalView.showNormalMin(floatValue, (float) magicalView.mOriginTop, (float) MagicalView.this.targetImageTop, (float) MagicalView.this.mOriginLeft, (float) MagicalView.this.targetEndLeft, (float) MagicalView.this.mOriginWidth, (float) MagicalView.this.targetImageWidth, (float) MagicalView.this.mOriginHeight, (float) MagicalView.this.targetImageHeight);
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                MagicalView.this.setShowEndParams();
            }
        });
        InterpolatorFactory interpolatorFactory = this.selectorConfig.interpolatorFactory;
        if (!(interpolatorFactory == null || (newInterpolator = interpolatorFactory.newInterpolator()) == null)) {
            ofFloat.setInterpolator(newInterpolator);
        }
        ofFloat.setDuration(250).start();
        changeBackgroundViewAlpha(false);
    }

    /* access modifiers changed from: private */
    public void changeBackgroundViewAlpha(final boolean z11) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{this.mAlpha, z11 ? 0.0f : 1.0f});
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                boolean unused = MagicalView.this.isAnimating = true;
                float unused2 = MagicalView.this.mAlpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MagicalView.this.backgroundView.setAlpha(MagicalView.this.mAlpha);
                if (MagicalView.this.onMagicalViewCallback != null) {
                    MagicalView.this.onMagicalViewCallback.onBackgroundAlpha(MagicalView.this.mAlpha);
                }
            }
        });
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                boolean unused = MagicalView.this.isAnimating = false;
                if (z11 && MagicalView.this.onMagicalViewCallback != null) {
                    MagicalView.this.onMagicalViewCallback.onMagicalViewFinish();
                }
            }
        });
        ofFloat.setDuration(250);
        ofFloat.start();
    }

    private void changeContentViewToFullscreen() {
        int i11 = this.screenHeight;
        this.targetImageHeight = i11;
        this.targetImageWidth = this.screenWidth;
        this.targetImageTop = 0;
        this.magicalWrapper.setHeight((float) i11);
        this.magicalWrapper.setWidth((float) this.screenWidth);
        this.magicalWrapper.setMarginTop(0);
        this.magicalWrapper.setMarginLeft(0);
    }

    private void getScreenSize() {
        this.screenWidth = DensityUtil.getRealScreenWidth(getContext());
        if (this.isPreviewFullScreenMode) {
            this.screenHeight = DensityUtil.getRealScreenHeight(getContext());
        } else {
            this.screenHeight = DensityUtil.getScreenHeight(getContext());
        }
    }

    private void setOriginParams() {
        this.contentLayout.getLocationOnScreen(new int[2]);
        this.targetEndLeft = 0;
        int i11 = this.screenWidth;
        int i12 = this.screenHeight;
        float f11 = ((float) i11) / ((float) i12);
        int i13 = this.realWidth;
        int i14 = this.realHeight;
        if (f11 < ((float) i13) / ((float) i14)) {
            this.targetImageWidth = i11;
            int i15 = (int) (((float) i11) * (((float) i14) / ((float) i13)));
            this.targetImageHeight = i15;
            this.targetImageTop = (i12 - i15) / 2;
        } else {
            this.targetImageHeight = i12;
            int i16 = (int) (((float) i12) * (((float) i13) / ((float) i14)));
            this.targetImageWidth = i16;
            this.targetImageTop = 0;
            this.targetEndLeft = (i11 - i16) / 2;
        }
        this.magicalWrapper.setWidth((float) this.mOriginWidth);
        this.magicalWrapper.setHeight((float) this.mOriginHeight);
        this.magicalWrapper.setMarginLeft(this.mOriginLeft);
        this.magicalWrapper.setMarginTop(this.mOriginTop);
    }

    /* access modifiers changed from: private */
    public void setShowEndParams() {
        this.isAnimating = false;
        changeContentViewToFullscreen();
        OnMagicalViewCallback onMagicalViewCallback2 = this.onMagicalViewCallback;
        if (onMagicalViewCallback2 != null) {
            onMagicalViewCallback2.onBeginMagicalAnimComplete(this, false);
        }
    }

    /* access modifiers changed from: private */
    public void showNormalMin(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        showNormalMin(false, f11, f12, f13, f14, f15, f16, f17, f18, f19);
    }

    public void backToMin() {
        if (!this.isAnimating) {
            if (this.mOriginWidth == 0 || this.mOriginHeight == 0) {
                backToMinWithoutView();
                return;
            }
            OnMagicalViewCallback onMagicalViewCallback2 = this.onMagicalViewCallback;
            if (onMagicalViewCallback2 != null) {
                onMagicalViewCallback2.onBeginBackMinAnim();
            }
            beginBackToMin(false);
            backToMinWithTransition();
        }
    }

    public void changeRealScreenHeight(int i11, int i12, boolean z11) {
        int i13;
        int i14;
        if (!this.isPreviewFullScreenMode && (i13 = this.screenWidth) <= (i14 = this.screenHeight)) {
            if (((int) (((float) i13) / (((float) i11) / ((float) i12)))) > i14) {
                this.screenHeight = this.appInScreenHeight;
                if (z11) {
                    this.magicalWrapper.setWidth((float) i13);
                    this.magicalWrapper.setHeight((float) this.screenHeight);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r1 != 3) goto L_0x0066;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.widget.FrameLayout r0 = r5.contentLayout
            r1 = 0
            android.view.View r0 = r0.getChildAt(r1)
            boolean r1 = r0 instanceof androidx.viewpager2.widget.ViewPager2
            if (r1 == 0) goto L_0x000e
            androidx.viewpager2.widget.ViewPager2 r0 = (androidx.viewpager2.widget.ViewPager2) r0
            goto L_0x000f
        L_0x000e:
            r0 = 0
        L_0x000f:
            int r1 = r6.getAction()
            r2 = 1
            if (r1 == 0) goto L_0x0053
            if (r1 == r2) goto L_0x004d
            r3 = 2
            if (r1 == r3) goto L_0x001f
            r3 = 3
            if (r1 == r3) goto L_0x004d
            goto L_0x0066
        L_0x001f:
            float r1 = r6.getX()
            int r1 = (int) r1
            float r3 = r6.getY()
            int r3 = (int) r3
            int r4 = r5.startX
            int r1 = r1 - r4
            int r1 = java.lang.Math.abs(r1)
            int r4 = r5.startY
            int r4 = r3 - r4
            int r4 = java.lang.Math.abs(r4)
            if (r1 <= r4) goto L_0x0040
            if (r0 == 0) goto L_0x0066
            r0.setUserInputEnabled(r2)
            goto L_0x0066
        L_0x0040:
            if (r0 == 0) goto L_0x0066
            int r1 = r5.startY
            int r1 = r1 - r3
            boolean r1 = r5.canScrollVertically(r1)
            r0.setUserInputEnabled(r1)
            goto L_0x0066
        L_0x004d:
            if (r0 == 0) goto L_0x0066
            r0.setUserInputEnabled(r2)
            goto L_0x0066
        L_0x0053:
            float r1 = r6.getX()
            int r1 = (int) r1
            r5.startX = r1
            float r1 = r6.getY()
            int r1 = (int) r1
            r5.startY = r1
            if (r0 == 0) goto L_0x0066
            r0.setUserInputEnabled(r2)
        L_0x0066:
            boolean r6 = super.dispatchTouchEvent(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luck.picture.lib.magical.MagicalView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void resetStart() {
        getScreenSize();
        start(true);
    }

    public void resetStartNormal(int i11, int i12, boolean z11) {
        getScreenSize();
        startNormal(i11, i12, z11);
    }

    public void setBackgroundAlpha(float f11) {
        this.mAlpha = f11;
        this.backgroundView.setAlpha(f11);
    }

    public void setBackgroundColor(int i11) {
        this.backgroundView.setBackgroundColor(i11);
    }

    public void setMagicalContent(View view) {
        this.contentLayout.addView(view);
    }

    public void setOnMojitoViewCallback(OnMagicalViewCallback onMagicalViewCallback2) {
        this.onMagicalViewCallback = onMagicalViewCallback2;
    }

    public void setViewParams(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.realWidth = i15;
        this.realHeight = i16;
        this.mOriginLeft = i11;
        this.mOriginTop = i12;
        this.mOriginWidth = i13;
        this.mOriginHeight = i14;
    }

    public void start(boolean z11) {
        float f11;
        if (z11) {
            f11 = 1.0f;
            this.mAlpha = 1.0f;
        } else {
            f11 = 0.0f;
        }
        this.mAlpha = f11;
        this.backgroundView.setAlpha(f11);
        setVisibility(0);
        setOriginParams();
        beginShow(z11);
    }

    public void startNormal(int i11, int i12, boolean z11) {
        this.realWidth = i11;
        this.realHeight = i12;
        this.mOriginLeft = 0;
        this.mOriginTop = 0;
        this.mOriginWidth = 0;
        this.mOriginHeight = 0;
        setVisibility(0);
        setOriginParams();
        showNormalMin((float) this.targetImageTop, (float) this.targetEndLeft, (float) this.targetImageWidth, (float) this.targetImageHeight);
        if (z11) {
            this.mAlpha = 1.0f;
            this.backgroundView.setAlpha(1.0f);
        } else {
            this.mAlpha = 0.0f;
            this.backgroundView.setAlpha(0.0f);
            this.contentLayout.setAlpha(0.0f);
            this.contentLayout.animate().alpha(1.0f).setDuration(250).start();
            this.backgroundView.animate().alpha(1.0f).setDuration(250).start();
        }
        setShowEndParams();
    }

    public MagicalView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void showNormalMin(float f11, float f12, float f13, float f14) {
        showNormalMin(true, 0.0f, 0.0f, f11, 0.0f, f12, 0.0f, f13, 0.0f, f14);
    }

    public MagicalView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.mAlpha = 0.0f;
        this.animationDuration = 250;
        this.isAnimating = false;
        SelectorConfig selectorConfig2 = SelectorProviders.getInstance().getSelectorConfig();
        this.selectorConfig = selectorConfig2;
        this.isPreviewFullScreenMode = selectorConfig2.isPreviewFullScreenMode;
        this.appInScreenHeight = DensityUtil.getRealScreenHeight(getContext());
        getScreenSize();
        View view = new View(context);
        this.backgroundView = view;
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setAlpha(this.mAlpha);
        addView(view);
        FrameLayout frameLayout = new FrameLayout(context);
        this.contentLayout = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        this.magicalWrapper = new MagicalViewWrapper(frameLayout);
    }

    private void showNormalMin(boolean z11, float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        if (z11) {
            this.magicalWrapper.setWidth(f17);
            this.magicalWrapper.setHeight(f19);
            this.magicalWrapper.setMarginLeft((int) f15);
            this.magicalWrapper.setMarginTop((int) f13);
            return;
        }
        float f21 = (f15 - f14) * f11;
        float f22 = (f17 - f16) * f11;
        float f23 = (f19 - f18) * f11;
        this.magicalWrapper.setWidth(f16 + f22);
        this.magicalWrapper.setHeight(f18 + f23);
        this.magicalWrapper.setMarginLeft((int) (f14 + f21));
        this.magicalWrapper.setMarginTop((int) (f12 + (f11 * (f13 - f12))));
    }
}
