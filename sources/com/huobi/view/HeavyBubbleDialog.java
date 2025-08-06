package com.huobi.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.lang.reflect.Field;

public class HeavyBubbleDialog extends DialogFragment {
    public final int arrowWidth = PixelUtils.a(16.0f);
    public Builder builder;
    private Context context;
    public final int cornerWidth = PixelUtils.a(5.0f);
    public ImageView ivImage;
    private LinearLayout llBubbleCard;
    public LoadingView lvAnim;
    public View rootView;
    public final int shadowWidth = PixelUtils.a(15.0f);
    public boolean supportNight = false;
    public TextView tvContent;
    public TextView tvMore;
    public TextView tvNegative;
    public TextView tvPositive;
    public TextView tvSubContent;
    public View viewArrow;

    private void forbidNightMode() {
        if (AppCompatDelegate.m() == 2) {
            Configuration configuration = new Configuration(this.context.getResources().getConfiguration());
            configuration.uiMode = 16;
            this.context = this.context.createConfigurationContext(configuration);
        }
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
        this.tvSubContent = (TextView) this.rootView.findViewById(R$id.tv_sub_content);
        this.lvAnim = (LoadingView) this.rootView.findViewById(R$id.lv_anim);
        this.ivImage = (ImageView) this.rootView.findViewById(R$id.iv_image);
        this.tvNegative = (TextView) this.rootView.findViewById(R$id.tv_negative);
        this.tvPositive = (TextView) this.rootView.findViewById(R$id.tv_positive);
        this.tvMore = (TextView) this.rootView.findViewById(R$id.tv_more);
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
    public /* synthetic */ void lambda$setMoreListener$1(Builder.OnDialogClickListener onDialogClickListener, View view) {
        if (onDialogClickListener != null) {
            onDialogClickListener.onDialogClick(this, view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$setNegListener$0(Builder.OnDialogClickListener onDialogClickListener, View view) {
        if (onDialogClickListener != null) {
            onDialogClickListener.onDialogClick(this, view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$setPosListener$2(Builder.OnDialogClickListener onDialogClickListener, View view) {
        if (onDialogClickListener != null) {
            onDialogClickListener.onDialogClick(this, view);
        } else {
            dismiss();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void setContent(String str) {
        this.tvContent.setText(str);
    }

    private void setMoreColor(int i11) {
        if (i11 != 0) {
            this.tvMore.setTextColor(i11);
        }
    }

    private void setMoreListener(Builder.OnDialogClickListener onDialogClickListener) {
        this.tvMore.setOnClickListener(new i0(this, onDialogClickListener));
    }

    private void setMoreText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.tvMore.setVisibility(0);
        }
        this.tvMore.setText(str);
    }

    private void setNegListener(Builder.OnDialogClickListener onDialogClickListener) {
        this.tvNegative.setOnClickListener(new h0(this, onDialogClickListener));
    }

    private void setNegText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.tvNegative.setVisibility(0);
            this.tvNegative.setText(str);
        }
    }

    private void setPosListener(Builder.OnDialogClickListener onDialogClickListener) {
        this.tvPositive.setOnClickListener(new g0(this, onDialogClickListener));
    }

    private void setPosText(String str) {
        this.tvPositive.setText(str);
    }

    private void setPosTextColor(int i11) {
        if (i11 != 0) {
            this.tvPositive.setTextColor(i11);
        }
    }

    private void setSubContent(String str, int i11) {
        if (!TextUtils.isEmpty(str)) {
            this.tvSubContent.setVisibility(0);
            if (i11 >= 0) {
                this.tvSubContent.setTextColor(i11);
            }
            this.tvSubContent.setText(str);
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
        this.viewArrow.post(new j0(this));
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
                int width = (int) ((((float) anchorViewLocation[0]) + (((float) view.getWidth()) / 2.0f)) - (((float) i11) / 2.0f));
                if (i11 + width > PixelUtils.g()) {
                    attributes.gravity = BadgeDrawable.TOP_END;
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.viewArrow.getLayoutParams();
                    layoutParams.setMarginStart(0);
                    int g11 = ((PixelUtils.g() - anchorViewLocation[0]) - (view.getWidth() / 2)) - (this.arrowWidth / 2);
                    layoutParams.setMarginEnd(g11);
                    layoutParams.gravity = 8388613;
                    this.viewArrow.setLayoutParams(layoutParams);
                    int i12 = this.shadowWidth;
                    int i13 = this.cornerWidth;
                    if (g11 < i12 + i13) {
                        this.llBubbleCard.setTranslationX((float) ((i12 + i13) - g11));
                    }
                } else if (width < 0) {
                    attributes.gravity = BadgeDrawable.TOP_START;
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.viewArrow.getLayoutParams();
                    int width2 = (anchorViewLocation[0] + (view.getWidth() / 2)) - (this.arrowWidth / 2);
                    layoutParams2.setMarginStart(width2);
                    layoutParams2.setMarginEnd(0);
                    layoutParams2.gravity = 8388611;
                    this.viewArrow.setLayoutParams(layoutParams2);
                    int i14 = this.shadowWidth;
                    int i15 = this.cornerWidth;
                    if (width2 < i14 + i15) {
                        this.llBubbleCard.setTranslationX((float) (-((i14 + i15) - width2)));
                    }
                } else {
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
                        HeavyBubbleDialog.super.dismiss();
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
        this.rootView = LayoutInflater.from(this.context).inflate(R$layout.layout_pic_text_bubble, viewGroup, true);
        initWindow();
        initView();
        Builder builder2 = this.builder;
        if (builder2 != null) {
            setContent(builder2.content);
            Builder builder3 = this.builder;
            setSubContent(builder3.subContent, builder3.subContentTextColor);
            setNegText(this.builder.negativeBtnText);
            setNegListener(this.builder.negativeBtnListener);
            setPosText(this.builder.positiveBtnText);
            setPosTextColor(this.builder.positiveBtnColor);
            setPosListener(this.builder.positiveBtnListener);
            setMoreText(this.builder.moreBtnText);
            setMoreListener(this.builder.moreBtnListener);
            setMoreColor(this.builder.tvMoreColor);
        }
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
        public View anchorView;
        public int animHeight;
        public int animResId;
        public int animWidth;
        public String content;
        public int imageResId;
        public String imageUrl;
        public OnDialogClickListener moreBtnListener;
        public String moreBtnText;
        public OnDialogClickListener negativeBtnListener;
        public String negativeBtnText;
        public boolean notExecuteHideAnim;
        public int positiveBtnColor;
        public OnDialogClickListener positiveBtnListener;
        public String positiveBtnText;
        public String subContent;
        public int subContentTextColor = -1;
        public int tvMoreColor;

        public interface OnDialogClickListener {
            void onDialogClick(DialogFragment dialogFragment, View view);
        }

        public Builder(FragmentActivity fragmentActivity, View view) {
            this.activity = fragmentActivity;
            this.anchorView = view;
        }

        private boolean noPic() {
            return this.animResId == 0 && this.imageUrl == null && this.imageResId == 0;
        }

        public Builder animHeight(int i11) {
            this.animHeight = i11;
            return this;
        }

        public Builder animResId(int i11) {
            this.animResId = i11;
            return this;
        }

        public Builder animWidth(int i11) {
            this.animWidth = i11;
            return this;
        }

        public HeavyBubbleDialog build() {
            HeavyBubbleDialog heavyBubbleDialog;
            if (noPic()) {
                heavyBubbleDialog = new HeavyTextBubbleDialog(false);
            } else {
                heavyBubbleDialog = new HeavyPicTextBubbleDialog(false);
            }
            heavyBubbleDialog.setBuilder(this);
            return heavyBubbleDialog;
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder imageResId(int i11) {
            this.imageResId = i11;
            return this;
        }

        public Builder imageUrl(String str) {
            this.imageUrl = str;
            return this;
        }

        public Builder more(String str) {
            this.moreBtnText = str;
            return this;
        }

        public Builder moreBtnListener(OnDialogClickListener onDialogClickListener) {
            this.moreBtnListener = onDialogClickListener;
            return this;
        }

        public Builder moreColor(int i11) {
            this.tvMoreColor = i11;
            return this;
        }

        public Builder negativeBtnListener(OnDialogClickListener onDialogClickListener) {
            this.negativeBtnListener = onDialogClickListener;
            return this;
        }

        public Builder negativeBtnText(String str) {
            this.negativeBtnText = str;
            return this;
        }

        public Builder positiveBtnColor(int i11) {
            this.positiveBtnColor = i11;
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

        public Builder subContent(String str) {
            this.subContent = str;
            return this;
        }

        public Builder subContentTextColor(int i11) {
            this.subContentTextColor = i11;
            return this;
        }

        public HeavyBubbleDialog build(boolean z11) {
            HeavyBubbleDialog heavyBubbleDialog;
            if (noPic()) {
                heavyBubbleDialog = new HeavyTextBubbleDialog(z11);
            } else {
                heavyBubbleDialog = new HeavyPicTextBubbleDialog(z11);
            }
            heavyBubbleDialog.setBuilder(this);
            return heavyBubbleDialog;
        }
    }
}
