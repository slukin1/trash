package com.huobi.view;

import android.os.Bundle;
import android.text.Layout;
import android.text.StaticLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.widgets.R$dimen;

public class HeavyTextBubbleDialog extends HeavyBubbleDialog {
    private int contentMargin;
    private final int defaultTextWidth = PixelUtils.a(230.0f);
    private int defaultWidth;
    private final int maxContentHeight = PixelUtils.a(160.0f);

    public HeavyTextBubbleDialog(boolean z11) {
        this.supportNight = z11;
    }

    private static int getTextHeight(TextView textView, int i11) {
        return new StaticLayout(textView.getText(), 0, textView.getText().length(), textView.getPaint(), i11, Layout.Alignment.ALIGN_NORMAL, textView.getLineSpacingMultiplier(), textView.getLineSpacingExtra(), textView.getIncludeFontPadding(), textView.getEllipsize(), i11).getHeight();
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

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.heavy_bubble_content_horizontal_margin);
        this.contentMargin = dimensionPixelOffset;
        this.defaultWidth = this.defaultTextWidth + ((dimensionPixelOffset + this.shadowWidth) * 2);
        makeContentWidthMatters();
        return this.rootView;
    }

    public void onStart() {
        super.onStart();
        layoutWindow();
    }
}
