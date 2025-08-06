package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.luck.picture.lib.R;
import com.luck.picture.lib.config.SelectorConfig;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.utils.DensityUtil;
import com.luck.picture.lib.utils.PictureFileUtils;
import com.luck.picture.lib.utils.StyleUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class BottomNavBar extends RelativeLayout implements View.OnClickListener {
    public OnBottomNavBarListener bottomNavBarListener;
    public SelectorConfig config;
    /* access modifiers changed from: private */
    public CheckBox originalCheckbox;
    public TextView tvImageEditor;
    public TextView tvPreview;

    public static class OnBottomNavBarListener {
        public void onCheckOriginalChange() {
        }

        public void onEditImage() {
        }

        public void onFirstCheckOriginalSelectedChange() {
        }

        public void onPreview() {
        }
    }

    public BottomNavBar(Context context) {
        super(context);
        init();
    }

    private void calculateFileTotalSize() {
        if (this.config.isOriginalControl) {
            long j11 = 0;
            for (int i11 = 0; i11 < this.config.getSelectCount(); i11++) {
                j11 += this.config.getSelectedResult().get(i11).getSize();
            }
            if (j11 > 0) {
                this.originalCheckbox.setText(getContext().getString(R.string.ps_original_image, new Object[]{PictureFileUtils.formatAccurateUnitFileSize(j11)}));
                return;
            }
            this.originalCheckbox.setText(getContext().getString(R.string.ps_default_original_image));
            return;
        }
        this.originalCheckbox.setText(getContext().getString(R.string.ps_default_original_image));
    }

    public void handleLayoutUI() {
    }

    public void inflateLayout() {
        RelativeLayout.inflate(getContext(), R.layout.ps_bottom_nav_bar, this);
    }

    public void init() {
        inflateLayout();
        setClickable(true);
        setFocusable(true);
        this.config = SelectorProviders.getInstance().getSelectorConfig();
        this.tvPreview = (TextView) findViewById(R.id.ps_tv_preview);
        this.tvImageEditor = (TextView) findViewById(R.id.ps_tv_editor);
        this.originalCheckbox = (CheckBox) findViewById(R.id.cb_original);
        this.tvPreview.setOnClickListener(this);
        this.tvImageEditor.setVisibility(8);
        setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ps_color_grey));
        this.originalCheckbox.setChecked(this.config.isCheckOriginalImage);
        this.originalCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @SensorsDataInstrumented
            public void onCheckedChanged(CompoundButton compoundButton, boolean z11) {
                BottomNavBar bottomNavBar = BottomNavBar.this;
                bottomNavBar.config.isCheckOriginalImage = z11;
                bottomNavBar.originalCheckbox.setChecked(BottomNavBar.this.config.isCheckOriginalImage);
                OnBottomNavBarListener onBottomNavBarListener = BottomNavBar.this.bottomNavBarListener;
                if (onBottomNavBarListener != null) {
                    onBottomNavBarListener.onCheckOriginalChange();
                    if (z11 && BottomNavBar.this.config.getSelectCount() == 0) {
                        BottomNavBar.this.bottomNavBarListener.onFirstCheckOriginalSelectedChange();
                    }
                }
                SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
            }
        });
        handleLayoutUI();
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (this.bottomNavBarListener == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        if (view.getId() == R.id.ps_tv_preview) {
            this.bottomNavBarListener.onPreview();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setBottomNavBarStyle() {
        SelectorConfig selectorConfig = this.config;
        if (selectorConfig.isDirectReturnSingle) {
            setVisibility(8);
            return;
        }
        BottomNavBarStyle bottomBarStyle = selectorConfig.selectorStyle.getBottomBarStyle();
        if (this.config.isOriginalControl) {
            this.originalCheckbox.setVisibility(0);
            int bottomOriginalDrawableLeft = bottomBarStyle.getBottomOriginalDrawableLeft();
            if (StyleUtils.checkStyleValidity(bottomOriginalDrawableLeft)) {
                this.originalCheckbox.setButtonDrawable(bottomOriginalDrawableLeft);
            }
            String string = StyleUtils.checkStyleValidity(bottomBarStyle.getBottomOriginalTextResId()) ? getContext().getString(bottomBarStyle.getBottomOriginalTextResId()) : bottomBarStyle.getBottomOriginalText();
            if (StyleUtils.checkTextValidity(string)) {
                this.originalCheckbox.setText(string);
            }
            int bottomOriginalTextSize = bottomBarStyle.getBottomOriginalTextSize();
            if (StyleUtils.checkSizeValidity(bottomOriginalTextSize)) {
                this.originalCheckbox.setTextSize((float) bottomOriginalTextSize);
            }
            int bottomOriginalTextColor = bottomBarStyle.getBottomOriginalTextColor();
            if (StyleUtils.checkStyleValidity(bottomOriginalTextColor)) {
                this.originalCheckbox.setTextColor(bottomOriginalTextColor);
            }
        }
        int bottomNarBarHeight = bottomBarStyle.getBottomNarBarHeight();
        if (StyleUtils.checkSizeValidity(bottomNarBarHeight)) {
            getLayoutParams().height = bottomNarBarHeight;
        } else {
            getLayoutParams().height = DensityUtil.dip2px(getContext(), 46.0f);
        }
        int bottomNarBarBackgroundColor = bottomBarStyle.getBottomNarBarBackgroundColor();
        if (StyleUtils.checkStyleValidity(bottomNarBarBackgroundColor)) {
            setBackgroundColor(bottomNarBarBackgroundColor);
        }
        int bottomPreviewNormalTextColor = bottomBarStyle.getBottomPreviewNormalTextColor();
        if (StyleUtils.checkStyleValidity(bottomPreviewNormalTextColor)) {
            this.tvPreview.setTextColor(bottomPreviewNormalTextColor);
        }
        int bottomPreviewNormalTextSize = bottomBarStyle.getBottomPreviewNormalTextSize();
        if (StyleUtils.checkSizeValidity(bottomPreviewNormalTextSize)) {
            this.tvPreview.setTextSize((float) bottomPreviewNormalTextSize);
        }
        String string2 = StyleUtils.checkStyleValidity(bottomBarStyle.getBottomPreviewNormalTextResId()) ? getContext().getString(bottomBarStyle.getBottomPreviewNormalTextResId()) : bottomBarStyle.getBottomPreviewNormalText();
        if (StyleUtils.checkTextValidity(string2)) {
            this.tvPreview.setText(string2);
        }
        String string3 = StyleUtils.checkStyleValidity(bottomBarStyle.getBottomEditorTextResId()) ? getContext().getString(bottomBarStyle.getBottomEditorTextResId()) : bottomBarStyle.getBottomEditorText();
        if (StyleUtils.checkTextValidity(string3)) {
            this.tvImageEditor.setText(string3);
        }
        int bottomEditorTextSize = bottomBarStyle.getBottomEditorTextSize();
        if (StyleUtils.checkSizeValidity(bottomEditorTextSize)) {
            this.tvImageEditor.setTextSize((float) bottomEditorTextSize);
        }
        int bottomEditorTextColor = bottomBarStyle.getBottomEditorTextColor();
        if (StyleUtils.checkStyleValidity(bottomEditorTextColor)) {
            this.tvImageEditor.setTextColor(bottomEditorTextColor);
        }
        int bottomOriginalDrawableLeft2 = bottomBarStyle.getBottomOriginalDrawableLeft();
        if (StyleUtils.checkStyleValidity(bottomOriginalDrawableLeft2)) {
            this.originalCheckbox.setButtonDrawable(bottomOriginalDrawableLeft2);
        }
        String string4 = StyleUtils.checkStyleValidity(bottomBarStyle.getBottomOriginalTextResId()) ? getContext().getString(bottomBarStyle.getBottomOriginalTextResId()) : bottomBarStyle.getBottomOriginalText();
        if (StyleUtils.checkTextValidity(string4)) {
            this.originalCheckbox.setText(string4);
        }
        int bottomOriginalTextSize2 = bottomBarStyle.getBottomOriginalTextSize();
        if (StyleUtils.checkSizeValidity(bottomOriginalTextSize2)) {
            this.originalCheckbox.setTextSize((float) bottomOriginalTextSize2);
        }
        int bottomOriginalTextColor2 = bottomBarStyle.getBottomOriginalTextColor();
        if (StyleUtils.checkStyleValidity(bottomOriginalTextColor2)) {
            this.originalCheckbox.setTextColor(bottomOriginalTextColor2);
        }
    }

    public void setOnBottomNavBarListener(OnBottomNavBarListener onBottomNavBarListener) {
        this.bottomNavBarListener = onBottomNavBarListener;
    }

    public void setOriginalCheck() {
        this.originalCheckbox.setChecked(this.config.isCheckOriginalImage);
    }

    public void setSelectedChange() {
        calculateFileTotalSize();
        BottomNavBarStyle bottomBarStyle = this.config.selectorStyle.getBottomBarStyle();
        if (this.config.getSelectCount() > 0) {
            this.tvPreview.setEnabled(true);
            int bottomPreviewSelectTextColor = bottomBarStyle.getBottomPreviewSelectTextColor();
            if (StyleUtils.checkStyleValidity(bottomPreviewSelectTextColor)) {
                this.tvPreview.setTextColor(bottomPreviewSelectTextColor);
            } else {
                this.tvPreview.setTextColor(ContextCompat.getColor(getContext(), R.color.ps_color_fa632d));
            }
            String string = StyleUtils.checkStyleValidity(bottomBarStyle.getBottomPreviewSelectTextResId()) ? getContext().getString(bottomBarStyle.getBottomPreviewSelectTextResId()) : bottomBarStyle.getBottomPreviewSelectText();
            if (!StyleUtils.checkTextValidity(string)) {
                this.tvPreview.setText(getContext().getString(R.string.ps_preview_num, new Object[]{Integer.valueOf(this.config.getSelectCount())}));
            } else if (StyleUtils.checkTextFormatValidity(string)) {
                this.tvPreview.setText(String.format(string, new Object[]{Integer.valueOf(this.config.getSelectCount())}));
            } else {
                this.tvPreview.setText(string);
            }
        } else {
            this.tvPreview.setEnabled(false);
            int bottomPreviewNormalTextColor = bottomBarStyle.getBottomPreviewNormalTextColor();
            if (StyleUtils.checkStyleValidity(bottomPreviewNormalTextColor)) {
                this.tvPreview.setTextColor(bottomPreviewNormalTextColor);
            } else {
                this.tvPreview.setTextColor(ContextCompat.getColor(getContext(), R.color.ps_color_9b));
            }
            String string2 = StyleUtils.checkStyleValidity(bottomBarStyle.getBottomPreviewNormalTextResId()) ? getContext().getString(bottomBarStyle.getBottomPreviewNormalTextResId()) : bottomBarStyle.getBottomPreviewNormalText();
            if (StyleUtils.checkTextValidity(string2)) {
                this.tvPreview.setText(string2);
            } else {
                this.tvPreview.setText(getContext().getString(R.string.ps_preview));
            }
        }
    }

    public BottomNavBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BottomNavBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init();
    }
}
