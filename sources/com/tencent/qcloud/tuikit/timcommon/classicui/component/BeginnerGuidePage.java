package com.tencent.qcloud.tuikit.timcommon.classicui.component;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.util.SPUtils;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.component.impl.GlideEngine;
import com.tencent.qcloud.tuikit.timcommon.util.ScreenUtil;
import com.tencent.qcloud.tuikit.timcommon.util.SoftKeyBoardUtil;
import com.tencent.qcloud.tuikit.timcommon.util.TIMCommonConstants;

public class BeginnerGuidePage {
    /* access modifiers changed from: private */
    public OnFinishListener onFinishListener;
    /* access modifiers changed from: private */
    public PopupWindow popupWindow;
    /* access modifiers changed from: private */
    public int[] resIDs;
    /* access modifiers changed from: private */
    public ViewPager2 viewPager;

    public class GuideAdapter extends RecyclerView.Adapter<GuideViewHolder> {

        public class GuideViewHolder extends RecyclerView.ViewHolder {
            /* access modifiers changed from: private */
            public final ImageView image;

            public GuideViewHolder(View view) {
                super(view);
                this.image = (ImageView) view.findViewById(R.id.center_image);
            }
        }

        public GuideAdapter() {
        }

        public int getItemCount() {
            if (BeginnerGuidePage.this.resIDs == null) {
                return 0;
            }
            return BeginnerGuidePage.this.resIDs.length;
        }

        public void onBindViewHolder(final GuideViewHolder guideViewHolder, int i11) {
            ViewGroup.LayoutParams layoutParams = guideViewHolder.image.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = ScreenUtil.getScreenWidth(guideViewHolder.image.getContext());
                layoutParams.height = ScreenUtil.getScreenHeight(guideViewHolder.image.getContext());
                guideViewHolder.image.setLayoutParams(layoutParams);
            }
            GlideEngine.loadImage(guideViewHolder.image, (Object) Integer.valueOf(BeginnerGuidePage.this.resIDs[i11]));
            guideViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (BeginnerGuidePage.this.viewPager != null) {
                        int bindingAdapterPosition = guideViewHolder.getBindingAdapterPosition();
                        if (bindingAdapterPosition < GuideAdapter.this.getItemCount() - 1) {
                            BeginnerGuidePage.this.viewPager.setCurrentItem(bindingAdapterPosition + 1, true);
                        } else {
                            if (BeginnerGuidePage.this.onFinishListener != null) {
                                BeginnerGuidePage.this.onFinishListener.onFinish();
                            }
                            if (BeginnerGuidePage.this.popupWindow != null && BeginnerGuidePage.this.popupWindow.isShowing()) {
                                BeginnerGuidePage.this.popupWindow.dismiss();
                            }
                        }
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
        }

        public GuideViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
            return new GuideViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_beginner_guide_item, viewGroup, false));
        }
    }

    @FunctionalInterface
    public interface OnFinishListener {
        void onFinish();
    }

    public BeginnerGuidePage(Activity activity) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_beginner_guide, (ViewGroup) null);
        this.viewPager = (ViewPager2) inflate.findViewById(R.id.view_pager);
        final Activity activity2 = activity;
        AnonymousClass1 r32 = new PopupWindow(inflate, -1, -1, true) {
            public void dismiss() {
                Activity activity = activity2;
                if (activity != null && !activity.isFinishing()) {
                    BeginnerGuidePage.this.startAnimation(activity2.getWindow(), false);
                }
                super.dismiss();
            }

            public void showAtLocation(View view, int i11, int i12, int i13) {
                Activity activity = activity2;
                if (activity != null && !activity.isFinishing()) {
                    BeginnerGuidePage.this.startAnimation(activity2.getWindow(), true);
                }
                super.showAtLocation(view, i11, i12, i13);
            }
        };
        this.popupWindow = r32;
        r32.setBackgroundDrawable(new ColorDrawable());
        this.popupWindow.setTouchable(true);
        this.popupWindow.setOutsideTouchable(false);
        this.popupWindow.setAnimationStyle(R.style.BeginnerGuidePopupAnimation);
        this.viewPager.setUserInputEnabled(false);
        this.viewPager.setAdapter(new GuideAdapter());
    }

    public static void showBeginnerGuideThen(View view, final Runnable runnable) {
        if (SPUtils.getInstance(TIMCommonConstants.CHAT_SETTINGS_SP_NAME).getBoolean(TIMCommonConstants.CHAT_REPLY_GUIDE_SHOW_SP_KEY, true)) {
            SoftKeyBoardUtil.hideKeyBoard(view.getWindowToken());
            SPUtils.getInstance(TIMCommonConstants.CHAT_SETTINGS_SP_NAME).put(TIMCommonConstants.CHAT_REPLY_GUIDE_SHOW_SP_KEY, false);
            BeginnerGuidePage beginnerGuidePage = new BeginnerGuidePage((Activity) view.getContext());
            beginnerGuidePage.setPagesResIDs(R.drawable.chat_reply_guide, R.drawable.chat_quote_guide);
            beginnerGuidePage.setOnFinishListener(new OnFinishListener() {
                public void onFinish() {
                    runnable.run();
                }
            });
            beginnerGuidePage.show(view, 0);
            return;
        }
        runnable.run();
    }

    /* access modifiers changed from: private */
    public void startAnimation(final Window window, boolean z11) {
        ValueAnimator valueAnimator;
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        if (z11) {
            valueAnimator = ValueAnimator.ofFloat(new float[]{1.0f, 0.5f});
        } else {
            valueAnimator = ValueAnimator.ofFloat(new float[]{0.5f, 1.0f});
        }
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.alpha = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                window.setAttributes(attributes);
            }
        });
        valueAnimator.setDuration(200);
        valueAnimator.setInterpolator(linearInterpolator);
        valueAnimator.start();
    }

    public void setOnFinishListener(OnFinishListener onFinishListener2) {
        this.onFinishListener = onFinishListener2;
    }

    public void setPagesResIDs(int... iArr) {
        this.resIDs = iArr;
        this.viewPager.setOffscreenPageLimit(iArr.length);
        this.viewPager.getAdapter().notifyDataSetChanged();
        this.viewPager.setCurrentItem(0, false);
    }

    public void show(View view, int i11) {
        PopupWindow popupWindow2 = this.popupWindow;
        if (popupWindow2 != null) {
            popupWindow2.showAtLocation(view, i11, 0, 0);
        }
    }
}
