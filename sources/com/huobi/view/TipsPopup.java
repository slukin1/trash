package com.huobi.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.R$drawable;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$layout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class TipsPopup extends PopupWindow {
    private View centerBg;
    private TextView contentTv;
    private AnimatorSet endAnimatorSet;
    private boolean isArrowUp;
    /* access modifiers changed from: private */
    public boolean isDismiss;
    private View leftBg;
    private int locationX;
    private View rightBg;
    private View rootView;
    private AnimatorSet startAnimatorSet;
    private String text;

    public TipsPopup(Context context, boolean z11, String str) {
        this.isArrowUp = z11;
        this.text = str;
        initView(context);
    }

    private void initView(Context context) {
        View inflate = View.inflate(context, R$layout.tips_popup_layout, (ViewGroup) null);
        this.rootView = inflate;
        this.contentTv = (TextView) inflate.findViewById(R$id.id_accept_popup_content_tv);
        this.rightBg = this.rootView.findViewById(R$id.id_otc_bubble_bg_right);
        this.leftBg = this.rootView.findViewById(R$id.id_otc_bubble_bg_left);
        this.centerBg = this.rootView.findViewById(R$id.id_otc_bubble_bg_center_tv);
        setContentView(this.rootView);
        setWidth(-2);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setFocusable(true);
        getContentView().setOnClickListener(new q1(this));
        this.contentTv.setText(this.text);
        if (!this.isArrowUp) {
            this.rightBg.setBackgroundResource(R$drawable.grid_tips_bubble_bg_left_down);
            this.leftBg.setBackgroundResource(R$drawable.grid_tips_bubble_bg_right_down);
            this.centerBg.setBackgroundResource(R$drawable.grid_tips_bubble_bg_center_down);
            this.contentTv.setPadding(PixelUtils.a(20.0f), PixelUtils.a(25.0f), PixelUtils.a(20.0f), PixelUtils.a(22.0f));
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private void showAsDropDown(View view, int i11) {
        super.showAsDropDown(view);
        updateAnim(i11);
    }

    private void showAtDown(View view, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = Resources.getSystem().getDisplayMetrics().widthPixels;
        int i17 = Resources.getSystem().getDisplayMetrics().heightPixels;
        if (view.getContext() instanceof Activity) {
            Rect rect = new Rect();
            ((Activity) view.getContext()).getWindow().getDecorView().getGlobalVisibleRect(rect);
            int i18 = rect.right - rect.left;
            i17 = rect.bottom - rect.top;
            i16 = i18;
        }
        this.rootView.measure(View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE));
        int measuredWidth = this.rootView.getMeasuredWidth();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = view.getWidth();
        this.centerBg.measure(View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i17, Integer.MIN_VALUE));
        int measuredWidth2 = this.centerBg.getMeasuredWidth();
        int i19 = width / 2;
        int i21 = measuredWidth / 2;
        if (iArr[0] + i19 + i21 > i16) {
            i13 = ((i21 + ((iArr[0] + i19) - (i16 - i21))) - (measuredWidth2 / 2)) - PixelUtils.a(5.0f);
            i12 = 0;
        } else {
            if ((iArr[0] + i19) - i21 < 0) {
                i12 = -iArr[0];
                i15 = (i21 - (i21 - (iArr[0] + i19))) - (measuredWidth2 / 2);
                i14 = PixelUtils.a(5.0f);
            } else {
                i12 = i19 - i21;
                i15 = i21 - (measuredWidth2 / 2);
                i14 = PixelUtils.a(5.0f);
            }
            i13 = i15 - i14;
        }
        super.showAsDropDown(view, i12, 0);
        updateAnim(i13);
    }

    private void showAtUp(View view, int i11) {
        int i12;
        int i13;
        int i14;
        int i15 = Resources.getSystem().getDisplayMetrics().widthPixels;
        int i16 = Resources.getSystem().getDisplayMetrics().heightPixels;
        if (view.getContext() instanceof Activity) {
            Rect rect = new Rect();
            ((Activity) view.getContext()).getWindow().getDecorView().getGlobalVisibleRect(rect);
            int i17 = rect.right - rect.left;
            i16 = rect.bottom - rect.top;
            i15 = i17;
        }
        this.rootView.measure(View.MeasureSpec.makeMeasureSpec(i15, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE));
        int measuredWidth = this.rootView.getMeasuredWidth();
        int a11 = PixelUtils.a(52.0f) + (PixelUtils.a(14.0f) * this.contentTv.getLineCount());
        setHeight(a11);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int width = view.getWidth();
        this.centerBg.measure(View.MeasureSpec.makeMeasureSpec(i15, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(i16, Integer.MIN_VALUE));
        int measuredWidth2 = this.centerBg.getMeasuredWidth();
        int i18 = 0;
        int i19 = width / 2;
        int i21 = measuredWidth / 2;
        if (iArr[0] + i19 + i21 > i15) {
            i12 = ((i21 + ((iArr[0] + i19) - (i15 - i21))) - (measuredWidth2 / 2)) - PixelUtils.a(5.0f);
            i18 = i15 - measuredWidth;
        } else {
            if ((iArr[0] + i19) - i21 < 0) {
                i14 = (i21 - (i21 - (iArr[0] + i19))) - (measuredWidth2 / 2);
                i13 = PixelUtils.a(5.0f);
            } else {
                i18 = (iArr[0] + i19) - i21;
                i14 = i21 - (measuredWidth2 / 2);
                i13 = PixelUtils.a(5.0f);
            }
            i12 = i14 - i13;
        }
        super.showAtLocation(view, 51, i18, iArr[1] - a11);
        updateAnim(i12);
    }

    private void updateAnim(int i11) {
        this.isDismiss = false;
        if (this.startAnimatorSet == null) {
            this.startAnimatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.rootView, "alpha", new float[]{0.0f, 1.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.rootView, "scaleX", new float[]{0.7f, 1.0f});
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.rootView, "scaleY", new float[]{0.7f, 1.0f});
            this.startAnimatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
            this.startAnimatorSet.setInterpolator(new FastOutSlowInInterpolator());
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.centerBg.getLayoutParams();
        marginLayoutParams.setMarginStart(i11);
        this.centerBg.setLayoutParams(marginLayoutParams);
        this.contentTv.setText(this.text);
        View view = this.rootView;
        if (view != null && this.startAnimatorSet != null) {
            if (this.isArrowUp) {
                view.setPivotY(0.0f);
            } else {
                view.setPivotY((float) getHeight());
            }
            this.rootView.setPivotX((float) (i11 + (this.centerBg.getWidth() / 2)));
            this.startAnimatorSet.start();
        }
    }

    public void dismiss() {
        if (this.endAnimatorSet == null) {
            this.endAnimatorSet = new AnimatorSet();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.rootView, "alpha", new float[]{1.0f, 0.0f});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.rootView, "scaleX", new float[]{1.0f, 0.7f});
            this.rootView.setPivotX((float) (this.locationX + (this.centerBg.getWidth() / 2)));
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.rootView, "scaleY", new float[]{1.0f, 0.7f});
            if (this.isArrowUp) {
                this.rootView.setPivotY(0.0f);
            } else {
                this.rootView.setPivotY((float) getHeight());
            }
            this.endAnimatorSet.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                }

                public void onAnimationEnd(Animator animator) {
                    if (TipsPopup.this.isDismiss) {
                        TipsPopup.this.dismiss();
                    }
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            });
            this.endAnimatorSet.setDuration(150);
            this.endAnimatorSet.setInterpolator(new FastOutSlowInInterpolator());
            this.endAnimatorSet.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3});
        }
        if (!this.isDismiss) {
            this.isDismiss = true;
            this.endAnimatorSet.start();
            return;
        }
        this.isDismiss = false;
        super.dismiss();
    }

    public void setText(String str) {
        this.text = str;
    }

    public void showAt(View view, int i11) {
        this.locationX = i11;
        if (this.isArrowUp) {
            showAtDown(view, i11);
        } else {
            showAtUp(view, i11);
        }
    }
}
