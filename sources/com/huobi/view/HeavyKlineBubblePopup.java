package com.huobi.view;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.R$color;
import com.hbg.lib.widgets.R$id;
import com.hbg.lib.widgets.R$integer;
import com.hbg.lib.widgets.R$layout;
import com.hbg.lib.widgets.R$style;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import g6.b;
import java.util.Objects;

public class HeavyKlineBubblePopup extends PopupWindow {
    private boolean canDismiss = false;
    private Context context;
    private ImageView ivImage;
    private LoadingView lvAnim;
    private View target;
    private TextView tvContent;
    private TextView tvNegative;
    private TextView tvPositive;
    private TextView tvSubContent;
    private ConstraintLayout vgBubbleCard;
    private View viewArrow;

    public HeavyKlineBubblePopup(boolean z11, View view, int i11) {
        super(i11, -2);
        Context context2;
        if (z11) {
            Configuration configuration = new Configuration(view.getContext().getResources().getConfiguration());
            configuration.uiMode = 16;
            context2 = view.getContext().createConfigurationContext(configuration);
        } else {
            context2 = view.getContext();
        }
        this.context = context2;
        this.target = view;
        setContentView(onCreateView());
        getContentView().measure(0, 0);
        setClippingEnabled(false);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable());
        setAnimationStyle(R$style.AnimationGuideArrow);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$setNegListener$0(View.OnClickListener onClickListener, View view) {
        dismiss2();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$setPosListener$1(View.OnClickListener onClickListener, View view) {
        dismiss2();
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static /* synthetic */ void lambda$setPosListenerNoDismiss$2(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    private View onCreateView() {
        View inflate = LayoutInflater.from(this.context).inflate(R$layout.view_bubble_kline_guide, (ViewGroup) null);
        ((FrameLayout) inflate.findViewById(R$id.vg_root)).setLayoutParams(new ViewGroup.LayoutParams(getWidth(), -2));
        this.viewArrow = inflate.findViewById(R$id.view_arrow);
        this.vgBubbleCard = (ConstraintLayout) inflate.findViewById(R$id.vg_bubble_card);
        this.tvContent = (TextView) inflate.findViewById(R$id.tv_content);
        this.tvSubContent = (TextView) inflate.findViewById(R$id.tv_sub_content);
        this.lvAnim = (LoadingView) inflate.findViewById(R$id.lv_anim);
        this.ivImage = (ImageView) inflate.findViewById(R$id.iv_image);
        this.tvNegative = (TextView) inflate.findViewById(R$id.tv_negative);
        this.tvPositive = (TextView) inflate.findViewById(R$id.tv_positive);
        return inflate;
    }

    public void dismiss() {
        if (this.canDismiss) {
            dismiss2();
        }
    }

    public void dismiss2() {
        super.dismiss();
    }

    public void setArrowCenterHorizontal(int i11) {
        int[] iArr = new int[2];
        this.target.getLocationInWindow(iArr);
        Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + this.target.getWidth(), iArr[1] + this.target.getHeight());
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.viewArrow.getLayoutParams();
        int i12 = rect.right;
        int i13 = rect.left;
        marginLayoutParams.setMarginStart(((((i12 - i13) / 2) + i13) - (PixelUtils.a(36.0f) / 2)) + i11);
        this.viewArrow.setLayoutParams(marginLayoutParams);
    }

    public void setArrowOffset(int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.viewArrow.getLayoutParams();
        marginLayoutParams.setMarginStart(i11);
        this.viewArrow.setLayoutParams(marginLayoutParams);
    }

    public void setArrowOffsetBottom(int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.viewArrow.getLayoutParams();
        marginLayoutParams.bottomMargin = i11;
        this.viewArrow.setLayoutParams(marginLayoutParams);
    }

    public void setArrowOffsetTop(int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.viewArrow.getLayoutParams();
        marginLayoutParams.topMargin = i11;
        this.viewArrow.setLayoutParams(marginLayoutParams);
    }

    public void setCarMarginLeft(int i11) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.vgBubbleCard.getLayoutParams();
        marginLayoutParams.leftMargin = i11;
        this.vgBubbleCard.setLayoutParams(marginLayoutParams);
    }

    public void setContent(String str) {
        this.tvContent.setText(str);
    }

    public void setImage(String str) {
        if (!TextUtils.isEmpty(str)) {
            b.c().i(this.ivImage, str, R$color.dialog_video_default);
            this.lvAnim.setVisibility(8);
            this.ivImage.setVisibility(0);
        }
    }

    public void setJsonAnim(int i11, int i12, int i13) {
        this.lvAnim.setLottieAnimationRes(i11);
        ViewGroup.LayoutParams layoutParams = this.lvAnim.getLayoutParams();
        layoutParams.width = i12;
        layoutParams.height = i13;
        this.lvAnim.setLayoutParams(layoutParams);
        this.lvAnim.setVisibility(0);
        this.ivImage.setVisibility(8);
    }

    public void setNegListener(View.OnClickListener onClickListener) {
        this.tvNegative.setOnClickListener(new p0(this, onClickListener));
    }

    public void setNegText(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.tvNegative.setVisibility(0);
            this.tvNegative.setText(str);
        }
    }

