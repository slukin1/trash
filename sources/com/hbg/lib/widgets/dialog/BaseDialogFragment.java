package com.hbg.lib.widgets.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$dimen;
import com.hbg.lib.widgets.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import i6.k;
import i6.r;
import java.lang.reflect.Field;

public abstract class BaseDialogFragment extends DialogFragment implements DialogInterface.OnKeyListener {
    private boolean canDismissOnBackPress = true;
    private boolean isDismissed;
    private View.OnClickListener mBgClickListener = new z9.a(this);
    private boolean mCanceledOnTouchOutside = true;
    private View mContentView = null;
    private int mContentViewHeight;
    private int mContentViewWidth;
    private View mCoverView = null;
    private b mDismissListener;
    private c mListener;
    public r viewFinder;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationEnd(Animator animator) {
            BaseDialogFragment.this.doDismiss();
        }
    }

    public interface b {
        void onDismiss();
    }

    public interface c {
        void onDialogFragmentBackPressed();

        void onDialogFragmentPause();

        void onDialogFragmentResume();
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        return dimensionPixelSize <= 0 ? PixelUtils.a(25.0f) : dimensionPixelSize;
    }

    private View initAllViews(LayoutInflater layoutInflater) {
        if (!useWindowBg()) {
            FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
            frameLayout.setOnClickListener(this.mBgClickListener);
            View coverView = getCoverView();
            this.mCoverView = coverView;
            frameLayout.addView(coverView);
            this.mCoverView.setOnClickListener(this.mBgClickListener);
            setCoverViewBgColor(getResources().getColor(R$color.global_dialog_bg_alpha_color));
            if (getContentViewResId() > 0) {
                this.mContentView = layoutInflater.inflate(getContentViewResId(), (ViewGroup) null);
            } else {
                this.mContentView = getContentView();
            }
            ViewGroup.LayoutParams layoutParams = this.mContentView.getLayoutParams();
            if (layoutParams == null) {
                if (contentViewIsFullScreen()) {
                    layoutParams = new FrameLayout.LayoutParams(-1, -1);
                } else if (contentViewIsFullWidth()) {
                    layoutParams = new FrameLayout.LayoutParams(-1, -2);
                } else {
                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                }
            }
            if (layoutParams instanceof FrameLayout.LayoutParams) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = getGravity();
            }
            this.mContentView.setLayoutParams(layoutParams);
            frameLayout.addView(this.mContentView);
            return frameLayout;
        } else if (getContentViewResId() > 0) {
            return layoutInflater.inflate(getContentViewResId(), (ViewGroup) null);
        } else {
            return getContentView();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$checkStatusHeight$0(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        if (iArr[1] == 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            marginLayoutParams.topMargin += getStatusBarHeight(getActivity());
            view.setLayoutParams(marginLayoutParams);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$doDefaultShowAnimation$2(View view, int i11, View view2) {
        this.mContentViewWidth = view2.getWidth();
        this.mContentViewHeight = view2.getHeight();
        doRealDefaultShowAnimation(view, i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$new$1(View view) {
        if (this.mCanceledOnTouchOutside) {
            dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public abstract void addEvent(r rVar);

    public abstract void afterInit();

    public void checkStatusHeight(View view) {
        ViewUtil.b(view, new z9.b(this));
    }

    public void configCoverViewLayoutParams(View view, FrameLayout.LayoutParams layoutParams) {
    }

    public boolean contentViewIsFullScreen() {
        return false;
    }

    public boolean contentViewIsFullWidth() {
        return false;
    }

    public void customizeWindowDimAmount() {
        TypedValue typedValue = new TypedValue();
        getResources().getValue(R$dimen.dialog_window_dimamount, typedValue, true);
        setWindowDimAmount(typedValue.getFloat());
    }

    public void dismiss() {
        if (!this.isDismissed) {
            this.isDismissed = true;
            doContentViewHideAnimation(this.mContentView);
            doCoverViewHideAnimation(this.mCoverView);
        }
    }

    public void doContentViewHideAnimation(View view) {
        if (isRunDefaultAnimation()) {
            doDefaultHideAnimation(view, getGravity());
        } else {
            doDismiss();
        }
    }

    public void doContentViewShowAnimation(View view) {
        if (isRunDefaultAnimation()) {
            doDefaultShowAnimation(view, getGravity());
        }
    }

    public void doCoverViewHideAnimation(View view) {
        if (view != null) {
            ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f, 0.0f}).setDuration(getDuration()).start();
        }
    }

    public void doCoverViewShowAnimation(View view) {
        if (view != null) {
            ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.0f, 1.0f}).setDuration(getDuration()).start();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v7, resolved type: android.animation.AnimatorSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: android.animation.AnimatorSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: android.animation.AnimatorSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v11, resolved type: android.animation.AnimatorSet} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v13, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v14, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v15, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: android.animation.ObjectAnimator} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v19, resolved type: android.animation.ObjectAnimator} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doDefaultHideAnimation(android.view.View r11, int r12) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x0173
            r0 = r12 & 3
            r1 = 3
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x000b
            r0 = r2
            goto L_0x000c
        L_0x000b:
            r0 = r3
        L_0x000c:
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r4 = r12 & r1
            if (r4 != r1) goto L_0x0015
            r1 = r2
            goto L_0x0016
        L_0x0015:
            r1 = r3
        L_0x0016:
            r4 = r12 & 48
            r5 = 48
            if (r4 != r5) goto L_0x001e
            r4 = r2
            goto L_0x001f
        L_0x001e:
            r4 = r3
        L_0x001f:
            r5 = r12 & 5
            r6 = 5
            if (r5 != r6) goto L_0x0026
            r5 = r2
            goto L_0x0027
        L_0x0026:
            r5 = r3
        L_0x0027:
            r6 = 8388613(0x800005, float:1.175495E-38)
            r7 = r12 & r6
            if (r7 != r6) goto L_0x0030
            r6 = r2
            goto L_0x0031
        L_0x0030:
            r6 = r3
        L_0x0031:
            r7 = 80
            r12 = r12 & r7
            if (r12 != r7) goto L_0x0038
            r12 = r2
            goto L_0x0039
        L_0x0038:
            r12 = r3
        L_0x0039:
            r7 = 0
            r8 = 0
            r9 = 2
            if (r4 == 0) goto L_0x006e
            if (r0 != 0) goto L_0x0042
            if (r1 == 0) goto L_0x006e
        L_0x0042:
            r11.setPivotX(r8)
            r11.setPivotY(r8)
            android.animation.AnimatorSet r7 = new android.animation.AnimatorSet
            r7.<init>()
            android.animation.Animator[] r12 = new android.animation.Animator[r9]
            android.util.Property r0 = android.view.View.SCALE_X
            float[] r1 = new float[r9]
            r1 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r11, r0, r1)
            r12[r3] = r0
            android.util.Property r0 = android.view.View.SCALE_Y
            float[] r1 = new float[r9]
            r1 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r11 = android.animation.ObjectAnimator.ofFloat(r11, r0, r1)
            r12[r2] = r11
            r7.playTogether(r12)
            goto L_0x015e
        L_0x006e:
            if (r4 == 0) goto L_0x00a3
            if (r5 != 0) goto L_0x0074
            if (r6 == 0) goto L_0x00a3
        L_0x0074:
            int r12 = r10.mContentViewWidth
            float r12 = (float) r12
            r11.setPivotX(r12)
            r11.setPivotY(r8)
            android.animation.AnimatorSet r7 = new android.animation.AnimatorSet
            r7.<init>()
            android.animation.Animator[] r12 = new android.animation.Animator[r9]
            android.util.Property r0 = android.view.View.SCALE_X
            float[] r1 = new float[r9]
            r1 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r11, r0, r1)
            r12[r3] = r0
            android.util.Property r0 = android.view.View.SCALE_Y
            float[] r1 = new float[r9]
            r1 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r11 = android.animation.ObjectAnimator.ofFloat(r11, r0, r1)
            r12[r2] = r11
            r7.playTogether(r12)
            goto L_0x015e
        L_0x00a3:
            if (r4 == 0) goto L_0x00b7
            android.util.Property r12 = android.view.View.TRANSLATION_Y
            float[] r0 = new float[r9]
            r0[r3] = r8
            int r1 = r10.mContentViewHeight
            int r1 = -r1
            float r1 = (float) r1
            r0[r2] = r1
            android.animation.ObjectAnimator r7 = android.animation.ObjectAnimator.ofFloat(r11, r12, r0)
            goto L_0x015e
        L_0x00b7:
            if (r12 == 0) goto L_0x00ec
            if (r0 != 0) goto L_0x00bd
            if (r1 == 0) goto L_0x00ec
        L_0x00bd:
            r11.setPivotX(r8)
            int r12 = r10.mContentViewHeight
            float r12 = (float) r12
            r11.setPivotY(r12)
            android.animation.AnimatorSet r7 = new android.animation.AnimatorSet
            r7.<init>()
            android.animation.Animator[] r12 = new android.animation.Animator[r9]
            android.util.Property r0 = android.view.View.SCALE_X
            float[] r1 = new float[r9]
            r1 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r11, r0, r1)
            r12[r3] = r0
            android.util.Property r0 = android.view.View.SCALE_Y
            float[] r1 = new float[r9]
            r1 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r11 = android.animation.ObjectAnimator.ofFloat(r11, r0, r1)
            r12[r2] = r11
            r7.playTogether(r12)
            goto L_0x015e
        L_0x00ec:
            if (r12 == 0) goto L_0x0123
            if (r5 != 0) goto L_0x00f2
            if (r6 == 0) goto L_0x0123
        L_0x00f2:
            int r12 = r10.mContentViewWidth
            float r12 = (float) r12
            r11.setPivotX(r12)
            int r12 = r10.mContentViewHeight
            float r12 = (float) r12
            r11.setPivotY(r12)
            android.animation.AnimatorSet r7 = new android.animation.AnimatorSet
            r7.<init>()
            android.animation.Animator[] r12 = new android.animation.Animator[r9]
            android.util.Property r0 = android.view.View.SCALE_X
            float[] r1 = new float[r9]
            r1 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r0 = android.animation.ObjectAnimator.ofFloat(r11, r0, r1)
            r12[r3] = r0
            android.util.Property r0 = android.view.View.SCALE_Y
            float[] r1 = new float[r9]
            r1 = {1065353216, 0} // fill-array
            android.animation.ObjectAnimator r11 = android.animation.ObjectAnimator.ofFloat(r11, r0, r1)
            r12[r2] = r11
            r7.playTogether(r12)
            goto L_0x015e
        L_0x0123:
            if (r12 == 0) goto L_0x0135
            android.util.Property r12 = android.view.View.TRANSLATION_Y
            float[] r0 = new float[r9]
            r0[r3] = r8
            int r1 = r10.mContentViewHeight
            float r1 = (float) r1
            r0[r2] = r1
            android.animation.ObjectAnimator r7 = android.animation.ObjectAnimator.ofFloat(r11, r12, r0)
            goto L_0x015e
        L_0x0135:
            if (r0 != 0) goto L_0x014e
            if (r1 == 0) goto L_0x013a
            goto L_0x014e
        L_0x013a:
            if (r5 != 0) goto L_0x013e
            if (r6 == 0) goto L_0x015e
        L_0x013e:
            android.util.Property r12 = android.view.View.TRANSLATION_X
            float[] r0 = new float[r9]
            r0[r3] = r8
            int r1 = r10.mContentViewWidth
            float r1 = (float) r1
            r0[r2] = r1
            android.animation.ObjectAnimator r7 = android.animation.ObjectAnimator.ofFloat(r11, r12, r0)
            goto L_0x015e
        L_0x014e:
            android.util.Property r12 = android.view.View.TRANSLATION_X
            float[] r0 = new float[r9]
            r0[r3] = r8
            int r1 = r10.mContentViewWidth
            int r1 = -r1
            float r1 = (float) r1
            r0[r2] = r1
            android.animation.ObjectAnimator r7 = android.animation.ObjectAnimator.ofFloat(r11, r12, r0)
        L_0x015e:
            if (r7 == 0) goto L_0x0173
            long r11 = r10.getDuration()
            r7.setDuration(r11)
            com.hbg.lib.widgets.dialog.BaseDialogFragment$a r11 = new com.hbg.lib.widgets.dialog.BaseDialogFragment$a
            r11.<init>()
            r7.addListener(r11)
            r7.start()
            return
        L_0x0173:
            r10.doDismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hbg.lib.widgets.dialog.BaseDialogFragment.doDefaultHideAnimation(android.view.View, int):void");
    }

    public void doDefaultShowAnimation(View view, int i11) {
        if (view == null) {
            return;
        }
        if (this.mContentViewWidth == 0 || this.mContentViewHeight == 0) {
            ViewUtil.b(view, new z9.c(this, view, i11));
        } else {
            doRealDefaultShowAnimation(view, i11);
        }
    }

    public void doDismiss() {
        try {
            super.dismissAllowingStateLoss();
        } catch (Exception unused) {
        }
        this.isDismissed = false;
    }

    public void doRealDefaultShowAnimation(View view, int i11) {
        boolean z11 = (i11 & 3) == 3;
        boolean z12 = (i11 & 8388611) == 8388611;
        boolean z13 = (i11 & 48) == 48;
        boolean z14 = (i11 & 5) == 5;
        boolean z15 = (i11 & 8388613) == 8388613;
        boolean z16 = (i11 & 80) == 80;
        if (z13 && (z11 || z12)) {
            view.setPivotX(0.0f);
            view.setPivotY(0.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{0.0f, 1.0f})});
            animatorSet.setDuration(getDuration());
            animatorSet.start();
        } else if (z13 && (z14 || z15)) {
            view.setPivotX((float) this.mContentViewWidth);
            view.setPivotY(0.0f);
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{0.0f, 1.0f})});
            animatorSet2.setDuration(getDuration());
            animatorSet2.start();
        } else if (z13) {
            ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{(float) (-this.mContentViewHeight), 0.0f}).setDuration(getDuration()).start();
        } else if (z16 && (z11 || z12)) {
            view.setPivotX(0.0f);
            view.setPivotY((float) this.mContentViewHeight);
            AnimatorSet animatorSet3 = new AnimatorSet();
            animatorSet3.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{0.0f, 1.0f})});
            animatorSet3.setDuration(getDuration());
            animatorSet3.start();
        } else if (z16 && (z14 || z15)) {
            view.setPivotX((float) this.mContentViewWidth);
            view.setPivotY((float) this.mContentViewHeight);
            AnimatorSet animatorSet4 = new AnimatorSet();
            animatorSet4.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.SCALE_X, new float[]{0.0f, 1.0f}), ObjectAnimator.ofFloat(view, View.SCALE_Y, new float[]{0.0f, 1.0f})});
            animatorSet4.setDuration(getDuration());
            animatorSet4.start();
        } else if (z16) {
            ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{(float) this.mContentViewHeight, 0.0f}).setDuration(getDuration()).start();
        } else if (z11 || z12) {
            ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{(float) (-this.mContentViewWidth), 0.0f}).setDuration(getDuration()).start();
        } else if (z14 || z15) {
            ObjectAnimator.ofFloat(view, View.TRANSLATION_X, new float[]{(float) this.mContentViewWidth, 0.0f}).setDuration(getDuration()).start();
        }
    }

    public boolean followScreenSize() {
        return false;
    }

    public int getAnimationStyle() {
        return -1;
    }

    public View getContentView() {
        return null;
    }

    public abstract int getContentViewResId();

    public View getCoverView() {
        this.mCoverView = new View(getActivity());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        configCoverViewLayoutParams(this.mCoverView, layoutParams);
        this.mCoverView.setLayoutParams(layoutParams);
        return this.mCoverView;
    }

    public Drawable getDrawableById(int i11) {
        Drawable drawable = getResources().getDrawable(i11);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        return drawable;
    }

    public long getDuration() {
        return 300;
    }

    public abstract int getGravity();

    public int getStandardWindowWidth() {
        return (PixelUtils.g() * 6) / 7;
    }

    public abstract void initView(r rVar);

    public void initWindow(Window window) {
        if (window != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            window.setLayout(displayMetrics.widthPixels, window.getAttributes().height);
            window.setBackgroundDrawable(new ColorDrawable(0));
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.gravity = getGravity();
            attributes.width = -1;
            window.setAttributes(attributes);
            window.setWindowAnimations(getAnimationStyle());
        }
    }

    public boolean isFullScreen() {
        return true;
    }

    public boolean isRunDefaultAnimation() {
        return true;
    }

    public abstract boolean isTransparent();

    public void onActivityCreated(Bundle bundle) {
        int i11;
        if (Build.VERSION.SDK_INT > 21) {
            try {
                if (isFullScreen() && getDialog().getWindow() != null) {
                    getDialog().getWindow().requestFeature(1);
                }
            } catch (Exception e11) {
                k.j("BaseDialogFragment", e11);
            }
        }
        super.onActivityCreated(bundle);
        if (isFullScreen()) {
            int i12 = -1;
            if (followScreenSize()) {
                DisplayMetrics displayMetrics = getDialog().getContext().getResources().getDisplayMetrics();
                i12 = displayMetrics.widthPixels;
                i11 = displayMetrics.heightPixels;
            } else {
                i11 = -1;
            }
            getDialog().getWindow().setLayout(i12, i11);
        }
    }

    public void onBackPressed() {
        if (this.canDismissOnBackPress) {
            dismiss();
        }
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.onDialogFragmentBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isTransparent()) {
            setStyle(1, R$style.BaseDialogFragmentStyle);
        }
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        initWindow(getDialog().getWindow());
        View initAllViews = initAllViews(layoutInflater);
        this.viewFinder = new r(initAllViews);
        checkStatusHeight(initAllViews);
        initView(this.viewFinder);
        getDialog().setOnKeyListener(this);
        setCanceledOnTouchOutside(this.mCanceledOnTouchOutside);
        addEvent(this.viewFinder);
        afterInit();
        doContentViewShowAnimation(this.mContentView);
        doCoverViewShowAnimation(this.mCoverView);
        this.isDismissed = false;
        return initAllViews;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        b bVar = this.mDismissListener;
        if (bVar != null) {
            bVar.onDismiss();
        }
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    public boolean onKey(DialogInterface dialogInterface, int i11, KeyEvent keyEvent) {
        if (i11 != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        onBackPressed();
        return true;
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.onDialogFragmentPause();
        }
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        c cVar = this.mListener;
        if (cVar != null) {
            cVar.onDialogFragmentResume();
        }
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setCanDismissOnBackPress(boolean z11) {
        this.canDismissOnBackPress = z11;
    }

    public void setCanceledOnTouchOutside(boolean z11) {
        this.mCanceledOnTouchOutside = z11;
        if (useWindowBg() && getDialog() != null) {
            getDialog().setCanceledOnTouchOutside(this.mCanceledOnTouchOutside);
        }
    }

    public void setCoverViewBgColor(int i11) {
        View view = this.mCoverView;
        if (view != null) {
            view.setBackgroundColor(i11);
        }
    }

    public void setDialogDismissListener(b bVar) {
        this.mDismissListener = bVar;
    }

    public void setDialogFragmentListener(c cVar) {
        this.mListener = cVar;
    }

    public void setStandardWidth(View view) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null) {
            layoutParams.width = getStandardWindowWidth();
            view.setLayoutParams(layoutParams);
        }
    }

    public void setStatusBarColorIfPossible(int i11) {
        if (Build.VERSION.SDK_INT >= 21) {
            getDialog().getWindow().addFlags(Integer.MIN_VALUE);
            getDialog().getWindow().setStatusBarColor(i11);
            Window window = getDialog().getWindow();
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        }
        getDialog().getWindow().getDecorView().setSystemUiVisibility(0);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void setViewVisible(View view, boolean z11) {
        if (view != null) {
            view.setVisibility(z11 ? 0 : 8);
        }
    }

    public void setWindowDimAmount(float f11) {
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setDimAmount(f11);
            window.addFlags(2);
        }
    }

    public void show(FragmentManager fragmentManager, String str) {
        try {
            fragmentManager.q().s(this).k();
            Field declaredField = DialogFragment.class.getDeclaredField("mDismissed");
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.FALSE);
            Field declaredField2 = DialogFragment.class.getDeclaredField("mShownByMe");
            declaredField2.setAccessible(true);
            declaredField2.set(this, Boolean.TRUE);
            FragmentTransaction q11 = fragmentManager.q();
            q11.e(this, str);
            q11.k();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void updateContentViewSize() {
        this.mContentViewWidth = this.mContentView.getWidth();
        this.mContentViewHeight = this.mContentView.getHeight();
    }

    public boolean useWindowBg() {
        return true;
    }
}
