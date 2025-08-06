package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.luck.picture.lib.R;
import com.luck.picture.lib.style.BottomNavBarStyle;
import com.luck.picture.lib.utils.StyleUtils;
import com.luck.picture.lib.widget.BottomNavBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public class PreviewBottomNavBar extends BottomNavBar {
    public PreviewBottomNavBar(Context context) {
        super(context);
    }

    public TextView getEditor() {
        return this.tvImageEditor;
    }

    public void handleLayoutUI() {
        int i11 = 8;
        this.tvPreview.setVisibility(8);
        this.tvImageEditor.setOnClickListener(this);
        TextView textView = this.tvImageEditor;
        if (this.config.onEditMediaEventListener != null) {
            i11 = 0;
        }
        textView.setVisibility(i11);
    }

    public void isDisplayEditor(boolean z11) {
        this.tvImageEditor.setVisibility((this.config.onEditMediaEventListener == null || z11) ? 8 : 0);
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        BottomNavBar.OnBottomNavBarListener onBottomNavBarListener;
        super.onClick(view);
        if (view.getId() == R.id.ps_tv_editor && (onBottomNavBarListener = this.bottomNavBarListener) != null) {
            onBottomNavBarListener.onEditImage();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void setBottomNavBarStyle() {
        super.setBottomNavBarStyle();
        BottomNavBarStyle bottomBarStyle = this.config.selectorStyle.getBottomBarStyle();
        if (StyleUtils.checkStyleValidity(bottomBarStyle.getBottomPreviewNarBarBackgroundColor())) {
            setBackgroundColor(bottomBarStyle.getBottomPreviewNarBarBackgroundColor());
        } else if (StyleUtils.checkSizeValidity(bottomBarStyle.getBottomNarBarBackgroundColor())) {
            setBackgroundColor(bottomBarStyle.getBottomNarBarBackgroundColor());
        }
    }

    public PreviewBottomNavBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreviewBottomNavBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
