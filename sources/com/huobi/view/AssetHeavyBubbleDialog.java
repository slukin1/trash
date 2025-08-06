package com.huobi.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.material.badge.BadgeDrawable;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.lang.reflect.Field;

public class AssetHeavyBubbleDialog extends DialogFragment {
    public final int arrowWidth = PixelUtils.a(16.0f);
    public Builder builder;
    private Context context;
    public final int cornerWidth = PixelUtils.a(5.0f);
    private final int defaultTextWidth = PixelUtils.a(240.0f);
    private int defaultWidth;
    private LinearLayout llBubbleCard;
    private final int maxContentHeight = PixelUtils.a(160.0f);
    public View rootView;
    public final int shadowWidth = PixelUtils.a(15.0f);
    public boolean supportNight = false;
    public TextView tvAllStep;
    public TextView tvContent;
    public TextView tvCurrentStep;
    public TextView tvPositive;
    public View viewArrow;

    public AssetHeavyBubbleDialog(boolean z11) {
        this.supportNight = z11;
    }

    private void forbidNightMode() {
        if (AppCompatDelegate.m() == 2) {
            Configuration configuration = new Configuration(this.context.getResources().getConfiguration());
            configuration.uiMode = 16;
            this.context = this.context.createConfigurationContext(configuration);
        }
    }

    private static int getTextHeight(TextView textView, int i11) {
        return new StaticLayout(textView.getText(), 0, textView.getText().length(), textView.getPaint(), i11, Layout.Alignment.ALIGN_NORMAL, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding(), textView.getEllipsize(), i11).getHeight();
    }

