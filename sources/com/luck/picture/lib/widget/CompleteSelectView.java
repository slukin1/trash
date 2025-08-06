package com.luck.picture.lib.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.interfaces.OnSelectAnimListener;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.style.PictureSelectorStyle;
import com.luck.picture.lib.style.SelectMainStyle;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.utils.ValueOf;

public class CompleteSelectView extends LinearLayout {
    private SelectorConfig config;
    private Animation numberChangeAnimation;
    private TextView tvComplete;
    private TextView tvSelectNum;

    public CompleteSelectView(Context context) {
        super(context);
        init();
    }

    private void init() {
        inflateLayout();
        setOrientation(0);
        this.tvSelectNum = (TextView) findViewById(R.id.ps_tv_select_num);
        this.tvComplete = (TextView) findViewById(R.id.ps_tv_complete);
        setGravity(16);
        this.numberChangeAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ps_anim_modal_in);
        this.config = SelectorProviders.getInstance().getSelectorConfig();
    }

    public void inflateLayout() {
        LayoutInflater.from(getContext()).inflate(R.layout.ps_complete_selected_layout, this);
    }

    public void setCompleteSelectViewStyle() {
        PictureSelectorStyle pictureSelectorStyle = this.config.selectorStyle;
        SelectMainStyle selectMainStyle = pictureSelectorStyle.getSelectMainStyle();
        if (StyleUtils.checkStyleValidity(selectMainStyle.getSelectNormalBackgroundResources())) {
            setBackgroundResource(selectMainStyle.getSelectNormalBackgroundResources());
        }
        String string = StyleUtils.checkStyleValidity(selectMainStyle.getSelectNormalTextResId()) ? getContext().getString(selectMainStyle.getSelectNormalTextResId()) : selectMainStyle.getSelectNormalText();
        if (StyleUtils.checkTextValidity(string)) {
            if (StyleUtils.checkTextTwoFormatValidity(string)) {
                this.tvComplete.setText(String.format(string, new Object[]{Integer.valueOf(this.config.getSelectCount()), Integer.valueOf(this.config.maxSelectNum)}));
            } else {
                this.tvComplete.setText(string);
            }
        }
        int selectNormalTextSize = selectMainStyle.getSelectNormalTextSize();
        if (StyleUtils.checkSizeValidity(selectNormalTextSize)) {
            this.tvComplete.setTextSize((float) selectNormalTextSize);
        }
        int selectNormalTextColor = selectMainStyle.getSelectNormalTextColor();
        if (StyleUtils.checkStyleValidity(selectNormalTextColor)) {
            this.tvComplete.setTextColor(selectNormalTextColor);
        }
        BottomNavBarStyle bottomBarStyle = pictureSelectorStyle.getBottomBarStyle();
        if (bottomBarStyle.isCompleteCountTips()) {
            int bottomSelectNumResources = bottomBarStyle.getBottomSelectNumResources();
            if (StyleUtils.checkStyleValidity(bottomSelectNumResources)) {
                this.tvSelectNum.setBackgroundResource(bottomSelectNumResources);
            }
            int bottomSelectNumTextSize = bottomBarStyle.getBottomSelectNumTextSize();
            if (StyleUtils.checkSizeValidity(bottomSelectNumTextSize)) {
                this.tvSelectNum.setTextSize((float) bottomSelectNumTextSize);
            }
            int bottomSelectNumTextColor = bottomBarStyle.getBottomSelectNumTextColor();
            if (StyleUtils.checkStyleValidity(bottomSelectNumTextColor)) {
                this.tvSelectNum.setTextColor(bottomSelectNumTextColor);
            }
        }
    }

    public void setSelectedChange(boolean z11) {
        PictureSelectorStyle pictureSelectorStyle = this.config.selectorStyle;
        SelectMainStyle selectMainStyle = pictureSelectorStyle.getSelectMainStyle();
        if (this.config.getSelectCount() > 0) {
            setEnabled(true);
            int selectBackgroundResources = selectMainStyle.getSelectBackgroundResources();
            if (StyleUtils.checkStyleValidity(selectBackgroundResources)) {
                setBackgroundResource(selectBackgroundResources);
            } else {
                setBackgroundResource(R.drawable.ps_ic_trans_1px);
            }
            String string = StyleUtils.checkStyleValidity(selectMainStyle.getSelectTextResId()) ? getContext().getString(selectMainStyle.getSelectTextResId()) : selectMainStyle.getSelectText();
            if (!StyleUtils.checkTextValidity(string)) {
                this.tvComplete.setText(getContext().getString(R.string.ps_completed));
            } else if (StyleUtils.checkTextTwoFormatValidity(string)) {
                this.tvComplete.setText(String.format(string, new Object[]{Integer.valueOf(this.config.getSelectCount()), Integer.valueOf(this.config.maxSelectNum)}));
            } else {
                this.tvComplete.setText(string);
            }
            int selectTextSize = selectMainStyle.getSelectTextSize();
            if (StyleUtils.checkSizeValidity(selectTextSize)) {
                this.tvComplete.setTextSize((float) selectTextSize);
            }
            int selectTextColor = selectMainStyle.getSelectTextColor();
            if (StyleUtils.checkStyleValidity(selectTextColor)) {
                this.tvComplete.setTextColor(selectTextColor);
            } else {
                this.tvComplete.setTextColor(ContextCompat.getColor(getContext(), R.color.ps_color_fa632d));
            }
            if (pictureSelectorStyle.getBottomBarStyle().isCompleteCountTips()) {
                if (this.tvSelectNum.getVisibility() == 8 || this.tvSelectNum.getVisibility() == 4) {
                    this.tvSelectNum.setVisibility(0);
                }
                if (!TextUtils.equals(ValueOf.toString(Integer.valueOf(this.config.getSelectCount())), this.tvSelectNum.getText())) {
                    this.tvSelectNum.setText(ValueOf.toString(Integer.valueOf(this.config.getSelectCount())));
                    OnSelectAnimListener onSelectAnimListener = this.config.onSelectAnimListener;
                    if (onSelectAnimListener != null) {
                        onSelectAnimListener.onSelectAnim(this.tvSelectNum);
                    } else {
                        this.tvSelectNum.startAnimation(this.numberChangeAnimation);
                    }
                }
            } else {
                this.tvSelectNum.setVisibility(8);
            }
        } else {
            if (!z11 || !selectMainStyle.isCompleteSelectRelativeTop()) {
                setEnabled(this.config.isEmptyResultReturn);
                int selectNormalBackgroundResources = selectMainStyle.getSelectNormalBackgroundResources();
                if (StyleUtils.checkStyleValidity(selectNormalBackgroundResources)) {
                    setBackgroundResource(selectNormalBackgroundResources);
                } else {
                    setBackgroundResource(R.drawable.ps_ic_trans_1px);
                }
                int selectNormalTextColor = selectMainStyle.getSelectNormalTextColor();
                if (StyleUtils.checkStyleValidity(selectNormalTextColor)) {
                    this.tvComplete.setTextColor(selectNormalTextColor);
                } else {
                    this.tvComplete.setTextColor(ContextCompat.getColor(getContext(), R.color.ps_color_9b));
                }
            } else {
                setEnabled(true);
                int selectBackgroundResources2 = selectMainStyle.getSelectBackgroundResources();
                if (StyleUtils.checkStyleValidity(selectBackgroundResources2)) {
                    setBackgroundResource(selectBackgroundResources2);
                } else {
                    setBackgroundResource(R.drawable.ps_ic_trans_1px);
                }
                int selectTextColor2 = selectMainStyle.getSelectTextColor();
                if (StyleUtils.checkStyleValidity(selectTextColor2)) {
                    this.tvComplete.setTextColor(selectTextColor2);
                } else {
                    this.tvComplete.setTextColor(ContextCompat.getColor(getContext(), R.color.ps_color_9b));
                }
            }
            this.tvSelectNum.setVisibility(8);
            String string2 = StyleUtils.checkStyleValidity(selectMainStyle.getSelectNormalTextResId()) ? getContext().getString(selectMainStyle.getSelectNormalTextResId()) : selectMainStyle.getSelectNormalText();
            if (!StyleUtils.checkTextValidity(string2)) {
                this.tvComplete.setText(getContext().getString(R.string.ps_please_select));
            } else if (StyleUtils.checkTextTwoFormatValidity(string2)) {
                this.tvComplete.setText(String.format(string2, new Object[]{Integer.valueOf(this.config.getSelectCount()), Integer.valueOf(this.config.maxSelectNum)}));
            } else {
                this.tvComplete.setText(string2);
            }
            int selectNormalTextSize = selectMainStyle.getSelectNormalTextSize();
            if (StyleUtils.checkSizeValidity(selectNormalTextSize)) {
                this.tvComplete.setTextSize((float) selectNormalTextSize);
            }
        }
    }

    public CompleteSelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public CompleteSelectView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
