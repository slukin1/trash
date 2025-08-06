package com.huobi.view.wheelpicker;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.ColorUtils;
import com.hbg.lib.common.utils.PixelUtils;
import com.huobi.view.roundimg.RoundedDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.Objects;

public abstract class ConfirmPopup<V extends View> extends BasicPopup<View> {
    public int backgroundColor = -1;
    private TextView cancelButton;
    public CharSequence cancelText = "";
    public int cancelTextColor = RoundedDrawable.DEFAULT_BORDER_COLOR;
    public int cancelTextSize = 0;
    private int cancelTypeDimension = 2;
    public boolean cancelVisible = true;
    public int pressedTextColor = WheelView.TEXT_COLOR_FOCUS;
    private TextView submitButton;
    public CharSequence submitText = "";
    public int submitTextColor = RoundedDrawable.DEFAULT_BORDER_COLOR;
    public int submitTextSize = 0;
    private int submitTypeDimension = 2;
    public CharSequence titleText = "";
    public int titleTextColor = RoundedDrawable.DEFAULT_BORDER_COLOR;
    public int titleTextSize = 0;
    private int titleTypeDimension = 2;
    private View titleView;
    public int topBackgroundColor = -1;
    public int topHeight = 40;
    public int topLineColor = -2236963;
    public int topLineHeight = 1;
    public boolean topLineVisible = true;
    public int topPadding = 15;

    public ConfirmPopup(Activity activity) {
        super(activity);
        this.cancelText = activity.getString(17039360);
        this.submitText = activity.getString(17039370);
    }

    public TextView getCancelButton() {
        TextView textView = this.cancelButton;
        Objects.requireNonNull(textView, "please call show at first");
        return textView;
    }

    public TextView getSubmitButton() {
        TextView textView = this.submitButton;
        Objects.requireNonNull(textView, "please call show at first");
        return textView;
    }

    public View getTitleView() {
        View view = this.titleView;
        Objects.requireNonNull(view, "please call show at first");
        return view;
    }

    public abstract V makeCenterView();

    public final View makeContentView() {
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(this.backgroundColor);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setPadding(0, 0, 0, 0);
        linearLayout.setClipToPadding(false);
        View makeHeaderView = makeHeaderView();
        if (makeHeaderView != null) {
            linearLayout.addView(makeHeaderView);
        }
        if (this.topLineVisible) {
            View view = new View(this.activity);
            view.setLayoutParams(new LinearLayout.LayoutParams(-1, PixelUtils.a((float) this.topLineHeight)));
            view.setBackgroundColor(this.topLineColor);
            linearLayout.addView(view);
        }
        linearLayout.addView(makeCenterView(), new LinearLayout.LayoutParams(-1, 0, 1.0f));
        View makeFooterView = makeFooterView();
        if (makeFooterView != null) {
            linearLayout.addView(makeFooterView);
        }
        return linearLayout;
    }

    public View makeFooterView() {
        return null;
    }

