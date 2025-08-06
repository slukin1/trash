package com.luck.picture.lib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.luck.picture.lib.R;
import com.luck.picture.lib.style.TitleBarStyle;
import com.luck.picture.lib.utils.StyleUtils;

public class PreviewTitleBar extends TitleBar {
    public PreviewTitleBar(Context context) {
        super(context);
    }

    public void setTitleBarStyle() {
        super.setTitleBarStyle();
        TitleBarStyle titleBarStyle = this.config.selectorStyle.getTitleBarStyle();
        if (StyleUtils.checkStyleValidity(titleBarStyle.getPreviewTitleBackgroundColor())) {
            setBackgroundColor(titleBarStyle.getPreviewTitleBackgroundColor());
        } else if (StyleUtils.checkSizeValidity(titleBarStyle.getTitleBackgroundColor())) {
            setBackgroundColor(titleBarStyle.getTitleBackgroundColor());
        }
        if (StyleUtils.checkStyleValidity(titleBarStyle.getPreviewTitleLeftBackResource())) {
            this.ivLeftBack.setImageResource(titleBarStyle.getPreviewTitleLeftBackResource());
        }
        this.rlAlbumBg.setOnClickListener((View.OnClickListener) null);
        this.viewAlbumClickArea.setOnClickListener((View.OnClickListener) null);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.rlAlbumBg.getLayoutParams();
        layoutParams.removeRule(17);
        layoutParams.addRule(14);
        this.rlAlbumBg.setBackgroundResource(R.drawable.ps_ic_trans_1px);
        this.tvCancel.setVisibility(8);
        this.ivArrow.setVisibility(8);
        this.viewAlbumClickArea.setVisibility(8);
    }

    public PreviewTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PreviewTitleBar(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