    private void hideAnim(Animator.AnimatorListener animatorListener) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.rootView, View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat.setDuration(270).setInterpolator(new AccelerateInterpolator());
        ofFloat.addListener(animatorListener);
        ofFloat.start();
    }

    private void initView() {
        this.rootView.setVisibility(4);
        this.llBubbleCard = (LinearLayout) this.rootView.findViewById(R$id.ll_bubble_card);
        this.viewArrow = this.rootView.findViewById(R$id.view_arrow);
        this.tvContent = (TextView) this.rootView.findViewById(R$id.tv_content);
        this.tvPositive = (TextView) this.rootView.findViewById(R$id.tv_positive);
        this.tvCurrentStep = (TextView) this.rootView.findViewById(R$id.tv_current_step);
        this.tvAllStep = (TextView) this.rootView.findViewById(R$id.tv_all_step);
    }

    private void initWindow() {
        setCancelable(false);
        getDialog().setCanceledOnTouchOutside(false);
        Window window = getDialog().getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(BadgeDrawable.TOP_START);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$setPosListener$0(Builder.OnDialogClickListener onDialogClickListener, View view) {
        if (onDialogClickListener != null) {
            onDialogClickListener.onDialogClick(this, view);
        } else {
            dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void layoutMoreTextWindow() {
        if (this.builder != null) {
            int[] anchorViewLocation = getAnchorViewLocation();
            Window window = getDialog().getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.y = (anchorViewLocation[1] - ViewUtil.g()) + this.builder.anchorView.getHeight();
                attributes.x = 0;
                attributes.width = PixelUtils.g();
                window.setAttributes(attributes);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.viewArrow.getLayoutParams();
                layoutParams.gravity = 8388611;
                layoutParams.setMarginStart((anchorViewLocation[0] + (this.builder.anchorView.getWidth() / 2)) - (this.arrowWidth / 2));
                this.viewArrow.setLayoutParams(layoutParams);
                afterLayout();
            }
        }
    }

    private void layoutWindow() {
        if (getTextHeight(this.tvContent, this.defaultTextWidth) > this.maxContentHeight) {
            layoutMoreTextWindow();
        } else {
            autoLayoutWindowByAnchor(this.defaultWidth);
        }
    }

    private void makeContentWidthMatters() {
        this.tvContent.setMinWidth(this.defaultTextWidth);
        ViewGroup.LayoutParams layoutParams = this.tvContent.getLayoutParams();
        layoutParams.width = -2;
        this.tvContent.setLayoutParams(layoutParams);
    }

    private void setContent(String str) {
        this.tvContent.setText(str);
    }

    private void setPosListener(Builder.OnDialogClickListener onDialogClickListener) {
        this.tvPositive.setOnClickListener(new l(this, onDialogClickListener));
    }

    private void setPosText(String str) {
        this.tvPositive.setText(str);
    }

    private void setPosTextColor(int i11) {
        if (i11 != 0) {
            this.tvPositive.setTextColor(i11);
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void setStepTv(Builder builder2) {
        TextView textView = this.tvCurrentStep;
        textView.setText("" + builder2.currentStep);
        TextView textView2 = this.tvAllStep;
        textView2.setText("/" + builder2.allStep);
    }

    private void setTitle(String str) {
        if (str != null && !str.isEmpty()) {
            this.rootView.findViewById(R$id.ll_step).setVisibility(0);
            this.tvCurrentStep.setText(str);
            this.tvAllStep.setText("");
        }
    }

    /* access modifiers changed from: private */
    public void showAnim() {
        int[] iArr = new int[2];
        this.viewArrow.getLocationInWindow(iArr);
        this.rootView.setPivotX(((float) iArr[0]) + (((float) this.arrowWidth) / 2.0f));
        this.rootView.setPivotY((float) iArr[1]);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.rootView, View.SCALE_X, new float[]{0.0f, 1.06f});
        ofFloat.setDuration(300);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.rootView, View.SCALE_X, new float[]{1.06f, 1.0f});
        ofFloat2.setDuration(200);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{ofFloat, ofFloat2});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.rootView, View.SCALE_Y, new float[]{0.0f, 1.06f});
        ofFloat3.setDuration(300);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.rootView, View.SCALE_Y, new float[]{1.06f, 1.0f});
        ofFloat4.setDuration(200);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(new Animator[]{ofFloat3, ofFloat4});
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet3.playTogether(new Animator[]{animatorSet, animatorSet2});
        this.rootView.setVisibility(0);
        animatorSet3.start();
    }

    public void afterLayout() {
        this.viewArrow.post(new m(this));
    }

    public void autoLayoutWindowByAnchor(int i11) {
        Builder builder2 = this.builder;
        if (builder2 != null) {
            View view = builder2.anchorView;
            int[] anchorViewLocation = getAnchorViewLocation();
            Window window = getDialog().getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.width = i11;
                attributes.y = (anchorViewLocation[1] + view.getHeight()) - ViewUtil.g();
                int width = (anchorViewLocation[0] - (i11 - view.getWidth())) + this.builder.offsetX;
                if (width < 0) {
                    attributes.gravity = BadgeDrawable.TOP_START;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.viewArrow.getLayoutParams();
                    int width2 = (anchorViewLocation[0] + (view.getWidth() / 2)) - (this.arrowWidth / 2);
                    layoutParams.setMarginStart(width2);
                    layoutParams.setMarginEnd(0);
                    layoutParams.gravity = 8388611;
                    this.viewArrow.setLayoutParams(layoutParams);
                    int i12 = this.shadowWidth;
                    int i13 = this.cornerWidth;
                    if (width2 < i12 + i13) {
                        this.llBubbleCard.setTranslationX((float) (-((i12 + i13) - width2)));
                    }
                } else {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.viewArrow.getLayoutParams();
                    layoutParams2.setMarginStart((i11 - this.arrowWidth) - PixelUtils.a(10.0f));
                    layoutParams2.setMarginEnd(0);
                    layoutParams2.gravity = 8388611;
                    this.viewArrow.setLayoutParams(layoutParams2);
                    attributes.x = width;
                }
                window.setAttributes(attributes);
                afterLayout();
            }
        }
    }

    public void dismiss() {
        Builder builder2 = this.builder;
        if (builder2 == null || builder2.notExecuteHideAnim) {
            try {
                super.dismissAllowingStateLoss();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        } else {
            hideAnim(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    try {
                        AssetHeavyBubbleDialog.super.dismiss();
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            });
        }
    }

    public int[] getAnchorViewLocation() {
        View view;
        int[] iArr = new int[2];
        Builder builder2 = this.builder;
        if (!(builder2 == null || (view = builder2.anchorView) == null)) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.context = getActivity();
        if (!this.supportNight) {
            forbidNightMode();
        }
        this.rootView = LayoutInflater.from(this.context).inflate(R$layout.layout_asset_text_bubble, viewGroup, true);
        initWindow();
        initView();
        Builder builder2 = this.builder;
        if (builder2 != null) {
            setContent(builder2.content);
            setPosText(this.builder.positiveBtnText);
            setPosTextColor(this.builder.positiveBtnColor);
            setPosListener(this.builder.positiveBtnListener);
            setStepTv(this.builder);
            setTitle(this.builder.title);
        }
        this.defaultWidth = this.defaultTextWidth;
        makeContentWidthMatters();
        return this.rootView;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onStart() {
        super.onStart();
        layoutWindow();
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void setBuilder(Builder builder2) {
        this.builder = builder2;
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public void show() {
        Builder builder2 = this.builder;
        if (builder2 != null) {
            showAllowingStateLoss(builder2.activity.getSupportFragmentManager(), "HeavyBubbleDialog");
        }
    }

    public void showAllowingStateLoss(FragmentManager fragmentManager, String str) {
        if (!isAdded()) {
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
    }

    public static class Builder {
        public FragmentActivity activity;
        public int allStep;
        public View anchorView;
        public String content;
        public int currentStep;
        public boolean notExecuteHideAnim;
        public int offsetX;
        public int positiveBtnColor;
        public OnDialogClickListener positiveBtnListener;
        public String positiveBtnText;
        public String title;

        public interface OnDialogClickListener {
            void onDialogClick(DialogFragment dialogFragment, View view);
        }

        public Builder(FragmentActivity fragmentActivity, View view) {
            this.activity = fragmentActivity;
            this.anchorView = view;
        }

        public Builder allStep(int i11) {
            this.allStep = i11;
            return this;
        }

        public AssetHeavyBubbleDialog build() {
            AssetHeavyBubbleDialog assetHeavyBubbleDialog = new AssetHeavyBubbleDialog(false);
            assetHeavyBubbleDialog.setBuilder(this);
            return assetHeavyBubbleDialog;
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder currentStep(int i11) {
            this.currentStep = i11;
            return this;
        }

        public Builder offsetX(int i11) {
            this.offsetX = i11;
            return this;
        }

        public Builder positiveBtnListener(OnDialogClickListener onDialogClickListener) {
            this.positiveBtnListener = onDialogClickListener;
            return this;
        }

        public Builder positiveBtnText(String str) {
            this.positiveBtnText = str;
            return this;
        }

        public Builder setNotExecuteHideAnim(boolean z11) {
            this.notExecuteHideAnim = z11;
            return this;
        }

        public Builder title(String str) {
            this.title = str;
            return this;
        }

        public AssetHeavyBubbleDialog build(boolean z11) {
            AssetHeavyBubbleDialog assetHeavyBubbleDialog = new AssetHeavyBubbleDialog(z11);
            assetHeavyBubbleDialog.setBuilder(this);
            return assetHeavyBubbleDialog;
        }
    }
}