    public void setPosListener(View.OnClickListener onClickListener) {
        this.tvPositive.setOnClickListener(new q0(this, onClickListener));
    }

    public void setPosListenerNoDismiss(View.OnClickListener onClickListener) {
        this.tvPositive.setOnClickListener(new o0(onClickListener));
    }

    public void setPosText(String str) {
        this.tvPositive.setText(str);
    }

    public void setPosTextColor(int i11) {
        TextView textView = this.tvPositive;
        if (textView != null) {
            textView.setTextColor(i11);
        }
    }

    public void setSubContent(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.tvSubContent.setVisibility(0);
            this.tvSubContent.setText(str);
        }
    }

    public void setSubContentColor(int i11) {
        this.tvSubContent.setTextColor(i11);
    }

    public void setTextViewWidth(int i11) {
        ViewGroup.LayoutParams layoutParams = this.tvContent.getLayoutParams();
        layoutParams.width = i11;
        this.tvContent.setLayoutParams(layoutParams);
    }

    public void show(int i11, int i12) {
        if (this.lvAnim.getVisibility() == 0) {
            int integer = this.context.getResources().getInteger(R$integer.bubble_guide_show_time);
            LoadingView loadingView = this.lvAnim;
            Objects.requireNonNull(loadingView);
            loadingView.postDelayed(new n0(loadingView), (long) integer);
        }
        int[] iArr = new int[2];
        this.target.getLocationInWindow(iArr);
        showAtLocation(this.target, 53, i11, new Rect(iArr[0], iArr[1], iArr[0] + this.target.getWidth(), iArr[1] + this.target.getHeight()).bottom + i12);
    }

    public void showRight(int i11, int i12) {
        if (this.lvAnim.getVisibility() == 0) {
            int integer = this.context.getResources().getInteger(R$integer.bubble_guide_show_time);
            LoadingView loadingView = this.lvAnim;
            Objects.requireNonNull(loadingView);
            loadingView.postDelayed(new n0(loadingView), (long) integer);
        }
        getContentView().measure(0, 0);
        int measuredHeight = getContentView().getMeasuredHeight();
        int[] iArr = new int[2];
        this.target.getLocationInWindow(iArr);
        showAtLocation(this.target, 53, i11, (iArr[1] - measuredHeight) - i12);
    }

    public void showTop(int i11, int i12) {
        if (this.lvAnim.getVisibility() == 0) {
            int integer = this.context.getResources().getInteger(R$integer.bubble_guide_show_time);
            LoadingView loadingView = this.lvAnim;
            Objects.requireNonNull(loadingView);
            loadingView.postDelayed(new n0(loadingView), (long) integer);
        }
        getContentView().measure(0, 0);
        int measuredHeight = getContentView().getMeasuredHeight();
        int[] iArr = new int[2];
        this.target.getLocationInWindow(iArr);
        showAtLocation(this.target, 51, i11, (iArr[1] - measuredHeight) - i12);
    }

    public void setImage(int i11) {
        this.ivImage.setImageResource(i11);
        this.lvAnim.setVisibility(8);
        this.ivImage.setVisibility(0);
    }

    public void setImage(int i11, int i12, int i13) {
        setImage(i11);
        ViewGroup.LayoutParams layoutParams = this.ivImage.getLayoutParams();
        layoutParams.width = i12;
        layoutParams.height = i13;
        this.ivImage.setLayoutParams(layoutParams);
    }
}