    public View makeHeaderView() {
        RelativeLayout relativeLayout = new RelativeLayout(this.activity);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, PixelUtils.a((float) this.topHeight)));
        relativeLayout.setBackgroundColor(this.topBackgroundColor);
        relativeLayout.setGravity(16);
        TextView textView = new TextView(this.activity);
        this.cancelButton = textView;
        textView.setVisibility(this.cancelVisible ? 0 : 8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(15, -1);
        this.cancelButton.setLayoutParams(layoutParams);
        this.cancelButton.setBackgroundColor(0);
        this.cancelButton.setGravity(17);
        int a11 = PixelUtils.a((float) this.topPadding);
        this.cancelButton.setPadding(a11, 0, a11, 0);
        if (!TextUtils.isEmpty(this.cancelText)) {
            this.cancelButton.setText(this.cancelText);
        }
        this.cancelButton.setTextColor(ColorUtils.a(this.cancelTextColor, this.pressedTextColor));
        int i11 = this.cancelTextSize;
        if (i11 != 0) {
            this.cancelButton.setTextSize(this.cancelTypeDimension, (float) i11);
        }
        this.cancelButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ConfirmPopup.this.dismiss();
                ConfirmPopup.this.onCancel();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        relativeLayout.addView(this.cancelButton);
        if (this.titleView == null) {
            TextView textView2 = new TextView(this.activity);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            int a12 = PixelUtils.a((float) this.topPadding);
            layoutParams2.leftMargin = a12;
            layoutParams2.rightMargin = a12;
            layoutParams2.addRule(14, -1);
            layoutParams2.addRule(15, -1);
            textView2.setLayoutParams(layoutParams2);
            textView2.setGravity(17);
            if (!TextUtils.isEmpty(this.titleText)) {
                textView2.setText(this.titleText);
            }
            textView2.setTextColor(this.titleTextColor);
            int i12 = this.titleTextSize;
            if (i12 != 0) {
                textView2.setTextSize(this.titleTypeDimension, (float) i12);
            }
            this.titleView = textView2;
        }
        relativeLayout.addView(this.titleView);
        this.submitButton = new TextView(this.activity);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams3.addRule(11, -1);
        layoutParams3.addRule(15, -1);
        this.submitButton.setLayoutParams(layoutParams3);
        this.submitButton.setBackgroundColor(0);
        this.submitButton.setGravity(17);
        this.submitButton.setPadding(a11, 0, a11, 0);
        if (!TextUtils.isEmpty(this.submitText)) {
            this.submitButton.setText(this.submitText);
        }
        this.submitButton.setTextColor(ColorUtils.a(this.submitTextColor, this.pressedTextColor));
        int i13 = this.submitTextSize;
        if (i13 != 0) {
            this.submitButton.setTextSize(this.submitTypeDimension, (float) i13);
        }
        this.submitButton.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                ConfirmPopup.this.dismiss();
                ConfirmPopup.this.onSubmit();
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
        relativeLayout.addView(this.submitButton);
        return relativeLayout;
    }

    public void onCancel() {
    }

    public void onSubmit() {
    }

    public void setBackgroundColor(int i11) {
        this.backgroundColor = i11;
    }

    public void setCancelText(CharSequence charSequence) {
        TextView textView = this.cancelButton;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.cancelText = charSequence;
        }
    }

    public void setCancelTextColor(int i11) {
        TextView textView = this.cancelButton;
        if (textView != null) {
            textView.setTextColor(i11);
        } else {
            this.cancelTextColor = i11;
        }
    }

    public void setCancelTextSize(int i11) {
        this.cancelTextSize = i11;
    }

    public void setCancelVisible(boolean z11) {
        TextView textView = this.cancelButton;
        if (textView != null) {
            textView.setVisibility(z11 ? 0 : 8);
        } else {
            this.cancelVisible = z11;
        }
    }

    public void setPressedTextColor(int i11) {
        this.pressedTextColor = i11;
    }

    public void setSubmitText(CharSequence charSequence) {
        TextView textView = this.submitButton;
        if (textView != null) {
            textView.setText(charSequence);
        } else {
            this.submitText = charSequence;
        }
    }

    public void setSubmitTextColor(int i11) {
        TextView textView = this.submitButton;
        if (textView != null) {
            textView.setTextColor(i11);
        } else {
            this.submitTextColor = i11;
        }
    }

    public void setSubmitTextSize(int i11) {
        this.submitTextSize = i11;
    }

    public void setTitleText(CharSequence charSequence) {
        View view = this.titleView;
        if (view == null || !(view instanceof TextView)) {
            this.titleText = charSequence;
        } else {
            ((TextView) view).setText(charSequence);
        }
    }

    public void setTitleTextColor(int i11) {
        View view = this.titleView;
        if (view == null || !(view instanceof TextView)) {
            this.titleTextColor = i11;
        } else {
            ((TextView) view).setTextColor(i11);
        }
    }

    public void setTitleTextSize(int i11) {
        this.titleTextSize = i11;
    }

    public void setTitleView(View view) {
        this.titleView = view;
    }

    public void setTopBackgroundColor(int i11) {
        this.topBackgroundColor = i11;
    }

    public void setTopHeight(int i11) {
        this.topHeight = i11;
    }

    public void setTopLineColor(int i11) {
        this.topLineColor = i11;
    }

    public void setTopLineHeight(int i11) {
        this.topLineHeight = i11;
    }

    public void setTopLineVisible(boolean z11) {
        this.topLineVisible = z11;
    }

    public void setTopPadding(int i11) {
        this.topPadding = i11;
    }

    public void setCancelTextSize(int i11, int i12) {
        this.cancelTextSize = i11;
        this.cancelTypeDimension = i12;
    }

    public void setSubmitTextSize(int i11, int i12) {
        this.submitTextSize = i11;
        this.submitTypeDimension = i12;
    }

    public void setTitleTextSize(int i11, int i12) {
        this.titleTextSize = i11;
        this.titleTypeDimension = i12;
    }

    public void setCancelText(int i11) {
        setCancelText((CharSequence) this.activity.getString(i11));
    }

    public void setSubmitText(int i11) {
        setSubmitText((CharSequence) this.activity.getString(i11));
    }

    public void setTitleText(int i11) {
        setTitleText((CharSequence) this.activity.getString(i11));
    }
}
